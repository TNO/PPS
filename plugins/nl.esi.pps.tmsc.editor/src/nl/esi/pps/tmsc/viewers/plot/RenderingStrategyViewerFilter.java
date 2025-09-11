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

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import nl.esi.pps.tmsc.rendering.plot.IRenderingStrategy;

public class RenderingStrategyViewerFilter extends ViewerFilter {
	private String renderingStrategyID = null;
	private IRenderingStrategy renderingStrategy = null;

	public void setRenderingStrategy(String id, IRenderingStrategy strategy) {
		this.renderingStrategyID = id;
		this.renderingStrategy = strategy;
	}
	
	public String getRenderingStrategyID() {
		return renderingStrategyID;
	}
	
	public IRenderingStrategy getRenderingStrategy() {
		return renderingStrategy;
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		return renderingStrategy == null || renderingStrategy.select(viewer, parentElement, element);
	}
}
