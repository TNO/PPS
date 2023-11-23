/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.xtext;

import nl.esi.pps.tmsc.xtext.conversion.TmscXtextValueConverterService;
import nl.esi.pps.tmsc.xtext.formatting.TmscXtextFormatter;
import nl.esi.pps.tmsc.xtext.linking.TmscXtextLinkingService;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.formatting.IFormatter;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
@SuppressWarnings("all")
public class TmscXtextRuntimeModule extends AbstractTmscXtextRuntimeModule {
  @Override
  public Class<? extends IValueConverterService> bindIValueConverterService() {
    return TmscXtextValueConverterService.class;
  }
  
  @Override
  public Class<? extends ILinkingService> bindILinkingService() {
    return TmscXtextLinkingService.class;
  }
  
  @Override
  public Class<? extends ITransientValueService> bindITransientValueService() {
    return TmscXtextTransientValueService.class;
  }
  
  @Override
  public Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
    return ImportUriGlobalScopeProvider.class;
  }
  
  @Override
  public Class<? extends IFormatter> bindIFormatter() {
    return TmscXtextFormatter.class;
  }
}
