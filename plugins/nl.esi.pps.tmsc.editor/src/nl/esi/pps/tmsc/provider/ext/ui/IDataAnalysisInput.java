/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.provider.ext.ui;

import java.util.Set;

import nl.esi.pps.tmsc.provider.dataanalysis.IDataAnalysisItemContentProvider;

public interface IDataAnalysisInput {
	/**
	 * Returns the input for data analysis.
	 */
	Object getInput();

	/**
	 * Returns the supported data analysis configurations for this
	 * {@link #getInput() input}.
	 * 
	 * @see IDataAnalysisItemContentProvider#getConfigurations(Object)
	 */
	Set<String> getConfigurations();

	/**
	 * Returns the title of the data analysis for this {@link #getInput() input} in
	 * the selected {@code configuration}.
	 * 
	 * @see IDataAnalysisItemContentProvider#getTitle(Object, String)
	 */
	String getTitle(String configuration);

	/**
	 * Returns the budget of the data analysis for this {@link #getInput() input} in
	 * the selected {@code configuration}, or {@code null} if the budget is not
	 * applicable.
	 * 
	 * @see IDataAnalysisItemContentProvider#getBudget(Object, String)
	 */
	Long getBudget(String configuration);

	/**
	 * Returns the siblings of this {@link #getInput() input} for the selected
	 * {@code configuration}.
	 * 
	 * @see IDataAnalysisItemContentProvider#getSiblings(Object, String)
	 */
	Iterable<?> getSiblings(String configuration);

	/**
	 * Returns the duration of {@code sibling} in the selected
	 * {@code configuration}. Please note that {@code sibling} can be any of the
	 * elements as returned by {@link #getSiblings(String)} or this
	 * {@link #getInput() input} itself.
	 * 
	 * @see IDataAnalysisItemContentProvider#getDuration(Object, Object, String)
	 */
	Long getDuration(Object sibling, String configuration);

	/**
	 * @see IDataAnalysisItemContentProvider#isCategorized(Object, String)
	 */
	boolean isCategorized(String configuration);

	/**
	 * @see IDataAnalysisItemContentProvider#getCategory(Object, Object, String)
	 */
	String getCategory(Object sibling, String configuration);
}
