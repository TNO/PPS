/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.analysis.ui.commands;

import static org.eclipse.lsat.common.queries.QueryableIterable.from;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;

import nl.esi.pps.common.emf.ui.domain.EditingDomainResolver;
import nl.esi.pps.tmsc.ScopedTMSC;
import nl.esi.pps.tmsc.TMSC;
import nl.esi.pps.tmsc.TmscFactory;
import nl.esi.pps.tmsc.analysis.SlackAnalysis;
import nl.esi.pps.tmsc.analysis.ui.rendering.SlackRenderingStrategy;
import nl.esi.pps.tmsc.presentation.TmscEditor;

public class SlackAnalysisCommand extends AbstractCommand {
	private final TMSC tmsc;

	public SlackAnalysisCommand(TMSC tmsc) {
		super("slack analysis");
		this.tmsc = tmsc;
	}

	@Override
	protected boolean prepare() {
		return true;
	}

	@Override
	public void execute() {
		SlackAnalysis.analyseSlack(tmsc);

		EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(tmsc);
		TmscEditor tmscEditor = EditingDomainResolver.findEditorPart(editingDomain, TmscEditor.class);
		if (tmscEditor != null) {
			// FIXME: Strange behavior when using true for the notification, workaround applied below
			tmscEditor.getTmscPlotViewer().setRenderingStrategyID(SlackRenderingStrategy.ID, false);

			// TODO: Investigate how we can trigger a viewer refresh just like when objects are added
			ScopedTMSC dummyTMSC = TmscFactory.eINSTANCE.createScopedTMSC();
			tmsc.getChildScopes().add(dummyTMSC);
			tmsc.getChildScopes().remove(dummyTMSC);
		}
	}

	@Override
	public Collection<?> getAffectedObjects() {
		return Collections.singleton(tmsc);
	}

	@Override
	public boolean canUndo() {
		return from(tmsc.getEvents()).exists(e -> SlackAnalysis.isSetSlack(e, tmsc));
	}

	@Override
	public void undo() {
		tmsc.getEvents().forEach(e -> SlackAnalysis.unsetSlack(e, tmsc));
	}

	@Override
	public void redo() {
		execute();
	}
}
