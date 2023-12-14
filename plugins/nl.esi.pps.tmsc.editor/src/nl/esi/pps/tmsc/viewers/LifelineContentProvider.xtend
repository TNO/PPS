/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.viewers

import java.util.Collections
import java.util.Set
import nl.esi.pps.architecture.deployed.Host
import nl.esi.pps.architecture.implemented.Function
import nl.esi.pps.architecture.instantiated.Executor
import nl.esi.pps.architecture.instantiated.ExecutorGroup
import nl.esi.pps.architecture.specified.Component
import nl.esi.pps.architecture.specified.Interface
import nl.esi.pps.architecture.specified.Operation
import nl.esi.pps.common.emf.ui.ContextAwareAdapterFactoryContentProvider
import nl.esi.pps.tmsc.Dependency
import nl.esi.pps.tmsc.Event
import nl.esi.pps.tmsc.Execution
import nl.esi.pps.tmsc.FullScopeTMSC
import nl.esi.pps.tmsc.Interval
import nl.esi.pps.tmsc.Lifeline
import nl.esi.pps.tmsc.LifelineSegment
import nl.esi.pps.tmsc.ScopedTMSC
import nl.esi.pps.tmsc.metric.Metric
import nl.esi.pps.tmsc.metric.MetricInstance
import org.eclipse.emf.common.notify.AdapterFactory
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.ResourceSet

import static extension nl.esi.pps.tmsc.util.TmscQueries.*
import static extension org.eclipse.lsat.common.xtend.Queries.*

/** 
 * Content provider that queries the applicable {@link Lifeline lifelines} for
 * the current context.<br>
 */
class LifelineContentProvider extends ContextAwareAdapterFactoryContentProvider<Lifeline> {
    new(AdapterFactory adapterFactory) {
        super(adapterFactory, Lifeline,
            // TMSC contexts 
            FullScopeTMSC, ScopedTMSC, Lifeline, Execution, Event, Dependency, Interval, 
            // Architecture contexts
            ExecutorGroup, Executor, Host, Component, Function, Operation, Interface,
            // Metric contexts
            Metric, MetricInstance,
            // Performance optimization
            ResourceSet
        )
    }
    
    override protected findContentWithinContext(Object element, Set<Lifeline> content) {
        super.findContentWithinContext(element, content)
        content.remove(null)
    }
    
    override protected void findContent(Object context, Set<Lifeline> content) {
        switch (context) {
            // TMSC contexts 
            FullScopeTMSC: {
                content += context.lifelines
            }
            ScopedTMSC case (context.fullScope !== null): {
                // Bugfix: when a scope is selected in the outline and then removed (i.e. undo command),
                // the fullScope becomes null, resulting in a NullpointerException, hence the null
                // check in this case
                content += context.fullScope.lifelines.select[events.exists[isInScope(context)]]
            }
            Lifeline: {
                content += context
                content += context.events.flatMap[connectedLifelines]
            }
            Execution: {
                content += context.lifeline
                content += Collections::singleton(context).walkTree(true)[children].flatMap[events].flatMap[connectedLifelines]
            }
            Event: {
                content += context.lifeline
                content += context.connectedLifelines
            }
            Dependency: {
                content += context.source?.lifeline
                content += context.target?.lifeline
            }
            Interval: {
                content += context.from?.lifeline
                content += context.to?.lifeline
                if (!context.scopes.isEmpty && context.tmsc !== null) {
                    // If an interval contains analysis results (i.e. scopes), also show their content.
                    content += context.tmsc.lifelines.select[events.exists[isInScope(context.scopes)]]
                }
            }
            // Architecture contexts
            ExecutorGroup: {
                val executors = context.executors
                content += context.findLifelines.filter[executors.contains(executor)]
            }
            Executor: {
                // IMPORTANT: Selecting an Executor should only view its life-line and not query its connected 
                // life-lines like it is done for Lifeline itself. This behavior is used by the life-line order 
                // optimizer and (in the future) the offline activity debugger
                content += context.findLifelines.filter[executor == context]
            }
            Host: {
                content += context.findLifelines.filter[executor.host == context]
            }
            Component: {
                content += context.findLifelines.filter[events.exists[component == context]]
            }
            Function: {
                content += context.findLifelines.filter[events.exists[function == context]]
            }
            Operation: {
                content += context.findLifelines.filter[events.exists[function.operation == context]]
            }
            Interface: {
                content += context.findLifelines.filter[events.exists[function.operation?.interface == context]]
            }
            // Metric contexts
            Metric: {
                content += context.instances.map[from?.lifeline]
                content += context.instances.map[to?.lifeline]
            }
            // Performance optimization, do not query whole resource set as it will trigger all queries above
            ResourceSet: {
                content += context.findLifelines
            }
            default: {
                super.findContent(context, content)
            }
        }
    }
    
    def protected getConnectedLifelines(Event event) {
        val adjacentEvents = event.fullScopeOutgoingDependencies.reject(LifelineSegment).xcollectOne[target]
                .union(event.fullScopeIncomingDependencies.reject(LifelineSegment).xcollectOne[source])
        return adjacentEvents.map[lifeline]
    }
    
    def protected findLifelines(EObject eObject) {
        return eObject?.eResource?.resourceSet?.findLifelines ?: Collections::emptySet
    }

    def protected findLifelines(ResourceSet resourceSet) {
        // FullScopeTMSC is considered to be a root element
        return resourceSet.resources.flatMap[contents].filter(FullScopeTMSC).flatMap[lifelines]
    }
}
