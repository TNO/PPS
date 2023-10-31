/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.common.emf.ui.views.contentoutline;

import org.eclipse.jface.viewers.ISelectionProvider;

/**
 * Marker interface To put on viewers to tell the Editor that the outline selection should be delegated to the view.
 */
public interface OutlineSelectionShadow extends ISelectionProvider {
}
