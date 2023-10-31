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

import org.eclipse.emf.common.util.BasicDiagnostic
import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.emf.common.util.DiagnosticChain
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import nl.esi.pps.tmsc.TmscPlugin

@FinalFieldsConstructor
class ValidationReporter {
    val DiagnosticChain diagnostics
    
    var valid = true
    
    def boolean isValid() {
        return valid;
    }

    def void info(CharSequence message, EObject... eObjects) {
        issue(Diagnostic::INFO, message, eObjects)
    }

    def void warning(CharSequence message, EObject... eObjects) {
        issue(Diagnostic::WARNING, message, eObjects)
    }

    def void error(CharSequence message, EObject... eObjects) {
        issue(Diagnostic::ERROR, message, eObjects)
    }

    def void issue(int severity, CharSequence message, Object... data) {
        diagnostics.add(new BasicDiagnostic(severity, TmscPlugin::PLUGIN_ID, 0, message.toString, data))
        if (severity > Diagnostic::INFO) {
            valid = false
        }
    }
}
