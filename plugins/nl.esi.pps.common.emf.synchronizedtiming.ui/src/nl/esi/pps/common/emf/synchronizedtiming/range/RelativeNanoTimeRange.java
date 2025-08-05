/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.emf.synchronizedtiming.range;

public class RelativeNanoTimeRange extends AbstractTimeRange {
	public RelativeNanoTimeRange(long from, long to) {
		super(from, to);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public <T extends TimeRange> T convertTo(Class<T> type) {
		if (type == RelativeTimeRange.class) {
			final double from = getFrom().longValue() * 1e-9;
			final double to = getTo().longValue() * 1e-9;
			return (T) new RelativeTimeRange(from, to);
		} else {
			return super.convertTo(type);
		}
	}
}
