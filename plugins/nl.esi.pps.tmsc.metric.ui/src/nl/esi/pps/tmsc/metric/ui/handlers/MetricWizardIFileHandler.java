/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.metric.ui.handlers;

import javax.inject.Named;

import org.eclipse.core.resources.IFile;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Evaluate;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.lsat.common.queries.QueryableIterable;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import nl.esi.pps.tmsc.TmscPlugin;
import nl.esi.pps.tmsc.metric.MetricPlugin;
import nl.esi.pps.tmsc.metric.ui.wizard.MetricAnalysisIFileWizard;

public class MetricWizardIFileHandler {
	@Evaluate
	@CanExecute
	@SuppressWarnings("unchecked")
	public boolean canExecute(@Named(IServiceConstants.ACTIVE_SELECTION) @Optional IStructuredSelection selection) {
		if (selection == null || selection.isEmpty()
				|| MetricPlugin.getPlugin().getRegisteredMetricProcessors().isEmpty()) {
			return false;
		}
		return QueryableIterable.from(selection)
				.forAll(e -> e instanceof IFile  && TmscPlugin.isTmscFile((IFile) e));
	}

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SELECTION) IStructuredSelection selection,
			@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
		MetricAnalysisIFileWizard wizard = new MetricAnalysisIFileWizard();
		wizard.init(PlatformUI.getWorkbench(), selection);
		wizard.getSelectMetricWizardPage().selectAllMetrics();
		WizardDialog wizardDialog = new WizardDialog(shell, wizard);
		wizardDialog.open();
	}
}
