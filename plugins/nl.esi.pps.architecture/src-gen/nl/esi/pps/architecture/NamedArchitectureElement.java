/**
 */
package nl.esi.pps.architecture;

import nl.esi.emf.properties.PropertiesContainer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Architecture Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.architecture.NamedArchitectureElement#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see nl.esi.pps.architecture.ArchitecturePackage#getNamedArchitectureElement()
 * @model abstract="true"
 * @generated
 */
public interface NamedArchitectureElement extends PropertiesContainer {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see nl.esi.pps.architecture.ArchitecturePackage#getNamedArchitectureElement_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link nl.esi.pps.architecture.NamedArchitectureElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // NamedArchitectureElement
