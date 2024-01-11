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

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;

public class LockingCommandStack extends BasicCommandStack {
	private final LockableAdapterFactory adapterFactory;

	public LockingCommandStack(LockableAdapterFactory adapterFactory) {
		this.adapterFactory = adapterFactory;
	}

	@Override
	public void execute(Command command) {
		adapterFactory.lockViewerUpdates();
		try {
			super.execute(command);
		} finally {
			adapterFactory.unlockViewerUpdates();
		}
	}

	@Override
	public void undo() {
		adapterFactory.lockViewerUpdates();
		try {
			super.undo();
		} finally {
			adapterFactory.unlockViewerUpdates();
		}
	}

	@Override
	public void redo() {
		adapterFactory.lockViewerUpdates();
		try {
			super.redo();
		} finally {
			adapterFactory.unlockViewerUpdates();
		}
	}
}
