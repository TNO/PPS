/**
 */
package nl.esi.pps.tmsc.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import nl.esi.emf.properties.impl.PropertiesContainerImpl;

import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.ITimeRange;
import nl.esi.pps.tmsc.ScopedTMSC;
import nl.esi.pps.tmsc.TmscPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dependency</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.impl.DependencyImpl#getTmsc <em>Tmsc</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.DependencyImpl#getSource <em>Source</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.DependencyImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.DependencyImpl#getScopes <em>Scopes</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.DependencyImpl#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.DependencyImpl#getEndTime <em>End Time</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.DependencyImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.DependencyImpl#getTimeBound <em>Time Bound</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.DependencyImpl#getScheduled <em>Scheduled</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.DependencyImpl#isProjection <em>Projection</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DependencyImpl extends PropertiesContainerImpl implements Dependency {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected Event source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Event target;

	/**
	 * The cached value of the '{@link #getScopes() <em>Scopes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScopes()
	 * @generated
	 * @ordered
	 */
	protected EList<ScopedTMSC> scopes;

	/**
	 * The default value of the '{@link #getStartTime() <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartTime()
	 * @generated
	 * @ordered
	 */
	protected static final Long START_TIME_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getEndTime() <em>End Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndTime()
	 * @generated
	 * @ordered
	 */
	protected static final Long END_TIME_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected static final Long DURATION_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getTimeBound() <em>Time Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeBound()
	 * @generated
	 * @ordered
	 */
	protected static final Long TIME_BOUND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTimeBound() <em>Time Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeBound()
	 * @generated
	 * @ordered
	 */
	protected Long timeBound = TIME_BOUND_EDEFAULT;

	/**
	 * The default value of the '{@link #getScheduled() <em>Scheduled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScheduled()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean SCHEDULED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getScheduled() <em>Scheduled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScheduled()
	 * @generated
	 * @ordered
	 */
	protected Boolean scheduled = SCHEDULED_EDEFAULT;

	/**
	 * The default value of the '{@link #isProjection() <em>Projection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isProjection()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PROJECTION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isProjection() <em>Projection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isProjection()
	 * @generated
	 * @ordered
	 */
	protected boolean projection = PROJECTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DependencyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TmscPackage.Literals.DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FullScopeTMSC getTmsc() {
		if (eContainerFeatureID() != TmscPackage.DEPENDENCY__TMSC)
			return null;
		return (FullScopeTMSC) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTmsc(FullScopeTMSC newTmsc, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newTmsc, TmscPackage.DEPENDENCY__TMSC, msgs);
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
				|| (eContainerFeatureID() != TmscPackage.DEPENDENCY__TMSC && newTmsc != null)) {
			if (EcoreUtil.isAncestor(this, newTmsc))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTmsc != null)
				msgs = ((InternalEObject) newTmsc).eInverseAdd(this, TmscPackage.FULL_SCOPE_TMSC__DEPENDENCIES,
						FullScopeTMSC.class, msgs);
			msgs = basicSetTmsc(newTmsc, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TmscPackage.DEPENDENCY__TMSC, newTmsc, newTmsc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Event getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(Event newSource, NotificationChain msgs) {
		Event oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					TmscPackage.DEPENDENCY__SOURCE, oldSource, newSource);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSource(Event newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject) source).eInverseRemove(this,
						TmscPackage.EVENT__FULL_SCOPE_OUTGOING_DEPENDENCIES, Event.class, msgs);
			if (newSource != null)
				msgs = ((InternalEObject) newSource).eInverseAdd(this,
						TmscPackage.EVENT__FULL_SCOPE_OUTGOING_DEPENDENCIES, Event.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TmscPackage.DEPENDENCY__SOURCE, newSource,
					newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Event getTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(Event newTarget, NotificationChain msgs) {
		Event oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					TmscPackage.DEPENDENCY__TARGET, oldTarget, newTarget);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTarget(Event newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject) target).eInverseRemove(this,
						TmscPackage.EVENT__FULL_SCOPE_INCOMING_DEPENDENCIES, Event.class, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject) newTarget).eInverseAdd(this,
						TmscPackage.EVENT__FULL_SCOPE_INCOMING_DEPENDENCIES, Event.class, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TmscPackage.DEPENDENCY__TARGET, newTarget,
					newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ScopedTMSC> getScopes() {
		if (scopes == null) {
			scopes = new EObjectWithInverseEList.ManyInverse<ScopedTMSC>(ScopedTMSC.class, this,
					TmscPackage.DEPENDENCY__SCOPES, TmscPackage.SCOPED_TMSC__DEPENDENCIES);
		}
		return scopes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Long getStartTime() {
		return TmscImplQueries.getStartTimeImpl(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Long getEndTime() {
		return TmscImplQueries.getEndTimeImpl(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Long getDuration() {
		final Long startTime = getStartTime();
		if (startTime == null) {
			return null;
		}
		final Long endTime = getEndTime();
		if (endTime == null) {
			return null;
		}
		return endTime - startTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Long getTimeBound() {
		return timeBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTimeBound(Long newTimeBound) {
		Long oldTimeBound = timeBound;
		timeBound = newTimeBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TmscPackage.DEPENDENCY__TIME_BOUND, oldTimeBound,
					timeBound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Boolean getScheduled() {
		return scheduled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScheduled(Boolean newScheduled) {
		Boolean oldScheduled = scheduled;
		scheduled = newScheduled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TmscPackage.DEPENDENCY__SCHEDULED, oldScheduled,
					scheduled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isProjection() {
		return projection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProjection(boolean newProjection) {
		boolean oldProjection = projection;
		projection = newProjection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TmscPackage.DEPENDENCY__PROJECTION, oldProjection,
					projection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isEpochTime() {
		return getTmsc().isEpochTime();
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
		case TmscPackage.DEPENDENCY__TMSC:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetTmsc((FullScopeTMSC) otherEnd, msgs);
		case TmscPackage.DEPENDENCY__SOURCE:
			if (source != null)
				msgs = ((InternalEObject) source).eInverseRemove(this,
						TmscPackage.EVENT__FULL_SCOPE_OUTGOING_DEPENDENCIES, Event.class, msgs);
			return basicSetSource((Event) otherEnd, msgs);
		case TmscPackage.DEPENDENCY__TARGET:
			if (target != null)
				msgs = ((InternalEObject) target).eInverseRemove(this,
						TmscPackage.EVENT__FULL_SCOPE_INCOMING_DEPENDENCIES, Event.class, msgs);
			return basicSetTarget((Event) otherEnd, msgs);
		case TmscPackage.DEPENDENCY__SCOPES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getScopes()).basicAdd(otherEnd, msgs);
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
		case TmscPackage.DEPENDENCY__TMSC:
			return basicSetTmsc(null, msgs);
		case TmscPackage.DEPENDENCY__SOURCE:
			return basicSetSource(null, msgs);
		case TmscPackage.DEPENDENCY__TARGET:
			return basicSetTarget(null, msgs);
		case TmscPackage.DEPENDENCY__SCOPES:
			return ((InternalEList<?>) getScopes()).basicRemove(otherEnd, msgs);
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
		case TmscPackage.DEPENDENCY__TMSC:
			return eInternalContainer().eInverseRemove(this, TmscPackage.FULL_SCOPE_TMSC__DEPENDENCIES,
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
		case TmscPackage.DEPENDENCY__TMSC:
			return getTmsc();
		case TmscPackage.DEPENDENCY__SOURCE:
			return getSource();
		case TmscPackage.DEPENDENCY__TARGET:
			return getTarget();
		case TmscPackage.DEPENDENCY__SCOPES:
			return getScopes();
		case TmscPackage.DEPENDENCY__START_TIME:
			return getStartTime();
		case TmscPackage.DEPENDENCY__END_TIME:
			return getEndTime();
		case TmscPackage.DEPENDENCY__DURATION:
			return getDuration();
		case TmscPackage.DEPENDENCY__TIME_BOUND:
			return getTimeBound();
		case TmscPackage.DEPENDENCY__SCHEDULED:
			return getScheduled();
		case TmscPackage.DEPENDENCY__PROJECTION:
			return isProjection();
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
		case TmscPackage.DEPENDENCY__TMSC:
			setTmsc((FullScopeTMSC) newValue);
			return;
		case TmscPackage.DEPENDENCY__SOURCE:
			setSource((Event) newValue);
			return;
		case TmscPackage.DEPENDENCY__TARGET:
			setTarget((Event) newValue);
			return;
		case TmscPackage.DEPENDENCY__SCOPES:
			getScopes().clear();
			getScopes().addAll((Collection<? extends ScopedTMSC>) newValue);
			return;
		case TmscPackage.DEPENDENCY__TIME_BOUND:
			setTimeBound((Long) newValue);
			return;
		case TmscPackage.DEPENDENCY__SCHEDULED:
			setScheduled((Boolean) newValue);
			return;
		case TmscPackage.DEPENDENCY__PROJECTION:
			setProjection((Boolean) newValue);
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
		case TmscPackage.DEPENDENCY__TMSC:
			setTmsc((FullScopeTMSC) null);
			return;
		case TmscPackage.DEPENDENCY__SOURCE:
			setSource((Event) null);
			return;
		case TmscPackage.DEPENDENCY__TARGET:
			setTarget((Event) null);
			return;
		case TmscPackage.DEPENDENCY__SCOPES:
			getScopes().clear();
			return;
		case TmscPackage.DEPENDENCY__TIME_BOUND:
			setTimeBound(TIME_BOUND_EDEFAULT);
			return;
		case TmscPackage.DEPENDENCY__SCHEDULED:
			setScheduled(SCHEDULED_EDEFAULT);
			return;
		case TmscPackage.DEPENDENCY__PROJECTION:
			setProjection(PROJECTION_EDEFAULT);
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
		case TmscPackage.DEPENDENCY__TMSC:
			return getTmsc() != null;
		case TmscPackage.DEPENDENCY__SOURCE:
			return source != null;
		case TmscPackage.DEPENDENCY__TARGET:
			return target != null;
		case TmscPackage.DEPENDENCY__SCOPES:
			return scopes != null && !scopes.isEmpty();
		case TmscPackage.DEPENDENCY__START_TIME:
			return START_TIME_EDEFAULT == null ? getStartTime() != null : !START_TIME_EDEFAULT.equals(getStartTime());
		case TmscPackage.DEPENDENCY__END_TIME:
			return END_TIME_EDEFAULT == null ? getEndTime() != null : !END_TIME_EDEFAULT.equals(getEndTime());
		case TmscPackage.DEPENDENCY__DURATION:
			return DURATION_EDEFAULT == null ? getDuration() != null : !DURATION_EDEFAULT.equals(getDuration());
		case TmscPackage.DEPENDENCY__TIME_BOUND:
			return TIME_BOUND_EDEFAULT == null ? timeBound != null : !TIME_BOUND_EDEFAULT.equals(timeBound);
		case TmscPackage.DEPENDENCY__SCHEDULED:
			return SCHEDULED_EDEFAULT == null ? scheduled != null : !SCHEDULED_EDEFAULT.equals(scheduled);
		case TmscPackage.DEPENDENCY__PROJECTION:
			return projection != PROJECTION_EDEFAULT;
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
		if (baseClass == ITimeRange.class) {
			switch (baseOperationID) {
			case TmscPackage.ITIME_RANGE___GET_START_TIME:
				return TmscPackage.DEPENDENCY___GET_START_TIME;
			case TmscPackage.ITIME_RANGE___GET_END_TIME:
				return TmscPackage.DEPENDENCY___GET_END_TIME;
			case TmscPackage.ITIME_RANGE___GET_DURATION:
				return TmscPackage.DEPENDENCY___GET_DURATION;
			case TmscPackage.ITIME_RANGE___IS_EPOCH_TIME:
				return TmscPackage.DEPENDENCY___IS_EPOCH_TIME;
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
		case TmscPackage.DEPENDENCY___IS_EPOCH_TIME:
			return isEpochTime();
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
		result.append(" (timeBound: ");
		result.append(timeBound);
		result.append(", scheduled: ");
		result.append(scheduled);
		result.append(", projection: ");
		result.append(projection);
		result.append(')');
		return result.toString();
	}

} //DependencyImpl
