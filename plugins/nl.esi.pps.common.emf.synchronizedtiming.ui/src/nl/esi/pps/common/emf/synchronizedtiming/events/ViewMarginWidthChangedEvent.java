/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.emf.synchronizedtiming.events;

import java.util.Locale;

import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;

import nl.esi.pps.common.emf.synchronizedtiming.ITimeSyncEvent;

public class ViewMarginWidthChangedEvent implements ITimeSyncEvent {
	/** Time-based view margin width changed event unique id. */
	public static final String VIEW_MARGIN_WIDTH_CHANGED_EVENT_ID = "VIEW_MARGIN_WIDTH_CHANGED";

	/** The event origin. */
	private final Object origin;

	/** The target workbench window. May be {@code null} for 'all windows'. */
	private final @Nullable IWorkbenchWindow window;

	/**
	 * The coordinates of the upper-left location of the view, relative to the
	 * upper left location of the workbench window or SWT {@link Shell}.
	 */
	private final Point viewLocation;

	/** The margin width of the view, in pixels. */
	private final int viewMarginWidth;

	/**
	 * @param origin The event origin.
	 * @param window The target workbench window. May be {@code null} for 'all windows'.
	 * @param viewLocation The coordinates of the upper-left location of the view, relative to the
	 *      upper left location of the workbench window or SWT {@link Shell}.
	 * @param viewMarginWidth The margin width of the view, in pixels.
	 */
	public ViewMarginWidthChangedEvent(Object origin, @Nullable IWorkbenchWindow window, Point viewLocation,
			int viewMarginWidth) {
		this.origin = origin;
		this.window = window;
		this.viewLocation = viewLocation;
		this.viewMarginWidth = viewMarginWidth;
	}
	
	@Override
	public String getTopic() {
		return VIEW_MARGIN_WIDTH_CHANGED_EVENT_ID;
	}

	@Override
	public Object getOrigin() {
		return origin;
	}

	@Override
	public @Nullable IWorkbenchWindow getWorkbenchWindow() {
		return window;
	}

	public Point getViewLocation() {
		return viewLocation;
	}

	public int getViewMarginWidth() {
		return viewMarginWidth;
	}

	@Override
	@SuppressWarnings("null")
	public String toString() {
		return String.format(Locale.US, "%s @ %s -> %s @ %s", origin, window, viewMarginWidth, viewLocation);
	}
}
