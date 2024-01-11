/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.analysis.ui.handlers;

import javax.inject.Named;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Evaluate;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;

import nl.esi.pps.tmsc.ScopedTMSC;
import nl.esi.pps.tmsc.analysis.RootCauseAnalysis;
import nl.esi.pps.tmsc.analysis.ui.rendering.CriticalPathRenderingStrategy;
import nl.esi.pps.tmsc.metric.MetricInstance;

public class RootCauseAnalysisHandler extends CreateScopedTMSCCommandHandler {
	public RootCauseAnalysisHandler() {
		super("root cause analysis", CriticalPathRenderingStrategy.ID, false);
	}

	@Evaluate
	@CanExecute
	public boolean canExecute(@Named(IServiceConstants.ACTIVE_SELECTION) @Optional IStructuredSelection selection) {
		if (selection == null || selection.size() != 1) {
			return false;
		}
		final Object selectedElement = selection.getFirstElement();
		if (selectedElement instanceof MetricInstance) {
			final MetricInstance metricInstance = (MetricInstance) selectedElement;
			final EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(metricInstance);
			return editingDomain != null && metricInstance.isExceedsBudget();
		}
		return false;
	}

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SELECTION) IStructuredSelection selection,
			@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
		MetricInstance metricInstance = (MetricInstance) selection.getFirstElement();
		executeCommand(metricInstance.getTmsc(), (status, monitor) -> analyseRootCause(metricInstance, status, monitor));
	}
	
	private static ScopedTMSC analyseRootCause(MetricInstance metricInstance, MultiStatus status,
			IProgressMonitor monitor) {
		RootCauseAnalysis rootCauseAnalysis = new RootCauseAnalysis();
		ScopedTMSC rootCause = rootCauseAnalysis.analyseRootCause(metricInstance, monitor);
		status.addAll(rootCauseAnalysis.getStatus());
		return rootCause;
	}
}
