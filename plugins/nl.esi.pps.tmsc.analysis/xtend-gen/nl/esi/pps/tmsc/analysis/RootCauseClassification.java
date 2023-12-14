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

import com.google.common.base.Objects;
import java.util.List;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.LifelineSegment;
import nl.esi.pps.tmsc.ScopedTMSC;
import nl.esi.pps.tmsc.compare.ArchitectureLifecycleStage;
import nl.esi.pps.tmsc.metric.MetricInstance;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class RootCauseClassification {
  private final ArchitectureLifecycleStage stage;
  
  public RootCauseClassification() {
    this(ArchitectureLifecycleStage.IMPLEMENTED);
  }
  
  public RootCauseClassification(final ArchitectureLifecycleStage stage) {
    this.stage = stage;
  }
  
  public List<String> describeRootCauses(final MetricInstance metricInstance) {
    final Function1<ScopedTMSC, Iterable<Dependency>> _function = (ScopedTMSC it) -> {
      return RootCauseAnalysis.getRootCauses(it);
    };
    final Function1<Dependency, String> _function_1 = (Dependency it) -> {
      return this.describeRootCause(it);
    };
    return IterableExtensions.<String>toList(IterableExtensions.<Dependency, String>map(IterableExtensions.<ScopedTMSC, Dependency>flatMap(metricInstance.getScopes(), _function), _function_1));
  }
  
  public String describeRootCause(final Dependency dependency) {
    if ((Objects.equal(dependency.getSource().getLifeline(), dependency.getTarget().getLifeline()) || ActivityAnalysis.isEpoch(dependency))) {
      boolean _isResourceSharing = ActivityAnalysis.isResourceSharing(dependency);
      boolean _equals = (_isResourceSharing == true);
      if (_equals) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Detected service contention on ");
        String _resource = this.getResource(dependency.getTarget());
        _builder.append(_resource);
        _builder.append(".");
        return _builder.toString();
      } else {
        if ((((dependency.getScheduled()).booleanValue() == false) && (dependency instanceof LifelineSegment))) {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("Detected resource contention on ");
          String _resource_1 = this.getResource(dependency.getTarget());
          _builder_1.append(_resource_1);
          _builder_1.append(" in ");
          String _task = this.getTask(((LifelineSegment) dependency));
          _builder_1.append(_task);
          _builder_1.append(".");
          return _builder_1.toString();
        } else {
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("Detected resource contention on ");
          String _resource_2 = this.getResource(dependency.getTarget());
          _builder_2.append(_resource_2);
          _builder_2.append(".");
          return _builder_2.toString();
        }
      }
    } else {
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("Detected delay in communication between ");
      String _resource_3 = this.getResource(dependency.getSource());
      _builder_3.append(_resource_3);
      _builder_3.append(" and ");
      String _resource_4 = this.getResource(dependency.getTarget());
      _builder_3.append(_resource_4);
      _builder_3.append(".");
      return _builder_3.toString();
    }
  }
  
  private String getResource(final Event event) {
    return this.stage.describeResource(event, false);
  }
  
  private String getTask(final LifelineSegment lifelineSegment) {
    final Execution activeExecution = lifelineSegment.getActiveExecution();
    if ((activeExecution == null)) {
      return null;
    }
    return this.stage.describeTask(activeExecution.getExit(), false);
  }
}
