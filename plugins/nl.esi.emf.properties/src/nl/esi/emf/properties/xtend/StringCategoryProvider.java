/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.emf.properties.xtend;

/**
 * Allows the API user to choose the category upon setting/getting the property
 * value.
 */
public final class StringCategoryProvider implements CategoryProvider<String> {
	@Override
	public String getCategory(String category) {
		return category;
	}
}
