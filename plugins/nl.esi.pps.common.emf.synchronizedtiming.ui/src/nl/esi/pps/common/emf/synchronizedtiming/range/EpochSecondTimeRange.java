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

import java.math.BigDecimal;

public final class EpochSecondTimeRange extends AbstractTimeRange {
	public EpochSecondTimeRange(double from, double to) {
		super(from, to);
	}

	public EpochSecondTimeRange(BigDecimal from, BigDecimal to) {
		super(from, to);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T extends TimeRange> T convertTo(Class<T> type) {
		if (type == DateTimeRange.class) {
			return (T) new DateTimeRange(Math.round(getFrom().doubleValue() * 1000),
					Math.round(getTo().doubleValue() * 1000));

		} else if (type == EpochNanoTimeRange.class) {
			Number from = getFrom();
			Number to = getTo();
			long nanoFrom = (from instanceof Double) ? Math.round((double) from * 1e9)
					: ((BigDecimal) from).movePointRight(9).longValueExact();
			long nanoTo = (from instanceof Double) ? Math.round((double) to * 1e9)
					: ((BigDecimal) to).movePointRight(9).longValueExact();
			return (T) new EpochNanoTimeRange(nanoFrom, nanoTo);

		} else {
			return super.convertTo(type);
		}
	}
}
