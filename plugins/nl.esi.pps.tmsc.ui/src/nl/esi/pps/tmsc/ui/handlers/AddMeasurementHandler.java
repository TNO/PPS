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

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Evaluate;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.IStructuredSelection;

import nl.esi.pps.tmsc.Measurement;
import nl.esi.pps.tmsc.ui.commands.AddMeasurementCommand;
import nl.esi.pps.ui.handlers.AbstractCommandHandler;

public class AddMeasurementHandler extends AbstractCommandHandler {
	@Evaluate
	@CanExecute
	public boolean canExecute(@Named(IServiceConstants.ACTIVE_SELECTION) @Optional IStructuredSelection selection) {
		if (selection == null || selection.size() != 1) {
			return false;
		}
		final Object selectedElement = selection.getFirstElement();
		if (selectedElement instanceof Measurement) {
			Measurement measurement = (Measurement) selectedElement;
			// The measurement doesn't have a container yet, thus no editing-domain yet.
			// Retrieve it from the from event.
			final EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(measurement.getFrom());
			return editingDomain != null && measurement.eContainer() == null;
		}
		return false;
	}

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SELECTION) IStructuredSelection selection) {
		final Measurement measurement = (Measurement) selection.getFirstElement();
		final EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(measurement.getFrom());
		executeCommand(new AddMeasurementCommand(measurement), editingDomain);
	}
}