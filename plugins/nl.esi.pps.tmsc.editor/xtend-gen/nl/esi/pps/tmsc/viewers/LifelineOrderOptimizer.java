/**
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.viewers;

import com.google.common.collect.Iterables;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.Graph;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import nl.esi.pps.common.emf.synchronizedtiming.range.TimeRange;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.Lifeline;
import nl.esi.pps.tmsc.Message;
import nl.esi.pps.tmsc.Reply;
import org.eclipse.emf.common.util.EList;
import org.eclipse.lsat.common.xtend.Queries;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("all")
public class LifelineOrderOptimizer {
  private static final Logger LOGGER = LoggerFactory.getLogger(LifelineOrderOptimizer.class);

  private LifelineOrderOptimizer() {
  }

  public static Collection<Lifeline> optimizeOrder(final TimeRange timeRange, final Lifeline... lifelines) {
    final Set<Message> messages = LifelineOrderOptimizer.filterMessages(timeRange, lifelines);
    final MutableGraph<Lifeline> graph = GraphBuilder.directed().expectedNodeCount(lifelines.length).<Lifeline>build();
    final Consumer<Lifeline> _function = (Lifeline ll) -> {
      graph.addNode(ll);
    };
    ListExtensions.<Lifeline>reverseView(((List<Lifeline>)Conversions.doWrapArray(lifelines))).forEach(_function);
    final Consumer<Reply> _function_1 = (Reply it) -> {
      graph.putEdge(it.getSource().getLifeline(), it.getTarget().getLifeline());
    };
    Iterables.<Reply>filter(messages, Reply.class).forEach(_function_1);
    final Consumer<Message> _function_2 = (Message it) -> {
      graph.putEdge(it.getTarget().getLifeline(), it.getSource().getLifeline());
    };
    IterableExtensions.<Message>reject(messages, Reply.class).forEach(_function_2);
    int _length = lifelines.length;
    final ArrayList<Lifeline> sortedLifelines = new ArrayList<Lifeline>(_length);
    final Function1<Lifeline, Boolean> _function_3 = (Lifeline ll) -> {
      int _degree = graph.degree(ll);
      return Boolean.valueOf((_degree == 0));
    };
    final List<Lifeline> isolatedLifelines = IterableExtensions.<Lifeline>toList(IterableExtensions.<Lifeline>filter(graph.nodes(), _function_3));
    final Consumer<Lifeline> _function_4 = (Lifeline ll) -> {
      graph.removeNode(ll);
    };
    isolatedLifelines.forEach(_function_4);
    Iterables.<Lifeline>addAll(sortedLifelines, isolatedLifelines);
    List<MutableGraph<Lifeline>> _disjunct = LifelineOrderOptimizer.<Lifeline>disjunct(graph);
    for (final MutableGraph<Lifeline> disjunctGraph : _disjunct) {
      {
        final List<Lifeline> forward = LifelineOrderOptimizer.<Lifeline>getNodesInTopologicalOrder(disjunctGraph);
        Iterables.<Lifeline>addAll(sortedLifelines, forward);
        int _size = forward.size();
        int _size_1 = disjunctGraph.nodes().size();
        boolean _notEquals = (_size != _size_1);
        if (_notEquals) {
          final Consumer<Lifeline> _function_5 = (Lifeline ll) -> {
            disjunctGraph.removeNode(ll);
          };
          forward.forEach(_function_5);
          final List<Lifeline> reverse = LifelineOrderOptimizer.<Lifeline>getNodesInTopologicalOrder(LifelineOrderOptimizer.<Lifeline>reverse(disjunctGraph));
          final Consumer<Lifeline> _function_6 = (Lifeline ll) -> {
            disjunctGraph.removeNode(ll);
          };
          reverse.forEach(_function_6);
          final Function1<Lifeline, String> _function_7 = (Lifeline it) -> {
            return it.getExecutor().getName();
          };
          LifelineOrderOptimizer.LOGGER.debug("Detected cycle, skipped ordering {}", IterableExtensions.join(IterableExtensions.<Lifeline, String>map(disjunctGraph.nodes(), _function_7), ", "));
          Set<Lifeline> _nodes = disjunctGraph.nodes();
          Iterables.<Lifeline>addAll(sortedLifelines, _nodes);
          List<Lifeline> _reverseView = ListExtensions.<Lifeline>reverseView(reverse);
          Iterables.<Lifeline>addAll(sortedLifelines, _reverseView);
        }
      }
    }
    return ListExtensions.<Lifeline>reverse(sortedLifelines);
  }

  public static Set<Message> filterMessages(final TimeRange timeRange, final Lifeline... lifelines) {
    final Function1<Lifeline, EList<Event>> _function = (Lifeline it) -> {
      return it.getEvents();
    };
    final Function1<Event, Boolean> _function_1 = (Event it) -> {
      return Boolean.valueOf(timeRange.contains(it.getTimestamp()));
    };
    final Set<Event> events = IterableExtensions.<Event>toSet(IterableExtensions.<Event>filter(IterableExtensions.<Lifeline, Event>flatMap(((Iterable<Lifeline>)Conversions.doWrapArray(lifelines)), _function), _function_1));
    final Function1<Event, Iterable<Message>> _function_2 = (Event it) -> {
      return Iterables.<Message>filter(it.getFullScopeOutgoingDependencies(), Message.class);
    };
    final Function1<Message, Boolean> _function_3 = (Message it) -> {
      Lifeline _lifeline = it.getSource().getLifeline();
      Lifeline _lifeline_1 = it.getTarget().getLifeline();
      return Boolean.valueOf(Objects.equals(_lifeline, _lifeline_1));
    };
    final Function1<Message, Boolean> _function_4 = (Message it) -> {
      return Boolean.valueOf(events.contains(it.getTarget()));
    };
    final Iterable<Message> outgoingMessages = IterableExtensions.<Message>filter(IterableExtensions.<Message>reject(IterableExtensions.<Event, Message>flatMap(events, _function_2), _function_3), _function_4);
    final Function1<Event, Iterable<Message>> _function_5 = (Event it) -> {
      return Iterables.<Message>filter(it.getFullScopeIncomingDependencies(), Message.class);
    };
    final Function1<Message, Boolean> _function_6 = (Message it) -> {
      Lifeline _lifeline = it.getSource().getLifeline();
      Lifeline _lifeline_1 = it.getTarget().getLifeline();
      return Boolean.valueOf(Objects.equals(_lifeline, _lifeline_1));
    };
    final Function1<Message, Boolean> _function_7 = (Message it) -> {
      return Boolean.valueOf(events.contains(it.getSource()));
    };
    final Iterable<Message> incomingMessages = IterableExtensions.<Message>filter(IterableExtensions.<Message>reject(IterableExtensions.<Event, Message>flatMap(events, _function_5), _function_6), _function_7);
    return IterableExtensions.<Message>toSet(Queries.<Message>union(outgoingMessages, incomingMessages));
  }

  public static <N extends Object> List<MutableGraph<N>> disjunct(final Graph<N> graph) {
    final Map<N, MutableGraph<N>> node2graph = CollectionLiterals.<N, MutableGraph<N>>newLinkedHashMap();
    Set<EndpointPair<N>> _edges = graph.edges();
    for (final EndpointPair<N> edge : _edges) {
      {
        final MutableGraph<N> sourceGraph = node2graph.get(edge.source());
        final MutableGraph<N> targetGraph = node2graph.get(edge.target());
        if (((sourceGraph != null) && (targetGraph != null))) {
          if ((sourceGraph == targetGraph)) {
            sourceGraph.putEdge(edge);
          } else {
            int _size = sourceGraph.edges().size();
            int _size_1 = targetGraph.edges().size();
            boolean _lessThan = (_size < _size_1);
            if (_lessThan) {
              final Consumer<EndpointPair<N>> _function = (EndpointPair<N> e) -> {
                targetGraph.putEdge(e);
              };
              sourceGraph.edges().forEach(_function);
              targetGraph.putEdge(edge);
              final Consumer<N> _function_1 = (N n) -> {
                node2graph.put(n, targetGraph);
              };
              sourceGraph.nodes().forEach(_function_1);
            } else {
              final Consumer<EndpointPair<N>> _function_2 = (EndpointPair<N> e) -> {
                sourceGraph.putEdge(e);
              };
              targetGraph.edges().forEach(_function_2);
              sourceGraph.putEdge(edge);
              final Consumer<N> _function_3 = (N n) -> {
                node2graph.put(n, sourceGraph);
              };
              targetGraph.nodes().forEach(_function_3);
            }
          }
        } else {
          if ((sourceGraph != null)) {
            sourceGraph.putEdge(edge);
            node2graph.put(edge.target(), sourceGraph);
          } else {
            if ((targetGraph != null)) {
              targetGraph.putEdge(edge);
              node2graph.put(edge.source(), targetGraph);
            } else {
              final MutableGraph<N> newGraph = GraphBuilder.<N>from(graph).<N>build();
              newGraph.putEdge(edge);
              node2graph.put(edge.source(), newGraph);
              node2graph.put(edge.target(), newGraph);
            }
          }
        }
      }
    }
    return IterableExtensions.<MutableGraph<N>>toList(Queries.<MutableGraph<N>>unique(node2graph.values(), false));
  }

  public static <N extends Object> List<N> getNodesInTopologicalOrder(final Graph<N> graph) {
    final Function1<N, N> _function = (N k) -> {
      return k;
    };
    final Function1<N, HashSet<N>> _function_1 = (N it) -> {
      return CollectionLiterals.<N>newHashSet();
    };
    final Map<N, HashSet<N>> incomingEdges = IterableExtensions.<N, N, HashSet<N>>toMap(graph.nodes(), _function, _function_1);
    final Consumer<EndpointPair<N>> _function_2 = (EndpointPair<N> it) -> {
      HashSet<N> _get = incomingEdges.get(it.target());
      N _source = it.source();
      _get.add(_source);
    };
    graph.edges().forEach(_function_2);
    int _size = incomingEdges.size();
    final ArrayList<N> result = new ArrayList<N>(_size);
    final Function2<N, HashSet<N>, Boolean> _function_3 = (N k, HashSet<N> v) -> {
      return Boolean.valueOf(v.isEmpty());
    };
    Map.Entry<N, HashSet<N>> _removeFirst = Queries.<N, HashSet<N>>removeFirst(incomingEdges, _function_3);
    N _key = null;
    if (_removeFirst!=null) {
      _key=_removeFirst.getKey();
    }
    N next = _key;
    while ((next != null)) {
      {
        result.add(next);
        Collection<HashSet<N>> _values = incomingEdges.values();
        for (final HashSet<N> crossReferences : _values) {
          crossReferences.remove(next);
        }
        final Function2<N, HashSet<N>, Boolean> _function_4 = (N k, HashSet<N> v) -> {
          return Boolean.valueOf(v.isEmpty());
        };
        Map.Entry<N, HashSet<N>> _removeFirst_1 = Queries.<N, HashSet<N>>removeFirst(incomingEdges, _function_4);
        N _key_1 = null;
        if (_removeFirst_1!=null) {
          _key_1=_removeFirst_1.getKey();
        }
        next = _key_1;
      }
    }
    return result;
  }

  public static <N extends Object> MutableGraph<N> reverse(final Graph<N> graph) {
    final MutableGraph<N> reversed = GraphBuilder.<N>from(graph).<N>build();
    final Consumer<N> _function = (N n) -> {
      reversed.addNode(n);
    };
    Queries.<N>reverse(graph.nodes()).forEach(_function);
    final Consumer<EndpointPair<N>> _function_1 = (EndpointPair<N> it) -> {
      reversed.putEdge(it.target(), it.source());
    };
    graph.edges().forEach(_function_1);
    return reversed;
  }
}
