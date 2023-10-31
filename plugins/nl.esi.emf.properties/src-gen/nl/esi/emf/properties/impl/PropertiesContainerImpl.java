/**
 */
package nl.esi.emf.properties.impl;

import java.io.Serializable;

import nl.esi.emf.properties.PropertiesContainer;
import nl.esi.emf.properties.PropertiesPackage;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.emf.properties.impl.PropertiesContainerImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 *
 * @generated
 */
@SuppressWarnings("deprecation")
public abstract class PropertiesContainerImpl extends MinimalEObjectImpl.Container implements PropertiesContainer {
	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @deprecated
	 * @generated
	 * @ordered
	 */
	@Deprecated
	protected EMap<String, Serializable> properties;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertiesContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PropertiesPackage.Literals.PROPERTIES_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	@Override
	public EMap<String, Serializable> getProperties() {
		if (properties == null) {
			properties = new EcoreEMap<String, Serializable>(PropertiesPackage.Literals.PROPERTY_MAP_ENTRY,
					PropertyMapEntryImpl.class, this, PropertiesPackage.PROPERTIES_CONTAINER__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case PropertiesPackage.PROPERTIES_CONTAINER__PROPERTIES:
			return ((InternalEList<?>) getProperties()).basicRemove(otherEnd, msgs);
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
		case PropertiesPackage.PROPERTIES_CONTAINER__PROPERTIES:
			if (coreType)
				return getProperties();
			else
				return getProperties().map();
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
		case PropertiesPackage.PROPERTIES_CONTAINER__PROPERTIES:
			((EStructuralFeature.Setting) getProperties()).set(newValue);
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
		case PropertiesPackage.PROPERTIES_CONTAINER__PROPERTIES:
			getProperties().clear();
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
		case PropertiesPackage.PROPERTIES_CONTAINER__PROPERTIES:
			return properties != null && !properties.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PropertiesContainerImpl
