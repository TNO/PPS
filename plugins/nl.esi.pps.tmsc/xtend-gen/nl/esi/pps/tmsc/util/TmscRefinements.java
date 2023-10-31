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
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import nl.esi.pps.architecture.implemented.Function;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.EntryEvent;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.ExitEvent;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.Lifeline;
import nl.esi.pps.tmsc.LifelineSegment;
import nl.esi.pps.tmsc.TmscFactory;
import org.apache.commons.lang3.tuple.Pair;
import org.eclipse.emf.common.util.EList;
import org.eclipse.lsat.common.util.PairwiseIterable;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public final class TmscRefinements {
  @Extension
  private static final TmscFactory m_tmsc = TmscFactory.eINSTANCE;
  
  private TmscRefinements() {
  }
  
  /**
   * This method adds {@link LifelineSegment lifeline-segments} to guarantee the
   * order of events on a {@link Lifeline}.<br>
   * This method requires that the {@link Lifeline#getEvents() events on a lifeline}
   * are ordered in the execution order that they occur.
   */
  public static void refineWithCompleteOrder(final FullScopeTMSC tmsc) {
    final Consumer<Lifeline> _function = (Lifeline it) -> {
      TmscRefinements.refineWithCompleteOrder(it);
    };
    tmsc.getLifelines().forEach(_function);
  }
  
  /**
   * This method adds {@link LifelineSegment lifeline-segments} to guarantee the
   * order of events on a {@link Lifeline}.<br>
   * This method requires that the {@link Lifeline#getEvents() events on a lifeline}
   * are ordered in the execution order that they occur.
   */
  public static void refineWithCompleteOrder(final Lifeline lifeline) {
    EList<Dependency> _dependencies = lifeline.getTmsc().getDependencies();
    final Function1<Pair<Event, Event>, Boolean> _function = (Pair<Event, Event> it) -> {
      return Boolean.valueOf(TmscRefinements.lifelineSegmentExists(it.getLeft(), it.getRight()));
    };
    final Function1<Pair<Event, Event>, LifelineSegment> _function_1 = (Pair<Event, Event> pair) -> {
      LifelineSegment _createLifelineSegment = TmscRefinements.m_tmsc.createLifelineSegment();
      final Procedure1<LifelineSegment> _function_2 = (LifelineSegment it) -> {
        it.setSource(pair.getLeft());
        it.setTarget(pair.getRight());
      };
      return ObjectExtensions.<LifelineSegment>operator_doubleArrow(_createLifelineSegment, _function_2);
    };
    Iterable<LifelineSegment> _map = IterableExtensions.<Pair<Event, Event>, LifelineSegment>map(IterableExtensions.<Pair<Event, Event>>reject(PairwiseIterable.<Event>of(lifeline.getEvents()), _function), _function_1);
    Iterables.<Dependency>addAll(_dependencies, _map);
  }
  
  private static boolean lifelineSegmentExists(final Event _source, final Event _target) {
    final Function1<LifelineSegment, Boolean> _function = (LifelineSegment it) -> {
      Event _source_1 = it.getSource();
      return Boolean.valueOf(Objects.equal(_source_1, _source));
    };
    return IterableExtensions.<LifelineSegment>exists(Iterables.<LifelineSegment>filter(_target.getFullScopeIncomingDependencies(), LifelineSegment.class), _function);
  }
  
  /**
   * This method adds {@link Execution executions} to a {@link Lifeline} that
   * represent call-stacks over time.<br>
   * This method requires that the {@link Lifeline#getEvents() events on a lifeline}
   * are ordered in the execution order that they occur.
   */
  public static void refineWithCallStacks(final FullScopeTMSC tmsc) {
    final Consumer<Lifeline> _function = (Lifeline it) -> {
      TmscRefinements.refineWithCallStacks(it);
    };
    tmsc.getLifelines().forEach(_function);
  }
  
  /**
   * This method adds {@link Execution executions} to a {@link Lifeline} that
   * represent call-stacks over time.<br>
   * This method requires that the {@link Lifeline#getEvents() events on a lifeline}
   * are ordered in the execution order that they occur.
   */
  public static void refineWithCallStacks(final Lifeline lifeline) {
    boolean _isEmpty = lifeline.getExecutions().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      throw new IllegalArgumentException("Programming error: please remove all executions before calling this method");
    }
    Execution currentExecution = null;
    List<Execution> rootExecutions = CollectionLiterals.<Execution>newLinkedList();
    EList<Event> _events = lifeline.getEvents();
    ArrayList<Event> _arrayList = new ArrayList<Event>(_events);
    for (final Event event : _arrayList) {
      boolean _matched = false;
      if (event instanceof EntryEvent) {
        _matched=true;
        final Execution execution = TmscRefinements.m_tmsc.createExecution();
        EList<Execution> _executions = lifeline.getExecutions();
        _executions.add(execution);
        execution.setEntry(((EntryEvent)event));
        execution.setParent(currentExecution);
        Execution _parent = execution.getParent();
        boolean _tripleEquals = (_parent == null);
        if (_tripleEquals) {
          rootExecutions.add(execution);
        }
        currentExecution = execution;
      }
      if (!_matched) {
        if (event instanceof ExitEvent) {
          _matched=true;
          boolean _matched_1 = false;
          if (Objects.equal(currentExecution, null)) {
            _matched_1=true;
            final Execution execution = TmscRefinements.m_tmsc.createExecution();
            EList<Execution> _executions = lifeline.getExecutions();
            _executions.add(execution);
            execution.setExit(((ExitEvent)event));
            EList<Execution> _children = execution.getChildren();
            Iterables.<Execution>addAll(_children, rootExecutions);
            rootExecutions = CollectionLiterals.<Execution>newLinkedList(execution);
            execution.setEntry(TmscRefinements.m_tmsc.createEntryEvent());
            EntryEvent _entry = execution.getEntry();
            _entry.setTraced(false);
            EntryEvent _entry_1 = execution.getEntry();
            _entry_1.setTimestamp(lifeline.getTmsc().getStartTime());
            EntryEvent _entry_2 = execution.getEntry();
            _entry_2.setComponent(((ExitEvent)event).getComponent());
            EntryEvent _entry_3 = execution.getEntry();
            _entry_3.setFunction(((ExitEvent)event).getFunction());
            EList<Dependency> _dependencies = lifeline.getTmsc().getDependencies();
            LifelineSegment _createLifelineSegment = TmscRefinements.m_tmsc.createLifelineSegment();
            final Procedure1<LifelineSegment> _function = (LifelineSegment it) -> {
              it.setSource(execution.getEntry());
              it.setTarget(IterableExtensions.<Event>head(lifeline.getEvents()));
            };
            LifelineSegment _doubleArrow = ObjectExtensions.<LifelineSegment>operator_doubleArrow(_createLifelineSegment, _function);
            _dependencies.add(_doubleArrow);
            lifeline.getEvents().add(0, execution.getEntry());
          }
          if (!_matched_1) {
            Function _function_1 = currentExecution.getFunction();
            Function _function_2 = ((ExitEvent)event).getFunction();
            boolean _notEquals = (!Objects.equal(_function_1, _function_2));
            if (_notEquals) {
              _matched_1=true;
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("Expected function ");
              Function _function_3 = ((ExitEvent)event).getFunction();
              _builder.append(_function_3);
              _builder.append(", but was ");
              Function _function_4 = currentExecution.getFunction();
              _builder.append(_function_4);
              _builder.append(". This could be caused by dropped events or to incorrect ordering of events.");
              throw new IllegalStateException(_builder.toString());
            }
          }
          if (!_matched_1) {
            {
              currentExecution.setExit(((ExitEvent)event));
              currentExecution = currentExecution.getParent();
            }
          }
        }
      }
    }
    boolean _isEmpty_1 = rootExecutions.isEmpty();
    boolean _not_1 = (!_isEmpty_1);
    if (_not_1) {
      TmscRefinements.createExitEvent(IterableExtensions.<Execution>last(rootExecutions));
    }
  }
  
  private static ExitEvent createExitEvent(final Execution execution) {
    ExitEvent _exit = execution.getExit();
    boolean _tripleNotEquals = (_exit != null);
    if (_tripleNotEquals) {
      return execution.getExit();
    }
    Event _xifexpression = null;
    boolean _isEmpty = execution.getChildren().isEmpty();
    if (_isEmpty) {
      _xifexpression = execution.getEntry();
    } else {
      _xifexpression = TmscRefinements.createExitEvent(IterableExtensions.<Execution>last(execution.getChildren()));
    }
    final Event lifelineSegmentSource = _xifexpression;
    execution.setExit(TmscRefinements.m_tmsc.createExitEvent());
    ExitEvent _exit_1 = execution.getExit();
    _exit_1.setTraced(false);
    ExitEvent _exit_2 = execution.getExit();
    _exit_2.setTimestamp(execution.getTmsc().getEndTime());
    ExitEvent _exit_3 = execution.getExit();
    _exit_3.setComponent(execution.getEntry().getComponent());
    ExitEvent _exit_4 = execution.getExit();
    _exit_4.setFunction(execution.getEntry().getFunction());
    EList<Event> _events = execution.getLifeline().getEvents();
    ExitEvent _exit_5 = execution.getExit();
    _events.add(_exit_5);
    EList<Dependency> _dependencies = execution.getTmsc().getDependencies();
    LifelineSegment _createLifelineSegment = TmscRefinements.m_tmsc.createLifelineSegment();
    final Procedure1<LifelineSegment> _function = (LifelineSegment it) -> {
      it.setSource(lifelineSegmentSource);
      it.setTarget(execution.getExit());
    };
    LifelineSegment _doubleArrow = ObjectExtensions.<LifelineSegment>operator_doubleArrow(_createLifelineSegment, _function);
    _dependencies.add(_doubleArrow);
    return execution.getExit();
  }
}
