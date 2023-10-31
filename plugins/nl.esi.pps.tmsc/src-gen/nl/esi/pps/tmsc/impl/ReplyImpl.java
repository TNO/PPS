/**
 */
package nl.esi.pps.tmsc.impl;

import nl.esi.pps.tmsc.Reply;
import nl.esi.pps.tmsc.Request;
import nl.esi.pps.tmsc.TmscPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reply</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.impl.ReplyImpl#getRequest <em>Request</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReplyImpl extends MessageImpl implements Reply {
	/**
	 * The cached value of the '{@link #getRequest() <em>Request</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequest()
	 * @generated
	 * @ordered
	 */
	protected Request request;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReplyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TmscPackage.Literals.REPLY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Request getRequest() {
		return request;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRequest(Request newRequest, NotificationChain msgs) {
		Request oldRequest = request;
		request = newRequest;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TmscPackage.REPLY__REQUEST,
					oldRequest, newRequest);
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
	public void setRequest(Request newRequest) {
		if (newRequest != request) {
			NotificationChain msgs = null;
			if (request != null)
				msgs = ((InternalEObject) request).eInverseRemove(this, TmscPackage.REQUEST__REPLIES, Request.class,
						msgs);
			if (newRequest != null)
				msgs = ((InternalEObject) newRequest).eInverseAdd(this, TmscPackage.REQUEST__REPLIES, Request.class,
						msgs);
			msgs = basicSetRequest(newRequest, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TmscPackage.REPLY__REQUEST, newRequest, newRequest));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case TmscPackage.REPLY__REQUEST:
			if (request != null)
				msgs = ((InternalEObject) request).eInverseRemove(this, TmscPackage.REQUEST__REPLIES, Request.class,
						msgs);
			return basicSetRequest((Request) otherEnd, msgs);
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
		case TmscPackage.REPLY__REQUEST:
			return basicSetRequest(null, msgs);
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
		case TmscPackage.REPLY__REQUEST:
			return getRequest();
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
		case TmscPackage.REPLY__REQUEST:
			setRequest((Request) newValue);
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
		case TmscPackage.REPLY__REQUEST:
			setRequest((Request) null);
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
		case TmscPackage.REPLY__REQUEST:
			return request != null;
		}
		return super.eIsSet(featureID);
	}

} //ReplyImpl
