/**
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.analysis.rootcause

import nl.esi.pps.common.emf.ecore.validation.EValidatorBase
import nl.esi.pps.common.emf.ecore.validation.ValidationReporter
import nl.esi.pps.tmsc.Dependency
import nl.esi.pps.tmsc.analysis.RootCauseClassification
import nl.esi.pps.tmsc.analysis.TmscAnalysisPlugin
import nl.esi.pps.tmsc.compare.ArchitectureLifecycleStage
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject

import static extension nl.esi.pps.tmsc.analysis.RootCauseAnalysis.*

class RootCauseValidator extends EValidatorBase {
    new() {
        super(TmscAnalysisPlugin::PLUGIN_ID)
    }
    
    extension val RootCauseClassification rootCauseClassification = new RootCauseClassification(
        ArchitectureLifecycleStage::INSTANTIATED)

    override validate(EClass eClass, EObject eObject, ValidationReporter reporter) {
        if (eObject instanceof Dependency) {
            validateRootCauses(eObject, reporter)
        }
    }

    def private void validateRootCauses(Dependency dependency, extension ValidationReporter reporter) {
        if (dependency.isRootCause) {
            warning(dependency.describeRootCause, dependency)
        }
    }
}
