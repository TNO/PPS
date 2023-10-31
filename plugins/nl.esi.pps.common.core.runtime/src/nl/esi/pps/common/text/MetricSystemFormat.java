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
import java.math.MathContext;
import java.text.FieldPosition;
import java.util.EnumSet;
import java.util.Iterator;

public class MetricSystemFormat extends BigDecimalFormat {
	private static final long serialVersionUID = 7537361357674439457L;

	public enum MetricPrefix {
		YOCTO (10, -24, "y"),
		ZEPTO (10, -21, "z"),
		ATTO  (10, -18, "a"),
		FEMTO (10, -15, "f"),
		PICO  (10, -12, "p"),
		NANO  (10, -9,  "n"),
		MICRO (10, -6,  "μ"),
		MILLI (10, -3,  "m"),
		CENTI (10, -2,  "c"),
		DECI  (10, -1,  "d"),
		BASE  (10, 0,   ""),
		DECA  (10, 1,   "da"),
		HECTO (10, 2,   "h"),
		KILO  (10, 3,   "k"),
		MEGA  (10, 6,   "M"),
		GIGA  (10, 9,   "G"),
		TERA  (10, 12,  "T"),
		PETA  (10, 15,  "P"),
		EXA   (10, 18,  "E"),
		ZETTA (10, 21,  "Z"),
		YOTTA (10, 24,  "Y");
		
		private final BigDecimal factor;
		private final String symbol;

		private MetricPrefix(int base, int exponent, String unitSymbol) {
			this.factor = BigDecimal.valueOf(base).pow(exponent, MathContext.DECIMAL128);
			this.symbol = unitSymbol;
		}

		public BigDecimal getFactor() {
			return factor;
		}

		public String getSymbol() {
			return symbol;
		}
		
		public BigDecimal getBaseValue(BigDecimal prefixValue) {
			return prefixValue.multiply(this.factor);
		}
		
		public BigDecimal getPrefixValue(BigDecimal baseValue) {
			return baseValue.divide(this.factor);
		}
	};

	public static final MetricPrefix[] MULTIPLES = { MetricPrefix.BASE, MetricPrefix.DECA, MetricPrefix.HECTO,
			MetricPrefix.KILO, MetricPrefix.MEGA, MetricPrefix.GIGA, MetricPrefix.TERA, MetricPrefix.PETA,
			MetricPrefix.EXA, MetricPrefix.ZETTA, MetricPrefix.YOTTA };
	public static final MetricPrefix[] SUBMULTIPLES = { MetricPrefix.YOCTO, MetricPrefix.ZEPTO, MetricPrefix.ATTO,
			MetricPrefix.FEMTO, MetricPrefix.PICO, MetricPrefix.NANO, MetricPrefix.MICRO, MetricPrefix.MILLI,
			MetricPrefix.CENTI, MetricPrefix.DECI, MetricPrefix.BASE };
	
	private final String siBaseUnitSymbol;
	private final EnumSet<MetricPrefix> prefixes;
	private final int maxPrefixLength;
	
	private boolean rightAlign = false;

	public MetricSystemFormat(String siBaseUnitSymbol) {
		this(siBaseUnitSymbol, MetricPrefix.values());
	}

	public MetricSystemFormat(String siBaseUnitSymbol, MetricPrefix... prefixes) {
		if (null == prefixes || prefixes.length == 0)
			throw new IllegalArgumentException("At least 1 prefix is required");
		this.siBaseUnitSymbol = siBaseUnitSymbol;
		this.prefixes = EnumSet.of(prefixes[0], prefixes);
		this.maxPrefixLength = this.prefixes.stream().mapToInt(p -> p.getSymbol().length()).max().getAsInt();
	}
	
	public void setRightAlign(boolean rightAlign) {
		this.rightAlign = rightAlign;
	}
	
	public boolean isRightAlign() {
		return rightAlign;
	}

	@Override
	public StringBuffer format(BigDecimal number, StringBuffer toAppendTo, FieldPosition pos) {
		final BigDecimal absNumber = number.abs();
		final Iterator<MetricPrefix> iterator = prefixes.iterator();
		MetricPrefix prefix = iterator.next();
		while (iterator.hasNext()) {
			MetricPrefix nextUnit = iterator.next();
			if (nextUnit.getFactor().compareTo(absNumber) <= 0) {
				prefix = nextUnit;
			} else {
				break;
			}
		}
		
		final BigDecimal converted = number.divide(prefix.getFactor()).stripTrailingZeros();
		final String prefixSymbol = prefix.getSymbol();
		
		StringBuffer result = super.format(converted, toAppendTo, pos).append(' ');
		if (rightAlign) {
			for (int i = prefixSymbol.length(); i < maxPrefixLength; i++) {
				result.append(' ');
			}
		}
		return result.append(prefix.getSymbol()).append(siBaseUnitSymbol);
	}
}
