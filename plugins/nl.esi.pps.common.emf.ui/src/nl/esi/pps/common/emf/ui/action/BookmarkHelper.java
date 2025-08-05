/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.emf.ui.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;

public class BookmarkHelper {
	protected static final String LIST_TAG = List.class.getName();
	
	public String serializeURIs(Object object) {
		if (object instanceof List<?>) {
			StringBuilder builder = new StringBuilder();
			builder.append(LIST_TAG);
			for (Iterator<?> i = ((List<?>) object).iterator(); i.hasNext();) {
				String element = serializeURIs(i.next());
				if (null != element) {
					builder.append(' ').append(element);
				}
			}
			return builder.toString();
		}
		return serializeURI(object);
	}

	public String serializeURI(Object object) {
		if (object instanceof EObject) {
			return EcoreUtil.getURI((EObject) object).toString();
		}
		if (object instanceof Resource) {
			return ((Resource) object).getURI().toString();
		}
		return null;
	}

	public Object deserializeURIs(String uris, EditingDomain editingDomain, boolean wrap) {
		if (null == uris) {
			return null;
		}
		if (uris.startsWith(LIST_TAG)) {
			String elementsStr = uris.substring(LIST_TAG.length(), uris.length()).trim();
			if (elementsStr.isEmpty()) {
				return Collections.emptyList();
			} else {
				String[] elements = elementsStr.split("\\s");
				ArrayList<Object> objects = new ArrayList<Object>(elements.length);
				for (String element : elements) {
					objects.add(deserializeURIs(element, editingDomain, wrap));
				}
				return objects;
			}
		}
		return deserializeURI(uris, editingDomain, wrap);
	}

	public Object deserializeURI(String uri, EditingDomain editingDomain, boolean wrap) {
		if (null == uri) {
			return null;
		}
		URI uuri = URI.createURI(uri);
		if (uuri.hasFragment()) {
			final EObject eObject = editingDomain.getResourceSet().getEObject(uuri, true);
			return wrap ? AdapterFactoryEditingDomain.getWrapper(eObject, editingDomain) : eObject;
		} else {
			return editingDomain.getResourceSet().getResource(uuri, true);
		}
	}
}
