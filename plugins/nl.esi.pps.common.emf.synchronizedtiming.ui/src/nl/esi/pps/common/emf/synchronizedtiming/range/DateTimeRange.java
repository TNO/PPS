/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.common.emf.synchronizedtiming.range;

import java.util.Date;

public class DateTimeRange implements TimeRange {
	private final Date from;
	private final Date to;

	public DateTimeRange(Date from, Date to) {
		this.from = from;
		this.to = to;
	}

	public DateTimeRange(long from, long to) {
		this(new Date(from), new Date(to));
	}

	public Date getFromDate() {
		return from;
	}

	@Override
	public Number getFrom() {
		return from.getTime();
	}

	public Date getToDate() {
		return to;
	}

	@Override
	public Number getTo() {
		return to.getTime();
	}

	@Override
	@SuppressWarnings({ "unchecked", "null" })
	public <T extends TimeRange> T convertTo(Class<T> type) {
		if (type == getClass()) {
			return (T) this;

		} else if (type == EpochSecondTimeRange.class) {
			return (T) new EpochSecondTimeRange(getFrom().doubleValue() / 1000, getTo().doubleValue() / 1000);

		} else if (type == EpochNanoTimeRange.class) {
			return (T) new EpochNanoTimeRange(Math.round(getFrom().doubleValue() * 1_000_000),
					Math.round(getTo().doubleValue() * 1_000_000));
		}

		throw new ConversionNotSupportedException(
				String.format("Don't know how to convert from %s to %s", getClass(), type));
	}
}
