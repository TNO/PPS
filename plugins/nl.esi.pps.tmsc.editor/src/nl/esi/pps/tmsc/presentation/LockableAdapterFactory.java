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

import java.util.LinkedList;
import java.util.Queue;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IViewerNotification;

public class LockableAdapterFactory implements AdapterFactory, IChangeNotifier, IDisposable {
	private final ChangeNotifier changeNotifier = new ChangeNotifier();

	private final AdapterFactory delegate;

	private Queue<IViewerNotification> viewerNotifications = null;

	public LockableAdapterFactory(AdapterFactory delegate) {
		this.delegate = delegate;
		if (delegate instanceof IChangeNotifier) {
			((IChangeNotifier) delegate).addListener(this::fireNotifyChanged);
		}
	}
	
	/**
	 * Prevents {@link IViewerNotification viewer notifications} to be propagated
	 * until {@link #unlockViewerUpdates()} is called.
	 * 
	 * <p>
	 * This method should be called in a {@code try ... finally} block:
	 * </p>
	 * 
	 * <pre>
	 * try {
	 * 	adapterFactory.lockViewerUpdates();
	 * 	// Your code ...
	 * } finally {
	 * 	adapterFactory.unlockViewerUpdates();
	 * }
	 * </pre>
	 * 
	 * @see #unlockViewerUpdates()
	 */
	public void lockViewerUpdates() {
		if (viewerNotifications == null) {
			viewerNotifications = new LinkedList<>();
		}
	}
	
	/**
	 * Unlocks the {@link IViewerNotification viewer notifications} and sends the
	 * cached - if any - notifications directly to the viewer.
	 * 
	 * @see #lockViewerUpdates()
	 */
	public void unlockViewerUpdates() {
		if (viewerNotifications != null) {
			Queue<IViewerNotification> notifications = viewerNotifications;
			viewerNotifications = null;

			// Now fire all queued viewer notifications. The viewers are optimized
			// to reduce this stream of events to a single full refresh if needed. 
			notifications.forEach(this::fireNotifyChanged);
		}
	}

	@Override
	public void fireNotifyChanged(Notification notification) {
		if (viewerNotifications != null && notification instanceof IViewerNotification) {
			viewerNotifications.add((IViewerNotification) notification);
		} else {
			changeNotifier.fireNotifyChanged(notification);
		}
	}

	@Override
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	@Override
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	@Override
	public boolean isFactoryForType(Object type) {
		return delegate.isFactoryForType(type);
	}

	@Override
	public Object adapt(Object object, Object type) {
		return delegate.adapt(object, type);
	}

	@Override
	public Adapter adapt(Notifier target, Object type) {
		return delegate.adapt(target, type);
	}

	@Override
	public Adapter adaptNew(Notifier target, Object type) {
		return delegate.adaptNew(target, type);
	}

	@Override
	public void adaptAllNew(Notifier notifier) {
		delegate.adaptAllNew(notifier);
	}

	@Override
	public void dispose() {
		if (delegate instanceof IChangeNotifier) {
			((IChangeNotifier) delegate).removeListener(this::fireNotifyChanged);
		}
		if (delegate instanceof IDisposable) {
			((IDisposable) delegate).dispose();
		}
	}
}
