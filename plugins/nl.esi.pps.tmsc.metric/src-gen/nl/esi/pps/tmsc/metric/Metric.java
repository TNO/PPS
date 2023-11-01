/**
 */
package nl.esi.pps.tmsc.metric;

import nl.esi.pps.tmsc.FullScopeTMSC;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metric</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.metric.Metric#getId <em>Id</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.metric.Metric#getName <em>Name</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.metric.Metric#getBudget <em>Budget</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.metric.Metric#getCategory <em>Category</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.metric.Metric#getInstances <em>Instances</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.metric.Metric#getTmscs <em>Tmscs</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.metric.Metric#getConfiguration <em>Configuration</em>}</li>
 * </ul>
 *
 * @see nl.esi.pps.tmsc.metric.MetricPackage#getMetric()
 * @model
 * @generated
 */
public interface Metric extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see nl.esi.pps.tmsc.metric.MetricPackage#getMetric_Id()
	 * @model required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link nl.esi.pps.tmsc.metric.Metric#getId <em>Id</em>}' attribute.
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
	 * @see #setName(String)
	 * @see nl.esi.pps.tmsc.metric.MetricPackage#getMetric_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link nl.esi.pps.tmsc.metric.Metric#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Budget</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Budget</em>' attribute.
	 * @see #setBudget(Long)
	 * @see nl.esi.pps.tmsc.metric.MetricPackage#getMetric_Budget()
	 * @model dataType="nl.esi.pps.tmsc.EDuration"
	 * @generated
	 */
	Long getBudget();

	/**
	 * Sets the value of the '{@link nl.esi.pps.tmsc.metric.Metric#getBudget <em>Budget</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Budget</em>' attribute.
	 * @see #getBudget()
	 * @generated
	 */
	void setBudget(Long value);

	/**
	 * Returns the value of the '<em><b>Category</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.tmsc.metric.MetricCategory#getMetrics <em>Metrics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Category</em>' reference.
	 * @see #setCategory(MetricCategory)
	 * @see nl.esi.pps.tmsc.metric.MetricPackage#getMetric_Category()
	 * @see nl.esi.pps.tmsc.metric.MetricCategory#getMetrics
	 * @model opposite="metrics" required="true"
	 * @generated
	 */
	MetricCategory getCategory();

	/**
	 * Sets the value of the '{@link nl.esi.pps.tmsc.metric.Metric#getCategory <em>Category</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Category</em>' reference.
	 * @see #getCategory()
	 * @generated
	 */
	void setCategory(MetricCategory value);

	/**
	 * Returns the value of the '<em><b>Instances</b></em>' containment reference list.
	 * The list contents are of type {@link nl.esi.pps.tmsc.metric.MetricInstance}.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.tmsc.metric.MetricInstance#getMetric <em>Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instances</em>' containment reference list.
	 * @see nl.esi.pps.tmsc.metric.MetricPackage#getMetric_Instances()
	 * @see nl.esi.pps.tmsc.metric.MetricInstance#getMetric
	 * @model opposite="metric" containment="true" keys="id"
	 * @generated
	 */
	EList<MetricInstance> getInstances();

	/**
	 * Returns the value of the '<em><b>Tmscs</b></em>' reference list.
	 * The list contents are of type {@link nl.esi.pps.tmsc.FullScopeTMSC}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The TMSCs that were analyzed to resolve the Metric instances that are contained by this Metric.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Tmscs</em>' reference list.
	 * @see nl.esi.pps.tmsc.metric.MetricPackage#getMetric_Tmscs()
	 * @model
	 * @generated
	 */
	EList<FullScopeTMSC> getTmscs();

	/**
	 * Returns the value of the '<em><b>Configuration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration</em>' attribute.
	 * @see #setConfiguration(String)
	 * @see nl.esi.pps.tmsc.metric.MetricPackage#getMetric_Configuration()
	 * @model
	 * @generated
	 */
	String getConfiguration();

	/**
	 * Sets the value of the '{@link nl.esi.pps.tmsc.metric.Metric#getConfiguration <em>Configuration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration</em>' attribute.
	 * @see #getConfiguration()
	 * @generated
	 */
	void setConfiguration(String value);

} // Metric
