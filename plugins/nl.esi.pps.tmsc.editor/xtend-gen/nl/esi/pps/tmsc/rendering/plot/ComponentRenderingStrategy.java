/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.rendering.plot;

import nl.esi.pps.preferences.PPSPreferences;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.presentation.TmscEditorPlugin;
import org.eclipse.emf.edit.domain.EditingDomain;

@SuppressWarnings("all")
public class ComponentRenderingStrategy extends GroupingRenderingStrategy {
  public static final String ID = (TmscEditorPlugin.getPlugin().getSymbolicName() + ".component_rendering_strategy");
  
  @Override
  public boolean isSupported(final EditingDomain editingDomain) {
    return PPSPreferences.isAdvancedFeaturesEnabled();
  }
  
  @Override
  protected String getGroupKey(final Execution execution) {
    return execution.getComponent().getName();
  }
  
  @Override
  protected String getGroupKey(final Dependency dependency) {
    return null;
  }
}
