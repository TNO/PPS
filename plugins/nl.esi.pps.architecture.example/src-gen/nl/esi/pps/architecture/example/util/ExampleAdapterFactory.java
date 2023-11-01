/**
 */
package nl.esi.pps.architecture.example.util;

import nl.esi.emf.properties.PropertiesContainer;

import nl.esi.pps.architecture.ArchitectureModel;
import nl.esi.pps.architecture.NamedArchitectureElement;

import nl.esi.pps.architecture.deployed.Host;

import nl.esi.pps.architecture.example.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see nl.esi.pps.architecture.example.ExamplePackage
 * @generated
 */
public class ExampleAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ExamplePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExampleAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ExamplePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExampleSwitch<Adapter> modelSwitch = new ExampleSwitch<Adapter>() {
		@Override
		public Adapter caseExampleArchitecture(ExampleArchitecture object) {
			return createExampleArchitectureAdapter();
		}

		@Override
		public Adapter caseExampleHost(ExampleHost object) {
			return createExampleHostAdapter();
		}

		@Override
		public Adapter casePropertiesContainer(PropertiesContainer object) {
			return createPropertiesContainerAdapter();
		}

		@Override
		public Adapter caseArchitectureModel(ArchitectureModel object) {
			return createArchitectureModelAdapter();
		}

		@Override
		public Adapter caseNamedArchitectureElement(NamedArchitectureElement object) {
			return createNamedArchitectureElementAdapter();
		}

		@Override
		public Adapter caseHost(Host object) {
			return createHostAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esi.pps.architecture.example.ExampleArchitecture <em>Architecture</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esi.pps.architecture.example.ExampleArchitecture
	 * @generated
	 */
	public Adapter createExampleArchitectureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esi.pps.architecture.example.ExampleHost <em>Host</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esi.pps.architecture.example.ExampleHost
	 * @generated
	 */
	public Adapter createExampleHostAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esi.emf.properties.PropertiesContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esi.emf.properties.PropertiesContainer
	 * @generated
	 */
	public Adapter createPropertiesContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esi.pps.architecture.ArchitectureModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esi.pps.architecture.ArchitectureModel
	 * @generated
	 */
	public Adapter createArchitectureModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esi.pps.architecture.NamedArchitectureElement <em>Named Architecture Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esi.pps.architecture.NamedArchitectureElement
	 * @generated
	 */
	public Adapter createNamedArchitectureElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esi.pps.architecture.deployed.Host <em>Host</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esi.pps.architecture.deployed.Host
	 * @generated
	 */
	public Adapter createHostAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ExampleAdapterFactory
