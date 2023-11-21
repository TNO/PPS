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
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.ScopedTMSC;
import nl.esi.pps.tmsc.TmscPackage;
import nl.esi.pps.tmsc.sort.TmscTopologicalOrder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.lsat.common.xtend.Queries;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class TmscProjection {
  /**
   * Determines the type for the projection if it needs to be created.
   * This is a special DependencyFeatureProjection as it is not applied to the projection,
   * but is used to create the projection, hence its apply function is empty.
   * The rule for determining the projection type is:
   * <ol>
   * <li>If all dependencies of all paths are of the same type, that type is used for projection.</li>
   * <li>If one of the paths is  completely life-line segments, life-line is used for projection.</li>
   * <li>Otherwise domain-dependency is used for projection.</li>
   * </ol>
   */
  private static class DependencyTypeProjection implements DependencyFeatureProjection<EClass> {
    @Override
    public EClass calculateProjectedValue(final Event projectionSource, final Map<Dependency, EClass> projectionValues) {
      final Function1<Map.Entry<Dependency, EClass>, EClass> _function = (Map.Entry<Dependency, EClass> it) -> {
        EClass _switchResult = null;
        EClass _value = it.getValue();
        boolean _matched = false;
        if (Objects.equal(_value, null)) {
          _matched=true;
        }
        if (!_matched) {
          EClass _eClass = it.getKey().eClass();
          if (Objects.equal(_value, _eClass)) {
            _matched=true;
          }
        }
        if (_matched) {
          _switchResult = it.getKey().eClass();
        }
        if (!_matched) {
          _switchResult = TmscPackage.Literals.DOMAIN_DEPENDENCY;
        }
        return _switchResult;
      };
      final Set<EClass> types = IterableExtensions.<EClass>toSet(IterableExtensions.<Map.Entry<Dependency, EClass>, EClass>map(projectionValues.entrySet(), _function));
      EClass _switchResult = null;
      boolean _matched = false;
      int _size = types.size();
      boolean _equals = (_size == 1);
      if (_equals) {
        _matched=true;
        _switchResult = IterableExtensions.<EClass>head(types);
      }
      if (!_matched) {
        boolean _contains = types.contains(TmscPackage.Literals.LIFELINE_SEGMENT);
        if (_contains) {
          _matched=true;
          _switchResult = TmscPackage.Literals.LIFELINE_SEGMENT;
        }
      }
      if (!_matched) {
        _switchResult = TmscPackage.Literals.DOMAIN_DEPENDENCY;
      }
      return _switchResult;
    }
    
    @Override
    public void apply(final Dependency projection, final EClass targetFeatureValue) {
      throw new UnsupportedOperationException("Programming error, please contact PPS support!");
    }
  }
  
  private static class DependencyTimeBoundProjection implements DependencyFeatureProjection<Long> {
    @Override
    public Long getInitialValue(final Event projectionSource) {
      return Long.valueOf(0L);
    }
    
    @Override
    public Long calculateProjectedValue(final Event projectionSource, final Map<Dependency, Long> projectionValues) {
      final Function1<Map.Entry<Dependency, Long>, Boolean> _function = (Map.Entry<Dependency, Long> it) -> {
        Long _value = it.getValue();
        return Boolean.valueOf((_value == null));
      };
      final Function1<Map.Entry<Dependency, Long>, Boolean> _function_1 = (Map.Entry<Dependency, Long> it) -> {
        Long _timeBound = it.getKey().getTimeBound();
        return Boolean.valueOf((_timeBound == null));
      };
      final Iterable<Map.Entry<Dependency, Long>> validProjectionValues = IterableExtensions.<Map.Entry<Dependency, Long>>reject(IterableExtensions.<Map.Entry<Dependency, Long>>reject(projectionValues.entrySet(), _function), _function_1);
      boolean _isEmpty = IterableExtensions.isEmpty(validProjectionValues);
      if (_isEmpty) {
        return null;
      }
      final Function1<Map.Entry<Dependency, Long>, Long> _function_2 = (Map.Entry<Dependency, Long> it) -> {
        Long _value = it.getValue();
        Long _timeBound = it.getKey().getTimeBound();
        return Long.valueOf(((_value).longValue() + (_timeBound).longValue()));
      };
      return IterableExtensions.<Long>max(IterableExtensions.<Map.Entry<Dependency, Long>, Long>map(validProjectionValues, _function_2));
    }
    
    @Override
    public void apply(final Dependency projection, final Long projectedValue) {
      if (((projection.getTimeBound() != null) && (!Objects.equal(projection.getTimeBound(), projectedValue)))) {
        throw new IllegalArgumentException("Programming error, please contact PPS support!");
      }
      projection.setTimeBound(projectedValue);
    }
  }
  
  private static class DependencyScheduledProjection implements DependencyFeatureProjection<Boolean> {
    @Override
    public Boolean getInitialValue(final Event projectionSource) {
      return Boolean.valueOf(false);
    }
    
    @Override
    public Boolean calculateProjectedValue(final Event projectionSource, final Map<Dependency, Boolean> projectionValues) {
      final Function1<Map.Entry<Dependency, Boolean>, Boolean> _function = (Map.Entry<Dependency, Boolean> it) -> {
        Boolean _value = it.getValue();
        return Boolean.valueOf((_value == null));
      };
      final Function1<Map.Entry<Dependency, Boolean>, Boolean> _function_1 = (Map.Entry<Dependency, Boolean> it) -> {
        Boolean _scheduled = it.getKey().getScheduled();
        return Boolean.valueOf((_scheduled == null));
      };
      final Iterable<Map.Entry<Dependency, Boolean>> validProjectionValues = IterableExtensions.<Map.Entry<Dependency, Boolean>>reject(IterableExtensions.<Map.Entry<Dependency, Boolean>>reject(projectionValues.entrySet(), _function), _function_1);
      boolean _isEmpty = IterableExtensions.isEmpty(validProjectionValues);
      if (_isEmpty) {
        return null;
      }
      final Function1<Map.Entry<Dependency, Boolean>, Boolean> _function_2 = (Map.Entry<Dependency, Boolean> it) -> {
        return Boolean.valueOf(((!(it.getValue()).booleanValue()) && (!(it.getKey().getScheduled()).booleanValue())));
      };
      boolean _exists = IterableExtensions.<Map.Entry<Dependency, Boolean>>exists(validProjectionValues, _function_2);
      return Boolean.valueOf((!_exists));
    }
    
    @Override
    public void apply(final Dependency projection, final Boolean projectedValue) {
      Boolean _scheduled = projection.getScheduled();
      boolean _equals = Objects.equal(_scheduled, Boolean.FALSE);
      if (_equals) {
        return;
      }
      if (((projection.isProjection() && Objects.equal(projection.getScheduled(), Boolean.TRUE)) && Objects.equal(projectedValue, Boolean.FALSE))) {
        throw new IllegalArgumentException("Programming error, please contact PPS support!");
      }
      if ((projectedValue != null)) {
        projection.setScheduled(projectedValue);
      }
    }
  }
  
  public static final TmscProjection.DependencyTimeBoundProjection DEFAULT_TIME_BOUND_PROJECTION = new TmscProjection.DependencyTimeBoundProjection();
  
  public static final TmscProjection.DependencyScheduledProjection DEFAULT_SCHEDULED_PROJECTION = new TmscProjection.DependencyScheduledProjection();
  
  /**
   * This is a special projection, hence private and always added, see {@link DependencyTypeProjection}.
   */
  private static final TmscProjection.DependencyTypeProjection TYPE_PROJECTION = new TmscProjection.DependencyTypeProjection();
  
  private final ScopedTMSC tmsc;
  
  private final List<DependencyFeatureProjection<Object>> featureProjections = CollectionLiterals.<DependencyFeatureProjection<Object>>newArrayList();
  
  public TmscProjection(final ScopedTMSC tmsc, final DependencyFeatureProjection<?>... additionalFeatureProjections) {
    this(tmsc, true, additionalFeatureProjections);
  }
  
  protected TmscProjection(final ScopedTMSC tmsc, final boolean addDefaultProjections, final DependencyFeatureProjection<?>... featureProjections) {
    this.tmsc = tmsc;
    Iterable<DependencyFeatureProjection<?>> allFeatureProjections = Queries.<DependencyFeatureProjection<?>>union(((Iterable<? extends DependencyFeatureProjection<?>>)Conversions.doWrapArray(featureProjections)), TmscProjection.TYPE_PROJECTION);
    if (addDefaultProjections) {
      allFeatureProjections = Queries.<DependencyFeatureProjection<?>>union(allFeatureProjections, TmscProjection.DEFAULT_TIME_BOUND_PROJECTION, TmscProjection.DEFAULT_SCHEDULED_PROJECTION);
    }
    final Consumer<DependencyFeatureProjection<?>> _function = (DependencyFeatureProjection<?> fp) -> {
      this.featureProjections.add(((DependencyFeatureProjection<Object>) fp));
    };
    allFeatureProjections.forEach(_function);
  }
  
  public Set<Dependency> projectToScope(final Iterable<? extends Dependency> dependencies) {
    final Function1<Dependency, List<Event>> _function = (Dependency it) -> {
      return TmscQueries.getEvents(it);
    };
    final Set<Event> eventsInScope = IterableExtensions.<Event>toSet(IterableExtensions.<Dependency, Event>flatMap(this.tmsc.getDependencies(), _function));
    final Predicate<Event> _function_1 = (Event e) -> {
      return eventsInScope.contains(e);
    };
    return this.projectToScope(dependencies, null, _function_1);
  }
  
  public Set<Dependency> projectToScope(final Iterable<? extends Dependency> dependencies, final IProgressMonitor monitor, final Predicate<? super Event> scopePredicate) {
    final SubMonitor subMonitor = SubMonitor.convert(monitor, 100);
    final List<List<Dependency>> projectionSets = TmscQueries.findDisjunctTMSCs(dependencies, scopePredicate);
    subMonitor.worked(20);
    final Function2<Integer, List<Dependency>, Integer> _function = (Integer $0, List<Dependency> $1) -> {
      int _size = $1.size();
      return Integer.valueOf((($0).intValue() + _size));
    };
    subMonitor.setWorkRemaining((IterableExtensions.<List<Dependency>, Integer>fold(projectionSets, Integer.valueOf(0), _function)).intValue());
    final LinkedHashSet<Dependency> projections = CollectionLiterals.<Dependency>newLinkedHashSet();
    for (final List<Dependency> projectionSet : projectionSets) {
      {
        subMonitor.split(projectionSet.size());
        final BiPredicate<Event, Event> _function_1 = (Event s, Event t) -> {
          return (scopePredicate.test(s) && scopePredicate.test(t));
        };
        Set<Dependency> _project = this.project(projectionSet, _function_1);
        Iterables.<Dependency>addAll(projections, _project);
      }
    }
    return projections;
  }
  
  protected Set<Dependency> project(final Iterable<? extends Dependency> dependenciesToProject, final BiPredicate<? super Event, ? super Event> predicate) {
    final LinkedHashSet<Dependency> projections = CollectionLiterals.<Dependency>newLinkedHashSet();
    final TmscQueries.CachedQueryTMSC tmscToProject = TmscQueries.createCachedQueryTMSC(dependenciesToProject);
    final Map<Event, Map<Event, Map<DependencyFeatureProjection<Object>, Object>>> eventState = CollectionLiterals.<Event, Map<Event, Map<DependencyFeatureProjection<Object>, Object>>>newHashMap();
    TmscTopologicalOrder<Event> _eventsInTopologicalOrder = TmscTopologicalOrder.getEventsInTopologicalOrder(tmscToProject);
    for (final Event event : _eventsInTopologicalOrder) {
      {
        final List<Dependency> incomingDependencies = tmscToProject.getIncomingDependencies(event);
        boolean _isEmpty = incomingDependencies.isEmpty();
        if (_isEmpty) {
          final Function1<DependencyFeatureProjection<Object>, DependencyFeatureProjection<Object>> _function = (DependencyFeatureProjection<Object> fp) -> {
            return fp;
          };
          final Function1<DependencyFeatureProjection<Object>, Object> _function_1 = (DependencyFeatureProjection<Object> fp) -> {
            return fp.getInitialValue(event);
          };
          final Map<DependencyFeatureProjection<Object>, Object> initialEventState = IterableExtensions.<DependencyFeatureProjection<Object>, DependencyFeatureProjection<Object>, Object>toMap(this.featureProjections, _function, _function_1);
          Pair<Event, Map<DependencyFeatureProjection<Object>, Object>> _mappedTo = Pair.<Event, Map<DependencyFeatureProjection<Object>, Object>>of(event, initialEventState);
          eventState.put(event, CollectionLiterals.<Event, Map<DependencyFeatureProjection<Object>, Object>>newLinkedHashMap(_mappedTo));
        } else {
          final Function1<Dependency, Dependency> _function_2 = (Dependency d) -> {
            return d;
          };
          final Function1<Dependency, Map<Event, Map<DependencyFeatureProjection<Object>, Object>>> _function_3 = (Dependency d) -> {
            return eventState.get(d.getSource());
          };
          final Map<Dependency, Map<Event, Map<DependencyFeatureProjection<Object>, Object>>> incomingEventStates = IterableExtensions.<Dependency, Dependency, Map<Event, Map<DependencyFeatureProjection<Object>, Object>>>toMap(incomingDependencies, _function_2, _function_3);
          final Function1<Map<Event, Map<DependencyFeatureProjection<Object>, Object>>, Set<Event>> _function_4 = (Map<Event, Map<DependencyFeatureProjection<Object>, Object>> it) -> {
            return it.keySet();
          };
          final Set<Event> initialEvents = IterableExtensions.<Event>toSet(IterableExtensions.<Map<Event, Map<DependencyFeatureProjection<Object>, Object>>, Event>flatMap(incomingEventStates.values(), _function_4));
          for (final Event initialEvent : initialEvents) {
            {
              final LinkedHashMap<DependencyFeatureProjection<Object>, Object> initialEventState_1 = CollectionLiterals.<DependencyFeatureProjection<Object>, Object>newLinkedHashMap();
              for (final DependencyFeatureProjection<Object> featureProjection : this.featureProjections) {
                {
                  final Function1<Map.Entry<Dependency, Map<Event, Map<DependencyFeatureProjection<Object>, Object>>>, Boolean> _function_5 = (Map.Entry<Dependency, Map<Event, Map<DependencyFeatureProjection<Object>, Object>>> it) -> {
                    return Boolean.valueOf(it.getValue().containsKey(initialEvent));
                  };
                  final Function1<Map.Entry<Dependency, Map<Event, Map<DependencyFeatureProjection<Object>, Object>>>, Dependency> _function_6 = (Map.Entry<Dependency, Map<Event, Map<DependencyFeatureProjection<Object>, Object>>> it) -> {
                    return it.getKey();
                  };
                  final Function1<Map.Entry<Dependency, Map<Event, Map<DependencyFeatureProjection<Object>, Object>>>, Object> _function_7 = (Map.Entry<Dependency, Map<Event, Map<DependencyFeatureProjection<Object>, Object>>> it) -> {
                    return it.getValue().get(initialEvent).get(featureProjection);
                  };
                  final Map<Dependency, Object> projectionValues = IterableExtensions.<Map.Entry<Dependency, Map<Event, Map<DependencyFeatureProjection<Object>, Object>>>, Dependency, Object>toMap(IterableExtensions.<Map.Entry<Dependency, Map<Event, Map<DependencyFeatureProjection<Object>, Object>>>>filter(incomingEventStates.entrySet(), _function_5), _function_6, _function_7);
                  initialEventState_1.put(featureProjection, featureProjection.calculateProjectedValue(initialEvent, projectionValues));
                }
              }
              boolean _isFinalEvent = tmscToProject.isFinalEvent(event);
              if (_isFinalEvent) {
                boolean _test = predicate.test(initialEvent, event);
                if (_test) {
                  Object _remove = initialEventState_1.remove(TmscProjection.TYPE_PROJECTION);
                  final EClass projectionType = ((EClass) _remove);
                  final Dependency projection = this.resolveProjectionDependency(initialEvent, event, projectionType);
                  final BiConsumer<DependencyFeatureProjection<Object>, Object> _function_5 = (DependencyFeatureProjection<Object> fp, Object v) -> {
                    fp.apply(projection, v);
                  };
                  initialEventState_1.forEach(_function_5);
                  projections.add(projection);
                }
              } else {
                final Function<Event, Map<Event, Map<DependencyFeatureProjection<Object>, Object>>> _function_6 = (Event it) -> {
                  return CollectionLiterals.<Event, Map<DependencyFeatureProjection<Object>, Object>>newLinkedHashMap();
                };
                eventState.computeIfAbsent(event, _function_6).put(initialEvent, initialEventState_1);
              }
            }
          }
        }
      }
    }
    EList<Dependency> _dependencies = this.tmsc.getDependencies();
    Iterables.<Dependency>addAll(_dependencies, projections);
    return projections;
  }
  
  protected Dependency resolveProjectionDependency(final Event projectionSource, final Event projectionTarget, final EClass projectionType) {
    boolean _isSuperTypeOf = TmscPackage.Literals.DEPENDENCY.isSuperTypeOf(projectionType);
    boolean _not = (!_isSuperTypeOf);
    if (_not) {
      throw new IllegalArgumentException("Expected projectionType to be of type EClass<? extends Dependency>");
    }
    final Function1<Dependency, Boolean> _function = (Dependency it) -> {
      Event _target = it.getTarget();
      return Boolean.valueOf(Objects.equal(_target, projectionTarget));
    };
    final Function1<Dependency, Boolean> _function_1 = (Dependency it) -> {
      boolean _contains = it.getScopes().contains(this.tmsc);
      return Boolean.valueOf((!_contains));
    };
    final List<Dependency> sourceTargetDependencies = IterableExtensions.<Dependency, Boolean>sortBy(IterableExtensions.<Dependency>filter(projectionSource.getFullScopeOutgoingDependencies(), _function), _function_1);
    boolean _isEmpty = sourceTargetDependencies.isEmpty();
    if (_isEmpty) {
      EObject _create = EcoreUtil.create(projectionType);
      final Procedure1<Dependency> _function_2 = (Dependency it) -> {
        it.setSource(projectionSource);
        it.setTarget(projectionTarget);
        it.setProjection(true);
      };
      return ObjectExtensions.<Dependency>operator_doubleArrow(((Dependency) _create), _function_2);
    } else {
      return IterableExtensions.<Dependency>head(sourceTargetDependencies);
    }
  }
}
