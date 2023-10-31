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

import nl.esi.pps.tmsc.Dependency
import nl.esi.pps.tmsc.Execution
import nl.esi.pps.tmsc.LifelineSegment
import nl.esi.pps.tmsc.ScopedTMSC
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject

class DefaultTmscValidator extends TmscValidatorBase {
    override validate(EClass eClass, EObject eObject, ValidationReporter reporter) {
        if (eObject instanceof Dependency) {
            validateDependency(eObject, reporter)
        }
        if (eObject instanceof Execution) {
            validateExecution(eObject, reporter)
        }
        if (eObject instanceof LifelineSegment) {
            validateLifelineSegment(eObject, reporter)
        }
        if (eObject instanceof ScopedTMSC) {
            validateScopedTMSC(eObject, reporter)
        }
    }

    def private void validateDependency(Dependency dependency, extension ValidationReporter reporter) {
        if (dependency.duration !== null && dependency.timeBound !== null &&
            dependency.timeBound > dependency.duration) {
            warning('The time-bound of a dependency should be less than or equal to its duration.', dependency)
        }
    }

    def private void validateExecution(Execution execution, extension ValidationReporter reporter) {
        if (execution.entry?.lifeline != execution.root?.lifeline) {
            error('The entry event of an execution should refer to the same life-line as the execution itself.', execution)
        }
        if (execution.exit?.lifeline != execution.root?.lifeline) {
            error('The exit event of an execution should refer to the same life-line as the execution itself.', execution)
        }
        if (execution.entry?.component != execution.exit?.component) {
            error('The source and target event of an execution should refer to the same component.', execution)
        }
        if (execution.entry?.function != execution.exit?.function) {
            error('The source and target event of an execution should refer to the same function.', execution)
        }
    }

    def private void validateLifelineSegment(LifelineSegment lifelineSegment, extension ValidationReporter reporter) {
        if (lifelineSegment.source?.lifeline != lifelineSegment.target?.lifeline) {
            error('The source and target event of a life-line segment should refer to the same life-line.', lifelineSegment)
        }
    }
    
    def private void validateScopedTMSC(ScopedTMSC tmsc, extension ValidationReporter reporter) {
        if (tmsc.parentScope === null) {
            // Cannot validate this ScopedTMSC
            return
        }
        if (!tmsc.parentScope.dependencies.containsAll(tmsc.dependencies)) {
            error('The parent scope of this TMSC should at least include all dependencies of this TMSC.', tmsc)
        }
    }
}
