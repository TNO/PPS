/**
 */
package nl.esi.pps.architecture.implemented.impl;

import nl.esi.emf.properties.PropertiesPackage;

import nl.esi.pps.architecture.ArchitecturePackage;

import nl.esi.pps.architecture.deployed.DeployedPackage;

import nl.esi.pps.architecture.deployed.impl.DeployedPackageImpl;

import nl.esi.pps.architecture.impl.ArchitecturePackageImpl;

import nl.esi.pps.architecture.implemented.Function;
import nl.esi.pps.architecture.implemented.FunctionParameter;
import nl.esi.pps.architecture.implemented.FunctionParameterKind;
import nl.esi.pps.architecture.implemented.IPCClientFunction;
import nl.esi.pps.architecture.implemented.IPCFunction;
import nl.esi.pps.architecture.implemented.IPCServerFunction;
import nl.esi.pps.architecture.implemented.ImplementedFactory;
import nl.esi.pps.architecture.implemented.ImplementedPackage;

import nl.esi.pps.architecture.instantiated.InstantiatedPackage;

import nl.esi.pps.architecture.instantiated.impl.InstantiatedPackageImpl;

import nl.esi.pps.architecture.specified.SpecifiedPackage;

import nl.esi.pps.architecture.specified.impl.SpecifiedPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ImplementedPackageImpl extends EPackageImpl implements ImplementedPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ipcFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ipcClientFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ipcServerFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum functionParameterKindEEnum = null;

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
	 * @see nl.esi.pps.architecture.implemented.ImplementedPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ImplementedPackageImpl() {
		super(eNS_URI, ImplementedFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ImplementedPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ImplementedPackage init() {
		if (isInited)
			return (ImplementedPackage) EPackage.Registry.INSTANCE.getEPackage(ImplementedPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredImplementedPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ImplementedPackageImpl theImplementedPackage = registeredImplementedPackage instanceof ImplementedPackageImpl
				? (ImplementedPackageImpl) registeredImplementedPackage
				: new ImplementedPackageImpl();

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
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(InstantiatedPackage.eNS_URI);
		InstantiatedPackageImpl theInstantiatedPackage = (InstantiatedPackageImpl) (registeredPackage instanceof InstantiatedPackageImpl
				? registeredPackage
				: InstantiatedPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(DeployedPackage.eNS_URI);
		DeployedPackageImpl theDeployedPackage = (DeployedPackageImpl) (registeredPackage instanceof DeployedPackageImpl
				? registeredPackage
				: DeployedPackage.eINSTANCE);

		// Create package meta-data objects
		theImplementedPackage.createPackageContents();
		theArchitecturePackage.createPackageContents();
		theSpecifiedPackage.createPackageContents();
		theInstantiatedPackage.createPackageContents();
		theDeployedPackage.createPackageContents();

		// Initialize created meta-data
		theImplementedPackage.initializePackageContents();
		theArchitecturePackage.initializePackageContents();
		theSpecifiedPackage.initializePackageContents();
		theInstantiatedPackage.initializePackageContents();
		theDeployedPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theImplementedPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ImplementedPackage.eNS_URI, theImplementedPackage);
		return theImplementedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFunction() {
		return functionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFunction_Operation() {
		return (EReference) functionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFunction_Parameters() {
		return (EReference) functionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIPCFunction() {
		return ipcFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getIPCFunction__GetOperation() {
		return ipcFunctionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIPCClientFunction() {
		return ipcClientFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIPCServerFunction() {
		return ipcServerFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFunctionParameter() {
		return functionParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFunctionParameter_Function() {
		return (EReference) functionParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFunctionParameter_Kind() {
		return (EAttribute) functionParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getFunctionParameterKind() {
		return functionParameterKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImplementedFactory getImplementedFactory() {
		return (ImplementedFactory) getEFactoryInstance();
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
		functionEClass = createEClass(FUNCTION);
		createEReference(functionEClass, FUNCTION__OPERATION);
		createEReference(functionEClass, FUNCTION__PARAMETERS);

		ipcFunctionEClass = createEClass(IPC_FUNCTION);
		createEOperation(ipcFunctionEClass, IPC_FUNCTION___GET_OPERATION);

		ipcClientFunctionEClass = createEClass(IPC_CLIENT_FUNCTION);

		ipcServerFunctionEClass = createEClass(IPC_SERVER_FUNCTION);

		functionParameterEClass = createEClass(FUNCTION_PARAMETER);
		createEReference(functionParameterEClass, FUNCTION_PARAMETER__FUNCTION);
		createEAttribute(functionParameterEClass, FUNCTION_PARAMETER__KIND);

		// Create enums
		functionParameterKindEEnum = createEEnum(FUNCTION_PARAMETER_KIND);
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
		SpecifiedPackage theSpecifiedPackage = (SpecifiedPackage) EPackage.Registry.INSTANCE
				.getEPackage(SpecifiedPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		functionEClass.getESuperTypes().add(theArchitecturePackage.getNamedArchitectureElement());
		ipcFunctionEClass.getESuperTypes().add(this.getFunction());
		ipcClientFunctionEClass.getESuperTypes().add(this.getIPCFunction());
		ipcServerFunctionEClass.getESuperTypes().add(this.getIPCFunction());
		functionParameterEClass.getESuperTypes().add(theArchitecturePackage.getNamedArchitectureElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(functionEClass, Function.class, "Function", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunction_Operation(), theSpecifiedPackage.getOperation(), null, "operation", null, 0, 1,
				Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunction_Parameters(), this.getFunctionParameter(), this.getFunctionParameter_Function(),
				"parameters", null, 0, -1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ipcFunctionEClass, IPCFunction.class, "IPCFunction", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getIPCFunction__GetOperation(), theSpecifiedPackage.getOperation(), "getOperation", 1, 1,
				IS_UNIQUE, IS_ORDERED);

		initEClass(ipcClientFunctionEClass, IPCClientFunction.class, "IPCClientFunction", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(ipcServerFunctionEClass, IPCServerFunction.class, "IPCServerFunction", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(functionParameterEClass, FunctionParameter.class, "FunctionParameter", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunctionParameter_Function(), this.getFunction(), this.getFunction_Parameters(), "function",
				null, 1, 1, FunctionParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFunctionParameter_Kind(), this.getFunctionParameterKind(), "kind", null, 1, 1,
				FunctionParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(functionParameterKindEEnum, FunctionParameterKind.class, "FunctionParameterKind");
		addEEnumLiteral(functionParameterKindEEnum, FunctionParameterKind.IN);
		addEEnumLiteral(functionParameterKindEEnum, FunctionParameterKind.OUT);
		addEEnumLiteral(functionParameterKindEEnum, FunctionParameterKind.IN_OUT);
		addEEnumLiteral(functionParameterKindEEnum, FunctionParameterKind.RETURN);
	}

} //ImplementedPackageImpl
