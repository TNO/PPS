/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.xtext.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import nl.esi.pps.tmsc.xtext.TmscXtextRuntimeModule;
import nl.esi.pps.tmsc.xtext.TmscXtextStandaloneSetup;
import org.eclipse.xtext.util.Modules2;

/**
 * Initialization support for running Xtext languages as language servers.
 */
@SuppressWarnings("all")
public class TmscXtextIdeSetup extends TmscXtextStandaloneSetup {
  @Override
  public Injector createInjector() {
    TmscXtextRuntimeModule _tmscXtextRuntimeModule = new TmscXtextRuntimeModule();
    TmscXtextIdeModule _tmscXtextIdeModule = new TmscXtextIdeModule();
    return Guice.createInjector(Modules2.mixin(_tmscXtextRuntimeModule, _tmscXtextIdeModule));
  }
}
