/**
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.xtext.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
@SuppressWarnings("all")
public class TmscXtextUiModule extends AbstractTmscXtextUiModule {
  public TmscXtextUiModule(final AbstractUIPlugin plugin) {
    super(plugin);
  }
}
