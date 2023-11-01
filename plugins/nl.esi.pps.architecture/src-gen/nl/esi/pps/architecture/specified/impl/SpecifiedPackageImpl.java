/**
 */
package nl.esi.pps.architecture.specified.impl;

import nl.esi.emf.properties.PropertiesPackage;

import nl.esi.pps.architecture.ArchitecturePackage;

import nl.esi.pps.architecture.deployed.DeployedPackage;

import nl.esi.pps.architecture.deployed.impl.DeployedPackageImpl;

import nl.esi.pps.architecture.impl.ArchitecturePackageImpl;

import nl.esi.pps.architecture.implemented.ImplementedPackage;

import nl.esi.pps.architecture.implemented.impl.ImplementedPackageImpl;

import nl.esi.pps.architecture.instantiated.InstantiatedPackage;

import nl.esi.pps.architecture.instantiated.impl.InstantiatedPackageImpl;

import nl.esi.pps.architecture.specified.Component;
import nl.esi.pps.architecture.specified.Interface;
import nl.esi.pps.architecture.specified.Operation;
import nl.esi.pps.architecture.specified.SpecifiedFactory;
import nl.esi.pps.architecture.specified.SpecifiedPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SpecifiedPackageImpl extends EPackageImpl implements SpecifiedPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see nl.esi.pps.architecture.specified.SpecifiedPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SpecifiedPackageImpl() {
		super(eNS_URI, SpecifiedFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link SpecifiedPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SpecifiedPackage init() {
		if (isInited)
			return (SpecifiedPackage) EPackage.Registry.INSTANCE.getEPackage(SpecifiedPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredSpecifiedPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		SpecifiedPackageImpl theSpecifiedPackage = registeredSpecifiedPackage instanceof SpecifiedPackageImpl
				? (SpecifiedPackageImpl) registeredSpecifiedPackage
				: new SpecifiedPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		PropertiesPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ArchitecturePackage.eNS_URI);
		ArchitecturePackageImpl theArchitecturePackage = (ArchitecturePackageImpl) (registeredPackage instanceof ArchitecturePackageImpl
				? registeredPackage
				: ArchitecturePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ImplementedPackage.eNS_URI);
		ImplementedPackageImpl theImplementedPackage = (ImplementedPackageImpl) (registeredPackage instanceof ImplementedPackageImpl
				? registeredPackage
				: ImplementedPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(InstantiatedPackage.eNS_URI);
		InstantiatedPackageImpl theInstantiatedPackage = (InstantiatedPackageImpl) (registeredPackage instanceof InstantiatedPackageImpl
				? registeredPackage
				: InstantiatedPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(DeployedPackage.eNS_URI);
		DeployedPackageImpl theDeployedPackage = (DeployedPackageImpl) (registeredPackage instanceof DeployedPackageImpl
				? registeredPackage
				: DeployedPackage.eINSTANCE);

		// Create package meta-data objects
		theSpecifiedPackage.createPackageContents();
		theArchitecturePackage.createPackageContents();
		theImplementedPackage.createPackageContents();
		theInstantiatedPackage.createPackageContents();
		theDeployedPackage.createPackageContents();

		// Initialize created meta-data
		theSpecifiedPackage.initializePackageContents();
		theArchitecturePackage.initializePackageContents();
		theImplementedPackage.initializePackageContents();
		theInstantiatedPackage.initializePackageContents();
		theDeployedPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSpecifiedPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SpecifiedPackage.eNS_URI, theSpecifiedPackage);
		return theSpecifiedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getComponent() {
		return componentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComponent_RequiredInterfaces() {
		return (EReference) componentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComponent_ProvidedInterfaces() {
		return (EReference) componentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInterface() {
		return interfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInterface_RequiredBy() {
		return (EReference) interfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInterface_ProvidedBy() {
		return (EReference) interfaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInterface_Operations() {
		return (EReference) interfaceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOperation() {
		return operationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOperation_Interface() {
		return (EReference) operationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SpecifiedFactory getSpecifiedFactory() {
		return (SpecifiedFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		componentEClass = createEClass(COMPONENT);
		createEReference(componentEClass, COMPONENT__REQUIRED_INTERFACES);
		createEReference(componentEClass, COMPONENT__PROVIDED_INTERFACES);

		interfaceEClass = createEClass(INTERFACE);
		createEReference(interfaceEClass, INTERFACE__REQUIRED_BY);
		createEReference(interfaceEClass, INTERFACE__PROVIDED_BY);
		createEReference(interfaceEClass, INTERFACE__OPERATIONS);

		operationEClass = createEClass(OPERATION);
		createEReference(operationEClass, OPERATION__INTERFACE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ArchitecturePackage theArchitecturePackage = (ArchitecturePackage) EPackage.Registry.INSTANCE
				.getEPackage(ArchitecturePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		componentEClass.getESuperTypes().add(theArchitecturePackage.getNamedArchitectureElement());
		interfaceEClass.getESuperTypes().add(theArchitecturePackage.getNamedArchitectureElement());
		operationEClass.getESuperTypes().add(theArchitecturePackage.getNamedArchitectureElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(componentEClass, Component.class, "Component", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponent_RequiredInterfaces(), this.getInterface(), this.getInterface_RequiredBy(),
				"requiredInterfaces", null, 0, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponent_ProvidedInterfaces(), this.getInterface(), this.getInterface_ProvidedBy(),
				"providedInterfaces", null, 0, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interfaceEClass, Interface.class, "Interface", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInterface_RequiredBy(), this.getComponent(), this.getComponent_RequiredInterfaces(),
				"requiredBy", null, 0, -1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterface_ProvidedBy(), this.getComponent(), this.getComponent_ProvidedInterfaces(),
				"providedBy", null, 0, -1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterface_Operations(), this.getOperation(), this.getOperation_Interface(), "operations",
				null, 0, -1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationEClass, Operation.class, "Operation", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperation_Interface(), this.getInterface(), this.getInterface_Operations(), "interface", null,
				1, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //SpecifiedPackageImpl
