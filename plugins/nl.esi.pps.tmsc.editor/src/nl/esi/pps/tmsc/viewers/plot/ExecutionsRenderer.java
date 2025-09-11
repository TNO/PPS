/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.viewers.plot;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.trace4cps.common.jfreechart.ui.gantt.XYGanttRenderer;
import org.eclipse.trace4cps.common.jfreechart.ui.viewers.BackReferenceLabelGenerator;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.ui.Layer;

import nl.esi.pps.common.jfreechart.rendering.PaintSupplier;

public class ExecutionsRenderer extends XYGanttRenderer {
	private static final long serialVersionUID = -6747174833240234980L;

	private transient ILabelProvider labelProvider = new LabelProvider();

	private boolean defaultAnnotationsVisible = true;

	public ExecutionsRenderer() {
		final BackReferenceLabelGenerator labelGenerator = new BackReferenceLabelGenerator(
				o -> getLabelProvider().getText(o));
		setDefaultItemLabelGenerator(labelGenerator);
		setDefaultToolTipGenerator(labelGenerator);
	}

	public void setDefaultAnnotationsVisible(boolean annotationsVisible) {
		setDefaultAnnotationsVisible(annotationsVisible, true);
	}

	public void setDefaultAnnotationsVisible(boolean annotationsVisible, boolean notify) {
		this.defaultAnnotationsVisible = annotationsVisible;
		if (notify) {
			fireChangeEvent();
		}
	}

	public boolean getDefaultAnnotationsVisible() {
		return defaultAnnotationsVisible;
	}

	@Override
	public void drawAnnotations(Graphics2D g2, Rectangle2D dataArea, ValueAxis domainAxis, ValueAxis rangeAxis,
			Layer layer, PlotRenderingInfo info) {
		if (this.defaultAnnotationsVisible) {
			super.drawAnnotations(g2, dataArea, domainAxis, rangeAxis, layer, info);
		}
	}

	public void setLabelProvider(ILabelProvider labelProvider, boolean notify) {
		this.labelProvider = labelProvider;
		if (notify) {
			fireChangeEvent();
		}
	}

	public ILabelProvider getLabelProvider() {
		return labelProvider;
	}

	public void setDefaultPaintSupplier(PaintSupplier paintSupplier, boolean notify) {
		setDefaultPaint(paintSupplier.getPaint(), notify);
		setDefaultOutlinePaint(paintSupplier.getOutlinePaint(), notify);
		setDefaultItemLabelPaint(paintSupplier.getLabelPaint(), notify);
	}

	public void setSeriesPaintSupplier(int series, PaintSupplier paintSupplier, boolean notify) {
		setSeriesPaint(series, paintSupplier.getPaint(), notify);
		setSeriesOutlinePaint(series, paintSupplier.getOutlinePaint(), notify);
		setSeriesItemLabelPaint(series, paintSupplier.getLabelPaint(), notify);
	}
}
