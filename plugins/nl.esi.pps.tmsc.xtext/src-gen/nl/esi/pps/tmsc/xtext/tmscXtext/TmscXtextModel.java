/**
 * Generated by Xtext, all rights reserved ESI (TNO)
 */
package nl.esi.pps.tmsc.xtext.tmscXtext;

import java.math.BigDecimal;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextModel#getArchitectureKind <em>Architecture Kind</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextModel#getTimeBound <em>Time Bound</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextModel#getScheduled <em>Scheduled</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextModel#getProperties <em>Properties</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextModel#getDependencySettings <em>Dependency Settings</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextModel#getInterfaces <em>Interfaces</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextModel#getComponents <em>Components</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextModel#getFunctions <em>Functions</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextModel#getHosts <em>Hosts</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextModel#getExecutors <em>Executors</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextModel#getEvents <em>Events</em>}</li>
 * </ul>
 *
 * @see nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage#getTmscXtextModel()
 * @model
 * @generated
 */
public interface TmscXtextModel extends EObject
{
  /**
   * Returns the value of the '<em><b>Architecture Kind</b></em>' attribute.
   * The literals are from the enumeration {@link nl.esi.pps.tmsc.xtext.tmscXtext.XArchitectureKind}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Architecture Kind</em>' attribute.
   * @see nl.esi.pps.tmsc.xtext.tmscXtext.XArchitectureKind
   * @see #setArchitectureKind(XArchitectureKind)
   * @see nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage#getTmscXtextModel_ArchitectureKind()
   * @model
   * @generated
   */
  XArchitectureKind getArchitectureKind();

  /**
   * Sets the value of the '{@link nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextModel#getArchitectureKind <em>Architecture Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Architecture Kind</em>' attribute.
   * @see nl.esi.pps.tmsc.xtext.tmscXtext.XArchitectureKind
   * @see #getArchitectureKind()
   * @generated
   */
  void setArchitectureKind(XArchitectureKind value);

  /**
   * Returns the value of the '<em><b>Time Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Time Bound</em>' attribute.
   * @see #setTimeBound(BigDecimal)
   * @see nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage#getTmscXtextModel_TimeBound()
   * @model
   * @generated
   */
  BigDecimal getTimeBound();

  /**
   * Sets the value of the '{@link nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextModel#getTimeBound <em>Time Bound</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Time Bound</em>' attribute.
   * @see #getTimeBound()
   * @generated
   */
  void setTimeBound(BigDecimal value);

  /**
   * Returns the value of the '<em><b>Scheduled</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Scheduled</em>' attribute.
   * @see #setScheduled(Boolean)
   * @see nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage#getTmscXtextModel_Scheduled()
   * @model
   * @generated
   */
  Boolean getScheduled();

  /**
   * Sets the value of the '{@link nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextModel#getScheduled <em>Scheduled</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Scheduled</em>' attribute.
   * @see #getScheduled()
   * @generated
   */
  void setScheduled(Boolean value);

  /**
   * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
   * The list contents are of type {@link nl.esi.pps.tmsc.xtext.tmscXtext.XProperty}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Properties</em>' containment reference list.
   * @see nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage#getTmscXtextModel_Properties()
   * @model containment="true"
   * @generated
   */
  EList<XProperty> getProperties();

  /**
   * Returns the value of the '<em><b>Dependency Settings</b></em>' containment reference list.
   * The list contents are of type {@link nl.esi.pps.tmsc.xtext.tmscXtext.XDependencySettings}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dependency Settings</em>' containment reference list.
   * @see nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage#getTmscXtextModel_DependencySettings()
   * @model containment="true"
   * @generated
   */
  EList<XDependencySettings> getDependencySettings();

  /**
   * Returns the value of the '<em><b>Interfaces</b></em>' containment reference list.
   * The list contents are of type {@link nl.esi.pps.tmsc.xtext.tmscXtext.XInterface}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Interfaces</em>' containment reference list.
   * @see nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage#getTmscXtextModel_Interfaces()
   * @model containment="true"
   * @generated
   */
  EList<XInterface> getInterfaces();

  /**
   * Returns the value of the '<em><b>Components</b></em>' containment reference list.
   * The list contents are of type {@link nl.esi.pps.tmsc.xtext.tmscXtext.XComponent}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Components</em>' containment reference list.
   * @see nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage#getTmscXtextModel_Components()
   * @model containment="true"
   * @generated
   */
  EList<XComponent> getComponents();

  /**
   * Returns the value of the '<em><b>Functions</b></em>' containment reference list.
   * The list contents are of type {@link nl.esi.pps.tmsc.xtext.tmscXtext.XFunction}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Functions</em>' containment reference list.
   * @see nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage#getTmscXtextModel_Functions()
   * @model containment="true"
   * @generated
   */
  EList<XFunction> getFunctions();

  /**
   * Returns the value of the '<em><b>Hosts</b></em>' containment reference list.
   * The list contents are of type {@link nl.esi.pps.tmsc.xtext.tmscXtext.XHost}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Hosts</em>' containment reference list.
   * @see nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage#getTmscXtextModel_Hosts()
   * @model containment="true"
   * @generated
   */
  EList<XHost> getHosts();

  /**
   * Returns the value of the '<em><b>Executors</b></em>' containment reference list.
   * The list contents are of type {@link nl.esi.pps.tmsc.xtext.tmscXtext.XExecutor}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Executors</em>' containment reference list.
   * @see nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage#getTmscXtextModel_Executors()
   * @model containment="true"
   * @generated
   */
  EList<XExecutor> getExecutors();

  /**
   * Returns the value of the '<em><b>Events</b></em>' containment reference list.
   * The list contents are of type {@link nl.esi.pps.tmsc.xtext.tmscXtext.XEvent}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Events</em>' containment reference list.
   * @see nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage#getTmscXtextModel_Events()
   * @model containment="true"
   * @generated
   */
  EList<XEvent> getEvents();

} // TmscXtextModel
