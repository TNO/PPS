/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.emf.ui;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class Activator extends AbstractUIPlugin {
	public static final String IMAGE_REFRESH = Activator.class.getPackage().getName() + ".IMAGE_REFRESH";

	public static final String IMAGE_COLLAPSE_ALL = Activator.class.getPackage().getName() + ".IMAGE_COLLAPSE_ALL";

	public static final String IMAGE_BOOKMARK_ADD = Activator.class.getPackage().getName() + ".IMAGE_BOOKMARK_ADD";
	
	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}		

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}
	
	public static ImageDescriptor getDescriptor(String key) {
		return getDefault().getImageRegistry().getDescriptor(key);
	}

	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {
		super.initializeImageRegistry(reg);

		reg.put(IMAGE_REFRESH,
				ImageDescriptor.createFromURL(FileLocator.find(getBundle(), new Path("icons/refresh.gif"), null)));

		reg.put(IMAGE_COLLAPSE_ALL,
				ImageDescriptor.createFromURL(FileLocator.find(getBundle(), new Path("icons/collapse_all.png"), null)));

		reg.put(IMAGE_BOOKMARK_ADD,
				ImageDescriptor.createFromURL(FileLocator.find(getBundle(), new Path("icons/bookmark_add.png"), null)));
	}
}
