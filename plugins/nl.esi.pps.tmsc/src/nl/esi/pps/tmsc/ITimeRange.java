/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc;

public interface ITimeRange {
	boolean isEpochTime();
	
	Long getStartTime();

	Long getEndTime();

	default Long getDuration() {
		final Long startTime = getStartTime();
		if (startTime == null) {
			return null;
		}
		final Long endTime = getEndTime();
		if (endTime == null) {
			return null;
		}
		return endTime - startTime;
	}
}
