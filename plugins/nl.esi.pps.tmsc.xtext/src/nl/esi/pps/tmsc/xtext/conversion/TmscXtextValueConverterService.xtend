/**
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
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

import com.google.inject.Inject
import java.math.BigDecimal
import org.eclipse.xtext.common.services.DefaultTerminalConverters
import org.eclipse.xtext.conversion.IValueConverter
import org.eclipse.xtext.conversion.ValueConverter
import org.eclipse.xtext.conversion.impl.QualifiedNameValueConverter

class TmscXtextValueConverterService extends DefaultTerminalConverters {
    @Inject
    var QualifiedNameValueConverter qualifiedNameValueConverter;
    
    
    @ValueConverter(rule = "IDString")
    def IValueConverter<String> getIDStringConverter() {
        return new StringFallbackValueConverter(ID, STRING);
    }

    @ValueConverter(rule = "FQNString")
    def IValueConverter<String> getFQNStringConverter() {
        return new StringFallbackValueConverter(qualifiedNameValueConverter, STRING);
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