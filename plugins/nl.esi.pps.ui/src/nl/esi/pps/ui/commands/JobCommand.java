/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.ui.commands;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.command.AbstractCommand;

public abstract class JobCommand extends AbstractCommand implements IProgressCommand, IStatusCommand {
	private IProgressMonitor progressMonitor = new NullProgressMonitor();
	private IStatus status = Status.CANCEL_STATUS;

	public JobCommand(String label) {
		super(label);
	}

	public JobCommand(String label, String description) {
		super(label, description);
	}

	public void setProgressMonitor(IProgressMonitor progressMonitor) {
		this.progressMonitor = progressMonitor;
	}

	@Override
	public IStatus getStatus() {
		return status;
	}

	@Override
	public final void execute() {
		try {
			status = doExecute(progressMonitor);
		} finally {
			// A progress monitor can only be used once
			progressMonitor = new NullProgressMonitor();
		}
	}

	protected abstract IStatus doExecute(IProgressMonitor monitor);

	@Override
	public void redo() {
		execute();
	}

	@Override
	public final void undo() {
		try {
			doUndo();
		} finally {
			status = Status.CANCEL_STATUS;
		}
	}

	protected void doUndo() {
		throw new UnsupportedOperationException(CommonPlugin.INSTANCE.getString("_EXC_Method_not_implemented",
				new String[] { this.getClass().getName() + ".undo()" }));
	}
}
