/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.reconstruct;

import java.util.Set;

import nl.esi.pps.tmsc.EventType;

public interface TmscTraceEvent {
	boolean isEpochTime();
	
	Long getTimeStamp();
	
	String getExecutor();
	
	String getComponent();
	
	EventType getEventType();
	
	String getFunction();
	
	Set<String> getSentMessages();
	
	Set<String> getReceivedMessages();
}
