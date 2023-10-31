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

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;

@SuppressWarnings({"unchecked", "rawtypes"})
public class ColumnModelViewerComparator extends ViewerComparator {
	private final int columnIndex;
	private final Comparator comparator;
	
	public ColumnModelViewerComparator(int columnIndex, ColumnModel model) {
		this(columnIndex, model.getColumnComparator(columnIndex));
	}
	
	public ColumnModelViewerComparator(int columnIndex, Comparator comparator) {
		this.columnIndex = columnIndex;
		this.comparator = comparator;
	}
	
	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		ColumnModelViewer columnModelViewer = (ColumnModelViewer) viewer;
		ColumnModel columnModel = columnModelViewer.getColumnModel();
		int inverse = columnModelViewer.getSortDirection() == SWT.DOWN ? -1 : 1;
		return inverse * comparator.compare( 
				columnModel.getColumnValue(e1, columnIndex), 
				columnModel.getColumnValue(e2, columnIndex));
	}
}
