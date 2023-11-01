/**
 */
package nl.esi.pps.architecture.example.impl;

import java.util.Collection;

import nl.esi.pps.architecture.deployed.impl.HostImpl;

import nl.esi.pps.architecture.example.ExampleHost;
import nl.esi.pps.architecture.example.ExamplePackage;

import nl.esi.pps.architecture.instantiated.Executor;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Host</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.architecture.example.impl.ExampleHostImpl#getExecutors <em>Executors</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExampleHostImpl extends HostImpl implements ExampleHost {
	/**
	 * The cached value of the '{@link #getExecutors() <em>Executors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutors()
	 * @generated
	 * @ordered
	 */
	protected EList<Executor> executors;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExampleHostImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExamplePackage.Literals.EXAMPLE_HOST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Executor> getExecutors() {
		if (executors == null) {
			executors = new EObjectContainmentEList<Executor>(Executor.class, this,
					ExamplePackage.EXAMPLE_HOST__EXECUTORS);
		}
		return executors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ExamplePackage.EXAMPLE_HOST__EXECUTORS:
			return ((InternalEList<?>) getExecutors()).basicRemove(otherEnd, msgs);
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
		case ExamplePackage.EXAMPLE_HOST__EXECUTORS:
			return getExecutors();
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
		case ExamplePackage.EXAMPLE_HOST__EXECUTORS:
			getExecutors().clear();
			getExecutors().addAll((Collection<? extends Executor>) newValue);
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
		case ExamplePackage.EXAMPLE_HOST__EXECUTORS:
			getExecutors().clear();
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
		case ExamplePackage.EXAMPLE_HOST__EXECUTORS:
			return executors != null && !executors.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ExampleHostImpl
