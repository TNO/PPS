/////////////////////////////////////////////////////////////////////////
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
    override getConfigurations(Object object) {
        val dependency = object as Dependency
        return if (dependency.isSetTimeBoundSamples) singleton('Time-bounds')
    }

    override String getTitle(Object object, String configuration) {
        return 'Time-bounds'
    }

    override Long getBudget(Object object, String configuration) {
        val dependency = object as Dependency
        return dependency.timeBoundOutlierThreshold
    }

    override Iterable<?> getSiblings(Object object, String configuration) {
        val dependency = object as Dependency
        return singleton(object).union(dependency.timeBoundSamples)
    }

    override Long getDuration(Object object, Object sibling, String configuration) {
        return switch (sibling) {
        	Long: sibling
        	Dependency: sibling.timeBound
        }
    }
}
