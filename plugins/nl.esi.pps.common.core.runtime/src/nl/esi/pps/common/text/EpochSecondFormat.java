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
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * @see SimpleEpochSecondFormat
 */
public class EpochSecondFormat extends BigDecimalFormat {
	private static final long serialVersionUID = -1598116098036265645L;
	
	public static final EpochSecondFormat SECONDS = new EpochSecondFormat(null);
	public static final EpochSecondFormat MILLISECONDS = new EpochSecondFormat(3);
	public static final EpochSecondFormat MICROSECONDS = new EpochSecondFormat(6);
	public static final EpochSecondFormat NANOSECONDS = new EpochSecondFormat(9);
	public static final EpochSecondFormat UNSCALED = new EpochSecondFormat(0);
	
	private static final BigDecimal THOUSAND = new BigDecimal(1000);
	
	private final DateFormat dateFormat;
	private final ScaleFormat scaleFormat;
	
    public EpochSecondFormat() {
    	this(0);
	}

	/**
	 * Creates a formatter without a grouping separator.
	 * 
	 * @see #EpochSecondFormat(Integer, CharSequence, CharSequence)
	 */
    public EpochSecondFormat(Integer scaleLength) {
    	this(scaleLength, ".", " ");
	}

    /**
	 * @see #EpochSecondFormat(Integer, CharSequence, CharSequence)
     * @see #setTimeZone(TimeZone)
     */
    public EpochSecondFormat(Integer scaleLength, TimeZone zone) {
    	this(scaleLength);
    	setTimeZone(zone);
	}

    /**
     * Formats the scale of a decimal according to:
     * <ul>
     * <li><i>length == null</i> - no digits will be printed</li>
     * <li><i>length < 0</i> - number of digits will not exceed -length, but might be less</li>
     * <li><i>length = 0</i> - all available digits will be printed</li>
     * <li><i>length > 0</i> - number of digits will always be equals to length (appended with zero's)</li>
     * </ul>
     */
    public EpochSecondFormat(Integer scaleLength, CharSequence scalePrefix, CharSequence scaleGroupingSeparator) {
    	this.scaleFormat = (null == scaleLength) ? null : new ScaleFormat(scaleLength, scalePrefix, scaleGroupingSeparator);
    	this.dateFormat = new SimpleDateFormat("HH:mm:ss");
	}

    /**
	 * @see #EpochSecondFormat(Integer, CharSequence, CharSequence)
     * @see #setTimeZone(TimeZone)
     */
    public EpochSecondFormat(Integer scaleLength, TimeZone zone, CharSequence scalePrefix, CharSequence scaleGroupingSeparator) {
    	this(scaleLength, scalePrefix, scaleGroupingSeparator);
    	setTimeZone(zone);
	}

    public void setTimeZone(TimeZone zone) {
		dateFormat.setTimeZone(zone);
	}

	public TimeZone getTimeZone() {
		return dateFormat.getTimeZone();
	}

	@Override
	public StringBuffer format(BigDecimal epochSecond, StringBuffer toAppendTo, FieldPosition pos) {
		StringBuffer result = dateFormat.format(epochSecond.multiply(THOUSAND), toAppendTo, pos);
		if (null != scaleFormat) {
			result = scaleFormat.format(epochSecond, toAppendTo, pos);
		}
		return result;
	}
}
