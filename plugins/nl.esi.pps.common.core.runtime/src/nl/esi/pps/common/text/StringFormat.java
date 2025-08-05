/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

/**
 * Behaves like {@link String#format(String, Object...)}
 */
public class StringFormat extends Format {
	private static final long serialVersionUID = 3584928754653635094L;

	private final String format;

	public StringFormat(String format) {
		this.format = format;
	}

	@Override
	public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
		return toAppendTo.append(String.format(format, obj));
	}

	@Override
	public Object parseObject(String source, ParsePosition pos) {
		throw new UnsupportedOperationException();
	}
}
