/**
 */
package nl.esi.pps.tmsc.impl;

import java.util.Collection;

import nl.esi.pps.tmsc.Message;
import nl.esi.pps.tmsc.MessageControl;
import nl.esi.pps.tmsc.TmscPackage;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.impl.MessageImpl#getControlDependencies <em>Control Dependencies</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MessageImpl extends DependencyImpl implements Message {
	/**
	 * The cached value of the '{@link #getControlDependencies() <em>Control Dependencies</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControlDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<MessageControl> controlDependencies;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MessageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TmscPackage.Literals.MESSAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MessageControl> getControlDependencies() {
		if (controlDependencies == null) {
			controlDependencies = new EObjectWithInverseEList<MessageControl>(MessageControl.class, this,
					TmscPackage.MESSAGE__CONTROL_DEPENDENCIES, TmscPackage.MESSAGE_CONTROL__MESSAGE);
		}
		return controlDependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case TmscPackage.MESSAGE__CONTROL_DEPENDENCIES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getControlDependencies()).basicAdd(otherEnd,
					msgs);
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
		case TmscPackage.MESSAGE__CONTROL_DEPENDENCIES:
			return ((InternalEList<?>) getControlDependencies()).basicRemove(otherEnd, msgs);
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
		case TmscPackage.MESSAGE__CONTROL_DEPENDENCIES:
			return getControlDependencies();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case TmscPackage.MESSAGE__CONTROL_DEPENDENCIES:
			getControlDependencies().clear();
			getControlDependencies().addAll((Collection<? extends MessageControl>) newValue);
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
		case TmscPackage.MESSAGE__CONTROL_DEPENDENCIES:
			getControlDependencies().clear();
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
		case TmscPackage.MESSAGE__CONTROL_DEPENDENCIES:
			return controlDependencies != null && !controlDependencies.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MessageImpl
