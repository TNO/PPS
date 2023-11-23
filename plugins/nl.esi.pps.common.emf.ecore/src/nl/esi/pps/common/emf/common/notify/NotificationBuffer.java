/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.emf.common.notify;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;

/**
 * @see http://git.eclipse.org/c/emf-parsley/org.eclipse.emf-parsley.git/tree/plugins/org.eclipse.emf.parsley.common/src/org/eclipse/emf/parsley/edit/NotificationBuffer.java?id=fc480682cc041dfe9ce3d34a5edef6db085e9ede
 */
public class NotificationBuffer extends AdapterImpl {

	protected final List<Notification> notifications = new ArrayList<Notification>();

	protected List<Adapter> savedAdapters = null;

	protected final Notifier notifier;

	public NotificationBuffer(Notifier notifier) {
		this.notifier = notifier;
	}

	public void startBuffering() {
		// Save the current adapter
		EList<Adapter> eAdapters = notifier.eAdapters();
		savedAdapters = new ArrayList<Adapter>(eAdapters);
		eAdapters.clear();

		// now we listen to notifications
		eAdapters.add(this);
	}

	public void stopBuffering() {
		EList<Adapter> eAdapters = notifier.eAdapters();
		eAdapters.remove(this);
		eAdapters.addAll(savedAdapters);
		savedAdapters = null;
	}

	@Override
	public void notifyChanged(Notification msg) {
		notifications.add(msg);
	}

	public void flushNotifications() {
		if (null != savedAdapters) {
			throw new IllegalStateException("Cannot flush notifications while buffering");
		}
		
		for (Iterator<Notification> i = notifications.listIterator(); i.hasNext();) {
			notifier.eNotify(i.next());
			i.remove();
		}
	}

	public List<Notification> getNotifications() {
		return notifications;
	}
}