/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.jfreechart.rendering;

import java.awt.Stroke;

@FunctionalInterface
public interface StrokeSupplier {
	static StrokeSupplier of(Stroke stroke) {
		return () -> stroke;
	}
	
	public Stroke getStroke();
}
