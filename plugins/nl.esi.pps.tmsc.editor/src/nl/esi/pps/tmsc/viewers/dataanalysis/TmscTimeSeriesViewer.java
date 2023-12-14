/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.viewers.dataanalysis;

import static org.eclipse.lsat.common.queries.QueryableIterable.from;

import java.awt.Color;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.trace4cps.common.jfreechart.chart.plot.IntervalRangeValueCrosshair;
import org.eclipse.trace4cps.common.jfreechart.data.xy.XYDataItemResolver;
import org.eclipse.trace4cps.common.jfreechart.ui.data.XYBackreferenceDataItem;
import org.eclipse.trace4cps.common.jfreechart.ui.viewers.BackReferenceLabelGenerator;
import org.eclipse.xtext.xbase.lib.Pair;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.SeriesRenderingOrder;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import nl.esi.pps.common.jfreechart.rendering.RenderingPaint;
import nl.esi.pps.tmsc.provider.ext.ui.IDataAnalysisInput;
import nl.esi.pps.tmsc.text.EDurationFormat;

public class TmscTimeSeriesViewer extends TmscDataAnalysisViewer {
	public TmscTimeSeriesViewer(Composite parent, DurationFilter durationFilter, String configuration) {
		super(parent, durationFilter, configuration);
		setPreserveSelection(true);
	}

	@Override
	protected void configureChartPanel() {
		super.configureChartPanel();
		final XYPlot xyPlot = getXYPlot();
		xyPlot.setSeriesRenderingOrder(SeriesRenderingOrder.FORWARD);

		IntervalRangeValueCrosshair.connectTo(getChartPanel(),
				v -> String.format(" %s ", EDurationFormat.eINSTANCE.format(v)));

		BackReferenceLabelGenerator labelGenerator = new BackReferenceLabelGenerator(
				o -> getLabelProvider().getText(o));

		NumberAxis rangeAxis = (NumberAxis) xyPlot.getRangeAxis();
		rangeAxis.setLabel("Duration");
		rangeAxis.setNumberFormatOverride(EDurationFormat.eINSTANCE);
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

		xyPlot.getDomainAxis().setStandardTickUnits(NumberAxis.createIntegerTickUnits());

		XYBarRenderer renderer = (XYBarRenderer) xyPlot.getRenderer();
		renderer.setDefaultToolTipGenerator(labelGenerator);

		// Add a legend, but don't show it by default
		JFreeChart chart = getChart();
        LegendTitle legend = new LegendTitle(xyPlot);
        legend.setMargin(new RectangleInsets(1.0, 1.0, 1.0, 1.0));
        legend.setBackgroundPaint(Color.WHITE);
        legend.setPosition(RectangleEdge.BOTTOM);
        legend.setVisible(false);
        chart.addSubtitle(legend);
        legend.addChangeListener(chart);

		ChartFactory.getChartTheme().apply(chart);
	}

	@Override
	protected void inputChanged(Object input, Object oldInput) {
		super.inputChanged(input, oldInput);
		IDataAnalysisInput dataAnalysisInput = getContentProvider().getDataAnalysisInput(input);
		setSelection(dataAnalysisInput == null ? StructuredSelection.EMPTY : new StructuredSelection(dataAnalysisInput.getInput()));
	}

	@Override
	protected void refreshChart() {
		final JFreeChart chart = getChart();
		XYSeriesCollection xyCollection;

		final XYBarRenderer renderer = (XYBarRenderer) getXYPlot().getRenderer();
		renderer.clearSeriesPaints(false);
		renderer.clearSeriesOutlinePaints(false);

		IDataAnalysisInput input = getContentProvider().getDataAnalysisInput(getInput());
		if (input == null) {
			chart.setTitle("Data analysis is not available for current selection.");
			xyCollection = new XYSeriesCollection();
		} else {
			chart.setTitle(input.getTitle(getConfiguration()));
			if (input.isCategorized(getConfiguration())) {
				xyCollection = refreshCategoryChart(input, renderer);
			} else {
				xyCollection = refreshBudgetChart(input, renderer);
			}
		}
		chart.getXYPlot().setDataset(xyCollection);

		// Hide empty series in legend
		for (int series = 0; series < xyCollection.getSeriesCount(); series++) {
			if (xyCollection.getItemCount(series) == 0) {
				renderer.setSeriesVisibleInLegend(series, false, false);
			}
		}

		Number[] yValues = from(XYDataItemResolver.DEFAULT.resolveAllDataItems(xyCollection))
				.objectsOfKind(XYDataItem.class).collectOne(XYDataItem::getY).toArray(Number.class);
		subTitle.setText(calculateStatistics(yValues));
	}

	protected XYSeriesCollection refreshBudgetChart(IDataAnalysisInput input, XYBarRenderer renderer) {
		renderer.setAutoPopulateSeriesPaint(false);
		renderer.setAutoPopulateSeriesOutlinePaint(false);
		renderer.setSeriesPaint(0, RenderingPaint.BLUE.getPaint());
		renderer.setSeriesOutlinePaint(0, RenderingPaint.BLUE.getOutlinePaint());
		renderer.setSeriesPaint(1, RenderingPaint.RED.getPaint());
		renderer.setSeriesOutlinePaint(1, RenderingPaint.RED.getOutlinePaint());

		final XYSeries series0_Duration = new XYSeries("Normal");
		final XYSeries series1_ExceedsBudget = new XYSeries("Exceeds budget");

		List<Pair<?, Long>> siblings = getSiblingsWithDuration(input);
		Long budget = input.getBudget(getConfiguration());
		Integer index = 1;
		for (Pair<?, Long> sibling : siblings) {
			XYDataItem dataItem;
			if (sibling.getKey() instanceof EObject) {
				dataItem = new XYBackreferenceDataItem<>(index++, sibling.getValue(), sibling.getKey());
			} else {
				dataItem = new XYDataItem(index++, sibling.getValue());
			}
			if (budget != null && sibling.getValue() > budget) {
				series1_ExceedsBudget.add(dataItem, false);
			} else {
				series0_Duration.add(dataItem, false);
			}
		}

		XYSeriesCollection xyCollection = new XYSeriesCollection();
		xyCollection.addSeries(series0_Duration);
		xyCollection.addSeries(series1_ExceedsBudget);
		return xyCollection;
	}

	protected XYSeriesCollection refreshCategoryChart(IDataAnalysisInput input, XYBarRenderer renderer) {
		renderer.setAutoPopulateSeriesPaint(true);
		renderer.setAutoPopulateSeriesOutlinePaint(true);
		ChartFactory.getChartTheme().apply(getChart());
		
		Map<String, XYSeries> series = new LinkedHashMap<>();
		List<Pair<?, Long>> siblings = getSiblingsWithDuration(input);
		Integer index = 1;
		for (Pair<?, Long> sibling : siblings) {
			XYDataItem dataItem;
			if (sibling.getKey() instanceof EObject) {
				dataItem = new XYBackreferenceDataItem<>(index++, sibling.getValue(), sibling.getKey());
			} else {
				dataItem = new XYDataItem(index++, sibling.getValue());
			}
			XYSeries categorySeries = series.computeIfAbsent(
					input.getCategory(sibling.getKey(), getConfiguration()), XYSeries::new);
			categorySeries.add(dataItem, false);
		}

		XYSeriesCollection xyCollection = new XYSeriesCollection();
		series.values().forEach(xyCollection::addSeries);
		return xyCollection;
	}
}
