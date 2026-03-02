package nl.esi.pps.tmsc.cpu

import java.util.Map
import nl.esi.pps.tmsc.Dependency
import nl.esi.pps.tmsc.Event
import nl.esi.pps.tmsc.LifelineSegment
import nl.esi.pps.tmsc.util.DependencyFeatureProjection
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

import static extension nl.esi.pps.tmsc.cpu.TmscCpuInfoQueries.*

class TmscCpuInfoProjection {
    public static val ON_CPU_PROJECTION = new LifelineSegmentCpuInfoProjection([onCpuNanos],[$0.onCpuNanos = $1])
    public static val WAIT_CPU_PROJECTION = new LifelineSegmentCpuInfoProjection([waitCpuNanos],[$0.waitCpuNanos = $1])
    public static val WAIT_OTHER_PROJECTION = new LifelineSegmentCpuInfoProjection([waitOtherNanos],[$0.waitOtherNanos = $1])
    
    private new() {
        // Empty for utility classes
    }
    
    @FinalFieldsConstructor
    private static class LifelineSegmentCpuInfoProjection implements DependencyFeatureProjection<Long> {
        val (LifelineSegment)=>long getter
        val (LifelineSegment, long)=>void setter
        
        override getInitialValue(Event projectionSource) {
            return 0L
        }
        
        override calculateProjectedValue(Event projectionSource, Map<Dependency, Long> projectionValues) {
            val validProjectionValues = projectionValues.entrySet.filter[key instanceof LifelineSegment].reject[key.projection || value === null]
            return switch (it: validProjectionValues) {
            	case isEmpty: null
            	case size == 1: head.value + getter.apply(head.key as LifelineSegment)
            	default: throw new IllegalStateException('Programming error, please contact PPS support!')
            }
        }
         
        override apply(Dependency projection, Long projectedValue) {
            if (projection instanceof LifelineSegment) {
                if (getter.apply(projection) > 0 && getter.apply(projection) != projectedValue) {
                    // Expected the same onCpuNanos to be calculated if projection is reused
                    throw new IllegalArgumentException('Programming error, please contact PPS support!')
                }
                setter.apply(projection, projectedValue ?: 0L)
            }
        }
    }
}