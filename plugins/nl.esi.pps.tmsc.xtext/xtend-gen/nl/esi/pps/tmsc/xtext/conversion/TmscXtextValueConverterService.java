/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.xtext.conversion;

import java.math.BigDecimal;
import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;

@SuppressWarnings("all")
public class TmscXtextValueConverterService extends DefaultTerminalConverters {
  @ValueConverter(rule = "IDString")
  public IValueConverter<String> getIDStringConverter() {
    IValueConverter<String> _ID = this.ID();
    IValueConverter<String> _STRING = this.STRING();
    return new IDStringValueConverter(_ID, _STRING);
  }
  
  @ValueConverter(rule = "ISO8601")
  public IValueConverter<BigDecimal> getISO8601Converter() {
    return new ISO8601ValueConverter();
  }
  
  @ValueConverter(rule = "POS_EBIGDECIMAL")
  public IValueConverter<BigDecimal> getPosEBigDecimalConverter() {
    return new PosEBigDecimalConverter();
  }
}
