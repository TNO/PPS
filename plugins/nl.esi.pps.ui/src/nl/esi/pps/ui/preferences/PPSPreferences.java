/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.ui.preferences;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;

public class PPSPreferences {
	static final String PREF_SHOW_ADVANCED_FEATURES = "showAdvancedFeatures";

	private static final String PREFERENCES_NODE = "nl.esi.pps.ui";

	private PPSPreferences() {
		// Empty for utility classes
	}
	
	public static boolean isShowAdvancedFeatures() {
		return getPreferences().getBoolean(PREF_SHOW_ADVANCED_FEATURES, false);
	}
	
	static IEclipsePreferences getPreferences() {
		return InstanceScope.INSTANCE.getNode(PREFERENCES_NODE);
	}
}
