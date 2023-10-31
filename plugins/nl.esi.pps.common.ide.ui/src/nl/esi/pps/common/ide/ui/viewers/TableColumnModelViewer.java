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


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class TableColumnModelViewer extends TableViewer implements ColumnModelViewer {
	private Clipboard clipboard;

	private final SelectionAdapter sortListener = new SelectionAdapter() {
		@Override
		public void widgetSelected(SelectionEvent e) {
			sortOnColumn(getTable().indexOf((TableColumn) e.getSource()));
		}
	};

	/**
	 * Creates a table viewer on a newly-created table control under the given
	 * parent. The table control is created using the given style bits. The
	 * viewer has no input, no content provider, a default label provider, no
	 * sorter, and no filters. The table has no columns.
	 *
	 * @param parent
	 *            the parent control
	 * @param style
	 *            SWT style bits.Default direction of the sort indicator can be
	 *            set using either <code>UP</code> or <code>DOWN</code>.
	 */
	public TableColumnModelViewer(Composite parent, int style) {
		super(parent, style);
	}

	public TableColumnModelViewer(Composite parent) {
		super(parent);
	}

	public TableColumnModelViewer(Table table) {
		super(table);
	}

	public void pack() {
		for (TableColumn column : getTable().getColumns()) {
			column.pack();
		}
	}
	
	@Override
	public void setLabelProvider(IBaseLabelProvider labelProvider) {
		Assert.isTrue(labelProvider instanceof ColumnModel);
		super.setLabelProvider(labelProvider);
	}
	
	@Override
	public void setColumnModel(ColumnModel model) {
		setLabelProvider(model);
	}
	
	@Override
	public ColumnModel getColumnModel() {
		return (ColumnModel) getLabelProvider();
	}
	
	@Override
	public int getSortDirection() {
		return getTable().getSortDirection();
	}

	public void sortOnColumn(int columnIndex) {
		Table table = getTable();
		TableColumn column = null;
		Comparator<?> columnComparator = null;
		if (columnIndex >= 0 && columnIndex < table.getColumnCount()) {
			column = table.getColumn(columnIndex);
			columnComparator = getColumnModel().getColumnComparator(columnIndex);
		}
		
		if (null == column || columnComparator == null) {
			setComparator(null);
			table.setSortColumn(null);
			table.setSortDirection(SWT.NONE);
		} else {
			int direction = table.getSortDirection();
			if (direction == SWT.NONE) {
				// Not sorted, used the default sort direction from the style bits
				direction = (table.getStyle() & SWT.DOWN) == 0 ? SWT.UP : SWT.DOWN;
			} else if (table.getSortColumn() == column) {
				direction = direction == SWT.UP ? SWT.DOWN : SWT.UP;	
			}
			table.setSortDirection(direction);
			table.setSortColumn(column);
			setComparator(new ColumnModelViewerComparator(columnIndex, columnComparator)); 
		}
	}
	
	public void copySelectionToClipboard() {
		IStructuredSelection selection = getStructuredSelection();
		if (selection.isEmpty()) {
			return;
		}

		ColumnModel columnModel = getColumnModel();
		int columnCnt = columnModel.getColumnCount();

		List<String> lines = new ArrayList<>();
		for (Object s : selection) {
			List<String> cells = new ArrayList<>();
			for (int i = 0; i < columnCnt; i++) {
				cells.add(columnModel.getColumnText(s, i));
			}
			lines.add(String.join("\t", cells));
		}
		String text = String.join("\n", lines);

		Object[] data = new Object[] { selection, text };
		Transfer[] transferTypes = new Transfer[] { LocalSelectionTransfer.getTransfer(), TextTransfer.getInstance() };

		getClipboard().setContents(data, transferTypes);
	}

	@Override
	protected void internalRefresh(Object element) {
		TableViewerColumn[] columns = new TableViewerColumn[0];
		if (element == null || equals(element, getRoot())) {
			if (getColumnModel().setInput(element)) {
				columns = internalRefreshColumns();
			}
		}
		super.internalRefresh(element);
		for (TableViewerColumn column : columns) {
			column.getColumn().pack();
		}
	}

	protected TableViewerColumn[] internalRefreshColumns() {
		Table table = getTable();
		table.setRedraw(false);
		sortOnColumn(-1);
		
	    // Dispose former columns
		TableColumn[] oldColumns = table.getColumns();
		for (int i = oldColumns.length - 1; i >= 0; i--) {
			oldColumns[i].dispose();
		}

		ColumnModel model = getColumnModel();
		TableViewerColumn[] viewerColumns = new TableViewerColumn[model.getColumnCount()];
		for (int i = 0; i < model.getColumnCount(); i++) {
			viewerColumns[i] = new TableViewerColumn(this, SWT.NONE);
		    TableColumn column = viewerColumns[i].getColumn();
		    column.setText(model.getColumnHeaderText(i));
		    column.setImage(model.getColumnHeaderImage(i));
		    column.setAlignment(isNumericType(model.getColumnClass(i)) ? SWT.RIGHT : SWT.LEFT);
		    column.addSelectionListener(sortListener);
		}

		IBaseLabelProvider labelProvider = getLabelProvider();
		setLabelProvider(labelProvider);
		if (labelProvider instanceof ColumnCellModel) {
			for (int i = 0; i < viewerColumns.length; i++) {
				CellLabelProvider cellRenderer = ((ColumnCellModel) labelProvider).getColumnCellRenderer(i);
				if (null != cellRenderer) {
					viewerColumns[i].setLabelProvider(cellRenderer);
				}
			}
		}
		
	    table.setRedraw(true);
	    table.layout();
	    return viewerColumns;
	}
	
	protected boolean isNumericType(Class<?> clazz) {
		if (null == clazz) {
			return false;
		} else if (clazz.isPrimitive()) {
			return clazz == java.lang.Byte.TYPE
				|| clazz == java.lang.Short.TYPE
				|| clazz == java.lang.Integer.TYPE
				|| clazz == java.lang.Long.TYPE
				|| clazz == java.lang.Float.TYPE
				|| clazz == java.lang.Double.TYPE;
		} else if (Number.class.isAssignableFrom(clazz)) {
			return true;
		}
		return false;
	}

	@Override
	protected void handleDispose(DisposeEvent event) {
		if (null != clipboard) {
			clipboard.dispose();
		}
		super.handleDispose(event);
	}

	private Clipboard getClipboard() {
		if (null == clipboard) {
			clipboard = new Clipboard(getControl().getDisplay());
		}
		return clipboard;
	}
}
