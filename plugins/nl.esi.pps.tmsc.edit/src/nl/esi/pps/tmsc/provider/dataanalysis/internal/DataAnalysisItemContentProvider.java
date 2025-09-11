/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.provider.dataanalysis.internal;

import static java.lang.String.CASE_INSENSITIVE_ORDER;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

import nl.esi.pps.tmsc.provider.TmscEditPlugin;
import nl.esi.pps.tmsc.provider.dataanalysis.IDataAnalysisItemContentProvider;

public class DataAnalysisItemContentProvider extends ItemProviderAdapter implements IDataAnalysisItemContentProvider {
	public DataAnalysisItemContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Set<String> getConfigurations(Object object) {
		return getRegisteredContentProviders(object).keySet();
	}

	@Override
	public Long getBudget(Object object, String configuration) {
		return getRegisteredContentProviders(object).get(configuration).getBudget(object, configuration);
	}

	@Override
	public Iterable<?> getSiblings(Object object, String configuration) {
		return getRegisteredContentProviders(object).get(configuration).getSiblings(object, configuration);
	}

	@Override
	public String getTitle(Object object, String configuration) {
		return getRegisteredContentProviders(object).get(configuration).getTitle(object, configuration);
	}

	@Override
	public Long getDuration(Object object, Object sibling, String configuration) {
		return getRegisteredContentProviders(object).get(configuration).getDuration(object, sibling, configuration);
	}

	@Override
	public boolean isCategorized(Object object, String configuration) {
		return getRegisteredContentProviders(object).get(configuration).isCategorized(object, configuration);
	}

	@Override
	public String getCategory(Object object, Object sibling, String configuration) {
		return getRegisteredContentProviders(object).get(configuration).getCategory(object, sibling, configuration);
	}

	private Map<String, IDataAnalysisItemContentProvider> getRegisteredContentProviders(Object object) {
		if (object instanceof EObject) {
			EClass eClass = ((EObject) object).eClass();
			Map<String, IDataAnalysisItemContentProvider> contentProviders = new TreeMap<>(CASE_INSENSITIVE_ORDER);
			for (IDataAnalysisItemContentProvider contentProvider : TmscEditPlugin.getPlugin()
					.getRegisteredDataAnalysisItemContentProviders(eClass)) {
				Collection<String> configurations = contentProvider.getConfigurations(object);
				if (configurations != null) {
					for (String configuration : configurations) {
						contentProviders.putIfAbsent(configuration, contentProvider);
					}
				}
			}
			return contentProviders;
		}
		return Collections.emptyMap();
	}
}
