/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.provider.dataanalysis

import java.util.Collections
import java.util.Set
import nl.esi.pps.architecture.implemented.Function
import nl.esi.pps.tmsc.Execution
import nl.esi.pps.tmsc.FullScopeTMSC

import static extension nl.esi.pps.tmsc.util.TmscQueries.*

/** 
 * {@link Function} supports data analysis by providing this {@link IDataAnalysisItemContentProvider}.
 */
class FunctionDataAnalysisItemContentProvider implements IDataAnalysisItemContentProvider {
    override Set<String> getConfigurations(Object object) {
        return Collections::singleton(DEFAULT_CONFIGURATION)
    }

    override String getTitle(Object object, String configuration) {
        val Function function = object as Function
        return function.name
    }

    override Iterable<?> getSiblings(Object object, String configuration) {
        val Function function = object as Function
        val resourceSet = function.eResource?.resourceSet
        if (resourceSet === null) {
            return Collections::emptyList
        }
        return resourceSet.resources.flatMap[contents].filter(FullScopeTMSC).flatMap[lifelines].flatMap[executions].filter[it.function == function]
    }

    override Long getDuration(Object object, Object sibling, String configuration) {
        val Execution execution = sibling as Execution
        return if (execution.isFullyTraced) execution.duration
    }
}
