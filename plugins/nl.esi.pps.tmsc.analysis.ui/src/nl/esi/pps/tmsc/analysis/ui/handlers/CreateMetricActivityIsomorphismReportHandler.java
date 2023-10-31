/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////


package nl.esi.pps.tmsc.analysis.ui.handlers;

import static nl.esi.pps.common.ide.ui.jobs.StatusReportingJob.DEFAULT_LOG_SEVERITIES;
import static nl.esi.pps.tmsc.analysis.ui.Activator.getPluginID;
import static nl.esi.pps.ui.handlers.AbstractCommandHandler.DEFAULT_DIALOG_SEVERITIES;
import static org.eclipse.core.runtime.IStatus.ERROR;
import static org.eclipse.lsat.common.queries.QueryableIterable.from;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Evaluate;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.lsat.common.emf.common.util.URIHelper;
import org.eclipse.lsat.common.emf.ecore.resource.Persistor;
import org.eclipse.lsat.common.emf.ecore.resource.PersistorFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import nl.esi.pps.common.core.runtime.ErrorStatusException;
import nl.esi.pps.common.core.runtime.FailOnErrorStatus;
import nl.esi.pps.common.core.runtime.jobs.IStatusJobFunction;
import nl.esi.pps.common.ide.ui.jobs.StatusReportingJob;
import nl.esi.pps.preferences.PPSPreferences;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.ITMSC;
import nl.esi.pps.tmsc.TmscPlugin;
import nl.esi.pps.tmsc.analysis.ui.Activator;
import nl.esi.pps.tmsc.compare.ArchitectureLifecycleStage;
import nl.esi.pps.tmsc.compare.TmscIsomorphismMatcher;
import nl.esi.pps.tmsc.metric.Metric;
import nl.esi.pps.tmsc.metric.MetricInstance;
import nl.esi.pps.tmsc.metric.MetricPlugin;
import nl.esi.pps.tmsc.metric.extension.MetricProcessor;

public class CreateMetricActivityIsomorphismReportHandler {
	@Evaluate
	@CanExecute
	public boolean canExecute(@Named(IServiceConstants.ACTIVE_SELECTION) @Optional IStructuredSelection selection) {
		if (!PPSPreferences.isAdvancedFeaturesEnabled() || selection == null || selection.isEmpty()
				|| MetricPlugin.getPlugin().getRegisteredMetricProcessors().isEmpty()) {
			return false;
		}
		return from((Iterable<?>) selection)
				.forAll(f -> f instanceof IFile && TmscPlugin.isTmscFileExtension(((IFile) f).getFileExtension()));
	}

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SELECTION) IStructuredSelection selection,
			@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
		StrageSelectionDialog selectionDialog = new StrageSelectionDialog(shell);
		if (selectionDialog.open() != Window.OK) {
			return;
		}

		LinkedList<IFile> tmscIFiles = from((Iterable<?>) selection).objectsOfKind(IFile.class).asList();
		IStatusJobFunction jobFunction = monitor -> doJob(tmscIFiles, selectionDialog.getStage(), monitor);
		Job job = new StatusReportingJob("Create isomorphism report", jobFunction, getPluginID(),
				DEFAULT_DIALOG_SEVERITIES, DEFAULT_LOG_SEVERITIES);
		job.setUser(true);
		job.schedule();
	}

	private static IStatus doJob(List<IFile> tmscIFiles, ArchitectureLifecycleStage stage, IProgressMonitor monitor)
			throws ErrorStatusException {
		FailOnErrorStatus result = new FailOnErrorStatus(getPluginID(), "Created isomorphism report");
		Collection<MetricProcessor> metricProcessors = MetricPlugin.getPlugin().getRegisteredMetricProcessors()
				.values();
		SubMonitor subMonitor = SubMonitor.convert(monitor, tmscIFiles.size() * metricProcessors.size() * 100);

		for (IFile tmscIfile : tmscIFiles) {
			FullScopeTMSC tmsc = null;
			try {
				Persistor<FullScopeTMSC> persistor = new PersistorFactory().getPersistor(FullScopeTMSC.class, true);
				subMonitor.setTaskName("Loading TMSC from " + tmscIfile.getName());
				Map<Object, Object> loadOptions = new HashMap<>();
				loadOptions.put(IProgressMonitor.class, subMonitor.split(25));
				tmsc = persistor.loadOne(URIHelper.asURI(tmscIfile), loadOptions);
			} catch (IOException e) {
				result.add(new Status(IStatus.ERROR, Activator.getPluginID(),
						String.format("Failed to load %s: %s", tmscIfile.getFullPath().toOSString(), e.getMessage()),
						e));
			}

			for (MetricProcessor metricProcessor : metricProcessors) {
				Metric metric = metricProcessor.analyse(tmsc);
				if (metric == null) {
					continue;
				}
				String reportFileName = tmscIfile.getProjectRelativePath().removeFileExtension().lastSegment()
						+ " - " + stage.getLabel() + " - " + metricProcessor.getName() + ".csv";
				IFile reportIFile = tmscIfile.getParent().getFile(new Path(reportFileName));
				String[][] report = createIsomorphismReport(metric.getInstances(), stage, subMonitor.split(65));
				String reportTxt = from(report).collectOne(array -> from(array).joinfields(", ", "", ""))
						.joinfields("\n", "", "");
				try {
					byte[] reportContent = reportTxt.toString().getBytes(reportIFile.getCharset());
					if (reportIFile.exists()) {
						reportIFile.setContents(new ByteArrayInputStream(reportContent), true, true,
								subMonitor.split(10));
					} else {
						reportIFile.create(new ByteArrayInputStream(reportContent), true, subMonitor.split(10));
					}
				} catch (CoreException | UnsupportedEncodingException e) {
					result.add(new Status(ERROR, getPluginID(), e.getMessage(), e));
				}
			}
		}
		return result;
	}

	public static String[][] createIsomorphismReport(Collection<MetricInstance> metricInstances,
			ArchitectureLifecycleStage stage, IProgressMonitor monitor) {
		String[][] report = new String[metricInstances.size() + 1][CreateIntervalActivityStrategy.values().length + 2];

		int column = 0;
		int miIndex = 1;
		report[0][column] = metricInstances.iterator().next().getMetric().getName();
		for (MetricInstance mi : metricInstances) {
			report[miIndex++][column] = mi.getId();
		}

		miIndex = 1;
		report[0][++column] = "Exceed budget";
		for (MetricInstance mi : metricInstances) {
			report[miIndex++][column] = String.valueOf(mi.isExceedsBudget());
		}

		for (CreateIntervalActivityStrategy strategy : CreateIntervalActivityStrategy.values()) {
			Map<MetricInstance, ITMSC> tmscs = from(metricInstances).toMap(o -> o, strategy::createTMSC);
			report[0][++column] = strategy.getLabel();
			addToIsomorphismReport(tmscs, stage, report, column);
		}
		
		return report;
	}

	private static <T extends ITMSC> void addToIsomorphismReport(Map<MetricInstance, T> metricTmscs,
			ArchitectureLifecycleStage stage, String[][] report, int column) {
		List<List<T>> tmscGroups = TmscIsomorphismMatcher.findIsomorphismClasses(
				metricTmscs.values().iterator(), stage);

		int miIndex = 1;
		for (Map.Entry<MetricInstance, T> entry : metricTmscs.entrySet()) {
			report[miIndex++][column] = String.valueOf(findGroupIndex(tmscGroups, entry.getValue()));
		}
	}

	private static <T> int findGroupIndex(List<List<T>> groups, T element) {
		for (int i = 0; i < groups.size(); i++) {
			if (groups.get(i).contains(element)) {
				return i + 1;
			}
		}
		return -1;
	}

	public static class StrageSelectionDialog extends TitleAreaDialog {
		private ArchitectureLifecycleStage stage = ArchitectureLifecycleStage.IMPLEMENTED;

		public StrageSelectionDialog(Shell parent) {
			super(parent);
			setBlockOnOpen(true);
			setHelpAvailable(false);
		}

		@Override
		public void create() {
			super.create();
			setTitle("Select architecture lifecycle stage");
			setMessage("Please select the architecture lifecycle stage to use for the analysis.");
		}

		@Override
		protected Control createDialogArea(Composite parent) {
			Composite dialogArea = (Composite) super.createDialogArea(parent);
			createInputArea(dialogArea);
			return dialogArea;
		}
		
		protected Control createInputArea(Composite parent) {
			Composite btnComposite = new Composite(parent, SWT.NONE);
			btnComposite.setFont(parent.getFont());
			btnComposite.setLayout(new GridLayout());
			btnComposite.setLayoutData(new GridData(GridData.FILL_BOTH));

			for (ArchitectureLifecycleStage stage : ArchitectureLifecycleStage.values()) {
				Button btn = new Button(btnComposite, SWT.RADIO);
				btn.setText(stage.getLabel());
				btn.setData(stage);
				if (this.stage == stage) {
					btn.setSelection(true); // Default selection
				}
				btn.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						Button btn = (Button) e.widget;
						if (btn.getSelection()) {
							StrageSelectionDialog.this.stage = (ArchitectureLifecycleStage) btn.getData();
						}
					}
				});
			}
			return btnComposite;
		}

		public ArchitectureLifecycleStage getStage() {
			return stage;
		}
	}
}