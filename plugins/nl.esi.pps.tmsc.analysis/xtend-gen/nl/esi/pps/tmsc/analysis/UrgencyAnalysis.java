/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.analysis;

import java.util.function.Consumer;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.TMSC;
import nl.esi.pps.tmsc.sort.TmscTopologicalOrder;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

/**
 * An ASAP scheduling algorithm of a timed graph (i.e. {@link Dependency#getTimeBound()}) on a set of resources
 * (i.e. {@link Event#getLifeline()}).
 */
@SuppressWarnings("all")
public final class UrgencyAnalysis {
  private UrgencyAnalysis() {
  }
  
  public static void analyseUrgency(final TMSC tmsc) {
    final Function1<Dependency, Long> _function = (Dependency it) -> {
      return it.getTimeBound();
    };
    UrgencyAnalysis.analyseUrgency(tmsc, _function);
  }
  
  public static void analyseUrgency(final TMSC tmsc, final Function1<? super Dependency, ? extends Long> timeBoundFunctor) {
    final Consumer<Event> _function = (Event it) -> {
      UrgencyAnalysis.unsetUrgentTimestamp(it, tmsc);
    };
    tmsc.getEvents().forEach(_function);
    TmscTopologicalOrder<Dependency> _dependenciesInTopologicalOrder = TmscTopologicalOrder.getDependenciesInTopologicalOrder(tmsc);
    for (final Dependency dependency : _dependenciesInTopologicalOrder) {
      {
        Long sourceUrgentTime = UrgencyAnalysis.getUrgentTimestamp(dependency.getSource(), tmsc);
        if ((sourceUrgentTime == null)) {
          sourceUrgentTime = dependency.getSource().getTimestamp();
          UrgencyAnalysis.setUrgentTimestamp(dependency.getSource(), sourceUrgentTime, tmsc);
        }
        Long _elvis = null;
        Long _apply = timeBoundFunctor.apply(dependency);
        if (_apply != null) {
          _elvis = _apply;
        } else {
          _elvis = Long.valueOf(0L);
        }
        final long targetUrgentTime = ((sourceUrgentTime).longValue() + (_elvis).longValue());
        boolean _isSetUrgentTimestamp = UrgencyAnalysis.isSetUrgentTimestamp(dependency.getTarget(), tmsc);
        if (_isSetUrgentTimestamp) {
          Long _urgentTimestamp = UrgencyAnalysis.getUrgentTimestamp(dependency.getTarget(), tmsc);
          boolean _lessThan = ((_urgentTimestamp).longValue() < targetUrgentTime);
          if (_lessThan) {
            UrgencyAnalysis.setUrgentTimestamp(dependency.getTarget(), Long.valueOf(targetUrgentTime), tmsc);
          }
        } else {
          UrgencyAnalysis.setUrgentTimestamp(dependency.getTarget(), Long.valueOf(targetUrgentTime), tmsc);
        }
      }
    }
  }
  
  /**
   * The asap time-stamp of a {@code container} {@link Event} under the constraint of urgency,
   * i.e. considering the {@link Dependency#getTimeBound() time-bounds} of all incoming dependencies
   * within the {@link context} {@link TMSC}.
   */
  public static Long getUrgentTimestamp(final Event container, final TMSC context) {
    final String category = new nl.esi.pps.tmsc.properties.TmscCategoryProvider().getCategory(context);
    final String key = org.eclipse.xtext.xbase.lib.StringExtensions.isNullOrEmpty(category) ? 
            "urgentTimestamp" : category + "/urgentTimestamp";
    final Object value = container.getProperties().get(key);
    return (Long) value;
  }
  
  /**
   * The asap time-stamp of a {@code container} {@link Event} under the constraint of urgency,
   * i.e. considering the {@link Dependency#getTimeBound() time-bounds} of all incoming dependencies
   * within the {@link context} {@link TMSC}.
   */
  public static void setUrgentTimestamp(final Event container, final Long value, final TMSC context) {
    final String category = new nl.esi.pps.tmsc.properties.TmscCategoryProvider().getCategory(context);
    final String key = org.eclipse.xtext.xbase.lib.StringExtensions.isNullOrEmpty(category) ? 
            "urgentTimestamp" : category + "/urgentTimestamp";
    container.getProperties().put(key, value);
  }
  
  /**
   * Returns whether the value of the '{@link nl.esi.pps.tmsc.analysis.UrgencyAnalysis#getUrgentTimestamp <em>urgentTimestamp</em>}' property is set on {@code container}.
   */
  public static boolean isSetUrgentTimestamp(final Event container, final TMSC context) {
    final String category = new nl.esi.pps.tmsc.properties.TmscCategoryProvider().getCategory(context);
    final String key = org.eclipse.xtext.xbase.lib.StringExtensions.isNullOrEmpty(category) ? 
            "urgentTimestamp" : category + "/urgentTimestamp";
    return container.getProperties().containsKey(key);
  }
  
  /**
   * Unsets the value of the '{@link nl.esi.pps.tmsc.analysis.UrgencyAnalysis#getUrgentTimestamp <em>urgentTimestamp</em>}' property on {@code container}.
   */
  public static void unsetUrgentTimestamp(final Event container, final TMSC context) {
    final String category = new nl.esi.pps.tmsc.properties.TmscCategoryProvider().getCategory(context);
    final String key = org.eclipse.xtext.xbase.lib.StringExtensions.isNullOrEmpty(category) ? 
            "urgentTimestamp" : category + "/urgentTimestamp";
    container.getProperties().remove(key);
  }
}
