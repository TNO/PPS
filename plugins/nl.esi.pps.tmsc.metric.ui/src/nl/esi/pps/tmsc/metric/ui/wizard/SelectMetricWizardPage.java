/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.metric.ui.wizard;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

import nl.esi.pps.tmsc.metric.extension.MetricProcessor;

public class SelectMetricWizardPage extends WizardPage implements SelectionListener {
	private static final String TITLE = "Select metrics";
	private static final String DESCRIPTION = "Select the metrics to analyze";
	protected static final String METRIC_KEY = MetricProcessor.class.getName();

	private final TreeSet<MetricProcessor> allMetrics = new TreeSet<>(Comparator.comparing(MetricProcessor::getId));
	private final TreeSet<MetricProcessor> selectedMetrics = new TreeSet<>(Comparator.comparing(MetricProcessor::getId));
	
	public SelectMetricWizardPage(Collection<MetricProcessor> allMetrics) {
		super(TITLE);
		setTitle(TITLE);
		setDescription(DESCRIPTION);
		// We want the user to review the options on this page, hence it is complete
		// when made visible once
		setPageComplete(false);
		this.allMetrics.addAll(allMetrics);
	}
	
	protected Set<MetricProcessor> getAllMetrics() {
		return Collections.unmodifiableSet(allMetrics);
	}

	public Set<MetricProcessor> getSelectedMetrics() {
		return selectedMetrics;
	}
	
	public void selectAllMetrics() {
		selectedMetrics.addAll(allMetrics);
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			// We want the user to review the options on this page, hence it is complete
			// when made visible once.
			validatePageComplete();
		}
	}
	
	protected void validatePageComplete() {
		if (selectedMetrics.isEmpty()) {
			setErrorMessage("Please select at least one Metric to analyze");
			setPageComplete(false);
		} else {
			setErrorMessage(null);
			setPageComplete(true);
		}
	}

	@Override
	public void createControl(Composite parent) {
		final Composite container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout(1, false));

		TabFolder tabFolder = new TabFolder(container, SWT.NONE);
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));

		Map<String, Set<MetricProcessor>> metricCategories = getMetricCategories();
		if (metricCategories.isEmpty()) {
			setErrorMessage("No Metrics available");
		}
		for (Entry<String, Set<MetricProcessor>> metricCategoryEntry : metricCategories.entrySet()) {
			Composite metricCategoryGroup = new Composite(tabFolder, SWT.NONE);
			metricCategoryGroup.setLayout(new GridLayout(1, false));

			for (MetricProcessor metric : metricCategoryEntry.getValue()) {
				Button btnMetric = new Button(metricCategoryGroup, SWT.CHECK);
				btnMetric.setText(metric.getName());
				btnMetric.setData(METRIC_KEY, metric);
				btnMetric.setSelection(selectedMetrics.contains(metric));
				btnMetric.addSelectionListener(this);
			}

			TabItem item = new TabItem(tabFolder, SWT.NONE);
			item.setText(metricCategoryEntry.getKey());
			item.setControl(metricCategoryGroup);
		}
	}

	/**
	 * Returned categories and Metrics are sorted by their name. 
	 */
	private Map<String, Set<MetricProcessor>> getMetricCategories() {
		Map<String, Set<MetricProcessor>> metricCategories = new TreeMap<>();
		for (MetricProcessor metricExtension : allMetrics) {
			final Set<MetricProcessor> metricCategory = metricCategories.computeIfAbsent(metricExtension.getCategory(),
					k -> new TreeSet<>(Comparator.comparing(MetricProcessor::getName)));
			metricCategory.add(metricExtension);
		}
		return metricCategories;
	}

	@Override
	public void widgetSelected(SelectionEvent event) {
		Button button = (Button) event.widget;
		MetricProcessor metric = (MetricProcessor) button.getData(METRIC_KEY);

		if (button.getSelection()) {
			selectedMetrics.add(metric);
		} else {
			selectedMetrics.remove(metric);
		}
		validatePageComplete();
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent event) {
		widgetSelected(event);
	}
}
