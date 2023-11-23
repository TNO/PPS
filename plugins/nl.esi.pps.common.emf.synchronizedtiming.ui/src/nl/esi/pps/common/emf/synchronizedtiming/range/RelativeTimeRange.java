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

public class RelativeTimeRange extends AbstractTimeRange {
	public RelativeTimeRange(double from, double to) {
		super(from, to);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T extends TimeRange> T convertTo(Class<T> type) {
		if (type == RelativeNanoTimeRange.class) {
			final long nanoFrom = Math.round(getFrom().doubleValue() * 1e9);
			final long nanoTo = Math.round(getTo().doubleValue() * 1e9);
			return (T) new RelativeNanoTimeRange(nanoFrom, nanoTo);
		} else {
			return super.convertTo(type);
		}
	}
}
