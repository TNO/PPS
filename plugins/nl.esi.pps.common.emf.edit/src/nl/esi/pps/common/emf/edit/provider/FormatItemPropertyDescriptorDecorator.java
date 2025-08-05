/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.emf.edit.provider;

import java.text.Format;
import java.util.function.Function;

import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

public class FormatItemPropertyDescriptorDecorator<T> extends ItemPropertyDescriptorDecorator<T> {
	private final Format format;

	public FormatItemPropertyDescriptorDecorator(Format format, IItemPropertyDescriptor itemPropertyDescriptor) {
		super(itemPropertyDescriptor);
		this.format = format;
	}

	public FormatItemPropertyDescriptorDecorator(Function<T, ?> itemPropertyOwnerProvider, Format format,
			IItemPropertyDescriptor itemPropertyDescriptor) {
		super(itemPropertyOwnerProvider, itemPropertyDescriptor);
		this.format = format;
	}

	public FormatItemPropertyDescriptorDecorator(Object itemPropertyOwner, Format format,
			IItemPropertyDescriptor itemPropertyDescriptor) {
		super(itemPropertyOwner, itemPropertyDescriptor);
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
				return FormatItemPropertyDescriptorDecorator.super.getLabelProvider(outerObject).getImage(innerObject);
			}
		};
	}
}
