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
import nl.esi.pps.tmsc.rendering.RenderingExecutions;

/**
 * Adds UI handling to {@link RenderingExecutions}.
 */
public enum ExecutionsVisibility {
	ALL(RenderingExecutions.ALL), HIDE_ANNOTATIONS(RenderingExecutions.HIDE_ANNOTATIONS),
	NONE(RenderingExecutions.NONE);

	private final RenderingExecutions rendering;
	private final ImageDescriptor image;

	private ExecutionsVisibility(RenderingExecutions rendering) {
		this.rendering = rendering;
		this.image = ResourceLocator.imageDescriptorFromBundle(TmscEditorPlugin.getPlugin().getSymbolicName(),
				String.format("icons/ExecutionsVisibility%s.gif", name())).orElse(null);
	}

	public String getLabel() {
		return rendering.getLabel();
	}

	public ImageDescriptor getImage() {
		return image;
	}

	public void apply(ExecutionsRenderer renderer, boolean notify) {
		renderer.setDefaultSeriesVisible(this.compareTo(NONE) < 0, false);
		renderer.setDefaultAnnotationsVisible(this.compareTo(HIDE_ANNOTATIONS) < 0, notify);
	}

	public static ExecutionsVisibility valueOf(ExecutionsRenderer renderer) {
		if (!renderer.getDefaultSeriesVisible()) {
			return NONE;
		} else if (!renderer.getDefaultAnnotationsVisible()) {
			return HIDE_ANNOTATIONS;
		} else {
			return ALL;
		}
	}

	public static final ExecutionsVisibility valueOf(RenderingExecutions rendering) {
		for (ExecutionsVisibility visibility : values()) {
			if (visibility.rendering == rendering) {
				return visibility;
			}
		}
		return null;
	}
}
