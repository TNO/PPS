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

import com.google.common.collect.Sets
import java.util.ArrayList
import java.util.Arrays
import java.util.Collection
import java.util.Collections
import java.util.LinkedHashMap
import java.util.LinkedHashSet
import java.util.LinkedList
import java.util.List
import java.util.Map
import java.util.Set
import java.util.function.Predicate
import nl.esi.pps.architecture.implemented.Function
import nl.esi.pps.tmsc.Dependency
import nl.esi.pps.tmsc.EntryEvent
import nl.esi.pps.tmsc.Event
import nl.esi.pps.tmsc.Execution
import nl.esi.pps.tmsc.FullScopeTMSC
import nl.esi.pps.tmsc.ITMSC
import nl.esi.pps.tmsc.Interval
import nl.esi.pps.tmsc.Lifeline
import nl.esi.pps.tmsc.LifelineSegment
import nl.esi.pps.tmsc.ScopedTMSC
import nl.esi.pps.tmsc.TMSC
import nl.esi.pps.tmsc.TmscFactory
import nl.esi.pps.tmsc.text.ETimestampFormat
import org.eclipse.emf.ecore.EObject
import org.eclipse.lsat.common.util.BranchIterable
import org.eclipse.lsat.common.util.UniqueQueue
import org.eclipse.xtend.lib.annotations.Accessors

import static extension org.eclipse.lsat.common.xtend.Queries.*

final class TmscQueries {
    private new() {
        // Empty for utility classes
    }

    static def String toDebugString(Function function) '''«function?.eClass?.name»[«function?.name»]'''

    static def String toDebugString(Execution execution) '''«execution?.function?.toDebugString»«execution?.entry?.toDebugString»«execution?.exit?.toDebugString»'''

    static def String toDebugString(Dependency dependency) '''«dependency?.source?.toDebugString» -«dependency?.eClass?.name»-> «dependency?.target?.toDebugString»'''

    static def String toDebugString(Event event) '''«IF event instanceof EntryEvent»↑«ELSE»↓«ENDIF»«event?.lifeline?.executor?.name»@«ETimestampFormat::eINSTANCE.format(event?.timestamp)»'''

    static def BranchIterable<Execution> getCallStack(Execution execution) {
         Collections::singletonList(execution).walkTree(true)[children]
    }

    static def Iterable<Event> getCallStackEvents(Execution execution) {
         return switch it: execution {
            case entry !== null && exit !== null: {
                execution.getCallStackLifelineSegments.map[source].union(execution.exit)
                
            }
            case entry !== null: Collections::singletonList(entry)
            case exit !== null: Collections::singletonList(exit)
            default: Collections::emptyList
        }
    }

    static def Iterable<LifelineSegment> getCallStackLifelineSegments(Execution execution) {
        if (execution.entry === null || execution.exit === null) {
            return Collections::emptyList
        }
        return Collections::singleton(execution.entry.outgoingLifelineSegment)
            .climbTree(true)[target?.outgoingLifelineSegment].upToAndIncluding[target == execution.exit]
    }

    /**
     * Returns a list, containing the {@link Dependency#getSource() source event}
     * and/or {@link Dependency#getTarget() target event}. The list only contains an
     * event if it is not <code>null</code>.
     */
    static def List<Event> getEvents(Dependency dependency) {
        return switch it: dependency {
            case source !== null && target !== null: Arrays::asList(source, target)
            case source !== null: Collections::singletonList(source)
            case target !== null: Collections::singletonList(target)
            default: Collections::emptyList
        }
    }
    
    /**
     * Returns a list, containing the {@link Execution#getEntry() entry event}
     * and/or {@link Execution#getExit() exit event}. The list only contains an
     * event if it is not <code>null</code>.
     */
    static def List<Event> getEvents(Execution execution) {
        return switch it: execution {
            case entry !== null && exit !== null: Arrays::asList(entry, exit)
            case entry !== null: Collections::singletonList(entry)
            case exit !== null: Collections::singletonList(exit)
            default: Collections::emptyList
        }
    }

    /**
     * Returns a list, containing the {@link Interval#getFrom() from event}
     * and/or {@link Interval#getTo() to event}. The list only contains an
     * event if it is not <code>null</code>.
     */
    static def List<Event> getEvents(Interval interval) {
        return switch it: interval {
            case from !== null && to !== null: Arrays::asList(from, to)
            case from !== null: Collections::singletonList(from)
            case to !== null: Collections::singletonList(to)
            default: Collections::emptyList
        }
    }

    /**
     * Returns <code>true</code> if both {@link Dependency#getSource() source} and
     * {@link Dependency#getTarget() target} are set and both are
     * {@link Event#isTraced() traced}, <code>false</code> otherwise.
     */
    static def boolean isFullyTraced(Dependency dependency) {
        return dependency.isSourceTraced && dependency.isTargetTraced
    }

    /**
     * Returns <code>true</code> if {@link Dependency#getSource() source} is set and
     * {@link Event#isTraced() traced}, <code>false</code> otherwise.
     */
    static def boolean isSourceTraced(Dependency dependency) {
        return dependency?.source !== null && dependency.source.traced
    }

    /**
     * Returns <code>true</code> if {@link Dependency#getTarget() target} is set and
     * {@link Event#isTraced() traced}, <code>false</code> otherwise.
     */
    static def boolean isTargetTraced(Dependency dependency) {
        return dependency?.target !== null && dependency.target.traced
    }

    /**
     * Returns <code>true</code> if both {@link Execution#getEntry() entry event} and
     * {@link Execution#getExit() exit event} are set and both are
     * {@link Event#isTraced() traced}, <code>false</code> otherwise.
     */
    static def boolean isFullyTraced(Execution execution) {
        return execution.isEntryTraced && execution.isExitTraced
    }

    /**
     * Returns <code>true</code> if {@link Execution#getEntry() entry event} is set and
     * {@link Event#isTraced() traced}, <code>false</code> otherwise.
     */
    static def boolean isEntryTraced(Execution execution) {
        return execution?.entry !== null && execution.entry.traced
    }

    /**
     * Returns <code>true</code> if {@link Execution#getExit() exit event} is set and
     * {@link Event#isTraced() traced}, <code>false</code> otherwise.
     */
    static def boolean isExitTraced(Execution execution) {
        return execution?.exit !== null && execution.exit.traced
    }

    /**
     * Returns the nearest common ancestor for both <code>execution1</code> and <code>execution2</code>.
     */
    static def Execution getCommonAncestor(Execution execution1, Execution execution2) {
        val ancestors1 = Collections::singleton(execution1).climbTree(true)[parent].toSet
        val ancestors2 = Collections::singleton(execution2).climbTree(true)[parent]
        return ancestors2.findFirst[e|ancestors1.contains(e)]
    }

    /**
     * Creates a valid {@link TmscPackage.Literals#EID EID} string for
     * <code>text</code>.<br>
     * Replaces each sequence of illegal EID characters by a single '_' (underscore)
     * character.
     */
    static def String toEID(CharSequence text) {
        return if(text !== null) text.toString.replaceAll("\\W+", "_");
    }

    /**
     * Causal dependencies are defined as the intersection of the transitive closure
     * of outgoing dependencies of 'from' and the transitive closure of incoming
     * dependencies of 'to'.
     * 
     * @see #findCausalDependenciesBetween(ITMSC, Iterable, Iterable)
     */
    static def Set<Dependency> findCausalDependenciesBetween(ITMSC tmsc, Event from, Event to) {
        return findCausalDependenciesBetween(tmsc, Collections::singleton(from), Collections::singleton(to))
    }

    /**
     * Causal dependencies are defined as the intersection of the transitive closure
     * of outgoing dependencies of 'from' and the transitive closure of incoming
     * dependencies of 'to'.
     * <p>
     * Please note that, due to incomplete tracing (i.e. untraced Executors), the
     * returned set of dependencies might not contain a fully connected path. This
     * can be checked by calling {@link TmscQueries#findDisjunctTMSCs(Iterable)},
     * which should return a single entry in case of a fully connected path.
     * </p>
     */
    static def Set<Dependency> findCausalDependenciesBetween(extension ITMSC tmsc, Iterable<Event> froms, Iterable<Event> tos) {
        val minTimeStamp = froms.map[timestamp].min
        val maxTimeStamp = tos.map[timestamp].max
        if (minTimeStamp > maxTimeStamp) {
            throw new IllegalArgumentException('''From nanos («minTimeStamp») should be before to nanos («maxTimeStamp»)''')
        }
        val effect = froms.flatMap[outgoingDependencies].closure(true)[target.outgoingDependencies]
            .until[endTime > maxTimeStamp]
        val cause = tos.flatMap[incomingDependencies].closure(true)[source.incomingDependencies]
            .until[startTime < minTimeStamp]

        val causalDependencies = effect.toSet
        causalDependencies.retainAll(cause.toSet)
        return causalDependencies
    }

    /**
     * Finds the transitive closure of adjacent (a.k.a. in any direction) dependencies 
     * that match the {@code predicate} and are not before from.timestamp on the from.lifeline and 
     * not after to.timestamp on the to.lifeline.
     */
    static def Set<Dependency> findAdjacentDependenciesBetween(extension ITMSC tmsc, Event from, Event to, (Dependency)=>boolean predicate) {
        if (from.timestamp > to.timestamp) {
            throw new IllegalArgumentException('''From nanos («from.timestamp») should be before to nanos («to.timestamp»)''')
        }

        val adjacentDependencies = newLinkedHashSet

        // Do not process the from and to normally, as for the from we only want to 
        // consider its outgoing edges and for the to only its incoming edges
        val eventsToProcess = new UniqueQueue<Event>(from, to)

        // Only add TMSC dependencies between from and to both in control as well as in time
        // Find the outgoing dependencies of 'from', add them to the TMSC and mark their target as 'event-to-process'
        from.outgoingDependencies.reject[target.isAfter(to)].filter(predicate).forEach [ d |
            adjacentDependencies += d
            eventsToProcess += d.target
        ]
        // Find the incoming dependencies of 'to', add them to the TMSC and mark their source as 'event-to-process'
        to.incomingDependencies.reject[source.isBefore(from)].filter(predicate).forEach [ d |
            adjacentDependencies += d
            eventsToProcess += d.source
        ]

        // For every 'event-to-process' add its incoming and outgoing dependencies to the TMSC 
        // and mark their source and target respectively as 'event-to-process'
        while (!eventsToProcess.empty) {
            val event = eventsToProcess.remove
            if (event !== null) {
                event.outgoingDependencies.reject[target.isBefore(from)].reject[target.isAfter(to)].filter(predicate).forEach [ d |
                        adjacentDependencies += d
                        eventsToProcess += d.target
                    ]
                event.incomingDependencies.reject[source.isBefore(from)].reject[source.isAfter(to)].filter(predicate).forEach [ d |
                        adjacentDependencies += d
                        eventsToProcess += d.source
                    ]
            }
        }

        return adjacentDependencies;
    }

    private static def boolean isBefore(Event event, Event anchor) {
        // Index checking is expensive so use time-stamp if available
        return switch (event) {
            case (event.lifeline !== anchor.lifeline): false
            case (event.timestamp == anchor.timestamp): event.indexOnLifeline < anchor.indexOnLifeline
            default: event.timestamp < anchor.timestamp
        }
    }

    private static def boolean isAfter(Event event, Event anchor) {
        // Index checking is expensive so use time-stamp if available
        return switch (event) {
            case (event.lifeline !== anchor.lifeline): false
            case (event.timestamp == anchor.timestamp): event.indexOnLifeline > anchor.indexOnLifeline
            default: event.timestamp > anchor.timestamp
        }
    }

    /**
     * Returns the {@link List#indexOf(Object) index of} {@code event} within its
     * life-line.
     * 
     * @see Event#getLifeline()
     * @see Lifeline#getEvents()
     */
    private static def int indexOnLifeline(Event event) {
        return event.lifeline.events.indexOf(event)
    }

    /** 
     * Group dependencies to disjunct TMSCs (as groups of dependencies): <ol>
     * <li>When source and target of a dependency do not belong to an TMSC, assign the dependency to a new TMSC</li>
     * <li>When source or target are part of the same TMSC, then the dependency belongs to that TMSC as well</li>
     * <li>When both assigned to different TMSCs then copy the dependencies of one TMSC to the other</li>
     * </ol>
     */
    static def List<List<Dependency>> findDisjunctTMSCs(Iterable<? extends Dependency> dependencies) {
        val Map<Event, List<Dependency>> event2tmsc = newLinkedHashMap

        for (dependency : dependencies) {
            val sourceTmsc = event2tmsc.get(dependency.source)
            val targetTmsc = event2tmsc.get(dependency.target)
            if (sourceTmsc !== null && targetTmsc !== null) {
                if (sourceTmsc === targetTmsc) {
                    // Both events map to the same tmsc, so just add the dependency to that tmsc 
                    sourceTmsc += dependency
                } else if (sourceTmsc.size < targetTmsc.size) {
                    // Compare size and choose to copy the smaller to the other
                    targetTmsc += sourceTmsc
                    targetTmsc += dependency
                    // Now update the administration for all events pointing to the old list
                    sourceTmsc.map[source].union(sourceTmsc.map[target]).forEach[e|event2tmsc.put(e, targetTmsc)]
                } else /* if (sourceTmsc.size >= targetTmsc.size) */ {
                    // Compare size and choose to copy the smaller to the other
                    sourceTmsc += targetTmsc
                    sourceTmsc += dependency
                    // Now update the administration for all events pointing to the old list
                    targetTmsc.map[source].union(targetTmsc.map[target]).forEach[e|event2tmsc.put(e, sourceTmsc)]
                }
            } else if (sourceTmsc !== null) {
                // Just add the dependency to the existing TMSC
                sourceTmsc += dependency
                event2tmsc.put(dependency.target, sourceTmsc)
            } else if (targetTmsc !== null) {
                // Just add the dependency to the existing TMSC
                targetTmsc += dependency
                event2tmsc.put(dependency.source, targetTmsc)
            } else /* if (sourceTmsc === null && targetTmsc === null) */ {
                // When both are not allocated to a TMSC yet then we set both on a new TMSC
                val tmsc = newArrayList(dependency)
                event2tmsc.put(dependency.source, tmsc)
                event2tmsc.put(dependency.target, tmsc)
            }
        }

        // Return the unique TMSCs (use unique as many keys map to the same list value)
        return event2tmsc.values.unique(false).toList
    }

    /** 
     * Group dependencies to disjunct TMSCs (as groups of dependencies): <ol>
     * <li>When source and target of a dependency do not belong to an TMSC, assign the dependency to a new TMSC</li>
     * <li>When source or target are part of the same TMSC, then the dependency belongs to that TMSC as well</li>
     * <li>When both assigned to different TMSCs then copy the dependencies of one TMSC to the other</li>
     * </ol>
     * In addition, {@link Event events} that match the <tt>predicate</tt> are also considered to be both initial and final events.
     */
    static def List<List<Dependency>> findDisjunctTMSCs(Iterable<? extends Dependency> dependencies, Predicate<? super Event> predicate) {
        val Map<Event, List<Dependency>> sourceEvent2tmsc = newLinkedHashMap
        val Map<Event, List<Dependency>> targetEvent2tmsc = newLinkedHashMap

        for (dependency : dependencies) {
            val sourceTmsc = sourceEvent2tmsc.get(dependency.source)
            val targetTmsc = targetEvent2tmsc.get(dependency.target)
            val sourceInitial = predicate.test(dependency.source)
            val targetFinal = predicate.test(dependency.target)

            if (sourceTmsc !== null && targetTmsc !== null) {
                if (sourceTmsc === targetTmsc) {
                    // Both events map to the same tmsc, so just add the dependency to that tmsc 
                    sourceTmsc += dependency
                } else {
                    // Merge the two TMSCs and add the dependency (that joins them)
                    sourceTmsc += targetTmsc
                    sourceTmsc += dependency
                    // Now update the administration for all events pointing to the old TMSC
                    sourceEvent2tmsc.entrySet.filter[value === targetTmsc].forEach[value = sourceTmsc]
                    targetEvent2tmsc.entrySet.filter[value === targetTmsc].forEach[value = sourceTmsc]
                }
            } else if (sourceTmsc !== null) {
                // Just add the dependency to the existing TMSC
                sourceTmsc += dependency
                // Now register that this TMSC should be used for other dependencies to the target
                targetEvent2tmsc.put(dependency.target, sourceTmsc)
                if (!targetFinal) {
                    // If the target is not a final event, also register that this TMSC 
                    // should be used for other dependencies from the target
                    sourceEvent2tmsc.put(dependency.target, sourceTmsc)
                }
            } else if (targetTmsc !== null) {
                // Just add the dependency to the existing TMSC
                targetTmsc += dependency
                sourceEvent2tmsc.put(dependency.source, targetTmsc)
                if (!sourceInitial) {
                    targetEvent2tmsc.put(dependency.source, targetTmsc)
                }
            } else /* if (sourceTmsc === null && targetTmsc === null) */ {
                // When both are not allocated to a TMSC yet then we set both on a new TMSC
                val tmsc = newArrayList(dependency)
                sourceEvent2tmsc.put(dependency.source, tmsc)
                if (!sourceInitial) {
                    targetEvent2tmsc.put(dependency.source, tmsc)
                }
                targetEvent2tmsc.put(dependency.target, tmsc)
                if (!targetFinal) {
                    sourceEvent2tmsc.put(dependency.target, tmsc)
                }
            }
        }

        // Return the unique TMSCs (use unique as many keys map to the same list value)
        return sourceEvent2tmsc.values.union(targetEvent2tmsc.values).unique(false).toList
    }

    /**
     * Trims a TMSC, removing all events at the border that match the <tt>predicate</tt>.
     */
    static def Set<Dependency> trim(extension ITMSC tmsc, Predicate<? super Event> predicate) {
        val leadingDependencies = initialEvents.flatMap[outgoingDependencies]
            .closure(true)[target.outgoingDependencies]
            .until[!predicate.test(source)]
        val trailingDependencies = finalEvents.flatMap[incomingDependencies]
            .closure(true)[source.incomingDependencies]
            .until[!predicate.test(target)]

        val trimmedDependencies = new LinkedHashSet(tmsc.dependencies)
        trimmedDependencies.removeAll(leadingDependencies)
        trimmedDependencies.removeAll(trailingDependencies)
        return trimmedDependencies
    }

    /**
     * Returns all dependencies (including <code>dependency</code>) of the same type (i.e.
     * same {@link EObject#eClass() eClass}) between the source lifeline and target
     * lifeline of <code>dependency</code>.
     */
    static def <T extends Dependency> Iterable<T> findAllOfTypeBetweenLifelines(T dependency) {
        return dependency.source.lifeline.events.flatMap[fullScopeOutgoingDependencies].filter [
            it.eClass == dependency.eClass && it.target.lifeline == dependency.target.lifeline
        ] as Iterable<T>
    }

    /**
     * Returns all executions with the same {@link Execution#getFunction() function}
     * for the same {@link Execution#getComponent() component}
     */
    static def Iterable<Execution> findAllWithFunctionAndComponent(Execution execution) {
        return execution.tmsc.lifelines.flatMap[executions].filter [
            it.function == execution.function && it.component == execution.component
        ]
    }

    /**
     * Returns all executions with the same {@link Execution#getFunction() function}
     * for the same {@link Execution#getLifeline() lifeline}
     */
    static def Iterable<Execution> findAllWithFunctionAndLifeline(Execution execution) {
        return execution.lifeline.executions.filter [
            it.function == execution.function
        ]
    }

    /**
     * Convenience method for creating {@link ITMSC} instances that are required by some queries.
     */
    static def CachedQueryTMSC createCachedQueryTMSC(Iterable<? extends Dependency> cacheDependencies, Event... cacheOrigin) {
        return new CachedQueryTMSC(cacheDependencies) => [ cache |
            cache.origin += cacheOrigin
        ]
    }

    /**
     * Convenience method for creating {@link ITMSC} instances that are required by some queries.
     */
    static def CachedQueryTMSC createCachedQueryTMSC(Iterable<? extends Dependency> cacheDependencies, CharSequence cacheName, Event... cacheOrigin) {
        return new CachedQueryTMSC(cacheDependencies) => [ cache |
            cache.name = cacheName.toString
            cache.origin += cacheOrigin
        ]
    }

    /**
     * Convenience method for creating a {@link ScopedTMSC} instance, that does two things:
     * <ol>
     * <li>Ensures a valid {@code scopeName}, see {@link #toEID(CharSequence)}</li>
     * <li>Applies a performance improvement in adding dependencies</li>
     * </ol>
     * Please note that the resulting {@link ScopedTMSC} is not yet {@link TMSC#getChildScopes() contained}.
     */
    static def ScopedTMSC createScopedTMSC(Iterable<? extends Dependency> scopeDependencies, CharSequence scopeName, Event... scopeOrigin) {
        return TmscFactory::eINSTANCE.createScopedTMSC => [
            name = scopeName.toEID
            origin += scopeOrigin

            if (scopeDependencies instanceof Collection) {
                dependencies.addAll(scopeDependencies);
            } else {
                // IMPORTANT: Use addAll is for performance reasons. 
                // Adding a collection is faster than its individual 
                // elements due to uniqueness check of the target EList.
                dependencies.addAll(scopeDependencies.toList);
            }
        ]
    }

    /**
     * Adding a {@code child} scope might require to add (new) dependencies
     * to the {@code parent} TMSC and its ancestors.
     * Only the added dependencies are returned.
     */
    static def Set<Dependency> addScopedTMSC(TMSC parent, ScopedTMSC child) {
        parent.childScopes += child
        return parent.addDependencies(child.dependencies)
    }

    /**
     * Adds dependencies to a TMSC and its ancestors, only if they are not yet added. 
     * Only the added dependencies are returned.
     */
    static def <T extends Dependency> Set<T> addDependencies(TMSC tmsc, Iterable<T> dependencies) {
        val dependenciesToAdd = Sets.newLinkedHashSet(dependencies)
        dependenciesToAdd.removeAll(tmsc.dependencies)
        if (!dependenciesToAdd.isEmpty) {
            tmsc.dependencies += dependenciesToAdd
            if (tmsc instanceof ScopedTMSC) {
                if (tmsc.parentScope !== null) {
                    tmsc.parentScope.addDependencies(dependenciesToAdd)
                }
            }
        }
        return dependenciesToAdd
    }

    /**
     * An performance optimized version of {@code event.getScopes().contains(tmsc)}.
     */
    static def boolean isInScope(Event event, ScopedTMSC tmsc) {
        return tmsc !== null && event.fullScopeIncomingDependencies.union(event.fullScopeOutgoingDependencies).exists[scopes.contains(tmsc)]
    }
    
    static def boolean isInScope(Event event, Iterable<? extends ScopedTMSC> tmscs) {
        if (tmscs.isNullOrEmpty) {
            return false
        }
        val eventScopes = event.fullScopeIncomingDependencies.union(event.fullScopeOutgoingDependencies).flatMap[scopes]
        return eventScopes.exists[scope | tmscs.contains(scope)]
    }
    
    static def void disposeTemp(ScopedTMSC tmsc, boolean disposeTempDependencies) {
        if (tmsc.eContainer !== null) {
            throw new IllegalArgumentException(
                'This method is only intended for temporary TMCSs that are not added to the model yet')
        }
        // The order below is faster than just disposing all temp dependencies first
        val tempDependencies = disposeTempDependencies
                ? tmsc.dependencies.filter[eContainer === null].toList
                : Collections::emptyList
        Collections::singleton(tmsc).closure(true)[childScopes].forEach[dependencies.clear]
        tempDependencies.forEach[disposeTemp]
    }

    static def void disposeTemp(Iterable<? extends Dependency> dependencies) {
        val tempDependencies = dependencies.filter[eContainer === null].toList
        // The order below is faster than just disposing all temp dependencies first
        val tempDependenciesPerScope = tempDependencies.collect[d|d.scopes.map[s|s -> d]].groupBy([key], [value])
        tempDependenciesPerScope.forEach[s, d|s.dependencies.removeAll(d)]
        tempDependencies.forEach[disposeTemp]
    }

    static def void disposeTemp(Dependency dependency) {
        if (dependency.eContainer !== null) {
            throw new IllegalArgumentException(
                'This method is only intended for temporary dependencies that are not added to the model yet')
        }
        dependency.eClass.EAllStructuralFeatures.filter[changeable].forEach[f|dependency.eUnset(f)]
    }
    
    /**
     * Returns the dependencies whose events include {@code event}.
     * 
     * <p>
     * This is equal to the union of {@link Event#getFullScopeIncomingDependencies()
     * incoming } and {@link Event#getFullScopeOutgoingDependencies() outgoing }
     * dependencies.
     * </p>
     */
    static def Iterable<Dependency> getFullScopeDependencies(Event event) {
        return event.fullScopeIncomingDependencies.union(event.fullScopeOutgoingDependencies)
    }

    static def BranchIterable<Event> getPreviousEventsOnLifeline(Event event) {
        return Collections::singleton(event).climbTree[incomingLifelineSegment?.source]
    }

    static def LifelineSegment getIncomingLifelineSegment(Event event) {
        return event.fullScopeIncomingDependencies.filter(LifelineSegment).reject[projection].atMostOne
    }

    static def BranchIterable<Event> getNextEventsOnLifeline(Event event) {
        return Collections::singleton(event).climbTree[outgoingLifelineSegment?.target]
    }

    static def LifelineSegment getOutgoingLifelineSegment(Event event) {
        return event.fullScopeOutgoingDependencies.filter(LifelineSegment).reject[projection].atMostOne
    }

    static def <T> T getAtMostOne(Iterable<T> source) {
        val iterator = source.iterator
        if (iterator.hasNext) {
            val result = iterator.next
            if (iterator.hasNext) {
                throw new IllegalArgumentException('Expected at most 1 element: ' + source)
            }
            return result
        } else {
            return null
        }
    }

    static def void shiftTime(FullScopeTMSC tmsc, long delta) {
        tmsc.events.reject[timestamp === null].forEach[timestamp = timestamp + delta]
        tmsc.startTime = tmsc.startTime + delta
        tmsc.endTime = tmsc.endTime + delta
    }

    static class CachedQueryTMSC implements ITMSC {
        @Accessors
        val List<Event> origin = new ArrayList(2)

        @Accessors
        val List<Dependency> dependencies

        val Map<Event, List<Dependency>> incomingDependencies
        val Map<Event, List<Dependency>> outgoingDependencies

        @Accessors
        var String name

        new(Iterable<? extends Dependency> dependencies) {
            if (dependencies instanceof Collection) {
                this.dependencies = new ArrayList(dependencies.size)
                this.incomingDependencies = new LinkedHashMap(dependencies.size)
                this.outgoingDependencies = new LinkedHashMap(dependencies.size)
            } else {
                this.dependencies = new LinkedList()
                this.incomingDependencies = new LinkedHashMap()
                this.outgoingDependencies = new LinkedHashMap()
            }
            for (dependency : dependencies) {
                this.dependencies += dependency
                this.incomingDependencies.computeIfAbsent(dependency.target)[new ArrayList()] += dependency
                this.outgoingDependencies.computeIfAbsent(dependency.source)[new ArrayList()] += dependency
            }
        }

        override List<Dependency> getIncomingDependencies(Event event) {
            return incomingDependencies.getOrDefault(event, Collections::emptyList)
        }

        override List<Dependency> getOutgoingDependencies(Event event) {
            return outgoingDependencies.getOrDefault(event, Collections::emptyList)
        }

        override getInitialEvents() {
            val initialEvents = new LinkedHashSet(outgoingDependencies.keySet)
            initialEvents.removeAll(incomingDependencies.keySet)
            return initialEvents
        }

        override isInitialEvent(Event event) {
            return !incomingDependencies.containsKey(event)
        }

        override getFinalEvents() {
            val finalEvents = new LinkedHashSet(incomingDependencies.keySet)
            finalEvents.removeAll(outgoingDependencies.keySet)
            return finalEvents
        }

        override isFinalEvent(Event event) {
            return !outgoingDependencies.containsKey(event)
        }

        def createScopedTMSC() {
            return dependencies.createScopedTMSC(name) => [ scope |
                scope.origin += this.origin
            ]
        }
    }
}
