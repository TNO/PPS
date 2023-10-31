/**
 */
package nl.esi.pps.tmsc.impl;

import java.util.Collection;

import nl.esi.emf.properties.impl.PropertiesContainerImpl;

import nl.esi.pps.architecture.instantiated.Executor;

import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.Lifeline;
import nl.esi.pps.tmsc.LifelineSegment;
import nl.esi.pps.tmsc.TmscPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lifeline</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.impl.LifelineImpl#getTmsc <em>Tmsc</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.LifelineImpl#getEvents <em>Events</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.LifelineImpl#getExecutions <em>Executions</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.LifelineImpl#getRootExecutions <em>Root Executions</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.LifelineImpl#getSegments <em>Segments</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.LifelineImpl#getExecutor <em>Executor</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.LifelineImpl#isTraced <em>Traced</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LifelineImpl extends PropertiesContainerImpl implements Lifeline {
	/**
	 * The cached value of the '{@link #getEvents() <em>Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<Event> events;

	/**
	 * The cached value of the '{@link #getExecutions() <em>Executions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutions()
	 * @generated
	 * @ordered
	 */
	protected EList<Execution> executions;

	/**
	 * The cached value of the '{@link #getExecutor() <em>Executor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutor()
	 * @generated
	 * @ordered
	 */
	protected Executor executor;

	/**
	 * The default value of the '{@link #isTraced() <em>Traced</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTraced()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TRACED_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LifelineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TmscPackage.Literals.LIFELINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FullScopeTMSC getTmsc() {
		if (eContainerFeatureID() != TmscPackage.LIFELINE__TMSC)
			return null;
		return (FullScopeTMSC) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTmsc(FullScopeTMSC newTmsc, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newTmsc, TmscPackage.LIFELINE__TMSC, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTmsc(FullScopeTMSC newTmsc) {
		if (newTmsc != eInternalContainer()
				|| (eContainerFeatureID() != TmscPackage.LIFELINE__TMSC && newTmsc != null)) {
			if (EcoreUtil.isAncestor(this, newTmsc))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTmsc != null)
				msgs = ((InternalEObject) newTmsc).eInverseAdd(this, TmscPackage.FULL_SCOPE_TMSC__LIFELINES,
						FullScopeTMSC.class, msgs);
			msgs = basicSetTmsc(newTmsc, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TmscPackage.LIFELINE__TMSC, newTmsc, newTmsc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Event> getEvents() {
		if (events == null) {
			events = new EObjectContainmentWithInverseEList<Event>(Event.class, this, TmscPackage.LIFELINE__EVENTS,
					TmscPackage.EVENT__LIFELINE);
		}
		return events;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Execution> getExecutions() {
		if (executions == null) {
			executions = new EObjectContainmentWithInverseEList<Execution>(Execution.class, this,
					TmscPackage.LIFELINE__EXECUTIONS, TmscPackage.EXECUTION__LIFELINE);
		}
		return executions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Execution> getRootExecutions() {
		return DerivedUtil.derivedEReference(this, TmscPackage.LIFELINE__ROOT_EXECUTIONS,
				TmscImplQueries.getRootExecutionsImpl(this));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<LifelineSegment> getSegments() {
		return DerivedUtil.derivedEReference(this, TmscPackage.LIFELINE__SEGMENTS, TmscImplQueries::getSegmentsImpl);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Executor getExecutor() {
		if (executor != null && executor.eIsProxy()) {
			InternalEObject oldExecutor = (InternalEObject) executor;
			executor = (Executor) eResolveProxy(oldExecutor);
			if (executor != oldExecutor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TmscPackage.LIFELINE__EXECUTOR,
							oldExecutor, executor));
			}
		}
		return executor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Executor basicGetExecutor() {
		return executor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExecutor(Executor newExecutor) {
		Executor oldExecutor = executor;
		executor = newExecutor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TmscPackage.LIFELINE__EXECUTOR, oldExecutor,
					executor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isTraced() {
		return TmscImplQueries.isTracedImpl(this);
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
		case TmscPackage.LIFELINE__TMSC:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetTmsc((FullScopeTMSC) otherEnd, msgs);
		case TmscPackage.LIFELINE__EVENTS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getEvents()).basicAdd(otherEnd, msgs);
		case TmscPackage.LIFELINE__EXECUTIONS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getExecutions()).basicAdd(otherEnd, msgs);
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
		case TmscPackage.LIFELINE__TMSC:
			return basicSetTmsc(null, msgs);
		case TmscPackage.LIFELINE__EVENTS:
			return ((InternalEList<?>) getEvents()).basicRemove(otherEnd, msgs);
		case TmscPackage.LIFELINE__EXECUTIONS:
			return ((InternalEList<?>) getExecutions()).basicRemove(otherEnd, msgs);
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
		case TmscPackage.LIFELINE__TMSC:
			return eInternalContainer().eInverseRemove(this, TmscPackage.FULL_SCOPE_TMSC__LIFELINES,
					FullScopeTMSC.class, msgs);
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
		case TmscPackage.LIFELINE__TMSC:
			return getTmsc();
		case TmscPackage.LIFELINE__EVENTS:
			return getEvents();
		case TmscPackage.LIFELINE__EXECUTIONS:
			return getExecutions();
		case TmscPackage.LIFELINE__ROOT_EXECUTIONS:
			return getRootExecutions();
		case TmscPackage.LIFELINE__SEGMENTS:
			return getSegments();
		case TmscPackage.LIFELINE__EXECUTOR:
			if (resolve)
				return getExecutor();
			return basicGetExecutor();
		case TmscPackage.LIFELINE__TRACED:
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
		case TmscPackage.LIFELINE__TMSC:
			setTmsc((FullScopeTMSC) newValue);
			return;
		case TmscPackage.LIFELINE__EVENTS:
			getEvents().clear();
			getEvents().addAll((Collection<? extends Event>) newValue);
			return;
		case TmscPackage.LIFELINE__EXECUTIONS:
			getExecutions().clear();
			getExecutions().addAll((Collection<? extends Execution>) newValue);
			return;
		case TmscPackage.LIFELINE__EXECUTOR:
			setExecutor((Executor) newValue);
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
		case TmscPackage.LIFELINE__TMSC:
			setTmsc((FullScopeTMSC) null);
			return;
		case TmscPackage.LIFELINE__EVENTS:
			getEvents().clear();
			return;
		case TmscPackage.LIFELINE__EXECUTIONS:
			getExecutions().clear();
			return;
		case TmscPackage.LIFELINE__EXECUTOR:
			setExecutor((Executor) null);
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
		case TmscPackage.LIFELINE__TMSC:
			return getTmsc() != null;
		case TmscPackage.LIFELINE__EVENTS:
			return events != null && !events.isEmpty();
		case TmscPackage.LIFELINE__EXECUTIONS:
			return executions != null && !executions.isEmpty();
		case TmscPackage.LIFELINE__ROOT_EXECUTIONS:
			return !getRootExecutions().isEmpty();
		case TmscPackage.LIFELINE__SEGMENTS:
			return !getSegments().isEmpty();
		case TmscPackage.LIFELINE__EXECUTOR:
			return executor != null;
		case TmscPackage.LIFELINE__TRACED:
			return isTraced() != TRACED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //LifelineImpl
