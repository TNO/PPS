/**
 */
package nl.esi.pps.tmsc.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import nl.esi.emf.properties.impl.PropertiesContainerImpl;

import nl.esi.pps.architecture.implemented.Function;
import nl.esi.pps.architecture.implemented.FunctionParameter;

import nl.esi.pps.architecture.specified.Component;

import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.Lifeline;
import nl.esi.pps.tmsc.ScopedTMSC;
import nl.esi.pps.tmsc.TmscPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.impl.EventImpl#getLifeline <em>Lifeline</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.EventImpl#getArguments <em>Arguments</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.EventImpl#getFullScopeIncomingDependencies <em>Full Scope Incoming Dependencies</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.EventImpl#getFullScopeOutgoingDependencies <em>Full Scope Outgoing Dependencies</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.EventImpl#getTmsc <em>Tmsc</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.EventImpl#getScopes <em>Scopes</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.EventImpl#getComponent <em>Component</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.EventImpl#getFunction <em>Function</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.EventImpl#getTimestamp <em>Timestamp</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.EventImpl#isTraced <em>Traced</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class EventImpl extends PropertiesContainerImpl implements Event {
	/**
	 * The cached value of the '{@link #getArguments() <em>Arguments</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArguments()
	 * @generated
	 * @ordered
	 */
	protected EMap<FunctionParameter, String> arguments;

	/**
	 * The cached value of the '{@link #getFullScopeIncomingDependencies() <em>Full Scope Incoming Dependencies</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFullScopeIncomingDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<Dependency> fullScopeIncomingDependencies;

	/**
	 * The cached value of the '{@link #getFullScopeOutgoingDependencies() <em>Full Scope Outgoing Dependencies</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFullScopeOutgoingDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<Dependency> fullScopeOutgoingDependencies;

	/**
	 * The cached value of the '{@link #getComponent() <em>Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponent()
	 * @generated
	 * @ordered
	 */
	protected Component component;

	/**
	 * The cached value of the '{@link #getFunction() <em>Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunction()
	 * @generated
	 * @ordered
	 */
	protected Function function;

	/**
	 * The default value of the '{@link #getTimestamp() <em>Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimestamp()
	 * @generated
	 * @ordered
	 */
	protected static final Long TIMESTAMP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTimestamp() <em>Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimestamp()
	 * @generated
	 * @ordered
	 */
	protected Long timestamp = TIMESTAMP_EDEFAULT;

	/**
	 * The default value of the '{@link #isTraced() <em>Traced</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTraced()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TRACED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isTraced() <em>Traced</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTraced()
	 * @generated
	 * @ordered
	 */
	protected boolean traced = TRACED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TmscPackage.Literals.EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Lifeline getLifeline() {
		if (eContainerFeatureID() != TmscPackage.EVENT__LIFELINE)
			return null;
		return (Lifeline) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLifeline(Lifeline newLifeline, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newLifeline, TmscPackage.EVENT__LIFELINE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLifeline(Lifeline newLifeline) {
		if (newLifeline != eInternalContainer()
				|| (eContainerFeatureID() != TmscPackage.EVENT__LIFELINE && newLifeline != null)) {
			if (EcoreUtil.isAncestor(this, newLifeline))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newLifeline != null)
				msgs = ((InternalEObject) newLifeline).eInverseAdd(this, TmscPackage.LIFELINE__EVENTS, Lifeline.class,
						msgs);
			msgs = basicSetLifeline(newLifeline, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TmscPackage.EVENT__LIFELINE, newLifeline,
					newLifeline));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EMap<FunctionParameter, String> getArguments() {
		if (arguments == null) {
			arguments = new EcoreEMap<FunctionParameter, String>(TmscPackage.Literals.FUNCTION_ARGUMENT_MAP_ENTRY,
					FunctionArgumentMapEntryImpl.class, this, TmscPackage.EVENT__ARGUMENTS);
		}
		return arguments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Dependency> getFullScopeIncomingDependencies() {
		if (fullScopeIncomingDependencies == null) {
			fullScopeIncomingDependencies = new EObjectWithInverseEList<Dependency>(Dependency.class, this,
					TmscPackage.EVENT__FULL_SCOPE_INCOMING_DEPENDENCIES, TmscPackage.DEPENDENCY__TARGET);
		}
		return fullScopeIncomingDependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Dependency> getFullScopeOutgoingDependencies() {
		if (fullScopeOutgoingDependencies == null) {
			fullScopeOutgoingDependencies = new EObjectWithInverseEList<Dependency>(Dependency.class, this,
					TmscPackage.EVENT__FULL_SCOPE_OUTGOING_DEPENDENCIES, TmscPackage.DEPENDENCY__SOURCE);
		}
		return fullScopeOutgoingDependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FullScopeTMSC getTmsc() {
		return TmscImplQueries.getTmscImpl(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ScopedTMSC> getScopes() {
		return DerivedUtil.derivedEReference(this, TmscPackage.EVENT__SCOPES, TmscImplQueries::getScopesImpl);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Component getComponent() {
		if (component != null && component.eIsProxy()) {
			InternalEObject oldComponent = (InternalEObject) component;
			component = (Component) eResolveProxy(oldComponent);
			if (component != oldComponent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TmscPackage.EVENT__COMPONENT,
							oldComponent, component));
			}
		}
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component basicGetComponent() {
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setComponent(Component newComponent) {
		Component oldComponent = component;
		component = newComponent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TmscPackage.EVENT__COMPONENT, oldComponent,
					component));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Function getFunction() {
		if (function != null && function.eIsProxy()) {
			InternalEObject oldFunction = (InternalEObject) function;
			function = (Function) eResolveProxy(oldFunction);
			if (function != oldFunction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TmscPackage.EVENT__FUNCTION, oldFunction,
							function));
			}
		}
		return function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function basicGetFunction() {
		return function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFunction(Function newFunction) {
		Function oldFunction = function;
		function = newFunction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TmscPackage.EVENT__FUNCTION, oldFunction, function));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Long getTimestamp() {
		return timestamp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTimestamp(Long newTimestamp) {
		Long oldTimestamp = timestamp;
		timestamp = newTimestamp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TmscPackage.EVENT__TIMESTAMP, oldTimestamp,
					timestamp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isTraced() {
		return traced;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTraced(boolean newTraced) {
		boolean oldTraced = traced;
		traced = newTraced;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TmscPackage.EVENT__TRACED, oldTraced, traced));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Execution getExecution() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExecution(Execution Execution) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
		case TmscPackage.EVENT__LIFELINE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetLifeline((Lifeline) otherEnd, msgs);
		case TmscPackage.EVENT__FULL_SCOPE_INCOMING_DEPENDENCIES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getFullScopeIncomingDependencies())
					.basicAdd(otherEnd, msgs);
		case TmscPackage.EVENT__FULL_SCOPE_OUTGOING_DEPENDENCIES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getFullScopeOutgoingDependencies())
					.basicAdd(otherEnd, msgs);
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
		case TmscPackage.EVENT__LIFELINE:
			return basicSetLifeline(null, msgs);
		case TmscPackage.EVENT__ARGUMENTS:
			return ((InternalEList<?>) getArguments()).basicRemove(otherEnd, msgs);
		case TmscPackage.EVENT__FULL_SCOPE_INCOMING_DEPENDENCIES:
			return ((InternalEList<?>) getFullScopeIncomingDependencies()).basicRemove(otherEnd, msgs);
		case TmscPackage.EVENT__FULL_SCOPE_OUTGOING_DEPENDENCIES:
			return ((InternalEList<?>) getFullScopeOutgoingDependencies()).basicRemove(otherEnd, msgs);
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
		case TmscPackage.EVENT__LIFELINE:
			return eInternalContainer().eInverseRemove(this, TmscPackage.LIFELINE__EVENTS, Lifeline.class, msgs);
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
		case TmscPackage.EVENT__LIFELINE:
			return getLifeline();
		case TmscPackage.EVENT__ARGUMENTS:
			if (coreType)
				return getArguments();
			else
				return getArguments().map();
		case TmscPackage.EVENT__FULL_SCOPE_INCOMING_DEPENDENCIES:
			return getFullScopeIncomingDependencies();
		case TmscPackage.EVENT__FULL_SCOPE_OUTGOING_DEPENDENCIES:
			return getFullScopeOutgoingDependencies();
		case TmscPackage.EVENT__TMSC:
			return getTmsc();
		case TmscPackage.EVENT__SCOPES:
			return getScopes();
		case TmscPackage.EVENT__COMPONENT:
			if (resolve)
				return getComponent();
			return basicGetComponent();
		case TmscPackage.EVENT__FUNCTION:
			if (resolve)
				return getFunction();
			return basicGetFunction();
		case TmscPackage.EVENT__TIMESTAMP:
			return getTimestamp();
		case TmscPackage.EVENT__TRACED:
			return isTraced();
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
		case TmscPackage.EVENT__LIFELINE:
			setLifeline((Lifeline) newValue);
			return;
		case TmscPackage.EVENT__ARGUMENTS:
			((EStructuralFeature.Setting) getArguments()).set(newValue);
			return;
		case TmscPackage.EVENT__FULL_SCOPE_INCOMING_DEPENDENCIES:
			getFullScopeIncomingDependencies().clear();
			getFullScopeIncomingDependencies().addAll((Collection<? extends Dependency>) newValue);
			return;
		case TmscPackage.EVENT__FULL_SCOPE_OUTGOING_DEPENDENCIES:
			getFullScopeOutgoingDependencies().clear();
			getFullScopeOutgoingDependencies().addAll((Collection<? extends Dependency>) newValue);
			return;
		case TmscPackage.EVENT__COMPONENT:
			setComponent((Component) newValue);
			return;
		case TmscPackage.EVENT__FUNCTION:
			setFunction((Function) newValue);
			return;
		case TmscPackage.EVENT__TIMESTAMP:
			setTimestamp((Long) newValue);
			return;
		case TmscPackage.EVENT__TRACED:
			setTraced((Boolean) newValue);
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
		case TmscPackage.EVENT__LIFELINE:
			setLifeline((Lifeline) null);
			return;
		case TmscPackage.EVENT__ARGUMENTS:
			getArguments().clear();
			return;
		case TmscPackage.EVENT__FULL_SCOPE_INCOMING_DEPENDENCIES:
			getFullScopeIncomingDependencies().clear();
			return;
		case TmscPackage.EVENT__FULL_SCOPE_OUTGOING_DEPENDENCIES:
			getFullScopeOutgoingDependencies().clear();
			return;
		case TmscPackage.EVENT__COMPONENT:
			setComponent((Component) null);
			return;
		case TmscPackage.EVENT__FUNCTION:
			setFunction((Function) null);
			return;
		case TmscPackage.EVENT__TIMESTAMP:
			setTimestamp(TIMESTAMP_EDEFAULT);
			return;
		case TmscPackage.EVENT__TRACED:
			setTraced(TRACED_EDEFAULT);
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
		case TmscPackage.EVENT__LIFELINE:
			return getLifeline() != null;
		case TmscPackage.EVENT__ARGUMENTS:
			return arguments != null && !arguments.isEmpty();
		case TmscPackage.EVENT__FULL_SCOPE_INCOMING_DEPENDENCIES:
			return fullScopeIncomingDependencies != null && !fullScopeIncomingDependencies.isEmpty();
		case TmscPackage.EVENT__FULL_SCOPE_OUTGOING_DEPENDENCIES:
			return fullScopeOutgoingDependencies != null && !fullScopeOutgoingDependencies.isEmpty();
		case TmscPackage.EVENT__TMSC:
			return getTmsc() != null;
		case TmscPackage.EVENT__SCOPES:
			return !getScopes().isEmpty();
		case TmscPackage.EVENT__COMPONENT:
			return component != null;
		case TmscPackage.EVENT__FUNCTION:
			return function != null;
		case TmscPackage.EVENT__TIMESTAMP:
			return TIMESTAMP_EDEFAULT == null ? timestamp != null : !TIMESTAMP_EDEFAULT.equals(timestamp);
		case TmscPackage.EVENT__TRACED:
			return traced != TRACED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
		case TmscPackage.EVENT___GET_EXECUTION:
			return getExecution();
		case TmscPackage.EVENT___SET_EXECUTION__EXECUTION:
			setExecution((Execution) arguments.get(0));
			return null;
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (timestamp: ");
		result.append(timestamp);
		result.append(", traced: ");
		result.append(traced);
		result.append(')');
		return result.toString();
	}

} //EventImpl
