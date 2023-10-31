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

import java.util.function.Function;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

/**
 * This {@link ItemPropertyDescriptorDecorator} can be used to add properties of
 * a referenced object to a specific category.
 */
public class CategorizedItemPropertyDescriptor<T> extends ItemPropertyDescriptorDecorator<T> {
	private final String category;
	private final String idPrefix;

	/**
	 * @deprecated use
	 *             {@link ItemPropertyDescriptorDecorator#ItemPropertyDescriptorDecorator(Function, IItemPropertyDescriptor)}
	 */
	public CategorizedItemPropertyDescriptor(Function<T, ?> itemPropertyOwnerProvider,
			IItemPropertyDescriptor itemPropertyDescriptor) {
		this(itemPropertyOwnerProvider, itemPropertyDescriptor, null, null);
	}

	public CategorizedItemPropertyDescriptor(Object itemPropertyOwner, IItemPropertyDescriptor itemPropertyDescriptor,
			String category) {
		this(itemPropertyOwner, itemPropertyDescriptor, category, null == category ? null : category + "/");
	}

	public CategorizedItemPropertyDescriptor(Function<T, ?> itemPropertyOwnerProvider,
			IItemPropertyDescriptor itemPropertyDescriptor, String category) {
		this(itemPropertyOwnerProvider, itemPropertyDescriptor, category, null == category ? null : category + "/");
	}

	/**
	 * @param itemPropertyOwner      the item property owner
	 * @param itemPropertyDescriptor the decorated item property descriptor
	 * @param category               The category to use for this decorator or
	 *                               <code>null</null> to use the default category,
	 *                               see
	 *                               {@link IItemPropertyDescriptor#getCategory(Object)}
	 * @param idPrefix               The interface name of this property or
	 *                               <code>null</null> to use the default id, see
	 *                               {@link IItemPropertyDescriptor#getId(Object)}.
	 *                               This key must uniquely identify this
	 *                               descriptor.
	 */
	public CategorizedItemPropertyDescriptor(Object itemPropertyOwner, IItemPropertyDescriptor itemPropertyDescriptor,
			String category, String idPrefix) {
		super(itemPropertyOwner, itemPropertyDescriptor);
		this.category = category;
		this.idPrefix = idPrefix;
	}

	/**
	 * @param itemPropertyOwnerProvider a function to get the item property owner
	 * @param itemPropertyDescriptor    the decorated item property descriptor
	 * @param category                  The category to use for this decorator or
	 *                                  <code>null</null> to use the default
	 *                                  category, see
	 *                                  {@link IItemPropertyDescriptor#getCategory(Object)}
	 * @param idPrefix                  The interface name of this property or
	 *                                  <code>null</null> to use the default id, see
	 *                                  {@link IItemPropertyDescriptor#getId(Object)}.
	 *                                  This key must uniquely identify this
	 *                                  descriptor.
	 */
	public CategorizedItemPropertyDescriptor(Function<T, ?> itemPropertyOwnerProvider,
			IItemPropertyDescriptor itemPropertyDescriptor, String category, String idPrefix) {
		super(itemPropertyOwnerProvider, itemPropertyDescriptor);
		this.category = category;
		this.idPrefix = idPrefix;
	}

	@Override
	public String getCategory(Object object) {
		return null == category ? super.getCategory(object) : category;
	}

	@Override
	public String getId(Object object) {
		final String id = super.getId(object);
		return null == idPrefix ? id : idPrefix + id;
	}
}
