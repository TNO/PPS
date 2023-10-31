/**
 */
package nl.esi.pps.tmsc.metric;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.metric.MetricModel#getMetrics <em>Metrics</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.metric.MetricModel#getCategories <em>Categories</em>}</li>
 * </ul>
 *
 * @see nl.esi.pps.tmsc.metric.MetricPackage#getMetricModel()
 * @model
 * @generated
 */
public interface MetricModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Metrics</b></em>' containment reference list.
	 * The list contents are of type {@link nl.esi.pps.tmsc.metric.Metric}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metrics</em>' containment reference list.
	 * @see nl.esi.pps.tmsc.metric.MetricPackage#getMetricModel_Metrics()
	 * @model containment="true" keys="id"
	 * @generated
	 */
	EList<Metric> getMetrics();

	/**
	 * Returns the value of the '<em><b>Categories</b></em>' containment reference list.
	 * The list contents are of type {@link nl.esi.pps.tmsc.metric.MetricCategory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Categories</em>' containment reference list.
	 * @see nl.esi.pps.tmsc.metric.MetricPackage#getMetricModel_Categories()
	 * @model containment="true" keys="name"
	 * @generated
	 */
	EList<MetricCategory> getCategories();

} // MetricModel
