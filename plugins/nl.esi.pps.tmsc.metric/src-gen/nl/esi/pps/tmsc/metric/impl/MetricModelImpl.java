/**
 */
package nl.esi.pps.tmsc.metric.impl;

import java.util.Collection;

import nl.esi.pps.tmsc.metric.Metric;
import nl.esi.pps.tmsc.metric.MetricCategory;
import nl.esi.pps.tmsc.metric.MetricModel;
import nl.esi.pps.tmsc.metric.MetricPackage;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.metric.impl.MetricModelImpl#getMetrics <em>Metrics</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.metric.impl.MetricModelImpl#getCategories <em>Categories</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MetricModelImpl extends MinimalEObjectImpl.Container implements MetricModel {
	/**
	 * The cached value of the '{@link #getMetrics() <em>Metrics</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetrics()
	 * @generated
	 * @ordered
	 */
	protected EList<Metric> metrics;

	/**
	 * The cached value of the '{@link #getCategories() <em>Categories</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategories()
	 * @generated
	 * @ordered
	 */
	protected EList<MetricCategory> categories;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetricModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetricPackage.Literals.METRIC_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Metric> getMetrics() {
		if (metrics == null) {
			metrics = new EObjectContainmentEList<Metric>(Metric.class, this, MetricPackage.METRIC_MODEL__METRICS);
		}
		return metrics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MetricCategory> getCategories() {
		if (categories == null) {
			categories = new EObjectContainmentEList<MetricCategory>(MetricCategory.class, this,
					MetricPackage.METRIC_MODEL__CATEGORIES);
		}
		return categories;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MetricPackage.METRIC_MODEL__METRICS:
			return ((InternalEList<?>) getMetrics()).basicRemove(otherEnd, msgs);
		case MetricPackage.METRIC_MODEL__CATEGORIES:
			return ((InternalEList<?>) getCategories()).basicRemove(otherEnd, msgs);
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
		case MetricPackage.METRIC_MODEL__METRICS:
			return getMetrics();
		case MetricPackage.METRIC_MODEL__CATEGORIES:
			return getCategories();
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
		case MetricPackage.METRIC_MODEL__METRICS:
			getMetrics().clear();
			getMetrics().addAll((Collection<? extends Metric>) newValue);
			return;
		case MetricPackage.METRIC_MODEL__CATEGORIES:
			getCategories().clear();
			getCategories().addAll((Collection<? extends MetricCategory>) newValue);
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
		case MetricPackage.METRIC_MODEL__METRICS:
			getMetrics().clear();
			return;
		case MetricPackage.METRIC_MODEL__CATEGORIES:
			getCategories().clear();
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
		case MetricPackage.METRIC_MODEL__METRICS:
			return metrics != null && !metrics.isEmpty();
		case MetricPackage.METRIC_MODEL__CATEGORIES:
			return categories != null && !categories.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MetricModelImpl
