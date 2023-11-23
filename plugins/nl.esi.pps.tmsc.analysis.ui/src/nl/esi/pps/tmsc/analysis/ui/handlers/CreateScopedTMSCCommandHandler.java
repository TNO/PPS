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

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.xtext.xbase.lib.StringExtensions;

import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.ScopedTMSC;
import nl.esi.pps.tmsc.TMSC;
import nl.esi.pps.tmsc.analysis.ui.commands.CreateScopedTMSCCommand;
import nl.esi.pps.tmsc.util.TmscQueries;
import nl.esi.pps.ui.handlers.AbstractCommandHandler;

public abstract class CreateScopedTMSCCommandHandler extends AbstractCommandHandler {
	protected final String commandName;
	protected final String renderingStrategy;
	protected final boolean canUndo;

	public CreateScopedTMSCCommandHandler(String commandName) {
		this(commandName, null, true);
	}

	public CreateScopedTMSCCommandHandler(String commandName, String renderingStrategy) {
		this(commandName, renderingStrategy, true);
	}

	public CreateScopedTMSCCommandHandler(String commandName, String renderingStrategy, boolean canUndo) {
		this.commandName = commandName;
		this.renderingStrategy = renderingStrategy;
		this.canUndo = canUndo;
	}

	protected void executeCommand(TMSC tmsc, String scopeName, Function<TMSC, Iterable<Dependency>> scopeFunction) {
		executeCommand(tmsc, () -> TmscQueries.createScopedTMSC(scopeFunction.apply(tmsc), scopeName));
	}

	protected void executeCommand(TMSC tmsc, Supplier<ScopedTMSC> scopeSupplier) {
		executeCommand(tmsc, (status, monitor) -> {
			monitor.beginTask(StringExtensions.toFirstUpper(commandName), IProgressMonitor.UNKNOWN);
			return scopeSupplier.get();
		});
	}

	protected void executeCommand(TMSC tmsc, BiFunction<MultiStatus, IProgressMonitor, ScopedTMSC> scopeFactory) {
		CreateScopedTMSCCommand command = new CreateScopedTMSCCommand(commandName, tmsc, scopeFactory);
		command.setRenderingStrategy(renderingStrategy);
		command.setCanUndo(canUndo);
		EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(tmsc);
		executeCommand(command, editingDomain);
	}
}
