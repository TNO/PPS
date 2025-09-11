/**
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.xtext.ui.quickfix;

import java.util.Objects;
import nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextFactory;
import nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextModel;
import nl.esi.pps.tmsc.xtext.tmscXtext.XEvent;
import nl.esi.pps.tmsc.xtext.tmscXtext.XEventType;
import nl.esi.pps.tmsc.xtext.tmscXtext.XFunction;
import nl.esi.pps.tmsc.xtext.tmscXtext.XInterface;
import nl.esi.pps.tmsc.xtext.validation.TmscXtextValidator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * Custom quickfixes.
 * 
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#quick-fixes
 */
@SuppressWarnings("all")
public class TmscXtextQuickfixProvider extends DefaultQuickfixProvider {
  @Extension
  private static final TmscXtextFactory m_tmsct = TmscXtextFactory.eINSTANCE;

  @Fix(TmscXtextValidator.XINTERFACE_NOT_PROVIDED)
  public void provideInterface(final Issue issue, final IssueResolutionAcceptor acceptor) {
    final ISemanticModification _function = (EObject element, IModificationContext context) -> {
      final XEvent xEvent = ((XEvent) element);
      EList<XInterface> _provides = xEvent.getComponent().getProvides();
      EObject _eContainer = xEvent.getFunction().getOperation().eContainer();
      _provides.add(((XInterface) _eContainer));
    };
    acceptor.accept(issue, "Provide interface", "Provide the interface", null, _function);
  }

  @Fix(TmscXtextValidator.XINTERFACE_NOT_REQUIRED)
  public void requireInterface(final Issue issue, final IssueResolutionAcceptor acceptor) {
    final ISemanticModification _function = (EObject element, IModificationContext context) -> {
      final XEvent xEvent = ((XEvent) element);
      EList<XInterface> _requires = xEvent.getComponent().getRequires();
      EObject _eContainer = xEvent.getFunction().getOperation().eContainer();
      _requires.add(((XInterface) _eContainer));
    };
    acceptor.accept(issue, "Require interface", "Require the interface", null, _function);
  }

  @Fix(TmscXtextValidator.XEVENT_ORDER_CALL_STACK)
  public void addExitEvent(final Issue issue, final IssueResolutionAcceptor acceptor) {
    final String functionName = IterableExtensions.<String>head(((Iterable<String>)Conversions.doWrapArray(issue.getData())));
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Insert ");
    _builder.append(functionName);
    _builder.append(" function exit");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Inserts exit of function ");
    _builder_1.append(functionName);
    _builder_1.append(" just before this event.");
    final ISemanticModification _function = (EObject element, IModificationContext context) -> {
      final XEvent xEvent = ((XEvent) element);
      EObject _eContainer = xEvent.eContainer();
      final TmscXtextModel model = ((TmscXtextModel) _eContainer);
      EList<XEvent> _events = model.getEvents();
      int _indexOf = model.getEvents().indexOf(xEvent);
      XEvent _createXEvent = TmscXtextQuickfixProvider.m_tmsct.createXEvent();
      final Procedure1<XEvent> _function_1 = (XEvent it) -> {
        final Function1<XFunction, Boolean> _function_2 = (XFunction it_1) -> {
          String _name = it_1.getName();
          return Boolean.valueOf(Objects.equals(_name, functionName));
        };
        it.setFunction(IterableExtensions.<XFunction>findFirst(model.getFunctions(), _function_2));
        it.setType(XEventType.EXIT);
        it.setTimestamp(xEvent.getTimestamp());
        it.setComponent(xEvent.getComponent());
        it.setExecutor(xEvent.getExecutor());
      };
      XEvent _doubleArrow = ObjectExtensions.<XEvent>operator_doubleArrow(_createXEvent, _function_1);
      _events.add(_indexOf, _doubleArrow);
    };
    acceptor.accept(issue, _builder.toString(), _builder_1.toString(), null, _function);
  }
}
