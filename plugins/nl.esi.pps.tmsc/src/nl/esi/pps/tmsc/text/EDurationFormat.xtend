/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.text

import java.text.FieldPosition
import java.text.NumberFormat
import java.text.ParsePosition
import java.util.concurrent.TimeUnit
import java.util.regex.Pattern
import org.eclipse.xtend.lib.annotations.Accessors
import java.text.ParseException

/**
 * This class provides the interface for formatting an {@link TmscPackage.Literals#EDURATION}. 
 */
class EDurationFormat extends NumberFormat {
    /**
     * The default {@link EDurationFormat}, assuming that durations are in nanoseconds.
     */
    public static val eINSTANCE = new EDurationFormat
    
    static val Pattern PATTERN_NANOSECONDS = Pattern::compile("\\s*n(ano)?\\s*s(ec(onds)?)?\\.?");
    static val Pattern PATTERN_MICROSECONDS = Pattern::compile("\\s*(µ|u|micro)\\s*s(ec(onds)?)?\\.?");
    static val Pattern PATTERN_MILLISECONDS = Pattern::compile("\\s*(m(illi)?)\\s*s(ec(onds)?)?\\.?");
    static val Pattern PATTERN_SECONDS = Pattern::compile("\\s*s(ec(onds)?)?\\.?");
    static val Pattern PATTERN_MINUTES = Pattern::compile("\\s*min(utes)?\\.?");
    static val Pattern PATTERN_HOURS = Pattern::compile("\\s*((h(r(s)?)?)|hours)\\.?");
    static val Pattern PATTERN_DAYS = Pattern::compile("\\s*d(ay(s)?)?\\.?");
    
    @Accessors
    var TimeUnit minimumTimeUnit = TimeUnit::NANOSECONDS

    @Accessors
    var TimeUnit maximumTimeUnit = TimeUnit::SECONDS

    new() {
        // Empty
    }

    new(TimeUnit minUnit, TimeUnit maxUnit) {
        if (minUnit > maxUnit) {
            throw new IllegalArgumentException('Minimum time unit should not by greater than maximum time unit')
        }
        minimumTimeUnit = minUnit
        maximumTimeUnit = maxUnit
    }

    override format(Object number, StringBuffer toAppendTo, FieldPosition pos) {
        if (number === null) {
            return toAppendTo
        }
        super.format(number, toAppendTo, pos)
    }

    override StringBuffer format(double number, StringBuffer toAppendTo, FieldPosition pos) {
        return format(Math::round(number), toAppendTo, pos)
    }

    override StringBuffer format(long number, StringBuffer toAppendTo, FieldPosition pos) {
        val value = minimumTimeUnit.convert(number, TimeUnit.NANOSECONDS);
        if (value == 0) {
            return toAppendTo.append('0').append(minimumTimeUnit.postfix)
        }

        for (var unit = maximumTimeUnit; unit > minimumTimeUnit; unit = TimeUnit::values.get(unit.ordinal - 1)) {
            val divisor = minimumTimeUnit.convert(1, unit)
            if (Math.abs(value) >= divisor) {
                if (value % divisor == 0) {
                    return toAppendTo.append(value / divisor).append(unit.postfix)
                } else {
                    return toAppendTo.append(value / divisor as double).append(unit.postfix)
                }
            }
        }

        return toAppendTo.append(value).append(minimumTimeUnit.postfix)
    }

    private def getPostfix(TimeUnit unit) {
        return switch (unit) {
            case NANOSECONDS: ' ns.'
            case MICROSECONDS: ' µs.'
            case MILLISECONDS: ' ms.'
            case SECONDS: ' sec.'
            case MINUTES: ' min.'
            case HOURS: ' hr.'
            case DAYS: ' days'
        }
    }
    
    override Long parse(String source) throws ParseException {
        val parsePosition = new ParsePosition(0)
        val number = NumberFormat.numberInstance.parse(source, parsePosition)
        if (parsePosition.errorIndex >= 0) {
            throw new ParseException("Unparseable number: \"" + source + "\"",
                                     parsePosition.errorIndex)
        }
        val multiplier = getMultiplier(source, parsePosition)
        if (parsePosition.errorIndex >= 0) {
            throw new ParseException("Unparseable unit: \"" + source + "\"",
                                     parsePosition.errorIndex)
        }
        return Math::round(number.doubleValue * multiplier)
    }

    override Long parse(String source, ParsePosition parsePosition) {
        val number = NumberFormat.numberInstance.parse(source, parsePosition)
        if (number === null) {
            return null
        }
        val multiplier = getMultiplier(source, parsePosition)
        if (parsePosition.errorIndex >= 0) {
            return null
        }
        return Math::round(number.doubleValue * multiplier)
    }

    def private getMultiplier(String source, ParsePosition parsePosition) {
        return switch (source) {
            case PATTERN_NANOSECONDS.matches(source, parsePosition): 1
            case PATTERN_MICROSECONDS.matches(source, parsePosition): TimeUnit::NANOSECONDS.convert(1, TimeUnit.MICROSECONDS)
            case PATTERN_MILLISECONDS.matches(source, parsePosition): TimeUnit::NANOSECONDS.convert(1, TimeUnit.MILLISECONDS)
            case PATTERN_SECONDS.matches(source, parsePosition): TimeUnit::NANOSECONDS.convert(1, TimeUnit.SECONDS)
            case PATTERN_MINUTES.matches(source, parsePosition): TimeUnit::NANOSECONDS.convert(1, TimeUnit.MINUTES)
            case PATTERN_HOURS.matches(source, parsePosition): TimeUnit::NANOSECONDS.convert(1, TimeUnit.HOURS)
            case PATTERN_DAYS.matches(source, parsePosition): TimeUnit::NANOSECONDS.convert(1, TimeUnit.DAYS)
            default: 1
        }
    }
    
    def private boolean matches(Pattern pattern, String source, ParsePosition parsePosition) {
        val unit = source.substring(parsePosition.index)
        val matcher = pattern.matcher(unit)
        if (matcher.find) {
            if (matcher.start > 0) {
                parsePosition.errorIndex = parsePosition.index
            } else {
                parsePosition.index = parsePosition.index + matcher.end
            }
            return true
        }
        return false;
    }
}
