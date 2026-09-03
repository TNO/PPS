/**
 */
package nl.esi.pps.architecture.example;

import nl.esi.pps.architecture.NamedArchitectureElement;
import nl.esi.pps.architecture.specified.Component;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.architecture.example.ExampleComponentGroup#getComponents <em>Components</em>}</li>
 *   <li>{@link nl.esi.pps.architecture.example.ExampleComponentGroup#getSubGroups <em>Sub Groups</em>}</li>
 *   <li>{@link nl.esi.pps.architecture.example.ExampleComponentGroup#getParentGroup <em>Parent Group</em>}</li>
 * </ul>
 *
 * @see nl.esi.pps.architecture.example.ExamplePackage#getExampleComponentGroup()
 * @model
 * @generated
 */
public interface ExampleComponentGroup extends NamedArchitectureElement {
	/**
	 * Returns the value of the '<em><b>Components</b></em>' containment reference list.
	 * The list contents are of type {@link nl.esi.pps.architecture.specified.Component}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Components</em>' containment reference list.
	 * @see nl.esi.pps.architecture.example.ExamplePackage#getExampleComponentGroup_Components()
	 * @model containment="true"
	 * @generated
	 */
	EList<Component> getComponents();

	/**
	 * Returns the value of the '<em><b>Sub Groups</b></em>' containment reference list.
	 * The list contents are of type {@link nl.esi.pps.architecture.example.ExampleComponentGroup}.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.architecture.example.ExampleComponentGroup#getParentGroup <em>Parent Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Groups</em>' containment reference list.
	 * @see nl.esi.pps.architecture.example.ExamplePackage#getExampleComponentGroup_SubGroups()
	 * @see nl.esi.pps.architecture.example.ExampleComponentGroup#getParentGroup
	 * @model opposite="parentGroup" containment="true"
	 * @generated
	 */
	EList<ExampleComponentGroup> getSubGroups();

	/**
	 * Returns the value of the '<em><b>Parent Group</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.architecture.example.ExampleComponentGroup#getSubGroups <em>Sub Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Group</em>' container reference.
	 * @see #setParentGroup(ExampleComponentGroup)
	 * @see nl.esi.pps.architecture.example.ExamplePackage#getExampleComponentGroup_ParentGroup()
	 * @see nl.esi.pps.architecture.example.ExampleComponentGroup#getSubGroups
	 * @model opposite="subGroups" transient="false"
	 * @generated
	 */
	ExampleComponentGroup getParentGroup();

	/**
	 * Sets the value of the '{@link nl.esi.pps.architecture.example.ExampleComponentGroup#getParentGroup <em>Parent Group</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Group</em>' container reference.
	 * @see #getParentGroup()
	 * @generated
	 */
	void setParentGroup(ExampleComponentGroup value);

} // ExampleComponentGroup
