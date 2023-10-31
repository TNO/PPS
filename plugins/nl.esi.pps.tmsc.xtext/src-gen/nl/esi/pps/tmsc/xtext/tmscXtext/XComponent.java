/**
 * Generated by Xtext, all rights reserved ESI (TNO)
 */
package nl.esi.pps.tmsc.xtext.tmscXtext;

import java.math.BigDecimal;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XComponent</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.xtext.tmscXtext.XComponent#getProvides <em>Provides</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.xtext.tmscXtext.XComponent#getRequires <em>Requires</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.xtext.tmscXtext.XComponent#getTimeBound <em>Time Bound</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.xtext.tmscXtext.XComponent#getScheduled <em>Scheduled</em>}</li>
 * </ul>
 *
 * @see nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage#getXComponent()
 * @model
 * @generated
 */
public interface XComponent extends XNamedArchitectureElement
{
  /**
   * Returns the value of the '<em><b>Provides</b></em>' reference list.
   * The list contents are of type {@link nl.esi.pps.tmsc.xtext.tmscXtext.XInterface}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Provides</em>' reference list.
   * @see nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage#getXComponent_Provides()
   * @model
   * @generated
   */
  EList<XInterface> getProvides();

  /**
   * Returns the value of the '<em><b>Requires</b></em>' reference list.
   * The list contents are of type {@link nl.esi.pps.tmsc.xtext.tmscXtext.XInterface}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Requires</em>' reference list.
   * @see nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage#getXComponent_Requires()
   * @model
   * @generated
   */
  EList<XInterface> getRequires();

  /**
   * Returns the value of the '<em><b>Time Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Time Bound</em>' attribute.
   * @see #setTimeBound(BigDecimal)
   * @see nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage#getXComponent_TimeBound()
   * @model
   * @generated
   */
  BigDecimal getTimeBound();

  /**
   * Sets the value of the '{@link nl.esi.pps.tmsc.xtext.tmscXtext.XComponent#getTimeBound <em>Time Bound</em>}' attribute.
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
   * @see nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage#getXComponent_Scheduled()
   * @model
   * @generated
   */
  Boolean getScheduled();

  /**
   * Sets the value of the '{@link nl.esi.pps.tmsc.xtext.tmscXtext.XComponent#getScheduled <em>Scheduled</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Scheduled</em>' attribute.
   * @see #getScheduled()
   * @generated
   */
  void setScheduled(Boolean value);

} // XComponent
