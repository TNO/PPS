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
import java.math.RoundingMode;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class DurationFormat extends NumberFormat {
	private static final long serialVersionUID = -4328631410516476372L;

	public static final DurationFormat SECONDS = new DurationFormat(TimeUnit.SECONDS);

	private final TimeUnit numberUnit;
	private final TimeUnit resolutionUnit;
	private final Function<BigDecimal, BigDecimal> trimFunctor;

	public DurationFormat(TimeUnit numberUnit) {
		this(numberUnit, TimeUnit.NANOSECONDS, false);
	}

	public DurationFormat(TimeUnit numberUnit, TimeUnit resolutionUnit) {
		this(numberUnit, resolutionUnit, true);
	}

	private DurationFormat(TimeUnit numberUnit, TimeUnit resolutionUnit, boolean trim) {
		this.numberUnit = numberUnit;
		this.resolutionUnit = resolutionUnit;

		if (!trim) {
			trimFunctor = n -> n;
		} else if (TimeUnit.SECONDS.compareTo(numberUnit) < 0) {
			throw new IllegalArgumentException("Resolution is only supported for number units: sec., ms., µs. and ns.");
		} else if (resolutionUnit.compareTo(numberUnit) > 0) {
			throw new IllegalArgumentException("Resolution unit should be less than number unit.");
		} else {
			BigDecimal resolutionFactor = BigDecimal.valueOf(resolutionUnit.convert(1, numberUnit));
			trimFunctor = n -> n.multiply(resolutionFactor).setScale(0, RoundingMode.HALF_UP).divide(resolutionFactor);
		}
	}

	@Override
	public StringBuffer format(Object number, StringBuffer toAppendTo, FieldPosition pos) {
		if (number instanceof BigDecimal) {
			return format(trimFunctor.apply((BigDecimal) number), numberUnit, toAppendTo, pos);
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
			return format(trimFunctor.apply(BigDecimal.valueOf(number)), numberUnit, toAppendTo, pos);
		}
	}

	protected StringBuffer format(BigDecimal number, TimeUnit unit, StringBuffer toAppendTo, FieldPosition pos) {
		if (number.abs().compareTo(BigDecimal.ONE) < 0 && unit.compareTo(resolutionUnit) > 0) {
			// Convert to smaller time unit
			TimeUnit nextUnit = TimeUnit.values()[unit.ordinal() - 1];
			BigDecimal nextUnitFactor = BigDecimal.valueOf(nextUnit.convert(1, unit));
			return format(number.multiply(nextUnitFactor), nextUnit, toAppendTo, pos);
		} else {
			return toAppendTo.append(number.stripTrailingZeros().toPlainString()).append(getUnitPostfix(unit));
		}
	}

	@Override
	public StringBuffer format(long number, StringBuffer toAppendTo, FieldPosition pos) {
		return toAppendTo.append(number).append(getUnitPostfix(numberUnit));
	}

	private String getUnitPostfix(TimeUnit unit) {
		switch (unit) {
		case NANOSECONDS: 	return " ns.";
		case MICROSECONDS: 	return " µs.";
		case MILLISECONDS: 	return " ms.";
		case SECONDS: 		return " sec.";
		case MINUTES: 		return " min.";
		case HOURS: 		return " hr.";
		case DAYS: 			return " days";
		default:
			throw new IllegalArgumentException("Not defined: " + unit);
		}
	}

	@Override
	public Number parse(String source, ParsePosition parsePosition) {
		throw new UnsupportedOperationException();
	}
}
