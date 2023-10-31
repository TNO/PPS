/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.util;

import com.google.common.base.Objects;
import nl.esi.pps.architecture.implemented.Function;
import nl.esi.pps.architecture.implemented.FunctionParameter;
import nl.esi.pps.architecture.implemented.FunctionParameterKind;
import nl.esi.pps.architecture.implemented.ImplementedFactory;
import nl.esi.pps.tmsc.EntryEvent;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.ExitEvent;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class FunctionParametersUtil {
  @Extension
  private static final ImplementedFactory m_impl = ImplementedFactory.eINSTANCE;
  
  private FunctionParametersUtil() {
  }
  
  public static String getReturnValue(final ExitEvent event) {
    return FunctionParametersUtil.getArgument(event, ((String) null));
  }
  
  public static String getArgument(final Event event, final String parameterName) {
    final FunctionParameter parameter = FunctionParametersUtil.getParameter(event.getFunction(), parameterName);
    if ((parameter == null)) {
      return null;
    }
    return FunctionParametersUtil.getArgument(event, parameter);
  }
  
  public static String getArgument(final Event event, final FunctionParameter parameter) {
    return event.getArguments().get(parameter);
  }
  
  public static void setReturnValue(final ExitEvent event, final String value) {
    FunctionParametersUtil.setArgument(event, ((String) null), value);
  }
  
  public static void setArgument(final Event event, final String parameterName, final String value) {
    FunctionParameter parameter = FunctionParametersUtil.getParameter(event.getFunction(), parameterName);
    FunctionParameterKind _switchResult = null;
    boolean _matched = false;
    if (event instanceof ExitEvent) {
      _matched=true;
      FunctionParameterKind _xifexpression = null;
      if ((parameterName == null)) {
        FunctionParameterKind _xblockexpression = null;
        {
          if (((parameter != null) && (!Objects.equal(parameter.getKind(), FunctionParameterKind.RETURN)))) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("Expected return parameter when name is not set, but was ");
            FunctionParameterKind _kind = parameter.getKind();
            _builder.append(_kind);
            throw new IllegalArgumentException(_builder.toString());
          }
          _xblockexpression = FunctionParameterKind.RETURN;
        }
        _xifexpression = _xblockexpression;
      } else {
        FunctionParameterKind _xifexpression_1 = null;
        if (((parameter != null) && (!Objects.equal(parameter.getKind(), FunctionParameterKind.OUT)))) {
          _xifexpression_1 = FunctionParameterKind.IN_OUT;
        } else {
          _xifexpression_1 = FunctionParameterKind.OUT;
        }
        _xifexpression = _xifexpression_1;
      }
      _switchResult = _xifexpression;
    }
    if (!_matched) {
      if (event instanceof EntryEvent) {
        _matched=true;
        FunctionParameterKind _xifexpression = null;
        if (((parameter != null) && (!Objects.equal(parameter.getKind(), FunctionParameterKind.IN)))) {
          _xifexpression = FunctionParameterKind.IN_OUT;
        } else {
          _xifexpression = FunctionParameterKind.IN;
        }
        _switchResult = _xifexpression;
      }
    }
    final FunctionParameterKind parameterKind = _switchResult;
    if ((parameter == null)) {
      parameter = FunctionParametersUtil.getParameter(event.getFunction(), parameterName, parameterKind);
    } else {
      parameter.setKind(parameterKind);
    }
    FunctionParametersUtil.setArgument(event, parameter, value);
  }
  
  public static void setArgument(final Event event, final FunctionParameter parameter, final String value) {
    if ((value == null)) {
      event.getArguments().removeKey(parameter);
    } else {
      event.getArguments().put(parameter, value);
    }
  }
  
  public static FunctionParameter getParameter(final Function function, final String parameterName) {
    return FunctionParametersUtil.getParameter(function, parameterName, null);
  }
  
  public static FunctionParameter getParameter(final Function function, final String parameterName, final FunctionParameterKind parameterKind) {
    final Function1<FunctionParameter, Boolean> _function = (FunctionParameter it) -> {
      String _name = it.getName();
      return Boolean.valueOf(Objects.equal(_name, parameterName));
    };
    final FunctionParameter parameter = IterableExtensions.<FunctionParameter>findFirst(function.getParameters(), _function);
    if ((parameter != null)) {
      if (((parameterKind != null) && (!Objects.equal(parameter.getKind(), parameterKind)))) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Expected parameter kind ");
        FunctionParameterKind _kind = parameter.getKind();
        _builder.append(_kind);
        _builder.append(", but was ");
        _builder.append(parameterKind);
        _builder.append(" for function parameter ");
        String _name = function.getName();
        _builder.append(_name);
        _builder.append("(");
        _builder.append(parameterName);
        _builder.append(")");
        throw new IllegalArgumentException(_builder.toString());
      }
      return parameter;
    } else {
      if ((parameterKind != null)) {
        FunctionParameter _createFunctionParameter = FunctionParametersUtil.m_impl.createFunctionParameter();
        final Procedure1<FunctionParameter> _function_1 = (FunctionParameter it) -> {
          it.setName(parameterName);
          it.setKind(parameterKind);
        };
        final FunctionParameter newParameter = ObjectExtensions.<FunctionParameter>operator_doubleArrow(_createFunctionParameter, _function_1);
        EList<FunctionParameter> _parameters = function.getParameters();
        _parameters.add(newParameter);
        return newParameter;
      } else {
        return null;
      }
    }
  }
}
