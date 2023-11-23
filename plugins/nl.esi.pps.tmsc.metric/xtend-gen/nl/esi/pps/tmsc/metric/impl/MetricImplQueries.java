/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.metric.impl;

import nl.esi.pps.tmsc.metric.MetricInstance;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class MetricImplQueries {
  public static String getNameImpl(final MetricInstance metricInstance) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = metricInstance.getMetric().getName();
    _builder.append(_name);
    _builder.append(" - ");
    String _id = metricInstance.getId();
    _builder.append(_id);
    return _builder.toString();
  }
  
  public static boolean isExceedsBudgetImpl(final MetricInstance metricInstance) {
    final Long budget = metricInstance.getMetric().getBudget();
    final Long duration = metricInstance.getDuration();
    return (((budget != null) && (duration != null)) && (duration.compareTo(budget) > 0));
  }
}
