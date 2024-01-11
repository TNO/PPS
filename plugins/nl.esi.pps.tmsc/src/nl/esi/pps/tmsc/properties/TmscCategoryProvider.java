/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.properties;

import nl.esi.emf.properties.xtend.CategoryProvider;
import nl.esi.emf.properties.xtend.PersistedProperty;
import nl.esi.pps.tmsc.ScopedTMSC;
import nl.esi.pps.tmsc.TMSC;

/**
 * Indicates that this {@link PersistedProperty} is only valid within the
 * context of a specific {@link TMSC}.<br>
 * <b>NOTE:</b> All generated {@link PersistedProperty} methods for this
 * property require an additional parameter of type {@link TMSC}.
 */
public class TmscCategoryProvider implements CategoryProvider<TMSC> {
	@Override
	public String getCategory(TMSC tmsc) {
		return tmsc instanceof ScopedTMSC ? ((ScopedTMSC) tmsc).getFqn() : null;
	}
}
