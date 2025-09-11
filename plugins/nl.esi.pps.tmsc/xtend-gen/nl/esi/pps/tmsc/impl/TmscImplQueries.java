/**
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.impl;

import com.google.common.collect.Iterables;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import nl.esi.pps.architecture.implemented.Function;
import nl.esi.pps.architecture.specified.Component;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.EntryEvent;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.EventType;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.ExitEvent;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.Interval;
import nl.esi.pps.tmsc.Lifeline;
import nl.esi.pps.tmsc.LifelineSegment;
import nl.esi.pps.tmsc.ScopedTMSC;
import nl.esi.pps.tmsc.TMSC;
import nl.esi.pps.tmsc.util.TmscQueries;
import org.eclipse.emf.common.util.EList;
import org.eclipse.lsat.common.xtend.Queries;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.XbaseGenerated;

@SuppressWarnings("all")
final class TmscImplQueries {
  private TmscImplQueries() {
  }

  /**
   * @see Execution#getStartTime()
   */
  protected static Long _getStartTimeImpl(final Execution execution) {
    EntryEvent _entry = execution.getEntry();
    Long _timestamp = null;
    if (_entry!=null) {
      _timestamp=_entry.getTimestamp();
    }
    return _timestamp;
  }

  /**
   * @see Dependency#getStartTime()
   */
  protected static Long _getStartTimeImpl(final Dependency dependency) {
    Event _source = dependency.getSource();
    Long _timestamp = null;
    if (_source!=null) {
      _timestamp=_source.getTimestamp();
    }
    return _timestamp;
  }

  /**
   * @see Interval#getStartTime()
   */
  protected static Long _getStartTimeImpl(final Interval interval) {
    Event _from = interval.getFrom();
    Long _timestamp = null;
    if (_from!=null) {
      _timestamp=_from.getTimestamp();
    }
    return _timestamp;
  }

  /**
   * @see Execution#getEndTime()
   */
  protected static Long _getEndTimeImpl(final Execution execution) {
    ExitEvent _exit = execution.getExit();
    Long _timestamp = null;
    if (_exit!=null) {
      _timestamp=_exit.getTimestamp();
    }
    return _timestamp;
  }

  /**
   * @see Dependency#getEndTime()
   */
  protected static Long _getEndTimeImpl(final Dependency dependency) {
    Event _target = dependency.getTarget();
    Long _timestamp = null;
    if (_target!=null) {
      _timestamp=_target.getTimestamp();
    }
    return _timestamp;
  }

  /**
   * @see Interval#getEndTime()
   */
  protected static Long _getEndTimeImpl(final Interval interval) {
    Event _to = interval.getTo();
    Long _timestamp = null;
    if (_to!=null) {
      _timestamp=_to.getTimestamp();
    }
    return _timestamp;
  }

  /**
   * @see FullScopeTMSC#getEvents()
   */
  protected static Iterable<Event> _getEventsImpl(final FullScopeTMSC tmsc) {
    final Function1<Lifeline, EList<Event>> _function = (Lifeline it) -> {
      return it.getEvents();
    };
    return IterableExtensions.<Lifeline, Event>flatMap(tmsc.getLifelines(), _function);
  }

  /**
   * @see ScopedTMSC#getEvents()
   */
  protected static Iterable<Event> _getEventsImpl(final ScopedTMSC tmsc) {
    final Function1<Dependency, List<Event>> _function = (Dependency it) -> {
      return TmscQueries.getEvents(it);
    };
    return IterableExtensions.<Event>toSet(IterableExtensions.<Dependency, Event>flatMap(tmsc.getDependencies(), _function));
  }

  /**
   * @see FullScopeTMSC#getIncomingDependencies(Event)
   */
  protected static Iterable<Dependency> _getIncomingDependenciesImpl(final FullScopeTMSC tmsc, final Event event) {
    return event.getFullScopeIncomingDependencies();
  }

  /**
   * @see ScopedTMSC#getIncomingDependencies(Event)
   */
  protected static Iterable<Dependency> _getIncomingDependenciesImpl(final ScopedTMSC tmsc, final Event event) {
    final Function1<Dependency, Boolean> _function = (Dependency it) -> {
      return Boolean.valueOf(it.getScopes().contains(tmsc));
    };
    return IterableExtensions.<Dependency>filter(event.getFullScopeIncomingDependencies(), _function);
  }

  /**
   * @see FullScopeTMSC#getOutgoingDependencies(Event)
   */
  protected static Iterable<Dependency> _getOutgoingDependenciesImpl(final FullScopeTMSC tmsc, final Event event) {
    return event.getFullScopeOutgoingDependencies();
  }

  /**
   * @see ScopedTMSC#getOutgoingDependencies(Event)
   */
  protected static Iterable<Dependency> _getOutgoingDependenciesImpl(final ScopedTMSC tmsc, final Event event) {
    final Function1<Dependency, Boolean> _function = (Dependency it) -> {
      return Boolean.valueOf(it.getScopes().contains(tmsc));
    };
    return IterableExtensions.<Dependency>filter(event.getFullScopeOutgoingDependencies(), _function);
  }

  /**
   * @see TMSC#getFullScope()
   */
  public static FullScopeTMSC getFullScopeImpl(final TMSC tmsc) {
    TMSC fullScope = tmsc;
    while ((fullScope instanceof ScopedTMSC)) {
      fullScope = ((ScopedTMSC)fullScope).getParentScope();
    }
    return ((FullScopeTMSC) fullScope);
  }

  /**
   * @see ScopedTMSC#getFqn()
   */
  public static String getFqnImpl(final ScopedTMSC tmsc) {
    final Function1<ScopedTMSC, ScopedTMSC> _function = (ScopedTMSC it) -> {
      ScopedTMSC _xifexpression = null;
      TMSC _parentScope = it.getParentScope();
      if ((_parentScope instanceof ScopedTMSC)) {
        TMSC _parentScope_1 = it.getParentScope();
        _xifexpression = ((ScopedTMSC) _parentScope_1);
      }
      return _xifexpression;
    };
    final Function1<ScopedTMSC, String> _function_1 = (ScopedTMSC it) -> {
      return it.getName();
    };
    return IterableExtensions.join(ListExtensions.<ScopedTMSC, String>map(Queries.<ScopedTMSC>reverse(Queries.<ScopedTMSC>climbTree(Collections.<ScopedTMSC>singleton(tmsc), true, _function)), _function_1), ".");
  }

  /**
   * @see Lifeline#getSegments()
   */
  public static Iterable<LifelineSegment> getSegmentsImpl(final Lifeline lifeline) {
    final Function1<Event, Iterable<LifelineSegment>> _function = (Event it) -> {
      return Iterables.<LifelineSegment>filter(it.getFullScopeOutgoingDependencies(), LifelineSegment.class);
    };
    return IterableExtensions.<Event, LifelineSegment>flatMap(lifeline.getEvents(), _function);
  }

  /**
   * @see Lifeline#isTraced()
   */
  public static boolean isTracedImpl(final Lifeline lifeline) {
    final Function1<Event, Boolean> _function = (Event it) -> {
      return Boolean.valueOf(it.isTraced());
    };
    return IterableExtensions.<Event>exists(lifeline.getEvents(), _function);
  }

  public static Iterable<Execution> getRootExecutionsImpl(final Lifeline lifeline) {
    final Function1<Execution, Boolean> _function = (Execution it) -> {
      Execution _parent = it.getParent();
      return Boolean.valueOf((_parent == null));
    };
    return Queries.<Execution>select(lifeline.getExecutions(), _function);
  }

  /**
   * @see Event#getTmsc()
   */
  public static FullScopeTMSC getTmscImpl(final Event event) {
    Lifeline _lifeline = event.getLifeline();
    FullScopeTMSC _tmsc = null;
    if (_lifeline!=null) {
      _tmsc=_lifeline.getTmsc();
    }
    return _tmsc;
  }

  /**
   * @see Event#getScopes()
   */
  public static Set<ScopedTMSC> getScopesImpl(final Event event) {
    final Function1<Dependency, EList<ScopedTMSC>> _function = (Dependency it) -> {
      return it.getScopes();
    };
    return IterableExtensions.<ScopedTMSC>toSet(IterableExtensions.<Dependency, ScopedTMSC>flatMap(Queries.<Dependency>union(event.getFullScopeIncomingDependencies(), event.getFullScopeOutgoingDependencies()), _function));
  }

  /**
   * @see Event#getTmsc()
   */
  public static FullScopeTMSC getTmscImpl(final Execution execution) {
    Lifeline _lifeline = execution.getLifeline();
    FullScopeTMSC _tmsc = null;
    if (_lifeline!=null) {
      _tmsc=_lifeline.getTmsc();
    }
    return _tmsc;
  }

  /**
   * @see Execution#getFullScopeRoot()
   */
  public static Execution getRootImpl(final Execution execution) {
    Execution rootExecution = execution;
    while ((rootExecution.getParent() != null)) {
      rootExecution = rootExecution.getParent();
    }
    return rootExecution;
  }

  /**
   * @see Execution#getComponent()
   */
  public static Component getComponentImpl(final Execution execution) {
    Component _elvis = null;
    EntryEvent _entry = execution.getEntry();
    Component _component = null;
    if (_entry!=null) {
      _component=_entry.getComponent();
    }
    if (_component != null) {
      _elvis = _component;
    } else {
      ExitEvent _exit = execution.getExit();
      Component _component_1 = null;
      if (_exit!=null) {
        _component_1=_exit.getComponent();
      }
      _elvis = _component_1;
    }
    return _elvis;
  }

  /**
   * @see Execution#getFunction()
   */
  public static Function getFunctionImpl(final Execution execution) {
    Function _elvis = null;
    EntryEvent _entry = execution.getEntry();
    Function _function = null;
    if (_entry!=null) {
      _function=_entry.getFunction();
    }
    if (_function != null) {
      _elvis = _function;
    } else {
      ExitEvent _exit = execution.getExit();
      Function _function_1 = null;
      if (_exit!=null) {
        _function_1=_exit.getFunction();
      }
      _elvis = _function_1;
    }
    return _elvis;
  }

  /**
   * @see Execution#getSegments()
   */
  public static Iterable<LifelineSegment> getSegmentsImpl(final Execution execution) {
    final Function1<Execution, ExitEvent> _function = (Execution it) -> {
      return it.getExit();
    };
    final Function1<Event, Iterable<LifelineSegment>> _function_1 = (Event it) -> {
      return Iterables.<LifelineSegment>filter(it.getFullScopeOutgoingDependencies(), LifelineSegment.class);
    };
    return IterableExtensions.<Event, LifelineSegment>flatMap(IterableExtensions.<Event>filterNull(Queries.<Event>union(Collections.<EntryEvent>singleton(execution.getEntry()), ListExtensions.<Execution, ExitEvent>map(execution.getChildren(), _function))), _function_1);
  }

  /**
   * @see CallStackDependency#getLifeline()
   */
  public static Lifeline getLifelineImpl(final LifelineSegment lifelineSegment) {
    Lifeline _elvis = null;
    Event _source = lifelineSegment.getSource();
    Lifeline _lifeline = null;
    if (_source!=null) {
      _lifeline=_source.getLifeline();
    }
    if (_lifeline != null) {
      _elvis = _lifeline;
    } else {
      Event _target = lifelineSegment.getTarget();
      Lifeline _lifeline_1 = null;
      if (_target!=null) {
        _lifeline_1=_target.getLifeline();
      }
      _elvis = _lifeline_1;
    }
    return _elvis;
  }

  /**
   * Different call-stack dependencies and which execution is active.
   * 
   *      +---------+         +---------+
   *     /|         |    3    |         |\
   *  1 / |<-- 2 -->|<------->|<-- 4 -->| \ 5
   *   /  |         |         |         |  \
   *  +---+---------+---------+---------+---+         +----
   *  |   |         |         |         |   |         |
   *  | 1 |         |    3    |         | 5 |<-- 6 -->|
   *  |   |                             |   |         |
   *  +-------------------------------------+         +----
   * 
   * @see CallStackDependency#getLifeline()
   */
  public static Execution getActiveExecutionImpl(final LifelineSegment lifelineSegment) {
    Event _source = lifelineSegment.getSource();
    Execution _execution = null;
    if (_source!=null) {
      _execution=_source.getExecution();
    }
    final Execution sourceExecution = _execution;
    Event _target = lifelineSegment.getTarget();
    Execution _execution_1 = null;
    if (_target!=null) {
      _execution_1=_target.getExecution();
    }
    final Execution targetExecution = _execution_1;
    Execution _switchResult = null;
    final LifelineSegment it = lifelineSegment;
    boolean _matched = false;
    if (((sourceExecution == null) || (targetExecution == null))) {
      _matched=true;
      _switchResult = null;
    }
    if (!_matched) {
      if ((Objects.equals(EventType.getType(it.getSource()), EventType.ENTRY) && Objects.equals(EventType.getType(it.getTarget()), EventType.ENTRY))) {
        _matched=true;
        _switchResult = sourceExecution;
      }
    }
    if (!_matched) {
      if ((Objects.equals(EventType.getType(it.getSource()), EventType.EXIT) && Objects.equals(EventType.getType(it.getTarget()), EventType.EXIT))) {
        _matched=true;
        _switchResult = targetExecution;
      }
    }
    if (!_matched) {
      if (((Objects.equals(EventType.getType(it.getSource()), EventType.ENTRY) && Objects.equals(EventType.getType(it.getTarget()), EventType.EXIT)) && (sourceExecution == targetExecution))) {
        _matched=true;
        _switchResult = sourceExecution;
      }
    }
    if (!_matched) {
      if ((Objects.equals(EventType.getType(it.getSource()), EventType.EXIT) && Objects.equals(EventType.getType(it.getTarget()), EventType.ENTRY))) {
        _matched=true;
        _switchResult = TmscQueries.getCommonAncestor(sourceExecution, targetExecution);
      }
    }
    return _switchResult;
  }

  public static FullScopeTMSC getTmscImpl(final Interval interval) {
    FullScopeTMSC _elvis = null;
    Event _from = interval.getFrom();
    FullScopeTMSC _tmsc = null;
    if (_from!=null) {
      _tmsc=_from.getTmsc();
    }
    if (_tmsc != null) {
      _elvis = _tmsc;
    } else {
      Event _to = interval.getTo();
      FullScopeTMSC _tmsc_1 = null;
      if (_to!=null) {
        _tmsc_1=_to.getTmsc();
      }
      _elvis = _tmsc_1;
    }
    return _elvis;
  }

  @XbaseGenerated
  public static Long getStartTimeImpl(final Object dependency) {
    if (dependency instanceof Dependency) {
      return _getStartTimeImpl((Dependency)dependency);
    } else if (dependency instanceof Execution) {
      return _getStartTimeImpl((Execution)dependency);
    } else if (dependency instanceof Interval) {
      return _getStartTimeImpl((Interval)dependency);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(dependency).toString());
    }
  }

  @XbaseGenerated
  public static Long getEndTimeImpl(final Object dependency) {
    if (dependency instanceof Dependency) {
      return _getEndTimeImpl((Dependency)dependency);
    } else if (dependency instanceof Execution) {
      return _getEndTimeImpl((Execution)dependency);
    } else if (dependency instanceof Interval) {
      return _getEndTimeImpl((Interval)dependency);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(dependency).toString());
    }
  }

  @XbaseGenerated
  public static Iterable<Event> getEventsImpl(final TMSC tmsc) {
    if (tmsc instanceof FullScopeTMSC) {
      return _getEventsImpl((FullScopeTMSC)tmsc);
    } else if (tmsc instanceof ScopedTMSC) {
      return _getEventsImpl((ScopedTMSC)tmsc);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(tmsc).toString());
    }
  }

  @XbaseGenerated
  public static Iterable<Dependency> getIncomingDependenciesImpl(final TMSC tmsc, final Event event) {
    if (tmsc instanceof FullScopeTMSC) {
      return _getIncomingDependenciesImpl((FullScopeTMSC)tmsc, event);
    } else if (tmsc instanceof ScopedTMSC) {
      return _getIncomingDependenciesImpl((ScopedTMSC)tmsc, event);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(tmsc, event).toString());
    }
  }

  @XbaseGenerated
  public static Iterable<Dependency> getOutgoingDependenciesImpl(final TMSC tmsc, final Event event) {
    if (tmsc instanceof FullScopeTMSC) {
      return _getOutgoingDependenciesImpl((FullScopeTMSC)tmsc, event);
    } else if (tmsc instanceof ScopedTMSC) {
      return _getOutgoingDependenciesImpl((ScopedTMSC)tmsc, event);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(tmsc, event).toString());
    }
  }
}
