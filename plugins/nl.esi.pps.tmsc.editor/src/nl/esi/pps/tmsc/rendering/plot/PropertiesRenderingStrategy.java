/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.rendering.plot;

import java.awt.Stroke;
import java.util.HashMap;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.trace4cps.common.jfreechart.chart.axis.Section;
import org.eclipse.trace4cps.common.jfreechart.data.xy.XYEdgeSeries;
import org.eclipse.trace4cps.common.jfreechart.data.xy.XYEdgeSeriesCollection;
import org.eclipse.xtext.xbase.lib.Pair;
import org.jfree.data.xy.XYIntervalSeries;
import org.jfree.data.xy.XYIntervalSeriesCollection;

import nl.esi.pps.common.jfreechart.rendering.PaintSupplier;
import nl.esi.pps.common.jfreechart.rendering.RenderingPaint;
import nl.esi.pps.common.jfreechart.rendering.RenderingStroke;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.Lifeline;
import nl.esi.pps.tmsc.presentation.TmscEditorPlugin;
import nl.esi.pps.tmsc.rendering.RenderingProperties;
import nl.esi.pps.tmsc.viewers.plot.DependenciesRenderer;
import nl.esi.pps.tmsc.viewers.plot.DependencyAnnotation;
import nl.esi.pps.tmsc.viewers.plot.DependencyDataItem;
import nl.esi.pps.tmsc.viewers.plot.ExecutionDataItem;
import nl.esi.pps.tmsc.viewers.plot.ExecutionsRenderer;

public class PropertiesRenderingStrategy extends AbstractRenderingStrategy {
	public static final String ID = TmscEditorPlugin.getPlugin().getSymbolicName() + ".properties_rendering_strategy";

	public static final PaintSupplier DEFAULT_PAINT_EXECUTION = RenderingPaint.GREEN;
	public static final PaintSupplier DEFAULT_PAINT_DEPENDENCY = RenderingPaint.LIGHT_GRAY;
	public static final Stroke DEFAULT_STROKE_DEPENDENCY = RenderingStroke.SOLID.getStroke();

	private final HashMap<Pair<PaintSupplier, Stroke>, Integer> dependencySeries = new HashMap<>();
	private final HashMap<PaintSupplier, Integer> executionSeries = new HashMap<>();
	
	@Override
	public void preRendering(XYEdgeSeriesCollection dependenciesDataset, DependenciesRenderer dependenciesRenderer,
			XYIntervalSeriesCollection executionsDataset, ExecutionsRenderer executionsRenderer) {
		super.preRendering(dependenciesDataset, dependenciesRenderer, executionsDataset, executionsRenderer);

		// Prepare internal rendering state
		dependencySeries.clear();
		executionSeries.clear();
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (element instanceof Dependency) {
			Dependency dependency = (Dependency) element;
			return !dependency.isProjection() && !RenderingProperties.isHidden(dependency);
		}
		if (element instanceof Execution) {
			return !RenderingProperties.isHidden((Execution) element);
		}
		return true;
	}
	
	@Override
	public void configureLifelineSection(Lifeline lifeline, Section section) {
		PaintSupplier paint = RenderingProperties.getPaint(lifeline, null);
		if (paint != null) {
			section.setGridBandPaint(paint.getGridBandPaint());
			section.setGridBandAlternatePaint(paint.getGridBandAlternativePaint());
		} else {
			super.configureLifelineSection(lifeline, section);
		}
	}
	
	@Override
	public void add(ExecutionDataItem executionDataItem, XYIntervalSeriesCollection executionsDataset,
			ExecutionsRenderer executionsRenderer) {
		Execution execution = executionDataItem.getBackReference();
		PaintSupplier paint = RenderingProperties.getPaint(execution, DEFAULT_PAINT_EXECUTION);

		Integer series = executionSeries.get(paint);
		if (series == null) {
			series = executionSeries.size();
			executionSeries.put(paint, series);
			
			executionsDataset.addSeries(new XYIntervalSeries(series, false, true));
			executionsRenderer.setSeriesPaintSupplier(series, paint, false);
		}
		executionsDataset.getSeries(series).add(executionDataItem, false);
	}
	
	@Override
	public void add(DependencyDataItem dependencyDataItem, XYEdgeSeriesCollection dependenciesDataset,
			DependenciesRenderer dependenciesRenderer) {
		int series = getDependencySeries(dependencyDataItem.getBackReference(), dependenciesDataset,
				dependenciesRenderer);
		dependenciesDataset.getSeries(series).add(dependencyDataItem, false);
	}
	
	@Override
	public void add(DependencyAnnotation dependencyAnnotation, XYEdgeSeriesCollection dependenciesDataset,
			DependenciesRenderer dependenciesRenderer) {
		int series = getDependencySeries(dependencyAnnotation.getBackReference(), dependenciesDataset,
				dependenciesRenderer);
		configureDependencyAnnotation(dependencyAnnotation, dependenciesRenderer, series);
		dependenciesRenderer.addAnnotation(dependencyAnnotation);
	}

	private int getDependencySeries(Dependency dependency, XYEdgeSeriesCollection dependenciesDataset,
			DependenciesRenderer dependenciesRenderer) {
		PaintSupplier paint = RenderingProperties.getPaint(dependency, DEFAULT_PAINT_DEPENDENCY);
		Stroke stroke = RenderingProperties.getStroke(dependency, DEFAULT_STROKE_DEPENDENCY);
		Pair<PaintSupplier, Stroke> key = Pair.of(paint, stroke);

		Integer series = dependencySeries.get(key);
		if (series == null) {
			series = dependencySeries.size();
			dependencySeries.put(key, series);
			
			dependenciesDataset.addSeries(new XYEdgeSeries(dependencySeries.size()));
			dependenciesRenderer.setSeriesPaintSupplier(series, paint, false);
			dependenciesRenderer.setSeriesStroke(series, stroke, false);
		}
		return series;
	}
	
	@Override
	public void postRendering(XYEdgeSeriesCollection dependenciesDataset, DependenciesRenderer dependenciesRenderer,
			XYIntervalSeriesCollection executionsDataset, ExecutionsRenderer executionsRenderer) {
		super.postRendering(dependenciesDataset, dependenciesRenderer, executionsDataset, executionsRenderer);
		
		// Dispose internal rendering state
		dependencySeries.clear();
		executionSeries.clear();
	}
}
