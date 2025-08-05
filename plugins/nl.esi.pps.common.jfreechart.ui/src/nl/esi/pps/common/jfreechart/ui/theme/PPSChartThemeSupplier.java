/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.jfreechart.ui.theme;

import org.eclipse.trace4cps.common.jfreechart.ui.theme.ChartThemeSupplier;
import org.jfree.chart.ChartTheme;

public class PPSChartThemeSupplier implements ChartThemeSupplier {
	@Override
	public ChartTheme getChartTheme() {
		return new PPSChartTheme();
	}
}
