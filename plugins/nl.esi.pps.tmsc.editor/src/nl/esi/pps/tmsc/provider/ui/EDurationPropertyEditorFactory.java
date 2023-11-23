/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.provider.ui;

import org.eclipse.emf.common.util.URI;

import nl.esi.pps.common.emf.edit.ui.provider.FormatPropertyEditorFactory;

import nl.esi.pps.tmsc.text.EDurationFormat;

public class EDurationPropertyEditorFactory extends FormatPropertyEditorFactory {
	/**
	 * The property editor factory URI of this property editor factory.
	 */
	public static final URI PROPERTY_EDITOR_FACTORY_URI = URI
			.createURI("editor://nl.esi.pps.tmsc.text.EDurationFormat/");

	public EDurationPropertyEditorFactory() {
		super(EDurationFormat.eINSTANCE, PROPERTY_EDITOR_FACTORY_URI);
	}
}
