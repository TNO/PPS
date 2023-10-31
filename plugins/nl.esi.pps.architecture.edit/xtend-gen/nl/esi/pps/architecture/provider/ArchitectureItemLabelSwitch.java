/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.architecture.provider;

import com.google.common.base.Objects;
import java.util.Arrays;
import nl.esi.emf.edit.provider.EMFEditUtil;
import nl.esi.pps.architecture.ArchitecturePackage;
import nl.esi.pps.architecture.NamedArchitectureElement;
import nl.esi.pps.architecture.implemented.FunctionParameter;
import nl.esi.pps.architecture.implemented.ImplementedPackage;
import nl.esi.pps.architecture.instantiated.InstantiatedPackage;
import nl.esi.pps.architecture.specified.SpecifiedPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class ArchitectureItemLabelSwitch {
  public static final ArchitectureItemLabelSwitch eINSTANCE = new ArchitectureItemLabelSwitch();
  
  protected String _getText(final Object object) {
    return String.valueOf(object);
  }
  
  protected String _getText(final EObject eObject) {
    String _switchResult = null;
    EPackage _ePackage = eObject.eClass().getEPackage();
    boolean _matched = false;
    if (Objects.equal(_ePackage, SpecifiedPackage.eINSTANCE)) {
      _matched=true;
    }
    if (!_matched) {
      if (Objects.equal(_ePackage, ImplementedPackage.eINSTANCE)) {
        _matched=true;
      }
    }
    if (!_matched) {
      if (Objects.equal(_ePackage, InstantiatedPackage.eINSTANCE)) {
        _matched=true;
      }
    }
    if (!_matched) {
      if (Objects.equal(_ePackage, ArchitecturePackage.eINSTANCE)) {
        _matched=true;
      }
    }
    if (_matched) {
      _switchResult = this.getText(eObject.eClass());
    }
    if (!_matched) {
      _switchResult = EMFEditUtil.getText(eObject);
    }
    return _switchResult;
  }
  
  protected String _getText(final EClass eClass) {
    String _switchResult = null;
    EPackage _ePackage = eClass.getEPackage();
    boolean _matched = false;
    if (Objects.equal(_ePackage, SpecifiedPackage.eINSTANCE)) {
      _matched=true;
    }
    if (!_matched) {
      if (Objects.equal(_ePackage, ImplementedPackage.eINSTANCE)) {
        _matched=true;
      }
    }
    if (!_matched) {
      if (Objects.equal(_ePackage, InstantiatedPackage.eINSTANCE)) {
        _matched=true;
      }
    }
    if (!_matched) {
      if (Objects.equal(_ePackage, ArchitecturePackage.eINSTANCE)) {
        _matched=true;
      }
    }
    if (_matched) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("_UI_");
      String _name = eClass.getName();
      _builder.append(_name);
      _builder.append("_type");
      _switchResult = ArchitectureEditPlugin.INSTANCE.getString(_builder.toString());
    }
    if (!_matched) {
      _switchResult = null;
    }
    final String name = _switchResult;
    String _elvis = null;
    if (name != null) {
      _elvis = name;
    } else {
      String _name_1 = eClass.getName();
      _elvis = _name_1;
    }
    return _elvis;
  }
  
  protected String _getText(final NamedArchitectureElement element) {
    return element.getName();
  }
  
  protected String _getText(final FunctionParameter parameter) {
    StringConcatenation _builder = new StringConcatenation();
    String _literal = parameter.getKind().getLiteral();
    _builder.append(_literal);
    _builder.append(" ");
    String _name = parameter.getName();
    _builder.append(_name);
    return _builder.toString();
  }
  
  public String getText(final Object eClass) {
    if (eClass instanceof EClass) {
      return _getText((EClass)eClass);
    } else if (eClass instanceof FunctionParameter) {
      return _getText((FunctionParameter)eClass);
    } else if (eClass instanceof NamedArchitectureElement) {
      return _getText((NamedArchitectureElement)eClass);
    } else if (eClass instanceof EObject) {
      return _getText((EObject)eClass);
    } else if (eClass != null) {
      return _getText(eClass);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(eClass).toString());
    }
  }
}
