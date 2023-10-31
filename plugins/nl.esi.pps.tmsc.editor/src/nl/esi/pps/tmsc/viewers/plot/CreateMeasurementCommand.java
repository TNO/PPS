/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.viewers.plot;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.ecore.util.EcoreUtil;

import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.Measurement;
import nl.esi.pps.tmsc.TmscFactory;
import nl.esi.pps.tmsc.text.EDurationFormat;

public class CreateMeasurementCommand extends AbstractCommand {

	private final Event from;
	private final Event to;

	private Measurement measurement = null;

	public CreateMeasurementCommand(Event from, Event to) {
		super("create measurement");
		this.from = from;
		this.to = to;
	}

	@Override
	protected boolean prepare() {
		return from != null && to != null && from.getTmsc() != null && from.getTmsc() == to.getTmsc();
	}

	@Override
	public void execute() {
		measurement = TmscFactory.eINSTANCE.createMeasurement();
		measurement.setName(EDurationFormat.eINSTANCE.format(to.getTimestamp() - from.getTimestamp()));
		measurement.setFrom(from);
		measurement.setTo(to);
		from.getTmsc().getMeasurements().add(measurement);
	}

	@Override
	public void redo() {
		execute();
	}

	@Override
	public boolean canUndo() {
		return measurement != null;
	}

	@Override
	public void undo() {
		if (measurement != null) {
			EcoreUtil.delete(measurement);
			measurement = null;
		}
	}
}