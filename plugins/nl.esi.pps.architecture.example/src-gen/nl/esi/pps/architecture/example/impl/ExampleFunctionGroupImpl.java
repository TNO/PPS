/**
 */
package nl.esi.pps.architecture.example.impl;

import java.util.Collection;

import nl.esi.pps.architecture.example.ExampleFunctionGroup;
import nl.esi.pps.architecture.example.ExamplePackage;

import nl.esi.pps.architecture.impl.NamedArchitectureElementImpl;

import nl.esi.pps.architecture.implemented.Function;

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
 * An implementation of the model object '<em><b>Function Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.architecture.example.impl.ExampleFunctionGroupImpl#getSubGroups <em>Sub Groups</em>}</li>
 *   <li>{@link nl.esi.pps.architecture.example.impl.ExampleFunctionGroupImpl#getParentGroup <em>Parent Group</em>}</li>
 *   <li>{@link nl.esi.pps.architecture.example.impl.ExampleFunctionGroupImpl#getFunctions <em>Functions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExampleFunctionGroupImpl extends NamedArchitectureElementImpl implements ExampleFunctionGroup {
	/**
	 * The cached value of the '{@link #getSubGroups() <em>Sub Groups</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<ExampleFunctionGroup> subGroups;

	/**
	 * The cached value of the '{@link #getFunctions() <em>Functions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctions()
	 * @generated
	 * @ordered
	 */
	protected EList<Function> functions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExampleFunctionGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExamplePackage.Literals.EXAMPLE_FUNCTION_GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ExampleFunctionGroup> getSubGroups() {
		if (subGroups == null) {
			subGroups = new EObjectContainmentWithInverseEList<ExampleFunctionGroup>(ExampleFunctionGroup.class, this,
					ExamplePackage.EXAMPLE_FUNCTION_GROUP__SUB_GROUPS,
					ExamplePackage.EXAMPLE_FUNCTION_GROUP__PARENT_GROUP);
		}
		return subGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExampleFunctionGroup getParentGroup() {
		if (eContainerFeatureID() != ExamplePackage.EXAMPLE_FUNCTION_GROUP__PARENT_GROUP)
			return null;
		return (ExampleFunctionGroup) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentGroup(ExampleFunctionGroup newParentGroup, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newParentGroup, ExamplePackage.EXAMPLE_FUNCTION_GROUP__PARENT_GROUP,
				msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParentGroup(ExampleFunctionGroup newParentGroup) {
		if (newParentGroup != eInternalContainer()
				|| (eContainerFeatureID() != ExamplePackage.EXAMPLE_FUNCTION_GROUP__PARENT_GROUP
						&& newParentGroup != null)) {
			if (EcoreUtil.isAncestor(this, newParentGroup))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentGroup != null)
				msgs = ((InternalEObject) newParentGroup).eInverseAdd(this,
						ExamplePackage.EXAMPLE_FUNCTION_GROUP__SUB_GROUPS, ExampleFunctionGroup.class, msgs);
			msgs = basicSetParentGroup(newParentGroup, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExamplePackage.EXAMPLE_FUNCTION_GROUP__PARENT_GROUP,
					newParentGroup, newParentGroup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Function> getFunctions() {
		if (functions == null) {
			functions = new EObjectContainmentEList<Function>(Function.class, this,
					ExamplePackage.EXAMPLE_FUNCTION_GROUP__FUNCTIONS);
		}
		return functions;
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
		case ExamplePackage.EXAMPLE_FUNCTION_GROUP__SUB_GROUPS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSubGroups()).basicAdd(otherEnd, msgs);
		case ExamplePackage.EXAMPLE_FUNCTION_GROUP__PARENT_GROUP:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetParentGroup((ExampleFunctionGroup) otherEnd, msgs);
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
		case ExamplePackage.EXAMPLE_FUNCTION_GROUP__SUB_GROUPS:
			return ((InternalEList<?>) getSubGroups()).basicRemove(otherEnd, msgs);
		case ExamplePackage.EXAMPLE_FUNCTION_GROUP__PARENT_GROUP:
			return basicSetParentGroup(null, msgs);
		case ExamplePackage.EXAMPLE_FUNCTION_GROUP__FUNCTIONS:
			return ((InternalEList<?>) getFunctions()).basicRemove(otherEnd, msgs);
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
		case ExamplePackage.EXAMPLE_FUNCTION_GROUP__PARENT_GROUP:
			return eInternalContainer().eInverseRemove(this, ExamplePackage.EXAMPLE_FUNCTION_GROUP__SUB_GROUPS,
					ExampleFunctionGroup.class, msgs);
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
		case ExamplePackage.EXAMPLE_FUNCTION_GROUP__SUB_GROUPS:
			return getSubGroups();
		case ExamplePackage.EXAMPLE_FUNCTION_GROUP__PARENT_GROUP:
			return getParentGroup();
		case ExamplePackage.EXAMPLE_FUNCTION_GROUP__FUNCTIONS:
			return getFunctions();
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
		case ExamplePackage.EXAMPLE_FUNCTION_GROUP__SUB_GROUPS:
			getSubGroups().clear();
			getSubGroups().addAll((Collection<? extends ExampleFunctionGroup>) newValue);
			return;
		case ExamplePackage.EXAMPLE_FUNCTION_GROUP__PARENT_GROUP:
			setParentGroup((ExampleFunctionGroup) newValue);
			return;
		case ExamplePackage.EXAMPLE_FUNCTION_GROUP__FUNCTIONS:
			getFunctions().clear();
			getFunctions().addAll((Collection<? extends Function>) newValue);
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
		case ExamplePackage.EXAMPLE_FUNCTION_GROUP__SUB_GROUPS:
			getSubGroups().clear();
			return;
		case ExamplePackage.EXAMPLE_FUNCTION_GROUP__PARENT_GROUP:
			setParentGroup((ExampleFunctionGroup) null);
			return;
		case ExamplePackage.EXAMPLE_FUNCTION_GROUP__FUNCTIONS:
			getFunctions().clear();
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
		case ExamplePackage.EXAMPLE_FUNCTION_GROUP__SUB_GROUPS:
			return subGroups != null && !subGroups.isEmpty();
		case ExamplePackage.EXAMPLE_FUNCTION_GROUP__PARENT_GROUP:
			return getParentGroup() != null;
		case ExamplePackage.EXAMPLE_FUNCTION_GROUP__FUNCTIONS:
			return functions != null && !functions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ExampleFunctionGroupImpl
