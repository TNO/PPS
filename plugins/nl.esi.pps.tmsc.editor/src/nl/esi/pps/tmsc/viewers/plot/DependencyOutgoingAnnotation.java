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

import org.jfree.chart.annotations.XYInversePointerAnnotation;
import org.jfree.data.Range;

import nl.esi.pps.tmsc.Dependency;

public class DependencyOutgoingAnnotation extends XYInversePointerAnnotation implements DependencyAnnotation {
	private static final long serialVersionUID = -8125635769379344912L;

	private final Dependency dependency;

	public DependencyOutgoingAnnotation(Point2D sourceLocation, Dependency dependency) {
		super("TARGET_NOT_SET", sourceLocation.getX(), sourceLocation.getY(), Math.PI * -0.25);
		this.dependency = dependency;
		setToolTipText(getText());
		setBackgroundPaint(Color.WHITE);
		setOutlinePaint(Color.DARK_GRAY);
		setPaint(Color.DARK_GRAY);
		setOutlineVisible(true);
		setTipRadius(0);
		setBaseRadius(45);
		setDotRadius(2.5);
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
