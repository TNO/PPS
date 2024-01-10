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
import com.google.common.collect.BiMap;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import nl.esi.pps.common.core.runtime.StatusLogger;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.ITMSC;
import nl.esi.pps.tmsc.ScopedTMSC;
import nl.esi.pps.tmsc.analysis.rootcause.AdvancedRootCauseAnalysis;
import nl.esi.pps.tmsc.compare.ArchitectureLifecycleStage;
import nl.esi.pps.tmsc.compare.ITmscMatchResult;
import nl.esi.pps.tmsc.compare.TmscIsomorphismMatcher;
import nl.esi.pps.tmsc.metric.Metric;
import nl.esi.pps.tmsc.metric.MetricInstance;
import nl.esi.pps.tmsc.util.TmscQueries;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class RootCauseAnalysis {
  @Extension
  private final StatusLogger logger = new StatusLogger("nl.esi.pps.tmsc.analysis", "Root Cause Analysis");
  
  private final ArchitectureLifecycleStage stage;
  
  public RootCauseAnalysis() {
    this(ArchitectureLifecycleStage.IMPLEMENTED);
  }
  
  public RootCauseAnalysis(final ArchitectureLifecycleStage stage) {
    this.stage = stage;
  }
  
  public MultiStatus getStatus() {
    return this.logger.getStatus();
  }
  
  public static Iterable<Dependency> getRootCauses(final ScopedTMSC scopedTMSC) {
    boolean _isRootCauseAnalysisResult = RootCauseAnalysis.isRootCauseAnalysisResult(scopedTMSC);
    boolean _not = (!_isRootCauseAnalysisResult);
    if (_not) {
      return Collections.<Dependency>emptyList();
    }
    final Function1<Dependency, Boolean> _function = (Dependency it) -> {
      return Boolean.valueOf(RootCauseAnalysis.isRootCause(it));
    };
    return IterableExtensions.<Dependency>filter(scopedTMSC.getDependencies(), _function);
  }
  
  public ScopedTMSC analyseRootCause(final MetricInstance metricInstance, final IProgressMonitor monitor) {
    return this.analyseRootCause(Collections.<MetricInstance>singleton(metricInstance), metricInstance.getMetric(), monitor).get(metricInstance);
  }
  
  public Map<MetricInstance, ScopedTMSC> analyseRootCause(final Collection<MetricInstance> metricInstances, final Metric _metric, final IProgressMonitor monitor) {
    if (((metricInstances == null) || metricInstances.isEmpty())) {
      this.logger.error("Programming error, no metric instances provided for metric {}.", _metric.getName());
      return Collections.<MetricInstance, ScopedTMSC>emptyMap();
    }
    final Function1<MetricInstance, Boolean> _function = (MetricInstance it) -> {
      Metric _metric_1 = it.getMetric();
      return Boolean.valueOf((!Objects.equal(_metric_1, _metric)));
    };
    boolean _exists = IterableExtensions.<MetricInstance>exists(metricInstances, _function);
    if (_exists) {
      this.logger.error("Programming error, only expected metric instances for metric {}.", _metric.getName());
      return Collections.<MetricInstance, ScopedTMSC>emptyMap();
    }
    Long _budget = _metric.getBudget();
    boolean _tripleEquals = (_budget == null);
    if (_tripleEquals) {
      this.logger.info("Skipped root-cause analysis as budget is not set for metric {}.", _metric.getName());
      return Collections.<MetricInstance, ScopedTMSC>emptyMap();
    }
    final Function1<MetricInstance, Boolean> _function_1 = (MetricInstance it) -> {
      return Boolean.valueOf(it.isExceedsBudget());
    };
    final Consumer<MetricInstance> _function_2 = (MetricInstance it) -> {
      this.logger.info("Skipped root-cause analysis for metric instance {} as budget is already met.", it.getName());
    };
    IterableExtensions.<MetricInstance>reject(metricInstances, _function_1).forEach(_function_2);
    final Function1<MetricInstance, Boolean> _function_3 = (MetricInstance it) -> {
      return Boolean.valueOf(it.isExceedsBudget());
    };
    final List<MetricInstance> instancesToAnalyse = IterableExtensions.<MetricInstance>toList(IterableExtensions.<MetricInstance>filter(metricInstances, _function_3));
    boolean _isEmpty = instancesToAnalyse.isEmpty();
    if (_isEmpty) {
      return Collections.<MetricInstance, ScopedTMSC>emptyMap();
    }
    final LinkedHashMap<MetricInstance, ScopedTMSC> analysisResult = CollectionLiterals.<MetricInstance, ScopedTMSC>newLinkedHashMap();
    final LinkedHashMap<MetricInstance, ScopedTMSC> analysisCausalScheduledActivities = CollectionLiterals.<MetricInstance, ScopedTMSC>newLinkedHashMap();
    for (final MetricInstance mi : instancesToAnalyse) {
      {
        final Function1<ScopedTMSC, Boolean> _function_4 = (ScopedTMSC it) -> {
          return Boolean.valueOf(RootCauseAnalysis.isRootCauseAnalysisResult(it));
        };
        ScopedTMSC causalScheduledActivity = IterableExtensions.<ScopedTMSC>findFirst(mi.getScopes(), _function_4);
        if ((causalScheduledActivity == null)) {
          ScopedTMSC _createCausalScheduledActivityTMSC = ActivityAnalysis.createCausalScheduledActivityTMSC(mi);
          final Procedure1<ScopedTMSC> _function_5 = (ScopedTMSC it) -> {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("Root cause for ");
            String _firstLower = StringExtensions.toFirstLower(mi.getName());
            _builder.append(_firstLower);
            it.setName(TmscQueries.toEID(_builder));
            RootCauseAnalysis.setRootCauseAnalysisResult(it, true);
          };
          ScopedTMSC _doubleArrow = ObjectExtensions.<ScopedTMSC>operator_doubleArrow(_createCausalScheduledActivityTMSC, _function_5);
          causalScheduledActivity = _doubleArrow;
          EList<ScopedTMSC> _scopes = mi.getScopes();
          _scopes.add(causalScheduledActivity);
          analysisCausalScheduledActivities.put(mi, causalScheduledActivity);
        }
        analysisResult.put(mi, causalScheduledActivity);
      }
    }
    boolean _isEmpty_1 = analysisCausalScheduledActivities.isEmpty();
    boolean _not = (!_isEmpty_1);
    if (_not) {
      this.collectTimeBoundSamples(_metric, analysisCausalScheduledActivities);
      final BiConsumer<MetricInstance, ScopedTMSC> _function_4 = (MetricInstance mi_1, ScopedTMSC tmsc) -> {
        this.logger.startSection("Analyzed root cause for: {}", mi_1.getName());
        try {
          this.analyseRootCause(mi_1, tmsc);
        } finally {
          this.logger.endSection();
        }
      };
      analysisCausalScheduledActivities.forEach(_function_4);
    }
    return analysisResult;
  }
  
  protected void collectTimeBoundSamples(final Metric _metric, final Map<MetricInstance, ScopedTMSC> analysisCausalScheduledActivities) {
    final Function1<MetricInstance, Boolean> _function = (MetricInstance it) -> {
      return Boolean.valueOf(it.isExceedsBudget());
    };
    final Function1<MetricInstance, MetricInstance> _function_1 = (MetricInstance mi) -> {
      return mi;
    };
    final Function1<MetricInstance, ScopedTMSC> _function_2 = (MetricInstance mi) -> {
      return ActivityAnalysis.createScheduledActivityTMSC(mi);
    };
    final Map<MetricInstance, ScopedTMSC> compareScheduledActivities = IterableExtensions.<MetricInstance, MetricInstance, ScopedTMSC>toMap(IterableExtensions.<MetricInstance>reject(_metric.getInstances(), _function), _function_1, _function_2);
    this.collectTimeBoundSamplesFromIsomorphicCausalActivity(analysisCausalScheduledActivities, compareScheduledActivities);
    this.collectTimeBoundSamplesFromIsomorphicActivity(analysisCausalScheduledActivities, compareScheduledActivities);
    final Consumer<ScopedTMSC> _function_3 = (ScopedTMSC it) -> {
      TmscQueries.disposeTemp(it, true);
    };
    compareScheduledActivities.values().forEach(_function_3);
  }
  
  /**
   * Based on isomorphism of the causal-activity, collects time-bounds for all
   * matching dependencies (incl. scheduled dependencies).
   */
  protected void collectTimeBoundSamplesFromIsomorphicCausalActivity(final Map<MetricInstance, ? extends ITMSC> analysisCausalScheduledActivities, final Map<MetricInstance, ? extends ITMSC> compareScheduledActivities) {
    int _size = compareScheduledActivities.size();
    final LinkedHashMap<MetricInstance, TmscQueries.CachedQueryTMSC> compareCausalActivities = new LinkedHashMap<MetricInstance, TmscQueries.CachedQueryTMSC>(_size);
    final BiConsumer<MetricInstance, ITMSC> _function = (MetricInstance mi, ITMSC tmsc) -> {
      final Function1<Dependency, Boolean> _function_1 = (Dependency it) -> {
        return Boolean.valueOf(ActivityAnalysis.isActivity(it));
      };
      final Iterable<Dependency> causalActivityDependencies = IterableExtensions.<Dependency>filter(TmscQueries.findCausalDependenciesBetween(tmsc, mi.getFrom(), mi.getTo()), _function_1);
      StringConcatenation _builder = new StringConcatenation();
      String _name = mi.getName();
      _builder.append(_name);
      _builder.append(" - causal activity");
      compareCausalActivities.put(mi, TmscQueries.createCachedQueryTMSC(causalActivityDependencies, _builder, mi.getFrom(), mi.getTo()));
    };
    compareScheduledActivities.forEach(_function);
    final BiConsumer<MetricInstance, ITMSC> _function_1 = (MetricInstance miLeft, ITMSC csaLeft) -> {
      final Function1<Dependency, Boolean> _function_2 = (Dependency it) -> {
        return Boolean.valueOf(ActivityAnalysis.isActivity(it));
      };
      Iterable<Dependency> _filter = IterableExtensions.<Dependency>filter(csaLeft.getDependencies(), _function_2);
      StringConcatenation _builder = new StringConcatenation();
      String _name = miLeft.getName();
      _builder.append(_name);
      _builder.append(" - causal activity");
      final TmscQueries.CachedQueryTMSC caLeft = TmscQueries.createCachedQueryTMSC(_filter, _builder, miLeft.getFrom(), miLeft.getTo());
      final BiConsumer<MetricInstance, TmscQueries.CachedQueryTMSC> _function_3 = (MetricInstance miRight, TmscQueries.CachedQueryTMSC caRight) -> {
        final BiMap<Event, Event> eventMatches = TmscIsomorphismMatcher.intervalEventMatches(miLeft, miRight, this.stage);
        final ITmscMatchResult caMatch = TmscIsomorphismMatcher.match(caLeft, caRight, eventMatches, false, this.stage);
        boolean _isFullMatch = caMatch.isFullMatch();
        if (_isFullMatch) {
          final ITMSC saRight = compareScheduledActivities.get(miRight);
          this.collectTimeBoundSamples(csaLeft, saRight, caMatch);
        }
      };
      compareCausalActivities.forEach(_function_3);
    };
    analysisCausalScheduledActivities.forEach(_function_1);
  }
  
  /**
   * Based on isomorphism of the activity, collects time-bounds for all
   * matching dependencies (incl. scheduled dependencies).
   */
  protected void collectTimeBoundSamplesFromIsomorphicActivity(final Map<MetricInstance, ? extends ITMSC> analysisCausalScheduledActivities, final Map<MetricInstance, ? extends ITMSC> compareScheduledActivities) {
    int _size = compareScheduledActivities.size();
    final LinkedHashMap<MetricInstance, TmscQueries.CachedQueryTMSC> compareActivities = new LinkedHashMap<MetricInstance, TmscQueries.CachedQueryTMSC>(_size);
    final BiConsumer<MetricInstance, ITMSC> _function = (MetricInstance mi, ITMSC tmsc) -> {
      final Function1<Dependency, Boolean> _function_1 = (Dependency it) -> {
        return Boolean.valueOf(ActivityAnalysis.isActivity(it));
      };
      final Iterable<Dependency> activityDependencies = IterableExtensions.<Dependency>filter(tmsc.getDependencies(), _function_1);
      StringConcatenation _builder = new StringConcatenation();
      String _name = mi.getName();
      _builder.append(_name);
      _builder.append(" - activity");
      compareActivities.put(mi, TmscQueries.createCachedQueryTMSC(activityDependencies, _builder, mi.getFrom(), mi.getTo()));
    };
    compareScheduledActivities.forEach(_function);
    final BiConsumer<MetricInstance, ITMSC> _function_1 = (MetricInstance miLeft, ITMSC csaLeft) -> {
      Set<Dependency> _findActivityDependencies = ActivityAnalysis.findActivityDependencies(miLeft);
      StringConcatenation _builder = new StringConcatenation();
      String _name = miLeft.getName();
      _builder.append(_name);
      _builder.append(" - activity");
      final TmscQueries.CachedQueryTMSC activityLeft = TmscQueries.createCachedQueryTMSC(_findActivityDependencies, _builder, miLeft.getFrom(), miLeft.getTo());
      final BiConsumer<MetricInstance, TmscQueries.CachedQueryTMSC> _function_2 = (MetricInstance miRight, TmscQueries.CachedQueryTMSC activityRight) -> {
        final BiMap<Event, Event> eventMatches = TmscIsomorphismMatcher.intervalEventMatches(miLeft, miRight, this.stage);
        final ITmscMatchResult activityMatch = TmscIsomorphismMatcher.match(activityLeft, activityRight, eventMatches, false, this.stage);
        boolean _isFullMatch = activityMatch.isFullMatch();
        if (_isFullMatch) {
          final ITMSC saRight = compareScheduledActivities.get(miRight);
          this.collectTimeBoundSamples(csaLeft, saRight, activityMatch);
        }
      };
      compareActivities.forEach(_function_2);
    };
    analysisCausalScheduledActivities.forEach(_function_1);
  }
  
  protected void collectTimeBoundSamples(final ITMSC causalScheduledActivityLeft, final ITMSC scheduledActivityRight, final ITmscMatchResult matchResult) {
    final ITmscMatchResult appliedMatchResult = matchResult.applyTo(causalScheduledActivityLeft, scheduledActivityRight);
    Collection<Dependency> _dependencies = causalScheduledActivityLeft.getDependencies();
    for (final Dependency left : _dependencies) {
      {
        final Dependency right = appliedMatchResult.getRightMatch(left);
        if ((right != null)) {
          boolean _isSetTimeBoundSamples = TimeBoundOutlierAnalysis.isSetTimeBoundSamples(right);
          if (_isSetTimeBoundSamples) {
            ArrayList<Long> _timeBoundSamples = TimeBoundOutlierAnalysis.getTimeBoundSamples(left);
            ArrayList<Long> _timeBoundSamples_1 = TimeBoundOutlierAnalysis.getTimeBoundSamples(right);
            Iterables.<Long>addAll(_timeBoundSamples, _timeBoundSamples_1);
          } else {
            Long _timeBound = right.getTimeBound();
            boolean _tripleNotEquals = (_timeBound != null);
            if (_tripleNotEquals) {
              ArrayList<Long> _timeBoundSamples_2 = TimeBoundOutlierAnalysis.getTimeBoundSamples(left);
              Long _timeBound_1 = right.getTimeBound();
              _timeBoundSamples_2.add(_timeBound_1);
            }
          }
        }
      }
    }
  }
  
  public void analyseRootCause(final MetricInstance metricInstance, final ScopedTMSC causalScheduledActivity) {
    final Consumer<Dependency> _function = (Dependency it) -> {
      RootCauseAnalysis.unsetRootCause(it);
    };
    causalScheduledActivity.getDependencies().forEach(_function);
    final AdvancedRootCauseAnalysis advancedRootCauseAnalysis = new AdvancedRootCauseAnalysis();
    final Set<Dependency> rootCause = advancedRootCauseAnalysis.analyseRootCause(causalScheduledActivity, metricInstance.getFrom(), 
      metricInstance.getTo(), (metricInstance.getMetric().getBudget()).longValue());
    this.logger.logAll(advancedRootCauseAnalysis.getStatus());
    final Consumer<Dependency> _function_1 = (Dependency it) -> {
      RootCauseAnalysis.setRootCause(it, true);
    };
    rootCause.forEach(_function_1);
    final Set<Dependency> criticalPath = IterableExtensions.<Dependency>toSet(new CriticalPathAnalysis().findCriticalPathBetween(causalScheduledActivity, 
      metricInstance.getFrom(), metricInstance.getTo()));
    final Function1<Dependency, Boolean> _function_2 = (Dependency it) -> {
      EObject _eContainer = it.eContainer();
      return Boolean.valueOf((_eContainer == null));
    };
    final Set<Dependency> tempDependencies = IterableExtensions.<Dependency>toSet(IterableExtensions.<Dependency>filter(causalScheduledActivity.getDependencies(), _function_2));
    tempDependencies.removeAll(criticalPath);
    tempDependencies.removeAll(rootCause);
    final Consumer<Dependency> _function_3 = (Dependency it) -> {
      TmscQueries.disposeTemp(it);
    };
    tempDependencies.forEach(_function_3);
  }
  
  /**
   * Default value for persisted {@code rootCause} property on Dependency
   */
  private static final boolean _DEFAULT_DEPENDENCY_ROOTCAUSE = false;
  
  public static boolean isRootCause(final Dependency container) {
    final String key = "rootCause";
    final Object value = container.getProperties().get(key);
    if (value == null) {
        return _DEFAULT_DEPENDENCY_ROOTCAUSE;
    }
    return (boolean) value;
  }
  
  public static void setRootCause(final Dependency container, final boolean value) {
    final String key = "rootCause";
    container.getProperties().put(key, value);
  }
  
  /**
   * Returns whether the value of the '{@link nl.esi.pps.tmsc.analysis.RootCauseAnalysis#isRootCause <em>rootCause</em>}' property is set on {@code container}.
   */
  public static boolean isSetRootCause(final Dependency container) {
    final String key = "rootCause";
    return container.getProperties().containsKey(key);
  }
  
  /**
   * Unsets the value of the '{@link nl.esi.pps.tmsc.analysis.RootCauseAnalysis#isRootCause <em>rootCause</em>}' property on {@code container}.
   */
  public static void unsetRootCause(final Dependency container) {
    final String key = "rootCause";
    container.getProperties().remove(key);
  }
  
  /**
   * Default value for persisted {@code rootCauseAnalysisResult} property on ScopedTMSC
   */
  private static final boolean _DEFAULT_SCOPEDTMSC_ROOTCAUSEANALYSISRESULT = false;
  
  public static boolean isRootCauseAnalysisResult(final ScopedTMSC container) {
    final String key = "rootCauseAnalysisResult";
    final Object value = container.getProperties().get(key);
    if (value == null) {
        return _DEFAULT_SCOPEDTMSC_ROOTCAUSEANALYSISRESULT;
    }
    return (boolean) value;
  }
  
  public static void setRootCauseAnalysisResult(final ScopedTMSC container, final boolean value) {
    final String key = "rootCauseAnalysisResult";
    if (value == _DEFAULT_SCOPEDTMSC_ROOTCAUSEANALYSISRESULT) {
    container.getProperties().remove(key);
    } else {
        container.getProperties().put(key, value);
    }
  }
}
