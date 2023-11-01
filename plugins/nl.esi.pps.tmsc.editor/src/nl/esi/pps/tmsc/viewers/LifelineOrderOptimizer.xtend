/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.viewers

import com.google.common.graph.Graph
import com.google.common.graph.GraphBuilder
import com.google.common.graph.MutableGraph
import java.util.ArrayList
import java.util.Collection
import java.util.List
import java.util.Map
import nl.esi.pps.common.emf.synchronizedtiming.range.TimeRange
import nl.esi.pps.tmsc.Lifeline
import nl.esi.pps.tmsc.Message
import nl.esi.pps.tmsc.Reply
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import static extension org.eclipse.lsat.common.xtend.Queries.*

class LifelineOrderOptimizer {
    static val Logger LOGGER = LoggerFactory.getLogger(LifelineOrderOptimizer);

    private new() {
        // Empty for utility classes
    }
    
    static def Collection<Lifeline> optimizeOrder(TimeRange timeRange, Lifeline... lifelines) {
        // Build a life-line dependency graph based on the inter-lifeline messages that are currently visible
        val messages = filterMessages(timeRange, lifelines)
        val graph = GraphBuilder::directed.expectedNodeCount(lifelines.length).build
        lifelines.reverseView.forEach[ll|graph.addNode(ll)]
        // Replies are added as opposite dependencies
        messages.filter(Reply).forEach[graph.putEdge(source.lifeline, target.lifeline)]
        messages.reject(Reply).forEach[graph.putEdge(target.lifeline, source.lifeline)]

        // The first life-line in the list will be visible at the bottom of the view 
        val sortedLifelines = new ArrayList(lifelines.length)

        // Isolated life-lines do not communicate within the time-range, so they cannot be sorted
        // Most likely the user is also not that interested in these life-lines if he/she chooses
        // to optimize, so put them at the top of the view later
        val isolatedLifelines = graph.nodes.filter[ll|graph.degree(ll) == 0].toList
        isolatedLifelines.forEach[ll|graph.removeNode(ll)]
        sortedLifelines += isolatedLifelines

        // Keep disjunct groups of communicating life-lines close together
        for (disjunctGraph : graph.disjunct) {
            // Now base the order of the life-lines on the topological order
            val forward = disjunctGraph.nodesInTopologicalOrder
            sortedLifelines += forward

            if (forward.size != disjunctGraph.nodes.size) {
                // Detected a cycle, so topological order is not available, but
                // we can try to use the topological order as much as possible
                // by also adding the reverse topological order and only skip
                // ordering the cycle in the middle
                forward.forEach[ll|disjunctGraph.removeNode(ll)]

                val reverse = disjunctGraph.reverse.nodesInTopologicalOrder
                reverse.forEach[ll|disjunctGraph.removeNode(ll)]

                LOGGER.debug('Detected cycle, skipped ordering {}', disjunctGraph.nodes.map[executor.name].join(', '))
                sortedLifelines += disjunctGraph.nodes
                sortedLifelines += reverse.reverseView
            }
        }

        return sortedLifelines.reverse
    }

    static def filterMessages(TimeRange timeRange, Lifeline... lifelines) {
        val events = lifelines.flatMap[events].filter[timeRange.contains(timestamp)].toSet
        val outgoingMessages = events.flatMap[fullScopeOutgoingDependencies.filter(Message)]
                .reject[source.lifeline == target.lifeline].filter[events.contains(target)]
        val incomingMessages = events.flatMap[fullScopeIncomingDependencies.filter(Message)]
                .reject[source.lifeline == target.lifeline].filter[events.contains(source)]
        return outgoingMessages.union(incomingMessages).toSet
    }

    static def <N> List<MutableGraph<N>> disjunct(Graph<N> graph) {
        val Map<N, MutableGraph<N>> node2graph = newLinkedHashMap

        for (edge : graph.edges) {
            val sourceGraph = node2graph.get(edge.source)
            val targetGraph = node2graph.get(edge.target)
            if (sourceGraph !== null && targetGraph !== null) {
                if (sourceGraph === targetGraph) {
                    // Both events map to the same tmsc, so just add the dependency to that tmsc 
                    sourceGraph.putEdge(edge)
                } else if (sourceGraph.edges.size < targetGraph.edges.size) {
                    // Compare size and choose to copy the smaller to the other
                    sourceGraph.edges.forEach[e|targetGraph.putEdge(e)]
                    targetGraph.putEdge(edge)
                    // Now update the administration for all events pointing to the old list
                    sourceGraph.nodes.forEach[n|node2graph.put(n, targetGraph)]
                } else /* if (fromGraph.incomingEdges.size >= toGraph.incomingEdges.size) */ {
                    // Compare size and choose to copy the smaller to the other
                    targetGraph.edges.forEach[e|sourceGraph.putEdge(e)]
                    sourceGraph.putEdge(edge)
                    // Now update the administration for all events pointing to the old list
                    targetGraph.nodes.forEach[n|node2graph.put(n, sourceGraph)]
                }
            } else if (sourceGraph !== null) {
                // Just add the dependency to the existing graph
                sourceGraph.putEdge(edge)
                node2graph.put(edge.target, sourceGraph)
            } else if (targetGraph !== null) {
                // Just add the dependency to the existing graph
                targetGraph.putEdge(edge)
                node2graph.put(edge.source, targetGraph)
            } else /* if (sourceGraph === null && targetGraph === null) */ {
                // When both are not allocated to a graph yet then we set both on a new graph
                val newGraph = GraphBuilder::from(graph).build
                newGraph.putEdge(edge)
                node2graph.put(edge.source, newGraph)
                node2graph.put(edge.target, newGraph)
            }
        }

        // Return the unique graphs
        return node2graph.values.unique(false).toList
    }

    static def <N> List<N> getNodesInTopologicalOrder(Graph<N> graph) {
        val incomingEdges = graph.nodes.toMap([k|k], [newHashSet])
        graph.edges.forEach [
            incomingEdges.get(target) += source
        ]

        val result = new ArrayList(incomingEdges.size)

        // Try to sort as much as possible in reverse topological order
        var next = incomingEdges.removeFirst[k, v|v.isEmpty]?.key
        while (next !== null) {
            result += next
            for (crossReferences : incomingEdges.values) {
                crossReferences.remove(next)
            }
            next = incomingEdges.removeFirst[k, v|v.isEmpty]?.key
        }

        return result;
    }

    static def <N> MutableGraph<N> reverse(Graph<N> graph) {
        val reversed = GraphBuilder::from(graph).build
        graph.nodes.reverse.forEach[n|reversed.addNode(n)]
        graph.edges.forEach [
            reversed.putEdge(target, source)
        ]
        return reversed
    }
}
