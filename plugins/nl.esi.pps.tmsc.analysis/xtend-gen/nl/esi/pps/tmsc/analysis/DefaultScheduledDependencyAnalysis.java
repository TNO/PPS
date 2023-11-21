/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.analysis;

import java.util.function.Consumer;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.LifelineSegment;
import nl.esi.pps.tmsc.util.TmscQueries;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Applies scheduled dependency analysis, by setting the
 * {@link Dependency#setScheduled(Boolean) scheduled} attribute on dependencies
 * in <code>tmsc</code>.<br>
 * If <code>refresh</code> is <code>true</code>, the scheduled attribute will be
 * calculated for all dependencies, if <code>false</code>, scheduled will only
 * be calculated if not set yet. <br>
 * In this default implementation, {@link LifelineSegment}s without an
 * {@link LifelineSegment#getActiveExecution() active execution} are considered
 * a scheduled dependency. <br>
 * This method requires that the model contains
 * {@link #refineWithCallStacks(FullScopeTMSC) call stacks}.<br>
 * TODO: Should the scheduled attribute be a scoped attribute? If so, it should
 * be modeled as property
 */
@SuppressWarnings("all")
public class DefaultScheduledDependencyAnalysis {
  public void analyzeScheduledDependencies(final FullScopeTMSC tmsc) {
    this.analyzeScheduledDependencies(tmsc, false);
  }
  
  public void analyzeScheduledDependencies(final FullScopeTMSC tmsc, final boolean refresh) {
    final Function1<Dependency, Boolean> _function = (Dependency it) -> {
      return Boolean.valueOf(this.shouldBeAnalyzed(it));
    };
    Iterable<Dependency> dependencies = IterableExtensions.<Dependency>filter(tmsc.getDependencies(), _function);
    if ((!refresh)) {
      final Function1<Dependency, Boolean> _function_1 = (Dependency it) -> {
        Boolean _scheduled = it.getScheduled();
        return Boolean.valueOf((_scheduled == null));
      };
      dependencies = IterableExtensions.<Dependency>filter(dependencies, _function_1);
    }
    final Consumer<Dependency> _function_2 = (Dependency it) -> {
      it.setScheduled(Boolean.valueOf(this.analyseScheduled(it)));
    };
    dependencies.forEach(_function_2);
  }
  
  /**
   * Partial traced life-line segments (i.e. start and end of trace effect) should not be analyzed as we don't know.
   */
  protected boolean shouldBeAnalyzed(final Dependency dependency) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (dependency instanceof LifelineSegment) {
      _matched=true;
      _switchResult = TmscQueries.isFullyTraced(dependency);
    }
    if (!_matched) {
      _switchResult = true;
    }
    return _switchResult;
  }
  
  protected boolean analyseScheduled(final Dependency dependency) {
    boolean _xifexpression = false;
    if ((dependency instanceof LifelineSegment)) {
      Execution _activeExecution = ((LifelineSegment)dependency).getActiveExecution();
      _xifexpression = (_activeExecution == null);
    } else {
      _xifexpression = false;
    }
    return _xifexpression;
  }
}
