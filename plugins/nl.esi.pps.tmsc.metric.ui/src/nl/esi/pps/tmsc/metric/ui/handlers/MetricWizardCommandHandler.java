/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.metric.ui.handlers;

import static org.eclipse.lsat.common.queries.QueryableIterable.from;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Evaluate;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;

import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.metric.MetricPlugin;
import nl.esi.pps.tmsc.metric.ui.wizard.MetricAnalysisCommandWizard;

public class MetricWizardCommandHandler {
	@Evaluate
	@CanExecute
	public boolean canExecute(@Named(IServiceConstants.ACTIVE_SELECTION) @Optional IStructuredSelection selection) {
		FullScopeTMSC tmsc = getTMSC(selection);
		if (tmsc == null || MetricPlugin.getPlugin().getRegisteredMetricProcessors(tmsc).isEmpty()) {
			// No Metrics and/or TMSCs available
			return false;
		}
		EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(tmsc);
		return editingDomain != null;
	}

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SELECTION) IStructuredSelection selection,
			@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
		FullScopeTMSC tmsc = getTMSC(selection);
		EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(tmsc);

		MetricAnalysisCommandWizard wizard = new MetricAnalysisCommandWizard();
		wizard.init(editingDomain, tmsc);
		wizard.getSelectMetricWizardPage().selectAllMetrics();
		WizardDialog wizardDialog = new WizardDialog(shell, wizard);
		wizardDialog.open();
	}

	private static FullScopeTMSC getTMSC(IStructuredSelection selection) {
		if (selection == null || selection.size() != 1) {
			return null;
		}
		Object selectedElement = selection.getFirstElement();
		if (selectedElement instanceof FullScopeTMSC) {
			return (FullScopeTMSC) selectedElement;
		} else if (selectedElement instanceof Resource) {
			return from(((Resource) selectedElement).getContents()).objectsOfKind(FullScopeTMSC.class).first();
		}
		return null;
	}
}
