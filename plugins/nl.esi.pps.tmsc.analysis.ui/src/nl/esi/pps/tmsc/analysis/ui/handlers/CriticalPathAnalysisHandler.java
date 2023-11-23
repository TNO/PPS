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

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Evaluate;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.IStructuredSelection;

import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.Interval;
import nl.esi.pps.tmsc.analysis.CriticalPathAnalysis;
import nl.esi.pps.tmsc.analysis.ui.rendering.CriticalPathRenderingStrategy;
import nl.esi.pps.tmsc.text.ETimestampFormat;

public class CriticalPathAnalysisHandler extends CreateScopedTMSCCommandHandler {
	public CriticalPathAnalysisHandler() {
		super("critical path analysis", CriticalPathRenderingStrategy.ID, false);
	}

	@Evaluate
	@CanExecute
	public boolean canExecute(@Named(IServiceConstants.ACTIVE_SELECTION) @Optional IStructuredSelection selection) {
		if (selection == null || selection.size() != 1) {
			return false;
		}
		final Object selectedElement = selection.getFirstElement();
		final EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(selectedElement);

		return editingDomain != null && (selectedElement instanceof Event || selectedElement instanceof Dependency
				|| selectedElement instanceof Execution || selectedElement instanceof Interval);
	}

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SELECTION) IStructuredSelection selection) {
		Object selectedElement = selection.getFirstElement();
		final Event event;
		if (selectedElement instanceof Interval) {
			Interval interval = (Interval) selectedElement;
			executeCommand(interval.getTmsc(), () -> CriticalPathAnalysis.analyseCriticalPath(interval));
			return;
		} else if (selectedElement instanceof Dependency) {
			event = ((Dependency) selectedElement).getSource();
		} else if (selectedElement instanceof Execution) {
			event = ((Execution) selectedElement).getEntry();
		} else /* if (selectedElement instanceof Event) */ {
			event = (Event) selectedElement;
		}
		String scopeName = String.format("Critical path to %s at %s", event.getLifeline().getExecutor().getName(),
				ETimestampFormat.eINSTANCE.format(event.getTimestamp()));
		executeCommand(event.getTmsc(), scopeName, tmsc -> new CriticalPathAnalysis().findCriticalPathTo(tmsc, event));
	}
}
