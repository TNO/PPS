/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.emf.common;

import java.io.IOException;

import org.eclipse.emf.common.EMFPlugin.EclipsePlugin;

public abstract class PngEclipsePlugin extends EclipsePlugin {
	@Override
	protected Object doGetImage(String key) throws IOException {
		try {
			// Prefer png images over gif
			return super.doGetImage(key + ".png");
		} catch (IOException e) {
			return super.doGetImage(key);
		}
	}
}
