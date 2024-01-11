/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.emf.synchronizedtiming.jfree;

import java.util.Date;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jdt.annotation.Nullable;
import org.jfree.data.Range;
import org.jfree.data.time.DateRange;

import nl.esi.pps.common.emf.synchronizedtiming.range.DateTimeRange;
import nl.esi.pps.common.emf.synchronizedtiming.range.EpochSecondTimeRange;
import nl.esi.pps.common.emf.synchronizedtiming.range.TimeRange;

public interface JFreeRangeToTimeRangeConverter {
	public static class DateTimeTimeRangeConverter implements JFreeRangeToTimeRangeConverter {
		protected DateTimeTimeRangeConverter() {
			
		}
		
		@Override
		public @Nullable TimeRange convert(Range range) {
			Assert.isLegal(range instanceof DateRange);

			final DateRange dateRange = (DateRange) range;

			Date lowerDate = dateRange.getLowerDate();
			Assert.isNotNull(lowerDate);

			Date upperDate = dateRange.getUpperDate();
			Assert.isNotNull(upperDate);

			return new DateTimeRange(lowerDate, upperDate);
		}
	}

	public static class EpochSecondTimeRangeConverter implements JFreeRangeToTimeRangeConverter {
		protected EpochSecondTimeRangeConverter() {
			
		}
		
		@Override
		public @Nullable TimeRange convert(Range range) {
			return new EpochSecondTimeRange(range.getLowerBound(), range.getUpperBound());
		}
	}

	public static final JFreeRangeToTimeRangeConverter EPOCH_SECOND = new EpochSecondTimeRangeConverter();

	public static final JFreeRangeToTimeRangeConverter DATE_TIME = new DateTimeTimeRangeConverter();

	/**
	 * Convert JFree time range to a time synchronization time range.
	 *
	 * @param range
	 *            The JFree time range.
	 * @return The time synchronization time range, or {@code null} if it could not
	 *         be converted.
	 */
	public @Nullable TimeRange convert(Range range);
}
