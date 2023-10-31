/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.common.ide.ui.views.dataanalysis;

import org.eclipse.ui.part.IPageBookViewPage;

public interface IDataAnalysisPage extends IPageBookViewPage {
	void setPinned(boolean pinned);
	
	default void refresh() {
		// Subclasses that support refresh can override this method
	}
}
