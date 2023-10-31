/**
 */
package nl.esi.pps.tmsc;

import nl.esi.emf.properties.PropertiesContainer;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TMSC</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * TMSC is a directed acyclic graph with events and dependencies, and some additional structural properties. 
 * A TMSC should at least contain all events that are referred to by its dependencies.
 * Two specializations are considered the FullScopeTMSC and ScopedTMSC.
 * 
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.TMSC#getChildScopes <em>Child Scopes</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.TMSC#getFullScope <em>Full Scope</em>}</li>
 * </ul>
 *
 * @see nl.esi.pps.tmsc.TmscPackage#getTMSC()
 * @model abstract="true" superTypes="nl.esi.emf.properties.PropertiesContainer nl.esi.pps.tmsc.ITMSC"
 * @generated
 */
public interface TMSC extends PropertiesContainer, ITMSC {
	/**
	 * Returns the value of the '<em><b>Child Scopes</b></em>' containment reference list.
	 * The list contents are of type {@link nl.esi.pps.tmsc.ScopedTMSC}.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.tmsc.ScopedTMSC#getParentScope <em>Parent Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * All dependencies of a child scope should also be contained by its parent scope.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Child Scopes</em>' containment reference list.
	 * @see nl.esi.pps.tmsc.TmscPackage#getTMSC_ChildScopes()
	 * @see nl.esi.pps.tmsc.ScopedTMSC#getParentScope
	 * @model opposite="parentScope" containment="true" keys="name"
	 * @generated
	 */
	EList<ScopedTMSC> getChildScopes();

	/**
	 * Returns the value of the '<em><b>Full Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Full Scope</em>' reference.
	 * @see nl.esi.pps.tmsc.TmscPackage#getTMSC_FullScope()
	 * @model resolveProxies="false" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	FullScopeTMSC getFullScope();

} // TMSC
