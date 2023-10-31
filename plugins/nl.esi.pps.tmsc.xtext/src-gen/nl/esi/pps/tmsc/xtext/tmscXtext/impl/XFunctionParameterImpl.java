/**
 * Generated by Xtext, all rights reserved ESI (TNO)
 */
package nl.esi.pps.tmsc.xtext.tmscXtext.impl;

import java.util.Collection;

import nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage;
import nl.esi.pps.tmsc.xtext.tmscXtext.XFunctionParameter;
import nl.esi.pps.tmsc.xtext.tmscXtext.XFunctionParameterKind;
import nl.esi.pps.tmsc.xtext.tmscXtext.XProperty;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XFunction Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.xtext.tmscXtext.impl.XFunctionParameterImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.xtext.tmscXtext.impl.XFunctionParameterImpl#getName <em>Name</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.xtext.tmscXtext.impl.XFunctionParameterImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 *
 * @generated
 */
public class XFunctionParameterImpl extends MinimalEObjectImpl.Container implements XFunctionParameter
{
  /**
   * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKind()
   * @generated
   * @ordered
   */
  protected static final XFunctionParameterKind KIND_EDEFAULT = XFunctionParameterKind.IN;

  /**
   * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKind()
   * @generated
   * @ordered
   */
  protected XFunctionParameterKind kind = KIND_EDEFAULT;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperties()
   * @generated
   * @ordered
   */
  protected EList<XProperty> properties;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected XFunctionParameterImpl()
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
    return TmscXtextPackage.Literals.XFUNCTION_PARAMETER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public XFunctionParameterKind getKind()
  {
    return kind;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setKind(XFunctionParameterKind newKind)
  {
    XFunctionParameterKind oldKind = kind;
    kind = newKind == null ? KIND_EDEFAULT : newKind;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TmscXtextPackage.XFUNCTION_PARAMETER__KIND, oldKind, kind));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TmscXtextPackage.XFUNCTION_PARAMETER__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<XProperty> getProperties()
  {
    if (properties == null)
    {
      properties = new EObjectContainmentEList<XProperty>(XProperty.class, this, TmscXtextPackage.XFUNCTION_PARAMETER__PROPERTIES);
    }
    return properties;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case TmscXtextPackage.XFUNCTION_PARAMETER__PROPERTIES:
        return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case TmscXtextPackage.XFUNCTION_PARAMETER__KIND:
        return getKind();
      case TmscXtextPackage.XFUNCTION_PARAMETER__NAME:
        return getName();
      case TmscXtextPackage.XFUNCTION_PARAMETER__PROPERTIES:
        return getProperties();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case TmscXtextPackage.XFUNCTION_PARAMETER__KIND:
        setKind((XFunctionParameterKind)newValue);
        return;
      case TmscXtextPackage.XFUNCTION_PARAMETER__NAME:
        setName((String)newValue);
        return;
      case TmscXtextPackage.XFUNCTION_PARAMETER__PROPERTIES:
        getProperties().clear();
        getProperties().addAll((Collection<? extends XProperty>)newValue);
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
      case TmscXtextPackage.XFUNCTION_PARAMETER__KIND:
        setKind(KIND_EDEFAULT);
        return;
      case TmscXtextPackage.XFUNCTION_PARAMETER__NAME:
        setName(NAME_EDEFAULT);
        return;
      case TmscXtextPackage.XFUNCTION_PARAMETER__PROPERTIES:
        getProperties().clear();
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
      case TmscXtextPackage.XFUNCTION_PARAMETER__KIND:
        return kind != KIND_EDEFAULT;
      case TmscXtextPackage.XFUNCTION_PARAMETER__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case TmscXtextPackage.XFUNCTION_PARAMETER__PROPERTIES:
        return properties != null && !properties.isEmpty();
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
    result.append(" (kind: ");
    result.append(kind);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //XFunctionParameterImpl
