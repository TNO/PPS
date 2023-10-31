/**
 */
package nl.esi.emf.properties;

import java.io.Serializable;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The PropertiesContainer facilitates the seamless extension of specific modeling elements with additional attributes, that are required for specific type of analysis. Though this allows rapid prototyping or customer specific annotations, for every property that is added to the model the question should be raised if this property is a primary citizen of the meta-model. If so, the property should be promoted as attribute or reference in the meta-model.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link nl.esi.emf.properties.PropertiesContainer#getProperties <em>Properties</em>}</li>
 * </ul>
 *
 * @see nl.esi.emf.properties.PropertiesPackage#getPropertiesContainer()
 * @model abstract="true"
 * @generated
 */
public interface PropertiesContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Properties</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.io.Serializable},
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <br><br>
	 * <b>Deprecated:</b> Properties should only be used from an Xtend context using {@link nl.esi.emf.properties.xtend.PersistedProperty}.
	 * 
	 * @deprecated
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Properties</em>' map.
	 * @see nl.esi.emf.properties.PropertiesPackage#getPropertiesContainer_Properties()
	 * @model mapType="nl.esi.emf.properties.PropertyMapEntry&lt;org.eclipse.emf.ecore.EString, nl.esi.emf.properties.EPropertyValue&gt;"
	 * @generated
	 */
	@Deprecated
	EMap<String, Serializable> getProperties();

} // PropertiesContainer
