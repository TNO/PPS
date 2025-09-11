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

import java.util.Collections;
import java.util.Set;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.analysis.TimeBoundOutlierAnalysis;
import nl.esi.pps.tmsc.provider.dataanalysis.IDataAnalysisItemContentProvider;
import org.eclipse.lsat.common.xtend.Queries;

@SuppressWarnings("all")
public class TimeBoundOutlierDataAnalysisItemContentProvider implements IDataAnalysisItemContentProvider {
  @Override
  public Set<String> getConfigurations(final Object object) {
    final Dependency dependency = ((Dependency) object);
    Set<String> _xifexpression = null;
    boolean _isSetTimeBoundSamples = TimeBoundOutlierAnalysis.isSetTimeBoundSamples(dependency);
    if (_isSetTimeBoundSamples) {
      _xifexpression = Collections.<String>singleton("Time-bounds");
    }
    return _xifexpression;
  }

  @Override
  public String getTitle(final Object object, final String configuration) {
    return "Time-bounds";
  }

  @Override
  public Long getBudget(final Object object, final String configuration) {
    final Dependency dependency = ((Dependency) object);
    return TimeBoundOutlierAnalysis.getTimeBoundOutlierThreshold(dependency);
  }

  @Override
  public Iterable<?> getSiblings(final Object object, final String configuration) {
    final Dependency dependency = ((Dependency) object);
    return Queries.<Object>union(Collections.<Object>singleton(object), TimeBoundOutlierAnalysis.getTimeBoundSamples(dependency));
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
