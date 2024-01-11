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

import org.jfree.chart.renderer.xy.AbstractXYItemRenderer;

import nl.esi.pps.tmsc.viewers.plot.DependenciesRenderer;
import nl.esi.pps.tmsc.viewers.plot.ExecutionsRenderer;

public interface IRenderingSeriesConfigurator {
	default void configureSeries(AbstractXYItemRenderer renderer, int series, boolean notify) {
		// Empty, because implementers can also choose to implement the more specific methods
	}

	default void configureDependenciesSeries(DependenciesRenderer dependenciesRenderer, int series, boolean notify) {
		configureSeries((AbstractXYItemRenderer) dependenciesRenderer, series, notify);
	}

	default void configureExecutionsSeries(ExecutionsRenderer executionsRenderer, int series, boolean notify) {
		configureSeries((AbstractXYItemRenderer) executionsRenderer, series, notify);
	}
}