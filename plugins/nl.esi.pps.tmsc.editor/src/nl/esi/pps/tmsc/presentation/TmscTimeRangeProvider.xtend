/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.presentation

import nl.esi.pps.common.emf.synchronizedtiming.range.EpochNanoTimeRange
import nl.esi.pps.common.emf.synchronizedtiming.range.RelativeNanoTimeRange
import nl.esi.pps.common.emf.synchronizedtiming.range.TimeRange
import nl.esi.pps.tmsc.Event
import nl.esi.pps.tmsc.ITimeRange
import nl.esi.pps.tmsc.Lifeline
import nl.esi.pps.tmsc.ScopedTMSC
import org.eclipse.xtend.lib.annotations.Data

/**
 * Calculates the required time-range to visualize a TMSC element or sequence of elements completely.
 */
class TmscTimeRangeProvider {
    static def TimeRange getTimeRange(Object object) {
        return doGetTimeRange(object)?.toTimeRange
    }
    
    @Data
    private static class NanoTimeRange {
        val boolean epoch
        val long start
        val long end
        
        new(boolean epoch ,long start, long end) {
            this.epoch = epoch
            this.start = Math.min(start, end)
            this.end = Math.max(start, end)
        }
        
        def toTimeRange() {
            // Add a margin of 5% or minimal 5ns
            val margin = Math::max(Math::round((end - start) * 0.05), 5)
            val mStart = Math::max(start - margin, 0)
            val mEnd = end + margin
            return epoch ? new EpochNanoTimeRange(mStart, mEnd) : new RelativeNanoTimeRange(mStart, mEnd)
        }
    }
    
    private static dispatch def NanoTimeRange doGetTimeRange(Object object) {
        return null
    }
    
    private static dispatch def NanoTimeRange doGetTimeRange(NanoTimeRange timeRange) {
        return timeRange
    }

    private static dispatch def NanoTimeRange doGetTimeRange(Iterable<?> elements) {
        val timeRanges = elements.map[doGetTimeRange].filterNull.toList
        return switch (timeRanges.size) {
            case 0: {
                null
            }
            case 1: {
                timeRanges.head
            }
            default: {
                if (!timeRanges.tail.forall[epoch == timeRanges.head.epoch]) {
                    throw new IllegalArgumentException
                }
                new NanoTimeRange(timeRanges.head.epoch, timeRanges.map[start].min, timeRanges.map[end].max)
            }
        }
    }

    private static dispatch def NanoTimeRange doGetTimeRange(ITimeRange timeRange) {
        return if (timeRange.duration !== null) {
            new NanoTimeRange(timeRange.epochTime, timeRange.startTime, timeRange.endTime)
        }
    }

    private static dispatch def NanoTimeRange doGetTimeRange(Event event) {
        return if (event.timestamp !== null) {
            new NanoTimeRange(event.tmsc.epochTime, event.timestamp, event.timestamp)
        }
    }

    private static dispatch def NanoTimeRange doGetTimeRange(ScopedTMSC tmsc) {
        val events = tmsc.origin.isEmpty ? tmsc.events : tmsc.origin
        val eventTimeStamps = events.map[timestamp].filterNull
        return if (!eventTimeStamps.isEmpty) {
            new NanoTimeRange(tmsc.fullScope.epochTime, eventTimeStamps.min, eventTimeStamps.max)
        }
    }

    private static dispatch def NanoTimeRange doGetTimeRange(Lifeline lifeline) {
        val eventTimeStamps = lifeline.events.map[timestamp].filterNull
        return if (!eventTimeStamps.isEmpty) {
            new NanoTimeRange(lifeline.tmsc.epochTime, eventTimeStamps.min, eventTimeStamps.max)
        }
    }
}
