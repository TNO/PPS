/**
 */
package nl.esi.pps.architecture.instantiated;

import nl.esi.pps.architecture.ArchitecturePackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * At instantiated stage the system is started, and the components are instantiated and start living in memory. 
 * Here, the runtime component takes form and is mapped on OS execution entities, i.e., on a specific thread which is mapped on specific process, etc. 
 * Communication ports are created and instantiated enabling communication among the runtime components. 
 * The OS execution entities, i.e., processes and threads are mapped on specific processing unit, with specific scheduling policies, priorities, etc.
 * 
 * [[instantiated-ecore-diagram]]
 * .Diagram of the instantiated lyfecycle stage in the architecture meta-model
 * image::{metamodelsdir}/instantiated.png[]
 * 
 * <!-- end-model-doc -->
 * @see nl.esi.pps.architecture.instantiated.InstantiatedFactory
 * @model kind="package"
 * @generated
 */
public interface InstantiatedPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "instantiated";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.esi.nl/pps/architecture/instantiated";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "architecture_instantiated";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	InstantiatedPackage eINSTANCE = nl.esi.pps.architecture.instantiated.impl.InstantiatedPackageImpl.init();

	/**
	 * The meta object id for the '{@link nl.esi.pps.architecture.instantiated.impl.ExecutorImpl <em>Executor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.architecture.instantiated.impl.ExecutorImpl
	 * @see nl.esi.pps.architecture.instantiated.impl.InstantiatedPackageImpl#getExecutor()
	 * @generated
	 */
	int EXECUTOR = 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 * @ordered
	 */
	@Deprecated
	int EXECUTOR__PROPERTIES = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTOR__NAME = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Executor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTOR_FEATURE_COUNT = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Executor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTOR_OPERATION_COUNT = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.architecture.instantiated.Executor <em>Executor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Executor</em>'.
	 * @see nl.esi.pps.architecture.instantiated.Executor
	 * @generated
	 */
	EClass getExecutor();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	InstantiatedFactory getInstantiatedFactory();

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
		 * The meta object literal for the '{@link nl.esi.pps.architecture.instantiated.impl.ExecutorImpl <em>Executor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.architecture.instantiated.impl.ExecutorImpl
		 * @see nl.esi.pps.architecture.instantiated.impl.InstantiatedPackageImpl#getExecutor()
		 * @generated
		 */
		EClass EXECUTOR = eINSTANCE.getExecutor();

	}

} //InstantiatedPackage
