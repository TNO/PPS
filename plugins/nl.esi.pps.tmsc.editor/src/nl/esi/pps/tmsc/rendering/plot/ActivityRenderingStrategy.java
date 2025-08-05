/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.rendering.plot;

import org.eclipse.emf.edit.domain.EditingDomain;

import nl.esi.pps.common.jfreechart.rendering.RenderingPaint;
import nl.esi.pps.common.jfreechart.rendering.RenderingStroke;
import nl.esi.pps.preferences.PPSPreferences;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Execution;

public class ActivityRenderingStrategy extends HighlightRenderingStrategy {
	public ActivityRenderingStrategy() {
		super("Activity", RenderingPaint.ORANGE, RenderingStroke.FAT_SOLID);
	}
	
	@Override
	public boolean isSupported(EditingDomain editingDomain) {
		return PPSPreferences.isAdvancedFeaturesEnabled();
	}
	
	@Override
	protected boolean isHighlight(Execution execution) {
		return false;
	}

	@Override
	protected boolean isHighlight(Dependency dependency) {
		return dependency.getScheduled() == Boolean.FALSE;
	}
}