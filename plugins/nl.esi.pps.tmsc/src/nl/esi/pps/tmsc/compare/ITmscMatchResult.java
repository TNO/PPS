/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.compare;

import java.util.regex.MatchResult;

import com.google.common.collect.BiMap;
import com.google.common.collect.Maps;

import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.ITMSC;

public interface ITmscMatchResult {
	/**
	 * Returns the completeness of the match as a percentage, optionally
	 * {@code null} if completeness is not known.
	 * 
	 * @return the completeness of the match as a percentage
	 */
	Double getMatchPercentage();

	/**
	 * Returns {@code true} if the left and right TMSC can be considered equal.
	 * 
	 * @return {@code true} if the {@link #getMatchPercentage() match percentage} is
	 *         known and equal to 1, {@code false} otherwise.
	 */
	boolean isFullMatch();

	boolean containsRightMatch(Event left);

	Event getRightMatch(Event left);

	Dependency getRightMatch(Dependency left);

	boolean containsLeftMatch(Event right);

	Event getLeftMatch(Event right);

	Dependency getLeftMatch(Dependency right);

	/**
	 * Returns an {@link Maps#unmodifiableBiMap(BiMap) unmodifiable} {@link BiMap}
	 * of matches where the key is an {@link Event} of the {@code left} TMSC and its
	 * value is a matched {@link Event} of the {@code right} TMSC.<br>
	 * Query operations on the returned bimap "readthrough" to this
	 * {@link MatchResult}, and attempts to modify the returned map, whether direct
	 * or via its collection views, result in an
	 * {@link UnsupportedOperationException}.
	 */
	BiMap<Event, Event> getEventMatches();

	/**
	 * Returns an {@link Maps#unmodifiableBiMap(BiMap) unmodifiable} {@link BiMap}
	 * of matches where the key is a {@link Dependency} of the {@code left} TMSC and
	 * its value is a matched {@link Dependency} of the {@code right} TMSC.<br>
	 * The returned bimap uses a copy of this {@link MatchResult}, and attempts to
	 * modify the returned map, whether direct or via its collection views, result
	 * in an {@link UnsupportedOperationException}.
	 */
	BiMap<Dependency, Dependency> getDependencyMatches();

	ITmscMatchResult applyTo(ITMSC left, ITMSC right);
}