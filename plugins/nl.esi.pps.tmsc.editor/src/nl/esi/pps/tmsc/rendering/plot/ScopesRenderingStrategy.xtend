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

import nl.esi.emf.properties.xtend.PersistedProperty
import nl.esi.pps.preferences.PPSPreferences
import nl.esi.pps.tmsc.Dependency
import nl.esi.pps.tmsc.Execution
import nl.esi.pps.tmsc.ScopedTMSC
import nl.esi.pps.tmsc.presentation.TmscEditorPlugin
import org.eclipse.emf.edit.domain.EditingDomain
import org.eclipse.jface.viewers.Viewer

class ScopesRenderingStrategy extends GroupingRenderingStrategy {
    public static final String ID = TmscEditorPlugin::getPlugin().getSymbolicName() + ".scopes_rendering_strategy"
    
    @PersistedProperty(ScopedTMSC)
    public static val boolean groupKey = true

    override isSupported(EditingDomain editingDomain) {
        return PPSPreferences::isAdvancedFeaturesEnabled
    }

    override select(Viewer viewer, Object parentElement, Object element) {
        // Behave like highlight, always show dependencies in scope
        return switch (element) {
            Dependency case !element.scopesGroup.isEmpty: true
            default: super.select(viewer, parentElement, element)
        }
    }
    
    override protected getGroupKey(Execution execution) {
        // Do not color executions by scope as multiple strategies can apply, e.g.:
        // When the execution is (partially) active within a scope
        // return execution.segments.flatMap[scopes].toSet.filter[groupKey].groupKey
        // When either the entry or exit event is part of a scope
        // return execution.events.flatMap[scopes].toSet.filter[groupKey].groupKey
        return null
    }
    
    override protected String getGroupKey(Dependency dependency) {
        return dependency.scopesGroup.groupKey
    }
    
    def private getScopesGroup(Dependency dependency) {
        return dependency.scopes.filter[groupKey]
    }
    
    def private getGroupKey(Iterable<ScopedTMSC> scopesGroup) {
        return scopesGroup.isEmpty ? null : scopesGroup.sortBy[fqn].map[name].join(', ')
    }
}
