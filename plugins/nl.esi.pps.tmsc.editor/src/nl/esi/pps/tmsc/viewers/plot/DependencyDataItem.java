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

import java.awt.geom.Point2D;

import org.eclipse.trace4cps.common.jfreechart.data.xy.XYEdgeDataItem;
import org.eclipse.trace4cps.common.jfreechart.ui.viewers.BackReferenceProvider;

import nl.esi.pps.tmsc.Dependency;

public class DependencyDataItem extends XYEdgeDataItem implements BackReferenceProvider<Dependency> {
	private static final long serialVersionUID = 7030747384736615187L;

	private final transient Dependency dependency;

	public DependencyDataItem(Point2D sourceLocation, Point2D targetLocation, Dependency dependency) {
		super(sourceLocation.getX(), sourceLocation.getY(), targetLocation.getX(), targetLocation.getY());
		this.dependency = dependency;
	}

	@Override
	public Dependency getBackReference() {
		return dependency;
	}

	static Long getStartTime(Dependency dependency, long offset) {
		Long startTime = dependency.getStartTime();
		if (startTime == null) {
			startTime = dependency.getTmsc().getStartTime();
		}
		return startTime - offset;
	}

	static Long getEndTime(Dependency dependency, long offset) {
		Long endTime = dependency.getEndTime();
		if (endTime == null) {
			endTime = dependency.getTmsc().getEndTime();
		}
		return endTime - offset;
	}
}
