/**
 */
package nl.esi.pps.architecture.specified;

import nl.esi.pps.architecture.ArchitecturePackage;

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
 * <!-- begin-model-doc -->
 * In this lifecycle stage, the specification of the software components takes place. 
 * Provided and required interfaces describe the contracts between the software components and encode the service specification. 
 * At this stage, the software interfaces are also specified by bundling operations that each of those implements.
 * 
 * [[specified-ecore-diagram]]
 * .Diagram of the specified lyfecycle stage in the architecture meta-model
 * image::{metamodelsdir}/specified.png[]
 * 
 * <!-- end-model-doc -->
 * @see nl.esi.pps.architecture.specified.SpecifiedFactory
 * @model kind="package"
 * @generated
 */
public interface SpecifiedPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "specified";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.esi.nl/pps/architecture/specified";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "architecture_specified";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SpecifiedPackage eINSTANCE = nl.esi.pps.architecture.specified.impl.SpecifiedPackageImpl.init();

	/**
	 * The meta object id for the '{@link nl.esi.pps.architecture.specified.impl.ComponentImpl <em>Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.architecture.specified.impl.ComponentImpl
	 * @see nl.esi.pps.architecture.specified.impl.SpecifiedPackageImpl#getComponent()
	 * @generated
	 */
	int COMPONENT = 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 * @ordered
	 */
	@Deprecated
	int COMPONENT__PROPERTIES = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__NAME = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Required Interfaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__REQUIRED_INTERFACES = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Provided Interfaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__PROVIDED_INTERFACES = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FEATURE_COUNT = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_OPERATION_COUNT = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link nl.esi.pps.architecture.specified.impl.InterfaceImpl <em>Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.architecture.specified.impl.InterfaceImpl
	 * @see nl.esi.pps.architecture.specified.impl.SpecifiedPackageImpl#getInterface()
	 * @generated
	 */
	int INTERFACE = 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 * @ordered
	 */
	@Deprecated
	int INTERFACE__PROPERTIES = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__NAME = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__REQUIRED_BY = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Provided By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__PROVIDED_BY = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__OPERATIONS = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_FEATURE_COUNT = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_OPERATION_COUNT = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link nl.esi.pps.architecture.specified.impl.OperationImpl <em>Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.architecture.specified.impl.OperationImpl
	 * @see nl.esi.pps.architecture.specified.impl.SpecifiedPackageImpl#getOperation()
	 * @generated
	 */
	int OPERATION = 2;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 * @ordered
	 */
	@Deprecated
	int OPERATION__PROPERTIES = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__NAME = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__INTERFACE = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_FEATURE_COUNT = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_OPERATION_COUNT = ArchitecturePackage.NAMED_ARCHITECTURE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.architecture.specified.Component <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component</em>'.
	 * @see nl.esi.pps.architecture.specified.Component
	 * @generated
	 */
	EClass getComponent();

	/**
	 * Returns the meta object for the reference list '{@link nl.esi.pps.architecture.specified.Component#getRequiredInterfaces <em>Required Interfaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Required Interfaces</em>'.
	 * @see nl.esi.pps.architecture.specified.Component#getRequiredInterfaces()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_RequiredInterfaces();

	/**
	 * Returns the meta object for the reference list '{@link nl.esi.pps.architecture.specified.Component#getProvidedInterfaces <em>Provided Interfaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Provided Interfaces</em>'.
	 * @see nl.esi.pps.architecture.specified.Component#getProvidedInterfaces()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_ProvidedInterfaces();

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.architecture.specified.Interface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface</em>'.
	 * @see nl.esi.pps.architecture.specified.Interface
	 * @generated
	 */
	EClass getInterface();

	/**
	 * Returns the meta object for the reference list '{@link nl.esi.pps.architecture.specified.Interface#getRequiredBy <em>Required By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Required By</em>'.
	 * @see nl.esi.pps.architecture.specified.Interface#getRequiredBy()
	 * @see #getInterface()
	 * @generated
	 */
	EReference getInterface_RequiredBy();

	/**
	 * Returns the meta object for the reference list '{@link nl.esi.pps.architecture.specified.Interface#getProvidedBy <em>Provided By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Provided By</em>'.
	 * @see nl.esi.pps.architecture.specified.Interface#getProvidedBy()
	 * @see #getInterface()
	 * @generated
	 */
	EReference getInterface_ProvidedBy();

	/**
	 * Returns the meta object for the containment reference list '{@link nl.esi.pps.architecture.specified.Interface#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operations</em>'.
	 * @see nl.esi.pps.architecture.specified.Interface#getOperations()
	 * @see #getInterface()
	 * @generated
	 */
	EReference getInterface_Operations();

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.architecture.specified.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation</em>'.
	 * @see nl.esi.pps.architecture.specified.Operation
	 * @generated
	 */
	EClass getOperation();

	/**
	 * Returns the meta object for the container reference '{@link nl.esi.pps.architecture.specified.Operation#getInterface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Interface</em>'.
	 * @see nl.esi.pps.architecture.specified.Operation#getInterface()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Interface();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SpecifiedFactory getSpecifiedFactory();

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
		 * The meta object literal for the '{@link nl.esi.pps.architecture.specified.impl.ComponentImpl <em>Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.architecture.specified.impl.ComponentImpl
		 * @see nl.esi.pps.architecture.specified.impl.SpecifiedPackageImpl#getComponent()
		 * @generated
		 */
		EClass COMPONENT = eINSTANCE.getComponent();

		/**
		 * The meta object literal for the '<em><b>Required Interfaces</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__REQUIRED_INTERFACES = eINSTANCE.getComponent_RequiredInterfaces();

		/**
		 * The meta object literal for the '<em><b>Provided Interfaces</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__PROVIDED_INTERFACES = eINSTANCE.getComponent_ProvidedInterfaces();

		/**
		 * The meta object literal for the '{@link nl.esi.pps.architecture.specified.impl.InterfaceImpl <em>Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.architecture.specified.impl.InterfaceImpl
		 * @see nl.esi.pps.architecture.specified.impl.SpecifiedPackageImpl#getInterface()
		 * @generated
		 */
		EClass INTERFACE = eINSTANCE.getInterface();

		/**
		 * The meta object literal for the '<em><b>Required By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE__REQUIRED_BY = eINSTANCE.getInterface_RequiredBy();

		/**
		 * The meta object literal for the '<em><b>Provided By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE__PROVIDED_BY = eINSTANCE.getInterface_ProvidedBy();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE__OPERATIONS = eINSTANCE.getInterface_Operations();

		/**
		 * The meta object literal for the '{@link nl.esi.pps.architecture.specified.impl.OperationImpl <em>Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.architecture.specified.impl.OperationImpl
		 * @see nl.esi.pps.architecture.specified.impl.SpecifiedPackageImpl#getOperation()
		 * @generated
		 */
		EClass OPERATION = eINSTANCE.getOperation();

		/**
		 * The meta object literal for the '<em><b>Interface</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__INTERFACE = eINSTANCE.getOperation_Interface();

	}

} //SpecifiedPackage
