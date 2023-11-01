/**
 */
package nl.esi.pps.tmsc.metric.impl;

import java.util.Collection;

import nl.esi.pps.tmsc.FullScopeTMSC;

import nl.esi.pps.tmsc.metric.Metric;
import nl.esi.pps.tmsc.metric.MetricCategory;
import nl.esi.pps.tmsc.metric.MetricInstance;
import nl.esi.pps.tmsc.metric.MetricPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Metric</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.metric.impl.MetricImpl#getId <em>Id</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.metric.impl.MetricImpl#getName <em>Name</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.metric.impl.MetricImpl#getBudget <em>Budget</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.metric.impl.MetricImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.metric.impl.MetricImpl#getInstances <em>Instances</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.metric.impl.MetricImpl#getTmscs <em>Tmscs</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.metric.impl.MetricImpl#getConfiguration <em>Configuration</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MetricImpl extends MinimalEObjectImpl.Container implements Metric {
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
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getBudget() <em>Budget</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBudget()
	 * @generated
	 * @ordered
	 */
	protected static final Long BUDGET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBudget() <em>Budget</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBudget()
	 * @generated
	 * @ordered
	 */
	protected Long budget = BUDGET_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCategory() <em>Category</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected MetricCategory category;

	/**
	 * The cached value of the '{@link #getInstances() <em>Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<MetricInstance> instances;

	/**
	 * The cached value of the '{@link #getTmscs() <em>Tmscs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTmscs()
	 * @generated
	 * @ordered
	 */
	protected EList<FullScopeTMSC> tmscs;

	/**
	 * The default value of the '{@link #getConfiguration() <em>Configuration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfiguration()
	 * @generated
	 * @ordered
	 */
	protected static final String CONFIGURATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConfiguration() <em>Configuration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfiguration()
	 * @generated
	 * @ordered
	 */
	protected String configuration = CONFIGURATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetricImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetricPackage.Literals.METRIC;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MetricPackage.METRIC__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MetricPackage.METRIC__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Long getBudget() {
		return budget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBudget(Long newBudget) {
		Long oldBudget = budget;
		budget = newBudget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricPackage.METRIC__BUDGET, oldBudget, budget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MetricCategory getCategory() {
		if (category != null && category.eIsProxy()) {
			InternalEObject oldCategory = (InternalEObject) category;
			category = (MetricCategory) eResolveProxy(oldCategory);
			if (category != oldCategory) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetricPackage.METRIC__CATEGORY,
							oldCategory, category));
			}
		}
		return category;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricCategory basicGetCategory() {
		return category;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCategory(MetricCategory newCategory, NotificationChain msgs) {
		MetricCategory oldCategory = category;
		category = newCategory;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					MetricPackage.METRIC__CATEGORY, oldCategory, newCategory);
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
	public void setCategory(MetricCategory newCategory) {
		if (newCategory != category) {
			NotificationChain msgs = null;
			if (category != null)
				msgs = ((InternalEObject) category).eInverseRemove(this, MetricPackage.METRIC_CATEGORY__METRICS,
						MetricCategory.class, msgs);
			if (newCategory != null)
				msgs = ((InternalEObject) newCategory).eInverseAdd(this, MetricPackage.METRIC_CATEGORY__METRICS,
						MetricCategory.class, msgs);
			msgs = basicSetCategory(newCategory, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricPackage.METRIC__CATEGORY, newCategory,
					newCategory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MetricInstance> getInstances() {
		if (instances == null) {
			instances = new EObjectContainmentWithInverseEList<MetricInstance>(MetricInstance.class, this,
					MetricPackage.METRIC__INSTANCES, MetricPackage.METRIC_INSTANCE__METRIC);
		}
		return instances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<FullScopeTMSC> getTmscs() {
		if (tmscs == null) {
			tmscs = new EObjectResolvingEList<FullScopeTMSC>(FullScopeTMSC.class, this, MetricPackage.METRIC__TMSCS);
		}
		return tmscs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getConfiguration() {
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConfiguration(String newConfiguration) {
		String oldConfiguration = configuration;
		configuration = newConfiguration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricPackage.METRIC__CONFIGURATION, oldConfiguration,
					configuration));
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
		case MetricPackage.METRIC__CATEGORY:
			if (category != null)
				msgs = ((InternalEObject) category).eInverseRemove(this, MetricPackage.METRIC_CATEGORY__METRICS,
						MetricCategory.class, msgs);
			return basicSetCategory((MetricCategory) otherEnd, msgs);
		case MetricPackage.METRIC__INSTANCES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getInstances()).basicAdd(otherEnd, msgs);
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
		case MetricPackage.METRIC__CATEGORY:
			return basicSetCategory(null, msgs);
		case MetricPackage.METRIC__INSTANCES:
			return ((InternalEList<?>) getInstances()).basicRemove(otherEnd, msgs);
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
		case MetricPackage.METRIC__ID:
			return getId();
		case MetricPackage.METRIC__NAME:
			return getName();
		case MetricPackage.METRIC__BUDGET:
			return getBudget();
		case MetricPackage.METRIC__CATEGORY:
			if (resolve)
				return getCategory();
			return basicGetCategory();
		case MetricPackage.METRIC__INSTANCES:
			return getInstances();
		case MetricPackage.METRIC__TMSCS:
			return getTmscs();
		case MetricPackage.METRIC__CONFIGURATION:
			return getConfiguration();
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
		case MetricPackage.METRIC__ID:
			setId((String) newValue);
			return;
		case MetricPackage.METRIC__NAME:
			setName((String) newValue);
			return;
		case MetricPackage.METRIC__BUDGET:
			setBudget((Long) newValue);
			return;
		case MetricPackage.METRIC__CATEGORY:
			setCategory((MetricCategory) newValue);
			return;
		case MetricPackage.METRIC__INSTANCES:
			getInstances().clear();
			getInstances().addAll((Collection<? extends MetricInstance>) newValue);
			return;
		case MetricPackage.METRIC__TMSCS:
			getTmscs().clear();
			getTmscs().addAll((Collection<? extends FullScopeTMSC>) newValue);
			return;
		case MetricPackage.METRIC__CONFIGURATION:
			setConfiguration((String) newValue);
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
		case MetricPackage.METRIC__ID:
			setId(ID_EDEFAULT);
			return;
		case MetricPackage.METRIC__NAME:
			setName(NAME_EDEFAULT);
			return;
		case MetricPackage.METRIC__BUDGET:
			setBudget(BUDGET_EDEFAULT);
			return;
		case MetricPackage.METRIC__CATEGORY:
			setCategory((MetricCategory) null);
			return;
		case MetricPackage.METRIC__INSTANCES:
			getInstances().clear();
			return;
		case MetricPackage.METRIC__TMSCS:
			getTmscs().clear();
			return;
		case MetricPackage.METRIC__CONFIGURATION:
			setConfiguration(CONFIGURATION_EDEFAULT);
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
		case MetricPackage.METRIC__ID:
			return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
		case MetricPackage.METRIC__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case MetricPackage.METRIC__BUDGET:
			return BUDGET_EDEFAULT == null ? budget != null : !BUDGET_EDEFAULT.equals(budget);
		case MetricPackage.METRIC__CATEGORY:
			return category != null;
		case MetricPackage.METRIC__INSTANCES:
			return instances != null && !instances.isEmpty();
		case MetricPackage.METRIC__TMSCS:
			return tmscs != null && !tmscs.isEmpty();
		case MetricPackage.METRIC__CONFIGURATION:
			return CONFIGURATION_EDEFAULT == null ? configuration != null
					: !CONFIGURATION_EDEFAULT.equals(configuration);
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
		result.append(", name: ");
		result.append(name);
		result.append(", budget: ");
		result.append(budget);
		result.append(", configuration: ");
		result.append(configuration);
		result.append(')');
		return result.toString();
	}

} //MetricImpl
