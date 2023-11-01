/**
 */
package nl.esi.pps.tmsc;

import nl.esi.pps.architecture.ArchitectureModel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Full Scope TMSC</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * FullScopeTMSC contains all events (via Lifeline) and dependencies of the TMSC model. 
 * It has the startTime and endTime attributes which are timestamps derived from the TMSC model, denoting the start and end time of the considered trace.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.FullScopeTMSC#getMeasurements <em>Measurements</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.FullScopeTMSC#getLifelines <em>Lifelines</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.FullScopeTMSC#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.FullScopeTMSC#getArchitectures <em>Architectures</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.FullScopeTMSC#isEpochTime <em>Epoch Time</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.FullScopeTMSC#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.FullScopeTMSC#getEndTime <em>End Time</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.FullScopeTMSC#getDuration <em>Duration</em>}</li>
 * </ul>
 *
 * @see nl.esi.pps.tmsc.TmscPackage#getFullScopeTMSC()
 * @model superTypes="nl.esi.pps.tmsc.TMSC nl.esi.pps.tmsc.ITimeRange"
 * @generated
 */
public interface FullScopeTMSC extends TMSC, ITimeRange {
	/**
	 * Returns the value of the '<em><b>Measurements</b></em>' containment reference list.
	 * The list contents are of type {@link nl.esi.pps.tmsc.Measurement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measurements</em>' containment reference list.
	 * @see nl.esi.pps.tmsc.TmscPackage#getFullScopeTMSC_Measurements()
	 * @model containment="true"
	 * @generated
	 */
	EList<Measurement> getMeasurements();

	/**
	 * Returns the value of the '<em><b>Lifelines</b></em>' containment reference list.
	 * The list contents are of type {@link nl.esi.pps.tmsc.Lifeline}.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.tmsc.Lifeline#getTmsc <em>Tmsc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lifelines</em>' containment reference list.
	 * @see nl.esi.pps.tmsc.TmscPackage#getFullScopeTMSC_Lifelines()
	 * @see nl.esi.pps.tmsc.Lifeline#getTmsc
	 * @model opposite="tmsc" containment="true"
	 * @generated
	 */
	EList<Lifeline> getLifelines();

	/**
	 * Returns the value of the '<em><b>Dependencies</b></em>' containment reference list.
	 * The list contents are of type {@link nl.esi.pps.tmsc.Dependency}.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.tmsc.Dependency#getTmsc <em>Tmsc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependencies</em>' containment reference list.
	 * @see nl.esi.pps.tmsc.TmscPackage#getFullScopeTMSC_Dependencies()
	 * @see nl.esi.pps.tmsc.Dependency#getTmsc
	 * @model opposite="tmsc" containment="true"
	 * @generated
	 */
	EList<Dependency> getDependencies();

	/**
	 * Returns the value of the '<em><b>Architectures</b></em>' reference list.
	 * The list contents are of type {@link nl.esi.pps.architecture.ArchitectureModel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * References all model roots (i.e. ArchitectureModels) that own the architectural elements that are referenced by the model elements of this FullScopeTMSC.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Architectures</em>' reference list.
	 * @see nl.esi.pps.tmsc.TmscPackage#getFullScopeTMSC_Architectures()
	 * @model
	 * @generated
	 */
	EList<ArchitectureModel> getArchitectures();

	/**
	 * Returns the value of the '<em><b>Epoch Time</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Epoch Time</em>' attribute.
	 * @see #setEpochTime(boolean)
	 * @see nl.esi.pps.tmsc.TmscPackage#getFullScopeTMSC_EpochTime()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isEpochTime();

	/**
	 * Sets the value of the '{@link nl.esi.pps.tmsc.FullScopeTMSC#isEpochTime <em>Epoch Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Epoch Time</em>' attribute.
	 * @see #isEpochTime()
	 * @generated
	 */
	void setEpochTime(boolean value);

	/**
	 * Returns the value of the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Time</em>' attribute.
	 * @see #setStartTime(Long)
	 * @see nl.esi.pps.tmsc.TmscPackage#getFullScopeTMSC_StartTime()
	 * @model dataType="nl.esi.pps.tmsc.ETimestamp" required="true"
	 * @generated
	 */
	Long getStartTime();

	/**
	 * Sets the value of the '{@link nl.esi.pps.tmsc.FullScopeTMSC#getStartTime <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Time</em>' attribute.
	 * @see #getStartTime()
	 * @generated
	 */
	void setStartTime(Long value);

	/**
	 * Returns the value of the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Time</em>' attribute.
	 * @see #setEndTime(Long)
	 * @see nl.esi.pps.tmsc.TmscPackage#getFullScopeTMSC_EndTime()
	 * @model dataType="nl.esi.pps.tmsc.ETimestamp" required="true"
	 * @generated
	 */
	Long getEndTime();

	/**
	 * Sets the value of the '{@link nl.esi.pps.tmsc.FullScopeTMSC#getEndTime <em>End Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Time</em>' attribute.
	 * @see #getEndTime()
	 * @generated
	 */
	void setEndTime(Long value);

	/**
	 * Returns the value of the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duration</em>' attribute.
	 * @see nl.esi.pps.tmsc.TmscPackage#getFullScopeTMSC_Duration()
	 * @model dataType="nl.esi.pps.tmsc.EDuration" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Long getDuration();

} // FullScopeTMSC
