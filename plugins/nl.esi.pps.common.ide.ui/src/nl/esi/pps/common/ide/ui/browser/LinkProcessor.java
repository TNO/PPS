/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.ide.ui.browser;

public interface LinkProcessor {
	/**
	 * @param location
	 *            The URL of this event, escaped and encoded for consumption by {@link java.net.URI#URI(String)}.
	 * @return <tt>true</tt> if this processor processed the location, <tt>false</tt> otherwise.
	 */
	public boolean process(String location);
}
