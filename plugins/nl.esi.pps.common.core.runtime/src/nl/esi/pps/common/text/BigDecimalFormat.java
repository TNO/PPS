/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.common.text;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;

/**
 * Formats a string representation of a {@code BigDecimal} without an exponent
 * field. For values with a positive scale, the number of digits to the right of
 * the decimal point is used to indicate scale. For values with a zero or
 * negative scale, the resulting string is generated as if the value were
 * converted to a numerically equal value with zero scale and as if all the
 * trailing zeros of the zero scale value were present in the result.<br>
 * <br>
 * The entire string is prefixed by a minus sign character '-'
 * (<tt>'&#92;u002D'</tt>) if the unscaled value is less than zero. No sign
 * character is prefixed if the unscaled value is zero or positive.
 * 
 * @see BigDecimal#toPlainString()
 */
/*
 * For future use: Note that if the formatted result is again parsed, only the
 * numerical value of the {@code BigDecimal} will necessarily be recovered; the
 * representation of the new {@code BigDecimal} may have a different scale. In
 * particular, if the {@code BigDecimal} has a negative scale, the string
 * resulting from formatting will have a scale of zero when processed by the
 * {@link #parse(String, ParsePosition)} method.
 */
public class BigDecimalFormat extends NumberFormat {
	private static final long serialVersionUID = -7776148386955119608L;

	public static final BigDecimalFormat INSTANCE = new BigDecimalFormat();
	
	private RoundingMode roundingMode = RoundingMode.HALF_UP;
	
	public BigDecimalFormat() {
		super();
		setMaximumIntegerDigits(Integer.MAX_VALUE);
		setMaximumFractionDigits(Integer.MAX_VALUE);
	}

	@Override
	public void setRoundingMode(RoundingMode roundingMode) {
		this.roundingMode = roundingMode;
	}
	
	@Override
	public RoundingMode getRoundingMode() {
		return roundingMode;
	}

	@Override
	public StringBuffer format(Object number, StringBuffer toAppendTo, FieldPosition pos) {
		// Avoid rounding errors for this format
		if (number instanceof BigDecimal) {
			return format((BigDecimal) number, toAppendTo, pos);
		}
		if (number instanceof BigInteger) {
			return format(new BigDecimal((BigInteger) number), toAppendTo, pos);
		}
		return super.format(number, toAppendTo, pos);
	}

	@Override
	public StringBuffer format(double number, StringBuffer toAppendTo, FieldPosition pos) {
		if (Double.isNaN(number)) {
			return toAppendTo.append("NaN");
		} else if (Double.isInfinite(number)) {
			return getNumberInstance().format(number, toAppendTo, pos);
		} else {
			return format(BigDecimal.valueOf(number), toAppendTo, pos);
		}
	}

	@Override
	public StringBuffer format(long number, StringBuffer toAppendTo, FieldPosition pos) {
		return format(BigDecimal.valueOf(number), toAppendTo, pos);
	}

	/**
	 * Specialization of format.
	 *
	 * @param number
	 *            the {@link BigDecimal} number to format
	 * @param toAppendTo
	 *            the StringBuffer to which the formatted text is to be appended
	 * @param pos
	 *            the field position
	 * @return the formatted StringBuffer
	 * @exception ArithmeticException
	 *                if rounding is needed with rounding mode being set to
	 *                RoundingMode.UNNECESSARY
	 * @see java.text.Format#format
	 */
	public StringBuffer format(BigDecimal number, StringBuffer toAppendTo, FieldPosition pos) {
        final int maxFraDigits = super.getMaximumFractionDigits();
        final int minFraDigits = super.getMinimumFractionDigits();
        final int scale = number.scale();
        
		BigDecimal toFormat = number;
		if (scale < minFraDigits) {
			toFormat = toFormat.setScale(minFraDigits, getRoundingMode());
		} else if (scale > maxFraDigits) {
			toFormat = toFormat.setScale(maxFraDigits, getRoundingMode());
		}
		return toAppendTo.append(toFormat.toPlainString());
	}

	@Override
	public Number parse(String source, ParsePosition parsePosition) {
		throw new UnsupportedOperationException();
	}
}
