/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.viewers.plot;

import java.awt.geom.Point2D;

import org.eclipse.trace4cps.common.jfreechart.ui.viewers.BackReferenceProvider;
import org.jfree.chart.annotations.XYNoteAnnotation;

import nl.esi.pps.tmsc.Event;

public class EventNoteAnnotation extends XYNoteAnnotation implements BackReferenceProvider<Event> {
	private static final long serialVersionUID = -9147978816045768510L;

	private final Event event;
	
	public EventNoteAnnotation(Point2D location, String text, Event event) {
		super(text, location.getX(), location.getY(), -1);
        this.event = event;
		setToolTipText(text);
	}
	
	@Override
	public Event getBackReference() {
		return event;
	}
}
