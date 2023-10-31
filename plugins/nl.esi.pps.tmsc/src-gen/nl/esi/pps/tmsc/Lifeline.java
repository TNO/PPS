/**
 */
package nl.esi.pps.tmsc;

import nl.esi.emf.properties.PropertiesContainer;

import nl.esi.pps.architecture.instantiated.Executor;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lifeline</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Lifeline is the modeling element as defined in the UML Message Sequence Chart formalism and it is equivalent only to the instantiated nature (viewpoint) of the Component modeling element as defined in the abstract TMSC meta-model. 
 * A lifeline contains the behavior of an Executor, in the form of a sequence of events, over a specific time span.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.Lifeline#getTmsc <em>Tmsc</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Lifeline#getEvents <em>Events</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Lifeline#getExecutions <em>Executions</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Lifeline#getRootExecutions <em>Root Executions</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Lifeline#getSegments <em>Segments</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Lifeline#getExecutor <em>Executor</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Lifeline#isTraced <em>Traced</em>}</li>
 * </ul>
 *
 * @see nl.esi.pps.tmsc.TmscPackage#getLifeline()
 * @model
 * @generated
 */
public interface Lifeline extends PropertiesContainer {
	/**
	 * Returns the value of the '<em><b>Tmsc</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.tmsc.FullScopeTMSC#getLifelines <em>Lifelines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tmsc</em>' container reference.
	 * @see #setTmsc(FullScopeTMSC)
	 * @see nl.esi.pps.tmsc.TmscPackage#getLifeline_Tmsc()
	 * @see nl.esi.pps.tmsc.FullScopeTMSC#getLifelines
	 * @model opposite="lifelines" required="true" transient="false"
	 * @generated
	 */
	FullScopeTMSC getTmsc();

	/**
	 * Sets the value of the '{@link nl.esi.pps.tmsc.Lifeline#getTmsc <em>Tmsc</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tmsc</em>' container reference.
	 * @see #getTmsc()
	 * @generated
	 */
	void setTmsc(FullScopeTMSC value);

	/**
	 * Returns the value of the '<em><b>Events</b></em>' containment reference list.
	 * The list contents are of type {@link nl.esi.pps.tmsc.Event}.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.tmsc.Event#getLifeline <em>Lifeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Events</em>' containment reference list.
	 * @see nl.esi.pps.tmsc.TmscPackage#getLifeline_Events()
	 * @see nl.esi.pps.tmsc.Event#getLifeline
	 * @model opposite="lifeline" containment="true"
	 * @generated
	 */
	EList<Event> getEvents();

	/**
	 * Returns the value of the '<em><b>Executions</b></em>' containment reference list.
	 * The list contents are of type {@link nl.esi.pps.tmsc.Execution}.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.tmsc.Execution#getLifeline <em>Lifeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Executions</em>' containment reference list.
	 * @see nl.esi.pps.tmsc.TmscPackage#getLifeline_Executions()
	 * @see nl.esi.pps.tmsc.Execution#getLifeline
	 * @model opposite="lifeline" containment="true"
	 * @generated
	 */
	EList<Execution> getExecutions();

	/**
	 * Returns the value of the '<em><b>Root Executions</b></em>' reference list.
	 * The list contents are of type {@link nl.esi.pps.tmsc.Execution}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns the executions that are at the highest level of the call-stack, i.e., that do not have any parent execution.
	 * 
	 * Note that this is a derived 'many' relation. Though the return type 'EList' provides methods to alter the content, no altering method should be used and will throw an UnsupportedOperationException upon usage.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Root Executions</em>' reference list.
	 * @see nl.esi.pps.tmsc.TmscPackage#getLifeline_RootExecutions()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Execution> getRootExecutions();

	/**
	 * Returns the value of the '<em><b>Segments</b></em>' reference list.
	 * The list contents are of type {@link nl.esi.pps.tmsc.LifelineSegment}.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.tmsc.LifelineSegment#getLifeline <em>Lifeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Note that this is a derived 'many' relation. Though the return type 'EList' provides methods to alter the content, no altering method should be used and will throw an UnsupportedOperationException upon usage.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Segments</em>' reference list.
	 * @see nl.esi.pps.tmsc.TmscPackage#getLifeline_Segments()
	 * @see nl.esi.pps.tmsc.LifelineSegment#getLifeline
	 * @model opposite="lifeline" resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<LifelineSegment> getSegments();

	/**
	 * Returns the value of the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Executor</em>' reference.
	 * @see #setExecutor(Executor)
	 * @see nl.esi.pps.tmsc.TmscPackage#getLifeline_Executor()
	 * @model required="true"
	 * @generated
	 */
	Executor getExecutor();

	/**
	 * Sets the value of the '{@link nl.esi.pps.tmsc.Lifeline#getExecutor <em>Executor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Executor</em>' reference.
	 * @see #getExecutor()
	 * @generated
	 */
	void setExecutor(Executor value);

	/**
	 * Returns the value of the '<em><b>Traced</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Traced</em>' attribute.
	 * @see nl.esi.pps.tmsc.TmscPackage#getLifeline_Traced()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isTraced();

} // Lifeline
