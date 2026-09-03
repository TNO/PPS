/**
 */
package nl.esi.pps.architecture.example.impl;

import java.util.Collection;

import nl.esi.pps.architecture.example.ExampleInterfaceGroup;
import nl.esi.pps.architecture.example.ExamplePackage;

import nl.esi.pps.architecture.impl.NamedArchitectureElementImpl;

import nl.esi.pps.architecture.specified.Interface;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interface Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.architecture.example.impl.ExampleInterfaceGroupImpl#getInterfaces <em>Interfaces</em>}</li>
 *   <li>{@link nl.esi.pps.architecture.example.impl.ExampleInterfaceGroupImpl#getSubGroups <em>Sub Groups</em>}</li>
 *   <li>{@link nl.esi.pps.architecture.example.impl.ExampleInterfaceGroupImpl#getParentGroup <em>Parent Group</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExampleInterfaceGroupImpl extends NamedArchitectureElementImpl implements ExampleInterfaceGroup {
	/**
	 * The cached value of the '{@link #getInterfaces() <em>Interfaces</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfaces()
	 * @generated
	 * @ordered
	 */
	protected EList<Interface> interfaces;

	/**
	 * The cached value of the '{@link #getSubGroups() <em>Sub Groups</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<ExampleInterfaceGroup> subGroups;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExampleInterfaceGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExamplePackage.Literals.EXAMPLE_INTERFACE_GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Interface> getInterfaces() {
		if (interfaces == null) {
			interfaces = new EObjectContainmentEList<Interface>(Interface.class, this,
					ExamplePackage.EXAMPLE_INTERFACE_GROUP__INTERFACES);
		}
		return interfaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ExampleInterfaceGroup> getSubGroups() {
		if (subGroups == null) {
			subGroups = new EObjectContainmentWithInverseEList<ExampleInterfaceGroup>(ExampleInterfaceGroup.class, this,
					ExamplePackage.EXAMPLE_INTERFACE_GROUP__SUB_GROUPS,
					ExamplePackage.EXAMPLE_INTERFACE_GROUP__PARENT_GROUP);
		}
		return subGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExampleInterfaceGroup getParentGroup() {
		if (eContainerFeatureID() != ExamplePackage.EXAMPLE_INTERFACE_GROUP__PARENT_GROUP)
			return null;
		return (ExampleInterfaceGroup) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentGroup(ExampleInterfaceGroup newParentGroup, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newParentGroup,
				ExamplePackage.EXAMPLE_INTERFACE_GROUP__PARENT_GROUP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParentGroup(ExampleInterfaceGroup newParentGroup) {
		if (newParentGroup != eInternalContainer()
				|| (eContainerFeatureID() != ExamplePackage.EXAMPLE_INTERFACE_GROUP__PARENT_GROUP
						&& newParentGroup != null)) {
			if (EcoreUtil.isAncestor(this, newParentGroup))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentGroup != null)
				msgs = ((InternalEObject) newParentGroup).eInverseAdd(this,
						ExamplePackage.EXAMPLE_INTERFACE_GROUP__SUB_GROUPS, ExampleInterfaceGroup.class, msgs);
			msgs = basicSetParentGroup(newParentGroup, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExamplePackage.EXAMPLE_INTERFACE_GROUP__PARENT_GROUP,
					newParentGroup, newParentGroup));
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
		case ExamplePackage.EXAMPLE_INTERFACE_GROUP__SUB_GROUPS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSubGroups()).basicAdd(otherEnd, msgs);
		case ExamplePackage.EXAMPLE_INTERFACE_GROUP__PARENT_GROUP:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetParentGroup((ExampleInterfaceGroup) otherEnd, msgs);
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
		case ExamplePackage.EXAMPLE_INTERFACE_GROUP__INTERFACES:
			return ((InternalEList<?>) getInterfaces()).basicRemove(otherEnd, msgs);
		case ExamplePackage.EXAMPLE_INTERFACE_GROUP__SUB_GROUPS:
			return ((InternalEList<?>) getSubGroups()).basicRemove(otherEnd, msgs);
		case ExamplePackage.EXAMPLE_INTERFACE_GROUP__PARENT_GROUP:
			return basicSetParentGroup(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case ExamplePackage.EXAMPLE_INTERFACE_GROUP__PARENT_GROUP:
			return eInternalContainer().eInverseRemove(this, ExamplePackage.EXAMPLE_INTERFACE_GROUP__SUB_GROUPS,
					ExampleInterfaceGroup.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ExamplePackage.EXAMPLE_INTERFACE_GROUP__INTERFACES:
			return getInterfaces();
		case ExamplePackage.EXAMPLE_INTERFACE_GROUP__SUB_GROUPS:
			return getSubGroups();
		case ExamplePackage.EXAMPLE_INTERFACE_GROUP__PARENT_GROUP:
			return getParentGroup();
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
		case ExamplePackage.EXAMPLE_INTERFACE_GROUP__INTERFACES:
			getInterfaces().clear();
			getInterfaces().addAll((Collection<? extends Interface>) newValue);
			return;
		case ExamplePackage.EXAMPLE_INTERFACE_GROUP__SUB_GROUPS:
			getSubGroups().clear();
			getSubGroups().addAll((Collection<? extends ExampleInterfaceGroup>) newValue);
			return;
		case ExamplePackage.EXAMPLE_INTERFACE_GROUP__PARENT_GROUP:
			setParentGroup((ExampleInterfaceGroup) newValue);
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
		case ExamplePackage.EXAMPLE_INTERFACE_GROUP__INTERFACES:
			getInterfaces().clear();
			return;
		case ExamplePackage.EXAMPLE_INTERFACE_GROUP__SUB_GROUPS:
			getSubGroups().clear();
			return;
		case ExamplePackage.EXAMPLE_INTERFACE_GROUP__PARENT_GROUP:
			setParentGroup((ExampleInterfaceGroup) null);
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
		case ExamplePackage.EXAMPLE_INTERFACE_GROUP__INTERFACES:
			return interfaces != null && !interfaces.isEmpty();
		case ExamplePackage.EXAMPLE_INTERFACE_GROUP__SUB_GROUPS:
			return subGroups != null && !subGroups.isEmpty();
		case ExamplePackage.EXAMPLE_INTERFACE_GROUP__PARENT_GROUP:
			return getParentGroup() != null;
		}
		return super.eIsSet(featureID);
	}

} //ExampleInterfaceGroupImpl
