/**
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.cpu.edit

import java.util.Collections
import nl.esi.pps.tmsc.Execution
import nl.esi.pps.tmsc.cpu.TmscCpuInfoQueries
import nl.esi.pps.tmsc.provider.dataanalysis.IDataAnalysisItemContentProvider
import nl.esi.pps.tmsc.util.TmscQueries

import static extension nl.esi.pps.tmsc.cpu.TmscCpuInfoQueries.*

class ExecutionDataAnalysisItemContentProvider implements IDataAnalysisItemContentProvider {
    /** 
     * Data analysis of On-CPU for all {@link Execution executions} with the same 
     * {@link Execution#getFunction() function} on the same{@link Execution#getLifeline() executor.}
     */
    static final String CONF_ON_CPU = "On-CPU (On same executor)"
    
    /** 
     * Data analysis of Wait-for-CPU for all {@link Execution executions} with the same 
     * {@link Execution#getFunction() function} on the same{@link Execution#getLifeline() executor.}
     */
    static final String CONF_WAIT_CPU = "Wait-for-CPU (On same executor)"
    
    override getConfigurations(Object object) {
        val Execution execution = object as Execution
        return execution.hasCpuInfo ? newLinkedHashSet(CONF_ON_CPU, CONF_WAIT_CPU) : Collections.emptySet()
    }
    
    override getTitle(Object object, String configuration) {
        val Execution execution = object as Execution
        return switch (configuration) {
            case CONF_ON_CPU: '''On-CPU for «execution.function.name» on «execution.lifeline.executor.name»'''
            case CONF_WAIT_CPU: '''Wait-for-CPU for «execution.function.name» on «execution.lifeline.executor.name»'''
            default: '''Unsupported configuration: «configuration»'''
        }
    }
    
    override getSiblings(Object object, String configuration) {
        val Execution execution = object as Execution
        return TmscQueries::findAllWithFunctionAndLifeline(execution)
    }
    
    override getDuration(Object object, Object sibling, String configuration) {
        val Execution execution = sibling as Execution
        return switch (configuration) {
            case CONF_ON_CPU: TmscCpuInfoQueries::getOnCpuNanos(execution, true)
            case CONF_WAIT_CPU: TmscCpuInfoQueries::getWaitCpuNanos(execution, true)
            default: throw new IllegalArgumentException('''Unsupported configuration: «configuration»''')
        }
    }
}