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
import nl.esi.pps.tmsc.Event
import nl.esi.pps.tmsc.TMSC
import nl.esi.pps.tmsc.properties.TmscCategoryProvider

import static extension nl.esi.pps.tmsc.sort.TmscTopologicalOrder.*

final class SlackAnalysis {
    /**
     * The {@link #getSlack(Event, TMSC) slack} that can be added to the
     * {@link Event#getTimestamp() time-stamp} of the event, without impacting the
     * {@link Event#getTimestamp() time-stamps} of all sink events in the
     * {@code context} tmsc.
     * 
     * @param context the {@code tmsc} context for which the slack is applicable.
     */
    @PersistedProperty(value=Event, categoryProvider=TmscCategoryProvider, unsettable=true)
    public static val long slack = 0

    private new() {
        // Empty for utility classes
    }

    /**
     * For each {@link TMSC#getEvents() event} in {@code tmsc}, calculates the
     * {@link #getSlack(Event, TMSC) slack} that can be added to the
     * {@link Event#getTimestamp() time-stamp} of the event, without impacting the
     * {@link Event#getTimestamp() time-stamps} of all sink events in the {@code tmsc}.
     * 
     * @param tmsc the {@code tmsc} for which the slack should be calculated.
     */
    static def void analyseSlack(TMSC tmsc) {
        tmsc.events.forEach[unsetSlack(tmsc)]

        // Using reverse topological order to guarantee that the slack of the target event 
        // has been calculated before calculating the slack of the source event of a dependency
        // Exclude dependencies from slack analysis if their time-bound is not set
        for (dependency : tmsc.dependenciesInReverseTopologicalOrder.reject[timeBound === null]) {
            // Use max to avoid negative values 
            // TODO: Can time-bound be greater than actual duration? Should we add a validation?
            var dependencyWaitTime = Math::max(dependency.duration - dependency.timeBound, 0)
            // Compute slack of current source event for the current dependency
            val calculatedSlack = dependencyWaitTime + dependency.target.getSlack(tmsc)
            // Find minimum between the slack of current source event and the slack from temporary intermediate property 
            if (!dependency.source.isSetSlack(tmsc) || dependency.source.getSlack(tmsc) > calculatedSlack) {
                 dependency.source.setSlack(calculatedSlack, tmsc)
            }
        }
    }
}
