/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.provider.dataanalysis;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.EventType;
import nl.esi.pps.tmsc.Interval;
import nl.esi.pps.tmsc.Measurement;
import nl.esi.pps.tmsc.TmscFactory;
import nl.esi.pps.tmsc.text.EDurationFormat;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * {@link Interval} supports data analysis by providing this {@link IDataAnalysisItemContentProvider}.
 */
@SuppressWarnings("all")
public class IntervalDataAnalysisItemContentProvider implements IDataAnalysisItemContentProvider {
  @Override
  public Set<String> getConfigurations(final Object object) {
    return Collections.<String>singleton(IDataAnalysisItemContentProvider.DEFAULT_CONFIGURATION);
  }
  
  @Override
  public String getTitle(final Object object, final String configuration) {
    final Interval interval = ((Interval) object);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("From ");
    String _lowerCase = EventType.getType(interval.getFrom()).name().toLowerCase();
    _builder.append(_lowerCase);
    _builder.append(" of ");
    String _name = interval.getFrom().getFunction().getName();
    _builder.append(_name);
    _builder.append(" on ");
    String _name_1 = interval.getFrom().getLifeline().getExecutor().getName();
    _builder.append(_name_1);
    _builder.append(" to ");
    String _lowerCase_1 = EventType.getType(interval.getTo()).name().toLowerCase();
    _builder.append(_lowerCase_1);
    _builder.append(" of ");
    String _name_2 = interval.getTo().getFunction().getName();
    _builder.append(_name_2);
    _builder.append(" on ");
    String _name_3 = interval.getTo().getLifeline().getExecutor().getName();
    _builder.append(_name_3);
    return _builder.toString();
  }
  
  @Override
  public Iterable<?> getSiblings(final Object object, final String configuration) {
    final Interval interval = ((Interval) object);
    final List<Event> fromSiblings = IterableExtensions.<Event>toList(this.getSiblings(interval.getFrom(), configuration));
    final List<Event> toSiblings = IterableExtensions.<Event>toList(this.getSiblings(interval.getTo(), configuration));
    final int fromIndex = fromSiblings.indexOf(interval.getFrom());
    final int toIndex = toSiblings.indexOf(interval.getTo());
    final int fromOffset = Math.max((fromIndex - toIndex), 0);
    final int toOffset = Math.max((toIndex - fromIndex), 0);
    int _size = fromSiblings.size();
    int _minus = (_size - fromOffset);
    int _size_1 = toSiblings.size();
    int _minus_1 = (_size_1 - toOffset);
    final int pairsSize = Math.min(_minus, _minus_1);
    final ArrayList<Interval> pairs = new ArrayList<Interval>(pairsSize);
    for (int i = 0; (i < pairsSize); i++) {
      {
        final int f = (i + fromOffset);
        final int t = (i + toOffset);
        if (((f == fromIndex) && (t == toIndex))) {
          pairs.add(interval);
        } else {
          Measurement _createMeasurement = TmscFactory.eINSTANCE.createMeasurement();
          final Procedure1<Measurement> _function = (Measurement it) -> {
            it.setFrom(fromSiblings.get(f));
            it.setTo(toSiblings.get(t));
            it.setName(EDurationFormat.eINSTANCE.format(it.getDuration()));
          };
          Measurement _doubleArrow = ObjectExtensions.<Measurement>operator_doubleArrow(_createMeasurement, _function);
          pairs.add(_doubleArrow);
        }
      }
    }
    return pairs;
  }
  
  private Iterable<Event> getSiblings(final Event event, final String configuration) {
    final Function1<Event, Boolean> _function = (Event it) -> {
      return Boolean.valueOf(((Objects.equal(it.eClass(), event.eClass()) && Objects.equal(it.getFunction(), event.getFunction())) && Objects.equal(it.getComponent(), event.getComponent())));
    };
    return IterableExtensions.<Event>filter(event.getLifeline().getEvents(), _function);
  }
  
  @Override
  public Long getDuration(final Object object, final Object sibling, final String configuration) {
    final Interval interval = ((Interval) sibling);
    return interval.getDuration();
  }
}
