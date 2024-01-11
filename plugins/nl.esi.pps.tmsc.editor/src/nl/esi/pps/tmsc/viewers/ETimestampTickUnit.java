/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.viewers;

import static java.util.concurrent.TimeUnit.HOURS;
import static java.util.concurrent.TimeUnit.MICROSECONDS;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.MINUTES;
import static java.util.concurrent.TimeUnit.NANOSECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.concurrent.TimeUnit;

import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.TickUnits;

import nl.esi.pps.tmsc.TmscPackage;
import nl.esi.pps.tmsc.text.ETimestampFormat;

public class ETimestampTickUnit extends NumberTickUnit {
	private static final long serialVersionUID = -6053257408318950798L;
	
	public ETimestampTickUnit(long size, TimeUnit unit) {
		super(unit.toNanos(size), getFormatter(unit));
	}

	private static ETimestampFormat getFormatter(TimeUnit unit) {
		switch (unit) {
		case NANOSECONDS:
			return ETimestampFormat.GMT_NANOSECONDS;
		case MICROSECONDS:
			return ETimestampFormat.GMT_MICROSECONDS;
		case MILLISECONDS:
			return ETimestampFormat.GMT_MILLISECONDS;
		default:
			return ETimestampFormat.GMT_SECONDS;
		}
	}

	/**
	 * Returns a {@link TickUnitSource} to visualize
	 * {@link TmscPackage.Literals#ETIMESTAMP ETimestamp} in the GMT time zone. The
	 * benefit of GMT is that it can be used for both relative as absolute (i..e
	 * since epoch) time-stamps.
	 */
	public static TickUnitSource createGMTTickUnits() {
		final TickUnits tickUnits = new TickUnits();
		
		tickUnits.add(new ETimestampTickUnit(1, NANOSECONDS));
		tickUnits.add(new ETimestampTickUnit(2, NANOSECONDS));
		tickUnits.add(new ETimestampTickUnit(5, NANOSECONDS));
		tickUnits.add(new ETimestampTickUnit(10, NANOSECONDS));
		tickUnits.add(new ETimestampTickUnit(20, NANOSECONDS));
		tickUnits.add(new ETimestampTickUnit(50, NANOSECONDS));
		tickUnits.add(new ETimestampTickUnit(100, NANOSECONDS));
		tickUnits.add(new ETimestampTickUnit(200, NANOSECONDS));
		tickUnits.add(new ETimestampTickUnit(500, NANOSECONDS));

		tickUnits.add(new ETimestampTickUnit(1, MICROSECONDS));
		tickUnits.add(new ETimestampTickUnit(2, MICROSECONDS));
		tickUnits.add(new ETimestampTickUnit(5, MICROSECONDS));
		tickUnits.add(new ETimestampTickUnit(10, MICROSECONDS));
		tickUnits.add(new ETimestampTickUnit(20, MICROSECONDS));
		tickUnits.add(new ETimestampTickUnit(50, MICROSECONDS));
		tickUnits.add(new ETimestampTickUnit(100, MICROSECONDS));
		tickUnits.add(new ETimestampTickUnit(200, MICROSECONDS));
		tickUnits.add(new ETimestampTickUnit(500, MICROSECONDS));

		tickUnits.add(new ETimestampTickUnit(1, MILLISECONDS));
		tickUnits.add(new ETimestampTickUnit(2, MILLISECONDS));
		tickUnits.add(new ETimestampTickUnit(5, MILLISECONDS));
		tickUnits.add(new ETimestampTickUnit(10, MILLISECONDS));
		tickUnits.add(new ETimestampTickUnit(20, MILLISECONDS));
		tickUnits.add(new ETimestampTickUnit(50, MILLISECONDS));
		tickUnits.add(new ETimestampTickUnit(100, MILLISECONDS));
		tickUnits.add(new ETimestampTickUnit(200, MILLISECONDS));
		tickUnits.add(new ETimestampTickUnit(500, MILLISECONDS));

		tickUnits.add(new ETimestampTickUnit(1, SECONDS));
		tickUnits.add(new ETimestampTickUnit(2, SECONDS));
		tickUnits.add(new ETimestampTickUnit(5, SECONDS));
		tickUnits.add(new ETimestampTickUnit(10, SECONDS));
		tickUnits.add(new ETimestampTickUnit(30, SECONDS));

		tickUnits.add(new ETimestampTickUnit(1, MINUTES));
		tickUnits.add(new ETimestampTickUnit(2, MINUTES));
		tickUnits.add(new ETimestampTickUnit(5, MINUTES));
		tickUnits.add(new ETimestampTickUnit(10, MINUTES));
		tickUnits.add(new ETimestampTickUnit(30, MINUTES));

		tickUnits.add(new ETimestampTickUnit(1, HOURS));
		tickUnits.add(new ETimestampTickUnit(2, HOURS));
		tickUnits.add(new ETimestampTickUnit(6, HOURS));
		tickUnits.add(new ETimestampTickUnit(12, HOURS));
		tickUnits.add(new ETimestampTickUnit(24, HOURS));

		return tickUnits;
	}
}
