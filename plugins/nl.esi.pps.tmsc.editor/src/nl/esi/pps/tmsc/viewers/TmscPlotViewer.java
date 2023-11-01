/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.viewers;

import static java.time.ZoneOffset.UTC;
import static java.time.format.DateTimeFormatter.ISO_DATE;
import static java.time.temporal.ChronoField.EPOCH_DAY;
import static org.eclipse.lsat.common.queries.QueryableIterable.from;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.lsat.common.queries.QueryableIterable;
import org.eclipse.lsat.common.util.IterableUtil;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.trace4cps.common.jfreechart.chart.axis.AxisUtils;
import org.eclipse.trace4cps.common.jfreechart.chart.axis.Section;
import org.eclipse.trace4cps.common.jfreechart.chart.axis.SectionAxis;
import org.eclipse.trace4cps.common.jfreechart.chart.geom.Arrow2D;
import org.eclipse.trace4cps.common.jfreechart.chart.geom.Triangle2D;
import org.eclipse.trace4cps.common.jfreechart.chart.plot.PlotUtils;
import org.eclipse.trace4cps.common.jfreechart.data.xy.XYEdgeSeriesCollection;
import org.eclipse.trace4cps.common.jfreechart.ui.gantt.XYGanttDataItem;
import org.eclipse.trace4cps.common.jfreechart.ui.gantt.XYGanttMeasureWithAnnotations;
import org.eclipse.trace4cps.common.jfreechart.ui.gantt.XYGanttMeasurement.Snap;
import org.eclipse.trace4cps.common.jfreechart.ui.viewers.ChartPanelSelectionHandler;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYAnnotation;
import org.jfree.chart.annotations.XYMeasurementAnnotation;
import org.jfree.chart.event.ChartChangeEventType;
import org.jfree.chart.event.PlotChangeEvent;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelClip;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.plot.SeriesRenderingOrder;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.XYMeasureWithAnnotations.MeasurementAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ui.RectangleAnchor;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.data.Range;
import org.jfree.data.RangeAlign;
import org.jfree.data.xy.XYIntervalSeriesCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nl.esi.pps.common.emf.synchronizedtiming.TimeSyncSupportProvider;
import nl.esi.pps.common.emf.synchronizedtiming.jfree.TimeSyncAxis;
import nl.esi.pps.common.emf.synchronizedtiming.jfree.TimeSyncJFreeSupport;
import nl.esi.pps.common.emf.synchronizedtiming.range.EpochNanoTimeRange;
import nl.esi.pps.common.emf.synchronizedtiming.range.RelativeNanoTimeRange;
import nl.esi.pps.common.emf.synchronizedtiming.range.TimeRange;
import nl.esi.pps.common.emf.ui.ContextAwareAdapterFactoryContentProvider;
import nl.esi.pps.common.emf.ui.jfree.XYPlotEValidatorAnnotations;
import nl.esi.pps.common.ide.ui.viewers.IStructuredGenericContentProvider;
import nl.esi.pps.common.jfreechart.chart.axis.NanoTimeAxis;
import nl.esi.pps.common.jfreechart.chart.axis.NanoTimeRange;
import nl.esi.pps.common.jfreechart.ui.viewers.LockableChartPanelStructuredViewer;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.EntryEvent;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.Interval;
import nl.esi.pps.tmsc.Lifeline;
import nl.esi.pps.tmsc.Measurement;
import nl.esi.pps.tmsc.presentation.TmscEditorPlugin;
import nl.esi.pps.tmsc.rendering.RenderingProperties;
import nl.esi.pps.tmsc.rendering.plot.DefaultRenderingStrategy;
import nl.esi.pps.tmsc.rendering.plot.IRenderingStrategy;
import nl.esi.pps.tmsc.viewers.plot.CreateMeasurementCommand;
import nl.esi.pps.tmsc.viewers.plot.DependenciesRenderer;
import nl.esi.pps.tmsc.viewers.plot.DependenciesVisibility;
import nl.esi.pps.tmsc.viewers.plot.DependencyDataItem;
import nl.esi.pps.tmsc.viewers.plot.DependencyIncomingAnnotation;
import nl.esi.pps.tmsc.viewers.plot.DependencyOutgoingAnnotation;
import nl.esi.pps.tmsc.viewers.plot.ExecutionDataItem;
import nl.esi.pps.tmsc.viewers.plot.ExecutionsRenderer;
import nl.esi.pps.tmsc.viewers.plot.ExecutionsVisibility;
import nl.esi.pps.tmsc.viewers.plot.IntervalAnnotation;
import nl.esi.pps.tmsc.viewers.plot.RenderingStrategyRegistryReader;
import nl.esi.pps.tmsc.viewers.plot.RenderingStrategyViewerFilter;

public class TmscPlotViewer extends LockableChartPanelStructuredViewer implements TimeSyncSupportProvider {
	private static final Logger LOGGER = LoggerFactory.getLogger(TmscPlotViewer.class);

	/** Set the maximum zoom level to 1 microsecond to prevent scroll bar issues */
	private static final int MAX_ZOOM_EPOCH_NANOS = 1_000;
	private static final int DEPENDENCIES_INDEX = 0;
	private static final int EXECUTIONS_INDEX = 1;

	private final ExecutionsRenderer executionsRenderer = new ExecutionsRenderer();
	private final DependenciesRenderer dependenciesRenderer = new DependenciesRenderer();
	private final RenderingStrategyViewerFilter renderingStrategyViewerFilter = new RenderingStrategyViewerFilter();
	
	private Map<Lifeline, Range> lifelineRanges = new HashMap<>();
	private String renderingStrategyID;
	private boolean isEpochTime;
	private ValueMarker traceStartMarker;
	private ValueMarker traceEndMarker;

	public TmscPlotViewer(Composite parent) {
		super(parent);
		setFilters(renderingStrategyViewerFilter);
	}
	
	@Override
	public ChartPanelSelectionHandler getChartPanelSelectionHandler() {
		return super.getChartPanelSelectionHandler();
	}

	@Override
	public ILabelProvider getLabelProvider() {
		return (ILabelProvider) super.getLabelProvider();
	}

	@Override
	public void setLabelProvider(IBaseLabelProvider labelProvider) {
		super.setLabelProvider(labelProvider);
		executionsRenderer.setLabelProvider((ILabelProvider) labelProvider, false);
		dependenciesRenderer.setLabelProvider((ILabelProvider) labelProvider, true);
	}

	@Override
	public void setContentProvider(IContentProvider contentProvider) {
		Assert.isTrue(contentProvider instanceof ContextAwareAdapterFactoryContentProvider,
				"Content provider should be of type: " + ContextAwareAdapterFactoryContentProvider.class);
		ContextAwareAdapterFactoryContentProvider<?> typedContentProvider = (ContextAwareAdapterFactoryContentProvider<?>) contentProvider;
		Assert.isTrue(Lifeline.class.isAssignableFrom(typedContentProvider.getContentType()),
				"Content type should be (sub)type of: " + Lifeline.class);
		super.setContentProvider(contentProvider);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public IStructuredGenericContentProvider<Lifeline> getContentProvider() {
		return (IStructuredGenericContentProvider<Lifeline>) super.getContentProvider();
	}
	
	public Lifeline[] getVisibleLifelines() {
		return getVisibleLifelines(getRawLifelines());
	}
	
	private Lifeline[] getRawLifelines() {
		Object input = getInput();
		IStructuredGenericContentProvider<Lifeline> contentProvider = getContentProvider();
		if (input == null || contentProvider == null) {
			return new Lifeline[0];
		}
		return contentProvider.getElements(input);
	}
	
	private Lifeline[] getVisibleLifelines(Lifeline[] rawLifelines) {
		if (rawLifelines == null || rawLifelines.length == 0) {
			return rawLifelines;
		}
		Lifeline[] lifelines = rawLifelines;
		if (hasFilters()) {
			lifelines = filter(from(rawLifelines)).toArray(Lifeline.class);
		}
		ViewerComparator viewerComparator = getComparator();
		if (viewerComparator != null) {
			viewerComparator.sort(this, lifelines);
		}
		return lifelines;
	}

	protected <T extends EObject> QueryableIterable<T> filter(Iterable<T> source) {
		QueryableIterable<T> result = from(source);
		if (hasFilters()) {
			final QueryableIterable<ViewerFilter> filters = from(getFilters());
			result = result.select(o -> filters.forAll(f -> f.select(TmscPlotViewer.this, o.eContainer(), o)));
		}
		return result;
	}
	
	public DependenciesVisibility getDependenciesVisibility() {
		return DependenciesVisibility.valueOf(dependenciesRenderer);
	}

	public void setDependenciesVisibility(DependenciesVisibility visibility, boolean notify) {
		visibility.apply(dependenciesRenderer, notify);
	}

	public ExecutionsVisibility getExecutionsVisibility() {
		return ExecutionsVisibility.valueOf(executionsRenderer);
	}

	public void setExecutionsVisibility(ExecutionsVisibility visibility, boolean notify) {
		visibility.apply(executionsRenderer, notify);
	}

	public String getRenderingStrategyID() {
		return renderingStrategyID != null ? renderingStrategyID : DefaultRenderingStrategy.ID;
	}

	public void setRenderingStrategyID(String renderingStrategyID, boolean notify) {
		boolean change = !Objects.equals(renderingStrategyID, getRenderingStrategyID());
		this.renderingStrategyID = renderingStrategyID;
		if (notify && change) {
			refresh();
		}
	}

	@Override
	protected void configureChartPanel() {
		super.configureChartPanel();

		// Measuring
		XYGanttMeasureWithAnnotations measureWithAnnotations = new XYGanttMeasureWithAnnotations(MeasurementAxis.DOMAIN) {
			private static final long serialVersionUID = 1L;

			protected XYAnnotation createMeasurementAnnotation(XYMeasurementAnnotation.Orientation orientation,
					String label, XYGanttDataItem<?> firstDataItem, Snap firstSnap, XYGanttDataItem<?> secondDataItem,
					Snap secondSnap) {
				Event from = firstSnap == Snap.START ? ((Execution) firstDataItem.getBackReference()).getEntry()
						: ((Execution) firstDataItem.getBackReference()).getExit();
				Event to = secondSnap == Snap.START ? ((Execution) secondDataItem.getBackReference()).getEntry()
						: ((Execution) secondDataItem.getBackReference()).getExit();
				if (from.getTimestamp() != null && to.getTimestamp() != null) {
					if (from.getTimestamp() > to.getTimestamp()) {
						// Swap events
						Event tmp = from;
						from = to;
						to = tmp;
					}
					EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(from);
					editingDomain.getCommandStack().execute(new CreateMeasurementCommand(from, to));
				}
				return null;
			}
		};
		measureWithAnnotations.addToChartPanel(getChartPanel());
		getChartPanelSelectionHandler().setZoomToSelectionMargin(0.05);

		XYPlot plot = new XYPlot();
		plot.setSeriesRenderingOrder(SeriesRenderingOrder.FORWARD);
		plot.setDomainPannable(true);
		plot.setRangePannable(true);

		// Domain axis, also see #getDomainAxis()
		NanoTimeAxis domainAxis = new NanoTimeAxis("Time");
		domainAxis.setStandardTickUnits(ETimestampTickUnit.createGMTTickUnits());
		domainAxis.setRangeMinimumSize(MAX_ZOOM_EPOCH_NANOS);
		domainAxis.setAutoRangeAlign(RangeAlign.LOWER);
		domainAxis.setAutoRangeIncludesZero(false);
		domainAxis.setAutoRange(true);
		domainAxis.setLowerMargin(0.01);
		domainAxis.setUpperMargin(0.01);
		plot.setDomainAxis(domainAxis);

		// Range axis
		SectionAxis rangeAxis = new SectionAxis("Components");
		rangeAxis.setRangeMinimumSize(1);
		plot.setRangeAxis(rangeAxis);

		// Dependencies
		XYEdgeSeriesCollection dependenciesDataset = new XYEdgeSeriesCollection();
		plot.setDataset(DEPENDENCIES_INDEX, dependenciesDataset);
		dependenciesRenderer.setDefaultItemLabelsVisible(false);
		dependenciesRenderer.setDefaultLegendShape(new Triangle2D.Double(-4.0, -4.0, -4.0, 4.0, 4.0, 0.0));
		dependenciesRenderer.setDefaultBeginShape(new Rectangle2D.Double(0, 0, 4, 4), false);
		dependenciesRenderer.setDefaultBeginShapeRotate(false, false);
		dependenciesRenderer.setDefaultEndShape(new Arrow2D.Double(0, 0, 8, 8), false);
		plot.setRenderer(DEPENDENCIES_INDEX, dependenciesRenderer);

		// Executions
		XYIntervalSeriesCollection executionsDataset = new XYIntervalSeriesCollection();
		plot.setDataset(EXECUTIONS_INDEX, executionsDataset);
		executionsRenderer.setDefaultItemLabelsVisible(true);
		plot.setRenderer(EXECUTIONS_INDEX, executionsRenderer);

		// Trace-window markers
		traceStartMarker = new ValueMarker(Double.NaN, Color.DARK_GRAY, plot.getDomainGridlineStroke());
		traceStartMarker.setLabel("Start of trace");
		traceStartMarker.setLabelAnchor(RectangleAnchor.TOP_RIGHT);
		traceStartMarker.setLabelTextAnchor(TextAnchor.TOP_LEFT);
		traceStartMarker.setLabelPaint(Color.DARK_GRAY);
		plot.addDomainMarker(traceStartMarker);

		traceEndMarker = new ValueMarker(Double.NaN, Color.DARK_GRAY, plot.getDomainGridlineStroke());
		traceEndMarker.setLabel("End of trace");
		traceEndMarker.setLabelAnchor(RectangleAnchor.TOP_LEFT);
		traceEndMarker.setLabelTextAnchor(TextAnchor.TOP_RIGHT);
		traceEndMarker.setLabelPaint(Color.DARK_GRAY);
		plot.addDomainMarker(traceEndMarker);

		JFreeChart chart = new JFreeChart(plot);
		ChartFactory.getChartTheme().apply(chart);
		getChartPanel().setChart(chart);
	}
	
	private NanoTimeAxis getDomainAxis() {
		return (NanoTimeAxis) getXYPlot().getDomainAxis();
	}

	@Override
	protected void inputChanged(Object input, Object oldInput) {
		if (Objects.equals(oldInput, input)) {
			// New input didn't change the scope, so skip refresh
			return;
		}
		// Order is important as we might be using a caching DebugContentProvider
		Object[] oldLifelines = getFilteredChildren(oldInput);
		Object[] lifelines = getFilteredChildren(input);
		if (Arrays.deepEquals(oldLifelines, lifelines)) {
			// New input didn't change the scope, so skip refresh
			return;
		}
		super.inputChanged(input, oldInput);

		// Events are turned off during refresh and a general event is fired
		// when enabling it again, but the ChartPanelCompositeHistory requires
		// a DATASET_UPDATED event to clear its history.
        PlotChangeEvent event = new PlotChangeEvent(getXYPlot());
        event.setType(ChartChangeEventType.DATASET_UPDATED);
		getXYPlot().notifyListeners(event);
	}

	@Override
	protected void refreshChart(Object element) {
		LOGGER.debug("refreshChart({}) -->", getLabelProvider().getText(element));
		final JFreeChart chart = getChart();
		final XYPlot plot = getXYPlot();

		// Reset the plot
		XYEdgeSeriesCollection dependenciesDataset = (XYEdgeSeriesCollection) plot.getDataset(DEPENDENCIES_INDEX);
		XYIntervalSeriesCollection executionsDataset = (XYIntervalSeriesCollection) plot.getDataset(EXECUTIONS_INDEX);

		dependenciesDataset.removeAllSeries();
		dependenciesRenderer.removeAnnotations();
		executionsDataset.removeAllSeries();
		executionsRenderer.removeAnnotations();
		plot.clearAnnotations();

		NanoTimeAxis domainAxis = getDomainAxis();
		domainAxis.setLabel("Time");
		domainAxis.initializeOffset(0, false);

		// Reset epoch and offset, as validation in next lines might skip rendering
		isEpochTime = false;
		traceStartMarker.setValue(Double.NaN);
		traceEndMarker.setValue(Double.NaN);

		Lifeline[] rawLifelines = getRawLifelines();

		SectionAxis rangeAxis = new SectionAxis();
		rangeAxis.setRangeMinimumSize(1);
		// If we are showing the same life-lines, we can show the same zoom/pan, i.e. range
		// So try to copy the range here, and if differences are found reset it to the auto-range,
		// see end of this method.
		rangeAxis.setRange(plot.getRangeAxis().getRange(), true, false);
		Map<Lifeline, Range> previousLifelineRanges = lifelineRanges;
		lifelineRanges = new HashMap<>(rawLifelines.length);
		plot.setRangeAxis(rangeAxis);
		
		Set<FullScopeTMSC> tmscs = from(rawLifelines).xcollectOne(Lifeline::getTmsc).asOrderedSet();
		if (rawLifelines.length == 0 || tmscs.isEmpty()) {
			// Nothing to render
			rangeAxis.setAutoRange(true, false);
			LOGGER.debug("refreshChart <-- (no data)");
			return;
		}

		Set<Boolean> isEpochTimes = from(tmscs).collectOne(FullScopeTMSC::isEpochTime).asSet();
		if (isEpochTimes.size() > 1) {
			rangeAxis.setAutoRange(true, false);
			TmscEditorPlugin.getPlugin().getLog()
					.log(new Status(IStatus.ERROR, TmscEditorPlugin.getPlugin().getSymbolicName(),
							"Failed to render TMSCs, cannot mix relative and epoch times."));
			LOGGER.debug("refreshChart <-- (error: different isEpochTime)");
			return;
		}
		
		Long startTime = IterableUtil.min(from(tmscs).xcollectOne(FullScopeTMSC::getStartTime), null);
		Long endTime = IterableUtil.max(from(tmscs).xcollectOne(FullScopeTMSC::getEndTime), null);
		if (startTime == null || endTime == null) {
			rangeAxis.setAutoRange(true, false);
			TmscEditorPlugin.getPlugin().getLog()
					.log(new Status(IStatus.ERROR, TmscEditorPlugin.getPlugin().getSymbolicName(),
							"Failed to render TMSC, start and end time should be set."));
			LOGGER.debug("refreshChart <-- (error: TMSC startTime={}, endTime={})", startTime,
					endTime);
			return;
		}
		
		/*
		 * The TMSC model uses 64-bits longs to store time-stamps. If epochTime is set
		 * to true in the TMSC, these times are relative to the epoch (i.e. Thu Jan 01
		 * 1970 00:00:00 UTC). A Java long can capture epoch nanoseconds until 2^63-1
		 * nanoseconds after the epoch, i.e. Fri Apr 11 2262 23:47:16 UTC. JFreeChart
		 * uses doubles an an double uses 52-bits only for its decimals. This means that
		 * after 2^52-1 = Sun Feb 22 1970 02:59:59 UTC (±53 days) it will start
		 * suffering from rounding errors. Due to this we will shift all time-stamps in
		 * the JFreeChart dataset to to their time-in-day, relative to the epoch. With
		 * this solution we know that we can show up to ±53 days of tracing without any
		 * rounding errors. We choose to shift to the start-time within it day, because
		 * that will not affect the visualization of time-stamps.
		 */
		isEpochTime = IterableUtil.first(isEpochTimes);
		domainAxis.initializeOffset(startTime, false);
		traceStartMarker.setValue(domainAxis.toAxisValue(startTime));
		traceEndMarker.setValue(domainAxis.toAxisValue(endTime));

		LOGGER.debug("refreshChart - Pre rendering");
		// Install the rendering strategy before filtering the life-lines as the
		// rendering strategy might is also a ViewerFilter
		IRenderingStrategy renderingStrategy = installRenderingStrategy(tmscs);
		renderingStrategy.preRendering(dependenciesDataset, dependenciesRenderer, executionsDataset,
				executionsRenderer);

		LOGGER.debug("refreshChart - Create executions");
		for (Lifeline lifeline : getVisibleLifelines(rawLifelines)) {
			List<Execution> lifeLineExecutions = filter(lifeline.getExecutions()).asList();
			// When all executions are filtered, the life-line shoudn't be rendered, but
			// executions are optional, so if they are not available, the life-line should
			// be rendered if it contains events
			boolean lifelineRendered = !lifeLineExecutions.isEmpty()
					|| (lifeline.getExecutions().isEmpty() && !lifeline.getEvents().isEmpty());
			if (lifelineRendered) {
				Section lifelineSection = rangeAxis.nextSection(getLabelProvider().getText(lifeline),
						getLifelineLength(lifeLineExecutions));
				lifelineRanges.put(lifeline, lifelineSection.getRange());
				renderingStrategy.configureLifelineSection(lifeline, lifelineSection);

				for (Execution execution : lifeLineExecutions) {
					Range executionRange = getExecutionRange(execution, lifelineSection.getRange());
					Double executionStart = getEventX(execution.getEntry());
					Double executionEnd = getEventX(execution.getExit());
					renderingStrategy.add(
							new ExecutionDataItem(executionRange, executionStart, executionEnd, execution),
							executionsDataset, executionsRenderer);
				}
			}
		}

		LOGGER.debug("refreshChart - Create dependencies");
		// Now add all dependencies, but omit the Executions as they are also dependencies
		QueryableIterable<Dependency> allDependencies = from(tmscs).collect(FullScopeTMSC::getDependencies);
		for (Dependency dependency : filter(allDependencies)) {
			Point2D sourceLocation = getEventLocation(dependency.getSource());
			Point2D targetLocation = getEventLocation(dependency.getTarget());
			if (sourceLocation != null && targetLocation != null) {
				renderingStrategy.add(new DependencyDataItem(sourceLocation, targetLocation, dependency),
						dependenciesDataset, dependenciesRenderer);
			} else if (sourceLocation != null) {
				DependencyOutgoingAnnotation annotation = new DependencyOutgoingAnnotation(sourceLocation, dependency);
				if (dependency.getTarget() != null) {
					annotation.setText(getLabelProvider().getText(dependency.getTarget().getLifeline()));
					annotation.setToolTipText(getLabelProvider().getText(dependency.getTarget()));
				}
				renderingStrategy.add(annotation, dependenciesDataset, dependenciesRenderer);
			} else if (targetLocation != null) {
				DependencyIncomingAnnotation annotation = new DependencyIncomingAnnotation(targetLocation, dependency);
				if (dependency.getSource() != null) {
					annotation.setText(getLabelProvider().getText(dependency.getSource().getLifeline()));
					annotation.setToolTipText(getLabelProvider().getText(dependency.getSource()));
				}
				renderingStrategy.add(annotation, dependenciesDataset, dependenciesRenderer);
			}
		}

		LOGGER.debug("refreshChart - Create measurements");
		for (Measurement measurement : filter(from(tmscs).collect(FullScopeTMSC::getMeasurements))) {
			IntervalAnnotation.add(TmscPlotViewer.this, measurement);
		}
		ISelection selection = getSelection();
		if (selection instanceof Iterable) {
			for (Interval interval : from((Iterable<?>) selection).objectsOfKind(Interval.class)) {
				// Ensure annotations for selection
				IntervalAnnotation.add(TmscPlotViewer.this, interval);
			}
		}

		LOGGER.debug("refreshChart - Post rendering");
		XYPlotEValidatorAnnotations.addAnnotations(plot, IMarker.SEVERITY_WARNING, IMarker.SEVERITY_ERROR);

		if (isEpochTime) {
			LocalDateTime startDate = LocalDateTime.ofEpochSecond(startTime / 1_000_000_000, 0, UTC);
			LocalDateTime endDate = LocalDateTime.ofEpochSecond(endTime / 1_000_000_000, 0, UTC);
			if (startDate.getLong(EPOCH_DAY) == endDate.getLong(EPOCH_DAY)) {
				domainAxis.setLabel(String.format("Time (%s, GMT)", ISO_DATE.format(startDate)));
			} else {
				domainAxis.setLabel(
						String.format("Time (%s - %s, GMT)", ISO_DATE.format(startDate), ISO_DATE.format(endDate)));
			}
		}

		ChartFactory.getChartTheme().apply(chart);
		// For this view we want to visualize the labels on the bottom of the bar to
		// avoid overlap with arrows as much as possible
		executionsRenderer.setDefaultPositiveItemLabelPosition(
				new ItemLabelPosition(ItemLabelAnchor.INSIDE6, TextAnchor.BOTTOM_CENTER, ItemLabelClip.FIT));
		executionsRenderer.setPositiveItemLabelPositionFallback(
				new ItemLabelPosition(ItemLabelAnchor.INSIDE7, TextAnchor.BOTTOM_LEFT, ItemLabelClip.CLIP));

		renderingStrategy.postRendering(dependenciesDataset, dependenciesRenderer, executionsDataset,
				executionsRenderer);

		// Performance improvements: for large datasets only show a portion
		int itemCount = PlotUtils.getItemCount(plot);
		if (itemCount > 50_000) {
			Range domainRange = plot.getDataRange(domainAxis);
			double lower = Math.max(traceStartMarker.getValue(), domainRange.getLowerBound());
			double upper = Math.min(traceEndMarker.getValue(), domainRange.getUpperBound());
			// Detected large amount of plot data, so limit time window (based on average) for performance
			domainAxis.setFixedAutoRange(traceStartMarker.getValue(), (50_000d / itemCount) * (upper - lower));
		} else {
			Range fixedAutoRange = new Range(traceStartMarker.getValue(), traceEndMarker.getValue());
			// Automatically zoom until end-of-trace + upper-margin (i.e. 1%)
			domainAxis.setFixedAutoRange(Range.expand(fixedAutoRange, 0, domainAxis.getUpperMargin()));
		}

		Range rangeRange = plot.getDataRange(rangeAxis);
		if (rangeRange != null && rangeRange.getLength() > 125) {
			rangeAxis.setAutoRangeAlign(RangeAlign.LOWER);
			rangeAxis.setFixedAutoRange(125);
		}
		// If we are not showing the same life-lines, we should reset the range axis zoom/pan
		if (!lifelineRanges.equals(previousLifelineRanges)) {
			rangeAxis.setAutoRange(true, false);
		}

		timeSyncSupport.resetMarginSync();
		AxisUtils.calculateAndApplyFixedDimension(rangeAxis, plot.getRangeAxisEdge());

		LOGGER.debug("refreshChart <--");
	}
	
	private IRenderingStrategy installRenderingStrategy(Iterable<FullScopeTMSC> tmscs) {
		if (renderingStrategyID == null) {
			// This indicates the first time this chart is rendered, so we can also initialize other settings here
			LinkedList<DependenciesVisibility> dependenciesVisibilities = from(tmscs)
					.xcollectOne(RenderingProperties::getRenderingDependencies)
					.xcollectOne(DependenciesVisibility::valueOf).asList();
			if (!dependenciesVisibilities.isEmpty()) {
				setDependenciesVisibility(dependenciesVisibilities.getFirst(), false);
			}
			LinkedList<ExecutionsVisibility> executionsVisibilities = from(tmscs)
					.xcollectOne(RenderingProperties::getRenderingExecutions)
					.xcollectOne(ExecutionsVisibility::valueOf).asList();
			if (!executionsVisibilities.isEmpty()) {
				setExecutionsVisibility(executionsVisibilities.getFirst(), false);
			}

			// Preferred rendering strategy can be set as property on TMSC
			renderingStrategyID = from(tmscs).xcollectOne(RenderingProperties::getRenderingStrategyID).first();
		}
		if (renderingStrategyID == null) {
			renderingStrategyID = DefaultRenderingStrategy.ID;
		}
		
		if (Objects.equals(renderingStrategyID, renderingStrategyViewerFilter.getRenderingStrategyID())) {
			// The rendering strategy hasn't changed, so reuse it
			return renderingStrategyViewerFilter.getRenderingStrategy();
		}

		final IConfigurationElement renderingStrategyConf = RenderingStrategyRegistryReader
				.getRenderingStrategyConfiguration(renderingStrategyID);

		IRenderingStrategy renderingStrategy = null;
		if (renderingStrategyConf != null) {
			renderingStrategy = RenderingStrategyRegistryReader.getIRenderingStrategy(renderingStrategyConf);
		} else {
			TmscEditorPlugin.getPlugin().getLog()
					.log(new Status(IStatus.ERROR, TmscEditorPlugin.getPlugin().getSymbolicName(),
							"Rendering strategy not found for ID: " + renderingStrategyID));
		}

		if (renderingStrategy == null) {
			// Could not create rendering strategy, fallback to default
			renderingStrategyID = DefaultRenderingStrategy.ID;
			renderingStrategy = new DefaultRenderingStrategy();
		}
		
		renderingStrategyViewerFilter.setRenderingStrategy(renderingStrategyID, renderingStrategy);
		return renderingStrategy;
	}

	public Point2D getEventLocation(Event event) {
		Double eventX = getEventX(event);
		Double eventY = getEventY(event);
		if (eventX == null || eventY == null) {
			return null;
		}
		return new Point2D.Double(eventX, eventY);
	}

	private Double getEventX(Event event) {
		if (event == null) {
			return null;
		}
		Long eventX = event.getTimestamp();
		if (eventX == null) {
			if (event instanceof EntryEvent) {
				eventX = event.getTmsc().getStartTime();
			} else if (event instanceof EntryEvent) {
				eventX = event.getTmsc().getEndTime();
			}
		}
		if (eventX == null) {
			return null;
		}
		return (double) getDomainAxis().toAxisValue(eventX);
	}

	private Double getEventY(Event event) {
		if (event == null) {
			return null;
		}
		Range eventYRange = lifelineRanges.get(event.getLifeline());
		if (eventYRange != null && event.getExecution() != null) {
			eventYRange = getExecutionRange(event.getExecution(), eventYRange);
		}
		return eventYRange == null ? null : eventYRange.getCentralValue();
	}

	/**
	 * The component range will be equal to the stack size of the component + 0.1
	 * for padding.
	 * 
	 * @see #getExecutionRange(Execution, Range)
	 */
	private double getLifelineLength(Iterable<Execution> componentExecutions) {
		QueryableIterable<Integer> callStackLevels = from(componentExecutions).xcollectOne(this::getCallStackLevel);
		int maxStackLevel = IterableUtil.max(callStackLevels, 0);
		// Add 1 to lift zero based stack level and 0.2 for resource padding
		return maxStackLevel + 1.2;
	}

	/**
	 * @see #getLifelineLength(Iterable)
	 */
	private Range getExecutionRange(Execution execution, Range componentRange) {
		Integer callStackLevel = getCallStackLevel(execution);
		if (callStackLevel == null) {
			// Execution is not visible
			return null;
		}
		// Add 0.1 for resource padding
		double executionLower = componentRange.getLowerBound() + callStackLevel + 0.1;
		return new Range(executionLower, executionLower + 1);
	}

	private Integer getCallStackLevel(Execution execution) {
		QueryableIterable<Execution> stackTrace = from(execution).climbTree(true, Execution::getParent);
		if (hasFilters()) {
			Object[] filteredStackTrace = filter(stackTrace.toArray());
			if (filteredStackTrace.length == 0 || filteredStackTrace[0] != execution) {
				// Execution is filtered out
				return null;
			}
			return filteredStackTrace.length - 1;
		} else {
			return stackTrace.size() - 1;
		}
	}

	/**********************************************
	 * Time synchronization
	 **********************************************/

	private TimeSyncJFreeSupport timeSyncSupport;

	@Override
	public TimeSyncJFreeSupport getTimeSyncSupport() {
		if (timeSyncSupport == null) {
			timeSyncSupport = new TimeSyncJFreeSupport(getChartPanelComposite(), TimeSyncAxis.DOMAIN,
					this::convertToJFreeRange, this::convertToTimeRange);
		}
		return timeSyncSupport;
	}

	private TimeRange convertToTimeRange(Range axisRange) {
		final NanoTimeRange range = getDomainAxis().getNanoTimeRange();
		return isEpochTime ? new EpochNanoTimeRange(range.getLowerBound(), range.getUpperBound())
				: new RelativeNanoTimeRange(range.getLowerBound(), range.getUpperBound());
	}

	private Range convertToJFreeRange(TimeRange timeRange) {
		return getDomainAxis().toAxisRange(timeRange.getFrom().longValue(), timeRange.getTo().longValue());
	}
}
