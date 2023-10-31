/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.analysis.ui.commands;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Supplier;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.lsat.common.emf.ecore.util.EcoreUtility;
import org.eclipse.xtext.xbase.lib.StringExtensions;

import nl.esi.pps.common.emf.ui.domain.EditingDomainResolver;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.ScopedTMSC;
import nl.esi.pps.tmsc.TMSC;
import nl.esi.pps.tmsc.presentation.TmscEditor;
import nl.esi.pps.tmsc.util.TmscQueries;
import nl.esi.pps.tmsc.viewers.TmscPlotViewer;
import nl.esi.pps.ui.commands.JobCommand;

public class CreateScopedTMSCCommand extends JobCommand {
	private final TMSC tmsc;
	private final BiFunction<MultiStatus, IProgressMonitor, ScopedTMSC> scopeFactory;
	
	private String renderingStrategy;
	private boolean canUndo = true;
	
	private ScopedTMSC scopedTMSC;
	private Set<Dependency> scopedDependencies;
	private String orgRenderingStrategy;
	
	public CreateScopedTMSCCommand(String commandName, TMSC tmsc, Supplier<ScopedTMSC> scopeSupplier) {
		this(commandName, tmsc, (status, monitor) ->  {
			monitor.beginTask(StringExtensions.toFirstUpper(commandName), IProgressMonitor.UNKNOWN);
			return scopeSupplier.get();
		});
	}
	
	public CreateScopedTMSCCommand(String commandName, TMSC tmsc, BiFunction<MultiStatus, IProgressMonitor, ScopedTMSC> scopeFactory) {
		super(commandName);
		this.tmsc = tmsc;
		this.scopeFactory = scopeFactory;
	}

	public void setRenderingStrategy(String renderingStrategy) {
		this.renderingStrategy = renderingStrategy;
	}
	
	public void setCanUndo(boolean canUndo) {
		this.canUndo = canUndo;
	}
	
	@Override
	public boolean canUndo() {
		return this.canUndo;
	}
	
	@Override
	protected boolean prepare() {
		return tmsc != null && scopeFactory != null;
	}

	@Override
	protected final IStatus doExecute(IProgressMonitor monitor) {
		if (renderingStrategy != null) {
			TmscPlotViewer tmscPlotViewer = getTmscPlotViewer();
			if (tmscPlotViewer != null) {
				orgRenderingStrategy = tmscPlotViewer.getRenderingStrategyID();
				tmscPlotViewer.setRenderingStrategyID(renderingStrategy, false);
			}
		}
		
		MultiStatus status = new MultiStatus(getClass(), 0, StringExtensions.toFirstUpper(getLabel()));
		scopedTMSC = createScopedTMSC(status, monitor);
		if (scopedTMSC != null) {
			// Scoping might add new dependencies to the TMSC.
			// If so, they need to be added to the TMSC and removed at undo
			scopedDependencies = TmscQueries.addScopedTMSC(tmsc, scopedTMSC);
		} else if (status.isOK()) {
			status.add(new Status(IStatus.ERROR, getClass(), "Failed to create scope, please contact PPS support"));
		}
		return status;
	}
	
	protected ScopedTMSC createScopedTMSC(MultiStatus status, IProgressMonitor monitor) {
		return scopeFactory.apply(status, monitor);
	}
	
	@Override
	public Collection<?> getAffectedObjects() {
		return scopedTMSC != null ? Collections.singleton(scopedTMSC) : Collections.singleton(tmsc);
	}

	@Override
	protected final void doUndo() {
		if (scopedTMSC != null) {
			// Only restore the rendering strategy if set by this command and not changed by user.
			if (renderingStrategy != null && orgRenderingStrategy != null) {
				TmscPlotViewer tmscPlotViewer = getTmscPlotViewer();
				if (tmscPlotViewer != null && renderingStrategy.equals(tmscPlotViewer.getRenderingStrategyID())) {
					tmscPlotViewer.setRenderingStrategyID(orgRenderingStrategy, false);
				}
				orgRenderingStrategy = null;
			}
			
			deleteScopedTMSC(scopedTMSC);
			scopedDependencies = null;
			scopedTMSC = null;
		}
	}
	
	protected void deleteScopedTMSC(ScopedTMSC scopedTMSC) {
		EcoreUtil.delete(scopedTMSC, true);
		if (scopedDependencies != null && !scopedDependencies.isEmpty()) {
			EcoreUtility.deleteAll(scopedDependencies, true);
		}
	}

	@Override
	public void redo() {
		execute();
	}
	
	protected TmscPlotViewer getTmscPlotViewer() {
		EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(tmsc);
		TmscEditor tmscEditor = EditingDomainResolver.findEditorPart(editingDomain, TmscEditor.class);
		return tmscEditor == null ? null : tmscEditor.getTmscPlotViewer();
	}
}
