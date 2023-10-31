/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.provider.dataanalysis

import java.util.ArrayList
import java.util.Collections
import nl.esi.pps.tmsc.Event
import nl.esi.pps.tmsc.Interval
import nl.esi.pps.tmsc.TmscFactory
import nl.esi.pps.tmsc.text.EDurationFormat

import static extension nl.esi.pps.tmsc.EventType.*

/** 
 * {@link Interval} supports data analysis by providing this {@link IDataAnalysisItemContentProvider}.
 */
class IntervalDataAnalysisItemContentProvider implements IDataAnalysisItemContentProvider {
    override getConfigurations(Object object) {
        return Collections::singleton(DEFAULT_CONFIGURATION);
    }
    
    override String getTitle(Object object, String configuration) {
        val Interval interval = object as Interval
        return '''From «interval.from.type.name.toLowerCase» of «interval.from.function.name» on «interval.from.lifeline.executor.name» to «interval.to.type.name.toLowerCase» of «interval.to.function.name» on «interval.to.lifeline.executor.name»'''
    }

    override Iterable<?> getSiblings(Object object, String configuration) {
        val Interval interval = object as Interval
        val fromSiblings = getSiblings(interval.from, configuration).toList
        val toSiblings = getSiblings(interval.to, configuration).toList
        val fromIndex = fromSiblings.indexOf(interval.from)
        val toIndex = toSiblings.indexOf(interval.to)
        val fromOffset = Math.max(fromIndex - toIndex, 0)
        val toOffset = Math.max(toIndex - fromIndex, 0)
        
        val pairsSize = Math.min(fromSiblings.size - fromOffset, toSiblings.size - toOffset)
        val pairs = new ArrayList(pairsSize)
        for (var i = 0; i < pairsSize; i++) {
            val f = i + fromOffset
            val t = i + toOffset
            if (f == fromIndex && t == toIndex) {
                pairs += interval
            } else {
                pairs += TmscFactory::eINSTANCE.createMeasurement => [
                    from = fromSiblings.get(f)
                    to = toSiblings.get(t)
                    name = EDurationFormat::eINSTANCE.format(duration)
                ]
            }
        }
        return pairs
    }
    
    private def Iterable<Event> getSiblings(Event event, String configuration) {
        return event.lifeline.events.filter[eClass == event.eClass && function == event.function && component == event.component]
    }

    override Long getDuration(Object object, Object sibling, String configuration) {
        val Interval interval = sibling as Interval
        return interval.duration
    }
}
