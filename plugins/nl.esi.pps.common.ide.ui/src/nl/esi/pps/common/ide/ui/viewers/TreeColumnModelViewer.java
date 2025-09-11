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


import java.util.Comparator;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;

public class TreeColumnModelViewer extends TreeViewer implements ColumnModelViewer {
	private final SelectionAdapter sortListener = new SelectionAdapter() {
		@Override
		public void widgetSelected(SelectionEvent e) {
			sortOnColumn(getTree().indexOf((TreeColumn)e.getSource()));
		}
	};
	
	/**
	 * Creates a tree viewer on a newly-created tree control under the given
	 * parent. The tree control is created using the given SWT style bits. The
	 * viewer has no input, no content provider, a default label provider, no
	 * sorter, and no filters.
	 *
	 * @param parent
	 *            the parent control
	 * @param style
	 *            the SWT style bits used to create the tree. Default direction
	 *            of the sort indicator can be set using either <code>UP</code>
	 *            or <code>DOWN</code>.
	 */
	public TreeColumnModelViewer(Composite parent, int style) {
		super(parent, style);
	}

	public TreeColumnModelViewer(Composite parent) {
		super(parent);
	}

	public TreeColumnModelViewer(Tree tree) {
		super(tree);
	}
	
	public void pack() {
		for (TreeColumn column : getTree().getColumns()) {
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
		return getTree().getSortDirection();
	}

	public void sortOnColumn(int columnIndex) {
		Tree tree = getTree();
		TreeColumn column = null;
		Comparator<?> columnComparator = null;
		if (columnIndex >= 0 && columnIndex < tree.getColumnCount()) {
			column = tree.getColumn(columnIndex);
			columnComparator = getColumnModel().getColumnComparator(columnIndex);
		}
		
		if (null == column || columnComparator == null) {
			setComparator(null);
			tree.setSortColumn(null);
			tree.setSortDirection(SWT.NONE);
		} else {
			int direction = tree.getSortDirection();
			if (direction == SWT.NONE) {
				// Not sorted, used the default sort direction from the style bits
				direction = (tree.getStyle() & SWT.DOWN) == 0 ? SWT.UP : SWT.DOWN;
			} else if (tree.getSortColumn() == column) {
				direction = direction == SWT.UP ? SWT.DOWN : SWT.UP;	
			}
			tree.setSortDirection(direction);
			tree.setSortColumn(column);
			setComparator(new ColumnModelViewerComparator(columnIndex, columnComparator)); 
		}
	}
	
	@Override
	protected void inputChanged(Object input, Object oldInput) {
		TreeViewerColumn[] columns = new TreeViewerColumn[0];
		if (getColumnModel().setInput(input)) {
			columns = internalRefreshColumns();
		}
		super.inputChanged(input, oldInput);
		for (TreeViewerColumn column : columns) {
			column.getColumn().pack();
		}
	}
	
	@Override
	protected void internalRefresh(Object element) {
		TreeViewerColumn[] columns = new TreeViewerColumn[0];
		if (element == null || equals(element, getRoot())) {
			if (getColumnModel().setInput(element)) {
				columns = internalRefreshColumns();
			}
		}
		super.internalRefresh(element);
		for (TreeViewerColumn column : columns) {
			column.getColumn().pack();
		}
	}

	protected TreeViewerColumn[] internalRefreshColumns() {
		Tree tree = getTree();
		tree.setRedraw(false);
		sortOnColumn(-1);
		
	    // Dispose former columns 
		for (TreeColumn column : tree.getColumns()) {
			column.dispose();
		}

		ColumnModel model = getColumnModel();
		TreeViewerColumn[] viewerColumns = new TreeViewerColumn[model.getColumnCount()];
		for (int i = 0; i < viewerColumns.length; i++) {
			viewerColumns[i] = new TreeViewerColumn(this, SWT.NONE);
		    TreeColumn column = viewerColumns[i].getColumn();
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
		
	    tree.setRedraw(true);
	    tree.layout();
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
}
