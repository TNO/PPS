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
import java.text.NumberFormat;
import java.text.ParsePosition;

public class StringNumberFormat extends NumberFormat {
	private static final long serialVersionUID = -1395502978988710042L;

	private final String floatingPointFormat;
	private final String integralFormat;

	public StringNumberFormat(String floatingPointFormat) {
		this(floatingPointFormat, null);
	}

	public StringNumberFormat(String floatingPointFormat, String integralFormat) {
		if (null == floatingPointFormat && null == integralFormat) {
			throw new IllegalArgumentException(
					"One of both arguments should be set: floatingPointFormat or integralFormat");
		}
		this.floatingPointFormat = floatingPointFormat;
		this.integralFormat = integralFormat;
	}

	@Override
	public StringBuffer format(double number, StringBuffer toAppendTo, FieldPosition pos) {
		if (null == floatingPointFormat) {
			return format(Double.valueOf(number).longValue(), toAppendTo, pos);
		} else {
			toAppendTo.append(String.format(floatingPointFormat, number));
			return toAppendTo;
		}
	}

	@Override
	public StringBuffer format(long number, StringBuffer toAppendTo, FieldPosition pos) {
		if (null == integralFormat) {
			return format(Long.valueOf(number).doubleValue(), toAppendTo, pos);
		} else {
			toAppendTo.append(String.format(integralFormat, number));
			return toAppendTo;
		}
	}

	@Override
	public Number parse(String source, ParsePosition parsePosition) {
		throw new UnsupportedOperationException();
	}
}
