/**
 * Generated by Xtext, all rights reserved ESI (TNO)
 */
package nl.esi.pps.tmsc.xtext.tmscXtext.impl;

import java.math.BigDecimal;

import java.util.Collection;

import nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage;
import nl.esi.pps.tmsc.xtext.tmscXtext.XExecutor;
import nl.esi.pps.tmsc.xtext.tmscXtext.XHost;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XHost</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.pps.tmsc.xtext.tmscXtext.impl.XHostImpl#isUntraced <em>Untraced</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.xtext.tmscXtext.impl.XHostImpl#getTimeBound <em>Time Bound</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.xtext.tmscXtext.impl.XHostImpl#getScheduled <em>Scheduled</em>}</li>
 *   <li>{@link nl.esi.pps.tmsc.xtext.tmscXtext.impl.XHostImpl#getExecutors <em>Executors</em>}</li>
 * </ul>
 *
 * @generated
 */
public class XHostImpl extends XNamedArchitectureElementImpl implements XHost
{
  /**
   * The default value of the '{@link #isUntraced() <em>Untraced</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUntraced()
   * @generated
   * @ordered
   */
  protected static final boolean UNTRACED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isUntraced() <em>Untraced</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUntraced()
   * @generated
   * @ordered
   */
  protected boolean untraced = UNTRACED_EDEFAULT;

  /**
   * The default value of the '{@link #getTimeBound() <em>Time Bound</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTimeBound()
   * @generated
   * @ordered
   */
  protected static final BigDecimal TIME_BOUND_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTimeBound() <em>Time Bound</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTimeBound()
   * @generated
   * @ordered
   */
  protected BigDecimal timeBound = TIME_BOUND_EDEFAULT;

  /**
   * The default value of the '{@link #getScheduled() <em>Scheduled</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScheduled()
   * @generated
   * @ordered
   */
  protected static final Boolean SCHEDULED_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getScheduled() <em>Scheduled</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScheduled()
   * @generated
   * @ordered
   */
  protected Boolean scheduled = SCHEDULED_EDEFAULT;

  /**
   * The cached value of the '{@link #getExecutors() <em>Executors</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExecutors()
   * @generated
   * @ordered
   */
  protected EList<XExecutor> executors;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected XHostImpl()
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
    return TmscXtextPackage.Literals.XHOST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isUntraced()
  {
    return untraced;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setUntraced(boolean newUntraced)
  {
    boolean oldUntraced = untraced;
    untraced = newUntraced;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TmscXtextPackage.XHOST__UNTRACED, oldUntraced, untraced));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BigDecimal getTimeBound()
  {
    return timeBound;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setTimeBound(BigDecimal newTimeBound)
  {
    BigDecimal oldTimeBound = timeBound;
    timeBound = newTimeBound;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TmscXtextPackage.XHOST__TIME_BOUND, oldTimeBound, timeBound));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Boolean getScheduled()
  {
    return scheduled;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setScheduled(Boolean newScheduled)
  {
    Boolean oldScheduled = scheduled;
    scheduled = newScheduled;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TmscXtextPackage.XHOST__SCHEDULED, oldScheduled, scheduled));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<XExecutor> getExecutors()
  {
    if (executors == null)
    {
      executors = new EObjectContainmentEList<XExecutor>(XExecutor.class, this, TmscXtextPackage.XHOST__EXECUTORS);
    }
    return executors;
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
      case TmscXtextPackage.XHOST__EXECUTORS:
        return ((InternalEList<?>)getExecutors()).basicRemove(otherEnd, msgs);
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
      case TmscXtextPackage.XHOST__UNTRACED:
        return isUntraced();
      case TmscXtextPackage.XHOST__TIME_BOUND:
        return getTimeBound();
      case TmscXtextPackage.XHOST__SCHEDULED:
        return getScheduled();
      case TmscXtextPackage.XHOST__EXECUTORS:
        return getExecutors();
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
      case TmscXtextPackage.XHOST__UNTRACED:
        setUntraced((Boolean)newValue);
        return;
      case TmscXtextPackage.XHOST__TIME_BOUND:
        setTimeBound((BigDecimal)newValue);
        return;
      case TmscXtextPackage.XHOST__SCHEDULED:
        setScheduled((Boolean)newValue);
        return;
      case TmscXtextPackage.XHOST__EXECUTORS:
        getExecutors().clear();
        getExecutors().addAll((Collection<? extends XExecutor>)newValue);
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
      case TmscXtextPackage.XHOST__UNTRACED:
        setUntraced(UNTRACED_EDEFAULT);
        return;
      case TmscXtextPackage.XHOST__TIME_BOUND:
        setTimeBound(TIME_BOUND_EDEFAULT);
        return;
      case TmscXtextPackage.XHOST__SCHEDULED:
        setScheduled(SCHEDULED_EDEFAULT);
        return;
      case TmscXtextPackage.XHOST__EXECUTORS:
        getExecutors().clear();
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
      case TmscXtextPackage.XHOST__UNTRACED:
        return untraced != UNTRACED_EDEFAULT;
      case TmscXtextPackage.XHOST__TIME_BOUND:
        return TIME_BOUND_EDEFAULT == null ? timeBound != null : !TIME_BOUND_EDEFAULT.equals(timeBound);
      case TmscXtextPackage.XHOST__SCHEDULED:
        return SCHEDULED_EDEFAULT == null ? scheduled != null : !SCHEDULED_EDEFAULT.equals(scheduled);
      case TmscXtextPackage.XHOST__EXECUTORS:
        return executors != null && !executors.isEmpty();
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
    result.append(" (untraced: ");
    result.append(untraced);
    result.append(", timeBound: ");
    result.append(timeBound);
    result.append(", scheduled: ");
    result.append(scheduled);
    result.append(')');
    return result.toString();
  }

} //XHostImpl
