/**
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.util

import java.util.List
import java.util.Map
import java.util.Set
import java.util.function.BiPredicate
import java.util.function.Predicate
import nl.esi.pps.tmsc.Dependency
import nl.esi.pps.tmsc.Event
import nl.esi.pps.tmsc.ScopedTMSC
import nl.esi.pps.tmsc.TmscPackage
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.SubMonitor
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.util.EcoreUtil

import static extension nl.esi.pps.tmsc.sort.TmscTopologicalOrder.*
import static extension nl.esi.pps.tmsc.util.TmscQueries.*
import static extension org.eclipse.lsat.common.xtend.Queries.*

class TmscProjection {
    public static val DEFAULT_TIME_BOUND_PROJECTION = new DependencyTimeBoundProjection()
    public static val DEFAULT_SCHEDULED_PROJECTION = new DependencyScheduledProjection()
    
    /** This is a special projection, hence private and always added, see {@link DependencyTypeProjection}. */
    static val TYPE_PROJECTION = new DependencyTypeProjection()

    val ScopedTMSC tmsc
    
    val List<DependencyFeatureProjection<Object>> featureProjections = newArrayList()
    
    new (ScopedTMSC tmsc, DependencyFeatureProjection<?>... additionalFeatureProjections) {
        this(tmsc, true, additionalFeatureProjections)        
    }

    protected new (ScopedTMSC tmsc, boolean addDefaultProjections, DependencyFeatureProjection<?>... featureProjections) {
        this.tmsc = tmsc
        var allFeatureProjections = featureProjections.union(TYPE_PROJECTION)
        if (addDefaultProjections) {
            allFeatureProjections = allFeatureProjections.union(DEFAULT_TIME_BOUND_PROJECTION, DEFAULT_SCHEDULED_PROJECTION)
        }
        allFeatureProjections.forEach[fp | this.featureProjections.add(fp as DependencyFeatureProjection<Object>)]
    }

    def Set<Dependency> projectToScope(Iterable<? extends Dependency> dependencies) {
        // Equivalent, but a slightly faster than tmsc.events.toSet
        val eventsInScope = tmsc.dependencies.flatMap[events].toSet
        return projectToScope(dependencies, null)[e | eventsInScope.contains(e)]
    }
    
    def Set<Dependency> projectToScope(Iterable<? extends Dependency> dependencies, IProgressMonitor monitor, Predicate<? super Event> scopePredicate) {
        val subMonitor = SubMonitor::convert(monitor, 100)

        val projectionSets = dependencies.findDisjunctTMSCs(scopePredicate)
        subMonitor.worked(20)
        
        subMonitor.workRemaining = projectionSets.fold(0)[$0 + $1.size]
        val projections = newLinkedHashSet()
        for (projectionSet : projectionSets) {
            subMonitor.split(projectionSet.size)
            projections += projectionSet.project[s, t | scopePredicate.test(s) && scopePredicate.test(t)]
        }
        return projections
    }

    protected def Set<Dependency> project(Iterable<? extends Dependency> dependenciesToProject, BiPredicate<? super Event, ? super Event> predicate) {
        val projections = newLinkedHashSet()
        val tmscToProject = dependenciesToProject.createCachedQueryTMSC
        // TODO: Describe this map
        val Map<Event, Map<Event, Map<DependencyFeatureProjection<Object>, Object>>> eventState = newHashMap

        for (event : tmscToProject.eventsInTopologicalOrder) {
            val incomingDependencies = tmscToProject.getIncomingDependencies(event)
            if (incomingDependencies.isEmpty) {
                // Initial event, prepare properties
                val initialEventState = featureProjections.toMap([fp | fp], [fp | fp.getInitialValue(event)])
                eventState.put(event, newLinkedHashMap(event -> initialEventState))
            } else {
                // Intermediate or final event, first calculate new feature-projection values
                val incomingEventStates = incomingDependencies.toMap([d | d], [d | eventState.get(d.source)])
                // Now get all the initial events that have a path to this event
                val initialEvents = incomingEventStates.values.flatMap[keySet].toSet
                
                for (initialEvent : initialEvents) {
                    val initialEventState = newLinkedHashMap
                    // Per initial event update the values of the feature-projections
                    for (featureProjection : featureProjections) {
                        // TODO: Try to explain this ;)
                        // Basically remapping with other keys
                        val projectionValues = incomingEventStates.entrySet.filter[value.containsKey(initialEvent)].toMap([key], [value.get(initialEvent).get(featureProjection)])
                        initialEventState.put(featureProjection, featureProjection.calculateProjectedValue(initialEvent, projectionValues))
                    }
                    
                    if (tmscToProject.isFinalEvent(event)) {
                        // Final event, do projection
                        if (predicate.test(initialEvent, event)) {
                            val projectionType = initialEventState.remove(TYPE_PROJECTION) as EClass
                            val projection = resolveProjectionDependency(initialEvent, event, projectionType)
                            initialEventState.forEach[fp, v | fp.apply(projection, v)]
                            projections += projection
                        }
                    } else {
                        eventState.computeIfAbsent(event)[newLinkedHashMap].put(initialEvent, initialEventState)
                    }
                }
            }
        }
        tmsc.dependencies += projections
        return projections
    }
    
    protected def Dependency resolveProjectionDependency(Event projectionSource, Event projectionTarget, EClass projectionType) {
        if (!TmscPackage.Literals.DEPENDENCY.isSuperTypeOf(projectionType)) {
            throw new IllegalArgumentException('Expected projectionType to be of type EClass<? extends Dependency>')
        }
        // Check if a dependency between source and target already exists,
        // preferably already within our scope (needs negation for booleans).
        // If none can be found, create a new dependency
        val sourceTargetDependencies = 
            projectionSource.fullScopeOutgoingDependencies.filter[target == projectionTarget]
                .sortBy[!scopes.contains(tmsc)]
        if (sourceTargetDependencies.isEmpty) {
            return EcoreUtil::create(projectionType) as Dependency => [
                source = projectionSource
                target = projectionTarget
                projection = true
            ]
        } else {
            return sourceTargetDependencies.head
        }
    }
    
    /**
     * Determines the type for the projection if it needs to be created. 
     * This is a special DependencyFeatureProjection as it is not applied to the projection, 
     * but is used to create the projection, hence its apply function is empty.
     * The rule for determining the projection type is:
     * <ol>
     * <li>If all dependencies of all paths are of the same type, that type is used for projection.</li>
     * <li>If one of the paths is  completely life-line segments, life-line is used for projection.</li>
     * <li>Otherwise domain-dependency is used for projection.</li>
     * </ol>
     */
    private static class DependencyTypeProjection implements DependencyFeatureProjection<EClass> {
        override calculateProjectedValue(Event projectionSource, Map<Dependency, EClass> projectionValues) {
            val types = projectionValues.entrySet.map[switch (value) {
                case null,
                case key.eClass: key.eClass
                default: TmscPackage.Literals.DOMAIN_DEPENDENCY
            }].toSet
            
            return switch (types) {
                case types.size == 1: types.head
                case types.contains(TmscPackage.Literals.LIFELINE_SEGMENT): TmscPackage.Literals.LIFELINE_SEGMENT
                default: TmscPackage.Literals.DOMAIN_DEPENDENCY
            }
        }

        override apply(Dependency projection, EClass targetFeatureValue) {
            throw new UnsupportedOperationException('Programming error, please contact PPS support!')
        }
    }

    private static class DependencyTimeBoundProjection implements DependencyFeatureProjection<Long> {
        override getInitialValue(Event projectionSource) {
            return 0L
        }
        
        override calculateProjectedValue(Event projectionSource, Map<Dependency, Long> projectionValues) {
            val validProjectionValues = projectionValues.entrySet.reject[value === null].reject[key.timeBound === null]
            if (validProjectionValues.isEmpty) {
                return null
            }
            return validProjectionValues.map[value + key.timeBound].max
        }
         
        override apply(Dependency projection, Long projectedValue) {
            if (projection.timeBound !== null && projection.timeBound != projectedValue) {
                // Expected the same time-bound to be calculated if projection is reused
                throw new IllegalArgumentException('Programming error, please contact PPS support!')
            }
            projection.timeBound = projectedValue
        }
    }

    private static class DependencyScheduledProjection implements DependencyFeatureProjection<Boolean> {
        override getInitialValue(Event projectionSource) {
            return false
        }
        
        override calculateProjectedValue(Event projectionSource, Map<Dependency, Boolean> projectionValues) {
            val validProjectionValues = projectionValues.entrySet.reject[value === null].reject[key.scheduled === null]
            if (validProjectionValues.isEmpty) {
                return null
            }
            // If a path exists that is not scheduled the result should be not scheduled, 
            // hence false, see negation at the start
            return !validProjectionValues.exists[!value && !key.scheduled]
        }
         
        override apply(Dependency projection, Boolean projectedValue) {
            if (projection.scheduled == Boolean.FALSE) {
                // If a path exists that is not scheduled the result should be not scheduled.
                // The projection itself should be considered a path as well in the comment above
                return
            }
            
            if (projection.isProjection && projection.scheduled == Boolean.TRUE && projectedValue == Boolean.FALSE) {
                // Expecting the same scheduled value to be calculated if projection is reused
                // Otherwise this could lead to side effects in subsequent analyzes
                throw new IllegalArgumentException('Programming error, please contact PPS support!')
            }
            
            if (projectedValue !== null) {
                projection.scheduled = projectedValue
            }
        }
    }
}
