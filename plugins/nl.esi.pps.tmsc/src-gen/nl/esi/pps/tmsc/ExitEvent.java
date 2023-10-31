/**
 */
package nl.esi.pps.tmsc;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exit Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.ExitEvent#getExecution <em>Execution</em>}</li>
 * </ul>
 *
 * @see nl.esi.pps.tmsc.TmscPackage#getExitEvent()
 * @model
 * @generated
 */
public interface ExitEvent extends Event {
	/**
	 * Returns the value of the '<em><b>Execution</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.tmsc.Execution#getExit <em>Exit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Execution</em>' reference.
	 * @see #setExecution(Execution)
	 * @see nl.esi.pps.tmsc.TmscPackage#getExitEvent_Execution()
	 * @see nl.esi.pps.tmsc.Execution#getExit
	 * @model opposite="exit" resolveProxies="false" transient="true"
	 * @generated
	 */
	Execution getExecution();

	/**
	 * Sets the value of the '{@link nl.esi.pps.tmsc.ExitEvent#getExecution <em>Execution</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Execution</em>' reference.
	 * @see #getExecution()
	 * @generated
	 */
	void setExecution(Execution value);

} // ExitEvent
