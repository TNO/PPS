/**
 */
package nl.esi.pps.tmsc.metric;

import java.util.Map;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.osgi.framework.BundleContext;

import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.metric.extension.MetricProcessor;

/**
 * This is the central singleton for the Metric model plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class MetricPlugin extends EMFPlugin {
	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final MetricPlugin INSTANCE = new MetricPlugin();

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
	public MetricPlugin() {
		super(new ResourceLocator[] {});
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
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class Implementation extends EclipsePlugin {
		private final MetricRegistryReader metricRegistryReader = new MetricRegistryReader(this);

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
			metricRegistryReader.readRegistry();
		}

		/**
		 * Returns an unmodifiable {@link Map} containing all registered Metric extensions,
		 * mapped by their {@link MetricProcessor#getId() id}.
		 * 
		 * @return a {@link Map} containing all registered Metric extensions, mapped by
		 *         their {@link MetricProcessor#getId() id}.
		 */
		public Map<String, MetricProcessor> getRegisteredMetricProcessors() {
			return getRegisteredMetricProcessors(null);
		}

		/**
		 * Returns an unmodifiable {@link Map} containing all registered Metric extensions,
		 * mapped by their {@link MetricProcessor#getId() id}.
		 * 
		 * @return a {@link Map} containing all registered Metric extensions, mapped by
		 *         their {@link MetricProcessor#getId() id}.
		 */
		public Map<String, MetricProcessor> getRegisteredMetricProcessors(FullScopeTMSC tmsc) {
			return MapExtensions.filter(metricRegistryReader.getMetricProcessors(), (K, V) -> V.isEnabled(tmsc));
		}
	}

}
