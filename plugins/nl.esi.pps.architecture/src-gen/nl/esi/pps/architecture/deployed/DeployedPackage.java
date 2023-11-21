/**
 */
package nl.esi.pps.architecture.deployed;

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
 * In the Deployed lifecycle stage, the implemented software components are built and bundled into binaries. 
 * At this stage, the binaries are placed into a filesystem from where they can be installed to the different hosts.
 * The installation takes place during the transition from Deployed to Instantiated stage.
 * During this transition the binaries are mapped (installed) to specific hosts.
 * We consider for the sake of simplicity that the deployment of binaries onto hosts is static and performed before the system is initiated/started.
 * 
 * [[deployed-ecore-diagram]]
 * .Diagram of the deployed lyfecycle stage in the architecture meta-model
 * image::{metamodelsdir}/deployed.png[]
 * 
 * <!-- end-model-doc -->
 * @see nl.esi.pps.architecture.deployed.DeployedFactory
 * @model kind="package"
 * @generated
 */
public interface DeployedPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "deployed";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.esi.nl/pps/architecture/deployed";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "architecture_deployed";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DeployedPackage eINSTANCE = nl.esi.pps.architecture.deployed.impl.DeployedPackageImpl.init();

	/**
	 * The meta object id for the '{@link nl.esi.pps.architecture.deployed.impl.HostImpl <em>Host</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.architecture.deployed.impl.HostImpl
	 * @see nl.esi.pps.architecture.deployed.impl.DeployedPackageImpl#getHost()
	 * @generated
	 */
	int HOST = 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 * @ordered
	 */
	@Deprecated
	int HOST__PROPERTIES = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOST__NAME = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Host</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOST_FEATURE_COUNT = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Host</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOST_OPERATION_COUNT = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.architecture.deployed.Host <em>Host</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Host</em>'.
	 * @see nl.esi.pps.architecture.deployed.Host
	 * @generated
	 */
	EClass getHost();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DeployedFactory getDeployedFactory();

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
		 * The meta object literal for the '{@link nl.esi.pps.architecture.deployed.impl.HostImpl <em>Host</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.architecture.deployed.impl.HostImpl
		 * @see nl.esi.pps.architecture.deployed.impl.DeployedPackageImpl#getHost()
		 * @generated
		 */
		EClass HOST = eINSTANCE.getHost();

	}

} //DeployedPackage
