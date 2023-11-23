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

import com.google.common.base.Objects;
import java.util.function.Consumer;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.Lifeline;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public final class NormalizeTiming {
  private NormalizeTiming() {
  }
  
  /**
   * Normalizes the timing of a {@code tmsc} by:
   * <ol>
   * <li>Resetting all event time-stamps</li>
   * <li>Normalizing all dependency time-bounds (i.e. 15µs for intra-lifeline and 50µs inter-lifeline
   * {@link Dependency dependencies}</li>
   * <li>Applying {@link UrgencyAnalysis}</li>
   * <li>Copying the analysis result (i.e.
   * {@link UrgencyAnalysis#getUrgentTimestamp(Event, nl.esi.pps.tmsc.TMSC)
   * Event#urgentTimestamp}) into the event time-stamps</li>
   * </ol>
   */
  public static void normalizeTiming(final FullScopeTMSC tmsc) {
    final Consumer<Event> _function = (Event it) -> {
      it.setTimestamp(Long.valueOf(0L));
    };
    tmsc.getEvents().forEach(_function);
    final Consumer<Dependency> _function_1 = (Dependency it) -> {
      long _xifexpression = (long) 0;
      Lifeline _lifeline = it.getSource().getLifeline();
      Lifeline _lifeline_1 = it.getTarget().getLifeline();
      boolean _equals = Objects.equal(_lifeline, _lifeline_1);
      if (_equals) {
        _xifexpression = 15_000L;
      } else {
        _xifexpression = 50_000L;
      }
      final long normalizedTimeBound = _xifexpression;
      it.setTimeBound(Long.valueOf(normalizedTimeBound));
    };
    tmsc.getDependencies().forEach(_function_1);
    UrgencyAnalysis.analyseUrgency(tmsc);
    final Consumer<Event> _function_2 = (Event it) -> {
      it.setTimestamp(UrgencyAnalysis.getUrgentTimestamp(it, tmsc));
      UrgencyAnalysis.unsetUrgentTimestamp(it, tmsc);
    };
    tmsc.getEvents().forEach(_function_2);
    tmsc.setEpochTime(false);
    tmsc.setStartTime(Long.valueOf(0L));
    final Function1<Event, Long> _function_3 = (Event it) -> {
      return it.getTimestamp();
    };
    tmsc.setEndTime(IterableExtensions.<Long>max(IterableExtensions.<Event, Long>map(tmsc.getEvents(), _function_3)));
  }
}
