/**
 */
package nl.esi.pps.tmsc.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import nl.esi.emf.properties.impl.PropertiesContainerImpl;

import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.ITMSC;
import nl.esi.pps.tmsc.ScopedTMSC;
import nl.esi.pps.tmsc.TMSC;
import nl.esi.pps.tmsc.TmscPackage;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TMSC</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.impl.TMSCImpl#getChildScopes <em>Child Scopes</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.TMSCImpl#getFullScope <em>Full Scope</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class TMSCImpl extends PropertiesContainerImpl implements TMSC {
	/**
	 * The cached value of the '{@link #getChildScopes() <em>Child Scopes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildScopes()
	 * @generated
	 * @ordered
	 */
	protected EList<ScopedTMSC> childScopes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TMSCImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TmscPackage.Literals.TMSC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ScopedTMSC> getChildScopes() {
		if (childScopes == null) {
			childScopes = new EObjectContainmentWithInverseEList<ScopedTMSC>(ScopedTMSC.class, this,
					TmscPackage.TMSC__CHILD_SCOPES, TmscPackage.SCOPED_TMSC__PARENT_SCOPE);
		}
		return childScopes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FullScopeTMSC getFullScope() {
		return TmscImplQueries.getFullScopeImpl(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Event> getEvents() {
		return DerivedUtil.derivedEOperation(TmscImplQueries.getEventsImpl(this));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Dependency> getDependencies() {
		// Subclasses RootTMSC and ScopedTMSC override this method
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Dependency> getIncomingDependencies(final Event event) {
		return DerivedUtil.derivedEOperation(TmscImplQueries.getIncomingDependenciesImpl(this, event));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Dependency> getOutgoingDependencies(final Event event) {
		return DerivedUtil.derivedEOperation(TmscImplQueries.getOutgoingDependenciesImpl(this, event));
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
		case TmscPackage.TMSC__CHILD_SCOPES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getChildScopes()).basicAdd(otherEnd, msgs);
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
		case TmscPackage.TMSC__CHILD_SCOPES:
			return ((InternalEList<?>) getChildScopes()).basicRemove(otherEnd, msgs);
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
		case TmscPackage.TMSC__CHILD_SCOPES:
			return getChildScopes();
		case TmscPackage.TMSC__FULL_SCOPE:
			return getFullScope();
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
		case TmscPackage.TMSC__CHILD_SCOPES:
			getChildScopes().clear();
			getChildScopes().addAll((Collection<? extends ScopedTMSC>) newValue);
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
		case TmscPackage.TMSC__CHILD_SCOPES:
			getChildScopes().clear();
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
		case TmscPackage.TMSC__CHILD_SCOPES:
			return childScopes != null && !childScopes.isEmpty();
		case TmscPackage.TMSC__FULL_SCOPE:
			return getFullScope() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == ITMSC.class) {
			switch (baseOperationID) {
			case TmscPackage.ITMSC___GET_EVENTS:
				return TmscPackage.TMSC___GET_EVENTS;
			case TmscPackage.ITMSC___GET_DEPENDENCIES:
				return TmscPackage.TMSC___GET_DEPENDENCIES;
			case TmscPackage.ITMSC___GET_INCOMING_DEPENDENCIES__EVENT:
				return TmscPackage.TMSC___GET_INCOMING_DEPENDENCIES__EVENT;
			case TmscPackage.ITMSC___GET_OUTGOING_DEPENDENCIES__EVENT:
				return TmscPackage.TMSC___GET_OUTGOING_DEPENDENCIES__EVENT;
			default:
				return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
		case TmscPackage.TMSC___GET_EVENTS:
			return getEvents();
		case TmscPackage.TMSC___GET_DEPENDENCIES:
			return getDependencies();
		case TmscPackage.TMSC___GET_INCOMING_DEPENDENCIES__EVENT:
			return getIncomingDependencies((Event) arguments.get(0));
		case TmscPackage.TMSC___GET_OUTGOING_DEPENDENCIES__EVENT:
			return getOutgoingDependencies((Event) arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //TMSCImpl
