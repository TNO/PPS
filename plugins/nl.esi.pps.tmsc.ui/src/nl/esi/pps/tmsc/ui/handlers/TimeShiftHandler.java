/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */

package nl.esi.pps.tmsc.ui.handlers;

import static nl.esi.pps.tmsc.ui.Activator.getPluginID;
import static org.eclipse.core.runtime.IStatus.ERROR;
import static org.eclipse.lsat.common.queries.QueryableIterable.from;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;

import org.eclipse.core.resources.IFile;
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
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.lsat.common.emf.common.util.URIHelper;
import org.eclipse.lsat.common.emf.ecore.resource.Persistor;
import org.eclipse.lsat.common.emf.ecore.resource.PersistorFactory;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.SaveAsDialog;

import nl.esi.pps.common.core.runtime.ErrorStatusException;
import nl.esi.pps.common.core.runtime.FailOnErrorStatus;
import nl.esi.pps.common.core.runtime.jobs.IStatusJobFunction;
import nl.esi.pps.common.core.runtime.jobs.JobUtils;
import nl.esi.pps.common.ide.ui.jobs.StatusReportingJob;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.TmscPlugin;
import nl.esi.pps.tmsc.provider.TmscEditPlugin;
import nl.esi.pps.tmsc.util.TmscQueries;

public class TimeShiftHandler {
	@Evaluate
	@CanExecute
	public boolean canExecute(@Named(IServiceConstants.ACTIVE_SELECTION) @Optional IStructuredSelection selection) {
		if (selection == null || selection.isEmpty()) {
			return false;
		}
		return from((Iterable<?>) selection).forAll(e -> e instanceof IFile && TmscPlugin.isTmscFile((IFile) e));
	}

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SELECTION) IStructuredSelection selection,
			@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
		LinkedList<IFile> inputFiles = from((Iterable<?>) selection).objectsOfKind(IFile.class).asList();

		TimeShiftDialog inputDialog = new TimeShiftDialog(shell);
		if (inputDialog.open() == SaveAsDialog.CANCEL) {
			return;
		}

		IStatusJobFunction jobFunction = monitor -> doJob(inputFiles, inputDialog.getAmount(), inputDialog.getUnit(), monitor);
		String jobName = "Time-shifting TMSCs.";
		Collection<Integer> jobReportingSeverities = Arrays.asList(IStatus.INFO, IStatus.WARNING, IStatus.ERROR);
		Job job = new StatusReportingJob(jobName, jobFunction, getPluginID(), jobReportingSeverities,
				jobReportingSeverities);
		job.setUser(true);
		job.schedule();
	}

	private static IStatus doJob(List<IFile> inputFiles, long amount, TimeUnit unit, IProgressMonitor monitor)
			throws ErrorStatusException {
		SubMonitor subMonitor = SubMonitor.convert(monitor, (inputFiles.size() * 100) + 1);

		FailOnErrorStatus result = new FailOnErrorStatus(getPluginID(), "Time-shifted TMSCs.");
		result.setWarningMessage("Time-shifted TMSCs with warnings.");
		result.setErrorMessage("Failed to time-shift TMSCs.");

		long offset = TimeUnit.NANOSECONDS.convert(amount, unit);

		for (IFile inputFile : inputFiles) {
			Persistor<FullScopeTMSC> tmscPersistor = new PersistorFactory(TmscEditPlugin.createResourceSet())
					.getPersistor(FullScopeTMSC.class, true);

			FullScopeTMSC tmsc = null;
			try {
				Map<Object, Object> loadOptions = new HashMap<>();
				loadOptions.put(IProgressMonitor.class, subMonitor.split(45));
				tmsc = tmscPersistor.loadOne(URIHelper.asURI(inputFile), loadOptions);
			} catch (IOException e) {
				result.add(new Status(ERROR, getPluginID(),
						String.format("Failed to load %s: %s", inputFile, e.getMessage()), e));
			}

			subMonitor.split(10);
			subMonitor.subTask(String.format("Applying time-shift of %d %s", amount, unit.name().toLowerCase()));
			TmscQueries.shiftTime(tmsc, offset);
			subMonitor.subTask("");

			try {
				Map<Object, Object> saveOptions = new HashMap<>();
				saveOptions.put(IProgressMonitor.class, subMonitor.split(45));
				tmsc.eResource().save(saveOptions);
			} catch (IOException ex) {
				result.add(new Status(ERROR, getPluginID(), "Failed to save TMSC.", ex));
			}
		}
		JobUtils.refreshWorkspaceProjects(inputFiles, subMonitor.split(1));

		return result;
	}
}