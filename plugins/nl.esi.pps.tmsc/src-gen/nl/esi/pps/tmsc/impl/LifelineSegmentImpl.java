/**
 */
package nl.esi.pps.tmsc.impl;

import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.Lifeline;
import nl.esi.pps.tmsc.LifelineSegment;
import nl.esi.pps.tmsc.TmscPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lifeline Segment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.impl.LifelineSegmentImpl#getLifeline <em>Lifeline</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.impl.LifelineSegmentImpl#getActiveExecution <em>Active Execution</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LifelineSegmentImpl extends DependencyImpl implements LifelineSegment {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LifelineSegmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TmscPackage.Literals.LIFELINE_SEGMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Lifeline getLifeline() {
		return TmscImplQueries.getLifelineImpl(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Execution getActiveExecution() {
		return TmscImplQueries.getActiveExecutionImpl(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case TmscPackage.LIFELINE_SEGMENT__LIFELINE:
			return getLifeline();
		case TmscPackage.LIFELINE_SEGMENT__ACTIVE_EXECUTION:
			return getActiveExecution();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case TmscPackage.LIFELINE_SEGMENT__LIFELINE:
			return getLifeline() != null;
		case TmscPackage.LIFELINE_SEGMENT__ACTIVE_EXECUTION:
			return getActiveExecution() != null;
		}
		return super.eIsSet(featureID);
	}

} //LifelineSegmentImpl
