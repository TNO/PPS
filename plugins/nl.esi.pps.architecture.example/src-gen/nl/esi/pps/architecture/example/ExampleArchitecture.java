/**
 */
package nl.esi.pps.architecture.example;

import nl.esi.emf.properties.PropertiesContainer;

import nl.esi.pps.architecture.ArchitectureModel;

import nl.esi.pps.architecture.implemented.Function;

import nl.esi.pps.architecture.instantiated.Executor;

import nl.esi.pps.architecture.specified.Component;
import nl.esi.pps.architecture.specified.Interface;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Architecture</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.architecture.example.ExampleArchitecture#getComponents <em>Components</em>}</li>
 *   <li>{@link nl.esi.pps.architecture.example.ExampleArchitecture#getInterfaces <em>Interfaces</em>}</li>
 *   <li>{@link nl.esi.pps.architecture.example.ExampleArchitecture#getFunctions <em>Functions</em>}</li>
 *   <li>{@link nl.esi.pps.architecture.example.ExampleArchitecture#getExecutors <em>Executors</em>}</li>
 * </ul>
 *
 * @see nl.esi.pps.architecture.example.ExamplePackage#getExampleArchitecture()
 * @model
 * @generated
 */
public interface ExampleArchitecture extends PropertiesContainer, ArchitectureModel {
	/**
	 * Returns the value of the '<em><b>Components</b></em>' containment reference list.
	 * The list contents are of type {@link nl.esi.pps.architecture.specified.Component}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Components</em>' containment reference list.
	 * @see nl.esi.pps.architecture.example.ExamplePackage#getExampleArchitecture_Components()
	 * @model containment="true"
	 * @generated
	 */
	EList<Component> getComponents();

	/**
	 * Returns the value of the '<em><b>Interfaces</b></em>' containment reference list.
	 * The list contents are of type {@link nl.esi.pps.architecture.specified.Interface}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interfaces</em>' containment reference list.
	 * @see nl.esi.pps.architecture.example.ExamplePackage#getExampleArchitecture_Interfaces()
	 * @model containment="true"
	 * @generated
	 */
	EList<Interface> getInterfaces();

	/**
	 * Returns the value of the '<em><b>Functions</b></em>' containment reference list.
	 * The list contents are of type {@link nl.esi.pps.architecture.implemented.Function}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Functions</em>' containment reference list.
	 * @see nl.esi.pps.architecture.example.ExamplePackage#getExampleArchitecture_Functions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Function> getFunctions();

	/**
	 * Returns the value of the '<em><b>Executors</b></em>' containment reference list.
	 * The list contents are of type {@link nl.esi.pps.architecture.instantiated.Executor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Executors</em>' containment reference list.
	 * @see nl.esi.pps.architecture.example.ExamplePackage#getExampleArchitecture_Executors()
	 * @model containment="true"
	 * @generated
	 */
	EList<Executor> getExecutors();

} // ExampleArchitecture
