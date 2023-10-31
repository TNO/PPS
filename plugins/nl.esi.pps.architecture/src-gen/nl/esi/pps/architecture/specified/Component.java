/**
 */
package nl.esi.pps.architecture.specified;

import nl.esi.pps.architecture.NamedArchitectureElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.architecture.specified.Component#getRequiredInterfaces <em>Required Interfaces</em>}</li>
 *   <li>{@link nl.esi.pps.architecture.specified.Component#getProvidedInterfaces <em>Provided Interfaces</em>}</li>
 * </ul>
 *
 * @see nl.esi.pps.architecture.specified.SpecifiedPackage#getComponent()
 * @model
 * @generated
 */
public interface Component extends NamedArchitectureElement {
	/**
	 * Returns the value of the '<em><b>Required Interfaces</b></em>' reference list.
	 * The list contents are of type {@link nl.esi.pps.architecture.specified.Interface}.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.architecture.specified.Interface#getRequiredBy <em>Required By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Interfaces</em>' reference list.
	 * @see nl.esi.pps.architecture.specified.SpecifiedPackage#getComponent_RequiredInterfaces()
	 * @see nl.esi.pps.architecture.specified.Interface#getRequiredBy
	 * @model opposite="requiredBy"
	 * @generated
	 */
	EList<Interface> getRequiredInterfaces();

	/**
	 * Returns the value of the '<em><b>Provided Interfaces</b></em>' reference list.
	 * The list contents are of type {@link nl.esi.pps.architecture.specified.Interface}.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.architecture.specified.Interface#getProvidedBy <em>Provided By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provided Interfaces</em>' reference list.
	 * @see nl.esi.pps.architecture.specified.SpecifiedPackage#getComponent_ProvidedInterfaces()
	 * @see nl.esi.pps.architecture.specified.Interface#getProvidedBy
	 * @model opposite="providedBy"
	 * @generated
	 */
	EList<Interface> getProvidedInterfaces();

} // Component
