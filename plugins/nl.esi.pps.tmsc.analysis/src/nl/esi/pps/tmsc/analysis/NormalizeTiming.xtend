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

import nl.esi.pps.tmsc.Dependency
import nl.esi.pps.tmsc.FullScopeTMSC

import static extension nl.esi.pps.tmsc.analysis.UrgencyAnalysis.*

final class NormalizeTiming {
    private new() {
        // Empty for utility classes
    }

    /**
     * Normalizes the timing of a {@code tmsc} by:
     * <ol>
     * <li>Resetting all event time-stamps</li>
     * <li>Normalizing all dependency time-bounds (i.e. 15µs for intra-lifeline and 50µs inter-lifeline 
     * {@link Dependency dependencies}</li>
     * <li>Applying {@link UrgencyAnalysis}</li>
     * <li>Copying the analysis result (i.e.
     * {@link UrgencyAnalysis#getUrgentTimestamp(Event, nl.esi.pps.tmsc.TMSC)
     * Event#urgentTimestamp}) into the event time-stamps</li>
     * </ol>
     */
    static def void normalizeTiming(FullScopeTMSC tmsc) {
        tmsc.events.forEach[timestamp = 0L]
        tmsc.dependencies.forEach [
            val normalizedTimeBound = source.lifeline == target.lifeline ? 15_000L : 50_000L
            timeBound = normalizedTimeBound
        ]
        UrgencyAnalysis::analyseUrgency(tmsc)
        tmsc.events.forEach [
            timestamp = getUrgentTimestamp(tmsc);
            unsetUrgentTimestamp(tmsc) // Cleanup
        ]
        tmsc.epochTime = false
        tmsc.startTime = 0L
        tmsc.endTime = tmsc.events.map[timestamp].max
    }
}
