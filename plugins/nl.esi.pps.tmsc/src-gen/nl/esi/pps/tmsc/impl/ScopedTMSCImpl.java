/**
 */
package nl.esi.pps.tmsc.impl;

import java.util.Collection;

import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.ScopedTMSC;
import nl.esi.pps.tmsc.TMSC;
import nl.esi.pps.tmsc.TmscPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scoped TMSC</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.impl.ScopedTMSCImpl#getParentScope <em>Parent Scope</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.ScopedTMSCImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.ScopedTMSCImpl#getOrigin <em>Origin</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.ScopedTMSCImpl#getFqn <em>Fqn</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.ScopedTMSCImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ScopedTMSCImpl extends TMSCImpl implements ScopedTMSC {
	/**
	 * The cached value of the '{@link #getDependencies() <em>Dependencies</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<Dependency> dependencies;

	/**
	 * The cached value of the '{@link #getOrigin() <em>Origin</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrigin()
	 * @generated
	 * @ordered
	 */
	protected EList<Event> origin;

	/**
	 * The default value of the '{@link #getFqn() <em>Fqn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFqn()
	 * @generated
	 * @ordered
	 */
	protected static final String FQN_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScopedTMSCImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TmscPackage.Literals.SCOPED_TMSC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TMSC getParentScope() {
		if (eContainerFeatureID() != TmscPackage.SCOPED_TMSC__PARENT_SCOPE)
			return null;
		return (TMSC) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentScope(TMSC newParentScope, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newParentScope, TmscPackage.SCOPED_TMSC__PARENT_SCOPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParentScope(TMSC newParentScope) {
		if (newParentScope != eInternalContainer()
				|| (eContainerFeatureID() != TmscPackage.SCOPED_TMSC__PARENT_SCOPE && newParentScope != null)) {
			if (EcoreUtil.isAncestor(this, newParentScope))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentScope != null)
				msgs = ((InternalEObject) newParentScope).eInverseAdd(this, TmscPackage.TMSC__CHILD_SCOPES, TMSC.class,
						msgs);
			msgs = basicSetParentScope(newParentScope, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TmscPackage.SCOPED_TMSC__PARENT_SCOPE, newParentScope,
					newParentScope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Dependency> getDependencies() {
		if (dependencies == null) {
			dependencies = new EObjectWithInverseEList.ManyInverse<Dependency>(Dependency.class, this,
					TmscPackage.SCOPED_TMSC__DEPENDENCIES, TmscPackage.DEPENDENCY__SCOPES);
		}
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Event> getOrigin() {
		if (origin == null) {
			origin = new EObjectResolvingEList<Event>(Event.class, this, TmscPackage.SCOPED_TMSC__ORIGIN);
		}
		return origin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFqn() {
		return TmscImplQueries.getFqnImpl(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TmscPackage.SCOPED_TMSC__NAME, oldName, name));
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
		case TmscPackage.SCOPED_TMSC__PARENT_SCOPE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetParentScope((TMSC) otherEnd, msgs);
		case TmscPackage.SCOPED_TMSC__DEPENDENCIES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getDependencies()).basicAdd(otherEnd, msgs);
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
		case TmscPackage.SCOPED_TMSC__PARENT_SCOPE:
			return basicSetParentScope(null, msgs);
		case TmscPackage.SCOPED_TMSC__DEPENDENCIES:
			return ((InternalEList<?>) getDependencies()).basicRemove(otherEnd, msgs);
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
		case TmscPackage.SCOPED_TMSC__PARENT_SCOPE:
			return eInternalContainer().eInverseRemove(this, TmscPackage.TMSC__CHILD_SCOPES, TMSC.class, msgs);
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
		case TmscPackage.SCOPED_TMSC__PARENT_SCOPE:
			return getParentScope();
		case TmscPackage.SCOPED_TMSC__DEPENDENCIES:
			return getDependencies();
		case TmscPackage.SCOPED_TMSC__ORIGIN:
			return getOrigin();
		case TmscPackage.SCOPED_TMSC__FQN:
			return getFqn();
		case TmscPackage.SCOPED_TMSC__NAME:
			return getName();
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
		case TmscPackage.SCOPED_TMSC__PARENT_SCOPE:
			setParentScope((TMSC) newValue);
			return;
		case TmscPackage.SCOPED_TMSC__DEPENDENCIES:
			getDependencies().clear();
			getDependencies().addAll((Collection<? extends Dependency>) newValue);
			return;
		case TmscPackage.SCOPED_TMSC__ORIGIN:
			getOrigin().clear();
			getOrigin().addAll((Collection<? extends Event>) newValue);
			return;
		case TmscPackage.SCOPED_TMSC__NAME:
			setName((String) newValue);
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
		case TmscPackage.SCOPED_TMSC__PARENT_SCOPE:
			setParentScope((TMSC) null);
			return;
		case TmscPackage.SCOPED_TMSC__DEPENDENCIES:
			getDependencies().clear();
			return;
		case TmscPackage.SCOPED_TMSC__ORIGIN:
			getOrigin().clear();
			return;
		case TmscPackage.SCOPED_TMSC__NAME:
			setName(NAME_EDEFAULT);
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
		case TmscPackage.SCOPED_TMSC__PARENT_SCOPE:
			return getParentScope() != null;
		case TmscPackage.SCOPED_TMSC__DEPENDENCIES:
			return dependencies != null && !dependencies.isEmpty();
		case TmscPackage.SCOPED_TMSC__ORIGIN:
			return origin != null && !origin.isEmpty();
		case TmscPackage.SCOPED_TMSC__FQN:
			return FQN_EDEFAULT == null ? getFqn() != null : !FQN_EDEFAULT.equals(getFqn());
		case TmscPackage.SCOPED_TMSC__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ScopedTMSCImpl
