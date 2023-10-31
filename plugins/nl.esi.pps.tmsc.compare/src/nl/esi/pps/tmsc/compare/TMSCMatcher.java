/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.compare;

import java.util.Map;
import java.util.function.BiPredicate;

import com.google.common.collect.BiMap;

import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.ITMSC;

/**
 * This is the access point for the TMSC comparison functionality and provides different matcher algorithms.
 */
public class TMSCMatcher {
	/**
	 * Computes commonalities between TMSCs, using the Isomorphism algorithm.
	 * 
	 * The input TMSCs are compared to each-other and dependencies that are common
	 * in both are returned as a Map where the common dependencies of the left are
	 * the keys and their right equivalents are the values.
	 * 
	 * @see TmscIsomorphismMatcher#match(ITMSC, ITMSC, BiMap, BiPredicate)
	 */
	public static Map<Dependency, Dependency> matchIsomorphic(ITMSC leftTmsc, ITMSC rightTmsc,
			BiPredicate<? super Event, ? super Event> equivalence) {
		BiMap<Event, Event> matchedEvents = TmscIsomorphismMatcher.discoverEventMatches(leftTmsc, rightTmsc, equivalence);
		// TODO: Typically we create a TMSC from a Metric instance. 
		// These instances know their from and to events and as such these events can be considered equivalent 
		// and thus fed to the matcher below (as an alternative to the discovery code above)
		ITmscMatchResult matchResult = TmscIsomorphismMatcher.match(leftTmsc, rightTmsc, matchedEvents, equivalence);
		return matchResult.getDependencyMatches();
	}
}
