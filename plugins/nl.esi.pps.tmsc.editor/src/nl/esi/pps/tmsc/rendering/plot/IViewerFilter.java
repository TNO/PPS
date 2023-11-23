/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.rendering.plot;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

/**
 * A viewer filter is used by a structured viewer to extract a subset of
 * elements provided by its content provider.
 *
 * @see IStructuredContentProvider
 * @see StructuredViewer
 * @see ViewerFilter
 */
public interface IViewerFilter {
	/**
	 * Returns whether the given element makes it through this filter.
	 *
	 * @param viewer        the viewer
	 * @param parentElement the parent element
	 * @param element       the element
	 * @return <code>true</code> if element is included in the filtered set, and
	 *         <code>false</code> if excluded
	 * @see ViewerFilter#select(Viewer, Object, Object)
	 */
	boolean select(Viewer viewer, Object parentElement, Object element);
}
