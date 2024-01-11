/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */

package nl.esi.pps.tmsc.metric.ui.handlers;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Evaluate;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;

import nl.esi.pps.preferences.PPSPreferences;
import nl.esi.pps.tmsc.Measurement;
import nl.esi.pps.tmsc.metric.ui.commands.ConvertToMetricCommand;
import nl.esi.pps.ui.handlers.AbstractCommandHandler;

public class ConvertToMetricHandler extends AbstractCommandHandler {
	@Evaluate
	@CanExecute
	public boolean canExecute(@Named(IServiceConstants.ACTIVE_SELECTION) @Optional IStructuredSelection selection) {
		if (!PPSPreferences.isAdvancedFeaturesEnabled() || selection == null || selection.size() != 1) {
			return false;
		}
		final Object selectedElement = selection.getFirstElement();
		if (selectedElement instanceof Measurement) {
			Measurement measurement = (Measurement) selectedElement;
			// A measurement might not have a container yet, thus no editing-domain yet.
			// Retrieve it from the from event.
			final EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(measurement.getFrom());
			return editingDomain instanceof AdapterFactoryEditingDomain;
		}
		return false;
	}

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SELECTION) IStructuredSelection selection,
			@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
		Measurement measurement = (Measurement) selection.getFirstElement();
		AdapterFactoryEditingDomain editingDomain = (AdapterFactoryEditingDomain) AdapterFactoryEditingDomain
				.getEditingDomainFor(measurement.getFrom());

		InputDialog inputDialog = new InputDialog(shell, "Metric name", "Please provide the name of the metric", "",
				s -> s.isEmpty() ? "Please provide the name of the metric" : null);
		if (inputDialog.open() != InputDialog.OK) {
			return;
		}
		executeCommand(new ConvertToMetricCommand(measurement, inputDialog.getValue()), editingDomain);
	}
}