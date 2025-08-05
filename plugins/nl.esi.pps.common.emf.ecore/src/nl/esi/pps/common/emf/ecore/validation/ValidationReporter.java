/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.emf.ecore.validation;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;

public class ValidationReporter {
	private final DiagnosticChain diagnostics;
	private final String source;

	private boolean valid = true;

	public ValidationReporter(DiagnosticChain diagnostics, String source) {
		this.diagnostics = diagnostics;
		this.source = source;
	}

	public boolean isValid() {
		return valid;
	}

	public void info(CharSequence message, EObject... eObjects) {
		issue(Diagnostic.INFO, message, (Object[]) eObjects);
	}

	public void warning(CharSequence message, EObject... eObjects) {
		issue(Diagnostic.WARNING, message, (Object[]) eObjects);
	}

	public void error(CharSequence message, EObject... eObjects) {
		issue(Diagnostic.ERROR, message, (Object[]) eObjects);
	}

	public void issue(int severity, CharSequence message, Object... data) {
		diagnostics.add(new BasicDiagnostic(severity, source, 0, message.toString(), data));
		if (severity > Diagnostic.INFO) {
			valid = false;
		}
	}
}
