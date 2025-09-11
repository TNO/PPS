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
import static nl.esi.pps.ui.handlers.AbstractCommandHandler.DEFAULT_DIALOG_SEVERITIES;
import static org.eclipse.core.runtime.IStatus.ERROR;
import static org.eclipse.lsat.common.queries.QueryableIterable.from;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.lsat.common.emf.common.util.URIHelper;
import org.eclipse.lsat.common.emf.ecore.resource.Persistor;
import org.eclipse.lsat.common.emf.ecore.resource.PersistorFactory;
import org.eclipse.lsat.common.queries.QueryableIterable;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.SaveAsDialog;

import nl.esi.pps.common.core.runtime.jobs.IStatusJobFunction;
import nl.esi.pps.common.core.runtime.jobs.JobUtils;
import nl.esi.pps.common.ide.ui.jobs.StatusReportingJob;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.ScopedTMSC;
import nl.esi.pps.tmsc.TmscPlugin;
import nl.esi.pps.tmsc.metric.MetricModel;
import nl.esi.pps.tmsc.rendering.RenderingProperties;
import nl.esi.pps.tmsc.rendering.plot.ScopesRenderingStrategy;
import nl.esi.pps.tmsc.util.ScopedTmscCopier;

public class SaveScopedTmscHandler {
	@Evaluate
	@CanExecute
	public boolean canExecute(@Named(IServiceConstants.ACTIVE_SELECTION) @Optional IStructuredSelection selection) {
		if (selection == null || selection.isEmpty()) {
			return false;
		}
		// Casting required for Java generics
		QueryableIterable<?> queryableSelection = from((Iterable<?>) selection);
		// Selection should be all ScopedTMSCs that share the same full scope
		return queryableSelection.forAll(s -> s instanceof ScopedTMSC) && queryableSelection
				.objectsOfKind(ScopedTMSC.class).collectOne(ScopedTMSC::getFullScope).asSet().size() == 1;
	}

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SELECTION) IStructuredSelection selection, 
			@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
		List<ScopedTMSC> scopedTmscs = from((Iterable<?>) selection).asType(ScopedTMSC.class).asList();
		ScopedTMSC firstTmsc = (ScopedTMSC) selection.getFirstElement();
		URI tmscURI = firstTmsc.eResource().getURI();
		IFile tmscIFile = (IFile) URIHelper.asIResource(tmscURI);
		String suggestFileName = StringUtils.getCommonPrefix(from(scopedTmscs).collectOne(ScopedTMSC::getName).toArray(String.class));
		if (suggestFileName == null || suggestFileName.isEmpty()) {
			suggestFileName = scopedTmscs.size() + "_scopes";
		}
		
		SaveAsDialog saveAsDialog = new SaveAsDialog(shell);
		saveAsDialog.setOriginalFile(
				tmscIFile.getParent().getFile(new Path(suggestFileName + '.' + tmscURI.fileExtension())));
		if (saveAsDialog.open() != SaveAsDialog.OK) {
			return;
		}
		IPath saveIPath = saveAsDialog.getResult();
		if (!TmscPlugin.isTmscFileExtension(saveIPath.getFileExtension())) {
			saveIPath.addFileExtension(TmscPlugin.TMSC_FILE_EXTENSION_BINARY_COMPRESSED);
		}
		IFile saveIFile = ResourcesPlugin.getWorkspace().getRoot().getFile(saveIPath);
		
		IStatusJobFunction jobFunction = monitor -> doJob(scopedTmscs, saveIFile, monitor);
		String jobName = "Save scoped TMSC";
		Job job = new StatusReportingJob(jobName, jobFunction, getPluginID(), DEFAULT_DIALOG_SEVERITIES,
				DEFAULT_LOG_SEVERITIES);
		job.setUser(true);
		job.schedule();
	}

	public static IStatus doJob(List<ScopedTMSC> scopedTmscs, IFile saveIFile, IProgressMonitor monitor) {
		SubMonitor subMonitor = SubMonitor.convert(monitor, 101);
		
		FullScopeTMSC fullScope = scopedTmscs.get(0).getFullScope();
		
		subMonitor.setTaskName("Prepare to copy scoped TMSC.");
		EObject[] otherRootContainers = ScopedTmscCopier.findOtherRootContainersToCopy(scopedTmscs,
				MetricModel.class::isInstance);

		subMonitor.setTaskName("Copy scoped TMSC.");
		Map<EObject, EObject> copies = ScopedTmscCopier.copyTmscs(scopedTmscs, otherRootContainers);
		
		// Now create the content to save, i.e. the root container of our scopedTmsc copy and 
		// the copies of all otherRootContainers
		FullScopeTMSC fullScopeCopy = (FullScopeTMSC) copies.get(fullScope);
		EObject[] saveContent = new EObject[otherRootContainers.length + 1];
		saveContent[0] = EcoreUtil.getRootContainer(fullScopeCopy);
		for (int i = 0; i < otherRootContainers.length; i++) {
			saveContent[i + 1] = copies.get(otherRootContainers[i]);
		}
		subMonitor.worked(75);
		
		// (Optional) Derive the new start and end time of the copied trace from the TMSC that we actually copied
		Set<ScopedTMSC> copiedScopes = from(scopedTmscs).collectOne(copies::get).asType(ScopedTMSC.class).asSet();
		ScopedTmscCopier.deriveStartEndTime(copiedScopes);
		
		// (Optional) Typically we want to visualize the copied scope, so apply a rendering strategy
		from(fullScopeCopy.getChildScopes()).walkTree(true, ScopedTMSC::getChildScopes).forEach(
				scope -> ScopesRenderingStrategy.setGroupKey(scope, copiedScopes.contains(scope)));
		RenderingProperties.setRenderingStrategyID(fullScopeCopy, ScopesRenderingStrategy.ID);
		
		subMonitor.setTaskName("Save scoped TMSC.");
		Persistor<EObject> persistor = new PersistorFactory().getPersistor();
		URI saveUri = URIHelper.asURI(saveIFile);
		try {
			subMonitor.setTaskName("Saving TMSC to " + saveUri.lastSegment());
			Map<Object, Object> saveOptions = new HashMap<>();
			saveOptions.put(IProgressMonitor.class, subMonitor.split(25));
			persistor.save(saveUri, saveOptions, saveContent);
		} catch (IOException ex) {
			return new Status(ERROR, getPluginID(),
					String.format("Failed to save %s: %s", saveUri, ex.getMessage()), ex);
		}
		
		JobUtils.refreshWorkspaceProjects(subMonitor.split(1), saveIFile);
		
		return Status.OK_STATUS;
	}
}
