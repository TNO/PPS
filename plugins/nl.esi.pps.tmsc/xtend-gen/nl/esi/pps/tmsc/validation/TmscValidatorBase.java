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

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public abstract class TmscValidatorBase implements EValidator {
  @Override
  public boolean validate(final EDataType eDataType, final Object value, final DiagnosticChain diagnostics, final Map<Object, Object> context) {
    return true;
  }
  
  @Override
  public boolean validate(final EObject eObject, final DiagnosticChain diagnostics, final Map<Object, Object> context) {
    EClass _xifexpression = null;
    if ((eObject == null)) {
      _xifexpression = null;
    } else {
      _xifexpression = eObject.eClass();
    }
    return this.validate(_xifexpression, eObject, diagnostics, context);
  }
  
  @Override
  public boolean validate(final EClass eClass, final EObject eObject, final DiagnosticChain diagnostics, final Map<Object, Object> context) {
    final ValidationReporter reporter = new ValidationReporter(diagnostics);
    this.validate(eClass, eObject, reporter);
    return reporter.isValid();
  }
  
  public abstract void validate(final EClass eClass, final EObject eObject, @Extension final ValidationReporter reporter);
}
