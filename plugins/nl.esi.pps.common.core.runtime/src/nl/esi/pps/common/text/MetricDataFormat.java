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

public class MetricDataFormat extends MetricSystemFormat {
	private static final long serialVersionUID = -3098118411416656094L;

	public static final MetricPrefix[] MULTIPLES = { MetricPrefix.BASE, MetricPrefix.KILO, MetricPrefix.MEGA,
			MetricPrefix.GIGA, MetricPrefix.TERA, MetricPrefix.PETA, MetricPrefix.EXA, MetricPrefix.ZETTA,
			MetricPrefix.YOTTA };

	public static final MetricDataFormat BIT = new MetricDataFormat("b");
	public static final MetricDataFormat BITS_PER_SECOND = new MetricDataFormat("bps");
	public static final MetricDataFormat BYTE = new MetricDataFormat("B");
	public static final MetricDataFormat BYTES_PER_SECOND = new MetricDataFormat("Bps");

	public MetricDataFormat(String siBaseUnitSymbol) {
		super(siBaseUnitSymbol, MULTIPLES);
	}
}
