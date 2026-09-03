/**
 */
package nl.esi.pps.architecture.example;

import nl.esi.pps.architecture.NamedArchitectureElement;

import nl.esi.pps.architecture.implemented.Function;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.architecture.example.ExampleFunctionGroup#getSubGroups <em>Sub Groups</em>}</li>
 *   <li>{@link nl.esi.pps.architecture.example.ExampleFunctionGroup#getParentGroup <em>Parent Group</em>}</li>
 *   <li>{@link nl.esi.pps.architecture.example.ExampleFunctionGroup#getFunctions <em>Functions</em>}</li>
 * </ul>
 *
 * @see nl.esi.pps.architecture.example.ExamplePackage#getExampleFunctionGroup()
 * @model
 * @generated
 */
public interface ExampleFunctionGroup extends NamedArchitectureElement {
	/**
	 * Returns the value of the '<em><b>Sub Groups</b></em>' containment reference list.
	 * The list contents are of type {@link nl.esi.pps.architecture.example.ExampleFunctionGroup}.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.architecture.example.ExampleFunctionGroup#getParentGroup <em>Parent Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Groups</em>' containment reference list.
	 * @see nl.esi.pps.architecture.example.ExamplePackage#getExampleFunctionGroup_SubGroups()
	 * @see nl.esi.pps.architecture.example.ExampleFunctionGroup#getParentGroup
	 * @model opposite="parentGroup" containment="true"
	 * @generated
	 */
	EList<ExampleFunctionGroup> getSubGroups();

	/**
	 * Returns the value of the '<em><b>Parent Group</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.architecture.example.ExampleFunctionGroup#getSubGroups <em>Sub Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Group</em>' container reference.
	 * @see #setParentGroup(ExampleFunctionGroup)
	 * @see nl.esi.pps.architecture.example.ExamplePackage#getExampleFunctionGroup_ParentGroup()
	 * @see nl.esi.pps.architecture.example.ExampleFunctionGroup#getSubGroups
	 * @model opposite="subGroups" transient="false"
	 * @generated
	 */
	ExampleFunctionGroup getParentGroup();

	/**
	 * Sets the value of the '{@link nl.esi.pps.architecture.example.ExampleFunctionGroup#getParentGroup <em>Parent Group</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Group</em>' container reference.
	 * @see #getParentGroup()
	 * @generated
	 */
	void setParentGroup(ExampleFunctionGroup value);

	/**
	 * Returns the value of the '<em><b>Functions</b></em>' containment reference list.
	 * The list contents are of type {@link nl.esi.pps.architecture.implemented.Function}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Functions</em>' containment reference list.
	 * @see nl.esi.pps.architecture.example.ExamplePackage#getExampleFunctionGroup_Functions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Function> getFunctions();

} // ExampleFunctionGroup
