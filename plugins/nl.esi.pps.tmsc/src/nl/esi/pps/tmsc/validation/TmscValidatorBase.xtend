/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.validation

import java.util.Map
import org.eclipse.emf.common.util.DiagnosticChain
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EValidator

abstract class TmscValidatorBase implements EValidator {
    override validate(EDataType eDataType, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return true;
    }

    override validate(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate(eObject === null ? null : eObject.eClass, eObject, diagnostics, context);
    }

    override validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
        val reporter = new ValidationReporter(diagnostics)
        validate(eClass, eObject, reporter)
        return reporter.valid
    }

    abstract def void validate(EClass eClass, EObject eObject, extension ValidationReporter reporter)
}
