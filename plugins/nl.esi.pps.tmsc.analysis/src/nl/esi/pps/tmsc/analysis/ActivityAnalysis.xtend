/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.analysis

import java.util.HashSet
import java.util.List
import java.util.Map
import java.util.Set
import nl.esi.emf.properties.xtend.PersistedProperty
import nl.esi.pps.tmsc.Dependency
import nl.esi.pps.tmsc.Event
import nl.esi.pps.tmsc.Interval
import nl.esi.pps.tmsc.ScopedTMSC
import nl.esi.pps.tmsc.TmscFactory
import nl.esi.pps.tmsc.metric.MetricInstance
import nl.esi.pps.tmsc.metric.MetricPlugin
import nl.esi.pps.tmsc.util.DependencyFeatureProjection
import nl.esi.pps.tmsc.util.TmscProjection

import static extension nl.esi.pps.tmsc.sort.TmscTopologicalOrder.*
import static extension nl.esi.pps.tmsc.util.TmscQueries.*
import static extension org.eclipse.lsat.common.xtend.Queries.*

final class ActivityAnalysis {
    public static val EPOCH_PROJECTION = new DependencyEpochProjection()
    public static val RESOURCE_SHARING_PROJECTION = new DependencyResourceSharingProjection()

    @PersistedProperty(Dependency)
    public static val boolean epoch = false

    @PersistedProperty(Dependency)
    public static val boolean resourceSharing = false

    private new() {
        // Empty for utility classes
    }
    
    static def ScopedTMSC createActivityTMSC(Interval interval) {
        return findActivityDependencies(interval).createScopedTMSC(
            '''«interval.name» activity''', interval.from, interval.to)
    }
    
    static def ScopedTMSC createCausalTMSC(Interval interval) {
        val causalDependencies = interval.tmsc.findCausalDependenciesBetween(interval.from, interval.to)
        return causalDependencies.createScopedTMSC('''«interval.name» causal''', interval.from, interval.to)
    }
    
    static def ScopedTMSC createCausalActivityTMSC(Interval interval) {
        // Step 1: Finding all causality between from and to
        // Executions can be part of the causality, but we are not interested in them
        // as the result also includes their life-line-segments
        val causalDependencies = interval.tmsc.findCausalDependenciesBetween(interval.from, interval.to)
        
        // Step 2: Determine the activity part of the causality and already add them to the result
        val causalActivityDependencies = findActivityDependencies(interval)
        causalActivityDependencies.retainAll(causalDependencies)

        return causalActivityDependencies.createScopedTMSC('''«interval.name» causal activity''', interval.from, interval.to)
    }

    static def ScopedTMSC createCausalScheduledActivityTMSC(Interval interval) {
        // Step 1: Finding all causality between from and to
        // Executions can be part of the causality, but we are not interested in them
        // as the result also includes their life-line-segments
        val causalDependencies = interval.tmsc.findCausalDependenciesBetween(interval.from, interval.to)
        // Add epoch dependencies, that represent the life-line release times, to the causality
        val epochDependencies = interval.createEpochDependencies(causalDependencies)
        causalDependencies += epochDependencies
        
        // Step 2: Determine the activity part of the causality and already add them to the result
        val causalActivityDependencies = findActivityDependencies(interval)
        causalActivityDependencies.retainAll(causalDependencies)
        val csaTmsc = causalActivityDependencies.createScopedTMSC('''«interval.name» causal scheduled activity''', interval.from, interval.to)
        
        // Step 3: For all other causal paths, create projections and add them to the result
        // We create projections to abstract from the specific behavior between the activity.
        // Projection ensures that we can run other analysis (e.g. critical path) on the resulting TMSC.
        causalDependencies.removeAll(causalActivityDependencies)
        val causalProjections = causalDependencies.projectToScope(csaTmsc)
        
        // The causal scheduled activity TMSC may not contain all epoch dependencies created at step 1,
        // as they may have been projected into other dependencies. Hence do not persist these intermediate results.
        epochDependencies.removeAll(causalProjections)
        epochDependencies.disposeTemp

        return csaTmsc
    }
    
    static def ScopedTMSC createScheduledActivityTMSC(Interval interval) {
        // Step 1: Determine the activity for the interval and
        // ensure that we will not use any dependencies before the interval start as
        // creating epoch dependencies will then fail. Also dependencies before the interval start
        // indicate a non-sound metric definition and should be solved by defining activity cut-offs
        // for the metric.
        val activityDependencies = findActivityDependencies(interval).reject[startTime < interval.startTime].toSet
        val saTmsc = activityDependencies.createScopedTMSC('''«interval.name» scheduled activity''', interval.from, interval.to)
        
        // Step 2a: Finding all causality within the activity
        val activityCausalDependencies = interval.tmsc.findCausalDependenciesBetween(saTmsc.initialEvents, saTmsc.finalEvents)
        if (!activityCausalDependencies.containsAll(activityDependencies)) {
            throw new IllegalStateException('Programming error, please contact PPS support!')
        }
        // Step 2b: Add epoch dependencies, that represent the life-line release times, to the causality.
        // Ensure that we will not use any dependencies outside the interval causality as
        // creating epoch dependencies will then fail. These dependencies indicate a non-sound metric definition 
        // and should be solved by defining activity cut-offs for the metric.
        val epochDependencies = interval.createEpochDependencies()
        activityCausalDependencies += epochDependencies

        // Step 3: For all non-activity causal paths, create projections and add them to the result
        // We create projections to abstract from the specific behavior between the activity.
        // Projection ensures that we can run other analysis (e.g. critical path) on the resulting TMSC.
        activityCausalDependencies.removeAll(activityDependencies)
        val activityCausalProjections = activityCausalDependencies.projectToScope(saTmsc)

        // The scheduled activity TMSC may not contain all epoch dependencies created at step 1,
        // as they may have been projected into other dependencies. Hence do not persist these intermediate results.
        epochDependencies.removeAll(activityCausalProjections)
        epochDependencies.disposeTemp
        
        return saTmsc
    }
    
    private static def Set<Dependency> projectToScope(Iterable<? extends Dependency> dependencies, ScopedTMSC scope) {
        val tmscProjection = new TmscProjection(scope, EPOCH_PROJECTION, RESOURCE_SHARING_PROJECTION)
        return tmscProjection.projectToScope(dependencies)
    }
    
    private static def List<? extends Dependency> createEpochDependencies(Interval interval) {
        val causalDependencies = interval.tmsc.findCausalDependenciesBetween(interval.from, interval.to)
        return interval.createEpochDependencies(causalDependencies)
    }
    
    private static def List<? extends Dependency> createEpochDependencies(Interval interval,
        Set<Dependency> causalDependencies) {
        val epochEvent = interval.from
        val epochDependencies = newArrayList
        
        // Do not add an dependency to the epoch itself, hence mark it life-line as already processed
        val epochLifelines = newHashSet(epochEvent.lifeline)
        for (event : causalDependencies.createCachedQueryTMSC().getEventsInTopologicalOrder()) {
            if (epochLifelines.add(event.lifeline)) {
                val incomingDependencies = new HashSet(event.fullScopeIncomingDependencies)
                var epochDependency = incomingDependencies.findFirst[source == epochEvent && epoch == true]
                if (epochDependency === null) {
                    // Epoch dependency does not exist yet, so create one
                    incomingDependencies.removeAll(causalDependencies)
                    // Release time: the max of the time-stamp of the epoch and the release time on the life-line 
                    // (if any; is time-stamp of last event on life-line before event + dependency time-bound)
                    val releaseTimesOnLifeline = incomingDependencies.reject[timeBound === null].map [
                        source.timestamp + timeBound
                    ]
                    val releaseTime = releaseTimesOnLifeline.union(epochEvent.timestamp).max
                    // Now add a dependency between the epoch and the first event on the thread, 
                    // using the release time as timeBound
                    epochDependency = TmscFactory::eINSTANCE.createDomainDependency => [
                        source = epochEvent
                        target = event
                        timeBound = releaseTime - epochEvent.timestamp
                        scheduled = true
                        projection = true
                        epoch = true
                        resourceSharing = releaseTime > epochEvent.timestamp
                    ]
                }
                epochDependencies += epochDependency
            }
        }

        return epochDependencies
    }
    
    static def Set<Dependency> findActivityDependencies(Interval interval) {
        if (interval instanceof MetricInstance) {
            val metricProcessor = MetricPlugin.plugin.getRegisteredMetricProcessors(interval.tmsc).get(interval.metric.id)
            if (metricProcessor !== null) {
                return interval.tmsc.findAdjacentDependenciesBetween(interval.from, interval.to) [ d |
                    d.isActivity && !metricProcessor.isActivityCutOff(d, interval)
                ]
            }
        }
        return interval.tmsc.findAdjacentDependenciesBetween(interval.from, interval.to)[isActivity]
    }

    static def boolean isActivity(Dependency dependency) {
        return dependency.scheduled == Boolean.FALSE
    }
    
    private static class DependencyEpochProjection implements DependencyFeatureProjection<Boolean> {
        override calculateProjectedValue(Event projectionSource, Map<Dependency, Boolean> projectionValues) {
            // The query below returns true for all incoming paths that originate from an epoch,
            // i.e., initially the projection value is null and then the epoch value of the dependency is used,
            // when not initial the epoch value is propagated to the next events
            projectionValues.entrySet.forall[value ?: key.isEpoch]
        }
        
        override apply(Dependency projection, Boolean targetFeatureValue) {
            // Only set the epoch property if paths are projected into a (new) projection dependency
            if (projection.isProjection && targetFeatureValue == Boolean.TRUE) {
                projection.epoch = true
            }
        }
    }
    
    /**
     * If the dependencies that are projected contain activity dependencies,
     * this means that the resource was used by other activities and therefore resourceSharing is set to true
     */
    private static class DependencyResourceSharingProjection implements DependencyFeatureProjection<Boolean> {
        override calculateProjectedValue(Event projectionSource, Map<Dependency, Boolean> projectionValues) {
            return projectionValues.containsValue(true) || projectionValues.keySet.exists[activity || resourceSharing]
        }
        
        override apply(Dependency projection, Boolean targetFeatureValue) {
            // Only set the resourceSharing property if paths are projected into a (new) projection dependency
            if (projection.isProjection && targetFeatureValue == Boolean.TRUE) {
                projection.resourceSharing = true
            }
        }
    }
}