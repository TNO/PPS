/*
 * Copyright (c) 2018-2026 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */

package nl.esi.pps.tmsc.reconstruct;

import java.util.Set;

import nl.esi.pps.tmsc.EventType;

/**
 * Represents a single traced event used by {@link TmscTraceReconstructor} to reconstruct a {@code FullScopeTMSC}.
 * Implementations provide access to the event timestamp, the executor/component/function involved, the event type, and
 * related sets such as sent/received message identifiers, metric starts/ends and arbitrary property strings.
 */
public interface TmscTraceEvent {
    /**
     * Indicates whether the timestamp returned by {@link #getTimeStamp()} is expressed as epoch nanoseconds.
     *
     * @return {@code true} when the timestamp is epoch nanoseconds
     */
    boolean isEpochTime();

    /**
     * Returns the timestamp for the event. The interpretation (epoch or relative) depends on {@link #isEpochTime()}.
     *
     * @return the event timestamp in nanoseconds or {@code null} when unknown
     */
    Long getTimeStamp();

    /**
     * Name of the executor (lifeline) that produced this event.
     *
     * @return executor name, never {@code null} when present in the trace
     */
    String getExecutor();

    /**
     * Name of the component associated with this event.
     *
     * @return component name, or {@code null} if not provided
     */
    String getComponent();

    /**
     * The type of event (e.g., entry, exit) used to create the corresponding TMSC {@code Event} instance.
     *
     * @return the EventType for this trace event
     */
    EventType getEventType();

    /**
     * Name of the function or operation associated with this event.
     *
     * @return function name, or {@code null} if not provided
     */
    String getFunction();

    /**
     * Identifiers of messages that were sent by this event. Message identifiers are used to correlate send and receive
     * events and should be unique per message.
     *
     * @return a possibly empty set of sent message ids
     */
    Set<String> getSentMessages();

    /**
     * Identifiers of messages that were received by this event.
     *
     * @return a possibly empty set of received message ids
     */
    Set<String> getReceivedMessages();

    /**
     * Identifiers of metric instances that start at this event. Metric identifiers are used to correlate start and
     * end events and should be unique per instance.
     *
     * @return a possibly empty set of metric instance ids that start here
     */
    Set<String> getMetricStarts();

    /**
     * Identifiers of metric instances that end at this event.
     *
     * @return a possibly empty set of metric instance ids that end here
     */
    Set<String> getMetricEnds();

    /**
     * Arbitrary property strings associated with the event. Each property is a string that may be either a simple name
     * or a name/value pair separated by "::" (e.g. {@code key::value}). Values are parsed by the reconstructor into
     * basic types where possible.
     *
     * @return a possibly empty set of property strings
     */
    Set<String> getProperties();
}
