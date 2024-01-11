/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.ui.commands;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.command.AbstractCommand;

import nl.esi.pps.tmsc.Measurement;

public class AddMeasurementCommand extends AbstractCommand {
	private final Measurement measurement;

	public AddMeasurementCommand(Measurement measurement) {
		super("add to model", "Adds a measurement to the model");
		this.measurement = measurement;
	}

	@Override
	protected boolean prepare() {
		return measurement.eContainer() == null && measurement.getFrom().getTmsc() != null;
	}

	@Override
	public void execute() {
		measurement.getFrom().getTmsc().getMeasurements().add(measurement);
	}

	@Override
	public void redo() {
		execute();
	}

	@Override
	public void undo() {
		measurement.getFrom().getTmsc().getMeasurements().remove(measurement);
	}

	@Override
	public Collection<?> getAffectedObjects() {
		return measurement.eContainer() == null ? Collections.singleton(measurement.getFrom().getTmsc())
				: Collections.singleton(measurement);
	}
}
