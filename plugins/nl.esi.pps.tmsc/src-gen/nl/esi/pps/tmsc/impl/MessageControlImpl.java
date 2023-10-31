/**
 */
package nl.esi.pps.tmsc.impl;

import nl.esi.pps.tmsc.Message;
import nl.esi.pps.tmsc.MessageControl;
import nl.esi.pps.tmsc.TmscPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message Control</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.impl.MessageControlImpl#getMessage <em>Message</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MessageControlImpl extends DependencyImpl implements MessageControl {
	/**
	 * The cached value of the '{@link #getMessage() <em>Message</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected Message message;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MessageControlImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TmscPackage.Literals.MESSAGE_CONTROL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Message getMessage() {
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMessage(Message newMessage, NotificationChain msgs) {
		Message oldMessage = message;
		message = newMessage;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					TmscPackage.MESSAGE_CONTROL__MESSAGE, oldMessage, newMessage);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMessage(Message newMessage) {
		if (newMessage != message) {
			NotificationChain msgs = null;
			if (message != null)
				msgs = ((InternalEObject) message).eInverseRemove(this, TmscPackage.MESSAGE__CONTROL_DEPENDENCIES,
						Message.class, msgs);
			if (newMessage != null)
				msgs = ((InternalEObject) newMessage).eInverseAdd(this, TmscPackage.MESSAGE__CONTROL_DEPENDENCIES,
						Message.class, msgs);
			msgs = basicSetMessage(newMessage, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TmscPackage.MESSAGE_CONTROL__MESSAGE, newMessage,
					newMessage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case TmscPackage.MESSAGE_CONTROL__MESSAGE:
			if (message != null)
				msgs = ((InternalEObject) message).eInverseRemove(this, TmscPackage.MESSAGE__CONTROL_DEPENDENCIES,
						Message.class, msgs);
			return basicSetMessage((Message) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case TmscPackage.MESSAGE_CONTROL__MESSAGE:
			return basicSetMessage(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case TmscPackage.MESSAGE_CONTROL__MESSAGE:
			return getMessage();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case TmscPackage.MESSAGE_CONTROL__MESSAGE:
			setMessage((Message) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case TmscPackage.MESSAGE_CONTROL__MESSAGE:
			setMessage((Message) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case TmscPackage.MESSAGE_CONTROL__MESSAGE:
			return message != null;
		}
		return super.eIsSet(featureID);
	}

} //MessageControlImpl
