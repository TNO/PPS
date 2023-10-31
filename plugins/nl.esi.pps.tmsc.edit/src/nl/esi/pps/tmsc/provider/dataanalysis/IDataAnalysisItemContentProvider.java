/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.provider.dataanalysis;

import java.util.Set;

// This source file is also used in the developer guide.
// The tags allow asciidoc to only include this file partially and should not be removed!
// tag::developer-guide[]
/**
 * This interface defines the required information to populate the Data Analysis
 * view of the TMSC editor.
 */
public interface IDataAnalysisItemContentProvider {
	/**
	 * The default configuration for data analysis. If your data analysis only
	 * supports a single configuration, its is recommended to use this
	 * configuration.
	 */
	static final String DEFAULT_CONFIGURATION = "Default";

	/**
	 * Returns the supported data analysis configurations for {@code object}.
	 */
	Set<String> getConfigurations(Object object);

	/**
	 * Returns the title of the data analysis for {@code object} in the selected
	 * {@code configuration}.
	 */
	String getTitle(Object object, String configuration);

	/**
	 * Returns the budget of the data analysis for {@code object} in the selected
	 * {@code configuration}, or {@code null} if the budget is not applicable.
	 */
	default Long getBudget(Object object, String configuration) {
		return null;
	}

	/**
	 * Returns the siblings of {@code object} for the selected
	 * {@code configuration}.
	 */
	Iterable<?> getSiblings(Object object, String configuration);

	/**
	 * Returns the duration of {@code sibling} in the selected
	 * {@code configuration}. Please note that {@code sibling} can be any of the
	 * elements as returned by {@link #getSiblings(Object, String)} or the
	 * {@code object} itself.
	 */
	Long getDuration(Object object, Object sibling, String configuration);
}
// end::developer-guide[]
