/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.common.jfreechart.ui.viewers;

import org.eclipse.trace4cps.common.jfreechart.ui.viewers.ChartPanelViewer;

public interface LockableChartPanelViewer extends ChartPanelViewer {
	/**
	 * Prevents {@link #refresh() refreshes} to be propagated to the
	 * {@link #getChartPanel() chart panel} until {@link #unlockRefresh()} is
	 * called.
	 * 
	 * <p>
	 * This method should be called in a {@code try ... finally} block:
	 * </p>
	 * 
	 * <pre>
	 * try {
	 * 	viewer.lockRefresh();
	 * 	// Your code ...
	 * } finally {
	 * 	viewer.unlockRefresh();
	 * }
	 * </pre>
	 * 
	 * @see #unlockRefresh()
	 */
	void lockRefresh();

	/**
	 * Unlocks refreshes to this viewer and {@link #refresh() refreshes} this viewer
	 * immediately if refreshes where pending.
	 * 
	 * @see #lockRefresh()
	 */
	void unlockRefresh();
}
