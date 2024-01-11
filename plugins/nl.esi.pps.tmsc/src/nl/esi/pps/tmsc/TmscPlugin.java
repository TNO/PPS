/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.lsat.common.emf.validation.EValidatorUtil;
import org.osgi.framework.BundleContext;

import nl.esi.pps.tmsc.validation.DefaultTmscValidator;

/**
 * The activator class controls the plug-in life cycle
 */
public class TmscPlugin extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "nl.esi.pps.tmsc";
	
	public static final String TMSC_FILE_EXTENSION_XMI = "tmsc";
	
	public static final String TMSC_FILE_EXTENSION_BINARY_COMPRESSED = "tmscz";
	
	// The shared instance
	private static TmscPlugin plugin;

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		EValidatorUtil.registerValidations(TmscPackage.eINSTANCE, new DefaultTmscValidator());
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
	public static TmscPlugin getDefault() {
		return plugin;
	}
	
	public static boolean isTmscFile(IFile file) {
		return isTmscXmiFileExtension(file.getFileExtension())
				|| isTmscBinaryCompressedFileExtension(file.getFileExtension());
	}

	public static boolean isTmscFileExtension(String extension) {
		return isTmscXmiFileExtension(extension) || isTmscBinaryCompressedFileExtension(extension);
	}
	
	public static boolean isTmscXmiFileExtension(String extension) {
		return extension == null ? false : extension.equals(TMSC_FILE_EXTENSION_XMI);
	}

	public static boolean isTmscBinaryCompressedFileExtension(String extension) {
		return extension == null ? false : extension.equals(TMSC_FILE_EXTENSION_BINARY_COMPRESSED);
	}
}