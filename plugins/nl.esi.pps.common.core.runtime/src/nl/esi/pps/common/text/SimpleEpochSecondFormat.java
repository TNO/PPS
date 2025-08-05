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
import java.text.DecimalFormatSymbols;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * SimpleEpochSecondFormat is a concrete class for formatting epoch-seconds in a
 * locale-sensitive manner. The pattern syntax is based on
 * {@link SimpleDateFormat} and is extended with the following pattern letters
 * (all other characters from <code>'A'</code> to <code>'Z'</code> and from
 * <code>'a'</code> to <code>'z'</code> are reserved): <blockquote>
 * <table border=0 cellspacing=3 cellpadding=0 summary="Chart shows pattern
 * letters, date/time component, presentation, and ranges.">
 * <tr style="background-color: rgb(204, 204, 255);">
 * <th align=left>Letter
 * <th align=left>Date or Time Component
 * <th align=left>Presentation
 * <th align=left>Range
 * <tr style="background-color: rgb(238, 238, 255);">
 * <td><code>U</code>
 * <td>Microsecond
 * <td>Number
 * <td><code>0</code>-<code>999</code>
 * <tr style="background-color: rgb(238, 238, 255);">
 * <td><code>N</code>
 * <td>Nanosecond
 * <td>Number
 * <td><code>0</code>-<code>999</code>
 * </table>
 * </blockquote>
 * 
 * @see SimpleDateFormat
 */
public class SimpleEpochSecondFormat extends BigDecimalFormat {
	private static final long serialVersionUID = 8026825907476942531L;

	public static final String DEFAULT_PATTERN = "HH:mm:ss.SSS UUU NNN";

	private static final char QUOTE = '\'';

	/**
	 * Range: FFF0—FFFF are 'specials' in unicode and most likely not to be
	 * contained in a time pattern.
	 * 
	 * @see <a href='https://unicode-table.com/en/blocks/specials/'>Unicode Table -
	 *      Specials</a>
	 */
	private static final char TAG_MICRO = '\uFFF1';
	private static final char MICRO = 'U';
	private static final Pattern TAGGED_MICROS = Pattern.compile(TAG_MICRO + "+");

	/**
	 * Range: FFF0—FFFF are 'specials' in unicode and most likely not to be
	 * contained in a time pattern.
	 * 
	 * @see <a href='https://unicode-table.com/en/blocks/specials/'>Unicode Table -
	 *      Specials</a>
	 */
	private static final char TAG_NANO = '\uFFF2';
	private static final char NANO = 'N';
	private static final Pattern TAGGED_NANOS = Pattern.compile(TAG_NANO + "+");

	private final SimpleDateFormat dateFormat;
	private final DecimalFormatSymbols decimalSymbols;

	/**
	 * Constructs a <code>SimpleEpochSecondFormat</code> using the default pattern
	 * {@value #DEFAULT_PATTERN} and date format symbols for the default
	 * {@link java.util.Locale.Category#FORMAT FORMAT} locale.
	 */
	public SimpleEpochSecondFormat() {
		this(DEFAULT_PATTERN, Locale.getDefault(Locale.Category.FORMAT));
	}

	/**
	 * Constructs a <code>SimpleEpochSecondFormat</code> using the given pattern and
	 * the default date format symbols for the default
	 * {@link java.util.Locale.Category#FORMAT FORMAT} locale.
	 * <p>
	 * This is equivalent to calling {@link #SimpleEpochSecondFormat(String, Locale)
	 * SimpleEpochSecondFormat(pattern, Locale.getDefault(Locale.Category.FORMAT))}.
	 *
	 * @param pattern the pattern describing the date and time format
	 * @exception NullPointerException     if the given pattern is null
	 * @exception IllegalArgumentException if the given pattern is invalid
	 * @see java.util.Locale#getDefault(java.util.Locale.Category)
	 * @see java.util.Locale.Category#FORMAT
	 */
	public SimpleEpochSecondFormat(String pattern) throws NullPointerException, IllegalArgumentException {
		this(pattern, Locale.getDefault(Locale.Category.FORMAT));
	}

	/**
	 * Constructs a <code>SimpleEpochSecondFormat</code> using the given pattern and
	 * the default date format symbols for the given locale.
	 *
	 * @param pattern the pattern describing the date and time format
	 * @param locale  the locale whose date format symbols should be used
	 * @exception NullPointerException     if the given pattern or locale is null
	 * @exception IllegalArgumentException if the given pattern is invalid
	 */
	public SimpleEpochSecondFormat(String pattern, Locale locale)
			throws NullPointerException, IllegalArgumentException {
		if (TAGGED_MICROS.matcher(pattern).find() || TAGGED_NANOS.matcher(pattern).find()) {
			throw new IllegalArgumentException(
					String.format("Unicode characters U+%x and U+%x can't be used in the pattern string",
							(int) TAG_MICRO, (int) TAG_NANO));
		}
		dateFormat = new SimpleDateFormat(convertToSimpleDatePattern(pattern), locale);
		decimalSymbols = new DecimalFormatSymbols(locale);
	}

	@Override
	public StringBuffer format(BigDecimal seconds, StringBuffer toAppendTo, FieldPosition pos) {
		BigDecimal millis = seconds.movePointRight(3);
		BigDecimal micros = millis.remainder(BigDecimal.ONE).movePointRight(3);
		BigDecimal nanos = micros.remainder(BigDecimal.ONE).movePointRight(3);

		StringBuffer formattedDate = dateFormat.format(new Date(millis.longValue()), new StringBuffer(), pos);

		Matcher microsMatcher = TAGGED_MICROS.matcher(formattedDate);
		formattedDate = new StringBuffer();
		while (microsMatcher.find()) {
			microsMatcher.appendReplacement(formattedDate, StringUtils.leftPad(String.valueOf(micros.shortValue()),
					microsMatcher.group().length(), decimalSymbols.getZeroDigit()));
		}
		microsMatcher.appendTail(formattedDate);

		Matcher nanosMatcher = TAGGED_NANOS.matcher(formattedDate);
		formattedDate = new StringBuffer();
		while (nanosMatcher.find()) {
			nanosMatcher.appendReplacement(formattedDate, StringUtils.leftPad(String.valueOf(nanos.shortValue()),
					nanosMatcher.group().length(), decimalSymbols.getZeroDigit()));
		}
		nanosMatcher.appendTail(formattedDate);

		return toAppendTo.append(formattedDate);
	}

	private static String convertToSimpleDatePattern(String epochSecondPattern) {
		final PatternBuffer simpleDatePattern = new PatternBuffer();
		final int length = epochSecondPattern.length();

		boolean insideQuote = false;
		for (int i = 0; i < length; i++) {
			char ch = epochSecondPattern.charAt(i);
			switch (ch) {
			case QUOTE:
				// '' is treated as a single quote regardless of being in a quoted section.
				if ((i + 1) < length && epochSecondPattern.charAt(i + 1) == QUOTE) {
					simpleDatePattern.appendDoubleSingleQuote();
					i++;
				} else {
					// Just mark the state change, PatternBuffer will take care of the rest
					insideQuote = !insideQuote;
				}
				break;
			case MICRO:
				if (insideQuote) {
					simpleDatePattern.append(MICRO, insideQuote);
				} else {
					simpleDatePattern.append(TAG_MICRO, true);
				}
				break;
			case NANO:
				if (insideQuote) {
					simpleDatePattern.append(NANO, insideQuote);
				} else {
					simpleDatePattern.append(TAG_NANO, true);
				}
				break;
			default:
				simpleDatePattern.append(ch, insideQuote);
			}
		}

		return simpleDatePattern.close();
	}

	private static class PatternBuffer {
		private final StringBuffer buffer = new StringBuffer();
		private boolean insideQuote = false;

		void appendDoubleSingleQuote() {
			buffer.append(QUOTE).append(QUOTE);
		}

		void append(char ch, boolean insideQuote) {
			if (ch == QUOTE) {
				throw new IllegalArgumentException("Quotes should not be appended explicitly");
			}
			if (this.insideQuote != insideQuote) {
				buffer.append(QUOTE);
				this.insideQuote = insideQuote;
			}
			buffer.append(ch);
		}

		String close() {
			if (this.insideQuote) {
				buffer.append(QUOTE);
				this.insideQuote = false;
			}
			return buffer.toString();
		}
	}
}
