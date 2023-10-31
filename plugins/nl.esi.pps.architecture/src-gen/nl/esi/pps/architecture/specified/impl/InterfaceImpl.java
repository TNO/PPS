/**
 */
package nl.esi.pps.architecture.specified.impl;

import java.util.Collection;

import nl.esi.pps.architecture.impl.NamedArchitectureElementImpl;

import nl.esi.pps.architecture.specified.Component;
import nl.esi.pps.architecture.specified.Interface;
import nl.esi.pps.architecture.specified.Operation;
import nl.esi.pps.architecture.specified.SpecifiedPackage;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.architecture.specified.impl.InterfaceImpl#getRequiredBy <em>Required By</em>}</li>
 *   <li>{@link nl.esi.pps.architecture.specified.impl.InterfaceImpl#getProvidedBy <em>Provided By</em>}</li>
 *   <li>{@link nl.esi.pps.architecture.specified.impl.InterfaceImpl#getOperations <em>Operations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InterfaceImpl extends NamedArchitectureElementImpl implements Interface {
	/**
	 * The cached value of the '{@link #getRequiredBy() <em>Required By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredBy()
	 * @generated
	 * @ordered
	 */
	protected EList<Component> requiredBy;

	/**
	 * The cached value of the '{@link #getProvidedBy() <em>Provided By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<Component> providedBy;

	/**
	 * The cached value of the '{@link #getOperations() <em>Operations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<Operation> operations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InterfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpecifiedPackage.Literals.INTERFACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Component> getRequiredBy() {
		if (requiredBy == null) {
			requiredBy = new EObjectWithInverseResolvingEList.ManyInverse<Component>(Component.class, this,
					SpecifiedPackage.INTERFACE__REQUIRED_BY, SpecifiedPackage.COMPONENT__REQUIRED_INTERFACES);
		}
		return requiredBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Component> getProvidedBy() {
		if (providedBy == null) {
			providedBy = new EObjectWithInverseResolvingEList.ManyInverse<Component>(Component.class, this,
					SpecifiedPackage.INTERFACE__PROVIDED_BY, SpecifiedPackage.COMPONENT__PROVIDED_INTERFACES);
		}
		return providedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Operation> getOperations() {
		if (operations == null) {
			operations = new EObjectContainmentWithInverseEList<Operation>(Operation.class, this,
					SpecifiedPackage.INTERFACE__OPERATIONS, SpecifiedPackage.OPERATION__INTERFACE);
		}
		return operations;
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
		case SpecifiedPackage.INTERFACE__REQUIRED_BY:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getRequiredBy()).basicAdd(otherEnd, msgs);
		case SpecifiedPackage.INTERFACE__PROVIDED_BY:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getProvidedBy()).basicAdd(otherEnd, msgs);
		case SpecifiedPackage.INTERFACE__OPERATIONS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getOperations()).basicAdd(otherEnd, msgs);
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
		case SpecifiedPackage.INTERFACE__REQUIRED_BY:
			return ((InternalEList<?>) getRequiredBy()).basicRemove(otherEnd, msgs);
		case SpecifiedPackage.INTERFACE__PROVIDED_BY:
			return ((InternalEList<?>) getProvidedBy()).basicRemove(otherEnd, msgs);
		case SpecifiedPackage.INTERFACE__OPERATIONS:
			return ((InternalEList<?>) getOperations()).basicRemove(otherEnd, msgs);
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
		case SpecifiedPackage.INTERFACE__REQUIRED_BY:
			return getRequiredBy();
		case SpecifiedPackage.INTERFACE__PROVIDED_BY:
			return getProvidedBy();
		case SpecifiedPackage.INTERFACE__OPERATIONS:
			return getOperations();
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
		case SpecifiedPackage.INTERFACE__REQUIRED_BY:
			getRequiredBy().clear();
			getRequiredBy().addAll((Collection<? extends Component>) newValue);
			return;
		case SpecifiedPackage.INTERFACE__PROVIDED_BY:
			getProvidedBy().clear();
			getProvidedBy().addAll((Collection<? extends Component>) newValue);
			return;
		case SpecifiedPackage.INTERFACE__OPERATIONS:
			getOperations().clear();
			getOperations().addAll((Collection<? extends Operation>) newValue);
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
		case SpecifiedPackage.INTERFACE__REQUIRED_BY:
			getRequiredBy().clear();
			return;
		case SpecifiedPackage.INTERFACE__PROVIDED_BY:
			getProvidedBy().clear();
			return;
		case SpecifiedPackage.INTERFACE__OPERATIONS:
			getOperations().clear();
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
		case SpecifiedPackage.INTERFACE__REQUIRED_BY:
			return requiredBy != null && !requiredBy.isEmpty();
		case SpecifiedPackage.INTERFACE__PROVIDED_BY:
			return providedBy != null && !providedBy.isEmpty();
		case SpecifiedPackage.INTERFACE__OPERATIONS:
			return operations != null && !operations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //InterfaceImpl
