/**
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.architecture.plantuml

import java.util.Set
import net.sourceforge.plantuml.eclipse.utils.DiagramTextProvider
import nl.esi.pps.architecture.example.ExampleArchitecture
import nl.esi.pps.architecture.specified.Component
import nl.esi.pps.architecture.specified.Interface
import org.eclipse.emf.ecore.EObject
import org.eclipse.jface.viewers.ISelection
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.ui.IEditorPart
import org.eclipse.ui.IViewPart
import org.eclipse.xtend.lib.annotations.Data

class ComponentDiagramTextProvider implements DiagramTextProvider {
    override boolean supportsSelection(ISelection selection) {
        return !selection.findComponentsAndInterfaces.isEmpty
    }

    override String getDiagramText(IEditorPart editorPart, ISelection selection) {
        return selection.diagramText
    }

    override String getDiagramText(IViewPart viewPart, ISelection selection) {
        return selection.diagramText
    }
    
    def private String getDiagramText(ISelection selection) {
        val c_and_i = selection.findComponentsAndInterfaces
        if (c_and_i.isEmpty) {
            return null
        } 
        val selectedItems = (selection as IStructuredSelection).toList
        val indexedInterfaces = c_and_i.interfaces.indexed.toMap([value], [key])
        val indexedComponents = c_and_i.components.indexed.toMap([value], [key])
        
        return '''
            skinparam fixCircleLabelOverlapping true
            
            skinparam interface {
                fontColor MidnightBlue
                borderColor SteelBlue
                backgroundColor White
                backgroundColor<<selected>> Yellow
            }
            
            skinparam component {
                fontColor MidnightBlue
                arrowColor SteelBlue
                borderColor SteelBlue
                backgroundColor White
                backgroundColor<<selected>> Yellow
            }

            «FOR indexedInterface : indexedInterfaces.entrySet»
                interface "«indexedInterface.key.name»"«IF selectedItems.contains(indexedInterface.key)» <<selected>>«ENDIF» as I«indexedInterface.value»
            «ENDFOR»
            «FOR indexedComponent : indexedComponents.entrySet»
                component "«indexedComponent.key.name»"«IF selectedItems.contains(indexedComponent.key)» <<selected>>«ENDIF» as C«indexedComponent.value»
                «FOR provided : indexedComponent.key.providedInterfaces.filter[indexedInterfaces.containsKey(it)]»
                    C«indexedComponent.value» -up- I«indexedInterfaces.get(provided)»
                «ENDFOR»
                «FOR required : indexedComponent.key.requiredInterfaces.filter[indexedInterfaces.containsKey(it)]»
                    C«indexedComponent.value» .down.( I«indexedInterfaces.get(required)»
                «ENDFOR»
            «ENDFOR»
        '''
    }
    
    def private ComponentsAndInterfaces findComponentsAndInterfaces(ISelection selection) {
        val c_and_i = new ComponentsAndInterfaces
        if (selection instanceof IStructuredSelection) {
            selection.filter(EObject).forEach[addComponentsAndInterfaces(c_and_i)]
        } 
        return c_and_i
    }
    
    dispatch def private void addComponentsAndInterfaces(EObject eObject, ComponentsAndInterfaces c_and_i) {
        // Empty
    }

    dispatch def private void addComponentsAndInterfaces(ExampleArchitecture architecture, ComponentsAndInterfaces c_and_i) {
        c_and_i.interfaces += architecture.interfaces
        c_and_i.components += architecture.components
    }

    dispatch def private void addComponentsAndInterfaces(Component component, ComponentsAndInterfaces c_and_i) {
        c_and_i.interfaces += component.providedInterfaces
        c_and_i.interfaces += component.requiredInterfaces
        c_and_i.components += component
        c_and_i.components += component.providedInterfaces.flatMap[requiredBy]
        c_and_i.components += component.requiredInterfaces.flatMap[providedBy]
    }
    
    dispatch def private void addComponentsAndInterfaces(Interface _interface, ComponentsAndInterfaces c_and_i) {
        c_and_i.interfaces += _interface
        c_and_i.components += _interface.providedBy
        c_and_i.components += _interface.requiredBy
    }

    @Data
    static class ComponentsAndInterfaces {
        val Set<Component> components = newLinkedHashSet
        val Set<Interface> interfaces = newLinkedHashSet
        
        def isEmpty() {
            return components.isEmpty && interfaces.isEmpty
        }
    } 
}
