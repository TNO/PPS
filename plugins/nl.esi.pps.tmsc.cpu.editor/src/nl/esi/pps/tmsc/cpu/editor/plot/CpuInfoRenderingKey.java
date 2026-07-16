/*
 * Copyright (c) 2018-2026 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.cpu.editor.plot;

import java.awt.Color;
import java.awt.Paint;

import nl.esi.pps.tmsc.rendering.plot.IRenderingSeriesConfigurator;
import nl.esi.pps.tmsc.viewers.plot.ExecutionsRenderer;

public enum CpuInfoRenderingKey implements IRenderingSeriesConfigurator {
	ON_CPU("On-CPU", new Color(0, 183, 185)), 
	WAIT_CPU("Wait-for-CPU", new Color(234, 0, 94)),
	WAIT_OTHER("Wait-Other", new Color(174, 182, 193));

	private final String literal;
	private final Paint paint;
	
	private CpuInfoRenderingKey(String literal, Paint paint) {
		this.literal = literal;
		this.paint = paint;
	}

	@Override
	public void configureExecutionsSeries(ExecutionsRenderer executionsRenderer, int series, boolean notify) {
		executionsRenderer.setSeriesVisibleInLegend(series, true, notify);
		executionsRenderer.setSeriesPaint(series, paint, notify);
	}

	@Override
	public String toString() {
		return literal;
	}
}
