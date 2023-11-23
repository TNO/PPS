/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.validation;

import java.util.List;
import java.util.function.Consumer;
import nl.esi.pps.common.emf.ecore.validation.EValidatorBase;
import nl.esi.pps.common.emf.ecore.validation.ValidationReporter;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.TMSC;
import nl.esi.pps.tmsc.TmscPlugin;
import nl.esi.pps.tmsc.text.EDurationFormat;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * An TMSC is urgent if and only if the timestamp of each event is as soon as possible,
 * considering the source timestamp and time-bound of the events' incoming dependencies.
 */
@SuppressWarnings("all")
public class UrgentTmscValidator extends EValidatorBase {
  public UrgentTmscValidator() {
    super(TmscPlugin.PLUGIN_ID);
  }
  
  @Override
  public void validate(final EClass eClass, final EObject eObject, final ValidationReporter reporter) {
    if ((eObject instanceof TMSC)) {
      this.validateTMSC(((TMSC)eObject), reporter);
    }
  }
  
  private void validateTMSC(final TMSC tmsc, final ValidationReporter reporter) {
    final Consumer<Event> _function = (Event it) -> {
      this.validateEvent(it, tmsc, reporter);
    };
    tmsc.getEvents().forEach(_function);
  }
  
  private void validateEvent(final Event event, @Extension final TMSC tmsc, @Extension final ValidationReporter reporter) {
    Long _timestamp = event.getTimestamp();
    boolean _tripleEquals = (_timestamp == null);
    if (_tripleEquals) {
      reporter.error("Event timestamp should be set to validate TMSC urgency", event);
      return;
    }
    final List<Dependency> incomingDependencies = IterableExtensions.<Dependency>toList(tmsc.getIncomingDependencies(event));
    boolean _isEmpty = incomingDependencies.isEmpty();
    if (_isEmpty) {
      return;
    } else {
      final Function1<Dependency, Boolean> _function = (Dependency it) -> {
        Event _source = it.getSource();
        Long _timestamp_1 = null;
        if (_source!=null) {
          _timestamp_1=_source.getTimestamp();
        }
        return Boolean.valueOf((_timestamp_1 == null));
      };
      boolean _exists = IterableExtensions.<Dependency>exists(incomingDependencies, _function);
      if (_exists) {
        return;
      }
    }
    final Function1<Dependency, Long> _function_1 = (Dependency it) -> {
      Long _timestamp_1 = it.getSource().getTimestamp();
      Long _timeBound = it.getTimeBound();
      return Long.valueOf(((_timestamp_1).longValue() + (_timeBound).longValue()));
    };
    final Long urgentTime = IterableExtensions.<Long>max(ListExtensions.<Dependency, Long>map(incomingDependencies, _function_1));
    Long _timestamp_1 = event.getTimestamp();
    boolean _lessThan = (urgentTime.compareTo(_timestamp_1) < 0);
    if (_lessThan) {
      Long _timestamp_2 = event.getTimestamp();
      long _minus = ((_timestamp_2).longValue() - (urgentTime).longValue());
      final String delay = EDurationFormat.eINSTANCE.format(_minus);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Event is not urgent as its timestamp is ");
      _builder.append(delay);
      _builder.append(" later than its urgent time");
      reporter.error(_builder, event);
    }
  }
}
