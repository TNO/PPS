/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.analysis

import java.util.List
import nl.esi.pps.tmsc.Dependency
import nl.esi.pps.tmsc.Event
import nl.esi.pps.tmsc.LifelineSegment
import nl.esi.pps.tmsc.compare.ArchitectureLifecycleStage
import nl.esi.pps.tmsc.metric.MetricInstance

import static extension nl.esi.pps.tmsc.analysis.ActivityAnalysis.*
import static extension nl.esi.pps.tmsc.analysis.RootCauseAnalysis.*

class RootCauseClassification {
    val ArchitectureLifecycleStage stage

    new() {
        this(ArchitectureLifecycleStage.IMPLEMENTED)
    }

    new(ArchitectureLifecycleStage stage) {
        this.stage = stage
    }

    def List<String> describeRootCauses(MetricInstance metricInstance) {
       return metricInstance.scopes.flatMap[rootCauses].map[describeRootCause].toList
    }

    def String describeRootCause(Dependency dependency) {
        if (dependency.source.lifeline == dependency.target.lifeline || dependency.epoch) {
            if (dependency.resourceSharing == true) {
                return '''Detected service contention on «dependency.target.resource».'''
            } else if (dependency.scheduled == false && dependency instanceof LifelineSegment) {
                return '''Detected resource contention on «dependency.target.resource» in «(dependency as LifelineSegment).task».'''
            } else {
                return '''Detected resource contention on «dependency.target.resource».'''
            }
        } else {
            return '''Detected delay in communication between «dependency.source.resource» and «dependency.target.resource».'''
        }
    }
    
    private def getResource(Event event) {
        return stage.describeResource(event, false)
    }

    private def getTask(LifelineSegment lifelineSegment) {
        val activeExecution = lifelineSegment.activeExecution
        if (activeExecution === null) {
            return null
        }
        return stage.describeTask(activeExecution.exit, false)
    }
}
