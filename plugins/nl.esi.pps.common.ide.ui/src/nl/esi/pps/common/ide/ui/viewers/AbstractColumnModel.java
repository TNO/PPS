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

import org.eclipse.jface.viewers.IInputProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;

public abstract class AbstractColumnModel extends DelegateLabelProvider implements ColumnModel, IInputProvider {
	@SuppressWarnings({"rawtypes", "unchecked"})
	protected static final Comparator<Comparable> NATURAL_COMPARATOR = new Comparator<Comparable>() {
		@Override
		public int compare(Comparable o1, Comparable o2) {
			if (o1 == o2) return 0;
			if (null == o1) return -1;
			if (null == o2) return 1;
			return o1.compareTo(o2);
		}
	}; 
	
	protected final Comparator<Object> LABEL_COMPARATOR = new Comparator<Object>() {
		@Override
		public int compare(Object o1, Object o2) {
			final String l1 = getText(o1);
			final String l2 = getText(o2);
			if (l1 == l2) return 0;
			if (null == l1) return -1;
			if (null == l2) return 1;
			return l1.compareToIgnoreCase(l2);
		}
	}; 

	private Object input = null;
	
	public AbstractColumnModel(ILabelProvider delegate) {
		super(delegate);
	}
	
	/**
	 * @param root
	 * @return true if model structure (i.e. column properties) changed
	 */
	@Override
	public boolean setInput(Object input) {
		boolean changed = this.input != input && (this.input == null || input == null);
		this.input = input;
		return changed;
	}
	
	
	@Override
	public Object getInput() {
		return input;
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return Object.class;
	}
	
	@Override
	public Comparator<?> getColumnComparator(int columnIndex) {
		Class<?> columnClass = getColumnClass(columnIndex);
		if (null == columnClass || columnClass == Void.class) {
			return null;
		} else if (String.class.isAssignableFrom(columnClass)) {
			return String.CASE_INSENSITIVE_ORDER;
		} else if (Comparable.class.isAssignableFrom(columnClass)) {
			return NATURAL_COMPARATOR;
		} else if (columnClass.isPrimitive()) {
			// Autoboxing will take care of converting to Comparable
			return NATURAL_COMPARATOR;
		}
		return null;
	}

	protected abstract Object getColumnHeaderValue(int columnIndex);

	@Override
	public Image getColumnHeaderImage(int columnIndex) {
		return getImage(getColumnHeaderValue(columnIndex));
	}

	@Override
	public String getColumnHeaderText(int columnIndex) {
		return getText(getColumnHeaderValue(columnIndex));
	}
	
	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		return getImage(getColumnValue(element, columnIndex));
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		return getText(getColumnValue(element, columnIndex));
	}
	
	@Override
	public Image getImage(Object element) {
		// Never show images for null value
		return null == element ? null : super.getImage(element);
	}
}
