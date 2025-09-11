/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.analysis;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.lsat.common.emf.validation.EValidatorUtil;
import org.osgi.framework.BundleContext;

import nl.esi.pps.tmsc.TmscPackage;
import nl.esi.pps.tmsc.analysis.rootcause.RootCauseValidator;

/**
 * The activator class controls the plug-in life cycle
 */
public class TmscAnalysisPlugin extends Plugin {
	// The plug-in ID
	public static final String PLUGIN_ID = "nl.esi.pps.tmsc.analysis";

	// The shared instance
	private static TmscAnalysisPlugin plugin;

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		EValidatorUtil.registerValidations(TmscPackage.eINSTANCE, new RootCauseValidator());
	}

	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static TmscAnalysisPlugin getDefault() {
		return plugin;
	}
}