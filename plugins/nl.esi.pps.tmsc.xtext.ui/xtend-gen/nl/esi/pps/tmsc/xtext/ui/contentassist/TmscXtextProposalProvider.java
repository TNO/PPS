/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.xtext.ui.contentassist;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import nl.esi.pps.common.jfreechart.rendering.RenderingPaint;
import nl.esi.pps.common.jfreechart.rendering.RenderingStroke;
import nl.esi.pps.tmsc.metric.PropertiesMetricProcessor;
import nl.esi.pps.tmsc.rendering.RenderingDependencies;
import nl.esi.pps.tmsc.rendering.RenderingExecutions;
import nl.esi.pps.tmsc.rendering.RenderingProperties;
import nl.esi.pps.tmsc.viewers.plot.RenderingStrategyRegistryReader;
import nl.esi.pps.tmsc.xtext.TmscXtextQueries;
import nl.esi.pps.tmsc.xtext.services.TmscXtextGrammarAccess;
import nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextModel;
import nl.esi.pps.tmsc.xtext.tmscXtext.XDependency;
import nl.esi.pps.tmsc.xtext.tmscXtext.XDependencySettings;
import nl.esi.pps.tmsc.xtext.tmscXtext.XDependencyType;
import nl.esi.pps.tmsc.xtext.tmscXtext.XEvent;
import nl.esi.pps.tmsc.xtext.tmscXtext.XEventType;
import nl.esi.pps.tmsc.xtext.tmscXtext.XFunctionParameter;
import nl.esi.pps.tmsc.xtext.tmscXtext.XFunctionParameterKind;
import nl.esi.pps.tmsc.xtext.tmscXtext.XProperty;
import nl.esi.pps.tmsc.xtext.tmscXtext.XPropertyStringValue;
import nl.esi.pps.tmsc.xtext.tmscXtext.XPropertyValue;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.IImageHelper;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#content-assist
 * on how to customize the content assistant.
 */
@SuppressWarnings("all")
public class TmscXtextProposalProvider extends AbstractTmscXtextProposalProvider {
  @Inject
  private IImageHelper imageHelper;
  
  @Inject
  @Extension
  private TmscXtextGrammarAccess tmscXtextGrammarAccess;
  
  @Inject
  @Extension
  private IValueConverterService valueConverterService;
  
  @Override
  public void completeXEvent_IncomingDependencies(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    final Function1<XEvent, EList<XDependency>> _function = (XEvent it) -> {
      return it.getOutgoingDependencies();
    };
    final Iterable<XDependency> xDependencies = IterableExtensions.<XEvent, XDependency>flatMap(EcoreUtil2.<TmscXtextModel>getContainerOfType(model, TmscXtextModel.class).getEvents(), _function);
    for (final XDependency xDependency : xDependencies) {
      String _name = xDependency.getName();
      StringConcatenation _builder = new StringConcatenation();
      XDependencyType _type = TmscXtextQueries.getType(xDependency);
      _builder.append(_type);
      _builder.append(": ");
      String _name_1 = xDependency.getName();
      _builder.append(_name_1);
      acceptor.accept(
        this.createCompletionProposal(_name, _builder.toString(), 
          this.getImage(xDependency), context));
    }
  }
  
  @Override
  public void completeXDependency_Name(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    final Function1<XDependencySettings, Boolean> _function = (XDependencySettings it) -> {
      String _prefix = it.getPrefix();
      return Boolean.valueOf((_prefix == null));
    };
    final Iterable<XDependencySettings> defaults = IterableExtensions.<XDependencySettings>reject(EcoreUtil2.<TmscXtextModel>getContainerOfType(model, TmscXtextModel.class).getDependencySettings(), _function);
    for (final XDependencySettings dependencyDefaults : defaults) {
      String _prefix = dependencyDefaults.getPrefix();
      StringConcatenation _builder = new StringConcatenation();
      XDependencyType _type = dependencyDefaults.getType();
      _builder.append(_type);
      _builder.append(": ");
      String _prefix_1 = dependencyDefaults.getPrefix();
      _builder.append(_prefix_1);
      acceptor.accept(
        this.createCompletionProposal(_prefix, _builder.toString(), null, context));
    }
  }
  
  @Override
  public void completeXDependency_Request(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    AbstractElement _terminal = assignment.getTerminal();
    final Predicate<IEObjectDescription> _function = (IEObjectDescription it) -> {
      EObject _eObjectOrProxy = it.getEObjectOrProxy();
      XDependencyType _type = TmscXtextQueries.getType(((XDependency) _eObjectOrProxy));
      return Objects.equal(_type, XDependencyType.REQUEST);
    };
    this.lookupCrossReference(((CrossReference) _terminal), context, acceptor, _function);
  }
  
  @Override
  public void completeXDependency_Message(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    AbstractElement _terminal = assignment.getTerminal();
    final Predicate<IEObjectDescription> _function = (IEObjectDescription it) -> {
      boolean _switchResult = false;
      EObject _eObjectOrProxy = it.getEObjectOrProxy();
      XDependencyType _type = TmscXtextQueries.getType(((XDependency) _eObjectOrProxy));
      if (_type != null) {
        switch (_type) {
          case MESSAGE:
          case REQUEST:
          case REPLY:
            _switchResult = true;
            break;
          default:
            _switchResult = false;
            break;
        }
      } else {
        _switchResult = false;
      }
      return _switchResult;
    };
    this.lookupCrossReference(((CrossReference) _terminal), context, acceptor, _function);
  }
  
  @Override
  public void completeXProperty_Name(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    super.completeXProperty_Name(model, assignment, context, acceptor);
    final Function1<XProperty, String> _function = (XProperty it) -> {
      return it.getName();
    };
    final Set<String> propertyNames = IteratorExtensions.<String>toSet(IteratorExtensions.<XProperty, String>map(Iterators.<XProperty>filter(EcoreUtil.getRootContainer(model).eAllContents(), XProperty.class), _function));
    propertyNames.add(RenderingProperties.PROPERTY_RENDERING_STRATEGY_ID);
    propertyNames.add(RenderingProperties.PROPERTY_RENDERING_DEPENDENCIES);
    propertyNames.add(RenderingProperties.PROPERTY_RENDERING_EXECUTIONS);
    propertyNames.add(RenderingProperties.PROPERTY_HIDDEN);
    propertyNames.add(RenderingProperties.PROPERTY_PAINT);
    propertyNames.add(RenderingProperties.PROPERTY_STROKE);
    propertyNames.add(PropertiesMetricProcessor.PROPERTY_METRIC_BUDGET);
    propertyNames.add(PropertiesMetricProcessor.PROPERTY_METRIC_INSTANCE_FROM_ID);
    propertyNames.add(PropertiesMetricProcessor.PROPERTY_METRIC_INSTANCE_TO_ID);
    propertyNames.add(PropertiesMetricProcessor.PROPERTY_METRIC_ACTIVITY_CUT_OFF);
    for (final String propertyName : propertyNames) {
      acceptor.accept(this.createCompletionProposal(propertyName, propertyName, null, context));
    }
  }
  
  @Override
  public void completeXPropertyValue_Value(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    super.completeXPropertyValue_Value(model, assignment, context, acceptor);
    AbstractElement _terminal = assignment.getTerminal();
    RuleCall _valueIDStringParserRuleCall_0_1_0 = this.tmscXtextGrammarAccess.getXPropertyValueAccess().getValueIDStringParserRuleCall_0_1_0();
    boolean _equals = Objects.equal(_terminal, _valueIDStringParserRuleCall_0_1_0);
    if (_equals) {
      String _name = ((XProperty) model).getName();
      final String propertyName = _name;
      if (propertyName != null) {
        switch (propertyName) {
          case RenderingProperties.PROPERTY_RENDERING_STRATEGY_ID:
            IConfigurationElement[] _renderingStrategyConfigurations = RenderingStrategyRegistryReader.getRenderingStrategyConfigurations();
            for (final IConfigurationElement renderingStrategy : _renderingStrategyConfigurations) {
              {
                final Optional<ImageDescriptor> imageDescriptor = RenderingStrategyRegistryReader.getIcon(renderingStrategy);
                Image _xifexpression = null;
                boolean _isPresent = imageDescriptor.isPresent();
                if (_isPresent) {
                  _xifexpression = this.imageHelper.getImage(imageDescriptor.get());
                } else {
                  _xifexpression = null;
                }
                final Image image = _xifexpression;
                acceptor.accept(
                  this.createCompletionProposal(
                    this.toIDStringProposal(RenderingStrategyRegistryReader.getID(renderingStrategy)), 
                    RenderingStrategyRegistryReader.getName(renderingStrategy), image, context));
              }
            }
            break;
          case RenderingProperties.PROPERTY_RENDERING_DEPENDENCIES:
            RenderingDependencies[] _values = RenderingDependencies.values();
            for (final RenderingDependencies rendering : _values) {
              acceptor.accept(this.createCompletionProposal(this.toIDStringProposal(rendering.name()), rendering.name(), null, context));
            }
            break;
          case RenderingProperties.PROPERTY_RENDERING_EXECUTIONS:
            RenderingExecutions[] _values_1 = RenderingExecutions.values();
            for (final RenderingExecutions rendering_1 : _values_1) {
              acceptor.accept(this.createCompletionProposal(this.toIDStringProposal(rendering_1.name()), rendering_1.name(), null, context));
            }
            break;
          case RenderingProperties.PROPERTY_STROKE:
            RenderingStroke[] _values_2 = RenderingStroke.values();
            for (final RenderingStroke stroke : _values_2) {
              acceptor.accept(this.createCompletionProposal(this.toIDStringProposal(stroke.name()), stroke.name(), null, context));
            }
            break;
          default:
            {
              final Function1<XProperty, Boolean> _function = (XProperty it) -> {
                String _name_1 = it.getName();
                return Boolean.valueOf(Objects.equal(_name_1, propertyName));
              };
              final Iterator<XProperty> properties = IteratorExtensions.<XProperty>filter(Iterators.<XProperty>filter(EcoreUtil.getRootContainer(model).eAllContents(), XProperty.class), _function);
              final Function1<XProperty, XPropertyValue> _function_1 = (XProperty it) -> {
                return it.getValue();
              };
              final Function1<XPropertyStringValue, String> _function_2 = (XPropertyStringValue it) -> {
                return it.getValue();
              };
              final Set<String> propertyValues = IteratorExtensions.<String>toSet(IteratorExtensions.<XPropertyStringValue, String>map(Iterators.<XPropertyStringValue>filter(IteratorExtensions.<XProperty, XPropertyValue>map(properties, _function_1), XPropertyStringValue.class), _function_2));
              boolean _equals_1 = RenderingProperties.PROPERTY_PAINT.equals(propertyName);
              if (_equals_1) {
                final Function1<RenderingPaint, String> _function_3 = (RenderingPaint it) -> {
                  return it.name();
                };
                List<String> _map = ListExtensions.<RenderingPaint, String>map(((List<RenderingPaint>)Conversions.doWrapArray(RenderingPaint.values())), _function_3);
                Iterables.<String>addAll(propertyValues, _map);
              }
              for (final String propertyValue : propertyValues) {
                acceptor.accept(this.createCompletionProposal(this.toIDStringProposal(propertyValue), propertyValue, null, context));
              }
            }
            break;
        }
      } else {
        {
          final Function1<XProperty, Boolean> _function = (XProperty it) -> {
            String _name_1 = it.getName();
            return Boolean.valueOf(Objects.equal(_name_1, propertyName));
          };
          final Iterator<XProperty> properties = IteratorExtensions.<XProperty>filter(Iterators.<XProperty>filter(EcoreUtil.getRootContainer(model).eAllContents(), XProperty.class), _function);
          final Function1<XProperty, XPropertyValue> _function_1 = (XProperty it) -> {
            return it.getValue();
          };
          final Function1<XPropertyStringValue, String> _function_2 = (XPropertyStringValue it) -> {
            return it.getValue();
          };
          final Set<String> propertyValues = IteratorExtensions.<String>toSet(IteratorExtensions.<XPropertyStringValue, String>map(Iterators.<XPropertyStringValue>filter(IteratorExtensions.<XProperty, XPropertyValue>map(properties, _function_1), XPropertyStringValue.class), _function_2));
          boolean _equals_1 = RenderingProperties.PROPERTY_PAINT.equals(propertyName);
          if (_equals_1) {
            final Function1<RenderingPaint, String> _function_3 = (RenderingPaint it) -> {
              return it.name();
            };
            List<String> _map = ListExtensions.<RenderingPaint, String>map(((List<RenderingPaint>)Conversions.doWrapArray(RenderingPaint.values())), _function_3);
            Iterables.<String>addAll(propertyValues, _map);
          }
          for (final String propertyValue : propertyValues) {
            acceptor.accept(this.createCompletionProposal(this.toIDStringProposal(propertyValue), propertyValue, null, context));
          }
        }
      }
    }
  }
  
  @Override
  public void completeXEventArgument_Parameter(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    final XEvent xEvent = EcoreUtil2.<XEvent>getContainerOfType(model, XEvent.class);
    EnumSet<XFunctionParameterKind> _xifexpression = null;
    XEventType _type = xEvent.getType();
    boolean _equals = Objects.equal(_type, XEventType.ENTRY);
    if (_equals) {
      _xifexpression = EnumSet.<XFunctionParameterKind>of(XFunctionParameterKind.IN, XFunctionParameterKind.IN_OUT);
    } else {
      _xifexpression = EnumSet.<XFunctionParameterKind>of(XFunctionParameterKind.IN_OUT, XFunctionParameterKind.OUT, XFunctionParameterKind.RETURN);
    }
    final EnumSet<XFunctionParameterKind> parameterKinds = _xifexpression;
    AbstractElement _terminal = assignment.getTerminal();
    final Predicate<IEObjectDescription> _function = (IEObjectDescription it) -> {
      EObject _eObjectOrProxy = it.getEObjectOrProxy();
      return parameterKinds.contains(((XFunctionParameter) _eObjectOrProxy).getKind());
    };
    this.lookupCrossReference(((CrossReference) _terminal), context, acceptor, _function);
  }
  
  @Override
  public void complete_EBOOLEAN_OBJECT(final EObject model, final RuleCall ruleCall, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    acceptor.accept(this.createCompletionProposal("false", "false", null, context));
    acceptor.accept(this.createCompletionProposal("true", "true", null, context));
  }
  
  private String toIDStringProposal(final String value) {
    return this.valueConverterService.toString(value, "IDString");
  }
}
