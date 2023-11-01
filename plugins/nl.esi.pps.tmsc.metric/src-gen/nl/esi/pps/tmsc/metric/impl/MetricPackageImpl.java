/**
 */
package nl.esi.pps.tmsc.metric.impl;

import nl.esi.emf.properties.PropertiesPackage;

import nl.esi.pps.architecture.ArchitecturePackage;

import nl.esi.pps.tmsc.TmscPackage;

import nl.esi.pps.tmsc.metric.Metric;
import nl.esi.pps.tmsc.metric.MetricCategory;
import nl.esi.pps.tmsc.metric.MetricFactory;
import nl.esi.pps.tmsc.metric.MetricInstance;
import nl.esi.pps.tmsc.metric.MetricModel;
import nl.esi.pps.tmsc.metric.MetricPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MetricPackageImpl extends EPackageImpl implements MetricPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metricModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metricCategoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metricEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metricInstanceEClass = null;

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
	 * @see nl.esi.pps.tmsc.metric.MetricPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MetricPackageImpl() {
		super(eNS_URI, MetricFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link MetricPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MetricPackage init() {
		if (isInited)
			return (MetricPackage) EPackage.Registry.INSTANCE.getEPackage(MetricPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredMetricPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		MetricPackageImpl theMetricPackage = registeredMetricPackage instanceof MetricPackageImpl
				? (MetricPackageImpl) registeredMetricPackage
				: new MetricPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		ArchitecturePackage.eINSTANCE.eClass();
		PropertiesPackage.eINSTANCE.eClass();
		TmscPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theMetricPackage.createPackageContents();

		// Initialize created meta-data
		theMetricPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMetricPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MetricPackage.eNS_URI, theMetricPackage);
		return theMetricPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMetricModel() {
		return metricModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMetricModel_Metrics() {
		return (EReference) metricModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMetricModel_Categories() {
		return (EReference) metricModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMetricCategory() {
		return metricCategoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetricCategory_Name() {
		return (EAttribute) metricCategoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMetricCategory_Metrics() {
		return (EReference) metricCategoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMetric() {
		return metricEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetric_Id() {
		return (EAttribute) metricEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetric_Name() {
		return (EAttribute) metricEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetric_Budget() {
		return (EAttribute) metricEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMetric_Category() {
		return (EReference) metricEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMetric_Instances() {
		return (EReference) metricEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMetric_Tmscs() {
		return (EReference) metricEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetric_Configuration() {
		return (EAttribute) metricEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMetricInstance() {
		return metricInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetricInstance_Id() {
		return (EAttribute) metricInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetricInstance_Name() {
		return (EAttribute) metricInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetricInstance_ExceedsBudget() {
		return (EAttribute) metricInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMetricInstance_Metric() {
		return (EReference) metricInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MetricFactory getMetricFactory() {
		return (MetricFactory) getEFactoryInstance();
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
		metricModelEClass = createEClass(METRIC_MODEL);
		createEReference(metricModelEClass, METRIC_MODEL__METRICS);
		createEReference(metricModelEClass, METRIC_MODEL__CATEGORIES);

		metricCategoryEClass = createEClass(METRIC_CATEGORY);
		createEAttribute(metricCategoryEClass, METRIC_CATEGORY__NAME);
		createEReference(metricCategoryEClass, METRIC_CATEGORY__METRICS);

		metricEClass = createEClass(METRIC);
		createEAttribute(metricEClass, METRIC__ID);
		createEAttribute(metricEClass, METRIC__NAME);
		createEAttribute(metricEClass, METRIC__BUDGET);
		createEReference(metricEClass, METRIC__CATEGORY);
		createEReference(metricEClass, METRIC__INSTANCES);
		createEReference(metricEClass, METRIC__TMSCS);
		createEAttribute(metricEClass, METRIC__CONFIGURATION);

		metricInstanceEClass = createEClass(METRIC_INSTANCE);
		createEAttribute(metricInstanceEClass, METRIC_INSTANCE__ID);
		createEAttribute(metricInstanceEClass, METRIC_INSTANCE__NAME);
		createEAttribute(metricInstanceEClass, METRIC_INSTANCE__EXCEEDS_BUDGET);
		createEReference(metricInstanceEClass, METRIC_INSTANCE__METRIC);
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
		TmscPackage theTmscPackage = (TmscPackage) EPackage.Registry.INSTANCE.getEPackage(TmscPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		metricInstanceEClass.getESuperTypes().add(theTmscPackage.getInterval());

		// Initialize classes, features, and operations; add parameters
		initEClass(metricModelEClass, MetricModel.class, "MetricModel", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMetricModel_Metrics(), this.getMetric(), null, "metrics", null, 0, -1, MetricModel.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getMetricModel_Metrics().getEKeys().add(this.getMetric_Id());
		initEReference(getMetricModel_Categories(), this.getMetricCategory(), null, "categories", null, 0, -1,
				MetricModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getMetricModel_Categories().getEKeys().add(this.getMetricCategory_Name());

		initEClass(metricCategoryEClass, MetricCategory.class, "MetricCategory", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMetricCategory_Name(), ecorePackage.getEString(), "name", null, 1, 1, MetricCategory.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMetricCategory_Metrics(), this.getMetric(), this.getMetric_Category(), "metrics", null, 0, -1,
				MetricCategory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(metricEClass, Metric.class, "Metric", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMetric_Id(), ecorePackage.getEString(), "id", null, 1, 1, Metric.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetric_Name(), ecorePackage.getEString(), "name", null, 1, 1, Metric.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetric_Budget(), theTmscPackage.getEDuration(), "budget", null, 0, 1, Metric.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMetric_Category(), this.getMetricCategory(), this.getMetricCategory_Metrics(), "category",
				null, 1, 1, Metric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMetric_Instances(), this.getMetricInstance(), this.getMetricInstance_Metric(), "instances",
				null, 0, -1, Metric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getMetric_Instances().getEKeys().add(this.getMetricInstance_Id());
		initEReference(getMetric_Tmscs(), theTmscPackage.getFullScopeTMSC(), null, "tmscs", null, 0, -1, Metric.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetric_Configuration(), ecorePackage.getEString(), "configuration", null, 0, 1, Metric.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(metricInstanceEClass, MetricInstance.class, "MetricInstance", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMetricInstance_Id(), ecorePackage.getEString(), "id", null, 1, 1, MetricInstance.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetricInstance_Name(), ecorePackage.getEString(), "name", null, 1, 1, MetricInstance.class,
				IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetricInstance_ExceedsBudget(), ecorePackage.getEBoolean(), "exceedsBudget", null, 0, 1,
				MetricInstance.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				IS_DERIVED, IS_ORDERED);
		initEReference(getMetricInstance_Metric(), this.getMetric(), this.getMetric_Instances(), "metric", null, 1, 1,
				MetricInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //MetricPackageImpl
