/**
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.analysis

import java.util.Collection
import java.util.Collections
import java.util.LinkedHashMap
import java.util.Map
import nl.esi.emf.properties.xtend.PersistedProperty
import nl.esi.pps.common.core.runtime.StatusLogger
import nl.esi.pps.tmsc.Dependency
import nl.esi.pps.tmsc.ITMSC
import nl.esi.pps.tmsc.ScopedTMSC
import nl.esi.pps.tmsc.analysis.rootcause.AdvancedRootCauseAnalysis
import nl.esi.pps.tmsc.compare.ArchitectureLifecycleStage
import nl.esi.pps.tmsc.compare.ITmscMatchResult
import nl.esi.pps.tmsc.compare.TmscIsomorphismMatcher
import nl.esi.pps.tmsc.metric.Metric
import nl.esi.pps.tmsc.metric.MetricInstance
import org.eclipse.core.runtime.IProgressMonitor

import static extension nl.esi.pps.tmsc.analysis.ActivityAnalysis.*
import static extension nl.esi.pps.tmsc.analysis.TimeBoundOutlierAnalysis.*
import static extension nl.esi.pps.tmsc.util.TmscQueries.*

class RootCauseAnalysis {
    extension val StatusLogger logger = new StatusLogger('nl.esi.pps.tmsc.analysis', 'Root Cause Analysis')

    @PersistedProperty(value=Dependency, unsettable=true)
    public static val boolean rootCause = false
    
    @PersistedProperty(ScopedTMSC)
    public static val boolean rootCauseAnalysisResult = false

    val ArchitectureLifecycleStage stage

    new() {
        this(ArchitectureLifecycleStage.IMPLEMENTED)
    }

    new(ArchitectureLifecycleStage stage) {
        this.stage = stage
    }

    def getStatus() {
        return logger.status
    }
    
    static def getRootCauses(ScopedTMSC scopedTMSC) {
        if (!scopedTMSC.isRootCauseAnalysisResult) {
            return Collections::emptyList
        }
        return scopedTMSC.dependencies.filter[isRootCause]
    }

    def ScopedTMSC analyseRootCause(MetricInstance metricInstance, IProgressMonitor monitor) {
        return analyseRootCause(Collections.singleton(metricInstance), metricInstance.metric, monitor).get(metricInstance)
    }
    
    def Map<MetricInstance, ScopedTMSC> analyseRootCause(Collection<MetricInstance> metricInstances, Metric _metric, IProgressMonitor monitor) {
        if (metricInstances === null || metricInstances.isEmpty) {
            error('Programming error, no metric instances provided for metric {}.', _metric.name)
            return Collections.emptyMap
        }
        if (metricInstances.exists[metric != _metric]) {
            error('Programming error, only expected metric instances for metric {}.', _metric.name)
            return Collections.emptyMap
        }
        if (_metric.budget === null) {
            info('Skipped root-cause analysis as budget is not set for metric {}.', _metric.name)
            return Collections.emptyMap
        }

        metricInstances.reject[exceedsBudget].forEach [
            info('Skipped root-cause analysis for metric instance {} as budget is already met.', name)
        ]
        val instancesToAnalyse = metricInstances.filter[exceedsBudget].toList
            
        if (instancesToAnalyse.isEmpty) {
            return Collections.emptyMap
        }
        
        // 1) Create causal-scheduled-activity TMSCs for analysis (or reuse previous result)
        val analysisResult = newLinkedHashMap
        val analysisCausalScheduledActivities = newLinkedHashMap
        for (mi : instancesToAnalyse) {
            var causalScheduledActivity = mi.scopes.findFirst[rootCauseAnalysisResult]
            if (causalScheduledActivity === null) {
                causalScheduledActivity = mi.createCausalScheduledActivityTMSC => [
                    name = '''Root cause for «mi.name.toFirstLower»'''.toEID
                    rootCauseAnalysisResult = true
                ]
                mi.scopes += causalScheduledActivity
                analysisCausalScheduledActivities.put(mi, causalScheduledActivity)
            }
            analysisResult.put(mi, causalScheduledActivity)
        }
        
        if (!analysisCausalScheduledActivities.isEmpty) {
            // 2) Add comparison material to analysis TMSCs
            collectTimeBoundSamples(_metric, analysisCausalScheduledActivities)
            
            // 3 + 4) Detect outliers (on the critical path) and determine the outliers that caused the budget exceed.
            analysisCausalScheduledActivities.forEach [ mi, tmsc |
                logger.startSection('Analyzed root cause for: {}', mi.name)
                try {
                    analyseRootCause(mi, tmsc)
                } finally {
                    logger.endSection
                }
            ]
        }
        
        return analysisResult
    }
    
    def protected void collectTimeBoundSamples(Metric _metric, Map<MetricInstance, ScopedTMSC> analysisCausalScheduledActivities) {
        val compareScheduledActivities = _metric.instances.reject[exceedsBudget]
                .toMap([mi|mi], [mi|mi.createScheduledActivityTMSC()])
        
        collectTimeBoundSamplesFromIsomorphicCausalActivity(
            analysisCausalScheduledActivities, compareScheduledActivities
        )
        // TODO: The second step should only be done if the first step did not resolve enough time-bound samples and
        // the second step should only be done for metric instances that did not resolve in the first step 
        // (this requires an API change I believe)
        collectTimeBoundSamplesFromIsomorphicActivity(
            analysisCausalScheduledActivities, compareScheduledActivities
        )
        
        // Cleanup
        compareScheduledActivities.values.forEach[disposeTemp(true)]
    }
    
    /**
     * Based on isomorphism of the causal-activity, collects time-bounds for all 
     * matching dependencies (incl. scheduled dependencies).
     */
    def protected collectTimeBoundSamplesFromIsomorphicCausalActivity(
        Map<MetricInstance, ? extends ITMSC> analysisCausalScheduledActivities,
        Map<MetricInstance, ? extends ITMSC> compareScheduledActivities) {
        
        val compareCausalActivities = new LinkedHashMap(compareScheduledActivities.size)
        compareScheduledActivities.forEach [ mi, tmsc |
            val causalActivityDependencies = tmsc.findCausalDependenciesBetween(mi.from, mi.to).filter[isActivity]
            compareCausalActivities.put(mi, causalActivityDependencies.createCachedQueryTMSC('''«mi.name» - causal activity''', mi.from, mi.to))
        ]
        
        analysisCausalScheduledActivities.forEach [ miLeft, csaLeft |
            val caLeft = csaLeft.dependencies.filter[isActivity]
                    .createCachedQueryTMSC('''«miLeft.name» - causal activity''', miLeft.from, miLeft.to)
            compareCausalActivities.forEach[miRight, caRight |
                val eventMatches = TmscIsomorphismMatcher.intervalEventMatches(miLeft, miRight, stage)
                val caMatch = TmscIsomorphismMatcher.match(caLeft, caRight, eventMatches, false, stage)
                if (caMatch.isFullMatch) {
                    val saRight = compareScheduledActivities.get(miRight)
                    csaLeft.collectTimeBoundSamples(saRight, caMatch)
                }
            ]
        ]
    }
    
    /**
     * Based on isomorphism of the activity, collects time-bounds for all 
     * matching dependencies (incl. scheduled dependencies).
     */
    def protected collectTimeBoundSamplesFromIsomorphicActivity(
        Map<MetricInstance, ? extends ITMSC> analysisCausalScheduledActivities,
        Map<MetricInstance, ? extends ITMSC> compareScheduledActivities) {

        val compareActivities = new LinkedHashMap(compareScheduledActivities.size)
        compareScheduledActivities.forEach [ mi, tmsc |
            val activityDependencies = tmsc.dependencies.filter[isActivity]
            compareActivities.put(mi, activityDependencies.createCachedQueryTMSC('''«mi.name» - activity''', mi.from, mi.to))
        ]

        analysisCausalScheduledActivities.forEach [ miLeft, csaLeft |
            val activityLeft = miLeft.findActivityDependencies
                    .createCachedQueryTMSC('''«miLeft.name» - activity''', miLeft.from, miLeft.to)
            compareActivities.forEach[miRight, activityRight |
                val eventMatches = TmscIsomorphismMatcher.intervalEventMatches(miLeft, miRight, stage)
                val activityMatch = TmscIsomorphismMatcher.match(activityLeft, activityRight, eventMatches, false, stage)
                if (activityMatch.isFullMatch) {
                    val saRight = compareScheduledActivities.get(miRight)
                    csaLeft.collectTimeBoundSamples(saRight, activityMatch)
                }
            ]
        ]
    }

    def protected void collectTimeBoundSamples(ITMSC causalScheduledActivityLeft, ITMSC scheduledActivityRight,
        ITmscMatchResult matchResult) {
        
        val appliedMatchResult = matchResult.applyTo(causalScheduledActivityLeft, scheduledActivityRight)
        for (left : causalScheduledActivityLeft.dependencies) {
            val right = appliedMatchResult.getRightMatch(left)
            if (right !== null) {
                if (right.isSetTimeBoundSamples()) {
                    left.timeBoundSamples += right.timeBoundSamples
                } else if (right.timeBound !== null) {
                    left.timeBoundSamples += right.timeBound
                }
            }
        }
    }
    
    def protected void analyseRootCause(MetricInstance metricInstance, ScopedTMSC causalScheduledActivity) {
        // Advanced root-cause analysis
        causalScheduledActivity.dependencies.forEach[unsetRootCause]
        val advancedRootCauseAnalysis = new AdvancedRootCauseAnalysis()
        val rootCause = advancedRootCauseAnalysis.analyseRootCause(causalScheduledActivity, metricInstance.from,
            metricInstance.to, metricInstance.metric.budget)
        logger.logAll(advancedRootCauseAnalysis.status)
        rootCause.forEach[rootCause = true]
        
        // Critical path analysis
        val criticalPath = new CriticalPathAnalysis().findCriticalPathBetween(causalScheduledActivity,
            metricInstance.from, metricInstance.to).toSet
        
        // Cleanup only keep the temporary dependencies that are required for the result
        val tempDependencies = causalScheduledActivity.dependencies.filter[eContainer === null].toSet
        tempDependencies.removeAll(criticalPath)
        tempDependencies.removeAll(rootCause)
        tempDependencies.forEach[disposeTemp]
    }
}