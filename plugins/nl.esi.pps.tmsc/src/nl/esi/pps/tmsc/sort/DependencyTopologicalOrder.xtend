/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.sort

import com.google.common.collect.Iterators
import java.util.Map
import java.util.Queue
import nl.esi.pps.tmsc.Dependency
import nl.esi.pps.tmsc.ITMSC

package class DependencyTopologicalOrder implements TopologicalOrderIterator<Dependency> {
    extension val ITMSC tmsc
    
    val Queue<Dependency> enabledElements = newLinkedList
    val Map<Dependency, Integer> elementThreshold = newLinkedHashMap
     
    new (ITMSC tmsc) {
        this.tmsc = tmsc
        for (element : tmsc.dependencies) {
            val threshold = element.source === null ? 0 : element.source.incomingDependencies.size
            if (threshold == 0) {
                enabledElements += element
            } else {
                elementThreshold.put(element, threshold)
            }
        }
    }
    
    override hasNext() {
        !enabledElements.isEmpty || !elementThreshold.isEmpty
    }
    
    override next() {
        if (enabledElements.isEmpty) {
            throw new IllegalStateException('TMSC has at least one cycle')
        }
        val next = enabledElements.remove
        enabledElements += doConsume(next)
        return next
    }

    override consume(Dependency dependency) {
        if (enabledElements.remove(dependency)) {
            val newEnabledElements = doConsume(dependency)
            enabledElements += newEnabledElements
            return Iterators::unmodifiableIterator(newEnabledElements.iterator)
        } else {
            throw new IllegalArgumentException('Dependency cannot be consumed')
        }
    }
    
    def private doConsume(Dependency dependency) {
        val newEnabledElements = newLinkedList
        if (dependency.target !== null) {
            for (candidate : dependency.target.outgoingDependencies) {
                val candidateThreshold = elementThreshold.computeIfPresent(candidate) [ element, threshold |
                    threshold > 1 ? threshold - 1 : null
                ]
                if (candidateThreshold === null) {
                    newEnabledElements += candidate
                }
            }
        }
        return newEnabledElements
    }
    
    override getEnabledElements() {
        return Iterators::unmodifiableIterator(enabledElements.iterator)
    }
}