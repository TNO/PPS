/**
 */
package nl.esi.pps.tmsc;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reply</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.Reply#getRequest <em>Request</em>}</li>
 * </ul>
 *
 * @see nl.esi.pps.tmsc.TmscPackage#getReply()
 * @model
 * @generated
 */
public interface Reply extends Message {
	/**
	 * Returns the value of the '<em><b>Request</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.tmsc.Request#getReplies <em>Replies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Request</em>' reference.
	 * @see #setRequest(Request)
	 * @see nl.esi.pps.tmsc.TmscPackage#getReply_Request()
	 * @see nl.esi.pps.tmsc.Request#getReplies
	 * @model opposite="replies" resolveProxies="false" transient="true"
	 * @generated
	 */
	Request getRequest();

	/**
	 * Sets the value of the '{@link nl.esi.pps.tmsc.Reply#getRequest <em>Request</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Request</em>' reference.
	 * @see #getRequest()
	 * @generated
	 */
	void setRequest(Request value);

} // Reply
