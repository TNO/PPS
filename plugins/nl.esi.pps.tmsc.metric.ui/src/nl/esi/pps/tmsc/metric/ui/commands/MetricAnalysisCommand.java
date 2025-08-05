/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.metric.ui.commands;

import static org.eclipse.lsat.common.queries.QueryableIterable.from;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.lsat.common.emf.ecore.util.EcoreUtility;

import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.metric.Metric;
import nl.esi.pps.tmsc.metric.MetricModel;
import nl.esi.pps.tmsc.metric.extension.MetricProcessor;

public class MetricAnalysisCommand extends AbstractCommand {
	private final FullScopeTMSC tmsc;
	private final Set<MetricProcessor> metricProcessors;

	private List<Metric> metrics;

	public MetricAnalysisCommand(Set<MetricProcessor> metricProcessors, FullScopeTMSC tmsc) {
		super("Metric Analysis");
		this.metricProcessors = metricProcessors;
		this.tmsc = tmsc;
	}

	@Override
	protected boolean prepare() {
		return tmsc.eResource() != null;
	}

	@Override
	public void execute() {
		metrics = new ArrayList<>(metricProcessors.size());
		for (MetricProcessor metricProcessor : metricProcessors) {
			Metric metric = metricProcessor.analyse(tmsc);
			if (metric != null) {
				metrics.add(metric);
			}
		}
	}

	@Override
	public Collection<?> getAffectedObjects() {
		if (metrics == null) {
			return Collections.singleton(tmsc);
		} else if (metrics.isEmpty()) {
			return Collections.emptySet();
		}
		return metrics;
	}

	@Override
	public boolean canUndo() {
		return metrics != null;
	}

	@Override
	public void undo() {
		Set<MetricModel> metricModels = from(metrics).xcollectOne(EObject::eContainer).objectsOfKind(MetricModel.class).asSet();
		EcoreUtility.deleteAll(metrics, true);
		EcoreUtility.deleteAll(from(metricModels).select(mm -> mm.getMetrics().isEmpty()).asList(), true);
		metrics = null;
	}

	@Override
	public void redo() {
		execute();
	}
}
