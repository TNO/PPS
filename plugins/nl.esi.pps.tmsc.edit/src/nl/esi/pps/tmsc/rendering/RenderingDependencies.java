/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.rendering;

public enum RenderingDependencies {
	ALL("Show all"), HIDE_ANNOTATIONS("Hide annotations"), HIDE_CROSSING("Hide crossing dependencies"),
	NONE("Hide all");

	private final String label;

	private RenderingDependencies(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
