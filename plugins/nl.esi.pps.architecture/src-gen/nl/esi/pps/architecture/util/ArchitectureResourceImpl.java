/**
 */
package nl.esi.pps.architecture.util;

import org.eclipse.emf.common.util.URI;

import nl.esi.pps.common.emf.ecore.xmi.ProgressReportingXMIResourceImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource </b> associated with the package.
 * <!-- end-user-doc -->
 * @see nl.esi.pps.architecture.util.ArchitectureResourceFactoryImpl
 * @generated NOT
 */
public class ArchitectureResourceImpl extends ProgressReportingXMIResourceImpl {
	/**
	 * Creates an instance of the resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param uri the URI of the new resource.
	 * @generated
	 */
	public ArchitectureResourceImpl(URI uri) {
		super(uri);
	}

	@Override
	protected boolean useUUIDs() {
		// Using UUID's to gain stable bookmark references
		return true;
	}

	@Override
	protected boolean useIDAttributes() {
		// Disable IDs from EObjects, improve lookup of IDs that are no longer there
		return false;
	}

	@Override
	protected boolean assignIDsWhileLoading() {
		// For backwards compatibility, only assign UUID's on save
		return false;
	}
} //ArchitectureResourceImpl
