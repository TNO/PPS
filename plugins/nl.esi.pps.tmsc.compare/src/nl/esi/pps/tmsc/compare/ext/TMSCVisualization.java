package nl.esi.pps.tmsc.compare.ext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import nl.esi.pps.common.jfreechart.rendering.RenderingPaint;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.ITMSC;
import nl.esi.pps.tmsc.compare.ITmscMatchResult;
import nl.esi.pps.tmsc.rendering.RenderingProperties;
import nl.esi.pps.tmsc.util.TmscQueries;

/**
 * This is the access point for the TMSC visualization functionality.
 */

public class TMSCVisualization{
	
	public static void diffCorrelation(ITMSC leftTmsc, ITMSC rightTmsc, ITmscMatchResult result) {
		LinkedHashMap<Set<Dependency>, Set<Dependency>> correspondingDiff = new LinkedHashMap<>();
    	List<Dependency> leftUnmatchedDep = leftTmsc.getDependencies().stream().filter(d -> !result.getDependencyMatches().containsKey(d)).collect(Collectors.toList());
    	List<Dependency> rightUnmatchedDep = rightTmsc.getDependencies().stream().filter(d -> !result.getDependencyMatches().containsValue(d)).collect(Collectors.toList());
    	List<List<Dependency>> leftDisjointParts = TmscQueries.findDisjunctTMSCs(leftUnmatchedDep);
    	List<List<Dependency>> rigthDisjointParts = TmscQueries.findDisjunctTMSCs(rightUnmatchedDep);
    	
    	List<List<Dependency>> matchedRigthDisjointTmscs = new ArrayList<List<Dependency>>();
    	for(List<Dependency> l: leftDisjointParts) {
    		List<Event> lEvents = TmscQueries.createCachedQueryTMSC(l).getEvents().stream().filter(e -> result.getEventMatches().keySet().contains(e)).collect(Collectors.toList()); 
    		Boolean noMatch = true;
    		for(List<Dependency> r: rigthDisjointParts) {
        		List<Event> rEvents = TmscQueries.createCachedQueryTMSC(r).getEvents().stream().filter(e -> result.getEventMatches().values().contains(e)).collect(Collectors.toList()); 
    			if(lEvents.stream().anyMatch(e -> rEvents.contains(result.getEventMatches().get(e)))) {
    				for(Entry<Set<Dependency>, Set<Dependency>> entry: correspondingDiff.entrySet()) {
    					Set<Dependency> lResult = entry.getKey().stream()
    							  .filter(d -> l.contains(d))
    							  .collect(Collectors.toSet());
    					Set<Dependency> rResult = entry.getValue().stream()
  							  .filter(d -> r.contains(d))
  							  .collect(Collectors.toSet());
    					if(!lResult.isEmpty() || !rResult.isEmpty()) {
    						entry.getKey().addAll(l.stream().collect(Collectors.toSet()));
    						entry.getValue().addAll(r.stream().collect(Collectors.toSet()));
    						matchedRigthDisjointTmscs.add(r);
    						noMatch = false;
    					}
    				}
    				if(noMatch) {
        				noMatch = false;
						matchedRigthDisjointTmscs.add(r);
						correspondingDiff.put(l.stream().collect(Collectors.toSet()), r.stream().collect(Collectors.toSet()));
    				}
    			}
    		}
    		if(noMatch)
    			correspondingDiff.put(l.stream().collect(Collectors.toSet()), Collections.<Dependency>emptySet());
    	}
		for(List<Dependency> r: rigthDisjointParts.stream().filter(t -> !matchedRigthDisjointTmscs.contains(t)).collect(Collectors.toSet())) {
			correspondingDiff.put(r.stream().collect(Collectors.toSet()), Collections.<Dependency>emptySet());
		}
    	
    	int count = 0;
		for(Entry<Set<Dependency>, Set<Dependency>> entry : correspondingDiff.entrySet()) {
			for (Dependency dep : entry.getKey()) {
				RenderingProperties.setPaint(dep, RenderingPaint.valueOf(count));
			}
			for (Dependency dep : entry.getValue()) {
				RenderingProperties.setPaint(dep, RenderingPaint.valueOf(count));
			}
			count++;
		}
	}
}
