package nl.esi.pps.tmsc.compare

import com.google.common.collect.BiMap
import com.google.common.collect.HashBiMap
import java.util.List
import java.util.Map
import java.util.Set
import java.util.function.BiPredicate
import nl.esi.pps.architecture.implemented.IPCFunction
import nl.esi.pps.tmsc.Dependency
import nl.esi.pps.tmsc.Event
import nl.esi.pps.tmsc.Execution
import nl.esi.pps.tmsc.ITMSC
import nl.esi.pps.tmsc.Lifeline
import nl.esi.pps.tmsc.util.TmscQueries
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class TmscServiceMatcher {
    static extension val Logger LOGGER = LoggerFactory.getLogger(TmscServiceMatcher)
    
    static class Service{
        ITMSC tmsc
        Execution rootExec
        new(ITMSC tmsc, Execution exec) {
            this.tmsc = tmsc
            this.rootExec = exec
        } 
    }
    
    static List<Service> leftServices = newLinkedList
    static List<Service> rightServices = newLinkedList
    static BiMap<Service, Service> matchedServices = HashBiMap.create()

    static def ITmscMatchResult match(ITMSC leftTmsc, ITMSC rightTmsc,
        BiPredicate<? super Event, ? super Event> eventEquivalence){
        val TmscMatchResult matchResult = new TmscMatchResult(leftTmsc, rightTmsc);
        
        leftServices = leftTmsc.serviceSegments.filter[rootExec !== null].toList
        rightServices = rightTmsc.serviceSegments.filter[rootExec !== null].toList
        val Map<String, List<Service>> leftGroupedServices = leftServices.groupBy[rootExec.lifeline.executor.name+rootExec.function.name]
        val Map<String, List<Service>> rightGroupedServices = rightServices.groupBy[rootExec.lifeline.executor.name+rootExec.function.name]
        
        val List<Service> leftUniqueServices = newLinkedList
        leftGroupedServices.entrySet.filter[value.size == 1].forEach[leftUniqueServices.addAll(value)]
        leftUniqueServices.sort[a,b | a.tmsc.dependencies.size.compareTo(b.tmsc.dependencies.size)]
        
        val List<Service> rigthUniqueServices = newLinkedList
        rightGroupedServices.entrySet.filter[value.size == 1].forEach[rigthUniqueServices.addAll(value)]
        rigthUniqueServices.sort[a,b | a.tmsc.dependencies.size.compareTo(b.tmsc.dependencies.size)]
        
        val matchedEvents = HashBiMap.create()
        
        for(leftService: leftUniqueServices){
            for(rightService: rigthUniqueServices){
                match(leftService, rightService, matchedEvents, eventEquivalence)
            }
        }
        
        matchedEvents.forEach[a,b | matchResult.addMatch(a,b)]
        return matchResult
    }
    
    private static def boolean match(Service leftService, Service rigthService, BiMap<Event, Event> matchedEvents, BiPredicate<? super Event, ? super Event> eventEquivalence) {
        if(leftService === null || rigthService === null)
            return false
        if(leftService.rootExec === null || rigthService.rootExec === null)
            return false
        if(leftService.tmsc === null || rigthService.tmsc === null)
            return false
        if(leftService.rootExec.component.name.equals("«untraced»") || rigthService.rootExec.component.name.equals("«untraced»"))
            return false
        if(!compareExecutions(leftService.rootExec, rigthService.rootExec))
            return false
        debug('Matching TMSCs {} and {}', leftService.label, rigthService.label)

        val BiMap<Event, Event> initMatchedEvents = TmscIsomorphismMatcher.discoverAllEventMatches(leftService.tmsc,
            rigthService.tmsc, eventEquivalence)
        val ITmscMatchResult result = TmscIsomorphismMatcher.match(leftService.tmsc, rigthService.tmsc,
            initMatchedEvents, eventEquivalence)
        try {
            matchedEvents.putAll(result.eventMatches)
        } catch (IllegalArgumentException e) {                    
                    debug('One of the events is matched! {}', e.message)
        }
        matchedServices.put(leftService, rigthService)
        result.eventMatches.entrySet.filter[entry|!entry.key.component.name.equals("«untraced»")]
                                    .filter [ entry |entry.key.execution.lifeline != leftService.rootExec.lifeline]
                                    .forEach[entry|match(getLeftService(entry.key), getRightService(entry.value), matchedEvents, eventEquivalence)]
        
        return true
    }

    private static def Service getLeftService(Event event) {
        for(service: leftServices)
            if(service.tmsc.events.contains(event) && !matchedServices.containsKey(service))
                return service
        return null
    }
    
    private static def Service getRightService(Event event) {
        for(service: rightServices)
            if(service.tmsc.events.contains(event) && !matchedServices.containsValue(service))
                return service
        return null
    }
 
    private static def String label(Service service) {
        return service.rootExec.lifeline.executor.name+"."+service.rootExec.function.name
    }
    
    private static def Set<Service> serviceSegments(ITMSC tmsc) {
        val Set<Lifeline> lifelines = newLinkedHashSet
        val Set<Service> services = newLinkedHashSet
        tmsc.events.forEach[lifelines.add(lifeline)];
        lifelines.forEach[services.addAll(getLifelineServices(tmsc))];
        return services
    }
    
    private static def Set<Service> getLifelineServices(Lifeline lifeline, ITMSC tmsc) {
        val Set<Service> lifelineServices = newLinkedHashSet
                
        val rootExecutions = lifeline.executions.filter[parent === null]
          
        for(root: rootExecutions){  
            val allEvents = lifeline.events.filter[timestamp >= root.startTime && timestamp <= root.endTime].toSet
            val allDependencies = newLinkedHashSet
            allEvents.forEach [
                allDependencies.addAll(tmsc.getIncomingDependencies(it))
                allDependencies.addAll(tmsc.getOutgoingDependencies(it))
            ]
            val ipcExecutions = allEvents.map[execution].filter[function instanceof IPCFunction]
                                         .filter[parent !== null]
                                         .filter[!(parent.function instanceof IPCFunction)].toSet
                                         
            switch (ipcExecutions.size) {
            	case 0: {
            		lifelineServices.add(new Service(TmscQueries.createCachedQueryTMSC(allDependencies), root))
            	}
            	case 1: {
            	    lifelineServices.add(new Service(TmscQueries.createCachedQueryTMSC(allDependencies), ipcExecutions.get(0))) 
            	}
            	default: {
                    for(execution: rootExecutions){
                        val events = allEvents.filter[timestamp >= execution.startTime && timestamp <= execution.endTime]
                        val Set<Dependency> dependencies = newLinkedHashSet
                        events.forEach[
                            dependencies.addAll(tmsc.getIncomingDependencies(it))
                            dependencies.addAll(tmsc.getOutgoingDependencies(it))
                        ]
                        lifelineServices.add(new Service(TmscQueries.createCachedQueryTMSC(dependencies) , execution))
                   }
               }                                                                  
             }   
        }
        return lifelineServices
    }
    
    static def boolean compareExecutions(Execution leftExec, Execution rigthExec){
        if(!leftExec.function.name.equals(rigthExec.function.name))
            return false
        if(!leftExec.lifeline.executor.name.equals(rigthExec.lifeline.executor.name))
            return false
        return true
    }
}