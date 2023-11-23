/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.emf.edit.provider;

import java.util.Collection;
import java.util.function.Function;

import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IPropertyEditorFactory;
import org.eclipse.emf.edit.provider.ItemProvider;

/**
 * This {@link ItemPropertyDescriptorDecorator} can be used to add properties of
 * a referenced object.
 * 
 * @author yblanken This class basically is a copy of
 *         {@link ItemPropertyDescriptorDecorator}, but adapted to use a
 *         function instead of a fixed object, such that the
 *         {@link ItemProvider} can stay stateless.
 */
public class ItemPropertyDescriptorDecorator<T> implements IItemPropertyDescriptor,
		IItemPropertyDescriptor.ValueHandlerProvider, IPropertyEditorFactory.Provider {

	private final Function<T, ?> itemPropertyOwnerProvider;
	private final IItemPropertyDescriptor itemPropertyDescriptor;

	public ItemPropertyDescriptorDecorator(IItemPropertyDescriptor itemPropertyDescriptor) {
		this(Function.identity(), itemPropertyDescriptor);
	}

	public ItemPropertyDescriptorDecorator(Object itemPropertyOwner, IItemPropertyDescriptor itemPropertyDescriptor) {
		this(o -> itemPropertyOwner, itemPropertyDescriptor);
	}

	public ItemPropertyDescriptorDecorator(Function<T, ?> itemPropertyOwnerProvider,
			IItemPropertyDescriptor itemPropertyDescriptor) {
		this.itemPropertyOwnerProvider = itemPropertyOwnerProvider;
		this.itemPropertyDescriptor = itemPropertyDescriptor;
	}

	@SuppressWarnings("unchecked")
	public Object getItemPropertyOwner(Object object) {
		return itemPropertyOwnerProvider.apply((T) object);
	}

	public IItemPropertyDescriptor getDecoratedItemPropertyDescriptor() {
		return itemPropertyDescriptor;
	}

	@Override
	public Object getPropertyValue(Object object) {
		return itemPropertyDescriptor.getPropertyValue(getItemPropertyOwner(object));
	}

	@Override
	public boolean isPropertySet(Object object) {
		return itemPropertyDescriptor.isPropertySet(getItemPropertyOwner(object));
	}

	@Override
	public boolean canSetProperty(Object object) {
		return itemPropertyDescriptor.canSetProperty(getItemPropertyOwner(object));
	}

	@Override
	public void resetPropertyValue(Object object) {
		itemPropertyDescriptor.resetPropertyValue(getItemPropertyOwner(object));
	}

	@Override
	public void setPropertyValue(Object object, Object value) {
		itemPropertyDescriptor.setPropertyValue(getItemPropertyOwner(object), value);
	}

	@Override
	public String getCategory(Object object) {
		return itemPropertyDescriptor.getCategory(getItemPropertyOwner(object));
	}

	@Override
	public String getDescription(Object object) {
		return itemPropertyDescriptor.getDescription(getItemPropertyOwner(object));
	}

	@Override
	public String getDisplayName(Object object) {
		return itemPropertyDescriptor.getDisplayName(getItemPropertyOwner(object));
	}

	@Override
	public String[] getFilterFlags(Object object) {
		return itemPropertyDescriptor.getFilterFlags(getItemPropertyOwner(object));
	}

	@Override
	public Object getHelpContextIds(Object object) {
		return itemPropertyDescriptor.getHelpContextIds(getItemPropertyOwner(object));
	}

	@Override
	public String getId(Object object) {
		return itemPropertyDescriptor.getId(getItemPropertyOwner(object));
	}

	@Override
	public IItemLabelProvider getLabelProvider(Object object) {
		return itemPropertyDescriptor.getLabelProvider(getItemPropertyOwner(object));
	}

	@Override
	public boolean isCompatibleWith(Object object, Object anotherObject,
			IItemPropertyDescriptor anotherPropertyDescriptor) {
		return itemPropertyDescriptor.isCompatibleWith(getItemPropertyOwner(object), anotherObject,
				anotherPropertyDescriptor);
	}

	@Override
	public Object getFeature(Object object) {
		return itemPropertyDescriptor.getFeature(getItemPropertyOwner(object));
	}

	@Override
	public boolean isMany(Object object) {
		return itemPropertyDescriptor.isMany(getItemPropertyOwner(object));
	}

	@Override
	public Collection<?> getChoiceOfValues(Object object) {
		return itemPropertyDescriptor.getChoiceOfValues(getItemPropertyOwner(object));
	}

	@Override
	public boolean isMultiLine(Object object) {
		return itemPropertyDescriptor.isMultiLine(getItemPropertyOwner(object));
	}

	@Override
	public boolean isSortChoices(Object object) {
		return itemPropertyDescriptor.isSortChoices(getItemPropertyOwner(object));
	}

	@Override
	public boolean isChoiceArbitrary(Object object) {
		return itemPropertyDescriptor instanceof ValueHandlerProvider
				&& ((ValueHandlerProvider) itemPropertyDescriptor).isChoiceArbitrary(getItemPropertyOwner(object));
	}

	@Override
	public boolean isPropertyUnsettable(Object object) {
		return itemPropertyDescriptor instanceof ValueHandlerProvider
				&& ((ValueHandlerProvider) itemPropertyDescriptor).isPropertyUnsettable(getItemPropertyOwner(object));
	}

	@Override
	public ValueHandler getValueHandler(Object object) {
		return itemPropertyDescriptor instanceof ValueHandlerProvider
				? ((ValueHandlerProvider) itemPropertyDescriptor).getValueHandler(getItemPropertyOwner(object))
				: null;
	}

	@Override
	public Object getEditorFactory(Object object) {
		return itemPropertyDescriptor instanceof IPropertyEditorFactory.Provider
				? ((IPropertyEditorFactory.Provider) itemPropertyDescriptor)
						.getEditorFactory(getItemPropertyOwner(object))
				: null;
	}
}