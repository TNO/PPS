/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.metric;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.EMFPlugin.EclipsePlugin;
import org.eclipse.emf.ecore.plugin.RegistryReader;

import nl.esi.pps.tmsc.metric.extension.IMetricProcessor;
import nl.esi.pps.tmsc.metric.extension.MetricProcessor;

/**
 * Reads Metric extensions only once and allow for dynamic registration of Metrics.
 */
class MetricRegistryReader extends RegistryReader {
	private static final String METRIC_PROCESSORS_EXTENSION_POINT_ID = "processors";
	private static final String TAG_PROCESSOR = "MetricProcessor";
	private static final String TAG_BUDGET = "Budget";

	private final Map<String, MetricProcessor> metricProcessors = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

	private final EclipsePlugin plugin;

	public MetricRegistryReader(EclipsePlugin plugin) {
		super(Platform.getExtensionRegistry(), plugin.getBundle().getSymbolicName(), METRIC_PROCESSORS_EXTENSION_POINT_ID);
		this.plugin = plugin;
	}

	/**
	 * Returns an unmodifiable {@link Map} containing all registered Metric processors,
	 * mapped by their {@link MetricProcessor#getId() id}.
	 * 
	 * @return a {@link Map} containing all registered Metric processors, mapped by
	 *         their {@link MetricProcessor#getId() id}.
	 */
	public Map<String, MetricProcessor> getMetricProcessors() {
		return Collections.unmodifiableMap(metricProcessors);
	}

	@Override
	protected boolean readElement(IConfigurationElement element, boolean add) {
		boolean recognized = false;
		if (element.getName().equals(TAG_PROCESSOR)) {
			recognized = true;

			final String id = element.getAttribute("id");
			if (id == null || !id.matches("[^\\\\/:\\*\\?\\\"<>\\|]+")) {
				plugin.getLog().error(
						"The Metric processor id cannot be empty or contain '\\ / : * ? \" < > |' characters for Metric: "
								+ element.getContributor().getName() + ":" + id);
				return recognized;
			}

			if (!add) {
				metricProcessors.remove(id);
				return recognized;
			}

			final String name = element.getAttribute("name");
			if (name == null || name.contains("/")) {
				plugin.getLog().error("The Metric processor name cannot contain '/' characters for Metric: "
						+ element.getContributor().getName() + ":" + id);
				return recognized;
			}

			String category = element.getAttribute("category");
			if (null == category) {
				category = plugin.getString("defaultMetricProcessorCategory");
			}

			String model_id = element.getAttribute("model_id");
			if (null == model_id || model_id.trim().isEmpty()) {
				model_id = id;
			} else if (!model_id.matches("[^\\\\/:\\*\\?\\\"<>\\|]+")) {
				plugin.getLog().error(
						"The Metric processor model id cannot contain '\\ / : * ? \" < > |' characters for Metric: "
								+ element.getContributor().getName() + ":" + id);
				return recognized;
			}

			final String defaultBudgetStr = element.getAttribute("budget");
			Long defaultBudget = null;
			if (null != defaultBudgetStr) {
				try {
					defaultBudget = Long.parseLong(defaultBudgetStr);
				} catch (NumberFormatException e) {
					plugin.getLog().error("The Metric processor budget must be a natural number for Metric: "
							+ element.getContributor().getName() + ":" + id);
					return recognized;
				}
			}

			try {
				final IMetricProcessor processor = (IMetricProcessor) element.createExecutableExtension("processor");
				final MetricProcessor current = metricProcessors.putIfAbsent(id,
						new MetricProcessor(id, name, category, model_id, defaultBudget, processor));
				if (null != current) {
					plugin.getLog().error("Metric with id '" + id + "' is already defined, ignoring processor from: "
							+ element.getContributor().getName());
				}
			} catch (CoreException e) {
				plugin.getLog().error(
						"The Metric processor can't be created for Metric: " + element.getContributor().getName() + ":" + id,
						e);
			}
		} else if (element.getName().equals(TAG_BUDGET)) {
			recognized = true;

			final String metricId = ((IConfigurationElement) element.getParent()).getAttribute("id");
			final MetricProcessor metricProcessor = metricProcessors.get(metricId);
			if (null == metricProcessor) {
				plugin.getLog().error("Parent Metric cannot be found for budget for Metric: "
						+ element.getContributor().getName() + ":" + metricId);
				return recognized;
			}

			final String configurationStr = element.getAttribute("configuration");
			if (null == configurationStr || configurationStr.isEmpty()) {
				plugin.getLog().error("The Metric processor budget configuraton is mandatory for Metric: "
						+ element.getContributor().getName() + ":" + metricId);
				return recognized;
			}

			if (!add) {
				metricProcessor.removeBudget(configurationStr);
				return recognized;
			}

			final String budgetStr = element.getAttribute("budget");
			Long budget = null;
			if (null != budgetStr) {
				try {
					budget = Long.parseLong(budgetStr);
				} catch (NumberFormatException e) {
					plugin.getLog().error("The Metric processor budget must be a natural number for configuration"
							+ configurationStr + " on Metric: " + element.getContributor().getName() + ":" + metricId);
					return recognized;
				}
			}

			if (!metricProcessor.addBudget(configurationStr, budget)) {
				plugin.getLog().error("Budget already defined for configuration" + configurationStr + " on Metric: "
						+ element.getContributor().getName() + ":" + metricId);
				return recognized;
			}
		}

		return recognized;
	}
}
