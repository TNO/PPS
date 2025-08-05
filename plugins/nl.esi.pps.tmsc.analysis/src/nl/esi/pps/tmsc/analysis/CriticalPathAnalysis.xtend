/**
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.analysis

import nl.esi.emf.properties.xtend.PersistedProperty
import nl.esi.pps.tmsc.Dependency
import nl.esi.pps.tmsc.Event
import nl.esi.pps.tmsc.Interval
import nl.esi.pps.tmsc.ScopedTMSC
import nl.esi.pps.tmsc.TMSC

import static extension org.eclipse.lsat.common.xtend.Queries.*
import static extension nl.esi.pps.tmsc.util.TmscQueries.*

final class CriticalPathAnalysis {
    @PersistedProperty(value=Dependency, unsettable=true)
    public static val boolean critical = false

    @PersistedProperty(ScopedTMSC)
    static val boolean criticalPathAnalysisResult = false

    val boolean markCritical
    val (Event)=>Long timestampFunc
    val (Dependency)=>Long timeBoundFunc

    new() {
        this.markCritical = true
        this.timestampFunc = [timestamp]
        this.timeBoundFunc = [timeBound]
    }

    new((Event)=>Long timestampFunc, (Dependency)=>Long timeBoundFunc) {
        this.markCritical = false
        this.timestampFunc = timestampFunc
        this.timeBoundFunc = timeBoundFunc
    }

    static def ScopedTMSC analyseCriticalPath(Interval interval) {
        val previousCriticalPath = interval.scopes.findFirst[criticalPathAnalysisResult]
        if (previousCriticalPath !== null) {
            return previousCriticalPath
        }
        extension val criticalPathAnalysis = new CriticalPathAnalysis();
        val criticalPath = interval.tmsc.findCriticalPathBetween(interval.from, interval.to)
            .createScopedTMSC('''Critical path for «interval.name»''', interval.from, interval.to)
        criticalPath.criticalPathAnalysisResult = true
        interval.scopes += criticalPath
        return criticalPath
    }

    /**
     * Finds {@link Dependency dependencies} that denote the critical path to
     * the specified {@code event}.
     * 
     * @see #analyseCriticalDependenciesTo(TMSC, Event)
     */
    def findCriticalPathTo(TMSC tmsc, Event event) {
        return tmsc.closureIncomingDependencies(event)
            .until[!analyseCritical]
    }

    /**
     * Finds {@link Dependency dependencies} that denote the critical path to
     * the specified {@code to} event. Analysis is stopped when {@code from} event
     * is detected or at the {@link Event#getTimestamp() time} of {@code from}.
     * 
     * @see #findCriticalPathTo(TMSC, Event)
     */
    def findCriticalPathBetween(TMSC tmsc, Event from, Event to) {
        return tmsc.closureIncomingDependencies(to)
            .until[target == from || target.timestamp <= from.timestamp]
            .until[!analyseCritical]
    }

    private def closureIncomingDependencies(extension TMSC tmsc, Event event) {
        return event.incomingDependencies.closure(true)[source?.incomingDependencies]
    }

    private def boolean analyseCritical(Dependency dependency) {
        val sourceTimestamp = if(dependency.source !== null) timestampFunc.apply(dependency.source)
        val targetTimestamp = if(dependency.target !== null) timestampFunc.apply(dependency.target)
        val timeBound = timeBoundFunc.apply(dependency)
        if (sourceTimestamp === null || targetTimestamp === null || timeBound === null) {
            // Prerequisites not met, cannot analyse critical
            if (markCritical) {
                dependency.unsetCritical
            }
            return false
        } else {
            val criticalValue = sourceTimestamp + timeBound >= targetTimestamp
            if (markCritical) {
                dependency.critical = criticalValue
            }
            return criticalValue
        }
    }
}
