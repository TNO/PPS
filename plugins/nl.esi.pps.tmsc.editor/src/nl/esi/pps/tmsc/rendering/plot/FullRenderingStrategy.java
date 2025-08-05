/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.rendering.plot;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.Viewer;

import nl.esi.pps.preferences.PPSPreferences;
import nl.esi.pps.tmsc.presentation.TmscEditorPlugin;

public class FullRenderingStrategy extends DefaultRenderingStrategy {
	public static final String ID = TmscEditorPlugin.getPlugin().getSymbolicName() + ".full_rendering_strategy";
	
	@Override
	public boolean isSupported(EditingDomain editingDomain) {
		return PPSPreferences.isAdvancedFeaturesEnabled();
	}
	
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		return true;
	}
}
