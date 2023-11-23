/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.compare;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;
import org.eclipse.lsat.common.queries.IteratorQueries;
import org.eclipse.lsat.common.xtend.Queries;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class EquivalenceMatcher {
  @Data
  public static final class Match<T extends Object> {
    public enum MatchKind {
      Ambiguity,
      
      Addition,
      
      Exact;
    }
    
    private final Collection<T> left;
    
    private final Collection<T> right;
    
    public Match(final Collection<T> left, final Collection<T> right) {
      Collection<T> _elvis = null;
      if (left != null) {
        _elvis = left;
      } else {
        Set<T> _emptySet = Collections.<T>emptySet();
        _elvis = _emptySet;
      }
      this.left = _elvis;
      Collection<T> _elvis_1 = null;
      if (right != null) {
        _elvis_1 = right;
      } else {
        Set<T> _emptySet_1 = Collections.<T>emptySet();
        _elvis_1 = _emptySet_1;
      }
      this.right = _elvis_1;
    }
    
    public EquivalenceMatcher.Match.MatchKind getKind() {
      EquivalenceMatcher.Match.MatchKind _switchResult = null;
      boolean _matched = false;
      if ((this.left.isEmpty() || this.right.isEmpty())) {
        _matched=true;
        _switchResult = EquivalenceMatcher.Match.MatchKind.Addition;
      }
      if (!_matched) {
        if (((this.left.size() == 1) && (this.right.size() == 1))) {
          _matched=true;
          _switchResult = EquivalenceMatcher.Match.MatchKind.Exact;
        }
      }
      if (!_matched) {
        _switchResult = EquivalenceMatcher.Match.MatchKind.Ambiguity;
      }
      return _switchResult;
    }
    
    @Override
    public String toString() {
      return this.getKind().name();
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.left== null) ? 0 : this.left.hashCode());
      return prime * result + ((this.right== null) ? 0 : this.right.hashCode());
    }
    
    @Override
    @Pure
    public boolean equals(final Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      EquivalenceMatcher.Match<?> other = (EquivalenceMatcher.Match<?>) obj;
      if (this.left == null) {
        if (other.left != null)
          return false;
      } else if (!this.left.equals(other.left))
        return false;
      if (this.right == null) {
        if (other.right != null)
          return false;
      } else if (!this.right.equals(other.right))
        return false;
      return true;
    }
    
    @Pure
    public Collection<T> getLeft() {
      return this.left;
    }
    
    @Pure
    public Collection<T> getRight() {
      return this.right;
    }
  }
  
  private EquivalenceMatcher() {
  }
  
  public static <T extends Object> List<EquivalenceMatcher.Match<T>> match(final Iterable<T> left, final Iterable<T> right, final BiPredicate<? super T, ? super T> equivalence) {
    return EquivalenceMatcher.<T>match(left.iterator(), right.iterator(), equivalence);
  }
  
  public static <T extends Object> List<EquivalenceMatcher.Match<T>> match(final Iterator<T> left, final Iterator<T> right, final BiPredicate<? super T, ? super T> equivalence) {
    final List<List<T>> leftGroups = IteratorQueries.<T>groupBy(left, equivalence);
    final List<List<T>> rightGroups = IteratorQueries.<T>groupBy(right, equivalence);
    int _max = Math.max(leftGroups.size(), rightGroups.size());
    final ArrayList<EquivalenceMatcher.Match<T>> result = new ArrayList<EquivalenceMatcher.Match<T>>(_max);
    for (final List<T> leftGroup : leftGroups) {
      {
        final Function1<List<T>, Boolean> _function = (List<T> rg) -> {
          return Boolean.valueOf(equivalence.test(IterableExtensions.<T>head(leftGroup), IterableExtensions.<T>head(rg)));
        };
        final List<T> rightGroup = Queries.<List<T>>removeFirst(rightGroups, _function);
        EquivalenceMatcher.Match<T> _match = new EquivalenceMatcher.Match<T>(leftGroup, rightGroup);
        result.add(_match);
      }
    }
    for (final List<T> rightGroup : rightGroups) {
      EquivalenceMatcher.Match<T> _match = new EquivalenceMatcher.Match<T>(null, rightGroup);
      result.add(_match);
    }
    return result;
  }
  
  public static <T extends Object> BiMap<T, T> matchExact(final Iterable<T> left, final Iterable<T> right, final BiPredicate<? super T, ? super T> equivalence) {
    return EquivalenceMatcher.<T>matchExact(left.iterator(), right.iterator(), equivalence);
  }
  
  public static <T extends Object> BiMap<T, T> matchExact(final Iterator<T> left, final Iterator<T> right, final BiPredicate<? super T, ? super T> equivalence) {
    final Function1<List<T>, Boolean> _function = (List<T> it) -> {
      int _size = it.size();
      return Boolean.valueOf((_size == 1));
    };
    final Set<T> leftUniqueElements = IterableExtensions.<T>toSet(Iterables.<T>concat(IterableExtensions.<List<T>>filter(IteratorQueries.<T>groupBy(left, equivalence), _function)));
    final Function1<List<T>, Boolean> _function_1 = (List<T> it) -> {
      int _size = it.size();
      return Boolean.valueOf((_size == 1));
    };
    final Set<T> rightUniqueElements = IterableExtensions.<T>toSet(Iterables.<T>concat(IterableExtensions.<List<T>>filter(IteratorQueries.<T>groupBy(right, equivalence), _function_1)));
    final HashBiMap<T, T> exactMatches = HashBiMap.<T, T>create();
    for (final T leftElement : leftUniqueElements) {
      {
        final Function1<T, Boolean> _function_2 = (T r) -> {
          return Boolean.valueOf(equivalence.test(leftElement, r));
        };
        final T rightElement = Queries.<T>removeFirst(rightUniqueElements, _function_2);
        if ((rightElement != null)) {
          exactMatches.put(leftElement, rightElement);
        }
      }
    }
    return exactMatches;
  }
}
