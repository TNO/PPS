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

import nl.esi.pps.tmsc.Dependency
import nl.esi.pps.tmsc.FullScopeTMSC
import nl.esi.pps.tmsc.LifelineSegment

import static extension nl.esi.pps.tmsc.util.TmscQueries.*

/**
 * Applies scheduled dependency analysis, by setting the
 * {@link Dependency#setScheduled(Boolean) scheduled} attribute on dependencies
 * in <code>tmsc</code>.<br>
 * If <code>refresh</code> is <code>true</code>, the scheduled attribute will be
 * calculated for all dependencies, if <code>false</code>, scheduled will only
 * be calculated if not set yet. <br>
 * In this default implementation, {@link LifelineSegment}s without an
 * {@link LifelineSegment#getActiveExecution() active execution} are considered
 * a scheduled dependency. <br>
 * This method requires that the model contains
 * {@link #refineWithCallStacks(FullScopeTMSC) call stacks}.<br>
 * TODO: Should the scheduled attribute be a scoped attribute? If so, it should
 * be modeled as property
 */
class DefaultScheduledDependencyAnalysis {
    
    def analyzeScheduledDependencies(FullScopeTMSC tmsc) {
        analyzeScheduledDependencies(tmsc, false)
    }
    
    def analyzeScheduledDependencies(FullScopeTMSC tmsc, boolean refresh) {
        var dependencies = tmsc.dependencies.filter[shouldBeAnalyzed]
        if (!refresh) {
            dependencies = dependencies.filter[scheduled === null]
        }
        dependencies.forEach[scheduled = analyseScheduled]
    }

    /**
     * Partial traced life-line segments (i.e. start and end of trace effect) should not be analyzed as we don't know. 
     */
    protected def boolean shouldBeAnalyzed(Dependency dependency) {
        return switch (dependency) {
        	LifelineSegment: dependency.isFullyTraced
        	default: true
        }
    }

    protected def boolean analyseScheduled(Dependency dependency) {
        // Default rule: All life-line segments between call stack roots are scheduled dependencies
        return dependency instanceof LifelineSegment ? dependency.activeExecution === null : false
    }
}
