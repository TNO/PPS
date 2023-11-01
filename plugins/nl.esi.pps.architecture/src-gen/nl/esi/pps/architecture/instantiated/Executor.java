/**
 */
package nl.esi.pps.architecture.instantiated;

import nl.esi.pps.architecture.NamedArchitectureElement;

import nl.esi.pps.architecture.deployed.Host;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Executor</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see nl.esi.pps.architecture.instantiated.InstantiatedPackage#getExecutor()
 * @model
 * @generated
 */
public interface Executor extends NamedArchitectureElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Typically an executor is deployed onto a host, but PPS doesn't make any assumptions on the kind of relation, hence this relation is merely implemented as an operation and it is up to the architecture implementer to define the relation.
	 * The default implementation of this method returns the container of type Host in the hierarchy of this Executor.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Host getHost();

} // Executor
