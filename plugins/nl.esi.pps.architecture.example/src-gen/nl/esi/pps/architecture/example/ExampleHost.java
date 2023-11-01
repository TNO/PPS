/**
 */
package nl.esi.pps.architecture.example;

import nl.esi.pps.architecture.deployed.Host;

import nl.esi.pps.architecture.instantiated.Executor;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Host</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.architecture.example.ExampleHost#getExecutors <em>Executors</em>}</li>
 * </ul>
 *
 * @see nl.esi.pps.architecture.example.ExamplePackage#getExampleHost()
 * @model
 * @generated
 */
public interface ExampleHost extends Host {
	/**
	 * Returns the value of the '<em><b>Executors</b></em>' containment reference list.
	 * The list contents are of type {@link nl.esi.pps.architecture.instantiated.Executor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Executors</em>' containment reference list.
	 * @see nl.esi.pps.architecture.example.ExamplePackage#getExampleHost_Executors()
	 * @model containment="true"
	 * @generated
	 */
	EList<Executor> getExecutors();

} // ExampleHost
