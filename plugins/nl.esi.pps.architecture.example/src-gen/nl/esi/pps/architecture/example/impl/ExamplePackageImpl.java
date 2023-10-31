/**
 */
package nl.esi.pps.architecture.example.impl;

import nl.esi.emf.properties.PropertiesPackage;

import nl.esi.pps.architecture.ArchitecturePackage;

import nl.esi.pps.architecture.example.ExampleArchitecture;
import nl.esi.pps.architecture.example.ExampleFactory;
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
	public EReference getExampleArchitecture_Components() {
		return (EReference) exampleArchitectureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExampleArchitecture_Interfaces() {
		return (EReference) exampleArchitectureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExampleArchitecture_Functions() {
		return (EReference) exampleArchitectureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExampleArchitecture_Executors() {
		return (EReference) exampleArchitectureEClass.getEStructuralFeatures().get(3);
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
		createEReference(exampleArchitectureEClass, EXAMPLE_ARCHITECTURE__COMPONENTS);
		createEReference(exampleArchitectureEClass, EXAMPLE_ARCHITECTURE__INTERFACES);
		createEReference(exampleArchitectureEClass, EXAMPLE_ARCHITECTURE__FUNCTIONS);
		createEReference(exampleArchitectureEClass, EXAMPLE_ARCHITECTURE__EXECUTORS);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		exampleArchitectureEClass.getESuperTypes().add(thePropertiesPackage.getPropertiesContainer());
		exampleArchitectureEClass.getESuperTypes().add(theArchitecturePackage.getArchitectureModel());

		// Initialize classes, features, and operations; add parameters
		initEClass(exampleArchitectureEClass, ExampleArchitecture.class, "ExampleArchitecture", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
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

		// Create resource
		createResource(eNS_URI);
	}

} //ExamplePackageImpl
