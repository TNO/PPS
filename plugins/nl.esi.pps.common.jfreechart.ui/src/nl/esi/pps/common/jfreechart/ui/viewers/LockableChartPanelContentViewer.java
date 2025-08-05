/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.jfreechart.ui.viewers;

import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.trace4cps.common.jfreechart.ui.viewers.ChartPanelContentViewer;

public abstract class LockableChartPanelContentViewer extends ChartPanelContentViewer
		implements LockableChartPanelViewer {
	/**
	 * Acts as a tri-state where {@code null} means unlocked, {@link Boolean#FALSE}
	 * means locked and {@link Boolean#TRUE} means locked and refresh pending.
	 */
	private Boolean refreshLock = null;

	private AtomicBoolean inRefresh = new AtomicBoolean(false);

	public LockableChartPanelContentViewer(Composite parent) {
		super(parent);
	}

	@Override
	public void lockRefresh() {
		if (refreshLock == null) {
			refreshLock = Boolean.FALSE;
		}
	}

	@Override
	public void unlockRefresh() {
		if (refreshLock == Boolean.TRUE) {
			refreshLock = null;
			refresh();
		} else {
			refreshLock = null;
		}
	}

	@Override
	public final void refresh() {
		if (inRefresh.compareAndSet(true, true)) {
			// Already refreshing
			return;
		}
		try {
			if (refreshLock != null) {
				refreshLock = Boolean.TRUE;
				return;
			}
			BusyIndicator.showWhile(null, this::doRefresh);
		} finally {
			inRefresh.set(false);
		}
	}

	protected final void doRefresh() {
		super.refresh();
	}
}
