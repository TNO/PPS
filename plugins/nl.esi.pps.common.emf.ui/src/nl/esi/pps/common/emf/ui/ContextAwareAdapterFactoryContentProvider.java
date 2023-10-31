/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.common.emf.ui;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;

import nl.esi.pps.common.ide.ui.viewers.IStructuredGenericContentProvider;

public class ContextAwareAdapterFactoryContentProvider<ContentType> extends AdapterFactoryContentProvider implements IStructuredGenericContentProvider<ContentType> {
	private final Class<ContentType> contentType;
	private final List<Class<?>> contextTypes;
	
	public ContextAwareAdapterFactoryContentProvider(Class<ContentType> contentType, Class<?>... contextTypes) {
		this(createDefaultAdapterFactory(), contentType, contextTypes);
	}
	
	private static AdapterFactory createDefaultAdapterFactory() {
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		return adapterFactory;
	}
	
	public ContextAwareAdapterFactoryContentProvider(AdapterFactory adapterFactory, Class<ContentType> contentType, Class<?>... contextTypes) {
		super(adapterFactory);
		this.contentType = contentType;
		// By default the content is its own context, meaning:
		// - when input is direct or indirect content of contentType instance the result will be the instance
		// - when input is ancestor or unrelated to contentType instance, the result will be all instances of contentType
		this.contextTypes = (null == contextTypes || contextTypes.length == 0) ? Arrays.asList(contentType) : Arrays.asList(contextTypes);
	}
	
	public Class<ContentType> getContentType() {
		return contentType;
	}

	protected Set<ContentType> createContentSet() {
		return new LinkedHashSet<>();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public final ContentType[] getElements(Object input) {
		final Set<ContentType> content = createContentSet();
		if (input instanceof Iterable<?>) {
			((Iterable<?>) input).forEach(i -> findContentWithinContext(i, content));
		} else if (input instanceof Iterator<?>) {
			((Iterator<?>) input).forEachRemaining(i -> findContentWithinContext(i, content));
		} else if (input != null && input.getClass().isArray()) {
			final int length = Array.getLength(input);
			for (int i = 0; i < length; i++) {
				findContentWithinContext(Array.get(input, i), content);
			}
		} else {
			findContentWithinContext(input, content);
		}
		return content.toArray((ContentType[]) Array.newInstance(contentType, content.size()));
	}
	
	protected void findContentWithinContext(Object element, Set<ContentType> content) {
		findContent(findContext(element), content);
	}
	
	protected Object findContext(final Object element) {
		if (element == null) {
			return null;
		}
		if (contextTypes.stream().anyMatch(t -> t.isInstance(element))) {
			return element;
		}
		final Object parent = getParent(element);
		return parent == null ? element : findContext(parent);
	}

	protected void findContent(final Object object, final Set<ContentType> content) {
		if (null == object) {
			return;
		} else if (contentType.isInstance(object)) {
			content.add(contentType.cast(object));
		} else if (object.getClass().isArray()) {
			final int length = Array.getLength(object);
			for (int i = 0; i < length; i++) {
				findContent(Array.get(object, i), content);
			}
		} else if (object instanceof Iterable<?>) {
			((Iterable<?>) object).forEach(i -> findContent(i, content));
		} else if (object instanceof Iterator<?>) {
			((Iterator<?>) object).forEachRemaining(i -> findContent(i, content));
		} else {
			findContent(getChildren(object), content);
		}
	}
}
