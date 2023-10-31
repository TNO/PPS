/**
 */
package nl.esi.pps.architecture.implemented;

import nl.esi.pps.architecture.NamedArchitectureElement;

import nl.esi.pps.architecture.specified.Operation;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.architecture.implemented.Function#getOperation <em>Operation</em>}</li>
 *   <li>{@link nl.esi.pps.architecture.implemented.Function#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @see nl.esi.pps.architecture.implemented.ImplementedPackage#getFunction()
 * @model
 * @generated
 */
public interface Function extends NamedArchitectureElement {
	/**
	 * Returns the value of the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' reference.
	 * @see #setOperation(Operation)
	 * @see nl.esi.pps.architecture.implemented.ImplementedPackage#getFunction_Operation()
	 * @model
	 * @generated
	 */
	Operation getOperation();

	/**
	 * Sets the value of the '{@link nl.esi.pps.architecture.implemented.Function#getOperation <em>Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(Operation value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link nl.esi.pps.architecture.implemented.FunctionParameter}.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.architecture.implemented.FunctionParameter#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see nl.esi.pps.architecture.implemented.ImplementedPackage#getFunction_Parameters()
	 * @see nl.esi.pps.architecture.implemented.FunctionParameter#getFunction
	 * @model opposite="function" containment="true"
	 * @generated
	 */
	EList<FunctionParameter> getParameters();

} // Function
