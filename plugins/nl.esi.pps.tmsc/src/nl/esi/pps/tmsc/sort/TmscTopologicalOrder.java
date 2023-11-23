/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.sort;

import java.util.function.Function;

import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.ITMSC;
import nl.esi.pps.tmsc.TMSC;

/**
 * A utility class to iterate over the {@link TMSC#getEvents() events} or
 * {@link TMSC#getDependencies() dependencies} of an {@link TMSC} in
 * <a href="https://en.wikipedia.org/wiki/Topological_sorting">topological
 * order</a>.
 * 
 * @param <E> the type of element to iterate
 */
public class TmscTopologicalOrder<E> implements Iterable<E> {
	private final ITMSC tmsc;
	private final Function<ITMSC, TopologicalOrderIterator<E>> factory;

	/**
	 * Returns the events of a TMSC in topological order.
	 */
	public static TmscTopologicalOrder<Event> getEventsInTopologicalOrder(ITMSC tmsc) {
		return new TmscTopologicalOrder<Event>(tmsc, EventTopologicalOrder::new);
	}

	/**
	 * Returns the events of a TMSC in reverse topological order.
	 */
	public static TmscTopologicalOrder<Event> getEventsInReverseTopologicalOrder(ITMSC tmsc) {
		return new TmscTopologicalOrder<Event>(tmsc, EventReverseTopologicalOrder::new);
	}

	/**
	 * Returns the dependencies of a TMSC in topological order.
	 */
	public static TmscTopologicalOrder<Dependency> getDependenciesInTopologicalOrder(ITMSC tmsc) {
		return new TmscTopologicalOrder<Dependency>(tmsc, DependencyTopologicalOrder::new);
	}

	/**
	 * Returns the dependencies of a TMSC in reverse topological order.
	 */
	public static TmscTopologicalOrder<Dependency> getDependenciesInReverseTopologicalOrder(ITMSC tmsc) {
		return new TmscTopologicalOrder<Dependency>(tmsc, DependencyReverseTopologicalOrder::new);
	}

	private TmscTopologicalOrder(ITMSC tmsc, Function<ITMSC, TopologicalOrderIterator<E>> factory) {
		this.tmsc = tmsc;
		this.factory = factory;
	}

	@Override
	public TopologicalOrderIterator<E> iterator() {
		return factory.apply(tmsc);
	}
}
