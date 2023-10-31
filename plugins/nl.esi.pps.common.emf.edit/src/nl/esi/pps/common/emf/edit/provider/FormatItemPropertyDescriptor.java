/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.common.emf.edit.provider;

import java.text.Format;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;

/**
 * @author yblanken
 * @deprecated use nl.esi.pps.common.emf.edit.ui.provider.FormatPropertyEditorFactory from bundle nl.esi.pps.common.emf.ui
 */
public class FormatItemPropertyDescriptor extends ItemPropertyDescriptor {
	private final Format format;

	public FormatItemPropertyDescriptor(Format format, AdapterFactory adapterFactory, ResourceLocator resourceLocator,
			String displayName, String description, EStructuralFeature feature, boolean isSettable, boolean multiLine,
			boolean sortChoices, Object staticImage, String category, String[] filterFlags) {
		super(adapterFactory, resourceLocator, displayName, description, feature, isSettable, multiLine, sortChoices,
				staticImage, category, filterFlags);
		this.format = format;
	}

	public Format getFormat() {
		return format;
	}

	@Override
	public IItemLabelProvider getLabelProvider(Object outerObject) {
		return new IItemLabelProvider() {
			@Override
			public String getText(Object innerObject) {
				return format.format(innerObject);
			}

			@Override
			public Object getImage(Object innerObject) {
				return FormatItemPropertyDescriptor.super.getLabelProvider(outerObject).getImage(innerObject);
			}
		};
	}
}
