/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.analysis.ui.rendering

import java.awt.geom.Point2D
import nl.esi.pps.tmsc.Dependency
import nl.esi.pps.tmsc.Execution
import nl.esi.pps.tmsc.rendering.plot.EnumRenderingStrategy
import nl.esi.pps.tmsc.rendering.plot.EnumRenderingStrategy.VoidRenderingKey
import nl.esi.pps.tmsc.viewers.plot.DependenciesRenderer
import nl.esi.pps.tmsc.viewers.plot.DependencyDataItem
import nl.esi.pps.tmsc.viewers.plot.ExecutionsRenderer
import org.eclipse.trace4cps.common.jfreechart.data.xy.XYEdgeSeriesCollection
import org.jfree.data.xy.XYIntervalSeriesCollection

import static nl.esi.pps.tmsc.analysis.ui.rendering.CriticalPathRenderingKey.*

import static extension nl.esi.pps.tmsc.analysis.ActivityAnalysis.*
import static extension nl.esi.pps.tmsc.analysis.CriticalPathAnalysis.*
import static extension nl.esi.pps.tmsc.analysis.RootCauseAnalysis.*
import static extension nl.esi.pps.tmsc.analysis.TimeBoundOutlierAnalysis.*
import org.eclipse.jface.viewers.Viewer

class CriticalPathRenderingStrategy extends EnumRenderingStrategy<VoidRenderingKey, CriticalPathRenderingKey> {
    public static val ID = 'nl.esi.pps.tmsc.analysis.ui.rendering.critical_path';

    new () {
        super(VoidRenderingKey, CriticalPathRenderingKey)
    }
    
    override protected getRenderingKey(Execution execution) {
        // All executions are rendered as default, see VoidRenderingKey
        return null
    }
    
    override protected getRenderingKey(Dependency dependency) {
        return switch it: dependency {
            case rootCause && activity: ROOT_CAUSE_ACTIVITY
            case rootCause: ROOT_CAUSE_SCHEDULED
            case criticalOutlier && activity: OUTLIER_ACTIVITY
            case criticalOutlier: OUTLIER_SCHEDULED
            case critical && activity: CRITICAL_ACTIVITY
            case critical: CRITICAL_SCHEDULED
        }
    }
    
    def private isCriticalOutlier(Dependency dependency) {
        return dependency.critical && dependency.isSetTimeBoundOutlierThreshold &&
            dependency.timeBound > dependency.timeBoundOutlierThreshold
    }
    
    override select(Viewer viewer, Object parentElement, Object element) {
        // Behave like highlight, always show dependencies on the critical path
        if (element instanceof Dependency) {
            if (element instanceof Execution || element.critical || element.rootCause) {
                return true
            }
        }
        super.select(viewer, parentElement, element)
    }
    
    override add(DependencyDataItem dependencyDataItem, XYEdgeSeriesCollection dependenciesDataset, DependenciesRenderer dependenciesRenderer) {
        // FIXME: So this is tricky. ActivityAnalysis adds epoch dependencies to the model. These dependencies represent
        // the release time on the thread with respect to the from of the metric instance. Therefore their source is 
        // connected to the from of the metric, but the dependency should be visualized as a horizontal arrow on the 
        // (release time) thread, this is done in the code below
        // We should consider if these epoch dependencies should be of separate type (e.g. AnalysisDependency), such 
        // that they can be hidden by default.
        var dataItem = dependencyDataItem
        if (dependencyDataItem.backReference.isEpoch) {
            dataItem = new DependencyDataItem(
                new Point2D.Double(dependencyDataItem.x0Value, dependencyDataItem.y1Value),
                new Point2D.Double(dependencyDataItem.x1Value, dependencyDataItem.y1Value),
                dependencyDataItem.backReference)
        }
        super.add(dataItem, dependenciesDataset, dependenciesRenderer)
    }
    
    override protected hideEmptySeriesInLegend(XYEdgeSeriesCollection dependenciesDataset, DependenciesRenderer dependenciesRenderer, XYIntervalSeriesCollection executionsDataset, ExecutionsRenderer executionsRenderer) {
        super.hideEmptySeriesInLegend(dependenciesDataset, dependenciesRenderer, executionsDataset, executionsRenderer)
        
        // Only the legends of the activity variants are rendered as their color is equal to the scheduled variant, 
        // so if the scheduled variant is not empty, make sure that its activity variant is visible in the legend.
        if (dependenciesDataset.getItemCount(CRITICAL_SCHEDULED.series) > 0) {
            dependenciesRenderer.setSeriesVisibleInLegend(CRITICAL_ACTIVITY.series, true, false)
        }
        if (dependenciesDataset.getItemCount(OUTLIER_SCHEDULED.series) > 0) {
            dependenciesRenderer.setSeriesVisibleInLegend(OUTLIER_ACTIVITY.series, true, false)
        }
        if (dependenciesDataset.getItemCount(ROOT_CAUSE_SCHEDULED.series) > 0) {
            dependenciesRenderer.setSeriesVisibleInLegend(ROOT_CAUSE_ACTIVITY.series, true, false)
        }
    }
}
