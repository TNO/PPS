/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.reconstruct;

import static java.util.function.Function.identity;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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
import nl.esi.pps.tmsc.util.TmscRefinements;

public class TmscTraceReconstructor {
	private final ExampleArchitecture architecture;
	private final FullScopeTMSC tmsc;
	
	private Map<String, Component> components;
	private Map<String, Function> functions;
	private Map<String, Executor> executors;
	
	private Map<String, Lifeline> lifelines;
	private Map<String, Message> messages;
	
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
	}
	
	public FullScopeTMSC getTmsc() {
		return tmsc;
	}
	
	public ExampleArchitecture getArchitecture() {
		return architecture;
	}
	
	void preReconstruct() {
		// An architecture may already exist, populate caches
		executors = architecture.getExecutors().stream().collect(Collectors.toMap(Executor::getName, identity()));
		components = architecture.getComponents().stream().collect(Collectors.toMap(Component::getName, identity()));
		functions = architecture.getFunctions().stream().collect(Collectors.toMap(Function::getName, identity()));
		
		lifelines = new HashMap<>();
		messages = new HashMap<>();

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
			Message message = createMessage(messageId);
			if (messages.put(messageId, message) != null) {
				throw new IllegalArgumentException("Message IDs should be unique: " + messageId);
			}
			tmscEvent.getFullScopeOutgoingDependencies().add(message);
		}
		
		// Received messages
		for (String messageId : traceEvent.getReceivedMessages()) {
			Message message = messages.remove(messageId);
			if (message == null) {
				// Start of trace effect: message could have been sent before trace started
				message = createMessage(messageId);
			}
			tmscEvent.getFullScopeIncomingDependencies().add(message);
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

	private Message createMessage(String messageId) {
		Message message = TmscFactory.eINSTANCE.createMessage();
		tmsc.getDependencies().add(message);
		return message;
	}
}
