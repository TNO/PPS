/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.compare;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiPredicate;

import com.github.tno.gltsdiff.glts.DiffKind;
import com.github.tno.gltsdiff.glts.DiffProperty;
import com.github.tno.gltsdiff.glts.GLTS;
import com.github.tno.gltsdiff.glts.State;
import com.github.tno.gltsdiff.glts.Transition;
import com.github.tno.gltsdiff.matchers.Matcher;
import com.github.tno.gltsdiff.matchers.WalkinshawGLTSMatcher;
import com.github.tno.gltsdiff.matchers.scorers.SimilarityScorer;
import com.github.tno.gltsdiff.matchers.scorers.WalkinshawLocalGLTSScorer;
import com.github.tno.gltsdiff.mergers.DefaultMerger;
import com.github.tno.gltsdiff.operators.combiners.Combiner;
import com.github.tno.gltsdiff.operators.combiners.DiffPropertyCombiner;
import com.github.tno.gltsdiff.operators.printers.DiffPropertyHtmlPrinter;
import com.github.tno.gltsdiff.operators.printers.HtmlPrinter;
import com.github.tno.gltsdiff.writers.GLTSDotWriter;
import com.google.common.base.Supplier;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.DomainDependency;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.EventType;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.ITMSC;
import nl.esi.pps.tmsc.LifelineSegment;
import nl.esi.pps.tmsc.Message;
import nl.esi.pps.tmsc.MessageControl;
import nl.esi.pps.tmsc.Reply;
import nl.esi.pps.tmsc.Request;

public class TmscWalkinshawMatcher {
	
	public static ITmscMatchResult match(ITMSC leftTmsc, ITMSC rightTmsc, BiMap<Event, Event> eventMatches,
            BiPredicate<? super Event, ? super Event> eventEquivalence) {
		TmscMatchResult result = new TmscMatchResult(leftTmsc, rightTmsc);
    	
		/*
		 *  1. TMSC transformation into LTS graphs
		 *  DiffProperty<T> is a wrapper class that keeps the status (added/removed/unchanged) of each object T (e.g., state/transition)    
		 */
		Map<Event, Integer> leftEvent2State = new HashMap<>();
		Map<Event, Integer> rigthEvent2State = new HashMap<>();
		GLTS<DiffProperty<Event>, DiffProperty<Dependency>> leftGLTS = TransformTMSC2LTS(leftTmsc, leftEvent2State, DiffKind.ADDED);		
		GLTS<DiffProperty<Event>, DiffProperty<Dependency>> rightGLTS = TransformTMSC2LTS(rightTmsc, rigthEvent2State, DiffKind.REMOVED);
		
        /*
         *  2. Instantiation of the state and transition combiners of the two given LTS graphs
         *     The combiners check if two states/transitions are combinable.
         *     eventEquivalence is used for this purpose.
         */
		Combiner<Event> propertyCombiner =  new Combiner<Event>() {
        	/* 
        	 * This function checks if two states, each of which associated with one of the given events, are combinable.
        	 * This function also incorporates the matched events determined by the Isomorphism check to avoid 
        	 * unnecessary matchings by Walkinshaw algorithm.
        	 */
			@Override
			protected boolean computeAreCombinable(Event left, Event right) {
				
				//Stop the process if the either of left and right events are already matched with another event.
				
				if(eventMatches.containsKey(left)) {
					if(eventMatches.get(left).equals(right))
						return true;
					else
						return false;
				}
				else {
					if(eventMatches.containsValue(right))
						return false;
				}
				
				//Check if the two given events are equivalent
				
				return eventEquivalence.test(left, right);
			}
			
			@Override
			protected Event computeCombination(Event left, Event right) {
				return left;
			}
			
			@Override
			public boolean areAlreadyMatched(Event left, Event right) {
				if(eventMatches.containsKey(left))
					if(eventMatches.get(left).equals(right))
						return true;
				return false;
			}
		};
		
        DiffPropertyCombiner<Event> statePropertyCombiner = new DiffPropertyCombiner<Event>(propertyCombiner);
	  
		   
        DiffPropertyCombiner<Dependency> transitionPropertyCombiner = new DiffPropertyCombiner<Dependency>(new Combiner<Dependency>() {
        	
        	/* 
        	 * This function checks if two transitions, each of which associated with one of the given dependencies, are combinable.
        	 * This function also incorporates the matched events determined by the Isomorphism check to avoid 
        	 * unnecessary matchings by Walkinshaw algorithm.
        	 */
			@Override
			protected boolean computeAreCombinable(Dependency left, Dependency right) {
				return propertyCombiner.areCombinable(left.getSource(), right.getSource()) && propertyCombiner.areCombinable(left.getTarget(), right.getTarget());
			}

			@Override
			protected Dependency computeCombination(Dependency left, Dependency right) {
				return left;
			}
			
			@Override
			public boolean areAlreadyMatched(Dependency left, Dependency right) {
				return propertyCombiner.areAlreadyMatched(left.getSource(), right.getSource()) && propertyCombiner.areAlreadyMatched(left.getTarget(), right.getTarget());
			}
		});

        /*
         *  3. Instantiation of the similarity scoring algorithm
         */
		
        SimilarityScorer<DiffProperty<Event>, DiffProperty<Dependency>, GLTS<DiffProperty<Event>, DiffProperty<Dependency>>> similarityScorer = new WalkinshawLocalGLTSScorer<>(statePropertyCombiner, transitionPropertyCombiner, 1);

        /*
         *  4. Deriving the matched events using the graph matching algorithm(s)
         */

		Matcher<DiffProperty<Event>, DiffProperty<Dependency>, GLTS<DiffProperty<Event>, DiffProperty<Dependency>>> matcher = new WalkinshawGLTSMatcher<>(similarityScorer, statePropertyCombiner, transitionPropertyCombiner);
		
		Map<State<DiffProperty<Event>>, State<DiffProperty<Event>>> matchStates = matcher.compute(leftGLTS,rightGLTS);
		
		//Translate the matched states into the matched events 
		for(Map.Entry<State<DiffProperty<Event>>, State<DiffProperty<Event>>> entry : matchStates.entrySet()) {
			result.addMatch(entry.getKey().getProperty().getProperty(), entry.getValue().getProperty().getProperty());
		}
		result.setMatchPercentage((double) result.getDependencyMatches().size() * 2.0 / (leftTmsc.getDependencies().size()+rightTmsc.getDependencies().size()));
				
		/*
		 *  5. Merging the two LTS graphs
		 *     This step is essential for deriving the corresponding changes amongst two given TMSCs. 
		 */
		
		// The object "instantiator" is used in the object "merging", needed for creating an empty LTS graph using the function get().
     	Supplier<GLTS<DiffProperty<Event>, DiffProperty<Dependency>>> instantiator = new Supplier<GLTS<DiffProperty<Event>,DiffProperty<Dependency>>>() {
			 
			@Override
			public GLTS<DiffProperty<Event>, DiffProperty<Dependency>> get() {
				GLTS<DiffProperty<Event>, DiffProperty<Dependency>> glts = new GLTS<DiffProperty<Event>,DiffProperty<Dependency>>();
				return glts;
			}
		};
		
		DefaultMerger<DiffProperty<Event>, DiffProperty<Dependency>, GLTS<DiffProperty<Event>, DiffProperty<Dependency>>> merging = new DefaultMerger<>(statePropertyCombiner, transitionPropertyCombiner, instantiator);
		GLTS<DiffProperty<Event>, DiffProperty<Dependency>> mergedLTS = merging.merge(leftGLTS, rightGLTS, matchStates);
		
		/*
		 * 5.1 (optional) printing the merged LTS graph in dot format
		 * 	   eventPrinter and depPrinter are the format of labels of states and transitions which are written by 
		 * 	   statePrinter and tranPrinter, respectively.
		 */
		
		HtmlPrinter<Event> eventPrinter = event -> event.getLifeline().getExecutor().getName()+"<br/>"+event.getFunction().getName()+"<br/>"+ EventType.valueOf(event).name().toLowerCase();
		HtmlPrinter<DiffProperty<Event>> diffEventPrinter = new DiffPropertyHtmlPrinter<>(eventPrinter);
		HtmlPrinter<State<DiffProperty<Event>>> statePrinter = state -> diffEventPrinter.print(state.getProperty());
		
		HtmlPrinter<Dependency> depPrinter = Dependency -> getLabel(Dependency);
		HtmlPrinter<DiffProperty<Dependency>> diffDepPrinter = new DiffPropertyHtmlPrinter<>(depPrinter);
		HtmlPrinter<Transition<DiffProperty<Event>, DiffProperty<Dependency>>> tranPrinter = transition -> diffDepPrinter.print(transition.getProperty());
			
		GLTSDotWriter<DiffProperty<Event>, DiffProperty<Dependency>, GLTS<DiffProperty<Event>, DiffProperty<Dependency>>> diffDotprinter = new GLTSDotWriter<>(statePrinter, tranPrinter);
		
		try {
			OutputStream mergeStream = new FileOutputStream("merge.dot");
			diffDotprinter.write(mergedLTS, mergeStream);
			OutputStream leftStream = new FileOutputStream("left.dot");
			diffDotprinter.write(leftGLTS, leftStream);
			OutputStream rightStream = new FileOutputStream("right.dot");
			diffDotprinter.write(rightGLTS, rightStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
    }
    
    public static GLTS<DiffProperty<Event>, DiffProperty<Dependency>> TransformTMSC2LTS(ITMSC tmsc, Map<Event, Integer> event2StateID, DiffKind diffkind) {
		
		BiMap<Event, State<DiffProperty<Event>>> event2State = HashBiMap.create();

    	GLTS<DiffProperty<Event>, DiffProperty<Dependency>> glts = new GLTS<DiffProperty<Event>,DiffProperty<Dependency>>();
    	
    	for(Event S: tmsc.getEvents()) {
    		DiffProperty<Event> diffState = new DiffProperty<Event>(S, diffkind); 
    		State<DiffProperty<Event>> newState = glts.addState(diffState);
    		event2State.put(S, newState);
    		event2StateID.put(S, newState.getId());
    	}
    	
    	for(Dependency t: tmsc.getDependencies()) {
    		State<DiffProperty<Event>> srcState = event2State.get(t.getSource());
    		State<DiffProperty<Event>> dstState = event2State.get(t.getTarget());
    		DiffProperty<Dependency> diffDependency = new DiffProperty<Dependency>(t, diffkind); 
    		glts.addTransition(srcState, diffDependency, dstState);
    	}
		
    	return glts;
	} 		

    /**
	 * Computes the String label of a TMSC dependency, used for converting a TMSC to an LTS
	 * graph that is used by the gLTSdiff algorithms.
	 *  
	 * @param d the dependency to compute the label for
	 * @return a label string for the dependency
	 */
	public static String getLabel(Dependency d) {
		String type = "";
		if (d instanceof DomainDependency) {
			type = "domain";
		} else if (d instanceof Execution) {
			type = "execution";
		} else if (d instanceof LifelineSegment) {
			type = "lifelinesegment";
		} else if (d instanceof Request) {
			type = "request";
		} else if (d instanceof Message) {
			type = "Message";
		} else if (d instanceof MessageControl) {
			type = "MessageControl";
		} else if (d instanceof Reply) {
			type = "reply";
		}
		if(type == "") System.out.println("empty type!"); 
		return type;
	}

}
