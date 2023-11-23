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

import java.awt.Color;
import java.awt.geom.Point2D;

import org.jfree.chart.annotations.XYPointerAnnotation;
import org.jfree.data.Range;

import nl.esi.pps.tmsc.Dependency;

public class DependencyIncomingAnnotation extends XYPointerAnnotation implements DependencyAnnotation {
	private static final long serialVersionUID = -2915115343342450231L;

	private final Dependency dependency;

	public DependencyIncomingAnnotation(Point2D targetLocation, Dependency dependency) {
		super("SOURCE_NOT_SET", targetLocation.getX(), targetLocation.getY(), Math.PI * 0.75);
		this.dependency = dependency;
		setToolTipText(getText());
		setBackgroundPaint(Color.WHITE);
		setOutlinePaint(Color.DARK_GRAY);
		setPaint(Color.DARK_GRAY);
		setOutlineVisible(true);
		setTipRadius(0);
	}

	@Override
	public Dependency getBackReference() {
		return dependency;
	}

	@Override
	public boolean getIncludeInDataBounds() {
		return true;
	}
	
	@Override
	public Range getXRange() {
		return new Range(getX(), getX());
	}
	
	@Override
	public Range getYRange() {
		return new Range(getY(), getY());
	}
}
