/**
 */
package nl.esi.pps.architecture.specified;

import nl.esi.pps.architecture.NamedArchitectureElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.architecture.specified.Interface#getRequiredBy <em>Required By</em>}</li>
 *   <li>{@link nl.esi.pps.architecture.specified.Interface#getProvidedBy <em>Provided By</em>}</li>
 *   <li>{@link nl.esi.pps.architecture.specified.Interface#getOperations <em>Operations</em>}</li>
 * </ul>
 *
 * @see nl.esi.pps.architecture.specified.SpecifiedPackage#getInterface()
 * @model
 * @generated
 */
public interface Interface extends NamedArchitectureElement {
	/**
	 * Returns the value of the '<em><b>Required By</b></em>' reference list.
	 * The list contents are of type {@link nl.esi.pps.architecture.specified.Component}.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.architecture.specified.Component#getRequiredInterfaces <em>Required Interfaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required By</em>' reference list.
	 * @see nl.esi.pps.architecture.specified.SpecifiedPackage#getInterface_RequiredBy()
	 * @see nl.esi.pps.architecture.specified.Component#getRequiredInterfaces
	 * @model opposite="requiredInterfaces"
	 * @generated
	 */
	EList<Component> getRequiredBy();

	/**
	 * Returns the value of the '<em><b>Provided By</b></em>' reference list.
	 * The list contents are of type {@link nl.esi.pps.architecture.specified.Component}.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.architecture.specified.Component#getProvidedInterfaces <em>Provided Interfaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provided By</em>' reference list.
	 * @see nl.esi.pps.architecture.specified.SpecifiedPackage#getInterface_ProvidedBy()
	 * @see nl.esi.pps.architecture.specified.Component#getProvidedInterfaces
	 * @model opposite="providedInterfaces"
	 * @generated
	 */
	EList<Component> getProvidedBy();

	/**
	 * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
	 * The list contents are of type {@link nl.esi.pps.architecture.specified.Operation}.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.architecture.specified.Operation#getInterface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operations</em>' containment reference list.
	 * @see nl.esi.pps.architecture.specified.SpecifiedPackage#getInterface_Operations()
	 * @see nl.esi.pps.architecture.specified.Operation#getInterface
	 * @model opposite="interface" containment="true"
	 * @generated
	 */
	EList<Operation> getOperations();

} // Interface
