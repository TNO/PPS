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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jface.viewers.IStructuredContentProvider;

public class ManyContentProvider implements IStructuredContentProvider {
	protected static final Object[] EMPTY = new Object[0];
	
	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement == null) {
			return EMPTY;
		}
		if (inputElement instanceof Object[]) {
			return (Object[]) inputElement;
		}
		if (inputElement instanceof Collection<?>) {
			return ((Collection<?>) inputElement).toArray();
		}
		if (inputElement.getClass().isArray()) {
			Object[] inputElements = new Object[Array.getLength(inputElement)];
			for (int i = 0; i < inputElements.length; i++) {
				inputElements[i] = Array.get(inputElement, i);
			}
			return inputElements;
		}
		if (inputElement instanceof Iterable<?>) {
			ArrayList<Object> inputElements = new ArrayList<>();
			for (Object element : (Iterable<?>) inputElement) {
				inputElements.add(element);
			}
			return inputElements.toArray();
		}
		return new Object[] { inputElement };
	}
}
