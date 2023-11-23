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

public class AbstractTimeRange implements TimeRange {
	private final Number from;
	private final Number to;

	public AbstractTimeRange(Number from, Number to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public Number getFrom() {
		return from;
	}

	@Override
	public Number getTo() {
		return to;
	}

	@Override
	@SuppressWarnings("null")
	public String toString() {
		return String.format("%s[from=%s, to=%s]", getClass().getSimpleName(), from, to);
	}

	@Override
	@SuppressWarnings({ "unchecked", "null" })
	public <T extends TimeRange> T convertTo(Class<T> type) {
		if (type == getClass()) return (T) this;
		throw new ConversionNotSupportedException(String.format("Don't know how to convert from %s to %s", getClass(), type));
	}
}
