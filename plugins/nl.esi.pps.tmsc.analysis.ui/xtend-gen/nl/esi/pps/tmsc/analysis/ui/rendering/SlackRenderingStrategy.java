/**
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.analysis.ui.rendering;

import java.awt.geom.Point2D;
import java.util.List;
import java.util.Objects;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.EventType;
import nl.esi.pps.tmsc.TMSC;
import nl.esi.pps.tmsc.analysis.SlackAnalysis;
import nl.esi.pps.tmsc.rendering.plot.DefaultRenderingStrategy;
import nl.esi.pps.tmsc.text.EDurationFormat;
import nl.esi.pps.tmsc.viewers.plot.DependenciesRenderer;
import nl.esi.pps.tmsc.viewers.plot.EventNoteAnnotation;
import nl.esi.pps.tmsc.viewers.plot.ExecutionDataItem;
import nl.esi.pps.tmsc.viewers.plot.ExecutionsRenderer;
import nl.esi.pps.tmsc.viewers.plot.ExecutionsVisibility;
import org.eclipse.lsat.common.xtend.Queries;
import org.eclipse.trace4cps.common.jfreechart.data.xy.XYEdgeSeriesCollection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.jfree.data.xy.XYIntervalSeriesCollection;

@SuppressWarnings("all")
public class SlackRenderingStrategy extends DefaultRenderingStrategy {
  public static final String ID = "nl.esi.pps.tmsc.analysis.ui.rendering.slack";

  @Override
  public void preRendering(final XYEdgeSeriesCollection dependenciesDataset, final DependenciesRenderer dependenciesRenderer, final XYIntervalSeriesCollection executionsDataset, final ExecutionsRenderer executionsRenderer) {
    super.preRendering(dependenciesDataset, dependenciesRenderer, executionsDataset, executionsRenderer);
    ExecutionsVisibility.ALL.apply(executionsRenderer, false);
  }

  @Override
  public void add(final ExecutionDataItem executionDataItem, final XYIntervalSeriesCollection executionsDataset, final ExecutionsRenderer executionsRenderer) {
    super.add(executionDataItem, executionsDataset, executionsRenderer);
    this.addSlackAnnotation(executionsRenderer, executionDataItem, EventType.ENTRY);
    this.addSlackAnnotation(executionsRenderer, executionDataItem, EventType.EXIT);
  }

  private void addSlackAnnotation(final ExecutionsRenderer executionsRenderer, final ExecutionDataItem executionDataItem, final EventType eventType) {
    Event _xifexpression = null;
    boolean _equals = Objects.equals(eventType, EventType.ENTRY);
    if (_equals) {
      _xifexpression = executionDataItem.getBackReference().getEntry();
    } else {
      _xifexpression = executionDataItem.getBackReference().getExit();
    }
    final Event event = _xifexpression;
    double _xifexpression_1 = (double) 0;
    boolean _equals_1 = Objects.equals(eventType, EventType.ENTRY);
    if (_equals_1) {
      _xifexpression_1 = executionDataItem.getXLowValue();
    } else {
      _xifexpression_1 = executionDataItem.getXHighValue();
    }
    final double xValue = _xifexpression_1;
    final Iterable<TMSC> tmscs = Queries.<TMSC>union(event.getScopes(), event.getTmsc());
    final Function1<TMSC, Long> _function = (TMSC tmsc) -> {
      return Long.valueOf(SlackAnalysis.getSlack(event, tmsc));
    };
    final Function1<Long, Boolean> _function_1 = (Long slack) -> {
      return Boolean.valueOf(((slack).longValue() > 0));
    };
    final List<Long> slacks = IterableExtensions.<Long>toList(IterableExtensions.<Long>filter(IterableExtensions.<TMSC, Long>map(tmscs, _function), _function_1));
    boolean _isEmpty = slacks.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      double _yValue = executionDataItem.getYValue();
      final Point2D.Double location = new Point2D.Double(xValue, _yValue);
      final String note = EDurationFormat.eINSTANCE.format(IterableExtensions.<Long>min(slacks));
      EventNoteAnnotation _eventNoteAnnotation = new EventNoteAnnotation(location, note, event);
      executionsRenderer.addAnnotation(_eventNoteAnnotation);
    }
  }
}
