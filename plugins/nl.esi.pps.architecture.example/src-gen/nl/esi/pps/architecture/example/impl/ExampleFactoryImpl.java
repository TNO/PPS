/**
 */
package nl.esi.pps.architecture.example.impl;

import nl.esi.pps.architecture.example.*;

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
public class ExampleFactoryImpl extends EFactoryImpl implements ExampleFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExampleFactory init() {
		try {
			ExampleFactory theExampleFactory = (ExampleFactory) EPackage.Registry.INSTANCE
					.getEFactory(ExamplePackage.eNS_URI);
			if (theExampleFactory != null) {
				return theExampleFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ExampleFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExampleFactoryImpl() {
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
		case ExamplePackage.EXAMPLE_ARCHITECTURE:
			return createExampleArchitecture();
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
	public ExampleArchitecture createExampleArchitecture() {
		ExampleArchitectureImpl exampleArchitecture = new ExampleArchitectureImpl();
		return exampleArchitecture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExamplePackage getExamplePackage() {
		return (ExamplePackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ExamplePackage getPackage() {
		return ExamplePackage.eINSTANCE;
	}

} //ExampleFactoryImpl
