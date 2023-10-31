/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.metric.ui.wizard;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.lsat.common.emf.common.util.URIHelper;
import org.eclipse.lsat.common.emf.ecore.resource.Persistor;
import org.eclipse.lsat.common.emf.ecore.resource.PersistorFactory;
import org.eclipse.lsat.common.queries.QueryableIterable;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.statushandlers.StatusManager;

import nl.esi.pps.common.core.runtime.jobs.JobUtils;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.metric.MetricPlugin;
import nl.esi.pps.tmsc.metric.extension.MetricProcessor;
import nl.esi.pps.tmsc.metric.ui.Activator;

public class MetricAnalysisIFileWizard extends Wizard implements IWorkbenchWizard {
	protected SelectMetricWizardPage selectMetricWizardPage = null;
	protected IStructuredSelection selection = StructuredSelection.EMPTY;

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		setWindowTitle("Metrics Analysis");
		setNeedsProgressMonitor(true);
		this.selection = selection;
		selectMetricWizardPage = new SelectMetricWizardPage(
				MetricPlugin.getPlugin().getRegisteredMetricProcessors().values());
	}

	public SelectMetricWizardPage getSelectMetricWizardPage() {
		return selectMetricWizardPage;
	}

	@Override
	public void addPages() {
		addPage(selectMetricWizardPage);
	}

	@Override
	public boolean performFinish() {
		@SuppressWarnings("unchecked")
		List<IFile> modelIFiles = QueryableIterable.from(selection).objectsOfKind(IFile.class).asList();
		Set<MetricProcessor> selectedMetrics = selectMetricWizardPage.getSelectedMetrics();

		try {
			getContainer().run(true, true, m -> performMetricAnalysis(m, modelIFiles, selectedMetrics));
		} catch (InvocationTargetException e) {
			StatusManager.getManager().handle(new Status(IStatus.ERROR, Activator.getPluginID(),
					String.format("Failed to perform Metric analysis: %s", e.getMessage()), e));
		} catch (InterruptedException e) {
			// User canceled
		}
		return true;
	}

	protected void performMetricAnalysis(IProgressMonitor monitor, List<IFile> modelIFiles, Set<MetricProcessor> selectedMetrics) {
		SubMonitor subMonitor = SubMonitor.convert(monitor, (modelIFiles.size() * 100) + 1);
		subMonitor.setTaskName("Analyze Metrics");

		for (IFile modelIFile : modelIFiles) {
			URI modelUri = URIHelper.asURI(modelIFile);
			Persistor<FullScopeTMSC> persistor = new PersistorFactory().getPersistor(FullScopeTMSC.class, true);
	
			try {
				subMonitor.setTaskName("Loading TMSC from " + modelUri.lastSegment());
				Map<Object, Object> loadOptions = new HashMap<>();
				loadOptions.put(IProgressMonitor.class, subMonitor.split(25));
				final FullScopeTMSC tmsc = persistor.loadOne(modelUri, loadOptions);
	
				subMonitor.split(50);
				selectedMetrics.forEach(metric -> metric.analyse(tmsc));
	
				subMonitor.setTaskName("Saving TMSC to " + modelUri.lastSegment());
				Map<Object, Object> saveOptions = new HashMap<>();
				saveOptions.put(IProgressMonitor.class, subMonitor.split(25));
				tmsc.eResource().save(saveOptions);
			} catch (IOException e) {
				StatusManager.getManager().handle(new Status(IStatus.ERROR, Activator.getPluginID(),
						String.format("Failed to load or save %s: %s", modelIFile, e.getMessage()), e));
			}
		}
		JobUtils.refreshWorkspaceProjects(modelIFiles, subMonitor.split(1));
	}
}
