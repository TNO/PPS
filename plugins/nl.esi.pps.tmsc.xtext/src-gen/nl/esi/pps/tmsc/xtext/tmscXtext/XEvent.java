/**
 * Generated by Xtext, all rights reserved ESI (TNO)
 */
package nl.esi.pps.tmsc.xtext.tmscXtext;

import java.math.BigDecimal;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XEvent</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.xtext.tmscXtext.XEvent#getTimestamp <em>Timestamp</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.xtext.tmscXtext.XEvent#getTimeBound <em>Time Bound</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.xtext.tmscXtext.XEvent#getExecutor <em>Executor</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.xtext.tmscXtext.XEvent#getComponent <em>Component</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.xtext.tmscXtext.XEvent#getType <em>Type</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.xtext.tmscXtext.XEvent#getFunction <em>Function</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.xtext.tmscXtext.XEvent#getArguments <em>Arguments</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.xtext.tmscXtext.XEvent#getOutgoingDependencies <em>Outgoing Dependencies</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.xtext.tmscXtext.XEvent#getIncomingDependencies <em>Incoming Dependencies</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.xtext.tmscXtext.XEvent#getScheduled <em>Scheduled</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.xtext.tmscXtext.XEvent#getProperties <em>Properties</em>}</li>
 * </ul>
 *
 * @see nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage#getXEvent()
 * @model
 * @generated
 */
public interface XEvent extends EObject
{
  /**
   * Returns the value of the '<em><b>Timestamp</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Timestamp</em>' attribute.
   * @see #setTimestamp(BigDecimal)
   * @see nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage#getXEvent_Timestamp()
   * @model
   * @generated
   */
  BigDecimal getTimestamp();

  /**
   * Sets the value of the '{@link nl.esi.pps.tmsc.xtext.tmscXtext.XEvent#getTimestamp <em>Timestamp</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Timestamp</em>' attribute.
   * @see #getTimestamp()
   * @generated
   */
  void setTimestamp(BigDecimal value);

  /**
   * Returns the value of the '<em><b>Time Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Time Bound</em>' attribute.
   * @see #setTimeBound(BigDecimal)
   * @see nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage#getXEvent_TimeBound()
   * @model
   * @generated
   */
  BigDecimal getTimeBound();

  /**
   * Sets the value of the '{@link nl.esi.pps.tmsc.xtext.tmscXtext.XEvent#getTimeBound <em>Time Bound</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Time Bound</em>' attribute.
   * @see #getTimeBound()
   * @generated
   */
  void setTimeBound(BigDecimal value);

  /**
   * Returns the value of the '<em><b>Executor</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Executor</em>' reference.
   * @see #setExecutor(XExecutor)
   * @see nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage#getXEvent_Executor()
   * @model
   * @generated
   */
  XExecutor getExecutor();

  /**
   * Sets the value of the '{@link nl.esi.pps.tmsc.xtext.tmscXtext.XEvent#getExecutor <em>Executor</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Executor</em>' reference.
   * @see #getExecutor()
   * @generated
   */
  void setExecutor(XExecutor value);

  /**
   * Returns the value of the '<em><b>Component</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Component</em>' reference.
   * @see #setComponent(XComponent)
   * @see nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage#getXEvent_Component()
   * @model
   * @generated
   */
  XComponent getComponent();

  /**
   * Sets the value of the '{@link nl.esi.pps.tmsc.xtext.tmscXtext.XEvent#getComponent <em>Component</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Component</em>' reference.
   * @see #getComponent()
   * @generated
   */
  void setComponent(XComponent value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link nl.esi.pps.tmsc.xtext.tmscXtext.XEventType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see nl.esi.pps.tmsc.xtext.tmscXtext.XEventType
   * @see #setType(XEventType)
   * @see nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage#getXEvent_Type()
   * @model
   * @generated
   */
  XEventType getType();

  /**
   * Sets the value of the '{@link nl.esi.pps.tmsc.xtext.tmscXtext.XEvent#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see nl.esi.pps.tmsc.xtext.tmscXtext.XEventType
   * @see #getType()
   * @generated
   */
  void setType(XEventType value);

  /**
   * Returns the value of the '<em><b>Function</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Function</em>' reference.
   * @see #setFunction(XFunction)
   * @see nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage#getXEvent_Function()
   * @model
   * @generated
   */
  XFunction getFunction();

  /**
   * Sets the value of the '{@link nl.esi.pps.tmsc.xtext.tmscXtext.XEvent#getFunction <em>Function</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Function</em>' reference.
   * @see #getFunction()
   * @generated
   */
  void setFunction(XFunction value);

  /**
   * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
   * The list contents are of type {@link nl.esi.pps.tmsc.xtext.tmscXtext.XEventArgument}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Arguments</em>' containment reference list.
   * @see nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage#getXEvent_Arguments()
   * @model containment="true"
   * @generated
   */
  EList<XEventArgument> getArguments();

  /**
   * Returns the value of the '<em><b>Outgoing Dependencies</b></em>' containment reference list.
   * The list contents are of type {@link nl.esi.pps.tmsc.xtext.tmscXtext.XDependency}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Outgoing Dependencies</em>' containment reference list.
   * @see nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage#getXEvent_OutgoingDependencies()
   * @model containment="true"
   * @generated
   */
  EList<XDependency> getOutgoingDependencies();

  /**
   * Returns the value of the '<em><b>Incoming Dependencies</b></em>' reference list.
   * The list contents are of type {@link nl.esi.pps.tmsc.xtext.tmscXtext.XDependency}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Incoming Dependencies</em>' reference list.
   * @see nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage#getXEvent_IncomingDependencies()
   * @model
   * @generated
   */
  EList<XDependency> getIncomingDependencies();

  /**
   * Returns the value of the '<em><b>Scheduled</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Scheduled</em>' attribute.
   * @see #setScheduled(Boolean)
   * @see nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage#getXEvent_Scheduled()
   * @model
   * @generated
   */
  Boolean getScheduled();

  /**
   * Sets the value of the '{@link nl.esi.pps.tmsc.xtext.tmscXtext.XEvent#getScheduled <em>Scheduled</em>}' attribute.
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
   * @see nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage#getXEvent_Properties()
   * @model containment="true"
   * @generated
   */
  EList<XProperty> getProperties();

} // XEvent
