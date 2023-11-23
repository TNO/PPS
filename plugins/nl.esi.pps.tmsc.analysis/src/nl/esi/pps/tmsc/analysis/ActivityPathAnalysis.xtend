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

import nl.esi.emf.properties.xtend.PersistedProperty
import nl.esi.pps.tmsc.Dependency
import nl.esi.pps.tmsc.Event
import nl.esi.pps.tmsc.Interval
import nl.esi.pps.tmsc.ScopedTMSC
import nl.esi.pps.tmsc.TMSC

import static extension nl.esi.pps.tmsc.util.TmscQueries.*
import static extension org.eclipse.lsat.common.xtend.Queries.*

final class ActivityPathAnalysis {
    @PersistedProperty(ScopedTMSC)
    static val boolean activityPathAnalysisResult = false

    static def ScopedTMSC analyseActivityPath(Interval interval) {
        val previousActivityPath = interval.scopes.findFirst[activityPathAnalysisResult]
        if (previousActivityPath !== null) {
            return previousActivityPath
        }
        val activityPath = interval.tmsc.findActivityPathBetween(interval.from, interval.to).
            createScopedTMSC('''Activity path for «interval.name»''', interval.from, interval.to)
        activityPath.activityPathAnalysisResult = true
        interval.scopes += activityPath
        return activityPath
    }

    /**
     * Finds {@link Dependency dependencies} that denote the activity path to
     * the specified {@code event}.
     */
    static def findActivityPathTo(TMSC tmsc, Event event) {
        return tmsc.closureIncomingDependencies(event)
            .until[scheduled != Boolean.FALSE]
    }

    /**
     * Finds {@link Dependency dependencies} that denote the activity path to
     * the specified {@code to} event. Analysis is stopped when {@code from} event
     * is detected or at the {@link Event#getTimestamp() time} of {@code from}.
     */
    static def findActivityPathBetween(TMSC tmsc, Event from, Event to) {
        return tmsc.closureIncomingDependencies(to)
            .until[target == from || target.timestamp <= from.timestamp]
            .until[scheduled != Boolean.FALSE]
    }

    private static def closureIncomingDependencies(extension TMSC tmsc, Event event) {
        return event.incomingDependencies.closure(true)[source?.incomingDependencies]
    }
}
