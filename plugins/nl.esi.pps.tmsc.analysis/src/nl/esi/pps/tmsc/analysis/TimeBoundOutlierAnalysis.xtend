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

import java.util.ArrayList
import java.util.List
import nl.esi.emf.properties.xtend.PersistedProperty
import nl.esi.pps.tmsc.Dependency
import nl.esi.pps.tmsc.TMSC

class TimeBoundOutlierAnalysis {
    @PersistedProperty(value = Dependency, unsettable = true)
    public static val Long timeBoundOutlierThreshold

    @PersistedProperty(value = Dependency, unsettable = true, mutable=true)
    public static val ArrayList<Long> timeBoundSamples = newArrayList
    
    static val IQR_FACTOR = 3.0
    
    private new() {
        // Empty for utility classes
    }
    
    static def Iterable<Dependency> analyseTimeBoundOutliers(TMSC tmsc) {
        return tmsc.dependencies.filter[isTimeBoundOutlier]
    }
    
    static def boolean isTimeBoundOutlier(Dependency dependency) {
        if (dependency.timeBound === null) {
            return false
        }
        val timeBoundOutlierThreshold = dependency.analyseTimeBoundOutlierThreshold(false)
        if (timeBoundOutlierThreshold === null) {
            return false
        }
        return dependency.timeBound > timeBoundOutlierThreshold
    }
    
    static def Long analyseTimeBoundOutlierThreshold(Dependency dependency, boolean refresh) {
        if (dependency.isSetTimeBoundOutlierThreshold && !refresh) {
            return dependency.timeBoundOutlierThreshold
        }
        if (!dependency.isSetTimeBoundSamples || dependency.timeBoundSamples.isEmpty) {
            return null
        }
        val iqr = dependency.timeBoundSamples.interquartileRange
        val Q1 = iqr.key
        val Q3 = iqr.value
        dependency.timeBoundOutlierThreshold = Math::ceil(Q3 + ((Q3 - Q1) * IQR_FACTOR)).longValue
        return dependency.timeBoundOutlierThreshold
    }

    /**
     * @see https://en.wikipedia.org/wiki/Interquartile_range
     */
    private static def Pair<Double, Double> getInterquartileRange(Iterable<Long> values) {
        return switch sortedValues: values.sort {
            case sortedValues.isEmpty:
                null
            case sortedValues.size == 1:
                Pair::of(sortedValues.head.doubleValue, sortedValues.head.doubleValue)
            case (sortedValues.size / 2) % 2 == 0: {
                val highIndexQ1 = sortedValues.size / 4
                Pair::of(
                    (sortedValues.at(highIndexQ1 - 1) + sortedValues.at(highIndexQ1)) / 2.0,
                    (sortedValues.at(-highIndexQ1 + 1) + sortedValues.at(-highIndexQ1)) / 2.0
                )
            }
            default: {
                val indexQ1 = sortedValues.size / 4
                Pair::of(sortedValues.at(indexQ1).doubleValue, sortedValues.at(-indexQ1).doubleValue)
            }
        }
    }

    private static def <T> T at(List<T> values, int position) {
        return if(position < 0) values.get(values.size - 1 + position) else values.get(position)
    }
}