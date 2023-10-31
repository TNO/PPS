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
import java.text.FieldPosition;
import java.util.EnumSet;
import java.util.Iterator;

public class BinaryDataFormat extends BigDecimalFormat {
	private static final long serialVersionUID = 7537361357674439457L;

	public static final BinaryDataFormat BIT = new BinaryDataFormat("b");
	public static final BinaryDataFormat BITS_PER_SECOND = new BinaryDataFormat("bps");
	public static final BinaryDataFormat BYTE = new BinaryDataFormat("B");
	public static final BinaryDataFormat BYTES_PER_SECOND = new BinaryDataFormat("Bps");

	public enum BinaryPrefix {
		BASE (1024, 0, ""),
		KIBI (1024, 1, "Ki"),
		MEBI (1024, 2, "Mi"),
		GIBI (1024, 3, "Gi"),
		TEBI (1024, 4, "Ti"),
		PEBI (1024, 5, "Pi"),
		EXBI (1024, 6, "Ei"),
		ZEBI (1024, 7, "Zi"),
		YOBI (1024, 8, "Yi");
		
		private final BigDecimal factor;
		private final String symbol;

		private BinaryPrefix(int base, int exponent, String unitSymbol) {
			this.factor = BigDecimal.valueOf(base).pow(exponent);
			this.symbol = unitSymbol;
		}

		public BigDecimal getFactor() {
			return factor;
		}

		public String getSymbol() {
			return symbol;
		}
	};

	private final String baseUnitSymbol;
	private final EnumSet<BinaryPrefix> prefixes;
	private final int maxPrefixLength;
	
	private boolean rightAlign = false;

	public BinaryDataFormat(String siBaseUnitSymbol) {
		this(siBaseUnitSymbol, BinaryPrefix.values());
	}

	public BinaryDataFormat(String baseUnitSymbol, BinaryPrefix... prefixes) {
		if (null == prefixes || prefixes.length == 0)
			throw new IllegalArgumentException("At least 1 prefix is required");
		this.baseUnitSymbol = baseUnitSymbol;
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
		final Iterator<BinaryPrefix> iterator = prefixes.iterator();
		BinaryPrefix prefix = iterator.next();
		while (iterator.hasNext()) {
			BinaryPrefix nextUnit = iterator.next();
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
		return result.append(prefix.getSymbol()).append(baseUnitSymbol);
	}
}
