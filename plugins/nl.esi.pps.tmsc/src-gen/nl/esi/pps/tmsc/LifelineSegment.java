/**
 */
package nl.esi.pps.tmsc;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lifeline Segment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.LifelineSegment#getLifeline <em>Lifeline</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.LifelineSegment#getActiveExecution <em>Active Execution</em>}</li>
 * </ul>
 *
 * @see nl.esi.pps.tmsc.TmscPackage#getLifelineSegment()
 * @model
 * @generated
 */
public interface LifelineSegment extends Dependency {
	/**
	 * Returns the value of the '<em><b>Lifeline</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.tmsc.Lifeline#getSegments <em>Segments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lifeline</em>' reference.
	 * @see nl.esi.pps.tmsc.TmscPackage#getLifelineSegment_Lifeline()
	 * @see nl.esi.pps.tmsc.Lifeline#getSegments
	 * @model opposite="segments" resolveProxies="false" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Lifeline getLifeline();

	/**
	 * Returns the value of the '<em><b>Active Execution</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.tmsc.Execution#getSegments <em>Segments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active Execution</em>' reference.
	 * @see nl.esi.pps.tmsc.TmscPackage#getLifelineSegment_ActiveExecution()
	 * @see nl.esi.pps.tmsc.Execution#getSegments
	 * @model opposite="segments" resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Execution getActiveExecution();

} // LifelineSegment
