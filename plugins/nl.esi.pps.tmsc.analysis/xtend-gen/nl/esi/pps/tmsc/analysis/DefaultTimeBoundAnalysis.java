/**
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.analysis;

import com.google.common.collect.Iterables;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.EntryEvent;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.Lifeline;
import nl.esi.pps.tmsc.LifelineSegment;
import nl.esi.pps.tmsc.Message;
import nl.esi.pps.tmsc.MessageControl;
import nl.esi.pps.tmsc.util.TmscQueries;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class DefaultTimeBoundAnalysis {
  @Data
  private static class MinimumDurationKey {
    private final Lifeline from;

    private final Lifeline to;

    private final EClass dependencyType;

    private final boolean messageControl;

    public MinimumDurationKey(final Dependency dependency) {
      Event _source = dependency.getSource();
      Lifeline _lifeline = null;
      if (_source!=null) {
        _lifeline=_source.getLifeline();
      }
      this.from = _lifeline;
      Event _target = dependency.getTarget();
      Lifeline _lifeline_1 = null;
      if (_target!=null) {
        _lifeline_1=_target.getLifeline();
      }
      this.to = _lifeline_1;
      if ((dependency instanceof MessageControl)) {
        this.dependencyType = ((MessageControl)dependency).getMessage().eClass();
        this.messageControl = true;
      } else {
        this.dependencyType = dependency.eClass();
        this.messageControl = false;
      }
    }

    public Long computeMinimumDuration() {
      final Function1<Event, EList<Dependency>> _function = (Event it) -> {
        return it.getFullScopeOutgoingDependencies();
      };
      final Function1<Dependency, Boolean> _function_1 = (Dependency it) -> {
        Event _target = it.getTarget();
        Lifeline _lifeline = null;
        if (_target!=null) {
          _lifeline=_target.getLifeline();
        }
        return Boolean.valueOf(Objects.equals(_lifeline, this.to));
      };
      Iterable<? extends Dependency> siblings = IterableExtensions.<Dependency>filter(IterableExtensions.<Event, Dependency>flatMap(this.from.getEvents(), _function), _function_1);
      if (this.messageControl) {
        final Function1<MessageControl, Boolean> _function_2 = (MessageControl it) -> {
          EClass _eClass = it.getMessage().eClass();
          return Boolean.valueOf(Objects.equals(_eClass, this.dependencyType));
        };
        siblings = IterableExtensions.<MessageControl>filter(Iterables.<MessageControl>filter(siblings, MessageControl.class), _function_2);
      } else {
        final Function1<Dependency, Boolean> _function_3 = (Dependency it) -> {
          EClass _eClass = it.eClass();
          return Boolean.valueOf(Objects.equals(_eClass, this.dependencyType));
        };
        siblings = IterableExtensions.filter(siblings, _function_3);
      }
      final Function1<Dependency, Long> _function_4 = (Dependency it) -> {
        return it.getDuration();
      };
      return IterableExtensions.<Long>min(IterableExtensions.<Long>filterNull(IterableExtensions.map(siblings, _function_4)));
    }

    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.from== null) ? 0 : this.from.hashCode());
      result = prime * result + ((this.to== null) ? 0 : this.to.hashCode());
      result = prime * result + ((this.dependencyType== null) ? 0 : this.dependencyType.hashCode());
      return prime * result + (this.messageControl ? 1231 : 1237);
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
      DefaultTimeBoundAnalysis.MinimumDurationKey other = (DefaultTimeBoundAnalysis.MinimumDurationKey) obj;
      if (this.from == null) {
        if (other.from != null)
          return false;
      } else if (!this.from.equals(other.from))
        return false;
      if (this.to == null) {
        if (other.to != null)
          return false;
      } else if (!this.to.equals(other.to))
        return false;
      if (this.dependencyType == null) {
        if (other.dependencyType != null)
          return false;
      } else if (!this.dependencyType.equals(other.dependencyType))
        return false;
      if (other.messageControl != this.messageControl)
        return false;
      return true;
    }

    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("from", this.from);
      b.add("to", this.to);
      b.add("dependencyType", this.dependencyType);
      b.add("messageControl", this.messageControl);
      return b.toString();
    }

    @Pure
    public Lifeline getFrom() {
      return this.from;
    }

    @Pure
    public Lifeline getTo() {
      return this.to;
    }

    @Pure
    public EClass getDependencyType() {
      return this.dependencyType;
    }

    @Pure
    public boolean isMessageControl() {
      return this.messageControl;
    }
  }

  private final Map<DefaultTimeBoundAnalysis.MinimumDurationKey, Long> minimumDurationCache = CollectionLiterals.<DefaultTimeBoundAnalysis.MinimumDurationKey, Long>newHashMap();

  private final long defaultTimeBound;

  public void analyzeTimeBounds(final FullScopeTMSC tmsc) {
    final Function1<Lifeline, EList<Event>> _function = (Lifeline it) -> {
      return it.getEvents();
    };
    final Consumer<Event> _function_1 = (Event it) -> {
      this.analyzeTimeBounds(it);
    };
    IterableExtensions.<Lifeline, Event>flatMap(tmsc.getLifelines(), _function).forEach(_function_1);
  }

  public void analyzeTimeBounds(final Event event) {
    final Function1<Dependency, Boolean> _function = (Dependency it) -> {
      Long _duration = it.getDuration();
      return Boolean.valueOf((_duration == null));
    };
    final Function1<Dependency, Boolean> _function_1 = (Dependency it) -> {
      return Boolean.valueOf(this.shouldBeAnalyzed(it));
    };
    final Iterable<Dependency> incomingDependencies = IterableExtensions.<Dependency>filter(IterableExtensions.<Dependency>reject(event.getFullScopeIncomingDependencies(), _function), _function_1);
    final Set<Dependency> messages = IterableExtensions.<Dependency>toSet(IterableExtensions.<Dependency>reject(incomingDependencies, LifelineSegment.class));
    final LifelineSegment lifelineSegment = TmscQueries.<LifelineSegment>getAtMostOne(Iterables.<LifelineSegment>filter(incomingDependencies, LifelineSegment.class));
    boolean lifelineSegmentCritical = false;
    final Function1<Dependency, Boolean> _function_2 = (Dependency it) -> {
      return Boolean.valueOf(TmscQueries.isFullyTraced(it));
    };
    Iterable<Dependency> _filter = IterableExtensions.<Dependency>filter(messages, _function_2);
    for (final Dependency tracedMessage : _filter) {
      {
        Long _startTime = tracedMessage.getStartTime();
        long _timeout = this.getTimeout(tracedMessage);
        final long tracedMessageActualStartTime = ((_startTime).longValue() + _timeout);
        if (((lifelineSegment == null) || (tracedMessageActualStartTime >= (lifelineSegment.getStartTime()).longValue()))) {
          this.setSafeTimeBound(tracedMessage, tracedMessage.getDuration());
        } else {
          lifelineSegmentCritical = true;
          this.setSafeTimeBound(tracedMessage, Long.valueOf(this.getDefaultTimeBound(tracedMessage)));
        }
      }
    }
    if ((lifelineSegment != null)) {
      if (((!lifelineSegmentCritical) && ((!messages.isEmpty()) || this.isWaitEvent(event)))) {
        final long lifelineSegmentDefaultTimeBound = this.getDefaultTimeBound(lifelineSegment);
        Long _duration = lifelineSegment.getDuration();
        boolean _lessEqualsThan = ((_duration).longValue() <= lifelineSegmentDefaultTimeBound);
        lifelineSegmentCritical = _lessEqualsThan;
        Long _xifexpression = null;
        if (lifelineSegmentCritical) {
          _xifexpression = lifelineSegment.getDuration();
        } else {
          _xifexpression = Long.valueOf(lifelineSegmentDefaultTimeBound);
        }
        this.setSafeTimeBound(lifelineSegment, _xifexpression);
      } else {
        this.setSafeTimeBound(lifelineSegment, lifelineSegment.getDuration());
      }
    }
    if ((!lifelineSegmentCritical)) {
      final Function1<Dependency, Boolean> _function_3 = (Dependency it) -> {
        return Boolean.valueOf(TmscQueries.isFullyTraced(it));
      };
      final Consumer<Dependency> _function_4 = (Dependency it) -> {
        this.setSafeTimeBound(it, it.getDuration());
      };
      IterableExtensions.<Dependency>reject(messages, _function_3).forEach(_function_4);
    } else {
      final Function1<Dependency, Boolean> _function_5 = (Dependency it) -> {
        return Boolean.valueOf(TmscQueries.isFullyTraced(it));
      };
      final Consumer<Dependency> _function_6 = (Dependency it) -> {
        this.setSafeTimeBound(it, null);
      };
      IterableExtensions.<Dependency>reject(messages, _function_5).forEach(_function_6);
    }
  }

  /**
   * Returns {@code true} if time-bound should be analyzed for {@code dependency}.
   */
  protected boolean shouldBeAnalyzed(final Dependency dependency) {
    boolean _switchResult = false;
    final Dependency it = dependency;
    boolean _matched = false;
    boolean _isProjection = it.isProjection();
    if (_isProjection) {
      _matched=true;
      _switchResult = false;
    }
    if (!_matched) {
      if (it instanceof LifelineSegment) {
        _matched=true;
      }
      if (!_matched) {
        if (it instanceof MessageControl) {
          _matched=true;
        }
      }
      if (!_matched) {
        if (it instanceof Message) {
          boolean _isEmpty = ((Message)it).getControlDependencies().isEmpty();
          if (_isEmpty) {
            _matched=true;
          }
        }
      }
      if (_matched) {
        _switchResult = true;
      }
    }
    if (!_matched) {
      _switchResult = false;
    }
    return _switchResult;
  }

  /**
   * Returns {@code true} if the {@code event} is expected to await some message
   * before the application continues.
   */
  protected boolean isWaitEvent(final Event event) {
    return (((event instanceof EntryEvent) && (event.getExecution() != null)) && (event.getExecution().getParent() == null));
  }

  protected long getTimeout(final Dependency dependency) {
    return 0L;
  }

  protected long getDefaultTimeBound(final Dependency dependency) {
    if ((dependency instanceof LifelineSegment)) {
      return this.defaultTimeBound;
    }
    final long dependencyDelay = this.getTimeout(dependency);
    if ((dependencyDelay > 0)) {
      return dependencyDelay;
    }
    if (((dependency instanceof Message) || (dependency instanceof MessageControl))) {
      final long messageLatency = this.getMinimumDuration(dependency);
      Long _duration = dependency.getDuration();
      boolean _lessThan = (messageLatency < (_duration).longValue());
      if (_lessThan) {
        return messageLatency;
      }
    }
    return this.defaultTimeBound;
  }

  /**
   * Sets the {@code dependency} time-bound, ensuring that it will never be greater than its duration.
   */
  protected void setSafeTimeBound(final Dependency dependency, final Long timeBound) {
    if (((timeBound == null) || (dependency.getDuration() == null))) {
      dependency.setTimeBound(null);
    } else {
      dependency.setTimeBound(Long.valueOf(Math.min((dependency.getDuration()).longValue(), (timeBound).longValue())));
    }
  }

  protected long getMinimumDuration(final Dependency dependency) {
    DefaultTimeBoundAnalysis.MinimumDurationKey _minimumDurationKey = new DefaultTimeBoundAnalysis.MinimumDurationKey(dependency);
    final Function<DefaultTimeBoundAnalysis.MinimumDurationKey, Long> _function = (DefaultTimeBoundAnalysis.MinimumDurationKey it) -> {
      return it.computeMinimumDuration();
    };
    return (this.minimumDurationCache.computeIfAbsent(_minimumDurationKey, _function)).longValue();
  }

  public DefaultTimeBoundAnalysis(final long defaultTimeBound) {
    super();
    this.defaultTimeBound = defaultTimeBound;
  }
}
