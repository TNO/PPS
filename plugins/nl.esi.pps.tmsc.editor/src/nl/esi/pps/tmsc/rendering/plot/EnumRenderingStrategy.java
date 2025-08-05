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

import org.eclipse.trace4cps.common.jfreechart.data.xy.XYEdgeSeries;
import org.eclipse.trace4cps.common.jfreechart.data.xy.XYEdgeSeriesCollection;
import org.jfree.data.xy.XYIntervalSeries;
import org.jfree.data.xy.XYIntervalSeriesCollection;

import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.viewers.plot.DependenciesRenderer;
import nl.esi.pps.tmsc.viewers.plot.DependencyAnnotation;
import nl.esi.pps.tmsc.viewers.plot.DependencyDataItem;
import nl.esi.pps.tmsc.viewers.plot.ExecutionDataItem;
import nl.esi.pps.tmsc.viewers.plot.ExecutionsRenderer;

public abstract class EnumRenderingStrategy<E extends Enum<?>, D extends Enum<?>> extends AbstractRenderingStrategy {
	/**
	 * Subclasses can use this rendering key if either Executions or Dependency
	 * rendering is not applicable. The overridden {@code getRenderingKey(...)}
	 * method should just return {@code null}.
	 */
	public static enum VoidRenderingKey {};

	private final Class<E> executionRenderingKeyType;
	private final Class<D> dependencyRenderingKeyType;

	public EnumRenderingStrategy(Class<E> executionRenderingKeyType, Class<D> dependencyRenderingKeyType) {
		this.executionRenderingKeyType = executionRenderingKeyType;
		this.dependencyRenderingKeyType = dependencyRenderingKeyType;
	}

	/**
	 * @return the rendering key for the {@code execution}, {@code null} if not
	 *         applicable.
	 */
	protected abstract E getRenderingKey(Execution execution);

	/**
	 * @return the rendering key for the {@code dependency}, {@code null} if not
	 *         applicable.
	 */
	protected abstract D getRenderingKey(Dependency dependency);

	protected final int getSeries(Enum<?> renderingKey) {
		return renderingKey == null ? 0 : renderingKey.ordinal() + 1;
	}

	@Override
	public void preRendering(XYEdgeSeriesCollection dependenciesDataset, DependenciesRenderer dependenciesRenderer,
			XYIntervalSeriesCollection executionsDataset, ExecutionsRenderer executionsRenderer) {
		super.preRendering(dependenciesDataset, dependenciesRenderer, executionsDataset, executionsRenderer);

		// Ensure that the default series are the first in the dataset,
		// such that other series are visualized over the default series
		// Also see getSeries(Enum<?>)
		getDefaultExecutionSeries(executionsDataset);
		getDefaultDependencySeries(dependenciesDataset);

		for (E renderingKey : executionRenderingKeyType.getEnumConstants()) {
			executionsDataset.addSeries(new XYIntervalSeries(renderingKey, false, true));
			configureExecutionsSeries(renderingKey, executionsRenderer);
		}

		for (D renderingKey : dependencyRenderingKeyType.getEnumConstants()) {
			dependenciesDataset.addSeries(new XYEdgeSeries(renderingKey));
			configureDependenciesSeries(renderingKey, dependenciesRenderer);
		}
	}

	protected void configureExecutionsSeries(E renderingKey, ExecutionsRenderer executionsRenderer) {
		if (renderingKey instanceof IRenderingSeriesConfigurator) {
			((IRenderingSeriesConfigurator) renderingKey).configureExecutionsSeries(executionsRenderer,
					getSeries(renderingKey), false);
		}
	}

	protected void configureDependenciesSeries(D renderingKey, DependenciesRenderer dependenciesRenderer) {
		if (renderingKey instanceof IRenderingSeriesConfigurator) {
			((IRenderingSeriesConfigurator) renderingKey).configureDependenciesSeries(dependenciesRenderer,
					getSeries(renderingKey), false);
		}
	}

	@Override
	public void add(ExecutionDataItem executionDataItem, XYIntervalSeriesCollection executionsDataset,
			ExecutionsRenderer executionsRenderer) {
		int series = getSeries(getRenderingKey(executionDataItem.getBackReference()));
		executionsDataset.getSeries(series).add(executionDataItem, false);
	}

	@Override
	public void add(DependencyDataItem dependencyDataItem, XYEdgeSeriesCollection dependenciesDataset,
			DependenciesRenderer dependenciesRenderer) {
		int series = getSeries(getRenderingKey(dependencyDataItem.getBackReference()));
		dependenciesDataset.getSeries(series).add(dependencyDataItem, false);
	}

	@Override
	public void add(DependencyAnnotation dependencyAnnotation, XYEdgeSeriesCollection dependenciesDataset,
			DependenciesRenderer dependenciesRenderer) {
		int series = getSeries(getRenderingKey(dependencyAnnotation.getBackReference()));
		configureDependencyAnnotation(dependencyAnnotation, dependenciesRenderer, series);
		dependenciesRenderer.addAnnotation(dependencyAnnotation);
	}
}
