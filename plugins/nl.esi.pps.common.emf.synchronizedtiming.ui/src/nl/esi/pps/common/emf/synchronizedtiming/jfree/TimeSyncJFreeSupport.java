/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.emf.synchronizedtiming.jfree;

import static nl.esi.pps.common.emf.synchronizedtiming.TimeSyncDebug.DEBUG;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.swt.graphics.Point;
import org.eclipse.trace4cps.common.jfreechart.ui.viewers.ChartPanelContentViewer;
import org.eclipse.trace4cps.common.jfreechart.ui.widgets.ChartPanelComposite;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisSpace;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.event.AxisChangeEvent;
import org.jfree.chart.event.PlotChangeEvent;
import org.jfree.chart.event.PlotChangeListener;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.CombinedRangeXYPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.Range;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nl.esi.pps.common.emf.synchronizedtiming.TimeSyncSupport;
import nl.esi.pps.common.emf.synchronizedtiming.range.TimeRange;

public class TimeSyncJFreeSupport extends TimeSyncSupport implements PlotChangeListener {
	@SuppressWarnings("null")
	private static final Logger LOGGER = LoggerFactory.getLogger(TimeSyncSupport.class);
	private static final BufferedImage DUMMY_IMAGE = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);

	private final ChartPanelComposite chartPanelComposite;
	private final TimeSyncAxis axisDimension;
	private final TimeRangeToJFreeRangeConverter timeRangeConverter;
	private final JFreeRangeToTimeRangeConverter jfreeRangeConverter;

	/** Whether to live send changes of the time range of the axis for synchronization. */
	protected boolean liveSend = true;

	public TimeSyncJFreeSupport(ChartPanelComposite chartPanelComposite, TimeSyncAxis axisDimension,
			JFreeRangeToTimeRangeConverter jfreeRangeConverter) {
		this(chartPanelComposite, axisDimension, TimeRangeToJFreeRangeConverter.DEFAULT, jfreeRangeConverter);
	}

	public TimeSyncJFreeSupport(ChartPanelComposite chartPanelComposite, TimeSyncAxis axisDimension,
			TimeRangeToJFreeRangeConverter timeRangeConverter, JFreeRangeToTimeRangeConverter jfreeRangeConverter) {
		super(chartPanelComposite);

		this.chartPanelComposite = chartPanelComposite;
		this.axisDimension = axisDimension;
		this.timeRangeConverter = timeRangeConverter;
		this.jfreeRangeConverter = jfreeRangeConverter;

		this.chartPanelComposite.addDisposeListener(e -> dispose());
		this.chartPanelComposite.getChartPanel().addPropertyChangeListener(ChartPanel.PROPERTY_CHART, e -> {
			if (e.getOldValue() instanceof Plot) {
				((Plot) e.getOldValue()).removeChangeListener(this);
			}
			if (e.getNewValue() instanceof Plot) {
				((Plot) e.getNewValue()).addChangeListener(this);
			}
		});
		final XYPlot plot = getXYPlot();
		if (plot != null) {
			plot.addChangeListener(this);
		}
	}

	protected final ChartPanelComposite getChartPanelComposite() {
		return chartPanelComposite;
	}

	protected @Nullable XYPlot getXYPlot() {
		final Plot result = chartPanelComposite.getPlot();
		return result instanceof XYPlot ? (XYPlot) result : null;
	}

	protected TimeSyncAxis getAxisDimension() {
		return axisDimension;
	}

	protected @Nullable ValueAxis getTimeSyncAxisFromPlotComposite() {
		final XYPlot plot = getXYPlot();
		if (plot == null) {
			return null;
		}
		if (axisDimension == TimeSyncAxis.DOMAIN) {
			if (plot.getDomainAxisCount() > 1) {
				throw new IllegalStateException(
						"Found multiple domain axes, for plot: " + plot + ", control=" + getControl());
			}
			return plot.getDomainAxis();

		} else {
			if (plot.getRangeAxisCount() > 1) {
				throw new IllegalStateException(
						"Found multiple range axes, for plot: " + plot + ", control=" + getControl());
			}
			return plot.getRangeAxis();
		}
	}

	@Override
	@SuppressWarnings("null")
	public @Nullable TimeRange getTimeRange() {
		final ValueAxis axis = getTimeSyncAxisFromPlotComposite();
		return (axis == null) ? null : jfreeRangeConverter.convert(axis.getRange());
	}

	@Override
	protected void setTimeRange(TimeRange range) {
		final ValueAxis axis = getTimeSyncAxisFromPlotComposite();
		if (axis == null) {
			LOGGER.debug("No axis on which to set time range; control=" + getControl());
			return;
		}
		Range jfreeRange = timeRangeConverter.convert(range);
		if (jfreeRange == null) {
			LOGGER.warn("Time range not converted to JFree time range. Skipped setting range on axis: " + range
					+ "; control=" + getControl());
			return;
		}
		axis.setRange(jfreeRange);
	}

	@Override
	public @Nullable Point getViewLocation() {
		return chartPanelComposite.toDisplay(0, 0);
	}

	@Override
	public @Nullable Integer getViewMarginWidth() {
		ChartPanel chartPanel = chartPanelComposite.getChartPanel();
		if (chartPanel == null) {
			return null;
		}
		Rectangle2D area = chartPanel.getScreenDataArea();
		int width = (int)Math.round(area.getX());
		return width;
	}

	@Override
	public void setMarginWidth(int width) {
		XYPlot plot = getXYPlot();
		if (plot == null) {
			return;
		}

		// Get current margin.
		Integer curWidth = getViewMarginWidth();
		if (curWidth == null) {
			LOGGER.warn("Set margin width skipped. Could not determine the current margin width, for plot: " + plot
					+ ", control=" + getControl());
			return;
		}

		// Get current axis dimension.
		ChartPanel chartPanel = chartPanelComposite.getChartPanel();
		if (chartPanel == null) {
			LOGGER.warn("Set margin width skipped. No chart panel for plot composite: " + chartPanelComposite);
			return;
		}
		Rectangle2D plotArea = chartPanel.getChartRenderingInfo().getPlotInfo().getPlotArea();
		if (plotArea == null) {
			// Occurs frequently, for instance for editors with tabs with viewers where the tab/viewer has not yet been
			// shown yet.
			if (DEBUG) {
				LOGGER.debug("Set margin width skipped. No plot area, for plot composite: " + chartPanelComposite);
			}
			return;
		}

		setMarginWidthInternal(width, plot, curWidth, plotArea);
	}

	protected void setMarginWidthInternal(int width, XYPlot plot, Integer curWidth, Rectangle2D plotArea) {
		// Get left axis.
		ValueAxis axis = getLeftAxis();
		if (axis == null) {
			LOGGER.warn(
					"Set margin width skipped. No left axis found, for plot: " + plot + ", control=" + getControl());
			return;
		}

		RectangleEdge edge = (plot.getDomainAxis() == axis) ? plot.getDomainAxisEdge() : plot.getRangeAxisEdge();
		Assert.isNotNull(edge);

		setMarginWidthOnAxis(width, plot, curWidth, plotArea, axis, edge);
	}

	protected void setMarginWidthOnAxis(int width, XYPlot plot, Integer curWidth, Rectangle2D plotArea, ValueAxis axis,
			RectangleEdge edge) {
		Graphics2D g = DUMMY_IMAGE.createGraphics();
		AxisSpace space = axis.reserveSpace(g, plot, plotArea, edge, null);
		g.dispose();
		double curDimension = space.getLeft();

		// Skip if no current dimension. Typically viewers of tabs of editors that have not yet been initialized or
		// shown have no data, and as such the dimension is zero.
		if (curDimension <= 0.0) {
			LOGGER.warn("Set margin width skipped. No current margin dimensions, plot=" + plot + ", axis=" + axis
					+ ", control=" + getControl());
			return;
		}

		// Get new fixed dimension, compensating for the difference between margin width and axis dimension.
		int widthIncrease = width - curWidth;
		double newDimension = curDimension + widthIncrease;
		if (widthIncrease == 0) {
			return;
		}

		// Debug output.
		if (DEBUG) {
			LOGGER.debug("setMarginWidth: chartPanelComposite=" + chartPanelComposite + ", plot=" + plot + ", width=" + width
					+ ", curWidth=" + curWidth + ", widthIncrease=" + widthIncrease + ", curDimension=" + curDimension
					+ ", newDimension=" + newDimension);
		}

		// Set new fixed dimension. Inform plot of the change to fire an axis changed event.
		axis.setFixedDimension(newDimension);
		plot.axisChanged(new AxisChangeEvent(axis));
	}

	protected @Nullable ValueAxis getLeftAxis() {
        Optional<ValueAxis> axis =
                streamXYPlots(getXYPlot()).map(this::getLeftAxis).filter(Objects::nonNull).findFirst();
        return axis.isPresent() ? axis.get() : null;
	}

	protected @Nullable ValueAxis getLeftAxis(XYPlot xyPlot) {
		for (int i = 0; i < xyPlot.getRangeAxisCount(); i++) {
			if (xyPlot.getRangeAxisEdge(i) == RectangleEdge.LEFT) {
				return xyPlot.getRangeAxis(i);
			}
		}
		for (int i = 0; i < xyPlot.getDomainAxisCount(); i++) {
			if (xyPlot.getDomainAxisEdge(i) == RectangleEdge.LEFT) {
				return xyPlot.getDomainAxis(i);
			}
		}
		return null;
	}

	public void setLiveSend(boolean liveSend) {
		this.liveSend = liveSend;
	}

	@Override
	public void plotChanged(@Nullable PlotChangeEvent event) {
		if (DEBUG) {
			LOGGER.debug("plotChanged: event=" + event);
		}
		final XYPlot xyPlot = getXYPlot();
		if (event == null || xyPlot == null || event.getPlot() != xyPlot || isInTimeSync()) {
			return;
		}
		// Do not send time sync events for empty plots
		boolean skipLiveSend = xyPlot.getDataRange(getTimeSyncAxisFromPlotComposite()) == null;
		if (liveSend && !skipLiveSend) {
			sendTimeRangeChangedEvent(false);
		}
	}

	/**
	 * Set a minimum right margin, to ensure that the plot is fixed to the right side scroll bar. This improves right
	 * margin synchronization with Trace Compass views, in case they are also adjusted for having a scroll bar.
	 */
	public void setMinimumRightMargin() {
		XYPlot plot = getXYPlot();
		if (plot == null) {
			return;
		}

		// Remove right side chart padding.
		JFreeChart chart = chartPanelComposite.getChart();
		if (chart != null) {
			RectangleInsets chartPadding = chart.getPadding();
			if (chartPadding.getRight() != 0.0) {
				chart.setPadding(
					new RectangleInsets(chartPadding.getTop(), chartPadding.getLeft(), chartPadding.getBottom(), 0));
			}
		}

		streamXYPlots(plot).forEach(this::setMinimumRightMargin);
	}

	protected void setMinimumRightMargin(XYPlot plot) {
		// Remove right side plot insets.
		RectangleInsets plotInsets = plot.getInsets();
		if (plotInsets.getRight() != 0.0) {
			plot.setInsets(new RectangleInsets(plotInsets.getTop(), plotInsets.getLeft(), plotInsets.getBottom(), 0));
		}


		// Reduce right side axis offset. Keep a pixel to still show the border around the plot area.
		RectangleInsets plotAxisOffset = plot.getAxisOffset();
		if (plotAxisOffset.getRight() != 0.0) {
			plot.setAxisOffset(
				new RectangleInsets(plotAxisOffset.getTop(), plotAxisOffset.getLeft(), plotAxisOffset.getBottom(), 1));
		}
	}

	/**
	 * Zoom out fully. This is needed to ensure the entire time range becomes known by the scrollbar handler, such
	 * that it can properly update the scrollbars upon receiving a time sync request. See
	 * {@link org.eclipse.trace4cps.common.jfreechart.ui.internal.ChartPanelScrollbarHandler}.
	 */
	public void resetZoom() {
		ChartPanel chartPanel = chartPanelComposite.getChartPanel();
		if (chartPanel != null) {
			chartPanel.restoreAutoBounds();
		}
	}

	/**
	 * Resets the fixed axis dimension resulting from margin width synchronization. Since there is no way to know what
	 * caused the fixed axis dimension, it is reset even in case it did not result from margin width synchronization.
	 *
	 * <p>If invoked from {@link ChartPanelContentViewer#refreshChart}, and the axes are replaced in that method, invoke
	 * this method before replacing the axis.</p>
	 */
	public void resetAxisFixedDimension() {
		ValueAxis leftAxis = getLeftAxis();
		if (leftAxis != null && leftAxis.getFixedDimension() > 0.0) {
			leftAxis.setFixedDimension(0.0);
		}
	}

	/**
	 * Resets the effects of time range synchronization, and prepare for future synchronizations.
	 *
	 * @see #resetZoom
	 */
	public void resetTimeSync() {
		resetZoom();
	}

	/**
	 * Resets the effects of margin width synchronization, and prepare for future synchronizations.
	 *
	 * <p>If invoked from {@link ChartPanelContentViewer#refreshChart}, and the axes are replaced in that method, invoke
	 * this method before replacing the axis.</p>
	 *
	 * @see #setMinimumRightMargin
	 * @see #resetAxisFixedDimension
	 */
	public void resetMarginSync() {
		setMinimumRightMargin();
		resetAxisFixedDimension();
	}

	/**
	 * Resets the effects of time range and margin width synchronization, and prepare for future synchronizations.
	 *
	 * <p>If invoked from {@link ChartPanelContentViewer#refreshChart}, and the axes are replaced in that method, invoke
	 * this method before replacing the axis.</p>
	 *
	 * @see #resetTimeSync
	 * @see #resetMarginSync
	 */
	public void resetTimeMarginSync() {
		resetTimeSync();
		resetMarginSync();
	}

	public void dispose() {
		disableReceivingEvents();
		setEnabled(false);
		XYPlot plot = getXYPlot();
		if (plot != null) {
			plot.removeChangeListener(this);
		}
	}

	@SuppressWarnings("null")
	protected Stream<XYPlot> streamXYPlots(@Nullable XYPlot xyPlot) {
		if (xyPlot == null) {
			return Stream.empty();
		}
		Stream<XYPlot> plots = Stream.of(xyPlot);
		if (xyPlot instanceof CombinedDomainXYPlot) {
			Stream<XYPlot> subPlots = ((CombinedDomainXYPlot) xyPlot).getSubplots().stream();
			plots = Stream.concat(plots, subPlots.flatMap(this::streamXYPlots));
		} else if (xyPlot instanceof CombinedRangeXYPlot) {
			Stream<XYPlot> subPlots = ((CombinedRangeXYPlot) xyPlot).getSubplots().stream();
			plots = Stream.concat(plots, subPlots.flatMap(this::streamXYPlots));
		}
		return plots;
	}
}
