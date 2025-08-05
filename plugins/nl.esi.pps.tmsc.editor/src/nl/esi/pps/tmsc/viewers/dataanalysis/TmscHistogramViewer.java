/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
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
import java.util.ArrayList;
import java.util.List;

import org.eclipse.lsat.common.util.CollectionUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.trace4cps.common.jfreechart.ui.viewers.ChartPanelSelectionHandler.SelectionType;
import org.eclipse.xtext.xbase.lib.Pair;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYStepRenderer;
import org.jfree.chart.ui.RectangleAnchor;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYIntervalSeriesCollection;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import nl.esi.pps.common.jfreechart.rendering.RenderingPaint;
import nl.esi.pps.common.jfreechart.rendering.RenderingStroke;
import nl.esi.pps.tmsc.provider.ext.ui.IDataAnalysisInput;
import nl.esi.pps.tmsc.text.EDurationFormat;

public class TmscHistogramViewer extends TmscDataAnalysisViewer {
	private int nrOfBins = 20;
	private ValueMarker durationMarker = new ValueMarker(Double.NaN, RenderingPaint.GOLD.getPaint(),
			RenderingStroke.SOLID.getStroke());
	private IntervalMarker budgetMarker = new IntervalMarker(Double.NaN, Double.MAX_VALUE,
			RenderingPaint.ORANGE.getPaint());

	public TmscHistogramViewer(Composite parent, DurationFilter durationFilter, String configuration) {
		super(parent, durationFilter, configuration);
	}

	@Override
	protected ChartPanelControlTuple createControl(Composite parent, int style, SelectionType dontCare) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		
		Group grpNrOfBins = new Group(composite, SWT.NONE);
		grpNrOfBins.setLayout(new GridLayout(2, false));
		grpNrOfBins.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, true, 1, 1));
		grpNrOfBins.setText("Nr. of bins:");
		
		Scale scale = new Scale(grpNrOfBins, SWT.VERTICAL);
		scale.setMinimum(3);
		scale.setMaximum(99);
		scale.setSelection(scale.getMaximum() - nrOfBins);
		scale.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, true, 1, 1));
		Label nrOfBinsLabel = new Label(grpNrOfBins, SWT.NONE);
		nrOfBinsLabel.setAlignment(SWT.RIGHT);
		nrOfBinsLabel.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		nrOfBinsLabel.setText(String.valueOf(nrOfBins));
		
		scale.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				nrOfBins = scale.getMaximum() - scale.getSelection() + scale.getMinimum();
				nrOfBinsLabel.setText(String.valueOf(nrOfBins));
				refresh();
			}
		});
		
		// We added an additional composite, so wrap the tuple with this.
		ChartPanelControlTuple controlTuple = super.createControl(composite, style, SelectionType.None).wrapControl(composite);
		controlTuple.getChartPanelComposite().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		return controlTuple;
	}
	
	@Override
	protected void configureChartPanel() {
		super.configureChartPanel();
		final XYPlot xyPlot = getXYPlot();

		xyPlot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
		xyPlot.getRangeAxis().setLabel("Frequency");
		
		NumberAxis cdfAxis = new NumberAxis("CDF [%]");
		cdfAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		xyPlot.setRangeAxis(1, cdfAxis, false);
		xyPlot.mapDatasetToRangeAxis(1, 1);
		XYStepRenderer cdfRenderer = new XYStepRenderer();
		xyPlot.setRenderer(1, cdfRenderer);

		NumberAxis domainAxis = (NumberAxis) xyPlot.getDomainAxis();
		domainAxis.setLabel("Duration");
		domainAxis.setNumberFormatOverride(EDurationFormat.eINSTANCE);
		domainAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		
		xyPlot.getRenderer().setDefaultToolTipGenerator((d, s, i) -> String.format("%d times within %s - %s",
						((IntervalXYDataset) d).getEndY(s, i),
						EDurationFormat.eINSTANCE.format(((IntervalXYDataset) d).getStartX(s, i)),
						EDurationFormat.eINSTANCE.format(((IntervalXYDataset) d).getEndX(s, i))));
		
		durationMarker.setLabelAnchor(RectangleAnchor.TOP_LEFT);
		durationMarker.setLabelTextAnchor(TextAnchor.TOP_RIGHT);
		durationMarker.setLabelPaint(Color.DARK_GRAY);
		xyPlot.addDomainMarker(durationMarker);

		budgetMarker.setLabelAnchor(RectangleAnchor.TOP_LEFT);
		budgetMarker.setLabelTextAnchor(TextAnchor.TOP_LEFT);
		budgetMarker.setLabelPaint(Color.BLACK);
		budgetMarker.setAlpha(0.2f);
		xyPlot.addDomainMarker(budgetMarker);
	}

	@Override
	protected void refreshChart() {
		final JFreeChart chart = getChart();
		final XYPlot xyPlot = chart.getXYPlot();
		final ArrayList<Number> yValues = new ArrayList<>(1000); 

		durationMarker.setValue(Double.NaN);
		durationMarker.setLabel(null);
		budgetMarker.setStartValue(Double.NaN);
		budgetMarker.setLabel(null);

		IDataAnalysisInput input = getContentProvider().getDataAnalysisInput(getInput());
		List<Pair<?,Long>> siblings = getSiblingsWithDuration(input);
		if (siblings.isEmpty()) {
			chart.setTitle("Data analysis is not available for current selection.");
		} else {
			Iterable<Long> siblingsDuration = from(siblings).collectOne(Pair::getValue);
			CollectionUtil.addAll(yValues, siblingsDuration);

			Long inputDuration = input.getDuration(input.getInput(), getConfiguration());
			if (inputDuration != null) {
				durationMarker.setValue(inputDuration);
				durationMarker.setLabel(EDurationFormat.eINSTANCE.format(inputDuration));
			}
			
			Long inputBudget = input.getBudget(getConfiguration());
			if (inputBudget != null) {
				budgetMarker.setStartValue(inputBudget);
				budgetMarker.setLabel(EDurationFormat.eINSTANCE.format(inputBudget));
			}

			chart.setTitle(input.getTitle(getConfiguration()));
		}

		subTitle.setText(calculateStatistics(yValues.toArray(new Number[yValues.size()])));

		if (yValues.isEmpty()) {
			xyPlot.setDataset(new XYIntervalSeriesCollection());
			xyPlot.setDataset(1, new XYSeriesCollection());
		} else {
			double[] yValuesSorted = yValues.stream().mapToDouble(Number::doubleValue).sorted().toArray();
			HistogramDataset dataset = new HistogramDataset();
			dataset.setType(HistogramType.FREQUENCY);
			dataset.addSeries("Duration", yValuesSorted, nrOfBins);
			xyPlot.setDataset(dataset);
			xyPlot.setDataset(1, new XYSeriesCollection(createCDFSeries(yValuesSorted)));
		}

		ChartFactory.getChartTheme().apply(chart);
	}
	
	private XYSeries createCDFSeries(double[] sortedValues) {
		final XYSeries series = new XYSeries("Cumulative Distribution Function (CDF)");
		for (int i = 0; i < sortedValues.length; i++) {
			if (i == sortedValues.length - 1 || sortedValues[i] != sortedValues[i + 1]) {
				series.add(sortedValues[i], i * 100d / sortedValues.length);
			}
		}
		return series;
	}
}
