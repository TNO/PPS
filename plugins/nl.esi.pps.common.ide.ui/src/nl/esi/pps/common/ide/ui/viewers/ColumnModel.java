/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.common.ide.ui.viewers;

import java.util.Comparator;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

public interface ColumnModel extends ITableLabelProvider {

	/**
	 * @return true if model structure (i.e. column properties) changed
	 */
	boolean setInput(Object input); 

	int getColumnCount();

	Object getColumnValue(Object element, int columnIndex);

	Class<?> getColumnClass(int columnIndex);

	Comparator<?> getColumnComparator(int columnIndex);

	Image getColumnHeaderImage(int columnIndex);

	String getColumnHeaderText(int columnIndex);
}