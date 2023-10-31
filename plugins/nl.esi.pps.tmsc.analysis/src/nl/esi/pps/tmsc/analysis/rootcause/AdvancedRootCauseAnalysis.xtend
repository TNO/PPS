/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.analysis.rootcause

import nl.esi.pps.common.core.runtime.StatusLogger
import org.eclipse.lsat.common.xtend.annotations.IntermediateProperty
import java.util.Collections
import java.util.Deque
import java.util.HashSet
import java.util.LinkedHashSet
import java.util.LinkedList
import java.util.Set
import nl.esi.pps.tmsc.Dependency
import nl.esi.pps.tmsc.Event
import nl.esi.pps.tmsc.TMSC
import nl.esi.pps.tmsc.analysis.ActivityAnalysis
import nl.esi.pps.tmsc.analysis.CriticalPathAnalysis
import nl.esi.pps.tmsc.text.EDurationFormat
import nl.esi.pps.tmsc.text.ETimestampFormat

import static extension nl.esi.pps.tmsc.analysis.TimeBoundOutlierAnalysis.*
import static extension nl.esi.pps.tmsc.analysis.UrgencyAnalysis.*

class AdvancedRootCauseAnalysis {
    extension val StatusLogger logger = new StatusLogger('nl.esi.pps.tmsc.analysis', 'Advanced Root Cause Analysis')

    @IntermediateProperty(Dependency)
    val Long urgentTimeBound = 0L

    def getStatus() {
        return logger.status
    }

    /**
     * @param tmsc requires a {@link ActivityAnalysis#createCausalScheduledActivityTMSC(nl.esi.pps.tmsc.Interval) causal scheduled activity TMSC}.
     */
    def analyseRootCause(TMSC tmsc, Event from, Event to, long budget) {
        // Check that budget is not yet met.
        if (to.timestamp - from.timestamp < budget) {
            info('Skipped root-cause analysis as budget is already met.')
            return Collections::emptySet
        }

        val outliers = tmsc.analyseTimeBoundOutliers().toList
        if (outliers.isEmpty) {
            warn('Skipped root-cause analysis as no outliers were found.')
            return Collections::emptySet
        }

        // One time only, sort all outliers based on their maximum gain w.r.t. the makespan
        // Note the minus to sort descending
        outliers.sortInplaceBy[-maxGain]

        // For debugging only, build an ID map for logging
        val outlierIds = newHashMap
        outliers.forEach[outlier, index |
            debug(
                '{} is an outlier with a max. gain of {} (time-bound: {}, threshold: {}): {}@{} -> {}@{}',
                index,
                outlier.maxGain.formatDuration,
                outlier.timeBound.formatDuration,
                outlier.timeBoundOutlierThreshold.formatDuration,
                outlier.source.lifeline.executor.name,
                outlier.source.timestamp.formatTimestamp,
                outlier.target.lifeline.executor.name,
                outlier.target.timestamp.formatTimestamp
            )
            outlierIds.put(outlier, index)
        ]

        var rootCause = new LinkedHashSet(outliers)
        var rootCauseMakespan = to.timestamp - from.timestamp
        debug('Makespan without resolving any outliers {}', rootCauseMakespan.formatDuration)

        // Check that there is a solution by resolving all outliers.
        tmsc.computeUrgentTimestamps(outliers)
        val minMakespan = to.getUrgentTimestamp(tmsc) - from.getUrgentTimestamp(tmsc)

        if (minMakespan > budget) {
            // Can never find a solution for the specified budget.
            // The minimal solution for the lowest possible makespan are all ouliers 
            // that are still on the critical path, even if all outliers are resolved.
            val criticalPathAnalysis = new CriticalPathAnalysis([getUrgentTimestamp(tmsc)], [urgentTimeBound])
            rootCause.retainAll(criticalPathAnalysis.findCriticalPathBetween(tmsc, from, to).toSet)
            
            // Cleanup
            disposeUrgentTimeBound
            tmsc.events.forEach[unsetUrgentTimestamp(tmsc)]
            
            debug(
                'Found root-cause {} for lowest possible makespan {}',
                rootCause.map[dep|outlierIds.get(dep)],
                minMakespan.formatDuration
            )
            warn(
                'Resolving all outliers does not meet budget. Lowest possible makespan is {}',
                minMakespan.formatDuration
            )
            
            return rootCause
        } 

        debug(
            'Resolving all outliers yields {}, meeting budget of {}',
            minMakespan.formatDuration,
            budget.formatDuration
        )

        // Start branch-and-bound algorithm from the smallest solution.
        val Deque<LinkedHashSet<Dependency>> potentialCausesQueue = newLinkedList(newLinkedHashSet)
        val Set<LinkedHashSet<Dependency>> potentialCausesHistory = new HashSet(potentialCausesQueue)
        
        while (!potentialCausesQueue.isEmpty) {
            val potentialCause = potentialCausesQueue.removeFirst

            // Compute the new event time stamps after resolving the outliers in the potentialCause.
            tmsc.computeUrgentTimestamps(potentialCause)
            val potentialCauseMakespan = to.getUrgentTimestamp(tmsc) - from.getUrgentTimestamp(tmsc)

            if (rootCause.size < outliers.size) {
                debug(
                    'Current best solution {} with makespan {} on urgent TMSC instance. New potential cause {} with makespan {} on urgent TMSC instance.',
                    rootCause.map[dep|outlierIds.get(dep)],
                    rootCauseMakespan.formatDuration,
                    potentialCause.map[dep|outlierIds.get(dep)],
                    potentialCauseMakespan.formatDuration
                )
            } else {
                debug(
                    'New potential cause {} with makespan {} on urgent TMSC instance.',
                    potentialCause.map[dep|outlierIds.get(dep)],
                    potentialCauseMakespan.formatDuration
                )
            }

            val hopsLeft = rootCause.size - potentialCause.size
            if (potentialCauseMakespan <= budget) {
                // Budget is met, only retain smallest cause with lowest make-span.
                if (potentialCause.size < rootCause.size || potentialCauseMakespan < rootCauseMakespan) {
                    rootCause = potentialCause
                    rootCauseMakespan = potentialCauseMakespan
                    // No need to explore larger potential causes
                    potentialCausesQueue.removeIf[size > potentialCause.size]
                }
            } else if (hopsLeft > 0) {
                // Budget is not met.
                val notResolvedDependencies = new LinkedList(outliers)
                notResolvedDependencies.removeAll(potentialCause)
                // notResolvedDependencies is sorted descending by max-gain, so sum the first 'hopsLeft' items
                val maxGainLeft = notResolvedDependencies.take(hopsLeft).sum[maxGain]
                debug(
                    'Max gain of {} left in {} hops for branch {}',
                    maxGainLeft.formatDuration,
                    hopsLeft,
                    potentialCause.map[dep|outlierIds.get(dep)]
                )

                if (potentialCauseMakespan - maxGainLeft > budget) {
                    // We will never find a root cause within the number of remaining hops such that the budget is met,
                    // so stop exploring this branch.
                } else {
                    // Only consider outliers that are on the newly computed critical path.
                    val criticalPathAnalysis = new CriticalPathAnalysis([getUrgentTimestamp(tmsc)], [urgentTimeBound])
                    notResolvedDependencies.retainAll(criticalPathAnalysis.findCriticalPathBetween(tmsc, from, to).toSet)
                    for (outlier : notResolvedDependencies) {
                        val newPotentialCause = new LinkedHashSet(potentialCause)
                        newPotentialCause += outlier
                        // Only explore the new potential cause if not explored yet in another branch
                        if (potentialCausesHistory.add(newPotentialCause)) {
                            potentialCausesQueue.addLast(newPotentialCause)
                        }
                    }
                }
            }
       }
        
        // Cleanup
        disposeUrgentTimeBound
        tmsc.events.forEach[unsetUrgentTimestamp(tmsc)]

        debug(
            'Found root-cause {} with makespan {}',
            rootCause.map[dep|outlierIds.get(dep)],
            rootCauseMakespan.formatDuration
        )
        info(
            'Found root-cause, {} caused a budget exceed of {}',
            rootCause.size == 1 ? '1 dependency' : rootCause.size + ' dependencies',
            (to.timestamp - from.timestamp - budget).formatDuration
        )

        return rootCause
    }

    private def computeUrgentTimestamps(TMSC tmsc, Iterable<Dependency> potentialCause) {
        disposeUrgentTimeBound
        tmsc.dependencies.forEach[urgentTimeBound = timeBound]
        potentialCause.forEach[urgentTimeBound = timeBoundOutlierThreshold]
        tmsc.analyseUrgency[urgentTimeBound]
    }
    
    private static def <T> sum(Iterable<T> source, (T)=>long sumBy) {
        return source.fold(0L)[$0 + sumBy.apply($1)]
    }

    private static def getMaxGain(Dependency dependency) {
        return Math::max(dependency.timeBound - dependency.timeBoundOutlierThreshold, 0L)
    }    

    private static def formatDuration(Long duration) {
        return EDurationFormat::eINSTANCE.format(duration)
    }

    private static def formatTimestamp(Long timestamp) {
        return ETimestampFormat::eINSTANCE.format(timestamp)
    }
}
