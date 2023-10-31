/**
 */
package nl.esi.pps.architecture;

import nl.esi.emf.properties.PropertiesPackage;

import org.eclipse.emf.ecore.EAttribute;
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
 * The architecture meta-model defines the minimal set of concepts that are required to define the xref:tmsc[TMSC] meta-model.
 * The architecture package contains sub-packages that represent the lifecycle stages of an architecture as inspired by Koziolek et al.footnote:[H. Koziolek, "Performance Evaluation of Component-based Software Systems: A Survey", Elsevier, 2010.], where the author presents a view on the software component lifecycle. 
 * This study considers 4 levels of lifecycle stages: the xref:specified[specification], xref:implemented[implementation], deployment and runtime level.
 * This architecture considers an additional distinction in the runtime level, which is divided in the (runtime) xref:instantiated[instantiated] and (runtime) stimulated stage.
 * The xref:tmsc[TMSC] meta-model defines concepts that belong to the stimulated stage.
 * 
 * [[architecture-ecore-diagram]]
 * .Diagram of the architecture meta-model
 * image::{metamodelsdir}/architecture.png[]
 * 
 * 
 * 
 * <!-- end-model-doc -->
 * @see nl.esi.pps.architecture.ArchitectureFactory
 * @model kind="package"
 * @generated
 */
public interface ArchitecturePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "architecture";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.esi.nl/pps/architecture";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "architecture";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ArchitecturePackage eINSTANCE = nl.esi.pps.architecture.impl.ArchitecturePackageImpl.init();

	/**
	 * The meta object id for the '{@link nl.esi.pps.architecture.impl.NamedArchitectureElementImpl <em>Named Architecture Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.architecture.impl.NamedArchitectureElementImpl
	 * @see nl.esi.pps.architecture.impl.ArchitecturePackageImpl#getNamedArchitectureElement()
	 * @generated
	 */
	int NAMED_ARCHITECTURE_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 * @ordered
	 */
	@Deprecated
	int NAMED_ARCHITECTURE_ELEMENT__PROPERTIES = PropertiesPackage.PROPERTIES_CONTAINER__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ARCHITECTURE_ELEMENT__NAME = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Named Architecture Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ARCHITECTURE_ELEMENT_FEATURE_COUNT = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Named Architecture Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ARCHITECTURE_ELEMENT_OPERATION_COUNT = PropertiesPackage.PROPERTIES_CONTAINER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link nl.esi.pps.architecture.ArchitectureModel <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.architecture.ArchitectureModel
	 * @see nl.esi.pps.architecture.impl.ArchitecturePackageImpl#getArchitectureModel()
	 * @generated
	 */
	int ARCHITECTURE_MODEL = 1;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_MODEL_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_MODEL_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.architecture.NamedArchitectureElement <em>Named Architecture Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Architecture Element</em>'.
	 * @see nl.esi.pps.architecture.NamedArchitectureElement
	 * @generated
	 */
	EClass getNamedArchitectureElement();

	/**
	 * Returns the meta object for the attribute '{@link nl.esi.pps.architecture.NamedArchitectureElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see nl.esi.pps.architecture.NamedArchitectureElement#getName()
	 * @see #getNamedArchitectureElement()
	 * @generated
	 */
	EAttribute getNamedArchitectureElement_Name();

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.architecture.ArchitectureModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see nl.esi.pps.architecture.ArchitectureModel
	 * @generated
	 */
	EClass getArchitectureModel();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ArchitectureFactory getArchitectureFactory();

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
		 * The meta object literal for the '{@link nl.esi.pps.architecture.impl.NamedArchitectureElementImpl <em>Named Architecture Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.architecture.impl.NamedArchitectureElementImpl
		 * @see nl.esi.pps.architecture.impl.ArchitecturePackageImpl#getNamedArchitectureElement()
		 * @generated
		 */
		EClass NAMED_ARCHITECTURE_ELEMENT = eINSTANCE.getNamedArchitectureElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ARCHITECTURE_ELEMENT__NAME = eINSTANCE.getNamedArchitectureElement_Name();

		/**
		 * The meta object literal for the '{@link nl.esi.pps.architecture.ArchitectureModel <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.architecture.ArchitectureModel
		 * @see nl.esi.pps.architecture.impl.ArchitecturePackageImpl#getArchitectureModel()
		 * @generated
		 */
		EClass ARCHITECTURE_MODEL = eINSTANCE.getArchitectureModel();

	}

} //ArchitecturePackage
