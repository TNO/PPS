/**
 */
package nl.esi.pps.tmsc.metric;

import nl.esi.pps.tmsc.TmscPackage;

import org.eclipse.emf.ecore.EAttribute;
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
 * [[metric-ecore-diagram]]
 * .Diagram of the Metric meta-model
 * image::{metamodelsdir}/metric.png[]
 * 
 * <!-- end-model-doc -->
 * @see nl.esi.pps.tmsc.metric.MetricFactory
 * @model kind="package"
 * @generated
 */
public interface MetricPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "metric";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.esi.nl/tmsc/metric";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "tmsc_metric";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MetricPackage eINSTANCE = nl.esi.pps.tmsc.metric.impl.MetricPackageImpl.init();

	/**
	 * The meta object id for the '{@link nl.esi.pps.tmsc.metric.impl.MetricModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.tmsc.metric.impl.MetricModelImpl
	 * @see nl.esi.pps.tmsc.metric.impl.MetricPackageImpl#getMetricModel()
	 * @generated
	 */
	int METRIC_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Metrics</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_MODEL__METRICS = 0;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_MODEL__CATEGORIES = 1;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_MODEL_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link nl.esi.pps.tmsc.metric.impl.MetricCategoryImpl <em>Category</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.tmsc.metric.impl.MetricCategoryImpl
	 * @see nl.esi.pps.tmsc.metric.impl.MetricPackageImpl#getMetricCategory()
	 * @generated
	 */
	int METRIC_CATEGORY = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_CATEGORY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Metrics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_CATEGORY__METRICS = 1;

	/**
	 * The number of structural features of the '<em>Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_CATEGORY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_CATEGORY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link nl.esi.pps.tmsc.metric.impl.MetricImpl <em>Metric</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.tmsc.metric.impl.MetricImpl
	 * @see nl.esi.pps.tmsc.metric.impl.MetricPackageImpl#getMetric()
	 * @generated
	 */
	int METRIC = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__NAME = 1;

	/**
	 * The feature id for the '<em><b>Budget</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__BUDGET = 2;

	/**
	 * The feature id for the '<em><b>Category</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__CATEGORY = 3;

	/**
	 * The feature id for the '<em><b>Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__INSTANCES = 4;

	/**
	 * The feature id for the '<em><b>Tmscs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__TMSCS = 5;

	/**
	 * The number of structural features of the '<em>Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link nl.esi.pps.tmsc.metric.impl.MetricInstanceImpl <em>Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.tmsc.metric.impl.MetricInstanceImpl
	 * @see nl.esi.pps.tmsc.metric.impl.MetricPackageImpl#getMetricInstance()
	 * @generated
	 */
	int METRIC_INSTANCE = 3;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 * @ordered
	 */
	@Deprecated
	int METRIC_INSTANCE__PROPERTIES = TmscPackage.INTERVAL__PROPERTIES;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_INSTANCE__FROM = TmscPackage.INTERVAL__FROM;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_INSTANCE__TO = TmscPackage.INTERVAL__TO;

	/**
	 * The feature id for the '<em><b>Tmsc</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_INSTANCE__TMSC = TmscPackage.INTERVAL__TMSC;

	/**
	 * The feature id for the '<em><b>Scopes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_INSTANCE__SCOPES = TmscPackage.INTERVAL__SCOPES;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_INSTANCE__START_TIME = TmscPackage.INTERVAL__START_TIME;

	/**
	 * The feature id for the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_INSTANCE__END_TIME = TmscPackage.INTERVAL__END_TIME;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_INSTANCE__DURATION = TmscPackage.INTERVAL__DURATION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_INSTANCE__ID = TmscPackage.INTERVAL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_INSTANCE__NAME = TmscPackage.INTERVAL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Exceeds Budget</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_INSTANCE__EXCEEDS_BUDGET = TmscPackage.INTERVAL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Metric</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_INSTANCE__METRIC = TmscPackage.INTERVAL_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_INSTANCE_FEATURE_COUNT = TmscPackage.INTERVAL_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Start Time</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_INSTANCE___GET_START_TIME = TmscPackage.INTERVAL___GET_START_TIME;

	/**
	 * The operation id for the '<em>Get End Time</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_INSTANCE___GET_END_TIME = TmscPackage.INTERVAL___GET_END_TIME;

	/**
	 * The operation id for the '<em>Get Duration</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_INSTANCE___GET_DURATION = TmscPackage.INTERVAL___GET_DURATION;

	/**
	 * The operation id for the '<em>Get Tmsc</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_INSTANCE___GET_TMSC = TmscPackage.INTERVAL___GET_TMSC;

	/**
	 * The operation id for the '<em>Get Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_INSTANCE___GET_NAME = TmscPackage.INTERVAL___GET_NAME;

	/**
	 * The number of operations of the '<em>Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_INSTANCE_OPERATION_COUNT = TmscPackage.INTERVAL_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.tmsc.metric.MetricModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see nl.esi.pps.tmsc.metric.MetricModel
	 * @generated
	 */
	EClass getMetricModel();

	/**
	 * Returns the meta object for the containment reference list '{@link nl.esi.pps.tmsc.metric.MetricModel#getMetrics <em>Metrics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Metrics</em>'.
	 * @see nl.esi.pps.tmsc.metric.MetricModel#getMetrics()
	 * @see #getMetricModel()
	 * @generated
	 */
	EReference getMetricModel_Metrics();

	/**
	 * Returns the meta object for the containment reference list '{@link nl.esi.pps.tmsc.metric.MetricModel#getCategories <em>Categories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Categories</em>'.
	 * @see nl.esi.pps.tmsc.metric.MetricModel#getCategories()
	 * @see #getMetricModel()
	 * @generated
	 */
	EReference getMetricModel_Categories();

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.tmsc.metric.MetricCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Category</em>'.
	 * @see nl.esi.pps.tmsc.metric.MetricCategory
	 * @generated
	 */
	EClass getMetricCategory();

	/**
	 * Returns the meta object for the attribute '{@link nl.esi.pps.tmsc.metric.MetricCategory#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see nl.esi.pps.tmsc.metric.MetricCategory#getName()
	 * @see #getMetricCategory()
	 * @generated
	 */
	EAttribute getMetricCategory_Name();

	/**
	 * Returns the meta object for the reference list '{@link nl.esi.pps.tmsc.metric.MetricCategory#getMetrics <em>Metrics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Metrics</em>'.
	 * @see nl.esi.pps.tmsc.metric.MetricCategory#getMetrics()
	 * @see #getMetricCategory()
	 * @generated
	 */
	EReference getMetricCategory_Metrics();

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.tmsc.metric.Metric <em>Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metric</em>'.
	 * @see nl.esi.pps.tmsc.metric.Metric
	 * @generated
	 */
	EClass getMetric();

	/**
	 * Returns the meta object for the attribute '{@link nl.esi.pps.tmsc.metric.Metric#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see nl.esi.pps.tmsc.metric.Metric#getId()
	 * @see #getMetric()
	 * @generated
	 */
	EAttribute getMetric_Id();

	/**
	 * Returns the meta object for the attribute '{@link nl.esi.pps.tmsc.metric.Metric#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see nl.esi.pps.tmsc.metric.Metric#getName()
	 * @see #getMetric()
	 * @generated
	 */
	EAttribute getMetric_Name();

	/**
	 * Returns the meta object for the attribute '{@link nl.esi.pps.tmsc.metric.Metric#getBudget <em>Budget</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Budget</em>'.
	 * @see nl.esi.pps.tmsc.metric.Metric#getBudget()
	 * @see #getMetric()
	 * @generated
	 */
	EAttribute getMetric_Budget();

	/**
	 * Returns the meta object for the reference '{@link nl.esi.pps.tmsc.metric.Metric#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Category</em>'.
	 * @see nl.esi.pps.tmsc.metric.Metric#getCategory()
	 * @see #getMetric()
	 * @generated
	 */
	EReference getMetric_Category();

	/**
	 * Returns the meta object for the containment reference list '{@link nl.esi.pps.tmsc.metric.Metric#getInstances <em>Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Instances</em>'.
	 * @see nl.esi.pps.tmsc.metric.Metric#getInstances()
	 * @see #getMetric()
	 * @generated
	 */
	EReference getMetric_Instances();

	/**
	 * Returns the meta object for the reference list '{@link nl.esi.pps.tmsc.metric.Metric#getTmscs <em>Tmscs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tmscs</em>'.
	 * @see nl.esi.pps.tmsc.metric.Metric#getTmscs()
	 * @see #getMetric()
	 * @generated
	 */
	EReference getMetric_Tmscs();

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.tmsc.metric.MetricInstance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance</em>'.
	 * @see nl.esi.pps.tmsc.metric.MetricInstance
	 * @generated
	 */
	EClass getMetricInstance();

	/**
	 * Returns the meta object for the attribute '{@link nl.esi.pps.tmsc.metric.MetricInstance#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see nl.esi.pps.tmsc.metric.MetricInstance#getId()
	 * @see #getMetricInstance()
	 * @generated
	 */
	EAttribute getMetricInstance_Id();

	/**
	 * Returns the meta object for the attribute '{@link nl.esi.pps.tmsc.metric.MetricInstance#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see nl.esi.pps.tmsc.metric.MetricInstance#getName()
	 * @see #getMetricInstance()
	 * @generated
	 */
	EAttribute getMetricInstance_Name();

	/**
	 * Returns the meta object for the attribute '{@link nl.esi.pps.tmsc.metric.MetricInstance#isExceedsBudget <em>Exceeds Budget</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exceeds Budget</em>'.
	 * @see nl.esi.pps.tmsc.metric.MetricInstance#isExceedsBudget()
	 * @see #getMetricInstance()
	 * @generated
	 */
	EAttribute getMetricInstance_ExceedsBudget();

	/**
	 * Returns the meta object for the container reference '{@link nl.esi.pps.tmsc.metric.MetricInstance#getMetric <em>Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Metric</em>'.
	 * @see nl.esi.pps.tmsc.metric.MetricInstance#getMetric()
	 * @see #getMetricInstance()
	 * @generated
	 */
	EReference getMetricInstance_Metric();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MetricFactory getMetricFactory();

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
		 * The meta object literal for the '{@link nl.esi.pps.tmsc.metric.impl.MetricModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.tmsc.metric.impl.MetricModelImpl
		 * @see nl.esi.pps.tmsc.metric.impl.MetricPackageImpl#getMetricModel()
		 * @generated
		 */
		EClass METRIC_MODEL = eINSTANCE.getMetricModel();

		/**
		 * The meta object literal for the '<em><b>Metrics</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METRIC_MODEL__METRICS = eINSTANCE.getMetricModel_Metrics();

		/**
		 * The meta object literal for the '<em><b>Categories</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METRIC_MODEL__CATEGORIES = eINSTANCE.getMetricModel_Categories();

		/**
		 * The meta object literal for the '{@link nl.esi.pps.tmsc.metric.impl.MetricCategoryImpl <em>Category</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.tmsc.metric.impl.MetricCategoryImpl
		 * @see nl.esi.pps.tmsc.metric.impl.MetricPackageImpl#getMetricCategory()
		 * @generated
		 */
		EClass METRIC_CATEGORY = eINSTANCE.getMetricCategory();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC_CATEGORY__NAME = eINSTANCE.getMetricCategory_Name();

		/**
		 * The meta object literal for the '<em><b>Metrics</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METRIC_CATEGORY__METRICS = eINSTANCE.getMetricCategory_Metrics();

		/**
		 * The meta object literal for the '{@link nl.esi.pps.tmsc.metric.impl.MetricImpl <em>Metric</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.tmsc.metric.impl.MetricImpl
		 * @see nl.esi.pps.tmsc.metric.impl.MetricPackageImpl#getMetric()
		 * @generated
		 */
		EClass METRIC = eINSTANCE.getMetric();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC__ID = eINSTANCE.getMetric_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC__NAME = eINSTANCE.getMetric_Name();

		/**
		 * The meta object literal for the '<em><b>Budget</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC__BUDGET = eINSTANCE.getMetric_Budget();

		/**
		 * The meta object literal for the '<em><b>Category</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METRIC__CATEGORY = eINSTANCE.getMetric_Category();

		/**
		 * The meta object literal for the '<em><b>Instances</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METRIC__INSTANCES = eINSTANCE.getMetric_Instances();

		/**
		 * The meta object literal for the '<em><b>Tmscs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METRIC__TMSCS = eINSTANCE.getMetric_Tmscs();

		/**
		 * The meta object literal for the '{@link nl.esi.pps.tmsc.metric.impl.MetricInstanceImpl <em>Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.tmsc.metric.impl.MetricInstanceImpl
		 * @see nl.esi.pps.tmsc.metric.impl.MetricPackageImpl#getMetricInstance()
		 * @generated
		 */
		EClass METRIC_INSTANCE = eINSTANCE.getMetricInstance();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC_INSTANCE__ID = eINSTANCE.getMetricInstance_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC_INSTANCE__NAME = eINSTANCE.getMetricInstance_Name();

		/**
		 * The meta object literal for the '<em><b>Exceeds Budget</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC_INSTANCE__EXCEEDS_BUDGET = eINSTANCE.getMetricInstance_ExceedsBudget();

		/**
		 * The meta object literal for the '<em><b>Metric</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METRIC_INSTANCE__METRIC = eINSTANCE.getMetricInstance_Metric();

	}

} //MetricPackage
