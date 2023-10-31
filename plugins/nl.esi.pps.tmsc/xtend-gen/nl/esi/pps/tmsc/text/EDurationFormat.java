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

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * This class provides the interface for formatting an {@link TmscPackage.Literals#EDURATION}.
 */
@SuppressWarnings("all")
public class EDurationFormat extends NumberFormat {
  /**
   * The default {@link EDurationFormat}, assuming that durations are in nanoseconds.
   */
  public static final EDurationFormat eINSTANCE = new EDurationFormat();
  
  private static final Pattern PATTERN_NANOSECONDS = Pattern.compile("\\s*n(ano)?\\s*s(ec(onds)?)?\\.?");
  
  private static final Pattern PATTERN_MICROSECONDS = Pattern.compile("\\s*(µ|u|micro)\\s*s(ec(onds)?)?\\.?");
  
  private static final Pattern PATTERN_MILLISECONDS = Pattern.compile("\\s*(m(illi)?)\\s*s(ec(onds)?)?\\.?");
  
  private static final Pattern PATTERN_SECONDS = Pattern.compile("\\s*s(ec(onds)?)?\\.?");
  
  private static final Pattern PATTERN_MINUTES = Pattern.compile("\\s*min(utes)?\\.?");
  
  private static final Pattern PATTERN_HOURS = Pattern.compile("\\s*((h(r(s)?)?)|hours)\\.?");
  
  private static final Pattern PATTERN_DAYS = Pattern.compile("\\s*d(ay(s)?)?\\.?");
  
  @Accessors
  private TimeUnit minimumTimeUnit = TimeUnit.NANOSECONDS;
  
  @Accessors
  private TimeUnit maximumTimeUnit = TimeUnit.SECONDS;
  
  public EDurationFormat() {
  }
  
  public EDurationFormat(final TimeUnit minUnit, final TimeUnit maxUnit) {
    boolean _greaterThan = (minUnit.compareTo(maxUnit) > 0);
    if (_greaterThan) {
      throw new IllegalArgumentException("Minimum time unit should not by greater than maximum time unit");
    }
    this.minimumTimeUnit = minUnit;
    this.maximumTimeUnit = maxUnit;
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
    final long value = this.minimumTimeUnit.convert(number, TimeUnit.NANOSECONDS);
    if ((value == 0)) {
      return toAppendTo.append("0").append(this.getPostfix(this.minimumTimeUnit));
    }
    for (TimeUnit unit = this.maximumTimeUnit; (unit.compareTo(this.minimumTimeUnit) > 0); unit = TimeUnit.values()[(unit.ordinal() - 1)]) {
      {
        final long divisor = this.minimumTimeUnit.convert(1, unit);
        if ((value >= divisor)) {
          if (((value % divisor) == 0)) {
            return toAppendTo.append((value / divisor)).append(this.getPostfix(unit));
          } else {
            return toAppendTo.append((value / ((double) divisor))).append(this.getPostfix(unit));
          }
        }
      }
    }
    return toAppendTo.append(value).append(this.getPostfix(this.minimumTimeUnit));
  }
  
  private String getPostfix(final TimeUnit unit) {
    String _switchResult = null;
    if (unit != null) {
      switch (unit) {
        case NANOSECONDS:
          _switchResult = " ns.";
          break;
        case MICROSECONDS:
          _switchResult = " µs.";
          break;
        case MILLISECONDS:
          _switchResult = " ms.";
          break;
        case SECONDS:
          _switchResult = " sec.";
          break;
        case MINUTES:
          _switchResult = " min.";
          break;
        case HOURS:
          _switchResult = " hr.";
          break;
        case DAYS:
          _switchResult = " days";
          break;
        default:
          break;
      }
    }
    return _switchResult;
  }
  
  @Override
  public Number parse(final String source) throws ParseException {
    final ParsePosition parsePosition = new ParsePosition(0);
    final Number number = NumberFormat.getNumberInstance().parse(source, parsePosition);
    int _errorIndex = parsePosition.getErrorIndex();
    boolean _greaterEqualsThan = (_errorIndex >= 0);
    if (_greaterEqualsThan) {
      int _errorIndex_1 = parsePosition.getErrorIndex();
      throw new ParseException((("Unparseable number: \"" + source) + "\""), _errorIndex_1);
    }
    final long multiplier = this.getMultiplier(source, parsePosition);
    int _errorIndex_2 = parsePosition.getErrorIndex();
    boolean _greaterEqualsThan_1 = (_errorIndex_2 >= 0);
    if (_greaterEqualsThan_1) {
      int _errorIndex_3 = parsePosition.getErrorIndex();
      throw new ParseException((("Unparseable unit: \"" + source) + "\""), _errorIndex_3);
    }
    double _doubleValue = number.doubleValue();
    double _multiply = (_doubleValue * multiplier);
    return Long.valueOf(Math.round(_multiply));
  }
  
  @Override
  public Number parse(final String source, final ParsePosition parsePosition) {
    final Number number = NumberFormat.getNumberInstance().parse(source, parsePosition);
    if ((number == null)) {
      return null;
    }
    final long multiplier = this.getMultiplier(source, parsePosition);
    int _errorIndex = parsePosition.getErrorIndex();
    boolean _greaterEqualsThan = (_errorIndex >= 0);
    if (_greaterEqualsThan) {
      return null;
    }
    double _doubleValue = number.doubleValue();
    double _multiply = (_doubleValue * multiplier);
    return Long.valueOf(Math.round(_multiply));
  }
  
  private long getMultiplier(final String source, final ParsePosition parsePosition) {
    long _switchResult = (long) 0;
    boolean _matched = false;
    boolean _matches = this.matches(EDurationFormat.PATTERN_NANOSECONDS, source, parsePosition);
    if (_matches) {
      _matched=true;
      _switchResult = 1;
    }
    if (!_matched) {
      boolean _matches_1 = this.matches(EDurationFormat.PATTERN_MICROSECONDS, source, parsePosition);
      if (_matches_1) {
        _matched=true;
        _switchResult = TimeUnit.NANOSECONDS.convert(1, TimeUnit.MICROSECONDS);
      }
    }
    if (!_matched) {
      boolean _matches_2 = this.matches(EDurationFormat.PATTERN_MILLISECONDS, source, parsePosition);
      if (_matches_2) {
        _matched=true;
        _switchResult = TimeUnit.NANOSECONDS.convert(1, TimeUnit.MILLISECONDS);
      }
    }
    if (!_matched) {
      boolean _matches_3 = this.matches(EDurationFormat.PATTERN_SECONDS, source, parsePosition);
      if (_matches_3) {
        _matched=true;
        _switchResult = TimeUnit.NANOSECONDS.convert(1, TimeUnit.SECONDS);
      }
    }
    if (!_matched) {
      boolean _matches_4 = this.matches(EDurationFormat.PATTERN_MINUTES, source, parsePosition);
      if (_matches_4) {
        _matched=true;
        _switchResult = TimeUnit.NANOSECONDS.convert(1, TimeUnit.MINUTES);
      }
    }
    if (!_matched) {
      boolean _matches_5 = this.matches(EDurationFormat.PATTERN_HOURS, source, parsePosition);
      if (_matches_5) {
        _matched=true;
        _switchResult = TimeUnit.NANOSECONDS.convert(1, TimeUnit.HOURS);
      }
    }
    if (!_matched) {
      boolean _matches_6 = this.matches(EDurationFormat.PATTERN_DAYS, source, parsePosition);
      if (_matches_6) {
        _matched=true;
        _switchResult = TimeUnit.NANOSECONDS.convert(1, TimeUnit.DAYS);
      }
    }
    if (!_matched) {
      _switchResult = 1;
    }
    return _switchResult;
  }
  
  private boolean matches(final Pattern pattern, final String source, final ParsePosition parsePosition) {
    final String unit = source.substring(parsePosition.getIndex());
    final Matcher matcher = pattern.matcher(unit);
    boolean _find = matcher.find();
    if (_find) {
      int _start = matcher.start();
      boolean _greaterThan = (_start > 0);
      if (_greaterThan) {
        parsePosition.setErrorIndex(parsePosition.getIndex());
      } else {
        int _index = parsePosition.getIndex();
        int _end = matcher.end();
        int _plus = (_index + _end);
        parsePosition.setIndex(_plus);
      }
      return true;
    }
    return false;
  }
  
  @Pure
  public TimeUnit getMinimumTimeUnit() {
    return this.minimumTimeUnit;
  }
  
  public void setMinimumTimeUnit(final TimeUnit minimumTimeUnit) {
    this.minimumTimeUnit = minimumTimeUnit;
  }
  
  @Pure
  public TimeUnit getMaximumTimeUnit() {
    return this.maximumTimeUnit;
  }
  
  public void setMaximumTimeUnit(final TimeUnit maximumTimeUnit) {
    this.maximumTimeUnit = maximumTimeUnit;
  }
}
