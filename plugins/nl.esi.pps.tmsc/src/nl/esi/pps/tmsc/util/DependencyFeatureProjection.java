/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.util;

import java.util.Map;

import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Event;

public interface DependencyFeatureProjection<V> {
	default V getInitialValue(Event projectionSource) {
		return null;
	}
	
	V calculateProjectedValue(Event projectionSource, Map<Dependency, V> projectionValues);
	
	void apply(Dependency projection, V targetFeatureValue);
}
