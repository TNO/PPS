/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.viewers.plot;

import org.eclipse.trace4cps.common.jfreechart.ui.gantt.XYGanttDataItem;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.Range;

import nl.esi.pps.tmsc.Execution;

public class ExecutionDataItem extends XYGanttDataItem<Execution> {
	private static final long serialVersionUID = -410836050035541114L;

	public ExecutionDataItem(Range executionRange, double start, double end, Execution execution) {
		super(executionRange, 1L, 0L, start, end, PlotOrientation.VERTICAL, execution);
	}
}
