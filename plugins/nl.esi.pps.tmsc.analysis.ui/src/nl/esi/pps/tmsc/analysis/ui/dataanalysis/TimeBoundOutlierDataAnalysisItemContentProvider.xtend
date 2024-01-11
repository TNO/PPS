/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.analysis.ui.dataanalysis

import nl.esi.pps.tmsc.Dependency
import nl.esi.pps.tmsc.provider.dataanalysis.IDataAnalysisItemContentProvider

import static java.util.Collections.singleton

import static extension nl.esi.pps.tmsc.analysis.TimeBoundOutlierAnalysis.*
import static extension org.eclipse.lsat.common.xtend.Queries.*

class TimeBoundOutlierDataAnalysisItemContentProvider implements IDataAnalysisItemContentProvider {
    
    static final String TIME_BOUNDS_PRE = "Time-bounds (pre)"
    static final String TIME_BOUNDS = "Time-bounds"
    
    override getConfigurations(Object object) {
       val dependency = object as Dependency
       val configurations = newLinkedHashSet
       if (dependency.isSetTimeBoundSamples) {
           configurations += TIME_BOUNDS
       } 
       if (dependency.isSetPreTimeBoundSamples) {
           configurations += TIME_BOUNDS_PRE
       } 
       return configurations
    }

    override String getTitle(Object object, String configuration) {
        return configuration 
    }

    override Long getBudget(Object object, String configuration) {
        val dependency = object as Dependency
        return switch (configuration) {
            case TIME_BOUNDS: dependency.timeBoundOutlierThreshold
            case TIME_BOUNDS_PRE: dependency.preTimeBoundOutlierThreshold
        }
    }

    override Iterable<?> getSiblings(Object object, String configuration) {
        val dependency = object as Dependency
        val timeBoundSamples = switch (configuration) {
           case TIME_BOUNDS: dependency.timeBoundSamples
           case TIME_BOUNDS_PRE: dependency.preTimeBoundSamples
       }
       return singleton(object).union(timeBoundSamples)
    }

    override Long getDuration(Object object, Object sibling, String configuration) {
        return switch (sibling) {
        	Long: sibling
        	Dependency: sibling.timeBound
        }
    }
}
