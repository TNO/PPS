/**
 */
package nl.esi.pps.tmsc;

import nl.esi.emf.properties.PropertiesPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
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
 * 
 * 
 * [[tmsc-ecore-diagram]]
 * .Diagram of the TMSC meta-model
 * image::{metamodelsdir}/tmsc.png[]
 * 
 * [[callstack-ecore-diagram]]
 * .Diagram of call-stacks in the TMSC meta-model
 * image::{metamodelsdir}/callstack.png[]
 * 
 * [[measurment-ecore-diagram]]
 * .Diagram of measurments in the TMSC meta-model
 * image::{metamodelsdir}/measurement.png[]
 * 
 * <!-- end-model-doc -->
 * @see nl.esi.pps.tmsc.TmscFactory
 * @model kind="package"
 * @generated
 */
public interface TmscPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "tmsc";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.esi.nl/pps/tmsc";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "tmsc";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TmscPackage eINSTANCE = nl.esi.pps.tmsc.impl.TmscPackageImpl.init();

	/**
	 * The meta object id for the '{@link nl.esi.pps.tmsc.impl.TMSCImpl <em>TMSC</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.tmsc.impl.TMSCImpl
	 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getTMSC()
	 * @generated
	 */
	int TMSC = 7;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 * @ordered
	 */
	@Deprecated
	int TMSC__PROPERTIES = PropertiesPackage.PROPERTIES_CONTAINER__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Child Scopes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMSC__CHILD_SCOPES = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Full Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMSC__FULL_SCOPE = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>TMSC</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMSC_FEATURE_COUNT = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Events</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMSC___GET_EVENTS = PropertiesPackage.PROPERTIES_CONTAINER_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Dependencies</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMSC___GET_DEPENDENCIES = PropertiesPackage.PROPERTIES_CONTAINER_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Incoming Dependencies</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMSC___GET_INCOMING_DEPENDENCIES__EVENT = PropertiesPackage.PROPERTIES_CONTAINER_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Outgoing Dependencies</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMSC___GET_OUTGOING_DEPENDENCIES__EVENT = PropertiesPackage.PROPERTIES_CONTAINER_OPERATION_COUNT + 3;

	/**
	 * The number of operations of the '<em>TMSC</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMSC_OPERATION_COUNT = PropertiesPackage.PROPERTIES_CONTAINER_OPERATION_COUNT + 4;

	/**
	 * The meta object id for the '{@link nl.esi.pps.tmsc.impl.FullScopeTMSCImpl <em>Full Scope TMSC</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.tmsc.impl.FullScopeTMSCImpl
	 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getFullScopeTMSC()
	 * @generated
	 */
	int FULL_SCOPE_TMSC = 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 * @ordered
	 */
	@Deprecated
	int FULL_SCOPE_TMSC__PROPERTIES = TMSC__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Child Scopes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FULL_SCOPE_TMSC__CHILD_SCOPES = TMSC__CHILD_SCOPES;

	/**
	 * The feature id for the '<em><b>Full Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FULL_SCOPE_TMSC__FULL_SCOPE = TMSC__FULL_SCOPE;

	/**
	 * The feature id for the '<em><b>Measurements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FULL_SCOPE_TMSC__MEASUREMENTS = TMSC_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Lifelines</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FULL_SCOPE_TMSC__LIFELINES = TMSC_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FULL_SCOPE_TMSC__DEPENDENCIES = TMSC_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Architectures</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FULL_SCOPE_TMSC__ARCHITECTURES = TMSC_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Epoch Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FULL_SCOPE_TMSC__EPOCH_TIME = TMSC_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FULL_SCOPE_TMSC__START_TIME = TMSC_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FULL_SCOPE_TMSC__END_TIME = TMSC_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Full Scope TMSC</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FULL_SCOPE_TMSC_FEATURE_COUNT = TMSC_FEATURE_COUNT + 7;

	/**
	 * The operation id for the '<em>Get Events</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FULL_SCOPE_TMSC___GET_EVENTS = TMSC___GET_EVENTS;

	/**
	 * The operation id for the '<em>Get Dependencies</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FULL_SCOPE_TMSC___GET_DEPENDENCIES = TMSC___GET_DEPENDENCIES;

	/**
	 * The operation id for the '<em>Get Incoming Dependencies</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FULL_SCOPE_TMSC___GET_INCOMING_DEPENDENCIES__EVENT = TMSC___GET_INCOMING_DEPENDENCIES__EVENT;

	/**
	 * The operation id for the '<em>Get Outgoing Dependencies</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FULL_SCOPE_TMSC___GET_OUTGOING_DEPENDENCIES__EVENT = TMSC___GET_OUTGOING_DEPENDENCIES__EVENT;

	/**
	 * The number of operations of the '<em>Full Scope TMSC</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FULL_SCOPE_TMSC_OPERATION_COUNT = TMSC_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link nl.esi.pps.tmsc.impl.EventImpl <em>Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.tmsc.impl.EventImpl
	 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getEvent()
	 * @generated
	 */
	int EVENT = 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 * @ordered
	 */
	@Deprecated
	int EVENT__PROPERTIES = PropertiesPackage.PROPERTIES_CONTAINER__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Lifeline</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__LIFELINE = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__ARGUMENTS = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Full Scope Incoming Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__FULL_SCOPE_INCOMING_DEPENDENCIES = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Full Scope Outgoing Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__FULL_SCOPE_OUTGOING_DEPENDENCIES = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Tmsc</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__TMSC = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Scopes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__SCOPES = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__COMPONENT = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__FUNCTION = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__TIMESTAMP = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Traced</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__TRACED = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_FEATURE_COUNT = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 10;

	/**
	 * The operation id for the '<em>Get Execution</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT___GET_EXECUTION = PropertiesPackage.PROPERTIES_CONTAINER_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Set Execution</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT___SET_EXECUTION__EXECUTION = PropertiesPackage.PROPERTIES_CONTAINER_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_OPERATION_COUNT = PropertiesPackage.PROPERTIES_CONTAINER_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link nl.esi.pps.tmsc.impl.ExecutionImpl <em>Execution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.tmsc.impl.ExecutionImpl
	 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getExecution()
	 * @generated
	 */
	int EXECUTION = 2;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 * @ordered
	 */
	@Deprecated
	int EXECUTION__PROPERTIES = PropertiesPackage.PROPERTIES_CONTAINER__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Lifeline</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION__LIFELINE = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Entry</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION__ENTRY = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION__CHILDREN = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Exit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION__EXIT = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION__PARENT = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION__ROOT = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION__COMPONENT = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION__FUNCTION = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Segments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION__SEGMENTS = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION__START_TIME = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION__END_TIME = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION__DURATION = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Tmsc</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION__TMSC = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 12;

	/**
	 * The number of structural features of the '<em>Execution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_FEATURE_COUNT = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 13;

	/**
	 * The operation id for the '<em>Get Start Time</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION___GET_START_TIME = PropertiesPackage.PROPERTIES_CONTAINER_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get End Time</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION___GET_END_TIME = PropertiesPackage.PROPERTIES_CONTAINER_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Duration</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION___GET_DURATION = PropertiesPackage.PROPERTIES_CONTAINER_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Tmsc</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION___GET_TMSC = PropertiesPackage.PROPERTIES_CONTAINER_OPERATION_COUNT + 3;

	/**
	 * The number of operations of the '<em>Execution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_OPERATION_COUNT = PropertiesPackage.PROPERTIES_CONTAINER_OPERATION_COUNT + 4;

	/**
	 * The meta object id for the '{@link nl.esi.pps.tmsc.impl.DependencyImpl <em>Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.tmsc.impl.DependencyImpl
	 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getDependency()
	 * @generated
	 */
	int DEPENDENCY = 3;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 * @ordered
	 */
	@Deprecated
	int DEPENDENCY__PROPERTIES = PropertiesPackage.PROPERTIES_CONTAINER__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tmsc</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__TMSC = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__SOURCE = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__TARGET = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Scopes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__SCOPES = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__START_TIME = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__END_TIME = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__DURATION = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Time Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__TIME_BOUND = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Scheduled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__SCHEDULED = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Projection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__PROJECTION = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_FEATURE_COUNT = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 10;

	/**
	 * The operation id for the '<em>Get Start Time</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY___GET_START_TIME = PropertiesPackage.PROPERTIES_CONTAINER_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get End Time</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY___GET_END_TIME = PropertiesPackage.PROPERTIES_CONTAINER_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Duration</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY___GET_DURATION = PropertiesPackage.PROPERTIES_CONTAINER_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Tmsc</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY___GET_TMSC = PropertiesPackage.PROPERTIES_CONTAINER_OPERATION_COUNT + 3;

	/**
	 * The number of operations of the '<em>Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_OPERATION_COUNT = PropertiesPackage.PROPERTIES_CONTAINER_OPERATION_COUNT + 4;

	/**
	 * The meta object id for the '{@link nl.esi.pps.tmsc.impl.MessageImpl <em>Message</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.tmsc.impl.MessageImpl
	 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getMessage()
	 * @generated
	 */
	int MESSAGE = 4;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 * @ordered
	 */
	@Deprecated
	int MESSAGE__PROPERTIES = DEPENDENCY__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tmsc</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__TMSC = DEPENDENCY__TMSC;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__SOURCE = DEPENDENCY__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__TARGET = DEPENDENCY__TARGET;

	/**
	 * The feature id for the '<em><b>Scopes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__SCOPES = DEPENDENCY__SCOPES;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__START_TIME = DEPENDENCY__START_TIME;

	/**
	 * The feature id for the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__END_TIME = DEPENDENCY__END_TIME;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__DURATION = DEPENDENCY__DURATION;

	/**
	 * The feature id for the '<em><b>Time Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__TIME_BOUND = DEPENDENCY__TIME_BOUND;

	/**
	 * The feature id for the '<em><b>Scheduled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__SCHEDULED = DEPENDENCY__SCHEDULED;

	/**
	 * The feature id for the '<em><b>Projection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__PROJECTION = DEPENDENCY__PROJECTION;

	/**
	 * The feature id for the '<em><b>Control Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__CONTROL_DEPENDENCIES = DEPENDENCY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FEATURE_COUNT = DEPENDENCY_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Start Time</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE___GET_START_TIME = DEPENDENCY___GET_START_TIME;

	/**
	 * The operation id for the '<em>Get End Time</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE___GET_END_TIME = DEPENDENCY___GET_END_TIME;

	/**
	 * The operation id for the '<em>Get Duration</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE___GET_DURATION = DEPENDENCY___GET_DURATION;

	/**
	 * The operation id for the '<em>Get Tmsc</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE___GET_TMSC = DEPENDENCY___GET_TMSC;

	/**
	 * The number of operations of the '<em>Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_OPERATION_COUNT = DEPENDENCY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link nl.esi.pps.tmsc.impl.RequestImpl <em>Request</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.tmsc.impl.RequestImpl
	 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getRequest()
	 * @generated
	 */
	int REQUEST = 5;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 * @ordered
	 */
	@Deprecated
	int REQUEST__PROPERTIES = MESSAGE__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tmsc</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST__TMSC = MESSAGE__TMSC;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST__SOURCE = MESSAGE__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST__TARGET = MESSAGE__TARGET;

	/**
	 * The feature id for the '<em><b>Scopes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST__SCOPES = MESSAGE__SCOPES;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST__START_TIME = MESSAGE__START_TIME;

	/**
	 * The feature id for the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST__END_TIME = MESSAGE__END_TIME;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST__DURATION = MESSAGE__DURATION;

	/**
	 * The feature id for the '<em><b>Time Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST__TIME_BOUND = MESSAGE__TIME_BOUND;

	/**
	 * The feature id for the '<em><b>Scheduled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST__SCHEDULED = MESSAGE__SCHEDULED;

	/**
	 * The feature id for the '<em><b>Projection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST__PROJECTION = MESSAGE__PROJECTION;

	/**
	 * The feature id for the '<em><b>Control Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST__CONTROL_DEPENDENCIES = MESSAGE__CONTROL_DEPENDENCIES;

	/**
	 * The feature id for the '<em><b>Replies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST__REPLIES = MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Request</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Start Time</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST___GET_START_TIME = MESSAGE___GET_START_TIME;

	/**
	 * The operation id for the '<em>Get End Time</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST___GET_END_TIME = MESSAGE___GET_END_TIME;

	/**
	 * The operation id for the '<em>Get Duration</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST___GET_DURATION = MESSAGE___GET_DURATION;

	/**
	 * The operation id for the '<em>Get Tmsc</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST___GET_TMSC = MESSAGE___GET_TMSC;

	/**
	 * The number of operations of the '<em>Request</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link nl.esi.pps.tmsc.impl.ReplyImpl <em>Reply</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.tmsc.impl.ReplyImpl
	 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getReply()
	 * @generated
	 */
	int REPLY = 6;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 * @ordered
	 */
	@Deprecated
	int REPLY__PROPERTIES = MESSAGE__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tmsc</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLY__TMSC = MESSAGE__TMSC;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLY__SOURCE = MESSAGE__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLY__TARGET = MESSAGE__TARGET;

	/**
	 * The feature id for the '<em><b>Scopes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLY__SCOPES = MESSAGE__SCOPES;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLY__START_TIME = MESSAGE__START_TIME;

	/**
	 * The feature id for the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLY__END_TIME = MESSAGE__END_TIME;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLY__DURATION = MESSAGE__DURATION;

	/**
	 * The feature id for the '<em><b>Time Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLY__TIME_BOUND = MESSAGE__TIME_BOUND;

	/**
	 * The feature id for the '<em><b>Scheduled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLY__SCHEDULED = MESSAGE__SCHEDULED;

	/**
	 * The feature id for the '<em><b>Projection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLY__PROJECTION = MESSAGE__PROJECTION;

	/**
	 * The feature id for the '<em><b>Control Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLY__CONTROL_DEPENDENCIES = MESSAGE__CONTROL_DEPENDENCIES;

	/**
	 * The feature id for the '<em><b>Request</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLY__REQUEST = MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reply</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLY_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Start Time</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLY___GET_START_TIME = MESSAGE___GET_START_TIME;

	/**
	 * The operation id for the '<em>Get End Time</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLY___GET_END_TIME = MESSAGE___GET_END_TIME;

	/**
	 * The operation id for the '<em>Get Duration</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLY___GET_DURATION = MESSAGE___GET_DURATION;

	/**
	 * The operation id for the '<em>Get Tmsc</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLY___GET_TMSC = MESSAGE___GET_TMSC;

	/**
	 * The number of operations of the '<em>Reply</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLY_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link nl.esi.pps.tmsc.impl.ScopedTMSCImpl <em>Scoped TMSC</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.tmsc.impl.ScopedTMSCImpl
	 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getScopedTMSC()
	 * @generated
	 */
	int SCOPED_TMSC = 8;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 * @ordered
	 */
	@Deprecated
	int SCOPED_TMSC__PROPERTIES = TMSC__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Child Scopes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_TMSC__CHILD_SCOPES = TMSC__CHILD_SCOPES;

	/**
	 * The feature id for the '<em><b>Full Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_TMSC__FULL_SCOPE = TMSC__FULL_SCOPE;

	/**
	 * The feature id for the '<em><b>Parent Scope</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_TMSC__PARENT_SCOPE = TMSC_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_TMSC__DEPENDENCIES = TMSC_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_TMSC__ORIGIN = TMSC_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Fqn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_TMSC__FQN = TMSC_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_TMSC__NAME = TMSC_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Scoped TMSC</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_TMSC_FEATURE_COUNT = TMSC_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>Get Events</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_TMSC___GET_EVENTS = TMSC___GET_EVENTS;

	/**
	 * The operation id for the '<em>Get Dependencies</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_TMSC___GET_DEPENDENCIES = TMSC___GET_DEPENDENCIES;

	/**
	 * The operation id for the '<em>Get Incoming Dependencies</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_TMSC___GET_INCOMING_DEPENDENCIES__EVENT = TMSC___GET_INCOMING_DEPENDENCIES__EVENT;

	/**
	 * The operation id for the '<em>Get Outgoing Dependencies</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_TMSC___GET_OUTGOING_DEPENDENCIES__EVENT = TMSC___GET_OUTGOING_DEPENDENCIES__EVENT;

	/**
	 * The number of operations of the '<em>Scoped TMSC</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_TMSC_OPERATION_COUNT = TMSC_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link nl.esi.pps.tmsc.impl.DomainDependencyImpl <em>Domain Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.tmsc.impl.DomainDependencyImpl
	 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getDomainDependency()
	 * @generated
	 */
	int DOMAIN_DEPENDENCY = 9;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 * @ordered
	 */
	@Deprecated
	int DOMAIN_DEPENDENCY__PROPERTIES = DEPENDENCY__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tmsc</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_DEPENDENCY__TMSC = DEPENDENCY__TMSC;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_DEPENDENCY__SOURCE = DEPENDENCY__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_DEPENDENCY__TARGET = DEPENDENCY__TARGET;

	/**
	 * The feature id for the '<em><b>Scopes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_DEPENDENCY__SCOPES = DEPENDENCY__SCOPES;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_DEPENDENCY__START_TIME = DEPENDENCY__START_TIME;

	/**
	 * The feature id for the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_DEPENDENCY__END_TIME = DEPENDENCY__END_TIME;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_DEPENDENCY__DURATION = DEPENDENCY__DURATION;

	/**
	 * The feature id for the '<em><b>Time Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_DEPENDENCY__TIME_BOUND = DEPENDENCY__TIME_BOUND;

	/**
	 * The feature id for the '<em><b>Scheduled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_DEPENDENCY__SCHEDULED = DEPENDENCY__SCHEDULED;

	/**
	 * The feature id for the '<em><b>Projection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_DEPENDENCY__PROJECTION = DEPENDENCY__PROJECTION;

	/**
	 * The number of structural features of the '<em>Domain Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_DEPENDENCY_FEATURE_COUNT = DEPENDENCY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Start Time</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_DEPENDENCY___GET_START_TIME = DEPENDENCY___GET_START_TIME;

	/**
	 * The operation id for the '<em>Get End Time</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_DEPENDENCY___GET_END_TIME = DEPENDENCY___GET_END_TIME;

	/**
	 * The operation id for the '<em>Get Duration</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_DEPENDENCY___GET_DURATION = DEPENDENCY___GET_DURATION;

	/**
	 * The operation id for the '<em>Get Tmsc</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_DEPENDENCY___GET_TMSC = DEPENDENCY___GET_TMSC;

	/**
	 * The number of operations of the '<em>Domain Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_DEPENDENCY_OPERATION_COUNT = DEPENDENCY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link nl.esi.pps.tmsc.impl.LifelineImpl <em>Lifeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.tmsc.impl.LifelineImpl
	 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getLifeline()
	 * @generated
	 */
	int LIFELINE = 10;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 * @ordered
	 */
	@Deprecated
	int LIFELINE__PROPERTIES = PropertiesPackage.PROPERTIES_CONTAINER__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tmsc</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE__TMSC = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE__EVENTS = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Executions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE__EXECUTIONS = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Root Executions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE__ROOT_EXECUTIONS = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Segments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE__SEGMENTS = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE__EXECUTOR = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Traced</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE__TRACED = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Lifeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE_FEATURE_COUNT = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Lifeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE_OPERATION_COUNT = PropertiesPackage.PROPERTIES_CONTAINER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link nl.esi.pps.tmsc.impl.LifelineSegmentImpl <em>Lifeline Segment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.tmsc.impl.LifelineSegmentImpl
	 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getLifelineSegment()
	 * @generated
	 */
	int LIFELINE_SEGMENT = 11;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 * @ordered
	 */
	@Deprecated
	int LIFELINE_SEGMENT__PROPERTIES = DEPENDENCY__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tmsc</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE_SEGMENT__TMSC = DEPENDENCY__TMSC;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE_SEGMENT__SOURCE = DEPENDENCY__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE_SEGMENT__TARGET = DEPENDENCY__TARGET;

	/**
	 * The feature id for the '<em><b>Scopes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE_SEGMENT__SCOPES = DEPENDENCY__SCOPES;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE_SEGMENT__START_TIME = DEPENDENCY__START_TIME;

	/**
	 * The feature id for the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE_SEGMENT__END_TIME = DEPENDENCY__END_TIME;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE_SEGMENT__DURATION = DEPENDENCY__DURATION;

	/**
	 * The feature id for the '<em><b>Time Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE_SEGMENT__TIME_BOUND = DEPENDENCY__TIME_BOUND;

	/**
	 * The feature id for the '<em><b>Scheduled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE_SEGMENT__SCHEDULED = DEPENDENCY__SCHEDULED;

	/**
	 * The feature id for the '<em><b>Projection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE_SEGMENT__PROJECTION = DEPENDENCY__PROJECTION;

	/**
	 * The feature id for the '<em><b>Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE_SEGMENT__LIFELINE = DEPENDENCY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Active Execution</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE_SEGMENT__ACTIVE_EXECUTION = DEPENDENCY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Lifeline Segment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE_SEGMENT_FEATURE_COUNT = DEPENDENCY_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Start Time</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE_SEGMENT___GET_START_TIME = DEPENDENCY___GET_START_TIME;

	/**
	 * The operation id for the '<em>Get End Time</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE_SEGMENT___GET_END_TIME = DEPENDENCY___GET_END_TIME;

	/**
	 * The operation id for the '<em>Get Duration</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE_SEGMENT___GET_DURATION = DEPENDENCY___GET_DURATION;

	/**
	 * The operation id for the '<em>Get Tmsc</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE_SEGMENT___GET_TMSC = DEPENDENCY___GET_TMSC;

	/**
	 * The number of operations of the '<em>Lifeline Segment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE_SEGMENT_OPERATION_COUNT = DEPENDENCY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link nl.esi.pps.tmsc.impl.MessageControlImpl <em>Message Control</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.tmsc.impl.MessageControlImpl
	 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getMessageControl()
	 * @generated
	 */
	int MESSAGE_CONTROL = 12;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 * @ordered
	 */
	@Deprecated
	int MESSAGE_CONTROL__PROPERTIES = DEPENDENCY__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tmsc</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_CONTROL__TMSC = DEPENDENCY__TMSC;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_CONTROL__SOURCE = DEPENDENCY__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_CONTROL__TARGET = DEPENDENCY__TARGET;

	/**
	 * The feature id for the '<em><b>Scopes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_CONTROL__SCOPES = DEPENDENCY__SCOPES;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_CONTROL__START_TIME = DEPENDENCY__START_TIME;

	/**
	 * The feature id for the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_CONTROL__END_TIME = DEPENDENCY__END_TIME;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_CONTROL__DURATION = DEPENDENCY__DURATION;

	/**
	 * The feature id for the '<em><b>Time Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_CONTROL__TIME_BOUND = DEPENDENCY__TIME_BOUND;

	/**
	 * The feature id for the '<em><b>Scheduled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_CONTROL__SCHEDULED = DEPENDENCY__SCHEDULED;

	/**
	 * The feature id for the '<em><b>Projection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_CONTROL__PROJECTION = DEPENDENCY__PROJECTION;

	/**
	 * The feature id for the '<em><b>Message</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_CONTROL__MESSAGE = DEPENDENCY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Message Control</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_CONTROL_FEATURE_COUNT = DEPENDENCY_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Start Time</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_CONTROL___GET_START_TIME = DEPENDENCY___GET_START_TIME;

	/**
	 * The operation id for the '<em>Get End Time</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_CONTROL___GET_END_TIME = DEPENDENCY___GET_END_TIME;

	/**
	 * The operation id for the '<em>Get Duration</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_CONTROL___GET_DURATION = DEPENDENCY___GET_DURATION;

	/**
	 * The operation id for the '<em>Get Tmsc</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_CONTROL___GET_TMSC = DEPENDENCY___GET_TMSC;

	/**
	 * The number of operations of the '<em>Message Control</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_CONTROL_OPERATION_COUNT = DEPENDENCY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link nl.esi.pps.tmsc.impl.FunctionArgumentMapEntryImpl <em>Function Argument Map Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.tmsc.impl.FunctionArgumentMapEntryImpl
	 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getFunctionArgumentMapEntry()
	 * @generated
	 */
	int FUNCTION_ARGUMENT_MAP_ENTRY = 13;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_ARGUMENT_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_ARGUMENT_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Function Argument Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_ARGUMENT_MAP_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Function Argument Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_ARGUMENT_MAP_ENTRY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link nl.esi.pps.tmsc.impl.IntervalImpl <em>Interval</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.tmsc.impl.IntervalImpl
	 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getInterval()
	 * @generated
	 */
	int INTERVAL = 14;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 * @ordered
	 */
	@Deprecated
	int INTERVAL__PROPERTIES = PropertiesPackage.PROPERTIES_CONTAINER__PROPERTIES;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL__FROM = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL__TO = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Tmsc</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL__TMSC = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Scopes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL__SCOPES = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL__START_TIME = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL__END_TIME = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL__DURATION = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Interval</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_FEATURE_COUNT = PropertiesPackage.PROPERTIES_CONTAINER_FEATURE_COUNT + 7;

	/**
	 * The operation id for the '<em>Get Start Time</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL___GET_START_TIME = PropertiesPackage.PROPERTIES_CONTAINER_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get End Time</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL___GET_END_TIME = PropertiesPackage.PROPERTIES_CONTAINER_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Duration</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL___GET_DURATION = PropertiesPackage.PROPERTIES_CONTAINER_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Tmsc</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL___GET_TMSC = PropertiesPackage.PROPERTIES_CONTAINER_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL___GET_NAME = PropertiesPackage.PROPERTIES_CONTAINER_OPERATION_COUNT + 4;

	/**
	 * The number of operations of the '<em>Interval</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_OPERATION_COUNT = PropertiesPackage.PROPERTIES_CONTAINER_OPERATION_COUNT + 5;

	/**
	 * The meta object id for the '{@link nl.esi.pps.tmsc.impl.MeasurementImpl <em>Measurement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.tmsc.impl.MeasurementImpl
	 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getMeasurement()
	 * @generated
	 */
	int MEASUREMENT = 15;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 * @ordered
	 */
	@Deprecated
	int MEASUREMENT__PROPERTIES = INTERVAL__PROPERTIES;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT__FROM = INTERVAL__FROM;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT__TO = INTERVAL__TO;

	/**
	 * The feature id for the '<em><b>Tmsc</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT__TMSC = INTERVAL__TMSC;

	/**
	 * The feature id for the '<em><b>Scopes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT__SCOPES = INTERVAL__SCOPES;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT__START_TIME = INTERVAL__START_TIME;

	/**
	 * The feature id for the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT__END_TIME = INTERVAL__END_TIME;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT__DURATION = INTERVAL__DURATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT__NAME = INTERVAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Measurement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_FEATURE_COUNT = INTERVAL_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Start Time</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT___GET_START_TIME = INTERVAL___GET_START_TIME;

	/**
	 * The operation id for the '<em>Get End Time</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT___GET_END_TIME = INTERVAL___GET_END_TIME;

	/**
	 * The operation id for the '<em>Get Duration</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT___GET_DURATION = INTERVAL___GET_DURATION;

	/**
	 * The operation id for the '<em>Get Tmsc</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT___GET_TMSC = INTERVAL___GET_TMSC;

	/**
	 * The operation id for the '<em>Get Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT___GET_NAME = INTERVAL___GET_NAME;

	/**
	 * The number of operations of the '<em>Measurement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_OPERATION_COUNT = INTERVAL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link nl.esi.pps.tmsc.ITMSC <em>ITMSC</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.tmsc.ITMSC
	 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getITMSC()
	 * @generated
	 */
	int ITMSC = 16;

	/**
	 * The number of structural features of the '<em>ITMSC</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITMSC_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Get Events</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITMSC___GET_EVENTS = 0;

	/**
	 * The operation id for the '<em>Get Dependencies</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITMSC___GET_DEPENDENCIES = 1;

	/**
	 * The operation id for the '<em>Get Incoming Dependencies</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITMSC___GET_INCOMING_DEPENDENCIES__EVENT = 2;

	/**
	 * The operation id for the '<em>Get Outgoing Dependencies</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITMSC___GET_OUTGOING_DEPENDENCIES__EVENT = 3;

	/**
	 * The number of operations of the '<em>ITMSC</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITMSC_OPERATION_COUNT = 4;

	/**
	 * The meta object id for the '{@link nl.esi.pps.tmsc.impl.EntryEventImpl <em>Entry Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.tmsc.impl.EntryEventImpl
	 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getEntryEvent()
	 * @generated
	 */
	int ENTRY_EVENT = 17;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 * @ordered
	 */
	@Deprecated
	int ENTRY_EVENT__PROPERTIES = EVENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Lifeline</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_EVENT__LIFELINE = EVENT__LIFELINE;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_EVENT__ARGUMENTS = EVENT__ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Full Scope Incoming Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_EVENT__FULL_SCOPE_INCOMING_DEPENDENCIES = EVENT__FULL_SCOPE_INCOMING_DEPENDENCIES;

	/**
	 * The feature id for the '<em><b>Full Scope Outgoing Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_EVENT__FULL_SCOPE_OUTGOING_DEPENDENCIES = EVENT__FULL_SCOPE_OUTGOING_DEPENDENCIES;

	/**
	 * The feature id for the '<em><b>Tmsc</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_EVENT__TMSC = EVENT__TMSC;

	/**
	 * The feature id for the '<em><b>Scopes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_EVENT__SCOPES = EVENT__SCOPES;

	/**
	 * The feature id for the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_EVENT__COMPONENT = EVENT__COMPONENT;

	/**
	 * The feature id for the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_EVENT__FUNCTION = EVENT__FUNCTION;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_EVENT__TIMESTAMP = EVENT__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Traced</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_EVENT__TRACED = EVENT__TRACED;

	/**
	 * The feature id for the '<em><b>Execution</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_EVENT__EXECUTION = EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Entry Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Execution</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_EVENT___GET_EXECUTION = EVENT___GET_EXECUTION;

	/**
	 * The operation id for the '<em>Set Execution</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_EVENT___SET_EXECUTION__EXECUTION = EVENT___SET_EXECUTION__EXECUTION;

	/**
	 * The number of operations of the '<em>Entry Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_EVENT_OPERATION_COUNT = EVENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link nl.esi.pps.tmsc.impl.ExitEventImpl <em>Exit Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.tmsc.impl.ExitEventImpl
	 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getExitEvent()
	 * @generated
	 */
	int EXIT_EVENT = 18;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 * @ordered
	 */
	@Deprecated
	int EXIT_EVENT__PROPERTIES = EVENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Lifeline</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT_EVENT__LIFELINE = EVENT__LIFELINE;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT_EVENT__ARGUMENTS = EVENT__ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Full Scope Incoming Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT_EVENT__FULL_SCOPE_INCOMING_DEPENDENCIES = EVENT__FULL_SCOPE_INCOMING_DEPENDENCIES;

	/**
	 * The feature id for the '<em><b>Full Scope Outgoing Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT_EVENT__FULL_SCOPE_OUTGOING_DEPENDENCIES = EVENT__FULL_SCOPE_OUTGOING_DEPENDENCIES;

	/**
	 * The feature id for the '<em><b>Tmsc</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT_EVENT__TMSC = EVENT__TMSC;

	/**
	 * The feature id for the '<em><b>Scopes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT_EVENT__SCOPES = EVENT__SCOPES;

	/**
	 * The feature id for the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT_EVENT__COMPONENT = EVENT__COMPONENT;

	/**
	 * The feature id for the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT_EVENT__FUNCTION = EVENT__FUNCTION;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT_EVENT__TIMESTAMP = EVENT__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Traced</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT_EVENT__TRACED = EVENT__TRACED;

	/**
	 * The feature id for the '<em><b>Execution</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT_EVENT__EXECUTION = EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Exit Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Execution</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT_EVENT___GET_EXECUTION = EVENT___GET_EXECUTION;

	/**
	 * The operation id for the '<em>Set Execution</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT_EVENT___SET_EXECUTION__EXECUTION = EVENT___SET_EXECUTION__EXECUTION;

	/**
	 * The number of operations of the '<em>Exit Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT_EVENT_OPERATION_COUNT = EVENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link nl.esi.pps.tmsc.ITimeRange <em>ITime Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esi.pps.tmsc.ITimeRange
	 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getITimeRange()
	 * @generated
	 */
	int ITIME_RANGE = 19;

	/**
	 * The number of structural features of the '<em>ITime Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITIME_RANGE_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Get Start Time</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITIME_RANGE___GET_START_TIME = 0;

	/**
	 * The operation id for the '<em>Get End Time</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITIME_RANGE___GET_END_TIME = 1;

	/**
	 * The operation id for the '<em>Get Duration</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITIME_RANGE___GET_DURATION = 2;

	/**
	 * The operation id for the '<em>Get Tmsc</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITIME_RANGE___GET_TMSC = 3;

	/**
	 * The number of operations of the '<em>ITime Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITIME_RANGE_OPERATION_COUNT = 4;

	/**
	 * The meta object id for the '<em>ETimestamp</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Long
	 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getETimestamp()
	 * @generated
	 */
	int ETIMESTAMP = 20;

	/**
	 * The meta object id for the '<em>EDuration</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Long
	 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getEDuration()
	 * @generated
	 */
	int EDURATION = 21;

	/**
	 * The meta object id for the '<em>EID</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getEID()
	 * @generated
	 */
	int EID = 22;

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.tmsc.FullScopeTMSC <em>Full Scope TMSC</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Full Scope TMSC</em>'.
	 * @see nl.esi.pps.tmsc.FullScopeTMSC
	 * @generated
	 */
	EClass getFullScopeTMSC();

	/**
	 * Returns the meta object for the containment reference list '{@link nl.esi.pps.tmsc.FullScopeTMSC#getMeasurements <em>Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Measurements</em>'.
	 * @see nl.esi.pps.tmsc.FullScopeTMSC#getMeasurements()
	 * @see #getFullScopeTMSC()
	 * @generated
	 */
	EReference getFullScopeTMSC_Measurements();

	/**
	 * Returns the meta object for the containment reference list '{@link nl.esi.pps.tmsc.FullScopeTMSC#getLifelines <em>Lifelines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lifelines</em>'.
	 * @see nl.esi.pps.tmsc.FullScopeTMSC#getLifelines()
	 * @see #getFullScopeTMSC()
	 * @generated
	 */
	EReference getFullScopeTMSC_Lifelines();

	/**
	 * Returns the meta object for the containment reference list '{@link nl.esi.pps.tmsc.FullScopeTMSC#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dependencies</em>'.
	 * @see nl.esi.pps.tmsc.FullScopeTMSC#getDependencies()
	 * @see #getFullScopeTMSC()
	 * @generated
	 */
	EReference getFullScopeTMSC_Dependencies();

	/**
	 * Returns the meta object for the reference list '{@link nl.esi.pps.tmsc.FullScopeTMSC#getArchitectures <em>Architectures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Architectures</em>'.
	 * @see nl.esi.pps.tmsc.FullScopeTMSC#getArchitectures()
	 * @see #getFullScopeTMSC()
	 * @generated
	 */
	EReference getFullScopeTMSC_Architectures();

	/**
	 * Returns the meta object for the attribute '{@link nl.esi.pps.tmsc.FullScopeTMSC#isEpochTime <em>Epoch Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Epoch Time</em>'.
	 * @see nl.esi.pps.tmsc.FullScopeTMSC#isEpochTime()
	 * @see #getFullScopeTMSC()
	 * @generated
	 */
	EAttribute getFullScopeTMSC_EpochTime();

	/**
	 * Returns the meta object for the attribute '{@link nl.esi.pps.tmsc.FullScopeTMSC#getStartTime <em>Start Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Time</em>'.
	 * @see nl.esi.pps.tmsc.FullScopeTMSC#getStartTime()
	 * @see #getFullScopeTMSC()
	 * @generated
	 */
	EAttribute getFullScopeTMSC_StartTime();

	/**
	 * Returns the meta object for the attribute '{@link nl.esi.pps.tmsc.FullScopeTMSC#getEndTime <em>End Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Time</em>'.
	 * @see nl.esi.pps.tmsc.FullScopeTMSC#getEndTime()
	 * @see #getFullScopeTMSC()
	 * @generated
	 */
	EAttribute getFullScopeTMSC_EndTime();

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.tmsc.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see nl.esi.pps.tmsc.Event
	 * @generated
	 */
	EClass getEvent();

	/**
	 * Returns the meta object for the container reference '{@link nl.esi.pps.tmsc.Event#getLifeline <em>Lifeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Lifeline</em>'.
	 * @see nl.esi.pps.tmsc.Event#getLifeline()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_Lifeline();

	/**
	 * Returns the meta object for the map '{@link nl.esi.pps.tmsc.Event#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Arguments</em>'.
	 * @see nl.esi.pps.tmsc.Event#getArguments()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_Arguments();

	/**
	 * Returns the meta object for the reference list '{@link nl.esi.pps.tmsc.Event#getFullScopeIncomingDependencies <em>Full Scope Incoming Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Full Scope Incoming Dependencies</em>'.
	 * @see nl.esi.pps.tmsc.Event#getFullScopeIncomingDependencies()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_FullScopeIncomingDependencies();

	/**
	 * Returns the meta object for the reference list '{@link nl.esi.pps.tmsc.Event#getFullScopeOutgoingDependencies <em>Full Scope Outgoing Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Full Scope Outgoing Dependencies</em>'.
	 * @see nl.esi.pps.tmsc.Event#getFullScopeOutgoingDependencies()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_FullScopeOutgoingDependencies();

	/**
	 * Returns the meta object for the reference '{@link nl.esi.pps.tmsc.Event#getTmsc <em>Tmsc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Tmsc</em>'.
	 * @see nl.esi.pps.tmsc.Event#getTmsc()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_Tmsc();

	/**
	 * Returns the meta object for the reference list '{@link nl.esi.pps.tmsc.Event#getScopes <em>Scopes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Scopes</em>'.
	 * @see nl.esi.pps.tmsc.Event#getScopes()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_Scopes();

	/**
	 * Returns the meta object for the reference '{@link nl.esi.pps.tmsc.Event#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Component</em>'.
	 * @see nl.esi.pps.tmsc.Event#getComponent()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_Component();

	/**
	 * Returns the meta object for the reference '{@link nl.esi.pps.tmsc.Event#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Function</em>'.
	 * @see nl.esi.pps.tmsc.Event#getFunction()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_Function();

	/**
	 * Returns the meta object for the attribute '{@link nl.esi.pps.tmsc.Event#getTimestamp <em>Timestamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timestamp</em>'.
	 * @see nl.esi.pps.tmsc.Event#getTimestamp()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_Timestamp();

	/**
	 * Returns the meta object for the attribute '{@link nl.esi.pps.tmsc.Event#isTraced <em>Traced</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Traced</em>'.
	 * @see nl.esi.pps.tmsc.Event#isTraced()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_Traced();

	/**
	 * Returns the meta object for the '{@link nl.esi.pps.tmsc.Event#getExecution() <em>Get Execution</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Execution</em>' operation.
	 * @see nl.esi.pps.tmsc.Event#getExecution()
	 * @generated
	 */
	EOperation getEvent__GetExecution();

	/**
	 * Returns the meta object for the '{@link nl.esi.pps.tmsc.Event#setExecution(nl.esi.pps.tmsc.Execution) <em>Set Execution</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Set Execution</em>' operation.
	 * @see nl.esi.pps.tmsc.Event#setExecution(nl.esi.pps.tmsc.Execution)
	 * @generated
	 */
	EOperation getEvent__SetExecution__Execution();

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.tmsc.Execution <em>Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution</em>'.
	 * @see nl.esi.pps.tmsc.Execution
	 * @generated
	 */
	EClass getExecution();

	/**
	 * Returns the meta object for the container reference '{@link nl.esi.pps.tmsc.Execution#getLifeline <em>Lifeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Lifeline</em>'.
	 * @see nl.esi.pps.tmsc.Execution#getLifeline()
	 * @see #getExecution()
	 * @generated
	 */
	EReference getExecution_Lifeline();

	/**
	 * Returns the meta object for the reference '{@link nl.esi.pps.tmsc.Execution#getEntry <em>Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Entry</em>'.
	 * @see nl.esi.pps.tmsc.Execution#getEntry()
	 * @see #getExecution()
	 * @generated
	 */
	EReference getExecution_Entry();

	/**
	 * Returns the meta object for the reference list '{@link nl.esi.pps.tmsc.Execution#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Children</em>'.
	 * @see nl.esi.pps.tmsc.Execution#getChildren()
	 * @see #getExecution()
	 * @generated
	 */
	EReference getExecution_Children();

	/**
	 * Returns the meta object for the reference '{@link nl.esi.pps.tmsc.Execution#getExit <em>Exit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Exit</em>'.
	 * @see nl.esi.pps.tmsc.Execution#getExit()
	 * @see #getExecution()
	 * @generated
	 */
	EReference getExecution_Exit();

	/**
	 * Returns the meta object for the reference '{@link nl.esi.pps.tmsc.Execution#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see nl.esi.pps.tmsc.Execution#getParent()
	 * @see #getExecution()
	 * @generated
	 */
	EReference getExecution_Parent();

	/**
	 * Returns the meta object for the reference '{@link nl.esi.pps.tmsc.Execution#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Root</em>'.
	 * @see nl.esi.pps.tmsc.Execution#getRoot()
	 * @see #getExecution()
	 * @generated
	 */
	EReference getExecution_Root();

	/**
	 * Returns the meta object for the reference '{@link nl.esi.pps.tmsc.Execution#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Component</em>'.
	 * @see nl.esi.pps.tmsc.Execution#getComponent()
	 * @see #getExecution()
	 * @generated
	 */
	EReference getExecution_Component();

	/**
	 * Returns the meta object for the reference '{@link nl.esi.pps.tmsc.Execution#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Function</em>'.
	 * @see nl.esi.pps.tmsc.Execution#getFunction()
	 * @see #getExecution()
	 * @generated
	 */
	EReference getExecution_Function();

	/**
	 * Returns the meta object for the reference list '{@link nl.esi.pps.tmsc.Execution#getSegments <em>Segments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Segments</em>'.
	 * @see nl.esi.pps.tmsc.Execution#getSegments()
	 * @see #getExecution()
	 * @generated
	 */
	EReference getExecution_Segments();

	/**
	 * Returns the meta object for the attribute '{@link nl.esi.pps.tmsc.Execution#getStartTime <em>Start Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Time</em>'.
	 * @see nl.esi.pps.tmsc.Execution#getStartTime()
	 * @see #getExecution()
	 * @generated
	 */
	EAttribute getExecution_StartTime();

	/**
	 * Returns the meta object for the attribute '{@link nl.esi.pps.tmsc.Execution#getEndTime <em>End Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Time</em>'.
	 * @see nl.esi.pps.tmsc.Execution#getEndTime()
	 * @see #getExecution()
	 * @generated
	 */
	EAttribute getExecution_EndTime();

	/**
	 * Returns the meta object for the attribute '{@link nl.esi.pps.tmsc.Execution#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration</em>'.
	 * @see nl.esi.pps.tmsc.Execution#getDuration()
	 * @see #getExecution()
	 * @generated
	 */
	EAttribute getExecution_Duration();

	/**
	 * Returns the meta object for the reference '{@link nl.esi.pps.tmsc.Execution#getTmsc <em>Tmsc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Tmsc</em>'.
	 * @see nl.esi.pps.tmsc.Execution#getTmsc()
	 * @see #getExecution()
	 * @generated
	 */
	EReference getExecution_Tmsc();

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.tmsc.Dependency <em>Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependency</em>'.
	 * @see nl.esi.pps.tmsc.Dependency
	 * @generated
	 */
	EClass getDependency();

	/**
	 * Returns the meta object for the container reference '{@link nl.esi.pps.tmsc.Dependency#getTmsc <em>Tmsc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Tmsc</em>'.
	 * @see nl.esi.pps.tmsc.Dependency#getTmsc()
	 * @see #getDependency()
	 * @generated
	 */
	EReference getDependency_Tmsc();

	/**
	 * Returns the meta object for the reference '{@link nl.esi.pps.tmsc.Dependency#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see nl.esi.pps.tmsc.Dependency#getSource()
	 * @see #getDependency()
	 * @generated
	 */
	EReference getDependency_Source();

	/**
	 * Returns the meta object for the reference '{@link nl.esi.pps.tmsc.Dependency#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see nl.esi.pps.tmsc.Dependency#getTarget()
	 * @see #getDependency()
	 * @generated
	 */
	EReference getDependency_Target();

	/**
	 * Returns the meta object for the reference list '{@link nl.esi.pps.tmsc.Dependency#getScopes <em>Scopes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Scopes</em>'.
	 * @see nl.esi.pps.tmsc.Dependency#getScopes()
	 * @see #getDependency()
	 * @generated
	 */
	EReference getDependency_Scopes();

	/**
	 * Returns the meta object for the attribute '{@link nl.esi.pps.tmsc.Dependency#getStartTime <em>Start Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Time</em>'.
	 * @see nl.esi.pps.tmsc.Dependency#getStartTime()
	 * @see #getDependency()
	 * @generated
	 */
	EAttribute getDependency_StartTime();

	/**
	 * Returns the meta object for the attribute '{@link nl.esi.pps.tmsc.Dependency#getEndTime <em>End Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Time</em>'.
	 * @see nl.esi.pps.tmsc.Dependency#getEndTime()
	 * @see #getDependency()
	 * @generated
	 */
	EAttribute getDependency_EndTime();

	/**
	 * Returns the meta object for the attribute '{@link nl.esi.pps.tmsc.Dependency#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration</em>'.
	 * @see nl.esi.pps.tmsc.Dependency#getDuration()
	 * @see #getDependency()
	 * @generated
	 */
	EAttribute getDependency_Duration();

	/**
	 * Returns the meta object for the attribute '{@link nl.esi.pps.tmsc.Dependency#getTimeBound <em>Time Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time Bound</em>'.
	 * @see nl.esi.pps.tmsc.Dependency#getTimeBound()
	 * @see #getDependency()
	 * @generated
	 */
	EAttribute getDependency_TimeBound();

	/**
	 * Returns the meta object for the attribute '{@link nl.esi.pps.tmsc.Dependency#getScheduled <em>Scheduled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scheduled</em>'.
	 * @see nl.esi.pps.tmsc.Dependency#getScheduled()
	 * @see #getDependency()
	 * @generated
	 */
	EAttribute getDependency_Scheduled();

	/**
	 * Returns the meta object for the attribute '{@link nl.esi.pps.tmsc.Dependency#isProjection <em>Projection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Projection</em>'.
	 * @see nl.esi.pps.tmsc.Dependency#isProjection()
	 * @see #getDependency()
	 * @generated
	 */
	EAttribute getDependency_Projection();

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.tmsc.Message <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message</em>'.
	 * @see nl.esi.pps.tmsc.Message
	 * @generated
	 */
	EClass getMessage();

	/**
	 * Returns the meta object for the reference list '{@link nl.esi.pps.tmsc.Message#getControlDependencies <em>Control Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Control Dependencies</em>'.
	 * @see nl.esi.pps.tmsc.Message#getControlDependencies()
	 * @see #getMessage()
	 * @generated
	 */
	EReference getMessage_ControlDependencies();

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.tmsc.Request <em>Request</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Request</em>'.
	 * @see nl.esi.pps.tmsc.Request
	 * @generated
	 */
	EClass getRequest();

	/**
	 * Returns the meta object for the reference list '{@link nl.esi.pps.tmsc.Request#getReplies <em>Replies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Replies</em>'.
	 * @see nl.esi.pps.tmsc.Request#getReplies()
	 * @see #getRequest()
	 * @generated
	 */
	EReference getRequest_Replies();

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.tmsc.Reply <em>Reply</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reply</em>'.
	 * @see nl.esi.pps.tmsc.Reply
	 * @generated
	 */
	EClass getReply();

	/**
	 * Returns the meta object for the reference '{@link nl.esi.pps.tmsc.Reply#getRequest <em>Request</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Request</em>'.
	 * @see nl.esi.pps.tmsc.Reply#getRequest()
	 * @see #getReply()
	 * @generated
	 */
	EReference getReply_Request();

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.tmsc.TMSC <em>TMSC</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TMSC</em>'.
	 * @see nl.esi.pps.tmsc.TMSC
	 * @generated
	 */
	EClass getTMSC();

	/**
	 * Returns the meta object for the containment reference list '{@link nl.esi.pps.tmsc.TMSC#getChildScopes <em>Child Scopes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Child Scopes</em>'.
	 * @see nl.esi.pps.tmsc.TMSC#getChildScopes()
	 * @see #getTMSC()
	 * @generated
	 */
	EReference getTMSC_ChildScopes();

	/**
	 * Returns the meta object for the reference '{@link nl.esi.pps.tmsc.TMSC#getFullScope <em>Full Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Full Scope</em>'.
	 * @see nl.esi.pps.tmsc.TMSC#getFullScope()
	 * @see #getTMSC()
	 * @generated
	 */
	EReference getTMSC_FullScope();

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.tmsc.ScopedTMSC <em>Scoped TMSC</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scoped TMSC</em>'.
	 * @see nl.esi.pps.tmsc.ScopedTMSC
	 * @generated
	 */
	EClass getScopedTMSC();

	/**
	 * Returns the meta object for the container reference '{@link nl.esi.pps.tmsc.ScopedTMSC#getParentScope <em>Parent Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Scope</em>'.
	 * @see nl.esi.pps.tmsc.ScopedTMSC#getParentScope()
	 * @see #getScopedTMSC()
	 * @generated
	 */
	EReference getScopedTMSC_ParentScope();

	/**
	 * Returns the meta object for the reference list '{@link nl.esi.pps.tmsc.ScopedTMSC#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dependencies</em>'.
	 * @see nl.esi.pps.tmsc.ScopedTMSC#getDependencies()
	 * @see #getScopedTMSC()
	 * @generated
	 */
	EReference getScopedTMSC_Dependencies();

	/**
	 * Returns the meta object for the reference list '{@link nl.esi.pps.tmsc.ScopedTMSC#getOrigin <em>Origin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Origin</em>'.
	 * @see nl.esi.pps.tmsc.ScopedTMSC#getOrigin()
	 * @see #getScopedTMSC()
	 * @generated
	 */
	EReference getScopedTMSC_Origin();

	/**
	 * Returns the meta object for the attribute '{@link nl.esi.pps.tmsc.ScopedTMSC#getFqn <em>Fqn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fqn</em>'.
	 * @see nl.esi.pps.tmsc.ScopedTMSC#getFqn()
	 * @see #getScopedTMSC()
	 * @generated
	 */
	EAttribute getScopedTMSC_Fqn();

	/**
	 * Returns the meta object for the attribute '{@link nl.esi.pps.tmsc.ScopedTMSC#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see nl.esi.pps.tmsc.ScopedTMSC#getName()
	 * @see #getScopedTMSC()
	 * @generated
	 */
	EAttribute getScopedTMSC_Name();

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.tmsc.DomainDependency <em>Domain Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain Dependency</em>'.
	 * @see nl.esi.pps.tmsc.DomainDependency
	 * @generated
	 */
	EClass getDomainDependency();

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.tmsc.Lifeline <em>Lifeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lifeline</em>'.
	 * @see nl.esi.pps.tmsc.Lifeline
	 * @generated
	 */
	EClass getLifeline();

	/**
	 * Returns the meta object for the container reference '{@link nl.esi.pps.tmsc.Lifeline#getTmsc <em>Tmsc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Tmsc</em>'.
	 * @see nl.esi.pps.tmsc.Lifeline#getTmsc()
	 * @see #getLifeline()
	 * @generated
	 */
	EReference getLifeline_Tmsc();

	/**
	 * Returns the meta object for the containment reference list '{@link nl.esi.pps.tmsc.Lifeline#getEvents <em>Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Events</em>'.
	 * @see nl.esi.pps.tmsc.Lifeline#getEvents()
	 * @see #getLifeline()
	 * @generated
	 */
	EReference getLifeline_Events();

	/**
	 * Returns the meta object for the containment reference list '{@link nl.esi.pps.tmsc.Lifeline#getExecutions <em>Executions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Executions</em>'.
	 * @see nl.esi.pps.tmsc.Lifeline#getExecutions()
	 * @see #getLifeline()
	 * @generated
	 */
	EReference getLifeline_Executions();

	/**
	 * Returns the meta object for the reference list '{@link nl.esi.pps.tmsc.Lifeline#getRootExecutions <em>Root Executions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Root Executions</em>'.
	 * @see nl.esi.pps.tmsc.Lifeline#getRootExecutions()
	 * @see #getLifeline()
	 * @generated
	 */
	EReference getLifeline_RootExecutions();

	/**
	 * Returns the meta object for the reference list '{@link nl.esi.pps.tmsc.Lifeline#getSegments <em>Segments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Segments</em>'.
	 * @see nl.esi.pps.tmsc.Lifeline#getSegments()
	 * @see #getLifeline()
	 * @generated
	 */
	EReference getLifeline_Segments();

	/**
	 * Returns the meta object for the reference '{@link nl.esi.pps.tmsc.Lifeline#getExecutor <em>Executor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Executor</em>'.
	 * @see nl.esi.pps.tmsc.Lifeline#getExecutor()
	 * @see #getLifeline()
	 * @generated
	 */
	EReference getLifeline_Executor();

	/**
	 * Returns the meta object for the attribute '{@link nl.esi.pps.tmsc.Lifeline#isTraced <em>Traced</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Traced</em>'.
	 * @see nl.esi.pps.tmsc.Lifeline#isTraced()
	 * @see #getLifeline()
	 * @generated
	 */
	EAttribute getLifeline_Traced();

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.tmsc.LifelineSegment <em>Lifeline Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lifeline Segment</em>'.
	 * @see nl.esi.pps.tmsc.LifelineSegment
	 * @generated
	 */
	EClass getLifelineSegment();

	/**
	 * Returns the meta object for the reference '{@link nl.esi.pps.tmsc.LifelineSegment#getLifeline <em>Lifeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Lifeline</em>'.
	 * @see nl.esi.pps.tmsc.LifelineSegment#getLifeline()
	 * @see #getLifelineSegment()
	 * @generated
	 */
	EReference getLifelineSegment_Lifeline();

	/**
	 * Returns the meta object for the reference '{@link nl.esi.pps.tmsc.LifelineSegment#getActiveExecution <em>Active Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Active Execution</em>'.
	 * @see nl.esi.pps.tmsc.LifelineSegment#getActiveExecution()
	 * @see #getLifelineSegment()
	 * @generated
	 */
	EReference getLifelineSegment_ActiveExecution();

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.tmsc.MessageControl <em>Message Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message Control</em>'.
	 * @see nl.esi.pps.tmsc.MessageControl
	 * @generated
	 */
	EClass getMessageControl();

	/**
	 * Returns the meta object for the reference '{@link nl.esi.pps.tmsc.MessageControl#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Message</em>'.
	 * @see nl.esi.pps.tmsc.MessageControl#getMessage()
	 * @see #getMessageControl()
	 * @generated
	 */
	EReference getMessageControl_Message();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Function Argument Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Argument Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="nl.esi.pps.architecture.implemented.FunctionParameter" keyRequired="true"
	 *        valueDataType="org.eclipse.emf.ecore.EString" valueRequired="true"
	 * @generated
	 */
	EClass getFunctionArgumentMapEntry();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getFunctionArgumentMapEntry()
	 * @generated
	 */
	EReference getFunctionArgumentMapEntry_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getFunctionArgumentMapEntry()
	 * @generated
	 */
	EAttribute getFunctionArgumentMapEntry_Value();

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.tmsc.Interval <em>Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interval</em>'.
	 * @see nl.esi.pps.tmsc.Interval
	 * @generated
	 */
	EClass getInterval();

	/**
	 * Returns the meta object for the reference '{@link nl.esi.pps.tmsc.Interval#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From</em>'.
	 * @see nl.esi.pps.tmsc.Interval#getFrom()
	 * @see #getInterval()
	 * @generated
	 */
	EReference getInterval_From();

	/**
	 * Returns the meta object for the reference '{@link nl.esi.pps.tmsc.Interval#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To</em>'.
	 * @see nl.esi.pps.tmsc.Interval#getTo()
	 * @see #getInterval()
	 * @generated
	 */
	EReference getInterval_To();

	/**
	 * Returns the meta object for the reference '{@link nl.esi.pps.tmsc.Interval#getTmsc <em>Tmsc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Tmsc</em>'.
	 * @see nl.esi.pps.tmsc.Interval#getTmsc()
	 * @see #getInterval()
	 * @generated
	 */
	EReference getInterval_Tmsc();

	/**
	 * Returns the meta object for the reference list '{@link nl.esi.pps.tmsc.Interval#getScopes <em>Scopes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Scopes</em>'.
	 * @see nl.esi.pps.tmsc.Interval#getScopes()
	 * @see #getInterval()
	 * @generated
	 */
	EReference getInterval_Scopes();

	/**
	 * Returns the meta object for the attribute '{@link nl.esi.pps.tmsc.Interval#getStartTime <em>Start Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Time</em>'.
	 * @see nl.esi.pps.tmsc.Interval#getStartTime()
	 * @see #getInterval()
	 * @generated
	 */
	EAttribute getInterval_StartTime();

	/**
	 * Returns the meta object for the attribute '{@link nl.esi.pps.tmsc.Interval#getEndTime <em>End Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Time</em>'.
	 * @see nl.esi.pps.tmsc.Interval#getEndTime()
	 * @see #getInterval()
	 * @generated
	 */
	EAttribute getInterval_EndTime();

	/**
	 * Returns the meta object for the attribute '{@link nl.esi.pps.tmsc.Interval#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration</em>'.
	 * @see nl.esi.pps.tmsc.Interval#getDuration()
	 * @see #getInterval()
	 * @generated
	 */
	EAttribute getInterval_Duration();

	/**
	 * Returns the meta object for the '{@link nl.esi.pps.tmsc.Interval#getName() <em>Get Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Name</em>' operation.
	 * @see nl.esi.pps.tmsc.Interval#getName()
	 * @generated
	 */
	EOperation getInterval__GetName();

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.tmsc.Measurement <em>Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Measurement</em>'.
	 * @see nl.esi.pps.tmsc.Measurement
	 * @generated
	 */
	EClass getMeasurement();

	/**
	 * Returns the meta object for the attribute '{@link nl.esi.pps.tmsc.Measurement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see nl.esi.pps.tmsc.Measurement#getName()
	 * @see #getMeasurement()
	 * @generated
	 */
	EAttribute getMeasurement_Name();

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.tmsc.ITMSC <em>ITMSC</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ITMSC</em>'.
	 * @see nl.esi.pps.tmsc.ITMSC
	 * @model instanceClass="nl.esi.pps.tmsc.ITMSC"
	 * @generated
	 */
	EClass getITMSC();

	/**
	 * Returns the meta object for the '{@link nl.esi.pps.tmsc.ITMSC#getEvents() <em>Get Events</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Events</em>' operation.
	 * @see nl.esi.pps.tmsc.ITMSC#getEvents()
	 * @generated
	 */
	EOperation getITMSC__GetEvents();

	/**
	 * Returns the meta object for the '{@link nl.esi.pps.tmsc.ITMSC#getDependencies() <em>Get Dependencies</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Dependencies</em>' operation.
	 * @see nl.esi.pps.tmsc.ITMSC#getDependencies()
	 * @generated
	 */
	EOperation getITMSC__GetDependencies();

	/**
	 * Returns the meta object for the '{@link nl.esi.pps.tmsc.ITMSC#getIncomingDependencies(nl.esi.pps.tmsc.Event) <em>Get Incoming Dependencies</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Incoming Dependencies</em>' operation.
	 * @see nl.esi.pps.tmsc.ITMSC#getIncomingDependencies(nl.esi.pps.tmsc.Event)
	 * @generated
	 */
	EOperation getITMSC__GetIncomingDependencies__Event();

	/**
	 * Returns the meta object for the '{@link nl.esi.pps.tmsc.ITMSC#getOutgoingDependencies(nl.esi.pps.tmsc.Event) <em>Get Outgoing Dependencies</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Outgoing Dependencies</em>' operation.
	 * @see nl.esi.pps.tmsc.ITMSC#getOutgoingDependencies(nl.esi.pps.tmsc.Event)
	 * @generated
	 */
	EOperation getITMSC__GetOutgoingDependencies__Event();

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.tmsc.EntryEvent <em>Entry Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entry Event</em>'.
	 * @see nl.esi.pps.tmsc.EntryEvent
	 * @generated
	 */
	EClass getEntryEvent();

	/**
	 * Returns the meta object for the reference '{@link nl.esi.pps.tmsc.EntryEvent#getExecution <em>Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Execution</em>'.
	 * @see nl.esi.pps.tmsc.EntryEvent#getExecution()
	 * @see #getEntryEvent()
	 * @generated
	 */
	EReference getEntryEvent_Execution();

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.tmsc.ExitEvent <em>Exit Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exit Event</em>'.
	 * @see nl.esi.pps.tmsc.ExitEvent
	 * @generated
	 */
	EClass getExitEvent();

	/**
	 * Returns the meta object for the reference '{@link nl.esi.pps.tmsc.ExitEvent#getExecution <em>Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Execution</em>'.
	 * @see nl.esi.pps.tmsc.ExitEvent#getExecution()
	 * @see #getExitEvent()
	 * @generated
	 */
	EReference getExitEvent_Execution();

	/**
	 * Returns the meta object for class '{@link nl.esi.pps.tmsc.ITimeRange <em>ITime Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ITime Range</em>'.
	 * @see nl.esi.pps.tmsc.ITimeRange
	 * @model instanceClass="nl.esi.pps.tmsc.ITimeRange"
	 * @generated
	 */
	EClass getITimeRange();

	/**
	 * Returns the meta object for the '{@link nl.esi.pps.tmsc.ITimeRange#getStartTime() <em>Get Start Time</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Start Time</em>' operation.
	 * @see nl.esi.pps.tmsc.ITimeRange#getStartTime()
	 * @generated
	 */
	EOperation getITimeRange__GetStartTime();

	/**
	 * Returns the meta object for the '{@link nl.esi.pps.tmsc.ITimeRange#getEndTime() <em>Get End Time</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get End Time</em>' operation.
	 * @see nl.esi.pps.tmsc.ITimeRange#getEndTime()
	 * @generated
	 */
	EOperation getITimeRange__GetEndTime();

	/**
	 * Returns the meta object for the '{@link nl.esi.pps.tmsc.ITimeRange#getDuration() <em>Get Duration</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Duration</em>' operation.
	 * @see nl.esi.pps.tmsc.ITimeRange#getDuration()
	 * @generated
	 */
	EOperation getITimeRange__GetDuration();

	/**
	 * Returns the meta object for the '{@link nl.esi.pps.tmsc.ITimeRange#getTmsc() <em>Get Tmsc</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Tmsc</em>' operation.
	 * @see nl.esi.pps.tmsc.ITimeRange#getTmsc()
	 * @generated
	 */
	EOperation getITimeRange__GetTmsc();

	/**
	 * Returns the meta object for data type '{@link java.lang.Long <em>ETimestamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Represents a time stamp in nanoseconds. 
	 * The timestamp can be either relative (i.e. relative to 0) or absolute (i.e. relative to the epoch). 
	 * Please note that {@link FullScopeTMSC#setEpochTime(boolean)} should be set accordingly.
	 * <!-- end-model-doc -->
	 * @return the meta object for data type '<em>ETimestamp</em>'.
	 * @see java.lang.Long
	 * @model instanceClass="java.lang.Long"
	 *        extendedMetaData="baseType='http://www.eclipse.org/emf/2002/Ecore#ELong' minInclusive='0'"
	 * @generated
	 */
	EDataType getETimestamp();

	/**
	 * Returns the meta object for data type '{@link java.lang.Long <em>EDuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Represents a duration in nanoseconds.
	 * <!-- end-model-doc -->
	 * @return the meta object for data type '<em>EDuration</em>'.
	 * @see java.lang.Long
	 * @model instanceClass="java.lang.Long"
	 *        extendedMetaData="baseType='http://www.eclipse.org/emf/2002/Ecore#ELong' minInclusive='0'"
	 * @generated
	 */
	EDataType getEDuration();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>EID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>EID</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="baseType='http://www.eclipse.org/emf/2002/Ecore#EString' pattern='[a-zA-Z_0-9]+'"
	 * @generated
	 */
	EDataType getEID();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TmscFactory getTmscFactory();

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
		 * The meta object literal for the '{@link nl.esi.pps.tmsc.impl.FullScopeTMSCImpl <em>Full Scope TMSC</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.tmsc.impl.FullScopeTMSCImpl
		 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getFullScopeTMSC()
		 * @generated
		 */
		EClass FULL_SCOPE_TMSC = eINSTANCE.getFullScopeTMSC();

		/**
		 * The meta object literal for the '<em><b>Measurements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FULL_SCOPE_TMSC__MEASUREMENTS = eINSTANCE.getFullScopeTMSC_Measurements();

		/**
		 * The meta object literal for the '<em><b>Lifelines</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FULL_SCOPE_TMSC__LIFELINES = eINSTANCE.getFullScopeTMSC_Lifelines();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FULL_SCOPE_TMSC__DEPENDENCIES = eINSTANCE.getFullScopeTMSC_Dependencies();

		/**
		 * The meta object literal for the '<em><b>Architectures</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FULL_SCOPE_TMSC__ARCHITECTURES = eINSTANCE.getFullScopeTMSC_Architectures();

		/**
		 * The meta object literal for the '<em><b>Epoch Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FULL_SCOPE_TMSC__EPOCH_TIME = eINSTANCE.getFullScopeTMSC_EpochTime();

		/**
		 * The meta object literal for the '<em><b>Start Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FULL_SCOPE_TMSC__START_TIME = eINSTANCE.getFullScopeTMSC_StartTime();

		/**
		 * The meta object literal for the '<em><b>End Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FULL_SCOPE_TMSC__END_TIME = eINSTANCE.getFullScopeTMSC_EndTime();

		/**
		 * The meta object literal for the '{@link nl.esi.pps.tmsc.impl.EventImpl <em>Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.tmsc.impl.EventImpl
		 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getEvent()
		 * @generated
		 */
		EClass EVENT = eINSTANCE.getEvent();

		/**
		 * The meta object literal for the '<em><b>Lifeline</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__LIFELINE = eINSTANCE.getEvent_Lifeline();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__ARGUMENTS = eINSTANCE.getEvent_Arguments();

		/**
		 * The meta object literal for the '<em><b>Full Scope Incoming Dependencies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__FULL_SCOPE_INCOMING_DEPENDENCIES = eINSTANCE.getEvent_FullScopeIncomingDependencies();

		/**
		 * The meta object literal for the '<em><b>Full Scope Outgoing Dependencies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__FULL_SCOPE_OUTGOING_DEPENDENCIES = eINSTANCE.getEvent_FullScopeOutgoingDependencies();

		/**
		 * The meta object literal for the '<em><b>Tmsc</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__TMSC = eINSTANCE.getEvent_Tmsc();

		/**
		 * The meta object literal for the '<em><b>Scopes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__SCOPES = eINSTANCE.getEvent_Scopes();

		/**
		 * The meta object literal for the '<em><b>Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__COMPONENT = eINSTANCE.getEvent_Component();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__FUNCTION = eINSTANCE.getEvent_Function();

		/**
		 * The meta object literal for the '<em><b>Timestamp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__TIMESTAMP = eINSTANCE.getEvent_Timestamp();

		/**
		 * The meta object literal for the '<em><b>Traced</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__TRACED = eINSTANCE.getEvent_Traced();

		/**
		 * The meta object literal for the '<em><b>Get Execution</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EVENT___GET_EXECUTION = eINSTANCE.getEvent__GetExecution();

		/**
		 * The meta object literal for the '<em><b>Set Execution</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EVENT___SET_EXECUTION__EXECUTION = eINSTANCE.getEvent__SetExecution__Execution();

		/**
		 * The meta object literal for the '{@link nl.esi.pps.tmsc.impl.ExecutionImpl <em>Execution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.tmsc.impl.ExecutionImpl
		 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getExecution()
		 * @generated
		 */
		EClass EXECUTION = eINSTANCE.getExecution();

		/**
		 * The meta object literal for the '<em><b>Lifeline</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION__LIFELINE = eINSTANCE.getExecution_Lifeline();

		/**
		 * The meta object literal for the '<em><b>Entry</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION__ENTRY = eINSTANCE.getExecution_Entry();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION__CHILDREN = eINSTANCE.getExecution_Children();

		/**
		 * The meta object literal for the '<em><b>Exit</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION__EXIT = eINSTANCE.getExecution_Exit();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION__PARENT = eINSTANCE.getExecution_Parent();

		/**
		 * The meta object literal for the '<em><b>Root</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION__ROOT = eINSTANCE.getExecution_Root();

		/**
		 * The meta object literal for the '<em><b>Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION__COMPONENT = eINSTANCE.getExecution_Component();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION__FUNCTION = eINSTANCE.getExecution_Function();

		/**
		 * The meta object literal for the '<em><b>Segments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION__SEGMENTS = eINSTANCE.getExecution_Segments();

		/**
		 * The meta object literal for the '<em><b>Start Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTION__START_TIME = eINSTANCE.getExecution_StartTime();

		/**
		 * The meta object literal for the '<em><b>End Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTION__END_TIME = eINSTANCE.getExecution_EndTime();

		/**
		 * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTION__DURATION = eINSTANCE.getExecution_Duration();

		/**
		 * The meta object literal for the '<em><b>Tmsc</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION__TMSC = eINSTANCE.getExecution_Tmsc();

		/**
		 * The meta object literal for the '{@link nl.esi.pps.tmsc.impl.DependencyImpl <em>Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.tmsc.impl.DependencyImpl
		 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getDependency()
		 * @generated
		 */
		EClass DEPENDENCY = eINSTANCE.getDependency();

		/**
		 * The meta object literal for the '<em><b>Tmsc</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY__TMSC = eINSTANCE.getDependency_Tmsc();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY__SOURCE = eINSTANCE.getDependency_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY__TARGET = eINSTANCE.getDependency_Target();

		/**
		 * The meta object literal for the '<em><b>Scopes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY__SCOPES = eINSTANCE.getDependency_Scopes();

		/**
		 * The meta object literal for the '<em><b>Start Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPENDENCY__START_TIME = eINSTANCE.getDependency_StartTime();

		/**
		 * The meta object literal for the '<em><b>End Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPENDENCY__END_TIME = eINSTANCE.getDependency_EndTime();

		/**
		 * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPENDENCY__DURATION = eINSTANCE.getDependency_Duration();

		/**
		 * The meta object literal for the '<em><b>Time Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPENDENCY__TIME_BOUND = eINSTANCE.getDependency_TimeBound();

		/**
		 * The meta object literal for the '<em><b>Scheduled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPENDENCY__SCHEDULED = eINSTANCE.getDependency_Scheduled();

		/**
		 * The meta object literal for the '<em><b>Projection</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPENDENCY__PROJECTION = eINSTANCE.getDependency_Projection();

		/**
		 * The meta object literal for the '{@link nl.esi.pps.tmsc.impl.MessageImpl <em>Message</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.tmsc.impl.MessageImpl
		 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getMessage()
		 * @generated
		 */
		EClass MESSAGE = eINSTANCE.getMessage();

		/**
		 * The meta object literal for the '<em><b>Control Dependencies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE__CONTROL_DEPENDENCIES = eINSTANCE.getMessage_ControlDependencies();

		/**
		 * The meta object literal for the '{@link nl.esi.pps.tmsc.impl.RequestImpl <em>Request</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.tmsc.impl.RequestImpl
		 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getRequest()
		 * @generated
		 */
		EClass REQUEST = eINSTANCE.getRequest();

		/**
		 * The meta object literal for the '<em><b>Replies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUEST__REPLIES = eINSTANCE.getRequest_Replies();

		/**
		 * The meta object literal for the '{@link nl.esi.pps.tmsc.impl.ReplyImpl <em>Reply</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.tmsc.impl.ReplyImpl
		 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getReply()
		 * @generated
		 */
		EClass REPLY = eINSTANCE.getReply();

		/**
		 * The meta object literal for the '<em><b>Request</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPLY__REQUEST = eINSTANCE.getReply_Request();

		/**
		 * The meta object literal for the '{@link nl.esi.pps.tmsc.impl.TMSCImpl <em>TMSC</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.tmsc.impl.TMSCImpl
		 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getTMSC()
		 * @generated
		 */
		EClass TMSC = eINSTANCE.getTMSC();

		/**
		 * The meta object literal for the '<em><b>Child Scopes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMSC__CHILD_SCOPES = eINSTANCE.getTMSC_ChildScopes();

		/**
		 * The meta object literal for the '<em><b>Full Scope</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMSC__FULL_SCOPE = eINSTANCE.getTMSC_FullScope();

		/**
		 * The meta object literal for the '{@link nl.esi.pps.tmsc.impl.ScopedTMSCImpl <em>Scoped TMSC</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.tmsc.impl.ScopedTMSCImpl
		 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getScopedTMSC()
		 * @generated
		 */
		EClass SCOPED_TMSC = eINSTANCE.getScopedTMSC();

		/**
		 * The meta object literal for the '<em><b>Parent Scope</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCOPED_TMSC__PARENT_SCOPE = eINSTANCE.getScopedTMSC_ParentScope();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCOPED_TMSC__DEPENDENCIES = eINSTANCE.getScopedTMSC_Dependencies();

		/**
		 * The meta object literal for the '<em><b>Origin</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCOPED_TMSC__ORIGIN = eINSTANCE.getScopedTMSC_Origin();

		/**
		 * The meta object literal for the '<em><b>Fqn</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCOPED_TMSC__FQN = eINSTANCE.getScopedTMSC_Fqn();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCOPED_TMSC__NAME = eINSTANCE.getScopedTMSC_Name();

		/**
		 * The meta object literal for the '{@link nl.esi.pps.tmsc.impl.DomainDependencyImpl <em>Domain Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.tmsc.impl.DomainDependencyImpl
		 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getDomainDependency()
		 * @generated
		 */
		EClass DOMAIN_DEPENDENCY = eINSTANCE.getDomainDependency();

		/**
		 * The meta object literal for the '{@link nl.esi.pps.tmsc.impl.LifelineImpl <em>Lifeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.tmsc.impl.LifelineImpl
		 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getLifeline()
		 * @generated
		 */
		EClass LIFELINE = eINSTANCE.getLifeline();

		/**
		 * The meta object literal for the '<em><b>Tmsc</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIFELINE__TMSC = eINSTANCE.getLifeline_Tmsc();

		/**
		 * The meta object literal for the '<em><b>Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIFELINE__EVENTS = eINSTANCE.getLifeline_Events();

		/**
		 * The meta object literal for the '<em><b>Executions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIFELINE__EXECUTIONS = eINSTANCE.getLifeline_Executions();

		/**
		 * The meta object literal for the '<em><b>Root Executions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIFELINE__ROOT_EXECUTIONS = eINSTANCE.getLifeline_RootExecutions();

		/**
		 * The meta object literal for the '<em><b>Segments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIFELINE__SEGMENTS = eINSTANCE.getLifeline_Segments();

		/**
		 * The meta object literal for the '<em><b>Executor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIFELINE__EXECUTOR = eINSTANCE.getLifeline_Executor();

		/**
		 * The meta object literal for the '<em><b>Traced</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIFELINE__TRACED = eINSTANCE.getLifeline_Traced();

		/**
		 * The meta object literal for the '{@link nl.esi.pps.tmsc.impl.LifelineSegmentImpl <em>Lifeline Segment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.tmsc.impl.LifelineSegmentImpl
		 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getLifelineSegment()
		 * @generated
		 */
		EClass LIFELINE_SEGMENT = eINSTANCE.getLifelineSegment();

		/**
		 * The meta object literal for the '<em><b>Lifeline</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIFELINE_SEGMENT__LIFELINE = eINSTANCE.getLifelineSegment_Lifeline();

		/**
		 * The meta object literal for the '<em><b>Active Execution</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIFELINE_SEGMENT__ACTIVE_EXECUTION = eINSTANCE.getLifelineSegment_ActiveExecution();

		/**
		 * The meta object literal for the '{@link nl.esi.pps.tmsc.impl.MessageControlImpl <em>Message Control</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.tmsc.impl.MessageControlImpl
		 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getMessageControl()
		 * @generated
		 */
		EClass MESSAGE_CONTROL = eINSTANCE.getMessageControl();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_CONTROL__MESSAGE = eINSTANCE.getMessageControl_Message();

		/**
		 * The meta object literal for the '{@link nl.esi.pps.tmsc.impl.FunctionArgumentMapEntryImpl <em>Function Argument Map Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.tmsc.impl.FunctionArgumentMapEntryImpl
		 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getFunctionArgumentMapEntry()
		 * @generated
		 */
		EClass FUNCTION_ARGUMENT_MAP_ENTRY = eINSTANCE.getFunctionArgumentMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_ARGUMENT_MAP_ENTRY__KEY = eINSTANCE.getFunctionArgumentMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION_ARGUMENT_MAP_ENTRY__VALUE = eINSTANCE.getFunctionArgumentMapEntry_Value();

		/**
		 * The meta object literal for the '{@link nl.esi.pps.tmsc.impl.IntervalImpl <em>Interval</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.tmsc.impl.IntervalImpl
		 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getInterval()
		 * @generated
		 */
		EClass INTERVAL = eINSTANCE.getInterval();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERVAL__FROM = eINSTANCE.getInterval_From();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERVAL__TO = eINSTANCE.getInterval_To();

		/**
		 * The meta object literal for the '<em><b>Tmsc</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERVAL__TMSC = eINSTANCE.getInterval_Tmsc();

		/**
		 * The meta object literal for the '<em><b>Scopes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERVAL__SCOPES = eINSTANCE.getInterval_Scopes();

		/**
		 * The meta object literal for the '<em><b>Start Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERVAL__START_TIME = eINSTANCE.getInterval_StartTime();

		/**
		 * The meta object literal for the '<em><b>End Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERVAL__END_TIME = eINSTANCE.getInterval_EndTime();

		/**
		 * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERVAL__DURATION = eINSTANCE.getInterval_Duration();

		/**
		 * The meta object literal for the '<em><b>Get Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INTERVAL___GET_NAME = eINSTANCE.getInterval__GetName();

		/**
		 * The meta object literal for the '{@link nl.esi.pps.tmsc.impl.MeasurementImpl <em>Measurement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.tmsc.impl.MeasurementImpl
		 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getMeasurement()
		 * @generated
		 */
		EClass MEASUREMENT = eINSTANCE.getMeasurement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASUREMENT__NAME = eINSTANCE.getMeasurement_Name();

		/**
		 * The meta object literal for the '{@link nl.esi.pps.tmsc.ITMSC <em>ITMSC</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.tmsc.ITMSC
		 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getITMSC()
		 * @generated
		 */
		EClass ITMSC = eINSTANCE.getITMSC();

		/**
		 * The meta object literal for the '<em><b>Get Events</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITMSC___GET_EVENTS = eINSTANCE.getITMSC__GetEvents();

		/**
		 * The meta object literal for the '<em><b>Get Dependencies</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITMSC___GET_DEPENDENCIES = eINSTANCE.getITMSC__GetDependencies();

		/**
		 * The meta object literal for the '<em><b>Get Incoming Dependencies</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITMSC___GET_INCOMING_DEPENDENCIES__EVENT = eINSTANCE.getITMSC__GetIncomingDependencies__Event();

		/**
		 * The meta object literal for the '<em><b>Get Outgoing Dependencies</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITMSC___GET_OUTGOING_DEPENDENCIES__EVENT = eINSTANCE.getITMSC__GetOutgoingDependencies__Event();

		/**
		 * The meta object literal for the '{@link nl.esi.pps.tmsc.impl.EntryEventImpl <em>Entry Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.tmsc.impl.EntryEventImpl
		 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getEntryEvent()
		 * @generated
		 */
		EClass ENTRY_EVENT = eINSTANCE.getEntryEvent();

		/**
		 * The meta object literal for the '<em><b>Execution</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTRY_EVENT__EXECUTION = eINSTANCE.getEntryEvent_Execution();

		/**
		 * The meta object literal for the '{@link nl.esi.pps.tmsc.impl.ExitEventImpl <em>Exit Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.tmsc.impl.ExitEventImpl
		 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getExitEvent()
		 * @generated
		 */
		EClass EXIT_EVENT = eINSTANCE.getExitEvent();

		/**
		 * The meta object literal for the '<em><b>Execution</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXIT_EVENT__EXECUTION = eINSTANCE.getExitEvent_Execution();

		/**
		 * The meta object literal for the '{@link nl.esi.pps.tmsc.ITimeRange <em>ITime Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esi.pps.tmsc.ITimeRange
		 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getITimeRange()
		 * @generated
		 */
		EClass ITIME_RANGE = eINSTANCE.getITimeRange();

		/**
		 * The meta object literal for the '<em><b>Get Start Time</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITIME_RANGE___GET_START_TIME = eINSTANCE.getITimeRange__GetStartTime();

		/**
		 * The meta object literal for the '<em><b>Get End Time</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITIME_RANGE___GET_END_TIME = eINSTANCE.getITimeRange__GetEndTime();

		/**
		 * The meta object literal for the '<em><b>Get Duration</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITIME_RANGE___GET_DURATION = eINSTANCE.getITimeRange__GetDuration();

		/**
		 * The meta object literal for the '<em><b>Get Tmsc</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ITIME_RANGE___GET_TMSC = eINSTANCE.getITimeRange__GetTmsc();

		/**
		 * The meta object literal for the '<em>ETimestamp</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Long
		 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getETimestamp()
		 * @generated
		 */
		EDataType ETIMESTAMP = eINSTANCE.getETimestamp();

		/**
		 * The meta object literal for the '<em>EDuration</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Long
		 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getEDuration()
		 * @generated
		 */
		EDataType EDURATION = eINSTANCE.getEDuration();

		/**
		 * The meta object literal for the '<em>EID</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see nl.esi.pps.tmsc.impl.TmscPackageImpl#getEID()
		 * @generated
		 */
		EDataType EID = eINSTANCE.getEID();

	}

} //TmscPackage
