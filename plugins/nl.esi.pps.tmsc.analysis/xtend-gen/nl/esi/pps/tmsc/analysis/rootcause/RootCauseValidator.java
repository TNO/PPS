/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.analysis.rootcause;

import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.analysis.RootCauseAnalysis;
import nl.esi.pps.tmsc.analysis.RootCauseClassification;
import nl.esi.pps.tmsc.compare.ArchitectureLifecycleStage;
import nl.esi.pps.tmsc.validation.TmscValidatorBase;
import nl.esi.pps.tmsc.validation.ValidationReporter;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class RootCauseValidator extends TmscValidatorBase {
  @Extension
  private final RootCauseClassification rootCauseClassification = new RootCauseClassification(
    ArchitectureLifecycleStage.INSTANTIATED);
  
  @Override
  public void validate(final EClass eClass, final EObject eObject, final ValidationReporter reporter) {
    if ((eObject instanceof Dependency)) {
      this.validateRootCauses(((Dependency)eObject), reporter);
    }
  }
  
  private void validateRootCauses(final Dependency dependency, @Extension final ValidationReporter reporter) {
    boolean _isRootCause = RootCauseAnalysis.isRootCause(dependency);
    if (_isRootCause) {
      reporter.warning(this.rootCauseClassification.describeRootCause(dependency), dependency);
    }
  }
}
