/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.emf.synchronizedtiming.jfree;

import org.eclipse.jdt.annotation.Nullable;
import org.jfree.data.Range;

import nl.esi.pps.common.emf.synchronizedtiming.range.TimeRange;

public interface TimeRangeToJFreeRangeConverter {
	public static final TimeRangeToJFreeRangeConverter DEFAULT = new TimeRangeToJFreeRangeConverter() {
		@Override
		public @Nullable Range convert(TimeRange range) {
			return new Range(range.getFrom().doubleValue(), range.getTo().doubleValue());
		}
	};

	/**
	 * Convert  time range to a JFree time range.
	 *
	 * @param range The time synchronization time range.
	 * @return The JFree time range, or {@code null} if it could not be converted.
	 */
	public @Nullable Range convert(TimeRange range);
}
