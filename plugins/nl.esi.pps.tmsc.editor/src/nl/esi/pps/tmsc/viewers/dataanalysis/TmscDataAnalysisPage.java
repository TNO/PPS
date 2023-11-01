/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.viewers.dataanalysis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ResourceLocator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.trace4cps.common.jfreechart.ui.viewers.ChartPanelContentViewer;
import org.eclipse.ui.part.IPageSite;

import nl.esi.pps.common.emf.synchronizedtiming.jfree.ExportImageAction;
import nl.esi.pps.common.emf.ui.views.dataanalysis.DataAnalysisMultiViewerPage;
import nl.esi.pps.common.ide.ui.action.DropDownMenuAction;
import nl.esi.pps.common.ide.ui.action.DropDownMenuAction.DropDownAction;
import nl.esi.pps.common.ide.ui.views.dataanalysis.DataAnalysisView;

import nl.esi.pps.tmsc.presentation.TmscEditor;
import nl.esi.pps.tmsc.presentation.TmscEditorPlugin;
import nl.esi.pps.tmsc.provider.ext.ui.AdapterFactoryDataAnalysisContentProvider;
import nl.esi.pps.tmsc.provider.ext.ui.IDataAnalysisInput;

public abstract class TmscDataAnalysisPage extends DataAnalysisMultiViewerPage
		implements IEditingDomainProvider, ISelectionProvider {
	
	private static final String DATA_ANALYSIS_NOT_AVAILABLE = "Not available";

	private final ExportImageAction exportImageAction = new ExportImageAction();
	private final DurationFilterAction durationFilterAction = new DurationFilterAction(() -> getSite().getShell());

	private final ArrayList<ISelectionChangedListener> selectionChangedListeners = new ArrayList<>();
	private ISelection pageSelection = StructuredSelection.EMPTY;

	private final AdapterFactoryDataAnalysisContentProvider contentProvider;
	
	private DataAnalysisViewerType viewerType = DataAnalysisViewerType.TIME_SERIES;

	public TmscDataAnalysisPage(TmscEditor editor) {
		super(editor, editor.getEditingDomain());
		contentProvider = new AdapterFactoryDataAnalysisContentProvider(editor.getEditingDomain().getAdapterFactory());
	}

	@Override
	public AdapterFactoryEditingDomain getEditingDomain() {
		return super.getEditingDomain();
	}

	@Override
	public void init(IPageSite pageSite) {
		super.init(pageSite);
		pageSite.setSelectionProvider(this);
	}

	@Override
	protected void createViewerPages() {
		addNotAvailablePage();
	}

	@Override
	public void makeContributions(IMenuManager menuManager, IToolBarManager toolBarManager,
			IStatusLineManager statusLineManager) {
		super.makeContributions(menuManager, toolBarManager, statusLineManager);

		menuManager.insertBefore(DataAnalysisView.GROUP_VIEW_END, durationFilterAction);
		toolBarManager.insertBefore(DataAnalysisView.GROUP_VIEW_END, durationFilterAction);

		menuManager.insertBefore(DataAnalysisView.GROUP_VIEW_END, exportImageAction);
		
		DataAnalysisViewerType[] viewerTypes = DataAnalysisViewerType.values();
		DropDownAction[] viewerTypeActions = new DropDownAction[viewerTypes.length];
		for (int i = 0; i < viewerTypes.length; i++) {
			viewerTypeActions[i] = new SelectDataAnalysisViewerTypeAction(viewerTypes[i]);
		}
		DropDownMenuAction selectViewerTypeAction = new DropDownMenuAction("Select Data Analysis Type",
				viewerTypeActions);
		toolBarManager.insertBefore(DataAnalysisView.GROUP_VIEW, selectViewerTypeAction);
	}

	@Override
	public void dispose() {
		// Workaround for memory leak in menu manager due to Eclipse bug 543827
		exportImageAction.setChartPanelComposite(null);
		super.dispose();
	}

	@Override
	protected void inputChanged(Object[] oldInput, Object[] newInput) {
		IDataAnalysisInput dataAnalysisInput = contentProvider.getDataAnalysisInput(newInput);
		Collection<String> configurations = dataAnalysisInput == null ? Collections.emptyList() : dataAnalysisInput.getConfigurations();
		if (shouldUpdateTabs(configurations)) {
			String activeConfiguration = getActivePageText();
			removeAllPages();
			if (configurations.isEmpty()) {
				addNotAvailablePage();
			} else {
				for (String configuration : configurations) {
					addTmscDataAnalysisViewer(configuration);
				}
			}
			setActivePage(activeConfiguration, 0);
		}
		super.inputChanged(oldInput, newInput);
	}
	
	protected String getActivePageText() {
		int pageIndex = getActivePage();
		return pageIndex < 0 ? null : getPageText(pageIndex);
	}
	
	protected void setActivePage(String pageText, int defaultIndex) {
		if (pageText != null) {
			for (int pageIndex = 0; pageIndex < getPageCount(); pageIndex++) {
				if (getPageText(pageIndex).equals(pageText)) {
					setActivePage(pageIndex);
					return;
				}
			}
		}
		setActivePage(defaultIndex);
	}
	
	private boolean shouldUpdateTabs(Collection<String> configurations) {
		if (configurations.isEmpty() && getPageCount() == 1) {
			return !Objects.equals(getPageData(0), DATA_ANALYSIS_NOT_AVAILABLE);
		}
		ArrayList<String> confList = new ArrayList<String>(configurations);
		if (confList.size() != getPageCount()) {
			return true;
		}
		Class<?> viewerClazz = null;
		switch (viewerType) {
		case TIME_SERIES:
			viewerClazz = TmscTimeSeriesViewer.class;
			break;
		case HISTOGRAM:
			viewerClazz = TmscHistogramViewer.class;
			break;
		}
		for (int i = 0; i < confList.size(); i++) {
			if (!Objects.equals(confList.get(i), getPageText(i)) || !viewerClazz.isInstance(getPageData(i))) {
				return true;
			}
		}
		return false;
	}
	
	private void addNotAvailablePage() {
		Label label = new Label(getContainer(), SWT.NONE);
		label.setText("Data analysis is not available for current selection.");
		int pageIndex = addPage(label, DATA_ANALYSIS_NOT_AVAILABLE);
		setPageData(pageIndex, DATA_ANALYSIS_NOT_AVAILABLE);
	}

	private void addTmscDataAnalysisViewer(String configuration) {
		TmscDataAnalysisViewer dataAnalysisViewer = null;
		switch (viewerType) {
		case TIME_SERIES:
			dataAnalysisViewer = new TmscTimeSeriesViewer(getContainer(), durationFilterAction.getDurationFilter(),
					configuration);
			break;
		case HISTOGRAM:
			dataAnalysisViewer = new TmscHistogramViewer(getContainer(), durationFilterAction.getDurationFilter(),
					configuration);
			break;
		}
		dataAnalysisViewer.setContentProvider(
				new AdapterFactoryDataAnalysisContentProvider(getEditingDomain().getAdapterFactory()));
		dataAnalysisViewer.setLabelProvider(new AdapterFactoryLabelProvider(getEditingDomain().getAdapterFactory()));
		addViewer(dataAnalysisViewer, configuration);
	}

	@Override
	protected void viewerChanged(Viewer oldViewer, Viewer newViewer) {
		super.viewerChanged(oldViewer, newViewer);
		exportImageAction.setChartPanelComposite(newViewer instanceof ChartPanelContentViewer
				? ((ChartPanelContentViewer) newViewer).getChartPanelComposite()
				: null);
	}

	@Override
	protected void handleViewerSelectionChanged(SelectionChangedEvent event) {
		super.handleViewerSelectionChanged(event);
		setSelection(event.getSelection());
	}

	@Override
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		selectionChangedListeners.add(listener);
	}

	@Override
	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
		selectionChangedListeners.remove(listener);
	}

	@Override
	public ISelection getSelection() {
		return pageSelection;
	}

	@Override
	public void setSelection(ISelection selection) {
		pageSelection = selection;
		for (ISelectionChangedListener listener : selectionChangedListeners) {
			listener.selectionChanged(new SelectionChangedEvent(this, selection));
		}
	}

	private enum DataAnalysisViewerType {
		/** Time series */
		TIME_SERIES("Time series",
				ResourceLocator.imageDescriptorFromBundle(TmscEditorPlugin.getPlugin().getSymbolicName(),
						"icons/analysisprovider_obj.gif").orElse(null)),
		/** Histogram */
		HISTOGRAM("Histogram", ResourceLocator
				.imageDescriptorFromBundle(TmscEditorPlugin.getPlugin().getSymbolicName(), "icons/histogram.gif")
				.orElse(null));

		private final String label;
		private final ImageDescriptor imageDescriptor;

		private DataAnalysisViewerType(String label, ImageDescriptor imageDescriptor) {
			this.label = label;
			this.imageDescriptor = imageDescriptor;
		}

		public String getLabel() {
			return label;
		}

		public ImageDescriptor getImageDescriptor() {
			return imageDescriptor;
		}
	}

	private class SelectDataAnalysisViewerTypeAction extends DropDownAction {
		private final DataAnalysisViewerType type;
		
		public SelectDataAnalysisViewerTypeAction(DataAnalysisViewerType type) {
			super(type.getLabel(), type.getImageDescriptor());
			setChecked(type == viewerType);
			this.type = type;
		}
		
		@Override
		protected void runChecked() {
			viewerType = type;
			inputChanged(getInput(), getInput());
		}
	}
}
