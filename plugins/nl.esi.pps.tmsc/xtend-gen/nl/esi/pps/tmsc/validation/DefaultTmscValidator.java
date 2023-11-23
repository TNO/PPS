/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.validation;

import com.google.common.base.Objects;
import nl.esi.pps.architecture.implemented.Function;
import nl.esi.pps.architecture.specified.Component;
import nl.esi.pps.common.emf.ecore.validation.EValidatorBase;
import nl.esi.pps.common.emf.ecore.validation.ValidationReporter;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.EntryEvent;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.ExitEvent;
import nl.esi.pps.tmsc.Lifeline;
import nl.esi.pps.tmsc.LifelineSegment;
import nl.esi.pps.tmsc.ScopedTMSC;
import nl.esi.pps.tmsc.TMSC;
import nl.esi.pps.tmsc.TmscPlugin;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class DefaultTmscValidator extends EValidatorBase {
  public DefaultTmscValidator() {
    super(TmscPlugin.PLUGIN_ID);
  }
  
  @Override
  public void validate(final EClass eClass, final EObject eObject, final ValidationReporter reporter) {
    if ((eObject instanceof Dependency)) {
      this.validateDependency(((Dependency)eObject), reporter);
    }
    if ((eObject instanceof Execution)) {
      this.validateExecution(((Execution)eObject), reporter);
    }
    if ((eObject instanceof LifelineSegment)) {
      this.validateLifelineSegment(((LifelineSegment)eObject), reporter);
    }
    if ((eObject instanceof ScopedTMSC)) {
      this.validateScopedTMSC(((ScopedTMSC)eObject), reporter);
    }
  }
  
  private void validateDependency(final Dependency dependency, @Extension final ValidationReporter reporter) {
    if ((((dependency.getDuration() != null) && (dependency.getTimeBound() != null)) && 
      (dependency.getTimeBound().compareTo(dependency.getDuration()) > 0))) {
      reporter.warning("The time-bound of a dependency should be less than or equal to its duration.", dependency);
    }
  }
  
  private void validateExecution(final Execution execution, @Extension final ValidationReporter reporter) {
    EntryEvent _entry = execution.getEntry();
    Lifeline _lifeline = null;
    if (_entry!=null) {
      _lifeline=_entry.getLifeline();
    }
    Execution _root = execution.getRoot();
    Lifeline _lifeline_1 = null;
    if (_root!=null) {
      _lifeline_1=_root.getLifeline();
    }
    boolean _notEquals = (!Objects.equal(_lifeline, _lifeline_1));
    if (_notEquals) {
      reporter.error("The entry event of an execution should refer to the same life-line as the execution itself.", execution);
    }
    ExitEvent _exit = execution.getExit();
    Lifeline _lifeline_2 = null;
    if (_exit!=null) {
      _lifeline_2=_exit.getLifeline();
    }
    Execution _root_1 = execution.getRoot();
    Lifeline _lifeline_3 = null;
    if (_root_1!=null) {
      _lifeline_3=_root_1.getLifeline();
    }
    boolean _notEquals_1 = (!Objects.equal(_lifeline_2, _lifeline_3));
    if (_notEquals_1) {
      reporter.error("The exit event of an execution should refer to the same life-line as the execution itself.", execution);
    }
    EntryEvent _entry_1 = execution.getEntry();
    Component _component = null;
    if (_entry_1!=null) {
      _component=_entry_1.getComponent();
    }
    ExitEvent _exit_1 = execution.getExit();
    Component _component_1 = null;
    if (_exit_1!=null) {
      _component_1=_exit_1.getComponent();
    }
    boolean _notEquals_2 = (!Objects.equal(_component, _component_1));
    if (_notEquals_2) {
      reporter.error("The source and target event of an execution should refer to the same component.", execution);
    }
    EntryEvent _entry_2 = execution.getEntry();
    Function _function = null;
    if (_entry_2!=null) {
      _function=_entry_2.getFunction();
    }
    ExitEvent _exit_2 = execution.getExit();
    Function _function_1 = null;
    if (_exit_2!=null) {
      _function_1=_exit_2.getFunction();
    }
    boolean _notEquals_3 = (!Objects.equal(_function, _function_1));
    if (_notEquals_3) {
      reporter.error("The source and target event of an execution should refer to the same function.", execution);
    }
  }
  
  private void validateLifelineSegment(final LifelineSegment lifelineSegment, @Extension final ValidationReporter reporter) {
    Event _source = lifelineSegment.getSource();
    Lifeline _lifeline = null;
    if (_source!=null) {
      _lifeline=_source.getLifeline();
    }
    Event _target = lifelineSegment.getTarget();
    Lifeline _lifeline_1 = null;
    if (_target!=null) {
      _lifeline_1=_target.getLifeline();
    }
    boolean _notEquals = (!Objects.equal(_lifeline, _lifeline_1));
    if (_notEquals) {
      reporter.error("The source and target event of a life-line segment should refer to the same life-line.", lifelineSegment);
    }
  }
  
  private void validateScopedTMSC(final ScopedTMSC tmsc, @Extension final ValidationReporter reporter) {
    TMSC _parentScope = tmsc.getParentScope();
    boolean _tripleEquals = (_parentScope == null);
    if (_tripleEquals) {
      return;
    }
    boolean _containsAll = tmsc.getParentScope().getDependencies().containsAll(tmsc.getDependencies());
    boolean _not = (!_containsAll);
    if (_not) {
      reporter.error("The parent scope of this TMSC should at least include all dependencies of this TMSC.", tmsc);
    }
  }
}
