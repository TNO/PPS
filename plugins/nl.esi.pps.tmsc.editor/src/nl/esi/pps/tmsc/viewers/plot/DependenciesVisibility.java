/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.viewers.plot;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ResourceLocator;

import nl.esi.pps.tmsc.presentation.TmscEditorPlugin;
import nl.esi.pps.tmsc.rendering.RenderingDependencies;

/**
 * Adds UI handling to {@link RenderingDependencies}.
 */
public enum DependenciesVisibility {
	ALL(RenderingDependencies.ALL), HIDE_ANNOTATIONS(RenderingDependencies.HIDE_ANNOTATIONS),
	HIDE_CROSSING(RenderingDependencies.HIDE_CROSSING), NONE(RenderingDependencies.NONE);

	private final RenderingDependencies rendering;
	private final ImageDescriptor image;

	private DependenciesVisibility(RenderingDependencies rendering) {
		this.rendering = rendering;
		this.image = ResourceLocator.imageDescriptorFromBundle(TmscEditorPlugin.getPlugin().getSymbolicName(),
				String.format("icons/DependenciesVisibility%s.gif", name())).orElse(null);
	}

	public String getLabel() {
		return rendering.getLabel();
	}

	public ImageDescriptor getImage() {
		return image;
	}

	public void apply(DependenciesRenderer renderer, boolean notify) {
		renderer.setDefaultSeriesVisible(this.compareTo(NONE) < 0, false);
		renderer.setDefaultDrawPlotCrossingLines(this.compareTo(HIDE_CROSSING) < 0, false);
		renderer.setDefaultAnnotationsVisible(this.compareTo(HIDE_ANNOTATIONS) < 0, notify);
	}

	public static DependenciesVisibility valueOf(DependenciesRenderer renderer) {
		if (!renderer.getDefaultSeriesVisible()) {
			return NONE;
		} else if (!renderer.getDefaultDrawPlotCrossingLines()) {
			return HIDE_CROSSING;
		} else if (!renderer.getDefaultAnnotationsVisible()) {
			return HIDE_ANNOTATIONS;
		} else {
			return ALL;
		}
	}

	public static final DependenciesVisibility valueOf(RenderingDependencies rendering) {
		for (DependenciesVisibility visibility : values()) {
			if (visibility.rendering == rendering) {
				return visibility;
			}
		}
		return null;
	}
}
