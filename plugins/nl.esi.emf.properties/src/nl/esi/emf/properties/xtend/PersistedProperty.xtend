/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.emf.properties.xtend

import java.io.Serializable
import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.Target
import java.util.Collection
import nl.esi.emf.properties.PropertiesContainer
import org.eclipse.xtend.lib.macro.AbstractFieldProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.Visibility

/**
 * Use this active annotation to define a property on one ore more types. 
 * The benefits of this annotation are:
 * <ul>
 * <li>Well defined property names: prevents typos</li>
 * <li>Well defined property types: adds type checking</li>
 * </ul>
 * The modifiers of the annotated field are used as modifiers for the property 
 * and as such the user of this annotation can control the scope for this property.
 * 
 * Example of property declaration:
 * <pre>
 * @PersistedProperty(value=MyType, unsettable=false)
 * public static val String description = ''
 * </pre>
 * Example of property usage:
 * <pre>
 * def myMethod(MyType myInstance) {
 *   if (myInstance.description.isEmpty) {
 *      myInstance.description = 'My description'
 *   }
 * } 
 * </pre>
 */
@Retention(SOURCE)
@Target(ElementType.FIELD)
@Active(PersistedPropertyCompilationParticipant)
annotation PersistedProperty {
    /** Defines the types on which this property is available. */
    Class<? extends PropertiesContainer>[] value = #[PropertiesContainer]
    /** If {@code true}, unset and isSet methods are generated. */
    boolean unsettable = false
    /** 
     * Set to {@code true} if the property value is mutable.<br>
     * Note that if set to {@code true}, the property value will created 
     * (using the field initializer) and set upon getting the property value.
     */
    boolean mutable = false
    /** Defines the property category to use for this property. */
    String category = ''
    /** 
     * Defines the property category provider to use for this property.<br>
     * <b>NOTE:</b> By using a provider, a property can have 1 value per provided category.
     * @see CategoryProvider
     */
    // Why can't a default value be null? Workaround, use a specific type
    Class<? extends CategoryProvider<?>> categoryProvider = DefaultCategoryProvider
}

class PersistedPropertyCompilationParticipant extends AbstractFieldProcessor {
    override doTransform(MutableFieldDeclaration field, extension TransformationContext context) {
        val _annotation = field.findAnnotation(PersistedProperty.findTypeGlobally)
        val containerTypes = _annotation.getClassArrayValue('value')
        val unsettable = _annotation.getBooleanValue('unsettable')
        val mutable = _annotation.getBooleanValue('mutable')
        val category = _annotation.getStringValue('category')
        val categoryProvider = _annotation.getClassValue('categoryProvider')
        
        if (field.type.inferred) {
            field.addError('Type inference is not supported by @PersistedProperty')
            return
        } else if (!Serializable.findTypeGlobally.isAssignableFrom(field.type.type)) {
            field.addError('@PersistedProperty should be of type java.io.Serializable')
            return
        } else if (field.initializer === null && field.type.primitive) {
            field.addError('Initializer is required for primitive @PersistedProperty')
            return
        } else if (field.initializer === null && mutable) {
            field.addError('Initializer is required for mutable @PersistedProperty')
            return
        } 
        if (field.initializer !== null && !mutable && Collection.findTypeGlobally.isAssignableFrom(field.type.type)) {
            field.addWarning('Typically, mutable should be set to true for collections')
        }

        val contextParameterType = if (categoryProvider.type != DefaultCategoryProvider.findTypeGlobally) {
            if (!category.nullOrEmpty) {
                field.addError('''Either categoryProvider or category can be set, not both.''')
                return
            }
            val categoryMethod = categoryProvider.allResolvedMethods.map[declaration].findFirst[simpleName == 'getCategory' && parameters.size == 1]
            if (categoryMethod === null) {
                field.addError('''The categoryProvider class «categoryProvider.type.qualifiedName» does not declare method getCategory(T).''')
                return
            }
            categoryMethod.parameters.head.type
        }

        val propertyName = field.simpleName
        val propertyType = field.type
        val propertyDefault = switch (field) {
        	case field.initializer !== null && !mutable: {
                field.declaringType.addField('''_DEFAULT«FOR type : containerTypes»_«type.simpleName.toUpperCase»«ENDFOR»_«propertyName.toUpperCase»''') [
                    docComment = '''Default value for persisted {@code «propertyName»} property on «FOR type : containerTypes SEPARATOR ', '»«type.simpleName»«ENDFOR»'''
                    visibility = Visibility.PRIVATE
                    static = true
                    final = true
                    type = propertyType
                    initializer = field.initializer
                ]
        	}
            case field.initializer !== null && mutable: {
                field.declaringType.addMethod('''_getInitial«FOR type : containerTypes»_«type.simpleName»«ENDFOR»_«propertyName.toFirstUpper»''') [
                    docComment = '''Creates initial value for persisted {@code «propertyName»} property on «FOR type : containerTypes SEPARATOR ', '»«type.simpleName»«ENDFOR»'''
                    visibility = Visibility.PRIVATE
                    static = true
                    final = true
                    returnType = propertyType
                    body = field.initializer
                ]
            }
        }
        
        val propertyKeyInitializer = switch (field) {
            case contextParameterType !== null: '''
                final String category = new «categoryProvider.type.qualifiedName»().getCategory(context);
                final String key = org.eclipse.xtext.xbase.lib.StringExtensions.isNullOrEmpty(category) ? 
                        "«propertyName»" : category + "/«propertyName»";
            '''
            case !category.nullOrEmpty: '''final String key = "«category»/«propertyName»";'''
            default: '''final String key = "«propertyName»";'''
        }
        
        val getterPrefix = switch (propertyType.type) {
            case Boolean.findTypeGlobally,
            case boolean.findTypeGlobally: 'is'
            default: 'get'
        }

        for (containerType : containerTypes) {
            // add a getter method
            field.declaringType.addMethod(getterPrefix + propertyName.toFirstUpper) [
                docComment = field.docComment
                visibility = field.visibility
                static = field.static
                returnType = propertyType
                addParameter('container', containerType)
                if (contextParameterType !== null) {
                    addParameter('context', contextParameterType)
                }
                body = '''
                    «propertyKeyInitializer»
                    «IF mutable»
                        final Object value = container.getProperties().map().computeIfAbsent(key, k -> «propertyDefault.simpleName»());
                    «ELSE»
                        final Object value = container.getProperties().get(key);
                        «IF propertyDefault !== null»
                            if (value == null) {
                                return «propertyDefault.simpleName»;
                            }
                        «ENDIF»
                    «ENDIF»
                    return («propertyType») value;
                '''
            ]

            // add a setter method
            field.declaringType.addMethod('set' + propertyName.toFirstUpper) [
                docComment = field.docComment
                visibility = field.visibility
                static = field.static
                addParameter('container', containerType)
                addParameter('value', propertyType)
                if (contextParameterType !== null) {
                    addParameter('context', contextParameterType)
                }
                body = '''
                    «propertyKeyInitializer»
                    «IF unsettable || mutable»
                        container.getProperties().put(key, value);
                    «ELSE»
                        «IF propertyDefault === null» 
                            if (value == null) {
                        «ELSE»
                            if (value == «propertyDefault.simpleName»«IF !propertyType.primitive» || (value != null && «propertyDefault.simpleName» != null && value.equals(«propertyDefault.simpleName»))«ENDIF») {
                        «ENDIF»
                        container.getProperties().remove(key);
                        } else {
                            container.getProperties().put(key, value);
                        }
                    «ENDIF»
                '''
            ]

            if (unsettable) {
                field.declaringType.addMethod('isSet' + propertyName.toFirstUpper) [
                    docComment = '''Returns whether the value of the '{@link «field.declaringType.qualifiedName»#«getterPrefix»«propertyName.toFirstUpper» <em>«propertyName»</em>}' property is set on {@code container}.'''
                    visibility = field.visibility
                    static = field.static
                    returnType = newTypeReference(boolean.findTypeGlobally)
                    addParameter('container', containerType)
                    if (contextParameterType !== null) {
                        addParameter('context', contextParameterType)
                    }
                    body = '''
                        «propertyKeyInitializer»
                        return container.getProperties().containsKey(key);
                    '''
                ]

                field.declaringType.addMethod('unset' + propertyName.toFirstUpper) [
                    docComment = '''Unsets the value of the '{@link «field.declaringType.qualifiedName»#«getterPrefix»«propertyName.toFirstUpper» <em>«propertyName»</em>}' property on {@code container}.'''
                    visibility = field.visibility
                    static = field.static
                    addParameter('container', containerType)
                    if (contextParameterType !== null) {
                        addParameter('context', contextParameterType)
                    }
                    body = '''
                        «propertyKeyInitializer»
                        container.getProperties().remove(key);
                    '''
                ]
            }
        }
        
        field.remove
    }
}
