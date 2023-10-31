/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.metric.ui.commands;

import static nl.esi.pps.tmsc.provider.dataanalysis.IDataAnalysisItemContentProvider.DEFAULT_CONFIGURATION;
import static org.eclipse.lsat.common.queries.QueryableIterable.from;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.UUID;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;

import nl.esi.pps.tmsc.Measurement;
import nl.esi.pps.tmsc.metric.Metric;
import nl.esi.pps.tmsc.metric.MetricCategory;
import nl.esi.pps.tmsc.metric.MetricFactory;
import nl.esi.pps.tmsc.metric.MetricInstance;
import nl.esi.pps.tmsc.metric.MetricModel;
import nl.esi.pps.tmsc.provider.dataanalysis.IDataAnalysisItemContentProvider;

public class ConvertToMetricCommand extends AbstractCommand {
	private static final String CATEGORY_NAME = "Measurements";

	private final Measurement measurement;
	private final String metricName;

	private Metric metric;

	public ConvertToMetricCommand(Measurement measurement, String metricName) {
		super("convert to metric");
		this.measurement = measurement;
		this.metricName = metricName;
	}

	@Override
	protected boolean prepare() {
		return getContentProvider() != null;
	}

	@Override
	public void execute() {
		metric = MetricFactory.eINSTANCE.createMetric();
		metric.setId(UUID.randomUUID().toString());
		metric.setName(metricName);

		Iterator<Measurement> siblings = from(getContentProvider().getSiblings(measurement, DEFAULT_CONFIGURATION))
				.objectsOfKind(Measurement.class).iterator();
		for (int i = 1; siblings.hasNext(); i++) {
			Measurement sibling = (Measurement) siblings.next();
			MetricInstance metricInstance = MetricFactory.eINSTANCE.createMetricInstance();
			metricInstance.setId(String.valueOf(i));
			metricInstance.setFrom(sibling.getFrom());
			metricInstance.setTo(sibling.getTo());
			metric.getInstances().add(metricInstance);
			metric.getTmscs().add(metricInstance.getTmsc());
		}

		Resource resource = measurement.getFrom().eResource();
		MetricModel metricModel = from(resource.getContents()).objectsOfKind(MetricModel.class).first();
		if (metricModel == null) {
			metricModel = MetricFactory.eINSTANCE.createMetricModel();
			resource.getContents().add(metricModel);
		}
		MetricCategory metricCategory = from(metricModel.getCategories()).any(c -> CATEGORY_NAME.equals(c.getName()));
		if (metricCategory == null) {
			metricCategory = MetricFactory.eINSTANCE.createMetricCategory();
			metricCategory.setName(CATEGORY_NAME);
			metricModel.getCategories().add(metricCategory);
		}
		metricModel.getMetrics().add(metric);
		metricCategory.getMetrics().add(metric);
	}

	@Override
	public void redo() {
		execute();
	}

	@Override
	public void undo() {
		ArrayList<EObject> deleteMe = new ArrayList<>(2);
		if (metric.eContainer() instanceof MetricModel
				&& ((MetricModel) metric.eContainer()).getMetrics().size() == 1) {
			deleteMe.add(metric.eContainer());
		} else {
			if (metric.getCategory().getMetrics().size() == 1) {
				deleteMe.add(metric.getCategory());
			}
			deleteMe.add(metric);
		}

		EcoreUtil.deleteAll(deleteMe, true);
		metric = null;
	}

	@Override
	public Collection<?> getAffectedObjects() {
		return metric == null ? Collections.singleton(measurement) : Collections.singleton(metric);
	}

	private IDataAnalysisItemContentProvider getContentProvider() {
		final EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(measurement.getFrom());
		if (editingDomain instanceof AdapterFactoryEditingDomain) {
			AdapterFactory adapterFactory = ((AdapterFactoryEditingDomain) editingDomain).getAdapterFactory();
			return (IDataAnalysisItemContentProvider) adapterFactory.adapt(measurement,
					IDataAnalysisItemContentProvider.class);
		}
		return null;
	}
}
