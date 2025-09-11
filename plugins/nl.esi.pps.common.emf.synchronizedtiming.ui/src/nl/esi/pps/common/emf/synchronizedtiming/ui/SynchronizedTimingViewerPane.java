/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.emf.synchronizedtiming.ui;

import static java.lang.String.format;
import static nl.esi.pps.common.emf.synchronizedtiming.ui.Activator.IMAGE_DATASET_VIEW;
import static nl.esi.pps.common.emf.synchronizedtiming.ui.Activator.IMAGE_MARGIN_SYNC;
import static nl.esi.pps.common.emf.synchronizedtiming.ui.Activator.IMAGE_MARGIN_SYNC_ENABLED;
import static nl.esi.pps.common.emf.synchronizedtiming.ui.Activator.IMAGE_TIME_SYNC;
import static nl.esi.pps.common.emf.synchronizedtiming.ui.Activator.IMAGE_TIME_SYNC_ENABLED;
import static nl.esi.pps.common.emf.synchronizedtiming.ui.Activator.IMAGE_ZOOM_OUT_HORIZONTAL;
import static nl.esi.pps.common.emf.synchronizedtiming.ui.Activator.IMAGE_ZOOM_OUT_VERTICAL;
import static nl.esi.pps.common.emf.synchronizedtiming.ui.Activator.IMAGE_ZOOM_VIEW;

import java.awt.Rectangle;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.SubContributionItem;
import org.eclipse.lsat.common.emf.common.util.URIHelper;
import org.eclipse.lsat.common.emf.ui.ActionsViewerPane;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.trace4cps.common.jfreechart.ui.viewers.ChartPanelSelectionHandler;
import org.eclipse.trace4cps.common.jfreechart.ui.viewers.ChartPanelSelectionHandler.Axis;
import org.eclipse.trace4cps.common.jfreechart.ui.viewers.ChartPanelSelectionHandler.SelectionType;
import org.eclipse.trace4cps.common.jfreechart.ui.viewers.ChartPanelViewer;
import org.eclipse.trace4cps.common.jfreechart.ui.widgets.ChartPanelComposite;
import org.eclipse.trace4cps.common.jfreechart.ui.widgets.ChartPanelCompositeHistory;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.plot.Zoomable;

import nl.esi.pps.common.emf.synchronizedtiming.TimeSyncSupport;
import nl.esi.pps.common.emf.synchronizedtiming.TimeSyncSupportProvider;
import nl.esi.pps.common.emf.synchronizedtiming.jfree.ExportImageAction;
import nl.esi.pps.common.emf.synchronizedtiming.jfree.ShowLegendAction;

public abstract class SynchronizedTimingViewerPane extends ActionsViewerPane {
	protected static final String GROUP_VIEW = "view";
	protected static final String GROUP_ZOOM = "zoom";
	protected static final String GROUP_NAVIGATION = "navigation";
	protected static final String GROUP_SYNCHRONIZED_TIMING = "synchronized-timing";

	protected final TimeSyncAction timeSyncAction = new TimeSyncAction();
	protected final TimeSyncEnabledAction timeSyncEnabledAction = new TimeSyncEnabledAction();
	protected final MarginSyncAction marginSyncAction = new MarginSyncAction();
	protected final MarginSyncEnabledAction marginSyncEnabledAction = new MarginSyncEnabledAction();
	protected final RestoreAutoBoundsAction restoreAutoBoundsAction = new RestoreAutoBoundsAction(Dimension.ALL);
	protected final RestoreAutoBoundsAction restoreHorizontalBoundsAction = new RestoreAutoBoundsAction(Dimension.HORIZONTAL);
	protected final RestoreAutoBoundsAction restoreVerticalBoundsAction = new RestoreAutoBoundsAction(Dimension.VERTICAL);
	protected final ShowAllDatasetContentAction showAllDatasetContentAction = new ShowAllDatasetContentAction();
	protected final ZoomInAction zoomInAction = new ZoomInAction();
	protected final ZoomOutAction zoomOutAction = new ZoomOutAction();
	protected final ZoomToSelectionXAction zoomToSelectionXAction = new ZoomToSelectionXAction();
	protected final ZoomToSelectionYAction zoomToSelectionYAction = new ZoomToSelectionYAction();
	protected @Nullable ViewerShowLegendAction showLegendAction; // Initialized in 'createControl' method.
	protected @Nullable ViewerExportImageAction exportImageAction; // Initialized in 'createControl' method.

	public SynchronizedTimingViewerPane(IWorkbenchPage page, IWorkbenchPart part) {
		super(page, part);
	}

	protected @Nullable TimeSyncSupport getTimeSyncSupport() {
		if (viewer instanceof TimeSyncSupportProvider) {
			return ((TimeSyncSupportProvider) viewer).getTimeSyncSupport();
		}
		return null;
	}
	
	protected @Nullable ChartPanelViewer getChartPanelViewer() {
		if (viewer instanceof ChartPanelViewer) {
			return (ChartPanelViewer) viewer;
		}
		return null;
	}

	@Nullable ChartPanelComposite getChartPanelComposite() {
		final ChartPanelViewer chartPanelViewer = getChartPanelViewer();
		return chartPanelViewer == null ? null : chartPanelViewer.getChartPanelComposite();
	}
	
	@Override
	public void createControl(@Nullable Composite parent) {
		super.createControl(parent);

		getMenuManager().insertBefore(GROUP_ACTIONS, new Separator(GROUP_NAVIGATION));
		getMenuManager().insertBefore(GROUP_ACTIONS, new Separator(GROUP_ZOOM));
		getMenuManager().insertBefore(GROUP_ACTIONS, new Separator(GROUP_SYNCHRONIZED_TIMING));
		getMenuManager().insertBefore(GROUP_ACTIONS, new Separator(GROUP_VIEW));

		getToolBarManager().insertBefore(GROUP_ACTIONS, new Separator(GROUP_NAVIGATION));
		getToolBarManager().insertBefore(GROUP_ACTIONS, new Separator(GROUP_ZOOM));
		getToolBarManager().insertBefore(GROUP_ACTIONS, new Separator(GROUP_SYNCHRONIZED_TIMING));
		getToolBarManager().insertBefore(GROUP_ACTIONS, new Separator(GROUP_VIEW));


		if (null != getTimeSyncSupport()) {
			addTimeSyncActions();
		}

		if (null != getChartPanelViewer()) {
			addNavigationActions();
			addZoomActions();
			addViewActions();
		}

		updateActionBars();
	}

	/**
	 * This removes from the specified <code>manager</code> all {@link org.eclipse.jface.action.ActionContributionItem}s
	 * based on the {@link org.eclipse.jface.action.IAction}s contained in the <code>actions</code> collection.
	 */
	protected void depopulateManager(IContributionManager manager, Collection<? extends IAction> actions) {
		IContributionItem[] items = manager.getItems();
		for (int i = 0; i < items.length; i++) {
			// Look into SubContributionItems
			//
			IContributionItem contributionItem = items[i];
			while (contributionItem instanceof SubContributionItem) {
				contributionItem = ((SubContributionItem)contributionItem).getInnerItem();
			}

			// Delete the ActionContributionItems with matching action.
			if (contributionItem instanceof ActionContributionItem) {
				IAction action = ((ActionContributionItem)contributionItem).getAction();
				if (actions.contains(action)) {
					manager.remove(contributionItem);
				}
			}
		}
	}

	protected void addTimeSyncActions() {
		timeSyncEnabledAction.update();
		marginSyncEnabledAction.update();

		getMenuManager().appendToGroup(GROUP_SYNCHRONIZED_TIMING, marginSyncEnabledAction);
		getMenuManager().appendToGroup(GROUP_SYNCHRONIZED_TIMING, timeSyncEnabledAction);

		getToolBarManager().appendToGroup(GROUP_SYNCHRONIZED_TIMING, marginSyncEnabledAction);
		getToolBarManager().appendToGroup(GROUP_SYNCHRONIZED_TIMING, marginSyncAction);
		getToolBarManager().appendToGroup(GROUP_SYNCHRONIZED_TIMING, timeSyncEnabledAction);
		getToolBarManager().appendToGroup(GROUP_SYNCHRONIZED_TIMING, timeSyncAction);
	}

	@SuppressWarnings("null")
	protected void addZoomActions() {
		getToolBarManager().appendToGroup(GROUP_ZOOM, showAllDatasetContentAction);
		getToolBarManager().appendToGroup(GROUP_ZOOM, restoreAutoBoundsAction);
		getToolBarManager().appendToGroup(GROUP_ZOOM, restoreHorizontalBoundsAction);
		getToolBarManager().appendToGroup(GROUP_ZOOM, restoreVerticalBoundsAction);
		getToolBarManager().appendToGroup(GROUP_ZOOM, zoomOutAction);
		getToolBarManager().appendToGroup(GROUP_ZOOM, zoomInAction);
		
		ChartPanelSelectionHandler chartPanelSelectionHandler = getChartPanelViewer().getChartPanelSelectionHandler();
		if (chartPanelSelectionHandler.getSelectionType() != SelectionType.None) {
			chartPanelSelectionHandler.getSelectionProvider().addSelectionChangedListener(e -> {
				zoomToSelectionXAction.setEnabled(!e.getSelection().isEmpty());
				zoomToSelectionYAction.setEnabled(!e.getSelection().isEmpty());
			});
			getToolBarManager().appendToGroup(GROUP_ZOOM, zoomToSelectionXAction);
			getToolBarManager().appendToGroup(GROUP_ZOOM, zoomToSelectionYAction);
		}
	}
	
	protected void addNavigationActions() {
		ChartPanelCompositeHistory history = new ChartPanelCompositeHistory(getChartPanelComposite());
		getToolBarManager().appendToGroup(GROUP_NAVIGATION, history.getBackAction());
		getToolBarManager().appendToGroup(GROUP_NAVIGATION, history.getForwardAction());
	}

	protected void addViewActions() {
		exportImageAction = new ViewerExportImageAction(getChartPanelComposite());
		showLegendAction = new ViewerShowLegendAction(getChartPanelComposite());

		getMenuManager().appendToGroup(GROUP_VIEW, exportImageAction);
		getMenuManager().appendToGroup(GROUP_VIEW, showLegendAction);
	}
		
	protected class TimeSyncAction extends Action {
		public TimeSyncAction() {
			super("Synchronize Time Range", Activator.getDescriptor(IMAGE_TIME_SYNC));
			setToolTipText("Synchonizes the current time range to all other supported editors/views.");
		}

		@Override
		@SuppressWarnings("null")
		public void run() {
			SynchronizedTimingViewerPane.this.getTimeSyncSupport().sendTimeRangeChangedEvent(true);
		}
	}

	protected class TimeSyncEnabledAction extends Action {
		public TimeSyncEnabledAction() {
			super("Time Range Synchronization Enabled", IAction.AS_CHECK_BOX);
			setImageDescriptor(Activator.getDescriptor(IMAGE_TIME_SYNC_ENABLED));
			setToolTipText("If checked, this editor/view will participate in time range synchronization.");
		}

		@SuppressWarnings("null")
		public void update() {
			setChecked(SynchronizedTimingViewerPane.this.getTimeSyncSupport().isEnabledTimeSync());
		}

		@Override
		@SuppressWarnings("null")
		public void run() {
			SynchronizedTimingViewerPane.this.getTimeSyncSupport().setEnabledTimeSync(isChecked());
			update();
		}
	}

	protected class MarginSyncAction extends Action {
		public MarginSyncAction() {
			super("Synchronize Margin Width", Activator.getDescriptor(IMAGE_MARGIN_SYNC));
			setToolTipText("Synchonizes the current margin width to all other supported editors/views.");
		}

		@Override
		@SuppressWarnings("null")
		public void run() {
			SynchronizedTimingViewerPane.this.getTimeSyncSupport().sendViewMarginWidthChangedEvent(true);
		}
	}

	protected class MarginSyncEnabledAction extends Action {
		public MarginSyncEnabledAction() {
			super("Margin Synchronization Enabled", IAction.AS_CHECK_BOX);
			setImageDescriptor(Activator.getDescriptor(IMAGE_MARGIN_SYNC_ENABLED));
			setToolTipText("If checked, this editor/view will participate in margin with synchronization.");
		}

		@SuppressWarnings("null")
		public void update() {
			setChecked(SynchronizedTimingViewerPane.this.getTimeSyncSupport().isEnabledMarginSync());
		}

		@Override
		@SuppressWarnings("null")
		public void run() {
			SynchronizedTimingViewerPane.this.getTimeSyncSupport().setEnabledMarginSync(isChecked());
			update();
		}
	}

	protected enum Dimension {
		ALL(IMAGE_ZOOM_VIEW), HORIZONTAL(IMAGE_ZOOM_OUT_HORIZONTAL), VERTICAL(IMAGE_ZOOM_OUT_VERTICAL);
		private final String imageKey;

		private Dimension(String imageKey) {
			this.imageKey = imageKey;
		}

		public String getImageKey() {
			return imageKey;
		}

		@Override
		public String toString() {
			final String name = super.toString();
			return Character.toUpperCase(name.charAt(0)) + name.substring(1).toLowerCase();
		}
	}

	protected class RestoreAutoBoundsAction extends Action {
		private final Dimension dimension;

		public RestoreAutoBoundsAction(Dimension dimension) {
			super(format("Zoom To Fit %s", dimension), Activator.getDescriptor(dimension.getImageKey()));
			setToolTipText(format("Zoom to fit %s content.", dimension.name().toLowerCase()));
			this.dimension = dimension;
		}

		@Override
		public void run() {
			ChartPanelComposite chartPanelComposite = getChartPanelComposite();
			if (null == chartPanelComposite) return;
			ChartPanel chartPanel = chartPanelComposite.getChartPanel();
			if (null == chartPanel) return;
			JFreeChart chart = chartPanel.getChart();
			if (null == chart || !(chart.getPlot() instanceof Zoomable)) return;
			Zoomable zoomable = (Zoomable) chart.getPlot();

			switch (dimension) {
			case ALL:
				chartPanel.restoreAutoBounds();
				break;
			case HORIZONTAL:
				if (zoomable.getOrientation() == PlotOrientation.HORIZONTAL) {
					chartPanel.restoreAutoRangeBounds();
				} else {
					chartPanel.restoreAutoDomainBounds();
				}
				break;
			case VERTICAL:
				if (zoomable.getOrientation() == PlotOrientation.VERTICAL) {
					chartPanel.restoreAutoRangeBounds();
				} else {
					chartPanel.restoreAutoDomainBounds();
				}
			}
		}
	}

	protected class ShowAllDatasetContentAction extends Action {
		public ShowAllDatasetContentAction() {
			super("Zoom To Fit Whole Dataset", Activator.getDescriptor(IMAGE_DATASET_VIEW));
			setToolTipText("Zoom to fit all the data in the dataset.");
		}

		@Override
		@SuppressWarnings("null")
		public void run() {
			ChartPanelComposite chartPanelComposite = getChartPanelComposite();
			if (null == chartPanelComposite) return;
			ChartPanel chartPanel = chartPanelComposite.getChartPanel();
			if (null == chartPanel) return;
			JFreeChart chart = chartPanel.getChart();
			if (null == chart || !(chart.getPlot() instanceof XYPlot)) return;
			XYPlot xyPlot = (XYPlot) chart.getPlot();

			xyPlot.setNotify(false);
			try {
				Map<ValueAxis, Double> fixedAutoRanges = new HashMap<>(xyPlot.getRangeAxisCount() + xyPlot.getDomainAxisCount());
				for (ValueAxis axis : xyPlot.getRangeAxes().values()) {
					fixedAutoRanges.put(axis, axis.getFixedAutoRange());
					axis.setFixedAutoRange(0);
				}
				for (ValueAxis axis : xyPlot.getDomainAxes().values()) {
					fixedAutoRanges.put(axis, axis.getFixedAutoRange());
					axis.setFixedAutoRange(0);
				}

				chartPanel.restoreAutoBounds();

				for (Map.Entry<ValueAxis, Double> entry : fixedAutoRanges.entrySet()) {
					entry.getKey().setAutoRange(false, false);
					entry.getKey().setFixedAutoRange(entry.getValue());
				}
			} finally {
				xyPlot.setNotify(true);
			}
		}
	}

	protected class ZoomInAction extends Action {
		public ZoomInAction() {
			super("Zoom in", Activator.getDescriptor(Activator.IMAGE_ZOOM_IN));
		}

		@Override
		public void run() {
			ChartPanelComposite chartPanelComposite = getChartPanelComposite();
			if (null == chartPanelComposite) return;
			ChartPanel chartPanel = chartPanelComposite.getChartPanel();
			if (null == chartPanel) return;
			
			Rectangle bounds = chartPanel.getBounds();
			chartPanel.zoomInBoth(bounds.getCenterX(), bounds.getCenterY());
		}
	}

	protected class ZoomOutAction extends Action {
		public ZoomOutAction() {
			super("Zoom out", Activator.getDescriptor(Activator.IMAGE_ZOOM_OUT));
		}

		@Override
		public void run() {
			ChartPanelComposite chartPanelComposite = getChartPanelComposite();
			if (null == chartPanelComposite) return;
			ChartPanel chartPanel = chartPanelComposite.getChartPanel();
			if (null == chartPanel) return;
			
			Rectangle bounds = chartPanel.getBounds();
			chartPanel.zoomOutBoth(bounds.getCenterX(), bounds.getCenterY());
		}
	}

	protected class ZoomToSelectionXAction extends Action {
		protected ZoomToSelectionXAction() {
			super("Zoom To Fit Time Selection", Activator.getDescriptor(Activator.IMAGE_ZOOM_SELECTION_X));
			setToolTipText("Zoom to fit the time of the current selection.");
			setEnabled(false);
		}

		@Override
		public void run() {
			((ChartPanelViewer) getViewer()).getChartPanelSelectionHandler().zoomToSelection(Axis.X);
		}
	}

	protected class ZoomToSelectionYAction extends Action {
		protected ZoomToSelectionYAction() {
			super("Zoom To Fit Height", Activator.getDescriptor(Activator.IMAGE_ZOOM_SELECTION_Y));
			setToolTipText("Zoom to fit the height of the current selection.");
			setEnabled(false);
		}

		@Override
		public void run() {
			((ChartPanelViewer) getViewer()).getChartPanelSelectionHandler().zoomToSelection(Axis.Y);
		}
	}

	protected class ViewerExportImageAction extends ExportImageAction {
		public ViewerExportImageAction(@Nullable ChartPanelComposite chartPanelComposite) {
			super(chartPanelComposite);
		}

		@Override
		public void run() {
			// Determine suggested location to store the image, from edit input, if possible.
			super.setSuggestedIFile(null);
			IWorkbenchPart part = getPart();
			if (part instanceof IEditorPart) {
				IEditorInput input = ((IEditorPart) part).getEditorInput();
				if (input instanceof IFileEditorInput) {
					IFile editorFile = ((IFileEditorInput) input).getFile();
					IPath editorFileName = new Path(URIHelper.baseName(editorFile)).removeFileExtension()
							.addFileExtension("png");
					IFile suggestedFile = editorFile.getParent().getFile(editorFileName);
					if (suggestedFile != null) {
						super.setSuggestedIFile(suggestedFile);
					}
				}
			}

			// Do export.
			super.run();
		}
	}
	
	protected class ViewerShowLegendAction extends ShowLegendAction {
		public ViewerShowLegendAction(@Nullable ChartPanelComposite plotComposite) {
			super(plotComposite);
		}

		@Override
		public void setEnabled(boolean enabled) {
			super.setEnabled(enabled);
			
			// Also hide the action if disabled
			for (IContributionItem item : getToolBarManager().getItems()) {
				if (item instanceof ActionContributionItem && ((ActionContributionItem)item).getAction() == ViewerShowLegendAction.this) {
					item.setVisible(enabled);
				}
			}
			for (IContributionItem item : getMenuManager().getItems()) {
				if (item instanceof ActionContributionItem && ((ActionContributionItem)item).getAction() == ViewerShowLegendAction.this) {
					item.setVisible(enabled);
				}
			}
		}
	}
}
