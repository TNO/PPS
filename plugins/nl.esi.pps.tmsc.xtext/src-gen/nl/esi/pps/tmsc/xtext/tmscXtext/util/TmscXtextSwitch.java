/**
 * Generated by Xtext, all rights reserved ESI (TNO)
 */
package nl.esi.pps.tmsc.xtext.tmscXtext.util;

import nl.esi.pps.tmsc.xtext.tmscXtext.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage
 * @generated
 */
public class TmscXtextSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static TmscXtextPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TmscXtextSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = TmscXtextPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case TmscXtextPackage.TMSC_XTEXT_MODEL:
      {
        TmscXtextModel tmscXtextModel = (TmscXtextModel)theEObject;
        T result = caseTmscXtextModel(tmscXtextModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TmscXtextPackage.XNAMED_ARCHITECTURE_ELEMENT:
      {
        XNamedArchitectureElement xNamedArchitectureElement = (XNamedArchitectureElement)theEObject;
        T result = caseXNamedArchitectureElement(xNamedArchitectureElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TmscXtextPackage.XINTERFACE:
      {
        XInterface xInterface = (XInterface)theEObject;
        T result = caseXInterface(xInterface);
        if (result == null) result = caseXNamedArchitectureElement(xInterface);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TmscXtextPackage.XOPERATION:
      {
        XOperation xOperation = (XOperation)theEObject;
        T result = caseXOperation(xOperation);
        if (result == null) result = caseXNamedArchitectureElement(xOperation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TmscXtextPackage.XCOMPONENT:
      {
        XComponent xComponent = (XComponent)theEObject;
        T result = caseXComponent(xComponent);
        if (result == null) result = caseXNamedArchitectureElement(xComponent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TmscXtextPackage.XFUNCTION:
      {
        XFunction xFunction = (XFunction)theEObject;
        T result = caseXFunction(xFunction);
        if (result == null) result = caseXNamedArchitectureElement(xFunction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TmscXtextPackage.XFUNCTION_PARAMETER:
      {
        XFunctionParameter xFunctionParameter = (XFunctionParameter)theEObject;
        T result = caseXFunctionParameter(xFunctionParameter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TmscXtextPackage.XEXECUTOR:
      {
        XExecutor xExecutor = (XExecutor)theEObject;
        T result = caseXExecutor(xExecutor);
        if (result == null) result = caseXNamedArchitectureElement(xExecutor);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TmscXtextPackage.XEVENT:
      {
        XEvent xEvent = (XEvent)theEObject;
        T result = caseXEvent(xEvent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TmscXtextPackage.XEVENT_ARGUMENT:
      {
        XEventArgument xEventArgument = (XEventArgument)theEObject;
        T result = caseXEventArgument(xEventArgument);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TmscXtextPackage.XDEPENDENCY:
      {
        XDependency xDependency = (XDependency)theEObject;
        T result = caseXDependency(xDependency);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TmscXtextPackage.XDEPENDENCY_TYPE_OBJECT:
      {
        XDependencyTypeObject xDependencyTypeObject = (XDependencyTypeObject)theEObject;
        T result = caseXDependencyTypeObject(xDependencyTypeObject);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TmscXtextPackage.XDEPENDENCY_SETTINGS:
      {
        XDependencySettings xDependencySettings = (XDependencySettings)theEObject;
        T result = caseXDependencySettings(xDependencySettings);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TmscXtextPackage.XPROPERTY:
      {
        XProperty xProperty = (XProperty)theEObject;
        T result = caseXProperty(xProperty);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TmscXtextPackage.XPROPERTY_VALUE:
      {
        XPropertyValue xPropertyValue = (XPropertyValue)theEObject;
        T result = caseXPropertyValue(xPropertyValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TmscXtextPackage.XPROPERTY_STRING_VALUE:
      {
        XPropertyStringValue xPropertyStringValue = (XPropertyStringValue)theEObject;
        T result = caseXPropertyStringValue(xPropertyStringValue);
        if (result == null) result = caseXPropertyValue(xPropertyStringValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TmscXtextPackage.XPROPERTY_NUMBER_VALUE:
      {
        XPropertyNumberValue xPropertyNumberValue = (XPropertyNumberValue)theEObject;
        T result = caseXPropertyNumberValue(xPropertyNumberValue);
        if (result == null) result = caseXPropertyValue(xPropertyNumberValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TmscXtextPackage.XPROPERTY_BOOLEAN_VALUE:
      {
        XPropertyBooleanValue xPropertyBooleanValue = (XPropertyBooleanValue)theEObject;
        T result = caseXPropertyBooleanValue(xPropertyBooleanValue);
        if (result == null) result = caseXPropertyValue(xPropertyBooleanValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TmscXtextPackage.XPROPERTY_MUTLI_VALUE:
      {
        XPropertyMutliValue xPropertyMutliValue = (XPropertyMutliValue)theEObject;
        T result = caseXPropertyMutliValue(xPropertyMutliValue);
        if (result == null) result = caseXPropertyValue(xPropertyMutliValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTmscXtextModel(TmscXtextModel object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XNamed Architecture Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XNamed Architecture Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXNamedArchitectureElement(XNamedArchitectureElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XInterface</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XInterface</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXInterface(XInterface object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XOperation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XOperation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXOperation(XOperation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XComponent</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XComponent</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXComponent(XComponent object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XFunction</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XFunction</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXFunction(XFunction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XFunction Parameter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XFunction Parameter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXFunctionParameter(XFunctionParameter object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XExecutor</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XExecutor</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXExecutor(XExecutor object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XEvent</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XEvent</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXEvent(XEvent object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XEvent Argument</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XEvent Argument</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXEventArgument(XEventArgument object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XDependency</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XDependency</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXDependency(XDependency object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XDependency Type Object</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XDependency Type Object</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXDependencyTypeObject(XDependencyTypeObject object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XDependency Settings</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XDependency Settings</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXDependencySettings(XDependencySettings object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XProperty</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XProperty</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXProperty(XProperty object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XProperty Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XProperty Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXPropertyValue(XPropertyValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XProperty String Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XProperty String Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXPropertyStringValue(XPropertyStringValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XProperty Number Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XProperty Number Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXPropertyNumberValue(XPropertyNumberValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XProperty Boolean Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XProperty Boolean Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXPropertyBooleanValue(XPropertyBooleanValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XProperty Mutli Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XProperty Mutli Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXPropertyMutliValue(XPropertyMutliValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //TmscXtextSwitch
