/**
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.analysis;

import java.util.ArrayList;
import java.util.List;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.TMSC;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.DoubleExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class TimeBoundOutlierAnalysis {
  private static final double IQR_FACTOR = 3.0;

  private TimeBoundOutlierAnalysis() {
  }

  public static Iterable<Dependency> analyseTimeBoundOutliers(final TMSC tmsc) {
    final Function1<Dependency, Boolean> _function = (Dependency it) -> {
      return Boolean.valueOf(TimeBoundOutlierAnalysis.isTimeBoundOutlier(it));
    };
    return IterableExtensions.<Dependency>filter(tmsc.getDependencies(), _function);
  }

  public static boolean isTimeBoundOutlier(final Dependency dependency) {
    Long _timeBound = dependency.getTimeBound();
    boolean _tripleEquals = (_timeBound == null);
    if (_tripleEquals) {
      return false;
    }
    final Long timeBoundOutlierThreshold = TimeBoundOutlierAnalysis.analyseTimeBoundOutlierThreshold(dependency, false);
    if ((timeBoundOutlierThreshold == null)) {
      return false;
    }
    Long _timeBound_1 = dependency.getTimeBound();
    return (_timeBound_1.compareTo(timeBoundOutlierThreshold) > 0);
  }

  public static Long analyseTimeBoundOutlierThreshold(final Dependency dependency, final boolean refresh) {
    if ((TimeBoundOutlierAnalysis.isSetTimeBoundOutlierThreshold(dependency) && (!refresh))) {
      return TimeBoundOutlierAnalysis.getTimeBoundOutlierThreshold(dependency);
    }
    if (((!TimeBoundOutlierAnalysis.isSetTimeBoundSamples(dependency)) || TimeBoundOutlierAnalysis.getTimeBoundSamples(dependency).isEmpty())) {
      return null;
    }
    final Pair<Double, Double> iqr = TimeBoundOutlierAnalysis.getInterquartileRange(TimeBoundOutlierAnalysis.getTimeBoundSamples(dependency));
    final Double Q1 = iqr.getKey();
    final Double Q3 = iqr.getValue();
    double _minus = DoubleExtensions.operator_minus(Q3, Q1);
    double _multiply = (_minus * TimeBoundOutlierAnalysis.IQR_FACTOR);
    double _plus = ((Q3).doubleValue() + _multiply);
    TimeBoundOutlierAnalysis.setTimeBoundOutlierThreshold(dependency, Long.valueOf(Double.valueOf(Math.ceil(_plus)).longValue()));
    return TimeBoundOutlierAnalysis.getTimeBoundOutlierThreshold(dependency);
  }

  /**
   * @see https://en.wikipedia.org/wiki/Interquartile_range
   */
  private static Pair<Double, Double> getInterquartileRange(final Iterable<Long> values) {
    Pair<Double, Double> _switchResult = null;
    List<Long> _sort = IterableExtensions.<Long>sort(values);
    final List<Long> sortedValues = _sort;
    boolean _matched = false;
    boolean _isEmpty = sortedValues.isEmpty();
    if (_isEmpty) {
      _matched=true;
      _switchResult = null;
    }
    if (!_matched) {
      int _size = sortedValues.size();
      boolean _equals = (_size == 1);
      if (_equals) {
        _matched=true;
        _switchResult = Pair.<Double, Double>of(Double.valueOf(IterableExtensions.<Long>head(sortedValues).doubleValue()), Double.valueOf(IterableExtensions.<Long>head(sortedValues).doubleValue()));
      }
    }
    if (!_matched) {
      int _size_1 = sortedValues.size();
      int _divide = (_size_1 / 2);
      int _modulo = (_divide % 2);
      boolean _equals_1 = (_modulo == 0);
      if (_equals_1) {
        _matched=true;
        Pair<Double, Double> _xblockexpression = null;
        {
          int _size_2 = sortedValues.size();
          final int highIndexQ1 = (_size_2 / 4);
          Long _at = TimeBoundOutlierAnalysis.<Long>at(sortedValues, (highIndexQ1 - 1));
          Long _at_1 = TimeBoundOutlierAnalysis.<Long>at(sortedValues, highIndexQ1);
          long _plus = ((_at).longValue() + (_at_1).longValue());
          double _divide_1 = (_plus / 2.0);
          Long _at_2 = TimeBoundOutlierAnalysis.<Long>at(sortedValues, ((-highIndexQ1) + 1));
          Long _at_3 = TimeBoundOutlierAnalysis.<Long>at(sortedValues, (-highIndexQ1));
          long _plus_1 = ((_at_2).longValue() + (_at_3).longValue());
          double _divide_2 = (_plus_1 / 2.0);
          _xblockexpression = Pair.<Double, Double>of(Double.valueOf(_divide_1), Double.valueOf(_divide_2));
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      Pair<Double, Double> _xblockexpression_1 = null;
      {
        int _size_2 = sortedValues.size();
        final int indexQ1 = (_size_2 / 4);
        _xblockexpression_1 = Pair.<Double, Double>of(Double.valueOf(TimeBoundOutlierAnalysis.<Long>at(sortedValues, indexQ1).doubleValue()), Double.valueOf(TimeBoundOutlierAnalysis.<Long>at(sortedValues, (-indexQ1)).doubleValue()));
      }
      _switchResult = _xblockexpression_1;
    }
    return _switchResult;
  }

  private static <T extends Object> T at(final List<T> values, final int position) {
    T _xifexpression = null;
    if ((position < 0)) {
      int _size = values.size();
      int _minus = (_size - 1);
      int _plus = (_minus + position);
      _xifexpression = values.get(_plus);
    } else {
      _xifexpression = values.get(position);
    }
    return _xifexpression;
  }

  public static Long getTimeBoundOutlierThreshold(final Dependency container) {
    final String key = "timeBoundOutlierThreshold";
    final Object value = container.getProperties().get(key);
    return (Long) value;
  }

  public static void setTimeBoundOutlierThreshold(final Dependency container, final Long value) {
    final String key = "timeBoundOutlierThreshold";
    container.getProperties().put(key, value);
  }

  /**
   * Returns whether the value of the '{@link nl.esi.pps.tmsc.analysis.TimeBoundOutlierAnalysis#getTimeBoundOutlierThreshold <em>timeBoundOutlierThreshold</em>}' property is set on {@code container}.
   */
  public static boolean isSetTimeBoundOutlierThreshold(final Dependency container) {
    final String key = "timeBoundOutlierThreshold";
    return container.getProperties().containsKey(key);
  }

  /**
   * Unsets the value of the '{@link nl.esi.pps.tmsc.analysis.TimeBoundOutlierAnalysis#getTimeBoundOutlierThreshold <em>timeBoundOutlierThreshold</em>}' property on {@code container}.
   */
  public static void unsetTimeBoundOutlierThreshold(final Dependency container) {
    final String key = "timeBoundOutlierThreshold";
    container.getProperties().remove(key);
  }

  /**
   * Creates initial value for persisted {@code timeBoundSamples} property on Dependency
   */
  private static final ArrayList<Long> _getInitial_Dependency_TimeBoundSamples() {
    ArrayList<Long> _newArrayList = CollectionLiterals.<Long>newArrayList();
    return _newArrayList;
  }

  public static ArrayList<Long> getTimeBoundSamples(final Dependency container) {
    final String key = "timeBoundSamples";
    final Object value = container.getProperties().map().computeIfAbsent(key, k -> _getInitial_Dependency_TimeBoundSamples());
    return (ArrayList<Long>) value;
  }

  public static void setTimeBoundSamples(final Dependency container, final ArrayList<Long> value) {
    final String key = "timeBoundSamples";
    container.getProperties().put(key, value);
  }

  /**
   * Returns whether the value of the '{@link nl.esi.pps.tmsc.analysis.TimeBoundOutlierAnalysis#getTimeBoundSamples <em>timeBoundSamples</em>}' property is set on {@code container}.
   */
  public static boolean isSetTimeBoundSamples(final Dependency container) {
    final String key = "timeBoundSamples";
    return container.getProperties().containsKey(key);
  }

  /**
   * Unsets the value of the '{@link nl.esi.pps.tmsc.analysis.TimeBoundOutlierAnalysis#getTimeBoundSamples <em>timeBoundSamples</em>}' property on {@code container}.
   */
  public static void unsetTimeBoundSamples(final Dependency container) {
    final String key = "timeBoundSamples";
    container.getProperties().remove(key);
  }
}
