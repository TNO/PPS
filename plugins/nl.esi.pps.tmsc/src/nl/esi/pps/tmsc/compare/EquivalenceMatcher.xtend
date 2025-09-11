/**
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
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
import java.util.ArrayList
import java.util.Collection
import java.util.Collections
import java.util.Iterator
import java.util.List
import java.util.function.BiPredicate
import org.eclipse.xtend.lib.annotations.Data

import static extension org.eclipse.lsat.common.queries.IteratorQueries.*
import static extension org.eclipse.lsat.common.xtend.Queries.*

class EquivalenceMatcher {
    private new() {
        // Empty for utility classes
    }

    static def <T> List<Match<T>> match(Iterable<T> left, Iterable<T> right, BiPredicate<? super T, ? super T> equivalence) {
        return match(left.iterator, right.iterator, equivalence)
    }

    static def <T> List<Match<T>> match(Iterator<T> left, Iterator<T> right, BiPredicate<? super T, ? super T> equivalence) {
        val leftGroups = left.groupBy(equivalence)
        val rightGroups = right.groupBy(equivalence)

        val result = new ArrayList(Math::max(leftGroups.size, rightGroups.size))
        // Now try to match each left group with a group from the right by comparing their heads
        for (leftGroup : leftGroups) {
            // If no match is found (i.e., rightGroup == null), this implies an additional branch at the left
            val rightGroup = rightGroups.removeFirst[rg|equivalence.test(leftGroup.head, rg.head)]
            result += new Match(leftGroup, rightGroup)
        }
        // Also add matches for the remaining branches at the right
        for (rightGroup : rightGroups) {
            result += new Match(null, rightGroup)
        }
        return result
    }

    static def <T> BiMap<T, T> matchExact(Iterable<T> left, Iterable<T> right, BiPredicate<? super T, ? super T> equivalence) {
        return matchExact(left.iterator, right.iterator, equivalence)
    }
    
    static def <T> BiMap<T, T> matchExact(Iterator<T> left, Iterator<T> right, BiPredicate<? super T, ? super T> equivalence) {
        val leftUniqueElements = left.groupBy(equivalence).filter[size == 1].flatten.toSet
        val rightUniqueElements = right.groupBy(equivalence).filter[size == 1].flatten.toSet

        val exactMatches = HashBiMap.create();
        // Now try to match each left element with an element from the right
        for (leftElement : leftUniqueElements) {
            val rightElement = rightUniqueElements.removeFirst[r|equivalence.test(leftElement, r)]
            if (rightElement !== null) {
                exactMatches.put(leftElement, rightElement)
            }
        }
        return exactMatches
    }

    @Data
    static final class Match<T> {
        // NOTE: Order is important as matches are sorted on kind!!
        enum MatchKind {
            Ambiguity,
            Addition,
            Exact
        }

        val Collection<T> left
        val Collection<T> right

        new(Collection<T> left, Collection<T> right) {
            this.left = left ?: Collections::emptySet
            this.right = right ?: Collections::emptySet
        }

        def MatchKind getKind() {
            return switch (this) {
                case left.isEmpty || right.isEmpty: MatchKind::Addition
                case left.size == 1 && right.size == 1: MatchKind::Exact
                default: MatchKind::Ambiguity
            }
        }

        override toString() {
            kind.name
        }
    }
}
