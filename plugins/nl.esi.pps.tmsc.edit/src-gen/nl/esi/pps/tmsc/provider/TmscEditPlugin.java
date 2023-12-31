/**
 */
package nl.esi.pps.tmsc.provider;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.osgi.framework.BundleContext;

import nl.esi.emf.properties.provider.PropertiesEditPlugin;
import nl.esi.emf.properties.provider.PropertiesItemProviderAdapterFactory;
import nl.esi.pps.architecture.deployed.provider.DeployedItemProviderAdapterFactory;
import nl.esi.pps.architecture.implemented.provider.ImplementedItemProviderAdapterFactory;
import nl.esi.pps.architecture.instantiated.provider.InstantiatedItemProviderAdapterFactory;
import nl.esi.pps.architecture.provider.ArchitectureEditPlugin;
import nl.esi.pps.architecture.provider.ArchitectureItemProviderAdapterFactory;
import nl.esi.pps.architecture.specified.provider.SpecifiedItemProviderAdapterFactory;
import nl.esi.pps.common.emf.common.PngEclipsePlugin;
import nl.esi.pps.tmsc.provider.dataanalysis.IDataAnalysisItemContentProvider;
import nl.esi.pps.tmsc.provider.dataanalysis.internal.DataAnalysisItemContentProviderRegistryReader;

/**
 * This is the central singleton for the Tmsc edit plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class TmscEditPlugin extends EMFPlugin {
	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final TmscEditPlugin INSTANCE = new TmscEditPlugin();

	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static Implementation plugin;

	/**
	 * Create the instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmscEditPlugin() {
		super(new ResourceLocator[] { ArchitectureEditPlugin.INSTANCE, PropertiesEditPlugin.INSTANCE, });
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	public static Implementation getPlugin() {
		return plugin;
	}

	/**
	 * Creates a {@link ResourceSet} with edit support.
	 * 
	 * @see #createItemProviderAdapterFactory()
	 * @see ResourceSet#getAdapterFactories()
	 */
	public static ResourceSet createResourceSet() {
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		resourceSet.getAdapterFactories().add(createItemProviderAdapterFactory());
		return resourceSet;
	}

	/**
	 * Creates a {@link ComposedAdapterFactory} for all dependent languages, incl. reflective support.
	 */
	public static ComposedAdapterFactory createItemProviderAdapterFactory() {
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE) {
			// Avoiding multi-threading issues by making this method synchronized
			@Override
			public synchronized AdapterFactory getFactoryForTypes(Collection<?> types) {
				return super.getFactoryForTypes(types);
			}
		};
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new TmscItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ArchitectureItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new SpecifiedItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ImplementedItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new DeployedItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new InstantiatedItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new PropertiesItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		return adapterFactory;
	}

	/**
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static class Implementation extends PngEclipsePlugin {
		private DataAnalysisItemContentProviderRegistryReader dataAnalysisRegistryReader = null;

		/**
		 * Creates an instance.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public Implementation() {
			super();

			// Remember the static instance.
			//
			plugin = this;
		}

		@Override
		public void start(BundleContext context) throws Exception {
			super.start(context);
		}

		@Override
		public void stop(BundleContext context) throws Exception {
			super.stop(context);
			if (dataAnalysisRegistryReader != null) {
				dataAnalysisRegistryReader.dispose();
			}
		}

		/**
		 * Returns an unmodifiable {@link Map} containing all registered
		 * {@link IDataAnalysisItemContentProvider data-analysis content providers},
		 * mapped by their
		 * {@link IDataAnalysisItemContentProvider#getConfigurations(Object)
		 * configuration}.
		 * 
		 * @return a {@link Map} containing all registered data-analysis content
		 *         providers, mapped by their configuration.
		 */
		public Iterable<IDataAnalysisItemContentProvider> getRegisteredDataAnalysisItemContentProviders(EClass eClass) {
			if (dataAnalysisRegistryReader == null) {
				dataAnalysisRegistryReader = new DataAnalysisItemContentProviderRegistryReader(this);
				dataAnalysisRegistryReader.readRegistry();
			}
			return dataAnalysisRegistryReader.getDataAnalysisItemContentProviders(eClass);
		}
	}
}
