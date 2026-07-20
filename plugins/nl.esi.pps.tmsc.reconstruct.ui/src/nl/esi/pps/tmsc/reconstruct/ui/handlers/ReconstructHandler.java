/*
 * Copyright (c) 2018-2026 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.reconstruct.ui.handlers;

import static org.eclipse.core.runtime.IStatus.ERROR;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Named;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
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

import nl.esi.pps.common.core.runtime.ErrorStatusException;
import nl.esi.pps.common.core.runtime.FailOnErrorStatus;
import nl.esi.pps.common.core.runtime.jobs.JobUtils;
import nl.esi.pps.common.ide.ui.jobs.StatusReportingJob;
import nl.esi.pps.tmsc.TmscPlugin;
import nl.esi.pps.tmsc.reconstruct.TmscTraceParser;
import nl.esi.pps.tmsc.reconstruct.TmscTraceReconstructor;

public class ReconstructHandler {
	private static final String PLUGIN_ID = "nl.esi.pps.tmsc.reconstruct.ui";

	@Evaluate
	@CanExecute
	public boolean canExecute(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) IStructuredSelection selection) {
		if (selection == null || selection.size() != 1) {
			return false;
		}
		Object selectedElement = selection.getFirstElement();
		if (selectedElement instanceof IFile selectedFile) {
			String fileExtension = selectedFile.getFileExtension();
			return "tmsctrace".equals(fileExtension);
		}
		return false;
	}

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SELECTION) IStructuredSelection selection,
			@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
		IFile tmsctraceFile = (IFile) selection.getFirstElement();
		StatusReportingJob.runUserJob("Reconstruct TMSC", monitor -> reconstruct(tmsctraceFile, monitor), PLUGIN_ID);
	}

	private static IStatus reconstruct(IFile traceIFile, IProgressMonitor monitor) throws ErrorStatusException {
		SubMonitor subMonitor = SubMonitor.convert(monitor, 101);
		subMonitor.setTaskName("Reconstructing TMSC...");

		FailOnErrorStatus result = new FailOnErrorStatus(PLUGIN_ID, "Reconstructed TMSC");
		result.setWarningMessage("Reconstructed TMSC with warnings.");
		result.setErrorMessage("Failed to reconstructed TMSC");

		TmscTraceReconstructor reconstructor = new TmscTraceReconstructor();
		try {
			TmscTraceParser.parse(traceIFile.getContents(), reconstructor);
			subMonitor.worked(50);
		} catch (Exception e) {
			result.add(new Status(ERROR, PLUGIN_ID,
					String.format("Failed to parse %s: %s", traceIFile.getFullPath(), e.getMessage()), e));
		}

		// Saving models to file
		IFile tmscIFile = JobUtils.getSibling(traceIFile, null, TmscPlugin.TMSC_FILE_EXTENSION_BINARY_COMPRESSED);
		Persistor<?> persistor = new PersistorFactory().getPersistor();
		try {
			Map<Object, Object> saveOptions = new HashMap<>();
			saveOptions.put(IProgressMonitor.class, subMonitor.split(50));
			persistor.save(URIHelper.asURI(tmscIFile), saveOptions, reconstructor.getTmsc(),
					reconstructor.getArchitecture());
		} catch (IOException e) {
			result.add(new Status(ERROR, PLUGIN_ID,
					String.format("Failed to save %s: %s", tmscIFile.getFullPath(), e.getMessage()), e));
		}

		// Refresh workspace to view created file
		JobUtils.refreshWorkspaceProjects(subMonitor.split(1), traceIFile);

		return result;
	}
}