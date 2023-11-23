/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.emf.properties.edit;

import java.text.Format;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;

import nl.esi.pps.common.emf.edit.provider.FormatItemPropertyDescriptor;
import nl.esi.pps.common.emf.edit.provider.ItemPropertyDescriptorDecorator;
import nl.esi.pps.common.text.FunctionFormat;

import nl.esi.emf.properties.PropertiesContainer;
import nl.esi.emf.properties.PropertiesPackage;

public class PropertyItemPropertyDescriptor extends ItemPropertyDescriptorDecorator<PropertiesContainer> {
	/** We just want to present the String::toString value to the user */
	private static final Format PROPERTY_FORMAT = new FunctionFormat<>(String::valueOf);

	private final int propertyIndex;

	@SuppressWarnings("deprecation")
	public PropertyItemPropertyDescriptor(AdapterFactory adapterFactory, ResourceLocator resourceLocator,
			String propertyName, int propertyIndex, String defaultCategory, String[] filterFlags) {
		super(pc -> pc.getProperties().get(propertyIndex), createItemPropertyDescriptor(adapterFactory, resourceLocator,
				propertyName, propertyIndex, defaultCategory, filterFlags));
		this.propertyIndex = propertyIndex;
	}

	private static FormatItemPropertyDescriptor createItemPropertyDescriptor(AdapterFactory adapterFactory,
			ResourceLocator resourceLocator, String propertyName, int propertyIndex, String defaultCategory,
			String[] filterFlags) {
		final int separatorIndex = propertyName.indexOf('/');
		final String displayName = separatorIndex < 0 ? propertyName : propertyName.substring(separatorIndex + 1);
		final String category = separatorIndex < 0 ? defaultCategory : propertyName.substring(0, separatorIndex);
		return new FormatItemPropertyDescriptor(PROPERTY_FORMAT, adapterFactory, resourceLocator, displayName, null,
				PropertiesPackage.Literals.PROPERTY_MAP_ENTRY__VALUE, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, category, filterFlags);
	}

	@Override
	public String getId(Object object) {
		return "properties/" + propertyIndex;
	}
}
