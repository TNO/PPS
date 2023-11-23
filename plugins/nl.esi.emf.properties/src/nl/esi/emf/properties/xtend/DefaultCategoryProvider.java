/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.emf.properties.xtend;

/**
 * Used as default value for {@link PersistedProperty#categoryProvider()} as
 * assigning a {@code null} value as default is not allowed in an annotation (as
 * it seems).
 */
final class DefaultCategoryProvider implements CategoryProvider<Object> {
	@Override
	public String getCategory(Object context) {
		throw new UnsupportedOperationException("Programming error; should never be called!");
	}
}
