/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.ui.handlers;

import static nl.esi.pps.common.ide.ui.jobs.StatusReportingJob.DEFAULT_LOG_SEVERITIES;

import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import nl.esi.pps.common.core.runtime.jobs.IStatusJobFunction;
import nl.esi.pps.common.ide.ui.jobs.StatusReportingJob;

import nl.esi.pps.ui.commands.IProgressCommand;
import nl.esi.pps.ui.commands.IStatusCommand;

public abstract class AbstractCommandHandler {
	public static final Collection<Integer> DEFAULT_DIALOG_SEVERITIES = Arrays.asList(IStatus.INFO, IStatus.WARNING, IStatus.ERROR);
	
	protected void executeCommand(Command command, EditingDomain editingDomain) {
		final Bundle bundle = FrameworkUtil.getBundle(getClass());
		executeCommand(command, editingDomain, bundle == null ? "nl.esi.pps.tmsc.ui" : bundle.getSymbolicName());
	}

	protected void executeCommand(Command command, EditingDomain editingDomain, String pluginID) {
		IStatusJobFunction jobFunction = monitor -> doExecuteCommand(command, editingDomain, pluginID, monitor);
		Job job = new StatusReportingJob(StringUtils.capitalize(command.getLabel()), jobFunction, pluginID,
				DEFAULT_DIALOG_SEVERITIES, DEFAULT_LOG_SEVERITIES);
		job.setUser(true);
		job.schedule();
	}

	private static IStatus doExecuteCommand(Command command, EditingDomain editingDomain, String pluginID,
			IProgressMonitor monitor) {
		if (editingDomain == null) {
			return new Status(Status.ERROR, pluginID,
					String.format("Cannot execute command: %s. Editing domain not found.", command.getLabel()));
		}

		if (command instanceof IProgressCommand) {
			((IProgressCommand) command).setProgressMonitor(monitor);
		} else {
			monitor.beginTask(StringUtils.capitalize(command.getLabel()), IProgressMonitor.UNKNOWN);
		}

		if (command.canExecute()) {
			editingDomain.getCommandStack().execute(command);
		} else {
			return new Status(Status.ERROR, pluginID, String.format("Cannot execute command: %s.", command.getLabel()));
		}

		return command instanceof IStatusCommand ? ((IStatusCommand) command).getStatus() : Status.OK_STATUS;
	}
}
