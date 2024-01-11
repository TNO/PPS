/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.xtext.linking;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Collections;
import java.util.List;
import nl.esi.pps.tmsc.xtext.services.TmscXtextGrammarAccess;
import nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextFactory;
import nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextModel;
import nl.esi.pps.tmsc.xtext.tmscXtext.XComponent;
import nl.esi.pps.tmsc.xtext.tmscXtext.XExecutor;
import nl.esi.pps.tmsc.xtext.tmscXtext.XFunction;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class TmscXtextLinkingService extends DefaultLinkingService {
  @Extension
  private final TmscXtextFactory m_tmsc = TmscXtextFactory.eINSTANCE;
  
  @Inject
  @Extension
  private TmscXtextGrammarAccess tmscXtextGrammarAccess;
  
  @Override
  public List<EObject> getLinkedObjects(final EObject context, final EReference ref, final INode node) throws IllegalNodeException {
    final List<EObject> result = super.getLinkedObjects(context, ref, node);
    boolean _isEmpty = result.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      return result;
    }
    EObject _grammarElement = node.getGrammarElement();
    boolean _matched = false;
    CrossReference _executorXExecutorCrossReference_2_0 = this.tmscXtextGrammarAccess.getXEventAccess().getExecutorXExecutorCrossReference_2_0();
    if (Objects.equal(_grammarElement, _executorXExecutorCrossReference_2_0)) {
      _matched=true;
      XExecutor _createXExecutor = this.m_tmsc.createXExecutor();
      final Procedure1<XExecutor> _function = (XExecutor it) -> {
        it.setName(this.getCrossRefNodeAsString(node));
      };
      final XExecutor executor = ObjectExtensions.<XExecutor>operator_doubleArrow(_createXExecutor, _function);
      EList<XExecutor> _executors = EcoreUtil2.<TmscXtextModel>getContainerOfType(context, TmscXtextModel.class).getExecutors();
      _executors.add(executor);
      return Collections.<EObject>singletonList(executor);
    }
    if (!_matched) {
      CrossReference _componentXComponentCrossReference_3_0 = this.tmscXtextGrammarAccess.getXEventAccess().getComponentXComponentCrossReference_3_0();
      if (Objects.equal(_grammarElement, _componentXComponentCrossReference_3_0)) {
        _matched=true;
        XComponent _createXComponent = this.m_tmsc.createXComponent();
        final Procedure1<XComponent> _function_1 = (XComponent it) -> {
          it.setName(this.getCrossRefNodeAsString(node));
        };
        final XComponent component = ObjectExtensions.<XComponent>operator_doubleArrow(_createXComponent, _function_1);
        EList<XComponent> _components = EcoreUtil2.<TmscXtextModel>getContainerOfType(context, TmscXtextModel.class).getComponents();
        _components.add(component);
        return Collections.<EObject>singletonList(component);
      }
    }
    if (!_matched) {
      CrossReference _functionXFunctionCrossReference_5_0 = this.tmscXtextGrammarAccess.getXEventAccess().getFunctionXFunctionCrossReference_5_0();
      if (Objects.equal(_grammarElement, _functionXFunctionCrossReference_5_0)) {
        _matched=true;
        XFunction _createXFunction = this.m_tmsc.createXFunction();
        final Procedure1<XFunction> _function_2 = (XFunction it) -> {
          it.setName(this.getCrossRefNodeAsString(node));
        };
        final XFunction function = ObjectExtensions.<XFunction>operator_doubleArrow(_createXFunction, _function_2);
        EList<XFunction> _functions = EcoreUtil2.<TmscXtextModel>getContainerOfType(context, TmscXtextModel.class).getFunctions();
        _functions.add(function);
        return Collections.<EObject>singletonList(function);
      }
    }
    return Collections.<EObject>emptyList();
  }
}
