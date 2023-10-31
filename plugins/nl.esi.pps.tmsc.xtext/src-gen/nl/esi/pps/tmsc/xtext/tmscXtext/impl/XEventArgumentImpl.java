/**
 * Generated by Xtext, all rights reserved ESI (TNO)
 */
package nl.esi.pps.tmsc.xtext.tmscXtext.impl;

import nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage;
import nl.esi.pps.tmsc.xtext.tmscXtext.XEventArgument;
import nl.esi.pps.tmsc.xtext.tmscXtext.XFunctionParameter;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XEvent Argument</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.xtext.tmscXtext.impl.XEventArgumentImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.xtext.tmscXtext.impl.XEventArgumentImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class XEventArgumentImpl extends MinimalEObjectImpl.Container implements XEventArgument
{
  /**
   * The cached value of the '{@link #getParameter() <em>Parameter</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameter()
   * @generated
   * @ordered
   */
  protected XFunctionParameter parameter;

  /**
   * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected static final String VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected String value = VALUE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected XEventArgumentImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return TmscXtextPackage.Literals.XEVENT_ARGUMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public XFunctionParameter getParameter()
  {
    if (parameter != null && parameter.eIsProxy())
    {
      InternalEObject oldParameter = (InternalEObject)parameter;
      parameter = (XFunctionParameter)eResolveProxy(oldParameter);
      if (parameter != oldParameter)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TmscXtextPackage.XEVENT_ARGUMENT__PARAMETER, oldParameter, parameter));
      }
    }
    return parameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XFunctionParameter basicGetParameter()
  {
    return parameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setParameter(XFunctionParameter newParameter)
  {
    XFunctionParameter oldParameter = parameter;
    parameter = newParameter;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TmscXtextPackage.XEVENT_ARGUMENT__PARAMETER, oldParameter, parameter));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setValue(String newValue)
  {
    String oldValue = value;
    value = newValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TmscXtextPackage.XEVENT_ARGUMENT__VALUE, oldValue, value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case TmscXtextPackage.XEVENT_ARGUMENT__PARAMETER:
        if (resolve) return getParameter();
        return basicGetParameter();
      case TmscXtextPackage.XEVENT_ARGUMENT__VALUE:
        return getValue();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case TmscXtextPackage.XEVENT_ARGUMENT__PARAMETER:
        setParameter((XFunctionParameter)newValue);
        return;
      case TmscXtextPackage.XEVENT_ARGUMENT__VALUE:
        setValue((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case TmscXtextPackage.XEVENT_ARGUMENT__PARAMETER:
        setParameter((XFunctionParameter)null);
        return;
      case TmscXtextPackage.XEVENT_ARGUMENT__VALUE:
        setValue(VALUE_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case TmscXtextPackage.XEVENT_ARGUMENT__PARAMETER:
        return parameter != null;
      case TmscXtextPackage.XEVENT_ARGUMENT__VALUE:
        return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (value: ");
    result.append(value);
    result.append(')');
    return result.toString();
  }

} //XEventArgumentImpl
