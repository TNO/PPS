/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
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
import nl.esi.pps.tmsc.EventType
import nl.esi.pps.tmsc.rendering.plot.DefaultRenderingStrategy
import nl.esi.pps.tmsc.text.EDurationFormat
import nl.esi.pps.tmsc.viewers.plot.DependenciesRenderer
import nl.esi.pps.tmsc.viewers.plot.EventNoteAnnotation
import nl.esi.pps.tmsc.viewers.plot.ExecutionDataItem
import nl.esi.pps.tmsc.viewers.plot.ExecutionsRenderer
import nl.esi.pps.tmsc.viewers.plot.ExecutionsVisibility
import org.eclipse.trace4cps.common.jfreechart.data.xy.XYEdgeSeriesCollection
import org.jfree.data.xy.XYIntervalSeriesCollection

import static extension nl.esi.pps.tmsc.analysis.SlackAnalysis.*
import static extension org.eclipse.lsat.common.xtend.Queries.*

class SlackRenderingStrategy extends DefaultRenderingStrategy {
    public static val ID = 'nl.esi.pps.tmsc.analysis.ui.rendering.slack';
    
    override preRendering(XYEdgeSeriesCollection dependenciesDataset, DependenciesRenderer dependenciesRenderer, XYIntervalSeriesCollection executionsDataset, ExecutionsRenderer executionsRenderer) {
        super.preRendering(dependenciesDataset, dependenciesRenderer, executionsDataset, executionsRenderer)
        // This renderer requires annotations on executions to be visible 
        ExecutionsVisibility.ALL.apply(executionsRenderer, false)
    }

    override add(ExecutionDataItem executionDataItem, XYIntervalSeriesCollection executionsDataset,
        ExecutionsRenderer executionsRenderer) {
        super.add(executionDataItem, executionsDataset, executionsRenderer)
        executionsRenderer.addSlackAnnotation(executionDataItem, EventType::ENTRY)
        executionsRenderer.addSlackAnnotation(executionDataItem, EventType::EXIT)
    }

    def private void addSlackAnnotation(ExecutionsRenderer executionsRenderer, ExecutionDataItem executionDataItem,
        EventType eventType) {
        val event = eventType == EventType::ENTRY
                ? executionDataItem.backReference.entry
                : executionDataItem.backReference.exit
        val xValue = eventType == EventType::ENTRY ? executionDataItem.XLowValue : executionDataItem.XHighValue

        val tmscs = event.scopes.union(event.tmsc)
        val slacks = tmscs.map[tmsc|event.getSlack(tmsc)].filter[slack|slack > 0].toList

        if (!slacks.isEmpty) {
            val location = new Point2D.Double(xValue, executionDataItem.YValue)
            val note = EDurationFormat::eINSTANCE.format(slacks.min)
            executionsRenderer.addAnnotation(new EventNoteAnnotation(location, note, event))
        }
    }
}
