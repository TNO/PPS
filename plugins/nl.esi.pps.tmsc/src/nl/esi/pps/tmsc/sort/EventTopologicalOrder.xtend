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
import nl.esi.pps.tmsc.Event
import nl.esi.pps.tmsc.ITMSC

package class EventTopologicalOrder implements TopologicalOrderIterator<Event> {
    extension val ITMSC tmsc
    
    val Queue<Event> enabledElements = newLinkedList
    val Map<Event, Integer> elementThreshold = newLinkedHashMap
     
    new (ITMSC tmsc) {
        this.tmsc = tmsc
        for (element : tmsc.events) {
            val threshold = element.incomingDependencies.reject[source === null].size
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
    
    override consume(Event event) {
        if (enabledElements.remove(event)) {
            val newEnabledElements = doConsume(event)
            enabledElements += newEnabledElements
            return Iterators::unmodifiableIterator(newEnabledElements.iterator)
        } else {
            throw new IllegalArgumentException('Event cannot be consumed')
        }
    }
    
    def private doConsume(Event event) {
        val newEnabledElements = newLinkedList
        for (candidate : event.outgoingDependencies.map[target].filterNull) {
            val candidateThreshold = elementThreshold.computeIfPresent(candidate) [ element, threshold |
                threshold > 1 ? threshold - 1 : null
            ]
            if (candidateThreshold === null) {
                newEnabledElements += candidate
            }
        }
        return newEnabledElements
    }
    
    override getEnabledElements() {
        return Iterators::unmodifiableIterator(enabledElements.iterator)
    }
}