/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
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

@SuppressWarnings("all")
class DependencyReverseTopologicalOrder implements TopologicalOrderIterator<Dependency> {
  @Extension
  private final ITMSC tmsc;
  
  private final Queue<Dependency> enabledElements = CollectionLiterals.<Dependency>newLinkedList();
  
  private final Map<Dependency, Integer> elementThreshold = CollectionLiterals.<Dependency, Integer>newLinkedHashMap();
  
  public DependencyReverseTopologicalOrder(final ITMSC tmsc) {
    this.tmsc = tmsc;
    Collection<Dependency> _dependencies = tmsc.getDependencies();
    for (final Dependency element : _dependencies) {
      {
        int _xifexpression = (int) 0;
        Event _target = element.getTarget();
        boolean _tripleEquals = (_target == null);
        if (_tripleEquals) {
          _xifexpression = 0;
        } else {
          _xifexpression = this.tmsc.getOutgoingDependencies(element.getTarget()).size();
        }
        final int threshold = _xifexpression;
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
  public Dependency next() {
    boolean _isEmpty = this.enabledElements.isEmpty();
    if (_isEmpty) {
      throw new IllegalStateException("TMSC has at least one cycle");
    }
    final Dependency next = this.enabledElements.remove();
    LinkedList<Dependency> _doConsume = this.doConsume(next);
    Iterables.<Dependency>addAll(this.enabledElements, _doConsume);
    return next;
  }
  
  @Override
  public Iterator<Dependency> consume(final Dependency dependency) {
    boolean _remove = this.enabledElements.remove(dependency);
    if (_remove) {
      final LinkedList<Dependency> newEnabledElements = this.doConsume(dependency);
      Iterables.<Dependency>addAll(this.enabledElements, newEnabledElements);
      return Iterators.<Dependency>unmodifiableIterator(newEnabledElements.iterator());
    } else {
      throw new IllegalArgumentException("Dependency cannot be consumed");
    }
  }
  
  private LinkedList<Dependency> doConsume(final Dependency dependency) {
    final LinkedList<Dependency> newEnabledElements = CollectionLiterals.<Dependency>newLinkedList();
    Event _source = dependency.getSource();
    boolean _tripleNotEquals = (_source != null);
    if (_tripleNotEquals) {
      Collection<Dependency> _incomingDependencies = this.tmsc.getIncomingDependencies(dependency.getSource());
      for (final Dependency candidate : _incomingDependencies) {
        {
          final BiFunction<Dependency, Integer, Integer> _function = (Dependency element, Integer threshold) -> {
            Integer _xifexpression = null;
            if (((threshold).intValue() > 1)) {
              _xifexpression = Integer.valueOf(((threshold).intValue() - 1));
            } else {
              _xifexpression = null;
            }
            return _xifexpression;
          };
          final Integer candidateThreshold = this.elementThreshold.computeIfPresent(candidate, _function);
          if ((candidateThreshold == null)) {
            newEnabledElements.add(candidate);
          }
        }
      }
    }
    return newEnabledElements;
  }
  
  @Override
  public Iterator<Dependency> getEnabledElements() {
    return Iterators.<Dependency>unmodifiableIterator(this.enabledElements.iterator());
  }
}
