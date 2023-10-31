/**
 */
package nl.esi.pps.architecture.specified.impl;

import java.util.Collection;

import nl.esi.pps.architecture.impl.NamedArchitectureElementImpl;

import nl.esi.pps.architecture.specified.Component;
import nl.esi.pps.architecture.specified.Interface;
import nl.esi.pps.architecture.specified.SpecifiedPackage;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.architecture.specified.impl.ComponentImpl#getRequiredInterfaces <em>Required Interfaces</em>}</li>
 *   <li>{@link nl.esi.pps.architecture.specified.impl.ComponentImpl#getProvidedInterfaces <em>Provided Interfaces</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComponentImpl extends NamedArchitectureElementImpl implements Component {
	/**
	 * The cached value of the '{@link #getRequiredInterfaces() <em>Required Interfaces</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredInterfaces()
	 * @generated
	 * @ordered
	 */
	protected EList<Interface> requiredInterfaces;

	/**
	 * The cached value of the '{@link #getProvidedInterfaces() <em>Provided Interfaces</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidedInterfaces()
	 * @generated
	 * @ordered
	 */
	protected EList<Interface> providedInterfaces;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpecifiedPackage.Literals.COMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Interface> getRequiredInterfaces() {
		if (requiredInterfaces == null) {
			requiredInterfaces = new EObjectWithInverseResolvingEList.ManyInverse<Interface>(Interface.class, this,
					SpecifiedPackage.COMPONENT__REQUIRED_INTERFACES, SpecifiedPackage.INTERFACE__REQUIRED_BY);
		}
		return requiredInterfaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Interface> getProvidedInterfaces() {
		if (providedInterfaces == null) {
			providedInterfaces = new EObjectWithInverseResolvingEList.ManyInverse<Interface>(Interface.class, this,
					SpecifiedPackage.COMPONENT__PROVIDED_INTERFACES, SpecifiedPackage.INTERFACE__PROVIDED_BY);
		}
		return providedInterfaces;
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
		case SpecifiedPackage.COMPONENT__REQUIRED_INTERFACES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getRequiredInterfaces()).basicAdd(otherEnd,
					msgs);
		case SpecifiedPackage.COMPONENT__PROVIDED_INTERFACES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getProvidedInterfaces()).basicAdd(otherEnd,
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
		case SpecifiedPackage.COMPONENT__REQUIRED_INTERFACES:
			return ((InternalEList<?>) getRequiredInterfaces()).basicRemove(otherEnd, msgs);
		case SpecifiedPackage.COMPONENT__PROVIDED_INTERFACES:
			return ((InternalEList<?>) getProvidedInterfaces()).basicRemove(otherEnd, msgs);
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
		case SpecifiedPackage.COMPONENT__REQUIRED_INTERFACES:
			return getRequiredInterfaces();
		case SpecifiedPackage.COMPONENT__PROVIDED_INTERFACES:
			return getProvidedInterfaces();
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
		case SpecifiedPackage.COMPONENT__REQUIRED_INTERFACES:
			getRequiredInterfaces().clear();
			getRequiredInterfaces().addAll((Collection<? extends Interface>) newValue);
			return;
		case SpecifiedPackage.COMPONENT__PROVIDED_INTERFACES:
			getProvidedInterfaces().clear();
			getProvidedInterfaces().addAll((Collection<? extends Interface>) newValue);
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
		case SpecifiedPackage.COMPONENT__REQUIRED_INTERFACES:
			getRequiredInterfaces().clear();
			return;
		case SpecifiedPackage.COMPONENT__PROVIDED_INTERFACES:
			getProvidedInterfaces().clear();
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
		case SpecifiedPackage.COMPONENT__REQUIRED_INTERFACES:
			return requiredInterfaces != null && !requiredInterfaces.isEmpty();
		case SpecifiedPackage.COMPONENT__PROVIDED_INTERFACES:
			return providedInterfaces != null && !providedInterfaces.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ComponentImpl
