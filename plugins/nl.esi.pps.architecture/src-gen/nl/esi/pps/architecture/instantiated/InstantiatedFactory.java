/**
 */
package nl.esi.pps.architecture.instantiated;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see nl.esi.pps.architecture.instantiated.InstantiatedPackage
 * @generated
 */
public interface InstantiatedFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	InstantiatedFactory eINSTANCE = nl.esi.pps.architecture.instantiated.impl.InstantiatedFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Executor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Executor</em>'.
	 * @generated
	 */
	Executor createExecutor();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	InstantiatedPackage getInstantiatedPackage();

} //InstantiatedFactory
