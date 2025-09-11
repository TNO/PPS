/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.analysis.prototypes.ui;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import nl.esi.pps.tmsc.rendering.plot.ScopesRenderingStrategy;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		
		// FIXME: Added line to avoid SWT error
		@SuppressWarnings("unused")
		String id = ScopesRenderingStrategy.ID;
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

	public static String getPluginID() {
		return context.getBundle().getSymbolicName();
	}
}
