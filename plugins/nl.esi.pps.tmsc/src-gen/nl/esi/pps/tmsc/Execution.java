/**
 */
package nl.esi.pps.tmsc;

import nl.esi.emf.properties.PropertiesContainer;

import nl.esi.pps.architecture.implemented.Function;

import nl.esi.pps.architecture.specified.Component;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Execution should be considered final and should not be overridden. 
 * Executions are added by means of a refinement transformation, see {@link nl.esi.pps.tmsc.transform.TmscRefinements#refineWithCallStacks(FullScopeTMSC)}
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.Execution#getLifeline <em>Lifeline</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Execution#getEntry <em>Entry</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Execution#getChildren <em>Children</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Execution#getExit <em>Exit</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Execution#getParent <em>Parent</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Execution#getRoot <em>Root</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Execution#getComponent <em>Component</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Execution#getFunction <em>Function</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Execution#getSegments <em>Segments</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Execution#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Execution#getEndTime <em>End Time</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Execution#getDuration <em>Duration</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.Execution#getTmsc <em>Tmsc</em>}</li>
 * </ul>
 *
 * @see nl.esi.pps.tmsc.TmscPackage#getExecution()
 * @model superTypes="nl.esi.emf.properties.PropertiesContainer nl.esi.pps.tmsc.ITimeRange"
 * @generated
 */
public interface Execution extends PropertiesContainer, ITimeRange {
	/**
	 * Returns the value of the '<em><b>Lifeline</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.tmsc.Lifeline#getExecutions <em>Executions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lifeline</em>' container reference.
	 * @see #setLifeline(Lifeline)
	 * @see nl.esi.pps.tmsc.TmscPackage#getExecution_Lifeline()
	 * @see nl.esi.pps.tmsc.Lifeline#getExecutions
	 * @model opposite="executions" resolveProxies="false" required="true"
	 * @generated
	 */
	Lifeline getLifeline();

	/**
	 * Sets the value of the '{@link nl.esi.pps.tmsc.Execution#getLifeline <em>Lifeline</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lifeline</em>' container reference.
	 * @see #getLifeline()
	 * @generated
	 */
	void setLifeline(Lifeline value);

	/**
	 * Returns the value of the '<em><b>Entry</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.tmsc.EntryEvent#getExecution <em>Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry</em>' reference.
	 * @see #setEntry(EntryEvent)
	 * @see nl.esi.pps.tmsc.TmscPackage#getExecution_Entry()
	 * @see nl.esi.pps.tmsc.EntryEvent#getExecution
	 * @model opposite="execution" resolveProxies="false" required="true"
	 * @generated
	 */
	EntryEvent getEntry();

	/**
	 * Sets the value of the '{@link nl.esi.pps.tmsc.Execution#getEntry <em>Entry</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entry</em>' reference.
	 * @see #getEntry()
	 * @generated
	 */
	void setEntry(EntryEvent value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' reference list.
	 * The list contents are of type {@link nl.esi.pps.tmsc.Execution}.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.tmsc.Execution#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' reference list.
	 * @see nl.esi.pps.tmsc.TmscPackage#getExecution_Children()
	 * @see nl.esi.pps.tmsc.Execution#getParent
	 * @model opposite="parent" resolveProxies="false"
	 * @generated
	 */
	EList<Execution> getChildren();

	/**
	 * Returns the value of the '<em><b>Exit</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.tmsc.ExitEvent#getExecution <em>Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exit</em>' reference.
	 * @see #setExit(ExitEvent)
	 * @see nl.esi.pps.tmsc.TmscPackage#getExecution_Exit()
	 * @see nl.esi.pps.tmsc.ExitEvent#getExecution
	 * @model opposite="execution" resolveProxies="false" required="true"
	 * @generated
	 */
	ExitEvent getExit();

	/**
	 * Sets the value of the '{@link nl.esi.pps.tmsc.Execution#getExit <em>Exit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exit</em>' reference.
	 * @see #getExit()
	 * @generated
	 */
	void setExit(ExitEvent value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.tmsc.Execution#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Definition 2.3.5
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(Execution)
	 * @see nl.esi.pps.tmsc.TmscPackage#getExecution_Parent()
	 * @see nl.esi.pps.tmsc.Execution#getChildren
	 * @model opposite="children" resolveProxies="false" transient="true"
	 * @generated
	 */
	Execution getParent();

	/**
	 * Sets the value of the '{@link nl.esi.pps.tmsc.Execution#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Execution value);

	/**
	 * Returns the value of the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' reference.
	 * @see nl.esi.pps.tmsc.TmscPackage#getExecution_Root()
	 * @model resolveProxies="false" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Execution getRoot();

	/**
	 * Returns the value of the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component</em>' reference.
	 * @see nl.esi.pps.tmsc.TmscPackage#getExecution_Component()
	 * @model resolveProxies="false" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Component getComponent();

	/**
	 * Returns the value of the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function</em>' reference.
	 * @see nl.esi.pps.tmsc.TmscPackage#getExecution_Function()
	 * @model resolveProxies="false" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Function getFunction();

	/**
	 * Returns the value of the '<em><b>Segments</b></em>' reference list.
	 * The list contents are of type {@link nl.esi.pps.tmsc.LifelineSegment}.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.tmsc.LifelineSegment#getActiveExecution <em>Active Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns the LifeLineSegments for which this Execution is the active execution on its LifeLine.
	 * 
	 * Note that this is a derived 'many' relation. Though the return type 'EList' provides methods to alter the content, no altering method should be used and will throw an UnsupportedOperationException upon usage.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Segments</em>' reference list.
	 * @see nl.esi.pps.tmsc.TmscPackage#getExecution_Segments()
	 * @see nl.esi.pps.tmsc.LifelineSegment#getActiveExecution
	 * @model opposite="activeExecution" resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<LifelineSegment> getSegments();

	/**
	 * Returns the value of the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Time</em>' attribute.
	 * @see nl.esi.pps.tmsc.TmscPackage#getExecution_StartTime()
	 * @model dataType="nl.esi.pps.tmsc.ETimestamp" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Long getStartTime();

	/**
	 * Returns the value of the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Time</em>' attribute.
	 * @see nl.esi.pps.tmsc.TmscPackage#getExecution_EndTime()
	 * @model dataType="nl.esi.pps.tmsc.ETimestamp" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Long getEndTime();

	/**
	 * Returns the value of the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duration</em>' attribute.
	 * @see nl.esi.pps.tmsc.TmscPackage#getExecution_Duration()
	 * @model dataType="nl.esi.pps.tmsc.EDuration" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Long getDuration();

	/**
	 * Returns the value of the '<em><b>Tmsc</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tmsc</em>' reference.
	 * @see nl.esi.pps.tmsc.TmscPackage#getExecution_Tmsc()
	 * @model resolveProxies="false" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	FullScopeTMSC getTmsc();

} // Execution
