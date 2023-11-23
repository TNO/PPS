/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.metric.extension;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.Collection;
import java.util.Map;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.metric.Metric;
import nl.esi.pps.tmsc.metric.MetricCategory;
import nl.esi.pps.tmsc.metric.MetricFactory;
import nl.esi.pps.tmsc.metric.MetricInstance;
import nl.esi.pps.tmsc.metric.MetricModel;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Pure;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class MetricProcessor {
  @Extension
  private static final MetricFactory m_metric = MetricFactory.eINSTANCE;
  
  private final Map<String, Long> configurationBudgets = CollectionLiterals.<String, Long>newLinkedHashMap();
  
  @Accessors
  private final String id;
  
  @Accessors
  private final String name;
  
  @Accessors
  private final String category;
  
  @Accessors
  private final String modelId;
  
  private final Long defaultBudget;
  
  private final IMetricProcessor metricProcessor;
  
  /**
   * Adds a budget for a configuration
   */
  public boolean addBudget(final String configuration, final Long budget) {
    boolean _containsKey = this.configurationBudgets.containsKey(configuration);
    if (_containsKey) {
      return false;
    }
    this.configurationBudgets.put(configuration, budget);
    return true;
  }
  
  /**
   * Removes a budget for a configuration
   */
  public void removeBudget(final String configuration) {
    this.configurationBudgets.remove(configuration);
  }
  
  /**
   * @see IMetricProcessor#isEnabled(FullScopeTMSC)
   */
  public boolean isEnabled(final FullScopeTMSC tmsc) {
    return this.metricProcessor.isEnabled(tmsc);
  }
  
  /**
   * @see IMetricProcessor#isRequiredToResolveInstances(String, String)
   */
  public boolean isRequiredToResolveInstances(final String hostName, final String componentName) {
    return this.metricProcessor.isRequiredToResolveInstances(hostName, componentName);
  }
  
  /**
   * Resolves the instances for this metric and adds them to the
   * {@link #getMetricModel(FullScopeTMSC) default metric model}.
   * 
   * @throws IllegalArgumentException if <code>tmsc</code> is not contained in a {@link Resource}
   * @see #getMetricModel(FullScopeTMSC)
   */
  public Metric analyse(final FullScopeTMSC tmsc) {
    return this.analyse(tmsc, MetricProcessor.getMetricModel(tmsc));
  }
  
  /**
   * Resolves the instances for this metric and adds them to the {@code metricModel}.
   */
  public Metric analyse(final FullScopeTMSC tmsc, final MetricModel metricModel) {
    final String metricConfiguration = this.metricProcessor.getConfiguration(tmsc);
    final Long metricBudget = this.configurationBudgets.getOrDefault(metricConfiguration, 
      this.metricProcessor.getBudget(metricConfiguration, this.defaultBudget));
    final Collection<MetricInstance> metricInstances = this.metricProcessor.resolveInstances(tmsc, metricConfiguration);
    boolean _isEmpty = metricInstances.isEmpty();
    if (_isEmpty) {
      return null;
    }
    final Metric metric = MetricProcessor.createMetric(this, metricModel);
    metric.setBudget(metricBudget);
    metric.setConfiguration(metricConfiguration);
    EList<FullScopeTMSC> _tmscs = metric.getTmscs();
    _tmscs.add(tmsc);
    EList<MetricInstance> _instances = metric.getInstances();
    Iterables.<MetricInstance>addAll(_instances, metricInstances);
    return metric;
  }
  
  /**
   * Convenience method that finds the Metric model in the resource of the TMSC, or
   * creates a new Metric model if it could not be found (and adds it to the
   * resource).
   * 
   * @throws IllegalArgumentException if <code>tmsc</code> is not contained in a
   *                                  {@link Resource}
   * @see EObject#eResource()
   */
  public static MetricModel getMetricModel(final FullScopeTMSC tmsc) {
    Resource _eResource = tmsc.eResource();
    boolean _tripleEquals = (_eResource == null);
    if (_tripleEquals) {
      throw new IllegalArgumentException("TMSC should be contained in a resource");
    }
    MetricModel metricModel = IterableExtensions.<MetricModel>head(Iterables.<MetricModel>filter(tmsc.eResource().getContents(), MetricModel.class));
    if ((metricModel == null)) {
      metricModel = MetricProcessor.m_metric.createMetricModel();
      EList<EObject> _contents = tmsc.eResource().getContents();
      _contents.add(metricModel);
    }
    return metricModel;
  }
  
  private static Metric createMetric(final MetricProcessor metricExtension, final MetricModel metricModel) {
    final Function1<Metric, Boolean> _function = (Metric it) -> {
      String _id = it.getId();
      return Boolean.valueOf(Objects.equal(_id, metricExtension.id));
    };
    EcoreUtil.deleteAll(IterableExtensions.<Metric>toList(IterableExtensions.<Metric>filter(metricModel.getMetrics(), _function)), true);
    final Function1<MetricCategory, Boolean> _function_1 = (MetricCategory it) -> {
      String _name = it.getName();
      return Boolean.valueOf(Objects.equal(_name, metricExtension.category));
    };
    MetricCategory metricCategory = IterableExtensions.<MetricCategory>findFirst(metricModel.getCategories(), _function_1);
    if ((metricCategory == null)) {
      metricCategory = MetricProcessor.m_metric.createMetricCategory();
      metricCategory.setName(metricExtension.category);
      EList<MetricCategory> _categories = metricModel.getCategories();
      _categories.add(metricCategory);
    }
    final Metric metric = MetricProcessor.m_metric.createMetric();
    metric.setId(metricExtension.id);
    metric.setName(metricExtension.name);
    metric.setCategory(metricCategory);
    EList<Metric> _metrics = metricModel.getMetrics();
    _metrics.add(metric);
    return metric;
  }
  
  /**
   * @see IMetricProcessor#getAnalysisTimeWindow(MetricInstance)
   */
  public Pair<Long, Long> getAnalysisTimeWindow(final MetricInstance metricInstance) {
    return this.metricProcessor.getAnalysisTimeWindow(metricInstance);
  }
  
  /**
   * @see IMetricProcessor#isActivityCutOff(Dependency, MetricInstance)
   */
  public boolean isActivityCutOff(final Dependency dependency, final MetricInstance metricInstance) {
    return this.metricProcessor.isActivityCutOff(dependency, metricInstance);
  }
  
  @Override
  public String toString() {
    return this.id;
  }
  
  public MetricProcessor(final String id, final String name, final String category, final String modelId, final Long defaultBudget, final IMetricProcessor metricProcessor) {
    super();
    this.id = id;
    this.name = name;
    this.category = category;
    this.modelId = modelId;
    this.defaultBudget = defaultBudget;
    this.metricProcessor = metricProcessor;
  }
  
  @Pure
  public String getId() {
    return this.id;
  }
  
  @Pure
  public String getName() {
    return this.name;
  }
  
  @Pure
  public String getCategory() {
    return this.category;
  }
  
  @Pure
  public String getModelId() {
    return this.modelId;
  }
}
