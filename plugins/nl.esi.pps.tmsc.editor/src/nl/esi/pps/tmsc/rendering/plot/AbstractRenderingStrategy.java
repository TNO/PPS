/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.rendering.plot;

import java.awt.Color;

import org.eclipse.trace4cps.common.jfreechart.chart.axis.Section;
import org.eclipse.trace4cps.common.jfreechart.data.xy.XYEdgeSeries;
import org.eclipse.trace4cps.common.jfreechart.data.xy.XYEdgeSeriesCollection;
import org.jfree.chart.ChartColor;
import org.jfree.data.xy.XYIntervalSeries;
import org.jfree.data.xy.XYIntervalSeriesCollection;

import nl.esi.pps.common.jfreechart.rendering.RenderingPaint;
import nl.esi.pps.common.jfreechart.rendering.RenderingStroke;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Lifeline;
import nl.esi.pps.tmsc.Message;
import nl.esi.pps.tmsc.MessageControl;
import nl.esi.pps.tmsc.Reply;
import nl.esi.pps.tmsc.viewers.plot.DependenciesRenderer;
import nl.esi.pps.tmsc.viewers.plot.DependencyAnnotation;
import nl.esi.pps.tmsc.viewers.plot.DependencyDataItem;
import nl.esi.pps.tmsc.viewers.plot.DependencyIncomingAnnotation;
import nl.esi.pps.tmsc.viewers.plot.DependencyOutgoingAnnotation;
import nl.esi.pps.tmsc.viewers.plot.ExecutionDataItem;
import nl.esi.pps.tmsc.viewers.plot.ExecutionsRenderer;

public abstract class AbstractRenderingStrategy implements IRenderingStrategy, IViewerFilter {
	private Integer defaultExecutionSeriesIndex;
	private Integer defaultDependencySeriesIndex;

	protected int getDefaultExecutionSeriesIndex(XYIntervalSeriesCollection executionsDataset) {
		if (defaultExecutionSeriesIndex == null) {
			defaultExecutionSeriesIndex = executionsDataset.getSeriesCount();
			executionsDataset.addSeries(new XYIntervalSeries("Execution", false, true));
		}
		return defaultExecutionSeriesIndex;
	}

	protected XYIntervalSeries getDefaultExecutionSeries(XYIntervalSeriesCollection executionsDataset) {
		return executionsDataset.getSeries(getDefaultExecutionSeriesIndex(executionsDataset));
	}

	protected int getDefaultDependencySeriesIndex(XYEdgeSeriesCollection dependenciesDataset) {
		if (defaultDependencySeriesIndex == null) {
			defaultDependencySeriesIndex = dependenciesDataset.getSeriesCount();
			dependenciesDataset.addSeries(new XYEdgeSeries("Dependency"));
		}
		return defaultDependencySeriesIndex;
	}

	protected XYEdgeSeries getDefaultDependencySeries(XYEdgeSeriesCollection dependenciesDataset) {
		return dependenciesDataset.getSeries(getDefaultDependencySeriesIndex(dependenciesDataset));
	}

	@Override
	public void preRendering(XYEdgeSeriesCollection dependenciesDataset, DependenciesRenderer dependenciesRenderer,
			XYIntervalSeriesCollection executionsDataset, ExecutionsRenderer executionsRenderer) {
		dependenciesDataset.setNotify(false);
		executionsDataset.setNotify(false);

		defaultExecutionSeriesIndex = null;
		defaultDependencySeriesIndex = null;

		resetRenderer(dependenciesRenderer);
		resetRenderer(executionsRenderer);
	}

	protected void resetRenderer(DependenciesRenderer dependenciesRenderer) {
		dependenciesRenderer.setComputeItemLabelContrastColor(true);

		dependenciesRenderer.setDefaultSeriesVisibleInLegend(false);
		dependenciesRenderer.clearSeriesVisibleInLegend(false);

		dependenciesRenderer.setAutoPopulateSeriesPaint(false);
		dependenciesRenderer.setAutoPopulateSeriesOutlinePaint(false);
		dependenciesRenderer.setAutoPopulateSeriesFillPaint(false);
		dependenciesRenderer.clearSeriesPaints(false);
		dependenciesRenderer.clearSeriesOutlinePaints(false);
		dependenciesRenderer.clearSeriesFillPaints(false);
		dependenciesRenderer.setDefaultPaintSupplier(RenderingPaint.CONTROL_SHADOW, false);

		dependenciesRenderer.setAutoPopulateSeriesStroke(false);
		dependenciesRenderer.setAutoPopulateSeriesOutlineStroke(false);
		dependenciesRenderer.clearSeriesStrokes(false);
		dependenciesRenderer.clearSeriesOutlineStrokes(true);
		dependenciesRenderer.setDefaultStroke(RenderingStroke.SOLID.getStroke());
		dependenciesRenderer.setDefaultOutlineStroke(RenderingStroke.SOLID.getStroke());
	}

	protected void resetRenderer(ExecutionsRenderer executionsRenderer) {
		executionsRenderer.setComputeItemLabelContrastColor(true);

		executionsRenderer.setDefaultSeriesVisibleInLegend(false);
		executionsRenderer.clearSeriesVisibleInLegend(false);

		executionsRenderer.setAutoPopulateSeriesPaint(false);
		executionsRenderer.setAutoPopulateSeriesOutlinePaint(false);
		executionsRenderer.clearSeriesPaints(false);
		executionsRenderer.clearSeriesOutlinePaints(false);
		executionsRenderer.setDefaultPaintSupplier(RenderingPaint.CONTROL, false);

		executionsRenderer.setAutoPopulateSeriesOutlineStroke(false);
		executionsRenderer.setDefaultOutlineStroke(RenderingStroke.FINE_SOLID.getStroke());
	}
	
	@Override
	public void configureLifelineSection(Lifeline lifeline, Section section) {
		if (!lifeline.isTraced()) {
			section.setGridBandPaint(RenderingPaint.ORANGE.getGridBandPaint());
			section.setGridBandAlternatePaint(RenderingPaint.ORANGE.getGridBandAlternativePaint());
		}
	}

	@Override
	public void add(ExecutionDataItem executionDataItem, XYIntervalSeriesCollection executionsDataset,
			ExecutionsRenderer executionsRenderer) {
		getDefaultExecutionSeries(executionsDataset).add(executionDataItem, false);
	}

	@Override
	public void add(DependencyDataItem dependencyDataItem, XYEdgeSeriesCollection dependenciesDataset,
			DependenciesRenderer dependenciesRenderer) {
		getDefaultDependencySeries(dependenciesDataset).add(dependencyDataItem, false);
	}

	@Override
	public void add(DependencyAnnotation dependencyAnnotation, XYEdgeSeriesCollection dependenciesDataset,
			DependenciesRenderer dependenciesRenderer) {
		int series = getDefaultDependencySeriesIndex(dependenciesDataset);
		configureDependencyAnnotation(dependencyAnnotation, dependenciesRenderer, series);
		dependenciesRenderer.addAnnotation(dependencyAnnotation);
	}

	protected void configureDependencyAnnotation(DependencyAnnotation dependencyAnnotation,
			DependenciesRenderer dependenciesRenderer, int series) {
		dependencyAnnotation.setAngle(getDependencyAnnotationAngle(dependencyAnnotation, dependenciesRenderer, series));
		dependencyAnnotation.setArrowPaint(dependenciesRenderer.lookupSeriesPaint(series));
		dependencyAnnotation.setArrowStroke(dependenciesRenderer.lookupSeriesStroke(series));
		dependencyAnnotation.setOutlinePaint(dependenciesRenderer.lookupSeriesOutlinePaint(series));
		dependencyAnnotation.setOutlineStroke(dependenciesRenderer.lookupSeriesOutlineStroke(series));
		dependencyAnnotation.setBackgroundPaint(dependenciesRenderer.lookupSeriesFillPaint(series));
		dependencyAnnotation.setFont(dependenciesRenderer.getItemLabelFont(series, -1));
		if (dependenciesRenderer.isComputeItemLabelContrastColor()
				&& dependencyAnnotation.getBackgroundPaint() instanceof Color) {
			dependencyAnnotation.setPaint(ChartColor.getContrastColor((Color) dependencyAnnotation.getBackgroundPaint()));
		} else {
			dependencyAnnotation.setPaint(dependenciesRenderer.getItemLabelPaint(series, -1));
		}
	}
	
	protected double getDependencyAnnotationAngle(DependencyAnnotation dependencyAnnotation,
			DependenciesRenderer dependenciesRenderer, int series) {
		Dependency dependency = dependencyAnnotation.getBackReference();
		if (dependencyAnnotation instanceof DependencyOutgoingAnnotation) {
			if (dependency instanceof MessageControl) {
				Message message = ((MessageControl) dependency).getMessage();
				if (message instanceof Reply) {
					return Math.PI * 0.125;
				} else {
					return Math.PI * -0.125;
				}
			} else if (dependencyAnnotation.getBackReference() instanceof Reply) {
				return Math.PI * 0.25;
			} else {
				return Math.PI * -0.25;
			}
		} else if (dependencyAnnotation instanceof DependencyIncomingAnnotation) {
			if (dependency instanceof MessageControl) {
				Message message = ((MessageControl) dependency).getMessage();
				if (message instanceof Reply) {
					return Math.PI * -0.625;
				} else {
					return Math.PI * 0.625;
				}
			} else if (dependencyAnnotation.getBackReference() instanceof Reply) {
				return Math.PI * -0.75;
			} else {
				return Math.PI * 0.75;
			}
		}
		return 0;
	}

	@Override
	public void postRendering(XYEdgeSeriesCollection dependenciesDataset, DependenciesRenderer dependenciesRenderer,
			XYIntervalSeriesCollection executionsDataset, ExecutionsRenderer executionsRenderer) {
		hideEmptySeriesInLegend(dependenciesDataset, dependenciesRenderer, executionsDataset, executionsRenderer);

		defaultExecutionSeriesIndex = null;
		defaultDependencySeriesIndex = null;

		dependenciesDataset.setNotify(true);
		executionsDataset.setNotify(true);
	}

	protected void hideEmptySeriesInLegend(XYEdgeSeriesCollection dependenciesDataset,
			DependenciesRenderer dependenciesRenderer, XYIntervalSeriesCollection executionsDataset,
			ExecutionsRenderer executionsRenderer) {
		// Iterate through datasets and hide empty series
		for (int series = 0; series < dependenciesDataset.getSeriesCount(); series++) {
			if (dependenciesDataset.getItemCount(series) == 0) {
				dependenciesRenderer.setSeriesVisibleInLegend(series, false, false);
			}
		}

		for (int series = 0; series < executionsDataset.getSeriesCount(); series++) {
			if (executionsDataset.getItemCount(series) == 0) {
				executionsRenderer.setSeriesVisibleInLegend(series, false, false);
			}
		}
	}
}
