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


import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

public class DelegateLabelProvider implements ILabelProvider {
	private final ILabelProvider delegate;
	private final boolean showImage;
	private final boolean showText;

	public DelegateLabelProvider(ILabelProvider delegate) {
		this(delegate, true, true);
	}

	public DelegateLabelProvider(ILabelProvider delegate, boolean showImage) {
		this(delegate, showImage, true);
	}
	
	public DelegateLabelProvider(ILabelProvider delegate, boolean showImage, boolean showText) {
		this.delegate = delegate;
		this.showImage = showImage;
		this.showText = showText;
	}
	
	protected ILabelProvider getDelegate() {
		return delegate;
	}

	public Image getImage(Object element) {
		if (!showImage) return null;
		return delegate.getImage(element);
	}

	public String getText(Object element) {
		if (!showText) return null;
		return delegate.getText(element);
	}

	public void addListener(ILabelProviderListener listener) {
		delegate.addListener(listener);
	}

	public void dispose() {
		delegate.dispose();
	}

	public boolean isLabelProperty(Object element, String property) {
		return delegate.isLabelProperty(element, property);
	}

	public void removeListener(ILabelProviderListener listener) {
		delegate.removeListener(listener);
	}
}
