/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.metric.^extension

import java.util.Map
import nl.esi.pps.tmsc.Dependency
import nl.esi.pps.tmsc.FullScopeTMSC
import nl.esi.pps.tmsc.metric.Metric
import nl.esi.pps.tmsc.metric.MetricFactory
import nl.esi.pps.tmsc.metric.MetricInstance
import nl.esi.pps.tmsc.metric.MetricModel
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

@FinalFieldsConstructor
class MetricProcessor {
    static extension val MetricFactory m_metric = MetricFactory.eINSTANCE
    
    // No accessors for configuration budgets
    val Map<String, Long> configurationBudgets = newLinkedHashMap

    @Accessors
    val String id
    @Accessors
    val String name
    @Accessors
    val String category
    @Accessors
    val String modelId
    // No accessors for default budget
    val Long defaultBudget
    // No accessors for processor
    val IMetricProcessor metricProcessor
    
    /**
     * Adds a budget for a configuration
     */
    def boolean addBudget(String configuration, Long budget) {
        if (configurationBudgets.containsKey(configuration)) {
            return false
        }
        configurationBudgets.put(configuration, budget)
        return true
    }

    /**
     * Removes a budget for a configuration
     */
    def void removeBudget(String configuration) {
        configurationBudgets.remove(configuration)
    }
    
    /**
     * @see IMetricProcessor#isEnabled(FullScopeTMSC)
     */
    def boolean isEnabled(FullScopeTMSC tmsc) {
        return metricProcessor.isEnabled(tmsc)
    }
    
    /**
     * @see IMetricProcessor#isRequiredToResolveInstances(String, String)
     */
    def boolean isRequiredToResolveInstances(String hostName, String componentName) {
        return metricProcessor.isRequiredToResolveInstances(hostName, componentName);
    }

    /**
     * Resolves the instances for this metric and adds them to the 
     * {@link #getMetricModel(FullScopeTMSC) default metric model}.
     * 
     * @throws IllegalArgumentException if <code>tmsc</code> is not contained in a {@link Resource}
     * @see #getMetricModel(FullScopeTMSC)
     */
    def Metric analyse(FullScopeTMSC tmsc) {
        return analyse(tmsc, tmsc.metricModel)
    }
    
    /**
     * Resolves the instances for this metric and adds them to the {@code metricModel}.
     */
    def Metric analyse(FullScopeTMSC tmsc, MetricModel metricModel) {
        val metricConfiguration = metricProcessor.getConfiguration(tmsc)
        val metricBudget = configurationBudgets.getOrDefault(metricConfiguration,
            metricProcessor.getBudget(metricConfiguration, defaultBudget))
        val metricInstances = metricProcessor.resolveInstances(tmsc, metricConfiguration)
        if (metricInstances.isEmpty) {
            return null
        }
        val metric = createMetric(metricModel)
        metric.budget = metricBudget
        metric.configuration = metricConfiguration
        metric.tmscs += tmsc
        metric.instances += metricInstances
        return metric
    }
    
    /**
     * Convenience method that finds the Metric model in the resource of the TMSC, or
     * creates a new Metric model if it could not be found (and adds it to the
     * resource).
     * 
     * @throws IllegalArgumentException if <code>tmsc</code> is not contained in a
     *                                  {@link Resource}
     * @see EObject#eResource()
     */
    static def MetricModel getMetricModel(FullScopeTMSC tmsc) {
        if (tmsc.eResource === null) {
            throw new IllegalArgumentException('TMSC should be contained in a resource')
        }
        var metricModel = tmsc.eResource.contents.filter(MetricModel).head
        if (metricModel === null) {
            metricModel = createMetricModel
            tmsc.eResource.contents += metricModel
        }
        return metricModel
    }

    private static def Metric createMetric(MetricProcessor metricExtension, MetricModel metricModel) {
        EcoreUtil::deleteAll(metricModel.metrics.filter[it.id == metricExtension.id].toList, true)
        
        var metricCategory = metricModel.categories.findFirst[it.name == metricExtension.category]
        if (metricCategory === null) {
            metricCategory = createMetricCategory
            metricCategory.name = metricExtension.category
            metricModel.categories += metricCategory
        }
        
        val metric = createMetric
        metric.id = metricExtension.id
        metric.name = metricExtension.name
        metric.category = metricCategory
        metricModel.metrics += metric
        return metric
    }
    
    /**
     * @see IMetricProcessor#getAnalysisTimeWindow(MetricInstance)
     */
    def Pair<Long, Long> getAnalysisTimeWindow(MetricInstance metricInstance) {
        return metricProcessor.getAnalysisTimeWindow(metricInstance)
    }

    /**
     * @see IMetricProcessor#isActivityCutOff(Dependency, MetricInstance)
     */
    def boolean isActivityCutOff(Dependency dependency, MetricInstance metricInstance) {
        return metricProcessor.isActivityCutOff(dependency, metricInstance)
    }

    override toString() {
        return id
    }
}