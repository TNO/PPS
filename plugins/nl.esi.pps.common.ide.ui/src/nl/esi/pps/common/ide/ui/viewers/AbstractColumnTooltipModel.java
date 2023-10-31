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

import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITableColorProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;

/**
 * <b>IMPORTANT:</b> To use tooltips
 * {@link ColumnViewerToolTipSupport#enableFor(org.eclipse.jface.viewers.ColumnViewer))}
 * should be called.
 */
public abstract class AbstractColumnTooltipModel extends AbstractColumnModel
		implements ColumnCellModel, ITableColorProvider {
	public AbstractColumnTooltipModel(ILabelProvider delegate) {
		super(delegate);
	}

	@Override
	public Color getBackground(Object element, int columnIndex) {
		return null;
	}

	@Override
	public Color getForeground(Object element, int columnIndex) {
		return null;
	}

	public Font getFont(Object element, int columnIndex) {
		return null;
	}

	public Image getToolTipImage(Object element, int columnIndex) {
		return null;
	}

	public String getToolTipText(Object element, int columnIndex) {
		return null;
	}

	public Color getToolTipBackgroundColor(Object element, int columnIndex) {
		return null;
	}

	public Color getToolTipForegroundColor(Object element, int columnIndex) {
		return null;
	}

	public Font getToolTipFont(Object element, int columnIndex) {
		return null;
	}

	public Point getToolTipShift(Object element, int columnIndex) {
		return null;
	}

	public boolean useNativeToolTip(Object element, int columnIndex) {
		return false;
	}

	public int getToolTipTimeDisplayed(Object element, int columnIndex) {
		return 0;
	}

	public int getToolTipDisplayDelayTime(Object element, int columnIndex) {
		return 0;
	}

	public int getToolTipStyle(Object element, int columnIndex) {
		return SWT.SHADOW_NONE;
	}

	@Override
	public CellLabelProvider getColumnCellRenderer(final int columnIndex) {
		return new ColumnLabelProvider() {
			@Override
			public Font getFont(Object element) {
				return AbstractColumnTooltipModel.this.getFont(element, columnIndex);
			}

			@Override
			public Image getImage(Object element) {
				return AbstractColumnTooltipModel.this.getColumnImage(element, columnIndex);
			}

			@Override
			public String getText(Object element) {
				return AbstractColumnTooltipModel.this.getColumnText(element, columnIndex);
			}

			@Override
			public Color getBackground(Object element) {
				return AbstractColumnTooltipModel.this.getBackground(element, columnIndex);
			}

			@Override
			public Color getForeground(Object element) {
				return AbstractColumnTooltipModel.this.getForeground(element, columnIndex);
			}

			public Image getToolTipImage(Object element) {
				return AbstractColumnTooltipModel.this.getToolTipImage(element, columnIndex);
			}

			@Override
			public String getToolTipText(Object element) {
				return AbstractColumnTooltipModel.this.getToolTipText(element, columnIndex);
			}

			public Color getToolTipBackgroundColor(Object element) {
				return AbstractColumnTooltipModel.this.getToolTipBackgroundColor(element, columnIndex);
			}

			public Color getToolTipForegroundColor(Object element) {
				return AbstractColumnTooltipModel.this.getToolTipForegroundColor(element, columnIndex);
			}

			public Font getToolTipFont(Object element) {
				return AbstractColumnTooltipModel.this.getToolTipFont(element, columnIndex);
			}

			public Point getToolTipShift(Object element) {
				return AbstractColumnTooltipModel.this.getToolTipShift(element, columnIndex);
			}

			public boolean useNativeToolTip(Object element) {
				return AbstractColumnTooltipModel.this.useNativeToolTip(element, columnIndex);
			}

			public int getToolTipTimeDisplayed(Object element) {
				return AbstractColumnTooltipModel.this.getToolTipTimeDisplayed(element, columnIndex);
			}

			public int getToolTipDisplayDelayTime(Object element) {
				return AbstractColumnTooltipModel.this.getToolTipDisplayDelayTime(element, columnIndex);
			}

			public int getToolTipStyle(Object element) {
				return AbstractColumnTooltipModel.this.getToolTipStyle(element, columnIndex);
			}
		};
	}
}
