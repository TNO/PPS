/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.xtext.conversion

import org.eclipse.xtext.common.services.DefaultTerminalConverters
import org.eclipse.xtext.conversion.IValueConverter
import org.eclipse.xtext.conversion.ValueConverter
import java.math.BigDecimal

class TmscXtextValueConverterService extends DefaultTerminalConverters {
    @ValueConverter(rule = "IDString")
    def IValueConverter<String> getIDStringConverter() {
        return new IDStringValueConverter(ID, STRING);
    }

    @ValueConverter(rule = "ISO8601")
    def IValueConverter<BigDecimal> getISO8601Converter() {
        return new ISO8601ValueConverter();
    }

    @ValueConverter(rule = "POS_EBIGDECIMAL")
    def IValueConverter<BigDecimal> getPosEBigDecimalConverter() {
        return new PosEBigDecimalConverter();
    }
}