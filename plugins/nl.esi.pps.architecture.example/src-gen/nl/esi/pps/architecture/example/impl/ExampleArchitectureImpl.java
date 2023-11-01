/**
 */
package nl.esi.pps.architecture.example.impl;

import java.util.Collection;

import nl.esi.emf.properties.impl.PropertiesContainerImpl;

import nl.esi.pps.architecture.example.ExampleArchitecture;
import nl.esi.pps.architecture.example.ExampleHost;
import nl.esi.pps.architecture.example.ExamplePackage;

import nl.esi.pps.architecture.implemented.Function;

import nl.esi.pps.architecture.instantiated.Executor;

import nl.esi.pps.architecture.specified.Component;
import nl.esi.pps.architecture.specified.Interface;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Architecture</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.architecture.example.impl.ExampleArchitectureImpl#getInterfaces <em>Interfaces</em>}</li>
 *   <li>{@link nl.esi.pps.architecture.example.impl.ExampleArchitectureImpl#getFunctions <em>Functions</em>}</li>
 *   <li>{@link nl.esi.pps.architecture.example.impl.ExampleArchitectureImpl#getComponents <em>Components</em>}</li>
 *   <li>{@link nl.esi.pps.architecture.example.impl.ExampleArchitectureImpl#getHosts <em>Hosts</em>}</li>
 *   <li>{@link nl.esi.pps.architecture.example.impl.ExampleArchitectureImpl#getExecutors <em>Executors</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExampleArchitectureImpl extends PropertiesContainerImpl implements ExampleArchitecture {
	/**
	 * The cached value of the '{@link #getInterfaces() <em>Interfaces</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfaces()
	 * @generated
	 * @ordered
	 */
	protected EList<Interface> interfaces;

	/**
	 * The cached value of the '{@link #getFunctions() <em>Functions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctions()
	 * @generated
	 * @ordered
	 */
	protected EList<Function> functions;

	/**
	 * The cached value of the '{@link #getComponents() <em>Components</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponents()
	 * @generated
	 * @ordered
	 */
	protected EList<Component> components;

	/**
	 * The cached value of the '{@link #getHosts() <em>Hosts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHosts()
	 * @generated
	 * @ordered
	 */
	protected EList<ExampleHost> hosts;

	/**
	 * The cached value of the '{@link #getExecutors() <em>Executors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutors()
	 * @generated
	 * @ordered
	 */
	protected EList<Executor> executors;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExampleArchitectureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExamplePackage.Literals.EXAMPLE_ARCHITECTURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Interface> getInterfaces() {
		if (interfaces == null) {
			interfaces = new EObjectContainmentEList<Interface>(Interface.class, this,
					ExamplePackage.EXAMPLE_ARCHITECTURE__INTERFACES);
		}
		return interfaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Function> getFunctions() {
		if (functions == null) {
			functions = new EObjectContainmentEList<Function>(Function.class, this,
					ExamplePackage.EXAMPLE_ARCHITECTURE__FUNCTIONS);
		}
		return functions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Component> getComponents() {
		if (components == null) {
			components = new EObjectContainmentEList<Component>(Component.class, this,
					ExamplePackage.EXAMPLE_ARCHITECTURE__COMPONENTS);
		}
		return components;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ExampleHost> getHosts() {
		if (hosts == null) {
			hosts = new EObjectContainmentEList<ExampleHost>(ExampleHost.class, this,
					ExamplePackage.EXAMPLE_ARCHITECTURE__HOSTS);
		}
		return hosts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Executor> getExecutors() {
		if (executors == null) {
			executors = new EObjectContainmentEList<Executor>(Executor.class, this,
					ExamplePackage.EXAMPLE_ARCHITECTURE__EXECUTORS);
		}
		return executors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ExamplePackage.EXAMPLE_ARCHITECTURE__INTERFACES:
			return ((InternalEList<?>) getInterfaces()).basicRemove(otherEnd, msgs);
		case ExamplePackage.EXAMPLE_ARCHITECTURE__FUNCTIONS:
			return ((InternalEList<?>) getFunctions()).basicRemove(otherEnd, msgs);
		case ExamplePackage.EXAMPLE_ARCHITECTURE__COMPONENTS:
			return ((InternalEList<?>) getComponents()).basicRemove(otherEnd, msgs);
		case ExamplePackage.EXAMPLE_ARCHITECTURE__HOSTS:
			return ((InternalEList<?>) getHosts()).basicRemove(otherEnd, msgs);
		case ExamplePackage.EXAMPLE_ARCHITECTURE__EXECUTORS:
			return ((InternalEList<?>) getExecutors()).basicRemove(otherEnd, msgs);
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
		case ExamplePackage.EXAMPLE_ARCHITECTURE__INTERFACES:
			return getInterfaces();
		case ExamplePackage.EXAMPLE_ARCHITECTURE__FUNCTIONS:
			return getFunctions();
		case ExamplePackage.EXAMPLE_ARCHITECTURE__COMPONENTS:
			return getComponents();
		case ExamplePackage.EXAMPLE_ARCHITECTURE__HOSTS:
			return getHosts();
		case ExamplePackage.EXAMPLE_ARCHITECTURE__EXECUTORS:
			return getExecutors();
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
		case ExamplePackage.EXAMPLE_ARCHITECTURE__INTERFACES:
			getInterfaces().clear();
			getInterfaces().addAll((Collection<? extends Interface>) newValue);
			return;
		case ExamplePackage.EXAMPLE_ARCHITECTURE__FUNCTIONS:
			getFunctions().clear();
			getFunctions().addAll((Collection<? extends Function>) newValue);
			return;
		case ExamplePackage.EXAMPLE_ARCHITECTURE__COMPONENTS:
			getComponents().clear();
			getComponents().addAll((Collection<? extends Component>) newValue);
			return;
		case ExamplePackage.EXAMPLE_ARCHITECTURE__HOSTS:
			getHosts().clear();
			getHosts().addAll((Collection<? extends ExampleHost>) newValue);
			return;
		case ExamplePackage.EXAMPLE_ARCHITECTURE__EXECUTORS:
			getExecutors().clear();
			getExecutors().addAll((Collection<? extends Executor>) newValue);
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
		case ExamplePackage.EXAMPLE_ARCHITECTURE__INTERFACES:
			getInterfaces().clear();
			return;
		case ExamplePackage.EXAMPLE_ARCHITECTURE__FUNCTIONS:
			getFunctions().clear();
			return;
		case ExamplePackage.EXAMPLE_ARCHITECTURE__COMPONENTS:
			getComponents().clear();
			return;
		case ExamplePackage.EXAMPLE_ARCHITECTURE__HOSTS:
			getHosts().clear();
			return;
		case ExamplePackage.EXAMPLE_ARCHITECTURE__EXECUTORS:
			getExecutors().clear();
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
		case ExamplePackage.EXAMPLE_ARCHITECTURE__INTERFACES:
			return interfaces != null && !interfaces.isEmpty();
		case ExamplePackage.EXAMPLE_ARCHITECTURE__FUNCTIONS:
			return functions != null && !functions.isEmpty();
		case ExamplePackage.EXAMPLE_ARCHITECTURE__COMPONENTS:
			return components != null && !components.isEmpty();
		case ExamplePackage.EXAMPLE_ARCHITECTURE__HOSTS:
			return hosts != null && !hosts.isEmpty();
		case ExamplePackage.EXAMPLE_ARCHITECTURE__EXECUTORS:
			return executors != null && !executors.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ExampleArchitectureImpl
