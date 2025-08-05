/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.emf.ui.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITableColorProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import nl.esi.pps.common.ide.ui.viewers.AbstractColumnModel;

public class EcoreColumnModel extends AbstractColumnModel implements ITableColorProvider {
	public static final EStructuralFeature SELF_COLUMN = null;
	
	private static final EStructuralFeature[] DEFAULT_COLUMNS = new EStructuralFeature[] { SELF_COLUMN };
	
	private static final Comparator<Class<?>> CLASS_HIERARCHY_COMPARATOR = new Comparator<Class<?>>() {
		@Override
		public int compare(Class<?> c1, Class<?> c2) {
			if (c1 == c2 || Objects.equals(c1, c2)) return 0;
			if (c1.isAssignableFrom(c2)) return 1;
			if (c2.isAssignableFrom(c1)) return -1;
			
			// Don't care, just take another attribute to be consistent
			return Objects.compare(c1.getName(), c2.getName(), String.CASE_INSENSITIVE_ORDER);
		}
	}; 
	
	private final Map<Class<?>, EStructuralFeature[]> columnRegistry = new TreeMap<>(CLASS_HIERARCHY_COMPARATOR);
	
	private EStructuralFeature[] columns = DEFAULT_COLUMNS;
	
	public EcoreColumnModel(ILabelProvider delegate, EPackage... ePackages) {
		super(delegate);
		for (EPackage ePackage : ePackages) {
			registerColumns(ePackage);
		}
	}
	
	public void registerColumns(EPackage ePackage) {
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass) eClassifier;
				Set<EStructuralFeature> columns = new LinkedHashSet<EStructuralFeature>();
				columns.add(SELF_COLUMN);
				for (EReference eReference : eClass.getEAllContainments()) {
					if (eReference.getEType() instanceof EClass) {
						columns.addAll(((EClass)eReference.getEType()).getEAllStructuralFeatures());
					}
				}
				registerColumns((EClass) eClassifier, columns.toArray(new EStructuralFeature[columns.size()]));
			}
		}
	}
	
	public void registerColumns(EClass rootClass, EStructuralFeature... columns) {
		columnRegistry.put(rootClass.getInstanceClass(), columns);
	}
	
	public void registerColumns(Class<?> rootClass, EStructuralFeature... columns) {
		columnRegistry.put(rootClass, columns);
	}

	private EStructuralFeature getColumnFeature(int columnIndex) {
		return columnIndex < columns.length ? columns[columnIndex] : null;
	}
	
	@Override
	public boolean setInput(Object input) {
		super.setInput(input);
		
		EStructuralFeature[] newColumns = null;
		for (Map.Entry<Class<?>, EStructuralFeature[]> entry : columnRegistry.entrySet()) {
			if (entry.getKey().isInstance(input)) {
				newColumns = entry.getValue();
				break;
			}
		}
		if (null == newColumns) newColumns = DEFAULT_COLUMNS;
		
		if (!Arrays.equals(newColumns, columns)) {
			columns = newColumns;
			return true;
		}
		return false;
	}
	
	public int getColumnCount() {
		return columns.length;
	}
	
	@Override
	public Object getColumnHeaderValue(int columnIndex) {
		return getColumnFeature(columnIndex);
	}
	
	@Override
	public String getColumnHeaderText(int columnIndex) {
		Object value = getColumnHeaderValue(columnIndex);
		return null == value ? "Object" : getText(value);
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		EStructuralFeature feature = getColumnFeature(columnIndex);
		if (null == feature) { 
			return super.getColumnClass(columnIndex);
		} else if (feature.isMany()) {
			return Collection.class;
		} else if (null != feature.getEType()) {
			return feature.getEType().getInstanceClass();
		} else {
			return super.getColumnClass(columnIndex);
		}
	}
	
	@Override
	public Object getColumnValue(Object element, int columnIndex) {
		EStructuralFeature feature = getColumnFeature(columnIndex);
		if (null == element || null == feature) {
			return element;
		}
		if (feature.getEContainingClass().isInstance(element)) {
			return ((EObject)element).eGet(columns[columnIndex]);
		}
		return null;
	}
	
	@Override
	public String getColumnText(Object element, int columnIndex) {
		Object columnValue = getColumnValue(element, columnIndex);
		if (columnValue instanceof Collection) {
			String result = "";
			for (Iterator<?> i = ((Collection<?>) columnValue).iterator(); i.hasNext();) {
				result += getText(i.next());
				if (i.hasNext()) {
					result += ", ";
				}
			}
			return result.isEmpty() ? null : result.toString();
		}
		return getText(columnValue);
	}
	
	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		Object columnValue = getColumnValue(element, columnIndex);
		if (columnValue instanceof Collection) {
			Iterator<?> i = ((Collection<?>) columnValue).iterator();
			return getImage(i.hasNext() ? i.next() : null);
		}
		return getImage(columnValue);
	}
	
	@Override
	public Image getImage(Object element) {
		// Disable default images as provided by org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider
		return element instanceof EObject ? super.getImage(element) : null;
	}

	@Override
	public Color getBackground(Object element, int columnIndex) {
		EStructuralFeature feature = getColumnFeature(columnIndex);
		if (null != feature && !feature.getEContainingClass().isInstance(element)) {
			return Display.getDefault().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND);
		}
		return null;
	}
	
	@Override
	public Color getForeground(Object element, int columnIndex) {
		return null;
	}
}
