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

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.xbase.lib.StringExtensions;

import nl.esi.pps.tmsc.Interval;
import nl.esi.pps.tmsc.ScopedTMSC;
import nl.esi.pps.tmsc.analysis.ActivityAnalysis;

enum CreateIntervalActivityStrategy {
	ACTIVITY {
		@Override
		public ScopedTMSC createTMSC(Interval interval) {
			return ActivityAnalysis.createActivityTMSC(interval);
		}
	},
	CAUSAL {
		@Override
		public ScopedTMSC createTMSC(Interval interval) {
			return ActivityAnalysis.createCausalTMSC(interval);
		}
	},
	CAUSAL_ACTIVITY {
		@Override
		public ScopedTMSC createTMSC(Interval interval) {
			return ActivityAnalysis.createCausalActivityTMSC(interval);
		}
	},
	CAUSAL_SCHEDULED_ACTIVITY {
		@Override
		public ScopedTMSC createTMSC(Interval interval) {
			return ActivityAnalysis.createCausalScheduledActivityTMSC(interval);
		}
	},
	SCHEDULED_ACTIVITY {
		@Override
		public ScopedTMSC createTMSC(Interval interval) {
			return ActivityAnalysis.createScheduledActivityTMSC(interval);
		}
	};

	public abstract ScopedTMSC createTMSC(Interval interval);

	public String getLabel() {
		return StringExtensions.toFirstUpper(name().toLowerCase().replace('_', ' '));
	}

	public static CreateIntervalActivityStrategy openSelectionDialog(Shell parent) {
		StrategySelectionDialog selectionDialog = new StrategySelectionDialog(parent);
		if (selectionDialog.open() != Window.OK) {
			return null;
		}
		return selectionDialog.getStrategy();
	}

	public static class StrategySelectionDialog extends TitleAreaDialog {
		private CreateIntervalActivityStrategy strategy = ACTIVITY;

		public StrategySelectionDialog(Shell parent) {
			super(parent);
			setBlockOnOpen(true);
			setHelpAvailable(false);
		}

		@Override
		public void create() {
			super.create();
			setTitle("Select TMSC kind");
			setMessage("Please select the kind of TMSC to use for the analysis.");
		}

		@Override
		protected Control createDialogArea(Composite parent) {
			Composite dialogArea = (Composite) super.createDialogArea(parent);
			createInputArea(dialogArea);
			return dialogArea;
		}
		
		protected Control createInputArea(Composite parent) {
			Composite btnComposite = new Composite(parent, SWT.NONE);
			btnComposite.setFont(parent.getFont());
			btnComposite.setLayout(new GridLayout());
			btnComposite.setLayoutData(new GridData(GridData.FILL_BOTH));

			for (CreateIntervalActivityStrategy strategy : values()) {
				Button btn = new Button(btnComposite, SWT.RADIO);
				btn.setText(strategy.getLabel());
				btn.setData(strategy);
				if (this.strategy == strategy) {
					btn.setSelection(true); // Default selection
				}
				btn.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						Button btn = (Button) e.widget;
						if (btn.getSelection()) {
							StrategySelectionDialog.this.strategy = (CreateIntervalActivityStrategy) btn.getData();
						}
					}
				});
			}
			return btnComposite;
		}

		public CreateIntervalActivityStrategy getStrategy() {
			return strategy;
		}
	}
}