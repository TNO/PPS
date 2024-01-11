/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.ui.preferences;

import static nl.esi.pps.preferences.PPSPreferences.PREF_ADVANCED_FEATURES;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.osgi.service.prefs.BackingStoreException;

import nl.esi.pps.preferences.PPSPreferences;

public class PPSPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {
	private final IEclipsePreferences preferences = PPSPreferences.getPreferences();

	private Button btnShowAdvancedFeatures;

	public PPSPreferencePage() {
		super("PPS IDE");
	}

	@Override
	public void init(IWorkbench workbench) {
		// do nothing
	}

	@Override
	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));

		btnShowAdvancedFeatures = new Button(composite, SWT.CHECK);
		btnShowAdvancedFeatures.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		btnShowAdvancedFeatures.setText("Show advanced features");
		btnShowAdvancedFeatures.setSelection(preferences.getBoolean(PREF_ADVANCED_FEATURES, false));

		return composite;
	}

	@Override
	protected void performDefaults() {
		btnShowAdvancedFeatures.setSelection(false);

		super.performDefaults();
	}

	@Override
	public boolean performOk() {
		preferences.putBoolean(PREF_ADVANCED_FEATURES, btnShowAdvancedFeatures.getSelection());

		try {
			preferences.flush();
			return true;
		} catch (BackingStoreException e) {
			setErrorMessage(e.getMessage());
			return false;
		}
	}
}
