/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.common.jfreechart.chart.axis;

import java.util.concurrent.TimeUnit;

import org.jfree.chart.axis.NumberAxis;
import org.jfree.data.Range;

/**
 * An axis for displaying nano-time data.
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
 */
public class NanoTimeAxis extends NumberAxis {
	private static final long serialVersionUID = 6999850222076054036L;

	public static final long NANOS_PER_DAY = TimeUnit.DAYS.toNanos(1);

	private long offset = 0;
	
	private Double fixedAutoRangeLowerBound = null;

	public NanoTimeAxis() {
		super();
	}

	public NanoTimeAxis(String label) {
		super(label);
	}

	public void initializeOffset(long lowerBound, boolean notify) {
		this.offset = calculateOffset(lowerBound);
		if (notify) {
			fireChangeEvent();
		}
	}

	public long getOffset() {
		return offset;
	}

	public NanoTimeRange getNanoTimeRange() {
		return getNanoTimeRange(getRange());
	}

	public NanoTimeRange getNanoTimeRange(Range range) {
		return new NanoTimeRange(toNanoTime((long) Math.floor(range.getLowerBound())),
				toNanoTime((long) Math.ceil(range.getUpperBound())));
	}

	public void setNanoTimeRange(NanoTimeRange range) {
		setNanoTimeRange(range, true, true);
	}

	public void setNanoTimeRange(NanoTimeRange range, boolean turnOffAutoRange, boolean notify) {
		super.setRange(toAxisRange(range), turnOffAutoRange, notify);
	}
	
	/**
	 * @see #setFixedAutoRange(Double, double)
	 */
	public void setFixedAutoRange(Range range) {
		fixedAutoRangeLowerBound = range.getLowerBound();
		super.setFixedAutoRange(range.getLength());
	}

	/**
	 * Use {@code null} for {@code lower} to unset the lower-bound for the fixed-auto-range. 
	 * @see #setFixedAutoRange(double)
	 */
	public void setFixedAutoRange(Double lower, double length) {
		fixedAutoRangeLowerBound = lower;
		super.setFixedAutoRange(length);
	}
	
	@Override
	public Range calculateAutoRange(boolean adhereToMax) {
		double fixedAutoRange = getFixedAutoRange();
		if (adhereToMax && fixedAutoRangeLowerBound != null && getPlot() != null && fixedAutoRange > 0.0) {
            return new Range(fixedAutoRangeLowerBound, fixedAutoRangeLowerBound + fixedAutoRange);
		}
		return super.calculateAutoRange(adhereToMax);
	}
	
	public long toNanoTime(long axisValue) {
		return axisValue + offset;
	}

	public long toAxisValue(long nanoTime) {
		return nanoTime - offset;
	}

	public Range toAxisRange(NanoTimeRange range) {
		return toAxisRange(range.getLowerBound(), range.getUpperBound());
	}

	public Range toAxisRange(long lowerBound, long upperBound) {
		return new Range(toAxisValue(lowerBound), toAxisValue(upperBound));
	}

	public static long calculateOffset(long lowerBound) {
		final long lowerBoundWithinDay = lowerBound % NANOS_PER_DAY;
		return lowerBound - lowerBoundWithinDay;
	}
}
