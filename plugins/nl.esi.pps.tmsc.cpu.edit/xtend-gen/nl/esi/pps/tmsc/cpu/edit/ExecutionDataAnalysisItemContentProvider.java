/**
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.cpu.edit;

import java.util.Collections;
import java.util.Set;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.cpu.TmscCpuInfoQueries;
import nl.esi.pps.tmsc.provider.dataanalysis.IDataAnalysisItemContentProvider;
import nl.esi.pps.tmsc.util.TmscQueries;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class ExecutionDataAnalysisItemContentProvider implements IDataAnalysisItemContentProvider {
  /**
   * Data analysis of On-CPU for all {@link Execution executions} with the same
   * {@link Execution#getFunction() function} on the same{@link Execution#getLifeline() executor.}
   */
  private static final String CONF_ON_CPU = "On-CPU (On same executor)";

  /**
   * Data analysis of Wait-for-CPU for all {@link Execution executions} with the same
   * {@link Execution#getFunction() function} on the same{@link Execution#getLifeline() executor.}
   */
  private static final String CONF_WAIT_CPU = "Wait-for-CPU (On same executor)";

  @Override
  public Set<String> getConfigurations(final Object object) {
    final Execution execution = ((Execution) object);
    Set<String> _xifexpression = null;
    boolean _hasCpuInfo = TmscCpuInfoQueries.hasCpuInfo(execution);
    if (_hasCpuInfo) {
      _xifexpression = CollectionLiterals.<String>newLinkedHashSet(ExecutionDataAnalysisItemContentProvider.CONF_ON_CPU, ExecutionDataAnalysisItemContentProvider.CONF_WAIT_CPU);
    } else {
      _xifexpression = Collections.<String>emptySet();
    }
    return _xifexpression;
  }

  @Override
  public String getTitle(final Object object, final String configuration) {
    final Execution execution = ((Execution) object);
    String _switchResult = null;
    if (configuration != null) {
      switch (configuration) {
        case ExecutionDataAnalysisItemContentProvider.CONF_ON_CPU:
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("On-CPU for ");
          String _name = execution.getFunction().getName();
          _builder.append(_name);
          _builder.append(" on ");
          String _name_1 = execution.getLifeline().getExecutor().getName();
          _builder.append(_name_1);
          _switchResult = _builder.toString();
          break;
        case ExecutionDataAnalysisItemContentProvider.CONF_WAIT_CPU:
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("Wait-for-CPU for ");
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
    return TmscQueries.findAllWithFunctionAndLifeline(execution);
  }

  @Override
  public Long getDuration(final Object object, final Object sibling, final String configuration) {
    final Execution execution = ((Execution) sibling);
    long _switchResult = (long) 0;
    if (configuration != null) {
      switch (configuration) {
        case ExecutionDataAnalysisItemContentProvider.CONF_ON_CPU:
          _switchResult = TmscCpuInfoQueries.getOnCpuNanos(execution, true);
          break;
        case ExecutionDataAnalysisItemContentProvider.CONF_WAIT_CPU:
          _switchResult = TmscCpuInfoQueries.getWaitCpuNanos(execution, true);
          break;
        default:
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Unsupported configuration: ");
          _builder.append(configuration);
          throw new IllegalArgumentException(_builder.toString());
      }
    } else {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Unsupported configuration: ");
      _builder.append(configuration);
      throw new IllegalArgumentException(_builder.toString());
    }
    return Long.valueOf(_switchResult);
  }
}
