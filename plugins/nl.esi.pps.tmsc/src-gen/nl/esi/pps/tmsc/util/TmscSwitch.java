/**
 */
package nl.esi.pps.tmsc.util;

import java.util.Map;

import nl.esi.emf.properties.PropertiesContainer;

import nl.esi.pps.architecture.implemented.FunctionParameter;

import nl.esi.pps.tmsc.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see nl.esi.pps.tmsc.TmscPackage
 * @generated
 */
public class TmscSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TmscPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmscSwitch() {
		if (modelPackage == null) {
			modelPackage = TmscPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case TmscPackage.FULL_SCOPE_TMSC: {
			FullScopeTMSC fullScopeTMSC = (FullScopeTMSC) theEObject;
			T result = caseFullScopeTMSC(fullScopeTMSC);
			if (result == null)
				result = caseTMSC(fullScopeTMSC);
			if (result == null)
				result = casePropertiesContainer(fullScopeTMSC);
			if (result == null)
				result = caseITMSC(fullScopeTMSC);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case TmscPackage.EVENT: {
			Event event = (Event) theEObject;
			T result = caseEvent(event);
			if (result == null)
				result = casePropertiesContainer(event);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case TmscPackage.EXECUTION: {
			Execution execution = (Execution) theEObject;
			T result = caseExecution(execution);
			if (result == null)
				result = casePropertiesContainer(execution);
			if (result == null)
				result = caseITimeRange(execution);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case TmscPackage.DEPENDENCY: {
			Dependency dependency = (Dependency) theEObject;
			T result = caseDependency(dependency);
			if (result == null)
				result = casePropertiesContainer(dependency);
			if (result == null)
				result = caseITimeRange(dependency);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case TmscPackage.MESSAGE: {
			Message message = (Message) theEObject;
			T result = caseMessage(message);
			if (result == null)
				result = caseDependency(message);
			if (result == null)
				result = casePropertiesContainer(message);
			if (result == null)
				result = caseITimeRange(message);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case TmscPackage.REQUEST: {
			Request request = (Request) theEObject;
			T result = caseRequest(request);
			if (result == null)
				result = caseMessage(request);
			if (result == null)
				result = caseDependency(request);
			if (result == null)
				result = casePropertiesContainer(request);
			if (result == null)
				result = caseITimeRange(request);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case TmscPackage.REPLY: {
			Reply reply = (Reply) theEObject;
			T result = caseReply(reply);
			if (result == null)
				result = caseMessage(reply);
			if (result == null)
				result = caseDependency(reply);
			if (result == null)
				result = casePropertiesContainer(reply);
			if (result == null)
				result = caseITimeRange(reply);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case TmscPackage.TMSC: {
			TMSC tmsc = (TMSC) theEObject;
			T result = caseTMSC(tmsc);
			if (result == null)
				result = casePropertiesContainer(tmsc);
			if (result == null)
				result = caseITMSC(tmsc);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case TmscPackage.SCOPED_TMSC: {
			ScopedTMSC scopedTMSC = (ScopedTMSC) theEObject;
			T result = caseScopedTMSC(scopedTMSC);
			if (result == null)
				result = caseTMSC(scopedTMSC);
			if (result == null)
				result = casePropertiesContainer(scopedTMSC);
			if (result == null)
				result = caseITMSC(scopedTMSC);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case TmscPackage.DOMAIN_DEPENDENCY: {
			DomainDependency domainDependency = (DomainDependency) theEObject;
			T result = caseDomainDependency(domainDependency);
			if (result == null)
				result = caseDependency(domainDependency);
			if (result == null)
				result = casePropertiesContainer(domainDependency);
			if (result == null)
				result = caseITimeRange(domainDependency);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case TmscPackage.LIFELINE: {
			Lifeline lifeline = (Lifeline) theEObject;
			T result = caseLifeline(lifeline);
			if (result == null)
				result = casePropertiesContainer(lifeline);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case TmscPackage.LIFELINE_SEGMENT: {
			LifelineSegment lifelineSegment = (LifelineSegment) theEObject;
			T result = caseLifelineSegment(lifelineSegment);
			if (result == null)
				result = caseDependency(lifelineSegment);
			if (result == null)
				result = casePropertiesContainer(lifelineSegment);
			if (result == null)
				result = caseITimeRange(lifelineSegment);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case TmscPackage.MESSAGE_CONTROL: {
			MessageControl messageControl = (MessageControl) theEObject;
			T result = caseMessageControl(messageControl);
			if (result == null)
				result = caseDependency(messageControl);
			if (result == null)
				result = casePropertiesContainer(messageControl);
			if (result == null)
				result = caseITimeRange(messageControl);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case TmscPackage.FUNCTION_ARGUMENT_MAP_ENTRY: {
			@SuppressWarnings("unchecked")
			Map.Entry<FunctionParameter, String> functionArgumentMapEntry = (Map.Entry<FunctionParameter, String>) theEObject;
			T result = caseFunctionArgumentMapEntry(functionArgumentMapEntry);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case TmscPackage.INTERVAL: {
			Interval interval = (Interval) theEObject;
			T result = caseInterval(interval);
			if (result == null)
				result = casePropertiesContainer(interval);
			if (result == null)
				result = caseITimeRange(interval);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case TmscPackage.MEASUREMENT: {
			Measurement measurement = (Measurement) theEObject;
			T result = caseMeasurement(measurement);
			if (result == null)
				result = caseInterval(measurement);
			if (result == null)
				result = casePropertiesContainer(measurement);
			if (result == null)
				result = caseITimeRange(measurement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case TmscPackage.ITMSC: {
			ITMSC itmsc = (ITMSC) theEObject;
			T result = caseITMSC(itmsc);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case TmscPackage.ENTRY_EVENT: {
			EntryEvent entryEvent = (EntryEvent) theEObject;
			T result = caseEntryEvent(entryEvent);
			if (result == null)
				result = caseEvent(entryEvent);
			if (result == null)
				result = casePropertiesContainer(entryEvent);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case TmscPackage.EXIT_EVENT: {
			ExitEvent exitEvent = (ExitEvent) theEObject;
			T result = caseExitEvent(exitEvent);
			if (result == null)
				result = caseEvent(exitEvent);
			if (result == null)
				result = casePropertiesContainer(exitEvent);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case TmscPackage.ITIME_RANGE: {
			ITimeRange iTimeRange = (ITimeRange) theEObject;
			T result = caseITimeRange(iTimeRange);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Full Scope TMSC</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Full Scope TMSC</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFullScopeTMSC(FullScopeTMSC object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvent(Event object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Execution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Execution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExecution(Execution object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDependency(Dependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Message</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Message</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMessage(Message object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Request</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Request</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRequest(Request object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reply</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reply</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReply(Reply object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TMSC</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TMSC</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTMSC(TMSC object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scoped TMSC</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scoped TMSC</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScopedTMSC(ScopedTMSC object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Domain Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Domain Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDomainDependency(DomainDependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Lifeline</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lifeline</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLifeline(Lifeline object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Lifeline Segment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lifeline Segment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLifelineSegment(LifelineSegment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Message Control</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Message Control</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMessageControl(MessageControl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Argument Map Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Argument Map Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionArgumentMapEntry(Map.Entry<FunctionParameter, String> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interval</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interval</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterval(Interval object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Measurement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Measurement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMeasurement(Measurement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ITMSC</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ITMSC</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseITMSC(ITMSC object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entry Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entry Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntryEvent(EntryEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exit Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exit Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExitEvent(ExitEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ITime Range</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ITime Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseITimeRange(ITimeRange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertiesContainer(PropertiesContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //TmscSwitch
