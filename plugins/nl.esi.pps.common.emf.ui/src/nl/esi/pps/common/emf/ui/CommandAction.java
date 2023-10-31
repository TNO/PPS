/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.common.emf.ui;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;

public abstract class CommandAction extends Action {
	private final EditingDomain editingDomain;
	
	public CommandAction(EditingDomain editingDomain, String text, ImageDescriptor image, int style) {
		super(text, style);
		setImageDescriptor(image);
		this.editingDomain = editingDomain;
	}
	
	public EditingDomain getEditingDomain() {
		return editingDomain;
	}
	
	
	protected void preExecute() {
		// Empty, may be overwritten by subclasses
	}
	
	protected abstract IStatus execute(IProgressMonitor monitor);
	
	protected void postExecute(IStatus result) {
		// Empty, may be overwritten by subclasses
	}
	
	@Override
	public boolean isEnabled() {
		return super.isEnabled() && null != editingDomain;
	}
	
	@Override
	public void run() {
		Job actionJob = new Job(getText()) {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				final ProgressCommand command = new ProgressCommand(getText(), getDescription(), monitor);
				getEditingDomain().getCommandStack().execute(command);
				return (IStatus) command.getResult().iterator().next();
			}
		};
		actionJob.addJobChangeListener(new JobChangeAdapter() {
			@Override
			public void aboutToRun(IJobChangeEvent event) {
				preExecute();
			}
			
			@Override
			public void done(IJobChangeEvent event) {
				postExecute(event.getResult());
			}
		});
		actionJob.setUser(true);
		actionJob.schedule();
	}
	
	protected class ProgressCommand extends AbstractCommand {
		private final IProgressMonitor monitor;
		
		private IStatus result;
		
		public ProgressCommand(String label, String description, IProgressMonitor monitor) {
			super(label, description);
			this.monitor = monitor;
		}
		
		@Override
		protected boolean prepare() {
			return true;
		}

		@Override
		public void execute() {
			try {
				result = CommandAction.this.execute(monitor);
			} catch (OperationCanceledException e) {
				result = Status.CANCEL_STATUS;
			} catch (RuntimeException e) {
				result = new Status(Status.ERROR, "nl.esi.pps.common.emf.ui", "Failed to execute command: " + e.getMessage(), e);
			}
		}
		
		@Override
		public Collection<?> getResult() {
			return Arrays.asList(result);
		}
		
		@Override
		public void redo() {
			throw new UnsupportedOperationException();
		}
		
		@Override
		public boolean canUndo() {
			return false;
		}
	}
}
