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
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class PosEBigDecimalConverter implements IValueConverter<BigDecimal> {
  @Override
  public String toString(final BigDecimal value) throws ValueConverterException {
    int _signum = value.signum();
    boolean _lessThan = (_signum < 0);
    if (_lessThan) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Expected a positive number: ");
      _builder.append(value);
      throw new ValueConverterException(_builder.toString(), null, null);
    }
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("+");
    _builder_1.append(value);
    return _builder_1.toString();
  }
  
  @Override
  public BigDecimal toValue(final String string, final INode node) throws ValueConverterException {
    try {
      return new BigDecimal(string);
    } catch (final Throwable _t) {
      if (_t instanceof NumberFormatException) {
        final NumberFormatException nfe = (NumberFormatException)_t;
        String _message = nfe.getMessage();
        throw new ValueConverterException(_message, node, nfe);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
