/**
 */
package nl.esi.pps.tmsc;

import nl.esi.emf.properties.PropertiesContainer;

import nl.esi.pps.architecture.implemented.Function;
import nl.esi.pps.architecture.implemented.FunctionParameter;

import nl.esi.pps.architecture.specified.Component;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.Event#getLifeline <em>Lifeline</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Event#getArguments <em>Arguments</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Event#getFullScopeIncomingDependencies <em>Full Scope Incoming Dependencies</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Event#getFullScopeOutgoingDependencies <em>Full Scope Outgoing Dependencies</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Event#getTmsc <em>Tmsc</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Event#getScopes <em>Scopes</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Event#getComponent <em>Component</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Event#getFunction <em>Function</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Event#getTimestamp <em>Timestamp</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Event#isTraced <em>Traced</em>}</li>
 * </ul>
 *
 * @see nl.esi.pps.tmsc.TmscPackage#getEvent()
 * @model abstract="true"
 * @generated
 */
public interface Event extends PropertiesContainer {
	/**
	 * Returns the value of the '<em><b>Lifeline</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.tmsc.Lifeline#getEvents <em>Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lifeline</em>' container reference.
	 * @see #setLifeline(Lifeline)
	 * @see nl.esi.pps.tmsc.TmscPackage#getEvent_Lifeline()
	 * @see nl.esi.pps.tmsc.Lifeline#getEvents
	 * @model opposite="events" required="true" transient="false"
	 * @generated
	 */
	Lifeline getLifeline();

	/**
	 * Sets the value of the '{@link nl.esi.pps.tmsc.Event#getLifeline <em>Lifeline</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lifeline</em>' container reference.
	 * @see #getLifeline()
	 * @generated
	 */
	void setLifeline(Lifeline value);

	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' map.
	 * The key is of type {@link nl.esi.pps.architecture.implemented.FunctionParameter},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' map.
	 * @see nl.esi.pps.tmsc.TmscPackage#getEvent_Arguments()
	 * @model mapType="nl.esi.pps.tmsc.FunctionArgumentMapEntry&lt;nl.esi.pps.architecture.implemented.FunctionParameter, org.eclipse.emf.ecore.EString&gt;"
	 * @generated
	 */
	EMap<FunctionParameter, String> getArguments();

	/**
	 * Returns the value of the '<em><b>Full Scope Incoming Dependencies</b></em>' reference list.
	 * The list contents are of type {@link nl.esi.pps.tmsc.Dependency}.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.tmsc.Dependency#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Full Scope Incoming Dependencies</em>' reference list.
	 * @see nl.esi.pps.tmsc.TmscPackage#getEvent_FullScopeIncomingDependencies()
	 * @see nl.esi.pps.tmsc.Dependency#getTarget
	 * @model opposite="target" resolveProxies="false"
	 * @generated
	 */
	EList<Dependency> getFullScopeIncomingDependencies();

	/**
	 * Returns the value of the '<em><b>Full Scope Outgoing Dependencies</b></em>' reference list.
	 * The list contents are of type {@link nl.esi.pps.tmsc.Dependency}.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.tmsc.Dependency#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Full Scope Outgoing Dependencies</em>' reference list.
	 * @see nl.esi.pps.tmsc.TmscPackage#getEvent_FullScopeOutgoingDependencies()
	 * @see nl.esi.pps.tmsc.Dependency#getSource
	 * @model opposite="source" resolveProxies="false"
	 * @generated
	 */
	EList<Dependency> getFullScopeOutgoingDependencies();

	/**
	 * Returns the value of the '<em><b>Tmsc</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tmsc</em>' reference.
	 * @see nl.esi.pps.tmsc.TmscPackage#getEvent_Tmsc()
	 * @model resolveProxies="false" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	FullScopeTMSC getTmsc();

	/**
	 * Returns the value of the '<em><b>Scopes</b></em>' reference list.
	 * The list contents are of type {@link nl.esi.pps.tmsc.ScopedTMSC}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Note that this is a derived 'many' relation. Though the return type 'EList' provides methods to alter the content, no altering method should be used and will throw an UnsupportedOperationException upon usage.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Scopes</em>' reference list.
	 * @see nl.esi.pps.tmsc.TmscPackage#getEvent_Scopes()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<ScopedTMSC> getScopes();

	/**
	 * Returns the value of the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component</em>' reference.
	 * @see #setComponent(Component)
	 * @see nl.esi.pps.tmsc.TmscPackage#getEvent_Component()
	 * @model required="true"
	 * @generated
	 */
	Component getComponent();

	/**
	 * Sets the value of the '{@link nl.esi.pps.tmsc.Event#getComponent <em>Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component</em>' reference.
	 * @see #getComponent()
	 * @generated
	 */
	void setComponent(Component value);

	/**
	 * Returns the value of the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function</em>' reference.
	 * @see #setFunction(Function)
	 * @see nl.esi.pps.tmsc.TmscPackage#getEvent_Function()
	 * @model required="true"
	 * @generated
	 */
	Function getFunction();

	/**
	 * Sets the value of the '{@link nl.esi.pps.tmsc.Event#getFunction <em>Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function</em>' reference.
	 * @see #getFunction()
	 * @generated
	 */
	void setFunction(Function value);

	/**
	 * Returns the value of the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timestamp</em>' attribute.
	 * @see #setTimestamp(Long)
	 * @see nl.esi.pps.tmsc.TmscPackage#getEvent_Timestamp()
	 * @model dataType="nl.esi.pps.tmsc.ETimestamp" required="true"
	 * @generated
	 */
	Long getTimestamp();

	/**
	 * Sets the value of the '{@link nl.esi.pps.tmsc.Event#getTimestamp <em>Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timestamp</em>' attribute.
	 * @see #getTimestamp()
	 * @generated
	 */
	void setTimestamp(Long value);

	/**
	 * Returns the value of the '<em><b>Traced</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Traced</em>' attribute.
	 * @see #setTraced(boolean)
	 * @see nl.esi.pps.tmsc.TmscPackage#getEvent_Traced()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isTraced();

	/**
	 * Sets the value of the '{@link nl.esi.pps.tmsc.Event#isTraced <em>Traced</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Traced</em>' attribute.
	 * @see #isTraced()
	 * @generated
	 */
	void setTraced(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Execution getExecution();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setExecution(Execution Execution);

} // Event
