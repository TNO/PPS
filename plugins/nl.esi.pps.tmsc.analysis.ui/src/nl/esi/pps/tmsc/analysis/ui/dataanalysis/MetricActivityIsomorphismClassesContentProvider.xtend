/**
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.analysis.ui.dataanalysis

import nl.esi.pps.tmsc.ScopedTMSC
import nl.esi.pps.tmsc.metric.MetricInstance
import nl.esi.pps.tmsc.metric.provider.dataanalysis.MetricDataAnalysisItemContentProvider

import static extension nl.esi.pps.tmsc.analysis.ui.handlers.CreateMetricActivityIsomorphismClassesHelper.*

class MetricActivityIsomorphismClassesContentProvider extends MetricDataAnalysisItemContentProvider {
    override getConfigurations(Object object) {
        return object.metric.instances.flatMap[scopes].map[configuration].filterNull.toSet
    }

    override String getTitle(Object object, String configuration) {
        return object.metric.name + ' - ' + configuration
    }

    override isCategorized(Object object, String configuration) {
        return true
    }
    
    override getCategory(Object object, Object sibling, String configuration) {
        if (sibling instanceof MetricInstance) {
            val isomorphismClass = sibling.scopes.findFirst[s | s.configuration == configuration]?.isomorphismClass
            if (isomorphismClass !== null) {
                return 'Isomorphism class ' + isomorphismClass
            }
        }
        return super.getCategory(object, sibling, configuration)
    }
    
    protected def String getConfiguration(ScopedTMSC tmsc) {
        val isomorphismStage = tmsc.isomorphismStage
        if (isomorphismStage === null) {
            return null
        }
        val isomorphismType = tmsc.isomorphismType
        if (isomorphismType === null) {
            return null
        }
        return isomorphismStage + ' ' + isomorphismType
    }
}