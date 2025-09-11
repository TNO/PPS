/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.provider.dataanalysis.internal;

import static org.eclipse.lsat.common.queries.QueryableIterable.from;

import java.util.ArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.EMFPlugin.EclipsePlugin;
import org.eclipse.emf.common.util.SegmentSequence;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.plugin.RegistryReader;

import nl.esi.pps.tmsc.provider.dataanalysis.IDataAnalysisItemContentProvider;

public class DataAnalysisItemContentProviderRegistryReader extends RegistryReader {
	private static final String DATA_ANALYSIS_EXTENSION_POINT_ID = "dataAnalysis";
	private static final String TAG_DATA_ANALYSIS = "DataAnalysis";

	private final EclipsePlugin plugin;
	
	private final ArrayList<DataAnalysisExtension> extensions = new ArrayList<>();

	public DataAnalysisItemContentProviderRegistryReader(EclipsePlugin plugin) {
		super(Platform.getExtensionRegistry(), plugin.getBundle().getSymbolicName(), DATA_ANALYSIS_EXTENSION_POINT_ID);
		this.plugin = plugin;
	}
	
	public Iterable<IDataAnalysisItemContentProvider> getDataAnalysisItemContentProviders(EClass eClass) {
		return from(extensions).select(e -> e.getEClass().isSuperTypeOf(eClass)).xcollectOne(DataAnalysisExtension::getContentProvider);
	}
	
	public void dispose() {
		extensions.clear();
	}
	
	@Override
	protected boolean readElement(IConfigurationElement element, boolean add) {
		boolean recognized = false;
		if (element.getName().equals(TAG_DATA_ANALYSIS)) {
			recognized = true;

			final String id = element.getAttribute("id");
			if (id == null || id.isEmpty()) {
				plugin.getLog().error("The data analysis id cannot be empty for: " + element.getContributor().getName());
				return recognized;
			}

			if (!add) {
				extensions.removeIf(e -> id.equals(e.getId()));
				return recognized;
			}

			final String eClassURIStr = element.getAttribute("eclass_uri");
			if (eClassURIStr == null || eClassURIStr.isEmpty()) {
				plugin.getLog()
						.error("The eclass_uri cannot be empty for: " + element.getContributor().getName() + ":" + id);
				return recognized;
			}
			final EClass eClass;
			try {
				URI eClassURI = toEClassURI(eClassURIStr);
				EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(eClassURI.trimFragment().toString());
				if (ePackage == null) {
					plugin.getLog().error("The eclass_uri EPackage is not registered for: "
							+ element.getContributor().getName() + ":" + id);
					return recognized;
				}
				EClassifier eClassifier = ePackage.getEClassifier(eClassURI.fragment());
				if (!(eClassifier instanceof EClass)) {
					plugin.getLog().error("The eclass_uri should point to an EClass for: "
							+ element.getContributor().getName() + ":" + id);
					return recognized;
				}
				eClass = (EClass) eClassifier;
			} catch (IllegalArgumentException e) {
				plugin.getLog().error(
						"The eclass_uri cannot be parsed for: " + element.getContributor().getName() + ":" + id, e);
				return recognized;
			}

			try {
				final IDataAnalysisItemContentProvider contentProvider = (IDataAnalysisItemContentProvider) element
						.createExecutableExtension("content_provider");

				if (!addDataAnalysisExtension(new DataAnalysisExtension(id, eClass, contentProvider))) {
					plugin.getLog().error("Data analysis with id '" + id + "' is already defined, ignoring data analysis from: "
							+ element.getContributor().getName());
				}
			} catch (CoreException e) {
				plugin.getLog().error("The content provider can't be created for data anlysis: "
						+ element.getContributor().getName() + ":" + id, e);
			}
		}

		return recognized;
	}
	
	private boolean addDataAnalysisExtension(DataAnalysisExtension extension) {
		if (from(extensions).exists(e -> e.getId().equals(extension.getId()))) {
			return false;
		}
		for (int i = 0; i < extensions.size(); i++) {
			if (extensions.get(i).getEClass().isSuperTypeOf(extension.getEClass())) {
				extensions.add(i, extension);
				return true;
			}
		}
		extensions.add(extension);
		return true;
	}
	
	private static URI toEClassURI(String value) {
		URI uri = URI.createURI(value);
		String uriFragment = uri.fragment();
		if (uriFragment != null && uriFragment.charAt(0) == '/') {
			SegmentSequence uriFragmentSegments = SegmentSequence.create("/", uriFragment);
			uri = uri.trimFragment();
			for (int i = 0; i < uriFragmentSegments.segmentCount() - 1; i++) {
				if (!uriFragmentSegments.segment(i).isEmpty()) {
					uri = uri.appendSegment(uriFragmentSegments.segment(i));
				}
			}
			uri = uri.appendFragment(uriFragmentSegments.lastSegment());
		}
		return uri;
	}
	
	private static final class DataAnalysisExtension implements Comparable<DataAnalysisExtension> {
		private final String id;
		private final EClass eClass;
		private final IDataAnalysisItemContentProvider contentProvider;

		public DataAnalysisExtension(String id, EClass eClass, IDataAnalysisItemContentProvider contentProvider) {
			this.id = id;
			this.eClass = eClass;
			this.contentProvider = contentProvider;
		}
		
		public String getId() {
			return id;
		}
		
		public EClass getEClass() {
			return eClass;
		}
		
		public IDataAnalysisItemContentProvider getContentProvider() {
			return contentProvider;
		}
		
		@Override
		public int compareTo(DataAnalysisExtension o) {
			// Sort by EClass hierarchy to allow to override for sub-classes, then by id
			/*if (Objects.equals(eClass, o.eClass)) {
				return id.compareTo(o.id);
			} else*/ if (this.eClass.isSuperTypeOf(o.eClass)) {
				System.out.println(o.eClass.getName() + " --|> " + this.eClass.getName());
				return -1;
			} else if (o.eClass.isSuperTypeOf(this.eClass)) {
				System.out.println(this.eClass.getName() + " --|> " + o.eClass.getName());
				return 1;
			} else {
				return id.compareTo(o.id);
			}
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			DataAnalysisExtension other = (DataAnalysisExtension) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}
	}
}
