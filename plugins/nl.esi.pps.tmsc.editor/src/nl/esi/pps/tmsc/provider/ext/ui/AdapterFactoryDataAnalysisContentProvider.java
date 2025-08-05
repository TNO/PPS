/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.provider.ext.ui;

import java.lang.reflect.Array;
import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;

import nl.esi.pps.tmsc.provider.dataanalysis.IDataAnalysisItemContentProvider;

public class AdapterFactoryDataAnalysisContentProvider extends AdapterFactoryContentProvider
		implements IDataAnalysisContentProvider {
	public AdapterFactoryDataAnalysisContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}
	
	@Override
	public IDataAnalysisInput getDataAnalysisInput(Object inputElement) {
		Object singleInput = getSingleInput(inputElement);
		if (singleInput == null) {
			return null;
		}
		Object adapter = adapterFactory.adapt(singleInput, IDataAnalysisItemContentProvider.class);
		if (adapter instanceof IDataAnalysisItemContentProvider) {
			return new DataAnalysisInput(singleInput, (IDataAnalysisItemContentProvider) adapter);
		}
		return null;
	}

	/**
	 * Returns the input if and only if {@code inputElement} is a single object or an
	 * array or collection containing a single object.
	 */
	protected Object getSingleInput(Object inputElement) {
		Object input = inputElement;
		if (input == null) {
			return null;
		} else if (input.getClass().isArray()) {
			return Array.getLength(input) == 1 ? Array.get(input, 0) : null;
		} else if (input instanceof Collection) {
			Collection<?> collection = (Collection<?>) input;
			return collection.size() == 1 ? collection.iterator().next() : null;
		} else {
			return input;
		}
	}
}
