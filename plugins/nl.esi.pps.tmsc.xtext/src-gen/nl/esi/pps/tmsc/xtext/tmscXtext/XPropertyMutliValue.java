/**
 * Generated by Xtext, all rights reserved ESI (TNO)
 */
package nl.esi.pps.tmsc.xtext.tmscXtext;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XProperty Mutli Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.xtext.tmscXtext.XPropertyMutliValue#getValues <em>Values</em>}</li>
 * </ul>
 *
 * @see nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage#getXPropertyMutliValue()
 * @model
 * @generated
 */
public interface XPropertyMutliValue extends XPropertyValue
{
  /**
   * Returns the value of the '<em><b>Values</b></em>' containment reference list.
   * The list contents are of type {@link nl.esi.pps.tmsc.xtext.tmscXtext.XPropertyValue}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Values</em>' containment reference list.
   * @see nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage#getXPropertyMutliValue_Values()
   * @model containment="true"
   * @generated
   */
  EList<XPropertyValue> getValues();

} // XPropertyMutliValue
