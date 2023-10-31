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

import java.util.Collections;
import java.util.Set;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.util.TmscQueries;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * {@link Execution} supports data analysis by providing this {@link IDataAnalysisItemContentProvider}.
 */
@SuppressWarnings("all")
public class ExecutionDataAnalysisItemContentProvider implements IDataAnalysisItemContentProvider {
  /**
   * Data analysis of all {@link Execution executions} with the same{@link Execution#getFunction() function}
   * by the same{@link Execution#getComponent() component.}
   */
  private static final String CONF_COMPONENT = "By same component";
  
  /**
   * Data analysis of all {@link Execution executions} with the same{@link Execution#getFunction() function}
   * on the same{@link Execution#getLifeline() executor.}
   */
  private static final String CONF_EXECUTOR = "On same executor";
  
  @Override
  public Set<String> getConfigurations(final Object object) {
    return CollectionLiterals.<String>newLinkedHashSet(ExecutionDataAnalysisItemContentProvider.CONF_EXECUTOR, ExecutionDataAnalysisItemContentProvider.CONF_COMPONENT);
  }
  
  @Override
  public String getTitle(final Object object, final String configuration) {
    final Execution execution = ((Execution) object);
    String _switchResult = null;
    if (configuration != null) {
      switch (configuration) {
        case ExecutionDataAnalysisItemContentProvider.CONF_COMPONENT:
          StringConcatenation _builder = new StringConcatenation();
          String _name = execution.getFunction().getName();
          _builder.append(_name);
          _builder.append(" by ");
          String _name_1 = execution.getComponent().getName();
          _builder.append(_name_1);
          _switchResult = _builder.toString();
          break;
        case ExecutionDataAnalysisItemContentProvider.CONF_EXECUTOR:
          StringConcatenation _builder_1 = new StringConcatenation();
          String _name_2 = execution.getFunction().getName();
          _builder_1.append(_name_2);
          _builder_1.append(" on ");
          String _name_3 = execution.getLifeline().getExecutor().getName();
          _builder_1.append(_name_3);
          _switchResult = _builder_1.toString();
          break;
        default:
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("Unsupported configuration: ");
          _builder_2.append(configuration);
          _switchResult = _builder_2.toString();
          break;
      }
    } else {
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("Unsupported configuration: ");
      _builder_2.append(configuration);
      _switchResult = _builder_2.toString();
    }
    return _switchResult;
  }
  
  @Override
  public Iterable<?> getSiblings(final Object object, final String configuration) {
    final Execution execution = ((Execution) object);
    Iterable<?> _switchResult = null;
    if (configuration != null) {
      switch (configuration) {
        case ExecutionDataAnalysisItemContentProvider.CONF_COMPONENT:
          _switchResult = TmscQueries.findAllWithFunctionAndComponent(execution);
          break;
        case ExecutionDataAnalysisItemContentProvider.CONF_EXECUTOR:
          _switchResult = TmscQueries.findAllWithFunctionAndLifeline(execution);
          break;
        default:
          _switchResult = Collections.<Object>emptyList();
          break;
      }
    } else {
      _switchResult = Collections.<Object>emptyList();
    }
    return _switchResult;
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
