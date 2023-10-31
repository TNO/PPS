/**
 */
package nl.esi.emf.properties.impl;

import java.io.Serializable;

import java.util.Map;

import nl.esi.emf.properties.PropertiesContainer;
import nl.esi.emf.properties.PropertiesFactory;
import nl.esi.emf.properties.PropertiesPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PropertiesPackageImpl extends EPackageImpl implements PropertiesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertiesContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyMapEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType ePropertyValueEDataType = null;

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
	 * @see nl.esi.emf.properties.PropertiesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PropertiesPackageImpl() {
		super(eNS_URI, PropertiesFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PropertiesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PropertiesPackage init() {
		if (isInited)
			return (PropertiesPackage) EPackage.Registry.INSTANCE.getEPackage(PropertiesPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredPropertiesPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		PropertiesPackageImpl thePropertiesPackage = registeredPropertiesPackage instanceof PropertiesPackageImpl
				? (PropertiesPackageImpl) registeredPropertiesPackage
				: new PropertiesPackageImpl();

		isInited = true;

		// Create package meta-data objects
		thePropertiesPackage.createPackageContents();

		// Initialize created meta-data
		thePropertiesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePropertiesPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PropertiesPackage.eNS_URI, thePropertiesPackage);
		return thePropertiesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPropertiesContainer() {
		return propertiesContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	@Override
	public EReference getPropertiesContainer_Properties() {
		return (EReference) propertiesContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPropertyMapEntry() {
		return propertyMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPropertyMapEntry_Key() {
		return (EAttribute) propertyMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPropertyMapEntry_Value() {
		return (EAttribute) propertyMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getEPropertyValue() {
		return ePropertyValueEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropertiesFactory getPropertiesFactory() {
		return (PropertiesFactory) getEFactoryInstance();
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
	@SuppressWarnings("deprecation")
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		propertiesContainerEClass = createEClass(PROPERTIES_CONTAINER);
		createEReference(propertiesContainerEClass, PROPERTIES_CONTAINER__PROPERTIES);

		propertyMapEntryEClass = createEClass(PROPERTY_MAP_ENTRY);
		createEAttribute(propertyMapEntryEClass, PROPERTY_MAP_ENTRY__KEY);
		createEAttribute(propertyMapEntryEClass, PROPERTY_MAP_ENTRY__VALUE);

		// Create data types
		ePropertyValueEDataType = createEDataType(EPROPERTY_VALUE);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(propertiesContainerEClass, PropertiesContainer.class, "PropertiesContainer", IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertiesContainer_Properties(), this.getPropertyMapEntry(), null, "properties", null, 0, -1,
				PropertiesContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyMapEntryEClass, Map.Entry.class, "PropertyMapEntry", !IS_ABSTRACT, !IS_INTERFACE,
				!IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPropertyMapEntry_Key(), ecorePackage.getEString(), "key", null, 1, 1, Map.Entry.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyMapEntry_Value(), this.getEPropertyValue(), "value", null, 0, 1, Map.Entry.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(ePropertyValueEDataType, Serializable.class, "EPropertyValue", IS_SERIALIZABLE,
				!IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// bundle:/nl.esi.emf.properties/nl.esi.emf.properties.util.EPropertyValueConversionDelegate$Factory
		createNlAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";
		addAnnotation(this, source, new String[] { "conversionDelegates",
				"bundle:/nl.esi.emf.properties/nl.esi.emf.properties.util.EPropertyValueConversionDelegate$Factory" });
	}

	/**
	 * Initializes the annotations for <b>bundle:/nl.esi.emf.properties/nl.esi.emf.properties.util.EPropertyValueConversionDelegate$Factory</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createNlAnnotations() {
		String source = "bundle:/nl.esi.emf.properties/nl.esi.emf.properties.util.EPropertyValueConversionDelegate$Factory";
		addAnnotation(ePropertyValueEDataType, source, new String[] {});
	}

} //PropertiesPackageImpl
