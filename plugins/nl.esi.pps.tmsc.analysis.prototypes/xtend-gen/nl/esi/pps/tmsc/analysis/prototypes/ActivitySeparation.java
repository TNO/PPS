/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.analysis.prototypes;

import com.google.common.collect.Iterables;
import java.util.List;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.ScopedTMSC;
import nl.esi.pps.tmsc.TmscFactory;
import nl.esi.pps.tmsc.analysis.ActivityAnalysis;
import nl.esi.pps.tmsc.util.TmscQueries;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

@SuppressWarnings("all")
public class ActivitySeparation {
  @Extension
  private static final TmscFactory m_tmsc = TmscFactory.eINSTANCE;
  
  public static void separateActivities(final FullScopeTMSC tmsc) {
    final Function1<Dependency, Boolean> _function = (Dependency it) -> {
      return Boolean.valueOf(ActivityAnalysis.isActivity(it));
    };
    final Iterable<Dependency> activityDependencies = IterableExtensions.<Dependency>filter(tmsc.getDependencies(), _function);
    final Function1<List<Dependency>, Integer> _function_1 = (List<Dependency> it) -> {
      return Integer.valueOf(it.size());
    };
    final Iterable<List<Dependency>> disjunctTMSCs = IterableExtensions.<List<Dependency>>take(ListExtensions.<List<Dependency>>reverseView(ListExtensions.<List<Dependency>, Integer>sortInplaceBy(TmscQueries.findDisjunctTMSCs(activityDependencies), _function_1)), 20);
    final Procedure2<List<Dependency>, Integer> _function_2 = (List<Dependency> scopedTMSCDependencies, Integer index) -> {
      EList<ScopedTMSC> _childScopes = tmsc.getChildScopes();
      ScopedTMSC _createScopedTMSC = ActivitySeparation.m_tmsc.createScopedTMSC();
      final Procedure1<ScopedTMSC> _function_3 = (ScopedTMSC it) -> {
        EList<Dependency> _dependencies = it.getDependencies();
        Iterables.<Dependency>addAll(_dependencies, scopedTMSCDependencies);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(index);
        _builder.append(": ");
        int _size = it.getDependencies().size();
        _builder.append(_size);
        _builder.append(" dependencies");
        it.setName(_builder.toString());
      };
      ScopedTMSC _doubleArrow = ObjectExtensions.<ScopedTMSC>operator_doubleArrow(_createScopedTMSC, _function_3);
      _childScopes.add(_doubleArrow);
    };
    IterableExtensions.<List<Dependency>>forEach(disjunctTMSCs, _function_2);
  }
}
