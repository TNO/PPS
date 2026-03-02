/**
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.cpu

import nl.esi.emf.properties.xtend.PersistedProperty
import nl.esi.pps.tmsc.Execution
import nl.esi.pps.tmsc.FullScopeTMSC
import nl.esi.pps.tmsc.Lifeline
import nl.esi.pps.tmsc.LifelineSegment

import static extension nl.esi.pps.tmsc.util.TmscQueries.*

class TmscCpuInfoQueries {
    @PersistedProperty(LifelineSegment)
    public static val long onCpuNanos = 0L

    @PersistedProperty(LifelineSegment)
    public static val long waitCpuNanos = 0L

    @PersistedProperty(LifelineSegment)
    public static val long waitOtherNanos = 0L
    
    static def long getOnCpuNanos(Execution execution, boolean includeChildren) {
        return execution.callStackLifelineSegments.fold(0L)[sum, segment | 
            return (includeChildren || segment.activeExecution === execution) ? sum + segment.onCpuNanos : sum
        ]
    }

    static def long getWaitCpuNanos(Execution execution, boolean includeChildren) {
        return execution.callStackLifelineSegments.fold(0L)[sum, segment | 
            return (includeChildren || segment.activeExecution === execution) ? sum + segment.waitCpuNanos : sum
        ]
    }

    static def long getWaitOtherNanos(Execution execution, boolean includeChildren) {
        return execution.callStackLifelineSegments.fold(0L)[sum, segment | 
            return (includeChildren || segment.activeExecution === execution) ? sum + segment.waitOtherNanos : sum
        ]
    }
    
    static def boolean hasCpuInfo(FullScopeTMSC tmsc) {
        return tmsc.dependencies.filter(LifelineSegment).exists[hasCpuInfo]
    }

    static def boolean hasCpuInfo(Lifeline lifeline) {
        return lifeline.segments.exists[hasCpuInfo]
    }

    static def boolean hasCpuInfo(Execution execution) {
        return execution.callStackLifelineSegments.exists[hasCpuInfo]
    }

    static def boolean hasCpuInfo(LifelineSegment segement) {
        return segement.onCpuNanos > 0 || segement.waitCpuNanos > 0 || segement.waitOtherNanos > 0
    }

    static def void clearCpuInfo(FullScopeTMSC tmsc) {
        tmsc.dependencies.filter(LifelineSegment).forEach[clearCpuInfo]
    }

    static def void clearCpuInfo(Lifeline lifeline) {
        lifeline.segments.forEach[clearCpuInfo]
    }

    static def void clearCpuInfo(Execution execution) {
        execution.callStackLifelineSegments.forEach[clearCpuInfo]
    }

    static def void clearCpuInfo(LifelineSegment segement) {
        segement.onCpuNanos = 0L
        segement.waitCpuNanos = 0L
        segement.waitOtherNanos = 0L
    }
}