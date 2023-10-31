/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.rendering.plot;

import static nl.esi.pps.common.jfreechart.rendering.RenderingPaint.DARK_GRAY;
import static nl.esi.pps.common.jfreechart.rendering.RenderingPaint.LIGHT_GRAY;
import static nl.esi.pps.common.jfreechart.rendering.RenderingStroke.DASHED;
import static nl.esi.pps.common.jfreechart.rendering.RenderingStroke.DOT_DASH;
import static nl.esi.pps.common.jfreechart.rendering.RenderingStroke.DOUBLE_DOT_DASH;
import static nl.esi.pps.common.jfreechart.rendering.RenderingStroke.LONG_DASHED;
import static nl.esi.pps.common.jfreechart.rendering.RenderingStroke.SOLID;

import org.eclipse.trace4cps.common.jfreechart.data.xy.XYEdgeSeriesCollection;
import org.jfree.data.xy.XYIntervalSeriesCollection;

import nl.esi.pps.common.jfreechart.rendering.RenderingPaint;
import nl.esi.pps.common.jfreechart.rendering.RenderingStroke;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.DomainDependency;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.LifelineSegment;
import nl.esi.pps.tmsc.Message;
import nl.esi.pps.tmsc.MessageControl;
import nl.esi.pps.tmsc.Reply;
import nl.esi.pps.tmsc.Request;
import nl.esi.pps.tmsc.presentation.TmscEditorPlugin;
import nl.esi.pps.tmsc.rendering.plot.DefaultRenderingStrategy.DependencyRenderingKey;
import nl.esi.pps.tmsc.rendering.plot.EnumRenderingStrategy.VoidRenderingKey;
import nl.esi.pps.tmsc.viewers.plot.DependenciesRenderer;
import nl.esi.pps.tmsc.viewers.plot.ExecutionsRenderer;

public class DefaultRenderingStrategy extends EnumRenderingStrategy<VoidRenderingKey, DependencyRenderingKey> {
	public static final String ID = TmscEditorPlugin.getPlugin().getSymbolicName() + ".default_rendering_strategy";

	public static enum DependencyRenderingKey implements IRenderingSeriesConfigurator {
		REQUEST_SERIES(DARK_GRAY, SOLID),
		REPLY_SERIES(DARK_GRAY, DASHED),
		MESSAGE_SERIES(DARK_GRAY, DOT_DASH),
		MESSAGE_CONTROL_SERIES(DARK_GRAY, DOUBLE_DOT_DASH),
		DOMAIN_DEPENDENCY_SERIES(LIGHT_GRAY, LONG_DASHED),
		LIFELINE_SEGMENT_SERIES(LIGHT_GRAY, SOLID);
		
		private final RenderingPaint paint;
		private final  RenderingStroke stroke;
		
		private DependencyRenderingKey(RenderingPaint paint, RenderingStroke stroke) {
			this.paint = paint;
			this.stroke = stroke;
		}
		
		@Override
		public void configureDependenciesSeries(DependenciesRenderer dependenciesRenderer, int series, boolean notify) {
			dependenciesRenderer.setSeriesPaintSupplier(series, paint, notify);
			dependenciesRenderer.setSeriesStroke(series, stroke.getStroke(), notify);
		}
	}
	
	public DefaultRenderingStrategy() {
		super(VoidRenderingKey.class, DependencyRenderingKey.class);
	}
	
	@Override
	protected VoidRenderingKey getRenderingKey(Execution execution) {
        // All executions are rendered as default, see VoidRenderingKey
		return null;
	}
	
	@Override
	protected DependencyRenderingKey getRenderingKey(Dependency dependency) {
		DependencyRenderingKey key = null;
		if (dependency instanceof Request) {
			key = DependencyRenderingKey.REQUEST_SERIES;
		} else if (dependency instanceof Reply) {
			key = DependencyRenderingKey.REPLY_SERIES;
		} else if (dependency instanceof Message) {
			key = DependencyRenderingKey.MESSAGE_SERIES;
		} else if (dependency instanceof MessageControl) {
			key = DependencyRenderingKey.MESSAGE_CONTROL_SERIES;
		} else if (dependency instanceof DomainDependency) {
			key = DependencyRenderingKey.DOMAIN_DEPENDENCY_SERIES;
		} else if (dependency instanceof LifelineSegment) {
			key = DependencyRenderingKey.LIFELINE_SEGMENT_SERIES;
		}
		return key;
	}
	
	@Override
	public void preRendering(XYEdgeSeriesCollection dependenciesDataset, DependenciesRenderer dependenciesRenderer,
			XYIntervalSeriesCollection executionsDataset, ExecutionsRenderer executionsRenderer) {
		super.preRendering(dependenciesDataset, dependenciesRenderer, executionsDataset, executionsRenderer);

		executionsRenderer.setDefaultPaintSupplier(RenderingPaint.BLUE, false);
		// Using a more explicit color for unknown dependency types
		dependenciesRenderer.setDefaultPaintSupplier(RenderingPaint.CYAN, false);
	}
}
