/**
 */
package nl.esi.pps.tmsc;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entry Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.EntryEvent#getExecution <em>Execution</em>}</li>
 * </ul>
 *
 * @see nl.esi.pps.tmsc.TmscPackage#getEntryEvent()
 * @model
 * @generated
 */
public interface EntryEvent extends Event {
	/**
	 * Returns the value of the '<em><b>Execution</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.tmsc.Execution#getEntry <em>Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Execution</em>' reference.
	 * @see #setExecution(Execution)
	 * @see nl.esi.pps.tmsc.TmscPackage#getEntryEvent_Execution()
	 * @see nl.esi.pps.tmsc.Execution#getEntry
	 * @model opposite="entry" resolveProxies="false" transient="true"
	 * @generated
	 */
	Execution getExecution();

	/**
	 * Sets the value of the '{@link nl.esi.pps.tmsc.EntryEvent#getExecution <em>Execution</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Execution</em>' reference.
	 * @see #getExecution()
	 * @generated
	 */
	void setExecution(Execution value);

} // EntryEvent
