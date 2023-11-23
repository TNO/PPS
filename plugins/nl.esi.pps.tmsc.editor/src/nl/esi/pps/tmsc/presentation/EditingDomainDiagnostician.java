/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.presentation;

import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemLabelProvider;

/**
 * TODO: Candidate to be moved to common EMF edit library
 */
public class EditingDomainDiagnostician extends Diagnostician {
	private final EditingDomain editingDomain;

	public EditingDomainDiagnostician(EditingDomain editingDomain) {
		this(editingDomain, EValidator.Registry.INSTANCE);
	}

	public EditingDomainDiagnostician(EditingDomain editingDomain, Registry eValidatorRegistry) {
		super(eValidatorRegistry);
		this.editingDomain = editingDomain;
	}

	public Map<Object, Object> createDefaultContext() {
		final Map<Object, Object> context = super.createDefaultContext();
		if (editingDomain instanceof AdapterFactoryEditingDomain) {
			context.put(EValidator.SubstitutionLabelProvider.class, new AdapterFactorySubstitutionLabelProvider(
					((AdapterFactoryEditingDomain) editingDomain).getAdapterFactory()));
		}
		return context;
	}

	public BasicDiagnostic createDefaultDiagnostic(ResourceSet resourceSet) {
		return new BasicDiagnostic(EObjectValidator.DIAGNOSTIC_SOURCE, 0, "Diagnosis of editing domain",
				new Object[] { resourceSet });
	}

	public BasicDiagnostic createDefaultDiagnostic(Resource resource) {
		return new BasicDiagnostic(EObjectValidator.DIAGNOSTIC_SOURCE, 0, "Diagnosis of " + resource.getURI(),
				new Object[] { resource });
	}

	/**
	 * Validates the whole {@link EditingDomain}, i.e. all resources in
	 * {@link EditingDomain#getResourceSet()}.
	 */
	public Diagnostic validate() {
		return validate(Collections.emptyMap());
	}

	/**
	 * Validates the whole {@link EditingDomain}, i.e. all resources in
	 * {@link EditingDomain#getResourceSet()}.
	 */
	public Diagnostic validate(Map<Object, Object> contextEntries) {
		final ResourceSet resourceSet = editingDomain.getResourceSet();
		final BasicDiagnostic diagnostics = createDefaultDiagnostic(resourceSet);
		final Map<Object, Object> context = createDefaultContext();
		context.putAll(contextEntries);

		return diagnostics;
	}

	public boolean validate(DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;
		for (Resource resource : editingDomain.getResourceSet().getResources()) {
			result &= validate(resource, diagnostics, context);
		}
		return result;
	}
	
	private boolean validate(Resource resource, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;
		for (EObject eObject : resource.getContents()) {
			result &= validate(eObject, diagnostics, context);
		}
		return result;
	}

	public static class AdapterFactorySubstitutionLabelProvider implements EValidator.SubstitutionLabelProvider {
		private final AdapterFactory adapterFactory;

		public AdapterFactorySubstitutionLabelProvider(AdapterFactory adapterFactory) {
			this.adapterFactory = adapterFactory;
		}

		@Override
		public String getObjectLabel(EObject eObject) {
			IItemLabelProvider itemLabelProvider = (IItemLabelProvider) adapterFactory.adapt(eObject,
					IItemLabelProvider.class);
			if (itemLabelProvider != null) {
				return itemLabelProvider.getText(eObject);
			}
			return EcoreUtil.getIdentification(eObject);
		}

		@Override
		public String getFeatureLabel(EStructuralFeature eStructuralFeature) {
			return eStructuralFeature.getName();
		}

		@Override
		public String getValueLabel(EDataType eDataType, Object value) {
			return EcoreUtil.convertToString(eDataType, value);
		}
	}
}
