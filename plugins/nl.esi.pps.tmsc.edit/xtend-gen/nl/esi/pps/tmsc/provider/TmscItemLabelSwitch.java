/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.provider;

import com.google.common.base.Objects;
import java.util.Arrays;
import nl.esi.emf.edit.provider.EMFEditUtil;
import nl.esi.pps.architecture.ArchitecturePackage;
import nl.esi.pps.architecture.implemented.Function;
import nl.esi.pps.architecture.implemented.ImplementedPackage;
import nl.esi.pps.architecture.instantiated.Executor;
import nl.esi.pps.architecture.instantiated.InstantiatedPackage;
import nl.esi.pps.architecture.provider.ArchitectureItemLabelSwitch;
import nl.esi.pps.architecture.specified.SpecifiedPackage;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.EntryEvent;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.ExitEvent;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.Interval;
import nl.esi.pps.tmsc.Lifeline;
import nl.esi.pps.tmsc.LifelineSegment;
import nl.esi.pps.tmsc.Message;
import nl.esi.pps.tmsc.MessageControl;
import nl.esi.pps.tmsc.ScopedTMSC;
import nl.esi.pps.tmsc.TmscPackage;
import nl.esi.pps.tmsc.text.ETimestampFormat;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class TmscItemLabelSwitch {
  public static final TmscItemLabelSwitch eINSTANCE = new TmscItemLabelSwitch();
  
  protected String _getText(final Object object) {
    return String.valueOf(object);
  }
  
  protected String _getText(final EObject eObject) {
    String _switchResult = null;
    EPackage _ePackage = eObject.eClass().getEPackage();
    boolean _matched = false;
    if (Objects.equal(_ePackage, TmscPackage.eINSTANCE)) {
      _matched=true;
      _switchResult = this.getText(eObject.eClass());
    }
    if (!_matched) {
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
        _switchResult = ArchitectureItemLabelSwitch.eINSTANCE.getText(eObject);
      }
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
    if (Objects.equal(_ePackage, TmscPackage.eINSTANCE)) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("_UI_");
      String _name = eClass.getName();
      _builder.append(_name);
      _builder.append("_type");
      _switchResult = TmscEditPlugin.INSTANCE.getString(_builder.toString());
    }
    if (!_matched) {
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
        _switchResult = ArchitectureItemLabelSwitch.eINSTANCE.getText(eClass);
      }
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
  
  protected String _getText(final FullScopeTMSC tmsc) {
    return this.getText(tmsc.eClass());
  }
  
  protected String _getText(final ScopedTMSC tmsc) {
    return tmsc.getName();
  }
  
  protected String _getText(final Lifeline lifeline) {
    Executor _executor = lifeline.getExecutor();
    String _text = null;
    if (_executor!=null) {
      _text=this.getText(_executor);
    }
    return _text;
  }
  
  protected String _getText(final EntryEvent event) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Entry at ");
    String _format = ETimestampFormat.eINSTANCE.format(event.getTimestamp());
    _builder.append(_format);
    return _builder.toString();
  }
  
  protected String _getText(final ExitEvent event) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Exit at ");
    String _format = ETimestampFormat.eINSTANCE.format(event.getTimestamp());
    _builder.append(_format);
    return _builder.toString();
  }
  
  protected String _getText(final MessageControl messageControl) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Control ");
    Message _message = messageControl.getMessage();
    String _text = null;
    if (_message!=null) {
      _text=this.getText(_message);
    }
    String _firstLower = StringExtensions.toFirstLower(_text);
    _builder.append(_firstLower);
    return _builder.toString();
  }
  
  private String _getReference(final EntryEvent event) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entry of ");
    Function _function = event.getFunction();
    String _text = null;
    if (_function!=null) {
      _text=this.getText(_function);
    }
    _builder.append(_text);
    _builder.append(" on ");
    String _text_1 = this.getText(event.getLifeline());
    _builder.append(_text_1);
    return _builder.toString();
  }
  
  private String _getReference(final ExitEvent event) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("exit of ");
    Function _function = event.getFunction();
    String _text = null;
    if (_function!=null) {
      _text=this.getText(_function);
    }
    _builder.append(_text);
    _builder.append(" on ");
    String _text_1 = this.getText(event.getLifeline());
    _builder.append(_text_1);
    return _builder.toString();
  }
  
  protected String _getText(final Dependency dependency) {
    StringConcatenation _builder = new StringConcatenation();
    String _text = this.getText(dependency.eClass());
    _builder.append(_text);
    _builder.append(" from ");
    Event _source = dependency.getSource();
    String _reference = null;
    if (_source!=null) {
      _reference=this.getReference(_source);
    }
    _builder.append(_reference);
    _builder.append(" to ");
    Event _target = dependency.getTarget();
    String _reference_1 = null;
    if (_target!=null) {
      _reference_1=this.getReference(_target);
    }
    _builder.append(_reference_1);
    return _builder.toString();
  }
  
  protected String _getText(final LifelineSegment lifelineSegment) {
    String _elvis = null;
    Execution _activeExecution = lifelineSegment.getActiveExecution();
    String _text = null;
    if (_activeExecution!=null) {
      _text=this.getText(_activeExecution);
    }
    if (_text != null) {
      _elvis = _text;
    } else {
      _elvis = "Idle";
    }
    return _elvis;
  }
  
  protected String _getText(final Execution execution) {
    Function _function = execution.getFunction();
    String _text = null;
    if (_function!=null) {
      _text=this.getText(_function);
    }
    return _text;
  }
  
  protected String _getText(final Interval interval) {
    return interval.getName();
  }
  
  public String getText(final Object eClass) {
    if (eClass instanceof EClass) {
      return _getText((EClass)eClass);
    } else if (eClass instanceof EntryEvent) {
      return _getText((EntryEvent)eClass);
    } else if (eClass instanceof ExitEvent) {
      return _getText((ExitEvent)eClass);
    } else if (eClass instanceof FullScopeTMSC) {
      return _getText((FullScopeTMSC)eClass);
    } else if (eClass instanceof LifelineSegment) {
      return _getText((LifelineSegment)eClass);
    } else if (eClass instanceof MessageControl) {
      return _getText((MessageControl)eClass);
    } else if (eClass instanceof ScopedTMSC) {
      return _getText((ScopedTMSC)eClass);
    } else if (eClass instanceof Dependency) {
      return _getText((Dependency)eClass);
    } else if (eClass instanceof Execution) {
      return _getText((Execution)eClass);
    } else if (eClass instanceof Interval) {
      return _getText((Interval)eClass);
    } else if (eClass instanceof Lifeline) {
      return _getText((Lifeline)eClass);
    } else if (eClass instanceof EObject) {
      return _getText((EObject)eClass);
    } else if (eClass != null) {
      return _getText(eClass);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(eClass).toString());
    }
  }
  
  private String getReference(final Event event) {
    if (event instanceof EntryEvent) {
      return _getReference((EntryEvent)event);
    } else if (event instanceof ExitEvent) {
      return _getReference((ExitEvent)event);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(event).toString());
    }
  }
}
