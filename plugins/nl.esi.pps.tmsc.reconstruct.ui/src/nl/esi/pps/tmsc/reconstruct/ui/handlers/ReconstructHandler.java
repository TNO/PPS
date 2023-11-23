/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */

package nl.esi.pps.tmsc.reconstruct.ui.handlers;

import java.io.IOException;
import java.util.Collections;

import javax.inject.Named;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Evaluate;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;

import nl.esi.pps.tmsc.reconstruct.TmscTraceParser;
import nl.esi.pps.tmsc.reconstruct.TmscTraceReconstructor;

public class ReconstructHandler {
	@Evaluate
	@CanExecute
	public boolean canExecute(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) IStructuredSelection selection) {
		if (selection == null || selection.size() != 1) {
			return false;
		}
		Object selectedElement = selection.getFirstElement();
		if (selectedElement instanceof IFile) {
			String fileExtension = ((IFile) selectedElement).getFileExtension();
			return "tmsctrace".equals(fileExtension);
		}
		return false;
	}

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SELECTION) IStructuredSelection selection,
			@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
		try {
			reconstruct((IFile) selection.getFirstElement());
		} catch (Exception e) {
			MessageDialog.openError(shell, "Reconstruction failed", e.getLocalizedMessage());
		}
	}

	private void reconstruct(IFile traceIFile) throws IOException, CoreException {
		// Reconstruction
		TmscTraceReconstructor reconstructor = new TmscTraceReconstructor();
		TmscTraceParser.parse(traceIFile.getContents(), reconstructor);

		// Saving models to file
		URI traceURI = URI.createPlatformResourceURI(traceIFile.getFullPath().toString(), true);
		URI tmscURI = traceURI.trimFileExtension().appendFileExtension("tmscz");
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource tmscResource = resourceSet.createResource(tmscURI);
		tmscResource.getContents().add(reconstructor.getTmsc());
		tmscResource.getContents().add(reconstructor.getArchitecture());
		tmscResource.save(Collections.emptyMap());
		
		// Refresh workspace to view created file
		traceIFile.getParent().refreshLocal(IResource.DEPTH_ONE, null);
	}
}