/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.architecture;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class ArchitecturePlugin extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "nl.esi.pps.architecture";

	public static final String ARCHITECTURE_FILE_EXTENSION_XMI = "arch";

	public static final String ARCHITECTURE_FILE_EXTENSION_BINARY_COMPRESSED = "archz";

	// The shared instance
	private static ArchitecturePlugin plugin;

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
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
	public static ArchitecturePlugin getDefault() {
		return plugin;
	}

	public static boolean isArchitectureFileExtension(String extension) {
		return isArchitectureXmiFileExtension(extension) || isArchitectureBinaryCompressedFileExtension(extension);
	}

	public static boolean isArchitectureXmiFileExtension(String extension) {
		return extension == null ? false : extension.equals(ARCHITECTURE_FILE_EXTENSION_XMI);
	}

	public static boolean isArchitectureBinaryCompressedFileExtension(String extension) {
		return extension == null ? false : extension.equals(ARCHITECTURE_FILE_EXTENSION_BINARY_COMPRESSED);
	}
}