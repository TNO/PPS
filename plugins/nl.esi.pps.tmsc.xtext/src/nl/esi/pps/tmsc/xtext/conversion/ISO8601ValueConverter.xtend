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

package nl.esi.pps.tmsc.xtext.conversion

import java.math.BigDecimal
import java.time.Instant
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import org.eclipse.xtext.conversion.IValueConverter
import org.eclipse.xtext.conversion.ValueConverterException
import org.eclipse.xtext.nodemodel.INode

class ISO8601ValueConverter implements IValueConverter<BigDecimal> {
    static val minimumDate = BigDecimal.valueOf(
        ZonedDateTime.parse('1971-01-01T00:00:00Z', DateTimeFormatter::ISO_OFFSET_DATE_TIME).toInstant.epochSecond) 
    
    override toString(BigDecimal value) throws ValueConverterException {
        if (value < minimumDate) {
            throw new ValueConverterException('Use BigDecimal for dates earlier than 1971-01-01T00:00:00Z', null, null);
        }
        val epochSecond = value.longValue
        val nanoAdjustment = value.remainder(BigDecimal::ONE).movePointRight(9).longValue
        return DateTimeFormatter::ISO_OFFSET_DATE_TIME.format(Instant::ofEpochSecond(epochSecond, nanoAdjustment))
    }

    override toValue(String string, INode node) throws ValueConverterException {
        try {
            val datetime = ZonedDateTime.parse(string, DateTimeFormatter::ISO_OFFSET_DATE_TIME);
            val instant = datetime.toInstant()
            return BigDecimal::valueOf(instant.nano).movePointLeft(9).add(BigDecimal::valueOf(instant.epochSecond));
        } catch (DateTimeParseException e) {
            throw new ValueConverterException(e.message, node, e)
        }
    }
}
