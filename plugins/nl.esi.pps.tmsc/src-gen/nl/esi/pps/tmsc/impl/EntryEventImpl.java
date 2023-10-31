/**
 */
package nl.esi.pps.tmsc.impl;

import nl.esi.pps.tmsc.EntryEvent;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.TmscPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entry Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.impl.EntryEventImpl#getExecution <em>Execution</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EntryEventImpl extends EventImpl implements EntryEvent {
	/**
	 * The cached value of the '{@link #getExecution() <em>Execution</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecution()
	 * @generated
	 * @ordered
	 */
	protected Execution execution;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntryEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TmscPackage.Literals.ENTRY_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Execution getExecution() {
		return execution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExecution(Execution newExecution, NotificationChain msgs) {
		Execution oldExecution = execution;
		execution = newExecution;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					TmscPackage.ENTRY_EVENT__EXECUTION, oldExecution, newExecution);
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
	public void setExecution(Execution newExecution) {
		if (newExecution != execution) {
			NotificationChain msgs = null;
			if (execution != null)
				msgs = ((InternalEObject) execution).eInverseRemove(this, TmscPackage.EXECUTION__ENTRY, Execution.class,
						msgs);
			if (newExecution != null)
				msgs = ((InternalEObject) newExecution).eInverseAdd(this, TmscPackage.EXECUTION__ENTRY, Execution.class,
						msgs);
			msgs = basicSetExecution(newExecution, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TmscPackage.ENTRY_EVENT__EXECUTION, newExecution,
					newExecution));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case TmscPackage.ENTRY_EVENT__EXECUTION:
			if (execution != null)
				msgs = ((InternalEObject) execution).eInverseRemove(this, TmscPackage.EXECUTION__ENTRY, Execution.class,
						msgs);
			return basicSetExecution((Execution) otherEnd, msgs);
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
		case TmscPackage.ENTRY_EVENT__EXECUTION:
			return basicSetExecution(null, msgs);
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
		case TmscPackage.ENTRY_EVENT__EXECUTION:
			return getExecution();
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
		case TmscPackage.ENTRY_EVENT__EXECUTION:
			setExecution((Execution) newValue);
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
		case TmscPackage.ENTRY_EVENT__EXECUTION:
			setExecution((Execution) null);
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
		case TmscPackage.ENTRY_EVENT__EXECUTION:
			return execution != null;
		}
		return super.eIsSet(featureID);
	}

} //EntryEventImpl
