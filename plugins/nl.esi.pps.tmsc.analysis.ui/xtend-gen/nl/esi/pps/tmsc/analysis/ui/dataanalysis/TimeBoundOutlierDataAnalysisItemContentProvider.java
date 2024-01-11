/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.analysis.ui.dataanalysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.analysis.TimeBoundOutlierAnalysis;
import nl.esi.pps.tmsc.provider.dataanalysis.IDataAnalysisItemContentProvider;
import org.eclipse.lsat.common.xtend.Queries;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class TimeBoundOutlierDataAnalysisItemContentProvider implements IDataAnalysisItemContentProvider {
  private static final String TIME_BOUNDS_PRE = "Time-bounds (pre)";
  
  private static final String TIME_BOUNDS = "Time-bounds";
  
  @Override
  public Set<String> getConfigurations(final Object object) {
    final Dependency dependency = ((Dependency) object);
    final LinkedHashSet<String> configurations = CollectionLiterals.<String>newLinkedHashSet();
    boolean _isSetTimeBoundSamples = TimeBoundOutlierAnalysis.isSetTimeBoundSamples(dependency);
    if (_isSetTimeBoundSamples) {
      configurations.add(TimeBoundOutlierDataAnalysisItemContentProvider.TIME_BOUNDS);
    }
    boolean _isSetPreTimeBoundSamples = TimeBoundOutlierAnalysis.isSetPreTimeBoundSamples(dependency);
    if (_isSetPreTimeBoundSamples) {
      configurations.add(TimeBoundOutlierDataAnalysisItemContentProvider.TIME_BOUNDS_PRE);
    }
    return configurations;
  }
  
  @Override
  public String getTitle(final Object object, final String configuration) {
    return configuration;
  }
  
  @Override
  public Long getBudget(final Object object, final String configuration) {
    final Dependency dependency = ((Dependency) object);
    Long _switchResult = null;
    if (configuration != null) {
      switch (configuration) {
        case TimeBoundOutlierDataAnalysisItemContentProvider.TIME_BOUNDS:
          _switchResult = TimeBoundOutlierAnalysis.getTimeBoundOutlierThreshold(dependency);
          break;
        case TimeBoundOutlierDataAnalysisItemContentProvider.TIME_BOUNDS_PRE:
          _switchResult = TimeBoundOutlierAnalysis.getPreTimeBoundOutlierThreshold(dependency);
          break;
      }
    }
    return _switchResult;
  }
  
  @Override
  public Iterable<?> getSiblings(final Object object, final String configuration) {
    final Dependency dependency = ((Dependency) object);
    ArrayList<Long> _switchResult = null;
    if (configuration != null) {
      switch (configuration) {
        case TimeBoundOutlierDataAnalysisItemContentProvider.TIME_BOUNDS:
          _switchResult = TimeBoundOutlierAnalysis.getTimeBoundSamples(dependency);
          break;
        case TimeBoundOutlierDataAnalysisItemContentProvider.TIME_BOUNDS_PRE:
          _switchResult = TimeBoundOutlierAnalysis.getPreTimeBoundSamples(dependency);
          break;
      }
    }
    final ArrayList<Long> timeBoundSamples = _switchResult;
    return Queries.<Object>union(Collections.<Object>singleton(object), timeBoundSamples);
  }
  
  @Override
  public Long getDuration(final Object object, final Object sibling, final String configuration) {
    Long _switchResult = null;
    boolean _matched = false;
    if (sibling instanceof Long) {
      _matched=true;
      _switchResult = ((Long)sibling);
    }
    if (!_matched) {
      if (sibling instanceof Dependency) {
        _matched=true;
        _switchResult = ((Dependency)sibling).getTimeBound();
      }
    }
    return _switchResult;
  }
}
