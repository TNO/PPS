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

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.xtext.xbase.lib.Pair;

import nl.esi.pps.tmsc.EventType;

public class TmscTraceParser {
	public static void parse(InputStream inputStream, TmscTraceReconstructor reconstructor) throws IOException {
		reconstructor.preReconstruct();

		try (LineNumberReader reader = new LineNumberReader(new InputStreamReader(inputStream))) {
			try {
				String line;
				while ((line = reader.readLine()) != null) {
					TmscTraceEvent traceEvent = new TmscTraceEventImpl(line);
					reconstructor.reconstruct(traceEvent);
				}
			} catch (RuntimeException e) {
				throw new IOException("Failed to parse trace at line " + reader.getLineNumber() + ": " + e.getMessage(),
						e);
			}
		}

		reconstructor.postReconstruct();
	}

	public static TmscTraceEvent parseLine(String line) {
		return new TmscTraceEventImpl(line);
	}

	/**
	 * Parses lines with whitespace separated segments in the format:<br>
	 * [ISO8601-time-stamp|BigDecimal(seconds)] [executor-name] [component-name] [>|<] [function-name] [ [!sent-message-id] | [?received-message-id] | [^metric-id::instance-id] | [$metric-id::instance-id] ]*
	 */
	private static class TmscTraceEventImpl implements TmscTraceEvent {
		private static final Pattern SEGMENTS_PATTERN = Pattern.compile("\\s*(\"(\\\\.|[^\"])*\"|\\S+)");

		private final ArrayList<String> segments = new ArrayList<>();

		public TmscTraceEventImpl(String line) {
			Matcher matcher = SEGMENTS_PATTERN.matcher(line);
			while (matcher.find()) {
				String segment = matcher.group(1);
				if (segment.startsWith("\"") && segment.endsWith("\"")) {
					segments.add(segment.substring(1, segment.length() -1).replaceAll("\\\\(.)", "$1"));
				} else {
					segments.add(segment);
				}
			}
		}

		@Override
		public boolean isEpochTime() {
			try {
				ZonedDateTime.parse(segments.get(0), DateTimeFormatter.ISO_OFFSET_DATE_TIME);
				return true;
			} catch (DateTimeParseException e) {
				return false;
			}
		}

		@Override
		public Long getTimeStamp() {
			try {
				Instant instant = ZonedDateTime.parse(segments.get(0), DateTimeFormatter.ISO_OFFSET_DATE_TIME).toInstant();
				return (instant.getEpochSecond() * 1_000_000_000) + instant.getNano();
			} catch (DateTimeParseException e) {
				try {
					return new BigDecimal(segments.get(0)).movePointRight(9).longValueExact();
				} catch (NumberFormatException | ArithmeticException e2) {
					throw new IllegalArgumentException("Failed to parse time-stamp: " + e.getMessage(), e);
				}
			}
		}

		@Override
		public String getExecutor() {
			return segments.get(1);
		}

		@Override
		public String getComponent() {
			return segments.get(2);
		}

		@Override
		public EventType getEventType() {
			switch (segments.get(3)) {
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
			return segments.get(4);
		}

		@Override
		public Set<String> getSentMessages() {
			Set<String> messages = new LinkedHashSet<>();
			for (int index = 5; index < segments.size(); index++) {
				if (segments.get(index).startsWith("!")) {
					messages.add(segments.get(index).substring(1));
				}
			}
			return messages;
		}

		@Override
		public Set<String> getReceivedMessages() {
			Set<String> messages = new LinkedHashSet<>();
			for (int index = 5; index < segments.size(); index++) {
				if (segments.get(index).startsWith("?")) {
					messages.add(segments.get(index).substring(1));
				}
			}
			return messages;
		}

		@Override
		public Set<Pair<String, String>> getMetricStarts() {
			Set<Pair<String, String>> metrics = new LinkedHashSet<>();
			for (int index = 5; index < segments.size(); index++) {
				if (segments.get(index).startsWith("^") && segments.get(index).contains("::")) {
					String[] parts = segments.get(index).substring(1).split("::", 2);
					metrics.add(Pair.of(parts[0], parts[1]));
				}
			}
			return metrics;
		}

		@Override
		public Set<Pair<String, String>> getMetricEnds() {
			Set<Pair<String, String>> metrics = new LinkedHashSet<>();
			for (int index = 5; index < segments.size(); index++) {
				if (segments.get(index).startsWith("$") && segments.get(index).contains("::")) {
					String[] parts = segments.get(index).substring(1).split("::", 2);
					metrics.add(Pair.of(parts[0], parts[1]));
				}
			}
			return metrics;
		}
	}
}
