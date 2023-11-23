/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.compare

import com.google.common.collect.BiMap
import com.google.common.collect.HashBiMap
import java.util.Comparator
import java.util.Iterator
import java.util.Map
import java.util.PriorityQueue
import java.util.Set
import java.util.function.BiPredicate
import nl.esi.pps.tmsc.Dependency
import nl.esi.pps.tmsc.EntryEvent
import nl.esi.pps.tmsc.Event
import nl.esi.pps.tmsc.ExitEvent
import nl.esi.pps.tmsc.ITMSC
import nl.esi.pps.tmsc.Interval
import nl.esi.pps.tmsc.ScopedTMSC
import nl.esi.pps.tmsc.compare.EquivalenceMatcher.Match
import nl.esi.pps.tmsc.compare.EquivalenceMatcher.Match.MatchKind
import nl.esi.pps.tmsc.sort.TmscTopologicalOrder
import nl.esi.pps.tmsc.sort.TopologicalOrderIterator
import nl.esi.pps.tmsc.util.TmscQueries.CachedQueryTMSC
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import static java.util.Collections.singleton
import static nl.esi.pps.tmsc.compare.EquivalenceMatcher.*

import static extension nl.esi.pps.tmsc.sort.TmscTopologicalOrder.*
import static extension nl.esi.pps.tmsc.util.TmscQueries.*
import static extension org.eclipse.lsat.common.queries.IteratorQueries.groupBy
import static extension org.eclipse.lsat.common.xtend.Queries.*

class TmscIsomorphismMatcher {
    static extension val Logger LOGGER = LoggerFactory.getLogger(TmscIsomorphismMatcher)

    /**
     * Typically we create a TMSC from a Metric instance. 
     * These instances know their from and to events and 
     * as such these events can be considered equivalent.
     */
    static def BiMap<Event, Event> intervalEventMatches(Interval leftInterval, Interval rightInterval,
        BiPredicate<? super Event, ? super Event> eventEquivalence) throws IllegalArgumentException {
        val map = HashBiMap.create(2)
        if (eventEquivalence.test(leftInterval.from, rightInterval.from)) {
            map.put(leftInterval.from, rightInterval.from)
        }
        if (eventEquivalence.test(leftInterval.to, rightInterval.to)) {
            map.put(leftInterval.to, rightInterval.to)
        }
        return map
    }
    
    /**
     * Discover the initial and final events matches of the left and right TMSC, 
     * based on the provided event equivalence.<br>
     * These matches can be used as initial landmarks for matching.
     */
    static def BiMap<Event, Event> discoverEventMatches(ITMSC leftTmsc, ITMSC rightTmsc,
        BiPredicate<? super Event, ? super Event> eventEquivalence) {
        val matches = matchExact(leftTmsc.initialEvents, rightTmsc.initialEvents, eventEquivalence)
        matches.putAll(matchExact(leftTmsc.finalEvents, rightTmsc.finalEvents, eventEquivalence))
        return matches
    }

    /**
     * Discover unique events matches of the left and right TMSC, 
     * based on the provided event equivalence.<br>
     * These matches can be used as initial landmarks for matching.
     * FIXME Investigate: We get worse match results when we use this 
     *                    method instead of discoverEventMatches
     */
    static def BiMap<Event, Event> discoverAllEventMatches(ITMSC leftTmsc, ITMSC rightTmsc,
        BiPredicate<? super Event, ? super Event> eventEquivalence) {
        return matchExact(leftTmsc.events, rightTmsc.events, eventEquivalence)
    }
    
    /**
     * Returns a list of lists, representing the isomorphism classes of TMSCs that are isomorphic to each other, 
     * considering the specified architecture life-cycle stage.
     */
    static def <T extends ITMSC> findIsomorphismClasses(Iterator<T> tmscs, BiPredicate<? super Event, ? super Event> eventEquivalence) {
        // Sort the groups ascending in size (first argument) as we expect the majority of the TMSCs to be in one group.
        return tmscs.groupBy([$1.size - $0.size], [left, right |
            // TODO: Typically we create a TMSC from a Metric instance. 
            // These instances know their from and to events and as such these events can be considered equivalent 
            // and thus fed to the matcher below (as an alternative to the discovery code above)
            val eventMatches = discoverEventMatches(left, right, eventEquivalence)
            return isIsomorphic(left, right, eventMatches, eventEquivalence)
        ])
    }
    
    static def boolean isIsomorphic(ITMSC leftTmsc, ITMSC rightTmsc, BiMap<Event, Event> eventMatches,
        BiPredicate<? super Event, ? super Event> eventEquivalence) {
        return match(leftTmsc, rightTmsc, eventMatches, false, eventEquivalence).isFullMatch
    }

    static def ITmscMatchResult match(ITMSC leftTmsc, ITMSC rightTmsc, BiMap<Event, Event> eventMatches,
        BiPredicate<? super Event, ? super Event> eventEquivalence) {
        return match(leftTmsc, rightTmsc, eventMatches, true, eventEquivalence)
    }

    static def ITmscMatchResult match(ITMSC leftTmsc, ITMSC rightTmsc, BiMap<Event, Event> eventMatches,
        boolean failAtEnd, BiPredicate<? super Event, ? super Event> eventEquivalence) {
        debug('Matching TMSCs {} and {}', leftTmsc.label, rightTmsc.label)
        if (eventMatches === null || eventMatches.isEmpty) {
            throw new IllegalArgumentException('This algorithm requires at least 1 event match to start.')
        } else if (!failAtEnd && leftTmsc.dependencies.size != rightTmsc.dependencies.size) {
            // TMSC are not considered to be isomorphic equivalent when they contain different amounts of dependencies
            debug('TMSCs are different: Size: {} != {}', leftTmsc.dependencies.size, rightTmsc.dependencies.size)
            return TmscMatchResult.EMPTY;
        }

        val matchState = new MatchState(leftTmsc, rightTmsc, failAtEnd)
        val nrofDependencies = matchState.leftRemainder.size + matchState.rightRemainder.size
        eventMatches.entrySet.forEach[matchState.addMatch(key, value)]

        var boolean continue
        do {
            // If a match is found, both left and right remainder will be deducted, so only checking one side satisfies
            val leftRemainingAtStart = matchState.leftRemainder.size
            continue = matchCycle(matchState, eventEquivalence) &&
                matchCycleReverse(matchState, eventEquivalence) &&
                // Only continue if this cycle produced match results
                leftRemainingAtStart > matchState.leftRemainder.size
        } while (continue && !matchState.leftRemainder.isEmpty && !matchState.rightRemainder.isEmpty)

        matchState.result.setMatchPercentage = matchState.matchedDependencies.size * 2.0 / nrofDependencies
        if (failAtEnd) {
            debug(String.format('TMSCs match for %.2f%%', matchState.result.matchPercentage * 100))
        } else if (matchState.result.isFullMatch) {
            debug('TMSCs are different!')
        } else {
            debug('TMSCs are equivalent!')
        }

        return matchState.result;
    }
    
    private static def getLabel(ITMSC tmsc) {
        val label = switch (tmsc) {
            ScopedTMSC: tmsc.fqn
            CachedQueryTMSC: tmsc.name
        }
        return label ?: tmsc?.class?.simpleName
    }
    
    private static def boolean matchCycle(extension MatchState matchState,
        BiPredicate<? super Event, ? super Event> eventEquivalence) {
        val equivalence = new DependencyEquivalence([ leftEvent, rightEvent |
            result.getRightMatch(leftEvent) == rightEvent
        ], eventEquivalence)
        val initialDependencies = startCycle[dependenciesInTopologicalOrder]

        val dependencyMatches = new PriorityQueue<Match<Dependency>>(Comparator.comparing[kind])
        // Match all initial dependencies in the topological order
        dependencyMatches += match(initialDependencies.key, initialDependencies.value, equivalence)
        while (!dependencyMatches.isEmpty) {
            val match = dependencyMatches.remove
            if (match.kind == MatchKind.Exact) {
                // Matched exactly 1 left dependency with 1 right dependency
                // This means that its target events can be considered equivalent
                val leftMatch = match.left.head
                val rightMatch = match.right.head

                try {
                    // The target events might be equivalent, yet different instances, 
                    // this means that equivalent paths lead to different event instances.
                    // As a result, these TMSCs are not isomorphic and the events 
                    // of those paths should not be considered equivalent, see catch block.
                    addMatch(leftMatch.target, rightMatch.target)
                    // Record that we found a match
                    matchedDependencies.put(leftMatch, rightMatch)
                    // Consuming the matched dependencies might enable other dependencies in its topological order
                    // These enabled dependencies are again matched for equivalence
                    dependencyMatches += match(leftMatch.consumeLeft, rightMatch.consumeRight, equivalence)
                } catch (IllegalArgumentException e) {
                    val matchLeft = leftMatch.target
                    val matchRight = rightMatch.target
                    val oldMatchLeft = result.getLeftMatch(matchRight)
                    val oldMatchRight = result.getRightMatch(matchLeft)
                    result.invalidateMatch(matchLeft, matchRight);

                    matchedDependencies.keySet.removeIf[target === matchLeft || target === oldMatchLeft]
                    matchedDependencies.values.removeIf[target === matchRight || target === oldMatchRight]
                    
                    debug('TMSC different: Equivalent paths lead to different events. {}', e.message)
                    if (!failAtEnd) {
                        return false
                    }
                    
                    // Prune these branches to allow matches after joins and add them to the remainder for the next cycle,
                    // but exclude the dependencies of this match as they are invalid
                    leftMatch.processLeftBranchInNextCycle(false)
                    rightMatch.processRightBranchInNextCycle(false)
                }
            } else {
                // Prune these branches to allow matches after joins and add them to the remainder for the next cycle
                match.left.forEach[processLeftBranchInNextCycle(true)]
                match.right.forEach[processRightBranchInNextCycle(true)]
            }
        }
        return true
    }    
    
    private static def boolean matchCycleReverse(extension MatchState matchState,
        BiPredicate<? super Event, ? super Event> eventEquivalence) {
        val reverseEquivalence = new DependencyEquivalence(eventEquivalence, [ leftEvent, rightEvent |
            result.getRightMatch(leftEvent) == rightEvent
        ])
        val initialDependencies = startCycle[dependenciesInReverseTopologicalOrder]

        val dependencyMatches = new PriorityQueue<Match<Dependency>>(Comparator.comparing[kind])
        // Match all initial dependencies in the topological order
        dependencyMatches += match(initialDependencies.key, initialDependencies.value, reverseEquivalence)
        while (!dependencyMatches.isEmpty) {
            val match = dependencyMatches.remove
            if (match.kind == MatchKind.Exact) {
                // Matched exactly 1 left dependency with 1 right dependency
                // This means that its source events can be considered equivalent
                val leftMatch = match.left.head
                val rightMatch = match.right.head

                try {
                    // The source events might be equivalent, yet different instances, 
                    // this means that equivalent paths lead to different event instances.
                    // As a result, these TMSCs are not isomorphic and the events 
                    // of those paths should not be considered equivalent, see catch block.
                    addMatch(leftMatch.source, rightMatch.source)
                    // Record that we found a match
                    matchedDependencies.put(leftMatch, rightMatch)
                    // Consuming the matched dependencies might enable other dependencies in its topological order
                    // These enabled dependencies are again matched for equivalence
                    dependencyMatches += match(leftMatch.consumeLeft, rightMatch.consumeRight, reverseEquivalence)
                } catch (IllegalArgumentException e) {
                    val matchLeft = leftMatch.source
                    val matchRight = rightMatch.source
                    val oldMatchLeft = result.getLeftMatch(matchRight)
                    val oldMatchRight = result.getRightMatch(matchLeft)
                    result.invalidateMatch(matchLeft, matchRight);

                    matchedDependencies.keySet.removeIf[source === matchLeft || source === oldMatchLeft]
                    matchedDependencies.values.removeIf[source === matchRight || source === oldMatchRight]
                    
                    debug('TMSC different: Equivalent paths lead to different events. {}', e.message)
                    if (!failAtEnd) {
                        return false
                    }
                    
                    // Prune these branches to allow matches after joins and add them to the remainder for the next cycle,
                    // but exclude the dependencies of this match as they are invalid
                    leftMatch.processLeftBranchInNextCycle(false)
                    rightMatch.processRightBranchInNextCycle(false)
                }
            } else {
                // Prune these branches to allow matches after joins and add them to the remainder for the next cycle
                match.left.forEach[processLeftBranchInNextCycle(true)]
                match.right.forEach[processRightBranchInNextCycle(true)]
            }
        }
        return true
    }    

    private static class MatchState {
        val Map<Dependency, TopologicalOrderIterator<Dependency>> leftDependency2TopologicalOrder = newLinkedHashMap
        val Map<Dependency, TopologicalOrderIterator<Dependency>> rightDependency2TopologicalOrder = newLinkedHashMap
        val Map<Dependency, Dependency> matchedDependencies = newLinkedHashMap
        val Set<Dependency> leftRemainder = newLinkedHashSet
        val Set<Dependency> rightRemainder = newLinkedHashSet
        
        val TmscMatchResult result
        val boolean failAtEnd
        
        new(ITMSC leftTmsc, ITMSC rightTmsc, boolean failAtEnd) {
            this.result = new TmscMatchResult(leftTmsc, rightTmsc)
            this.failAtEnd = failAtEnd
            this.leftRemainder += leftTmsc.dependencies
            this.rightRemainder += rightTmsc.dependencies
        }
        
        def void addMatch(Event left, Event right) throws IllegalArgumentException {
            result.addMatch(left, right)
            
            if (this.failAtEnd) {
                // TODO: Idea, can we exploit executions yield better matching results?
                // Hypothesis
                // When the entry of an execution is matched, the exit of that execution should also match, right?
                // This still needs to be validated though as functions may implement multiple returns...
                if (left instanceof EntryEvent) {
                    val leftExit = left.execution?.exit
                    val rightExit = right.execution?.exit
                    if (leftExit !== null && rightExit !== null) {
                        result.addMatch(leftExit, rightExit)
                    }
                } else if (left instanceof ExitEvent) {
                    val leftEntry = left.execution?.entry
                    val rightEntry = right.execution?.entry
                    if (leftEntry !== null && rightEntry !== null) {
                        result.addMatch(leftEntry, rightEntry)
                    }
                }
            }
        }
        
        def Pair<Set<Dependency>, Set<Dependency>> startCycle((ITMSC)=>TmscTopologicalOrder<Dependency> factory) {
            if (!isCycleDone) {
                throw new IllegalStateException('Should only be called if current cycle is done')
            }
            
            leftDependency2TopologicalOrder.clear
            val leftTopologicalOrders = leftRemainder.findDisjunctTMSCs[result.containsRightMatch(it)]
                .map[factory.apply(createCachedQueryTMSC).iterator]
            for (leftTopologicalOrder : leftTopologicalOrders) {
                leftTopologicalOrder.enabledElements.forEach[leftDependency2TopologicalOrder.put(it, leftTopologicalOrder)]
            }

            rightDependency2TopologicalOrder.clear
            val rightTopologicalOrders = rightRemainder.findDisjunctTMSCs[result.containsLeftMatch(it)]
                .map[factory.apply(createCachedQueryTMSC).iterator]
            for (rightTopologicalOrder : rightTopologicalOrders) {
                rightTopologicalOrder.enabledElements.forEach[rightDependency2TopologicalOrder.put(it, rightTopologicalOrder)]
            }
            
            leftRemainder.clear
            rightRemainder.clear

            return Pair::of(leftDependency2TopologicalOrder.keySet, rightDependency2TopologicalOrder.keySet)
        }
        
        def boolean isCycleDone() {
            return leftDependency2TopologicalOrder.values.forall[!hasNext] &&
                rightDependency2TopologicalOrder.values.forall[!hasNext]
        }
        
        def Iterator<Dependency> consumeLeft(Dependency dependency) {
            val topologicalOrder = leftDependency2TopologicalOrder.remove(dependency)
            topologicalOrder.consume(dependency).map[
                leftDependency2TopologicalOrder.put(it, topologicalOrder)
                return it
            ]
        }
        
        def void processLeftBranchInNextCycle(Dependency dependency, boolean includeSelf) {
            // The query consumes all dependencies from the topological order until the first join with another path
            // i.e. either the consume returns an empty list (as another path still prevents consumption)
            // We can use the optimized walkTree here instead of closure as the topological order prevents us from cycles already.
            leftRemainder += singleton(dependency).walkTree(includeSelf)[consumeLeft.toIterable]
        }
        
        def Iterator<Dependency> consumeRight(Dependency dependency) {
            val topologicalOrder = rightDependency2TopologicalOrder.remove(dependency)
            topologicalOrder.consume(dependency).map[
                rightDependency2TopologicalOrder.put(it, topologicalOrder)
                return it
            ]
        }
        
        def void processRightBranchInNextCycle(Dependency dependency, boolean includeSelf) {
            // The query consumes all dependencies from the topological order until the first join with another path
            // i.e. either the consume returns an empty list (as another path still prevents consumption)
            // We can use the optimized walkTree here instead of closure as the topological order prevents us from cycles already.
            rightRemainder += singleton(dependency).walkTree(includeSelf)[consumeRight.toIterable]
        }
    }
}
