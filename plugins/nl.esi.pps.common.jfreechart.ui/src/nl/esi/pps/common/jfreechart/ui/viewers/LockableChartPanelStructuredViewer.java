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

import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.trace4cps.common.jfreechart.ui.viewers.ChartPanelStructuredViewer;

public abstract class LockableChartPanelStructuredViewer extends ChartPanelStructuredViewer
		implements LockableChartPanelViewer {
	/**
	 * Acts as a tri-state where {@code null} means unlocked,
	 * {@link Optional#isEmpty()} means locked and {@link Optional#isPresent()}
	 * means locked and refresh pending.
	 */
	private Optional<Object> refreshLock = null;

	private AtomicBoolean inRefresh = new AtomicBoolean(false);

	public LockableChartPanelStructuredViewer(Composite parent) {
		super(parent);
	}

	@Override
	public void lockRefresh() {
		if (refreshLock == null) {
			refreshLock = Optional.empty();
		}
	}

	@Override
	public void unlockRefresh() {
		if (refreshLock == null) {
			return;
		} else if (refreshLock.isPresent()) {
			final Object element = refreshLock.get();
			refreshLock = null;
			refresh(element);
		} else {
			refreshLock = null;
		}
	}

	@Override
	public final void refresh(Object element) {
		if (inRefresh.compareAndSet(true, true)) {
			// Already refreshing
			return;
		}
		try {
			if (refreshLock != null) {
				if (refreshLock.isEmpty()) {
					refreshLock = Optional.ofNullable(element);
				} else if (refreshLock.get() != element) {
					// Cannot refresh multiple elements, refresh the root instead
					refreshLock = Optional.ofNullable(getRoot());
				}
				return;
			}
			BusyIndicator.showWhile(null, () -> doRefresh(element));
		} finally {
			inRefresh.set(false);
		}
	}

	protected final void doRefresh(Object element) {
		super.refresh(element);
	}
}
