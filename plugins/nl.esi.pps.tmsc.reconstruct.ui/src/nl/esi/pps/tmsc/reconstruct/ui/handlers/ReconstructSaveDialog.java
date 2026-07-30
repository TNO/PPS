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

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.SaveAsDialog;

public class ReconstructSaveDialog extends SaveAsDialog {
	private boolean openFileInEditor = true;
	private boolean validateFile = false;

	protected ReconstructSaveDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Reconstruct TMSC");
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite dialogComposite = (Composite) super.createDialogArea(parent);
		createOptionsArea(dialogComposite);
		return dialogComposite;
	}

	protected Control createOptionsArea(Composite parent) {
		Composite optionsComposite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(1, false);
		layout.marginLeft = 5;
		layout.marginRight = 6;
		optionsComposite.setLayout(layout);
		optionsComposite.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false));
		optionsComposite.setFont(parent.getFont());
		
		Button cbValidate = new Button(optionsComposite, SWT.CHECK);
		cbValidate.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false, 1, 1));
		cbValidate.setFont(parent.getFont());
		cbValidate.setText("Validate reconstructed TMSC");
		cbValidate.setSelection(validateFile);
		cbValidate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				validateFile = cbValidate.getSelection();
			}
		});

		Button cbOpen = new Button(optionsComposite, SWT.CHECK);
		cbOpen.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false, 1, 1));
		cbOpen.setFont(parent.getFont());
		cbOpen.setText("Open reconstructed TMSC in editor");
		cbOpen.setSelection(openFileInEditor);
		cbOpen.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				openFileInEditor = cbOpen.getSelection();
			}
		});

		return optionsComposite;
	}

	protected boolean isOpenFileInEditor() {
		return openFileInEditor;
	}

	/**
	 * Must be called before <code>create</code>.
	 */
	protected void setOpenFileInEditor(boolean openFileInEditor) {
		this.openFileInEditor = openFileInEditor;
	}
	
	public boolean isValidateFile() {
		return validateFile;
	}
	
	/**
	 * Must be called before <code>create</code>.
	 */
	public void setValidateFile(boolean validateFile) {
		this.validateFile = validateFile;
	}
}