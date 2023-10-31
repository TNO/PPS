/**
 */
package nl.esi.pps.architecture.example;

import nl.esi.emf.properties.PropertiesPackage;

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
	 * The feature id for the '<em><b>Components</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_ARCHITECTURE__COMPONENTS = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Interfaces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_ARCHITECTURE__INTERFACES = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Functions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_ARCHITECTURE__FUNCTIONS = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Executors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_ARCHITECTURE__EXECUTORS = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Architecture</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_ARCHITECTURE_FEATURE_COUNT = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Architecture</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_ARCHITECTURE_OPERATION_COUNT = PropertiesPackage.PROPERTIES_CONTAINER_OPERATION_COUNT + 0;

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
		 * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXAMPLE_ARCHITECTURE__COMPONENTS = eINSTANCE.getExampleArchitecture_Components();

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
		 * The meta object literal for the '<em><b>Executors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXAMPLE_ARCHITECTURE__EXECUTORS = eINSTANCE.getExampleArchitecture_Executors();

	}

} //ExamplePackage
