/**
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
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

package nl.esi.pps.tmsc.metric.impl

import nl.esi.pps.tmsc.metric.MetricInstance

class MetricImplQueries {
    static def String getNameImpl(MetricInstance metricInstance) {
        return '''«metricInstance.metric.name» - «metricInstance.id»'''
    }

    static def boolean isExceedsBudgetImpl(MetricInstance metricInstance) {
        val budget = metricInstance.metric.budget
        val duration = metricInstance.duration
        return budget !== null && duration !== null && duration > budget
    }
}