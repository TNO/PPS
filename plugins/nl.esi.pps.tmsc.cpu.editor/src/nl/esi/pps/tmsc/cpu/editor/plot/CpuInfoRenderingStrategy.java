/*
 * Copyright (c) 2018-2026 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.cpu.editor.plot;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.lsat.common.queries.QueryableIterable;
import org.eclipse.trace4cps.common.jfreechart.chart.axis.Section;
import org.eclipse.trace4cps.common.jfreechart.chart.axis.SectionAxis;
import org.eclipse.trace4cps.common.jfreechart.data.xy.XYEdgeSeriesCollection;
import org.eclipse.trace4cps.common.jfreechart.ui.gantt.XYGanttDataItem;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.Range;
import org.jfree.data.xy.XYIntervalSeriesCollection;

import nl.esi.pps.preferences.PPSPreferences;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.Lifeline;
import nl.esi.pps.tmsc.LifelineSegment;
import nl.esi.pps.tmsc.cpu.TmscCpuInfoQueries;
import nl.esi.pps.tmsc.rendering.plot.EnumRenderingStrategy;
import nl.esi.pps.tmsc.rendering.plot.EnumRenderingStrategy.VoidRenderingKey;
import nl.esi.pps.tmsc.viewers.plot.DependenciesRenderer;
import nl.esi.pps.tmsc.viewers.plot.DependencyDataItem;
import nl.esi.pps.tmsc.viewers.plot.ExecutionDataItem;
import nl.esi.pps.tmsc.viewers.plot.ExecutionsRenderer;

public class CpuInfoRenderingStrategy extends EnumRenderingStrategy<CpuInfoRenderingKey, VoidRenderingKey> {
	private XYIntervalSeriesCollection executionsDataset;
	private Map<Lifeline, Range> lifelineRanges;

	public CpuInfoRenderingStrategy() {
		super(CpuInfoRenderingKey.class, VoidRenderingKey.class);
	}

	@Override
	public boolean isSupported(EditingDomain editingDomain) {
		return PPSPreferences.isAdvancedFeaturesEnabled() && 
			QueryableIterable.from(editingDomain.getResourceSet().getResources())
				.collect(Resource::getContents)
				.objectsOfKind(FullScopeTMSC.class)
				.exists(TmscCpuInfoQueries::hasCpuInfo);
	}
	
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (element instanceof Lifeline lifeline) {
			return TmscCpuInfoQueries.hasCpuInfo(lifeline);
		} else if (element instanceof Execution execution) {
			// Results in every lifeline getting 1 height unit
			// Although we are not rendering executions, we need the root level executions 
			// in order for the lifeline to be rendered.
			return execution.getParent() == null;
		} else if (element instanceof LifelineSegment segment) {
			return segment.getStartTime() != null && segment.getEndTime() != null;
		} else if (element instanceof Dependency) {
			return false;
		}
		return super.select(viewer, parentElement, element);
	}
	
	@Override
	public void preRendering(XYEdgeSeriesCollection dependenciesDataset, DependenciesRenderer dependenciesRenderer,
			XYIntervalSeriesCollection executionsDataset, ExecutionsRenderer executionsRenderer) {
		this.executionsDataset = executionsDataset;
		this.lifelineRanges = new HashMap<>();
		super.preRendering(dependenciesDataset, dependenciesRenderer, executionsDataset, executionsRenderer);
	}
	
	@Override
	public Section addLifelineSection(SectionAxis axis, Lifeline lifeline, String label, double length) {
		Section section = super.addLifelineSection(axis, lifeline, label, 10);
		section.setGridBandNumberRange(new Range(0, 100), true);
		this.lifelineRanges.put(lifeline, section.getRange());
		return section;
	}

	@Override
	public void postRendering(XYEdgeSeriesCollection dependenciesDataset, DependenciesRenderer dependenciesRenderer,
			XYIntervalSeriesCollection executionsDataset, ExecutionsRenderer executionsRenderer) {
		super.postRendering(dependenciesDataset, dependenciesRenderer, executionsDataset, executionsRenderer);
		executionsRenderer.setDefaultItemLabelsVisible(false);
		executionsRenderer.setDrawBarOutline(false);
		this.executionsDataset = null;
		this.lifelineRanges = null;
	}
	
	@Override
	public void add(ExecutionDataItem executionDataItem, XYIntervalSeriesCollection executionsDataset,
			ExecutionsRenderer executionsRenderer) {
		// We are not rendering the root executions, but we need them for the life-line to be rendered.
		// super.add(executionDataItem, executionsDataset, executionsRenderer);
	}
	
	@Override
	public void add(DependencyDataItem dataItem, XYEdgeSeriesCollection dataSet, DependenciesRenderer renderer) {
		Dependency dependency = dataItem.getBackReference();
		if (dependency instanceof LifelineSegment segment) {
			Range cpuSectionRange = lifelineRanges.get(segment.getLifeline());
			if (cpuSectionRange == null) {
				return;
			}

			BigDecimal cpuOffset = BigDecimal.ZERO;
			long onCpuNanos = TmscCpuInfoQueries.getOnCpuNanos(segment);
			if (onCpuNanos > 0) {
				BigDecimal cpuOccupation = BigDecimal.valueOf(onCpuNanos)
						.divide(BigDecimal.valueOf(segment.getDuration()), 10, RoundingMode.HALF_UP);
				XYGanttDataItem<LifelineSegment> item = new XYGanttDataItem<>(cpuSectionRange, cpuOccupation,
						cpuOffset, dataItem.getX0(), dataItem.getX1(), PlotOrientation.VERTICAL, segment);
				this.executionsDataset.getSeries(getSeries(CpuInfoRenderingKey.ON_CPU)).add(item, true);
				cpuOffset = cpuOffset.add(cpuOccupation);
			}
			long waitCpuNanos = TmscCpuInfoQueries.getWaitCpuNanos(segment);
			if (waitCpuNanos > 0) {
				BigDecimal cpuOccupation = BigDecimal.valueOf(waitCpuNanos)
						.divide(BigDecimal.valueOf(segment.getDuration()), 10, RoundingMode.HALF_UP);
				XYGanttDataItem<LifelineSegment> item = new XYGanttDataItem<>(cpuSectionRange, cpuOccupation,
						cpuOffset, dataItem.getX0(), dataItem.getX1(), PlotOrientation.VERTICAL, segment);
				this.executionsDataset.getSeries(getSeries(CpuInfoRenderingKey.WAIT_CPU)).add(item, true);
				cpuOffset = cpuOffset.add(cpuOccupation);
			}
			long waitOtherNanos = TmscCpuInfoQueries.getWaitOtherNanos(segment);
			if (waitOtherNanos > 0) {
				BigDecimal cpuOccupation = BigDecimal.valueOf(waitOtherNanos)
						.divide(BigDecimal.valueOf(segment.getDuration()), 10, RoundingMode.HALF_UP);
				XYGanttDataItem<LifelineSegment> item = new XYGanttDataItem<>(cpuSectionRange, cpuOccupation,
						cpuOffset, dataItem.getX0(), dataItem.getX1(), PlotOrientation.VERTICAL, segment);
				this.executionsDataset.getSeries(getSeries(CpuInfoRenderingKey.WAIT_OTHER)).add(item, true);
				cpuOffset = cpuOffset.add(cpuOccupation);
			}
		}
	}
	
	@Override
	protected CpuInfoRenderingKey getRenderingKey(Execution execution) {
		// Not used, not showing executions
		return null;
	}
	
	@Override
	protected VoidRenderingKey getRenderingKey(Dependency dependency) {
		// Not used, not showing dependencies
		return null;
	}
}
