/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.analysis

import nl.esi.emf.properties.xtend.PersistedProperty
import nl.esi.pps.tmsc.Dependency
import nl.esi.pps.tmsc.Event
import nl.esi.pps.tmsc.TMSC
import nl.esi.pps.tmsc.properties.TmscCategoryProvider

import static extension nl.esi.pps.tmsc.sort.TmscTopologicalOrder.*

/**
 * An ASAP scheduling algorithm of a timed graph (i.e. {@link Dependency#getTimeBound()}) on a set of resources 
 * (i.e. {@link Event#getLifeline()}).
 */
final class UrgencyAnalysis {
    /** 
     * The asap time-stamp of a {@code container} {@link Event} under the constraint of urgency, 
     * i.e. considering the {@link Dependency#getTimeBound() time-bounds} of all incoming dependencies 
     * within the {@link context} {@link TMSC}.
     */
    @PersistedProperty(value=Event, categoryProvider=TmscCategoryProvider, unsettable=true)
    public static val Long urgentTimestamp

    private new() {
        // Empty for utility classes
    }

    static def void analyseUrgency(TMSC tmsc) {
        analyseUrgency(tmsc) [timeBound]
    }
    
    static def void analyseUrgency(TMSC tmsc, (Dependency)=>Long timeBoundFunctor) {
        tmsc.events.forEach[unsetUrgentTimestamp(tmsc)]

        // Using topological order to guarantee that the urgent-timestamp of the source event 
        // has been calculated before calculating the urgent-timestamp of the target event of a dependency
        for (dependency : tmsc.dependenciesInTopologicalOrder) { 
            var sourceUrgentTime = dependency.source.getUrgentTimestamp(tmsc)
            if (sourceUrgentTime === null) {
                // Use the original timestamp for the initial (source) events of the TMSC
                sourceUrgentTime = dependency.source.timestamp
                dependency.source.setUrgentTimestamp(sourceUrgentTime, tmsc)
            }
            
            // Compute urgent-timestamp of target event for the current dependency
            // If time-bound is not set, assume the minimum time-bound for a dependency, i.e. 0L
            val targetUrgentTime = sourceUrgentTime + (timeBoundFunctor.apply(dependency) ?: 0L)
            
            // The urgent-timestamp of an event is the max of all its incoming dependencies,
            // thus check if already calulated for another incoming dependency (i.e. if isSet is true)
            // and take the max, otherwise just set the value for this dependency
            if (dependency.target.isSetUrgentTimestamp(tmsc)) {
                if (dependency.target.getUrgentTimestamp(tmsc) < targetUrgentTime) {
                    dependency.target.setUrgentTimestamp(targetUrgentTime, tmsc)
                }
            } else {
                dependency.target.setUrgentTimestamp(targetUrgentTime, tmsc)
            }
        }
    }
}
