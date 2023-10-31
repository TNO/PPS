/**
 */
package nl.esi.pps.architecture.instantiated.impl;

import nl.esi.pps.architecture.instantiated.*;

import org.eclipse.emf.ecore.EClass;
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
public class InstantiatedFactoryImpl extends EFactoryImpl implements InstantiatedFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static InstantiatedFactory init() {
		try {
			InstantiatedFactory theInstantiatedFactory = (InstantiatedFactory) EPackage.Registry.INSTANCE
					.getEFactory(InstantiatedPackage.eNS_URI);
			if (theInstantiatedFactory != null) {
				return theInstantiatedFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new InstantiatedFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstantiatedFactoryImpl() {
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
		case InstantiatedPackage.EXECUTOR:
			return createExecutor();
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
	public Executor createExecutor() {
		ExecutorImpl executor = new ExecutorImpl();
		return executor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InstantiatedPackage getInstantiatedPackage() {
		return (InstantiatedPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static InstantiatedPackage getPackage() {
		return InstantiatedPackage.eINSTANCE;
	}

} //InstantiatedFactoryImpl
