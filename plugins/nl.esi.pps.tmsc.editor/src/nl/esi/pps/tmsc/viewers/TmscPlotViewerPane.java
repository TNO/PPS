/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.viewers;

import static org.eclipse.lsat.common.queries.QueryableIterable.from;

import java.text.ParseException;
import java.util.LinkedList;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ResourceLocator;
import org.eclipse.lsat.common.queries.QueryableIterable;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.jfree.chart.event.ChartChangeEvent;
import org.jfree.chart.event.ChartChangeListener;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.Range;

import nl.esi.pps.architecture.instantiated.Executor;
import nl.esi.pps.common.emf.synchronizedtiming.range.TimeRange;
import nl.esi.pps.common.emf.synchronizedtiming.ui.SynchronizedTimingViewerPane;
import nl.esi.pps.common.ide.ui.action.DropDownMenuAction;
import nl.esi.pps.common.ide.ui.action.DropDownMenuAction.DropDownAction;
import nl.esi.pps.common.jfreechart.chart.axis.NanoTimeAxis;
import nl.esi.pps.preferences.PPSPreferences;
import nl.esi.pps.tmsc.Lifeline;
import nl.esi.pps.tmsc.presentation.TmscEditorPlugin;
import nl.esi.pps.tmsc.rendering.plot.IRenderingStrategy;
import nl.esi.pps.tmsc.text.ETimestampFormat;
import nl.esi.pps.tmsc.viewers.plot.DependenciesVisibility;
import nl.esi.pps.tmsc.viewers.plot.ExecutionsVisibility;
import nl.esi.pps.tmsc.viewers.plot.RenderingStrategyRegistryReader;

public class TmscPlotViewerPane extends SynchronizedTimingViewerPane {
	protected static final String GROUP_TMSC = "tmsc";
	
	private final GotoTimeAction gotoTimeAction = new GotoTimeAction();
	private final OptimizeLifelineOrderAction optimizeLifelineOrderAction = new OptimizeLifelineOrderAction();

	public TmscPlotViewerPane(IWorkbenchPage page, IWorkbenchPart part) {
		super(page, part);
	}

	@Override
	public TmscPlotViewer createViewer(Composite parent) {
		return new TmscPlotViewer(parent);
	}

	@Override
	public TmscPlotViewer getViewer() {
		return (TmscPlotViewer) super.getViewer();
	}
	
	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		
		getMenuManager().insert(0, new Separator(GROUP_TMSC));
		getToolBarManager().insert(0, new Separator(GROUP_TMSC));
		
		// Prepare and add the rendering strategies
		IConfigurationElement[] renderingStrategyConfigurations = RenderingStrategyRegistryReader
				.getRenderingStrategyConfigurations();
		DropDownAction[] renderingStrategyActions = QueryableIterable.from(renderingStrategyConfigurations)
				.select(this::isEnabled)
				.collectOne(this::createRenderingStrategyAction)
				.sortedBy(DropDownAction::getText, String.CASE_INSENSITIVE_ORDER)
				.toArray(DropDownAction.class);
		getToolBarManager().appendToGroup(GROUP_TMSC,
				new DropDownMenuAction("Select Rendering Strategy", renderingStrategyActions));
		
		getToolBarManager().appendToGroup(GROUP_TMSC, new DropDownMenuAction("Select Dependencies Visibility", 
				new SelectDependenciesVisibilityAction(DependenciesVisibility.ALL, getViewer()),
				new SelectDependenciesVisibilityAction(DependenciesVisibility.HIDE_ANNOTATIONS, getViewer()),
				new SelectDependenciesVisibilityAction(DependenciesVisibility.HIDE_CROSSING, getViewer()),
				new SelectDependenciesVisibilityAction(DependenciesVisibility.NONE, getViewer())));

		getToolBarManager().appendToGroup(GROUP_TMSC, new DropDownMenuAction("Select Executions Visibility", 
				new SelectExecutionsVisibilityAction(ExecutionsVisibility.ALL, getViewer()),
				new SelectExecutionsVisibilityAction(ExecutionsVisibility.HIDE_ANNOTATIONS, getViewer()),
				new SelectExecutionsVisibilityAction(ExecutionsVisibility.NONE, getViewer())));
		
		if (PPSPreferences.isAdvancedFeaturesEnabled()) {
			getToolBarManager().appendToGroup(GROUP_TMSC, optimizeLifelineOrderAction);
		}

		getMenuManager().appendToGroup(GROUP_SYNCHRONIZED_TIMING, gotoTimeAction);

		updateActionBars();
	}
	
	private boolean isEnabled(IConfigurationElement renderingStrategyConfiguration) {
		IRenderingStrategy renderingStrategy = RenderingStrategyRegistryReader.getIRenderingStrategy(renderingStrategyConfiguration);
		return renderingStrategy.isSupported(getEditingDomain());
	}
	
	private DropDownAction createRenderingStrategyAction(IConfigurationElement renderingStrategyConfiguration) {
		final SelectRenderingStrategyAction action = new SelectRenderingStrategyAction(
				RenderingStrategyRegistryReader.getID(renderingStrategyConfiguration),
				RenderingStrategyRegistryReader.getName(renderingStrategyConfiguration),
				RenderingStrategyRegistryReader.getIcon(renderingStrategyConfiguration).orElse(null), getViewer());
		final String description = RenderingStrategyRegistryReader.getDescription(renderingStrategyConfiguration);
		if (description != null) {
			action.setToolTipText(description);
		}
		return action;
	}
	
	private static class SelectRenderingStrategyAction extends DropDownAction implements ChartChangeListener {
		private final TmscPlotViewer viewer;
		private final String renderingStrategyID;
		
		SelectRenderingStrategyAction(String id, String name, ImageDescriptor image, TmscPlotViewer viewer) {
			super(name, image);
			this.renderingStrategyID = id;
			this.viewer = viewer;
			viewer.getChartPanelComposite().getChart().addChangeListener(this);
		}

		@Override
		public void chartChanged(ChartChangeEvent event) {
			boolean checked = renderingStrategyID.equals(viewer.getRenderingStrategyID());
			setChecked(checked);
		}
		
		@Override
		protected void runChecked() {
			viewer.setRenderingStrategyID(renderingStrategyID, true);
		}
	}

	private static class SelectDependenciesVisibilityAction extends DropDownAction implements ChartChangeListener {
		private final TmscPlotViewer viewer;
		private final DependenciesVisibility visibility;
		
		SelectDependenciesVisibilityAction(DependenciesVisibility visibility, TmscPlotViewer viewer) {
			super(visibility.getLabel(), visibility.getImage());
			this.visibility = visibility;
			this.viewer = viewer;
			viewer.getChartPanelComposite().getChart().addChangeListener(this);
		}

		@Override
		public void chartChanged(ChartChangeEvent event) {
			boolean checked = visibility == viewer.getDependenciesVisibility();
			setChecked(checked);
		}
		
		@Override
		protected void runChecked() {
			viewer.setDependenciesVisibility(visibility, true);
		}
	}

	private static class SelectExecutionsVisibilityAction extends DropDownAction implements ChartChangeListener {
		private final TmscPlotViewer viewer;
		private final ExecutionsVisibility visibility;

		SelectExecutionsVisibilityAction(ExecutionsVisibility visibility, TmscPlotViewer viewer) {
			super(visibility.getLabel(), visibility.getImage());
			this.visibility = visibility;
			this.viewer = viewer;
			viewer.getChartPanelComposite().getChart().addChangeListener(this);
		}

		@Override
		public void chartChanged(ChartChangeEvent event) {
			boolean checked = visibility == viewer.getExecutionsVisibility();
			setChecked(checked);
		}

		@Override
		protected void runChecked() {
			viewer.setExecutionsVisibility(visibility, true);
		}
	}
	
	private class GotoTimeAction extends Action {
		protected GotoTimeAction() {
			super("Goto Time...", ResourceLocator
					.imageDescriptorFromBundle(TmscEditorPlugin.getPlugin().getSymbolicName(), "icons/time_into.png")
					.orElse(null));
		}

		@Override
		public void run() {
			XYPlot xyPlot = getViewer().getChartPanelComposite().getChart().getXYPlot();
			NanoTimeAxis domainAxis = (NanoTimeAxis) xyPlot.getDomainAxis();
			Range domainDataRange = xyPlot.getDataRange(domainAxis);
			long domainOffset = domainAxis.getOffset();

			InputDialog inputDialog = new InputDialog(getViewer().getControl().getShell(), "Goto Time",
					"Please enter a timestamp to go to", "", s -> {
						try {
							parseNanoTime(s, domainOffset, domainDataRange);
							return null;
						} catch (ParseException e) {
							return e.getLocalizedMessage();
						}
					});
			if (inputDialog.open() != InputDialog.OK) {
				return;
			}
			try {
				Long nanoTime = parseNanoTime(inputDialog.getValue(), domainOffset, domainDataRange);
				if (domainAxis.isAutoRange()) {
					domainAxis.setRange(new Range(nanoTime, nanoTime + 1));
				} else {
					Range domainRange = domainAxis.getRange();
					domainAxis.setRange(Range.shift(domainRange, nanoTime - domainRange.getCentralValue()));
				}
			} catch (ParseException e) {
				// Should never happen
			}
		}

		private long parseNanoTime(String text, long offset, Range range) throws ParseException {
			if (text == null || text.isEmpty()) {
				throw new ParseException("Please specify a timestamp", 0);
			}
			long nanoTime;
			try {
				nanoTime = Long.parseLong(text);
			} catch (NumberFormatException nfe) {
				try {
					nanoTime = ETimestampFormat.eINSTANCE.parse(text).longValue();
				} catch (ParseException e) {
					throw new ParseException("Please specify a valid timestamp", e.getErrorOffset());
				}
			}
			if (nanoTime > range.getUpperBound()) {
				nanoTime -= offset;
			} else if (nanoTime < range.getLowerBound()) {
				// When the trace contains midnight
				nanoTime += NanoTimeAxis.NANOS_PER_DAY;
			}
			if (!range.contains(nanoTime)) {
				throw new ParseException(String.format("Timestamp should be within %s - %s",
						ETimestampFormat.eINSTANCE.format(range.getLowerBound()),
						ETimestampFormat.eINSTANCE.format(range.getUpperBound())), -1);
			}
			return nanoTime;
		}
	}

	/**
	 * "Optimize" the row order of the TMSC plot viewer. This groups the life-lines
	 * by minimizing the distance in the graph of messages for a given time range.
	 * The button moves the rows only when pressed. When the time range is moved,
	 * the optimization action can be re-applied.	 
	 */
	protected class OptimizeLifelineOrderAction extends Action {
		public OptimizeLifelineOrderAction() {
			super("Optimize");
			setImageDescriptor(ResourceLocator.imageDescriptorFromBundle(
					TmscEditorPlugin.getPlugin().getSymbolicName(), "icons/Optimization.png").orElse(null));
		}

		@Override
		public void run() {
			Lifeline[] lifelines = getViewer().getVisibleLifelines();
			TimeRange timeRange = getViewer().getTimeSyncSupport().getTimeRange();
			// If an executor is set, the content provider will not search for connections,
			// but just show that executor only
			LinkedList<Executor> executors = from(LifelineOrderOptimizer.optimizeOrder(timeRange, lifelines))
					.collectOne(Lifeline::getExecutor).asList();
			getViewer().setInput(executors);
		}
	}
}
