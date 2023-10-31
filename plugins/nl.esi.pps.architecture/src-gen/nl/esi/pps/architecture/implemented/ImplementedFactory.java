/**
 */
package nl.esi.pps.architecture.implemented;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see nl.esi.pps.architecture.implemented.ImplementedPackage
 * @generated
 */
public interface ImplementedFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ImplementedFactory eINSTANCE = nl.esi.pps.architecture.implemented.impl.ImplementedFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function</em>'.
	 * @generated
	 */
	Function createFunction();

	/**
	 * Returns a new object of class '<em>IPC Client Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IPC Client Function</em>'.
	 * @generated
	 */
	IPCClientFunction createIPCClientFunction();

	/**
	 * Returns a new object of class '<em>IPC Server Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IPC Server Function</em>'.
	 * @generated
	 */
	IPCServerFunction createIPCServerFunction();

	/**
	 * Returns a new object of class '<em>Function Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function Parameter</em>'.
	 * @generated
	 */
	FunctionParameter createFunctionParameter();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ImplementedPackage getImplementedPackage();

} //ImplementedFactory
