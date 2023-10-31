/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.validation;

import nl.esi.pps.tmsc.TmscPlugin;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class ValidationReporter {
  private final DiagnosticChain diagnostics;
  
  private boolean valid = true;
  
  public boolean isValid() {
    return this.valid;
  }
  
  public void info(final CharSequence message, final EObject... eObjects) {
    this.issue(Diagnostic.INFO, message, eObjects);
  }
  
  public void warning(final CharSequence message, final EObject... eObjects) {
    this.issue(Diagnostic.WARNING, message, eObjects);
  }
  
  public void error(final CharSequence message, final EObject... eObjects) {
    this.issue(Diagnostic.ERROR, message, eObjects);
  }
  
  public void issue(final int severity, final CharSequence message, final Object... data) {
    String _string = message.toString();
    BasicDiagnostic _basicDiagnostic = new BasicDiagnostic(severity, TmscPlugin.PLUGIN_ID, 0, _string, data);
    this.diagnostics.add(_basicDiagnostic);
    if ((severity > Diagnostic.INFO)) {
      this.valid = false;
    }
  }
  
  public ValidationReporter(final DiagnosticChain diagnostics) {
    super();
    this.diagnostics = diagnostics;
  }
}
