/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.emf.ui.jfree;

import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.Range;

import nl.esi.pps.common.emf.ui.action.BookmarkHelper;

public class JFreeBookmarkHelper extends BookmarkHelper {
	public static final String JFREE_BOOKMARK_TYPE = "nl.esi.pps.common.emf.jfree.bookmark";

	public static final String JFREE_BOOKMARK_DOMAIN = "domain";
	public static final String JFREE_BOOKMARK_RANGE = "range";

	public static final String VALUE_AUTO_RANGE = "auto";

	public String serializeDomainRange(final XYPlot xyPlot) {
		if (null == xyPlot) {
			return null;
		}
		final ValueAxis axis = xyPlot.getDomainAxis();
		if (null == axis) {
			return null;
		}
		return serializeRange(axis.getRange());
	}

	public void deserializeDomainRange(final String range, final XYPlot xyPlot) {
		if (null == range || null == xyPlot) {
			return;
		}
		final ValueAxis axis = xyPlot.getDomainAxis();
		if (null == axis) {
			return;
		}
		Range domainRange = deserializeRange(range);
		if (null == domainRange) {
			axis.setAutoRange(true);
		} else {
			axis.setRange(domainRange);
		}
	}

	public String serializeRangeRange(final XYPlot xyPlot) {
		if (null == xyPlot) {
			return null;
		}
		final ValueAxis axis = xyPlot.getRangeAxis();
		if (null == axis) {
			return null;
		}
		return serializeRange(axis.getRange());
	}

	public void deserializeRangeRange(final String range, final XYPlot xyPlot) {
		if (null == range || null == xyPlot) {
			return;
		}
		final ValueAxis axis = xyPlot.getRangeAxis();
		if (null == axis) {
			return;
		}
		Range rangeRange = deserializeRange(range);
		if (null == rangeRange) {
			axis.setAutoRange(true);
		} else {
			axis.setRange(rangeRange);
		}
	}

	public String serializeRange(final Range range) {
		if (null == range) {
			return null;
		}
		return range.getLowerBound() + " " + range.getUpperBound();
	}

	public Range deserializeRange(final String range) {
		if (null == range || VALUE_AUTO_RANGE.equalsIgnoreCase(range)) {
			return null;
		}
		String[] lowerUpper = range.split("\\s");
		if (lowerUpper.length == 2) {
			return new Range(Double.valueOf(lowerUpper[0]), Double.valueOf(lowerUpper[1]));
		}
		return null;
	}
}
