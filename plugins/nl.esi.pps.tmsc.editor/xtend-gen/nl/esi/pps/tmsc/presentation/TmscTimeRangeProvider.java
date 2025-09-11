/**
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.presentation;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import nl.esi.pps.common.emf.synchronizedtiming.range.AbstractTimeRange;
import nl.esi.pps.common.emf.synchronizedtiming.range.EpochNanoTimeRange;
import nl.esi.pps.common.emf.synchronizedtiming.range.RelativeNanoTimeRange;
import nl.esi.pps.common.emf.synchronizedtiming.range.TimeRange;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.ITimeRange;
import nl.esi.pps.tmsc.Lifeline;
import nl.esi.pps.tmsc.ScopedTMSC;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.XbaseGenerated;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Calculates the required time-range to visualize a TMSC element or sequence of elements completely.
 */
@SuppressWarnings("all")
public class TmscTimeRangeProvider {
  @Data
  private static class NanoTimeRange {
    private final boolean epoch;

    private final long start;

    private final long end;

    public NanoTimeRange(final boolean epoch, final long start, final long end) {
      this.epoch = epoch;
      this.start = Math.min(start, end);
      this.end = Math.max(start, end);
    }

    public AbstractTimeRange toTimeRange() {
      final long margin = Math.max(Math.round(((this.end - this.start) * 0.05)), 5);
      final long mStart = Math.max((this.start - margin), 0);
      final long mEnd = (this.end + margin);
      AbstractTimeRange _xifexpression = null;
      if (this.epoch) {
        _xifexpression = new EpochNanoTimeRange(mStart, mEnd);
      } else {
        _xifexpression = new RelativeNanoTimeRange(mStart, mEnd);
      }
      return _xifexpression;
    }

    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + (this.epoch ? 1231 : 1237);
      result = prime * result + (int) (this.start ^ (this.start >>> 32));
      return prime * result + (int) (this.end ^ (this.end >>> 32));
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
      TmscTimeRangeProvider.NanoTimeRange other = (TmscTimeRangeProvider.NanoTimeRange) obj;
      if (other.epoch != this.epoch)
        return false;
      if (other.start != this.start)
        return false;
      if (other.end != this.end)
        return false;
      return true;
    }

    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("epoch", this.epoch);
      b.add("start", this.start);
      b.add("end", this.end);
      return b.toString();
    }

    @Pure
    public boolean isEpoch() {
      return this.epoch;
    }

    @Pure
    public long getStart() {
      return this.start;
    }

    @Pure
    public long getEnd() {
      return this.end;
    }
  }

  public static TimeRange getTimeRange(final Object object) {
    TmscTimeRangeProvider.NanoTimeRange _doGetTimeRange = TmscTimeRangeProvider.doGetTimeRange(object);
    AbstractTimeRange _timeRange = null;
    if (_doGetTimeRange!=null) {
      _timeRange=_doGetTimeRange.toTimeRange();
    }
    return _timeRange;
  }

  private static TmscTimeRangeProvider.NanoTimeRange _doGetTimeRange(final Object object) {
    return null;
  }

  private static TmscTimeRangeProvider.NanoTimeRange _doGetTimeRange(final TmscTimeRangeProvider.NanoTimeRange timeRange) {
    return timeRange;
  }

  private static TmscTimeRangeProvider.NanoTimeRange _doGetTimeRange(final Iterable<?> elements) {
    final Function1<Object, TmscTimeRangeProvider.NanoTimeRange> _function = (Object it) -> {
      return TmscTimeRangeProvider.doGetTimeRange(it);
    };
    final List<TmscTimeRangeProvider.NanoTimeRange> timeRanges = IterableExtensions.<TmscTimeRangeProvider.NanoTimeRange>toList(IterableExtensions.<TmscTimeRangeProvider.NanoTimeRange>filterNull(IterableExtensions.map(elements, _function)));
    TmscTimeRangeProvider.NanoTimeRange _switchResult = null;
    int _size = timeRanges.size();
    switch (_size) {
      case 0:
        _switchResult = null;
        break;
      case 1:
        _switchResult = IterableExtensions.<TmscTimeRangeProvider.NanoTimeRange>head(timeRanges);
        break;
      default:
        TmscTimeRangeProvider.NanoTimeRange _xblockexpression = null;
        {
          final Function1<TmscTimeRangeProvider.NanoTimeRange, Boolean> _function_1 = (TmscTimeRangeProvider.NanoTimeRange it) -> {
            return Boolean.valueOf((it.epoch == IterableExtensions.<TmscTimeRangeProvider.NanoTimeRange>head(timeRanges).epoch));
          };
          boolean _forall = IterableExtensions.<TmscTimeRangeProvider.NanoTimeRange>forall(IterableExtensions.<TmscTimeRangeProvider.NanoTimeRange>tail(timeRanges), _function_1);
          boolean _not = (!_forall);
          if (_not) {
            throw new IllegalArgumentException();
          }
          final Function1<TmscTimeRangeProvider.NanoTimeRange, Long> _function_2 = (TmscTimeRangeProvider.NanoTimeRange it) -> {
            return Long.valueOf(it.start);
          };
          Long _min = IterableExtensions.<Long>min(ListExtensions.<TmscTimeRangeProvider.NanoTimeRange, Long>map(timeRanges, _function_2));
          final Function1<TmscTimeRangeProvider.NanoTimeRange, Long> _function_3 = (TmscTimeRangeProvider.NanoTimeRange it) -> {
            return Long.valueOf(it.end);
          };
          Long _max = IterableExtensions.<Long>max(ListExtensions.<TmscTimeRangeProvider.NanoTimeRange, Long>map(timeRanges, _function_3));
          _xblockexpression = new TmscTimeRangeProvider.NanoTimeRange(IterableExtensions.<TmscTimeRangeProvider.NanoTimeRange>head(timeRanges).epoch, (long) _min, (long) _max);
        }
        _switchResult = _xblockexpression;
        break;
    }
    return _switchResult;
  }

  private static TmscTimeRangeProvider.NanoTimeRange _doGetTimeRange(final ITimeRange timeRange) {
    TmscTimeRangeProvider.NanoTimeRange _xifexpression = null;
    Long _duration = timeRange.getDuration();
    boolean _tripleNotEquals = (_duration != null);
    if (_tripleNotEquals) {
      boolean _isEpochTime = timeRange.isEpochTime();
      Long _startTime = timeRange.getStartTime();
      Long _endTime = timeRange.getEndTime();
      _xifexpression = new TmscTimeRangeProvider.NanoTimeRange(_isEpochTime, (_startTime).longValue(), (_endTime).longValue());
    }
    return _xifexpression;
  }

  private static TmscTimeRangeProvider.NanoTimeRange _doGetTimeRange(final Event event) {
    TmscTimeRangeProvider.NanoTimeRange _xifexpression = null;
    Long _timestamp = event.getTimestamp();
    boolean _tripleNotEquals = (_timestamp != null);
    if (_tripleNotEquals) {
      boolean _isEpochTime = event.getTmsc().isEpochTime();
      Long _timestamp_1 = event.getTimestamp();
      Long _timestamp_2 = event.getTimestamp();
      _xifexpression = new TmscTimeRangeProvider.NanoTimeRange(_isEpochTime, (_timestamp_1).longValue(), (_timestamp_2).longValue());
    }
    return _xifexpression;
  }

  private static TmscTimeRangeProvider.NanoTimeRange _doGetTimeRange(final ScopedTMSC tmsc) {
    Collection<Event> _xifexpression = null;
    boolean _isEmpty = tmsc.getOrigin().isEmpty();
    if (_isEmpty) {
      _xifexpression = tmsc.getEvents();
    } else {
      _xifexpression = tmsc.getOrigin();
    }
    final Collection<Event> events = _xifexpression;
    final Function1<Event, Long> _function = (Event it) -> {
      return it.getTimestamp();
    };
    final Iterable<Long> eventTimeStamps = IterableExtensions.<Long>filterNull(IterableExtensions.<Event, Long>map(events, _function));
    TmscTimeRangeProvider.NanoTimeRange _xifexpression_1 = null;
    boolean _isEmpty_1 = IterableExtensions.isEmpty(eventTimeStamps);
    boolean _not = (!_isEmpty_1);
    if (_not) {
      boolean _isEpochTime = tmsc.getFullScope().isEpochTime();
      Long _min = IterableExtensions.<Long>min(eventTimeStamps);
      Long _max = IterableExtensions.<Long>max(eventTimeStamps);
      _xifexpression_1 = new TmscTimeRangeProvider.NanoTimeRange(_isEpochTime, (long) _min, (long) _max);
    }
    return _xifexpression_1;
  }

  private static TmscTimeRangeProvider.NanoTimeRange _doGetTimeRange(final Lifeline lifeline) {
    final Function1<Event, Long> _function = (Event it) -> {
      return it.getTimestamp();
    };
    final Iterable<Long> eventTimeStamps = IterableExtensions.<Long>filterNull(ListExtensions.<Event, Long>map(lifeline.getEvents(), _function));
    TmscTimeRangeProvider.NanoTimeRange _xifexpression = null;
    boolean _isEmpty = IterableExtensions.isEmpty(eventTimeStamps);
    boolean _not = (!_isEmpty);
    if (_not) {
      boolean _isEpochTime = lifeline.getTmsc().isEpochTime();
      Long _min = IterableExtensions.<Long>min(eventTimeStamps);
      Long _max = IterableExtensions.<Long>max(eventTimeStamps);
      _xifexpression = new TmscTimeRangeProvider.NanoTimeRange(_isEpochTime, (long) _min, (long) _max);
    }
    return _xifexpression;
  }

  @XbaseGenerated
  private static TmscTimeRangeProvider.NanoTimeRange doGetTimeRange(final Object tmsc) {
    if (tmsc instanceof ScopedTMSC) {
      return _doGetTimeRange((ScopedTMSC)tmsc);
    } else if (tmsc instanceof Event) {
      return _doGetTimeRange((Event)tmsc);
    } else if (tmsc instanceof Lifeline) {
      return _doGetTimeRange((Lifeline)tmsc);
    } else if (tmsc instanceof Iterable) {
      return _doGetTimeRange((Iterable<?>)tmsc);
    } else if (tmsc instanceof ITimeRange) {
      return _doGetTimeRange((ITimeRange)tmsc);
    } else if (tmsc instanceof TmscTimeRangeProvider.NanoTimeRange) {
      return _doGetTimeRange((TmscTimeRangeProvider.NanoTimeRange)tmsc);
    } else if (tmsc != null) {
      return _doGetTimeRange(tmsc);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(tmsc).toString());
    }
  }
}
