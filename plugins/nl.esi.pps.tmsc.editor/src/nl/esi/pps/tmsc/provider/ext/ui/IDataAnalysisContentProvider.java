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

import org.eclipse.jface.viewers.IContentProvider;

public interface IDataAnalysisContentProvider extends IContentProvider {
	IDataAnalysisInput getDataAnalysisInput(Object inputElement);
}
