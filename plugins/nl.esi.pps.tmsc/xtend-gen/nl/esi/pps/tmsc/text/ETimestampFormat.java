/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.text;

import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * This class provides the interface for formatting an {@link TmscPackage.Literals#ETIMESTAMP}.
 */
@SuppressWarnings("all")
public class ETimestampFormat extends NumberFormat {
  public static final ETimestampFormat GMT = new ETimestampFormat(null, TimeZone.getTimeZone("GMT"));
  
  public static final ETimestampFormat GMT_SECONDS = new ETimestampFormat(TimeUnit.SECONDS, TimeZone.getTimeZone("GMT"));
  
  public static final ETimestampFormat GMT_MILLISECONDS = new ETimestampFormat(TimeUnit.MILLISECONDS, TimeZone.getTimeZone("GMT"));
  
  public static final ETimestampFormat GMT_MICROSECONDS = new ETimestampFormat(TimeUnit.MICROSECONDS, TimeZone.getTimeZone("GMT"));
  
  public static final ETimestampFormat GMT_NANOSECONDS = new ETimestampFormat(TimeUnit.NANOSECONDS, TimeZone.getTimeZone("GMT"));
  
  /**
   * The default {@link ETimestampFormat}, assuming that time-stamps are in nanoseconds and GMT time-zone.
   */
  public static final ETimestampFormat eINSTANCE = ETimestampFormat.GMT_NANOSECONDS;
  
  private static final char DEFAULT_DECIMAL_SEPARATOR = '.';
  
  private static final char DEFAULT_THOUSANDTH_SEPARATOR = ' ';
  
  private static final DecimalFormat THOUSANDTH_FORMAT = new DecimalFormat("000");
  
  private final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
  
  @Accessors
  private TimeUnit timeUnit;
  
  public ETimestampFormat(final TimeUnit unit, final TimeZone zone) {
    this.timeUnit = unit;
    this.setTimeZone(zone);
  }
  
  public TimeZone getTimeZone() {
    return this.dateFormat.getTimeZone();
  }
  
  public void setTimeZone(final TimeZone zone) {
    this.dateFormat.setTimeZone(zone);
  }
  
  @Override
  public StringBuffer format(final Object number, final StringBuffer toAppendTo, final FieldPosition pos) {
    StringBuffer _xblockexpression = null;
    {
      if ((number == null)) {
        return toAppendTo;
      }
      _xblockexpression = super.format(number, toAppendTo, pos);
    }
    return _xblockexpression;
  }
  
  @Override
  public StringBuffer format(final double number, final StringBuffer toAppendTo, final FieldPosition pos) {
    return this.format(Math.round(number), toAppendTo, pos);
  }
  
  @Override
  public StringBuffer format(final long number, final StringBuffer toAppendTo, final FieldPosition pos) {
    final long date = Math.floorDiv(number, 1_000_000L);
    final long nanos = Math.floorMod(number, 1_000_000_000L);
    final long millisThousandth = (nanos / 1_000_000L);
    final long microsThousandth = ((nanos % 1_000_000L) / 1_000L);
    final long nanosThousandth = (nanos % 1_000L);
    this.dateFormat.format(Long.valueOf(date), toAppendTo, pos);
    TimeUnit formatUnit = this.timeUnit;
    if (((formatUnit == null) && (nanosThousandth > 0))) {
      formatUnit = TimeUnit.NANOSECONDS;
    }
    if (((formatUnit == null) && (microsThousandth > 0))) {
      formatUnit = TimeUnit.MICROSECONDS;
    }
    if (((formatUnit == null) && (millisThousandth > 0))) {
      formatUnit = TimeUnit.MILLISECONDS;
    }
    if ((formatUnit == null)) {
      formatUnit = TimeUnit.SECONDS;
    }
    boolean _lessThan = (formatUnit.compareTo(TimeUnit.SECONDS) < 0);
    if (_lessThan) {
      toAppendTo.append(ETimestampFormat.DEFAULT_DECIMAL_SEPARATOR);
      ETimestampFormat.THOUSANDTH_FORMAT.format(millisThousandth, toAppendTo, pos);
    }
    boolean _lessThan_1 = (formatUnit.compareTo(TimeUnit.MILLISECONDS) < 0);
    if (_lessThan_1) {
      toAppendTo.append(ETimestampFormat.DEFAULT_THOUSANDTH_SEPARATOR);
      ETimestampFormat.THOUSANDTH_FORMAT.format(microsThousandth, toAppendTo, pos);
    }
    boolean _lessThan_2 = (formatUnit.compareTo(TimeUnit.MICROSECONDS) < 0);
    if (_lessThan_2) {
      toAppendTo.append(ETimestampFormat.DEFAULT_THOUSANDTH_SEPARATOR);
      ETimestampFormat.THOUSANDTH_FORMAT.format(nanosThousandth, toAppendTo, pos);
    }
    return toAppendTo;
  }
  
  @Override
  public Long parse(final String source, final ParsePosition parsePosition) {
    final int orgIndex = parsePosition.getIndex();
    int oldIndex = parsePosition.getIndex();
    final Date date = this.dateFormat.parse(source, parsePosition);
    if (((date == null) || (parsePosition.getIndex() == oldIndex))) {
      parsePosition.setIndex(orgIndex);
      return null;
    }
    Integer millisThousandth = Integer.valueOf(0);
    int _length = source.length();
    int _index = parsePosition.getIndex();
    boolean _greaterThan = (_length > _index);
    if (_greaterThan) {
      oldIndex = parsePosition.getIndex();
      millisThousandth = this.parseThousandth(source, parsePosition, ETimestampFormat.DEFAULT_DECIMAL_SEPARATOR);
      int _index_1 = parsePosition.getIndex();
      boolean _equals = (_index_1 == oldIndex);
      if (_equals) {
        parsePosition.setIndex(orgIndex);
        return null;
      }
    }
    Integer microsThousandth = Integer.valueOf(0);
    int _length_1 = source.length();
    int _index_2 = parsePosition.getIndex();
    boolean _greaterThan_1 = (_length_1 > _index_2);
    if (_greaterThan_1) {
      oldIndex = parsePosition.getIndex();
      microsThousandth = this.parseThousandth(source, parsePosition, ETimestampFormat.DEFAULT_THOUSANDTH_SEPARATOR);
      int _index_3 = parsePosition.getIndex();
      boolean _equals_1 = (_index_3 == oldIndex);
      if (_equals_1) {
        parsePosition.setIndex(orgIndex);
        return null;
      }
    }
    Integer nanosThousandth = Integer.valueOf(0);
    int _length_2 = source.length();
    int _index_4 = parsePosition.getIndex();
    boolean _greaterThan_2 = (_length_2 > _index_4);
    if (_greaterThan_2) {
      oldIndex = parsePosition.getIndex();
      nanosThousandth = this.parseThousandth(source, parsePosition, ETimestampFormat.DEFAULT_THOUSANDTH_SEPARATOR);
      int _index_5 = parsePosition.getIndex();
      boolean _equals_2 = (_index_5 == oldIndex);
      if (_equals_2) {
        parsePosition.setIndex(orgIndex);
        return null;
      }
    }
    long _time = date.getTime();
    long _multiply = (_time * 1_000_000);
    long _plus = (_multiply + ((millisThousandth).intValue() * 1_000_000));
    long _plus_1 = (_plus + ((microsThousandth).intValue() * 1_000));
    return Long.valueOf((_plus_1 + (nanosThousandth).intValue()));
  }
  
  private Integer parseThousandth(final String source, final ParsePosition parsePosition, final char separator) {
    int _length = source.length();
    int _index = parsePosition.getIndex();
    int _plus = (_index + 4);
    boolean _lessThan = (_length < _plus);
    if (_lessThan) {
      parsePosition.setErrorIndex(source.length());
      return null;
    } else {
      char _charAt = source.charAt(parsePosition.getIndex());
      boolean _notEquals = (_charAt != separator);
      if (_notEquals) {
        parsePosition.setErrorIndex(parsePosition.getIndex());
        return null;
      }
    }
    final int orgIndex = parsePosition.getIndex();
    final int oldIndex = (orgIndex + 1);
    parsePosition.setIndex(oldIndex);
    final Number number = ETimestampFormat.THOUSANDTH_FORMAT.parse(source, parsePosition);
    int _index_1 = parsePosition.getIndex();
    boolean _equals = (_index_1 == oldIndex);
    if (_equals) {
      parsePosition.setIndex(orgIndex);
      return null;
    }
    int _intValue = number.intValue();
    boolean _greaterThan = (_intValue > 999);
    if (_greaterThan) {
      parsePosition.setErrorIndex(parsePosition.getIndex());
      parsePosition.setIndex(orgIndex);
      return null;
    }
    return Integer.valueOf(number.intValue());
  }
  
  @Pure
  public TimeUnit getTimeUnit() {
    return this.timeUnit;
  }
  
  public void setTimeUnit(final TimeUnit timeUnit) {
    this.timeUnit = timeUnit;
  }
}
