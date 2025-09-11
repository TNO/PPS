/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.emf.ui.link;

import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.PlatformUI;

import nl.esi.pps.common.ide.ui.browser.LinkProcessor;

public class HelpTopicLinkProcessor implements LinkProcessor {
	public static final String SCHEME_HELP = "help";
	public static final String SEGEMENT_TOPIC = "topic";
	
	protected static final URI PREFIX_HELP_TOPIC = URI.createHierarchicalURI(SCHEME_HELP, null, null, new String[] {SEGEMENT_TOPIC, ""}, null, null);
	protected static final URI PREFIX_ROOT = URI.createURI("/");

	@Override
	public boolean process(String location) {
		URI helpURI = URI.createURI(location);
		if (!(SCHEME_HELP.equals(helpURI.scheme()) && helpURI.segmentCount() > 1
				&& SEGEMENT_TOPIC.equals(helpURI.segment(0)))) {
			return false;
		}
		// Remove prefix: help:/topic
		String helpResource = helpURI.replacePrefix(PREFIX_HELP_TOPIC, PREFIX_ROOT).toString();
		PlatformUI.getWorkbench().getHelpSystem().displayHelpResource(helpResource);
		return true;
	}
}
