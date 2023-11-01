/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.analysis.ui.handlers;

import static nl.esi.pps.common.ide.ui.jobs.StatusReportingJob.DEFAULT_LOG_SEVERITIES;
import static nl.esi.pps.tmsc.analysis.ui.Activator.getPluginID;
import static org.eclipse.core.runtime.IStatus.ERROR;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
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
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.lsat.common.emf.common.util.URIHelper;
import org.eclipse.lsat.common.emf.ecore.resource.Persistor;
import org.eclipse.lsat.common.emf.ecore.resource.PersistorFactory;

import nl.esi.pps.common.core.runtime.ErrorStatusException;
import nl.esi.pps.common.core.runtime.FailOnErrorStatus;
import nl.esi.pps.common.core.runtime.jobs.IStatusJobFunction;
import nl.esi.pps.common.core.runtime.jobs.JobUtils;
import nl.esi.pps.common.ide.ui.jobs.StatusReportingJob;
import nl.esi.pps.preferences.PPSPreferences;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.ScopedTMSC;
import nl.esi.pps.tmsc.TMSC;
import nl.esi.pps.tmsc.TmscPlugin;
import nl.esi.pps.tmsc.analysis.CreateIPCScope;
import nl.esi.pps.tmsc.rendering.plot.ScopesRenderingStrategy;

public class CreateIPCScopeHandler extends CreateScopedTMSCCommandHandler {
	public CreateIPCScopeHandler() {
		super("create IPC scope", ScopesRenderingStrategy.ID);
	}

	@Evaluate
	@CanExecute
	public boolean canExecute(@Named(IServiceConstants.ACTIVE_SELECTION) @Optional IStructuredSelection selection) {
		if (!PPSPreferences.isAdvancedFeaturesEnabled() || selection == null || selection.size() != 1) {
			return false;
		}
		Object selectedElement = selection.getFirstElement();
		if (selectedElement instanceof TMSC) {
			return AdapterFactoryEditingDomain.getEditingDomainFor(selectedElement) != null;
		} else if (selectedElement instanceof IFile) {
			return TmscPlugin.isTmscFile((IFile) selectedElement);
		}
		return false;
	}

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SELECTION) IStructuredSelection selection) {
		Object selectedElement = selection.getFirstElement();
		if (selectedElement instanceof TMSC) {
			TMSC tmsc = (TMSC) selectedElement;
			executeCommand(tmsc, (status, monitor) -> {
				CreateIPCScope createIpcScope = new CreateIPCScope();
				ScopedTMSC ipcScope = createIpcScope.createIPCScope(tmsc, monitor);
				status.addAll(createIpcScope.getStatus());
				return ipcScope;
			});
		} else if (selectedElement instanceof IFile) {
			IFile modelIFile = (IFile) selectedElement;
			IStatusJobFunction jobFunction = monitor -> doJob(modelIFile, monitor);
			Job job = new StatusReportingJob(commandName, jobFunction, getPluginID(), DEFAULT_DIALOG_SEVERITIES,
					DEFAULT_LOG_SEVERITIES);
			job.setUser(true);
			job.schedule();
		}
	}
	
	private static IStatus doJob(IFile modelIFile, IProgressMonitor monitor) throws ErrorStatusException {
		SubMonitor subMonitor = SubMonitor.convert(monitor, 100);
		subMonitor.setTaskName("Create IPC scope.");

		FailOnErrorStatus result = new FailOnErrorStatus(getPluginID(), "Create IPC scope");
		result.setErrorMessage("Failed to create IPC scope.");

		URI loadUri = URIHelper.asURI(modelIFile);
		Persistor<FullScopeTMSC> persistor = new PersistorFactory().getPersistor(FullScopeTMSC.class, true);
		
		FullScopeTMSC tmsc = null;
		try {
			subMonitor.setTaskName("Loading TMSC from " + loadUri.lastSegment());
			Map<Object, Object> loadOptions = new HashMap<>();
			loadOptions.put(IProgressMonitor.class, subMonitor.split(10));
			tmsc = persistor.loadOne(loadUri, loadOptions);
		} catch (IOException ex) {
			result.add(new Status(ERROR, getPluginID(),
					String.format("Failed to load %s: %s", modelIFile, ex.getMessage()), ex));
		}

		subMonitor.setTaskName("Creating IPC scope");
		CreateIPCScope createIpcScope = new CreateIPCScope();
		ScopedTMSC ipcScope = createIpcScope.createIPCScope(tmsc, subMonitor.split(80));
		result.add(createIpcScope.getStatus());
		tmsc.getChildScopes().add(ipcScope);
		tmsc.getDependencies().addAll(ipcScope.getDependencies());
		
		subMonitor.setTaskName("Saving IPC scope");
		String saveBaseName = loadUri.trimFileExtension().lastSegment() + "_" + ipcScope.getName().toLowerCase();
		IFile saveIFile = JobUtils.getSibling(modelIFile, saveBaseName, null);
		result.add(SaveScopedTmscHandler.doJob(Collections.singletonList(ipcScope), saveIFile, subMonitor.split(10)));

		return result;
	}
}
