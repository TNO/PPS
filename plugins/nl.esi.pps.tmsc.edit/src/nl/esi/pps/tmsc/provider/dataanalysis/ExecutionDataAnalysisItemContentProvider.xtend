/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.provider.dataanalysis

import java.util.Collections
import java.util.Set
import nl.esi.pps.tmsc.Execution
import nl.esi.pps.tmsc.provider.dataanalysis.IDataAnalysisItemContentProvider
import nl.esi.pps.tmsc.util.TmscQueries

import static extension nl.esi.pps.tmsc.util.TmscQueries.*

/** 
 * {@link Execution} supports data analysis by providing this {@link IDataAnalysisItemContentProvider}.
 */
class ExecutionDataAnalysisItemContentProvider implements IDataAnalysisItemContentProvider {
    /** 
     * Data analysis of all {@link Execution executions} with the same{@link Execution#getFunction() function} 
     * by the same{@link Execution#getComponent() component.}
     */
    static final String CONF_COMPONENT = "By same component"
    /** 
     * Data analysis of all {@link Execution executions} with the same{@link Execution#getFunction() function} 
     * on the same{@link Execution#getLifeline() executor.}
     */
    static final String CONF_EXECUTOR = "On same executor"
    
    override Set<String> getConfigurations(Object object) {
        return newLinkedHashSet(CONF_EXECUTOR, CONF_COMPONENT)
    }

    override String getTitle(Object object, String configuration) {
        val Execution execution = object as Execution
        return switch (configuration) {
            case CONF_COMPONENT: '''«execution.function.name» by «execution.component.name»'''
            case CONF_EXECUTOR: '''«execution.function.name» on «execution.lifeline.executor.name»'''
            default: '''Unsupported configuration: «configuration»'''
        }
    }

    override Iterable<?> getSiblings(Object object, String configuration) {
        val Execution execution = object as Execution
        return switch (configuration) {
            case CONF_COMPONENT:
                TmscQueries::findAllWithFunctionAndComponent(execution)
            case CONF_EXECUTOR:
                TmscQueries::findAllWithFunctionAndLifeline(execution)
            default:
                Collections::emptyList
        }
    }

    override Long getDuration(Object object, Object sibling, String configuration) {
        val Execution execution = sibling as Execution
        return if (execution.isFullyTraced) execution.duration
    }
}
