/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.jfreechart.chart.axis;

import java.io.Serializable;
import java.util.Objects;

import org.jfree.data.Range;

/**
 * Represents an immutable range of values.
 * <p>
 * The TMSC model uses 64-bits longs to store time-stamps. If epochTime is set
 * to true in the TMSC, these times are relative to the epoch (i.e. Thu Jan 01
 * 1970 00:00:00 UTC). A Java long can capture epoch nanoseconds until 2^63-1
 * nanoseconds after the epoch, i.e. Fri Apr 11 2262 23:47:16 UTC. JFreeChart
 * uses doubles an an double uses 52-bits only for its decimals. This means that
 * after 2^52-1 = Sun Feb 22 1970 02:59:59 UTC (±53 days) it will start
 * suffering from rounding errors. Due to this we will shift all time-stamps in
 * the JFreeChart dataset to to their time-in-day, relative to the epoch. With
 * this solution we know that we can show up to ±53 days of tracing without any
 * rounding errors. We choose to shift to the start-time within it day, because
 * that will not affect the visualization of time-stamps.
 * </p>
 * 
 * @see Range
 */
public final class NanoTimeRange implements Serializable {
	private static final long serialVersionUID = 8983444048660801759L;

	private final long lowerBound, upperBound;

	public NanoTimeRange(long lowerBound, long upperBound) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}

	public long getLowerBound() {
		return lowerBound;
	}

	public long getUpperBound() {
		return upperBound;
	}

	public long getLength() {
		return upperBound - lowerBound;
	}

	@Override
	public int hashCode() {
		return Objects.hash(lowerBound, upperBound);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NanoTimeRange other = (NanoTimeRange) obj;
		return lowerBound == other.lowerBound && upperBound == other.upperBound;
	}

	/**
	 * Creates a new range by adding margins to an existing range.
	 *
	 * @param range       the range ({@code null} not permitted).
	 * @param lowerMargin the lower margin (expressed as a percentage of the range
	 *                    length).
	 * @param upperMargin the upper margin (expressed as a percentage of the range
	 *                    length).
	 *
	 * @return The expanded range.
	 */
	public static NanoTimeRange expand(NanoTimeRange range, double lowerMargin, double upperMargin) {
		long length = range.getLength();
		long lower = (long) Math.floor(range.lowerBound - (length * lowerMargin));
		long upper = (long) Math.ceil(range.upperBound + (length * upperMargin));
		return new NanoTimeRange(lower, upper);
	}
}
