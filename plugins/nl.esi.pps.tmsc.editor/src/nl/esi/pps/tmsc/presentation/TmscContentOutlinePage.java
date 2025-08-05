/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.presentation;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.resource.ResourceLocator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Composite;

import com.google.common.base.Objects;

import nl.esi.pps.common.emf.ui.views.contentoutline.FilteredContentOutlinePage;
import nl.esi.pps.tmsc.LifelineSegment;

public class TmscContentOutlinePage extends FilteredContentOutlinePage {
	private final ViewerFilter LIFELINE_SEGMENT_FILTER = new ViewerFilter() {
		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			return !(element instanceof LifelineSegment);
		}
	}; 

	private Action hideLifelineSegmentsSelection = new Action("Hide Lifeline Segments", Action.AS_CHECK_BOX) {
		{
			setImageDescriptor(ResourceLocator.imageDescriptorFromBundle(TmscEditorPlugin.getPlugin().getSymbolicName(),
					"icons/hide_LifelineSegment.gif").orElse(null));
			setChecked(true);
		}
		
		@Override
		public void run() {
			if (isChecked()) {
				getTreeViewer().addFilter(LIFELINE_SEGMENT_FILTER);
			} else {
				getTreeViewer().removeFilter(LIFELINE_SEGMENT_FILTER);
			}
		}
	};

	private Action sortAction = new Action("Sort", Action.AS_CHECK_BOX) {
		{
			setImageDescriptor(ResourceLocator.imageDescriptorFromBundle(TmscEditorPlugin.getPlugin().getSymbolicName(),
					"icons/alphab_sort_co.png").orElse(null));
			setChecked(true);
		}
		
		@Override
		public void run() {
			if (isChecked()) {
				getTreeViewer().setComparator(new TmscContentOutlineComparator());
			} else {
				getTreeViewer().setComparator(null);
			}
		}
	};
	
	private Action pushContextAction = new Action("Push Context", Action.AS_CHECK_BOX) {
		{
			setImageDescriptor(ResourceLocator.imageDescriptorFromBundle(TmscEditorPlugin.getPlugin().getSymbolicName(), 
					"icons/push_context.png").orElse(null));
			setChecked(true);
		}

		@Override
		public void run() {
			if (isChecked()) {
				fireSelectionChanged(getSelection());
			}
		}
	};

	private Action pushSelection = new Action("Push Selection", Action.AS_CHECK_BOX) {
		{
			setImageDescriptor(ResourceLocator.imageDescriptorFromBundle(TmscEditorPlugin.getPlugin().getSymbolicName(),
					"icons/push_selection.png").orElse(null));
			setChecked(true);
		}
		
		@Override
		public void run() {
			if(isChecked()) {
				fireSelectionChanged(getSelection());
			}
		}
	};
	
	private Action pushTimeRange = new Action("Push Time Range", Action.AS_CHECK_BOX) {
		{
			setImageDescriptor(ResourceLocator.imageDescriptorFromBundle(TmscEditorPlugin.getPlugin().getSymbolicName(),
					"icons/push_time.png").orElse(null));
			setChecked(false);
		}
		
		@Override
		public void run() {
			if(isChecked()) {
				fireSelectionChanged(getSelection());
			}
		}
	};

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		if (sortAction.isChecked()) {
			sortAction.run();
		}
		if (hideLifelineSegmentsSelection.isChecked()) {
			hideLifelineSegmentsSelection.run();
		}
	}

	@Override
	public void makeContributions(IMenuManager menuManager, IToolBarManager toolBarManager,
			IStatusLineManager statusLineManager) {
		super.makeContributions(menuManager, toolBarManager, statusLineManager);
		toolBarManager.add(sortAction);
		toolBarManager.add(pushContextAction);
		toolBarManager.add(pushSelection);
		toolBarManager.add(pushTimeRange);
		toolBarManager.add(hideLifelineSegmentsSelection);
	}
	
	public boolean isSort() {
		return sortAction.isChecked();
	}
	
	public boolean isPushContext() {
		return pushContextAction.isChecked();
	}
	
	public boolean isPushSelection() {
		return pushSelection.isChecked();
	}
	
	public boolean isPushTimeRange() {
		return pushTimeRange.isChecked();
	}
	
	@Override
	public void setSelection(ISelection selection) {
		clearFilter();
		super.setSelection(selection);
	}
	
	public boolean setSelection(ISelection selection, boolean reveal) {
		clearFilter();
		if (filteredTree == null) {
			return false;
		}
		filteredTree.getViewer().setSelection(selection, true);
		ISelection updatedSelection = filteredTree.getViewer().getSelection();
		return Objects.equal(selection, updatedSelection);
	}
}
