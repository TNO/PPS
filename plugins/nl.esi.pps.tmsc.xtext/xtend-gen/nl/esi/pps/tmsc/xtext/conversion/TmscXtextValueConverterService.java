/**
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.xtext.conversion;

import com.google.inject.Inject;
import java.math.BigDecimal;
import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.impl.QualifiedNameValueConverter;

@SuppressWarnings("all")
public class TmscXtextValueConverterService extends DefaultTerminalConverters {
  @Inject
  private QualifiedNameValueConverter qualifiedNameValueConverter;

  @ValueConverter(rule = "IDString")
  public IValueConverter<String> getIDStringConverter() {
    IValueConverter<String> _ID = this.ID();
    IValueConverter<String> _STRING = this.STRING();
    return new StringFallbackValueConverter(_ID, _STRING);
  }

  @ValueConverter(rule = "FQNString")
  public IValueConverter<String> getFQNStringConverter() {
    IValueConverter<String> _STRING = this.STRING();
    return new StringFallbackValueConverter(this.qualifiedNameValueConverter, _STRING);
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
