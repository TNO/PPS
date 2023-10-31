/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.common.ide.ui.status;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;

import nl.esi.pps.common.ide.ui.viewers.TreeColumnModelViewer;

public class StatusDialog extends MessageDialog {
	protected final IStatus status;
	
	public StatusDialog(Shell parentShell, String title, IStatus status) {
		super(parentShell, title, null, status.getMessage(), getDialogImageType(status), 0, IDialogConstants.OK_LABEL);
		this.status = status;
		int shellStyle = SWT.DIALOG_TRIM | getDefaultOrientation();
		if (isResizable()) {
			shellStyle |= SWT.MAX | SWT.RESIZE;
		}
		if (isModal()) {
			shellStyle |= SWT.APPLICATION_MODAL;
			setBlockOnOpen(true);
		} else {
			setBlockOnOpen(false);
		}
		setShellStyle(shellStyle);
	}
	
	protected boolean isModal() {
		return true;
	}

	protected static int getDialogImageType(IStatus status) {
		switch (status.getSeverity()) {
		case IStatus.ERROR: return MessageDialog.ERROR;
		case IStatus.WARNING: return MessageDialog.WARNING;
		case IStatus.INFO: return MessageDialog.INFORMATION;
		default: return MessageDialog.NONE;
		}
	}

	@Override
	protected Control createCustomArea(Composite parent) {
		if (status.isMultiStatus()) {
			return createStatusViewer(parent).getTree();
		}
		return null;
	}
	
	protected TreeColumnModelViewer createStatusViewer(Composite parent) {
		TreeColumnModelViewer statusViewer = new TreeColumnModelViewer(parent,
				SWT.BORDER | SWT.SINGLE | SWT.FULL_SELECTION | SWT.H_SCROLL | SWT.V_SCROLL | SWT.DOWN);

		Tree tree = statusViewer.getTree();
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);
		
		statusViewer.setColumnModel(new StatusColumnModel());
		statusViewer.setContentProvider( new StatusContentProvider());
		statusViewer.setInput(status);
		
		return statusViewer;
	}
}
