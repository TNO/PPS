/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.metric.ui.wizard;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.statushandlers.StatusManager;

import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.metric.MetricPlugin;
import nl.esi.pps.tmsc.metric.ui.Activator;
import nl.esi.pps.tmsc.metric.ui.commands.MetricAnalysisCommand;

public class MetricAnalysisCommandWizard extends Wizard {
	protected SelectMetricWizardPage selectMetricWizardPage = null;
	protected EditingDomain editingDomain = null;
	protected FullScopeTMSC tmsc = null;

	public void init(EditingDomain editingDomain, FullScopeTMSC tmsc) {
		setWindowTitle("Metrics Analysis");
		setNeedsProgressMonitor(true);
		this.editingDomain = editingDomain;
		this.tmsc = tmsc;
		selectMetricWizardPage = new SelectMetricWizardPage(
				MetricPlugin.getPlugin().getRegisteredMetricProcessors(tmsc).values());
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
		MetricAnalysisCommand command = new MetricAnalysisCommand(getSelectMetricWizardPage().getSelectedMetrics(), tmsc);
		if (command.canExecute()) {
			editingDomain.getCommandStack().execute(command);
		} else {
			StatusManager.getManager()
					.handle(new Status(IStatus.ERROR, Activator.getPluginID(), "Metric analysis cannot be performed"));
		}
		return true;
	}
}
