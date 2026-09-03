/**
 */
package nl.esi.pps.architecture.example.impl;

import nl.esi.emf.properties.PropertiesPackage;

import nl.esi.pps.architecture.ArchitecturePackage;

import nl.esi.pps.architecture.deployed.DeployedPackage;

import nl.esi.pps.architecture.example.ExampleArchitecture;
import nl.esi.pps.architecture.example.ExampleComponentGroup;
import nl.esi.pps.architecture.example.ExampleFactory;
import nl.esi.pps.architecture.example.ExampleFunctionGroup;
import nl.esi.pps.architecture.example.ExampleHost;
import nl.esi.pps.architecture.example.ExampleInterfaceGroup;
import nl.esi.pps.architecture.example.ExamplePackage;

import nl.esi.pps.architecture.implemented.ImplementedPackage;

import nl.esi.pps.architecture.instantiated.InstantiatedPackage;

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
public class ExamplePackageImpl extends EPackageImpl implements ExamplePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exampleArchitectureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exampleHostEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exampleFunctionGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exampleInterfaceGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exampleComponentGroupEClass = null;

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
	 * @see nl.esi.pps.architecture.example.ExamplePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ExamplePackageImpl() {
		super(eNS_URI, ExampleFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ExamplePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ExamplePackage init() {
		if (isInited)
			return (ExamplePackage) EPackage.Registry.INSTANCE.getEPackage(ExamplePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredExamplePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ExamplePackageImpl theExamplePackage = registeredExamplePackage instanceof ExamplePackageImpl
				? (ExamplePackageImpl) registeredExamplePackage
				: new ExamplePackageImpl();

		isInited = true;

		// Initialize simple dependencies
		ArchitecturePackage.eINSTANCE.eClass();
		PropertiesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theExamplePackage.createPackageContents();

		// Initialize created meta-data
		theExamplePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theExamplePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ExamplePackage.eNS_URI, theExamplePackage);
		return theExamplePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExampleArchitecture() {
		return exampleArchitectureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExampleArchitecture_Interfaces() {
		return (EReference) exampleArchitectureEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExampleArchitecture_Functions() {
		return (EReference) exampleArchitectureEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExampleArchitecture_Components() {
		return (EReference) exampleArchitectureEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExampleArchitecture_Hosts() {
		return (EReference) exampleArchitectureEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExampleArchitecture_Executors() {
		return (EReference) exampleArchitectureEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExampleArchitecture_FunctionGroups() {
		return (EReference) exampleArchitectureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExampleArchitecture_InterfaceGroups() {
		return (EReference) exampleArchitectureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExampleArchitecture_ComponentGroups() {
		return (EReference) exampleArchitectureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExampleHost() {
		return exampleHostEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExampleHost_Executors() {
		return (EReference) exampleHostEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExampleFunctionGroup() {
		return exampleFunctionGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExampleFunctionGroup_SubGroups() {
		return (EReference) exampleFunctionGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExampleFunctionGroup_ParentGroup() {
		return (EReference) exampleFunctionGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExampleFunctionGroup_Functions() {
		return (EReference) exampleFunctionGroupEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExampleInterfaceGroup() {
		return exampleInterfaceGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExampleInterfaceGroup_Interfaces() {
		return (EReference) exampleInterfaceGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExampleInterfaceGroup_SubGroups() {
		return (EReference) exampleInterfaceGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExampleInterfaceGroup_ParentGroup() {
		return (EReference) exampleInterfaceGroupEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExampleComponentGroup() {
		return exampleComponentGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExampleComponentGroup_Components() {
		return (EReference) exampleComponentGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExampleComponentGroup_SubGroups() {
		return (EReference) exampleComponentGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExampleComponentGroup_ParentGroup() {
		return (EReference) exampleComponentGroupEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExampleFactory getExampleFactory() {
		return (ExampleFactory) getEFactoryInstance();
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
		exampleArchitectureEClass = createEClass(EXAMPLE_ARCHITECTURE);
		createEReference(exampleArchitectureEClass, EXAMPLE_ARCHITECTURE__COMPONENT_GROUPS);
		createEReference(exampleArchitectureEClass, EXAMPLE_ARCHITECTURE__INTERFACE_GROUPS);
		createEReference(exampleArchitectureEClass, EXAMPLE_ARCHITECTURE__FUNCTION_GROUPS);
		createEReference(exampleArchitectureEClass, EXAMPLE_ARCHITECTURE__HOSTS);
		createEReference(exampleArchitectureEClass, EXAMPLE_ARCHITECTURE__COMPONENTS);
		createEReference(exampleArchitectureEClass, EXAMPLE_ARCHITECTURE__INTERFACES);
		createEReference(exampleArchitectureEClass, EXAMPLE_ARCHITECTURE__FUNCTIONS);
		createEReference(exampleArchitectureEClass, EXAMPLE_ARCHITECTURE__EXECUTORS);

		exampleHostEClass = createEClass(EXAMPLE_HOST);
		createEReference(exampleHostEClass, EXAMPLE_HOST__EXECUTORS);

		exampleFunctionGroupEClass = createEClass(EXAMPLE_FUNCTION_GROUP);
		createEReference(exampleFunctionGroupEClass, EXAMPLE_FUNCTION_GROUP__SUB_GROUPS);
		createEReference(exampleFunctionGroupEClass, EXAMPLE_FUNCTION_GROUP__PARENT_GROUP);
		createEReference(exampleFunctionGroupEClass, EXAMPLE_FUNCTION_GROUP__FUNCTIONS);

		exampleInterfaceGroupEClass = createEClass(EXAMPLE_INTERFACE_GROUP);
		createEReference(exampleInterfaceGroupEClass, EXAMPLE_INTERFACE_GROUP__INTERFACES);
		createEReference(exampleInterfaceGroupEClass, EXAMPLE_INTERFACE_GROUP__SUB_GROUPS);
		createEReference(exampleInterfaceGroupEClass, EXAMPLE_INTERFACE_GROUP__PARENT_GROUP);

		exampleComponentGroupEClass = createEClass(EXAMPLE_COMPONENT_GROUP);
		createEReference(exampleComponentGroupEClass, EXAMPLE_COMPONENT_GROUP__COMPONENTS);
		createEReference(exampleComponentGroupEClass, EXAMPLE_COMPONENT_GROUP__SUB_GROUPS);
		createEReference(exampleComponentGroupEClass, EXAMPLE_COMPONENT_GROUP__PARENT_GROUP);
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
		PropertiesPackage thePropertiesPackage = (PropertiesPackage) EPackage.Registry.INSTANCE
				.getEPackage(PropertiesPackage.eNS_URI);
		ArchitecturePackage theArchitecturePackage = (ArchitecturePackage) EPackage.Registry.INSTANCE
				.getEPackage(ArchitecturePackage.eNS_URI);
		SpecifiedPackage theSpecifiedPackage = (SpecifiedPackage) EPackage.Registry.INSTANCE
				.getEPackage(SpecifiedPackage.eNS_URI);
		ImplementedPackage theImplementedPackage = (ImplementedPackage) EPackage.Registry.INSTANCE
				.getEPackage(ImplementedPackage.eNS_URI);
		InstantiatedPackage theInstantiatedPackage = (InstantiatedPackage) EPackage.Registry.INSTANCE
				.getEPackage(InstantiatedPackage.eNS_URI);
		DeployedPackage theDeployedPackage = (DeployedPackage) EPackage.Registry.INSTANCE
				.getEPackage(DeployedPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		exampleArchitectureEClass.getESuperTypes().add(thePropertiesPackage.getPropertiesContainer());
		exampleArchitectureEClass.getESuperTypes().add(theArchitecturePackage.getArchitectureModel());
		exampleHostEClass.getESuperTypes().add(theDeployedPackage.getHost());
		exampleFunctionGroupEClass.getESuperTypes().add(theArchitecturePackage.getNamedArchitectureElement());
		exampleInterfaceGroupEClass.getESuperTypes().add(theArchitecturePackage.getNamedArchitectureElement());
		exampleComponentGroupEClass.getESuperTypes().add(theArchitecturePackage.getNamedArchitectureElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(exampleArchitectureEClass, ExampleArchitecture.class, "ExampleArchitecture", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExampleArchitecture_ComponentGroups(), this.getExampleComponentGroup(), null,
				"componentGroups", null, 0, -1, ExampleArchitecture.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExampleArchitecture_InterfaceGroups(), this.getExampleInterfaceGroup(), null,
				"interfaceGroups", null, 0, -1, ExampleArchitecture.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExampleArchitecture_FunctionGroups(), this.getExampleFunctionGroup(), null, "functionGroups",
				null, 0, -1, ExampleArchitecture.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExampleArchitecture_Hosts(), this.getExampleHost(), null, "hosts", null, 0, -1,
				ExampleArchitecture.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExampleArchitecture_Components(), theSpecifiedPackage.getComponent(), null, "components",
				null, 0, -1, ExampleArchitecture.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExampleArchitecture_Interfaces(), theSpecifiedPackage.getInterface(), null, "interfaces",
				null, 0, -1, ExampleArchitecture.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExampleArchitecture_Functions(), theImplementedPackage.getFunction(), null, "functions", null,
				0, -1, ExampleArchitecture.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExampleArchitecture_Executors(), theInstantiatedPackage.getExecutor(), null, "executors",
				null, 0, -1, ExampleArchitecture.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(exampleHostEClass, ExampleHost.class, "ExampleHost", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExampleHost_Executors(), theInstantiatedPackage.getExecutor(), null, "executors", null, 0, -1,
				ExampleHost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(exampleFunctionGroupEClass, ExampleFunctionGroup.class, "ExampleFunctionGroup", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExampleFunctionGroup_SubGroups(), this.getExampleFunctionGroup(),
				this.getExampleFunctionGroup_ParentGroup(), "subGroups", null, 0, -1, ExampleFunctionGroup.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExampleFunctionGroup_ParentGroup(), this.getExampleFunctionGroup(),
				this.getExampleFunctionGroup_SubGroups(), "parentGroup", null, 0, 1, ExampleFunctionGroup.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExampleFunctionGroup_Functions(), theImplementedPackage.getFunction(), null, "functions",
				null, 0, -1, ExampleFunctionGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(exampleInterfaceGroupEClass, ExampleInterfaceGroup.class, "ExampleInterfaceGroup", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExampleInterfaceGroup_Interfaces(), theSpecifiedPackage.getInterface(), null, "interfaces",
				null, 0, -1, ExampleInterfaceGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExampleInterfaceGroup_SubGroups(), this.getExampleInterfaceGroup(),
				this.getExampleInterfaceGroup_ParentGroup(), "subGroups", null, 0, -1, ExampleInterfaceGroup.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExampleInterfaceGroup_ParentGroup(), this.getExampleInterfaceGroup(),
				this.getExampleInterfaceGroup_SubGroups(), "parentGroup", null, 0, 1, ExampleInterfaceGroup.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(exampleComponentGroupEClass, ExampleComponentGroup.class, "ExampleComponentGroup", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExampleComponentGroup_Components(), theSpecifiedPackage.getComponent(), null, "components",
				null, 0, -1, ExampleComponentGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExampleComponentGroup_SubGroups(), this.getExampleComponentGroup(),
				this.getExampleComponentGroup_ParentGroup(), "subGroups", null, 0, -1, ExampleComponentGroup.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExampleComponentGroup_ParentGroup(), this.getExampleComponentGroup(),
				this.getExampleComponentGroup_SubGroups(), "parentGroup", null, 0, 1, ExampleComponentGroup.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ExamplePackageImpl
