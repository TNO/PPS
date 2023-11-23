/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.analysis

import java.util.Map
import nl.esi.pps.tmsc.Dependency
import nl.esi.pps.tmsc.Event
import nl.esi.pps.tmsc.FullScopeTMSC
import nl.esi.pps.tmsc.Lifeline
import nl.esi.pps.tmsc.LifelineSegment
import nl.esi.pps.tmsc.Message
import nl.esi.pps.tmsc.MessageControl
import org.eclipse.emf.ecore.EClass
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

import static extension nl.esi.pps.tmsc.util.TmscQueries.*

@FinalFieldsConstructor
class DefaultTimeBoundAnalysis {
    val Map<MinimumDurationKey, Long> minimumDurationCache = newHashMap

    val long defaultTimeBound
    
    def void analyzeTimeBounds(FullScopeTMSC tmsc) {
        tmsc.lifelines.flatMap[events].forEach[analyzeTimeBounds]
    }
    
    def void analyzeTimeBounds(Event event) {
        val incomingDependencies = event.fullScopeIncomingDependencies.reject[duration === null].filter[shouldBeAnalyzed]

        // Everything except life-line segments and executions is considered to be a message for this analysis.
        // For messages that are transitive, their time-bound should not be analyzed
        val messages = incomingDependencies.reject(LifelineSegment).toSet
        
        val lifelineSegment = incomingDependencies.filter(LifelineSegment).atMostOne
        var lifelineSegmentCritical = false
        
        for (tracedMessage : messages.filter[isFullyTraced]) {
            // Fully traced message, we can use a choice mechanism
            // Check if the life-line was already awaiting the message at time of the message start.
            // If so, message is critical, hence timeBound = duration.
            // Otherwise the life-line segment is critical.
            
            // The startTime of the message, optionally delayed with the time-out of the message.
            val tracedMessageActualStartTime = tracedMessage.startTime + tracedMessage.timeout
            // Start-of-trace effect, the first event on a life-line and non-traced events do not have an incoming 
            // life-line segment, just assume the message to be critical in that case.
            if (lifelineSegment === null || tracedMessageActualStartTime >= lifelineSegment.startTime) {
                tracedMessage.setSafeTimeBound(tracedMessage.duration)
            } else {
                // As the traced message is not critical, the life-line segment is
                lifelineSegmentCritical = true
                // As the traced message is not critical, we should guess its time-bound
                tracedMessage.setSafeTimeBound(tracedMessage.defaultTimeBound)
            }
        }
       
        if (lifelineSegment !== null) {
            if (!lifelineSegmentCritical && (!messages.isEmpty || event.isWaitEvent)) {
                // The life-line segment was never critical (or no traced messages were found),
                // yet the life-line is awaiting a message - or expected to - 
                // we base its criticalness on a timing heuristic.
                val lifelineSegmentDefaultTimeBound = lifelineSegment.defaultTimeBound
                lifelineSegmentCritical = lifelineSegment.duration <= lifelineSegmentDefaultTimeBound
                // Setting the time-bound of the life-line segment, based on its criticalness
                lifelineSegment.setSafeTimeBound(
                    lifelineSegmentCritical ? lifelineSegment.duration : lifelineSegmentDefaultTimeBound)
            } else {
                // Critical or not awaiting a message just means critical
                lifelineSegment.setSafeTimeBound(lifelineSegment.duration)
            }
        }
        
        if (!lifelineSegmentCritical) {
            // Assuming all non-traced messages to be critical, as the life-line segment took too much time, 
            // hence timeBound = duration
            messages.reject[isFullyTraced].forEach[setSafeTimeBound(duration)]
        } else {
            // For non-traced messages we just cannot say anything about their time-bound when not critical,
            // hence leave it empty, i.e. null. The depending algorithms should just ignore these dependencies.
            messages.reject[isFullyTraced].forEach[setSafeTimeBound(null)]
        }
    }
    
    /**
     * Returns {@code true} if time-bound should be analyzed for {@code dependency}.
     */
    protected def boolean shouldBeAnalyzed(Dependency dependency) {
        return switch it : dependency {
            case projection : false
            LifelineSegment,
            MessageControl,
            // When the message has control dependencies, 
            // the message itself is transitive and should not be analyzed
            Message case (controlDependencies.isEmpty): true
            default: false
        }
    }

    /**
     * Returns {@code true} if the {@code event} is expected to await some message
     * before the application continues.
     */
    protected def boolean isWaitEvent(Event event) {
        return event.execution !== null && event.execution.parent === null
    }
    
    protected def long getTimeout(Dependency dependency) {
        return 0L
    }
    
    protected def long getDefaultTimeBound(Dependency dependency) {
        if (dependency instanceof LifelineSegment) {
            return defaultTimeBound
        }

        val dependencyDelay = dependency.timeout
        if (dependencyDelay > 0) {
            return dependencyDelay
        }
        
        if (dependency instanceof Message || dependency instanceof MessageControl) {
            // The duration of critical messages indicate the latency, 
            // just use the minimum latency as observed in the trace
            val messageLatency = dependency.minimumDuration
            if (messageLatency < dependency.duration) {
                // This function is only called for non-critical dependencies, 
                // so the latency should always be less than the duration.
                return messageLatency
            }
        }

        return defaultTimeBound
    }

    /** Sets the {@code dependency} time-bound, ensuring that it will never be greater than its duration. */
    private def void setSafeTimeBound(Dependency dependency, Long timeBound) {
        if (timeBound === null || dependency.duration === null) {
            dependency.timeBound = null
        } else {
            // TimeBound of a dependency can never be greater than its duration
            dependency.timeBound = Math::min(dependency.duration, timeBound)
        }
    }
    
    protected def long getMinimumDuration(Dependency dependency) {
        // As messages in our domain indicate the latency, just use the minimum latency as observed in the trace
        return minimumDurationCache.computeIfAbsent(new MinimumDurationKey(dependency))[computeMinimumDuration]
    }

    @Data
    private static class MinimumDurationKey {
        val Lifeline from
        val Lifeline to
        val EClass dependencyType
        val boolean messageControl
        
        new (Dependency dependency) {
            from = dependency.source?.lifeline
            to = dependency.target?.lifeline
            if (dependency instanceof MessageControl) {
                dependencyType = dependency.message.eClass
                messageControl = true
            } else {
                dependencyType = dependency.eClass
                messageControl = false
            }
        }
        
        def computeMinimumDuration() {
            var Iterable<? extends Dependency> siblings = 
                    from.events.flatMap[fullScopeOutgoingDependencies].filter[target?.lifeline == to]
            if (messageControl) {
                // For message-control dependencies (a.k.a. message detect dependencies), make sure that
                // the comparison material is only for detects of the same message type. 
                // Rationale: the latency for a CN message, that is transferred via TCP/IP, may differ
                // from an EH CPU event which is transferred via a named pipe. 
                siblings = siblings.filter(MessageControl).filter[message.eClass == dependencyType]                
            } else {
                siblings = siblings.filter[eClass == dependencyType]
            }
            return siblings.map[duration].filterNull.min
        }
    }
}