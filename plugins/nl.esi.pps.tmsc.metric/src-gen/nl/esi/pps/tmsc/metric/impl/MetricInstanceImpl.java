/**
 */
package nl.esi.pps.tmsc.metric.impl;

import nl.esi.pps.tmsc.impl.IntervalImpl;

import nl.esi.pps.tmsc.metric.Metric;
import nl.esi.pps.tmsc.metric.MetricInstance;
import nl.esi.pps.tmsc.metric.MetricPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.metric.impl.MetricInstanceImpl#getId <em>Id</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.metric.impl.MetricInstanceImpl#getName <em>Name</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.metric.impl.MetricInstanceImpl#isExceedsBudget <em>Exceeds Budget</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.metric.impl.MetricInstanceImpl#getMetric <em>Metric</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MetricInstanceImpl extends IntervalImpl implements MetricInstance {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

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
	 * The default value of the '{@link #isExceedsBudget() <em>Exceeds Budget</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExceedsBudget()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXCEEDS_BUDGET_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetricInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetricPackage.Literals.METRIC_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricPackage.METRIC_INSTANCE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return MetricImplQueries.getNameImpl(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isExceedsBudget() {
		return MetricImplQueries.isExceedsBudgetImpl(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Metric getMetric() {
		if (eContainerFeatureID() != MetricPackage.METRIC_INSTANCE__METRIC)
			return null;
		return (Metric) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMetric(Metric newMetric, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newMetric, MetricPackage.METRIC_INSTANCE__METRIC, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMetric(Metric newMetric) {
		if (newMetric != eInternalContainer()
				|| (eContainerFeatureID() != MetricPackage.METRIC_INSTANCE__METRIC && newMetric != null)) {
			if (EcoreUtil.isAncestor(this, newMetric))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMetric != null)
				msgs = ((InternalEObject) newMetric).eInverseAdd(this, MetricPackage.METRIC__INSTANCES, Metric.class,
						msgs);
			msgs = basicSetMetric(newMetric, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricPackage.METRIC_INSTANCE__METRIC, newMetric,
					newMetric));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MetricPackage.METRIC_INSTANCE__METRIC:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetMetric((Metric) otherEnd, msgs);
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
		case MetricPackage.METRIC_INSTANCE__METRIC:
			return basicSetMetric(null, msgs);
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
		case MetricPackage.METRIC_INSTANCE__METRIC:
			return eInternalContainer().eInverseRemove(this, MetricPackage.METRIC__INSTANCES, Metric.class, msgs);
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
		case MetricPackage.METRIC_INSTANCE__ID:
			return getId();
		case MetricPackage.METRIC_INSTANCE__NAME:
			return getName();
		case MetricPackage.METRIC_INSTANCE__EXCEEDS_BUDGET:
			return isExceedsBudget();
		case MetricPackage.METRIC_INSTANCE__METRIC:
			return getMetric();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case MetricPackage.METRIC_INSTANCE__ID:
			setId((String) newValue);
			return;
		case MetricPackage.METRIC_INSTANCE__METRIC:
			setMetric((Metric) newValue);
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
		case MetricPackage.METRIC_INSTANCE__ID:
			setId(ID_EDEFAULT);
			return;
		case MetricPackage.METRIC_INSTANCE__METRIC:
			setMetric((Metric) null);
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
		case MetricPackage.METRIC_INSTANCE__ID:
			return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
		case MetricPackage.METRIC_INSTANCE__NAME:
			return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
		case MetricPackage.METRIC_INSTANCE__EXCEEDS_BUDGET:
			return isExceedsBudget() != EXCEEDS_BUDGET_EDEFAULT;
		case MetricPackage.METRIC_INSTANCE__METRIC:
			return getMetric() != null;
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
		result.append(" (id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //MetricInstanceImpl
