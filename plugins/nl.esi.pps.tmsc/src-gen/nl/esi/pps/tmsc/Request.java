/**
 */
package nl.esi.pps.tmsc;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Request</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.Request#getReplies <em>Replies</em>}</li>
 * </ul>
 *
 * @see nl.esi.pps.tmsc.TmscPackage#getRequest()
 * @model
 * @generated
 */
public interface Request extends Message {
	/**
	 * Returns the value of the '<em><b>Replies</b></em>' reference list.
	 * The list contents are of type {@link nl.esi.pps.tmsc.Reply}.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.tmsc.Reply#getRequest <em>Request</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Replies</em>' reference list.
	 * @see nl.esi.pps.tmsc.TmscPackage#getRequest_Replies()
	 * @see nl.esi.pps.tmsc.Reply#getRequest
	 * @model opposite="request" resolveProxies="false"
	 * @generated
	 */
	EList<Reply> getReplies();

} // Request
