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

import static org.eclipse.lsat.common.queries.QueryableIterable.from;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.regex.MatchResult;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;

import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.ITMSC;

public class TmscMatchResult implements ITmscMatchResult {
	public static final TmscMatchResult EMPTY = new TmscMatchResult(null, null);
	
	private final ITMSC leftTmsc;
	private final ITMSC rightTmsc;
	private final HashBiMap<Event, Event> matches;
	private final HashSet<Event> invalid = new HashSet<>();
	
	private Double matchPercentage;
	
	public TmscMatchResult(ITMSC left, ITMSC right) {
		leftTmsc = left;
		rightTmsc = right;
		matches = HashBiMap.create();
	}
	
	public void addMatch(Event left, Event right) throws IllegalArgumentException {
		if (invalid.contains(left) || invalid.contains(right)) {
			throw new IllegalArgumentException("Match is already marked as invalid");
		}
		matches.put(left, right);
	}
	
	/**
	 * Marks the match as invalid, removing it from the result and preventing it
	 * from being added again using {@link TmscMatchResult#addMatch(Event, Event)}.
	 */
	public void invalidateMatch(Event left, Event right) {
		invalid.add(left);
		invalid.add(right);
		Event oldLeft = matches.remove(left);
		if (oldLeft != null) {
			invalid.add(oldLeft);
		}
		Event oldRight = matches.inverse().remove(right);
		if (oldRight != null) {
			invalid.add(oldRight);
		}
	}
	
	public void setMatchPercentage(double percentage) {
		if (percentage < 0 || percentage > 1) {
			throw new IllegalArgumentException("Match percentage should be a real number between 0 an 1.");
		}
		if (matchPercentage != null) {
			throw new IllegalStateException("Match percentage can be set only once!");
		}
		matchPercentage = percentage;
	}
	
	/**
	 * Returns the completeness of the match as a percentage, optionally
	 * {@code null} if completeness is not known.
	 * 
	 * @return the completeness of the match as a percentage
	 */
	@Override
	public Double getMatchPercentage() {
		return matchPercentage;
	}
	
	/**
	 * Returns {@code true} if the left and right TMSC can be considered equal.
	 * 
	 * @return {@code true} if the {@link #getMatchPercentage() match percentage} is
	 *         known and equal to 1, {@code false} otherwise.
	 */
	@Override
	public boolean isFullMatch() {
		return invalid.isEmpty() && matchPercentage != null && matchPercentage >= 1;
	}
	
	@Override
	public boolean containsRightMatch(Event left) {
		return matches.containsKey(left);
	}

	@Override
	public Event getRightMatch(Event left) {
		return matches.get(left);
	}

	@Override
	public Dependency getRightMatch(Dependency left) {
		final Event rightSource = getRightMatch(left.getSource());
		if (rightSource == null) {
			return null;
		}
		final Event rightTarget = getRightMatch(left.getTarget());
		if (rightTarget == null) {
			return null;
		}
		LinkedList<Dependency> rightMatches = from(rightTmsc.getOutgoingDependencies(rightSource))
				.select(right -> right.getTarget() == rightTarget)
				.select(right -> DependencyEquivalence.equalsType(left, right))
				.asList();
		// Omit ambiguities from the result
		return rightMatches.size() == 1 ? rightMatches.getFirst() : null;
	}

	@Override
	public boolean containsLeftMatch(Event right) {
		return matches.containsValue(right);
	}

	@Override
	public Event getLeftMatch(Event right) {
		return matches.inverse().get(right);
	}

	@Override
	public Dependency getLeftMatch(Dependency right) {
		final Event leftSource = getLeftMatch(right.getSource());
		if (leftSource == null) {
			return null;
		}
		final Event leftTarget = getLeftMatch(right.getTarget());
		if (leftTarget == null) {
			return null;
		}
		LinkedList<Dependency> leftMatches = from(leftTmsc.getOutgoingDependencies(leftSource))
				.select(left -> left.getTarget() == leftTarget)
				.select(left -> DependencyEquivalence.equalsType(left, right))
				.asList();
		// Omit ambiguities from the result
		return leftMatches.size() == 1 ? leftMatches.getFirst() : null;
	}
	
	/**
	 * Returns an {@link Maps#unmodifiableBiMap(BiMap) unmodifiable} {@link BiMap}
	 * of matches where the key is an {@link Event} of the {@code left} TMSC and its
	 * value is a matched {@link Event} of the {@code right} TMSC.<br>
	 * Query operations on the returned bimap "readthrough" to this
	 * {@link MatchResult}, and attempts to modify the returned map, whether direct
	 * or via its collection views, result in an
	 * {@link UnsupportedOperationException}.
	 */
	@Override
	public BiMap<Event, Event> getEventMatches() {
		return Maps.unmodifiableBiMap(matches);
	}
	
	/**
	 * Returns an {@link Maps#unmodifiableBiMap(BiMap) unmodifiable} {@link BiMap}
	 * of matches where the key is a {@link Dependency} of the {@code left} TMSC and
	 * its value is a matched {@link Dependency} of the {@code right} TMSC.<br>
	 * The returned bimap uses a copy of this {@link MatchResult}, and attempts to
	 * modify the returned map, whether direct or via its collection views, result
	 * in an {@link UnsupportedOperationException}.
	 */
	@Override
	public BiMap<Dependency, Dependency> getDependencyMatches() {
		HashBiMap<Dependency, Dependency> dependencyMatches = HashBiMap.create(
				Math.min(leftTmsc.getDependencies().size(), rightTmsc.getDependencies().size()));
		for (Dependency leftDependency : leftTmsc.getDependencies()) {
			Dependency rightDependency = getRightMatch(leftDependency);
			if (rightDependency != null) {
				dependencyMatches.put(leftDependency, rightDependency);
			}
		}
		return Maps.unmodifiableBiMap(dependencyMatches);
	}
	
	@Override
	public ITmscMatchResult applyTo(ITMSC left, ITMSC right) {
		if (left == leftTmsc && right == rightTmsc) {
			return this;
		}
		TmscMatchResult result = new TmscMatchResult(left, right);
		result.matches.putAll(this.matches);
		return result;
	}
}
