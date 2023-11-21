/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.viewers;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import nl.esi.pps.architecture.deployed.Host;
import nl.esi.pps.architecture.implemented.Function;
import nl.esi.pps.architecture.instantiated.Executor;
import nl.esi.pps.architecture.instantiated.ExecutorGroup;
import nl.esi.pps.architecture.specified.Component;
import nl.esi.pps.architecture.specified.Interface;
import nl.esi.pps.architecture.specified.Operation;
import nl.esi.pps.common.emf.ui.ContextAwareAdapterFactoryContentProvider;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.Interval;
import nl.esi.pps.tmsc.Lifeline;
import nl.esi.pps.tmsc.LifelineSegment;
import nl.esi.pps.tmsc.ScopedTMSC;
import nl.esi.pps.tmsc.metric.Metric;
import nl.esi.pps.tmsc.metric.MetricInstance;
import nl.esi.pps.tmsc.util.TmscQueries;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.lsat.common.xtend.Queries;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * Content provider that queries the applicable {@link Lifeline lifelines} for
 * the current context.<br>
 */
@SuppressWarnings("all")
public class LifelineContentProvider extends ContextAwareAdapterFactoryContentProvider<Lifeline> {
  public LifelineContentProvider(final AdapterFactory adapterFactory) {
    super(adapterFactory, Lifeline.class, 
      FullScopeTMSC.class, ScopedTMSC.class, Lifeline.class, Execution.class, Event.class, Dependency.class, Interval.class, 
      ExecutorGroup.class, Executor.class, Host.class, Component.class, Function.class, Operation.class, Interface.class, 
      Metric.class, MetricInstance.class, 
      ResourceSet.class);
  }
  
  @Override
  protected void findContentWithinContext(final Object element, final Set<Lifeline> content) {
    super.findContentWithinContext(element, content);
    content.remove(null);
  }
  
  @Override
  protected void findContent(final Object context, final Set<Lifeline> content) {
    boolean _matched = false;
    if (context instanceof FullScopeTMSC) {
      _matched=true;
      EList<Lifeline> _lifelines = ((FullScopeTMSC)context).getLifelines();
      Iterables.<Lifeline>addAll(content, _lifelines);
    }
    if (!_matched) {
      if (context instanceof ScopedTMSC) {
        FullScopeTMSC _fullScope = ((ScopedTMSC)context).getFullScope();
        boolean _tripleNotEquals = (_fullScope != null);
        if (_tripleNotEquals) {
          _matched=true;
          final Function1<Lifeline, Boolean> _function = (Lifeline it) -> {
            final Function1<Event, Boolean> _function_1 = (Event it_1) -> {
              return Boolean.valueOf(TmscQueries.isInScope(it_1, ((ScopedTMSC)context)));
            };
            return Boolean.valueOf(IterableExtensions.<Event>exists(it.getEvents(), _function_1));
          };
          Iterable<Lifeline> _select = Queries.<Lifeline>select(((ScopedTMSC)context).getFullScope().getLifelines(), _function);
          Iterables.<Lifeline>addAll(content, _select);
        }
      }
    }
    if (!_matched) {
      if (context instanceof Lifeline) {
        _matched=true;
        content.add(((Lifeline)context));
        final Function1<Event, Iterable<Lifeline>> _function = (Event it) -> {
          return this.getConnectedLifelines(it);
        };
        Iterable<Lifeline> _flatMap = IterableExtensions.<Event, Lifeline>flatMap(((Lifeline)context).getEvents(), _function);
        Iterables.<Lifeline>addAll(content, _flatMap);
      }
    }
    if (!_matched) {
      if (context instanceof Execution) {
        _matched=true;
        Lifeline _lifeline = ((Execution)context).getLifeline();
        content.add(_lifeline);
        final Function1<Execution, Iterable<? extends Execution>> _function = (Execution it) -> {
          return it.getChildren();
        };
        final Function1<Execution, List<Event>> _function_1 = (Execution it) -> {
          return TmscQueries.getEvents(it);
        };
        final Function1<Event, Iterable<Lifeline>> _function_2 = (Event it) -> {
          return this.getConnectedLifelines(it);
        };
        Iterable<Lifeline> _flatMap = IterableExtensions.<Event, Lifeline>flatMap(IterableExtensions.<Execution, Event>flatMap(Queries.<Execution>walkTree(Collections.<Execution>singleton(((Execution)context)), true, _function), _function_1), _function_2);
        Iterables.<Lifeline>addAll(content, _flatMap);
      }
    }
    if (!_matched) {
      if (context instanceof Event) {
        _matched=true;
        Lifeline _lifeline = ((Event)context).getLifeline();
        content.add(_lifeline);
        Iterable<Lifeline> _connectedLifelines = this.getConnectedLifelines(((Event)context));
        Iterables.<Lifeline>addAll(content, _connectedLifelines);
      }
    }
    if (!_matched) {
      if (context instanceof Dependency) {
        _matched=true;
        Lifeline _lifeline = ((Dependency)context).getSource().getLifeline();
        content.add(_lifeline);
        Lifeline _lifeline_1 = ((Dependency)context).getTarget().getLifeline();
        content.add(_lifeline_1);
      }
    }
    if (!_matched) {
      if (context instanceof Interval) {
        _matched=true;
        Event _from = ((Interval)context).getFrom();
        Lifeline _lifeline = null;
        if (_from!=null) {
          _lifeline=_from.getLifeline();
        }
        content.add(_lifeline);
        Event _to = ((Interval)context).getTo();
        Lifeline _lifeline_1 = null;
        if (_to!=null) {
          _lifeline_1=_to.getLifeline();
        }
        content.add(_lifeline_1);
      }
    }
    if (!_matched) {
      if (context instanceof ExecutorGroup) {
        _matched=true;
        final EList<Executor> executors = ((ExecutorGroup)context).getExecutors();
        final Function1<Lifeline, Boolean> _function = (Lifeline it) -> {
          return Boolean.valueOf(executors.contains(it.getExecutor()));
        };
        Iterable<Lifeline> _filter = IterableExtensions.<Lifeline>filter(this.findLifelines(((EObject)context)), _function);
        Iterables.<Lifeline>addAll(content, _filter);
      }
    }
    if (!_matched) {
      if (context instanceof Executor) {
        _matched=true;
        final Function1<Lifeline, Boolean> _function = (Lifeline it) -> {
          Executor _executor = it.getExecutor();
          return Boolean.valueOf(Objects.equal(_executor, context));
        };
        Iterable<Lifeline> _filter = IterableExtensions.<Lifeline>filter(this.findLifelines(((EObject)context)), _function);
        Iterables.<Lifeline>addAll(content, _filter);
      }
    }
    if (!_matched) {
      if (context instanceof Host) {
        _matched=true;
        final Function1<Lifeline, Boolean> _function = (Lifeline it) -> {
          Host _host = it.getExecutor().getHost();
          return Boolean.valueOf(Objects.equal(_host, context));
        };
        Iterable<Lifeline> _filter = IterableExtensions.<Lifeline>filter(this.findLifelines(((EObject)context)), _function);
        Iterables.<Lifeline>addAll(content, _filter);
      }
    }
    if (!_matched) {
      if (context instanceof Component) {
        _matched=true;
        final Function1<Lifeline, Boolean> _function = (Lifeline it) -> {
          final Function1<Event, Boolean> _function_1 = (Event it_1) -> {
            Component _component = it_1.getComponent();
            return Boolean.valueOf(Objects.equal(_component, context));
          };
          return Boolean.valueOf(IterableExtensions.<Event>exists(it.getEvents(), _function_1));
        };
        Iterable<Lifeline> _filter = IterableExtensions.<Lifeline>filter(this.findLifelines(((EObject)context)), _function);
        Iterables.<Lifeline>addAll(content, _filter);
      }
    }
    if (!_matched) {
      if (context instanceof Function) {
        _matched=true;
        final Function1<Lifeline, Boolean> _function = (Lifeline it) -> {
          final Function1<Event, Boolean> _function_1 = (Event it_1) -> {
            Function _function_2 = it_1.getFunction();
            return Boolean.valueOf(Objects.equal(_function_2, context));
          };
          return Boolean.valueOf(IterableExtensions.<Event>exists(it.getEvents(), _function_1));
        };
        Iterable<Lifeline> _filter = IterableExtensions.<Lifeline>filter(this.findLifelines(((EObject)context)), _function);
        Iterables.<Lifeline>addAll(content, _filter);
      }
    }
    if (!_matched) {
      if (context instanceof Operation) {
        _matched=true;
        final Function1<Lifeline, Boolean> _function = (Lifeline it) -> {
          final Function1<Event, Boolean> _function_1 = (Event it_1) -> {
            Operation _operation = it_1.getFunction().getOperation();
            return Boolean.valueOf(Objects.equal(_operation, context));
          };
          return Boolean.valueOf(IterableExtensions.<Event>exists(it.getEvents(), _function_1));
        };
        Iterable<Lifeline> _filter = IterableExtensions.<Lifeline>filter(this.findLifelines(((EObject)context)), _function);
        Iterables.<Lifeline>addAll(content, _filter);
      }
    }
    if (!_matched) {
      if (context instanceof Interface) {
        _matched=true;
        final Function1<Lifeline, Boolean> _function = (Lifeline it) -> {
          final Function1<Event, Boolean> _function_1 = (Event it_1) -> {
            Operation _operation = it_1.getFunction().getOperation();
            Interface _interface = null;
            if (_operation!=null) {
              _interface=_operation.getInterface();
            }
            return Boolean.valueOf(Objects.equal(_interface, context));
          };
          return Boolean.valueOf(IterableExtensions.<Event>exists(it.getEvents(), _function_1));
        };
        Iterable<Lifeline> _filter = IterableExtensions.<Lifeline>filter(this.findLifelines(((EObject)context)), _function);
        Iterables.<Lifeline>addAll(content, _filter);
      }
    }
    if (!_matched) {
      if (context instanceof Metric) {
        _matched=true;
        final Function1<MetricInstance, Lifeline> _function = (MetricInstance it) -> {
          Event _from = it.getFrom();
          Lifeline _lifeline = null;
          if (_from!=null) {
            _lifeline=_from.getLifeline();
          }
          return _lifeline;
        };
        List<Lifeline> _map = ListExtensions.<MetricInstance, Lifeline>map(((Metric)context).getInstances(), _function);
        Iterables.<Lifeline>addAll(content, _map);
        final Function1<MetricInstance, Lifeline> _function_1 = (MetricInstance it) -> {
          Event _to = it.getTo();
          Lifeline _lifeline = null;
          if (_to!=null) {
            _lifeline=_to.getLifeline();
          }
          return _lifeline;
        };
        List<Lifeline> _map_1 = ListExtensions.<MetricInstance, Lifeline>map(((Metric)context).getInstances(), _function_1);
        Iterables.<Lifeline>addAll(content, _map_1);
      }
    }
    if (!_matched) {
      if (context instanceof ResourceSet) {
        _matched=true;
        Iterable<Lifeline> _findLifelines = this.findLifelines(((ResourceSet)context));
        Iterables.<Lifeline>addAll(content, _findLifelines);
      }
    }
    if (!_matched) {
      super.findContent(context, content);
    }
  }
  
  protected Iterable<Lifeline> getConnectedLifelines(final Event event) {
    final Function1<Dependency, Event> _function = (Dependency it) -> {
      return it.getTarget();
    };
    final Function1<Dependency, Event> _function_1 = (Dependency it) -> {
      return it.getSource();
    };
    final Iterable<Event> adjacentEvents = Queries.<Event>union(Queries.<Dependency, Event>xcollectOne(IterableExtensions.<Dependency>reject(event.getFullScopeOutgoingDependencies(), LifelineSegment.class), _function), Queries.<Dependency, Event>xcollectOne(IterableExtensions.<Dependency>reject(event.getFullScopeIncomingDependencies(), LifelineSegment.class), _function_1));
    final Function1<Event, Lifeline> _function_2 = (Event it) -> {
      return it.getLifeline();
    };
    return IterableExtensions.<Event, Lifeline>map(adjacentEvents, _function_2);
  }
  
  protected Iterable<Lifeline> findLifelines(final EObject eObject) {
    Iterable<Lifeline> _elvis = null;
    Resource _eResource = null;
    if (eObject!=null) {
      _eResource=eObject.eResource();
    }
    ResourceSet _resourceSet = null;
    if (_eResource!=null) {
      _resourceSet=_eResource.getResourceSet();
    }
    Iterable<Lifeline> _findLifelines = null;
    if (_resourceSet!=null) {
      _findLifelines=this.findLifelines(_resourceSet);
    }
    if (_findLifelines != null) {
      _elvis = _findLifelines;
    } else {
      Set<Lifeline> _emptySet = Collections.<Lifeline>emptySet();
      _elvis = _emptySet;
    }
    return _elvis;
  }
  
  protected Iterable<Lifeline> findLifelines(final ResourceSet resourceSet) {
    final Function1<Resource, EList<EObject>> _function = (Resource it) -> {
      return it.getContents();
    };
    final Function1<FullScopeTMSC, EList<Lifeline>> _function_1 = (FullScopeTMSC it) -> {
      return it.getLifelines();
    };
    return IterableExtensions.<FullScopeTMSC, Lifeline>flatMap(Iterables.<FullScopeTMSC>filter(IterableExtensions.<Resource, EObject>flatMap(resourceSet.getResources(), _function), FullScopeTMSC.class), _function_1);
  }
}
