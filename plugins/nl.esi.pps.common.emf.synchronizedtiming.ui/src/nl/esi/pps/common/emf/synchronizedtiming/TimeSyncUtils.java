/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.emf.synchronizedtiming;

import static nl.esi.pps.common.emf.synchronizedtiming.TimeSyncDebug.DEBUG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeSyncUtils {
	@SuppressWarnings("null")
	private static final Logger LOGGER = LoggerFactory.getLogger(TimeSyncUtils.class);

	/** Event throttle delay in milliseconds. */
	private static final long THROTTLE_DELAY = 500;

	private static final Map<String, PendingTimeSyncEvent> PENDING_EVENTS = new HashMap<>(2);

	private static final Timer TIMER = new Timer(TimeSyncUtils.class.getName());

	private static TimerTask theirCurrentTask = new TimerTask() {
		@Override
		public void run() {
			// Empty
		}
	};

	private TimeSyncUtils() {
		// Static class.
	}

	/**
	 * Returns the workbench windows that contains the given control.
	 *
	 * @param control
	 *            The control. May be {@code null} or disposed control.
	 * @return The workbench window, or {@code null} if window could not be determined.
	 */
	public static @Nullable IWorkbenchWindow getWorkbenchWindow(@Nullable Control control) {
		if (control == null || control.isDisposed()) {
			return null;
		}
		Shell shell = control.getShell();
		for (IWorkbenchWindow window : PlatformUI.getWorkbench().getWorkbenchWindows()) {
			if (window.getShell() == shell) {
				return window;
			}
		}
		return null;
	}

	public static void sendTimeSyncEvent(IEventBroker eventBroker, ITimeSyncEvent event) {
		if (DEBUG) {
			LOGGER.debug("Sending {} event: {}", event.getTopic().toLowerCase().replace('_', ' '), event);
		}
		synchronized (PENDING_EVENTS) {
			theirCurrentTask.cancel();
			PENDING_EVENTS.put(event.getTopic(), new PendingTimeSyncEvent(eventBroker, event));
			theirCurrentTask = new DeliverPendingEventsTask();
			TIMER.schedule(theirCurrentTask, THROTTLE_DELAY);
		}
	}

	private static class PendingTimeSyncEvent {
		private final IEventBroker eventBroker;
		private final ITimeSyncEvent event;

		PendingTimeSyncEvent(IEventBroker eventBroker, ITimeSyncEvent event) {
			this.eventBroker = eventBroker;
			this.event = event;
		}

		private void deliver() {
			eventBroker.send(event.getTopic(), event);
		}
	}

	private static class DeliverPendingEventsTask extends TimerTask {
		@Override
		public void run() {
			List<PendingTimeSyncEvent> eventsToDeliver;
			synchronized (PENDING_EVENTS) {
				eventsToDeliver = new ArrayList<>(PENDING_EVENTS.values());
				PENDING_EVENTS.clear();
			}
			for (PendingTimeSyncEvent event : eventsToDeliver) {
				event.deliver();
			}
		}
	}
}
