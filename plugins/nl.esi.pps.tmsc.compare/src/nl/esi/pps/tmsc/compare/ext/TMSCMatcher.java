package nl.esi.pps.tmsc.compare.ext;

import java.util.function.BiPredicate;

import org.eclipse.xtext.xbase.lib.StringExtensions;

import com.google.common.collect.BiMap;

import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.ITMSC;
import nl.esi.pps.tmsc.TMSC;
import nl.esi.pps.tmsc.compare.ITmscMatchResult;
import nl.esi.pps.tmsc.compare.TmscIsomorphismMatcher;
import nl.esi.pps.tmsc.compare.TmscServiceMatcher;
import nl.esi.pps.tmsc.compare.TmscWalkinshawMatcher;
import nl.esi.pps.tmsc.util.TmscQueries;

/**
 * This is the access point for the TMSC comparison functionality and provides different matcher algorithms.
 */

public enum TMSCMatcher{
	/**
	 * Computes commonalities between TMSCs, using the Isomorphism algorithm.
	 * 
	 * The input TMSCs are compared to each-other and dependencies that are common
	 * in both are returned as a Map where the common dependencies of the left are
	 * the keys and their right equivalents are the values.
	 * 
	 * @see TmscIsomorphismMatcher#match(ITMSC, ITMSC, BiMap, BiPredicate)
	 */
	Isomorphism {
		@Override
		public ITmscMatchResult match(TMSC leftTmsc, TMSC rightTmsc,
				BiPredicate<? super Event, ? super Event> equivalence) {
			long start=System.nanoTime();

			BiMap<Event, Event> matchedEvents = TmscIsomorphismMatcher.discoverEventMatches(leftTmsc, rightTmsc, equivalence);
			ITmscMatchResult matchResult = TmscIsomorphismMatcher.match(leftTmsc, rightTmsc, matchedEvents,
					equivalence);

			long end=System.nanoTime();

			System.err.println("Isomorphism matcher:");
			System.err.println("T1: |V|="+leftTmsc.getEvents().size()+", |E|="+leftTmsc.getDependencies().size());
			System.err.println("    |not matched deps|="+(leftTmsc.getDependencies().size()-matchResult.getDependencyMatches().size()));
			System.err.println("T2: |V|="+rightTmsc.getEvents().size()+", |E|="+rightTmsc.getDependencies().size());
			System.err.println("    |not matched deps|="+(rightTmsc.getDependencies().size()-matchResult.getDependencyMatches().size()));
			System.err.println("Number of matched events (dependencies)= " + matchResult.getEventMatches().size() + " (" + matchResult.getDependencyMatches().size()+")");
			System.err.println("Run-time = "+(end-start)/1000000+"ms\n");

			return matchResult;
		}
	},

	/**
	 * Computes commonalities between TMSCs, using the Walkinshaw algorithm.
	 * 
	 * The input TMSCs are compared to each-other and dependencies that are common
	 * in both are returned as a Map where the common dependencies of the left are
	 * the keys and their right equivalents are the values.
	 */
	Walkinshaw {
		@Override
		public ITmscMatchResult match(TMSC leftTmsc, TMSC rightTmsc,
			BiPredicate<? super Event, ? super Event> equivalence) {
			long start = System.nanoTime();

			BiMap<Event, Event> matchedEvents = TmscIsomorphismMatcher.discoverEventMatches(leftTmsc, rightTmsc, equivalence);
			ITmscMatchResult matchResult = TmscWalkinshawMatcher.match(leftTmsc, rightTmsc, matchedEvents, equivalence);

			long end = System.nanoTime();

			System.err.println("Walkinshaw matcher:");
			System.err.println("T1: |V|=" + leftTmsc.getEvents().size() + ", |E|=" + leftTmsc.getDependencies().size());
			System.err.println("    |not matched deps|=" + (leftTmsc.getDependencies().size() - matchResult.getDependencyMatches().size()));
			System.err.println("T2: |V|=" + rightTmsc.getEvents().size() + ", |E|=" + rightTmsc.getDependencies().size());
			System.err.println("    |not matched deps|=" + (rightTmsc.getDependencies().size() - matchResult.getDependencyMatches().size()));
			System.err.println("Number of matched events (dependencies)= " + matchResult.getEventMatches().size() + " (" + matchResult.getDependencyMatches().size()+")");
			System.err.println("Run-time = " + (end-start)/1000000 + "ms\n");

			return matchResult;
		}
	},

	/**
	 * Computes commonalities between TMSCs, using the service-matcher algorithm.
	 * 
	 * The input TMSCs are compared to each-other and dependencies that are common
	 * in both are returned as a Map where the common dependencies of the left are
	 * the keys and their right equivalents are the values.
	 */
	Service {
		@Override
		public ITmscMatchResult match(TMSC leftTmsc, TMSC rightTmsc,
			BiPredicate<? super Event, ? super Event> equivalence) {
			long start = System.nanoTime();

			ITmscMatchResult matchResult = TmscServiceMatcher.match(leftTmsc, rightTmsc, equivalence);

			long end = System.nanoTime();

			System.err.println("Service matcher:");
			System.err.println("T1: |V|=" + leftTmsc.getEvents().size() + ", |E|=" + leftTmsc.getDependencies().size());
			System.err.println("    |not matched deps|=" + (leftTmsc.getDependencies().size() - matchResult.getDependencyMatches().size()));
			System.err.println("T2: |V|=" + rightTmsc.getEvents().size() + ", |E|=" + rightTmsc.getDependencies().size());
			System.err.println("    |not matched deps|=" + (rightTmsc.getDependencies().size() - matchResult.getDependencyMatches().size()));
			System.err.println("Number of matched events (dependencies)= " + matchResult.getEventMatches().size() + " (" + matchResult.getDependencyMatches().size()+")");
			System.err.println("Run-time = " + (end-start)/1000000 + "ms\n");

			return matchResult;
		}
	},
	
	/**
	 * Computes commonalities between TMSCs, using the Hybrid algorithms, composed of any algorithms 
	 * 
	 * The input TMSCs are compared to each-other and dependencies that are common
	 * in both are returned as a Map where the common dependencies of the left are
	 * the keys and their right equivalents are the values.
	 */
	Service_Isomorphism {
	@Override
		public ITmscMatchResult match(TMSC leftTmsc, TMSC rightTmsc,
			BiPredicate<? super Event, ? super Event> equivalence) {
			long start = System.nanoTime();
			ITmscMatchResult serviceMatchResult = TmscServiceMatcher.match(leftTmsc, rightTmsc, equivalence);
			long end = System.nanoTime();

			long start2 = System.nanoTime();
			ITmscMatchResult matchResult = TmscIsomorphismMatcher.match(leftTmsc, rightTmsc, serviceMatchResult.getEventMatches(), equivalence);
			long end2 = System.nanoTime();
		
			System.err.println("Hybrid matcher:");
			System.err.println("T1: |V|=" + leftTmsc.getEvents().size() + ", |E|=" + leftTmsc.getDependencies().size());
			System.err.println("    |not matched deps|=" + (leftTmsc.getDependencies().size() - matchResult.getDependencyMatches().size()));
			System.err.println("T2: |V|=" + rightTmsc.getEvents().size() + ", |E|=" + rightTmsc.getDependencies().size());
			System.err.println("    |not matched deps|=" + (rightTmsc.getDependencies().size() - matchResult.getDependencyMatches().size()));
			System.err.println("Number of matched events (dependencies) by Service matcher= " + serviceMatchResult.getEventMatches().size()+" ("+serviceMatchResult.getDependencyMatches().size()+"), "+"Run-time = " + (end-start)/1000000 + " ms");
			System.err.println("Number of matched events (dependencies) by Service + Isomorphism matcher= " + matchResult.getEventMatches().size()+" ("+matchResult.getDependencyMatches().size()+"), "+"Run-time = " + (end2-start2)/1000000 + " ms\n");
			System.err.println("Run-time = " + (end-start+end2-start2)/1000000 + "ms\n");

			return matchResult;
		}
	},
	
	Service_Walkinshaw {
	@Override
		public ITmscMatchResult match(TMSC leftTmsc, TMSC rightTmsc,
			BiPredicate<? super Event, ? super Event> equivalence) {
			long start = System.nanoTime();
			ITmscMatchResult serviceMatchResult = TmscServiceMatcher.match(leftTmsc, rightTmsc, equivalence);
			long end = System.nanoTime();

			long start2 = System.nanoTime();
			ITmscMatchResult matchResult = TmscWalkinshawMatcher.match(leftTmsc, rightTmsc, serviceMatchResult.getEventMatches(), equivalence);
			long end2 = System.nanoTime();
		
			System.err.println("Hybrid matcher:");
			System.err.println("T1: |V|=" + leftTmsc.getEvents().size() + ", |E|=" + leftTmsc.getDependencies().size());
			System.err.println("    |not matched deps|=" + (leftTmsc.getDependencies().size() - matchResult.getDependencyMatches().size()));
			System.err.println("T2: |V|=" + rightTmsc.getEvents().size() + ", |E|=" + rightTmsc.getDependencies().size());
			System.err.println("    |not matched deps|=" + (rightTmsc.getDependencies().size() - matchResult.getDependencyMatches().size()));
			System.err.println("Number of matched events (dependencies) by Service matcher= " + serviceMatchResult.getEventMatches().size()+" ("+serviceMatchResult.getDependencyMatches().size()+"), "+"Run-time = " + (end-start)/1000000 + " ms");
			System.err.println("Number of matched events (dependencies) by Service + Walkinshaw matcher= " + matchResult.getEventMatches().size()+" ("+matchResult.getDependencyMatches().size()+"), "+"Run-time = " + (end2-start2)/1000000 + " ms\n");
			System.err.println("Run-time = " + (end-start+end2-start2)/1000000 + "ms\n");

			return matchResult;
		}
	},
	
	Isomorphism_Walkinshaw {
	@Override
		public ITmscMatchResult match(TMSC leftTmsc, TMSC rightTmsc,
			BiPredicate<? super Event, ? super Event> equivalence) {
			long start = System.nanoTime();
			BiMap<Event, Event> matchedEvents = TmscIsomorphismMatcher.discoverEventMatches(leftTmsc, rightTmsc, equivalence);
			ITmscMatchResult isomorphismMatchResult = TmscIsomorphismMatcher.match(leftTmsc, rightTmsc, matchedEvents, equivalence);
			long end = System.nanoTime();

			long start2 = System.nanoTime();
			ITmscMatchResult matchResult =  TmscWalkinshawMatcher.match(leftTmsc, rightTmsc, isomorphismMatchResult.getEventMatches(), equivalence);
			long end2 = System.nanoTime();
		
			System.err.println("Hybrid matcher:");
			System.err.println("T1: |V|=" + leftTmsc.getEvents().size() + ", |E|=" + leftTmsc.getDependencies().size());
			System.err.println("    |not matched deps|=" + (leftTmsc.getDependencies().size() - matchResult.getDependencyMatches().size()));
			System.err.println("T2: |V|=" + rightTmsc.getEvents().size() + ", |E|=" + rightTmsc.getDependencies().size());
			System.err.println("    |not matched deps|=" + (rightTmsc.getDependencies().size() - matchResult.getDependencyMatches().size()));
			System.err.println("Number of matched events (dependencies) by Isomorphism matcher= " + isomorphismMatchResult.getEventMatches().size()+" ("+isomorphismMatchResult.getDependencyMatches().size()+"), "+"Run-time = " + (end-start)/1000000 + " ms");
			System.err.println("Number of matched events (dependencies) by Isomorphism + Walkinshaw matcher= " + matchResult.getEventMatches().size()+" ("+matchResult.getDependencyMatches().size()+"), "+"Run-time = " + (end2-start2)/1000000 + " ms\n");
			System.err.println("Run-time = " + (end-start+end2-start2)/1000000 + "ms\n");

			return matchResult;
		}
	},
	
	Service_Isomorphism_Walkinshaw {
		@Override
			public ITmscMatchResult match(TMSC leftTmsc, TMSC rightTmsc,
				BiPredicate<? super Event, ? super Event> equivalence) {
				long start = System.nanoTime();
				ITmscMatchResult serviceMatchResult = TmscServiceMatcher.match(leftTmsc, rightTmsc, equivalence);
				long end = System.nanoTime();

				long start2 = System.nanoTime();
				ITmscMatchResult isomorphismMatchResult = TmscIsomorphismMatcher.match(leftTmsc, rightTmsc, serviceMatchResult.getEventMatches(), equivalence);
				long end2 = System.nanoTime();
				
				long start3 = System.nanoTime();
				ITmscMatchResult matchResult = TmscWalkinshawMatcher.match(leftTmsc, rightTmsc, isomorphismMatchResult.getEventMatches(), equivalence);
				long end3 = System.nanoTime();
			
				System.err.println("Hybrid matcher:");
				System.err.println("T1: |V|=" + leftTmsc.getEvents().size() + ", |E|=" + leftTmsc.getDependencies().size());
				System.err.println("    |not matched deps|=" + (leftTmsc.getDependencies().size() - matchResult.getDependencyMatches().size()));
				System.err.println("T2: |V|=" + rightTmsc.getEvents().size() + ", |E|=" + rightTmsc.getDependencies().size());
				System.err.println("    |not matched deps|=" + (rightTmsc.getDependencies().size() - matchResult.getDependencyMatches().size()));
				System.err.println("Number of matched events (dependencies) by Service matcher= " + serviceMatchResult.getEventMatches().size()+" ("+serviceMatchResult.getDependencyMatches().size()+"), "+"Run-time = " + (end-start)/1000000 + " ms");
				System.err.println("Number of matched events (dependencies) by Service + Isomorphism matcher= " + matchResult.getEventMatches().size()+" ("+matchResult.getDependencyMatches().size()+"), "+"Run-time = " + (end2-start2)/1000000 + " ms");
				System.err.println("Number of matched events (dependencies) by Service + Isomorphism + Walkinshaw matcher= " + matchResult.getEventMatches().size()+" ("+matchResult.getDependencyMatches().size()+"), "+"Run-time = " + (end3-start3)/1000000 + " ms\n");
				System.err.println("Run-time = " + (end-start+end2-start2+end3-start3)/1000000 + "ms\n");

				return matchResult;
			}
		};
	
	public abstract ITmscMatchResult match(TMSC leftTmsc, TMSC rightTmsc,
			BiPredicate<? super Event, ? super Event> equivalence);
	
	public void diffHighlighter(TMSC leftTmsc, TMSC rightTmsc, ITmscMatchResult matchResult, String postfix) {
		leftTmsc.getChildScopes().add(TmscQueries.createScopedTMSC(matchResult.getDependencyMatches().keySet(), postfix));
		rightTmsc.getChildScopes().add(TmscQueries.createScopedTMSC(matchResult.getDependencyMatches().values(), postfix));
	}
		
	public String getLabel() {
		return StringExtensions.toFirstUpper(name().toLowerCase().replace('_', ' '));
	}
}
