/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.viewers.plot;

import static org.eclipse.lsat.common.queries.QueryableIterable.from;

import java.util.Objects;
import java.util.Optional;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ResourceLocator;

import nl.esi.pps.tmsc.presentation.TmscEditorPlugin;
import nl.esi.pps.tmsc.rendering.plot.IRenderingStrategy;

public class RenderingStrategyRegistryReader {
	public static IConfigurationElement[] getRenderingStrategyConfigurations() {
		return Platform.getExtensionRegistry()
				.getConfigurationElementsFor(TmscEditorPlugin.getPlugin().getSymbolicName(), "rendering_strategy");
	}

	public static IConfigurationElement getRenderingStrategyConfiguration(String id) {
		return from(getRenderingStrategyConfigurations()).any(ce -> Objects.equals(getID(ce), id));
	}
	
	public static String getID(IConfigurationElement configurationElement) {
		return configurationElement.getAttribute("id");
	}

	public static String getName(IConfigurationElement configurationElement) {
		return configurationElement.getAttribute("name");
	}

	public static String getDescription(IConfigurationElement configurationElement) {
		return configurationElement.getAttribute("description");
	}

	public static Optional<ImageDescriptor> getIcon(IConfigurationElement configurationElement) {
		final String iconLocation = configurationElement.getAttribute("icon");
		if (iconLocation == null) {
			return ResourceLocator.imageDescriptorFromBundle(TmscEditorPlugin.getPlugin().getSymbolicName(),
					"icons/rendering_default.png");
		}
		return ResourceLocator.imageDescriptorFromBundle(configurationElement.getContributor().getName(), iconLocation);
	}
	
	public static IRenderingStrategy getIRenderingStrategy(IConfigurationElement configurationElement) {
		try {
			return (IRenderingStrategy) configurationElement.createExecutableExtension("class");
		} catch (CoreException e) {
			TmscEditorPlugin.getPlugin().getLog().log(new Status(e.getStatus().getSeverity(),
					TmscEditorPlugin.getPlugin().getSymbolicName(), e.getStatus().getMessage(), e));
			return null;
		}
	}
}
