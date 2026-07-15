/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
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
import static org.eclipse.core.runtime.IStatus.INFO;
import static org.eclipse.lsat.common.queries.QueryableIterable.from;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
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
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.lsat.common.emf.common.util.URIHelper;
import org.eclipse.lsat.common.emf.ecore.resource.Persistor;
import org.eclipse.lsat.common.emf.ecore.resource.PersistorFactory;
import org.eclipse.lsat.common.util.IterableUtil;

import nl.esi.pps.common.core.runtime.ErrorStatusException;
import nl.esi.pps.common.core.runtime.FailOnErrorStatus;
import nl.esi.pps.common.core.runtime.jobs.IStatusJobFunction;
import nl.esi.pps.common.core.runtime.jobs.JobUtils;
import nl.esi.pps.common.ide.ui.jobs.StatusReportingJob;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.TmscPlugin;
import nl.esi.pps.tmsc.provider.TmscEditPlugin;
import nl.esi.pps.tmsc.util.TmscQueries;

public class RelativeTimeHandler {
	@Evaluate
	@CanExecute
	public boolean canExecute(@Named(IServiceConstants.ACTIVE_SELECTION) @Optional IStructuredSelection selection) {
		if (selection == null || selection.isEmpty()) {
			return false;
		}
		return from((Iterable<?>) selection).forAll(e -> e instanceof IFile && TmscPlugin.isTmscFile((IFile) e));
	}

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SELECTION) IStructuredSelection selection) {
		LinkedList<IFile> inputFiles = from((Iterable<?>) selection).objectsOfKind(IFile.class).asList();

		IStatusJobFunction jobFunction = monitor -> doJob(inputFiles, monitor);
		String jobName = "Converting TMSCs to relative time.";
		Job job = new StatusReportingJob(jobName, jobFunction, getPluginID());
		job.setUser(true);
		job.schedule();
	}

	private static IStatus doJob(List<IFile> inputFiles, IProgressMonitor monitor)
			throws ErrorStatusException {
		SubMonitor subMonitor = SubMonitor.convert(monitor, (inputFiles.size() * 100) + 1);

		FailOnErrorStatus result = new FailOnErrorStatus(getPluginID(), "Convert TMSCs to relative time.");
		result.setWarningMessage("Converted TMSCs to relative time with warnings.");
		result.setErrorMessage("Failed to convert TMSCs to relative time.");

		for (IFile inputFile : inputFiles) {
			Persistor<FullScopeTMSC> tmscPersistor = new PersistorFactory(TmscEditPlugin.createResourceSet())
					.getPersistor(FullScopeTMSC.class, true);
			URI loadURI = URIHelper.asURI(inputFile);
			URI saveURI = loadURI.trimSegments(1).appendSegment(URIHelper.baseName(loadURI) + "_relative")
					.appendFileExtension(loadURI.fileExtension());

			List<FullScopeTMSC> tmscs = null;
			try {
				Map<Object, Object> loadOptions = new HashMap<>();
				loadOptions.put(IProgressMonitor.class, subMonitor.split(45));
				tmscs = tmscPersistor.loadAll(URIHelper.asURI(inputFile), loadOptions);
			} catch (IOException e) {
				result.add(new Status(ERROR, getPluginID(),
						String.format("Failed to load %s: %s", inputFile, e.getMessage()), e));
			}

			long offset = IterableUtil.min(from(tmscs).xcollectOne(FullScopeTMSC::getStartTime), Long.MIN_VALUE);
			if (offset > 0 && from(tmscs).forAll(FullScopeTMSC::isEpochTime)) {
				subMonitor.split(10);
				subMonitor.subTask("Converting TMSC to relative time");
				tmscs.forEach(tmsc -> {
					TmscQueries.shiftTime(tmsc, -offset);
					tmsc.setEpochTime(false);
				});
				subMonitor.subTask("");
			} else {
				result.add(new Status(INFO, getPluginID(),
						String.format("Skipped '%s', as TMSC is already relative.", loadURI.lastSegment())));
				subMonitor.worked(55);
				continue;
			}
			
			try {
				Map<Object, Object> saveOptions = new HashMap<>();
				saveOptions.put(IProgressMonitor.class, subMonitor.split(45));
				tmscPersistor.save(saveURI, saveOptions, tmscs.getFirst().eResource().getContents());
			} catch (IOException ex) {
				result.add(new Status(ERROR, getPluginID(), "Failed to save TMSC.", ex));
			}
		}
		JobUtils.refreshWorkspaceProjects(inputFiles, subMonitor.split(1));

		return result;
	}
}