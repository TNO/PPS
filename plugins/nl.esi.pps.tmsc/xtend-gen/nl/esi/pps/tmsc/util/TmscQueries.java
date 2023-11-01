/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.util;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.EntryEvent;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.ExitEvent;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.ITMSC;
import nl.esi.pps.tmsc.Interval;
import nl.esi.pps.tmsc.Lifeline;
import nl.esi.pps.tmsc.LifelineSegment;
import nl.esi.pps.tmsc.ScopedTMSC;
import nl.esi.pps.tmsc.TMSC;
import nl.esi.pps.tmsc.TmscFactory;
import nl.esi.pps.tmsc.text.ETimestampFormat;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.lsat.common.util.BranchIterable;
import org.eclipse.lsat.common.util.UniqueQueue;
import org.eclipse.lsat.common.xtend.Queries;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public final class TmscQueries {
  public static class CachedQueryTMSC implements ITMSC {
    @Accessors
    private final List<Event> origin = new ArrayList<Event>(2);
    
    @Accessors
    private final List<Dependency> dependencies;
    
    private final Map<Event, List<Dependency>> incomingDependencies;
    
    private final Map<Event, List<Dependency>> outgoingDependencies;
    
    @Accessors
    private String name;
    
    public CachedQueryTMSC(final Iterable<? extends Dependency> dependencies) {
      if ((dependencies instanceof Collection)) {
        int _size = ((Collection)dependencies).size();
        ArrayList<Dependency> _arrayList = new ArrayList<Dependency>(_size);
        this.dependencies = _arrayList;
        int _size_1 = ((Collection)dependencies).size();
        LinkedHashMap<Event, List<Dependency>> _linkedHashMap = new LinkedHashMap<Event, List<Dependency>>(_size_1);
        this.incomingDependencies = _linkedHashMap;
        int _size_2 = ((Collection)dependencies).size();
        LinkedHashMap<Event, List<Dependency>> _linkedHashMap_1 = new LinkedHashMap<Event, List<Dependency>>(_size_2);
        this.outgoingDependencies = _linkedHashMap_1;
      } else {
        LinkedList<Dependency> _linkedList = new LinkedList<Dependency>();
        this.dependencies = _linkedList;
        LinkedHashMap<Event, List<Dependency>> _linkedHashMap_2 = new LinkedHashMap<Event, List<Dependency>>();
        this.incomingDependencies = _linkedHashMap_2;
        LinkedHashMap<Event, List<Dependency>> _linkedHashMap_3 = new LinkedHashMap<Event, List<Dependency>>();
        this.outgoingDependencies = _linkedHashMap_3;
      }
      for (final Dependency dependency : dependencies) {
        {
          this.dependencies.add(dependency);
          final Function<Event, List<Dependency>> _function = (Event it) -> {
            return new ArrayList<Dependency>();
          };
          List<Dependency> _computeIfAbsent = this.incomingDependencies.computeIfAbsent(dependency.getTarget(), _function);
          _computeIfAbsent.add(dependency);
          final Function<Event, List<Dependency>> _function_1 = (Event it) -> {
            return new ArrayList<Dependency>();
          };
          List<Dependency> _computeIfAbsent_1 = this.outgoingDependencies.computeIfAbsent(dependency.getSource(), _function_1);
          _computeIfAbsent_1.add(dependency);
        }
      }
    }
    
    @Override
    public List<Dependency> getIncomingDependencies(final Event event) {
      return this.incomingDependencies.getOrDefault(event, Collections.<Dependency>emptyList());
    }
    
    @Override
    public List<Dependency> getOutgoingDependencies(final Event event) {
      return this.outgoingDependencies.getOrDefault(event, Collections.<Dependency>emptyList());
    }
    
    @Override
    public Collection<Event> getInitialEvents() {
      Set<Event> _keySet = this.outgoingDependencies.keySet();
      final LinkedHashSet<Event> initialEvents = new LinkedHashSet<Event>(_keySet);
      initialEvents.removeAll(this.incomingDependencies.keySet());
      return initialEvents;
    }
    
    @Override
    public boolean isInitialEvent(final Event event) {
      boolean _containsKey = this.incomingDependencies.containsKey(event);
      return (!_containsKey);
    }
    
    @Override
    public Collection<Event> getFinalEvents() {
      Set<Event> _keySet = this.incomingDependencies.keySet();
      final LinkedHashSet<Event> finalEvents = new LinkedHashSet<Event>(_keySet);
      finalEvents.removeAll(this.outgoingDependencies.keySet());
      return finalEvents;
    }
    
    @Override
    public boolean isFinalEvent(final Event event) {
      boolean _containsKey = this.outgoingDependencies.containsKey(event);
      return (!_containsKey);
    }
    
    public ScopedTMSC createScopedTMSC() {
      ScopedTMSC _createScopedTMSC = TmscQueries.createScopedTMSC(this.dependencies, this.name);
      final Procedure1<ScopedTMSC> _function = (ScopedTMSC scope) -> {
        EList<Event> _origin = scope.getOrigin();
        Iterables.<Event>addAll(_origin, this.origin);
      };
      return ObjectExtensions.<ScopedTMSC>operator_doubleArrow(_createScopedTMSC, _function);
    }
    
    @Pure
    public List<Event> getOrigin() {
      return this.origin;
    }
    
    @Pure
    @Override
    public List<Dependency> getDependencies() {
      return this.dependencies;
    }
    
    @Pure
    public String getName() {
      return this.name;
    }
    
    public void setName(final String name) {
      this.name = name;
    }
  }
  
  private TmscQueries() {
  }
  
  public static String toDebugString(final Dependency dependency) {
    StringConcatenation _builder = new StringConcatenation();
    String _debugString = TmscQueries.toDebugString(dependency.getSource());
    _builder.append(_debugString);
    _builder.append(" -");
    String _name = dependency.eClass().getName();
    _builder.append(_name);
    _builder.append("-> ");
    String _debugString_1 = TmscQueries.toDebugString(dependency.getTarget());
    _builder.append(_debugString_1);
    return _builder.toString();
  }
  
  public static String toDebugString(final Event event) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = event.getLifeline().getExecutor().getName();
    _builder.append(_name);
    _builder.append("@");
    String _format = ETimestampFormat.eINSTANCE.format(event.getTimestamp());
    _builder.append(_format);
    return _builder.toString();
  }
  
  /**
   * Returns a list, containing the {@link Dependency#getSource() source event}
   * and/or {@link Dependency#getTarget() target event}. The list only contains an
   * event if it is not <code>null</code>.
   */
  public static List<Event> getEvents(final Dependency dependency) {
    List<Event> _switchResult = null;
    final Dependency it = dependency;
    boolean _matched = false;
    if (((it.getSource() != null) && (it.getTarget() != null))) {
      _matched=true;
      _switchResult = Arrays.<Event>asList(it.getSource(), it.getTarget());
    }
    if (!_matched) {
      Event _source = it.getSource();
      boolean _tripleNotEquals = (_source != null);
      if (_tripleNotEquals) {
        _matched=true;
        _switchResult = Collections.<Event>singletonList(it.getSource());
      }
    }
    if (!_matched) {
      Event _target = it.getTarget();
      boolean _tripleNotEquals_1 = (_target != null);
      if (_tripleNotEquals_1) {
        _matched=true;
        _switchResult = Collections.<Event>singletonList(it.getTarget());
      }
    }
    if (!_matched) {
      _switchResult = Collections.<Event>emptyList();
    }
    return _switchResult;
  }
  
  /**
   * Returns a list, containing the {@link Execution#getEntry() entry event}
   * and/or {@link Execution#getExit() exit event}. The list only contains an
   * event if it is not <code>null</code>.
   */
  public static List<Event> getEvents(final Execution execution) {
    List<Event> _switchResult = null;
    final Execution it = execution;
    boolean _matched = false;
    if (((it.getEntry() != null) && (it.getExit() != null))) {
      _matched=true;
      _switchResult = Arrays.<Event>asList(it.getEntry(), it.getExit());
    }
    if (!_matched) {
      EntryEvent _entry = it.getEntry();
      boolean _tripleNotEquals = (_entry != null);
      if (_tripleNotEquals) {
        _matched=true;
        _switchResult = Collections.<Event>singletonList(it.getEntry());
      }
    }
    if (!_matched) {
      ExitEvent _exit = it.getExit();
      boolean _tripleNotEquals_1 = (_exit != null);
      if (_tripleNotEquals_1) {
        _matched=true;
        _switchResult = Collections.<Event>singletonList(it.getExit());
      }
    }
    if (!_matched) {
      _switchResult = Collections.<Event>emptyList();
    }
    return _switchResult;
  }
  
  /**
   * Returns a list, containing the {@link Interval#getFrom() from event}
   * and/or {@link Interval#getTo() to event}. The list only contains an
   * event if it is not <code>null</code>.
   */
  public static List<Event> getEvents(final Interval interval) {
    List<Event> _switchResult = null;
    final Interval it = interval;
    boolean _matched = false;
    if (((it.getFrom() != null) && (it.getTo() != null))) {
      _matched=true;
      _switchResult = Arrays.<Event>asList(it.getFrom(), it.getTo());
    }
    if (!_matched) {
      Event _from = it.getFrom();
      boolean _tripleNotEquals = (_from != null);
      if (_tripleNotEquals) {
        _matched=true;
        _switchResult = Collections.<Event>singletonList(it.getFrom());
      }
    }
    if (!_matched) {
      Event _to = it.getTo();
      boolean _tripleNotEquals_1 = (_to != null);
      if (_tripleNotEquals_1) {
        _matched=true;
        _switchResult = Collections.<Event>singletonList(it.getTo());
      }
    }
    if (!_matched) {
      _switchResult = Collections.<Event>emptyList();
    }
    return _switchResult;
  }
  
  /**
   * Returns <code>true</code> if both {@link Dependency#getSource() source} and
   * {@link Dependency#getTarget() target} are set and both are
   * {@link Event#isTraced() traced}, <code>false</code> otherwise.
   */
  public static boolean isFullyTraced(final Dependency dependency) {
    return (TmscQueries.isSourceTraced(dependency) && TmscQueries.isTargetTraced(dependency));
  }
  
  /**
   * Returns <code>true</code> if {@link Dependency#getSource() source} is set and
   * {@link Event#isTraced() traced}, <code>false</code> otherwise.
   */
  public static boolean isSourceTraced(final Dependency dependency) {
    boolean _and = false;
    Event _source = null;
    if (dependency!=null) {
      _source=dependency.getSource();
    }
    boolean _tripleNotEquals = (_source != null);
    if (!_tripleNotEquals) {
      _and = false;
    } else {
      boolean _isTraced = dependency.getSource().isTraced();
      _and = _isTraced;
    }
    return _and;
  }
  
  /**
   * Returns <code>true</code> if {@link Dependency#getTarget() target} is set and
   * {@link Event#isTraced() traced}, <code>false</code> otherwise.
   */
  public static boolean isTargetTraced(final Dependency dependency) {
    boolean _and = false;
    Event _target = null;
    if (dependency!=null) {
      _target=dependency.getTarget();
    }
    boolean _tripleNotEquals = (_target != null);
    if (!_tripleNotEquals) {
      _and = false;
    } else {
      boolean _isTraced = dependency.getTarget().isTraced();
      _and = _isTraced;
    }
    return _and;
  }
  
  /**
   * Returns <code>true</code> if both {@link Execution#getEntry() entry event} and
   * {@link Execution#getExit() exit event} are set and both are
   * {@link Event#isTraced() traced}, <code>false</code> otherwise.
   */
  public static boolean isFullyTraced(final Execution execution) {
    return (TmscQueries.isEntryTraced(execution) && TmscQueries.isExitTraced(execution));
  }
  
  /**
   * Returns <code>true</code> if {@link Execution#getEntry() entry event} is set and
   * {@link Event#isTraced() traced}, <code>false</code> otherwise.
   */
  public static boolean isEntryTraced(final Execution execution) {
    boolean _and = false;
    EntryEvent _entry = null;
    if (execution!=null) {
      _entry=execution.getEntry();
    }
    boolean _tripleNotEquals = (_entry != null);
    if (!_tripleNotEquals) {
      _and = false;
    } else {
      boolean _isTraced = execution.getEntry().isTraced();
      _and = _isTraced;
    }
    return _and;
  }
  
  /**
   * Returns <code>true</code> if {@link Execution#getExit() exit event} is set and
   * {@link Event#isTraced() traced}, <code>false</code> otherwise.
   */
  public static boolean isExitTraced(final Execution execution) {
    boolean _and = false;
    ExitEvent _exit = null;
    if (execution!=null) {
      _exit=execution.getExit();
    }
    boolean _tripleNotEquals = (_exit != null);
    if (!_tripleNotEquals) {
      _and = false;
    } else {
      boolean _isTraced = execution.getExit().isTraced();
      _and = _isTraced;
    }
    return _and;
  }
  
  /**
   * Returns the nearest common ancestor for both <code>execution1</code> and <code>execution2</code>.
   */
  public static Execution getCommonAncestor(final Execution execution1, final Execution execution2) {
    final Function1<Execution, Execution> _function = (Execution it) -> {
      return it.getParent();
    };
    final Set<Execution> ancestors1 = IterableExtensions.<Execution>toSet(Queries.<Execution>climbTree(Collections.<Execution>singleton(execution1), true, _function));
    final Function1<Execution, Execution> _function_1 = (Execution it) -> {
      return it.getParent();
    };
    final BranchIterable<Execution> ancestors2 = Queries.<Execution>climbTree(Collections.<Execution>singleton(execution2), true, _function_1);
    final Function1<Execution, Boolean> _function_2 = (Execution e) -> {
      return Boolean.valueOf(ancestors1.contains(e));
    };
    return IterableExtensions.<Execution>findFirst(ancestors2, _function_2);
  }
  
  /**
   * Creates a valid {@link TmscPackage.Literals#EID EID} string for
   * <code>text</code>.<br>
   * Replaces each sequence of illegal EID characters by a single '_' (underscore)
   * character.
   */
  public static String toEID(final CharSequence text) {
    String _xifexpression = null;
    if ((text != null)) {
      _xifexpression = text.toString().replaceAll("\\W+", "_");
    }
    return _xifexpression;
  }
  
  /**
   * Causal dependencies are defined as the intersection of the transitive closure
   * of outgoing dependencies of 'from' and the transitive closure of incoming
   * dependencies of 'to'.
   * 
   * @see #findCausalDependenciesBetween(ITMSC, Iterable, Iterable)
   */
  public static Set<Dependency> findCausalDependenciesBetween(final ITMSC tmsc, final Event from, final Event to) {
    return TmscQueries.findCausalDependenciesBetween(tmsc, Collections.<Event>singleton(from), Collections.<Event>singleton(to));
  }
  
  /**
   * Causal dependencies are defined as the intersection of the transitive closure
   * of outgoing dependencies of 'from' and the transitive closure of incoming
   * dependencies of 'to'.
   * <p>
   * Please note that, due to incomplete tracing (i.e. untraced Executors), the
   * returned set of dependencies might not contain a fully connected path. This
   * can be checked by calling {@link TmscQueries#findDisjunctTMSCs(Iterable)},
   * which should return a single entry in case of a fully connected path.
   * </p>
   */
  public static Set<Dependency> findCausalDependenciesBetween(@Extension final ITMSC tmsc, final Iterable<Event> froms, final Iterable<Event> tos) {
    final Function1<Event, Long> _function = (Event it) -> {
      return it.getTimestamp();
    };
    final Long minTimeStamp = IterableExtensions.<Long>min(IterableExtensions.<Event, Long>map(froms, _function));
    final Function1<Event, Long> _function_1 = (Event it) -> {
      return it.getTimestamp();
    };
    final Long maxTimeStamp = IterableExtensions.<Long>max(IterableExtensions.<Event, Long>map(tos, _function_1));
    boolean _greaterThan = (minTimeStamp.compareTo(maxTimeStamp) > 0);
    if (_greaterThan) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("From nanos (");
      _builder.append(minTimeStamp);
      _builder.append(") should be before to nanos (");
      _builder.append(maxTimeStamp);
      _builder.append(")");
      throw new IllegalArgumentException(_builder.toString());
    }
    final Function1<Event, Collection<Dependency>> _function_2 = (Event it) -> {
      return tmsc.getOutgoingDependencies(it);
    };
    final Function1<Dependency, Iterable<? extends Dependency>> _function_3 = (Dependency it) -> {
      return tmsc.getOutgoingDependencies(it.getTarget());
    };
    final Function1<Dependency, Boolean> _function_4 = (Dependency it) -> {
      Long _endTime = it.getEndTime();
      return Boolean.valueOf((_endTime.compareTo(maxTimeStamp) > 0));
    };
    final BranchIterable<Dependency> effect = Queries.<Dependency>until(Queries.<Dependency>closure(IterableExtensions.<Event, Dependency>flatMap(froms, _function_2), true, _function_3), _function_4);
    final Function1<Event, Collection<Dependency>> _function_5 = (Event it) -> {
      return tmsc.getIncomingDependencies(it);
    };
    final Function1<Dependency, Iterable<? extends Dependency>> _function_6 = (Dependency it) -> {
      return tmsc.getIncomingDependencies(it.getSource());
    };
    final Function1<Dependency, Boolean> _function_7 = (Dependency it) -> {
      Long _startTime = it.getStartTime();
      return Boolean.valueOf((_startTime.compareTo(minTimeStamp) < 0));
    };
    final BranchIterable<Dependency> cause = Queries.<Dependency>until(Queries.<Dependency>closure(IterableExtensions.<Event, Dependency>flatMap(tos, _function_5), true, _function_6), _function_7);
    final Set<Dependency> causalDependencies = IterableExtensions.<Dependency>toSet(effect);
    causalDependencies.retainAll(IterableExtensions.<Dependency>toSet(cause));
    return causalDependencies;
  }
  
  /**
   * Finds the transitive closure of adjecant (a.k.a. in any direction) dependencies
   * that match the {@code predicate} and are not earlier than from.timestamp on the from.lifeline and
   * not later than to.timestamp on the to.lifeline.
   */
  public static Set<Dependency> findAdjecantDependenciesBetween(@Extension final ITMSC tmsc, final Event from, final Event to, final Function1<? super Dependency, ? extends Boolean> predicate) {
    Long _timestamp = from.getTimestamp();
    Long _timestamp_1 = to.getTimestamp();
    boolean _greaterThan = (_timestamp.compareTo(_timestamp_1) > 0);
    if (_greaterThan) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("From nanos (");
      Long _timestamp_2 = from.getTimestamp();
      _builder.append(_timestamp_2);
      _builder.append(") should be before to nanos (");
      Long _timestamp_3 = to.getTimestamp();
      _builder.append(_timestamp_3);
      _builder.append(")");
      throw new IllegalArgumentException(_builder.toString());
    }
    final LinkedHashSet<Dependency> adjecantDependencies = CollectionLiterals.<Dependency>newLinkedHashSet();
    final UniqueQueue<Event> eventsToProcess = new UniqueQueue<Event>(from, to);
    final Function1<Dependency, Boolean> _function = (Dependency it) -> {
      return Boolean.valueOf(TmscQueries.isAfter(it.getTarget(), to));
    };
    final Consumer<Dependency> _function_1 = (Dependency d) -> {
      adjecantDependencies.add(d);
      Event _target = d.getTarget();
      eventsToProcess.add(_target);
    };
    IterableExtensions.<Dependency>filter(IterableExtensions.<Dependency>reject(tmsc.getOutgoingDependencies(from), _function), ((Function1<? super Dependency, Boolean>)predicate)).forEach(_function_1);
    final Function1<Dependency, Boolean> _function_2 = (Dependency it) -> {
      return Boolean.valueOf(TmscQueries.isBefore(it.getSource(), from));
    };
    final Consumer<Dependency> _function_3 = (Dependency d) -> {
      adjecantDependencies.add(d);
      Event _source = d.getSource();
      eventsToProcess.add(_source);
    };
    IterableExtensions.<Dependency>filter(IterableExtensions.<Dependency>reject(tmsc.getIncomingDependencies(to), _function_2), ((Function1<? super Dependency, Boolean>)predicate)).forEach(_function_3);
    while ((!eventsToProcess.isEmpty())) {
      {
        final Event event = eventsToProcess.remove();
        if ((event != null)) {
          final Function1<Dependency, Boolean> _function_4 = (Dependency it) -> {
            return Boolean.valueOf(TmscQueries.isBefore(it.getTarget(), from));
          };
          final Function1<Dependency, Boolean> _function_5 = (Dependency it) -> {
            return Boolean.valueOf(TmscQueries.isAfter(it.getTarget(), to));
          };
          final Consumer<Dependency> _function_6 = (Dependency d) -> {
            adjecantDependencies.add(d);
            Event _target = d.getTarget();
            eventsToProcess.add(_target);
          };
          IterableExtensions.<Dependency>filter(IterableExtensions.<Dependency>reject(IterableExtensions.<Dependency>reject(tmsc.getOutgoingDependencies(event), _function_4), _function_5), ((Function1<? super Dependency, Boolean>)predicate)).forEach(_function_6);
          final Function1<Dependency, Boolean> _function_7 = (Dependency it) -> {
            return Boolean.valueOf(TmscQueries.isBefore(it.getSource(), from));
          };
          final Function1<Dependency, Boolean> _function_8 = (Dependency it) -> {
            return Boolean.valueOf(TmscQueries.isAfter(it.getSource(), to));
          };
          final Consumer<Dependency> _function_9 = (Dependency d) -> {
            adjecantDependencies.add(d);
            Event _source = d.getSource();
            eventsToProcess.add(_source);
          };
          IterableExtensions.<Dependency>filter(IterableExtensions.<Dependency>reject(IterableExtensions.<Dependency>reject(tmsc.getIncomingDependencies(event), _function_7), _function_8), ((Function1<? super Dependency, Boolean>)predicate)).forEach(_function_9);
        }
      }
    }
    return adjecantDependencies;
  }
  
  private static boolean isBefore(final Event event, final Event anchor) {
    boolean _switchResult = false;
    boolean _matched = false;
    Lifeline _lifeline = event.getLifeline();
    Lifeline _lifeline_1 = anchor.getLifeline();
    boolean _tripleNotEquals = (_lifeline != _lifeline_1);
    if (_tripleNotEquals) {
      _matched=true;
      _switchResult = false;
    }
    if (!_matched) {
      Long _timestamp = event.getTimestamp();
      Long _timestamp_1 = anchor.getTimestamp();
      boolean _equals = Objects.equal(_timestamp, _timestamp_1);
      if (_equals) {
        _matched=true;
        int _lifelineIndex = TmscQueries.getLifelineIndex(event);
        int _lifelineIndex_1 = TmscQueries.getLifelineIndex(anchor);
        _switchResult = (_lifelineIndex < _lifelineIndex_1);
      }
    }
    if (!_matched) {
      Long _timestamp_2 = event.getTimestamp();
      Long _timestamp_3 = anchor.getTimestamp();
      _switchResult = (_timestamp_2.compareTo(_timestamp_3) < 0);
    }
    return _switchResult;
  }
  
  private static boolean isAfter(final Event event, final Event anchor) {
    boolean _switchResult = false;
    boolean _matched = false;
    Lifeline _lifeline = event.getLifeline();
    Lifeline _lifeline_1 = anchor.getLifeline();
    boolean _tripleNotEquals = (_lifeline != _lifeline_1);
    if (_tripleNotEquals) {
      _matched=true;
      _switchResult = false;
    }
    if (!_matched) {
      Long _timestamp = event.getTimestamp();
      Long _timestamp_1 = anchor.getTimestamp();
      boolean _equals = Objects.equal(_timestamp, _timestamp_1);
      if (_equals) {
        _matched=true;
        int _lifelineIndex = TmscQueries.getLifelineIndex(event);
        int _lifelineIndex_1 = TmscQueries.getLifelineIndex(anchor);
        _switchResult = (_lifelineIndex > _lifelineIndex_1);
      }
    }
    if (!_matched) {
      Long _timestamp_2 = event.getTimestamp();
      Long _timestamp_3 = anchor.getTimestamp();
      _switchResult = (_timestamp_2.compareTo(_timestamp_3) > 0);
    }
    return _switchResult;
  }
  
  private static int getLifelineIndex(final Event event) {
    return event.getLifeline().getEvents().indexOf(event);
  }
  
  /**
   * Group dependencies to disjunct TMSCs (as groups of dependencies): <ol>
   * <li>When source and target of a dependency do not belong to an TMSC, assign the dependency to a new TMSC</li>
   * <li>When source or target are part of the same TMSC, then the dependency belongs to that TMSC as well</li>
   * <li>When both assigned to different TMSCs then copy the dependencies of one TMSC to the other</li>
   * </ol>
   */
  public static List<List<Dependency>> findDisjunctTMSCs(final Iterable<? extends Dependency> dependencies) {
    final Map<Event, List<Dependency>> event2tmsc = CollectionLiterals.<Event, List<Dependency>>newLinkedHashMap();
    for (final Dependency dependency : dependencies) {
      {
        final List<Dependency> sourceTmsc = event2tmsc.get(dependency.getSource());
        final List<Dependency> targetTmsc = event2tmsc.get(dependency.getTarget());
        if (((sourceTmsc != null) && (targetTmsc != null))) {
          if ((sourceTmsc == targetTmsc)) {
            sourceTmsc.add(dependency);
          } else {
            int _size = sourceTmsc.size();
            int _size_1 = targetTmsc.size();
            boolean _lessThan = (_size < _size_1);
            if (_lessThan) {
              Iterables.<Dependency>addAll(targetTmsc, sourceTmsc);
              targetTmsc.add(dependency);
              final Function1<Dependency, Event> _function = (Dependency it) -> {
                return it.getSource();
              };
              final Function1<Dependency, Event> _function_1 = (Dependency it) -> {
                return it.getTarget();
              };
              final Consumer<Event> _function_2 = (Event e) -> {
                event2tmsc.put(e, targetTmsc);
              };
              Queries.<Event>union(ListExtensions.<Dependency, Event>map(sourceTmsc, _function), ListExtensions.<Dependency, Event>map(sourceTmsc, _function_1)).forEach(_function_2);
            } else {
              Iterables.<Dependency>addAll(sourceTmsc, targetTmsc);
              sourceTmsc.add(dependency);
              final Function1<Dependency, Event> _function_3 = (Dependency it) -> {
                return it.getSource();
              };
              final Function1<Dependency, Event> _function_4 = (Dependency it) -> {
                return it.getTarget();
              };
              final Consumer<Event> _function_5 = (Event e) -> {
                event2tmsc.put(e, sourceTmsc);
              };
              Queries.<Event>union(ListExtensions.<Dependency, Event>map(targetTmsc, _function_3), ListExtensions.<Dependency, Event>map(targetTmsc, _function_4)).forEach(_function_5);
            }
          }
        } else {
          if ((sourceTmsc != null)) {
            sourceTmsc.add(dependency);
            event2tmsc.put(dependency.getTarget(), sourceTmsc);
          } else {
            if ((targetTmsc != null)) {
              targetTmsc.add(dependency);
              event2tmsc.put(dependency.getSource(), targetTmsc);
            } else {
              final ArrayList<Dependency> tmsc = CollectionLiterals.<Dependency>newArrayList(dependency);
              event2tmsc.put(dependency.getSource(), tmsc);
              event2tmsc.put(dependency.getTarget(), tmsc);
            }
          }
        }
      }
    }
    return IterableExtensions.<List<Dependency>>toList(Queries.<List<Dependency>>unique(event2tmsc.values(), false));
  }
  
  /**
   * Group dependencies to disjunct TMSCs (as groups of dependencies): <ol>
   * <li>When source and target of a dependency do not belong to an TMSC, assign the dependency to a new TMSC</li>
   * <li>When source or target are part of the same TMSC, then the dependency belongs to that TMSC as well</li>
   * <li>When both assigned to different TMSCs then copy the dependencies of one TMSC to the other</li>
   * </ol>
   * In addition, {@link Event events} that match the <tt>predicate</tt> are also considered to be both initial and final events.
   */
  public static List<List<Dependency>> findDisjunctTMSCs(final Iterable<? extends Dependency> dependencies, final Predicate<? super Event> predicate) {
    final Map<Event, List<Dependency>> sourceEvent2tmsc = CollectionLiterals.<Event, List<Dependency>>newLinkedHashMap();
    final Map<Event, List<Dependency>> targetEvent2tmsc = CollectionLiterals.<Event, List<Dependency>>newLinkedHashMap();
    for (final Dependency dependency : dependencies) {
      {
        final List<Dependency> sourceTmsc = sourceEvent2tmsc.get(dependency.getSource());
        final List<Dependency> targetTmsc = targetEvent2tmsc.get(dependency.getTarget());
        final boolean sourceInitial = predicate.test(dependency.getSource());
        final boolean targetFinal = predicate.test(dependency.getTarget());
        if (((sourceTmsc != null) && (targetTmsc != null))) {
          if ((sourceTmsc == targetTmsc)) {
            sourceTmsc.add(dependency);
          } else {
            Iterables.<Dependency>addAll(sourceTmsc, targetTmsc);
            sourceTmsc.add(dependency);
            final Function1<Map.Entry<Event, List<Dependency>>, Boolean> _function = (Map.Entry<Event, List<Dependency>> it) -> {
              List<Dependency> _value = it.getValue();
              return Boolean.valueOf((_value == targetTmsc));
            };
            final Consumer<Map.Entry<Event, List<Dependency>>> _function_1 = (Map.Entry<Event, List<Dependency>> it) -> {
              it.setValue(sourceTmsc);
            };
            IterableExtensions.<Map.Entry<Event, List<Dependency>>>filter(sourceEvent2tmsc.entrySet(), _function).forEach(_function_1);
            final Function1<Map.Entry<Event, List<Dependency>>, Boolean> _function_2 = (Map.Entry<Event, List<Dependency>> it) -> {
              List<Dependency> _value = it.getValue();
              return Boolean.valueOf((_value == targetTmsc));
            };
            final Consumer<Map.Entry<Event, List<Dependency>>> _function_3 = (Map.Entry<Event, List<Dependency>> it) -> {
              it.setValue(sourceTmsc);
            };
            IterableExtensions.<Map.Entry<Event, List<Dependency>>>filter(targetEvent2tmsc.entrySet(), _function_2).forEach(_function_3);
          }
        } else {
          if ((sourceTmsc != null)) {
            sourceTmsc.add(dependency);
            targetEvent2tmsc.put(dependency.getTarget(), sourceTmsc);
            if ((!targetFinal)) {
              sourceEvent2tmsc.put(dependency.getTarget(), sourceTmsc);
            }
          } else {
            if ((targetTmsc != null)) {
              targetTmsc.add(dependency);
              sourceEvent2tmsc.put(dependency.getSource(), targetTmsc);
              if ((!sourceInitial)) {
                targetEvent2tmsc.put(dependency.getSource(), targetTmsc);
              }
            } else {
              final ArrayList<Dependency> tmsc = CollectionLiterals.<Dependency>newArrayList(dependency);
              sourceEvent2tmsc.put(dependency.getSource(), tmsc);
              if ((!sourceInitial)) {
                targetEvent2tmsc.put(dependency.getSource(), tmsc);
              }
              targetEvent2tmsc.put(dependency.getTarget(), tmsc);
              if ((!targetFinal)) {
                sourceEvent2tmsc.put(dependency.getTarget(), tmsc);
              }
            }
          }
        }
      }
    }
    return IterableExtensions.<List<Dependency>>toList(Queries.<List<Dependency>>unique(Queries.<List<Dependency>>union(sourceEvent2tmsc.values(), targetEvent2tmsc.values()), false));
  }
  
  /**
   * Trims a TMSC, removing all events at the border that match the <tt>predicate</tt>.
   */
  public static Set<Dependency> trim(@Extension final ITMSC tmsc, final Predicate<? super Event> predicate) {
    final Function1<Event, Collection<Dependency>> _function = (Event it) -> {
      return tmsc.getOutgoingDependencies(it);
    };
    final Function1<Dependency, Iterable<? extends Dependency>> _function_1 = (Dependency it) -> {
      return tmsc.getOutgoingDependencies(it.getTarget());
    };
    final Function1<Dependency, Boolean> _function_2 = (Dependency it) -> {
      boolean _test = predicate.test(it.getSource());
      return Boolean.valueOf((!_test));
    };
    final BranchIterable<Dependency> leadingDependencies = Queries.<Dependency>until(Queries.<Dependency>closure(IterableExtensions.<Event, Dependency>flatMap(tmsc.getInitialEvents(), _function), true, _function_1), _function_2);
    final Function1<Event, Collection<Dependency>> _function_3 = (Event it) -> {
      return tmsc.getIncomingDependencies(it);
    };
    final Function1<Dependency, Iterable<? extends Dependency>> _function_4 = (Dependency it) -> {
      return tmsc.getIncomingDependencies(it.getSource());
    };
    final Function1<Dependency, Boolean> _function_5 = (Dependency it) -> {
      boolean _test = predicate.test(it.getTarget());
      return Boolean.valueOf((!_test));
    };
    final BranchIterable<Dependency> trailingDependencies = Queries.<Dependency>until(Queries.<Dependency>closure(IterableExtensions.<Event, Dependency>flatMap(tmsc.getFinalEvents(), _function_3), true, _function_4), _function_5);
    Collection<Dependency> _dependencies = tmsc.getDependencies();
    final LinkedHashSet<Dependency> trimmedDependencies = new LinkedHashSet<Dependency>(_dependencies);
    CollectionExtensions.<Dependency>removeAll(trimmedDependencies, leadingDependencies);
    CollectionExtensions.<Dependency>removeAll(trimmedDependencies, trailingDependencies);
    return trimmedDependencies;
  }
  
  /**
   * Returns all dependencies (including <code>dependency</code>) of the same type (i.e.
   * same {@link EObject#eClass() eClass}) between the source lifeline and target
   * lifeline of <code>dependency</code>.
   */
  public static <T extends Dependency> Iterable<T> findAllOfTypeBetweenLifelines(final T dependency) {
    final Function1<Event, EList<Dependency>> _function = (Event it) -> {
      return it.getFullScopeOutgoingDependencies();
    };
    final Function1<Dependency, Boolean> _function_1 = (Dependency it) -> {
      return Boolean.valueOf((Objects.equal(it.eClass(), dependency.eClass()) && Objects.equal(it.getTarget().getLifeline(), dependency.getTarget().getLifeline())));
    };
    Iterable<Dependency> _filter = IterableExtensions.<Dependency>filter(IterableExtensions.<Event, Dependency>flatMap(dependency.getSource().getLifeline().getEvents(), _function), _function_1);
    return ((Iterable<T>) _filter);
  }
  
  /**
   * Returns all executions with the same {@link Execution#getFunction() function}
   * for the same {@link Execution#getComponent() component}
   */
  public static Iterable<Execution> findAllWithFunctionAndComponent(final Execution execution) {
    final Function1<Lifeline, EList<Execution>> _function = (Lifeline it) -> {
      return it.getExecutions();
    };
    final Function1<Execution, Boolean> _function_1 = (Execution it) -> {
      return Boolean.valueOf((Objects.equal(it.getFunction(), execution.getFunction()) && Objects.equal(it.getComponent(), execution.getComponent())));
    };
    return IterableExtensions.<Execution>filter(IterableExtensions.<Lifeline, Execution>flatMap(execution.getTmsc().getLifelines(), _function), _function_1);
  }
  
  /**
   * Returns all executions with the same {@link Execution#getFunction() function}
   * for the same {@link Execution#getLifeline() lifeline}
   */
  public static Iterable<Execution> findAllWithFunctionAndLifeline(final Execution execution) {
    final Function1<Execution, Boolean> _function = (Execution it) -> {
      nl.esi.pps.architecture.implemented.Function _function_1 = it.getFunction();
      nl.esi.pps.architecture.implemented.Function _function_2 = execution.getFunction();
      return Boolean.valueOf(Objects.equal(_function_1, _function_2));
    };
    return IterableExtensions.<Execution>filter(execution.getLifeline().getExecutions(), _function);
  }
  
  /**
   * Convenience method for creating {@link ITMSC} instances that are required by some queries.
   */
  public static TmscQueries.CachedQueryTMSC createCachedQueryTMSC(final Iterable<? extends Dependency> cacheDependencies, final Event... cacheOrigin) {
    TmscQueries.CachedQueryTMSC _cachedQueryTMSC = new TmscQueries.CachedQueryTMSC(cacheDependencies);
    final Procedure1<TmscQueries.CachedQueryTMSC> _function = (TmscQueries.CachedQueryTMSC cache) -> {
      Iterables.<Event>addAll(cache.origin, ((Iterable<? extends Event>)Conversions.doWrapArray(cacheOrigin)));
    };
    return ObjectExtensions.<TmscQueries.CachedQueryTMSC>operator_doubleArrow(_cachedQueryTMSC, _function);
  }
  
  /**
   * Convenience method for creating {@link ITMSC} instances that are required by some queries.
   */
  public static TmscQueries.CachedQueryTMSC createCachedQueryTMSC(final Iterable<? extends Dependency> cacheDependencies, final CharSequence cacheName, final Event... cacheOrigin) {
    TmscQueries.CachedQueryTMSC _cachedQueryTMSC = new TmscQueries.CachedQueryTMSC(cacheDependencies);
    final Procedure1<TmscQueries.CachedQueryTMSC> _function = (TmscQueries.CachedQueryTMSC cache) -> {
      cache.name = cacheName.toString();
      Iterables.<Event>addAll(cache.origin, ((Iterable<? extends Event>)Conversions.doWrapArray(cacheOrigin)));
    };
    return ObjectExtensions.<TmscQueries.CachedQueryTMSC>operator_doubleArrow(_cachedQueryTMSC, _function);
  }
  
  /**
   * Convenience method for creating a {@link ScopedTMSC} instance, that does two things:
   * <ol>
   * <li>Ensures a valid {@code scopeName}, see {@link #toEID(CharSequence)}</li>
   * <li>Applies a performance improvement in adding dependencies</li>
   * </ol>
   * Please note that the resulting {@link ScopedTMSC} is not yet {@link TMSC#getChildScopes() contained}.
   */
  public static ScopedTMSC createScopedTMSC(final Iterable<? extends Dependency> scopeDependencies, final CharSequence scopeName, final Event... scopeOrigin) {
    ScopedTMSC _createScopedTMSC = TmscFactory.eINSTANCE.createScopedTMSC();
    final Procedure1<ScopedTMSC> _function = (ScopedTMSC it) -> {
      it.setName(TmscQueries.toEID(scopeName));
      EList<Event> _origin = it.getOrigin();
      Iterables.<Event>addAll(_origin, ((Iterable<? extends Event>)Conversions.doWrapArray(scopeOrigin)));
      if ((scopeDependencies instanceof Collection)) {
        it.getDependencies().addAll(((Collection<? extends Dependency>)scopeDependencies));
      } else {
        it.getDependencies().addAll(IterableExtensions.toList(scopeDependencies));
      }
    };
    return ObjectExtensions.<ScopedTMSC>operator_doubleArrow(_createScopedTMSC, _function);
  }
  
  /**
   * Adding a {@code child} scope might require to add (new) dependencies
   * to the {@code parent} TMSC and its ancestors.
   * Only the added dependencies are returned.
   */
  public static Set<Dependency> addScopedTMSC(final TMSC parent, final ScopedTMSC child) {
    EList<ScopedTMSC> _childScopes = parent.getChildScopes();
    _childScopes.add(child);
    return TmscQueries.<Dependency>addDependencies(parent, child.getDependencies());
  }
  
  /**
   * Adds dependencies to a TMSC and its ancestors, only if they are not yet added.
   * Only the added dependencies are returned.
   */
  public static <T extends Dependency> Set<T> addDependencies(final TMSC tmsc, final Iterable<T> dependencies) {
    final LinkedHashSet<T> dependenciesToAdd = Sets.<T>newLinkedHashSet(dependencies);
    dependenciesToAdd.removeAll(tmsc.getDependencies());
    boolean _isEmpty = dependenciesToAdd.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      Collection<Dependency> _dependencies = tmsc.getDependencies();
      Iterables.<Dependency>addAll(_dependencies, dependenciesToAdd);
      if ((tmsc instanceof ScopedTMSC)) {
        TMSC _parentScope = ((ScopedTMSC)tmsc).getParentScope();
        boolean _tripleNotEquals = (_parentScope != null);
        if (_tripleNotEquals) {
          TmscQueries.<T>addDependencies(((ScopedTMSC)tmsc).getParentScope(), dependenciesToAdd);
        }
      }
    }
    return dependenciesToAdd;
  }
  
  /**
   * An performance optimized version of {@code event.getScopes().contains(tmsc)}.
   */
  public static boolean isInScope(final Event event, final ScopedTMSC tmsc) {
    final Function1<Dependency, Boolean> _function = (Dependency it) -> {
      return Boolean.valueOf(it.getScopes().contains(tmsc));
    };
    return IterableExtensions.<Dependency>exists(Queries.<Dependency>union(event.getFullScopeIncomingDependencies(), event.getFullScopeOutgoingDependencies()), _function);
  }
  
  public static void disposeTemp(final ScopedTMSC tmsc, final boolean disposeTempDependencies) {
    EObject _eContainer = tmsc.eContainer();
    boolean _tripleNotEquals = (_eContainer != null);
    if (_tripleNotEquals) {
      throw new IllegalArgumentException(
        "This method is only intended for temporary TMCSs that are not added to the model yet");
    }
    List<Dependency> _xifexpression = null;
    if (disposeTempDependencies) {
      final Function1<Dependency, Boolean> _function = (Dependency it) -> {
        EObject _eContainer_1 = it.eContainer();
        return Boolean.valueOf((_eContainer_1 == null));
      };
      _xifexpression = IterableExtensions.<Dependency>toList(IterableExtensions.<Dependency>filter(tmsc.getDependencies(), _function));
    } else {
      _xifexpression = Collections.<Dependency>emptyList();
    }
    final List<Dependency> tempDependencies = _xifexpression;
    final Function1<ScopedTMSC, Iterable<? extends ScopedTMSC>> _function_1 = (ScopedTMSC it) -> {
      return it.getChildScopes();
    };
    final Consumer<ScopedTMSC> _function_2 = (ScopedTMSC it) -> {
      it.getDependencies().clear();
    };
    Queries.<ScopedTMSC>closure(Collections.<ScopedTMSC>singleton(tmsc), true, _function_1).forEach(_function_2);
    final Consumer<Dependency> _function_3 = (Dependency it) -> {
      TmscQueries.disposeTemp(it);
    };
    tempDependencies.forEach(_function_3);
  }
  
  public static void disposeTemp(final Iterable<? extends Dependency> dependencies) {
    final Function1<Dependency, Boolean> _function = (Dependency it) -> {
      EObject _eContainer = it.eContainer();
      return Boolean.valueOf((_eContainer == null));
    };
    final List<? extends Dependency> tempDependencies = IterableExtensions.toList(IterableExtensions.filter(dependencies, _function));
    final Function1<Dependency, List<Pair<ScopedTMSC, Dependency>>> _function_1 = (Dependency d) -> {
      final Function1<ScopedTMSC, Pair<ScopedTMSC, Dependency>> _function_2 = (ScopedTMSC s) -> {
        return Pair.<ScopedTMSC, Dependency>of(s, d);
      };
      return ListExtensions.<ScopedTMSC, Pair<ScopedTMSC, Dependency>>map(d.getScopes(), _function_2);
    };
    final Function1<Pair<ScopedTMSC, Dependency>, ScopedTMSC> _function_2 = (Pair<ScopedTMSC, Dependency> it) -> {
      return it.getKey();
    };
    final Function1<Pair<ScopedTMSC, Dependency>, Dependency> _function_3 = (Pair<ScopedTMSC, Dependency> it) -> {
      return it.getValue();
    };
    final Map<ScopedTMSC, List<Dependency>> tempDependenciesPerScope = Queries.<Pair<ScopedTMSC, Dependency>, ScopedTMSC, Dependency>groupBy(Queries.collect(tempDependencies, _function_1), _function_2, _function_3);
    final BiConsumer<ScopedTMSC, List<Dependency>> _function_4 = (ScopedTMSC s, List<Dependency> d) -> {
      s.getDependencies().removeAll(d);
    };
    tempDependenciesPerScope.forEach(_function_4);
    final Consumer<Dependency> _function_5 = (Dependency it) -> {
      TmscQueries.disposeTemp(it);
    };
    tempDependencies.forEach(_function_5);
  }
  
  public static void disposeTemp(final Dependency dependency) {
    EObject _eContainer = dependency.eContainer();
    boolean _tripleNotEquals = (_eContainer != null);
    if (_tripleNotEquals) {
      throw new IllegalArgumentException(
        "This method is only intended for temporary dependencies that are not added to the model yet");
    }
    final Function1<EStructuralFeature, Boolean> _function = (EStructuralFeature it) -> {
      return Boolean.valueOf(it.isChangeable());
    };
    final Consumer<EStructuralFeature> _function_1 = (EStructuralFeature f) -> {
      dependency.eUnset(f);
    };
    IterableExtensions.<EStructuralFeature>filter(dependency.eClass().getEAllStructuralFeatures(), _function).forEach(_function_1);
  }
  
  public static BranchIterable<Event> getPreviousEventsOnLifeline(final Event event) {
    final Function1<Event, Event> _function = (Event it) -> {
      LifelineSegment _incomingLifelineSegment = TmscQueries.getIncomingLifelineSegment(it);
      Event _source = null;
      if (_incomingLifelineSegment!=null) {
        _source=_incomingLifelineSegment.getSource();
      }
      return _source;
    };
    return Queries.<Event>climbTree(Collections.<Event>singleton(event), _function);
  }
  
  public static LifelineSegment getIncomingLifelineSegment(final Event event) {
    return TmscQueries.<LifelineSegment>getAtMostOne(Iterables.<LifelineSegment>filter(event.getFullScopeIncomingDependencies(), LifelineSegment.class));
  }
  
  public static BranchIterable<Event> getNextEventsOnLifeline(final Event event) {
    final Function1<Event, Event> _function = (Event it) -> {
      LifelineSegment _outgoingLifelineSegment = TmscQueries.getOutgoingLifelineSegment(it);
      Event _target = null;
      if (_outgoingLifelineSegment!=null) {
        _target=_outgoingLifelineSegment.getTarget();
      }
      return _target;
    };
    return Queries.<Event>climbTree(Collections.<Event>singleton(event), _function);
  }
  
  public static LifelineSegment getOutgoingLifelineSegment(final Event event) {
    return TmscQueries.<LifelineSegment>getAtMostOne(Iterables.<LifelineSegment>filter(event.getFullScopeOutgoingDependencies(), LifelineSegment.class));
  }
  
  public static <T extends Object> T getAtMostOne(final Iterable<T> source) {
    final Iterator<T> iterator = source.iterator();
    boolean _hasNext = iterator.hasNext();
    if (_hasNext) {
      final T result = iterator.next();
      boolean _hasNext_1 = iterator.hasNext();
      if (_hasNext_1) {
        throw new IllegalArgumentException(("Expected at most 1 element: " + source));
      }
      return result;
    } else {
      return null;
    }
  }
  
  public static void shiftTime(final FullScopeTMSC tmsc, final long delta) {
    final Function1<Event, Boolean> _function = (Event it) -> {
      Long _timestamp = it.getTimestamp();
      return Boolean.valueOf((_timestamp == null));
    };
    final Consumer<Event> _function_1 = (Event it) -> {
      Long _timestamp = it.getTimestamp();
      long _plus = ((_timestamp).longValue() + delta);
      it.setTimestamp(Long.valueOf(_plus));
    };
    IterableExtensions.<Event>reject(tmsc.getEvents(), _function).forEach(_function_1);
    Long _startTime = tmsc.getStartTime();
    long _plus = ((_startTime).longValue() + delta);
    tmsc.setStartTime(Long.valueOf(_plus));
    Long _endTime = tmsc.getEndTime();
    long _plus_1 = ((_endTime).longValue() + delta);
    tmsc.setEndTime(Long.valueOf(_plus_1));
  }
}
