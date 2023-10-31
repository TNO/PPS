/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.util

import java.util.ArrayList
import java.util.List
import nl.esi.pps.tmsc.EntryEvent
import nl.esi.pps.tmsc.Event
import nl.esi.pps.tmsc.Execution
import nl.esi.pps.tmsc.ExitEvent
import nl.esi.pps.tmsc.FullScopeTMSC
import nl.esi.pps.tmsc.Lifeline
import nl.esi.pps.tmsc.LifelineSegment
import nl.esi.pps.tmsc.TmscFactory
import org.eclipse.lsat.common.util.PairwiseIterable

final class TmscRefinements {
    static extension val TmscFactory m_tmsc = TmscFactory.eINSTANCE

    private new() {
        // Empty for utility classes
    }

    /**
     * This method adds {@link LifelineSegment lifeline-segments} to guarantee the
     * order of events on a {@link Lifeline}.<br>
     * This method requires that the {@link Lifeline#getEvents() events on a lifeline} 
     * are ordered in the execution order that they occur.
     */
    static def void refineWithCompleteOrder(FullScopeTMSC tmsc) {
        tmsc.lifelines.forEach[refineWithCompleteOrder]
    }

    /**
     * This method adds {@link LifelineSegment lifeline-segments} to guarantee the
     * order of events on a {@link Lifeline}.<br>
     * This method requires that the {@link Lifeline#getEvents() events on a lifeline} 
     * are ordered in the execution order that they occur.
     */
    static def void refineWithCompleteOrder(Lifeline lifeline) {
        lifeline.tmsc.dependencies += PairwiseIterable::of(lifeline.events)
            .reject[lifelineSegmentExists(left, right)]
            .map[ pair |
                // Create LifelineSegment if not already present
                createLifelineSegment => [
                    source = pair.left
                    target = pair.right
                ]
            ]
    }

    private static def boolean lifelineSegmentExists(Event _source, Event _target) {
        return _target.fullScopeIncomingDependencies.filter(LifelineSegment).exists[source == _source]
    }

    /**
     * This method adds {@link Execution executions} to a {@link Lifeline} that
     * represent call-stacks over time.<br>
     * This method requires that the {@link Lifeline#getEvents() events on a lifeline} 
     * are ordered in the execution order that they occur.
     */
    static def void refineWithCallStacks(FullScopeTMSC tmsc) {
        tmsc.lifelines.forEach[refineWithCallStacks]
    }

    /**
     * This method adds {@link Execution executions} to a {@link Lifeline} that
     * represent call-stacks over time.<br>
     * This method requires that the {@link Lifeline#getEvents() events on a lifeline} 
     * are ordered in the execution order that they occur.
     */
    static def void refineWithCallStacks(Lifeline lifeline) {
        if (!lifeline.executions.isEmpty) {
            throw new IllegalArgumentException('Programming error: please remove all executions before calling this method')
        }
        
        var Execution currentExecution = null
        var List<Execution> rootExecutions = newLinkedList()

        for (event : new ArrayList(lifeline.events)) {
            switch (event) {
                EntryEvent: {
                    val execution = createExecution
                    lifeline.executions += execution
                    execution.entry = event
                    execution.parent = currentExecution
                    if (execution.parent === null) {
                        rootExecutions += execution
                    }
                    currentExecution = execution
                }
                ExitEvent: {
                    switch (currentExecution) {
                        case null: {
                            // Start-of-trace effect (i.e. execution started before trace started) is supported
                            val execution = createExecution
                            lifeline.executions += execution
                            execution.exit = event
                            // This execution now becomes the new root execution for this component
                            execution.children += rootExecutions
                            rootExecutions = newLinkedList(execution)

                            // The TMSC model requires an event for the dependency source, 
                            // so create one, but mark as untraced
                            execution.entry = createEntryEvent
                            execution.entry.traced = false
                            execution.entry.timestamp = lifeline.tmsc.startTime
                            execution.entry.component = event.component
                            execution.entry.function = event.function
                            lifeline.tmsc.dependencies += createLifelineSegment => [
                                source = execution.entry
                                target = lifeline.events.head
                            ]
                            lifeline.events.add(0, execution.entry)
                        }
                        case currentExecution.function != event.function: {
                            throw new IllegalStateException('''Expected function «event.function», but was «currentExecution.function». This could be caused by dropped events or to incorrect ordering of events.''')
                        }
                        default: {
                            currentExecution.exit = event
                            currentExecution = currentExecution.parent
                        }
                    }
                }
            }
        }

        // End-of-trace effect (i.e. execution ended after trace ended) is supported
        // The TMSC model requires an event for the execution exit, so create one
        if (!rootExecutions.isEmpty) {
            rootExecutions.last.createExitEvent
        }
    }

    private static def ExitEvent createExitEvent(Execution execution) {
        if (execution.exit !== null) {
            // Nothing to do
            return execution.exit
        }
        // Delegate first for correct event order on Lifeline
        val lifelineSegmentSource = execution.children.isEmpty ? execution.entry : 
            execution.children.last.createExitEvent

        execution.exit = createExitEvent
        execution.exit.traced = false
        execution.exit.timestamp = execution.tmsc.endTime
        execution.exit.component = execution.entry.component
        execution.exit.function = execution.entry.function
        execution.lifeline.events += execution.exit
        execution.tmsc.dependencies += createLifelineSegment => [
            source = lifelineSegmentSource
            target = execution.exit
        ]
        return execution.exit
    }
}
