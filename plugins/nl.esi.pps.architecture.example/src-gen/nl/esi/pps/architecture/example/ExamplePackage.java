/**
 */
package nl.esi.pps.architecture.example;

import nl.esi.emf.properties.PropertiesPackage;

import nl.esi.pps.architecture.ArchitecturePackage;
import nl.esi.pps.architecture.deployed.DeployedPackage;

import org.eclipse.emf.ecore.EClass;
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
 * @see nl.esi.pps.architecture.example.ExampleFactory
 * @model kind="package"
 * @generated
 */
public interface ExamplePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "example";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.esi.nl/pps/architecture/example";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "architecture_example";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExamplePackage eINSTANCE = nl.esi.pps.architecture.example.impl.ExamplePackageImpl.init();

	/**
	 * The meta object id for the '{@link nl.esi.pps.architecture.example.impl.ExampleArchitectureImpl <em>Architecture</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.architecture.example.impl.ExampleArchitectureImpl
	 * @see nl.esi.pps.architecture.example.impl.ExamplePackageImpl#getExampleArchitecture()
	 * @generated
	 */
	int EXAMPLE_ARCHITECTURE = 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 * @ordered
	 */
	@Deprecated
	int EXAMPLE_ARCHITECTURE__PROPERTIES = PropertiesPackage.PROPERTIES_CONTAINER__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Component Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_ARCHITECTURE__COMPONENT_GROUPS = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Interface Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_ARCHITECTURE__INTERFACE_GROUPS = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Function Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_ARCHITECTURE__FUNCTION_GROUPS = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Hosts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_ARCHITECTURE__HOSTS = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Components</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_ARCHITECTURE__COMPONENTS = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Interfaces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_ARCHITECTURE__INTERFACES = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Functions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_ARCHITECTURE__FUNCTIONS = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Executors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_ARCHITECTURE__EXECUTORS = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Architecture</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_ARCHITECTURE_FEATURE_COUNT = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 8;

	/**
	 * The number of operations of the '<em>Architecture</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_ARCHITECTURE_OPERATION_COUNT = PropertiesPackage.PROPERTIES_CONTAINER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link nl.esi.pps.architecture.example.impl.ExampleHostImpl <em>Host</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.architecture.example.impl.ExampleHostImpl
	 * @see nl.esi.pps.architecture.example.impl.ExamplePackageImpl#getExampleHost()
	 * @generated
	 */
	int EXAMPLE_HOST = 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 * @ordered
	 */
	@Deprecated
	int EXAMPLE_HOST__PROPERTIES = DeployedPackage.HOST__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_HOST__NAME = DeployedPackage.HOST__NAME;

	/**
	 * The feature id for the '<em><b>Executors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_HOST__EXECUTORS = DeployedPackage.HOST_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Host</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_HOST_FEATURE_COUNT = DeployedPackage.HOST_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Host</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_HOST_OPERATION_COUNT = DeployedPackage.HOST_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link nl.esi.pps.architecture.example.impl.ExampleFunctionGroupImpl <em>Function Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.architecture.example.impl.ExampleFunctionGroupImpl
	 * @see nl.esi.pps.architecture.example.impl.ExamplePackageImpl#getExampleFunctionGroup()
	 * @generated
	 */
	int EXAMPLE_FUNCTION_GROUP = 2;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 * @ordered
	 */
	@Deprecated
	int EXAMPLE_FUNCTION_GROUP__PROPERTIES = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_FUNCTION_GROUP__NAME = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Sub Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_FUNCTION_GROUP__SUB_GROUPS = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent Group</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_FUNCTION_GROUP__PARENT_GROUP = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Functions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_FUNCTION_GROUP__FUNCTIONS = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Function Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_FUNCTION_GROUP_FEATURE_COUNT = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Function Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_FUNCTION_GROUP_OPERATION_COUNT = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link nl.esi.pps.architecture.example.impl.ExampleInterfaceGroupImpl <em>Interface Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.architecture.example.impl.ExampleInterfaceGroupImpl
	 * @see nl.esi.pps.architecture.example.impl.ExamplePackageImpl#getExampleInterfaceGroup()
	 * @generated
	 */
	int EXAMPLE_INTERFACE_GROUP = 3;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 * @ordered
	 */
	@Deprecated
	int EXAMPLE_INTERFACE_GROUP__PROPERTIES = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_INTERFACE_GROUP__NAME = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Interfaces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_INTERFACE_GROUP__INTERFACES = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sub Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_INTERFACE_GROUP__SUB_GROUPS = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parent Group</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_INTERFACE_GROUP__PARENT_GROUP = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Interface Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_INTERFACE_GROUP_FEATURE_COUNT = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Interface Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_INTERFACE_GROUP_OPERATION_COUNT = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link nl.esi.pps.architecture.example.impl.ExampleComponentGroupImpl <em>Component Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.architecture.example.impl.ExampleComponentGroupImpl
	 * @see nl.esi.pps.architecture.example.impl.ExamplePackageImpl#getExampleComponentGroup()
	 * @generated
	 */
	int EXAMPLE_COMPONENT_GROUP = 4;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 * @ordered
	 */
	@Deprecated
	int EXAMPLE_COMPONENT_GROUP__PROPERTIES = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_COMPONENT_GROUP__NAME = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Components</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_COMPONENT_GROUP__COMPONENTS = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sub Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_COMPONENT_GROUP__SUB_GROUPS = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parent Group</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_COMPONENT_GROUP__PARENT_GROUP = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Component Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_COMPONENT_GROUP_FEATURE_COUNT = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Component Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_COMPONENT_GROUP_OPERATION_COUNT = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.architecture.example.ExampleArchitecture <em>Architecture</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Architecture</em>'.
	 * @see nl.esi.pps.architecture.example.ExampleArchitecture
	 * @generated
	 */
	EClass getExampleArchitecture();

	/**
	 * Returns the meta object for the containment reference list '{@link nl.esi.pps.architecture.example.ExampleArchitecture#getInterfaces <em>Interfaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Interfaces</em>'.
	 * @see nl.esi.pps.architecture.example.ExampleArchitecture#getInterfaces()
	 * @see #getExampleArchitecture()
	 * @generated
	 */
	EReference getExampleArchitecture_Interfaces();

	/**
	 * Returns the meta object for the containment reference list '{@link nl.esi.pps.architecture.example.ExampleArchitecture#getFunctions <em>Functions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Functions</em>'.
	 * @see nl.esi.pps.architecture.example.ExampleArchitecture#getFunctions()
	 * @see #getExampleArchitecture()
	 * @generated
	 */
	EReference getExampleArchitecture_Functions();

	/**
	 * Returns the meta object for the containment reference list '{@link nl.esi.pps.architecture.example.ExampleArchitecture#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Components</em>'.
	 * @see nl.esi.pps.architecture.example.ExampleArchitecture#getComponents()
	 * @see #getExampleArchitecture()
	 * @generated
	 */
	EReference getExampleArchitecture_Components();

	/**
	 * Returns the meta object for the containment reference list '{@link nl.esi.pps.architecture.example.ExampleArchitecture#getHosts <em>Hosts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Hosts</em>'.
	 * @see nl.esi.pps.architecture.example.ExampleArchitecture#getHosts()
	 * @see #getExampleArchitecture()
	 * @generated
	 */
	EReference getExampleArchitecture_Hosts();

	/**
	 * Returns the meta object for the containment reference list '{@link nl.esi.pps.architecture.example.ExampleArchitecture#getExecutors <em>Executors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Executors</em>'.
	 * @see nl.esi.pps.architecture.example.ExampleArchitecture#getExecutors()
	 * @see #getExampleArchitecture()
	 * @generated
	 */
	EReference getExampleArchitecture_Executors();

	/**
	 * Returns the meta object for the containment reference list '{@link nl.esi.pps.architecture.example.ExampleArchitecture#getFunctionGroups <em>Function Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Function Groups</em>'.
	 * @see nl.esi.pps.architecture.example.ExampleArchitecture#getFunctionGroups()
	 * @see #getExampleArchitecture()
	 * @generated
	 */
	EReference getExampleArchitecture_FunctionGroups();

	/**
	 * Returns the meta object for the containment reference list '{@link nl.esi.pps.architecture.example.ExampleArchitecture#getInterfaceGroups <em>Interface Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Interface Groups</em>'.
	 * @see nl.esi.pps.architecture.example.ExampleArchitecture#getInterfaceGroups()
	 * @see #getExampleArchitecture()
	 * @generated
	 */
	EReference getExampleArchitecture_InterfaceGroups();

	/**
	 * Returns the meta object for the containment reference list '{@link nl.esi.pps.architecture.example.ExampleArchitecture#getComponentGroups <em>Component Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Component Groups</em>'.
	 * @see nl.esi.pps.architecture.example.ExampleArchitecture#getComponentGroups()
	 * @see #getExampleArchitecture()
	 * @generated
	 */
	EReference getExampleArchitecture_ComponentGroups();

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.architecture.example.ExampleHost <em>Host</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Host</em>'.
	 * @see nl.esi.pps.architecture.example.ExampleHost
	 * @generated
	 */
	EClass getExampleHost();

	/**
	 * Returns the meta object for the containment reference list '{@link nl.esi.pps.architecture.example.ExampleHost#getExecutors <em>Executors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Executors</em>'.
	 * @see nl.esi.pps.architecture.example.ExampleHost#getExecutors()
	 * @see #getExampleHost()
	 * @generated
	 */
	EReference getExampleHost_Executors();

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.architecture.example.ExampleFunctionGroup <em>Function Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Group</em>'.
	 * @see nl.esi.pps.architecture.example.ExampleFunctionGroup
	 * @generated
	 */
	EClass getExampleFunctionGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link nl.esi.pps.architecture.example.ExampleFunctionGroup#getSubGroups <em>Sub Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Groups</em>'.
	 * @see nl.esi.pps.architecture.example.ExampleFunctionGroup#getSubGroups()
	 * @see #getExampleFunctionGroup()
	 * @generated
	 */
	EReference getExampleFunctionGroup_SubGroups();

	/**
	 * Returns the meta object for the container reference '{@link nl.esi.pps.architecture.example.ExampleFunctionGroup#getParentGroup <em>Parent Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Group</em>'.
	 * @see nl.esi.pps.architecture.example.ExampleFunctionGroup#getParentGroup()
	 * @see #getExampleFunctionGroup()
	 * @generated
	 */
	EReference getExampleFunctionGroup_ParentGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link nl.esi.pps.architecture.example.ExampleFunctionGroup#getFunctions <em>Functions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Functions</em>'.
	 * @see nl.esi.pps.architecture.example.ExampleFunctionGroup#getFunctions()
	 * @see #getExampleFunctionGroup()
	 * @generated
	 */
	EReference getExampleFunctionGroup_Functions();

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.architecture.example.ExampleInterfaceGroup <em>Interface Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface Group</em>'.
	 * @see nl.esi.pps.architecture.example.ExampleInterfaceGroup
	 * @generated
	 */
	EClass getExampleInterfaceGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link nl.esi.pps.architecture.example.ExampleInterfaceGroup#getInterfaces <em>Interfaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Interfaces</em>'.
	 * @see nl.esi.pps.architecture.example.ExampleInterfaceGroup#getInterfaces()
	 * @see #getExampleInterfaceGroup()
	 * @generated
	 */
	EReference getExampleInterfaceGroup_Interfaces();

	/**
	 * Returns the meta object for the containment reference list '{@link nl.esi.pps.architecture.example.ExampleInterfaceGroup#getSubGroups <em>Sub Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Groups</em>'.
	 * @see nl.esi.pps.architecture.example.ExampleInterfaceGroup#getSubGroups()
	 * @see #getExampleInterfaceGroup()
	 * @generated
	 */
	EReference getExampleInterfaceGroup_SubGroups();

	/**
	 * Returns the meta object for the container reference '{@link nl.esi.pps.architecture.example.ExampleInterfaceGroup#getParentGroup <em>Parent Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Group</em>'.
	 * @see nl.esi.pps.architecture.example.ExampleInterfaceGroup#getParentGroup()
	 * @see #getExampleInterfaceGroup()
	 * @generated
	 */
	EReference getExampleInterfaceGroup_ParentGroup();

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.architecture.example.ExampleComponentGroup <em>Component Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Group</em>'.
	 * @see nl.esi.pps.architecture.example.ExampleComponentGroup
	 * @generated
	 */
	EClass getExampleComponentGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link nl.esi.pps.architecture.example.ExampleComponentGroup#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Components</em>'.
	 * @see nl.esi.pps.architecture.example.ExampleComponentGroup#getComponents()
	 * @see #getExampleComponentGroup()
	 * @generated
	 */
	EReference getExampleComponentGroup_Components();

	/**
	 * Returns the meta object for the containment reference list '{@link nl.esi.pps.architecture.example.ExampleComponentGroup#getSubGroups <em>Sub Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Groups</em>'.
	 * @see nl.esi.pps.architecture.example.ExampleComponentGroup#getSubGroups()
	 * @see #getExampleComponentGroup()
	 * @generated
	 */
	EReference getExampleComponentGroup_SubGroups();

	/**
	 * Returns the meta object for the container reference '{@link nl.esi.pps.architecture.example.ExampleComponentGroup#getParentGroup <em>Parent Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Group</em>'.
	 * @see nl.esi.pps.architecture.example.ExampleComponentGroup#getParentGroup()
	 * @see #getExampleComponentGroup()
	 * @generated
	 */
	EReference getExampleComponentGroup_ParentGroup();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExampleFactory getExampleFactory();

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
		 * The meta object literal for the '{@link nl.esi.pps.architecture.example.impl.ExampleArchitectureImpl <em>Architecture</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.architecture.example.impl.ExampleArchitectureImpl
		 * @see nl.esi.pps.architecture.example.impl.ExamplePackageImpl#getExampleArchitecture()
		 * @generated
		 */
		EClass EXAMPLE_ARCHITECTURE = eINSTANCE.getExampleArchitecture();

		/**
		 * The meta object literal for the '<em><b>Interfaces</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXAMPLE_ARCHITECTURE__INTERFACES = eINSTANCE.getExampleArchitecture_Interfaces();

		/**
		 * The meta object literal for the '<em><b>Functions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXAMPLE_ARCHITECTURE__FUNCTIONS = eINSTANCE.getExampleArchitecture_Functions();

		/**
		 * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXAMPLE_ARCHITECTURE__COMPONENTS = eINSTANCE.getExampleArchitecture_Components();

		/**
		 * The meta object literal for the '<em><b>Hosts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXAMPLE_ARCHITECTURE__HOSTS = eINSTANCE.getExampleArchitecture_Hosts();

		/**
		 * The meta object literal for the '<em><b>Executors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXAMPLE_ARCHITECTURE__EXECUTORS = eINSTANCE.getExampleArchitecture_Executors();

		/**
		 * The meta object literal for the '<em><b>Function Groups</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXAMPLE_ARCHITECTURE__FUNCTION_GROUPS = eINSTANCE.getExampleArchitecture_FunctionGroups();

		/**
		 * The meta object literal for the '<em><b>Interface Groups</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXAMPLE_ARCHITECTURE__INTERFACE_GROUPS = eINSTANCE.getExampleArchitecture_InterfaceGroups();

		/**
		 * The meta object literal for the '<em><b>Component Groups</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXAMPLE_ARCHITECTURE__COMPONENT_GROUPS = eINSTANCE.getExampleArchitecture_ComponentGroups();

		/**
		 * The meta object literal for the '{@link nl.esi.pps.architecture.example.impl.ExampleHostImpl <em>Host</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.architecture.example.impl.ExampleHostImpl
		 * @see nl.esi.pps.architecture.example.impl.ExamplePackageImpl#getExampleHost()
		 * @generated
		 */
		EClass EXAMPLE_HOST = eINSTANCE.getExampleHost();

		/**
		 * The meta object literal for the '<em><b>Executors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXAMPLE_HOST__EXECUTORS = eINSTANCE.getExampleHost_Executors();

		/**
		 * The meta object literal for the '{@link nl.esi.pps.architecture.example.impl.ExampleFunctionGroupImpl <em>Function Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.architecture.example.impl.ExampleFunctionGroupImpl
		 * @see nl.esi.pps.architecture.example.impl.ExamplePackageImpl#getExampleFunctionGroup()
		 * @generated
		 */
		EClass EXAMPLE_FUNCTION_GROUP = eINSTANCE.getExampleFunctionGroup();

		/**
		 * The meta object literal for the '<em><b>Sub Groups</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXAMPLE_FUNCTION_GROUP__SUB_GROUPS = eINSTANCE.getExampleFunctionGroup_SubGroups();

		/**
		 * The meta object literal for the '<em><b>Parent Group</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXAMPLE_FUNCTION_GROUP__PARENT_GROUP = eINSTANCE.getExampleFunctionGroup_ParentGroup();

		/**
		 * The meta object literal for the '<em><b>Functions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXAMPLE_FUNCTION_GROUP__FUNCTIONS = eINSTANCE.getExampleFunctionGroup_Functions();

		/**
		 * The meta object literal for the '{@link nl.esi.pps.architecture.example.impl.ExampleInterfaceGroupImpl <em>Interface Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.architecture.example.impl.ExampleInterfaceGroupImpl
		 * @see nl.esi.pps.architecture.example.impl.ExamplePackageImpl#getExampleInterfaceGroup()
		 * @generated
		 */
		EClass EXAMPLE_INTERFACE_GROUP = eINSTANCE.getExampleInterfaceGroup();

		/**
		 * The meta object literal for the '<em><b>Interfaces</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXAMPLE_INTERFACE_GROUP__INTERFACES = eINSTANCE.getExampleInterfaceGroup_Interfaces();

		/**
		 * The meta object literal for the '<em><b>Sub Groups</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXAMPLE_INTERFACE_GROUP__SUB_GROUPS = eINSTANCE.getExampleInterfaceGroup_SubGroups();

		/**
		 * The meta object literal for the '<em><b>Parent Group</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXAMPLE_INTERFACE_GROUP__PARENT_GROUP = eINSTANCE.getExampleInterfaceGroup_ParentGroup();

		/**
		 * The meta object literal for the '{@link nl.esi.pps.architecture.example.impl.ExampleComponentGroupImpl <em>Component Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.architecture.example.impl.ExampleComponentGroupImpl
		 * @see nl.esi.pps.architecture.example.impl.ExamplePackageImpl#getExampleComponentGroup()
		 * @generated
		 */
		EClass EXAMPLE_COMPONENT_GROUP = eINSTANCE.getExampleComponentGroup();

		/**
		 * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXAMPLE_COMPONENT_GROUP__COMPONENTS = eINSTANCE.getExampleComponentGroup_Components();

		/**
		 * The meta object literal for the '<em><b>Sub Groups</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXAMPLE_COMPONENT_GROUP__SUB_GROUPS = eINSTANCE.getExampleComponentGroup_SubGroups();

		/**
		 * The meta object literal for the '<em><b>Parent Group</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXAMPLE_COMPONENT_GROUP__PARENT_GROUP = eINSTANCE.getExampleComponentGroup_ParentGroup();

	}

} //ExamplePackage
