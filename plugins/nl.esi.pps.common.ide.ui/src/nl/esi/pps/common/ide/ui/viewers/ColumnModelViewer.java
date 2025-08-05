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


import org.eclipse.swt.SWTException;

public interface ColumnModelViewer {
	void setColumnModel(ColumnModel model);
	
	ColumnModel getColumnModel();
	
	/**
	 * Returns the direction of the sort indicator for the receiver. 
	 * The value will be one of <code>UP</code>, <code>DOWN</code> 
	 * or <code>NONE</code>.
	 *
	 * @return the sort direction
	 *
	 * @exception SWTException <ul>
	 *    <li>ERROR_WIDGET_DISPOSED - if the receiver has been disposed</li>
	 *    <li>ERROR_THREAD_INVALID_ACCESS - if not called from the thread that created the receiver</li>
	 * </ul>
	 */
	int getSortDirection ();
}
