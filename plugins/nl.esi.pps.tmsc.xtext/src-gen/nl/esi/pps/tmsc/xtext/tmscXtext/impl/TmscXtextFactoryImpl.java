/**
 * Generated by Xtext, all rights reserved ESI (TNO)
 */
package nl.esi.pps.tmsc.xtext.tmscXtext.impl;

import nl.esi.pps.tmsc.xtext.tmscXtext.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TmscXtextFactoryImpl extends EFactoryImpl implements TmscXtextFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static TmscXtextFactory init()
  {
    try
    {
      TmscXtextFactory theTmscXtextFactory = (TmscXtextFactory)EPackage.Registry.INSTANCE.getEFactory(TmscXtextPackage.eNS_URI);
      if (theTmscXtextFactory != null)
      {
        return theTmscXtextFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new TmscXtextFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TmscXtextFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case TmscXtextPackage.TMSC_XTEXT_MODEL: return createTmscXtextModel();
      case TmscXtextPackage.XNAMED_ARCHITECTURE_ELEMENT: return createXNamedArchitectureElement();
      case TmscXtextPackage.XINTERFACE: return createXInterface();
      case TmscXtextPackage.XOPERATION: return createXOperation();
      case TmscXtextPackage.XCOMPONENT: return createXComponent();
      case TmscXtextPackage.XFUNCTION: return createXFunction();
      case TmscXtextPackage.XFUNCTION_PARAMETER: return createXFunctionParameter();
      case TmscXtextPackage.XHOST: return createXHost();
      case TmscXtextPackage.XEXECUTOR: return createXExecutor();
      case TmscXtextPackage.XEVENT: return createXEvent();
      case TmscXtextPackage.XEVENT_ARGUMENT: return createXEventArgument();
      case TmscXtextPackage.XDEPENDENCY: return createXDependency();
      case TmscXtextPackage.XDEPENDENCY_TYPE_OBJECT: return createXDependencyTypeObject();
      case TmscXtextPackage.XDEPENDENCY_SETTINGS: return createXDependencySettings();
      case TmscXtextPackage.XPROPERTY: return createXProperty();
      case TmscXtextPackage.XPROPERTY_VALUE: return createXPropertyValue();
      case TmscXtextPackage.XPROPERTY_STRING_VALUE: return createXPropertyStringValue();
      case TmscXtextPackage.XPROPERTY_NUMBER_VALUE: return createXPropertyNumberValue();
      case TmscXtextPackage.XPROPERTY_BOOLEAN_VALUE: return createXPropertyBooleanValue();
      case TmscXtextPackage.XPROPERTY_MUTLI_VALUE: return createXPropertyMutliValue();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case TmscXtextPackage.XARCHITECTURE_KIND:
        return createXArchitectureKindFromString(eDataType, initialValue);
      case TmscXtextPackage.XFUNCTION_PARAMETER_KIND:
        return createXFunctionParameterKindFromString(eDataType, initialValue);
      case TmscXtextPackage.XEVENT_TYPE:
        return createXEventTypeFromString(eDataType, initialValue);
      case TmscXtextPackage.XDEPENDENCY_TYPE:
        return createXDependencyTypeFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case TmscXtextPackage.XARCHITECTURE_KIND:
        return convertXArchitectureKindToString(eDataType, instanceValue);
      case TmscXtextPackage.XFUNCTION_PARAMETER_KIND:
        return convertXFunctionParameterKindToString(eDataType, instanceValue);
      case TmscXtextPackage.XEVENT_TYPE:
        return convertXEventTypeToString(eDataType, instanceValue);
      case TmscXtextPackage.XDEPENDENCY_TYPE:
        return convertXDependencyTypeToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TmscXtextModel createTmscXtextModel()
  {
    TmscXtextModelImpl tmscXtextModel = new TmscXtextModelImpl();
    return tmscXtextModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public XNamedArchitectureElement createXNamedArchitectureElement()
  {
    XNamedArchitectureElementImpl xNamedArchitectureElement = new XNamedArchitectureElementImpl();
    return xNamedArchitectureElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public XInterface createXInterface()
  {
    XInterfaceImpl xInterface = new XInterfaceImpl();
    return xInterface;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public XOperation createXOperation()
  {
    XOperationImpl xOperation = new XOperationImpl();
    return xOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public XComponent createXComponent()
  {
    XComponentImpl xComponent = new XComponentImpl();
    return xComponent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public XFunction createXFunction()
  {
    XFunctionImpl xFunction = new XFunctionImpl();
    return xFunction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public XFunctionParameter createXFunctionParameter()
  {
    XFunctionParameterImpl xFunctionParameter = new XFunctionParameterImpl();
    return xFunctionParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public XHost createXHost()
  {
    XHostImpl xHost = new XHostImpl();
    return xHost;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public XExecutor createXExecutor()
  {
    XExecutorImpl xExecutor = new XExecutorImpl();
    return xExecutor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public XEvent createXEvent()
  {
    XEventImpl xEvent = new XEventImpl();
    return xEvent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public XEventArgument createXEventArgument()
  {
    XEventArgumentImpl xEventArgument = new XEventArgumentImpl();
    return xEventArgument;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public XDependency createXDependency()
  {
    XDependencyImpl xDependency = new XDependencyImpl();
    return xDependency;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public XDependencyTypeObject createXDependencyTypeObject()
  {
    XDependencyTypeObjectImpl xDependencyTypeObject = new XDependencyTypeObjectImpl();
    return xDependencyTypeObject;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public XDependencySettings createXDependencySettings()
  {
    XDependencySettingsImpl xDependencySettings = new XDependencySettingsImpl();
    return xDependencySettings;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public XProperty createXProperty()
  {
    XPropertyImpl xProperty = new XPropertyImpl();
    return xProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public XPropertyValue createXPropertyValue()
  {
    XPropertyValueImpl xPropertyValue = new XPropertyValueImpl();
    return xPropertyValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public XPropertyStringValue createXPropertyStringValue()
  {
    XPropertyStringValueImpl xPropertyStringValue = new XPropertyStringValueImpl();
    return xPropertyStringValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public XPropertyNumberValue createXPropertyNumberValue()
  {
    XPropertyNumberValueImpl xPropertyNumberValue = new XPropertyNumberValueImpl();
    return xPropertyNumberValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public XPropertyBooleanValue createXPropertyBooleanValue()
  {
    XPropertyBooleanValueImpl xPropertyBooleanValue = new XPropertyBooleanValueImpl();
    return xPropertyBooleanValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public XPropertyMutliValue createXPropertyMutliValue()
  {
    XPropertyMutliValueImpl xPropertyMutliValue = new XPropertyMutliValueImpl();
    return xPropertyMutliValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XArchitectureKind createXArchitectureKindFromString(EDataType eDataType, String initialValue)
  {
    XArchitectureKind result = XArchitectureKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertXArchitectureKindToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XFunctionParameterKind createXFunctionParameterKindFromString(EDataType eDataType, String initialValue)
  {
    XFunctionParameterKind result = XFunctionParameterKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertXFunctionParameterKindToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XEventType createXEventTypeFromString(EDataType eDataType, String initialValue)
  {
    XEventType result = XEventType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertXEventTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XDependencyType createXDependencyTypeFromString(EDataType eDataType, String initialValue)
  {
    XDependencyType result = XDependencyType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertXDependencyTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TmscXtextPackage getTmscXtextPackage()
  {
    return (TmscXtextPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static TmscXtextPackage getPackage()
  {
    return TmscXtextPackage.eINSTANCE;
  }

} //TmscXtextFactoryImpl
