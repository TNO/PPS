/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.viewers.dataanalysis;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.trace4cps.common.jfreechart.ui.viewers.ChartPanelContentViewer;
import org.eclipse.xtext.xbase.lib.Pair;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.statistics.Statistics;

import nl.esi.pps.tmsc.provider.ext.ui.IDataAnalysisContentProvider;
import nl.esi.pps.tmsc.provider.ext.ui.IDataAnalysisInput;
import nl.esi.pps.tmsc.text.EDurationFormat;

abstract class TmscDataAnalysisViewer extends ChartPanelContentViewer {
	protected final TextTitle subTitle = new TextTitle("", NumberAxis.DEFAULT_AXIS_LABEL_FONT,
			TextTitle.DEFAULT_TEXT_PAINT, TextTitle.DEFAULT_POSITION, Title.DEFAULT_HORIZONTAL_ALIGNMENT,
			Title.DEFAULT_VERTICAL_ALIGNMENT, Title.DEFAULT_PADDING);

	private final DurationFilter durationFilter;
	private final String configuration;

	public TmscDataAnalysisViewer(Composite parent, DurationFilter durationFilter, String configuration) {
		super(parent);
		this.durationFilter = durationFilter;
		this.configuration = configuration;
		this.durationFilter.addPropertyChangeListener(e -> {
			if (DurationFilter.PROPERTY_FILTER.equals(e.getPropertyName()) || durationFilter.isFilter()) {
				refresh();
			}
		});
	}

	protected String getConfiguration() {
		return configuration;
	}

	@Override
	public void setLabelProvider(IBaseLabelProvider labelProvider) {
		if (labelProvider instanceof ILabelProvider) {
			super.setLabelProvider(labelProvider);
		} else {
			throw new IllegalArgumentException("Expected " + ILabelProvider.class);
		}
	}

	@Override
	public ILabelProvider getLabelProvider() {
		return (ILabelProvider) super.getLabelProvider();
	}

	@Override
	public void setContentProvider(IContentProvider contentProvider) {
		if (contentProvider instanceof IDataAnalysisContentProvider) {
			super.setContentProvider(contentProvider);
		} else {
			throw new IllegalArgumentException("Expected " + IDataAnalysisContentProvider.class);
		}
	}

	@Override
	public IDataAnalysisContentProvider getContentProvider() {
		return (IDataAnalysisContentProvider) super.getContentProvider();
	}
	
	@Override
	protected void configureChartPanel() {
		super.configureChartPanel();

		final XYPlot xyPlot = new XYPlot();
		xyPlot.setDomainPannable(true);
		xyPlot.setRangePannable(true);

		XYBarRenderer renderer = new XYBarRenderer();
		xyPlot.setRenderer(renderer);

		NumberAxis domainAxis = new NumberAxis();
		domainAxis.setAutoRangeIncludesZero(false);
		domainAxis.setLowerMargin(0);
		domainAxis.setUpperMargin(0.02);
		xyPlot.setDomainAxis(domainAxis);

		NumberAxis rangeAxis = new NumberAxis();
		rangeAxis.setLowerMargin(0);
		rangeAxis.setUpperMargin(0.02);
		xyPlot.setRangeAxis(rangeAxis);

		JFreeChart chart = new JFreeChart("", null, xyPlot, false);
		chart.addSubtitle(subTitle);
		ChartFactory.getChartTheme().apply(chart);
		getChartPanel().setChart(chart);
	}

	@Override
	protected void inputChanged(Object input, Object oldInput) {
		super.inputChanged(input, oldInput);
		getChartPanelComposite().getChartPanel().restoreAutoBounds();
	}

	protected List<Pair<?, Long>> getSiblingsWithDuration(IDataAnalysisInput input) {
		if (input == null) {
			return Collections.emptyList();
		}
		LinkedList<Pair<?, Long>> siblingsWithDuration = new LinkedList<Pair<?, Long>>();
		Iterable<?> siblings = input.getSiblings(configuration);
		if (siblings != null) {
			for (Object sibling: siblings) {
				Long duration = input.getDuration(sibling, configuration);
				if (duration != null) {
					siblingsWithDuration.add(Pair.of(sibling, duration));
				}
			}
		}
		if (!siblingsWithDuration.isEmpty()) {
			durationFilter.filter(siblingsWithDuration);
		}
		return siblingsWithDuration;
	}

	protected String calculateStatistics(Number[] values) {
		String filter = durationFilter.getDescription();
		if (values.length == 0) {
			return filter;
		}
		double mean = Statistics.calculateMean(values);
		double std = Statistics.getStdDev(values);
		double min = Arrays.stream(values).mapToDouble(Number::doubleValue).min().getAsDouble();
		double max = Arrays.stream(values).mapToDouble(Number::doubleValue).max().getAsDouble();
		String statistics = String.format("Mean: %s, Std. dev.: %s, Min.: %s, Max.: %s",
				EDurationFormat.eINSTANCE.format(mean), EDurationFormat.eINSTANCE.format(std),
				EDurationFormat.eINSTANCE.format(min), EDurationFormat.eINSTANCE.format(max));
		return filter.isEmpty() ? statistics : filter + ", " + statistics;
	}
}
