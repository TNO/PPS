/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.metric;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeSet;
import nl.esi.pps.preferences.PPSPreferences;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.LifelineSegment;
import nl.esi.pps.tmsc.metric.extension.IMetricProcessor;
import nl.esi.pps.tmsc.text.EDurationFormat;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("all")
public class PropertiesMetricProcessor implements IMetricProcessor {
  protected static final Logger LOGGER = LoggerFactory.getLogger(PropertiesMetricProcessor.class);
  
  @Extension
  protected static final MetricFactory m_metric = MetricFactory.eINSTANCE;
  
  public static final String PROPERTY_METRIC_BUDGET = "metricBudget";
  
  public static final String PROPERTY_METRIC_INSTANCE_FROM_ID = "metricInstanceFromID";
  
  public static final String PROPERTY_METRIC_INSTANCE_TO_ID = "metricInstanceToID";
  
  public static final String PROPERTY_METRIC_ACTIVITY_CUT_OFF = "metricActivityCutOff";
  
  @Override
  public boolean isEnabled(final FullScopeTMSC tmsc) {
    return ((tmsc != null) && PPSPreferences.isAdvancedFeaturesEnabled());
  }
  
  @Override
  public String getConfiguration(final FullScopeTMSC tmsc) {
    Serializable _metricBudget = PropertiesMetricProcessor.getMetricBudget(tmsc);
    final Serializable budget = _metricBudget;
    boolean _matched = false;
    if (Objects.equal(budget, null)) {
      _matched=true;
      return null;
    }
    if (!_matched) {
      if (budget instanceof Long) {
        _matched=true;
        return ((Long)budget).toString();
      }
    }
    if (!_matched) {
      if (budget instanceof Number) {
        _matched=true;
        double _doubleValue = ((Number)budget).doubleValue();
        return Long.valueOf(Double.valueOf((_doubleValue * 1e9)).longValue()).toString();
      }
    }
    if (!_matched) {
      if (budget instanceof String) {
        _matched=true;
        try {
          return Long.valueOf(EDurationFormat.eINSTANCE.parse(((String)budget)).longValue()).toString();
        } catch (final Throwable _t) {
          if (_t instanceof ParseException) {
            final ParseException e = (ParseException)_t;
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("Invalid metricBudget value: ");
            _builder.append(((String)budget));
            PropertiesMetricProcessor.LOGGER.error(_builder.toString(), e);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
    }
    if (!_matched) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Invalid metricBudget value \'");
      _builder.append(budget);
      _builder.append("\', only number or duration is allowed.");
      PropertiesMetricProcessor.LOGGER.error(_builder.toString());
    }
    return null;
  }
  
  @Override
  public Long getBudget(final String configuration, final Long defaultBudget) {
    if ((configuration != null)) {
      try {
        return Long.valueOf(Long.parseLong(configuration));
      } catch (final Throwable _t) {
        if (_t instanceof NumberFormatException) {
          final NumberFormatException e = (NumberFormatException)_t;
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Invalid metricBudget value: ");
          _builder.append(configuration);
          PropertiesMetricProcessor.LOGGER.error(_builder.toString(), e);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
    return defaultBudget;
  }
  
  @Override
  public Collection<MetricInstance> resolveInstances(final FullScopeTMSC tmsc, final String configuration) {
    final Function1<Event, Serializable> _function = (Event it) -> {
      return PropertiesMetricProcessor.getMetricInstanceFromID(it);
    };
    final Map<Serializable, Event> fromEvents = IterableExtensions.<Serializable, Event>toMap(tmsc.getEvents(), _function);
    final Function1<Event, Serializable> _function_1 = (Event it) -> {
      return PropertiesMetricProcessor.getMetricInstanceToID(it);
    };
    final Map<Serializable, Event> toEvents = IterableExtensions.<Serializable, Event>toMap(tmsc.getEvents(), _function_1);
    final TreeSet<Serializable> instances = new TreeSet<Serializable>();
    Iterable<Serializable> _filterNull = IterableExtensions.<Serializable>filterNull(fromEvents.keySet());
    Iterables.<Serializable>addAll(instances, _filterNull);
    instances.retainAll(toEvents.keySet());
    final ArrayList<MetricInstance> metricInstances = CollectionLiterals.<MetricInstance>newArrayList();
    for (final Serializable instance : instances) {
      {
        final MetricInstance metricInstance = PropertiesMetricProcessor.m_metric.createMetricInstance();
        metricInstance.setId(String.valueOf(instance));
        metricInstance.setFrom(fromEvents.get(instance));
        metricInstance.setTo(toEvents.get(instance));
        metricInstances.add(metricInstance);
      }
    }
    return Collections.<MetricInstance>unmodifiableCollection(metricInstances);
  }
  
  @Override
  public boolean isActivityCutOff(final Dependency dependency, final MetricInstance metricInstance) {
    Serializable cutOffValue = PropertiesMetricProcessor.getMetricActivityCutOff(dependency);
    if ((cutOffValue == null)) {
      if ((dependency instanceof LifelineSegment)) {
        cutOffValue = PropertiesMetricProcessor.getMetricActivityCutOff(((LifelineSegment)dependency).getActiveExecution());
      }
    }
    return this.isActivityCutOff(cutOffValue);
  }
  
  private boolean isActivityCutOff(final Serializable cutOffValue) {
    boolean _matched = false;
    if (Objects.equal(cutOffValue, null)) {
      _matched=true;
      return false;
    }
    if (!_matched) {
      if (cutOffValue instanceof Boolean) {
        _matched=true;
        return ((Boolean) cutOffValue).booleanValue();
      }
    }
    if (!_matched) {
      if (cutOffValue instanceof String) {
        _matched=true;
        return Boolean.parseBoolean(((String)cutOffValue));
      }
    }
    {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Invalid metricActivityCutOff value \'");
      _builder.append(cutOffValue);
      _builder.append("\', only boolean is allowed.");
      PropertiesMetricProcessor.LOGGER.error(_builder.toString());
      return false;
    }
  }
  
  public static Serializable getMetricBudget(final FullScopeTMSC container) {
    final String key = "metricBudget";
    final Object value = container.getProperties().get(key);
    return (Serializable) value;
  }
  
  public static void setMetricBudget(final FullScopeTMSC container, final Serializable value) {
    final String key = "metricBudget";
    if (value == null) {
    container.getProperties().remove(key);
    } else {
        container.getProperties().put(key, value);
    }
  }
  
  public static Serializable getMetricInstanceFromID(final Event container) {
    final String key = "metricInstanceFromID";
    final Object value = container.getProperties().get(key);
    return (Serializable) value;
  }
  
  public static void setMetricInstanceFromID(final Event container, final Serializable value) {
    final String key = "metricInstanceFromID";
    if (value == null) {
    container.getProperties().remove(key);
    } else {
        container.getProperties().put(key, value);
    }
  }
  
  public static Serializable getMetricInstanceToID(final Event container) {
    final String key = "metricInstanceToID";
    final Object value = container.getProperties().get(key);
    return (Serializable) value;
  }
  
  public static void setMetricInstanceToID(final Event container, final Serializable value) {
    final String key = "metricInstanceToID";
    if (value == null) {
    container.getProperties().remove(key);
    } else {
        container.getProperties().put(key, value);
    }
  }
  
  public static Serializable getMetricActivityCutOff(final Dependency container) {
    final String key = "metricActivityCutOff";
    final Object value = container.getProperties().get(key);
    return (Serializable) value;
  }
  
  public static void setMetricActivityCutOff(final Dependency container, final Serializable value) {
    final String key = "metricActivityCutOff";
    if (value == null) {
    container.getProperties().remove(key);
    } else {
        container.getProperties().put(key, value);
    }
  }
  
  public static Serializable getMetricActivityCutOff(final Execution container) {
    final String key = "metricActivityCutOff";
    final Object value = container.getProperties().get(key);
    return (Serializable) value;
  }
  
  public static void setMetricActivityCutOff(final Execution container, final Serializable value) {
    final String key = "metricActivityCutOff";
    if (value == null) {
    container.getProperties().remove(key);
    } else {
        container.getProperties().put(key, value);
    }
  }
}
