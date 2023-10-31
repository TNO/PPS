/**
 */
package nl.esi.pps.tmsc;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see nl.esi.pps.tmsc.TmscPackage
 * @generated
 */
public interface TmscFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TmscFactory eINSTANCE = nl.esi.pps.tmsc.impl.TmscFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Full Scope TMSC</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Full Scope TMSC</em>'.
	 * @generated
	 */
	FullScopeTMSC createFullScopeTMSC();

	/**
	 * Returns a new object of class '<em>Execution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execution</em>'.
	 * @generated
	 */
	Execution createExecution();

	/**
	 * Returns a new object of class '<em>Message</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Message</em>'.
	 * @generated
	 */
	Message createMessage();

	/**
	 * Returns a new object of class '<em>Request</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Request</em>'.
	 * @generated
	 */
	Request createRequest();

	/**
	 * Returns a new object of class '<em>Reply</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reply</em>'.
	 * @generated
	 */
	Reply createReply();

	/**
	 * Returns a new object of class '<em>Scoped TMSC</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scoped TMSC</em>'.
	 * @generated
	 */
	ScopedTMSC createScopedTMSC();

	/**
	 * Returns a new object of class '<em>Domain Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Domain Dependency</em>'.
	 * @generated
	 */
	DomainDependency createDomainDependency();

	/**
	 * Returns a new object of class '<em>Lifeline</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lifeline</em>'.
	 * @generated
	 */
	Lifeline createLifeline();

	/**
	 * Returns a new object of class '<em>Lifeline Segment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lifeline Segment</em>'.
	 * @generated
	 */
	LifelineSegment createLifelineSegment();

	/**
	 * Returns a new object of class '<em>Message Control</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Message Control</em>'.
	 * @generated
	 */
	MessageControl createMessageControl();

	/**
	 * Returns a new object of class '<em>Measurement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Measurement</em>'.
	 * @generated
	 */
	Measurement createMeasurement();

	/**
	 * Returns a new object of class '<em>Entry Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entry Event</em>'.
	 * @generated
	 */
	EntryEvent createEntryEvent();

	/**
	 * Returns a new object of class '<em>Exit Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Exit Event</em>'.
	 * @generated
	 */
	ExitEvent createExitEvent();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TmscPackage getTmscPackage();

} //TmscFactory
