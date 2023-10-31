/**
 */
package nl.esi.pps.architecture.implemented;

import nl.esi.pps.architecture.ArchitecturePackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * In the Implementation lifecycle stage, the specified software components and interfaces are implemented. 
 * Depending on the software architecture, as well as the execution platform, a component may have more than one implementation, which may be related to a specific execution platform (i.e., programming language, type of processing unit, etc.) or other factors (i.e., quality of service, etc.)
 * 
 * [[implemented-ecore-diagram]]
 * .Diagram of the implemented lyfecycle stage in the architecture meta-model
 * image::{metamodelsdir}/implemented.png[]
 * 
 * <!-- end-model-doc -->
 * @see nl.esi.pps.architecture.implemented.ImplementedFactory
 * @model kind="package"
 * @generated
 */
public interface ImplementedPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "implemented";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.esi.nl/pps/architecture/implemented";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "architecture_implemented";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ImplementedPackage eINSTANCE = nl.esi.pps.architecture.implemented.impl.ImplementedPackageImpl.init();

	/**
	 * The meta object id for the '{@link nl.esi.pps.architecture.implemented.impl.FunctionImpl <em>Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.architecture.implemented.impl.FunctionImpl
	 * @see nl.esi.pps.architecture.implemented.impl.ImplementedPackageImpl#getFunction()
	 * @generated
	 */
	int FUNCTION = 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 * @ordered
	 */
	@Deprecated
	int FUNCTION__PROPERTIES = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__NAME = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__OPERATION = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__PARAMETERS = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_FEATURE_COUNT = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_OPERATION_COUNT = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link nl.esi.pps.architecture.implemented.impl.IPCFunctionImpl <em>IPC Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.architecture.implemented.impl.IPCFunctionImpl
	 * @see nl.esi.pps.architecture.implemented.impl.ImplementedPackageImpl#getIPCFunction()
	 * @generated
	 */
	int IPC_FUNCTION = 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 * @ordered
	 */
	@Deprecated
	int IPC_FUNCTION__PROPERTIES = FUNCTION__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPC_FUNCTION__NAME = FUNCTION__NAME;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPC_FUNCTION__OPERATION = FUNCTION__OPERATION;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPC_FUNCTION__PARAMETERS = FUNCTION__PARAMETERS;

	/**
	 * The number of structural features of the '<em>IPC Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPC_FUNCTION_FEATURE_COUNT = FUNCTION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Operation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPC_FUNCTION___GET_OPERATION = FUNCTION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>IPC Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPC_FUNCTION_OPERATION_COUNT = FUNCTION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link nl.esi.pps.architecture.implemented.impl.IPCClientFunctionImpl <em>IPC Client Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.architecture.implemented.impl.IPCClientFunctionImpl
	 * @see nl.esi.pps.architecture.implemented.impl.ImplementedPackageImpl#getIPCClientFunction()
	 * @generated
	 */
	int IPC_CLIENT_FUNCTION = 2;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 * @ordered
	 */
	@Deprecated
	int IPC_CLIENT_FUNCTION__PROPERTIES = IPC_FUNCTION__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPC_CLIENT_FUNCTION__NAME = IPC_FUNCTION__NAME;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPC_CLIENT_FUNCTION__OPERATION = IPC_FUNCTION__OPERATION;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPC_CLIENT_FUNCTION__PARAMETERS = IPC_FUNCTION__PARAMETERS;

	/**
	 * The number of structural features of the '<em>IPC Client Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPC_CLIENT_FUNCTION_FEATURE_COUNT = IPC_FUNCTION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Operation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPC_CLIENT_FUNCTION___GET_OPERATION = IPC_FUNCTION___GET_OPERATION;

	/**
	 * The number of operations of the '<em>IPC Client Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPC_CLIENT_FUNCTION_OPERATION_COUNT = IPC_FUNCTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link nl.esi.pps.architecture.implemented.impl.IPCServerFunctionImpl <em>IPC Server Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.architecture.implemented.impl.IPCServerFunctionImpl
	 * @see nl.esi.pps.architecture.implemented.impl.ImplementedPackageImpl#getIPCServerFunction()
	 * @generated
	 */
	int IPC_SERVER_FUNCTION = 3;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 * @ordered
	 */
	@Deprecated
	int IPC_SERVER_FUNCTION__PROPERTIES = IPC_FUNCTION__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPC_SERVER_FUNCTION__NAME = IPC_FUNCTION__NAME;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPC_SERVER_FUNCTION__OPERATION = IPC_FUNCTION__OPERATION;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPC_SERVER_FUNCTION__PARAMETERS = IPC_FUNCTION__PARAMETERS;

	/**
	 * The number of structural features of the '<em>IPC Server Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPC_SERVER_FUNCTION_FEATURE_COUNT = IPC_FUNCTION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Operation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPC_SERVER_FUNCTION___GET_OPERATION = IPC_FUNCTION___GET_OPERATION;

	/**
	 * The number of operations of the '<em>IPC Server Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPC_SERVER_FUNCTION_OPERATION_COUNT = IPC_FUNCTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link nl.esi.pps.architecture.implemented.impl.FunctionParameterImpl <em>Function Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.architecture.implemented.impl.FunctionParameterImpl
	 * @see nl.esi.pps.architecture.implemented.impl.ImplementedPackageImpl#getFunctionParameter()
	 * @generated
	 */
	int FUNCTION_PARAMETER = 4;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 * @ordered
	 */
	@Deprecated
	int FUNCTION_PARAMETER__PROPERTIES = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PARAMETER__NAME = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Function</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PARAMETER__FUNCTION = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PARAMETER__KIND = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Function Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PARAMETER_FEATURE_COUNT = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Function Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PARAMETER_OPERATION_COUNT = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link nl.esi.pps.architecture.implemented.FunctionParameterKind <em>Function Parameter Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.architecture.implemented.FunctionParameterKind
	 * @see nl.esi.pps.architecture.implemented.impl.ImplementedPackageImpl#getFunctionParameterKind()
	 * @generated
	 */
	int FUNCTION_PARAMETER_KIND = 5;

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.architecture.implemented.Function <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function</em>'.
	 * @see nl.esi.pps.architecture.implemented.Function
	 * @generated
	 */
	EClass getFunction();

	/**
	 * Returns the meta object for the reference '{@link nl.esi.pps.architecture.implemented.Function#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operation</em>'.
	 * @see nl.esi.pps.architecture.implemented.Function#getOperation()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_Operation();

	/**
	 * Returns the meta object for the containment reference list '{@link nl.esi.pps.architecture.implemented.Function#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see nl.esi.pps.architecture.implemented.Function#getParameters()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_Parameters();

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.architecture.implemented.IPCFunction <em>IPC Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IPC Function</em>'.
	 * @see nl.esi.pps.architecture.implemented.IPCFunction
	 * @generated
	 */
	EClass getIPCFunction();

	/**
	 * Returns the meta object for the '{@link nl.esi.pps.architecture.implemented.IPCFunction#getOperation() <em>Get Operation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Operation</em>' operation.
	 * @see nl.esi.pps.architecture.implemented.IPCFunction#getOperation()
	 * @generated
	 */
	EOperation getIPCFunction__GetOperation();

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.architecture.implemented.IPCClientFunction <em>IPC Client Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IPC Client Function</em>'.
	 * @see nl.esi.pps.architecture.implemented.IPCClientFunction
	 * @generated
	 */
	EClass getIPCClientFunction();

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.architecture.implemented.IPCServerFunction <em>IPC Server Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IPC Server Function</em>'.
	 * @see nl.esi.pps.architecture.implemented.IPCServerFunction
	 * @generated
	 */
	EClass getIPCServerFunction();

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.architecture.implemented.FunctionParameter <em>Function Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Parameter</em>'.
	 * @see nl.esi.pps.architecture.implemented.FunctionParameter
	 * @generated
	 */
	EClass getFunctionParameter();

	/**
	 * Returns the meta object for the container reference '{@link nl.esi.pps.architecture.implemented.FunctionParameter#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Function</em>'.
	 * @see nl.esi.pps.architecture.implemented.FunctionParameter#getFunction()
	 * @see #getFunctionParameter()
	 * @generated
	 */
	EReference getFunctionParameter_Function();

	/**
	 * Returns the meta object for the attribute '{@link nl.esi.pps.architecture.implemented.FunctionParameter#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see nl.esi.pps.architecture.implemented.FunctionParameter#getKind()
	 * @see #getFunctionParameter()
	 * @generated
	 */
	EAttribute getFunctionParameter_Kind();

	/**
	 * Returns the meta object for enum '{@link nl.esi.pps.architecture.implemented.FunctionParameterKind <em>Function Parameter Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Function Parameter Kind</em>'.
	 * @see nl.esi.pps.architecture.implemented.FunctionParameterKind
	 * @generated
	 */
	EEnum getFunctionParameterKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ImplementedFactory getImplementedFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link nl.esi.pps.architecture.implemented.impl.FunctionImpl <em>Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.architecture.implemented.impl.FunctionImpl
		 * @see nl.esi.pps.architecture.implemented.impl.ImplementedPackageImpl#getFunction()
		 * @generated
		 */
		EClass FUNCTION = eINSTANCE.getFunction();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__OPERATION = eINSTANCE.getFunction_Operation();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__PARAMETERS = eINSTANCE.getFunction_Parameters();

		/**
		 * The meta object literal for the '{@link nl.esi.pps.architecture.implemented.impl.IPCFunctionImpl <em>IPC Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.architecture.implemented.impl.IPCFunctionImpl
		 * @see nl.esi.pps.architecture.implemented.impl.ImplementedPackageImpl#getIPCFunction()
		 * @generated
		 */
		EClass IPC_FUNCTION = eINSTANCE.getIPCFunction();

		/**
		 * The meta object literal for the '<em><b>Get Operation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IPC_FUNCTION___GET_OPERATION = eINSTANCE.getIPCFunction__GetOperation();

		/**
		 * The meta object literal for the '{@link nl.esi.pps.architecture.implemented.impl.IPCClientFunctionImpl <em>IPC Client Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.architecture.implemented.impl.IPCClientFunctionImpl
		 * @see nl.esi.pps.architecture.implemented.impl.ImplementedPackageImpl#getIPCClientFunction()
		 * @generated
		 */
		EClass IPC_CLIENT_FUNCTION = eINSTANCE.getIPCClientFunction();

		/**
		 * The meta object literal for the '{@link nl.esi.pps.architecture.implemented.impl.IPCServerFunctionImpl <em>IPC Server Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.architecture.implemented.impl.IPCServerFunctionImpl
		 * @see nl.esi.pps.architecture.implemented.impl.ImplementedPackageImpl#getIPCServerFunction()
		 * @generated
		 */
		EClass IPC_SERVER_FUNCTION = eINSTANCE.getIPCServerFunction();

		/**
		 * The meta object literal for the '{@link nl.esi.pps.architecture.implemented.impl.FunctionParameterImpl <em>Function Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.architecture.implemented.impl.FunctionParameterImpl
		 * @see nl.esi.pps.architecture.implemented.impl.ImplementedPackageImpl#getFunctionParameter()
		 * @generated
		 */
		EClass FUNCTION_PARAMETER = eINSTANCE.getFunctionParameter();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_PARAMETER__FUNCTION = eINSTANCE.getFunctionParameter_Function();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION_PARAMETER__KIND = eINSTANCE.getFunctionParameter_Kind();

		/**
		 * The meta object literal for the '{@link nl.esi.pps.architecture.implemented.FunctionParameterKind <em>Function Parameter Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.architecture.implemented.FunctionParameterKind
		 * @see nl.esi.pps.architecture.implemented.impl.ImplementedPackageImpl#getFunctionParameterKind()
		 * @generated
		 */
		EEnum FUNCTION_PARAMETER_KIND = eINSTANCE.getFunctionParameterKind();

	}

} //ImplementedPackage
