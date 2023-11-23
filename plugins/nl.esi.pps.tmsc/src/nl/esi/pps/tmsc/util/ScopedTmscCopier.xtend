/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.util

import java.util.Collection
import java.util.Collections
import java.util.Map
import java.util.Set
import nl.esi.pps.tmsc.Dependency
import nl.esi.pps.tmsc.EntryEvent
import nl.esi.pps.tmsc.Event
import nl.esi.pps.tmsc.Execution
import nl.esi.pps.tmsc.ExitEvent
import nl.esi.pps.tmsc.FullScopeTMSC
import nl.esi.pps.tmsc.Lifeline
import nl.esi.pps.tmsc.LifelineSegment
import nl.esi.pps.tmsc.MessageControl
import nl.esi.pps.tmsc.ScopedTMSC
import nl.esi.pps.tmsc.TmscPackage
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.util.EcoreUtil

import static extension nl.esi.pps.tmsc.util.TmscRefinements.*
import static extension org.eclipse.emf.ecore.util.EcoreUtil.*
import static extension org.eclipse.lsat.common.xtend.Queries.*

/**
 * Creates a self contained copy of a {@link ScopedTMSC}, containing just enough content to be persisted and rendered.
 */
class ScopedTmscCopier extends EcoreUtil.Copier {
    val Set<Dependency> registeredDependencies = newHashSet
    val Set<Execution> registeredExecutions = newHashSet
    val Map<Lifeline, Set<Event>> registeredLifelineEvents = newHashMap

    private new() {
        // Private constructor for utilities
    }
    
    /**
     * Finds all {@link EcoreUtil#getRootContainer(EObject) root containers} within
     * the same {@link EObject#eResource() resource} of {@code tmsc} for which
     * applies that some {@link EObject#eAllContents() content} of {@code tmsc} root
     * container {@link #eReferred(EObject) refers} to some content of the other
     * root container.<br>
     * <br>
     * <b>NOTE:</b> This might be a rather time consuming query as the whole model content
     * may be explored. If you know what to copy, just pass it directly into
     * {@link #copyTmsc(ScopedTMSC, EObject...)}
     */
    def static EObject[] findOtherRootContainersToCopy(ScopedTMSC tmsc) {
        return tmsc.findOtherRootContainersToCopy[false]
    }

    def static EObject[] findOtherRootContainersToCopy(ScopedTMSC tmsc, (EObject)=>boolean rejectPredicate) {
        return Collections::singleton(tmsc).findOtherRootContainersToCopy(rejectPredicate)
    }
 
    def static EObject[] findOtherRootContainersToCopy(Iterable<ScopedTMSC> tmscs) {
        tmscs.findOtherRootContainersToCopy[false]
    }
    
    def static EObject[] findOtherRootContainersToCopy(Iterable<ScopedTMSC> tmscs, (EObject)=>boolean rejectPredicate) {
        val resources = tmscs.map[eResource].filterNull.toSet
        if (resources.isEmpty) {
            return newArrayOfSize(0)
        } else if (resources.size > 1) {
            throw new IllegalArgumentException('Expected all TMSCs to be contained by the same resource.')
        }
        val tmscsResource = resources.head
        val tmscsRootContainers = tmscs.map[rootContainer].toSet
        
        val otherRootContainersToCopy = tmscsResource.contents.reject(rejectPredicate).toSet
        otherRootContainersToCopy.removeAll(tmscsRootContainers)
        if (otherRootContainersToCopy.isEmpty) {
            // Stop searching, we are done
            return newArrayOfSize(0)
        }
        
        val archsRootContainers = tmscs.map[fullScope].flatMap[architectures].map[rootContainer].toSet
        if (archsRootContainers.containsAll(otherRootContainersToCopy)) {
            // The other root containers are all architectures that are referenced by the TMSCs, so just return them
            return otherRootContainersToCopy
        }
        
        // If that didn't work, try a more generic and time-consuming way: 
        // Find all content that is referred to from the TMSCs
        val referredRootContainers = tmscsRootContainers.closure(true)[eContents]
            .flatMap[eReferred].map[rootContainer].toSet
        referredRootContainers.removeAll(tmscsRootContainers)
        referredRootContainers.removeIf[c|rejectPredicate.apply(c)]
        referredRootContainers.removeIf[c|c.eResource != tmscsResource]
        
        return referredRootContainers
    }
    
    def static void deriveStartEndTime(ScopedTMSC tmsc) {
        Collections::singleton(tmsc).deriveStartEndTime
    }
    
    def static void deriveStartEndTime(Iterable<ScopedTMSC> tmscs) {
        if (tmscs.isNullOrEmpty) {
            return
        }
        val fullScope = tmscs.fullScope
        if (tmscs.exists[origin.isEmpty]) {
            // We cannot use the origin, so derive from earliest source and latest target times
            fullScope.startTime = tmscs.flatMap[dependencies].xcollectOne[source].xcollectOne[timestamp].min(fullScope.startTime)
            fullScope.endTime = tmscs.flatMap[dependencies].xcollectOne[target].xcollectOne[timestamp].max(fullScope.endTime)
        } else {
            // Use the TMSC origins to derive the start and end time
            fullScope.startTime = tmscs.flatMap[origin].xcollectOne[timestamp].min(fullScope.startTime)
            fullScope.endTime = tmscs.flatMap[origin].xcollectOne[timestamp].max(fullScope.endTime)
        }
    }
    
    private static def FullScopeTMSC getFullScope(Iterable<ScopedTMSC> tmscs) {
        val fullScopes = tmscs.map[fullScope].toSet
        if (fullScopes.size > 1) {
            throw new IllegalArgumentException('Scoped TMSCs should share same full scope.')
        }
        return fullScopes.head
    }
    
    /**
     * The equivalent of {@link EObject#eContents()}, but for
     * {@link EClass#getEAllReferences() non-containment references}.
     */
    private static def eReferred(EObject eObject) {
        eObject.eClass.EAllReferences.reject[container].flatMap[ref |
            return switch (ref) {
                case !eObject.eIsSet(ref): Collections::emptyList
            	case ref.isMany: (eObject.eGet(ref) as Iterable<EObject>)
            	default: Collections.singleton(eObject.eGet(ref) as EObject)
            }
        ]
    }
    
    /**
     * Creates a self contained copy of a {@link ScopedTMSC}, containing just enough
     * content to be persisted and rendered.
     * 
     * @param scopedSource        the TMSC to copy
     * @param otherRootContainers other root containers that should be copied as
     *                            they are referred to by {@code scopedSource}.
     * @return a mapping of all copied {@link EObject}s from their original source
     *         to their copy.
     * @see ScopedTmscCopier#findOtherRootContainersToCopy(ScopedTMSC)
     */
    def static Map<EObject, EObject> copyTmsc(ScopedTMSC scopedSource, EObject... otherRootContainers) {
        return Collections::singleton(scopedSource).copyTmscs(otherRootContainers)
    }
    
    def static Map<EObject, EObject> copyTmscs(Iterable<ScopedTMSC> scopedSources, EObject... otherRootContainers) {
        if (scopedSources.isEmpty) {
            throw new IllegalArgumentException('Expected at least 1 scoped TMSC to copy')
        }
        val fullSource = scopedSources.fullScope
        val copier = new ScopedTmscCopier
        
        // We require full executions to render a TMSC. As this is not guaranteed in a Scoped TMSC, we first need to 
        // determine all the dependencies and events that are required for a consistent TMSC that can also be rendered.
        // We register these elements to the copier such that it can perform a filtered copy, see #copyContainment(...)
        for (dependency : scopedSources.flatMap[dependencies]) {
            copier.register(dependency)
            copier.register(dependency.source?.execution)
            copier.register(dependency.target?.execution)

            if (dependency instanceof LifelineSegment) {
                copier.register(dependency.activeExecution)
            } else if (dependency instanceof MessageControl) {
                copier.register(dependency.message)
                copier.register(dependency.message.source?.execution)
                copier.register(dependency.message.target?.execution)
            }
        }
        
        // Now just copy the root container and scoped TMSCs, filtering will take care of the rest
        copier.copy(fullSource.rootContainer)
        val scopedTargets = scopedSources.map[ss | copier.copy(ss) as ScopedTMSC].toList
        val fullTarget = copier.get(fullSource) as FullScopeTMSC
        // Now add the copied ScopedTMSCs to the copied FullScopeTMSC, except for the ones that already have a parent,
        // as this means that their parent scope was copied as well.
        scopedTargets.filter[parentScope === null].forEach[parentScope = fullTarget]
        // The TMSC might refer to other elements that are also stored in the same resource, 
        // these need to be copied as well.
        copier.copyAll(otherRootContainers)
        // Done copying, call copyReferences as per API
        copier.copyReferences
        
        // As the scoped TMSC might not contain the full call stacks, we need to add missing life-line segments
        // and we need to update the execution hierarchy administration.
        fullTarget.refineWithCompleteOrder
        fullTarget.lifelines.forEach[updateCallStackHierarchy]
        
        // We're done, the copier contains a mapping of all copied objects
        return copier
    }
    
    private static def updateCallStackHierarchy(Lifeline lifeline) {
        lifeline.events.fold(null) [ Execution currentExecution, Event event |
            val eventExecution = event.execution
            return switch (event) {
                case eventExecution === null: {
                    // No executions, no call-stacks, hence nothing to do
                    currentExecution
                }
                EntryEvent: {
                    // Clear the current call-stack hierarchy for this execution
                    eventExecution.children.clear
                    // Update the hierarchy
                    if (currentExecution !== null) {
                        currentExecution.children += eventExecution
                    }
                    // Entry implies that this is the current execution on the stack
                    eventExecution
                }
                ExitEvent: {
                    // Parent child relation should have been updated for ENTRY event
                    // Exit implies that parent becomes current execution on the stack
                    eventExecution.parent
                }
            }
        ]
    }
    
    private def void register(Dependency dependency) {
        if (dependency === null) {
            return
        } 
        registeredDependencies.add(dependency)
        if (dependency.source !== null) {
            registeredLifelineEvents.computeIfAbsent(dependency.source.lifeline)[newHashSet].add(dependency.source)
        }
        if (dependency.target !== null) {
            registeredLifelineEvents.computeIfAbsent(dependency.target.lifeline)[newHashSet].add(dependency.target)
        }
    }

    private def void register(Execution execution) {
        if (execution === null) {
            return
        } 
        registeredExecutions.add(execution)
        if (execution.entry !== null) {
            registeredLifelineEvents.computeIfAbsent(execution.entry.lifeline)[newHashSet].add(execution.entry)
        }
        if (execution.exit !== null) {
            registeredLifelineEvents.computeIfAbsent(execution.entry.lifeline)[newHashSet].add(execution.exit)
        }
        
    }
    
    private def boolean isRegistered(Event event) {
        return registeredLifelineEvents.values.exists[contains(event)]
    }
    
    /**
     * Apply mapping semantics, copy once
     */
    override copy(EObject eObject) {
        val copy = get(eObject)
        return copy !== null ? copy: super.copy(eObject)
    }
    
    /** @see #copyAll(Collection) */
    def <T> Collection<T> copyAll(Iterable<? extends T> eObjects) {
        return copyAll(eObjects.toList)
    }

    /**
     * We do not want to copy the whole model, so apply filtering for specific containments.
     */
    override protected void copyContainment(EReference eReference, EObject eObject, EObject copyEObject) {
        switch (eObject) {
        	FullScopeTMSC case eReference == TmscPackage.Literals::TMSC__CHILD_SCOPES: {
        	    // Do not copy all scopes, we'll return a full scope TMSC 
        	    // with only the copied scope including its child scopes
        		return
        	}
            case eReference == TmscPackage.Literals::FULL_SCOPE_TMSC__MEASUREMENTS: {
                val source = eObject as FullScopeTMSC
                val target = copyEObject as FullScopeTMSC
                // Only copy measurements within the scoped TMSC. Using a filter guarantees the original order.
                target.measurements += copyAll(source.measurements.filter[m | m.from.isRegistered && m.to.isRegistered])
        	}
            case eReference == TmscPackage.Literals::FULL_SCOPE_TMSC__DEPENDENCIES: {
                val source = eObject as FullScopeTMSC
                val target = copyEObject as FullScopeTMSC
                // Only copy the registered dependencies. Using a filter guarantees the original order. 
                target.dependencies += copyAll(source.dependencies.filter[d | registeredDependencies.contains(d)])
            }
            case eReference == TmscPackage.Literals::FULL_SCOPE_TMSC__LIFELINES: {
                val source = eObject as FullScopeTMSC
                val target = copyEObject as FullScopeTMSC
                // Only copy the registered life-lines. Using a filter guarantees the original order. 
                target.lifelines += copyAll(source.lifelines.filter[l | registeredLifelineEvents.containsKey(l)])
            }
            case eReference == TmscPackage.Literals::LIFELINE__EVENTS: {
                val source = eObject as Lifeline
                val target = copyEObject as Lifeline
                val sourceEvents = registeredLifelineEvents.get(source)
                // Only copy the registered events. Using a filter guarantees the original order. 
                target.events += copyAll(source.events.filter[e | sourceEvents.contains(e)])
            }
            case eReference == TmscPackage.Literals::LIFELINE__EXECUTIONS: {
                val source = eObject as Lifeline
                val target = copyEObject as Lifeline
                // Only copy the registered executions. Using a filter guarantees the original order. 
                target.executions += copyAll(source.executions.filter[d | registeredExecutions.contains(d)])
            }
        	default: {
                super.copyContainment(eReference, eObject, copyEObject)
        	}
        }
    }
}
