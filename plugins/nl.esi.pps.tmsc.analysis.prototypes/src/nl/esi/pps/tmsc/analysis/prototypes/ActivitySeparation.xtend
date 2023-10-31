/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.analysis.prototypes

import nl.esi.pps.tmsc.FullScopeTMSC
import nl.esi.pps.tmsc.TmscFactory

import static extension nl.esi.pps.tmsc.analysis.ActivityAnalysis.*
import static extension nl.esi.pps.tmsc.util.TmscQueries.*

class ActivitySeparation {
    static extension val TmscFactory m_tmsc = TmscFactory.eINSTANCE

    static def separateActivities(FullScopeTMSC tmsc) {
        // Note that scheduled my be null, hence the equals with boolean object
        val activityDependencies = tmsc.dependencies.filter[isActivity]
        // Only save the 20 largest TMSCs
        val disjunctTMSCs = activityDependencies.findDisjunctTMSCs.sortInplaceBy[size].reverseView.take(20)
        
        disjunctTMSCs.forEach[scopedTMSCDependencies, index |
            tmsc.childScopes += createScopedTMSC => [
                dependencies += scopedTMSCDependencies
                name = '''«index»: «dependencies.size» dependencies'''
            ]
        ]
    }
}