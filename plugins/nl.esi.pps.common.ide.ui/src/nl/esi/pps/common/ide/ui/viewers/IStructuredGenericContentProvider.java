/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.ide.ui.viewers;

import org.eclipse.jface.viewers.IStructuredContentProvider;

public interface IStructuredGenericContentProvider<ContentType> extends IStructuredContentProvider {
	@Override
	ContentType[] getElements(Object inputElement);
}
