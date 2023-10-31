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

import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.ScopedTMSC;
import nl.esi.pps.tmsc.TMSC;
import nl.esi.pps.tmsc.util.ScopedTmscCopier;
import nl.esi.pps.tmsc.util.TmscQueries;

public class TMSCComparison {
	public static void compare(TMSC leftTmsc, TMSC rightTmsc, String commonId,
			BiPredicate<? super Event, ? super Event> equivalence) {
		Map<Dependency, Dependency> matchResult = TMSCMatcher.matchIsomorphic(leftTmsc, rightTmsc, equivalence);

		leftTmsc.getChildScopes().add(TmscQueries.createScopedTMSC(matchResult.keySet(), commonId));
		makeRelativeTiming(leftTmsc);

		rightTmsc.getChildScopes().add(TmscQueries.createScopedTMSC(matchResult.values(), commonId));
		makeRelativeTiming(rightTmsc);
	}
	
	public static void makeRelativeTiming(TMSC tmsc) {
		FullScopeTMSC fullScope = tmsc.getFullScope();
		if (tmsc instanceof ScopedTMSC) {
			ScopedTmscCopier.deriveStartEndTime((ScopedTMSC) tmsc);
		}
		TmscQueries.shiftTime(fullScope, -fullScope.getStartTime());
		fullScope.setEpochTime(false);
	}
}
