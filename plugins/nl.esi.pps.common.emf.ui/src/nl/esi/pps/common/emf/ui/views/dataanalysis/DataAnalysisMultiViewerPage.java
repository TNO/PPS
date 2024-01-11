/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.emf.ui.views.dataanalysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.ui.EMFEditUIPlugin;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.part.IPageSite;

import nl.esi.pps.common.ide.ui.views.dataanalysis.DataAnalysisView;
import nl.esi.pps.common.ide.ui.views.dataanalysis.IDataAnalysisPage;
import nl.esi.pps.common.ide.ui.views.dataanalysis.MultiViewerPage;

public abstract class DataAnalysisMultiViewerPage extends MultiViewerPage implements IDataAnalysisPage {

	protected IAction locateValueAction = new LocateValueAction();

	private AdapterFactoryEditingDomain editingDomain;
	private boolean pinned = false;

	public DataAnalysisMultiViewerPage(ISelectionProvider selectionProvider,
			AdapterFactoryEditingDomain editingDomain) {
		super(selectionProvider);
		this.editingDomain = editingDomain;
	}
	
	protected AdapterFactoryEditingDomain getEditingDomain() {
		return editingDomain;
	}
	
	@Override
	public void dispose() {
		editingDomain = null;
		super.dispose();
	}

	@Override
	public void setPinned(boolean pinned) {
		this.pinned = pinned;
		if (!pinned) {
			// Refresh input when viewer is un-pinned
			ISelection selection = getSelectionProvider().getSelection();
			if (selection instanceof IStructuredSelection) {
				setInput(((IStructuredSelection) selection).toArray());
			}
		}
	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		// Ignore the selection when pinned
		if (!pinned) {
			super.selectionChanged(event);
		}
	}
	
	@Override
	public void refresh() {
		// Ignore the refresh when pinned
		if (!pinned) {
			Viewer activeViewer = getActiveViewer();
			if (activeViewer != null) {
				activeViewer.refresh();
			}
		}
	}
	
	@Override
	protected void handleViewerSelectionChanged(SelectionChangedEvent event) {
		locateValueAction.setEnabled(!event.getSelection().isEmpty());
	}
	
	@Override
	public void init(IPageSite pageSite) {
		super.init(pageSite);
		locateValueAction.setEnabled(false);
	}
	
	@Override
	public void makeContributions(IMenuManager menuManager, IToolBarManager toolBarManager,
			IStatusLineManager statusLineManager) {
		super.makeContributions(menuManager, toolBarManager, statusLineManager);
		toolBarManager.insertBefore(DataAnalysisView.GROUP_VIEW_END, locateValueAction);
	}

	abstract protected void setSelectionToViewer(List<?> selection);

	protected class LocateValueAction extends Action {
		public LocateValueAction() {
			setText(EMFEditUIPlugin.INSTANCE.getString("_UI_LocateValue_action"));
			setToolTipText(EMFEditUIPlugin.INSTANCE.getString("_UI_LocateValue_action_tool_tip"));
			setImageDescriptor(ExtendedImageRegistry.INSTANCE
					.getImageDescriptor(EMFEditUIPlugin.INSTANCE.getImage("full/elcl16/LocateValue")));
			setDisabledImageDescriptor(ExtendedImageRegistry.INSTANCE
					.getImageDescriptor(EMFEditUIPlugin.INSTANCE.getImage("full/dlcl16/LocateValue")));
		}

		@Override
		public void run() {
			List<Object> selection = new ArrayList<Object>();
			for (Object object : selectionToList(getActiveViewer().getSelection())) {
				selection.add(editingDomain.getWrapper(object));
			}
			setSelectionToViewer(selection);
		}

		private List<?> selectionToList(ISelection selection) {
			if (selection instanceof IStructuredSelection) {
				return ((IStructuredSelection) selection).toList();
			}
			return Collections.emptyList();
		}
	}
}
