/**
 */
package nl.esi.pps.tmsc;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scoped TMSC</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * ScopedTMSC is a sub-graph of the whole TMSC model and defined for facilitating fragmentation of the TMSC model to sub-graphs (e.g. indication of a path), i.e. events and dependencies that hold specific properties, activities, etc. 
 * Each ScopedTMSC can be considered as a part of its parent scope TMSC and allows application of analysis techniques, i.e., critical path analysis, locally in a sub-graph. 
 * The dependencies of a child scope are contained by its parent scope.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.ScopedTMSC#getParentScope <em>Parent Scope</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.ScopedTMSC#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.ScopedTMSC#getOrigin <em>Origin</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.ScopedTMSC#getFqn <em>Fqn</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.ScopedTMSC#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see nl.esi.pps.tmsc.TmscPackage#getScopedTMSC()
 * @model
 * @generated
 */
public interface ScopedTMSC extends TMSC {
	/**
	 * Returns the value of the '<em><b>Parent Scope</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.tmsc.TMSC#getChildScopes <em>Child Scopes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Scope</em>' container reference.
	 * @see #setParentScope(TMSC)
	 * @see nl.esi.pps.tmsc.TmscPackage#getScopedTMSC_ParentScope()
	 * @see nl.esi.pps.tmsc.TMSC#getChildScopes
	 * @model opposite="childScopes" required="true" transient="false"
	 * @generated
	 */
	TMSC getParentScope();

	/**
	 * Sets the value of the '{@link nl.esi.pps.tmsc.ScopedTMSC#getParentScope <em>Parent Scope</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Scope</em>' container reference.
	 * @see #getParentScope()
	 * @generated
	 */
	void setParentScope(TMSC value);

	/**
	 * Returns the value of the '<em><b>Dependencies</b></em>' reference list.
	 * The list contents are of type {@link nl.esi.pps.tmsc.Dependency}.
	 * It is bidirectional and its opposite is '{@link nl.esi.pps.tmsc.Dependency#getScopes <em>Scopes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependencies</em>' reference list.
	 * @see nl.esi.pps.tmsc.TmscPackage#getScopedTMSC_Dependencies()
	 * @see nl.esi.pps.tmsc.Dependency#getScopes
	 * @model opposite="scopes" resolveProxies="false"
	 * @generated
	 */
	EList<Dependency> getDependencies();

	/**
	 * Returns the value of the '<em><b>Origin</b></em>' reference list.
	 * The list contents are of type {@link nl.esi.pps.tmsc.Event}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Typically a ScopedTMSC represents an analysis result that is created from a certain event or events, this is called the origin of the scope.
	 * Setting this attribute is optional, but may help successor analyses.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Origin</em>' reference list.
	 * @see nl.esi.pps.tmsc.TmscPackage#getScopedTMSC_Origin()
	 * @model
	 * @generated
	 */
	EList<Event> getOrigin();

	/**
	 * Returns the value of the '<em><b>Fqn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fqn</em>' attribute.
	 * @see nl.esi.pps.tmsc.TmscPackage#getScopedTMSC_Fqn()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getFqn();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see nl.esi.pps.tmsc.TmscPackage#getScopedTMSC_Name()
	 * @model dataType="nl.esi.pps.tmsc.EID" required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link nl.esi.pps.tmsc.ScopedTMSC#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // ScopedTMSC
