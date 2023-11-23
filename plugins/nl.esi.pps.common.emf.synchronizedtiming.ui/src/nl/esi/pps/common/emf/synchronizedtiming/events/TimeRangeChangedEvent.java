/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
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
import org.eclipse.ui.IWorkbenchWindow;

import nl.esi.pps.common.emf.synchronizedtiming.ITimeSyncEvent;
import nl.esi.pps.common.emf.synchronizedtiming.range.TimeRange;

public class TimeRangeChangedEvent implements ITimeSyncEvent {
	/** Time range changed event unique id. */
	public static final String TIME_RANGE_CHANGED_EVENT_ID = "TIME_RANGE_CHANGED";

	/** The event origin. */
	private final Object origin;

	/** The target workbench window. May be {@code null} for 'all windows'. */
	private final @Nullable IWorkbenchWindow window;

	/** The new time range. */
	private final TimeRange range;

	/**
	 * @param origin The event origin.
	 * @param window The target workbench window. May be {@code null} for 'all windows'.
	 * @param range The new time range.
	 */
	public TimeRangeChangedEvent(Object origin, @Nullable IWorkbenchWindow window, TimeRange range) {
		this.origin = origin;
		this.window = window;
		this.range = range;
	}
	
	@Override
	public String getTopic() {
		return TIME_RANGE_CHANGED_EVENT_ID;
	}

	@Override
	public Object getOrigin() {
		return origin;
	}

	@Override
	public @Nullable IWorkbenchWindow getWorkbenchWindow() {
		return window;
	}

	/**
	 * @return The new time range.
	 */
	public TimeRange getTimeRange() {
		return range;
	}

	@Override
	@SuppressWarnings("null")
	public String toString() {
		return String.format(Locale.US, "%s @ %s -> %s", origin, window, range);
	}
}
