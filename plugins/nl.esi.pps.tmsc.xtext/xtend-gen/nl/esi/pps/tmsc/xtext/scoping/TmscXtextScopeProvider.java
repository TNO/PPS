/**
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.xtext.scoping;

import java.util.Objects;
import nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage;
import nl.esi.pps.tmsc.xtext.tmscXtext.XEvent;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;

/**
 * This class contains custom scoping description.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
@SuppressWarnings("all")
public class TmscXtextScopeProvider extends AbstractTmscXtextScopeProvider {
  @Override
  public IScope getScope(final EObject context, final EReference reference) {
    IScope _switchResult = null;
    boolean _matched = false;
    if (Objects.equals(reference, TmscXtextPackage.Literals.XEVENT_ARGUMENT__PARAMETER)) {
      _matched=true;
      IScope _xblockexpression = null;
      {
        final XEvent xEvent = EcoreUtil2.<XEvent>getContainerOfType(context, XEvent.class);
        _xblockexpression = Scopes.scopeFor(xEvent.getFunction().getParameters());
      }
      _switchResult = _xblockexpression;
    }
    if (!_matched) {
      _switchResult = super.getScope(context, reference);
    }
    return _switchResult;
  }
}
