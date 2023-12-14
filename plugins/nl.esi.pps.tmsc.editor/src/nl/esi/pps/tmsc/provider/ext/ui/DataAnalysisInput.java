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

import java.util.Set;

import nl.esi.pps.tmsc.provider.dataanalysis.IDataAnalysisItemContentProvider;

class DataAnalysisInput implements IDataAnalysisInput {
	private final Object input;
	private final IDataAnalysisItemContentProvider contentProvider;

	DataAnalysisInput(Object input, IDataAnalysisItemContentProvider contentProvider) {
		this.input = input;
		this.contentProvider = contentProvider;
	}

	@Override
	public Object getInput() {
		return input;
	}

	@Override
	public Set<String> getConfigurations() {
		return contentProvider.getConfigurations(input);
	}

	@Override
	public String getTitle(String configuration) {
		return contentProvider.getTitle(input, configuration);
	}

	@Override
	public Long getBudget(String configuration) {
		return contentProvider.getBudget(input, configuration);
	}

	@Override
	public Iterable<?> getSiblings(String configuration) {
		return contentProvider.getSiblings(input, configuration);
	}

	@Override
	public Long getDuration(Object sibling, String configuration) {
		return contentProvider.getDuration(input, sibling, configuration);
	}

	@Override
	public boolean isCategorized(String configuration) {
		return contentProvider.isCategorized(input, configuration);
	}

	@Override
	public String getCategory(Object sibling, String configuration) {
		return contentProvider.getCategory(input, sibling, configuration);
	}
}
