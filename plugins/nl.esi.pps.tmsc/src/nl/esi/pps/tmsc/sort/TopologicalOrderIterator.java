/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.sort;

import java.util.Iterator;

import org.eclipse.xtext.xbase.lib.IterableExtensions;

import nl.esi.pps.tmsc.TMSC;

/**
 * An interface class to iterate over the {@link TMSC#getEvents() events} or
 * {@link TMSC#getDependencies() dependencies} of an {@link TMSC} in
 * <a href="https://en.wikipedia.org/wiki/Topological_sorting">topological
 * order</a>.
 * 
 * @param <E> the type of element to iterate
 */
public interface TopologicalOrderIterator<E> extends Iterator<E> {
	/**
	 * Returns all elements that are candidate to be returned upon the first call to
	 * {@link #next() next} of this {@link Iterator iterator}. Typically the
	 * {@link IterableExtensions#head(Iterable) head} of these elements will be
	 * {@link #consume(Object) consumed} when calling {@link #next()}, but a user
	 * may choose to {@link #consume(Object)} any of its elements instead.
	 * 
	 * @return all elements that are candidate to be returned on the first call to
	 *         {@link #next()} of this {@link Iterator iterator}.
	 */
	Iterator<E> getEnabledElements();

	/**
	 * The topological order can be controlled by using this method instead of
	 * calling {@link #next()}. Only dependencies that are returned by
	 * {@link #getEnabledElements()} may be consumed. In all other cases, this
	 * method throws an {@link IllegalArgumentException}.
	 * 
	 * @return the elements that became {@link #getEnabledElements() enabled} due to the
	 *         consumption of {@code element}.
	 */
	Iterator<E> consume(E element);
}
