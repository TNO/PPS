/**
 */
package nl.esi.pps.tmsc.impl;

import java.util.Map;

import nl.esi.emf.properties.PropertiesPackage;

import nl.esi.pps.architecture.ArchitecturePackage;

import nl.esi.pps.architecture.implemented.ImplementedPackage;

import nl.esi.pps.architecture.instantiated.InstantiatedPackage;

import nl.esi.pps.architecture.specified.SpecifiedPackage;

import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.DomainDependency;
import nl.esi.pps.tmsc.EntryEvent;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.ExitEvent;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.ITimeRange;
import nl.esi.pps.tmsc.Interval;
import nl.esi.pps.tmsc.Lifeline;
import nl.esi.pps.tmsc.LifelineSegment;
import nl.esi.pps.tmsc.Measurement;
import nl.esi.pps.tmsc.Message;
import nl.esi.pps.tmsc.MessageControl;
import nl.esi.pps.tmsc.Reply;
import nl.esi.pps.tmsc.Request;
import nl.esi.pps.tmsc.ScopedTMSC;
import nl.esi.pps.tmsc.TmscFactory;
import nl.esi.pps.tmsc.TmscPackage;

import nl.esi.pps.tmsc.util.TmscValidator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TmscPackageImpl extends EPackageImpl implements TmscPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fullScopeTMSCEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass executionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass messageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass replyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tmscEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scopedTMSCEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass domainDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lifelineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lifelineSegmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass messageControlEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionArgumentMapEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intervalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass measurementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass itmscEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entryEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exitEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iTimeRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType eTimestampEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType eDurationEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType eidEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see nl.esi.pps.tmsc.TmscPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TmscPackageImpl() {
		super(eNS_URI, TmscFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link TmscPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TmscPackage init() {
		if (isInited)
			return (TmscPackage) EPackage.Registry.INSTANCE.getEPackage(TmscPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredTmscPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		TmscPackageImpl theTmscPackage = registeredTmscPackage instanceof TmscPackageImpl
				? (TmscPackageImpl) registeredTmscPackage
				: new TmscPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		ArchitecturePackage.eINSTANCE.eClass();
		PropertiesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theTmscPackage.createPackageContents();

		// Initialize created meta-data
		theTmscPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put(theTmscPackage, new EValidator.Descriptor() {
			@Override
			public EValidator getEValidator() {
				return TmscValidator.INSTANCE;
			}
		});

		// Mark meta-data to indicate it can't be changed
		theTmscPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TmscPackage.eNS_URI, theTmscPackage);
		return theTmscPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFullScopeTMSC() {
		return fullScopeTMSCEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFullScopeTMSC_Measurements() {
		return (EReference) fullScopeTMSCEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFullScopeTMSC_Lifelines() {
		return (EReference) fullScopeTMSCEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFullScopeTMSC_Dependencies() {
		return (EReference) fullScopeTMSCEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFullScopeTMSC_Architectures() {
		return (EReference) fullScopeTMSCEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFullScopeTMSC_EpochTime() {
		return (EAttribute) fullScopeTMSCEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFullScopeTMSC_StartTime() {
		return (EAttribute) fullScopeTMSCEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFullScopeTMSC_EndTime() {
		return (EAttribute) fullScopeTMSCEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEvent() {
		return eventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEvent_Lifeline() {
		return (EReference) eventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEvent_Arguments() {
		return (EReference) eventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEvent_FullScopeIncomingDependencies() {
		return (EReference) eventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEvent_FullScopeOutgoingDependencies() {
		return (EReference) eventEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEvent_Tmsc() {
		return (EReference) eventEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEvent_Scopes() {
		return (EReference) eventEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEvent_Component() {
		return (EReference) eventEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEvent_Function() {
		return (EReference) eventEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEvent_Timestamp() {
		return (EAttribute) eventEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEvent_Traced() {
		return (EAttribute) eventEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getEvent__GetExecution() {
		return eventEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getEvent__SetExecution__Execution() {
		return eventEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExecution() {
		return executionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExecution_Lifeline() {
		return (EReference) executionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExecution_Entry() {
		return (EReference) executionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExecution_Children() {
		return (EReference) executionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExecution_Exit() {
		return (EReference) executionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExecution_Parent() {
		return (EReference) executionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExecution_Root() {
		return (EReference) executionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExecution_Component() {
		return (EReference) executionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExecution_Function() {
		return (EReference) executionEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExecution_Segments() {
		return (EReference) executionEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getExecution_StartTime() {
		return (EAttribute) executionEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getExecution_EndTime() {
		return (EAttribute) executionEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getExecution_Duration() {
		return (EAttribute) executionEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExecution_Tmsc() {
		return (EReference) executionEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDependency() {
		return dependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDependency_Tmsc() {
		return (EReference) dependencyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDependency_Source() {
		return (EReference) dependencyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDependency_Target() {
		return (EReference) dependencyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDependency_Scopes() {
		return (EReference) dependencyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDependency_StartTime() {
		return (EAttribute) dependencyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDependency_EndTime() {
		return (EAttribute) dependencyEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDependency_Duration() {
		return (EAttribute) dependencyEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDependency_TimeBound() {
		return (EAttribute) dependencyEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDependency_Scheduled() {
		return (EAttribute) dependencyEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDependency_Projection() {
		return (EAttribute) dependencyEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMessage() {
		return messageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMessage_ControlDependencies() {
		return (EReference) messageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRequest() {
		return requestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRequest_Replies() {
		return (EReference) requestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getReply() {
		return replyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getReply_Request() {
		return (EReference) replyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTMSC() {
		return tmscEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTMSC_ChildScopes() {
		return (EReference) tmscEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTMSC_FullScope() {
		return (EReference) tmscEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getScopedTMSC() {
		return scopedTMSCEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScopedTMSC_ParentScope() {
		return (EReference) scopedTMSCEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScopedTMSC_Dependencies() {
		return (EReference) scopedTMSCEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScopedTMSC_Origin() {
		return (EReference) scopedTMSCEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getScopedTMSC_Fqn() {
		return (EAttribute) scopedTMSCEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getScopedTMSC_Name() {
		return (EAttribute) scopedTMSCEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDomainDependency() {
		return domainDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLifeline() {
		return lifelineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLifeline_Tmsc() {
		return (EReference) lifelineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLifeline_Events() {
		return (EReference) lifelineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLifeline_Executions() {
		return (EReference) lifelineEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLifeline_RootExecutions() {
		return (EReference) lifelineEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLifeline_Segments() {
		return (EReference) lifelineEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLifeline_Executor() {
		return (EReference) lifelineEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLifeline_Traced() {
		return (EAttribute) lifelineEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLifelineSegment() {
		return lifelineSegmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLifelineSegment_Lifeline() {
		return (EReference) lifelineSegmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLifelineSegment_ActiveExecution() {
		return (EReference) lifelineSegmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMessageControl() {
		return messageControlEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMessageControl_Message() {
		return (EReference) messageControlEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFunctionArgumentMapEntry() {
		return functionArgumentMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFunctionArgumentMapEntry_Key() {
		return (EReference) functionArgumentMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFunctionArgumentMapEntry_Value() {
		return (EAttribute) functionArgumentMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInterval() {
		return intervalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInterval_From() {
		return (EReference) intervalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInterval_To() {
		return (EReference) intervalEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInterval_Tmsc() {
		return (EReference) intervalEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInterval_Scopes() {
		return (EReference) intervalEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInterval_StartTime() {
		return (EAttribute) intervalEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInterval_EndTime() {
		return (EAttribute) intervalEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInterval_Duration() {
		return (EAttribute) intervalEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getInterval__GetName() {
		return intervalEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMeasurement() {
		return measurementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMeasurement_Name() {
		return (EAttribute) measurementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getITMSC() {
		return itmscEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getITMSC__GetEvents() {
		return itmscEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getITMSC__GetDependencies() {
		return itmscEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getITMSC__GetIncomingDependencies__Event() {
		return itmscEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getITMSC__GetOutgoingDependencies__Event() {
		return itmscEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEntryEvent() {
		return entryEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEntryEvent_Execution() {
		return (EReference) entryEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExitEvent() {
		return exitEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExitEvent_Execution() {
		return (EReference) exitEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getITimeRange() {
		return iTimeRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getITimeRange__GetStartTime() {
		return iTimeRangeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getITimeRange__GetEndTime() {
		return iTimeRangeEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getITimeRange__GetDuration() {
		return iTimeRangeEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getITimeRange__GetTmsc() {
		return iTimeRangeEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getETimestamp() {
		return eTimestampEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getEDuration() {
		return eDurationEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getEID() {
		return eidEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmscFactory getTmscFactory() {
		return (TmscFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		fullScopeTMSCEClass = createEClass(FULL_SCOPE_TMSC);
		createEReference(fullScopeTMSCEClass, FULL_SCOPE_TMSC__MEASUREMENTS);
		createEReference(fullScopeTMSCEClass, FULL_SCOPE_TMSC__LIFELINES);
		createEReference(fullScopeTMSCEClass, FULL_SCOPE_TMSC__DEPENDENCIES);
		createEReference(fullScopeTMSCEClass, FULL_SCOPE_TMSC__ARCHITECTURES);
		createEAttribute(fullScopeTMSCEClass, FULL_SCOPE_TMSC__EPOCH_TIME);
		createEAttribute(fullScopeTMSCEClass, FULL_SCOPE_TMSC__START_TIME);
		createEAttribute(fullScopeTMSCEClass, FULL_SCOPE_TMSC__END_TIME);

		eventEClass = createEClass(EVENT);
		createEReference(eventEClass, EVENT__LIFELINE);
		createEReference(eventEClass, EVENT__ARGUMENTS);
		createEReference(eventEClass, EVENT__FULL_SCOPE_INCOMING_DEPENDENCIES);
		createEReference(eventEClass, EVENT__FULL_SCOPE_OUTGOING_DEPENDENCIES);
		createEReference(eventEClass, EVENT__TMSC);
		createEReference(eventEClass, EVENT__SCOPES);
		createEReference(eventEClass, EVENT__COMPONENT);
		createEReference(eventEClass, EVENT__FUNCTION);
		createEAttribute(eventEClass, EVENT__TIMESTAMP);
		createEAttribute(eventEClass, EVENT__TRACED);
		createEOperation(eventEClass, EVENT___GET_EXECUTION);
		createEOperation(eventEClass, EVENT___SET_EXECUTION__EXECUTION);

		executionEClass = createEClass(EXECUTION);
		createEReference(executionEClass, EXECUTION__LIFELINE);
		createEReference(executionEClass, EXECUTION__ENTRY);
		createEReference(executionEClass, EXECUTION__CHILDREN);
		createEReference(executionEClass, EXECUTION__EXIT);
		createEReference(executionEClass, EXECUTION__PARENT);
		createEReference(executionEClass, EXECUTION__ROOT);
		createEReference(executionEClass, EXECUTION__COMPONENT);
		createEReference(executionEClass, EXECUTION__FUNCTION);
		createEReference(executionEClass, EXECUTION__SEGMENTS);
		createEAttribute(executionEClass, EXECUTION__START_TIME);
		createEAttribute(executionEClass, EXECUTION__END_TIME);
		createEAttribute(executionEClass, EXECUTION__DURATION);
		createEReference(executionEClass, EXECUTION__TMSC);

		dependencyEClass = createEClass(DEPENDENCY);
		createEReference(dependencyEClass, DEPENDENCY__TMSC);
		createEReference(dependencyEClass, DEPENDENCY__SOURCE);
		createEReference(dependencyEClass, DEPENDENCY__TARGET);
		createEReference(dependencyEClass, DEPENDENCY__SCOPES);
		createEAttribute(dependencyEClass, DEPENDENCY__START_TIME);
		createEAttribute(dependencyEClass, DEPENDENCY__END_TIME);
		createEAttribute(dependencyEClass, DEPENDENCY__DURATION);
		createEAttribute(dependencyEClass, DEPENDENCY__TIME_BOUND);
		createEAttribute(dependencyEClass, DEPENDENCY__SCHEDULED);
		createEAttribute(dependencyEClass, DEPENDENCY__PROJECTION);

		messageEClass = createEClass(MESSAGE);
		createEReference(messageEClass, MESSAGE__CONTROL_DEPENDENCIES);

		requestEClass = createEClass(REQUEST);
		createEReference(requestEClass, REQUEST__REPLIES);

		replyEClass = createEClass(REPLY);
		createEReference(replyEClass, REPLY__REQUEST);

		tmscEClass = createEClass(TMSC);
		createEReference(tmscEClass, TMSC__CHILD_SCOPES);
		createEReference(tmscEClass, TMSC__FULL_SCOPE);

		scopedTMSCEClass = createEClass(SCOPED_TMSC);
		createEReference(scopedTMSCEClass, SCOPED_TMSC__PARENT_SCOPE);
		createEReference(scopedTMSCEClass, SCOPED_TMSC__DEPENDENCIES);
		createEReference(scopedTMSCEClass, SCOPED_TMSC__ORIGIN);
		createEAttribute(scopedTMSCEClass, SCOPED_TMSC__FQN);
		createEAttribute(scopedTMSCEClass, SCOPED_TMSC__NAME);

		domainDependencyEClass = createEClass(DOMAIN_DEPENDENCY);

		lifelineEClass = createEClass(LIFELINE);
		createEReference(lifelineEClass, LIFELINE__TMSC);
		createEReference(lifelineEClass, LIFELINE__EVENTS);
		createEReference(lifelineEClass, LIFELINE__EXECUTIONS);
		createEReference(lifelineEClass, LIFELINE__ROOT_EXECUTIONS);
		createEReference(lifelineEClass, LIFELINE__SEGMENTS);
		createEReference(lifelineEClass, LIFELINE__EXECUTOR);
		createEAttribute(lifelineEClass, LIFELINE__TRACED);

		lifelineSegmentEClass = createEClass(LIFELINE_SEGMENT);
		createEReference(lifelineSegmentEClass, LIFELINE_SEGMENT__LIFELINE);
		createEReference(lifelineSegmentEClass, LIFELINE_SEGMENT__ACTIVE_EXECUTION);

		messageControlEClass = createEClass(MESSAGE_CONTROL);
		createEReference(messageControlEClass, MESSAGE_CONTROL__MESSAGE);

		functionArgumentMapEntryEClass = createEClass(FUNCTION_ARGUMENT_MAP_ENTRY);
		createEReference(functionArgumentMapEntryEClass, FUNCTION_ARGUMENT_MAP_ENTRY__KEY);
		createEAttribute(functionArgumentMapEntryEClass, FUNCTION_ARGUMENT_MAP_ENTRY__VALUE);

		intervalEClass = createEClass(INTERVAL);
		createEReference(intervalEClass, INTERVAL__FROM);
		createEReference(intervalEClass, INTERVAL__TO);
		createEReference(intervalEClass, INTERVAL__TMSC);
		createEReference(intervalEClass, INTERVAL__SCOPES);
		createEAttribute(intervalEClass, INTERVAL__START_TIME);
		createEAttribute(intervalEClass, INTERVAL__END_TIME);
		createEAttribute(intervalEClass, INTERVAL__DURATION);
		createEOperation(intervalEClass, INTERVAL___GET_NAME);

		measurementEClass = createEClass(MEASUREMENT);
		createEAttribute(measurementEClass, MEASUREMENT__NAME);

		itmscEClass = createEClass(ITMSC);
		createEOperation(itmscEClass, ITMSC___GET_EVENTS);
		createEOperation(itmscEClass, ITMSC___GET_DEPENDENCIES);
		createEOperation(itmscEClass, ITMSC___GET_INCOMING_DEPENDENCIES__EVENT);
		createEOperation(itmscEClass, ITMSC___GET_OUTGOING_DEPENDENCIES__EVENT);

		entryEventEClass = createEClass(ENTRY_EVENT);
		createEReference(entryEventEClass, ENTRY_EVENT__EXECUTION);

		exitEventEClass = createEClass(EXIT_EVENT);
		createEReference(exitEventEClass, EXIT_EVENT__EXECUTION);

		iTimeRangeEClass = createEClass(ITIME_RANGE);
		createEOperation(iTimeRangeEClass, ITIME_RANGE___GET_START_TIME);
		createEOperation(iTimeRangeEClass, ITIME_RANGE___GET_END_TIME);
		createEOperation(iTimeRangeEClass, ITIME_RANGE___GET_DURATION);
		createEOperation(iTimeRangeEClass, ITIME_RANGE___GET_TMSC);

		// Create data types
		eTimestampEDataType = createEDataType(ETIMESTAMP);
		eDurationEDataType = createEDataType(EDURATION);
		eidEDataType = createEDataType(EID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ArchitecturePackage theArchitecturePackage = (ArchitecturePackage) EPackage.Registry.INSTANCE
				.getEPackage(ArchitecturePackage.eNS_URI);
		PropertiesPackage thePropertiesPackage = (PropertiesPackage) EPackage.Registry.INSTANCE
				.getEPackage(PropertiesPackage.eNS_URI);
		SpecifiedPackage theSpecifiedPackage = (SpecifiedPackage) EPackage.Registry.INSTANCE
				.getEPackage(SpecifiedPackage.eNS_URI);
		ImplementedPackage theImplementedPackage = (ImplementedPackage) EPackage.Registry.INSTANCE
				.getEPackage(ImplementedPackage.eNS_URI);
		InstantiatedPackage theInstantiatedPackage = (InstantiatedPackage) EPackage.Registry.INSTANCE
				.getEPackage(InstantiatedPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		fullScopeTMSCEClass.getESuperTypes().add(this.getTMSC());
		eventEClass.getESuperTypes().add(thePropertiesPackage.getPropertiesContainer());
		executionEClass.getESuperTypes().add(thePropertiesPackage.getPropertiesContainer());
		executionEClass.getESuperTypes().add(this.getITimeRange());
		dependencyEClass.getESuperTypes().add(thePropertiesPackage.getPropertiesContainer());
		dependencyEClass.getESuperTypes().add(this.getITimeRange());
		messageEClass.getESuperTypes().add(this.getDependency());
		requestEClass.getESuperTypes().add(this.getMessage());
		replyEClass.getESuperTypes().add(this.getMessage());
		tmscEClass.getESuperTypes().add(thePropertiesPackage.getPropertiesContainer());
		tmscEClass.getESuperTypes().add(this.getITMSC());
		scopedTMSCEClass.getESuperTypes().add(this.getTMSC());
		domainDependencyEClass.getESuperTypes().add(this.getDependency());
		lifelineEClass.getESuperTypes().add(thePropertiesPackage.getPropertiesContainer());
		lifelineSegmentEClass.getESuperTypes().add(this.getDependency());
		messageControlEClass.getESuperTypes().add(this.getDependency());
		intervalEClass.getESuperTypes().add(thePropertiesPackage.getPropertiesContainer());
		intervalEClass.getESuperTypes().add(this.getITimeRange());
		measurementEClass.getESuperTypes().add(this.getInterval());
		entryEventEClass.getESuperTypes().add(this.getEvent());
		exitEventEClass.getESuperTypes().add(this.getEvent());

		// Initialize classes, features, and operations; add parameters
		initEClass(fullScopeTMSCEClass, FullScopeTMSC.class, "FullScopeTMSC", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFullScopeTMSC_Measurements(), this.getMeasurement(), null, "measurements", null, 0, -1,
				FullScopeTMSC.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFullScopeTMSC_Lifelines(), this.getLifeline(), this.getLifeline_Tmsc(), "lifelines", null, 0,
				-1, FullScopeTMSC.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFullScopeTMSC_Dependencies(), this.getDependency(), this.getDependency_Tmsc(), "dependencies",
				null, 0, -1, FullScopeTMSC.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFullScopeTMSC_Architectures(), theArchitecturePackage.getArchitectureModel(), null,
				"architectures", null, 0, -1, FullScopeTMSC.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFullScopeTMSC_EpochTime(), ecorePackage.getEBoolean(), "epochTime", "false", 1, 1,
				FullScopeTMSC.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getFullScopeTMSC_StartTime(), this.getETimestamp(), "startTime", null, 1, 1, FullScopeTMSC.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFullScopeTMSC_EndTime(), this.getETimestamp(), "endTime", null, 1, 1, FullScopeTMSC.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eventEClass, Event.class, "Event", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEvent_Lifeline(), this.getLifeline(), this.getLifeline_Events(), "lifeline", null, 1, 1,
				Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEvent_Arguments(), this.getFunctionArgumentMapEntry(), null, "arguments", null, 0, -1,
				Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEvent_FullScopeIncomingDependencies(), this.getDependency(), this.getDependency_Target(),
				"fullScopeIncomingDependencies", null, 0, -1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEvent_FullScopeOutgoingDependencies(), this.getDependency(), this.getDependency_Source(),
				"fullScopeOutgoingDependencies", null, 0, -1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEvent_Tmsc(), this.getFullScopeTMSC(), null, "tmsc", null, 1, 1, Event.class, IS_TRANSIENT,
				IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED,
				IS_ORDERED);
		initEReference(getEvent_Scopes(), this.getScopedTMSC(), null, "scopes", null, 0, -1, Event.class, IS_TRANSIENT,
				IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED,
				!IS_ORDERED);
		initEReference(getEvent_Component(), theSpecifiedPackage.getComponent(), null, "component", null, 1, 1,
				Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEvent_Function(), theImplementedPackage.getFunction(), null, "function", null, 1, 1,
				Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_Timestamp(), this.getETimestamp(), "timestamp", null, 1, 1, Event.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_Traced(), ecorePackage.getEBoolean(), "traced", "true", 1, 1, Event.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getEvent__GetExecution(), this.getExecution(), "getExecution", 0, 1, IS_UNIQUE, IS_ORDERED);

		EOperation op = initEOperation(getEvent__SetExecution__Execution(), null, "setExecution", 0, 1, IS_UNIQUE,
				IS_ORDERED);
		addEParameter(op, this.getExecution(), "Execution", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(executionEClass, Execution.class, "Execution", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExecution_Lifeline(), this.getLifeline(), this.getLifeline_Executions(), "lifeline", null, 1,
				1, Execution.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecution_Entry(), this.getEntryEvent(), this.getEntryEvent_Execution(), "entry", null, 1, 1,
				Execution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecution_Children(), this.getExecution(), this.getExecution_Parent(), "children", null, 0,
				-1, Execution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecution_Exit(), this.getExitEvent(), this.getExitEvent_Execution(), "exit", null, 1, 1,
				Execution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecution_Parent(), this.getExecution(), this.getExecution_Children(), "parent", null, 0, 1,
				Execution.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecution_Root(), this.getExecution(), null, "root", null, 1, 1, Execution.class,
				IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getExecution_Component(), theSpecifiedPackage.getComponent(), null, "component", null, 1, 1,
				Execution.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getExecution_Function(), theImplementedPackage.getFunction(), null, "function", null, 1, 1,
				Execution.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getExecution_Segments(), this.getLifelineSegment(), this.getLifelineSegment_ActiveExecution(),
				"segments", null, 0, -1, Execution.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecution_StartTime(), this.getETimestamp(), "startTime", null, 1, 1, Execution.class,
				IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecution_EndTime(), this.getETimestamp(), "endTime", null, 1, 1, Execution.class,
				IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecution_Duration(), this.getEDuration(), "duration", null, 1, 1, Execution.class,
				IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getExecution_Tmsc(), this.getFullScopeTMSC(), null, "tmsc", null, 1, 1, Execution.class,
				IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(dependencyEClass, Dependency.class, "Dependency", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDependency_Tmsc(), this.getFullScopeTMSC(), this.getFullScopeTMSC_Dependencies(), "tmsc",
				null, 1, 1, Dependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDependency_Source(), this.getEvent(), this.getEvent_FullScopeOutgoingDependencies(), "source",
				null, 1, 1, Dependency.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDependency_Target(), this.getEvent(), this.getEvent_FullScopeIncomingDependencies(), "target",
				null, 1, 1, Dependency.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDependency_Scopes(), this.getScopedTMSC(), this.getScopedTMSC_Dependencies(), "scopes", null,
				0, -1, Dependency.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDependency_StartTime(), this.getETimestamp(), "startTime", null, 1, 1, Dependency.class,
				IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getDependency_EndTime(), this.getETimestamp(), "endTime", null, 1, 1, Dependency.class,
				IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getDependency_Duration(), this.getEDuration(), "duration", null, 1, 1, Dependency.class,
				IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getDependency_TimeBound(), this.getEDuration(), "timeBound", null, 0, 1, Dependency.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDependency_Scheduled(), ecorePackage.getEBooleanObject(), "scheduled", null, 0, 1,
				Dependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getDependency_Projection(), ecorePackage.getEBoolean(), "projection", null, 0, 1,
				Dependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(messageEClass, Message.class, "Message", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMessage_ControlDependencies(), this.getMessageControl(), this.getMessageControl_Message(),
				"controlDependencies", null, 0, -1, Message.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(requestEClass, Request.class, "Request", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRequest_Replies(), this.getReply(), this.getReply_Request(), "replies", null, 0, -1,
				Request.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(replyEClass, Reply.class, "Reply", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReply_Request(), this.getRequest(), this.getRequest_Replies(), "request", null, 0, 1,
				Reply.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmscEClass, nl.esi.pps.tmsc.TMSC.class, "TMSC", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTMSC_ChildScopes(), this.getScopedTMSC(), this.getScopedTMSC_ParentScope(), "childScopes",
				null, 0, -1, nl.esi.pps.tmsc.TMSC.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getTMSC_ChildScopes().getEKeys().add(this.getScopedTMSC_Name());
		initEReference(getTMSC_FullScope(), this.getFullScopeTMSC(), null, "fullScope", null, 1, 1,
				nl.esi.pps.tmsc.TMSC.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(scopedTMSCEClass, ScopedTMSC.class, "ScopedTMSC", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScopedTMSC_ParentScope(), this.getTMSC(), this.getTMSC_ChildScopes(), "parentScope", null, 1,
				1, ScopedTMSC.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScopedTMSC_Dependencies(), this.getDependency(), this.getDependency_Scopes(), "dependencies",
				null, 0, -1, ScopedTMSC.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScopedTMSC_Origin(), this.getEvent(), null, "origin", null, 0, -1, ScopedTMSC.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScopedTMSC_Fqn(), ecorePackage.getEString(), "fqn", null, 1, 1, ScopedTMSC.class,
				IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getScopedTMSC_Name(), this.getEID(), "name", null, 1, 1, ScopedTMSC.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(domainDependencyEClass, DomainDependency.class, "DomainDependency", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(lifelineEClass, Lifeline.class, "Lifeline", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLifeline_Tmsc(), this.getFullScopeTMSC(), this.getFullScopeTMSC_Lifelines(), "tmsc", null, 1,
				1, Lifeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLifeline_Events(), this.getEvent(), this.getEvent_Lifeline(), "events", null, 0, -1,
				Lifeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLifeline_Executions(), this.getExecution(), this.getExecution_Lifeline(), "executions", null,
				0, -1, Lifeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLifeline_RootExecutions(), this.getExecution(), null, "rootExecutions", null, 0, -1,
				Lifeline.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getLifeline_Segments(), this.getLifelineSegment(), this.getLifelineSegment_Lifeline(),
				"segments", null, 0, -1, Lifeline.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getLifeline_Executor(), theInstantiatedPackage.getExecutor(), null, "executor", null, 1, 1,
				Lifeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLifeline_Traced(), ecorePackage.getEBoolean(), "traced", null, 1, 1, Lifeline.class,
				IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(lifelineSegmentEClass, LifelineSegment.class, "LifelineSegment", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLifelineSegment_Lifeline(), this.getLifeline(), this.getLifeline_Segments(), "lifeline", null,
				1, 1, LifelineSegment.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getLifelineSegment_ActiveExecution(), this.getExecution(), this.getExecution_Segments(),
				"activeExecution", null, 0, 1, LifelineSegment.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE,
				!IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(messageControlEClass, MessageControl.class, "MessageControl", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMessageControl_Message(), this.getMessage(), this.getMessage_ControlDependencies(), "message",
				null, 1, 1, MessageControl.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionArgumentMapEntryEClass, Map.Entry.class, "FunctionArgumentMapEntry", !IS_ABSTRACT,
				!IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunctionArgumentMapEntry_Key(), theImplementedPackage.getFunctionParameter(), null, "key",
				null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFunctionArgumentMapEntry_Value(), ecorePackage.getEString(), "value", null, 1, 1,
				Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(intervalEClass, Interval.class, "Interval", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInterval_From(), this.getEvent(), null, "from", null, 1, 1, Interval.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getInterval_To(), this.getEvent(), null, "to", null, 1, 1, Interval.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getInterval_Tmsc(), this.getFullScopeTMSC(), null, "tmsc", null, 1, 1, Interval.class,
				IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				IS_DERIVED, IS_ORDERED);
		initEReference(getInterval_Scopes(), this.getScopedTMSC(), null, "scopes", null, 0, -1, Interval.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterval_StartTime(), this.getETimestamp(), "startTime", null, 1, 1, Interval.class,
				IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterval_EndTime(), this.getETimestamp(), "endTime", null, 1, 1, Interval.class, IS_TRANSIENT,
				IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterval_Duration(), this.getEDuration(), "duration", null, 1, 1, Interval.class,
				IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEOperation(getInterval__GetName(), ecorePackage.getEString(), "getName", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(measurementEClass, Measurement.class, "Measurement", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMeasurement_Name(), ecorePackage.getEString(), "name", null, 1, 1, Measurement.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(itmscEClass, nl.esi.pps.tmsc.ITMSC.class, "ITMSC", IS_ABSTRACT, IS_INTERFACE,
				!IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getITMSC__GetEvents(), this.getEvent(), "getEvents", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getITMSC__GetDependencies(), this.getDependency(), "getDependencies", 0, -1, IS_UNIQUE,
				IS_ORDERED);

		op = initEOperation(getITMSC__GetIncomingDependencies__Event(), this.getDependency(), "getIncomingDependencies",
				0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEvent(), "event", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getITMSC__GetOutgoingDependencies__Event(), this.getDependency(), "getOutgoingDependencies",
				0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEvent(), "event", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(entryEventEClass, EntryEvent.class, "EntryEvent", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEntryEvent_Execution(), this.getExecution(), this.getExecution_Entry(), "execution", null, 0,
				1, EntryEvent.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(exitEventEClass, ExitEvent.class, "ExitEvent", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExitEvent_Execution(), this.getExecution(), this.getExecution_Exit(), "execution", null, 0, 1,
				ExitEvent.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iTimeRangeEClass, ITimeRange.class, "ITimeRange", IS_ABSTRACT, IS_INTERFACE,
				!IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getITimeRange__GetStartTime(), this.getETimestamp(), "getStartTime", 0, 1, IS_UNIQUE,
				IS_ORDERED);

		initEOperation(getITimeRange__GetEndTime(), this.getETimestamp(), "getEndTime", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getITimeRange__GetDuration(), this.getEDuration(), "getDuration", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getITimeRange__GetTmsc(), this.getFullScopeTMSC(), "getTmsc", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Initialize data types
		initEDataType(eTimestampEDataType, Long.class, "ETimestamp", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(eDurationEDataType, Long.class, "EDuration", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(eidEDataType, String.class, "EID", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";
		addAnnotation(eTimestampEDataType, source,
				new String[] { "baseType", "http://www.eclipse.org/emf/2002/Ecore#ELong", "minInclusive", "0" });
		addAnnotation(eDurationEDataType, source,
				new String[] { "baseType", "http://www.eclipse.org/emf/2002/Ecore#ELong", "minInclusive", "0" });
		addAnnotation(eidEDataType, source, new String[] { "baseType", "http://www.eclipse.org/emf/2002/Ecore#EString",
				"pattern", "[a-zA-Z_0-9]+" });
	}

} //TmscPackageImpl
