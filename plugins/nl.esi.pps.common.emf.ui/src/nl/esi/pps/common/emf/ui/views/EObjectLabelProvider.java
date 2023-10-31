/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.common.emf.ui.views;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;

import nl.esi.pps.common.ide.ui.viewers.DelegateLabelProvider;

public class EObjectLabelProvider extends DelegateLabelProvider {
	private final List<String> labelProperties;

	public EObjectLabelProvider(ILabelProvider delegate, String... labelProperties) {
		this(delegate, true, true, labelProperties);
	}

	public EObjectLabelProvider(ILabelProvider delegate, boolean showImage, boolean showText, String... labelProperties) {
		super(delegate, showImage, showText);
		this.labelProperties = Arrays.asList(labelProperties);
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return labelProperties.contains(property) || super.isLabelProperty(element, property);
	}
	
	@Override
	public Image getImage(Object element) {
		return super.getImage(getLabelElement(element));
	}

	@Override
	public String getText(Object element) {
		return super.getText(getLabelElement(element));
	}

	private Object getLabelElement(Object element) {
		Object labelElement = element;
		if (element instanceof EObject) {
			EObject eObject = (EObject) element;
			EList<EStructuralFeature> properties = eObject.eClass().getEAllStructuralFeatures();
			for (String labelProperty : labelProperties) {
				for (EStructuralFeature property : properties) {
					if (labelProperty.equals(property.getName())) {
						labelElement = eObject.eGet(property);
					}
				}
			}
		}
		return labelElement;
	}
}
