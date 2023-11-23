/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.emf.properties.xtend;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import nl.esi.emf.properties.PropertiesContainer;
import org.eclipse.xtend.lib.macro.Active;

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
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.FIELD)
@Active(PersistedPropertyCompilationParticipant.class)
@SuppressWarnings("all")
public @interface PersistedProperty {
  /**
   * Defines the types on which this property is available.
   */
  public Class<? extends PropertiesContainer>[] value() default { PropertiesContainer.class };
  /**
   * If {@code true}, unset and isSet methods are generated.
   */
  public boolean unsettable() default false;
  /**
   * Set to {@code true} if the property value is mutable.<br>
   * Note that if set to {@code true}, the property value will created
   * (using the field initializer) and set upon getting the property value.
   */
  public boolean mutable() default false;
  /**
   * Defines the property category to use for this property.
   */
  public String category() default "";
  /**
   * Defines the property category provider to use for this property.<br>
   * <b>NOTE:</b> By using a provider, a property can have 1 value per provided category.
   * @see CategoryProvider
   */
  public Class<? extends CategoryProvider<?>> categoryProvider() default DefaultCategoryProvider.class;
}
