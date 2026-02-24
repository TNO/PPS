package nl.esi.pps.tmsc.cpu;

import com.google.common.collect.Iterables;
import java.util.function.Consumer;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.Lifeline;
import nl.esi.pps.tmsc.LifelineSegment;
import nl.esi.pps.tmsc.util.TmscQueries;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class TmscCpuInfoQueries {
  public static long getOnCpuNanos(final Execution execution, final boolean includeChildren) {
    final Function2<Long, LifelineSegment, Long> _function = (Long sum, LifelineSegment segment) -> {
      Long _xifexpression = null;
      if ((includeChildren || (segment.getActiveExecution() == execution))) {
        long _onCpuNanos = TmscCpuInfoQueries.getOnCpuNanos(segment);
        _xifexpression = Long.valueOf(((sum).longValue() + _onCpuNanos));
      } else {
        _xifexpression = sum;
      }
      return _xifexpression;
    };
    return (long) IterableExtensions.<LifelineSegment, Long>fold(TmscQueries.getCallStackLifelineSegments(execution), Long.valueOf(0L), _function);
  }

  public static long getWaitCpuNanos(final Execution execution, final boolean includeChildren) {
    final Function2<Long, LifelineSegment, Long> _function = (Long sum, LifelineSegment segment) -> {
      Long _xifexpression = null;
      if ((includeChildren || (segment.getActiveExecution() == execution))) {
        long _waitCpuNanos = TmscCpuInfoQueries.getWaitCpuNanos(segment);
        _xifexpression = Long.valueOf(((sum).longValue() + _waitCpuNanos));
      } else {
        _xifexpression = sum;
      }
      return _xifexpression;
    };
    return (long) IterableExtensions.<LifelineSegment, Long>fold(TmscQueries.getCallStackLifelineSegments(execution), Long.valueOf(0L), _function);
  }

  public static long getWaitOtherNanos(final Execution execution, final boolean includeChildren) {
    final Function2<Long, LifelineSegment, Long> _function = (Long sum, LifelineSegment segment) -> {
      Long _xifexpression = null;
      if ((includeChildren || (segment.getActiveExecution() == execution))) {
        long _waitOtherNanos = TmscCpuInfoQueries.getWaitOtherNanos(segment);
        _xifexpression = Long.valueOf(((sum).longValue() + _waitOtherNanos));
      } else {
        _xifexpression = sum;
      }
      return _xifexpression;
    };
    return (long) IterableExtensions.<LifelineSegment, Long>fold(TmscQueries.getCallStackLifelineSegments(execution), Long.valueOf(0L), _function);
  }

  public static boolean hasCpuInfo(final FullScopeTMSC tmsc) {
    final Function1<LifelineSegment, Boolean> _function = (LifelineSegment it) -> {
      return Boolean.valueOf(TmscCpuInfoQueries.hasCpuInfo(it));
    };
    return IterableExtensions.<LifelineSegment>exists(Iterables.<LifelineSegment>filter(tmsc.getDependencies(), LifelineSegment.class), _function);
  }

  public static boolean hasCpuInfo(final Lifeline lifeline) {
    final Function1<LifelineSegment, Boolean> _function = (LifelineSegment it) -> {
      return Boolean.valueOf(TmscCpuInfoQueries.hasCpuInfo(it));
    };
    return IterableExtensions.<LifelineSegment>exists(lifeline.getSegments(), _function);
  }

  public static boolean hasCpuInfo(final Execution execution) {
    final Function1<LifelineSegment, Boolean> _function = (LifelineSegment it) -> {
      return Boolean.valueOf(TmscCpuInfoQueries.hasCpuInfo(it));
    };
    return IterableExtensions.<LifelineSegment>exists(TmscQueries.getCallStackLifelineSegments(execution), _function);
  }

  public static boolean hasCpuInfo(final LifelineSegment segement) {
    return (((TmscCpuInfoQueries.getOnCpuNanos(segement) > 0) || (TmscCpuInfoQueries.getWaitCpuNanos(segement) > 0)) || (TmscCpuInfoQueries.getWaitOtherNanos(segement) > 0));
  }

  public static void clearCpuInfo(final FullScopeTMSC tmsc) {
    final Consumer<LifelineSegment> _function = (LifelineSegment it) -> {
      TmscCpuInfoQueries.clearCpuInfo(it);
    };
    Iterables.<LifelineSegment>filter(tmsc.getDependencies(), LifelineSegment.class).forEach(_function);
  }

  public static void clearCpuInfo(final Lifeline lifeline) {
    final Consumer<LifelineSegment> _function = (LifelineSegment it) -> {
      TmscCpuInfoQueries.clearCpuInfo(it);
    };
    lifeline.getSegments().forEach(_function);
  }

  public static void clearCpuInfo(final Execution execution) {
    final Consumer<LifelineSegment> _function = (LifelineSegment it) -> {
      TmscCpuInfoQueries.clearCpuInfo(it);
    };
    TmscQueries.getCallStackLifelineSegments(execution).forEach(_function);
  }

  public static void clearCpuInfo(final LifelineSegment segement) {
    TmscCpuInfoQueries.setOnCpuNanos(segement, 0L);
    TmscCpuInfoQueries.setWaitCpuNanos(segement, 0L);
    TmscCpuInfoQueries.setWaitOtherNanos(segement, 0L);
  }

  /**
   * Default value for persisted {@code onCpuNanos} property on LifelineSegment
   */
  private static final long _DEFAULT_LIFELINESEGMENT_ONCPUNANOS = 0L;

  public static long getOnCpuNanos(final LifelineSegment container) {
    final String key = "onCpuNanos";
    final Object value = container.getProperties().get(key);
    if (value == null) {
        return _DEFAULT_LIFELINESEGMENT_ONCPUNANOS;
    }
    return (long) value;
  }

  public static void setOnCpuNanos(final LifelineSegment container, final long value) {
    final String key = "onCpuNanos";
    if (value == _DEFAULT_LIFELINESEGMENT_ONCPUNANOS) {
    container.getProperties().remove(key);
    } else {
        container.getProperties().put(key, value);
    }
  }

  /**
   * Default value for persisted {@code waitCpuNanos} property on LifelineSegment
   */
  private static final long _DEFAULT_LIFELINESEGMENT_WAITCPUNANOS = 0L;

  public static long getWaitCpuNanos(final LifelineSegment container) {
    final String key = "waitCpuNanos";
    final Object value = container.getProperties().get(key);
    if (value == null) {
        return _DEFAULT_LIFELINESEGMENT_WAITCPUNANOS;
    }
    return (long) value;
  }

  public static void setWaitCpuNanos(final LifelineSegment container, final long value) {
    final String key = "waitCpuNanos";
    if (value == _DEFAULT_LIFELINESEGMENT_WAITCPUNANOS) {
    container.getProperties().remove(key);
    } else {
        container.getProperties().put(key, value);
    }
  }

  /**
   * Default value for persisted {@code waitOtherNanos} property on LifelineSegment
   */
  private static final long _DEFAULT_LIFELINESEGMENT_WAITOTHERNANOS = 0L;

  public static long getWaitOtherNanos(final LifelineSegment container) {
    final String key = "waitOtherNanos";
    final Object value = container.getProperties().get(key);
    if (value == null) {
        return _DEFAULT_LIFELINESEGMENT_WAITOTHERNANOS;
    }
    return (long) value;
  }

  public static void setWaitOtherNanos(final LifelineSegment container, final long value) {
    final String key = "waitOtherNanos";
    if (value == _DEFAULT_LIFELINESEGMENT_WAITOTHERNANOS) {
    container.getProperties().remove(key);
    } else {
        container.getProperties().put(key, value);
    }
  }
}
