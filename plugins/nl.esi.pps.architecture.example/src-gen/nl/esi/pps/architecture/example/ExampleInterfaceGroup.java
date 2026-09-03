/**
 */
package nl.esi.pps.architecture.example;

import nl.esi.pps.architecture.NamedArchitectureElement;

import nl.esi.pps.architecture.specified.Interface;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interface Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.architecture.example.ExampleInterfaceGroup#getInterfaces <em>Interfaces</em>}</li>
 *   <li>{@link nl.esi.pps.architecture.example.ExampleInterfaceGroup#getSubGroups <em>Sub Groups</em>}</li>
 *   <li>{@link nl.esi.pps.architecture.example.ExampleInterfaceGroup#getParentGroup <em>Parent Group</em>}</li>
 * </ul>
 *
 * @see nl.esi.pps.architecture.example.ExamplePackage#getExampleInterfaceGroup()
 * @model
 * @generated
 */
public interface ExampleInterfaceGroup extends NamedArchitectureElement {
	/**
	 * Returns the value of the '<em><b>Interfaces</b></em>' containment reference list.
	 * The list contents are of type {@link nl.esi.pps.architecture.specified.Interface}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interfaces</em>' containment reference list.
	 * @see nl.esi.pps.architecture.example.ExamplePackage#getExampleInterfaceGroup_Interfaces()
	 * @model containment="true"
	 * @generated
	 */
	EList<Interface> getInterfaces();

	/**
	 * Returns the value of the '<em><b>Sub Groups</b></em>' containment reference list.
	 * The list contents are of type {@link nl.esi.pps.architecture.example.ExampleInterfaceGroup}.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.architecture.example.ExampleInterfaceGroup#getParentGroup <em>Parent Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Groups</em>' containment reference list.
	 * @see nl.esi.pps.architecture.example.ExamplePackage#getExampleInterfaceGroup_SubGroups()
	 * @see nl.esi.pps.architecture.example.ExampleInterfaceGroup#getParentGroup
	 * @model opposite="parentGroup" containment="true"
	 * @generated
	 */
	EList<ExampleInterfaceGroup> getSubGroups();

	/**
	 * Returns the value of the '<em><b>Parent Group</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.architecture.example.ExampleInterfaceGroup#getSubGroups <em>Sub Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Group</em>' container reference.
	 * @see #setParentGroup(ExampleInterfaceGroup)
	 * @see nl.esi.pps.architecture.example.ExamplePackage#getExampleInterfaceGroup_ParentGroup()
	 * @see nl.esi.pps.architecture.example.ExampleInterfaceGroup#getSubGroups
	 * @model opposite="subGroups" transient="false"
	 * @generated
	 */
	ExampleInterfaceGroup getParentGroup();

	/**
	 * Sets the value of the '{@link nl.esi.pps.architecture.example.ExampleInterfaceGroup#getParentGroup <em>Parent Group</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Group</em>' container reference.
	 * @see #getParentGroup()
	 * @generated
	 */
	void setParentGroup(ExampleInterfaceGroup value);

} // ExampleInterfaceGroup
