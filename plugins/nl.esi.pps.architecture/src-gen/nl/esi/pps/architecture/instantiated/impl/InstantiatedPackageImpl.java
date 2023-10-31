/**
 */
package nl.esi.pps.architecture.instantiated.impl;

import nl.esi.emf.properties.PropertiesPackage;

import nl.esi.pps.architecture.ArchitecturePackage;

import nl.esi.pps.architecture.impl.ArchitecturePackageImpl;

import nl.esi.pps.architecture.implemented.ImplementedPackage;

import nl.esi.pps.architecture.implemented.impl.ImplementedPackageImpl;

import nl.esi.pps.architecture.instantiated.Executor;
import nl.esi.pps.architecture.instantiated.InstantiatedFactory;
import nl.esi.pps.architecture.instantiated.InstantiatedPackage;

import nl.esi.pps.architecture.specified.SpecifiedPackage;

import nl.esi.pps.architecture.specified.impl.SpecifiedPackageImpl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InstantiatedPackageImpl extends EPackageImpl implements InstantiatedPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass executorEClass = null;

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
	 * @see nl.esi.pps.architecture.instantiated.InstantiatedPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private InstantiatedPackageImpl() {
		super(eNS_URI, InstantiatedFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link InstantiatedPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static InstantiatedPackage init() {
		if (isInited)
			return (InstantiatedPackage) EPackage.Registry.INSTANCE.getEPackage(InstantiatedPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredInstantiatedPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		InstantiatedPackageImpl theInstantiatedPackage = registeredInstantiatedPackage instanceof InstantiatedPackageImpl
				? (InstantiatedPackageImpl) registeredInstantiatedPackage
				: new InstantiatedPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		PropertiesPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ArchitecturePackage.eNS_URI);
		ArchitecturePackageImpl theArchitecturePackage = (ArchitecturePackageImpl) (registeredPackage instanceof ArchitecturePackageImpl
				? registeredPackage
				: ArchitecturePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(SpecifiedPackage.eNS_URI);
		SpecifiedPackageImpl theSpecifiedPackage = (SpecifiedPackageImpl) (registeredPackage instanceof SpecifiedPackageImpl
				? registeredPackage
				: SpecifiedPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ImplementedPackage.eNS_URI);
		ImplementedPackageImpl theImplementedPackage = (ImplementedPackageImpl) (registeredPackage instanceof ImplementedPackageImpl
				? registeredPackage
				: ImplementedPackage.eINSTANCE);

		// Create package meta-data objects
		theInstantiatedPackage.createPackageContents();
		theArchitecturePackage.createPackageContents();
		theSpecifiedPackage.createPackageContents();
		theImplementedPackage.createPackageContents();

		// Initialize created meta-data
		theInstantiatedPackage.initializePackageContents();
		theArchitecturePackage.initializePackageContents();
		theSpecifiedPackage.initializePackageContents();
		theImplementedPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theInstantiatedPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(InstantiatedPackage.eNS_URI, theInstantiatedPackage);
		return theInstantiatedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExecutor() {
		return executorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InstantiatedFactory getInstantiatedFactory() {
		return (InstantiatedFactory) getEFactoryInstance();
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
		executorEClass = createEClass(EXECUTOR);
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
		executorEClass.getESuperTypes().add(theArchitecturePackage.getNamedArchitectureElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(executorEClass, Executor.class, "Executor", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
	}

} //InstantiatedPackageImpl
