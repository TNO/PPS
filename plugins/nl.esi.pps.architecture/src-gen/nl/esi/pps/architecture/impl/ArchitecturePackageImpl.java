/**
 */
package nl.esi.pps.architecture.impl;

import nl.esi.emf.properties.PropertiesPackage;

import nl.esi.pps.architecture.ArchitectureFactory;
import nl.esi.pps.architecture.ArchitectureModel;
import nl.esi.pps.architecture.ArchitecturePackage;
import nl.esi.pps.architecture.NamedArchitectureElement;

import nl.esi.pps.architecture.deployed.DeployedPackage;

import nl.esi.pps.architecture.deployed.impl.DeployedPackageImpl;

import nl.esi.pps.architecture.implemented.ImplementedPackage;

import nl.esi.pps.architecture.implemented.impl.ImplementedPackageImpl;

import nl.esi.pps.architecture.instantiated.InstantiatedPackage;

import nl.esi.pps.architecture.instantiated.impl.InstantiatedPackageImpl;

import nl.esi.pps.architecture.specified.SpecifiedPackage;

import nl.esi.pps.architecture.specified.impl.SpecifiedPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ArchitecturePackageImpl extends EPackageImpl implements ArchitecturePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedArchitectureElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass architectureModelEClass = null;

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
	 * @see nl.esi.pps.architecture.ArchitecturePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ArchitecturePackageImpl() {
		super(eNS_URI, ArchitectureFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ArchitecturePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ArchitecturePackage init() {
		if (isInited)
			return (ArchitecturePackage) EPackage.Registry.INSTANCE.getEPackage(ArchitecturePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredArchitecturePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ArchitecturePackageImpl theArchitecturePackage = registeredArchitecturePackage instanceof ArchitecturePackageImpl
				? (ArchitecturePackageImpl) registeredArchitecturePackage
				: new ArchitecturePackageImpl();

		isInited = true;

		// Initialize simple dependencies
		PropertiesPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(SpecifiedPackage.eNS_URI);
		SpecifiedPackageImpl theSpecifiedPackage = (SpecifiedPackageImpl) (registeredPackage instanceof SpecifiedPackageImpl
				? registeredPackage
				: SpecifiedPackage.eINSTANCE);
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
		theArchitecturePackage.createPackageContents();
		theSpecifiedPackage.createPackageContents();
		theImplementedPackage.createPackageContents();
		theInstantiatedPackage.createPackageContents();
		theDeployedPackage.createPackageContents();

		// Initialize created meta-data
		theArchitecturePackage.initializePackageContents();
		theSpecifiedPackage.initializePackageContents();
		theImplementedPackage.initializePackageContents();
		theInstantiatedPackage.initializePackageContents();
		theDeployedPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theArchitecturePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ArchitecturePackage.eNS_URI, theArchitecturePackage);
		return theArchitecturePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNamedArchitectureElement() {
		return namedArchitectureElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNamedArchitectureElement_Name() {
		return (EAttribute) namedArchitectureElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getArchitectureModel() {
		return architectureModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ArchitectureFactory getArchitectureFactory() {
		return (ArchitectureFactory) getEFactoryInstance();
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
		namedArchitectureElementEClass = createEClass(NAMED_ARCHITECTURE_ELEMENT);
		createEAttribute(namedArchitectureElementEClass, NAMED_ARCHITECTURE_ELEMENT__NAME);

		architectureModelEClass = createEClass(ARCHITECTURE_MODEL);
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
		SpecifiedPackage theSpecifiedPackage = (SpecifiedPackage) EPackage.Registry.INSTANCE
				.getEPackage(SpecifiedPackage.eNS_URI);
		ImplementedPackage theImplementedPackage = (ImplementedPackage) EPackage.Registry.INSTANCE
				.getEPackage(ImplementedPackage.eNS_URI);
		InstantiatedPackage theInstantiatedPackage = (InstantiatedPackage) EPackage.Registry.INSTANCE
				.getEPackage(InstantiatedPackage.eNS_URI);
		DeployedPackage theDeployedPackage = (DeployedPackage) EPackage.Registry.INSTANCE
				.getEPackage(DeployedPackage.eNS_URI);
		PropertiesPackage thePropertiesPackage = (PropertiesPackage) EPackage.Registry.INSTANCE
				.getEPackage(PropertiesPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theSpecifiedPackage);
		getESubpackages().add(theImplementedPackage);
		getESubpackages().add(theInstantiatedPackage);
		getESubpackages().add(theDeployedPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		namedArchitectureElementEClass.getESuperTypes().add(thePropertiesPackage.getPropertiesContainer());

		// Initialize classes, features, and operations; add parameters
		initEClass(namedArchitectureElementEClass, NamedArchitectureElement.class, "NamedArchitectureElement",
				IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedArchitectureElement_Name(), ecorePackage.getEString(), "name", null, 0, 1,
				NamedArchitectureElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(architectureModelEClass, ArchitectureModel.class, "ArchitectureModel", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ArchitecturePackageImpl
