/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.text

import java.text.DecimalFormat
import java.text.FieldPosition
import java.text.NumberFormat
import java.text.ParsePosition
import java.text.SimpleDateFormat
import java.util.TimeZone
import java.util.concurrent.TimeUnit
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * This class provides the interface for formatting an {@link TmscPackage.Literals#ETIMESTAMP}.
 */
class ETimestampFormat extends NumberFormat {
    public static val GMT = new ETimestampFormat(null, TimeZone::getTimeZone('GMT'))
    public static val GMT_SECONDS = new ETimestampFormat(TimeUnit::SECONDS, TimeZone::getTimeZone('GMT'))
    public static val GMT_MILLISECONDS = new ETimestampFormat(TimeUnit::MILLISECONDS, TimeZone::getTimeZone('GMT'))
    public static val GMT_MICROSECONDS = new ETimestampFormat(TimeUnit::MICROSECONDS, TimeZone::getTimeZone('GMT'))
    public static val GMT_NANOSECONDS = new ETimestampFormat(TimeUnit::NANOSECONDS, TimeZone::getTimeZone('GMT'))

    /**
     * The default {@link ETimestampFormat}, assuming that time-stamps are in nanoseconds and GMT time-zone.
     */
    public static val eINSTANCE = GMT_NANOSECONDS

    static val char DEFAULT_DECIMAL_SEPARATOR = '.'
    static val char DEFAULT_THOUSANDTH_SEPARATOR = ' '
    static val THOUSANDTH_FORMAT = new DecimalFormat('000')

    val dateFormat = new SimpleDateFormat('HH:mm:ss')

    @Accessors
    var TimeUnit timeUnit

    new(TimeUnit unit, TimeZone zone) {
        timeUnit = unit
        setTimeZone(zone)
    }

    def TimeZone getTimeZone() {
        return dateFormat.timeZone
    }

    def setTimeZone(TimeZone zone) {
        dateFormat.timeZone = zone
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
        val long date = Math::floorDiv(number, 1_000_000L)
        val long nanos = Math::floorMod(number, 1_000_000_000L)
        val long millisThousandth = nanos / 1_000_000L
        val long microsThousandth = (nanos % 1_000_000L) / 1_000L
        val long nanosThousandth = nanos % 1_000L

        dateFormat.format(date, toAppendTo, pos)

        var formatUnit = timeUnit
        if (formatUnit === null && nanosThousandth > 0) {
            formatUnit = TimeUnit::NANOSECONDS
        }
        if (formatUnit === null && microsThousandth > 0) {
            formatUnit = TimeUnit::MICROSECONDS
        }
        if (formatUnit === null && millisThousandth > 0) {
            formatUnit = TimeUnit::MILLISECONDS
        }
        if (formatUnit === null) {
            formatUnit = TimeUnit::SECONDS
        }

        if (formatUnit < TimeUnit::SECONDS) {
            toAppendTo.append(ETimestampFormat.DEFAULT_DECIMAL_SEPARATOR)
            THOUSANDTH_FORMAT.format(millisThousandth, toAppendTo, pos)
        }
        if (formatUnit < TimeUnit::MILLISECONDS) {
            toAppendTo.append(DEFAULT_THOUSANDTH_SEPARATOR)
            THOUSANDTH_FORMAT.format(microsThousandth, toAppendTo, pos)
        }
        if (formatUnit < TimeUnit::MICROSECONDS) {
            toAppendTo.append(DEFAULT_THOUSANDTH_SEPARATOR)
            THOUSANDTH_FORMAT.format(nanosThousandth, toAppendTo, pos)
        }
        return toAppendTo
    }

    override Number parse(String source, ParsePosition parsePosition) {
        val orgIndex = parsePosition.index

        var oldIndex = parsePosition.index
        val date = dateFormat.parse(source, parsePosition)
        if (date === null || parsePosition.index == oldIndex) {
            parsePosition.index = orgIndex
            return null
        }

        var Integer millisThousandth = 0
        if (source.length > parsePosition.index) {
            oldIndex = parsePosition.index
            millisThousandth = parseThousandth(source, parsePosition, DEFAULT_DECIMAL_SEPARATOR)
            if (parsePosition.index == oldIndex) {
                parsePosition.index = orgIndex
                return null
            }
        }

        var Integer microsThousandth = 0
        if (source.length > parsePosition.index) {
            oldIndex = parsePosition.index
            microsThousandth = parseThousandth(source, parsePosition, DEFAULT_THOUSANDTH_SEPARATOR)
            if (parsePosition.index == oldIndex) {
                parsePosition.index = orgIndex
                return null
            }
        }

        var Integer nanosThousandth = 0
        if (source.length > parsePosition.index) {
            oldIndex = parsePosition.index
            nanosThousandth = parseThousandth(source, parsePosition, DEFAULT_THOUSANDTH_SEPARATOR)
            if (parsePosition.index == oldIndex) {
                parsePosition.index = orgIndex
                return null
            }
        }

        return (date.time * 1_000_000) + (millisThousandth * 1_000_000) + (microsThousandth * 1_000) + nanosThousandth
    }

    private def Integer parseThousandth(String source, ParsePosition parsePosition, char separator) {
        if (source.length < parsePosition.index + 4) {
            parsePosition.errorIndex = source.length
            return null
        } else if (source.charAt(parsePosition.index) != separator) {
            parsePosition.errorIndex = parsePosition.index
            return null
        }

        val orgIndex = parsePosition.index
        val oldIndex = orgIndex + 1
        parsePosition.index = oldIndex
        val number = THOUSANDTH_FORMAT.parse(source, parsePosition)
        if (parsePosition.index == oldIndex) {
            parsePosition.index = orgIndex
            return null
        }
        if (number.intValue > 999) {
            parsePosition.errorIndex = parsePosition.index
            parsePosition.index = orgIndex
            return null
        }
        return number.intValue
    }
}
