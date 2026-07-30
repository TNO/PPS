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

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import nl.esi.pps.tmsc.EventType;

/**
 * Parses lines with whitespace separated segments in the format:<br>
 * <code>[ISO8601-time-stamp|BigDecimal(seconds)] [executor-name] [component-name] [>|<] [function-name] [ [!sent-message-id]
 * | [?received-message-id] | [^[[category::]metric-id::]instance-id] | [$[[category::]metric-id::]instance-id] |
 * [*property-name[::property-value]]]*</code>
 */
public class TmscTraceEventImpl implements TmscTraceEvent {
    private static final Pattern SEGMENTS_PATTERN = Pattern.compile("\\s*(\"(\\\\.|[^\"])*\"|\\S+)");

    public static TmscTraceEventImpl parse(String line) throws ParseException {
        Matcher matcher = SEGMENTS_PATTERN.matcher(line);
        ArrayList<String> segments = new ArrayList<>();
        while (matcher.find()) {
            String segment = matcher.group(1);
            if (segment.startsWith("\"") && segment.endsWith("\"")) {
                segments.add(segment.substring(1, segment.length() - 1).replaceAll("\\\\(.)", "$1"));
            } else {
                segments.add(segment);
            }
        }
        if (segments.size() < 5) {
            throw new ParseException("Line must have at least 5 segments", 0);
        }
        return new TmscTraceEventImpl(segments.toArray(new String[segments.size()]));
    }

    private final String[] segments;

    protected TmscTraceEventImpl(String[] segments) {
        this.segments = segments;
    }

    @Override
    public boolean isEpochTime() {
        try {
            ZonedDateTime.parse(segments[0], DateTimeFormatter.ISO_OFFSET_DATE_TIME);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    @Override
    public Long getTimeStamp() {
        try {
            Instant instant = ZonedDateTime.parse(segments[0], DateTimeFormatter.ISO_OFFSET_DATE_TIME).toInstant();
            return (instant.getEpochSecond() * 1_000_000_000) + instant.getNano();
        } catch (DateTimeParseException e) {
            try {
                return new BigDecimal(segments[0]).movePointRight(9).longValueExact();
            } catch (NumberFormatException | ArithmeticException e2) {
                throw new IllegalArgumentException("Failed to parse time-stamp: " + e.getMessage(), e);
            }
        }
    }

    @Override
    public String getExecutor() {
        return segments[1];
    }

    @Override
    public String getComponent() {
        return segments[2];
    }

    @Override
    public EventType getEventType() {
        switch (segments[3]) {
            case ">":
                return EventType.ENTRY;
            case "<":
                return EventType.EXIT;
            default:
                return null;
        }
    }

    @Override
    public String getFunction() {
        return segments[4];
    }

    @Override
    public Set<String> getSentMessages() {
        return getValues("!");
    }

    @Override
    public Set<String> getReceivedMessages() {
        return getValues("?");
    }

    @Override
    public Set<String> getMetricStarts() {
        return getValues("^");
    }

    @Override
    public Set<String> getMetricEnds() {
        return getValues("$");
    }

    @Override
    public Set<String> getProperties() {
        return getValues("*");
    }

    protected Set<String> getValues(String prefix) {
        Set<String> values = new LinkedHashSet<>();
        for (int index = 5; index < segments.length; index++) {
            if (segments[index].startsWith(prefix)) {
                values.add(segments[index].substring(prefix.length()));
            }
        }
        return values;
    }
}
