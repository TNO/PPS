/**
 */
package nl.esi.pps.tmsc.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import nl.esi.emf.properties.impl.PropertiesContainerImpl;

import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.ITimeRange;
import nl.esi.pps.tmsc.Interval;
import nl.esi.pps.tmsc.ScopedTMSC;
import nl.esi.pps.tmsc.TmscPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interval</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.impl.IntervalImpl#getFrom <em>From</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.IntervalImpl#getTo <em>To</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.IntervalImpl#getTmsc <em>Tmsc</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.IntervalImpl#getScopes <em>Scopes</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.IntervalImpl#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.IntervalImpl#getEndTime <em>End Time</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.IntervalImpl#getDuration <em>Duration</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class IntervalImpl extends PropertiesContainerImpl implements Interval {
	/**
	 * The cached value of the '{@link #getFrom() <em>From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrom()
	 * @generated
	 * @ordered
	 */
	protected Event from;

	/**
	 * The cached value of the '{@link #getTo() <em>To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTo()
	 * @generated
	 * @ordered
	 */
	protected Event to;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntervalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TmscPackage.Literals.INTERVAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Event getFrom() {
		if (from != null && from.eIsProxy()) {
			InternalEObject oldFrom = (InternalEObject) from;
			from = (Event) eResolveProxy(oldFrom);
			if (from != oldFrom) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TmscPackage.INTERVAL__FROM, oldFrom,
							from));
			}
		}
		return from;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event basicGetFrom() {
		return from;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFrom(Event newFrom) {
		Event oldFrom = from;
		from = newFrom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TmscPackage.INTERVAL__FROM, oldFrom, from));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Event getTo() {
		if (to != null && to.eIsProxy()) {
			InternalEObject oldTo = (InternalEObject) to;
			to = (Event) eResolveProxy(oldTo);
			if (to != oldTo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TmscPackage.INTERVAL__TO, oldTo, to));
			}
		}
		return to;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event basicGetTo() {
		return to;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTo(Event newTo) {
		Event oldTo = to;
		to = newTo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TmscPackage.INTERVAL__TO, oldTo, to));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FullScopeTMSC getTmsc() {
		FullScopeTMSC tmsc = basicGetTmsc();
		return tmsc != null && tmsc.eIsProxy() ? (FullScopeTMSC) eResolveProxy((InternalEObject) tmsc) : tmsc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FullScopeTMSC basicGetTmsc() {
		return TmscImplQueries.getTmscImpl(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ScopedTMSC> getScopes() {
		if (scopes == null) {
			scopes = new EObjectResolvingEList<ScopedTMSC>(ScopedTMSC.class, this, TmscPackage.INTERVAL__SCOPES);
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
	public String getName() {
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
	public boolean isEpochTime() {
		return getTmsc().isEpochTime();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case TmscPackage.INTERVAL__FROM:
			if (resolve)
				return getFrom();
			return basicGetFrom();
		case TmscPackage.INTERVAL__TO:
			if (resolve)
				return getTo();
			return basicGetTo();
		case TmscPackage.INTERVAL__TMSC:
			if (resolve)
				return getTmsc();
			return basicGetTmsc();
		case TmscPackage.INTERVAL__SCOPES:
			return getScopes();
		case TmscPackage.INTERVAL__START_TIME:
			return getStartTime();
		case TmscPackage.INTERVAL__END_TIME:
			return getEndTime();
		case TmscPackage.INTERVAL__DURATION:
			return getDuration();
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
		case TmscPackage.INTERVAL__FROM:
			setFrom((Event) newValue);
			return;
		case TmscPackage.INTERVAL__TO:
			setTo((Event) newValue);
			return;
		case TmscPackage.INTERVAL__SCOPES:
			getScopes().clear();
			getScopes().addAll((Collection<? extends ScopedTMSC>) newValue);
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
		case TmscPackage.INTERVAL__FROM:
			setFrom((Event) null);
			return;
		case TmscPackage.INTERVAL__TO:
			setTo((Event) null);
			return;
		case TmscPackage.INTERVAL__SCOPES:
			getScopes().clear();
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
		case TmscPackage.INTERVAL__FROM:
			return from != null;
		case TmscPackage.INTERVAL__TO:
			return to != null;
		case TmscPackage.INTERVAL__TMSC:
			return basicGetTmsc() != null;
		case TmscPackage.INTERVAL__SCOPES:
			return scopes != null && !scopes.isEmpty();
		case TmscPackage.INTERVAL__START_TIME:
			return START_TIME_EDEFAULT == null ? getStartTime() != null : !START_TIME_EDEFAULT.equals(getStartTime());
		case TmscPackage.INTERVAL__END_TIME:
			return END_TIME_EDEFAULT == null ? getEndTime() != null : !END_TIME_EDEFAULT.equals(getEndTime());
		case TmscPackage.INTERVAL__DURATION:
			return DURATION_EDEFAULT == null ? getDuration() != null : !DURATION_EDEFAULT.equals(getDuration());
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
				return TmscPackage.INTERVAL___GET_START_TIME;
			case TmscPackage.ITIME_RANGE___GET_END_TIME:
				return TmscPackage.INTERVAL___GET_END_TIME;
			case TmscPackage.ITIME_RANGE___GET_DURATION:
				return TmscPackage.INTERVAL___GET_DURATION;
			case TmscPackage.ITIME_RANGE___IS_EPOCH_TIME:
				return TmscPackage.INTERVAL___IS_EPOCH_TIME;
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
		case TmscPackage.INTERVAL___GET_NAME:
			return getName();
		case TmscPackage.INTERVAL___IS_EPOCH_TIME:
			return isEpochTime();
		}
		return super.eInvoke(operationID, arguments);
	}

} //IntervalImpl
