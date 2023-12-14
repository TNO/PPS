/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.analysis;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.DomainDependency;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.Interval;
import nl.esi.pps.tmsc.Lifeline;
import nl.esi.pps.tmsc.ScopedTMSC;
import nl.esi.pps.tmsc.TmscFactory;
import nl.esi.pps.tmsc.metric.MetricInstance;
import nl.esi.pps.tmsc.metric.MetricPlugin;
import nl.esi.pps.tmsc.metric.extension.MetricProcessor;
import nl.esi.pps.tmsc.sort.TmscTopologicalOrder;
import nl.esi.pps.tmsc.util.DependencyFeatureProjection;
import nl.esi.pps.tmsc.util.TmscProjection;
import nl.esi.pps.tmsc.util.TmscQueries;
import org.eclipse.emf.common.util.EList;
import org.eclipse.lsat.common.xtend.Queries;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public final class ActivityAnalysis {
  private static class DependencyEpochProjection implements DependencyFeatureProjection<Boolean> {
    @Override
    public Boolean calculateProjectedValue(final Event projectionSource, final Map<Dependency, Boolean> projectionValues) {
      final Function1<Map.Entry<Dependency, Boolean>, Boolean> _function = (Map.Entry<Dependency, Boolean> it) -> {
        Boolean _elvis = null;
        Boolean _value = it.getValue();
        if (_value != null) {
          _elvis = _value;
        } else {
          boolean _isEpoch = ActivityAnalysis.isEpoch(it.getKey());
          _elvis = Boolean.valueOf(_isEpoch);
        }
        return _elvis;
      };
      return Boolean.valueOf(IterableExtensions.<Map.Entry<Dependency, Boolean>>forall(projectionValues.entrySet(), _function));
    }
    
    @Override
    public void apply(final Dependency projection, final Boolean targetFeatureValue) {
      if ((projection.isProjection() && Objects.equal(targetFeatureValue, Boolean.TRUE))) {
        ActivityAnalysis.setEpoch(projection, true);
      }
    }
  }
  
  /**
   * If the dependencies that are projected contain activity dependencies,
   * this means that the resource was used by other activities and therefore resourceSharing is set to true
   */
  private static class DependencyResourceSharingProjection implements DependencyFeatureProjection<Boolean> {
    @Override
    public Boolean calculateProjectedValue(final Event projectionSource, final Map<Dependency, Boolean> projectionValues) {
      return Boolean.valueOf((projectionValues.containsValue(Boolean.valueOf(true)) || IterableExtensions.<Dependency>exists(projectionValues.keySet(), ((Function1<Dependency, Boolean>) (Dependency it) -> {
        return Boolean.valueOf((ActivityAnalysis.isActivity(it) || ActivityAnalysis.isResourceSharing(it)));
      }))));
    }
    
    @Override
    public void apply(final Dependency projection, final Boolean targetFeatureValue) {
      if ((projection.isProjection() && Objects.equal(targetFeatureValue, Boolean.TRUE))) {
        ActivityAnalysis.setResourceSharing(projection, true);
      }
    }
  }
  
  public static final ActivityAnalysis.DependencyEpochProjection EPOCH_PROJECTION = new ActivityAnalysis.DependencyEpochProjection();
  
  public static final ActivityAnalysis.DependencyResourceSharingProjection RESOURCE_SHARING_PROJECTION = new ActivityAnalysis.DependencyResourceSharingProjection();
  
  private ActivityAnalysis() {
  }
  
  public static ScopedTMSC createActivityTMSC(final Interval interval) {
    Set<Dependency> _findActivityDependencies = ActivityAnalysis.findActivityDependencies(interval);
    StringConcatenation _builder = new StringConcatenation();
    String _name = interval.getName();
    _builder.append(_name);
    _builder.append(" activity");
    return TmscQueries.createScopedTMSC(_findActivityDependencies, _builder, interval.getFrom(), interval.getTo());
  }
  
  public static ScopedTMSC createCausalTMSC(final Interval interval) {
    final Set<Dependency> causalDependencies = TmscQueries.findCausalDependenciesBetween(interval.getTmsc(), interval.getFrom(), interval.getTo());
    StringConcatenation _builder = new StringConcatenation();
    String _name = interval.getName();
    _builder.append(_name);
    _builder.append(" causal");
    return TmscQueries.createScopedTMSC(causalDependencies, _builder, interval.getFrom(), interval.getTo());
  }
  
  public static ScopedTMSC createCausalActivityTMSC(final Interval interval) {
    final Set<Dependency> causalDependencies = TmscQueries.findCausalDependenciesBetween(interval.getTmsc(), interval.getFrom(), interval.getTo());
    final Set<Dependency> causalActivityDependencies = ActivityAnalysis.findActivityDependencies(interval);
    causalActivityDependencies.retainAll(causalDependencies);
    StringConcatenation _builder = new StringConcatenation();
    String _name = interval.getName();
    _builder.append(_name);
    _builder.append(" causal activity");
    return TmscQueries.createScopedTMSC(causalActivityDependencies, _builder, interval.getFrom(), interval.getTo());
  }
  
  public static ScopedTMSC createCausalScheduledActivityTMSC(final Interval interval) {
    final Set<Dependency> causalDependencies = TmscQueries.findCausalDependenciesBetween(interval.getTmsc(), interval.getFrom(), interval.getTo());
    final List<? extends Dependency> epochDependencies = ActivityAnalysis.createEpochDependencies(interval, causalDependencies);
    Iterables.<Dependency>addAll(causalDependencies, epochDependencies);
    final Set<Dependency> causalActivityDependencies = ActivityAnalysis.findActivityDependencies(interval);
    causalActivityDependencies.retainAll(causalDependencies);
    StringConcatenation _builder = new StringConcatenation();
    String _name = interval.getName();
    _builder.append(_name);
    _builder.append(" causal scheduled activity");
    final ScopedTMSC csaTmsc = TmscQueries.createScopedTMSC(causalActivityDependencies, _builder, interval.getFrom(), interval.getTo());
    causalDependencies.removeAll(causalActivityDependencies);
    final Set<Dependency> causalProjections = ActivityAnalysis.projectToScope(causalDependencies, csaTmsc);
    epochDependencies.removeAll(causalProjections);
    TmscQueries.disposeTemp(epochDependencies);
    return csaTmsc;
  }
  
  public static ScopedTMSC createScheduledActivityTMSC(final Interval interval) {
    final Function1<Dependency, Boolean> _function = (Dependency it) -> {
      Long _startTime = it.getStartTime();
      Long _startTime_1 = interval.getStartTime();
      return Boolean.valueOf((_startTime.compareTo(_startTime_1) < 0));
    };
    final Set<Dependency> activityDependencies = IterableExtensions.<Dependency>toSet(IterableExtensions.<Dependency>reject(ActivityAnalysis.findActivityDependencies(interval), _function));
    StringConcatenation _builder = new StringConcatenation();
    String _name = interval.getName();
    _builder.append(_name);
    _builder.append(" scheduled activity");
    final ScopedTMSC saTmsc = TmscQueries.createScopedTMSC(activityDependencies, _builder, interval.getFrom(), interval.getTo());
    final Set<Dependency> activityCausalDependencies = TmscQueries.findCausalDependenciesBetween(interval.getTmsc(), saTmsc.getInitialEvents(), saTmsc.getFinalEvents());
    boolean _containsAll = activityCausalDependencies.containsAll(activityDependencies);
    boolean _not = (!_containsAll);
    if (_not) {
      throw new IllegalStateException("Programming error, please contact PPS support!");
    }
    final List<? extends Dependency> epochDependencies = ActivityAnalysis.createEpochDependencies(interval);
    Iterables.<Dependency>addAll(activityCausalDependencies, epochDependencies);
    activityCausalDependencies.removeAll(activityDependencies);
    final Set<Dependency> activityCausalProjections = ActivityAnalysis.projectToScope(activityCausalDependencies, saTmsc);
    epochDependencies.removeAll(activityCausalProjections);
    TmscQueries.disposeTemp(epochDependencies);
    return saTmsc;
  }
  
  private static Set<Dependency> projectToScope(final Iterable<? extends Dependency> dependencies, final ScopedTMSC scope) {
    final TmscProjection tmscProjection = new TmscProjection(scope, ActivityAnalysis.EPOCH_PROJECTION, ActivityAnalysis.RESOURCE_SHARING_PROJECTION);
    return tmscProjection.projectToScope(dependencies);
  }
  
  private static List<? extends Dependency> createEpochDependencies(final Interval interval) {
    final Set<Dependency> causalDependencies = TmscQueries.findCausalDependenciesBetween(interval.getTmsc(), interval.getFrom(), interval.getTo());
    return ActivityAnalysis.createEpochDependencies(interval, causalDependencies);
  }
  
  private static List<? extends Dependency> createEpochDependencies(final Interval interval, final Set<Dependency> causalDependencies) {
    final Event epochEvent = interval.getFrom();
    final ArrayList<Dependency> epochDependencies = CollectionLiterals.<Dependency>newArrayList();
    final HashSet<Lifeline> epochLifelines = CollectionLiterals.<Lifeline>newHashSet(epochEvent.getLifeline());
    TmscTopologicalOrder<Event> _eventsInTopologicalOrder = TmscTopologicalOrder.getEventsInTopologicalOrder(TmscQueries.createCachedQueryTMSC(causalDependencies));
    for (final Event event : _eventsInTopologicalOrder) {
      boolean _add = epochLifelines.add(event.getLifeline());
      if (_add) {
        EList<Dependency> _fullScopeIncomingDependencies = event.getFullScopeIncomingDependencies();
        final HashSet<Dependency> incomingDependencies = new HashSet<Dependency>(_fullScopeIncomingDependencies);
        final Function1<Dependency, Boolean> _function = (Dependency it) -> {
          return Boolean.valueOf((Objects.equal(it.getSource(), epochEvent) && (ActivityAnalysis.isEpoch(it) == true)));
        };
        Dependency epochDependency = IterableExtensions.<Dependency>findFirst(incomingDependencies, _function);
        if ((epochDependency == null)) {
          incomingDependencies.removeAll(causalDependencies);
          final Function1<Dependency, Boolean> _function_1 = (Dependency it) -> {
            Long _timeBound = it.getTimeBound();
            return Boolean.valueOf((_timeBound == null));
          };
          final Function1<Dependency, Long> _function_2 = (Dependency it) -> {
            Long _timestamp = it.getSource().getTimestamp();
            Long _timeBound = it.getTimeBound();
            return Long.valueOf(((_timestamp).longValue() + (_timeBound).longValue()));
          };
          final Iterable<Long> releaseTimesOnLifeline = IterableExtensions.<Dependency, Long>map(IterableExtensions.<Dependency>reject(incomingDependencies, _function_1), _function_2);
          final Long releaseTime = IterableExtensions.<Long>max(Queries.<Long>union(releaseTimesOnLifeline, epochEvent.getTimestamp()));
          DomainDependency _createDomainDependency = TmscFactory.eINSTANCE.createDomainDependency();
          final Procedure1<DomainDependency> _function_3 = (DomainDependency it) -> {
            it.setSource(epochEvent);
            it.setTarget(event);
            Long _timestamp = epochEvent.getTimestamp();
            long _minus = ((releaseTime).longValue() - (_timestamp).longValue());
            it.setTimeBound(Long.valueOf(_minus));
            it.setScheduled(Boolean.valueOf(true));
            it.setProjection(true);
            ActivityAnalysis.setEpoch(it, true);
            Long _timestamp_1 = epochEvent.getTimestamp();
            boolean _greaterThan = (releaseTime.compareTo(_timestamp_1) > 0);
            ActivityAnalysis.setResourceSharing(it, _greaterThan);
          };
          DomainDependency _doubleArrow = ObjectExtensions.<DomainDependency>operator_doubleArrow(_createDomainDependency, _function_3);
          epochDependency = _doubleArrow;
        }
        epochDependencies.add(epochDependency);
      }
    }
    return epochDependencies;
  }
  
  public static Set<Dependency> findActivityDependencies(final Interval interval) {
    if ((interval instanceof MetricInstance)) {
      final MetricProcessor metricProcessor = MetricPlugin.getPlugin().getRegisteredMetricProcessors(((MetricInstance)interval).getTmsc()).get(((MetricInstance)interval).getMetric().getId());
      if ((metricProcessor != null)) {
        final Function1<Dependency, Boolean> _function = (Dependency d) -> {
          return Boolean.valueOf((ActivityAnalysis.isActivity(d) && (!metricProcessor.isActivityCutOff(d, ((MetricInstance)interval)))));
        };
        return TmscQueries.findAdjacentDependenciesBetween(((MetricInstance)interval).getTmsc(), ((MetricInstance)interval).getFrom(), ((MetricInstance)interval).getTo(), _function);
      }
    }
    final Function1<Dependency, Boolean> _function_1 = (Dependency it) -> {
      return Boolean.valueOf(ActivityAnalysis.isActivity(it));
    };
    return TmscQueries.findAdjacentDependenciesBetween(interval.getTmsc(), interval.getFrom(), interval.getTo(), _function_1);
  }
  
  public static boolean isActivity(final Dependency dependency) {
    Boolean _scheduled = dependency.getScheduled();
    return Objects.equal(_scheduled, Boolean.FALSE);
  }
  
  /**
   * Default value for persisted {@code epoch} property on Dependency
   */
  private static final boolean _DEFAULT_DEPENDENCY_EPOCH = false;
  
  public static boolean isEpoch(final Dependency container) {
    final String key = "epoch";
    final Object value = container.getProperties().get(key);
    if (value == null) {
        return _DEFAULT_DEPENDENCY_EPOCH;
    }
    return (boolean) value;
  }
  
  public static void setEpoch(final Dependency container, final boolean value) {
    final String key = "epoch";
    if (value == _DEFAULT_DEPENDENCY_EPOCH) {
    container.getProperties().remove(key);
    } else {
        container.getProperties().put(key, value);
    }
  }
  
  /**
   * Default value for persisted {@code resourceSharing} property on Dependency
   */
  private static final boolean _DEFAULT_DEPENDENCY_RESOURCESHARING = false;
  
  public static boolean isResourceSharing(final Dependency container) {
    final String key = "resourceSharing";
    final Object value = container.getProperties().get(key);
    if (value == null) {
        return _DEFAULT_DEPENDENCY_RESOURCESHARING;
    }
    return (boolean) value;
  }
  
  public static void setResourceSharing(final Dependency container, final boolean value) {
    final String key = "resourceSharing";
    if (value == _DEFAULT_DEPENDENCY_RESOURCESHARING) {
    container.getProperties().remove(key);
    } else {
        container.getProperties().put(key, value);
    }
  }
}
