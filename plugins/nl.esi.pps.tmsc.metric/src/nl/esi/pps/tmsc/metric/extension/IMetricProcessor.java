/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.metric.extension;

import java.util.Collection;

import org.eclipse.xtext.xbase.lib.Pair;

import nl.esi.pps.architecture.deployed.Host;
import nl.esi.pps.architecture.specified.Component;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.metric.Metric;
import nl.esi.pps.tmsc.metric.MetricInstance;

public interface IMetricProcessor {
	/**
	 * Returns true if this metric should be presented to the user for the provided
	 * TMSC.
	 * 
	 * @param tmsc Optional, the TMSC to resolve this metric against,
	 *             <code>null</code> if metric analysis is applied on an IFile.
	 * @return <code>true</code> if this metric can be resolved in
	 *         <code>tmsc</code>.
	 */
	default boolean isEnabled(FullScopeTMSC tmsc) {
		return true;
	}

	/**
	 * Returns <code>true</code> if the {@link Component} with
	 * <code>componentName</code> that is traced on a {@link Host} with
	 * <code>hostName</code> is required to resolve the instances for this Metric.
	 * Limiting the number of required components allows this Metric to be validated
	 * against a longer trace period.
	 * <p>
	 * Please note that a <code>null</code> value for <code>componentName</code>
	 * should be considered a wild-card, hence this method should also return
	 * <code>true</code> when a component running on that host is required.
	 * </p>
	 * <p>
	 * <b>NOTE:</b> Currently only a single host is supported to resolve instances.
	 * In other words: Automatic creation of multi-host TMSCs is not supported yet.
	 * </p>
	 * 
	 * @see IMetricProcessor#resolveInstances(FullScopeTMSC)
	 */
	default boolean isRequiredToResolveInstances(String hostName, String componentName) {
		return true;
	}

	/**
	 * Returns the active configuration for a trace if a metric supports multiple
	 * configurations (e.g. different budgets for different configurations).
	 */
	default String getConfiguration(FullScopeTMSC tmsc) {
		return null;
	}

	/**
	 * Returns the metric budget for the active configuration.
	 * <p>
	 * Please note that this function is only called if the budget is not specified
	 * in the extension point. This allows the implementer of a metric to choose
	 * whether budgets are defined in the extension point or in the implementation.
	 * </p>
	 * 
	 * @param configuration the configuration to use, as provided by
	 *                      {@link #getConfiguration(FullScopeTMSC)}, can be
	 *                      {@code null}
	 */
	default Long getBudget(String configuration, Long defaultBudget) {
		return defaultBudget;
	}

	/**
	 * Resolves the {@link MetricInstance}s in <code>tmsc</code> for this
	 * Metric.<br>
	 * <b>NOTE:</b> The instances do not need to be added to a {@link Metric}, this
	 * will be taken care of by the {@link MetricProcessor}.
	 * 
	 * @param tmsc          the tmsc to resolve the instances from
	 * @param configuration the configuration to use, as provided by
	 *                      {@link #getConfiguration(FullScopeTMSC)}, can be
	 *                      {@code null}
	 * @return the resolved Metric instances in <code>tmsc</code>
	 */
	Collection<MetricInstance> resolveInstances(FullScopeTMSC tmsc, String configuration);

	/**
	 * Returns time-window, as a {@link Pair} of {@link Long}s, that is required
	 * when detailed analysis are performed for this Metric.
	 */
	default Pair<Long, Long> getAnalysisTimeWindow(MetricInstance metricInstance) {
		// Make sure that all parent executions of the KPI instance are reconstructed
		Execution fromExecRoot = metricInstance.getFrom().getExecution().getRoot();
		Execution toExecRoot = metricInstance.getTo().getExecution().getRoot();
		return Pair.of(Long.min(fromExecRoot.getStartTime(), toExecRoot.getStartTime()),
				Long.max(fromExecRoot.getEndTime(), toExecRoot.getEndTime()));
	}

	/**
	 * Subclasses may override this method to limit the scope of the activity TMSC
	 * that is used for analyzing an instance of this metric.
	 */
	default boolean isActivityCutOff(Dependency dependency, MetricInstance metricInstance) {
		return false;
	}
}
