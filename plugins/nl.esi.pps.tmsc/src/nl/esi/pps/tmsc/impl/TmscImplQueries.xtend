/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.impl

import java.util.Collections
import nl.esi.pps.tmsc.Dependency
import nl.esi.pps.tmsc.Event
import nl.esi.pps.tmsc.Execution
import nl.esi.pps.tmsc.FullScopeTMSC
import nl.esi.pps.tmsc.Interval
import nl.esi.pps.tmsc.Lifeline
import nl.esi.pps.tmsc.LifelineSegment
import nl.esi.pps.tmsc.ScopedTMSC
import nl.esi.pps.tmsc.TMSC

import static extension nl.esi.pps.tmsc.EventType.*
import static extension nl.esi.pps.tmsc.util.TmscQueries.*
import static extension org.eclipse.lsat.common.xtend.Queries.*

package final class TmscImplQueries {
    private new() {
        // Empty for utility classes
    }
    
    // Dispatch methods, multi-level
    
    /** @see Execution#getStartTime() */
    static dispatch def getStartTimeImpl(Execution execution) {
        return execution.entry?.timestamp
    }

    /** @see Dependency#getStartTime() */
    static dispatch def getStartTimeImpl(Dependency dependency) {
        return dependency.source?.timestamp
    }

    /** @see Interval#getStartTime() */
    static dispatch def getStartTimeImpl(Interval interval) {
        return interval.from?.timestamp
    }


    /** @see Execution#getEndTime() */
    static dispatch  def getEndTimeImpl(Execution execution) {
        return execution.exit?.timestamp
    }

    /** @see Dependency#getEndTime() */
    static dispatch  def getEndTimeImpl(Dependency dependency) {
        return dependency.target?.timestamp
    }
    
    /** @see Interval#getEndTime() */
    static dispatch  def getEndTimeImpl(Interval interval) {
        return interval.to?.timestamp
    }


    /** @see FullScopeTMSC#getEvents() */
    static dispatch def getEventsImpl(FullScopeTMSC tmsc) {
        return tmsc.lifelines.flatMap[events]
    }

    /** @see ScopedTMSC#getEvents() */
    static dispatch def getEventsImpl(ScopedTMSC tmsc) {
        return tmsc.dependencies.flatMap[events].toSet
    }
    

    /** @see FullScopeTMSC#getIncomingDependencies(Event) */
    static dispatch def getIncomingDependenciesImpl(FullScopeTMSC tmsc, Event event) {
        return event.fullScopeIncomingDependencies
    }

    /** @see ScopedTMSC#getIncomingDependencies(Event) */
    static dispatch def getIncomingDependenciesImpl(ScopedTMSC tmsc, Event event) {
        return event.fullScopeIncomingDependencies.filter[scopes.contains(tmsc)]
    }


    /** @see FullScopeTMSC#getOutgoingDependencies(Event) */
    static dispatch def getOutgoingDependenciesImpl(FullScopeTMSC tmsc, Event event) {
        return event.fullScopeOutgoingDependencies
    }

    /** @see ScopedTMSC#getOutgoingDependencies(Event) */
    static dispatch def getOutgoingDependenciesImpl(ScopedTMSC tmsc, Event event) {
        return event.fullScopeOutgoingDependencies.filter[scopes.contains(tmsc)]
    }

    
    // Class specific getters
    
    /** @see TMSC#getFullScope() */
    static def getFullScopeImpl(TMSC tmsc) {
        var fullScope = tmsc
        while (fullScope instanceof ScopedTMSC) {
            fullScope = fullScope.parentScope
        }
        return fullScope as FullScopeTMSC
    }
    
    /** @see ScopedTMSC#getFqn() */
    static def getFqnImpl(ScopedTMSC tmsc) {
        return Collections::singleton(tmsc).climbTree(true)[if (parentScope instanceof ScopedTMSC) parentScope as ScopedTMSC].reverse.map[name].join('.')
    }

    /** @see Lifeline#getSegments() */
    static def getSegmentsImpl(Lifeline lifeline) {
        return lifeline.events.flatMap[fullScopeOutgoingDependencies.filter(LifelineSegment)]
    }
    
    /** @see Lifeline#isTraced() */
    static def isTracedImpl(Lifeline lifeline) {
        return lifeline.events.exists[traced]
    }
    
    static def getRootExecutionsImpl(Lifeline lifeline) {
        return lifeline.executions.select[parent === null]
    }
    
    /** @see Event#getTmsc() */
    static def getTmscImpl(Event event) {
        return event.lifeline?.tmsc
    }

    /** @see Event#getScopes() */
    static def getScopesImpl(Event event) {
        return event.fullScopeIncomingDependencies.union(event.fullScopeOutgoingDependencies).flatMap[scopes].toSet
    }

    /** @see Event#getTmsc() */
    static def getTmscImpl(Execution execution) {
        return execution.lifeline?.tmsc
    }

    /** @see Execution#getFullScopeRoot() */
    static def getRootImpl(Execution execution) {
        var rootExecution = execution
        while (rootExecution.parent !== null) {
            rootExecution = rootExecution.parent
        }
        return rootExecution
    }
    
    /** @see Execution#getComponent() */
    static def getComponentImpl(Execution execution) {
        return execution.entry?.component ?: execution.exit?.component
    }

    /** @see Execution#getFunction() */
    static def getFunctionImpl(Execution execution) {
        return execution.entry?.function ?: execution.exit?.function
    }

    /** @see Execution#getSegments() */
    static def getSegmentsImpl(Execution execution) {
        return Collections::singleton(execution.entry).union(execution.children.map[exit]).filterNull
            .flatMap[fullScopeOutgoingDependencies.filter(LifelineSegment)]
    }
    
    /** @see CallStackDependency#getLifeline() */
    static def getLifelineImpl(LifelineSegment lifelineSegment) {
        return lifelineSegment.source?.lifeline ?: lifelineSegment.target?.lifeline
    }

    /** 
     * Different call-stack dependencies and which execution is active.
     * 
     *      +---------+         +---------+
     *     /|         |    3    |         |\
     *  1 / |<-- 2 -->|<------->|<-- 4 -->| \ 5
     *   /  |         |         |         |  \
     *  +---+---------+---------+---------+---+         +----
     *  |   |         |         |         |   |         |
     *  | 1 |         |    3    |         | 5 |<-- 6 -->|
     *  |   |                             |   |         |
     *  +-------------------------------------+         +----
     * 
     * @see CallStackDependency#getLifeline()
     */
    static def getActiveExecutionImpl(LifelineSegment lifelineSegment) {
        val sourceExecution = lifelineSegment.source?.execution
        val targetExecution = lifelineSegment.target?.execution
        
        return switch it: lifelineSegment {
            case (sourceExecution === null || targetExecution === null): null
            /* 1 */ case (source.type == ENTRY && target.type == ENTRY): sourceExecution
            /* 5 */ case (source.type == EXIT && target.type == EXIT): targetExecution
            /* 2,4 */ case (source.type == ENTRY && target.type == EXIT && sourceExecution === targetExecution): sourceExecution
            /* 3,6 */ case (source.type == EXIT && target.type == ENTRY): getCommonAncestor(sourceExecution, targetExecution)
        }
    }

    static def FullScopeTMSC getTmscImpl(Interval interval) {
        return interval.from?.tmsc ?: interval.to?.tmsc
    }
}
