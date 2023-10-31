/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.common.emf.synchronizedtiming;

import static nl.esi.pps.common.emf.synchronizedtiming.TimeSyncDebug.DEBUG;

import java.util.Locale;
import java.util.function.Consumer;

import org.eclipse.core.runtime.Assert;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbenchWindow;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nl.esi.pps.common.emf.synchronizedtiming.events.TimeRangeChangedEvent;
import nl.esi.pps.common.emf.synchronizedtiming.events.ViewMarginWidthChangedEvent;
import nl.esi.pps.common.emf.synchronizedtiming.range.ConversionNotSupportedException;
import nl.esi.pps.common.emf.synchronizedtiming.range.TimeRange;

public abstract class TimeSyncSupport {
	/**
	 * Hides the ugly API for IEventBroker handlers.
	 * 
	 * We cannot use the annotation-based approach ({@link org.eclipse.e4.ui.di.UIEventTopic},
	 * as unsubscribing does not work with annotations.
	 * 
	 * @author nstotz
	 */
	protected class EventHandlerWrapper<EVENT> implements EventHandler {
		
		private final String topic;
		private final Class<EVENT> eventType;
		private final Consumer<EVENT> handler;

		protected EventHandlerWrapper(final String topic, final Class<EVENT> eventType, final Consumer<EVENT> handler) {
			this.topic = topic;
			this.eventType = eventType;
			this.handler = handler;
		}
		
		@Override
		public void handleEvent(@Nullable Event event) {
			if (null == event) {
				return;
			}
			
			final Object data = event.getProperty(IEventBroker.DATA);
			Assert.isLegal(eventType.isInstance(data), "event data must be a " + eventType.getName());
			handler.accept(eventType.cast(data));
		}
		
		public void subscribe() {
			getEventBroker().subscribe(topic, this);
		}
		
		public void unsubscribe() {
			getEventBroker().unsubscribe(this);
		}
	}
	
	@SuppressWarnings("null")
	private static final Logger LOGGER = LoggerFactory.getLogger(TimeSyncSupport.class);

    /** The number of pixels for the left offset alignment. */
    private static final int NEAR_THRESHOLD = 10;

    /** The control in the UI that uses this support. */
	private final Control control;

	/** The workbench window that contains the control. */
	private final IWorkbenchWindow window;

	/** The Eclipse context of the workbench window. */
	private final IEclipseContext context;

	/** The event broker of the Eclipse context. */
	private final IEventBroker eventBroker;

	/** Whether time synchronization sending/receiving is enabled. */
	private boolean enabledTimeSync = true;

	/** Whether margin synchronization sending/receiving is enabled. */
	private boolean enabledMarginSync = true;

	/** Whether time synchronization is currently being performed. */
	private boolean inTimeSync = false;

	/** Whether margin synchronization is currently being performed. */
	private boolean inMarginSync = false;

	private final EventHandlerWrapper<ViewMarginWidthChangedEvent> viewMarginWidthChangedEventHandler;

	private final EventHandlerWrapper<TimeRangeChangedEvent> timeRangeChangedEventHandler;

	@SuppressWarnings({ "null", "unused" })
	public TimeSyncSupport(Control control) {
		this.control = control;
		Assert.isNotNull(control);
		if (control.isDisposed()) {
			throw new IllegalStateException("Control is disposed: " + control);
		}

		IWorkbenchWindow window = TimeSyncUtils.getWorkbenchWindow(control);
		if (window == null) {
			throw new IllegalStateException(
					String.format(Locale.US, "No workbench window '%s' of control '%s'.", window, control));
		}
		this.window = window;

		@Nullable
		IEclipseContext context = window.getService(IEclipseContext.class);
		if (context == null) {
			throw new IllegalStateException(
					String.format(Locale.US, "No context for workbench window '%s' of control '%s'.", window, control));
		}
		this.context = context;

		@Nullable
		IEventBroker eventBroker = context.get(IEventBroker.class);
		if (eventBroker == null) {
			throw new IllegalStateException(String.format(Locale.US,
					"No event broker for context '%s' of workbench window '%s' of control '%s'.", context, window,
					control));
		}
		this.eventBroker = eventBroker;
		
		this.viewMarginWidthChangedEventHandler = new EventHandlerWrapper<>(
				ViewMarginWidthChangedEvent.VIEW_MARGIN_WIDTH_CHANGED_EVENT_ID, ViewMarginWidthChangedEvent.class,
				this::handleViewMarginWidthChangedEvent);

		this.timeRangeChangedEventHandler = new EventHandlerWrapper<>(TimeRangeChangedEvent.TIME_RANGE_CHANGED_EVENT_ID,
				TimeRangeChangedEvent.class, (e -> handleTimeRangeChangedEvent(e)));

		enableReceivingEvents(context);

		// On dispose of the control, no longer receive or process events.
		control.addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(@Nullable DisposeEvent e) {
				if (DEBUG) {
				LOGGER.debug("Widget disposed. event=" + e);
				}
				disableReceivingEvents();
			}
		});
	}

	protected void enableReceivingEvents(IEclipseContext context) {
		if (DEBUG) {
			LOGGER.debug("Subscribing to time synchronization support. support=" + this);
		}
		
		this.viewMarginWidthChangedEventHandler.subscribe();
		this.timeRangeChangedEventHandler.subscribe();
	}

	protected void disableReceivingEvents() {
		setEnabled(false);
		if (DEBUG) {
			LOGGER.debug("Unsubscribing from time synchronization support. support=" + this);
		}
		
		this.viewMarginWidthChangedEventHandler.unsubscribe();
		this.timeRangeChangedEventHandler.unsubscribe();
	}

	/**
	 * @return The control in the UI that uses this time synchronization support.
	 */
	protected Control getControl() {
		return control;
	}

	/**
	 * @return The workbench window that contains the control.
	 */
	protected IWorkbenchWindow getWindow() {
		return window;
	}

	/**
	 * @return The Eclipse context of the workbench window.
	 */
	protected IEclipseContext getContext() {
		return context;
	}

	/**
	 * @return The event broker of the Eclipse context.
	 */
	protected IEventBroker getEventBroker() {
		return eventBroker;
	}

	/**
	 * @return Whether time synchronization sending/receiving is enabled.
	 */
	public boolean isEnabledTimeSync() {
		return enabledTimeSync;
	}

	/**
	 * @return Whether margin synchronization sending/receiving is enabled.
	 */
	public boolean isEnabledMarginSync() {
		return enabledMarginSync;
	}

	/**
	 * @param enabled Whether time and margin synchronization sending/receiving is to be enabled.
	 */
	public void setEnabled(boolean enabled) {
		setEnabledTimeSync(enabled);
		setEnabledMarginSync(enabled);
	}

	/**
	 * @param enabled Whether time synchronization sending/receiving is to be enabled.
	 */
	public void setEnabledTimeSync(boolean enabled) {
		enabledTimeSync = enabled;
	}

	/**
	 * @param enabled Whether margin synchronization sending/receiving is to be enabled.
	 */
	public void setEnabledMarginSync(boolean enabled) {
		enabledMarginSync = enabled;
	}

	/**
	 * @return Whether time synchronization is currently being performed.
	 */
	protected boolean isInTimeSync() {
		return inTimeSync;
	}

	/**
	 * @return Whether margin synchronization is currently being performed.
	 */
	protected boolean isInMarginSync() {
		return inMarginSync;
	}

	public void handleTimeRangeChangedEvent(TimeRangeChangedEvent event) {
		// Debug.
		if (DEBUG) {
			LOGGER.debug("handleTimeRangeChangedEvent: control=" + control + ", event=" + event + ", support=" + this);
		}

		// Skip if not enabled.
		if (!enabledTimeSync) {
			return;
		}

		// Ensure that viewer is not updated for its own events.
		if (event.getOrigin() == control) {
			return;
		}

		// Skip events for other workbench windows.
		IWorkbenchWindow eventWindow = event.getWorkbenchWindow();
		if (eventWindow != null && window != eventWindow) {
			return;
		}

		// Update time range, if changed.
		updateTimeRangeIfDifferent(event.getTimeRange(), false);
	}

	public void handleViewMarginWidthChangedEvent(ViewMarginWidthChangedEvent event) {
		// Debug.
		if (DEBUG) {
			LOGGER.debug("handleViewMarginWidthChangedEvent: control=" + control + ", event=" + event);
		}

		// Skip if not enabled.
		if (!enabledMarginSync) {
			return;
		}

		// Skip events for other workbench windows.
		IWorkbenchWindow eventWindow = event.getWorkbenchWindow();
		if (eventWindow != null && window != eventWindow) {
			return;
		}

		// Get current view location. Skip if no view location, for instance in case the plot is being replaced.
		Point curLocation = getViewLocation();
		if (curLocation == null) {
			return;
		}

		// Get event view location.
		Point eventLocation = event.getViewLocation();

		// Skip if not left-aligned. Ensures that only relevant viewers are updated.
		int leftAlignOffset = eventLocation.x - curLocation.x;
		if (Math.abs(leftAlignOffset) > NEAR_THRESHOLD) {
			return;
		}

		// Update margin width, if changed. Compensate for left-align offset.
		updateMarginWidthIfDifferent(leftAlignOffset + event.getViewMarginWidth(), false);
	}

	public void sendTimeRangeChangedEvent(boolean force) {
		if (!force && !enabledTimeSync) {
			return;
		}
		TimeRange range = getTimeRange();
		if (range == null) {
			LOGGER.warn("No time range to send: " + this);
			return;
		}
		sendTimeRangeChangedEvent(force, range);
	}

	public void sendTimeRangeChangedEvent(boolean force, TimeRange range) {
		if (!force && !enabledTimeSync) {
			return;
		}
		TimeRangeChangedEvent event = new TimeRangeChangedEvent(control, window, range);
		TimeSyncUtils.sendTimeSyncEvent(eventBroker, event);
	}

	public void sendViewMarginWidthChangedEvent(boolean force) {
		if (!force && !enabledMarginSync) {
			return;
		}
		@Nullable Point viewLocation = getViewLocation();
		@Nullable Integer viewMarginWidth = getViewMarginWidth();
		if (viewLocation == null || viewMarginWidth == null) {
			LOGGER.warn("No view margin to send: " + this);
			return;
		}
		sendViewMarginWidthChangedEvent(force, viewLocation, viewMarginWidth);
	}

	public void sendViewMarginWidthChangedEvent(boolean force, Point viewLocation, int viewMarginWidth) {
		if (!force && !enabledMarginSync) {
			return;
		}
		ViewMarginWidthChangedEvent event = new ViewMarginWidthChangedEvent(control, window, viewLocation,
				viewMarginWidth);
		TimeSyncUtils.sendTimeSyncEvent(eventBroker, event);
	}

	/**
	 * Get/provide a time range.
	 *
	 * @return The time range. May be {@code null} if not available.
	 */
	public abstract @Nullable TimeRange getTimeRange();

	/**
	 * Updates the time range of the component of this support, regardless of the {@link #isEnabledTimeSync enablement}
	 * of this support. An {@link #updateTimeRange update} is only performed if the current time range and the given
	 * new range range are different. If updated, a time range change event will be send, but only if this support is
	 * enabled.
	 *
	 * @param timeRange The new time range.
	 */
	public void updateTimeRangeIfDifferent(TimeRange timeRange) {
		updateTimeRangeIfDifferent(timeRange, true);
	}

	/**
	 * Updates the time range of the component of this support, regardless of the {@link #isEnabledTimeSync enablement}
	 * of this support. An {@link #updateTimeRange update} is only performed if the current time range and the given
	 * new range range are different. If updated, a time range change event may optionally be send.
	 *
	 * @param timeRange The new time range.
	 * @param maySend Whether an event may be sent in case the time ranges differ.
	 */
	protected void updateTimeRangeIfDifferent(TimeRange newRange, boolean maySend) {
		// Get current time range. Skip if no time range, for instance in case of no data in plot.
		TimeRange curRange = getTimeRange();
		if (curRange == null) {
			return;
		}

		// Get new time range. Convert to same type as current time range for comparison.
		try {
			newRange = newRange.convertTo(curRange.getClass());
		} catch (ConversionNotSupportedException ex) {
			LOGGER.debug("Could not convert " + newRange.getClass() + " to " + curRange.getClass(), ex);
			return;
		}

		// Skip if same range. Ensures that viewer is not updated for its own events.
		if (newRange.getFrom().equals(curRange.getFrom()) && newRange.getTo().equals(curRange.getTo())) {
			return;
		}

		// Update time range.
		if (!maySend) {
			// Indicate that we are updating the time range due to a synchronization request from
			// another source, to prevent this update from causing events to be sent that have no effect.
			inTimeSync = true;
		}
		try {
			updateTimeRange(newRange);
		} finally {
			if (!maySend) {
				inTimeSync = false;
			}
		}
	}

	/**
	 * Updates the viewer to the given time range.
	 *
	 * @param range The new time range.
	 */
	protected void updateTimeRange(TimeRange range) {
		if (DEBUG) {
			LOGGER.debug("updateTimeRange: control=" + control + ", range=" + range);
		}
		setTimeRange(range);
	}

	/**
	 * Sets/consumes a time range.
	 *
	 * @param range The time range.
	 */
	protected abstract void setTimeRange(TimeRange range);

	protected abstract @Nullable Point getViewLocation();

	protected abstract @Nullable Integer getViewMarginWidth();

	/**
	 * Updates the margin width of the component of this support, regardless of the
	 * {@link #isEnabledMarginSync enablement} of this support. An {@link #updateMarginWidth update} is only performed
	 * if the current margin width and the given new margin width are different. If updated, a margin width change
	 * event will be send, but only if this support is enabled.
	 *
	 * @param newWidth The new margin width.
	 */
	public void updateMarginWidthIfDifferent(int newWidth) {
		updateMarginWidthIfDifferent(newWidth, true);
	}

	/**
	 * Updates the margin width of the component of this support, regardless of the
	 * {@link #isEnabledMarginSync enablement} of this support. An {@link #updateMarginWidth update} is only performed
	 * if the current margin width and the given new margin width are different. If updated, a margin width change
	 * event may optionally be send.
	 *
	 * @param newWidth The new margin width.
	 * @param maySend Whether an event may be sent in case the range widths differ.
	 */
	protected void updateMarginWidthIfDifferent(int newWidth, boolean maySend) {
		// Get current margin width. Skip if no margin width, for instance in case of no data in plot.
		Integer curWidth = getViewMarginWidth();
		if (curWidth == null) {
			return;
		}

		// Skip if same margin width. Ensures that viewer is not updated for its own events.
		if (curWidth.equals(newWidth)) {
			return;
		}

		// Update margin width.
		if (!maySend) {
			// Indicate that we are updating the margin width due to a synchronization request from
			// another source, to prevent this update from causing events to be sent that have no effect.
			inMarginSync = true;
		}
		try {
			updateMarginWidth(newWidth);
		} finally {
			if (!maySend) {
				inMarginSync = false;
			}
		}
	}

	/**
	 * Updates the viewer to the given margin width.
	 *
	 * @param width The new margin width.
	 */
	protected void updateMarginWidth(int width) {
		if (DEBUG) {
			LOGGER.debug("updateMarginWidth: control=" + control + ", width=" + width);
		}
		setMarginWidth(width);
	}

	protected abstract void setMarginWidth(int width);

	@Override
	public String toString() {
		return super.toString() + " (control=" + control + ")";
	}
}
