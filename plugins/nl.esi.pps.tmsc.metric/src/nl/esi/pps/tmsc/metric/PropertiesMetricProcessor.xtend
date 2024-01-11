/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.metric

import java.io.Serializable
import java.text.ParseException
import java.util.Collections
import java.util.TreeSet
import nl.esi.emf.properties.xtend.PersistedProperty
import nl.esi.pps.preferences.PPSPreferences
import nl.esi.pps.tmsc.Dependency
import nl.esi.pps.tmsc.Event
import nl.esi.pps.tmsc.Execution
import nl.esi.pps.tmsc.FullScopeTMSC
import nl.esi.pps.tmsc.LifelineSegment
import nl.esi.pps.tmsc.metric.^extension.IMetricProcessor
import nl.esi.pps.tmsc.text.EDurationFormat
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class PropertiesMetricProcessor implements IMetricProcessor {
    protected static val Logger LOGGER = LoggerFactory.getLogger(PropertiesMetricProcessor)

    protected static extension val MetricFactory m_metric = MetricFactory.eINSTANCE

    public static val PROPERTY_METRIC_BUDGET = 'metricBudget'

    @PersistedProperty(FullScopeTMSC)
    public static val Serializable metricBudget

    public static val PROPERTY_METRIC_INSTANCE_FROM_ID = 'metricInstanceFromID'

    @PersistedProperty(Event)
    public static val Serializable metricInstanceFromID

    public static val PROPERTY_METRIC_INSTANCE_TO_ID = 'metricInstanceToID'

    @PersistedProperty(Event)
    public static val Serializable metricInstanceToID

    public static val PROPERTY_METRIC_ACTIVITY_CUT_OFF = 'metricActivityCutOff'

    @PersistedProperty(Dependency, Execution)
    public static val Serializable metricActivityCutOff

    override isEnabled(FullScopeTMSC tmsc) {
        return tmsc !== null && PPSPreferences.isAdvancedFeaturesEnabled()
    }

    override getConfiguration(FullScopeTMSC tmsc) {
        // We (ab)use the configuration to pass the specified budget,
        // also see #getBudget(String, Long)
        switch (budget: tmsc.metricBudget) {
            case null:
                return null
            Long: {
                // A long value is considered to be nanos, pass though
                return budget.toString
            }
            Number: {
                // Any other number is considered an SI value (seconds), hence multiply to get nanos
                return (budget.doubleValue * 1e9).longValue.toString
            }
            String: {
                // Text will be parsed using the duration format
                try {
                    return EDurationFormat.eINSTANCE.parse(budget).longValue.toString
                } catch (ParseException e) {
                    LOGGER.error('''Invalid metricBudget value: «budget»''', e)
                }
            }
            default: {
                LOGGER.error('''Invalid metricBudget value '«budget»', only number or duration is allowed.''')
            }
        }
        return null
    }

    override getBudget(String configuration, Long defaultBudget) {
        if (configuration !== null) {
            try {
                return Long.parseLong(configuration)
            } catch (NumberFormatException e) {
                // Should not happen, just report it.
                LOGGER.error('''Invalid metricBudget value: «configuration»''', e)
            }
        }
        return defaultBudget
    }

    override resolveInstances(FullScopeTMSC tmsc, String configuration) {
        val fromEvents = tmsc.events.toMap[metricInstanceFromID]
        val toEvents = tmsc.events.toMap[metricInstanceToID]

        val instances = new TreeSet
        instances += fromEvents.keySet.filterNull
        instances.retainAll(toEvents.keySet)

        val metricInstances = newArrayList
        for (instance : instances) {
            val metricInstance = createMetricInstance
            metricInstance.id = String::valueOf(instance)
            metricInstance.from = fromEvents.get(instance)
            metricInstance.to = toEvents.get(instance)
            metricInstances += metricInstance
        }
        return Collections::unmodifiableCollection(metricInstances)
    }
    
    override isActivityCutOff(Dependency dependency, MetricInstance metricInstance) {
        var cutOffValue = dependency.metricActivityCutOff
        if (cutOffValue === null) {
            if (dependency instanceof LifelineSegment) {
                cutOffValue = dependency.activeExecution.metricActivityCutOff
            }
        }
        return isActivityCutOff(cutOffValue)
    }
    
    def private boolean isActivityCutOff(Serializable cutOffValue) {
        switch (cutOffValue) {
            case null:
                return false
            Boolean: {
                return cutOffValue
            }
            String: {
                return Boolean.parseBoolean(cutOffValue)
            }
            default: {
                LOGGER.error('''Invalid metricActivityCutOff value '«cutOffValue»', only boolean is allowed.''')
                return false
            }
        }
    }
}
