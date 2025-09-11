/**
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.sort;

import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.function.BiFunction;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.ITMSC;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
class EventTopologicalOrder implements TopologicalOrderIterator<Event> {
  @Extension
  private final ITMSC tmsc;

  private final Queue<Event> enabledElements = CollectionLiterals.<Event>newLinkedList();

  private final Map<Event, Integer> elementThreshold = CollectionLiterals.<Event, Integer>newLinkedHashMap();

  public EventTopologicalOrder(final ITMSC tmsc) {
    this.tmsc = tmsc;
    Collection<Event> _events = tmsc.getEvents();
    for (final Event element : _events) {
      {
        final Function1<Dependency, Boolean> _function = (Dependency it) -> {
          Event _source = it.getSource();
          return Boolean.valueOf((_source == null));
        };
        final int threshold = IterableExtensions.size(IterableExtensions.<Dependency>reject(this.tmsc.getIncomingDependencies(element), _function));
        if ((threshold == 0)) {
          this.enabledElements.add(element);
        } else {
          this.elementThreshold.put(element, Integer.valueOf(threshold));
        }
      }
    }
  }

  @Override
  public boolean hasNext() {
    return ((!this.enabledElements.isEmpty()) || (!this.elementThreshold.isEmpty()));
  }

  @Override
  public Event next() {
    boolean _isEmpty = this.enabledElements.isEmpty();
    if (_isEmpty) {
      throw new IllegalStateException("TMSC has at least one cycle");
    }
    final Event next = this.enabledElements.remove();
    LinkedList<Event> _doConsume = this.doConsume(next);
    Iterables.<Event>addAll(this.enabledElements, _doConsume);
    return next;
  }

  @Override
  public Iterator<Event> consume(final Event event) {
    boolean _remove = this.enabledElements.remove(event);
    if (_remove) {
      final LinkedList<Event> newEnabledElements = this.doConsume(event);
      Iterables.<Event>addAll(this.enabledElements, newEnabledElements);
      return Iterators.<Event>unmodifiableIterator(newEnabledElements.iterator());
    } else {
      throw new IllegalArgumentException("Event cannot be consumed");
    }
  }

  private LinkedList<Event> doConsume(final Event event) {
    final LinkedList<Event> newEnabledElements = CollectionLiterals.<Event>newLinkedList();
    final Function1<Dependency, Event> _function = (Dependency it) -> {
      return it.getTarget();
    };
    Iterable<Event> _filterNull = IterableExtensions.<Event>filterNull(IterableExtensions.<Dependency, Event>map(this.tmsc.getOutgoingDependencies(event), _function));
    for (final Event candidate : _filterNull) {
      {
        final BiFunction<Event, Integer, Integer> _function_1 = (Event element, Integer threshold) -> {
          Integer _xifexpression = null;
          if (((threshold).intValue() > 1)) {
            _xifexpression = Integer.valueOf(((threshold).intValue() - 1));
          } else {
            _xifexpression = null;
          }
          return _xifexpression;
        };
        final Integer candidateThreshold = this.elementThreshold.computeIfPresent(candidate, _function_1);
        if ((candidateThreshold == null)) {
          newEnabledElements.add(candidate);
        }
      }
    }
    return newEnabledElements;
  }

  @Override
  public Iterator<Event> getEnabledElements() {
    return Iterators.<Event>unmodifiableIterator(this.enabledElements.iterator());
  }
}
