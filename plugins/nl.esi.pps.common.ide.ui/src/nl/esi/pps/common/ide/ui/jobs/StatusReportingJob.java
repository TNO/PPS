/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.ide.ui.jobs;

import static nl.esi.pps.common.core.runtime.StatusUtils.filter;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.core.runtime.jobs.JobGroup;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import nl.esi.pps.common.core.runtime.jobs.IStatusJobFunction;
import nl.esi.pps.common.core.runtime.jobs.StatusJob;
import nl.esi.pps.common.ide.ui.Activator;
import nl.esi.pps.common.ide.ui.status.StatusDialog;
import nl.esi.pps.common.ide.ui.viewers.TreeColumnModelViewer;

/**
 * A {@link StatusJob} that allows reports the job result using a
 * {@link MessageDialog} as well as the Eclipse error log. This differs from
 * standard jobs, that only show a dialog when the job has an error result
 * status.
 */
public class StatusReportingJob extends StatusJob {
	public static final Collection<Integer> DEFAULT_SHOW_DIALOG_SEVERITIES = Collections
			.unmodifiableCollection(Arrays.asList(IStatus.OK, IStatus.INFO, IStatus.WARNING, IStatus.ERROR));

	public static final Collection<Integer> DEFAULT_LOG_SEVERITIES = Collections
			.unmodifiableCollection(Arrays.asList(IStatus.WARNING, IStatus.ERROR));

	/** The plug-in ID to use. */
	protected final String pluginId;

	/**
	 * The severity levels for which to show a dialog on job completion.
	 *
	 * @see IStatus#getSeverity
	 */
	protected final Collection<Integer> showDialogSeverities;

	/**
	 * The severity levels for which to log the job result.
	 *
	 * @see IStatus#getSeverity
	 */
	protected final Collection<Integer> logSeverities;

	/**
	 * Status reporting job. Reports status using a dialog for all outcomes except
	 * cancellation. Logs the job result for error and warning outcomes.
	 *
	 * @param name     The name of the job.
	 * @param function The function to execute for the job.
	 * @param pluginId The plug-in ID to use.
	 */
	public StatusReportingJob(String name, IStatusJobFunction function, String pluginId) {
		this(name, function, pluginId, DEFAULT_SHOW_DIALOG_SEVERITIES, DEFAULT_LOG_SEVERITIES);
	}

	/**
	 * Status reporting job. Reports status using a dialog and/or logs the job
	 * result.
	 *
	 * @param name                 The name of the job.
	 * @param function             The function to execute for the job.
	 * @param pluginId             The plug-in ID to use.
	 * @param showDialogSeverities The severity levels for which to show a dialog on
	 *                             job completion. See {@link IStatus#getSeverity}.
	 * @param logSeverities        The severity levels for which to log the job
	 *                             result. See {@link IStatus#getSeverity}.
	 */
	public StatusReportingJob(String name, IStatusJobFunction function, String pluginId,
			Collection<Integer> showDialogSeverities, Collection<Integer> logSeverities) {
		super(name, function);
		this.pluginId = pluginId;
		this.showDialogSeverities = showDialogSeverities;
		this.logSeverities = logSeverities;

		configureJob();
	}

	protected void configureJob() {
		// Show dialog, as configured, not just for errors. Log, as configured, not just
		// warnings/errors.
		addJobChangeListener(new JobChangeAdapter() {
			@Override
			public void done(IJobChangeEvent event) {
				IStatus result = event.getResult();
				if (logSeverities.contains(result.getSeverity())) {
					logJobResult(filter(result, s -> logSeverities.contains(s.getSeverity())));
				}
				if (showDialogSeverities.contains(result.getSeverity())) {
					showJobResultDialog(filter(result, s -> showDialogSeverities.contains(s.getSeverity())));
				}
			}
		});

		// Suppress errors by returning an empty MultiStatus with OK severity for the
		// job group.
		// We already report it, no need for standard Eclipse reporting. Avoid duplicate
		// dialogs on error results.
		setJobGroup(new JobGroup(getName(), 1, 1) {
			@Override
			protected MultiStatus computeGroupResult(List<IStatus> jobResults) {
				return new MultiStatus(pluginId, IStatus.OK, getName(), null);
			}
		});
	}

	protected void logJobResult(IStatus result) {
		Activator.getDefault().getLog().log(result);
	}

	protected void showJobResultDialog(IStatus result) {
		if (PlatformUI.isWorkbenchRunning()) {
			PlatformUI.getWorkbench().getDisplay().asyncExec(() -> {
				Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				StatusDialog statusDialog = new StatusDialog(shell, getName(), result) {
					@Override
					protected boolean isModal() {
						return false;
					}

					@Override
					protected boolean isResizable() {
						return true;
					}

					@Override
					protected TreeColumnModelViewer createStatusViewer(Composite parent) {
						TreeColumnModelViewer statusViewer = super.createStatusViewer(parent);
						statusViewer.expandAll();
						return statusViewer;
					}
				};
				statusDialog.setBlockOnOpen(false);
				statusDialog.open();
			});
		} else {
			Activator.getDefault().getLog().log(result);
		}
	}
}
