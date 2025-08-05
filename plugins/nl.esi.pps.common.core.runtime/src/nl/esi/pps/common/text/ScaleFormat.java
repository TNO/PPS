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

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.FieldPosition;
import java.text.ParsePosition;

/**
 * Formats the scale of a decimal according to:
 * <ul>
 * <li><i>length < 0</i> - number of digits will not exceed -length, but might be less</li>
 * <li><i>length = 0</i> - all available digits will be printed</li>
 * <li><i>length > 0</i> - number of digits will always be equals to length (appended with zero's)</li>
 * </ul>
 */
public class ScaleFormat extends BigDecimalFormat {
	private static final long serialVersionUID = -3904376437632799605L;
	
	private final int length;
	private final CharSequence prefix;
	private final CharSequence thousandsSeparator;
	
	public ScaleFormat(int length, CharSequence prefix) {
		this(length, prefix, "");
	}
	
	public ScaleFormat(int length, CharSequence prefix, CharSequence thousandsSeparator) {
		this.length = length;
		this.prefix = prefix;
		this.thousandsSeparator = thousandsSeparator;
	}
	
	public int length() {
		return length;
	}

	@Override
	public StringBuffer format(long number, StringBuffer toAppendTo, FieldPosition pos) {
		// long has no scale...
		if (length > 0) {
			toAppendTo.append(prefix);
			for (int i = 0; i < length; i++) {
				toAppendTo.append("0");
			}
		}
		return toAppendTo;
	}

	@Override
	public StringBuffer format(BigDecimal number, StringBuffer toAppendTo, FieldPosition pos) {
		if (length > 0) {
			return formatDigits(number, length, toAppendTo.append(prefix));
		} else if (number.scale() > 0) {
			if (length == 0) {
				return formatDigits(number, number.scale(), toAppendTo.append(prefix));
			} else {
				return formatDigits(number, Math.min(number.scale(), -length), toAppendTo.append(prefix));
			}
		}
		return toAppendTo;
	}
	
	private StringBuffer formatDigits(BigDecimal number, int scale, StringBuffer toAppendTo) {
		StringBuffer digits = new StringBuffer(scale);
		digits.append(number.abs().remainder(BigDecimal.ONE).movePointRight(scale).setScale(0, RoundingMode.FLOOR).toPlainString());
		while (digits.length() < scale) {
			digits.insert(0, '0');
		}
		
		for (int i = 0; i < digits.length(); i++) {
			if (i != 0 && i % 3 == 0) {
				toAppendTo.append(thousandsSeparator);
			}
			toAppendTo.append(digits.charAt(i));
		}
		return toAppendTo;
	}

	@Override
	public Number parse(String source, ParsePosition parsePosition) {
		throw new UnsupportedOperationException();
	}
	
	public static void main(String[] args) {
		System.out.println(new ScaleFormat(9, ".", " ").format(0.1));
		System.out.println(new ScaleFormat(0, ".").format(0.1));
		System.out.println(new ScaleFormat(-3, ".").format(0.1));
		System.out.println(new ScaleFormat(2, ".").format(0.123));
		System.out.println(new ScaleFormat(0, ".").format(0.123));
		System.out.println(new ScaleFormat(-2, ".").format(0.123));
		System.out.println(new ScaleFormat(1, ".").format(10));
		System.out.println(new ScaleFormat(0, ".").format(10));
		System.out.println(new ScaleFormat(-1, ".").format(10));
		System.out.println(new ScaleFormat(9, ".", " ").format(new BigDecimal("1520599852.760060036")));
		System.out.println(new ScaleFormat(9, ".", " ").format(new BigDecimal("-1520599852.760060036")));
		System.out.println(new ScaleFormat(9, ".", " ").format(new BigDecimal("-2100000000.000123456")));
		System.out.println(new ScaleFormat(-9, ".", " ").format(new BigDecimal("1520599852.7600600")));
		System.out.println(new ScaleFormat(-9, ".", " ").format(new BigDecimal("2.34567E+5")));
		System.out.println(new ScaleFormat(9, ".", " ").format(new BigDecimal("2.34567E+5")));
		System.out.println(new ScaleFormat(-9, ".", " ").format(new BigDecimal("1.23456E-4")));
		System.out.println(new ScaleFormat(9, ".", " ").format(new BigDecimal("2.34567890E+5")));
	}
}
