/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.provider.ext.ui;

import java.util.Collection;

import org.eclipse.jface.viewers.IContentProvider;

import nl.esi.pps.tmsc.provider.dataanalysis.IDataAnalysisItemContentProvider;

/**
 * @see IDataAnalysisItemContentProvider
 */
public interface IDataAnalysisContentProvider extends IContentProvider {
	/**
	 * @see IDataAnalysisItemContentProvider#getConfigurations(Object)
	 */
	Collection<String> getConfigurations(Object object);

	/**
	 * @see IDataAnalysisItemContentProvider#getTitle(Object, String)
	 */
	String getTitle(Object object, String configuration);

	/**
	 * @see IDataAnalysisItemContentProvider#getBudget(Object, String)
	 */
	Long getBudget(Object object, String configuration);

	/**
	 * @see IDataAnalysisItemContentProvider#getSiblings(Object, String)
	 */
	Iterable<?> getSiblings(Object object, String configuration);

	/**
	 * @see IDataAnalysisItemContentProvider#getDuration(Object, Object, String)
	 */
	Long getDuration(Object object, Object sibling, String configuration);
}
