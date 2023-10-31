/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.rendering.plot;

import nl.esi.pps.preferences.PPSPreferences;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.ScopedTMSC;
import nl.esi.pps.tmsc.presentation.TmscEditorPlugin;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class ScopesRenderingStrategy extends GroupingRenderingStrategy {
  public static final String ID = (TmscEditorPlugin.getPlugin().getSymbolicName() + ".scopes_rendering_strategy");
  
  @Override
  public boolean isSupported(final EditingDomain editingDomain) {
    return PPSPreferences.isAdvancedFeaturesEnabled();
  }
  
  @Override
  public boolean select(final Viewer viewer, final Object parentElement, final Object element) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (element instanceof Dependency) {
      boolean _isEmpty = IterableExtensions.isEmpty(this.getScopesGroup(((Dependency)element)));
      boolean _not = (!_isEmpty);
      if (_not) {
        _matched=true;
        _switchResult = true;
      }
    }
    if (!_matched) {
      _switchResult = super.select(viewer, parentElement, element);
    }
    return _switchResult;
  }
  
  @Override
  protected String getGroupKey(final Execution execution) {
    return null;
  }
  
  @Override
  protected String getGroupKey(final Dependency dependency) {
    return this.getGroupKey(this.getScopesGroup(dependency));
  }
  
  private Iterable<ScopedTMSC> getScopesGroup(final Dependency dependency) {
    final Function1<ScopedTMSC, Boolean> _function = (ScopedTMSC it) -> {
      return Boolean.valueOf(ScopesRenderingStrategy.isGroupKey(it));
    };
    return IterableExtensions.<ScopedTMSC>filter(dependency.getScopes(), _function);
  }
  
  private String getGroupKey(final Iterable<ScopedTMSC> scopesGroup) {
    String _xifexpression = null;
    boolean _isEmpty = IterableExtensions.isEmpty(scopesGroup);
    if (_isEmpty) {
      _xifexpression = null;
    } else {
      final Function1<ScopedTMSC, String> _function = (ScopedTMSC it) -> {
        return it.getFqn();
      };
      final Function1<ScopedTMSC, String> _function_1 = (ScopedTMSC it) -> {
        return it.getName();
      };
      _xifexpression = IterableExtensions.join(ListExtensions.<ScopedTMSC, String>map(IterableExtensions.<ScopedTMSC, String>sortBy(scopesGroup, _function), _function_1), ", ");
    }
    return _xifexpression;
  }
  
  /**
   * Default value for persisted {@code groupKey} property on ScopedTMSC
   */
  private static final boolean _DEFAULT_SCOPEDTMSC_GROUPKEY = true;
  
  public static boolean isGroupKey(final ScopedTMSC container) {
    final String key = "groupKey";
    final Object value = container.getProperties().get(key);
    if (value == null) {
        return _DEFAULT_SCOPEDTMSC_GROUPKEY;
    }
    return (boolean) value;
  }
  
  public static void setGroupKey(final ScopedTMSC container, final boolean value) {
    final String key = "groupKey";
    if (value == _DEFAULT_SCOPEDTMSC_GROUPKEY) {
    container.getProperties().remove(key);
    } else {
        container.getProperties().put(key, value);
    }
  }
}
