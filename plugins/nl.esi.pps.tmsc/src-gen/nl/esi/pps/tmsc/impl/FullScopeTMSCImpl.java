/**
 */
package nl.esi.pps.tmsc.impl;

import java.util.Collection;

import nl.esi.pps.architecture.ArchitectureModel;

import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.Lifeline;
import nl.esi.pps.tmsc.Measurement;
import nl.esi.pps.tmsc.TmscPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Full Scope TMSC</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.impl.FullScopeTMSCImpl#getMeasurements <em>Measurements</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.FullScopeTMSCImpl#getLifelines <em>Lifelines</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.FullScopeTMSCImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.FullScopeTMSCImpl#getArchitectures <em>Architectures</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.FullScopeTMSCImpl#isEpochTime <em>Epoch Time</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.FullScopeTMSCImpl#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.FullScopeTMSCImpl#getEndTime <em>End Time</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FullScopeTMSCImpl extends TMSCImpl implements FullScopeTMSC {
	/**
	 * The cached value of the '{@link #getMeasurements() <em>Measurements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasurements()
	 * @generated
	 * @ordered
	 */
	protected EList<Measurement> measurements;

	/**
	 * The cached value of the '{@link #getLifelines() <em>Lifelines</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLifelines()
	 * @generated
	 * @ordered
	 */
	protected EList<Lifeline> lifelines;

	/**
	 * The cached value of the '{@link #getDependencies() <em>Dependencies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<Dependency> dependencies;

	/**
	 * The cached value of the '{@link #getArchitectures() <em>Architectures</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArchitectures()
	 * @generated
	 * @ordered
	 */
	protected EList<ArchitectureModel> architectures;

	/**
	 * The default value of the '{@link #isEpochTime() <em>Epoch Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEpochTime()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EPOCH_TIME_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEpochTime() <em>Epoch Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEpochTime()
	 * @generated
	 * @ordered
	 */
	protected boolean epochTime = EPOCH_TIME_EDEFAULT;

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
	 * The cached value of the '{@link #getStartTime() <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartTime()
	 * @generated
	 * @ordered
	 */
	protected Long startTime = START_TIME_EDEFAULT;

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
	 * The cached value of the '{@link #getEndTime() <em>End Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndTime()
	 * @generated
	 * @ordered
	 */
	protected Long endTime = END_TIME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FullScopeTMSCImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TmscPackage.Literals.FULL_SCOPE_TMSC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Measurement> getMeasurements() {
		if (measurements == null) {
			measurements = new EObjectContainmentEList<Measurement>(Measurement.class, this,
					TmscPackage.FULL_SCOPE_TMSC__MEASUREMENTS);
		}
		return measurements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Lifeline> getLifelines() {
		if (lifelines == null) {
			lifelines = new EObjectContainmentWithInverseEList<Lifeline>(Lifeline.class, this,
					TmscPackage.FULL_SCOPE_TMSC__LIFELINES, TmscPackage.LIFELINE__TMSC);
		}
		return lifelines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Dependency> getDependencies() {
		if (dependencies == null) {
			dependencies = new EObjectContainmentWithInverseEList<Dependency>(Dependency.class, this,
					TmscPackage.FULL_SCOPE_TMSC__DEPENDENCIES, TmscPackage.DEPENDENCY__TMSC);
		}
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ArchitectureModel> getArchitectures() {
		if (architectures == null) {
			architectures = new EObjectResolvingEList<ArchitectureModel>(ArchitectureModel.class, this,
					TmscPackage.FULL_SCOPE_TMSC__ARCHITECTURES);
		}
		return architectures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isEpochTime() {
		return epochTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEpochTime(boolean newEpochTime) {
		boolean oldEpochTime = epochTime;
		epochTime = newEpochTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TmscPackage.FULL_SCOPE_TMSC__EPOCH_TIME, oldEpochTime,
					epochTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Long getStartTime() {
		return startTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStartTime(Long newStartTime) {
		Long oldStartTime = startTime;
		startTime = newStartTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TmscPackage.FULL_SCOPE_TMSC__START_TIME, oldStartTime,
					startTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Long getEndTime() {
		return endTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEndTime(Long newEndTime) {
		Long oldEndTime = endTime;
		endTime = newEndTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TmscPackage.FULL_SCOPE_TMSC__END_TIME, oldEndTime,
					endTime));
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
		case TmscPackage.FULL_SCOPE_TMSC__LIFELINES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getLifelines()).basicAdd(otherEnd, msgs);
		case TmscPackage.FULL_SCOPE_TMSC__DEPENDENCIES:
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
		case TmscPackage.FULL_SCOPE_TMSC__MEASUREMENTS:
			return ((InternalEList<?>) getMeasurements()).basicRemove(otherEnd, msgs);
		case TmscPackage.FULL_SCOPE_TMSC__LIFELINES:
			return ((InternalEList<?>) getLifelines()).basicRemove(otherEnd, msgs);
		case TmscPackage.FULL_SCOPE_TMSC__DEPENDENCIES:
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case TmscPackage.FULL_SCOPE_TMSC__MEASUREMENTS:
			return getMeasurements();
		case TmscPackage.FULL_SCOPE_TMSC__LIFELINES:
			return getLifelines();
		case TmscPackage.FULL_SCOPE_TMSC__DEPENDENCIES:
			return getDependencies();
		case TmscPackage.FULL_SCOPE_TMSC__ARCHITECTURES:
			return getArchitectures();
		case TmscPackage.FULL_SCOPE_TMSC__EPOCH_TIME:
			return isEpochTime();
		case TmscPackage.FULL_SCOPE_TMSC__START_TIME:
			return getStartTime();
		case TmscPackage.FULL_SCOPE_TMSC__END_TIME:
			return getEndTime();
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
		case TmscPackage.FULL_SCOPE_TMSC__MEASUREMENTS:
			getMeasurements().clear();
			getMeasurements().addAll((Collection<? extends Measurement>) newValue);
			return;
		case TmscPackage.FULL_SCOPE_TMSC__LIFELINES:
			getLifelines().clear();
			getLifelines().addAll((Collection<? extends Lifeline>) newValue);
			return;
		case TmscPackage.FULL_SCOPE_TMSC__DEPENDENCIES:
			getDependencies().clear();
			getDependencies().addAll((Collection<? extends Dependency>) newValue);
			return;
		case TmscPackage.FULL_SCOPE_TMSC__ARCHITECTURES:
			getArchitectures().clear();
			getArchitectures().addAll((Collection<? extends ArchitectureModel>) newValue);
			return;
		case TmscPackage.FULL_SCOPE_TMSC__EPOCH_TIME:
			setEpochTime((Boolean) newValue);
			return;
		case TmscPackage.FULL_SCOPE_TMSC__START_TIME:
			setStartTime((Long) newValue);
			return;
		case TmscPackage.FULL_SCOPE_TMSC__END_TIME:
			setEndTime((Long) newValue);
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
		case TmscPackage.FULL_SCOPE_TMSC__MEASUREMENTS:
			getMeasurements().clear();
			return;
		case TmscPackage.FULL_SCOPE_TMSC__LIFELINES:
			getLifelines().clear();
			return;
		case TmscPackage.FULL_SCOPE_TMSC__DEPENDENCIES:
			getDependencies().clear();
			return;
		case TmscPackage.FULL_SCOPE_TMSC__ARCHITECTURES:
			getArchitectures().clear();
			return;
		case TmscPackage.FULL_SCOPE_TMSC__EPOCH_TIME:
			setEpochTime(EPOCH_TIME_EDEFAULT);
			return;
		case TmscPackage.FULL_SCOPE_TMSC__START_TIME:
			setStartTime(START_TIME_EDEFAULT);
			return;
		case TmscPackage.FULL_SCOPE_TMSC__END_TIME:
			setEndTime(END_TIME_EDEFAULT);
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
		case TmscPackage.FULL_SCOPE_TMSC__MEASUREMENTS:
			return measurements != null && !measurements.isEmpty();
		case TmscPackage.FULL_SCOPE_TMSC__LIFELINES:
			return lifelines != null && !lifelines.isEmpty();
		case TmscPackage.FULL_SCOPE_TMSC__DEPENDENCIES:
			return dependencies != null && !dependencies.isEmpty();
		case TmscPackage.FULL_SCOPE_TMSC__ARCHITECTURES:
			return architectures != null && !architectures.isEmpty();
		case TmscPackage.FULL_SCOPE_TMSC__EPOCH_TIME:
			return epochTime != EPOCH_TIME_EDEFAULT;
		case TmscPackage.FULL_SCOPE_TMSC__START_TIME:
			return START_TIME_EDEFAULT == null ? startTime != null : !START_TIME_EDEFAULT.equals(startTime);
		case TmscPackage.FULL_SCOPE_TMSC__END_TIME:
			return END_TIME_EDEFAULT == null ? endTime != null : !END_TIME_EDEFAULT.equals(endTime);
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
		result.append(" (epochTime: ");
		result.append(epochTime);
		result.append(", startTime: ");
		result.append(startTime);
		result.append(", endTime: ");
		result.append(endTime);
		result.append(')');
		return result.toString();
	}

} //FullScopeTMSCImpl
