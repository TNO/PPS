/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.provider.ext.ui;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;

import nl.esi.pps.tmsc.provider.dataanalysis.IDataAnalysisItemContentProvider;

public class AdapterFactoryDataAnalysisContentProvider extends AdapterFactoryContentProvider
		implements IDataAnalysisContentProvider {
	public AdapterFactoryDataAnalysisContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Collection<String> getConfigurations(Object object) {
		Object adapter = adapterFactory.adapt(object, IDataAnalysisItemContentProvider.class);
		if (adapter instanceof IDataAnalysisItemContentProvider) {
			return ((IDataAnalysisItemContentProvider) adapter).getConfigurations(object);
		}
		return Collections.emptyList();
	}

	@Override
	public String getTitle(Object object, String configuration) {
		Object adapter = adapterFactory.adapt(object, IDataAnalysisItemContentProvider.class);
		if (adapter instanceof IDataAnalysisItemContentProvider) {
			return ((IDataAnalysisItemContentProvider) adapter).getTitle(object, configuration);
		}
		return "Data analysis is not supported for current selection.";
	}

	@Override
	public Long getBudget(Object object, String configuration) {
		Object adapter = adapterFactory.adapt(object, IDataAnalysisItemContentProvider.class);
		if (adapter instanceof IDataAnalysisItemContentProvider) {
			return ((IDataAnalysisItemContentProvider) adapter).getBudget(object, configuration);
		}
		return null;
	}

	@Override
	public Iterable<?> getSiblings(Object object, String configuration) {
		Object adapter = adapterFactory.adapt(object, IDataAnalysisItemContentProvider.class);
		if (adapter instanceof IDataAnalysisItemContentProvider) {
			return ((IDataAnalysisItemContentProvider) adapter).getSiblings(object, configuration);
		}
		return Collections.emptyList();
	}

	@Override
	public Long getDuration(Object object, Object sibling, String configuration) {
		Object adapter = adapterFactory.adapt(object, IDataAnalysisItemContentProvider.class);
		if (adapter instanceof IDataAnalysisItemContentProvider) {
			return ((IDataAnalysisItemContentProvider) adapter).getDuration(object, sibling, configuration);
		}
		return null;
	}
}
