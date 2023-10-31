/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.emf.properties.xtend;

/**
 * A {@link CategoryProvider} allows the API user to declare a
 * {@link PersistedProperty} per instance of a {@code context}.
 *
 * @param <T> the type of the context
 */
@FunctionalInterface
public interface CategoryProvider<T> {
	/**
	 * Returns the property category to use for {@code context}, {@code null} or
	 * {@link String#isEmpty() empty string} will omit the category.
	 * 
	 * @param context the context that defines the property category.
	 * @return the property category to use for {@code context}, should not contain
	 *         a '/' character.
	 */
	String getCategory(T context);
}
