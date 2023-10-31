/**
 */
package nl.esi.pps.architecture.specified;

import nl.esi.pps.architecture.NamedArchitectureElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.architecture.specified.Operation#getInterface <em>Interface</em>}</li>
 * </ul>
 *
 * @see nl.esi.pps.architecture.specified.SpecifiedPackage#getOperation()
 * @model
 * @generated
 */
public interface Operation extends NamedArchitectureElement {
	/**
	 * Returns the value of the '<em><b>Interface</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.architecture.specified.Interface#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interface</em>' container reference.
	 * @see #setInterface(Interface)
	 * @see nl.esi.pps.architecture.specified.SpecifiedPackage#getOperation_Interface()
	 * @see nl.esi.pps.architecture.specified.Interface#getOperations
	 * @model opposite="operations" required="true" transient="false"
	 * @generated
	 */
	Interface getInterface();

	/**
	 * Sets the value of the '{@link nl.esi.pps.architecture.specified.Operation#getInterface <em>Interface</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface</em>' container reference.
	 * @see #getInterface()
	 * @generated
	 */
	void setInterface(Interface value);

} // Operation
