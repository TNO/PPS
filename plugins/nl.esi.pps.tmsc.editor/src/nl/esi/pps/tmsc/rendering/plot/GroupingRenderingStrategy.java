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

import java.util.HashMap;

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

public abstract class GroupingRenderingStrategy extends AbstractRenderingStrategy {
	private final HashMap<String, Integer> groupSeries = new HashMap<>();
	
	private XYEdgeSeriesCollection dependenciesDataset;
	private DependenciesRenderer dependenciesRenderer;
	private XYIntervalSeriesCollection executionsDataset;
	private ExecutionsRenderer executionsRenderer;

	protected abstract String getGroupKey(Execution execution);
	
	protected abstract String getGroupKey(Dependency dependency);
	
	@Override
	public void preRendering(XYEdgeSeriesCollection dependenciesDataset, DependenciesRenderer dependenciesRenderer,
			XYIntervalSeriesCollection executionsDataset, ExecutionsRenderer executionsRenderer) {
		super.preRendering(dependenciesDataset, dependenciesRenderer, executionsDataset, executionsRenderer);
		
		// Prepare internal rendering state
        this.dependenciesDataset = dependenciesDataset;
		this.dependenciesRenderer = dependenciesRenderer;
		this.executionsDataset = executionsDataset;
		this.executionsRenderer = executionsRenderer;
		this.groupSeries.clear();

        // Ensure that the default series are the first in the dataset
        getDefaultExecutionSeries(executionsDataset);
        getDefaultDependencySeries(dependenciesDataset);
	}
	
	protected Integer getGroupSeries(String groupKey) {
		if (groupKey == null) {
			return null;
		}
		Integer series = groupSeries.get(groupKey);
		if (series != null) {
			return series;
		}
		
		series = groupSeries.size() + 1;
		groupSeries.put(groupKey, series);
		
		// Configure series, keep dependency and execution series in sync, meaning
		// both dependencies and executions with equal group-key get same color.
		RenderingPaint groupPaint = RenderingPaint.valueOf(series - 1);

		dependenciesDataset.addSeries(new XYEdgeSeries(groupKey));
		dependenciesRenderer.setSeriesPaintSupplier(series, groupPaint, false);
		dependenciesRenderer.setSeriesStroke(series, RenderingStroke.FAT_SOLID.getStroke(), false);
		
		executionsDataset.addSeries(new XYIntervalSeries(groupKey, false, true));
		executionsRenderer.setSeriesPaintSupplier(series, groupPaint, false);
		executionsRenderer.setSeriesVisibleInLegend(series, true, false);
		
		return series;
	}
	
	@Override
	public void add(ExecutionDataItem executionDataItem, XYIntervalSeriesCollection executionsDataset,
			ExecutionsRenderer executionsRenderer) {
		Integer groupSeries = getGroupSeries(getGroupKey(executionDataItem.getBackReference()));
		if (groupSeries != null) {
			executionsDataset.getSeries(groupSeries).add(executionDataItem, false);
		} else {
			super.add(executionDataItem, executionsDataset, executionsRenderer);
		}
	}
	
	@Override
	public void add(DependencyDataItem dependencyDataItem, XYEdgeSeriesCollection dependenciesDataset,
			DependenciesRenderer dependenciesRenderer) {
		Integer groupSeries = getGroupSeries(getGroupKey(dependencyDataItem.getBackReference()));
		if (groupSeries != null) {
			dependenciesDataset.getSeries(groupSeries).add(dependencyDataItem, false);
		} else {
			super.add(dependencyDataItem, dependenciesDataset, dependenciesRenderer);
		}
	}
	
	@Override
	public void add(DependencyAnnotation dependencyAnnotation, XYEdgeSeriesCollection dependenciesDataset,
			DependenciesRenderer dependenciesRenderer) {
		Integer groupSeries = getGroupSeries(getGroupKey(dependencyAnnotation.getBackReference()));
		if (groupSeries != null) {
			configureDependencyAnnotation(dependencyAnnotation, dependenciesRenderer, groupSeries);
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
        this.dependenciesDataset = null;
		this.dependenciesRenderer = null;
		this.executionsDataset = null;
		this.executionsRenderer = null;
		this.groupSeries.clear();
	}

	@Override
	protected void hideEmptySeriesInLegend(XYEdgeSeriesCollection dependenciesDataset,
			DependenciesRenderer dependenciesRenderer, XYIntervalSeriesCollection executionsDataset,
			ExecutionsRenderer executionsRenderer) {
		// Empty, disable this feature
	}
}
