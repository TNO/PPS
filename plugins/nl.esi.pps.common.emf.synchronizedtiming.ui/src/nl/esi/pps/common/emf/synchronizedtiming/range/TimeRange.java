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

import org.eclipse.jdt.annotation.Nullable;

public interface TimeRange {
	Number getFrom();

	Number getTo();

	<T extends TimeRange> T convertTo(Class<T> type) throws ConversionNotSupportedException;
	
	default boolean contains(@Nullable Number t) {
		if (t instanceof Comparable && t.getClass() == getFrom().getClass() && t.getClass() == getTo().getClass()) {
			@SuppressWarnings("unchecked")
			Comparable<Object> c = (Comparable<Object>) t;
			return c.compareTo(getFrom()) >= 0 && c.compareTo(getTo()) <= 0;
		} else if (null == t) {
			return false;
		} else {
			return t.doubleValue() >= getFrom().doubleValue() && t.doubleValue() <= getTo().doubleValue();
		}
	}
}
