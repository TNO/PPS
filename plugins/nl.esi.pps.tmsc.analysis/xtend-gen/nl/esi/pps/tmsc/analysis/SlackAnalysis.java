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
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.TMSC;
import nl.esi.pps.tmsc.sort.TmscTopologicalOrder;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public final class SlackAnalysis {
  private SlackAnalysis() {
  }
  
  /**
   * For each {@link TMSC#getEvents() event} in {@code tmsc}, calculates the
   * {@link #getSlack(Event, TMSC) slack} that can be added to the
   * {@link Event#getTimestamp() time-stamp} of the event, without impacting the
   * {@link Event#getTimestamp() time-stamps} of all sink events in the {@code tmsc}.
   * 
   * @param tmsc the {@code tmsc} for which the slack should be calculated.
   */
  public static void analyseSlack(final TMSC tmsc) {
    final Consumer<Event> _function = (Event it) -> {
      SlackAnalysis.unsetSlack(it, tmsc);
    };
    tmsc.getEvents().forEach(_function);
    final Function1<Dependency, Boolean> _function_1 = (Dependency it) -> {
      Long _timeBound = it.getTimeBound();
      return Boolean.valueOf((_timeBound == null));
    };
    Iterable<Dependency> _reject = IterableExtensions.<Dependency>reject(TmscTopologicalOrder.getDependenciesInReverseTopologicalOrder(tmsc), _function_1);
    for (final Dependency dependency : _reject) {
      {
        Long _duration = dependency.getDuration();
        Long _timeBound = dependency.getTimeBound();
        long _minus = ((_duration).longValue() - (_timeBound).longValue());
        long dependencyWaitTime = Math.max(_minus, 0);
        long _slack = SlackAnalysis.getSlack(dependency.getTarget(), tmsc);
        final long calculatedSlack = (dependencyWaitTime + _slack);
        if (((!SlackAnalysis.isSetSlack(dependency.getSource(), tmsc)) || (SlackAnalysis.getSlack(dependency.getSource(), tmsc) > calculatedSlack))) {
          SlackAnalysis.setSlack(dependency.getSource(), calculatedSlack, tmsc);
        }
      }
    }
  }
  
  /**
   * Default value for persisted {@code slack} property on Event
   */
  private static final long _DEFAULT_EVENT_SLACK = 0;
  
  /**
   * The {@link #getSlack(Event, TMSC) slack} that can be added to the
   * {@link Event#getTimestamp() time-stamp} of the event, without impacting the
   * {@link Event#getTimestamp() time-stamps} of all sink events in the
   * {@code context} tmsc.
   * 
   * @param context the {@code tmsc} context for which the slack is applicable.
   */
  public static long getSlack(final Event container, final TMSC context) {
    final String category = new nl.esi.pps.tmsc.properties.TmscCategoryProvider().getCategory(context);
    final String key = org.eclipse.xtext.xbase.lib.StringExtensions.isNullOrEmpty(category) ? 
            "slack" : category + "/slack";
    final Object value = container.getProperties().get(key);
    if (value == null) {
        return _DEFAULT_EVENT_SLACK;
    }
    return (long) value;
  }
  
  /**
   * The {@link #getSlack(Event, TMSC) slack} that can be added to the
   * {@link Event#getTimestamp() time-stamp} of the event, without impacting the
   * {@link Event#getTimestamp() time-stamps} of all sink events in the
   * {@code context} tmsc.
   * 
   * @param context the {@code tmsc} context for which the slack is applicable.
   */
  public static void setSlack(final Event container, final long value, final TMSC context) {
    final String category = new nl.esi.pps.tmsc.properties.TmscCategoryProvider().getCategory(context);
    final String key = org.eclipse.xtext.xbase.lib.StringExtensions.isNullOrEmpty(category) ? 
            "slack" : category + "/slack";
    container.getProperties().put(key, value);
  }
  
  /**
   * Returns whether the value of the '{@link nl.esi.pps.tmsc.analysis.SlackAnalysis#getSlack <em>slack</em>}' property is set on {@code container}.
   */
  public static boolean isSetSlack(final Event container, final TMSC context) {
    final String category = new nl.esi.pps.tmsc.properties.TmscCategoryProvider().getCategory(context);
    final String key = org.eclipse.xtext.xbase.lib.StringExtensions.isNullOrEmpty(category) ? 
            "slack" : category + "/slack";
    return container.getProperties().containsKey(key);
  }
  
  /**
   * Unsets the value of the '{@link nl.esi.pps.tmsc.analysis.SlackAnalysis#getSlack <em>slack</em>}' property on {@code container}.
   */
  public static void unsetSlack(final Event container, final TMSC context) {
    final String category = new nl.esi.pps.tmsc.properties.TmscCategoryProvider().getCategory(context);
    final String key = org.eclipse.xtext.xbase.lib.StringExtensions.isNullOrEmpty(category) ? 
            "slack" : category + "/slack";
    container.getProperties().remove(key);
  }
}
