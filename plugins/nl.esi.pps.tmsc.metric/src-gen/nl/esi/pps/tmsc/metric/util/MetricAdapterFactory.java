/**
 */
package nl.esi.pps.tmsc.metric.util;

import nl.esi.emf.properties.PropertiesContainer;

import nl.esi.pps.tmsc.ITimeRange;
import nl.esi.pps.tmsc.Interval;

import nl.esi.pps.tmsc.metric.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see nl.esi.pps.tmsc.metric.MetricPackage
 * @generated
 */
public class MetricAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MetricPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = MetricPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetricSwitch<Adapter> modelSwitch = new MetricSwitch<Adapter>() {
		@Override
		public Adapter caseMetricModel(MetricModel object) {
			return createMetricModelAdapter();
		}

		@Override
		public Adapter caseMetricCategory(MetricCategory object) {
			return createMetricCategoryAdapter();
		}

		@Override
		public Adapter caseMetric(Metric object) {
			return createMetricAdapter();
		}

		@Override
		public Adapter caseMetricInstance(MetricInstance object) {
			return createMetricInstanceAdapter();
		}

		@Override
		public Adapter casePropertiesContainer(PropertiesContainer object) {
			return createPropertiesContainerAdapter();
		}

		@Override
		public Adapter caseITimeRange(ITimeRange object) {
			return createITimeRangeAdapter();
		}

		@Override
		public Adapter caseInterval(Interval object) {
			return createIntervalAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esi.pps.tmsc.metric.MetricModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esi.pps.tmsc.metric.MetricModel
	 * @generated
	 */
	public Adapter createMetricModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esi.pps.tmsc.metric.MetricCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esi.pps.tmsc.metric.MetricCategory
	 * @generated
	 */
	public Adapter createMetricCategoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esi.pps.tmsc.metric.Metric <em>Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esi.pps.tmsc.metric.Metric
	 * @generated
	 */
	public Adapter createMetricAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esi.pps.tmsc.metric.MetricInstance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esi.pps.tmsc.metric.MetricInstance
	 * @generated
	 */
	public Adapter createMetricInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esi.emf.properties.PropertiesContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esi.emf.properties.PropertiesContainer
	 * @generated
	 */
	public Adapter createPropertiesContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esi.pps.tmsc.ITimeRange <em>ITime Range</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esi.pps.tmsc.ITimeRange
	 * @generated
	 */
	public Adapter createITimeRangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esi.pps.tmsc.Interval <em>Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esi.pps.tmsc.Interval
	 * @generated
	 */
	public Adapter createIntervalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //MetricAdapterFactory
