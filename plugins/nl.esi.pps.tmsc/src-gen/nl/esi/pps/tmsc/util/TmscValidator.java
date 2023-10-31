/**
 */
package nl.esi.pps.tmsc.util;

import java.util.Map;

import nl.esi.pps.tmsc.*;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.emf.ecore.xml.type.util.XMLTypeUtil;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see nl.esi.pps.tmsc.TmscPackage
 * @generated
 */
public class TmscValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final TmscValidator INSTANCE = new TmscValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "nl.esi.pps.tmsc";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmscValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
		return TmscPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		switch (classifierID) {
		case TmscPackage.FULL_SCOPE_TMSC:
			return validateFullScopeTMSC((FullScopeTMSC) value, diagnostics, context);
		case TmscPackage.EVENT:
			return validateEvent((Event) value, diagnostics, context);
		case TmscPackage.EXECUTION:
			return validateExecution((Execution) value, diagnostics, context);
		case TmscPackage.DEPENDENCY:
			return validateDependency((Dependency) value, diagnostics, context);
		case TmscPackage.MESSAGE:
			return validateMessage((Message) value, diagnostics, context);
		case TmscPackage.REQUEST:
			return validateRequest((Request) value, diagnostics, context);
		case TmscPackage.REPLY:
			return validateReply((Reply) value, diagnostics, context);
		case TmscPackage.TMSC:
			return validateTMSC((TMSC) value, diagnostics, context);
		case TmscPackage.SCOPED_TMSC:
			return validateScopedTMSC((ScopedTMSC) value, diagnostics, context);
		case TmscPackage.DOMAIN_DEPENDENCY:
			return validateDomainDependency((DomainDependency) value, diagnostics, context);
		case TmscPackage.LIFELINE:
			return validateLifeline((Lifeline) value, diagnostics, context);
		case TmscPackage.LIFELINE_SEGMENT:
			return validateLifelineSegment((LifelineSegment) value, diagnostics, context);
		case TmscPackage.MESSAGE_CONTROL:
			return validateMessageControl((MessageControl) value, diagnostics, context);
		case TmscPackage.FUNCTION_ARGUMENT_MAP_ENTRY:
			return validateFunctionArgumentMapEntry((Map.Entry<?, ?>) value, diagnostics, context);
		case TmscPackage.INTERVAL:
			return validateInterval((Interval) value, diagnostics, context);
		case TmscPackage.MEASUREMENT:
			return validateMeasurement((Measurement) value, diagnostics, context);
		case TmscPackage.ITMSC:
			return validateITMSC((ITMSC) value, diagnostics, context);
		case TmscPackage.ENTRY_EVENT:
			return validateEntryEvent((EntryEvent) value, diagnostics, context);
		case TmscPackage.EXIT_EVENT:
			return validateExitEvent((ExitEvent) value, diagnostics, context);
		case TmscPackage.ITIME_RANGE:
			return validateITimeRange((ITimeRange) value, diagnostics, context);
		case TmscPackage.ETIMESTAMP:
			return validateETimestamp((Long) value, diagnostics, context);
		case TmscPackage.EDURATION:
			return validateEDuration((Long) value, diagnostics, context);
		case TmscPackage.EID:
			return validateEID((String) value, diagnostics, context);
		default:
			return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFullScopeTMSC(FullScopeTMSC fullScopeTMSC, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(fullScopeTMSC, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEvent(Event event, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(event, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExecution(Execution execution, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(execution, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDependency(Dependency dependency, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(dependency, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMessage(Message message, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(message, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRequest(Request request, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(request, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReply(Reply reply, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(reply, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTMSC(TMSC tmsc, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(tmsc, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateScopedTMSC(ScopedTMSC scopedTMSC, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(scopedTMSC, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDomainDependency(DomainDependency domainDependency, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(domainDependency, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLifeline(Lifeline lifeline, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(lifeline, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLifelineSegment(LifelineSegment lifelineSegment, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(lifelineSegment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMessageControl(MessageControl messageControl, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(messageControl, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunctionArgumentMapEntry(Map.Entry<?, ?> functionArgumentMapEntry,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject) functionArgumentMapEntry, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInterval(Interval interval, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(interval, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMeasurement(Measurement measurement, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(measurement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateITMSC(ITMSC itmsc, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject) itmsc, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEntryEvent(EntryEvent entryEvent, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(entryEvent, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExitEvent(ExitEvent exitEvent, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(exitEvent, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateITimeRange(ITimeRange iTimeRange, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject) iTimeRange, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateETimestamp(Long eTimestamp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateETimestamp_Min(eTimestamp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validateETimestamp_Min
	 */
	public static final Long ETIMESTAMP__MIN__VALUE = 0L;

	/**
	 * Validates the Min constraint of '<em>ETimestamp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateETimestamp_Min(Long eTimestamp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = eTimestamp.compareTo(ETIMESTAMP__MIN__VALUE) >= 0;
		if (!result && diagnostics != null)
			reportMinViolation(TmscPackage.Literals.ETIMESTAMP, eTimestamp, ETIMESTAMP__MIN__VALUE, true, diagnostics,
					context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEDuration(Long eDuration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateEDuration_Min(eDuration, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validateEDuration_Min
	 */
	public static final Long EDURATION__MIN__VALUE = 0L;

	/**
	 * Validates the Min constraint of '<em>EDuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEDuration_Min(Long eDuration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = eDuration.compareTo(EDURATION__MIN__VALUE) >= 0;
		if (!result && diagnostics != null)
			reportMinViolation(TmscPackage.Literals.EDURATION, eDuration, EDURATION__MIN__VALUE, true, diagnostics,
					context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEID(String eid, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateEID_Pattern(eid, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validateEID_Pattern
	 */
	public static final PatternMatcher[][] EID__PATTERN__VALUES = new PatternMatcher[][] {
			new PatternMatcher[] { XMLTypeUtil.createPatternMatcher("[a-zA-Z_0-9]+") } };

	/**
	 * Validates the Pattern constraint of '<em>EID</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEID_Pattern(String eid, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validatePattern(TmscPackage.Literals.EID, eid, EID__PATTERN__VALUES, diagnostics, context);
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //TmscValidator
