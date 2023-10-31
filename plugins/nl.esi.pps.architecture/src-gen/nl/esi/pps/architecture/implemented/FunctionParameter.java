/**
 */
package nl.esi.pps.architecture.implemented;

import nl.esi.pps.architecture.NamedArchitectureElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.architecture.implemented.FunctionParameter#getFunction <em>Function</em>}</li>
 *   <li>{@link nl.esi.pps.architecture.implemented.FunctionParameter#getKind <em>Kind</em>}</li>
 * </ul>
 *
 * @see nl.esi.pps.architecture.implemented.ImplementedPackage#getFunctionParameter()
 * @model
 * @generated
 */
public interface FunctionParameter extends NamedArchitectureElement {
	/**
	 * Returns the value of the '<em><b>Function</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.architecture.implemented.Function#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function</em>' container reference.
	 * @see #setFunction(Function)
	 * @see nl.esi.pps.architecture.implemented.ImplementedPackage#getFunctionParameter_Function()
	 * @see nl.esi.pps.architecture.implemented.Function#getParameters
	 * @model opposite="parameters" resolveProxies="false" required="true" transient="false"
	 * @generated
	 */
	Function getFunction();

	/**
	 * Sets the value of the '{@link nl.esi.pps.architecture.implemented.FunctionParameter#getFunction <em>Function</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function</em>' container reference.
	 * @see #getFunction()
	 * @generated
	 */
	void setFunction(Function value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link nl.esi.pps.architecture.implemented.FunctionParameterKind}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see nl.esi.pps.architecture.implemented.FunctionParameterKind
	 * @see #setKind(FunctionParameterKind)
	 * @see nl.esi.pps.architecture.implemented.ImplementedPackage#getFunctionParameter_Kind()
	 * @model required="true"
	 * @generated
	 */
	FunctionParameterKind getKind();

	/**
	 * Sets the value of the '{@link nl.esi.pps.architecture.implemented.FunctionParameter#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see nl.esi.pps.architecture.implemented.FunctionParameterKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(FunctionParameterKind value);

} // FunctionParameter
