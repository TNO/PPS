/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.viewers.dataanalysis;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ResourceLocator;
import org.eclipse.jface.window.IShellProvider;

import nl.esi.pps.tmsc.presentation.TmscEditorPlugin;

class DurationFilterAction extends Action {
	private final DurationFilter durationFilter = new DurationFilter();
	private final IShellProvider shellProvider;

	public DurationFilterAction(IShellProvider shellProvider) {
		super("Filter Outliers...", Action.AS_CHECK_BOX); 
		setImageDescriptor(ResourceLocator.imageDescriptorFromBundle(TmscEditorPlugin.getPlugin().getSymbolicName(),
				"icons/filter_ps.png").orElse(null));
		this.shellProvider = shellProvider;
		durationFilter.addPropertyChangeListener(DurationFilter.PROPERTY_FILTER,
				e -> setChecked((Boolean) e.getNewValue()));
	}

	public DurationFilter getDurationFilter() {
		return durationFilter;
	}

	@Override
	public void run() {
		// We're not really toggling, the checked state depends on the configuration, thus align
		setChecked(durationFilter.isFilter());
		
		new DurationFilterDialog(shellProvider.getShell(), durationFilter).open();
	}
}