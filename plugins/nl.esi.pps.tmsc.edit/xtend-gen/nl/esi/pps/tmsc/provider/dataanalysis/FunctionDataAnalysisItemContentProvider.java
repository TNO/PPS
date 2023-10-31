/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.provider.dataanalysis;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.Collections;
import java.util.Set;
import nl.esi.pps.architecture.implemented.Function;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.Lifeline;
import nl.esi.pps.tmsc.util.TmscQueries;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * {@link Function} supports data analysis by providing this {@link IDataAnalysisItemContentProvider}.
 */
@SuppressWarnings("all")
public class FunctionDataAnalysisItemContentProvider implements IDataAnalysisItemContentProvider {
  @Override
  public Set<String> getConfigurations(final Object object) {
    return Collections.<String>singleton(IDataAnalysisItemContentProvider.DEFAULT_CONFIGURATION);
  }
  
  @Override
  public String getTitle(final Object object, final String configuration) {
    final Function function = ((Function) object);
    return function.getName();
  }
  
  @Override
  public Iterable<?> getSiblings(final Object object, final String configuration) {
    final Function function = ((Function) object);
    Resource _eResource = function.eResource();
    ResourceSet _resourceSet = null;
    if (_eResource!=null) {
      _resourceSet=_eResource.getResourceSet();
    }
    final ResourceSet resourceSet = _resourceSet;
    if ((resourceSet == null)) {
      return Collections.<Object>emptyList();
    }
    final Function1<Resource, EList<EObject>> _function = (Resource it) -> {
      return it.getContents();
    };
    final Function1<FullScopeTMSC, EList<Lifeline>> _function_1 = (FullScopeTMSC it) -> {
      return it.getLifelines();
    };
    final Function1<Lifeline, EList<Execution>> _function_2 = (Lifeline it) -> {
      return it.getExecutions();
    };
    final Function1<Execution, Boolean> _function_3 = (Execution it) -> {
      Function _function_4 = it.getFunction();
      return Boolean.valueOf(Objects.equal(_function_4, function));
    };
    return IterableExtensions.<Execution>filter(IterableExtensions.<Lifeline, Execution>flatMap(IterableExtensions.<FullScopeTMSC, Lifeline>flatMap(Iterables.<FullScopeTMSC>filter(IterableExtensions.<Resource, EObject>flatMap(resourceSet.getResources(), _function), FullScopeTMSC.class), _function_1), _function_2), _function_3);
  }
  
  @Override
  public Long getDuration(final Object object, final Object sibling, final String configuration) {
    final Execution execution = ((Execution) sibling);
    Long _xifexpression = null;
    boolean _isFullyTraced = TmscQueries.isFullyTraced(execution);
    if (_isFullyTraced) {
      _xifexpression = execution.getDuration();
    }
    return _xifexpression;
  }
}
