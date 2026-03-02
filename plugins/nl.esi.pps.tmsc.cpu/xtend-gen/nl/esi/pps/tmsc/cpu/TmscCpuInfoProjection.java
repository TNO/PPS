package nl.esi.pps.tmsc.cpu;

import java.util.Map;
import java.util.Objects;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.LifelineSegment;
import nl.esi.pps.tmsc.util.DependencyFeatureProjection;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

@SuppressWarnings("all")
public class TmscCpuInfoProjection {
  @FinalFieldsConstructor
  private static class LifelineSegmentCpuInfoProjection implements DependencyFeatureProjection<Long> {
    private final Function1<? super LifelineSegment, ? extends Long> getter;

    private final Procedure2<? super LifelineSegment, ? super Long> setter;

    @Override
    public Long getInitialValue(final Event projectionSource) {
      return Long.valueOf(0L);
    }

    @Override
    public Long calculateProjectedValue(final Event projectionSource, final Map<Dependency, Long> projectionValues) {
      final Function1<Map.Entry<Dependency, Long>, Boolean> _function = (Map.Entry<Dependency, Long> it) -> {
        Dependency _key = it.getKey();
        return Boolean.valueOf((_key instanceof LifelineSegment));
      };
      final Function1<Map.Entry<Dependency, Long>, Boolean> _function_1 = (Map.Entry<Dependency, Long> it) -> {
        return Boolean.valueOf((it.getKey().isProjection() || (it.getValue() == null)));
      };
      final Iterable<Map.Entry<Dependency, Long>> validProjectionValues = IterableExtensions.<Map.Entry<Dependency, Long>>reject(IterableExtensions.<Map.Entry<Dependency, Long>>filter(projectionValues.entrySet(), _function), _function_1);
      Long _switchResult = null;
      final Iterable<Map.Entry<Dependency, Long>> it = validProjectionValues;
      boolean _matched = false;
      boolean _isEmpty = IterableExtensions.isEmpty(it);
      if (_isEmpty) {
        _matched=true;
        _switchResult = null;
      }
      if (!_matched) {
        int _size = IterableExtensions.size(it);
        boolean _equals = (_size == 1);
        if (_equals) {
          _matched=true;
          Long _value = IterableExtensions.<Map.Entry<Dependency, Long>>head(it).getValue();
          Dependency _key = IterableExtensions.<Map.Entry<Dependency, Long>>head(it).getKey();
          Long _apply = this.getter.apply(((LifelineSegment) _key));
          _switchResult = Long.valueOf(((_value).longValue() + (_apply).longValue()));
        }
      }
      if (!_matched) {
        throw new IllegalStateException("Programming error, please contact PPS support!");
      }
      return _switchResult;
    }

    @Override
    public void apply(final Dependency projection, final Long projectedValue) {
      if ((projection instanceof LifelineSegment)) {
        if ((((this.getter.apply(((LifelineSegment)projection))).longValue() > 0) && (!Objects.equals(this.getter.apply(((LifelineSegment)projection)), projectedValue)))) {
          throw new IllegalArgumentException("Programming error, please contact PPS support!");
        }
        Long _elvis = null;
        if (projectedValue != null) {
          _elvis = projectedValue;
        } else {
          _elvis = Long.valueOf(0L);
        }
        this.setter.apply(((LifelineSegment)projection), _elvis);
      }
    }

    public LifelineSegmentCpuInfoProjection(final Function1<? super LifelineSegment, ? extends Long> getter, final Procedure2<? super LifelineSegment, ? super Long> setter) {
      super();
      this.getter = getter;
      this.setter = setter;
    }
  }

  public static final TmscCpuInfoProjection.LifelineSegmentCpuInfoProjection ON_CPU_PROJECTION = new TmscCpuInfoProjection.LifelineSegmentCpuInfoProjection(((Function1<LifelineSegment, Long>) (LifelineSegment it) -> {
    return Long.valueOf(TmscCpuInfoQueries.getOnCpuNanos(it));
  }), ((Procedure2<LifelineSegment, Long>) (LifelineSegment $0, Long $1) -> {
    TmscCpuInfoQueries.setOnCpuNanos($0, ($1).longValue());
  }));

  public static final TmscCpuInfoProjection.LifelineSegmentCpuInfoProjection WAIT_CPU_PROJECTION = new TmscCpuInfoProjection.LifelineSegmentCpuInfoProjection(((Function1<LifelineSegment, Long>) (LifelineSegment it) -> {
    return Long.valueOf(TmscCpuInfoQueries.getWaitCpuNanos(it));
  }), ((Procedure2<LifelineSegment, Long>) (LifelineSegment $0, Long $1) -> {
    TmscCpuInfoQueries.setWaitCpuNanos($0, ($1).longValue());
  }));

  public static final TmscCpuInfoProjection.LifelineSegmentCpuInfoProjection WAIT_OTHER_PROJECTION = new TmscCpuInfoProjection.LifelineSegmentCpuInfoProjection(((Function1<LifelineSegment, Long>) (LifelineSegment it) -> {
    return Long.valueOf(TmscCpuInfoQueries.getWaitOtherNanos(it));
  }), ((Procedure2<LifelineSegment, Long>) (LifelineSegment $0, Long $1) -> {
    TmscCpuInfoQueries.setWaitOtherNanos($0, ($1).longValue());
  }));

  private TmscCpuInfoProjection() {
  }
}
