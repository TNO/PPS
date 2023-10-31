/**
 */
package nl.esi.pps.tmsc.util;

import java.util.Map;

import nl.esi.emf.properties.PropertiesContainer;

import nl.esi.pps.architecture.implemented.FunctionParameter;

import nl.esi.pps.tmsc.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see nl.esi.pps.tmsc.TmscPackage
 * @generated
 */
public class TmscAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TmscPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmscAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = TmscPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TmscSwitch<Adapter> modelSwitch = new TmscSwitch<Adapter>() {
		@Override
		public Adapter caseFullScopeTMSC(FullScopeTMSC object) {
			return createFullScopeTMSCAdapter();
		}

		@Override
		public Adapter caseEvent(Event object) {
			return createEventAdapter();
		}

		@Override
		public Adapter caseExecution(Execution object) {
			return createExecutionAdapter();
		}

		@Override
		public Adapter caseDependency(Dependency object) {
			return createDependencyAdapter();
		}

		@Override
		public Adapter caseMessage(Message object) {
			return createMessageAdapter();
		}

		@Override
		public Adapter caseRequest(Request object) {
			return createRequestAdapter();
		}

		@Override
		public Adapter caseReply(Reply object) {
			return createReplyAdapter();
		}

		@Override
		public Adapter caseTMSC(TMSC object) {
			return createTMSCAdapter();
		}

		@Override
		public Adapter caseScopedTMSC(ScopedTMSC object) {
			return createScopedTMSCAdapter();
		}

		@Override
		public Adapter caseDomainDependency(DomainDependency object) {
			return createDomainDependencyAdapter();
		}

		@Override
		public Adapter caseLifeline(Lifeline object) {
			return createLifelineAdapter();
		}

		@Override
		public Adapter caseLifelineSegment(LifelineSegment object) {
			return createLifelineSegmentAdapter();
		}

		@Override
		public Adapter caseMessageControl(MessageControl object) {
			return createMessageControlAdapter();
		}

		@Override
		public Adapter caseFunctionArgumentMapEntry(Map.Entry<FunctionParameter, String> object) {
			return createFunctionArgumentMapEntryAdapter();
		}

		@Override
		public Adapter caseInterval(Interval object) {
			return createIntervalAdapter();
		}

		@Override
		public Adapter caseMeasurement(Measurement object) {
			return createMeasurementAdapter();
		}

		@Override
		public Adapter caseITMSC(ITMSC object) {
			return createITMSCAdapter();
		}

		@Override
		public Adapter caseEntryEvent(EntryEvent object) {
			return createEntryEventAdapter();
		}

		@Override
		public Adapter caseExitEvent(ExitEvent object) {
			return createExitEventAdapter();
		}

		@Override
		public Adapter caseITimeRange(ITimeRange object) {
			return createITimeRangeAdapter();
		}

		@Override
		public Adapter casePropertiesContainer(PropertiesContainer object) {
			return createPropertiesContainerAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esi.pps.tmsc.FullScopeTMSC <em>Full Scope TMSC</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esi.pps.tmsc.FullScopeTMSC
	 * @generated
	 */
	public Adapter createFullScopeTMSCAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esi.pps.tmsc.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esi.pps.tmsc.Event
	 * @generated
	 */
	public Adapter createEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esi.pps.tmsc.Execution <em>Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esi.pps.tmsc.Execution
	 * @generated
	 */
	public Adapter createExecutionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esi.pps.tmsc.Dependency <em>Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esi.pps.tmsc.Dependency
	 * @generated
	 */
	public Adapter createDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esi.pps.tmsc.Message <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esi.pps.tmsc.Message
	 * @generated
	 */
	public Adapter createMessageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esi.pps.tmsc.Request <em>Request</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esi.pps.tmsc.Request
	 * @generated
	 */
	public Adapter createRequestAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esi.pps.tmsc.Reply <em>Reply</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esi.pps.tmsc.Reply
	 * @generated
	 */
	public Adapter createReplyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esi.pps.tmsc.TMSC <em>TMSC</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esi.pps.tmsc.TMSC
	 * @generated
	 */
	public Adapter createTMSCAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esi.pps.tmsc.ScopedTMSC <em>Scoped TMSC</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esi.pps.tmsc.ScopedTMSC
	 * @generated
	 */
	public Adapter createScopedTMSCAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esi.pps.tmsc.DomainDependency <em>Domain Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esi.pps.tmsc.DomainDependency
	 * @generated
	 */
	public Adapter createDomainDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esi.pps.tmsc.Lifeline <em>Lifeline</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esi.pps.tmsc.Lifeline
	 * @generated
	 */
	public Adapter createLifelineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esi.pps.tmsc.LifelineSegment <em>Lifeline Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esi.pps.tmsc.LifelineSegment
	 * @generated
	 */
	public Adapter createLifelineSegmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esi.pps.tmsc.MessageControl <em>Message Control</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esi.pps.tmsc.MessageControl
	 * @generated
	 */
	public Adapter createMessageControlAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Function Argument Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createFunctionArgumentMapEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esi.pps.tmsc.Interval <em>Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esi.pps.tmsc.Interval
	 * @generated
	 */
	public Adapter createIntervalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esi.pps.tmsc.Measurement <em>Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esi.pps.tmsc.Measurement
	 * @generated
	 */
	public Adapter createMeasurementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esi.pps.tmsc.ITMSC <em>ITMSC</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esi.pps.tmsc.ITMSC
	 * @generated
	 */
	public Adapter createITMSCAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esi.pps.tmsc.EntryEvent <em>Entry Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esi.pps.tmsc.EntryEvent
	 * @generated
	 */
	public Adapter createEntryEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esi.pps.tmsc.ExitEvent <em>Exit Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esi.pps.tmsc.ExitEvent
	 * @generated
	 */
	public Adapter createExitEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esi.pps.tmsc.ITimeRange <em>ITime Range</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esi.pps.tmsc.ITimeRange
	 * @generated
	 */
	public Adapter createITimeRangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esi.emf.properties.PropertiesContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esi.emf.properties.PropertiesContainer
	 * @generated
	 */
	public Adapter createPropertiesContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //TmscAdapterFactory
