/**
 */
package nl.esi.pps.tmsc.impl;

import java.util.Map;

import nl.esi.pps.architecture.implemented.FunctionParameter;

import nl.esi.pps.tmsc.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TmscFactoryImpl extends EFactoryImpl implements TmscFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TmscFactory init() {
		try {
			TmscFactory theTmscFactory = (TmscFactory) EPackage.Registry.INSTANCE.getEFactory(TmscPackage.eNS_URI);
			if (theTmscFactory != null) {
				return theTmscFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TmscFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmscFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case TmscPackage.FULL_SCOPE_TMSC:
			return createFullScopeTMSC();
		case TmscPackage.EXECUTION:
			return createExecution();
		case TmscPackage.MESSAGE:
			return createMessage();
		case TmscPackage.REQUEST:
			return createRequest();
		case TmscPackage.REPLY:
			return createReply();
		case TmscPackage.SCOPED_TMSC:
			return createScopedTMSC();
		case TmscPackage.DOMAIN_DEPENDENCY:
			return createDomainDependency();
		case TmscPackage.LIFELINE:
			return createLifeline();
		case TmscPackage.LIFELINE_SEGMENT:
			return createLifelineSegment();
		case TmscPackage.MESSAGE_CONTROL:
			return createMessageControl();
		case TmscPackage.FUNCTION_ARGUMENT_MAP_ENTRY:
			return (EObject) createFunctionArgumentMapEntry();
		case TmscPackage.MEASUREMENT:
			return createMeasurement();
		case TmscPackage.ENTRY_EVENT:
			return createEntryEvent();
		case TmscPackage.EXIT_EVENT:
			return createExitEvent();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case TmscPackage.ETIMESTAMP:
			return createETimestampFromString(eDataType, initialValue);
		case TmscPackage.EDURATION:
			return createEDurationFromString(eDataType, initialValue);
		case TmscPackage.EID:
			return createEIDFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case TmscPackage.ETIMESTAMP:
			return convertETimestampToString(eDataType, instanceValue);
		case TmscPackage.EDURATION:
			return convertEDurationToString(eDataType, instanceValue);
		case TmscPackage.EID:
			return convertEIDToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FullScopeTMSC createFullScopeTMSC() {
		FullScopeTMSCImpl fullScopeTMSC = new FullScopeTMSCImpl();
		return fullScopeTMSC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Execution createExecution() {
		ExecutionImpl execution = new ExecutionImpl();
		return execution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Message createMessage() {
		MessageImpl message = new MessageImpl();
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Request createRequest() {
		RequestImpl request = new RequestImpl();
		return request;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Reply createReply() {
		ReplyImpl reply = new ReplyImpl();
		return reply;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ScopedTMSC createScopedTMSC() {
		ScopedTMSCImpl scopedTMSC = new ScopedTMSCImpl();
		return scopedTMSC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DomainDependency createDomainDependency() {
		DomainDependencyImpl domainDependency = new DomainDependencyImpl();
		return domainDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Lifeline createLifeline() {
		LifelineImpl lifeline = new LifelineImpl();
		return lifeline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LifelineSegment createLifelineSegment() {
		LifelineSegmentImpl lifelineSegment = new LifelineSegmentImpl();
		return lifelineSegment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MessageControl createMessageControl() {
		MessageControlImpl messageControl = new MessageControlImpl();
		return messageControl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<FunctionParameter, String> createFunctionArgumentMapEntry() {
		FunctionArgumentMapEntryImpl functionArgumentMapEntry = new FunctionArgumentMapEntryImpl();
		return functionArgumentMapEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Measurement createMeasurement() {
		MeasurementImpl measurement = new MeasurementImpl();
		return measurement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EntryEvent createEntryEvent() {
		EntryEventImpl entryEvent = new EntryEventImpl();
		return entryEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExitEvent createExitEvent() {
		ExitEventImpl exitEvent = new ExitEventImpl();
		return exitEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long createETimestampFromString(EDataType eDataType, String initialValue) {
		return (Long) EcoreFactory.eINSTANCE.createFromString(EcorePackage.Literals.ELONG, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertETimestampToString(EDataType eDataType, Object instanceValue) {
		return EcoreFactory.eINSTANCE.convertToString(EcorePackage.Literals.ELONG, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long createEDurationFromString(EDataType eDataType, String initialValue) {
		return (Long) EcoreFactory.eINSTANCE.createFromString(EcorePackage.Literals.ELONG, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEDurationToString(EDataType eDataType, Object instanceValue) {
		return EcoreFactory.eINSTANCE.convertToString(EcorePackage.Literals.ELONG, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createEIDFromString(EDataType eDataType, String initialValue) {
		return (String) EcoreFactory.eINSTANCE.createFromString(EcorePackage.Literals.ESTRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEIDToString(EDataType eDataType, Object instanceValue) {
		return EcoreFactory.eINSTANCE.convertToString(EcorePackage.Literals.ESTRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmscPackage getTmscPackage() {
		return (TmscPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TmscPackage getPackage() {
		return TmscPackage.eINSTANCE;
	}

} //TmscFactoryImpl
