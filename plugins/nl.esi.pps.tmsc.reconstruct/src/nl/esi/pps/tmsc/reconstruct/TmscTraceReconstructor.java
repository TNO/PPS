/*
 * Copyright (c) 2018-2026 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.reconstruct;

import static java.util.function.Function.identity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.eclipse.xtext.xbase.lib.Pair;

import nl.esi.pps.architecture.example.ExampleArchitecture;
import nl.esi.pps.architecture.example.ExampleFactory;
import nl.esi.pps.architecture.implemented.Function;
import nl.esi.pps.architecture.implemented.ImplementedFactory;
import nl.esi.pps.architecture.instantiated.Executor;
import nl.esi.pps.architecture.instantiated.InstantiatedFactory;
import nl.esi.pps.architecture.specified.Component;
import nl.esi.pps.architecture.specified.SpecifiedFactory;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.Lifeline;
import nl.esi.pps.tmsc.Message;
import nl.esi.pps.tmsc.TmscFactory;
import nl.esi.pps.tmsc.metric.Metric;
import nl.esi.pps.tmsc.metric.MetricCategory;
import nl.esi.pps.tmsc.metric.MetricFactory;
import nl.esi.pps.tmsc.metric.MetricInstance;
import nl.esi.pps.tmsc.metric.MetricModel;
import nl.esi.pps.tmsc.util.TmscRefinements;

public class TmscTraceReconstructor {
	private final ExampleArchitecture architecture;
	private final FullScopeTMSC tmsc;
	private final MetricCategory category;
	
	private Map<String, Component> components;
	private Map<String, Function> functions;
	private Map<String, Executor> executors;
	
	private Map<String, Lifeline> lifelines;
	private Map<String, Message> messages;
	private Map<Pair<String, String>, MetricInstance> metricInstances;
	
	public TmscTraceReconstructor() {
		this(null);
	}
	
	public TmscTraceReconstructor(ExampleArchitecture architecture) {
		if (architecture == null) {
			this.architecture = ExampleFactory.eINSTANCE.createExampleArchitecture();
		} else {
			this.architecture = architecture;
		}
		this.tmsc = TmscFactory.eINSTANCE.createFullScopeTMSC();
		this.category = MetricFactory.eINSTANCE.createMetricCategory();
		this.category.setName("Traced");
	}
	
	public FullScopeTMSC getTmsc() {
		return tmsc;
	}
	
	public ExampleArchitecture getArchitecture() {
		return architecture;
	}
	
	public boolean hasMetrics() {
		return !category.getMetrics().isEmpty();
	}

	public MetricModel getMetrics() {
		MetricModel metrics = (MetricModel) category.eContainer();
		if (metrics == null) {
			metrics = MetricFactory.eINSTANCE.createMetricModel();
			metrics.getCategories().add(category);
		}
		return metrics;
	}
	
	void preReconstruct() {
		// An architecture may already exist, populate caches
		executors = architecture.getExecutors().stream().collect(Collectors.toMap(Executor::getName, identity()));
		components = architecture.getComponents().stream().collect(Collectors.toMap(Component::getName, identity()));
		functions = architecture.getFunctions().stream().collect(Collectors.toMap(Function::getName, identity()));
		
		lifelines = new HashMap<>();
		messages = new HashMap<>();
		metricInstances = new HashMap<>();

		// Assign the architecture to the TMSC
		this.tmsc.getArchitectures().add(this.architecture);
	}
	
	void reconstruct(TmscTraceEvent traceEvent) throws IllegalArgumentException {
		// Update start/end time of TMSC, assuming that events are ordered in time
		Long timeStamp = traceEvent.getTimeStamp();
		if (tmsc.getStartTime() == null) {
			tmsc.setStartTime(timeStamp);
			tmsc.setEpochTime(traceEvent.isEpochTime());
		}
		tmsc.setEndTime(timeStamp);
		
		// Creating the event with its references to the architecture
		Event tmscEvent = traceEvent.getEventType().createEvent();
		tmscEvent.setTimestamp(timeStamp);
		tmscEvent.setFunction(functions.computeIfAbsent(traceEvent.getFunction(), this::createFunction));
		tmscEvent.setComponent(components.computeIfAbsent(traceEvent.getComponent(), this::createComponent));
		tmscEvent.setLifeline(lifelines.computeIfAbsent(traceEvent.getExecutor(), this::createLifeline));
		
		// Sent messages
		for (String messageId : traceEvent.getSentMessages()) {
			messages.compute(messageId, (id, msg) -> {
				if (msg == null) {
					msg = createMessage(id);
				}
				msg.setSource(tmscEvent);
				// Remove from cache when both source and target are set
				return msg.getTarget() == null ? msg : null;
			});
		}
		
		// Received messages
		for (String messageId : traceEvent.getReceivedMessages()) {
			messages.compute(messageId, (id, msg) -> {
				if (msg == null) {
					msg = createMessage(id);
				}
				msg.setTarget(tmscEvent);
				// Remove from cache when both source and target are set
				return msg.getSource() == null ? msg : null;
			});
		}
		
		// Metric starts
		for (Pair<String, String> metricInstanceId : traceEvent.getMetricStarts()) {
			metricInstances.compute(metricInstanceId, (id, mi) -> {
				if (mi == null) {
					mi = createMetricInstance(id);
				}
				mi.setFrom(tmscEvent);
				// Remove from cache when both from and to are set
				return mi.getTo() == null ? mi : null;
			});
		}

		// Metric end
		for (Pair<String, String> metricInstanceId : traceEvent.getMetricEnds()) {
			metricInstances.compute(metricInstanceId, (id, mi) -> {
				if (mi == null) {
					mi = createMetricInstance(id);
				}
				mi.setTo(tmscEvent);
				// Remove from cache when both from and to are set
				return mi.getFrom() == null ? mi : null;
			});
		}
	}
	
	void postReconstruct() {
		TmscRefinements.refineWithCompleteOrder(tmsc);
		TmscRefinements.refineWithCallStacks(tmsc);
	}
	
	private Lifeline createLifeline(String executorName) {
		Lifeline lifeline = TmscFactory.eINSTANCE.createLifeline();
		lifeline.setExecutor(executors.computeIfAbsent(executorName, this::createExecutor));
		tmsc.getLifelines().add(lifeline);
		return lifeline;
	}

	private Executor createExecutor(String executorName) {
		Executor executor = InstantiatedFactory.eINSTANCE.createExecutor();
		executor.setName(executorName);
		architecture.getExecutors().add(executor);
		return executor;
	}

	private Function createFunction(String functionName) {
		Function function = ImplementedFactory.eINSTANCE.createFunction();
		function.setName(functionName);
		architecture.getFunctions().add(function);
		return function;
	}

	private Component createComponent(String componentName) {
		Component component = SpecifiedFactory.eINSTANCE.createComponent();
		component.setName(componentName);
		architecture.getComponents().add(component);
		return component;
	}

	@SuppressWarnings("deprecation")
	private Message createMessage(String messageId) {
		Message message = TmscFactory.eINSTANCE.createMessage();
		message.getProperties().put("id", messageId);
		tmsc.getDependencies().add(message);
		return message;
	}

	private MetricInstance createMetricInstance(Pair<String, String> metricInstanceId) {
		Metric metric = category.getMetrics().stream().filter(m -> Objects.equals(m.getId(), metricInstanceId.getKey()))
				.findFirst().orElseGet(() -> createMetric(metricInstanceId.getKey()));
		
		MetricInstance metricInstance = MetricFactory.eINSTANCE.createMetricInstance();
		metricInstance.setId(metricInstanceId.getValue());
		metric.getInstances().add(metricInstance);
		return metricInstance;
	}

	private Metric createMetric(String metricId) {
		Metric metric = MetricFactory.eINSTANCE.createMetric();
		metric.setId(metricId);
		metric.setName(metricId);
		category.getMetrics().add(metric);
		getMetrics().getMetrics().add(metric);
		return metric;
	}
}
