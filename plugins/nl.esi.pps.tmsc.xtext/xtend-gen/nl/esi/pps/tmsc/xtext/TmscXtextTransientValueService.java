/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.xtext;

import com.google.common.base.Objects;
import java.util.List;
import nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage;
import nl.esi.pps.tmsc.xtext.tmscXtext.XComponent;
import nl.esi.pps.tmsc.xtext.tmscXtext.XFunction;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.parsetree.reconstr.impl.DefaultTransientValueService;

@SuppressWarnings("all")
public class TmscXtextTransientValueService extends DefaultTransientValueService {
  @Override
  public boolean isCheckElementsIndividually(final EObject owner, final EStructuralFeature feature) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (Objects.equal(feature, TmscXtextPackage.Literals.TMSC_XTEXT_MODEL__COMPONENTS)) {
      _matched=true;
    }
    if (!_matched) {
      if (Objects.equal(feature, TmscXtextPackage.Literals.TMSC_XTEXT_MODEL__FUNCTIONS)) {
        _matched=true;
      }
    }
    if (_matched) {
      _switchResult = true;
    }
    if (!_matched) {
      _switchResult = super.isCheckElementsIndividually(owner, feature);
    }
    return _switchResult;
  }
  
  @Override
  public boolean isTransient(final EObject owner, final EStructuralFeature feature, final int index) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (Objects.equal(feature, TmscXtextPackage.Literals.TMSC_XTEXT_MODEL__COMPONENTS)) {
      _matched=true;
      Object _element = TmscXtextTransientValueService.getElement(owner, feature, index);
      String _description = ((XComponent) _element).getDescription();
      _switchResult = (_description == null);
    }
    if (!_matched) {
      if (Objects.equal(feature, TmscXtextPackage.Literals.TMSC_XTEXT_MODEL__FUNCTIONS)) {
        _matched=true;
        Object _element_1 = TmscXtextTransientValueService.getElement(owner, feature, index);
        String _description_1 = ((XFunction) _element_1).getDescription();
        _switchResult = (_description_1 == null);
      }
    }
    if (!_matched) {
      _switchResult = super.isTransient(owner, feature, index);
    }
    return _switchResult;
  }
  
  private static Object getElement(final EObject owner, final EStructuralFeature feature, final int index) {
    final Object value = owner.eGet(feature);
    Object _xifexpression = null;
    if ((value instanceof List<?>)) {
      _xifexpression = ((List<?>)value).get(index);
    } else {
      _xifexpression = value;
    }
    return _xifexpression;
  }
}
