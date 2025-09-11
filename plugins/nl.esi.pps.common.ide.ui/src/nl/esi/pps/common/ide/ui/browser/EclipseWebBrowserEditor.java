/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.ide.ui.browser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.browser.LocationAdapter;
import org.eclipse.swt.browser.LocationEvent;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.internal.browser.WebBrowserEditor;

@SuppressWarnings("restriction")
public class EclipseWebBrowserEditor extends WebBrowserEditor {
	public static final String WEB_BROWSER_EDITOR_ID = "nl.esi.pps.common.ide.ui.browser.editor";

	private static final String WEB_BROWSER_LINK_PROCESSORS = "nl.esi.pps.common.ide.ui.browser";

	private static final String PLUGIN_ID = "nl.esi.pps.common.ide.ui";

	private List<LinkProcessor> linkProcessors = Collections.emptyList();

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);
		try {
			IConfigurationElement[] ces = Platform.getExtensionRegistry()
					.getConfigurationElementsFor(WEB_BROWSER_LINK_PROCESSORS);
			linkProcessors = new ArrayList<LinkProcessor>(ces.length);
			for (IConfigurationElement ce : ces) {
				switch (ce.getName()) {
					case "link_processor":
						linkProcessors.add((LinkProcessor) ce.createExecutableExtension("class"));
						break;
					default:
						break;
				}
			}
		} catch (CoreException e) {
			throw new PartInitException(new Status(e.getStatus().getSeverity(), PLUGIN_ID,
					e.getStatus().getMessage(), e));
		}
	}

	@Override
	public void createPartControl(org.eclipse.swt.widgets.Composite parent) {
		super.createPartControl(parent);
		webBrowser.getBrowser().addLocationListener(new LocationAdapter() {
			@Override
			public void changing(LocationEvent event) {
				for (Iterator<LinkProcessor> i = linkProcessors.iterator(); i.hasNext() && event.doit;) {
					event.doit &= !i.next().process(event.location);
				}
			}
		});
	}

	@Override
	public void dispose() {
		linkProcessors.clear();
		super.dispose();
	}
}
