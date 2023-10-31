/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.analysis.ui.handlers;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Evaluate;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;

import nl.esi.pps.preferences.PPSPreferences;
import nl.esi.pps.tmsc.Interval;
import nl.esi.pps.tmsc.rendering.plot.ScopesRenderingStrategy;

public class CreateIntervalActivityScopeHandler extends CreateScopedTMSCCommandHandler {
	public CreateIntervalActivityScopeHandler() {
		super("create TMSC", ScopesRenderingStrategy.ID);
	}

	@Evaluate
	@CanExecute
	public boolean canExecute(@Named(IServiceConstants.ACTIVE_SELECTION) @Optional IStructuredSelection selection) {
		if (!PPSPreferences.isAdvancedFeaturesEnabled() || selection == null || selection.size() != 1) {
			return false;
		}
		final Object selectedElement = selection.getFirstElement();
		final EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(selectedElement);

		return editingDomain != null && selectedElement instanceof Interval;
	}

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SELECTION) IStructuredSelection selection,
			@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
		Interval interval = (Interval) selection.getFirstElement();
		CreateIntervalActivityStrategy strategy = CreateIntervalActivityStrategy.openSelectionDialog(shell);
		if (strategy == null) {
			return;
		}
		executeCommand(interval.getTmsc(), () -> strategy.createTMSC(interval));
	}
}
