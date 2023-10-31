/**
 */
package nl.esi.emf.properties;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * [[properties-ecore-diagram]]
 * .Diagram of the properties meta-model
 * image::{metamodelsdir}/properties.png[]
 * 
 * <!-- end-model-doc -->
 * @see nl.esi.emf.properties.PropertiesFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore conversionDelegates='bundle:/nl.esi.emf.properties/nl.esi.emf.properties.util.EPropertyValueConversionDelegate$Factory'"
 * @generated
 */
public interface PropertiesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "properties";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.esi.nl/properties";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "properties";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PropertiesPackage eINSTANCE = nl.esi.emf.properties.impl.PropertiesPackageImpl.init();

	/**
	 * The meta object id for the '{@link nl.esi.emf.properties.impl.PropertiesContainerImpl <em>Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.emf.properties.impl.PropertiesContainerImpl
	 * @see nl.esi.emf.properties.impl.PropertiesPackageImpl#getPropertiesContainer()
	 * @generated
	 */
	int PROPERTIES_CONTAINER = 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 * @ordered
	 */
	@Deprecated
	int PROPERTIES_CONTAINER__PROPERTIES = 0;

	/**
	 * The number of structural features of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_CONTAINER_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_CONTAINER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link nl.esi.emf.properties.impl.PropertyMapEntryImpl <em>Property Map Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.emf.properties.impl.PropertyMapEntryImpl
	 * @see nl.esi.emf.properties.impl.PropertiesPackageImpl#getPropertyMapEntry()
	 * @generated
	 */
	int PROPERTY_MAP_ENTRY = 1;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Property Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_MAP_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Property Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_MAP_ENTRY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '<em>EProperty Value</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.io.Serializable
	 * @see nl.esi.emf.properties.impl.PropertiesPackageImpl#getEPropertyValue()
	 * @generated
	 */
	int EPROPERTY_VALUE = 2;

	/**
	 * Returns the meta object for class '{@link nl.esi.emf.properties.PropertiesContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container</em>'.
	 * @see nl.esi.emf.properties.PropertiesContainer
	 * @generated
	 */
	EClass getPropertiesContainer();

	/**
	 * Returns the meta object for the map '{@link nl.esi.emf.properties.PropertiesContainer#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Properties</em>'.
	 * @see nl.esi.emf.properties.PropertiesContainer#getProperties()
	 * @see #getPropertiesContainer()
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	EReference getPropertiesContainer_Properties();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Property Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
	 *        valueDataType="nl.esi.emf.properties.EPropertyValue"
	 * @generated
	 */
	EClass getPropertyMapEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getPropertyMapEntry()
	 * @generated
	 */
	EAttribute getPropertyMapEntry_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getPropertyMapEntry()
	 * @generated
	 */
	EAttribute getPropertyMapEntry_Value();

	/**
	 * Returns the meta object for data type '{@link java.io.Serializable <em>EProperty Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>EProperty Value</em>'.
	 * @see java.io.Serializable
	 * @model instanceClass="java.io.Serializable"
	 *        annotation="bundle:/nl.esi.emf.properties/nl.esi.emf.properties.util.EPropertyValueConversionDelegate$Factory"
	 * @generated
	 */
	EDataType getEPropertyValue();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PropertiesFactory getPropertiesFactory();

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
		 * The meta object literal for the '{@link nl.esi.emf.properties.impl.PropertiesContainerImpl <em>Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.emf.properties.impl.PropertiesContainerImpl
		 * @see nl.esi.emf.properties.impl.PropertiesPackageImpl#getPropertiesContainer()
		 * @generated
		 */
		EClass PROPERTIES_CONTAINER = eINSTANCE.getPropertiesContainer();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @deprecated
		 * @generated
		 */
		@Deprecated
		EReference PROPERTIES_CONTAINER__PROPERTIES = eINSTANCE.getPropertiesContainer_Properties();

		/**
		 * The meta object literal for the '{@link nl.esi.emf.properties.impl.PropertyMapEntryImpl <em>Property Map Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.emf.properties.impl.PropertyMapEntryImpl
		 * @see nl.esi.emf.properties.impl.PropertiesPackageImpl#getPropertyMapEntry()
		 * @generated
		 */
		EClass PROPERTY_MAP_ENTRY = eINSTANCE.getPropertyMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_MAP_ENTRY__KEY = eINSTANCE.getPropertyMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_MAP_ENTRY__VALUE = eINSTANCE.getPropertyMapEntry_Value();

		/**
		 * The meta object literal for the '<em>EProperty Value</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.io.Serializable
		 * @see nl.esi.emf.properties.impl.PropertiesPackageImpl#getEPropertyValue()
		 * @generated
		 */
		EDataType EPROPERTY_VALUE = eINSTANCE.getEPropertyValue();

	}

} //PropertiesPackage
