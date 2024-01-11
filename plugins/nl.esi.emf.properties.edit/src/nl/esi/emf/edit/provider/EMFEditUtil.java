/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.emf.edit.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemLabelProvider;

public class EMFEditUtil {
	private EMFEditUtil() {
		// Empty for utility classes
	}

	public static String getText(EObject eObject) {
		IItemLabelProvider labelProvider = adapt(eObject, IItemLabelProvider.class);
		return labelProvider == null ? null : labelProvider.getText(eObject);
	}

	public static Object getImage(EObject eObject) {
		IItemLabelProvider labelProvider = adapt(eObject, IItemLabelProvider.class);
		return labelProvider == null ? null : labelProvider.getImage(eObject);
	}

	private static <T> T adapt(EObject eObject, Class<T> adapterType) {
		if (eObject == null || adapterType == null) {
			return null;
		}
		EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(eObject);
		if (editingDomain instanceof AdapterFactoryEditingDomain) {
			AdapterFactory adapterFactory = ((AdapterFactoryEditingDomain) editingDomain).getAdapterFactory();
			Object adapter = adapterFactory.adapt(eObject, adapterType);
			if (adapterType.isInstance(adapter)) {
				return adapterType.cast(adapter);
			}
		}
		Object adapter = (IItemLabelProvider) EcoreUtil.getRegisteredAdapter(eObject, adapterType);
		return adapterType.isInstance(adapter) ? adapterType.cast(adapter) : null;
	}
}
