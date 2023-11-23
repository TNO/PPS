/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.xtext

import nl.esi.emf.properties.xtend.PersistedProperty
import nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextModel
import nl.esi.pps.tmsc.xtext.tmscXtext.XDependency
import nl.esi.pps.tmsc.xtext.tmscXtext.XDependencyType

import static extension org.eclipse.xtext.EcoreUtil2.*

class TmscXtextQueries {
    @PersistedProperty
    public static var String xtextName

    private new() {
        // Empty for utility classes
    }

    static def XDependencyType getType(XDependency xDependency) {
        if (xDependency === null) {
            return null
        } else if (xDependency.typeObject !== null) {
            return xDependency.typeObject.value
        }
        val model = xDependency.getContainerOfType(TmscXtextModel)
        if (xDependency.name !== null && model !== null) {
            // Check the prefix
            for (dependencySettings : model.dependencySettings) {
                if (dependencySettings.prefix !== null && xDependency.name.startsWith(dependencySettings.prefix)) {
                    return dependencySettings.type
                }
            }
        }
        return XDependencyType::MESSAGE
    }
}
