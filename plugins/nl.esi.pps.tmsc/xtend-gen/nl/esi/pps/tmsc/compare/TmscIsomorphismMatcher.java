/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.compare;

import com.google.common.base.Objects;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Iterables;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.EntryEvent;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.ExitEvent;
import nl.esi.pps.tmsc.ITMSC;
import nl.esi.pps.tmsc.Interval;
import nl.esi.pps.tmsc.ScopedTMSC;
import nl.esi.pps.tmsc.sort.TmscTopologicalOrder;
import nl.esi.pps.tmsc.sort.TopologicalOrderIterator;
import nl.esi.pps.tmsc.util.TmscQueries;
import org.eclipse.lsat.common.queries.IteratorQueries;
import org.eclipse.lsat.common.util.BranchIterable;
import org.eclipse.lsat.common.xtend.Queries;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("all")
public class TmscIsomorphismMatcher {
  private static class MatchState {
    private final Map<Dependency, TopologicalOrderIterator<Dependency>> leftDependency2TopologicalOrder = CollectionLiterals.<Dependency, TopologicalOrderIterator<Dependency>>newLinkedHashMap();
    
    private final Map<Dependency, TopologicalOrderIterator<Dependency>> rightDependency2TopologicalOrder = CollectionLiterals.<Dependency, TopologicalOrderIterator<Dependency>>newLinkedHashMap();
    
    private final Map<Dependency, Dependency> matchedDependencies = CollectionLiterals.<Dependency, Dependency>newLinkedHashMap();
    
    private final Set<Dependency> leftRemainder = CollectionLiterals.<Dependency>newLinkedHashSet();
    
    private final Set<Dependency> rightRemainder = CollectionLiterals.<Dependency>newLinkedHashSet();
    
    private final TmscMatchResult result;
    
    private final boolean failAtEnd;
    
    public MatchState(final ITMSC leftTmsc, final ITMSC rightTmsc, final boolean failAtEnd) {
      TmscMatchResult _tmscMatchResult = new TmscMatchResult(leftTmsc, rightTmsc);
      this.result = _tmscMatchResult;
      this.failAtEnd = failAtEnd;
      Collection<Dependency> _dependencies = leftTmsc.getDependencies();
      Iterables.<Dependency>addAll(this.leftRemainder, _dependencies);
      Collection<Dependency> _dependencies_1 = rightTmsc.getDependencies();
      Iterables.<Dependency>addAll(this.rightRemainder, _dependencies_1);
    }
    
    public void addMatch(final Event left, final Event right) throws IllegalArgumentException {
      this.result.addMatch(left, right);
      if (this.failAtEnd) {
        if ((left instanceof EntryEvent)) {
          Execution _execution = ((EntryEvent)left).getExecution();
          ExitEvent _exit = null;
          if (_execution!=null) {
            _exit=_execution.getExit();
          }
          final ExitEvent leftExit = _exit;
          Execution _execution_1 = right.getExecution();
          ExitEvent _exit_1 = null;
          if (_execution_1!=null) {
            _exit_1=_execution_1.getExit();
          }
          final ExitEvent rightExit = _exit_1;
          if (((leftExit != null) && (rightExit != null))) {
            this.result.addMatch(leftExit, rightExit);
          }
        } else {
          if ((left instanceof ExitEvent)) {
            Execution _execution_2 = ((ExitEvent)left).getExecution();
            EntryEvent _entry = null;
            if (_execution_2!=null) {
              _entry=_execution_2.getEntry();
            }
            final EntryEvent leftEntry = _entry;
            Execution _execution_3 = right.getExecution();
            EntryEvent _entry_1 = null;
            if (_execution_3!=null) {
              _entry_1=_execution_3.getEntry();
            }
            final EntryEvent rightEntry = _entry_1;
            if (((leftEntry != null) && (rightEntry != null))) {
              this.result.addMatch(leftEntry, rightEntry);
            }
          }
        }
      }
    }
    
    public Pair<Set<Dependency>, Set<Dependency>> startCycle(final Function1<? super ITMSC, ? extends TmscTopologicalOrder<Dependency>> factory) {
      boolean _isCycleDone = this.isCycleDone();
      boolean _not = (!_isCycleDone);
      if (_not) {
        throw new IllegalStateException("Should only be called if current cycle is done");
      }
      this.leftDependency2TopologicalOrder.clear();
      final Predicate<Event> _function = (Event it) -> {
        return this.result.containsRightMatch(it);
      };
      final Function1<List<Dependency>, TopologicalOrderIterator<Dependency>> _function_1 = (List<Dependency> it) -> {
        return factory.apply(TmscQueries.createCachedQueryTMSC(it)).iterator();
      };
      final List<TopologicalOrderIterator<Dependency>> leftTopologicalOrders = ListExtensions.<List<Dependency>, TopologicalOrderIterator<Dependency>>map(TmscQueries.findDisjunctTMSCs(this.leftRemainder, _function), _function_1);
      for (final TopologicalOrderIterator<Dependency> leftTopologicalOrder : leftTopologicalOrders) {
        final Procedure1<Dependency> _function_2 = (Dependency it) -> {
          this.leftDependency2TopologicalOrder.put(it, leftTopologicalOrder);
        };
        IteratorExtensions.<Dependency>forEach(leftTopologicalOrder.getEnabledElements(), _function_2);
      }
      this.rightDependency2TopologicalOrder.clear();
      final Predicate<Event> _function_3 = (Event it) -> {
        return this.result.containsLeftMatch(it);
      };
      final Function1<List<Dependency>, TopologicalOrderIterator<Dependency>> _function_4 = (List<Dependency> it) -> {
        return factory.apply(TmscQueries.createCachedQueryTMSC(it)).iterator();
      };
      final List<TopologicalOrderIterator<Dependency>> rightTopologicalOrders = ListExtensions.<List<Dependency>, TopologicalOrderIterator<Dependency>>map(TmscQueries.findDisjunctTMSCs(this.rightRemainder, _function_3), _function_4);
      for (final TopologicalOrderIterator<Dependency> rightTopologicalOrder : rightTopologicalOrders) {
        final Procedure1<Dependency> _function_5 = (Dependency it) -> {
          this.rightDependency2TopologicalOrder.put(it, rightTopologicalOrder);
        };
        IteratorExtensions.<Dependency>forEach(rightTopologicalOrder.getEnabledElements(), _function_5);
      }
      this.leftRemainder.clear();
      this.rightRemainder.clear();
      return Pair.<Set<Dependency>, Set<Dependency>>of(this.leftDependency2TopologicalOrder.keySet(), this.rightDependency2TopologicalOrder.keySet());
    }
    
    public boolean isCycleDone() {
      return (IterableExtensions.<TopologicalOrderIterator<Dependency>>forall(this.leftDependency2TopologicalOrder.values(), ((Function1<TopologicalOrderIterator<Dependency>, Boolean>) (TopologicalOrderIterator<Dependency> it) -> {
        boolean _hasNext = it.hasNext();
        return Boolean.valueOf((!_hasNext));
      })) && 
        IterableExtensions.<TopologicalOrderIterator<Dependency>>forall(this.rightDependency2TopologicalOrder.values(), ((Function1<TopologicalOrderIterator<Dependency>, Boolean>) (TopologicalOrderIterator<Dependency> it) -> {
          boolean _hasNext = it.hasNext();
          return Boolean.valueOf((!_hasNext));
        })));
    }
    
    public Iterator<Dependency> consumeLeft(final Dependency dependency) {
      Iterator<Dependency> _xblockexpression = null;
      {
        final TopologicalOrderIterator<Dependency> topologicalOrder = this.leftDependency2TopologicalOrder.remove(dependency);
        final Function1<Dependency, Dependency> _function = (Dependency it) -> {
          this.leftDependency2TopologicalOrder.put(it, topologicalOrder);
          return it;
        };
        _xblockexpression = IteratorExtensions.<Dependency, Dependency>map(topologicalOrder.consume(dependency), _function);
      }
      return _xblockexpression;
    }
    
    public void processLeftBranchInNextCycle(final Dependency dependency, final boolean includeSelf) {
      final Function1<Dependency, Iterable<? extends Dependency>> _function = (Dependency it) -> {
        return IteratorExtensions.<Dependency>toIterable(this.consumeLeft(it));
      };
      BranchIterable<Dependency> _walkTree = Queries.<Dependency>walkTree(Collections.<Dependency>singleton(dependency), includeSelf, _function);
      Iterables.<Dependency>addAll(this.leftRemainder, _walkTree);
    }
    
    public Iterator<Dependency> consumeRight(final Dependency dependency) {
      Iterator<Dependency> _xblockexpression = null;
      {
        final TopologicalOrderIterator<Dependency> topologicalOrder = this.rightDependency2TopologicalOrder.remove(dependency);
        final Function1<Dependency, Dependency> _function = (Dependency it) -> {
          this.rightDependency2TopologicalOrder.put(it, topologicalOrder);
          return it;
        };
        _xblockexpression = IteratorExtensions.<Dependency, Dependency>map(topologicalOrder.consume(dependency), _function);
      }
      return _xblockexpression;
    }
    
    public void processRightBranchInNextCycle(final Dependency dependency, final boolean includeSelf) {
      final Function1<Dependency, Iterable<? extends Dependency>> _function = (Dependency it) -> {
        return IteratorExtensions.<Dependency>toIterable(this.consumeRight(it));
      };
      BranchIterable<Dependency> _walkTree = Queries.<Dependency>walkTree(Collections.<Dependency>singleton(dependency), includeSelf, _function);
      Iterables.<Dependency>addAll(this.rightRemainder, _walkTree);
    }
  }
  
  @Extension
  private static final Logger LOGGER = LoggerFactory.getLogger(TmscIsomorphismMatcher.class);
  
  /**
   * Typically we create a TMSC from a Metric instance.
   * These instances know their from and to events and
   * as such these events can be considered equivalent.
   */
  public static BiMap<Event, Event> intervalEventMatches(final Interval leftInterval, final Interval rightInterval, final BiPredicate<? super Event, ? super Event> eventEquivalence) throws IllegalArgumentException {
    final HashBiMap<Event, Event> map = HashBiMap.<Event, Event>create(2);
    boolean _test = eventEquivalence.test(leftInterval.getFrom(), rightInterval.getFrom());
    if (_test) {
      map.put(leftInterval.getFrom(), rightInterval.getFrom());
    }
    boolean _test_1 = eventEquivalence.test(leftInterval.getTo(), rightInterval.getTo());
    if (_test_1) {
      map.put(leftInterval.getTo(), rightInterval.getTo());
    }
    return map;
  }
  
  /**
   * Discover the initial and final events matches of the left and right TMSC,
   * based on the provided event equivalence.<br>
   * These matches can be used as initial landmarks for matching.
   */
  public static BiMap<Event, Event> discoverEventMatches(final ITMSC leftTmsc, final ITMSC rightTmsc, final BiPredicate<? super Event, ? super Event> eventEquivalence) {
    final BiMap<Event, Event> matches = EquivalenceMatcher.<Event>matchExact(leftTmsc.getInitialEvents(), rightTmsc.getInitialEvents(), eventEquivalence);
    matches.putAll(EquivalenceMatcher.<Event>matchExact(leftTmsc.getFinalEvents(), rightTmsc.getFinalEvents(), eventEquivalence));
    return matches;
  }
  
  /**
   * Discover unique events matches of the left and right TMSC,
   * based on the provided event equivalence.<br>
   * These matches can be used as initial landmarks for matching.
   * FIXME Investigate: We get worse match results when we use this
   *                    method instead of discoverEventMatches
   */
  public static BiMap<Event, Event> discoverAllEventMatches(final ITMSC leftTmsc, final ITMSC rightTmsc, final BiPredicate<? super Event, ? super Event> eventEquivalence) {
    return EquivalenceMatcher.<Event>matchExact(leftTmsc.getEvents(), rightTmsc.getEvents(), eventEquivalence);
  }
  
  /**
   * Returns a list of lists, representing the isomorphism classes of TMSCs that are isomorphic to each other,
   * considering the specified architecture life-cycle stage.
   */
  public static <T extends ITMSC> List<List<T>> findIsomorphismClasses(final Iterator<T> tmscs, final BiPredicate<? super Event, ? super Event> eventEquivalence) {
    final Comparator<List<T>> _function = (List<T> $0, List<T> $1) -> {
      int _size = $1.size();
      int _size_1 = $0.size();
      return (_size - _size_1);
    };
    final BiPredicate<T, T> _function_1 = (T left, T right) -> {
      final BiMap<Event, Event> eventMatches = TmscIsomorphismMatcher.discoverEventMatches(left, right, eventEquivalence);
      return TmscIsomorphismMatcher.isIsomorphic(left, right, eventMatches, eventEquivalence);
    };
    return IteratorQueries.<T>groupBy(tmscs, _function, _function_1);
  }
  
  public static boolean isIsomorphic(final ITMSC leftTmsc, final ITMSC rightTmsc, final BiMap<Event, Event> eventMatches, final BiPredicate<? super Event, ? super Event> eventEquivalence) {
    return TmscIsomorphismMatcher.match(leftTmsc, rightTmsc, eventMatches, false, eventEquivalence).isFullMatch();
  }
  
  public static ITmscMatchResult match(final ITMSC leftTmsc, final ITMSC rightTmsc, final BiMap<Event, Event> eventMatches, final BiPredicate<? super Event, ? super Event> eventEquivalence) {
    return TmscIsomorphismMatcher.match(leftTmsc, rightTmsc, eventMatches, true, eventEquivalence);
  }
  
  public static ITmscMatchResult match(final ITMSC leftTmsc, final ITMSC rightTmsc, final BiMap<Event, Event> eventMatches, final boolean failAtEnd, final BiPredicate<? super Event, ? super Event> eventEquivalence) {
    TmscIsomorphismMatcher.LOGGER.debug("Matching TMSCs {} and {}", TmscIsomorphismMatcher.getLabel(leftTmsc), TmscIsomorphismMatcher.getLabel(rightTmsc));
    if (((eventMatches == null) || eventMatches.isEmpty())) {
      TmscIsomorphismMatcher.LOGGER.debug("This algorithm requires at least 1 event match to start.");
      return TmscMatchResult.EMPTY;
    } else {
      if (((!failAtEnd) && (leftTmsc.getDependencies().size() != rightTmsc.getDependencies().size()))) {
        TmscIsomorphismMatcher.LOGGER.debug("TMSCs are different: Size: {} != {}", Integer.valueOf(leftTmsc.getDependencies().size()), Integer.valueOf(rightTmsc.getDependencies().size()));
        return TmscMatchResult.EMPTY;
      }
    }
    final TmscIsomorphismMatcher.MatchState matchState = new TmscIsomorphismMatcher.MatchState(leftTmsc, rightTmsc, failAtEnd);
    int _size = matchState.leftRemainder.size();
    int _size_1 = matchState.rightRemainder.size();
    final int nrofDependencies = (_size + _size_1);
    final Consumer<Map.Entry<Event, Event>> _function = (Map.Entry<Event, Event> it) -> {
      matchState.addMatch(it.getKey(), it.getValue());
    };
    eventMatches.entrySet().forEach(_function);
    boolean continue_ = false;
    do {
      {
        final int leftRemainingAtStart = matchState.leftRemainder.size();
        continue_ = ((TmscIsomorphismMatcher.matchCycle(matchState, eventEquivalence) && 
          TmscIsomorphismMatcher.matchCycleReverse(matchState, eventEquivalence)) && 
          (leftRemainingAtStart > matchState.leftRemainder.size()));
      }
    } while(((continue_ && (!matchState.leftRemainder.isEmpty())) && (!matchState.rightRemainder.isEmpty())));
    int _size_2 = matchState.matchedDependencies.size();
    double _multiply = (_size_2 * 2.0);
    double _divide = (_multiply / nrofDependencies);
    matchState.result.setMatchPercentage(_divide);
    if (failAtEnd) {
      Double _matchPercentage = matchState.result.getMatchPercentage();
      double _multiply_1 = ((_matchPercentage).doubleValue() * 100);
      TmscIsomorphismMatcher.LOGGER.debug(String.format("TMSCs match for %.2f%%", Double.valueOf(_multiply_1)));
    } else {
      boolean _isFullMatch = matchState.result.isFullMatch();
      if (_isFullMatch) {
        TmscIsomorphismMatcher.LOGGER.debug("TMSCs are equivalent!");
      } else {
        TmscIsomorphismMatcher.LOGGER.debug("TMSCs are different!");
      }
    }
    return matchState.result;
  }
  
  private static String getLabel(final ITMSC tmsc) {
    String _switchResult = null;
    boolean _matched = false;
    if (tmsc instanceof ScopedTMSC) {
      _matched=true;
      _switchResult = ((ScopedTMSC)tmsc).getFqn();
    }
    if (!_matched) {
      if (tmsc instanceof TmscQueries.CachedQueryTMSC) {
        _matched=true;
        _switchResult = ((TmscQueries.CachedQueryTMSC)tmsc).getName();
      }
    }
    final String label = _switchResult;
    String _elvis = null;
    if (label != null) {
      _elvis = label;
    } else {
      Class<? extends ITMSC> _class = null;
      if (tmsc!=null) {
        _class=tmsc.getClass();
      }
      String _simpleName = null;
      if (_class!=null) {
        _simpleName=_class.getSimpleName();
      }
      _elvis = _simpleName;
    }
    return _elvis;
  }
  
  private static boolean matchCycle(@Extension final TmscIsomorphismMatcher.MatchState matchState, final BiPredicate<? super Event, ? super Event> eventEquivalence) {
    final BiPredicate<Event, Event> _function = (Event leftEvent, Event rightEvent) -> {
      Event _rightMatch = matchState.result.getRightMatch(leftEvent);
      return Objects.equal(_rightMatch, rightEvent);
    };
    final DependencyEquivalence equivalence = new DependencyEquivalence(_function, eventEquivalence);
    final Function1<ITMSC, TmscTopologicalOrder<Dependency>> _function_1 = (ITMSC it) -> {
      return TmscTopologicalOrder.getDependenciesInTopologicalOrder(it);
    };
    final Pair<Set<Dependency>, Set<Dependency>> initialDependencies = matchState.startCycle(_function_1);
    final Function<EquivalenceMatcher.Match<Dependency>, EquivalenceMatcher.Match.MatchKind> _function_2 = (EquivalenceMatcher.Match<Dependency> it) -> {
      return it.getKind();
    };
    Comparator<EquivalenceMatcher.Match<Dependency>> _comparing = Comparator.<EquivalenceMatcher.Match<Dependency>, EquivalenceMatcher.Match.MatchKind>comparing(_function_2);
    final PriorityQueue<EquivalenceMatcher.Match<Dependency>> dependencyMatches = new PriorityQueue<EquivalenceMatcher.Match<Dependency>>(_comparing);
    List<EquivalenceMatcher.Match<Dependency>> _match = EquivalenceMatcher.<Dependency>match(initialDependencies.getKey(), initialDependencies.getValue(), equivalence);
    Iterables.<EquivalenceMatcher.Match<Dependency>>addAll(dependencyMatches, _match);
    while ((!dependencyMatches.isEmpty())) {
      {
        final EquivalenceMatcher.Match<Dependency> match = dependencyMatches.remove();
        EquivalenceMatcher.Match.MatchKind _kind = match.getKind();
        boolean _equals = Objects.equal(_kind, EquivalenceMatcher.Match.MatchKind.Exact);
        if (_equals) {
          final Dependency leftMatch = IterableExtensions.<Dependency>head(match.getLeft());
          final Dependency rightMatch = IterableExtensions.<Dependency>head(match.getRight());
          try {
            matchState.addMatch(leftMatch.getTarget(), rightMatch.getTarget());
            matchState.matchedDependencies.put(leftMatch, rightMatch);
            List<EquivalenceMatcher.Match<Dependency>> _match_1 = EquivalenceMatcher.<Dependency>match(matchState.consumeLeft(leftMatch), matchState.consumeRight(rightMatch), equivalence);
            Iterables.<EquivalenceMatcher.Match<Dependency>>addAll(dependencyMatches, _match_1);
          } catch (final Throwable _t) {
            if (_t instanceof IllegalArgumentException) {
              final IllegalArgumentException e = (IllegalArgumentException)_t;
              final Event matchLeft = leftMatch.getTarget();
              final Event matchRight = rightMatch.getTarget();
              final Event oldMatchLeft = matchState.result.getLeftMatch(matchRight);
              final Event oldMatchRight = matchState.result.getRightMatch(matchLeft);
              matchState.result.invalidateMatch(matchLeft, matchRight);
              final Predicate<Dependency> _function_3 = (Dependency it) -> {
                return ((it.getTarget() == matchLeft) || (it.getTarget() == oldMatchLeft));
              };
              matchState.matchedDependencies.keySet().removeIf(_function_3);
              final Predicate<Dependency> _function_4 = (Dependency it) -> {
                return ((it.getTarget() == matchRight) || (it.getTarget() == oldMatchRight));
              };
              matchState.matchedDependencies.values().removeIf(_function_4);
              TmscIsomorphismMatcher.LOGGER.debug("TMSC different: Equivalent paths lead to different events. {}", e.getMessage());
              if ((!matchState.failAtEnd)) {
                return false;
              }
              matchState.processLeftBranchInNextCycle(leftMatch, false);
              matchState.processRightBranchInNextCycle(rightMatch, false);
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
        } else {
          final Consumer<Dependency> _function_3 = (Dependency it) -> {
            matchState.processLeftBranchInNextCycle(it, true);
          };
          match.getLeft().forEach(_function_3);
          final Consumer<Dependency> _function_4 = (Dependency it) -> {
            matchState.processRightBranchInNextCycle(it, true);
          };
          match.getRight().forEach(_function_4);
        }
      }
    }
    return true;
  }
  
  private static boolean matchCycleReverse(@Extension final TmscIsomorphismMatcher.MatchState matchState, final BiPredicate<? super Event, ? super Event> eventEquivalence) {
    final BiPredicate<Event, Event> _function = (Event leftEvent, Event rightEvent) -> {
      Event _rightMatch = matchState.result.getRightMatch(leftEvent);
      return Objects.equal(_rightMatch, rightEvent);
    };
    final DependencyEquivalence reverseEquivalence = new DependencyEquivalence(eventEquivalence, _function);
    final Function1<ITMSC, TmscTopologicalOrder<Dependency>> _function_1 = (ITMSC it) -> {
      return TmscTopologicalOrder.getDependenciesInReverseTopologicalOrder(it);
    };
    final Pair<Set<Dependency>, Set<Dependency>> initialDependencies = matchState.startCycle(_function_1);
    final Function<EquivalenceMatcher.Match<Dependency>, EquivalenceMatcher.Match.MatchKind> _function_2 = (EquivalenceMatcher.Match<Dependency> it) -> {
      return it.getKind();
    };
    Comparator<EquivalenceMatcher.Match<Dependency>> _comparing = Comparator.<EquivalenceMatcher.Match<Dependency>, EquivalenceMatcher.Match.MatchKind>comparing(_function_2);
    final PriorityQueue<EquivalenceMatcher.Match<Dependency>> dependencyMatches = new PriorityQueue<EquivalenceMatcher.Match<Dependency>>(_comparing);
    List<EquivalenceMatcher.Match<Dependency>> _match = EquivalenceMatcher.<Dependency>match(initialDependencies.getKey(), initialDependencies.getValue(), reverseEquivalence);
    Iterables.<EquivalenceMatcher.Match<Dependency>>addAll(dependencyMatches, _match);
    while ((!dependencyMatches.isEmpty())) {
      {
        final EquivalenceMatcher.Match<Dependency> match = dependencyMatches.remove();
        EquivalenceMatcher.Match.MatchKind _kind = match.getKind();
        boolean _equals = Objects.equal(_kind, EquivalenceMatcher.Match.MatchKind.Exact);
        if (_equals) {
          final Dependency leftMatch = IterableExtensions.<Dependency>head(match.getLeft());
          final Dependency rightMatch = IterableExtensions.<Dependency>head(match.getRight());
          try {
            matchState.addMatch(leftMatch.getSource(), rightMatch.getSource());
            matchState.matchedDependencies.put(leftMatch, rightMatch);
            List<EquivalenceMatcher.Match<Dependency>> _match_1 = EquivalenceMatcher.<Dependency>match(matchState.consumeLeft(leftMatch), matchState.consumeRight(rightMatch), reverseEquivalence);
            Iterables.<EquivalenceMatcher.Match<Dependency>>addAll(dependencyMatches, _match_1);
          } catch (final Throwable _t) {
            if (_t instanceof IllegalArgumentException) {
              final IllegalArgumentException e = (IllegalArgumentException)_t;
              final Event matchLeft = leftMatch.getSource();
              final Event matchRight = rightMatch.getSource();
              final Event oldMatchLeft = matchState.result.getLeftMatch(matchRight);
              final Event oldMatchRight = matchState.result.getRightMatch(matchLeft);
              matchState.result.invalidateMatch(matchLeft, matchRight);
              final Predicate<Dependency> _function_3 = (Dependency it) -> {
                return ((it.getSource() == matchLeft) || (it.getSource() == oldMatchLeft));
              };
              matchState.matchedDependencies.keySet().removeIf(_function_3);
              final Predicate<Dependency> _function_4 = (Dependency it) -> {
                return ((it.getSource() == matchRight) || (it.getSource() == oldMatchRight));
              };
              matchState.matchedDependencies.values().removeIf(_function_4);
              TmscIsomorphismMatcher.LOGGER.debug("TMSC different: Equivalent paths lead to different events. {}", e.getMessage());
              if ((!matchState.failAtEnd)) {
                return false;
              }
              matchState.processLeftBranchInNextCycle(leftMatch, false);
              matchState.processRightBranchInNextCycle(rightMatch, false);
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
        } else {
          final Consumer<Dependency> _function_3 = (Dependency it) -> {
            matchState.processLeftBranchInNextCycle(it, true);
          };
          match.getLeft().forEach(_function_3);
          final Consumer<Dependency> _function_4 = (Dependency it) -> {
            matchState.processRightBranchInNextCycle(it, true);
          };
          match.getRight().forEach(_function_4);
        }
      }
    }
    return true;
  }
}
