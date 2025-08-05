/**
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.xtext.ui.labeling;

import com.google.inject.Inject;
import nl.esi.pps.architecture.provider.ArchitectureEditPlugin;
import nl.esi.pps.tmsc.provider.TmscEditPlugin;
import nl.esi.pps.tmsc.xtext.TmscXtextQueries;
import nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage;
import nl.esi.pps.tmsc.xtext.tmscXtext.XDependency;
import nl.esi.pps.tmsc.xtext.tmscXtext.XDependencySettings;
import nl.esi.pps.tmsc.xtext.tmscXtext.XDependencyType;
import nl.esi.pps.tmsc.xtext.tmscXtext.XEvent;
import nl.esi.pps.tmsc.xtext.tmscXtext.XEventType;
import nl.esi.pps.tmsc.xtext.tmscXtext.XFunction;
import nl.esi.pps.tmsc.xtext.tmscXtext.XNamedArchitectureElement;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Provides labels for EObjects.
 * 
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#label-provider
 */
@SuppressWarnings("all")
public class TmscXtextLabelProvider extends DefaultEObjectLabelProvider {
  @Inject
  public TmscXtextLabelProvider(final AdapterFactoryLabelProvider delegate) {
    super(delegate);
  }

  public String text(final XDependencySettings xDependencySettings) {
    StringConcatenation _builder = new StringConcatenation();
    XDependencyType _type = xDependencySettings.getType();
    _builder.append(_type);
    _builder.append(" settings");
    return _builder.toString();
  }

  public String text(final XEvent xEvent) {
    final INode timestampNode = IterableExtensions.<INode>head(NodeModelUtils.findNodesForFeature(xEvent, TmscXtextPackage.Literals.XEVENT__TIMESTAMP));
    StringConcatenation _builder = new StringConcatenation();
    String _text = this.text(xEvent.getType());
    _builder.append(_text);
    _builder.append(" event");
    {
      if ((timestampNode != null)) {
        _builder.append(" at ");
        String _text_1 = timestampNode.getText();
        _builder.append(_text_1);
      }
    }
    return _builder.toString();
  }

  public String image(final XEvent xEvent) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("full/obj16/Event");
    String _name = xEvent.getType().getName();
    _builder.append(_name);
    _builder.append(".gif");
    return this.fromTmscEditPlugin(_builder);
  }

  public String text(final XEventType xEventType) {
    return StringExtensions.toFirstUpper(xEventType.getName().toLowerCase());
  }

  public String image(final XDependency dependency) {
    String _switchResult = null;
    XDependencyType _type = TmscXtextQueries.getType(dependency);
    if (_type != null) {
      switch (_type) {
        case DOMAIN:
          _switchResult = this.fromTmscEditPlugin("full/obj16/DomainDependency.gif");
          break;
        case LIFELINE_SEGMENT:
          _switchResult = this.fromTmscEditPlugin("full/obj16/LifelineSegment.gif");
          break;
        case MESSAGE_CONTROL:
          _switchResult = this.fromTmscEditPlugin("full/obj16/MessageControl.gif");
          break;
        case MESSAGE:
          _switchResult = this.fromTmscEditPlugin("full/obj16/Message.gif");
          break;
        case REPLY:
          _switchResult = this.fromTmscEditPlugin("full/obj16/Reply.gif");
          break;
        case REQUEST:
          _switchResult = this.fromTmscEditPlugin("full/obj16/Request.gif");
          break;
        default:
          break;
      }
    }
    return _switchResult;
  }

  public String text(final XNamedArchitectureElement xElement) {
    String _elvis = null;
    String _description = xElement.getDescription();
    if (_description != null) {
      _elvis = _description;
    } else {
      String _name = xElement.getName();
      _elvis = _name;
    }
    return _elvis;
  }

  public String image(final XNamedArchitectureElement xElement) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("full/obj16/");
    String _substring = xElement.eClass().getName().substring(1);
    _builder.append(_substring);
    _builder.append(".gif");
    return this.fromArchitectureEditPlugin(_builder);
  }

  public String image(final XFunction function) {
    String _switchResult = null;
    boolean _matched = false;
    boolean _isIpcClient = function.isIpcClient();
    if (_isIpcClient) {
      _matched=true;
      _switchResult = this.fromArchitectureEditPlugin("full/obj16/IPCClientFunction.gif");
    }
    if (!_matched) {
      boolean _isIpcServer = function.isIpcServer();
      if (_isIpcServer) {
        _matched=true;
        _switchResult = this.fromArchitectureEditPlugin("full/obj16/IPCServerFunction.gif");
      }
    }
    if (!_matched) {
      _switchResult = this.fromArchitectureEditPlugin("full/obj16/Function.gif");
    }
    return _switchResult;
  }

  private String fromArchitectureEditPlugin(final CharSequence path) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("platform:/plugin/");
    String _symbolicName = ArchitectureEditPlugin.INSTANCE.getSymbolicName();
    _builder.append(_symbolicName);
    _builder.append("/");
    _builder.append(path);
    return _builder.toString();
  }

  private String fromTmscEditPlugin(final CharSequence path) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("platform:/plugin/");
    String _symbolicName = TmscEditPlugin.INSTANCE.getSymbolicName();
    _builder.append(_symbolicName);
    _builder.append("/");
    _builder.append(path);
    return _builder.toString();
  }
}
