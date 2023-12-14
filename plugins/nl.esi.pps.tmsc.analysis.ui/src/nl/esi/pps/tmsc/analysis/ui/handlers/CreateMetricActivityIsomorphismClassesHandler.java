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

import static nl.esi.pps.tmsc.analysis.ui.handlers.CreateMetricActivityIsomorphismClassesHelper.createIsomorphismClasses;

import java.util.Collections;

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
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;

import nl.esi.pps.preferences.PPSPreferences;
import nl.esi.pps.tmsc.ScopedTMSC;
import nl.esi.pps.tmsc.analysis.ui.commands.CreateScopedTMSCCommand;
import nl.esi.pps.tmsc.compare.ArchitectureLifecycleStage;
import nl.esi.pps.tmsc.metric.Metric;
import nl.esi.pps.tmsc.rendering.plot.ScopesRenderingStrategy;
import nl.esi.pps.tmsc.util.TmscQueries;

public class CreateMetricActivityIsomorphismClassesHandler extends CreateScopedTMSCCommandHandler {
	public CreateMetricActivityIsomorphismClassesHandler() {
		super("create isomorphism classes of TMSCs");
	}

	@Evaluate
	@CanExecute
	public boolean canExecute(@Named(IServiceConstants.ACTIVE_SELECTION) @Optional IStructuredSelection selection) {
		if (!PPSPreferences.isAdvancedFeaturesEnabled() || selection == null || selection.size() != 1) {
			return false;
		}
		final Object selectedElement = selection.getFirstElement();
		final EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(selectedElement);

		return editingDomain != null && selectedElement instanceof Metric;
	}

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SELECTION) IStructuredSelection selection, 
			@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
		Metric metric = (Metric) selection.getFirstElement();
		
		StrategyAndStageSelectionDialog selectionDialog = new StrategyAndStageSelectionDialog(shell);
		if (selectionDialog.open() != Window.OK) {
			return;
		}
		MyCommand command = new MyCommand(commandName, metric, selectionDialog.getStage(), selectionDialog.getStrategy());
		EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(metric);
		executeCommand(command, editingDomain);
	}
	
	private static class MyCommand extends CreateScopedTMSCCommand {
		private final Metric metric;
		private final ArchitectureLifecycleStage stage;
		private final CreateIntervalActivityStrategy strategy;
		
		public MyCommand(String commandName, Metric metric, ArchitectureLifecycleStage stage, CreateIntervalActivityStrategy strategy) {
			// Use an emptyList as we'll do the work in #createScopedTMSC()
			super(commandName, metric.getTmscs().get(0),
					() -> TmscQueries.createScopedTMSC(Collections.emptyList(), metric.getName() + ' ' + strategy.getLabel()));
			this.metric = metric;
			this.stage = stage;
			this.strategy = strategy;
			setRenderingStrategy(ScopesRenderingStrategy.ID);
		}
		
		@Override
		protected boolean prepare() {
			return super.prepare() && metric.getTmscs().size() == 1;
		}
		
		@Override
		protected ScopedTMSC createScopedTMSC(MultiStatus status, IProgressMonitor monitor) {
			ScopedTMSC tmsc = super.createScopedTMSC(status, monitor);
			// Apply some rendering hints such that this scope isn't grouped by the renderer
			ScopesRenderingStrategy.setGroupKey(tmsc, false);
			
			for (ScopedTMSC isomorphismClass : createIsomorphismClasses(metric, strategy, stage)) {
				TmscQueries.addScopedTMSC(tmsc, isomorphismClass);
			}
			
			return tmsc;
		}
	}
	
	private static class StrategyAndStageSelectionDialog extends CreateIntervalActivityStrategy.StrategySelectionDialog {
		private ArchitectureLifecycleStage stage = ArchitectureLifecycleStage.IMPLEMENTED;
		
		public StrategyAndStageSelectionDialog(Shell parent) {
			super(parent);
		}
		
		@Override
		public void create() {
			super.create();
			setTitle("Select TMSC kind and architecture lifecycle stage");
			setMessage("Please select the kind of TMSC and architecture lifecycle stage to use for the analysis.");
		}
		
		@Override
		protected Control createInputArea(Composite parent) {
			Composite inputComposite = new Composite(parent, SWT.NONE);
			inputComposite.setFont(parent.getFont());
			inputComposite.setLayout(new GridLayout(2, true));
			inputComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
			
			Group tmscGroup = new Group(inputComposite, SWT.NONE);
			tmscGroup.setText("TMSC kind");
			tmscGroup.setFont(parent.getFont());
			tmscGroup.setLayout(new GridLayout());
			tmscGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
			super.createInputArea(tmscGroup);
			
			Group btnGroup = new Group(inputComposite, SWT.NONE);
			btnGroup.setFont(parent.getFont());
			btnGroup.setText("Architecture lifecycle stage");
			btnGroup.setLayout(new GridLayout());
			btnGroup.setLayoutData(new GridData(GridData.FILL_BOTH));

			for (ArchitectureLifecycleStage stage : ArchitectureLifecycleStage.values()) {
				Button btn = new Button(btnGroup, SWT.RADIO);
				btn.setText(stage.getLabel());
				btn.setData(stage);
				if (this.stage == stage) {
					btn.setSelection(true); // Default selection
				}
				btn.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						Button btn = (Button) e.widget;
						if (btn.getSelection()) {
							StrategyAndStageSelectionDialog.this.stage = (ArchitectureLifecycleStage) btn.getData();
						}
					}
				});
			}

			return inputComposite;
		}
		
		public ArchitectureLifecycleStage getStage() {
			return stage;
		}
	}
}
