/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.common.ide.ui.status;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import nl.esi.pps.common.ide.ui.viewers.AbstractColumnModel;

public class StatusColumnModel extends AbstractColumnModel {
	public StatusColumnModel() {
		super(new LabelProvider());
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	protected Object getColumnHeaderValue(int columnIndex) {
		switch (columnIndex) {
		case 0:return "Message";
		case 1:return "Plug-in";
		default: return "Unknown";
		}
	}
	
	@Override
	public Object getColumnValue(Object element, int columnIndex) {
		if (element instanceof IStatus) {
			switch (columnIndex) {
			case 0:return ((IStatus)element).getMessage();
			case 1:return ((IStatus)element).getPlugin();
			default: return "Unknown column: " + columnIndex;
			}
		}
		return null;
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}
	
	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		if (columnIndex == 0 && element instanceof IStatus) {
			final ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
			switch (((IStatus) element).getSeverity()) {
			case IStatus.ERROR: return sharedImages.getImage(ISharedImages.IMG_OBJS_ERROR_TSK);
			case IStatus.WARNING: return sharedImages.getImage(ISharedImages.IMG_OBJS_WARN_TSK);
			case IStatus.INFO: return sharedImages.getImage(ISharedImages.IMG_OBJS_INFO_TSK);
			}
		}
		return null;
	}
}
