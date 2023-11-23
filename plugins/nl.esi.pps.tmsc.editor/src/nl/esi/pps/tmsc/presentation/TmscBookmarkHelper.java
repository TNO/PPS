/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.presentation;

import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;

import nl.esi.pps.common.emf.ui.jfree.JFreeBookmarkHelper;
import nl.esi.pps.common.jfreechart.chart.axis.NanoTimeAxis;
import nl.esi.pps.common.jfreechart.chart.axis.NanoTimeRange;

public class TmscBookmarkHelper extends JFreeBookmarkHelper {
	public static final String TMSC_BOOKMARK_TYPE = TmscEditorPlugin.getPlugin().getSymbolicName() + ".bookmark";

	public static final String TMSC_RENDERING_STRATEGY_ID = "renderingStrategyID";

	public static final String TMSC_LOCATION_VALUE = "Timed message sequence chart";
	public static final int TMSC_PAGE_INDEX_VALUE = 1;

	@Override
	public String serializeDomainRange(XYPlot xyPlot) {
		if (null == xyPlot) {
			return null;
		}
		final ValueAxis axis = xyPlot.getDomainAxis();
		if (axis instanceof NanoTimeAxis) {
			return serializeNanoTimeRange(((NanoTimeAxis) axis).getNanoTimeRange());
		}
		return super.serializeDomainRange(xyPlot);
	}

	public String serializeNanoTimeRange(NanoTimeRange range) {
		if (null == range) {
			return null;
		}
		return Long.toString(range.getLowerBound()) + " " + Long.toString(range.getUpperBound());
	}

	@Override
	public void deserializeDomainRange(String range, XYPlot xyPlot) {
		if (null == range || null == xyPlot) {
			return;
		}
		final ValueAxis axis = xyPlot.getDomainAxis();
		if (axis instanceof NanoTimeAxis) {
			NanoTimeRange domainRange = deserializeNanoTimeRange(range);
			if (null == domainRange) {
				axis.setAutoRange(true);
			} else {
				((NanoTimeAxis) axis).setNanoTimeRange(domainRange);
			}
		} else {
			super.deserializeDomainRange(range, xyPlot);
		}
	}

	public NanoTimeRange deserializeNanoTimeRange(final String range) {
		if (null == range || VALUE_AUTO_RANGE.equalsIgnoreCase(range)) {
			return null;
		}
		String[] lowerUpper = range.split("\\s");
		if (lowerUpper.length == 2) {
			return new NanoTimeRange(Long.parseLong(lowerUpper[0]), Long.parseLong(lowerUpper[1]));
		}
		return null;
	}
}
