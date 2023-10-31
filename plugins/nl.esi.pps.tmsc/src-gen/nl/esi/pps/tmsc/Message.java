/**
 */
package nl.esi.pps.tmsc;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.Message#getControlDependencies <em>Control Dependencies</em>}</li>
 * </ul>
 *
 * @see nl.esi.pps.tmsc.TmscPackage#getMessage()
 * @model
 * @generated
 */
public interface Message extends Dependency {
	/**
	 * Returns the value of the '<em><b>Control Dependencies</b></em>' reference list.
	 * The list contents are of type {@link nl.esi.pps.tmsc.MessageControl}.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.tmsc.MessageControl#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Control Dependencies</em>' reference list.
	 * @see nl.esi.pps.tmsc.TmscPackage#getMessage_ControlDependencies()
	 * @see nl.esi.pps.tmsc.MessageControl#getMessage
	 * @model opposite="message" resolveProxies="false"
	 * @generated
	 */
	EList<MessageControl> getControlDependencies();

} // Message
