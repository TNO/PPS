/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.ide.ui.status;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.viewers.ITreeContentProvider;

public class StatusContentProvider implements ITreeContentProvider {
	private static final IStatus[] NO_CHILDREN = new IStatus[0];
	
	@Override
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	@Override
	public Object[] getChildren(Object element) {
		return element instanceof IStatus ? ((IStatus)element).getChildren() : NO_CHILDREN;
	}

	@Override
	public boolean hasChildren(Object element) {
		return element instanceof IStatus ? ((IStatus)element).isMultiStatus() : false;
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}
}
