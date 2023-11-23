/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.ui.handlers;

import java.util.concurrent.TimeUnit;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;

class TimeShiftDialog extends Dialog {
	private long amount = 0;
	private TimeUnit unit = TimeUnit.SECONDS;

	TimeShiftDialog(Shell parent) {
		super(parent);
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Time-shift TMSCs");
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		GridLayout gl_container = new GridLayout(2, false);
		gl_container.verticalSpacing = 15;
		gl_container.marginBottom = 5;
		gl_container.marginTop = 5;
		gl_container.marginRight = 5;
		gl_container.marginLeft = 5;
		container.setLayout(gl_container);

		Label lblMessage = new Label(container, SWT.NONE);
		lblMessage.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		lblMessage.setText("Please specify the amount of time to be shifted:");

		Spinner spinnerAmount = new Spinner(container, SWT.BORDER);
		spinnerAmount.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		spinnerAmount.setMinimum(Integer.MIN_VALUE);
		spinnerAmount.setMaximum(Integer.MAX_VALUE);
		spinnerAmount.setSelection((int) amount);
		spinnerAmount.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				amount = ((Spinner) e.getSource()).getSelection();
				getButton(IDialogConstants.OK_ID).setEnabled(amount != 0);
			}
		});

		Combo comboUnit = new Combo(container, SWT.NONE);
		comboUnit.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		comboUnit.setItems(getTimeUnitsAsString());
		comboUnit.select(unit.ordinal());
		comboUnit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				unit = TimeUnit.values()[((Combo) e.getSource()).getSelectionIndex()];
			}
		});

		Label lblNote = new Label(container, SWT.NONE);
		lblNote.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		lblNote.setText(
				"NOTE: A negative time will shift to the past\n" + 
				"and a positive time will shift to the future.");

		return container;
	}
	
	@Override
	protected Control createButtonBar(Composite parent) {
		Control buttonBar = super.createButtonBar(parent);
		getButton(IDialogConstants.OK_ID).setEnabled(amount != 0);
		return buttonBar;
	}

	private String[] getTimeUnitsAsString() {
		TimeUnit[] units = TimeUnit.values();
		String[] names = new String[units.length];
		for (int i = 0; i < units.length; i++) {
			names[i] = units[i].name().toLowerCase();
		}
		return names;
	}

	long getAmount() {
		return amount;
	}

	TimeUnit getUnit() {
		return unit;
	}
}
