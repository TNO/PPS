/**
 */
package nl.esi.pps.architecture.instantiated;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Executor Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The ExecutorGroup allows to create logical groups of Executors that have a relation. When selecting an ExecutorGroup in the Outline view of the TMSC viewer, all its Executors will be visualized.
 * <!-- end-model-doc -->
 *
 *
 * @see nl.esi.pps.architecture.instantiated.InstantiatedPackage#getExecutorGroup()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ExecutorGroup extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Typically an ExecutorGroup contains Executors, but PPS doesn't make any assumptions on the kind of relation, hence this relation is merely implemented as an operation and it is up to the architecture implementer to define the relation.
	 * The default implementation of this method returns all first-level descendants of this ExecutorGroup that are of kind Executor, meaning if an Executor contains another Executor, the latter will not be included in the result.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<Executor> getExecutors();

} // ExecutorGroup
