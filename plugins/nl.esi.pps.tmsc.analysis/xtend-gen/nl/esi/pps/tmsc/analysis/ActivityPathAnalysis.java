/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.analysis;

import com.google.common.base.Objects;
import java.util.Collection;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.Interval;
import nl.esi.pps.tmsc.ScopedTMSC;
import nl.esi.pps.tmsc.TMSC;
import nl.esi.pps.tmsc.util.TmscQueries;
import org.eclipse.emf.common.util.EList;
import org.eclipse.lsat.common.util.BranchIterable;
import org.eclipse.lsat.common.xtend.Queries;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public final class ActivityPathAnalysis {
  public static ScopedTMSC analyseActivityPath(final Interval interval) {
    final Function1<ScopedTMSC, Boolean> _function = (ScopedTMSC it) -> {
      return Boolean.valueOf(ActivityPathAnalysis.isActivityPathAnalysisResult(it));
    };
    final ScopedTMSC previousActivityPath = IterableExtensions.<ScopedTMSC>findFirst(interval.getScopes(), _function);
    if ((previousActivityPath != null)) {
      return previousActivityPath;
    }
    BranchIterable<Dependency> _findActivityPathBetween = ActivityPathAnalysis.findActivityPathBetween(interval.getTmsc(), interval.getFrom(), interval.getTo());
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Activity path for ");
    String _name = interval.getName();
    _builder.append(_name);
    final ScopedTMSC activityPath = TmscQueries.createScopedTMSC(_findActivityPathBetween, _builder, interval.getFrom(), interval.getTo());
    ActivityPathAnalysis.setActivityPathAnalysisResult(activityPath, true);
    EList<ScopedTMSC> _scopes = interval.getScopes();
    _scopes.add(activityPath);
    return activityPath;
  }
  
  /**
   * Finds {@link Dependency dependencies} that denote the activity path to
   * the specified {@code event}.
   */
  public static BranchIterable<Dependency> findActivityPathTo(final TMSC tmsc, final Event event) {
    final Function1<Dependency, Boolean> _function = (Dependency it) -> {
      Boolean _scheduled = it.getScheduled();
      return Boolean.valueOf((!Objects.equal(_scheduled, Boolean.FALSE)));
    };
    return Queries.<Dependency>until(ActivityPathAnalysis.closureIncomingDependencies(tmsc, event), _function);
  }
  
  /**
   * Finds {@link Dependency dependencies} that denote the activity path to
   * the specified {@code to} event. Analysis is stopped when {@code from} event
   * is detected or at the {@link Event#getTimestamp() time} of {@code from}.
   */
  public static BranchIterable<Dependency> findActivityPathBetween(final TMSC tmsc, final Event from, final Event to) {
    final Function1<Dependency, Boolean> _function = (Dependency it) -> {
      return Boolean.valueOf((Objects.equal(it.getTarget(), from) || (it.getTarget().getTimestamp().compareTo(from.getTimestamp()) <= 0)));
    };
    final Function1<Dependency, Boolean> _function_1 = (Dependency it) -> {
      Boolean _scheduled = it.getScheduled();
      return Boolean.valueOf((!Objects.equal(_scheduled, Boolean.FALSE)));
    };
    return Queries.<Dependency>until(Queries.<Dependency>until(ActivityPathAnalysis.closureIncomingDependencies(tmsc, to), _function), _function_1);
  }
  
  private static BranchIterable<Dependency> closureIncomingDependencies(@Extension final TMSC tmsc, final Event event) {
    final Function1<Dependency, Iterable<? extends Dependency>> _function = (Dependency it) -> {
      Event _source = it.getSource();
      Collection<Dependency> _incomingDependencies = null;
      if (_source!=null) {
        _incomingDependencies=tmsc.getIncomingDependencies(_source);
      }
      return _incomingDependencies;
    };
    return Queries.<Dependency>closure(tmsc.getIncomingDependencies(event), true, _function);
  }
  
  /**
   * Default value for persisted {@code activityPathAnalysisResult} property on ScopedTMSC
   */
  private static final boolean _DEFAULT_SCOPEDTMSC_ACTIVITYPATHANALYSISRESULT = false;
  
  private static boolean isActivityPathAnalysisResult(final ScopedTMSC container) {
    final String key = "activityPathAnalysisResult";
    final Object value = container.getProperties().get(key);
    if (value == null) {
        return _DEFAULT_SCOPEDTMSC_ACTIVITYPATHANALYSISRESULT;
    }
    return (boolean) value;
  }
  
  private static void setActivityPathAnalysisResult(final ScopedTMSC container, final boolean value) {
    final String key = "activityPathAnalysisResult";
    if (value == _DEFAULT_SCOPEDTMSC_ACTIVITYPATHANALYSISRESULT) {
    container.getProperties().remove(key);
    } else {
        container.getProperties().put(key, value);
    }
  }
}
