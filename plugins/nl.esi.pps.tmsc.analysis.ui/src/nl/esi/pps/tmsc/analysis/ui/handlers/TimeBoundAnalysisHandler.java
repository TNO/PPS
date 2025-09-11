/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
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

import java.text.ParseException;

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
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;

import nl.esi.pps.common.core.runtime.jobs.IStatusJobFunction;
import nl.esi.pps.common.emf.edit.ui.provider.FormatInputValidator;
import nl.esi.pps.common.ide.ui.jobs.StatusReportingJob;
import nl.esi.pps.preferences.PPSPreferences;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.analysis.ui.commands.DefaultTimeBoundAnalysisCommand;
import nl.esi.pps.tmsc.text.EDurationFormat;
import nl.esi.pps.ui.handlers.AbstractCommandHandler;

public class TimeBoundAnalysisHandler extends AbstractCommandHandler {

	@Evaluate
	@CanExecute
	public boolean canExecute(@Named(IServiceConstants.ACTIVE_SELECTION) @Optional IStructuredSelection selection) {
		if (!PPSPreferences.isAdvancedFeaturesEnabled() || selection == null || selection.size() != 1) {
			return false;
		}
		final Object selectedElement = selection.getFirstElement();
		final EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(selectedElement);

		return editingDomain != null && selectedElement instanceof FullScopeTMSC;
	}

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SELECTION) IStructuredSelection selection,
			@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
		final FullScopeTMSC tmsc = (FullScopeTMSC) selection.getFirstElement();
		EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(tmsc);

		InputDialog inputDialog = new InputDialog(shell, "Time-bound Analysis",
				"Please specify the default time-bound:", "0", new FormatInputValidator(EDurationFormat.eINSTANCE));
		if (inputDialog.open() != InputDialog.OK) {
			return;
		}

		IStatusJobFunction jobFunction = monitor -> doJob(tmsc, inputDialog.getValue(), editingDomain, monitor);
		String jobName = "Time-bound analysis";
		Job job = new StatusReportingJob(jobName, jobFunction, getPluginID(), DEFAULT_DIALOG_SEVERITIES,
				DEFAULT_LOG_SEVERITIES);
		job.setUser(true);
		job.schedule();
	}

	private static IStatus doJob(FullScopeTMSC tmsc, String defaultTimeBoundStr, EditingDomain editingDomain,
			IProgressMonitor monitor) {
		SubMonitor subMonitor = SubMonitor.convert(monitor, 100);
		subMonitor.setTaskName("Time-bound analysis.");

		try {
			Long defaultTimeBound = EDurationFormat.eINSTANCE.parse(defaultTimeBoundStr);

			DefaultTimeBoundAnalysisCommand command = new DefaultTimeBoundAnalysisCommand(tmsc, defaultTimeBound);
			;
			if (command.canExecute()) {
				editingDomain.getCommandStack().execute(command);
			} else {
				return new Status(Status.ERROR, getPluginID(), "Time-bound analysis cannot be performed.");
			}
		} catch (ParseException e) {
			return new Status(Status.ERROR, getPluginID(), "Failed to parse default time-bound: " + e.getMessage(), e);
		}
		return Status.OK_STATUS;
	}
}