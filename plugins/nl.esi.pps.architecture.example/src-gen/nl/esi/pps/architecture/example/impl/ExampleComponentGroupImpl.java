/**
 */
package nl.esi.pps.architecture.example.impl;

import java.util.Collection;

import nl.esi.pps.architecture.example.ExampleComponentGroup;
import nl.esi.pps.architecture.example.ExamplePackage;

import nl.esi.pps.architecture.impl.NamedArchitectureElementImpl;
import nl.esi.pps.architecture.specified.Component;

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
 * An implementation of the model object '<em><b>Component Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.architecture.example.impl.ExampleComponentGroupImpl#getComponents <em>Components</em>}</li>
 *   <li>{@link nl.esi.pps.architecture.example.impl.ExampleComponentGroupImpl#getSubGroups <em>Sub Groups</em>}</li>
 *   <li>{@link nl.esi.pps.architecture.example.impl.ExampleComponentGroupImpl#getParentGroup <em>Parent Group</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExampleComponentGroupImpl extends NamedArchitectureElementImpl implements ExampleComponentGroup {
	/**
	 * The cached value of the '{@link #getComponents() <em>Components</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponents()
	 * @generated
	 * @ordered
	 */
	protected EList<Component> components;

	/**
	 * The cached value of the '{@link #getSubGroups() <em>Sub Groups</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<ExampleComponentGroup> subGroups;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExampleComponentGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExamplePackage.Literals.EXAMPLE_COMPONENT_GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Component> getComponents() {
		if (components == null) {
			components = new EObjectContainmentEList<Component>(Component.class, this,
					ExamplePackage.EXAMPLE_COMPONENT_GROUP__COMPONENTS);
		}
		return components;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ExampleComponentGroup> getSubGroups() {
		if (subGroups == null) {
			subGroups = new EObjectContainmentWithInverseEList<ExampleComponentGroup>(ExampleComponentGroup.class, this,
					ExamplePackage.EXAMPLE_COMPONENT_GROUP__SUB_GROUPS,
					ExamplePackage.EXAMPLE_COMPONENT_GROUP__PARENT_GROUP);
		}
		return subGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExampleComponentGroup getParentGroup() {
		if (eContainerFeatureID() != ExamplePackage.EXAMPLE_COMPONENT_GROUP__PARENT_GROUP)
			return null;
		return (ExampleComponentGroup) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentGroup(ExampleComponentGroup newParentGroup, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newParentGroup,
				ExamplePackage.EXAMPLE_COMPONENT_GROUP__PARENT_GROUP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParentGroup(ExampleComponentGroup newParentGroup) {
		if (newParentGroup != eInternalContainer()
				|| (eContainerFeatureID() != ExamplePackage.EXAMPLE_COMPONENT_GROUP__PARENT_GROUP
						&& newParentGroup != null)) {
			if (EcoreUtil.isAncestor(this, newParentGroup))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentGroup != null)
				msgs = ((InternalEObject) newParentGroup).eInverseAdd(this,
						ExamplePackage.EXAMPLE_COMPONENT_GROUP__SUB_GROUPS, ExampleComponentGroup.class, msgs);
			msgs = basicSetParentGroup(newParentGroup, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExamplePackage.EXAMPLE_COMPONENT_GROUP__PARENT_GROUP,
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
		case ExamplePackage.EXAMPLE_COMPONENT_GROUP__SUB_GROUPS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSubGroups()).basicAdd(otherEnd, msgs);
		case ExamplePackage.EXAMPLE_COMPONENT_GROUP__PARENT_GROUP:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetParentGroup((ExampleComponentGroup) otherEnd, msgs);
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
		case ExamplePackage.EXAMPLE_COMPONENT_GROUP__COMPONENTS:
			return ((InternalEList<?>) getComponents()).basicRemove(otherEnd, msgs);
		case ExamplePackage.EXAMPLE_COMPONENT_GROUP__SUB_GROUPS:
			return ((InternalEList<?>) getSubGroups()).basicRemove(otherEnd, msgs);
		case ExamplePackage.EXAMPLE_COMPONENT_GROUP__PARENT_GROUP:
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
		case ExamplePackage.EXAMPLE_COMPONENT_GROUP__PARENT_GROUP:
			return eInternalContainer().eInverseRemove(this, ExamplePackage.EXAMPLE_COMPONENT_GROUP__SUB_GROUPS,
					ExampleComponentGroup.class, msgs);
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
		case ExamplePackage.EXAMPLE_COMPONENT_GROUP__COMPONENTS:
			return getComponents();
		case ExamplePackage.EXAMPLE_COMPONENT_GROUP__SUB_GROUPS:
			return getSubGroups();
		case ExamplePackage.EXAMPLE_COMPONENT_GROUP__PARENT_GROUP:
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
		case ExamplePackage.EXAMPLE_COMPONENT_GROUP__COMPONENTS:
			getComponents().clear();
			getComponents().addAll((Collection<? extends Component>) newValue);
			return;
		case ExamplePackage.EXAMPLE_COMPONENT_GROUP__SUB_GROUPS:
			getSubGroups().clear();
			getSubGroups().addAll((Collection<? extends ExampleComponentGroup>) newValue);
			return;
		case ExamplePackage.EXAMPLE_COMPONENT_GROUP__PARENT_GROUP:
			setParentGroup((ExampleComponentGroup) newValue);
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
		case ExamplePackage.EXAMPLE_COMPONENT_GROUP__COMPONENTS:
			getComponents().clear();
			return;
		case ExamplePackage.EXAMPLE_COMPONENT_GROUP__SUB_GROUPS:
			getSubGroups().clear();
			return;
		case ExamplePackage.EXAMPLE_COMPONENT_GROUP__PARENT_GROUP:
			setParentGroup((ExampleComponentGroup) null);
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
		case ExamplePackage.EXAMPLE_COMPONENT_GROUP__COMPONENTS:
			return components != null && !components.isEmpty();
		case ExamplePackage.EXAMPLE_COMPONENT_GROUP__SUB_GROUPS:
			return subGroups != null && !subGroups.isEmpty();
		case ExamplePackage.EXAMPLE_COMPONENT_GROUP__PARENT_GROUP:
			return getParentGroup() != null;
		}
		return super.eIsSet(featureID);
	}

} //ExampleComponentGroupImpl
