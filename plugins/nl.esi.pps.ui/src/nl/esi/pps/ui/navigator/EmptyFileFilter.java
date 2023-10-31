/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.ui.navigator;

import java.net.URI;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

public class EmptyFileFilter extends ViewerFilter {
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (element instanceof IFile) {
			URI fileURI = ((IFile) element).getLocationURI();
			try {
				return EFS.getStore(fileURI).fetchInfo().getLength() != 0;
			} catch (CoreException e) {
				// Ignore
			}
		}
		return true;
	}
}
