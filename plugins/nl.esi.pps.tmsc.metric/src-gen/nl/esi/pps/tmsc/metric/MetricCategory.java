/**
 */
package nl.esi.pps.tmsc.metric;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Category</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.metric.MetricCategory#getName <em>Name</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.metric.MetricCategory#getMetrics <em>Metrics</em>}</li>
 * </ul>
 *
 * @see nl.esi.pps.tmsc.metric.MetricPackage#getMetricCategory()
 * @model
 * @generated
 */
public interface MetricCategory extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see nl.esi.pps.tmsc.metric.MetricPackage#getMetricCategory_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link nl.esi.pps.tmsc.metric.MetricCategory#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Metrics</b></em>' reference list.
	 * The list contents are of type {@link nl.esi.pps.tmsc.metric.Metric}.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.tmsc.metric.Metric#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metrics</em>' reference list.
	 * @see nl.esi.pps.tmsc.metric.MetricPackage#getMetricCategory_Metrics()
	 * @see nl.esi.pps.tmsc.metric.Metric#getCategory
	 * @model opposite="category"
	 * @generated
	 */
	EList<Metric> getMetrics();

} // MetricCategory
