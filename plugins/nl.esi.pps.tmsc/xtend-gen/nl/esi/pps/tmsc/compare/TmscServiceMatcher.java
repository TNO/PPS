/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.compare;

import com.google.common.base.Objects;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import nl.esi.pps.architecture.implemented.Function;
import nl.esi.pps.architecture.implemented.IPCFunction;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.ITMSC;
import nl.esi.pps.tmsc.Lifeline;
import nl.esi.pps.tmsc.util.TmscQueries;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("all")
public class TmscServiceMatcher {
  public static class Service {
    private ITMSC tmsc;
    
    private Execution rootExec;
    
    public Service(final ITMSC tmsc, final Execution exec) {
      this.tmsc = tmsc;
      this.rootExec = exec;
    }
  }
  
  @Extension
  private static final Logger LOGGER = LoggerFactory.getLogger(TmscServiceMatcher.class);
  
  private static List<TmscServiceMatcher.Service> leftServices = CollectionLiterals.<TmscServiceMatcher.Service>newLinkedList();
  
  private static List<TmscServiceMatcher.Service> rightServices = CollectionLiterals.<TmscServiceMatcher.Service>newLinkedList();
  
  private static BiMap<TmscServiceMatcher.Service, TmscServiceMatcher.Service> matchedServices = HashBiMap.<TmscServiceMatcher.Service, TmscServiceMatcher.Service>create();
  
  public static ITmscMatchResult match(final ITMSC leftTmsc, final ITMSC rightTmsc, final BiPredicate<? super Event, ? super Event> eventEquivalence) {
    final TmscMatchResult matchResult = new TmscMatchResult(leftTmsc, rightTmsc);
    final Function1<TmscServiceMatcher.Service, Boolean> _function = (TmscServiceMatcher.Service it) -> {
      return Boolean.valueOf((it.rootExec != null));
    };
    TmscServiceMatcher.leftServices = IterableExtensions.<TmscServiceMatcher.Service>toList(IterableExtensions.<TmscServiceMatcher.Service>filter(TmscServiceMatcher.serviceSegments(leftTmsc), _function));
    final Function1<TmscServiceMatcher.Service, Boolean> _function_1 = (TmscServiceMatcher.Service it) -> {
      return Boolean.valueOf((it.rootExec != null));
    };
    TmscServiceMatcher.rightServices = IterableExtensions.<TmscServiceMatcher.Service>toList(IterableExtensions.<TmscServiceMatcher.Service>filter(TmscServiceMatcher.serviceSegments(rightTmsc), _function_1));
    final Function1<TmscServiceMatcher.Service, String> _function_2 = (TmscServiceMatcher.Service it) -> {
      String _name = it.rootExec.getLifeline().getExecutor().getName();
      String _name_1 = it.rootExec.getFunction().getName();
      return (_name + _name_1);
    };
    final Map<String, List<TmscServiceMatcher.Service>> leftGroupedServices = IterableExtensions.<String, TmscServiceMatcher.Service>groupBy(TmscServiceMatcher.leftServices, _function_2);
    final Function1<TmscServiceMatcher.Service, String> _function_3 = (TmscServiceMatcher.Service it) -> {
      String _name = it.rootExec.getLifeline().getExecutor().getName();
      String _name_1 = it.rootExec.getFunction().getName();
      return (_name + _name_1);
    };
    final Map<String, List<TmscServiceMatcher.Service>> rightGroupedServices = IterableExtensions.<String, TmscServiceMatcher.Service>groupBy(TmscServiceMatcher.rightServices, _function_3);
    final List<TmscServiceMatcher.Service> leftUniqueServices = CollectionLiterals.<TmscServiceMatcher.Service>newLinkedList();
    final Function1<Map.Entry<String, List<TmscServiceMatcher.Service>>, Boolean> _function_4 = (Map.Entry<String, List<TmscServiceMatcher.Service>> it) -> {
      int _size = it.getValue().size();
      return Boolean.valueOf((_size == 1));
    };
    final Consumer<Map.Entry<String, List<TmscServiceMatcher.Service>>> _function_5 = (Map.Entry<String, List<TmscServiceMatcher.Service>> it) -> {
      leftUniqueServices.addAll(it.getValue());
    };
    IterableExtensions.<Map.Entry<String, List<TmscServiceMatcher.Service>>>filter(leftGroupedServices.entrySet(), _function_4).forEach(_function_5);
    final Comparator<TmscServiceMatcher.Service> _function_6 = (TmscServiceMatcher.Service a, TmscServiceMatcher.Service b) -> {
      return Integer.valueOf(a.tmsc.getDependencies().size()).compareTo(Integer.valueOf(b.tmsc.getDependencies().size()));
    };
    leftUniqueServices.sort(_function_6);
    final List<TmscServiceMatcher.Service> rigthUniqueServices = CollectionLiterals.<TmscServiceMatcher.Service>newLinkedList();
    final Function1<Map.Entry<String, List<TmscServiceMatcher.Service>>, Boolean> _function_7 = (Map.Entry<String, List<TmscServiceMatcher.Service>> it) -> {
      int _size = it.getValue().size();
      return Boolean.valueOf((_size == 1));
    };
    final Consumer<Map.Entry<String, List<TmscServiceMatcher.Service>>> _function_8 = (Map.Entry<String, List<TmscServiceMatcher.Service>> it) -> {
      rigthUniqueServices.addAll(it.getValue());
    };
    IterableExtensions.<Map.Entry<String, List<TmscServiceMatcher.Service>>>filter(rightGroupedServices.entrySet(), _function_7).forEach(_function_8);
    final Comparator<TmscServiceMatcher.Service> _function_9 = (TmscServiceMatcher.Service a, TmscServiceMatcher.Service b) -> {
      return Integer.valueOf(a.tmsc.getDependencies().size()).compareTo(Integer.valueOf(b.tmsc.getDependencies().size()));
    };
    rigthUniqueServices.sort(_function_9);
    final HashBiMap<Event, Event> matchedEvents = HashBiMap.<Event, Event>create();
    for (final TmscServiceMatcher.Service leftService : leftUniqueServices) {
      for (final TmscServiceMatcher.Service rightService : rigthUniqueServices) {
        TmscServiceMatcher.match(leftService, rightService, matchedEvents, eventEquivalence);
      }
    }
    final BiConsumer<Event, Event> _function_10 = (Event a, Event b) -> {
      matchResult.addMatch(a, b);
    };
    matchedEvents.forEach(_function_10);
    return matchResult;
  }
  
  private static boolean match(final TmscServiceMatcher.Service leftService, final TmscServiceMatcher.Service rigthService, final BiMap<Event, Event> matchedEvents, final BiPredicate<? super Event, ? super Event> eventEquivalence) {
    if (((leftService == null) || (rigthService == null))) {
      return false;
    }
    if (((leftService.rootExec == null) || (rigthService.rootExec == null))) {
      return false;
    }
    if (((leftService.tmsc == null) || (rigthService.tmsc == null))) {
      return false;
    }
    if ((leftService.rootExec.getComponent().getName().equals("«untraced»") || rigthService.rootExec.getComponent().getName().equals("«untraced»"))) {
      return false;
    }
    boolean _compareExecutions = TmscServiceMatcher.compareExecutions(leftService.rootExec, rigthService.rootExec);
    boolean _not = (!_compareExecutions);
    if (_not) {
      return false;
    }
    TmscServiceMatcher.LOGGER.debug("Matching TMSCs {} and {}", TmscServiceMatcher.label(leftService), TmscServiceMatcher.label(rigthService));
    final BiMap<Event, Event> initMatchedEvents = TmscIsomorphismMatcher.discoverAllEventMatches(leftService.tmsc, 
      rigthService.tmsc, eventEquivalence);
    final ITmscMatchResult result = TmscIsomorphismMatcher.match(leftService.tmsc, rigthService.tmsc, initMatchedEvents, eventEquivalence);
    try {
      matchedEvents.putAll(result.getEventMatches());
    } catch (final Throwable _t) {
      if (_t instanceof IllegalArgumentException) {
        final IllegalArgumentException e = (IllegalArgumentException)_t;
        TmscServiceMatcher.LOGGER.debug("One of the events is matched! {}", e.getMessage());
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    TmscServiceMatcher.matchedServices.put(leftService, rigthService);
    final Function1<Map.Entry<Event, Event>, Boolean> _function = (Map.Entry<Event, Event> entry) -> {
      boolean _equals = entry.getKey().getComponent().getName().equals("«untraced»");
      return Boolean.valueOf((!_equals));
    };
    final Function1<Map.Entry<Event, Event>, Boolean> _function_1 = (Map.Entry<Event, Event> entry) -> {
      Lifeline _lifeline = entry.getKey().getExecution().getLifeline();
      Lifeline _lifeline_1 = leftService.rootExec.getLifeline();
      return Boolean.valueOf((!Objects.equal(_lifeline, _lifeline_1)));
    };
    final Consumer<Map.Entry<Event, Event>> _function_2 = (Map.Entry<Event, Event> entry) -> {
      TmscServiceMatcher.match(TmscServiceMatcher.getLeftService(entry.getKey()), TmscServiceMatcher.getRightService(entry.getValue()), matchedEvents, eventEquivalence);
    };
    IterableExtensions.<Map.Entry<Event, Event>>filter(IterableExtensions.<Map.Entry<Event, Event>>filter(result.getEventMatches().entrySet(), _function), _function_1).forEach(_function_2);
    return true;
  }
  
  private static TmscServiceMatcher.Service getLeftService(final Event event) {
    for (final TmscServiceMatcher.Service service : TmscServiceMatcher.leftServices) {
      if ((service.tmsc.getEvents().contains(event) && (!TmscServiceMatcher.matchedServices.containsKey(service)))) {
        return service;
      }
    }
    return null;
  }
  
  private static TmscServiceMatcher.Service getRightService(final Event event) {
    for (final TmscServiceMatcher.Service service : TmscServiceMatcher.rightServices) {
      if ((service.tmsc.getEvents().contains(event) && (!TmscServiceMatcher.matchedServices.containsValue(service)))) {
        return service;
      }
    }
    return null;
  }
  
  private static String label(final TmscServiceMatcher.Service service) {
    String _name = service.rootExec.getLifeline().getExecutor().getName();
    String _plus = (_name + ".");
    String _name_1 = service.rootExec.getFunction().getName();
    return (_plus + _name_1);
  }
  
  private static Set<TmscServiceMatcher.Service> serviceSegments(final ITMSC tmsc) {
    final Set<Lifeline> lifelines = CollectionLiterals.<Lifeline>newLinkedHashSet();
    final Set<TmscServiceMatcher.Service> services = CollectionLiterals.<TmscServiceMatcher.Service>newLinkedHashSet();
    final Consumer<Event> _function = (Event it) -> {
      lifelines.add(it.getLifeline());
    };
    tmsc.getEvents().forEach(_function);
    final Consumer<Lifeline> _function_1 = (Lifeline it) -> {
      services.addAll(TmscServiceMatcher.getLifelineServices(it, tmsc));
    };
    lifelines.forEach(_function_1);
    return services;
  }
  
  private static Set<TmscServiceMatcher.Service> getLifelineServices(final Lifeline lifeline, final ITMSC tmsc) {
    final Set<TmscServiceMatcher.Service> lifelineServices = CollectionLiterals.<TmscServiceMatcher.Service>newLinkedHashSet();
    final Function1<Execution, Boolean> _function = (Execution it) -> {
      Execution _parent = it.getParent();
      return Boolean.valueOf((_parent == null));
    };
    final Iterable<Execution> rootExecutions = IterableExtensions.<Execution>filter(lifeline.getExecutions(), _function);
    for (final Execution root : rootExecutions) {
      {
        final Function1<Event, Boolean> _function_1 = (Event it) -> {
          return Boolean.valueOf(((it.getTimestamp().compareTo(root.getStartTime()) >= 0) && (it.getTimestamp().compareTo(root.getEndTime()) <= 0)));
        };
        final Set<Event> allEvents = IterableExtensions.<Event>toSet(IterableExtensions.<Event>filter(lifeline.getEvents(), _function_1));
        final LinkedHashSet<Dependency> allDependencies = CollectionLiterals.<Dependency>newLinkedHashSet();
        final Consumer<Event> _function_2 = (Event it) -> {
          allDependencies.addAll(tmsc.getIncomingDependencies(it));
          allDependencies.addAll(tmsc.getOutgoingDependencies(it));
        };
        allEvents.forEach(_function_2);
        final Function1<Event, Execution> _function_3 = (Event it) -> {
          return it.getExecution();
        };
        final Function1<Execution, Boolean> _function_4 = (Execution it) -> {
          Function _function_5 = it.getFunction();
          return Boolean.valueOf((_function_5 instanceof IPCFunction));
        };
        final Function1<Execution, Boolean> _function_5 = (Execution it) -> {
          Execution _parent = it.getParent();
          return Boolean.valueOf((_parent != null));
        };
        final Function1<Execution, Boolean> _function_6 = (Execution it) -> {
          Function _function_7 = it.getParent().getFunction();
          return Boolean.valueOf((!(_function_7 instanceof IPCFunction)));
        };
        final Set<Execution> ipcExecutions = IterableExtensions.<Execution>toSet(IterableExtensions.<Execution>filter(IterableExtensions.<Execution>filter(IterableExtensions.<Execution>filter(IterableExtensions.<Event, Execution>map(allEvents, _function_3), _function_4), _function_5), _function_6));
        int _size = ipcExecutions.size();
        switch (_size) {
          case 0:
            TmscQueries.CachedQueryTMSC _createCachedQueryTMSC = TmscQueries.createCachedQueryTMSC(allDependencies);
            TmscServiceMatcher.Service _service = new TmscServiceMatcher.Service(_createCachedQueryTMSC, root);
            lifelineServices.add(_service);
            break;
          case 1:
            TmscQueries.CachedQueryTMSC _createCachedQueryTMSC_1 = TmscQueries.createCachedQueryTMSC(allDependencies);
            Execution _get = ((Execution[])Conversions.unwrapArray(ipcExecutions, Execution.class))[0];
            TmscServiceMatcher.Service _service_1 = new TmscServiceMatcher.Service(_createCachedQueryTMSC_1, _get);
            lifelineServices.add(_service_1);
            break;
          default:
            for (final Execution execution : rootExecutions) {
              {
                final Function1<Event, Boolean> _function_7 = (Event it) -> {
                  return Boolean.valueOf(((it.getTimestamp().compareTo(execution.getStartTime()) >= 0) && (it.getTimestamp().compareTo(execution.getEndTime()) <= 0)));
                };
                final Iterable<Event> events = IterableExtensions.<Event>filter(allEvents, _function_7);
                final Set<Dependency> dependencies = CollectionLiterals.<Dependency>newLinkedHashSet();
                final Consumer<Event> _function_8 = (Event it) -> {
                  dependencies.addAll(tmsc.getIncomingDependencies(it));
                  dependencies.addAll(tmsc.getOutgoingDependencies(it));
                };
                events.forEach(_function_8);
                TmscQueries.CachedQueryTMSC _createCachedQueryTMSC_2 = TmscQueries.createCachedQueryTMSC(dependencies);
                TmscServiceMatcher.Service _service_2 = new TmscServiceMatcher.Service(_createCachedQueryTMSC_2, execution);
                lifelineServices.add(_service_2);
              }
            }
            break;
        }
      }
    }
    return lifelineServices;
  }
  
  public static boolean compareExecutions(final Execution leftExec, final Execution rigthExec) {
    boolean _equals = leftExec.getFunction().getName().equals(rigthExec.getFunction().getName());
    boolean _not = (!_equals);
    if (_not) {
      return false;
    }
    boolean _equals_1 = leftExec.getLifeline().getExecutor().getName().equals(rigthExec.getLifeline().getExecutor().getName());
    boolean _not_1 = (!_equals_1);
    if (_not_1) {
      return false;
    }
    return true;
  }
}
