package nl.esi.pps.tmsc.analysis.ui.handlers

import java.text.DecimalFormat
import nl.esi.emf.properties.xtend.PersistedProperty
import nl.esi.pps.tmsc.ScopedTMSC
import nl.esi.pps.tmsc.compare.ArchitectureLifecycleStage
import nl.esi.pps.tmsc.metric.Metric

import static extension nl.esi.pps.tmsc.compare.TmscIsomorphismMatcher.*
import static extension nl.esi.pps.tmsc.rendering.plot.ScopesRenderingStrategy.*
import static extension nl.esi.pps.tmsc.util.TmscQueries.*

class CreateMetricActivityIsomorphismClassesHelper {
    static val CLASS_FORMAT = new DecimalFormat("000");

    @PersistedProperty(ScopedTMSC)
    public static var String isomorphismType
    
    @PersistedProperty(ScopedTMSC)
    public static var String isomorphismStage

    @PersistedProperty(ScopedTMSC)
    public static var String isomorphismClass

    static def Iterable<ScopedTMSC> createIsomorphismClasses(Metric metric, CreateIntervalActivityStrategy strategy, ArchitectureLifecycleStage stage) {
        val metricInstanceTmscs = metric.instances.iterator.map[mi | 
            strategy.createTMSC(mi) => [ miTmsc |
                mi.scopes += miTmsc
                miTmsc.isomorphismType = strategy.label
                miTmsc.isomorphismStage = stage.label
                miTmsc.groupKey = false
            ]
        ]
        
        return metricInstanceTmscs.findIsomorphismClasses(stage).indexed.map [
            val isomorphismClass = CLASS_FORMAT.format(key + 1)
            val isomorphicTmscs = value
            val isomorphismClassName = '''Isomorphism class «isomorphismClass» «isomorphicTmscs.size» «isomorphicTmscs.head.dependencies.size»'''
            
            isomorphicTmscs.forEach[tmsc | tmsc.isomorphismClass = isomorphismClass]
            
            isomorphicTmscs.flatMap[dependencies].createScopedTMSC(isomorphismClassName) => [ groupTmsc |
                groupTmsc.childScopes += isomorphicTmscs
                groupTmsc.isomorphismType = strategy.label
                groupTmsc.isomorphismStage = stage.label
                groupTmsc.isomorphismClass = isomorphismClass
                groupTmsc.groupKey = true
            ]
        ]
    }
}