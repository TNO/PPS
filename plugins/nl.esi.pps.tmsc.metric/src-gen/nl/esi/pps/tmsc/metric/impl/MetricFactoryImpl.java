/**
 */
package nl.esi.pps.tmsc.metric.impl;

import nl.esi.pps.tmsc.metric.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MetricFactoryImpl extends EFactoryImpl implements MetricFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MetricFactory init() {
		try {
			MetricFactory theMetricFactory = (MetricFactory) EPackage.Registry.INSTANCE
					.getEFactory(MetricPackage.eNS_URI);
			if (theMetricFactory != null) {
				return theMetricFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MetricFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case MetricPackage.METRIC_MODEL:
			return createMetricModel();
		case MetricPackage.METRIC_CATEGORY:
			return createMetricCategory();
		case MetricPackage.METRIC:
			return createMetric();
		case MetricPackage.METRIC_INSTANCE:
			return createMetricInstance();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MetricModel createMetricModel() {
		MetricModelImpl metricModel = new MetricModelImpl();
		return metricModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MetricCategory createMetricCategory() {
		MetricCategoryImpl metricCategory = new MetricCategoryImpl();
		return metricCategory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Metric createMetric() {
		MetricImpl metric = new MetricImpl();
		return metric;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MetricInstance createMetricInstance() {
		MetricInstanceImpl metricInstance = new MetricInstanceImpl();
		return metricInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MetricPackage getMetricPackage() {
		return (MetricPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MetricPackage getPackage() {
		return MetricPackage.eINSTANCE;
	}

} //MetricFactoryImpl
