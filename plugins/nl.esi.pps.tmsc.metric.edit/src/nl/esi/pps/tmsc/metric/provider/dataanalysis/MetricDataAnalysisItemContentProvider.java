/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.metric.provider.dataanalysis;

import java.util.Collections;
import java.util.Set;

import nl.esi.pps.tmsc.metric.Metric;
import nl.esi.pps.tmsc.metric.MetricInstance;
import nl.esi.pps.tmsc.provider.dataanalysis.IDataAnalysisItemContentProvider;

/**
 * Both {@link Metric} and {@link MetricInstance} support data analysis by providing
 * this {@link IDataAnalysisItemContentProvider}.
 */
public class MetricDataAnalysisItemContentProvider implements IDataAnalysisItemContentProvider {
	@Override
	public Set<String> getConfigurations(Object object) {
		return Collections.singleton(DEFAULT_CONFIGURATION);
	}

	@Override
	public String getTitle(Object object, String configuration) {
		return getMetric(object).getName();
	}

	@Override
	public Long getBudget(Object object, String configuration) {
		return getMetric(object).getBudget();
	}
	
	@Override
	public Iterable<MetricInstance> getSiblings(Object object, String configuration) {
		return getMetric(object).getInstances();
	}

	@Override
	public Long getDuration(Object object, Object sibling, String configuration) {
		if (sibling instanceof MetricInstance) {
			return ((MetricInstance) sibling).getDuration();
		}
		return null;
	}

	protected Metric getMetric(Object object) {
		if (object instanceof MetricInstance) {
			return ((MetricInstance) object).getMetric();
		}
		return (Metric) object;
	}
}