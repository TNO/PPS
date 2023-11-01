/**
 */
package nl.esi.pps.tmsc;

import nl.esi.emf.properties.PropertiesContainer;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.Dependency#getTmsc <em>Tmsc</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Dependency#getSource <em>Source</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Dependency#getTarget <em>Target</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Dependency#getScopes <em>Scopes</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Dependency#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Dependency#getEndTime <em>End Time</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Dependency#getDuration <em>Duration</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Dependency#getTimeBound <em>Time Bound</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Dependency#getScheduled <em>Scheduled</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Dependency#isProjection <em>Projection</em>}</li>
 * </ul>
 *
 * @see nl.esi.pps.tmsc.TmscPackage#getDependency()
 * @model abstract="true" superTypes="nl.esi.emf.properties.PropertiesContainer nl.esi.pps.tmsc.ITimeRange"
 * @generated
 */
public interface Dependency extends PropertiesContainer, ITimeRange {
	/**
	 * Returns the value of the '<em><b>Tmsc</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.tmsc.FullScopeTMSC#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tmsc</em>' container reference.
	 * @see #setTmsc(FullScopeTMSC)
	 * @see nl.esi.pps.tmsc.TmscPackage#getDependency_Tmsc()
	 * @see nl.esi.pps.tmsc.FullScopeTMSC#getDependencies
	 * @model opposite="dependencies" required="true" transient="false"
	 * @generated
	 */
	FullScopeTMSC getTmsc();

	/**
	 * Sets the value of the '{@link nl.esi.pps.tmsc.Dependency#getTmsc <em>Tmsc</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tmsc</em>' container reference.
	 * @see #getTmsc()
	 * @generated
	 */
	void setTmsc(FullScopeTMSC value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.tmsc.Event#getFullScopeOutgoingDependencies <em>Full Scope Outgoing Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Event)
	 * @see nl.esi.pps.tmsc.TmscPackage#getDependency_Source()
	 * @see nl.esi.pps.tmsc.Event#getFullScopeOutgoingDependencies
	 * @model opposite="fullScopeOutgoingDependencies" resolveProxies="false" required="true" transient="true"
	 * @generated
	 */
	Event getSource();

	/**
	 * Sets the value of the '{@link nl.esi.pps.tmsc.Dependency#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Event value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.tmsc.Event#getFullScopeIncomingDependencies <em>Full Scope Incoming Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Event)
	 * @see nl.esi.pps.tmsc.TmscPackage#getDependency_Target()
	 * @see nl.esi.pps.tmsc.Event#getFullScopeIncomingDependencies
	 * @model opposite="fullScopeIncomingDependencies" resolveProxies="false" required="true" transient="true"
	 * @generated
	 */
	Event getTarget();

	/**
	 * Sets the value of the '{@link nl.esi.pps.tmsc.Dependency#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Event value);

	/**
	 * Returns the value of the '<em><b>Scopes</b></em>' reference list.
	 * The list contents are of type {@link nl.esi.pps.tmsc.ScopedTMSC}.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.tmsc.ScopedTMSC#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * All dependencies of a child-scope ScopedTMSC should be contained by its parent-scope TMSC.
	 * 
	 * Note that this is a derived 'many' relation. Though the return type 'EList' provides methods to alter the content, no altering method should be used and will throw an UnsupportedOperationException upon usage.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Scopes</em>' reference list.
	 * @see nl.esi.pps.tmsc.TmscPackage#getDependency_Scopes()
	 * @see nl.esi.pps.tmsc.ScopedTMSC#getDependencies
	 * @model opposite="dependencies" resolveProxies="false" transient="true" ordered="false"
	 * @generated
	 */
	EList<ScopedTMSC> getScopes();

	/**
	 * Returns the value of the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Time</em>' attribute.
	 * @see nl.esi.pps.tmsc.TmscPackage#getDependency_StartTime()
	 * @model dataType="nl.esi.pps.tmsc.ETimestamp" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Long getStartTime();

	/**
	 * Returns the value of the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Time</em>' attribute.
	 * @see nl.esi.pps.tmsc.TmscPackage#getDependency_EndTime()
	 * @model dataType="nl.esi.pps.tmsc.ETimestamp" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Long getEndTime();

	/**
	 * Returns the value of the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duration</em>' attribute.
	 * @see nl.esi.pps.tmsc.TmscPackage#getDependency_Duration()
	 * @model dataType="nl.esi.pps.tmsc.EDuration" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Long getDuration();

	/**
	 * Returns the value of the '<em><b>Time Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The time-bound specifies the lowerbound for the duration of this dependency. This analysis attribute is used in e.g. critical-path and slack analysis.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Time Bound</em>' attribute.
	 * @see #setTimeBound(Long)
	 * @see nl.esi.pps.tmsc.TmscPackage#getDependency_TimeBound()
	 * @model dataType="nl.esi.pps.tmsc.EDuration"
	 * @generated
	 */
	Long getTimeBound();

	/**
	 * Sets the value of the '{@link nl.esi.pps.tmsc.Dependency#getTimeBound <em>Time Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Bound</em>' attribute.
	 * @see #getTimeBound()
	 * @generated
	 */
	void setTimeBound(Long value);

	/**
	 * Returns the value of the '<em><b>Scheduled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If true,  this dependency was induced by the (software) platform as result of scheduling. 
	 * If false, this dependency reflects a control or data dependency as programmed in code.
	 * By default Executions and LifelineSegments-without-activeExecution are considered to be scheduled dependencies, see TmscRefinements#refineWithCallStacks(Lifeline).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Scheduled</em>' attribute.
	 * @see #setScheduled(Boolean)
	 * @see nl.esi.pps.tmsc.TmscPackage#getDependency_Scheduled()
	 * @model
	 * @generated
	 */
	Boolean getScheduled();

	/**
	 * Sets the value of the '{@link nl.esi.pps.tmsc.Dependency#getScheduled <em>Scheduled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scheduled</em>' attribute.
	 * @see #getScheduled()
	 * @generated
	 */
	void setScheduled(Boolean value);

	/**
	 * Returns the value of the '<em><b>Projection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If true, this dependency was not originally part of the TMSC, but is an effect of projection, see nl.esi.pps.tmsc.util.TmscProjection class.
	 * Projections should typically not be visible to the user, unless they provide additional information.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Projection</em>' attribute.
	 * @see #setProjection(boolean)
	 * @see nl.esi.pps.tmsc.TmscPackage#getDependency_Projection()
	 * @model
	 * @generated
	 */
	boolean isProjection();

	/**
	 * Sets the value of the '{@link nl.esi.pps.tmsc.Dependency#isProjection <em>Projection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Projection</em>' attribute.
	 * @see #isProjection()
	 * @generated
	 */
	void setProjection(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isEpochTime();

} // Dependency
