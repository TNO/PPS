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
import java.util.Set;
import java.util.function.Predicate;
import nl.esi.pps.architecture.implemented.Function;
import nl.esi.pps.architecture.implemented.IPCFunction;
import nl.esi.pps.common.core.runtime.StatusLogger;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.ScopedTMSC;
import nl.esi.pps.tmsc.TMSC;
import nl.esi.pps.tmsc.util.TmscProjection;
import nl.esi.pps.tmsc.util.TmscQueries;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Finds all {@link Dependency dependencies} between {@link Event events} with
 * an {@link IPCFunction} and puts them in a {@link ScopedTMSC}.
 */
@SuppressWarnings("all")
public final class CreateIPCScope {
  @Extension
  private final StatusLogger logger = new StatusLogger("nl.esi.pps.tmsc.analysis", "Create IPC Scope");
  
  public MultiStatus getStatus() {
    return this.logger.getStatus();
  }
  
  public ScopedTMSC createIPCScope(final TMSC tmsc, final IProgressMonitor monitor) {
    final Function1<Dependency, Boolean> _function = (Dependency it) -> {
      return Boolean.valueOf(CreateIPCScope.isIPCScope(it));
    };
    final Iterable<Dependency> ipcDependencies = IterableExtensions.<Dependency>filter(tmsc.getDependencies(), _function);
    final Function1<Dependency, List<Event>> _function_1 = (Dependency it) -> {
      return TmscQueries.getEvents(it);
    };
    final Set<Event> ipcEvents = IterableExtensions.<Event>toSet(IterableExtensions.<Dependency, Event>flatMap(ipcDependencies, _function_1));
    final ScopedTMSC ipcScope = TmscQueries.createScopedTMSC(ipcDependencies, "IPC");
    final Function1<Dependency, Boolean> _function_2 = (Dependency it) -> {
      return Boolean.valueOf(CreateIPCScope.isIPCScope(it));
    };
    final Iterable<Dependency> nonIPCDependencies = IterableExtensions.<Dependency>reject(tmsc.getDependencies(), _function_2);
    Iterable<Dependency> _xifexpression = null;
    int _size = tmsc.getDependencies().size();
    boolean _greaterThan = (_size > 100_000);
    if (_greaterThan) {
      Iterable<Dependency> _xblockexpression = null;
      {
        this.logger.warn("The input is too large to perform a full projection, skipping scheduled dependencies.");
        this.logger.info("The output should only be used for structural comparison.");
        final Function1<Dependency, Boolean> _function_3 = (Dependency it) -> {
          Boolean _scheduled = it.getScheduled();
          return Boolean.valueOf(Objects.equal(_scheduled, Boolean.TRUE));
        };
        _xblockexpression = IterableExtensions.<Dependency>reject(nonIPCDependencies, _function_3);
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = nonIPCDependencies;
    }
    final Iterable<Dependency> dependenciesToProject = _xifexpression;
    final TmscProjection tmscProjection = new TmscProjection(ipcScope);
    final Predicate<Event> _function_3 = (Event e) -> {
      return ipcEvents.contains(e);
    };
    tmscProjection.projectToScope(dependenciesToProject, monitor, _function_3);
    return ipcScope;
  }
  
  private static boolean isIPCScope(final Dependency dependency) {
    boolean _xifexpression = false;
    boolean _isTraced = dependency.getSource().isTraced();
    boolean _not = (!_isTraced);
    if (_not) {
      Function _function = dependency.getTarget().getFunction();
      _xifexpression = (_function instanceof IPCFunction);
    } else {
      boolean _xifexpression_1 = false;
      Function _function_1 = dependency.getSource().getFunction();
      if ((_function_1 instanceof IPCFunction)) {
        _xifexpression_1 = ((!dependency.getTarget().isTraced()) || (dependency.getTarget().getFunction() instanceof IPCFunction));
      } else {
        _xifexpression_1 = false;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
}
