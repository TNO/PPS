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

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.trace4cps.common.jfreechart.chart.axis.Section;
import org.eclipse.trace4cps.common.jfreechart.data.xy.XYEdgeSeriesCollection;
import org.jfree.data.xy.XYIntervalSeriesCollection;

import nl.esi.pps.preferences.PPSPreferences;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.Lifeline;
import nl.esi.pps.tmsc.LifelineSegment;
import nl.esi.pps.tmsc.viewers.plot.DependenciesRenderer;
import nl.esi.pps.tmsc.viewers.plot.DependencyAnnotation;
import nl.esi.pps.tmsc.viewers.plot.DependencyDataItem;
import nl.esi.pps.tmsc.viewers.plot.ExecutionDataItem;
import nl.esi.pps.tmsc.viewers.plot.ExecutionsRenderer;

/**
 * All classes implementing {@link IRenderingStrategy} should provide a default
 * public constructor.
 */
public interface IRenderingStrategy extends IViewerFilter {
	/**
	 * This method is called once, when an TMSC editor is opened. The rendering
	 * strategy may check if it supports the {@code editingDomain} or base its
	 * result on other environmental properties, e.g.
	 * {@link PPSPreferences#isAdvancedFeaturesEnabled()}.
	 * 
	 * @param editingDomain the editing to inspect
	 * @return {@code true} if this rendering strategy is supported.
	 */
	default boolean isSupported(EditingDomain editingDomain) {
		return true;
	}
	
	/**
	 * Returns whether the given element makes it through this filter.
	 * <p>
	 * This default implementation hides all {@link LifelineSegment life-line
	 * segments} and all {@link Dependency#isProjection() projected dependencies}.
	 * <p>
	 */
	@Override
	default boolean select(Viewer viewer, Object parentElement, Object element) {
		if (element instanceof LifelineSegment) {
			return false;
		} else if (element instanceof Dependency) {
			return element instanceof Execution || !((Dependency) element).isProjection();
		} else {
			return true;
		}
	}
	
	void preRendering(XYEdgeSeriesCollection dependenciesDataset, DependenciesRenderer dependenciesRenderer,
			XYIntervalSeriesCollection executionsDataset, ExecutionsRenderer executionsRenderer);

	void configureLifelineSection(Lifeline lifeline, Section section);

	void add(ExecutionDataItem executionDataItem, XYIntervalSeriesCollection executionsDataset,
			ExecutionsRenderer executionsRenderer);

	void add(DependencyDataItem dependencyDataItem, XYEdgeSeriesCollection dependenciesDataset,
			DependenciesRenderer dependenciesRenderer);

	void add(DependencyAnnotation dependencyAnnotation, XYEdgeSeriesCollection dependenciesDataset,
			DependenciesRenderer dependenciesRenderer);

	void postRendering(XYEdgeSeriesCollection dependenciesDataset, DependenciesRenderer dependenciesRenderer,
			XYIntervalSeriesCollection executionsDataset, ExecutionsRenderer executionsRenderer);

}
