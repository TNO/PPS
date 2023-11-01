/**
 */
package nl.esi.pps.architecture.instantiated.impl;

import java.lang.reflect.InvocationTargetException;

import nl.esi.pps.architecture.deployed.Host;

import nl.esi.pps.architecture.impl.NamedArchitectureElementImpl;

import nl.esi.pps.architecture.instantiated.Executor;
import nl.esi.pps.architecture.instantiated.InstantiatedPackage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Executor</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ExecutorImpl extends NamedArchitectureElementImpl implements Executor {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InstantiatedPackage.Literals.EXECUTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Host getHost() {
		for (org.eclipse.emf.ecore.EObject e = this; e != null; e = e.eContainer()) {
			if (e instanceof Host) {
				return (Host) e;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
		case InstantiatedPackage.EXECUTOR___GET_HOST:
			return getHost();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ExecutorImpl
