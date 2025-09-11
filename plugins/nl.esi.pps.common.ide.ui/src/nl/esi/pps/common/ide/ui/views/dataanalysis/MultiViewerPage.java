/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.ide.ui.views.dataanalysis;

import java.util.Arrays;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.SubActionBars;

public abstract class MultiViewerPage extends MultiPagePage implements ISelectionChangedListener {

	private final String ACTIONBARS_KEY = "MultiViewerPage:SubActionBars";
	
	private Object[] input;

	private Viewer activeViewer;

	private ISelectionProvider selectionProvider;

	public MultiViewerPage() {
		this(null);
	}
	
	public MultiViewerPage(ISelectionProvider selectionProvider) {
		super();
		this.selectionProvider = selectionProvider;
	}
	
	protected ISelectionProvider getSelectionProvider() {
		return selectionProvider;
	}

	@Override
	protected final void createPages() {
		createViewerPages();

		if (selectionProvider != null) {
			// Populate the new page with the current selection
			ISelection selection = selectionProvider.getSelection();
			if (selection instanceof IStructuredSelection) {
				setInput(((IStructuredSelection) selection).toArray());
			}
			selectionProvider.addSelectionChangedListener(this);
		}

		activeViewer = getActiveViewer();
		addPageChangedListener(e -> viewerChanged(activeViewer, getActiveViewer()));
	}

	abstract protected void createViewerPages();

	public void setInput(Object[] input) {
		if (Arrays.equals(this.input, input)) {
			return;
		}
		
		Object[] oldInput = this.input;
		this.input = input;
		inputChanged(oldInput, input);
	}
	
	protected void inputChanged(Object[] oldInput, Object[] newInput) {
		if (activeViewer != null) {
			activeViewer.setInput(newInput);
		}
	}
	
	protected Object[] getInput() {
		return input;
	}

	protected void viewerChanged(Viewer oldViewer, Viewer newViewer) {
		if (oldViewer == newViewer) {
			return;
		}
		if (oldViewer != null) {
			// Clear the previous active viewer to avoid memory leakage
			oldViewer.removeSelectionChangedListener(this::handleViewerSelectionChanged);
			oldViewer.setInput(null);
			SubActionBars subActionBars = (SubActionBars) oldViewer.getData(ACTIONBARS_KEY);
			if (subActionBars != null) {
				subActionBars.deactivate();
			}
		}
		activeViewer = newViewer;
		if (activeViewer != null) {
			activeViewer.addSelectionChangedListener(this::handleViewerSelectionChanged);
			activeViewer.setInput(input);
			SubActionBars subActionBars = (SubActionBars) activeViewer.getData(ACTIONBARS_KEY);
			if (subActionBars != null) {
				subActionBars.activate();
			}
		}
		getSite().getActionBars().updateActionBars();
	}
	
	protected void handleViewerSelectionChanged(SelectionChangedEvent event) {
		// Do nothing
	}

	@Override
	public void removePage(int pageIndex) {
		Viewer viewer = getViewer(pageIndex);
		if (viewer != null) {
			if (viewer == activeViewer) {
				viewerChanged(viewer, null);
			}
			SubActionBars subActionBars = (SubActionBars) viewer.getData(ACTIONBARS_KEY);
			if (subActionBars != null) {
				subActionBars.dispose();
			}
		}

		super.removePage(pageIndex);
	}

	@Override
	public void dispose() {
		if (selectionProvider != null) {
			selectionProvider.removeSelectionChangedListener(this);
			selectionProvider = null;
		}
		if (activeViewer != null) {
			// Clear the previous active viewer to avoid memory leakage
			activeViewer.removeSelectionChangedListener(this::handleViewerSelectionChanged);
			activeViewer = null;
		}
		input = null;
		super.dispose();
	}

	protected void addViewer(Viewer pageViewer, String pageText, SubActionBars subActionBars) {
		addViewer(pageViewer, pageText);
		pageViewer.setData(ACTIONBARS_KEY, subActionBars);
	}
	
	protected void addViewer(Viewer pageViewer, String pageText) {
		int pageIndex = addPage(pageViewer.getControl(), pageText);
		setPageData(pageIndex, pageViewer);
	}

	private Viewer getViewer(int pageIndex) {
		final Object pageData = getPageData(pageIndex);
		return (pageData instanceof Viewer) ? (Viewer) pageData : null;
	}

	protected Viewer getActiveViewer() {
		int activePageIndex = getActivePage();
		if (activePageIndex < 0) {
			return null;
		}
		return getViewer(activePageIndex);
	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		ISelection selection = event.getSelection();
		if (selection instanceof IStructuredSelection) {
			setInput(((IStructuredSelection) selection).toArray());
		}
	}
}