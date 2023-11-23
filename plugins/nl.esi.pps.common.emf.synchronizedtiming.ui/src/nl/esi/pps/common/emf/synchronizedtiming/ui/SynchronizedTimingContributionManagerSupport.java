/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.emf.synchronizedtiming.ui;

import static nl.esi.pps.common.emf.synchronizedtiming.ui.Activator.IMAGE_MARGIN_SYNC;
import static nl.esi.pps.common.emf.synchronizedtiming.ui.Activator.IMAGE_MARGIN_SYNC_ENABLED;
import static nl.esi.pps.common.emf.synchronizedtiming.ui.Activator.IMAGE_TIME_SYNC;
import static nl.esi.pps.common.emf.synchronizedtiming.ui.Activator.IMAGE_TIME_SYNC_ENABLED;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.action.Separator;

import nl.esi.pps.common.emf.synchronizedtiming.TimeSyncSupport;

public class SynchronizedTimingContributionManagerSupport {
	protected final TimeSyncAction timeSyncAction = new TimeSyncAction();
	protected final TimeSyncEnabledAction timeSyncEnabledAction = new TimeSyncEnabledAction();
	protected final MarginSyncAction marginSyncAction = new MarginSyncAction();
	protected final MarginSyncEnabledAction marginSyncEnabledAction = new MarginSyncEnabledAction();

	private final TimeSyncSupport timeSyncSupport;

	public SynchronizedTimingContributionManagerSupport(TimeSyncSupport timeSyncSupport) {
		this.timeSyncSupport = timeSyncSupport;
	}

	protected TimeSyncSupport getTimeSyncSupport() {
		return timeSyncSupport;
	}

	public void addTimeSyncActions(IContributionManager contributionManager, String groupName) {
		updateTimeSyncActions();

		if (null == contributionManager.find(groupName)) {
			contributionManager.add(new Separator(groupName));
		}
		contributionManager.appendToGroup(groupName, marginSyncEnabledAction);
		contributionManager.appendToGroup(groupName, marginSyncAction);
		contributionManager.appendToGroup(groupName, timeSyncEnabledAction);
		contributionManager.appendToGroup(groupName, timeSyncAction);
		contributionManager.update(false);
	}

	protected void updateTimeSyncActions() {
		timeSyncEnabledAction.update();
		marginSyncEnabledAction.update();
	}

	protected class TimeSyncAction extends Action {
		public TimeSyncAction() {
			super("Synchronize Time Range", Activator.getDescriptor(IMAGE_TIME_SYNC));
			setToolTipText("Synchonizes the current time range to all other supported editors/views.");
		}

		@Override
		public void run() {
			SynchronizedTimingContributionManagerSupport.this.getTimeSyncSupport().sendTimeRangeChangedEvent(true);
		}
	}

	protected class TimeSyncEnabledAction extends Action {
		public TimeSyncEnabledAction() {
			super("Time Range Synchronization Enabled", IAction.AS_CHECK_BOX);
			setImageDescriptor(Activator.getDescriptor(IMAGE_TIME_SYNC_ENABLED));
			setToolTipText("If checked, this editor/view will participate in time range synchronization.");
		}

		public void update() {
			setChecked(SynchronizedTimingContributionManagerSupport.this.getTimeSyncSupport().isEnabledTimeSync());
		}

		@Override
		public void run() {
			SynchronizedTimingContributionManagerSupport.this.getTimeSyncSupport().setEnabledTimeSync(isChecked());
			update();
		}
	}

	protected class MarginSyncAction extends Action {
		public MarginSyncAction() {
			super("Synchronize Margin Width", Activator.getDescriptor(IMAGE_MARGIN_SYNC));
			setToolTipText("Synchonizes the current margin width to all other supported editors/views.");
		}

		@Override
		public void run() {
			SynchronizedTimingContributionManagerSupport.this.getTimeSyncSupport().sendViewMarginWidthChangedEvent(true);
		}
	}

	protected class MarginSyncEnabledAction extends Action {
		public MarginSyncEnabledAction() {
			super("Pause Time Range Synchronization", IAction.AS_CHECK_BOX);
			setImageDescriptor(Activator.getDescriptor(IMAGE_MARGIN_SYNC_ENABLED));
			setToolTipText("If checked, this editor/view will participate in margin with synchronization.");
		}

		public void update() {
			setChecked(SynchronizedTimingContributionManagerSupport.this.getTimeSyncSupport().isEnabledMarginSync());
		}

		@Override
		public void run() {
			SynchronizedTimingContributionManagerSupport.this.getTimeSyncSupport().setEnabledMarginSync(isChecked());
			update();
		}
	}
}
