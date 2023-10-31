/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.common.emf.ui.link;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.lsat.common.emf.common.util.URIHelper;

import nl.esi.pps.common.emf.ui.Activator;
import nl.esi.pps.common.ide.ui.WorkbenchUtil;
import nl.esi.pps.common.ide.ui.browser.LinkProcessor;

public class PlatformResourceProcessor implements LinkProcessor {
	@Override
	public boolean process(final String location) {
		try {
			return processURI(URI.createURI(location));
		} catch (IllegalArgumentException e) {
			// Not a valid URI, ignore
			return false;
		}
	}
	
	private boolean processURI(URI uri) {
		if (!uri.isPlatformResource()) {
			return false;
		}
		final IResource resource = URIHelper.asIResource(uri);
		if (!(resource instanceof IFile)) {
			return false;
		}
		final IFile file = (IFile) resource;
		try {
			openDefaultEditor(uri, file);
		} catch (CoreException e) {
			Activator.getDefault().getLog()
					.log(new Status(IStatus.ERROR, Activator.getDefault().getBundle().getSymbolicName(),
							"Failed to open editor: " + e.getMessage(), e));
		}
		return true;
	}
	
	/**
	 * @see {@link Resource#getURIFragment(org.eclipse.emf.ecore.EObject)}
	 */
	private void openDefaultEditor(URI uri, IFile file) throws CoreException {
		if (uri.hasFragment()) {
			// Create an intermediate IMarker to navigate to the requested EObject, 
			// see Resource#getURIFragment
			IMarker marker = file.createMarker(EValidator.MARKER);
			marker.setAttribute(IMarker.TRANSIENT, true);
			marker.setAttribute(EValidator.URI_ATTRIBUTE, uri.toString());
			WorkbenchUtil.openDefaultEditorSync(marker);
			// Delete the intermediate marker
			marker.delete();
		} else {
			WorkbenchUtil.openDefaultEditorSync(file);
		}

	}
}
