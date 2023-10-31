/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////


package nl.esi.pps.tmsc.analysis.ui.handlers;

import static org.eclipse.lsat.common.queries.QueryableIterable.from;

import java.util.Set;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Evaluate;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.lsat.common.util.CollectionUtil;
import org.eclipse.lsat.common.util.IterableUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import nl.esi.pps.preferences.PPSPreferences;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.Message;
import nl.esi.pps.tmsc.MessageControl;
import nl.esi.pps.tmsc.ScopedTMSC;
import nl.esi.pps.tmsc.rendering.plot.ScopesRenderingStrategy;
import nl.esi.pps.tmsc.util.TmscQueries;

public class CreateScopeHandler extends CreateScopedTMSCCommandHandler {
	public CreateScopeHandler() {
		super("create scope", ScopesRenderingStrategy.ID);
	}

	@Evaluate
	@CanExecute
	public boolean canExecute(@Named(IServiceConstants.ACTIVE_SELECTION) @Optional IStructuredSelection selection) {
		if (!PPSPreferences.isAdvancedFeaturesEnabled() || selection == null || selection.isEmpty()) {
			return false;
		}
		return from((Iterable<?>) selection).forAll(e -> e instanceof Dependency || e instanceof Execution);
	}

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SELECTION) IStructuredSelection selection,
			@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
		Set<Dependency> dependencies = from((Iterable<?>) selection).objectsOfKind(Dependency.class).asSet();
		Set<Execution> executions = from((Iterable<?>) selection).objectsOfKind(Execution.class).asSet();
		Set<FullScopeTMSC> tmscs = from(dependencies).collectOne(Dependency::getTmsc)
				.union(from(executions).collectOne(Execution::getTmsc)).asSet();
		if (tmscs.size() != 1) {
			MessageDialog.openError(shell, "Create scope", "Failed to create scope, expected 1 tmsc.");
			return;
		}
		
		MyInputDialog inputDialog = new MyInputDialog(shell, "Scope name", "Please provide the name of the scope", "",
				s -> s.isEmpty() ? "Please provide the name of the scope" : null);
		if (inputDialog.open() != InputDialog.OK) {
			return;
		}
		boolean includeCallersAndCallees = inputDialog.isIncludeCallersAndCallees();
		boolean includeFullCallStacks = inputDialog.isIncludeFullCallStacks();
		executeCommand(IterableUtil.first(tmscs), () -> createScope(inputDialog.getValue(), dependencies, executions,
				includeCallersAndCallees, includeFullCallStacks));
	}
	
	private static ScopedTMSC createScope(String scopeName, Set<Dependency> dependencies, Set<Execution> executions,
			boolean includeCallersAndCallees, boolean includeFullCallStacks) {
		ScopedTMSC scope = TmscQueries.createScopedTMSC(
				findScopeDependencies(dependencies, executions, includeCallersAndCallees, includeFullCallStacks),
				scopeName);
		if (includeFullCallStacks) {
			CollectionUtil.addAll(scope.getOrigin(), from(dependencies).collect(TmscQueries::getEvents));
		}
		return scope;
	}

	private static Set<Dependency> findScopeDependencies(Iterable<Dependency> dependencies, Set<Execution> executions,
			boolean includeCallersAndCallees, boolean includeFullCallStacks) {
		Set<Dependency> scopeDependencies = from(dependencies).asOrderedSet();
		Set<Event> executionEvents = from(executions).collect(e -> getCallStackEvents(e, includeFullCallStacks)).asOrderedSet();
		
		if (includeCallersAndCallees) {
			for (Event event : from(executions).collect(e -> getCallStackEvents(e, false))) {
				for (Event caller : from(event.getFullScopeIncomingDependencies()).select(CreateScopeHandler::isMessageOrControl).xcollectOne(Dependency::getSource)) {
					Execution callerExecution = caller.getExecution();
					if (executionEvents.add(caller) && callerExecution != null) {
						CollectionUtil.addAll(executionEvents, getCallStackEvents(callerExecution, includeFullCallStacks));
					}
				}
				for (Event callee : from(event.getFullScopeOutgoingDependencies()).select(CreateScopeHandler::isMessageOrControl).xcollectOne(Dependency::getTarget)) {
					Execution calleeExecution = callee.getExecution();
					if (executionEvents.add(callee) && calleeExecution != null) {
						CollectionUtil.addAll(executionEvents, getCallStackEvents(calleeExecution, includeFullCallStacks));
					}
				}
			}
		}
		
		CollectionUtil.addAll(scopeDependencies, from(executionEvents).collect(Event::getFullScopeOutgoingDependencies)
				.select(d -> executionEvents.contains(d.getTarget())));
		return scopeDependencies;
	}
	
	private static boolean isMessageOrControl(Dependency dependency) {
		return dependency instanceof Message || dependency instanceof MessageControl;
	}
	
	private static Iterable<Event> getCallStackEvents(Execution execution, boolean includeParents) {
		Execution ancestor = includeParents ? execution.getRoot() : execution;
		return from(ancestor).walkTree(true, Execution::getChildren).collect(TmscQueries::getEvents);
	}

	private static class MyInputDialog extends InputDialog {
		private boolean includeCallersAndCallees;
		private boolean includeFullCallStacks;

		public MyInputDialog(Shell parentShell, String dialogTitle, String dialogMessage, String initialValue,
				IInputValidator validator) {
			super(parentShell, dialogTitle, dialogMessage, initialValue, validator);
		}

		@Override
		protected Control createDialogArea(Composite parent) {
			Composite parentComposite = (Composite) super.createDialogArea(parent);
			Font font = parentComposite.getFont();

			Composite checkboxGroup = new Composite(parentComposite, SWT.NONE);
			GridLayout layout = new GridLayout();
			layout.marginLeft = 5;
			checkboxGroup.setLayout(layout);
			checkboxGroup.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL));
			checkboxGroup.setFont(font);

			Button checkBox1 = new Button(checkboxGroup, SWT.CHECK);
			checkBox1.setFont(font);
			checkBox1.setText("Include callers and callees");
			checkBox1.setSelection(includeCallersAndCallees);
			checkBox1.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					includeCallersAndCallees = checkBox1.getSelection();
				}
			});

			Button checkBox2 = new Button(checkboxGroup, SWT.CHECK);
			checkBox2.setFont(font);
			checkBox2.setText("Include full call-stacks");
			checkBox2.setSelection(includeFullCallStacks);
			checkBox2.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					includeFullCallStacks = checkBox2.getSelection();
				}
			});

			return parentComposite;
		}

		public boolean isIncludeCallersAndCallees() {
			return includeCallersAndCallees;
		}

		public boolean isIncludeFullCallStacks() {
			return includeFullCallStacks;
		}
	}
}