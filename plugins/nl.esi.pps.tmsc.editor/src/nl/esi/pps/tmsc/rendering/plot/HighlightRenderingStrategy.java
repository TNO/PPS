/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.rendering.plot;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.trace4cps.common.jfreechart.data.xy.XYEdgeSeries;
import org.eclipse.trace4cps.common.jfreechart.data.xy.XYEdgeSeriesCollection;
import org.jfree.data.xy.XYIntervalSeries;
import org.jfree.data.xy.XYIntervalSeriesCollection;

import nl.esi.pps.common.jfreechart.rendering.RenderingPaint;
import nl.esi.pps.common.jfreechart.rendering.RenderingStroke;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.viewers.plot.DependenciesRenderer;
import nl.esi.pps.tmsc.viewers.plot.DependencyAnnotation;
import nl.esi.pps.tmsc.viewers.plot.DependencyDataItem;
import nl.esi.pps.tmsc.viewers.plot.ExecutionDataItem;
import nl.esi.pps.tmsc.viewers.plot.ExecutionsRenderer;

public abstract class HighlightRenderingStrategy extends AbstractRenderingStrategy {
	private final String highlightName;
	private final RenderingPaint highlightPaint;
	private final RenderingStroke highlightStroke;
	
	private XYIntervalSeries highlightExecutionSeries;
	private XYEdgeSeries highlightDependencySeries;

	public HighlightRenderingStrategy(String highlightName) {
		this(highlightName, RenderingPaint.BLUE, RenderingStroke.FAT_SOLID);
	}
	
	public HighlightRenderingStrategy(String highlightName, RenderingPaint highlightPaint, RenderingStroke highlightStroke) {
		this.highlightName = highlightName;
		this.highlightPaint = highlightPaint;
		this.highlightStroke = highlightStroke;
	}

	protected abstract boolean isHighlight(Execution execution);

	protected abstract boolean isHighlight(Dependency dependency);

	@Override
	public void preRendering(XYEdgeSeriesCollection dependenciesDataset, DependenciesRenderer dependenciesRenderer,
			XYIntervalSeriesCollection executionsDataset, ExecutionsRenderer executionsRenderer) {
		super.preRendering(dependenciesDataset, dependenciesRenderer, executionsDataset, executionsRenderer);
		
		// Ensure that the default series are the first in the dataset
		getDefaultExecutionSeries(executionsDataset);
		getDefaultDependencySeries(dependenciesDataset);
		// Then create and add the highlight series
		highlightExecutionSeries = new XYIntervalSeries(highlightName, false, true);
		highlightDependencySeries = new XYEdgeSeries(highlightName);
		executionsDataset.addSeries(highlightExecutionSeries);
		dependenciesDataset.addSeries(highlightDependencySeries);

		executionsRenderer.setSeriesPaintSupplier(1, highlightPaint, false);
		executionsRenderer.setSeriesStroke(1, highlightStroke.getStroke(), false);
		executionsRenderer.setSeriesVisibleInLegend(1, true, false);

		dependenciesRenderer.setSeriesPaintSupplier(1, highlightPaint, false);
		dependenciesRenderer.setSeriesStroke(1, highlightStroke.getStroke(), false);
		dependenciesRenderer.setSeriesVisibleInLegend(1, true, false);
	}
	
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (element instanceof Execution && isHighlight((Execution) element)) {
			return true;
		} else if (element instanceof Dependency && isHighlight((Dependency) element)) {
			return true;
		}
		return super.select(viewer, parentElement, element);
	}

	@Override
	public void add(ExecutionDataItem executionDataItem, XYIntervalSeriesCollection executionsDataset,
			ExecutionsRenderer executionsRenderer) {
		if (isHighlight(executionDataItem.getBackReference())) {
			highlightExecutionSeries.add(executionDataItem, false);
		} else {
			super.add(executionDataItem, executionsDataset, executionsRenderer);
		}
	}

	@Override
	public void add(DependencyDataItem dependencyDataItem, XYEdgeSeriesCollection dependenciesDataset,
			DependenciesRenderer dependenciesRenderer) {
		if (isHighlight(dependencyDataItem.getBackReference())) {
			highlightDependencySeries.add(dependencyDataItem, false);
		} else {
			super.add(dependencyDataItem, dependenciesDataset, dependenciesRenderer);
		}
	}
	
	@Override
	public void add(DependencyAnnotation dependencyAnnotation, XYEdgeSeriesCollection dependenciesDataset,
			DependenciesRenderer dependenciesRenderer) {
		if (isHighlight(dependencyAnnotation.getBackReference())) {
			configureDependencyAnnotation(dependencyAnnotation, dependenciesRenderer, 1);
			dependenciesRenderer.addAnnotation(dependencyAnnotation);
		} else {
			super.add(dependencyAnnotation, dependenciesDataset, dependenciesRenderer);
		}
	}
	
	@Override
	public void postRendering(XYEdgeSeriesCollection dependenciesDataset, DependenciesRenderer dependenciesRenderer,
			XYIntervalSeriesCollection executionsDataset, ExecutionsRenderer executionsRenderer) {
		super.postRendering(dependenciesDataset, dependenciesRenderer, executionsDataset, executionsRenderer);

		// Dispose internal rendering state
		highlightExecutionSeries = null;
		highlightDependencySeries = null;
	}
}
