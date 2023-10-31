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

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;

import com.google.common.base.Strings;

import nl.esi.pps.common.emf.edit.provider.ItemPropertyDescriptorDecorator;

import nl.esi.pps.architecture.implemented.FunctionParameter;
import nl.esi.pps.architecture.implemented.FunctionParameterKind;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.EventType;
import nl.esi.pps.tmsc.TmscPackage;

public class EventArgumentItemPropertyDescriptor extends ItemPropertyDescriptorDecorator<Event> {
	private static final String CATEGORY = "Function Arguments";
	private static final String[] FILTER_FLAGS = new String[0];

	private final int parameterIndex;

	public EventArgumentItemPropertyDescriptor(AdapterFactory adapterFactory, ResourceLocator resourceLocator,
			FunctionParameter parameter, int parameterIndex, EventType eventType) {
		super(event -> event.getArguments().get(parameterIndex), createArgumentItemPropertyDescriptor(adapterFactory,
				resourceLocator, parameter, parameterIndex, eventType));
		this.parameterIndex = parameterIndex;
	}

	@Override
	public String getId(Object object) {
		return "arguments/" + parameterIndex;
	}

	static ItemPropertyDescriptor createArgumentItemPropertyDescriptor(AdapterFactory adapterFactory,
			ResourceLocator resourceLocator, FunctionParameter parameter, int propertyIndex, EventType eventType) {
		String displayName = parameter.getKind().getLiteral();
		if (parameter.getKind() == FunctionParameterKind.IN_OUT) {
			displayName = eventType == EventType.ENTRY ? FunctionParameterKind.IN.getLiteral()
					: FunctionParameterKind.OUT.getLiteral();
		}
		if (!Strings.isNullOrEmpty(parameter.getName())) {
			displayName += " " + parameter.getName();
		}
		return new ItemPropertyDescriptor(adapterFactory, resourceLocator, displayName, null,
				TmscPackage.Literals.FUNCTION_ARGUMENT_MAP_ENTRY__VALUE, false, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, CATEGORY, FILTER_FLAGS);
	}
}
