/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.emf.synchronizedtiming.range;

public final class EpochNanoTimeRange extends AbstractTimeRange {
	public EpochNanoTimeRange(long from, long to) {
		super(from, to);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T extends TimeRange> T convertTo(Class<T> type) {
		if (type == DateTimeRange.class) {
			return (T) new DateTimeRange(Math.round((long) getFrom() / 1e6), Math.round((long) getTo() / 1e6));

		} else if (type == EpochSecondTimeRange.class) {
			return (T) new EpochSecondTimeRange((long) getFrom() / 1e9, (long) getTo() / 1e9);
		
		} else {
			return super.convertTo(type);
		}
	}
}
