/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.xtext.conversion;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class ISO8601ValueConverter implements IValueConverter<BigDecimal> {
  private static final BigDecimal minimumDate = BigDecimal.valueOf(
    ZonedDateTime.parse("1971-01-01T00:00:00Z", DateTimeFormatter.ISO_OFFSET_DATE_TIME).toInstant().getEpochSecond());
  
  @Override
  public String toString(final BigDecimal value) throws ValueConverterException {
    boolean _lessThan = (value.compareTo(ISO8601ValueConverter.minimumDate) < 0);
    if (_lessThan) {
      throw new ValueConverterException("Use BigDecimal for dates earlier than 1971-01-01T00:00:00Z", null, null);
    }
    final long epochSecond = value.longValue();
    final long nanoAdjustment = value.remainder(BigDecimal.ONE).movePointRight(9).longValue();
    return DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(Instant.ofEpochSecond(epochSecond, nanoAdjustment));
  }
  
  @Override
  public BigDecimal toValue(final String string, final INode node) throws ValueConverterException {
    try {
      final ZonedDateTime datetime = ZonedDateTime.parse(string, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
      final Instant instant = datetime.toInstant();
      return BigDecimal.valueOf(instant.getNano()).movePointLeft(9).add(BigDecimal.valueOf(instant.getEpochSecond()));
    } catch (final Throwable _t) {
      if (_t instanceof DateTimeParseException) {
        final DateTimeParseException e = (DateTimeParseException)_t;
        String _message = e.getMessage();
        throw new ValueConverterException(_message, node, e);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
