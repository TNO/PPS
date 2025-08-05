/**
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.analysis.ui.dataanalysis;

import java.util.Objects;
import java.util.Set;
import nl.esi.pps.tmsc.ScopedTMSC;
import nl.esi.pps.tmsc.analysis.ui.handlers.CreateMetricActivityIsomorphismClassesHelper;
import nl.esi.pps.tmsc.metric.MetricInstance;
import nl.esi.pps.tmsc.metric.provider.dataanalysis.MetricDataAnalysisItemContentProvider;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class MetricActivityIsomorphismClassesContentProvider extends MetricDataAnalysisItemContentProvider {
  @Override
  public Set<String> getConfigurations(final Object object) {
    final Function1<MetricInstance, EList<ScopedTMSC>> _function = (MetricInstance it) -> {
      return it.getScopes();
    };
    final Function1<ScopedTMSC, String> _function_1 = (ScopedTMSC it) -> {
      return this.getConfiguration(it);
    };
    return IterableExtensions.<String>toSet(IterableExtensions.<String>filterNull(IterableExtensions.<ScopedTMSC, String>map(IterableExtensions.<MetricInstance, ScopedTMSC>flatMap(this.getMetric(object).getInstances(), _function), _function_1)));
  }

  @Override
  public String getTitle(final Object object, final String configuration) {
    String _name = this.getMetric(object).getName();
    String _plus = (_name + " - ");
    return (_plus + configuration);
  }

  @Override
  public boolean isCategorized(final Object object, final String configuration) {
    return true;
  }

  @Override
  public String getCategory(final Object object, final Object sibling, final String configuration) {
    if ((sibling instanceof MetricInstance)) {
      final Function1<ScopedTMSC, Boolean> _function = (ScopedTMSC s) -> {
        String _configuration = this.getConfiguration(s);
        return Boolean.valueOf(Objects.equals(_configuration, configuration));
      };
      ScopedTMSC _findFirst = IterableExtensions.<ScopedTMSC>findFirst(((MetricInstance)sibling).getScopes(), _function);
      String _isomorphismClass = null;
      if (_findFirst!=null) {
        _isomorphismClass=CreateMetricActivityIsomorphismClassesHelper.getIsomorphismClass(_findFirst);
      }
      final String isomorphismClass = _isomorphismClass;
      if ((isomorphismClass != null)) {
        return ("Isomorphism class " + isomorphismClass);
      }
    }
    return super.getCategory(object, sibling, configuration);
  }

  protected String getConfiguration(final ScopedTMSC tmsc) {
    final String isomorphismStage = CreateMetricActivityIsomorphismClassesHelper.getIsomorphismStage(tmsc);
    if ((isomorphismStage == null)) {
      return null;
    }
    final String isomorphismType = CreateMetricActivityIsomorphismClassesHelper.getIsomorphismType(tmsc);
    if ((isomorphismType == null)) {
      return null;
    }
    return ((isomorphismStage + " ") + isomorphismType);
  }
}
