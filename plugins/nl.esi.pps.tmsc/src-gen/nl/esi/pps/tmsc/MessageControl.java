/**
 */
package nl.esi.pps.tmsc;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message Control</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.MessageControl#getMessage <em>Message</em>}</li>
 * </ul>
 *
 * @see nl.esi.pps.tmsc.TmscPackage#getMessageControl()
 * @model
 * @generated
 */
public interface MessageControl extends Dependency {
	/**
	 * Returns the value of the '<em><b>Message</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.tmsc.Message#getControlDependencies <em>Control Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' reference.
	 * @see #setMessage(Message)
	 * @see nl.esi.pps.tmsc.TmscPackage#getMessageControl_Message()
	 * @see nl.esi.pps.tmsc.Message#getControlDependencies
	 * @model opposite="controlDependencies" resolveProxies="false" required="true" transient="true"
	 * @generated
	 */
	Message getMessage();

	/**
	 * Sets the value of the '{@link nl.esi.pps.tmsc.MessageControl#getMessage <em>Message</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' reference.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(Message value);

} // MessageControl
