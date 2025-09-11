/**
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.xtext.ui.codemining;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import nl.esi.pps.tmsc.rendering.RenderingProperties;
import nl.esi.pps.tmsc.viewers.plot.RenderingStrategyRegistryReader;
import nl.esi.pps.tmsc.xtext.TmscXtextQueries;
import nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage;
import nl.esi.pps.tmsc.xtext.tmscXtext.XDependency;
import nl.esi.pps.tmsc.xtext.tmscXtext.XDependencyType;
import nl.esi.pps.tmsc.xtext.tmscXtext.XDependencyTypeObject;
import nl.esi.pps.tmsc.xtext.tmscXtext.XEvent;
import nl.esi.pps.tmsc.xtext.tmscXtext.XEventArgument;
import nl.esi.pps.tmsc.xtext.tmscXtext.XFunctionParameter;
import nl.esi.pps.tmsc.xtext.tmscXtext.XProperty;
import nl.esi.pps.tmsc.xtext.tmscXtext.XPropertyStringValue;
import nl.esi.pps.tmsc.xtext.tmscXtext.XPropertyValue;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.codemining.ICodeMining;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.codemining.AbstractXtextCodeMiningProvider;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.XbaseGenerated;

@SuppressWarnings("all")
public class TmscXtextCodeMiningProvider extends AbstractXtextCodeMiningProvider {
  @Override
  public void createCodeMinings(final IDocument document, final XtextResource resource, final CancelIndicator indicator, final IAcceptor<? super ICodeMining> acceptor) throws BadLocationException {
    final Procedure1<EObject> _function = (EObject it) -> {
      try {
        this.createCodeMinings(it, acceptor);
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    IteratorExtensions.<EObject>forEach(resource.getAllContents(), _function);
  }

  private void _createCodeMinings(final EObject eObject, final IAcceptor<? super ICodeMining> acceptor) throws BadLocationException {
  }

  private void _createCodeMinings(final XProperty xProperty, final IAcceptor<? super ICodeMining> acceptor) throws BadLocationException {
    String _name = xProperty.getName();
    boolean _equals = Objects.equals(_name, RenderingProperties.PROPERTY_RENDERING_STRATEGY_ID);
    if (_equals) {
      final XPropertyValue xPropertyValue = xProperty.getValue();
      if ((xPropertyValue instanceof XPropertyStringValue)) {
        final Function1<IConfigurationElement, Boolean> _function = (IConfigurationElement it) -> {
          String _iD = RenderingStrategyRegistryReader.getID(it);
          String _value = ((XPropertyStringValue)xPropertyValue).getValue();
          return Boolean.valueOf(Objects.equals(_iD, _value));
        };
        final IConfigurationElement renderingStrategyConfiguration = IterableExtensions.<IConfigurationElement>findFirst(((Iterable<IConfigurationElement>)Conversions.doWrapArray(RenderingStrategyRegistryReader.getRenderingStrategyConfigurations())), _function);
        String _xifexpression = null;
        if ((renderingStrategyConfiguration == null)) {
          _xifexpression = "!! Unknown !!";
        } else {
          _xifexpression = RenderingStrategyRegistryReader.getName(renderingStrategyConfiguration);
        }
        final String renderingStrategyName = _xifexpression;
        final int annotationOffset = NodeModelUtils.findActualNodeFor(xPropertyValue).getTotalOffset();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(" ");
        _builder.append(renderingStrategyName, " ");
        _builder.append(":");
        acceptor.accept(this.createNewLineContentCodeMining(annotationOffset, _builder.toString()));
      }
    }
  }

  private void _createCodeMinings(final XDependency xDependency, final IAcceptor<? super ICodeMining> acceptor) throws BadLocationException {
    XDependencyTypeObject _typeObject = xDependency.getTypeObject();
    boolean _tripleEquals = (_typeObject == null);
    if (_tripleEquals) {
      final int annotationOffset = NodeModelUtils.findActualNodeFor(xDependency).getTotalOffset();
      StringConcatenation _builder = new StringConcatenation();
      XDependencyType _type = TmscXtextQueries.getType(xDependency);
      _builder.append(_type);
      _builder.append(" ");
      acceptor.accept(this.createNewLineContentCodeMining(annotationOffset, _builder.toString()));
    }
  }

  private void _createCodeMinings(final XEvent xEvent, final IAcceptor<? super ICodeMining> acceptor) throws BadLocationException {
    final EList<XDependency> dependencies = xEvent.getIncomingDependencies();
    final List<INode> dependencyNodes = NodeModelUtils.findNodesForFeature(xEvent, TmscXtextPackage.Literals.XEVENT__INCOMING_DEPENDENCIES);
    for (int i = 0; ((i < dependencies.size()) && (i < dependencyNodes.size())); i++) {
      {
        final XDependencyType dependencyType = TmscXtextQueries.getType(dependencies.get(i));
        final int annotationOffset = dependencyNodes.get(i).getTotalOffset();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(dependencyType);
        _builder.append(" ");
        acceptor.accept(this.createNewLineContentCodeMining(annotationOffset, _builder.toString()));
      }
    }
  }

  private void _createCodeMinings(final XEventArgument xEventArgument, final IAcceptor<? super ICodeMining> acceptor) throws BadLocationException {
    XFunctionParameter _parameter = xEventArgument.getParameter();
    boolean _tripleNotEquals = (_parameter != null);
    if (_tripleNotEquals) {
      final int annotationOffset = NodeModelUtils.findActualNodeFor(xEventArgument).getTotalOffset();
      StringConcatenation _builder = new StringConcatenation();
      String _literal = xEventArgument.getParameter().getKind().getLiteral();
      _builder.append(_literal);
      _builder.append(" ");
      acceptor.accept(this.createNewLineContentCodeMining(annotationOffset, _builder.toString()));
    }
  }

  @XbaseGenerated
  private void createCodeMinings(final EObject xDependency, final IAcceptor<? super ICodeMining> acceptor) throws BadLocationException {
    if (xDependency instanceof XDependency) {
      _createCodeMinings((XDependency)xDependency, acceptor);
      return;
    } else if (xDependency instanceof XEvent) {
      _createCodeMinings((XEvent)xDependency, acceptor);
      return;
    } else if (xDependency instanceof XEventArgument) {
      _createCodeMinings((XEventArgument)xDependency, acceptor);
      return;
    } else if (xDependency instanceof XProperty) {
      _createCodeMinings((XProperty)xDependency, acceptor);
      return;
    } else if (xDependency != null) {
      _createCodeMinings(xDependency, acceptor);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(xDependency, acceptor).toString());
    }
  }
}
