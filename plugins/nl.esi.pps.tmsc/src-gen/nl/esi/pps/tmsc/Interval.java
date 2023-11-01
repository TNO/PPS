/**
 */
package nl.esi.pps.tmsc;

import nl.esi.emf.properties.PropertiesContainer;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interval</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.Interval#getFrom <em>From</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Interval#getTo <em>To</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Interval#getTmsc <em>Tmsc</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Interval#getScopes <em>Scopes</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Interval#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Interval#getEndTime <em>End Time</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Interval#getDuration <em>Duration</em>}</li>
 * </ul>
 *
 * @see nl.esi.pps.tmsc.TmscPackage#getInterval()
 * @model abstract="true" superTypes="nl.esi.emf.properties.PropertiesContainer nl.esi.pps.tmsc.ITimeRange"
 * @generated
 */
public interface Interval extends PropertiesContainer, ITimeRange {
	/**
	 * Returns the value of the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' reference.
	 * @see #setFrom(Event)
	 * @see nl.esi.pps.tmsc.TmscPackage#getInterval_From()
	 * @model required="true"
	 * @generated
	 */
	Event getFrom();

	/**
	 * Sets the value of the '{@link nl.esi.pps.tmsc.Interval#getFrom <em>From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' reference.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(Event value);

	/**
	 * Returns the value of the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To</em>' reference.
	 * @see #setTo(Event)
	 * @see nl.esi.pps.tmsc.TmscPackage#getInterval_To()
	 * @model required="true"
	 * @generated
	 */
	Event getTo();

	/**
	 * Sets the value of the '{@link nl.esi.pps.tmsc.Interval#getTo <em>To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To</em>' reference.
	 * @see #getTo()
	 * @generated
	 */
	void setTo(Event value);

	/**
	 * Returns the value of the '<em><b>Tmsc</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tmsc</em>' reference.
	 * @see nl.esi.pps.tmsc.TmscPackage#getInterval_Tmsc()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	FullScopeTMSC getTmsc();

	/**
	 * Returns the value of the '<em><b>Scopes</b></em>' reference list.
	 * The list contents are of type {@link nl.esi.pps.tmsc.ScopedTMSC}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Typically analysis stores its result as a ScopedTMSC. This relation can be used to avoid duplicate analysis results in the model.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Scopes</em>' reference list.
	 * @see nl.esi.pps.tmsc.TmscPackage#getInterval_Scopes()
	 * @model
	 * @generated
	 */
	EList<ScopedTMSC> getScopes();

	/**
	 * Returns the value of the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Time</em>' attribute.
	 * @see nl.esi.pps.tmsc.TmscPackage#getInterval_StartTime()
	 * @model dataType="nl.esi.pps.tmsc.ETimestamp" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Long getStartTime();

	/**
	 * Returns the value of the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Time</em>' attribute.
	 * @see nl.esi.pps.tmsc.TmscPackage#getInterval_EndTime()
	 * @model dataType="nl.esi.pps.tmsc.ETimestamp" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Long getEndTime();

	/**
	 * Returns the value of the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duration</em>' attribute.
	 * @see nl.esi.pps.tmsc.TmscPackage#getInterval_Duration()
	 * @model dataType="nl.esi.pps.tmsc.EDuration" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Long getDuration();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	String getName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isEpochTime();

} // Interval
