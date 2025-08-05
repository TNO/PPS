/**
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.analysis;

import java.util.Collection;
import java.util.Objects;
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
public final class CriticalPathAnalysis {
  private final boolean markCritical;

  private final Function1<? super Event, ? extends Long> timestampFunc;

  private final Function1<? super Dependency, ? extends Long> timeBoundFunc;

  public CriticalPathAnalysis() {
    this.markCritical = true;
    final Function1<Event, Long> _function = (Event it) -> {
      return it.getTimestamp();
    };
    this.timestampFunc = _function;
    final Function1<Dependency, Long> _function_1 = (Dependency it) -> {
      return it.getTimeBound();
    };
    this.timeBoundFunc = _function_1;
  }

  public CriticalPathAnalysis(final Function1<? super Event, ? extends Long> timestampFunc, final Function1<? super Dependency, ? extends Long> timeBoundFunc) {
    this.markCritical = false;
    this.timestampFunc = timestampFunc;
    this.timeBoundFunc = timeBoundFunc;
  }

  public static ScopedTMSC analyseCriticalPath(final Interval interval) {
    final Function1<ScopedTMSC, Boolean> _function = (ScopedTMSC it) -> {
      return Boolean.valueOf(CriticalPathAnalysis.isCriticalPathAnalysisResult(it));
    };
    final ScopedTMSC previousCriticalPath = IterableExtensions.<ScopedTMSC>findFirst(interval.getScopes(), _function);
    if ((previousCriticalPath != null)) {
      return previousCriticalPath;
    }
    @Extension
    final CriticalPathAnalysis criticalPathAnalysis = new CriticalPathAnalysis();
    BranchIterable<Dependency> _findCriticalPathBetween = criticalPathAnalysis.findCriticalPathBetween(interval.getTmsc(), interval.getFrom(), interval.getTo());
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Critical path for ");
    String _name = interval.getName();
    _builder.append(_name);
    final ScopedTMSC criticalPath = TmscQueries.createScopedTMSC(_findCriticalPathBetween, _builder, interval.getFrom(), interval.getTo());
    CriticalPathAnalysis.setCriticalPathAnalysisResult(criticalPath, true);
    EList<ScopedTMSC> _scopes = interval.getScopes();
    _scopes.add(criticalPath);
    return criticalPath;
  }

  /**
   * Finds {@link Dependency dependencies} that denote the critical path to
   * the specified {@code event}.
   * 
   * @see #analyseCriticalDependenciesTo(TMSC, Event)
   */
  public BranchIterable<Dependency> findCriticalPathTo(final TMSC tmsc, final Event event) {
    final Function1<Dependency, Boolean> _function = (Dependency it) -> {
      boolean _analyseCritical = this.analyseCritical(it);
      return Boolean.valueOf((!_analyseCritical));
    };
    return Queries.<Dependency>until(this.closureIncomingDependencies(tmsc, event), _function);
  }

  /**
   * Finds {@link Dependency dependencies} that denote the critical path to
   * the specified {@code to} event. Analysis is stopped when {@code from} event
   * is detected or at the {@link Event#getTimestamp() time} of {@code from}.
   * 
   * @see #findCriticalPathTo(TMSC, Event)
   */
  public BranchIterable<Dependency> findCriticalPathBetween(final TMSC tmsc, final Event from, final Event to) {
    final Function1<Dependency, Boolean> _function = (Dependency it) -> {
      return Boolean.valueOf((Objects.equals(it.getTarget(), from) || (it.getTarget().getTimestamp().compareTo(from.getTimestamp()) <= 0)));
    };
    final Function1<Dependency, Boolean> _function_1 = (Dependency it) -> {
      boolean _analyseCritical = this.analyseCritical(it);
      return Boolean.valueOf((!_analyseCritical));
    };
    return Queries.<Dependency>until(Queries.<Dependency>until(this.closureIncomingDependencies(tmsc, to), _function), _function_1);
  }

  private BranchIterable<Dependency> closureIncomingDependencies(@Extension final TMSC tmsc, final Event event) {
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

  private boolean analyseCritical(final Dependency dependency) {
    Long _xifexpression = null;
    Event _source = dependency.getSource();
    boolean _tripleNotEquals = (_source != null);
    if (_tripleNotEquals) {
      _xifexpression = this.timestampFunc.apply(dependency.getSource());
    }
    final Long sourceTimestamp = _xifexpression;
    Long _xifexpression_1 = null;
    Event _target = dependency.getTarget();
    boolean _tripleNotEquals_1 = (_target != null);
    if (_tripleNotEquals_1) {
      _xifexpression_1 = this.timestampFunc.apply(dependency.getTarget());
    }
    final Long targetTimestamp = _xifexpression_1;
    final Long timeBound = this.timeBoundFunc.apply(dependency);
    if ((((sourceTimestamp == null) || (targetTimestamp == null)) || (timeBound == null))) {
      if (this.markCritical) {
        CriticalPathAnalysis.unsetCritical(dependency);
      }
      return false;
    } else {
      final boolean criticalValue = (((sourceTimestamp).longValue() + (timeBound).longValue()) >= (targetTimestamp).longValue());
      if (this.markCritical) {
        CriticalPathAnalysis.setCritical(dependency, criticalValue);
      }
      return criticalValue;
    }
  }

  /**
   * Default value for persisted {@code critical} property on Dependency
   */
  private static final boolean _DEFAULT_DEPENDENCY_CRITICAL = false;

  public static boolean isCritical(final Dependency container) {
    final String key = "critical";
    final Object value = container.getProperties().get(key);
    if (value == null) {
        return _DEFAULT_DEPENDENCY_CRITICAL;
    }
    return (boolean) value;
  }

  public static void setCritical(final Dependency container, final boolean value) {
    final String key = "critical";
    container.getProperties().put(key, value);
  }

  /**
   * Returns whether the value of the '{@link nl.esi.pps.tmsc.analysis.CriticalPathAnalysis#isCritical <em>critical</em>}' property is set on {@code container}.
   */
  public static boolean isSetCritical(final Dependency container) {
    final String key = "critical";
    return container.getProperties().containsKey(key);
  }

  /**
   * Unsets the value of the '{@link nl.esi.pps.tmsc.analysis.CriticalPathAnalysis#isCritical <em>critical</em>}' property on {@code container}.
   */
  public static void unsetCritical(final Dependency container) {
    final String key = "critical";
    container.getProperties().remove(key);
  }

  /**
   * Default value for persisted {@code criticalPathAnalysisResult} property on ScopedTMSC
   */
  private static final boolean _DEFAULT_SCOPEDTMSC_CRITICALPATHANALYSISRESULT = false;

  private static boolean isCriticalPathAnalysisResult(final ScopedTMSC container) {
    final String key = "criticalPathAnalysisResult";
    final Object value = container.getProperties().get(key);
    if (value == null) {
        return _DEFAULT_SCOPEDTMSC_CRITICALPATHANALYSISRESULT;
    }
    return (boolean) value;
  }

  private static void setCriticalPathAnalysisResult(final ScopedTMSC container, final boolean value) {
    final String key = "criticalPathAnalysisResult";
    if (value == _DEFAULT_SCOPEDTMSC_CRITICALPATHANALYSISRESULT) {
    container.getProperties().remove(key);
    } else {
        container.getProperties().put(key, value);
    }
  }
}
