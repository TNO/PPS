/**
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.rendering.plot

import nl.esi.pps.preferences.PPSPreferences
import nl.esi.pps.tmsc.Dependency
import nl.esi.pps.tmsc.Execution
import nl.esi.pps.tmsc.presentation.TmscEditorPlugin
import org.eclipse.emf.edit.domain.EditingDomain

class ComponentRenderingStrategy extends GroupingRenderingStrategy {
    public static final String ID = TmscEditorPlugin::getPlugin().getSymbolicName() + ".component_rendering_strategy"
    
    override isSupported(EditingDomain editingDomain) {
        return PPSPreferences::isAdvancedFeaturesEnabled
    }
    
    override protected getGroupKey(Execution execution) {
        return execution.component.name
    }
    
    override protected String getGroupKey(Dependency dependency) {
        return null
    }
}
