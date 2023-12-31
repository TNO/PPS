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
import static org.eclipse.core.runtime.IStatus.ERROR;
import static org.eclipse.lsat.common.queries.QueryableIterable.from;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.lsat.common.emf.common.util.URIHelper;
import org.eclipse.lsat.common.emf.ecore.resource.Persistor;
import org.eclipse.lsat.common.emf.ecore.resource.PersistorFactory;
import org.eclipse.lsat.common.queries.QueryableIterable;

import nl.esi.pps.common.core.runtime.ErrorStatusException;
import nl.esi.pps.common.core.runtime.FailOnErrorStatus;
import nl.esi.pps.common.core.runtime.jobs.IStatusJobFunction;
import nl.esi.pps.common.core.runtime.jobs.JobUtils;
import nl.esi.pps.common.ide.ui.jobs.StatusReportingJob;
import nl.esi.pps.preferences.PPSPreferences;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.TmscPlugin;
import nl.esi.pps.tmsc.analysis.NormalizeTiming;

public class NormalizeTimingHandler {
	@Evaluate
	@CanExecute
	public boolean canExecute(@Named(IServiceConstants.ACTIVE_SELECTION) @Optional IStructuredSelection selection) {
		if (selection == null || selection.size() != 1 || !PPSPreferences.isAdvancedFeaturesEnabled()) {
			return false;
		}
		return from((Iterable<?>) selection).forAll(e -> e instanceof IFile && TmscPlugin.isTmscFile((IFile) e));
	}

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SELECTION) IStructuredSelection selection) {
		IFile modelIFile = (IFile) selection.getFirstElement();
		IStatusJobFunction jobFunction = monitor -> doJob(modelIFile, monitor);
		String jobName = "Normalize timing";
		Job job = new StatusReportingJob(jobName, jobFunction, getPluginID(), DEFAULT_DIALOG_SEVERITIES,
				DEFAULT_LOG_SEVERITIES);
		job.setUser(true);
		job.schedule();
	}

	public static IStatus doJob(IFile modelIFile, IProgressMonitor monitor) throws ErrorStatusException {
		SubMonitor subMonitor = SubMonitor.convert(monitor, 101);
		subMonitor.setTaskName("Normalize timing.");

		FailOnErrorStatus result = new FailOnErrorStatus(getPluginID(), "Normalize timing");
		result.setErrorMessage("Failed to normalize timing.");

		URI loadUri = URIHelper.asURI(modelIFile);
		Persistor<EObject> persistor = new PersistorFactory().getPersistor();
		
		List<EObject> contents = null;
		try {
			subMonitor.setTaskName("Loading TMSC from " + loadUri.lastSegment());
			Map<Object, Object> loadOptions = new HashMap<>();
			loadOptions.put(IProgressMonitor.class, subMonitor.split(25));
			contents = persistor.loadAll(loadUri, loadOptions);
		} catch (IOException ex) {
			result.add(new Status(ERROR, getPluginID(),
					String.format("Failed to load %s: %s", modelIFile, ex.getMessage()), ex));
		}

		subMonitor.setTaskName("Normalize timing of TMSC");
		subMonitor.split(50);
		QueryableIterable.from(contents)
			.objectsOfKind(FullScopeTMSC.class)
			.forEach(NormalizeTiming::normalizeTiming);
		
		String fileExtension = loadUri.fileExtension();
		URI saveUri = loadUri.trimFileExtension().appendFileExtension("normalized").appendFileExtension(fileExtension);
		try {
			subMonitor.setTaskName("Saving TMSC to " + saveUri.lastSegment());
			Map<Object, Object> saveOptions = new HashMap<>();
			saveOptions.put(IProgressMonitor.class, subMonitor.split(25));
			persistor.save(saveUri, saveOptions, contents);
		} catch (IOException ex) {
			result.add(new Status(ERROR, getPluginID(),
					String.format("Failed to save %s: %s", saveUri, ex.getMessage()), ex));
		}
		
		JobUtils.refreshWorkspaceProjects(subMonitor.split(1), modelIFile);

		return result;
	}
}
