/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.ide.ui.viewers;


import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.OwnerDrawLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerColumn;
import org.eclipse.swt.widgets.Event;

public abstract class AbstractColumnPaintModel extends AbstractColumnModel implements ColumnCellModel {
	
	private final OwnerDrawLabelProvider cellRenderer = new OwnerDrawLabelProvider() {
		private ColumnViewer viewer;
		
		protected void initialize(ColumnViewer viewer, ViewerColumn column) {
			super.initialize(viewer, column);
			this.viewer = viewer;
		}
		
		@Override
		protected void measure(Event event, Object element) {
			AbstractColumnPaintModel.this.measureColumnCell(element, event.index, event);
		}
		
		@Override
		protected void paint(Event event, Object element) {
			if (event.width == 0) {
				if (viewer instanceof TreeViewer) {
					event.width = ((TreeViewer)viewer).getTree().getColumn(event.index).getWidth();
				}
				if (viewer instanceof TableViewer) {
					event.width = ((TableViewer)viewer).getTable().getColumn(event.index).getWidth();
				}
			}
			if (viewer != null) {
				event.gc.setForeground(viewer.getControl().getForeground());
				event.gc.setBackground(viewer.getControl().getBackground());
			}
			AbstractColumnPaintModel.this.renderColumnCell(element, event.index, event);
		}
	};
	
	public AbstractColumnPaintModel(ILabelProvider delegate) {
		super(delegate);
	}
	
	@Override
	public final CellLabelProvider getColumnCellRenderer(int columnIndex) {
		return isRenderedColumn(columnIndex) ? cellRenderer : null;
	}
	
	protected abstract boolean isRenderedColumn(int columnIndex);
	
	protected void measureColumnCell(Object element, int columnIndex, Event event) {
	}
	
	protected void renderColumnCell(Object element, int columnIndex, Event event) {
		String text = getColumnText(element, columnIndex);
		if (null != text && !text.isEmpty()) {
			event.gc.drawString(text, event.x, event.y, true);
		}
	}
}
