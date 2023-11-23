/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.analysis.ui.handlers;

import static nl.esi.pps.common.ide.ui.jobs.StatusReportingJob.DEFAULT_LOG_SEVERITIES;
import static nl.esi.pps.tmsc.analysis.ui.Activator.getPluginID;
import static nl.esi.pps.ui.handlers.AbstractCommandHandler.DEFAULT_DIALOG_SEVERITIES;

import javax.inject.Named;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Evaluate;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.IStructuredSelection;

import nl.esi.pps.common.core.runtime.jobs.IStatusJobFunction;
import nl.esi.pps.common.ide.ui.jobs.StatusReportingJob;

import nl.esi.pps.tmsc.TMSC;
import nl.esi.pps.tmsc.analysis.ui.commands.SlackAnalysisCommand;

public class SlackAnalysisHandler {
	@Evaluate
	@CanExecute
	public boolean canExecute(@Named(IServiceConstants.ACTIVE_SELECTION) @Optional IStructuredSelection selection) {
		if (selection == null || selection.size() != 1) {
			return false;
		}
		final Object selectedElement = selection.getFirstElement();
		final EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(selectedElement);

		return editingDomain != null && selectedElement instanceof TMSC;
	}

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SELECTION) IStructuredSelection selection) {
		final TMSC tmsc = (TMSC) selection.getFirstElement();
		EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(tmsc);

		IStatusJobFunction jobFunction = monitor -> doJob(tmsc, editingDomain, monitor);
		String jobName = "Slack analysis";
		Job job = new StatusReportingJob(jobName, jobFunction, getPluginID(), DEFAULT_DIALOG_SEVERITIES,
				DEFAULT_LOG_SEVERITIES);
		job.setUser(true);
		job.schedule();
	}

	public static IStatus doJob(TMSC tmsc, EditingDomain editingDomain, IProgressMonitor monitor) {
		SubMonitor subMonitor = SubMonitor.convert(monitor, 100);
		subMonitor.setTaskName("Slack analysis.");

		SlackAnalysisCommand command = new SlackAnalysisCommand(tmsc);
		if (command.canExecute()) {
			editingDomain.getCommandStack().execute(command);
		} else {
			return new Status(Status.ERROR, getPluginID(), "Slack analysis cannot be performed.");
		}
		return Status.OK_STATUS;
	}
}
