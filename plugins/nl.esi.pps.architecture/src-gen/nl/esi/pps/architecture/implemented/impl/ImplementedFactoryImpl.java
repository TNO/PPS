/**
 */
package nl.esi.pps.architecture.implemented.impl;

import nl.esi.pps.architecture.implemented.*;

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
public class ImplementedFactoryImpl extends EFactoryImpl implements ImplementedFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ImplementedFactory init() {
		try {
			ImplementedFactory theImplementedFactory = (ImplementedFactory) EPackage.Registry.INSTANCE
					.getEFactory(ImplementedPackage.eNS_URI);
			if (theImplementedFactory != null) {
				return theImplementedFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ImplementedFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImplementedFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case ImplementedPackage.FUNCTION:
			return createFunction();
		case ImplementedPackage.IPC_CLIENT_FUNCTION:
			return createIPCClientFunction();
		case ImplementedPackage.IPC_SERVER_FUNCTION:
			return createIPCServerFunction();
		case ImplementedPackage.FUNCTION_PARAMETER:
			return createFunctionParameter();
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
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case ImplementedPackage.FUNCTION_PARAMETER_KIND:
			return createFunctionParameterKindFromString(eDataType, initialValue);
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
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case ImplementedPackage.FUNCTION_PARAMETER_KIND:
			return convertFunctionParameterKindToString(eDataType, instanceValue);
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
	public Function createFunction() {
		FunctionImpl function = new FunctionImpl();
		return function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IPCClientFunction createIPCClientFunction() {
		IPCClientFunctionImpl ipcClientFunction = new IPCClientFunctionImpl();
		return ipcClientFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IPCServerFunction createIPCServerFunction() {
		IPCServerFunctionImpl ipcServerFunction = new IPCServerFunctionImpl();
		return ipcServerFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FunctionParameter createFunctionParameter() {
		FunctionParameterImpl functionParameter = new FunctionParameterImpl();
		return functionParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionParameterKind createFunctionParameterKindFromString(EDataType eDataType, String initialValue) {
		FunctionParameterKind result = FunctionParameterKind.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFunctionParameterKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImplementedPackage getImplementedPackage() {
		return (ImplementedPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ImplementedPackage getPackage() {
		return ImplementedPackage.eINSTANCE;
	}

} //ImplementedFactoryImpl
