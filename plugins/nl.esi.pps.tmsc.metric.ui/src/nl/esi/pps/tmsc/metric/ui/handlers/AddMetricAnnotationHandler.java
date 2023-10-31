/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

 
package nl.esi.pps.tmsc.metric.ui.handlers;

import static org.eclipse.lsat.common.queries.QueryableIterable.from;

import java.util.Set;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Evaluate;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.IStructuredSelection;

import nl.esi.pps.common.emf.ui.domain.EditingDomainResolver;

import nl.esi.pps.tmsc.metric.MetricInstance;
import nl.esi.pps.tmsc.metric.MetricPackage;
import nl.esi.pps.tmsc.presentation.TmscEditor;
import nl.esi.pps.tmsc.viewers.TmscPlotViewer;
import nl.esi.pps.tmsc.viewers.plot.IntervalAnnotation;

public class AddMetricAnnotationHandler {
	@Evaluate
	@CanExecute
	public boolean canExecute(@Named(IServiceConstants.ACTIVE_SELECTION) @Optional IStructuredSelection selection) {
		if (selection == null || selection.isEmpty()) {
			return false;
		}
		if (!from((Iterable<?>) selection).forAll(this::isMetricElement)) {
			return false;
		}
		EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(selection.getFirstElement());
		TmscEditor tmscEditor = EditingDomainResolver.findEditorPart(editingDomain, TmscEditor.class);
		return tmscEditor != null;
	}

	private boolean isMetricElement(Object o) {
		return o instanceof EObject && ((EObject) o).eClass().getEPackage() == MetricPackage.eINSTANCE;
	}
	
	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SELECTION) IStructuredSelection selection) {
		EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(selection.getFirstElement());
		TmscEditor tmscEditor = EditingDomainResolver.findEditorPart(editingDomain, TmscEditor.class);
		TmscPlotViewer tmscViewer = tmscEditor.getTmscPlotViewer();
		
		Set<MetricInstance> metricInstances = from((Iterable<?>) selection).objectsOfKind(EObject.class)
				.closure(true, EObject::eContents).objectsOfKind(MetricInstance.class).asSet();
		for (MetricInstance metricInstance : metricInstances) {
			IntervalAnnotation.add(tmscViewer, metricInstance);
		}
	}
}