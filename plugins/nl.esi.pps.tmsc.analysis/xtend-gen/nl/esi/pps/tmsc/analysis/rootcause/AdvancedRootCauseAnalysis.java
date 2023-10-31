/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.analysis.rootcause;

import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import nl.esi.pps.common.core.runtime.StatusLogger;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.TMSC;
import nl.esi.pps.tmsc.analysis.ActivityAnalysis;
import nl.esi.pps.tmsc.analysis.CriticalPathAnalysis;
import nl.esi.pps.tmsc.analysis.TimeBoundOutlierAnalysis;
import nl.esi.pps.tmsc.analysis.UrgencyAnalysis;
import nl.esi.pps.tmsc.text.EDurationFormat;
import nl.esi.pps.tmsc.text.ETimestampFormat;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.lsat.common.xtend.annotations.IntermediateProperty;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

@SuppressWarnings("all")
public class AdvancedRootCauseAnalysis {
  @Extension
  private final StatusLogger logger = new StatusLogger("nl.esi.pps.tmsc.analysis", "Advanced Root Cause Analysis");
  
  @IntermediateProperty(Dependency.class)
  private final Map<Dependency, Long> _IntermediateProperty_urgentTimeBound = new java.util.WeakHashMap<>();
  
  public MultiStatus getStatus() {
    return this.logger.getStatus();
  }
  
  /**
   * @param tmsc requires a {@link ActivityAnalysis#createCausalScheduledActivityTMSC(nl.esi.pps.tmsc.Interval) causal scheduled activity TMSC}.
   */
  public Set<Dependency> analyseRootCause(final TMSC tmsc, final Event from, final Event to, final long budget) {
    Long _timestamp = to.getTimestamp();
    Long _timestamp_1 = from.getTimestamp();
    long _minus = ((_timestamp).longValue() - (_timestamp_1).longValue());
    boolean _lessThan = (_minus < budget);
    if (_lessThan) {
      this.logger.info("Skipped root-cause analysis as budget is already met.");
      return Collections.<Dependency>emptySet();
    }
    final List<Dependency> outliers = IterableExtensions.<Dependency>toList(TimeBoundOutlierAnalysis.analyseTimeBoundOutliers(tmsc));
    boolean _isEmpty = outliers.isEmpty();
    if (_isEmpty) {
      this.logger.warn("Skipped root-cause analysis as no outliers were found.");
      return Collections.<Dependency>emptySet();
    }
    final Function1<Dependency, Long> _function = (Dependency it) -> {
      long _maxGain = AdvancedRootCauseAnalysis.getMaxGain(it);
      return Long.valueOf((-_maxGain));
    };
    ListExtensions.<Dependency, Long>sortInplaceBy(outliers, _function);
    final HashMap<Dependency, Integer> outlierIds = CollectionLiterals.<Dependency, Integer>newHashMap();
    final Procedure2<Dependency, Integer> _function_1 = (Dependency outlier, Integer index) -> {
      this.logger.debug(
        "{} is an outlier with a max. gain of {} (time-bound: {}, threshold: {}): {}@{} -> {}@{}", index, 
        AdvancedRootCauseAnalysis.formatDuration(Long.valueOf(AdvancedRootCauseAnalysis.getMaxGain(outlier))), 
        AdvancedRootCauseAnalysis.formatDuration(outlier.getTimeBound()), 
        AdvancedRootCauseAnalysis.formatDuration(TimeBoundOutlierAnalysis.getTimeBoundOutlierThreshold(outlier)), 
        outlier.getSource().getLifeline().getExecutor().getName(), 
        AdvancedRootCauseAnalysis.formatTimestamp(outlier.getSource().getTimestamp()), 
        outlier.getTarget().getLifeline().getExecutor().getName(), 
        AdvancedRootCauseAnalysis.formatTimestamp(outlier.getTarget().getTimestamp()));
      outlierIds.put(outlier, index);
    };
    IterableExtensions.<Dependency>forEach(outliers, _function_1);
    LinkedHashSet<Dependency> rootCause = new LinkedHashSet<Dependency>(outliers);
    Long _timestamp_2 = to.getTimestamp();
    Long _timestamp_3 = from.getTimestamp();
    long rootCauseMakespan = ((_timestamp_2).longValue() - (_timestamp_3).longValue());
    this.logger.debug("Makespan without resolving any outliers {}", AdvancedRootCauseAnalysis.formatDuration(Long.valueOf(rootCauseMakespan)));
    this.computeUrgentTimestamps(tmsc, outliers);
    Long _urgentTimestamp = UrgencyAnalysis.getUrgentTimestamp(to, tmsc);
    Long _urgentTimestamp_1 = UrgencyAnalysis.getUrgentTimestamp(from, tmsc);
    final long minMakespan = ((_urgentTimestamp).longValue() - (_urgentTimestamp_1).longValue());
    if ((minMakespan > budget)) {
      final Function1<Event, Long> _function_2 = (Event it) -> {
        return UrgencyAnalysis.getUrgentTimestamp(it, tmsc);
      };
      final Function1<Dependency, Long> _function_3 = (Dependency it) -> {
        return this.getUrgentTimeBound(it);
      };
      final CriticalPathAnalysis criticalPathAnalysis = new CriticalPathAnalysis(_function_2, _function_3);
      rootCause.retainAll(IterableExtensions.<Dependency>toSet(criticalPathAnalysis.findCriticalPathBetween(tmsc, from, to)));
      this.disposeUrgentTimeBound();
      final Consumer<Event> _function_4 = (Event it) -> {
        UrgencyAnalysis.unsetUrgentTimestamp(it, tmsc);
      };
      tmsc.getEvents().forEach(_function_4);
      final Function1<Dependency, Integer> _function_5 = (Dependency dep) -> {
        return outlierIds.get(dep);
      };
      this.logger.debug(
        "Found root-cause {} for lowest possible makespan {}", 
        IterableExtensions.<Dependency, Integer>map(rootCause, _function_5), 
        AdvancedRootCauseAnalysis.formatDuration(Long.valueOf(minMakespan)));
      this.logger.warn(
        "Resolving all outliers does not meet budget. Lowest possible makespan is {}", 
        AdvancedRootCauseAnalysis.formatDuration(Long.valueOf(minMakespan)));
      return rootCause;
    }
    this.logger.debug(
      "Resolving all outliers yields {}, meeting budget of {}", 
      AdvancedRootCauseAnalysis.formatDuration(Long.valueOf(minMakespan)), 
      AdvancedRootCauseAnalysis.formatDuration(Long.valueOf(budget)));
    final Deque<LinkedHashSet<Dependency>> potentialCausesQueue = CollectionLiterals.<LinkedHashSet<Dependency>>newLinkedList(CollectionLiterals.<Dependency>newLinkedHashSet());
    final Set<LinkedHashSet<Dependency>> potentialCausesHistory = new HashSet<LinkedHashSet<Dependency>>(potentialCausesQueue);
    while ((!potentialCausesQueue.isEmpty())) {
      {
        final LinkedHashSet<Dependency> potentialCause = potentialCausesQueue.removeFirst();
        this.computeUrgentTimestamps(tmsc, potentialCause);
        Long _urgentTimestamp_2 = UrgencyAnalysis.getUrgentTimestamp(to, tmsc);
        Long _urgentTimestamp_3 = UrgencyAnalysis.getUrgentTimestamp(from, tmsc);
        final long potentialCauseMakespan = ((_urgentTimestamp_2).longValue() - (_urgentTimestamp_3).longValue());
        int _size = rootCause.size();
        int _size_1 = outliers.size();
        boolean _lessThan_1 = (_size < _size_1);
        if (_lessThan_1) {
          final Function1<Dependency, Integer> _function_6 = (Dependency dep) -> {
            return outlierIds.get(dep);
          };
          final Function1<Dependency, Integer> _function_7 = (Dependency dep) -> {
            return outlierIds.get(dep);
          };
          this.logger.debug(
            "Current best solution {} with makespan {} on urgent TMSC instance. New potential cause {} with makespan {} on urgent TMSC instance.", 
            IterableExtensions.<Dependency, Integer>map(rootCause, _function_6), 
            AdvancedRootCauseAnalysis.formatDuration(Long.valueOf(rootCauseMakespan)), 
            IterableExtensions.<Dependency, Integer>map(potentialCause, _function_7), 
            AdvancedRootCauseAnalysis.formatDuration(Long.valueOf(potentialCauseMakespan)));
        } else {
          final Function1<Dependency, Integer> _function_8 = (Dependency dep) -> {
            return outlierIds.get(dep);
          };
          this.logger.debug(
            "New potential cause {} with makespan {} on urgent TMSC instance.", 
            IterableExtensions.<Dependency, Integer>map(potentialCause, _function_8), 
            AdvancedRootCauseAnalysis.formatDuration(Long.valueOf(potentialCauseMakespan)));
        }
        int _size_2 = rootCause.size();
        int _size_3 = potentialCause.size();
        final int hopsLeft = (_size_2 - _size_3);
        if ((potentialCauseMakespan <= budget)) {
          if (((potentialCause.size() < rootCause.size()) || (potentialCauseMakespan < rootCauseMakespan))) {
            rootCause = potentialCause;
            rootCauseMakespan = potentialCauseMakespan;
            final Predicate<LinkedHashSet<Dependency>> _function_9 = (LinkedHashSet<Dependency> it) -> {
              int _size_4 = it.size();
              int _size_5 = potentialCause.size();
              return (_size_4 > _size_5);
            };
            potentialCausesQueue.removeIf(_function_9);
          }
        } else {
          if ((hopsLeft > 0)) {
            final LinkedList<Dependency> notResolvedDependencies = new LinkedList<Dependency>(outliers);
            notResolvedDependencies.removeAll(potentialCause);
            final Function1<Dependency, Long> _function_10 = (Dependency it) -> {
              return Long.valueOf(AdvancedRootCauseAnalysis.getMaxGain(it));
            };
            final Long maxGainLeft = AdvancedRootCauseAnalysis.<Dependency>sum(IterableExtensions.<Dependency>take(notResolvedDependencies, hopsLeft), _function_10);
            final Function1<Dependency, Integer> _function_11 = (Dependency dep) -> {
              return outlierIds.get(dep);
            };
            this.logger.debug(
              "Max gain of {} left in {} hops for branch {}", 
              AdvancedRootCauseAnalysis.formatDuration(maxGainLeft), Integer.valueOf(hopsLeft), 
              IterableExtensions.<Dependency, Integer>map(potentialCause, _function_11));
            if (((potentialCauseMakespan - (maxGainLeft).longValue()) > budget)) {
            } else {
              final Function1<Event, Long> _function_12 = (Event it) -> {
                return UrgencyAnalysis.getUrgentTimestamp(it, tmsc);
              };
              final Function1<Dependency, Long> _function_13 = (Dependency it) -> {
                return this.getUrgentTimeBound(it);
              };
              final CriticalPathAnalysis criticalPathAnalysis_1 = new CriticalPathAnalysis(_function_12, _function_13);
              notResolvedDependencies.retainAll(IterableExtensions.<Dependency>toSet(criticalPathAnalysis_1.findCriticalPathBetween(tmsc, from, to)));
              for (final Dependency outlier : notResolvedDependencies) {
                {
                  final LinkedHashSet<Dependency> newPotentialCause = new LinkedHashSet<Dependency>(potentialCause);
                  newPotentialCause.add(outlier);
                  boolean _add = potentialCausesHistory.add(newPotentialCause);
                  if (_add) {
                    potentialCausesQueue.addLast(newPotentialCause);
                  }
                }
              }
            }
          }
        }
      }
    }
    this.disposeUrgentTimeBound();
    final Consumer<Event> _function_6 = (Event it) -> {
      UrgencyAnalysis.unsetUrgentTimestamp(it, tmsc);
    };
    tmsc.getEvents().forEach(_function_6);
    final Function1<Dependency, Integer> _function_7 = (Dependency dep) -> {
      return outlierIds.get(dep);
    };
    this.logger.debug(
      "Found root-cause {} with makespan {}", 
      IterableExtensions.<Dependency, Integer>map(rootCause, _function_7), 
      AdvancedRootCauseAnalysis.formatDuration(Long.valueOf(rootCauseMakespan)));
    String _xifexpression = null;
    int _size = rootCause.size();
    boolean _equals = (_size == 1);
    if (_equals) {
      _xifexpression = "1 dependency";
    } else {
      int _size_1 = rootCause.size();
      _xifexpression = (Integer.valueOf(_size_1) + " dependencies");
    }
    Long _timestamp_4 = to.getTimestamp();
    Long _timestamp_5 = from.getTimestamp();
    long _minus_1 = ((_timestamp_4).longValue() - (_timestamp_5).longValue());
    this.logger.info(
      "Found root-cause, {} caused a budget exceed of {}", _xifexpression, 
      AdvancedRootCauseAnalysis.formatDuration(Long.valueOf((_minus_1 - budget))));
    return rootCause;
  }
  
  private void computeUrgentTimestamps(final TMSC tmsc, final Iterable<Dependency> potentialCause) {
    this.disposeUrgentTimeBound();
    final Consumer<Dependency> _function = (Dependency it) -> {
      this.setUrgentTimeBound(it, it.getTimeBound());
    };
    tmsc.getDependencies().forEach(_function);
    final Consumer<Dependency> _function_1 = (Dependency it) -> {
      this.setUrgentTimeBound(it, TimeBoundOutlierAnalysis.getTimeBoundOutlierThreshold(it));
    };
    potentialCause.forEach(_function_1);
    final Function1<Dependency, Long> _function_2 = (Dependency it) -> {
      return this.getUrgentTimeBound(it);
    };
    UrgencyAnalysis.analyseUrgency(tmsc, _function_2);
  }
  
  private static <T extends Object> Long sum(final Iterable<T> source, final Function1<? super T, ? extends Long> sumBy) {
    final Function2<Long, T, Long> _function = (Long $0, T $1) -> {
      Long _apply = sumBy.apply($1);
      return Long.valueOf((($0).longValue() + (_apply).longValue()));
    };
    return IterableExtensions.<T, Long>fold(source, Long.valueOf(0L), _function);
  }
  
  private static long getMaxGain(final Dependency dependency) {
    Long _timeBound = dependency.getTimeBound();
    Long _timeBoundOutlierThreshold = TimeBoundOutlierAnalysis.getTimeBoundOutlierThreshold(dependency);
    long _minus = ((_timeBound).longValue() - (_timeBoundOutlierThreshold).longValue());
    return Math.max(_minus, 0L);
  }
  
  private static String formatDuration(final Long duration) {
    return EDurationFormat.eINSTANCE.format(duration);
  }
  
  private static String formatTimestamp(final Long timestamp) {
    return ETimestampFormat.eINSTANCE.format(timestamp);
  }
  
  private static final Long _DEFAULT_DEPENDENCY_URGENTTIMEBOUND = Long.valueOf(0L);
  
  private Long getUrgentTimeBound(final Dependency owner) {
    Long value = _IntermediateProperty_urgentTimeBound.get(owner);
    return value == null ? _DEFAULT_DEPENDENCY_URGENTTIMEBOUND : value;
  }
  
  private void setUrgentTimeBound(final Dependency owner, final Long value) {
    if (value == _DEFAULT_DEPENDENCY_URGENTTIMEBOUND) {
        _IntermediateProperty_urgentTimeBound.remove(owner);
    } else {
        _IntermediateProperty_urgentTimeBound.put(owner, value);
    }
  }
  
  private void disposeUrgentTimeBound() {
    _IntermediateProperty_urgentTimeBound.clear();
  }
}
