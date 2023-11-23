/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.ide.ui;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class Activator extends AbstractUIPlugin {

	public static final String IMAGE_WINDOW_CLONE = Activator.class.getPackage().getName() + ".IMAGE_CLONE_WINDOW";

	private static Activator instance;

	public Activator() {
		super();
		instance = this;
	}

	public static Activator getDefault() {
		return instance;
	}

	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {
		super.initializeImageRegistry(reg);

		ImageDescriptor imageExportImage = ImageDescriptor
				.createFromURL(FileLocator.find(getBundle(), new Path("icons/new.png"), null));
		reg.put(IMAGE_WINDOW_CLONE, imageExportImage);
	}

	public ImageDescriptor getDescriptor(String key) {
		return getImageRegistry().getDescriptor(key);
	}

}
