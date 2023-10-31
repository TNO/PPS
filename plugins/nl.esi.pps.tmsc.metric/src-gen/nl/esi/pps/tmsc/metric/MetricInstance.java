/**
 */
package nl.esi.pps.tmsc.metric;

import nl.esi.pps.tmsc.Interval;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.metric.MetricInstance#getId <em>Id</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.metric.MetricInstance#getName <em>Name</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.metric.MetricInstance#isExceedsBudget <em>Exceeds Budget</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.metric.MetricInstance#getMetric <em>Metric</em>}</li>
 * </ul>
 *
 * @see nl.esi.pps.tmsc.metric.MetricPackage#getMetricInstance()
 * @model
 * @generated
 */
public interface MetricInstance extends Interval {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see nl.esi.pps.tmsc.metric.MetricPackage#getMetricInstance_Id()
	 * @model required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link nl.esi.pps.tmsc.metric.MetricInstance#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see nl.esi.pps.tmsc.metric.MetricPackage#getMetricInstance_Name()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getName();

	/**
	 * Returns the value of the '<em><b>Exceeds Budget</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exceeds Budget</em>' attribute.
	 * @see nl.esi.pps.tmsc.metric.MetricPackage#getMetricInstance_ExceedsBudget()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isExceedsBudget();

	/**
	 * Returns the value of the '<em><b>Metric</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.tmsc.metric.Metric#getInstances <em>Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metric</em>' container reference.
	 * @see #setMetric(Metric)
	 * @see nl.esi.pps.tmsc.metric.MetricPackage#getMetricInstance_Metric()
	 * @see nl.esi.pps.tmsc.metric.Metric#getInstances
	 * @model opposite="instances" required="true" transient="false"
	 * @generated
	 */
	Metric getMetric();

	/**
	 * Sets the value of the '{@link nl.esi.pps.tmsc.metric.MetricInstance#getMetric <em>Metric</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metric</em>' container reference.
	 * @see #getMetric()
	 * @generated
	 */
	void setMetric(Metric value);

} // MetricInstance
