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

import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.xbase.lib.Exceptions;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class StringFallbackValueConverter implements IValueConverter<String> {
  private final IValueConverter<String> fallbackValueConverter;
  
  private final IValueConverter<String> stringValueConverter;
  
  /**
   * Prefer ID with fallback to STRING
   */
  @Override
  public String toString(final String value) throws ValueConverterException {
    try {
      return this.fallbackValueConverter.toString(value);
    } catch (final Throwable _t) {
      if (_t instanceof ValueConverterException) {
        return this.stringValueConverter.toString(value);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  /**
   * Try STRING with fallback to ID
   */
  @Override
  public String toValue(final String string, final INode node) throws ValueConverterException {
    String _xifexpression = null;
    if (((string != null) && (string.startsWith("\"") || string.startsWith("\'")))) {
      _xifexpression = this.stringValueConverter.toValue(string, node);
    } else {
      _xifexpression = this.fallbackValueConverter.toValue(string, node);
    }
    return _xifexpression;
  }
  
  public StringFallbackValueConverter(final IValueConverter<String> fallbackValueConverter, final IValueConverter<String> stringValueConverter) {
    super();
    this.fallbackValueConverter = fallbackValueConverter;
    this.stringValueConverter = stringValueConverter;
  }
}
