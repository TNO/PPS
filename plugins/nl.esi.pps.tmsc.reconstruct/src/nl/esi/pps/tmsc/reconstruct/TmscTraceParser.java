/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

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
import java.util.LinkedHashSet;
import java.util.Set;

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
				throw new IOException("Failed to parse trace at line " + reader.getLineNumber(), e);
			}
		}
		
		reconstructor.postReconstruct();
	}
	
	public static TmscTraceEvent parseLine(String line) {
		return new TmscTraceEventImpl(line);
	}

	/**
	 * Parses lines with whitespace separated segments in the format:<br>
	 * [ISO8601-time-stamp] [executor-name] [component-name] [>|<] [function-name] [ [!sent-message-id] | [?received-message-id] ]*
	 */
	private static class TmscTraceEventImpl implements TmscTraceEvent {
		private final String[] segments; 
				
		public TmscTraceEventImpl(String line) {
			segments = line.split("\\s+");
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
			case ">": return EventType.ENTRY;
			case "<": return EventType.EXIT;
			default: return null;
			}
		}
		
		@Override
		public String getFunction() {
			return segments[4];
		}
		
		@Override
		public Set<String> getSentMessages() {
			Set<String> messages = new LinkedHashSet<>();
			for (int index = 5; index < segments.length; index++) {
				if (segments[index].startsWith("!")) {
					messages.add(segments[index].substring(1));
				}
			}
			return messages;
		}
		
		@Override
		public Set<String> getReceivedMessages() {
			Set<String> messages = new LinkedHashSet<>();
			for (int index = 5; index < segments.length; index++) {
				if (segments[index].startsWith("?")) {
					messages.add(segments[index].substring(1));
				}
			}
			return messages;
		}
	}
}
