/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.analysis.ui.rendering;

import static nl.esi.pps.common.jfreechart.rendering.RenderingPaint.PURE_BLUE;
import static nl.esi.pps.common.jfreechart.rendering.RenderingPaint.PURE_ORANGE;
import static nl.esi.pps.common.jfreechart.rendering.RenderingPaint.PURE_RED;
import static nl.esi.pps.common.jfreechart.rendering.RenderingStroke.FAT_DASHED;
import static nl.esi.pps.common.jfreechart.rendering.RenderingStroke.FAT_SOLID;

import nl.esi.pps.common.jfreechart.rendering.RenderingPaint;
import nl.esi.pps.common.jfreechart.rendering.RenderingStroke;
import nl.esi.pps.tmsc.rendering.plot.IRenderingSeriesConfigurator;
import nl.esi.pps.tmsc.viewers.plot.DependenciesRenderer;

public enum CriticalPathRenderingKey implements IRenderingSeriesConfigurator {
	CRITICAL_ACTIVITY("Critical", PURE_BLUE, FAT_SOLID, true), CRITICAL_SCHEDULED("Critical", PURE_BLUE, FAT_DASHED, false),
	OUTLIER_ACTIVITY("Outlier", PURE_ORANGE, FAT_SOLID, true), OUTLIER_SCHEDULED("Outlier", PURE_ORANGE, FAT_DASHED, false),
	ROOT_CAUSE_ACTIVITY("Root cause", PURE_RED, FAT_SOLID, true), ROOT_CAUSE_SCHEDULED("Root cause", PURE_RED, FAT_DASHED, false);

	private final String literal;
	private final RenderingPaint paint;
	private final RenderingStroke stroke;
	private boolean visibleInLegend;
	

	private CriticalPathRenderingKey(String literal, RenderingPaint paint, RenderingStroke stroke,
			boolean visibleInLegend) {
		this.literal = literal;
		this.paint = paint;
		this.stroke = stroke;
		this.visibleInLegend = visibleInLegend;
	}

	@Override
	public void configureDependenciesSeries(DependenciesRenderer dependenciesRenderer, int series, boolean notify) {
		dependenciesRenderer.setSeriesPaintSupplier(series, paint, notify);
		dependenciesRenderer.setSeriesStroke(series, stroke.getStroke(), notify);
		dependenciesRenderer.setSeriesVisibleInLegend(series, visibleInLegend, false);
	}
	
	@Override
	public String toString() {
		return literal;
	}
}
