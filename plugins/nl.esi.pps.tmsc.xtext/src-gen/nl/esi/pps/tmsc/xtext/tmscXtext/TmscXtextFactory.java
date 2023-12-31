/**
 * Generated by Xtext, all rights reserved ESI (TNO)
 */
package nl.esi.pps.tmsc.xtext.tmscXtext;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage
 * @generated
 */
public interface TmscXtextFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TmscXtextFactory eINSTANCE = nl.esi.pps.tmsc.xtext.tmscXtext.impl.TmscXtextFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  TmscXtextModel createTmscXtextModel();

  /**
   * Returns a new object of class '<em>XNamed Architecture Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>XNamed Architecture Element</em>'.
   * @generated
   */
  XNamedArchitectureElement createXNamedArchitectureElement();

  /**
   * Returns a new object of class '<em>XInterface</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>XInterface</em>'.
   * @generated
   */
  XInterface createXInterface();

  /**
   * Returns a new object of class '<em>XOperation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>XOperation</em>'.
   * @generated
   */
  XOperation createXOperation();

  /**
   * Returns a new object of class '<em>XComponent</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>XComponent</em>'.
   * @generated
   */
  XComponent createXComponent();

  /**
   * Returns a new object of class '<em>XFunction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>XFunction</em>'.
   * @generated
   */
  XFunction createXFunction();

  /**
   * Returns a new object of class '<em>XFunction Parameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>XFunction Parameter</em>'.
   * @generated
   */
  XFunctionParameter createXFunctionParameter();

  /**
   * Returns a new object of class '<em>XHost</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>XHost</em>'.
   * @generated
   */
  XHost createXHost();

  /**
   * Returns a new object of class '<em>XExecutor</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>XExecutor</em>'.
   * @generated
   */
  XExecutor createXExecutor();

  /**
   * Returns a new object of class '<em>XEvent</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>XEvent</em>'.
   * @generated
   */
  XEvent createXEvent();

  /**
   * Returns a new object of class '<em>XEvent Argument</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>XEvent Argument</em>'.
   * @generated
   */
  XEventArgument createXEventArgument();

  /**
   * Returns a new object of class '<em>XDependency</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>XDependency</em>'.
   * @generated
   */
  XDependency createXDependency();

  /**
   * Returns a new object of class '<em>XDependency Type Object</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>XDependency Type Object</em>'.
   * @generated
   */
  XDependencyTypeObject createXDependencyTypeObject();

  /**
   * Returns a new object of class '<em>XDependency Settings</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>XDependency Settings</em>'.
   * @generated
   */
  XDependencySettings createXDependencySettings();

  /**
   * Returns a new object of class '<em>XProperty</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>XProperty</em>'.
   * @generated
   */
  XProperty createXProperty();

  /**
   * Returns a new object of class '<em>XProperty Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>XProperty Value</em>'.
   * @generated
   */
  XPropertyValue createXPropertyValue();

  /**
   * Returns a new object of class '<em>XProperty String Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>XProperty String Value</em>'.
   * @generated
   */
  XPropertyStringValue createXPropertyStringValue();

  /**
   * Returns a new object of class '<em>XProperty Number Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>XProperty Number Value</em>'.
   * @generated
   */
  XPropertyNumberValue createXPropertyNumberValue();

  /**
   * Returns a new object of class '<em>XProperty Boolean Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>XProperty Boolean Value</em>'.
   * @generated
   */
  XPropertyBooleanValue createXPropertyBooleanValue();

  /**
   * Returns a new object of class '<em>XProperty Mutli Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>XProperty Mutli Value</em>'.
   * @generated
   */
  XPropertyMutliValue createXPropertyMutliValue();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  TmscXtextPackage getTmscXtextPackage();

} //TmscXtextFactory
