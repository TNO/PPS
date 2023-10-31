/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.provider;

import static nl.esi.pps.tmsc.provider.EventArgumentItemPropertyDescriptor.createArgumentItemPropertyDescriptor;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.ResourceLocator;

import nl.esi.pps.architecture.implemented.FunctionParameter;
import nl.esi.pps.common.emf.edit.provider.ItemPropertyDescriptorDecorator;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.EventType;
import nl.esi.pps.tmsc.Execution;

public class ExecutionArgumentItemPropertyDescriptor extends ItemPropertyDescriptorDecorator<Execution> {
	private final EventType eventType;
	private final int parameterIndex;

	public ExecutionArgumentItemPropertyDescriptor(AdapterFactory adapterFactory, ResourceLocator resourceLocator,
			FunctionParameter parameter, int parameterIndex, EventType eventType) {
		super(execution -> {
			Event event = eventType == EventType.ENTRY ? execution.getEntry() : execution.getExit();
			return event.getArguments().get(parameterIndex);
		}, createArgumentItemPropertyDescriptor(adapterFactory, resourceLocator, parameter, parameterIndex, eventType));
		this.parameterIndex = parameterIndex;
		this.eventType = eventType;
	}

	@Override
	public String getId(Object object) {
		return "arguments/" + eventType.name() + "/" + parameterIndex;
	}
}
