/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.architecture.provider

import nl.esi.emf.edit.provider.EMFEditUtil
import nl.esi.pps.architecture.NamedArchitectureElement
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import nl.esi.pps.architecture.ArchitecturePackage
import nl.esi.pps.architecture.implemented.ImplementedPackage
import nl.esi.pps.architecture.specified.SpecifiedPackage
import nl.esi.pps.architecture.instantiated.InstantiatedPackage
import nl.esi.pps.architecture.implemented.FunctionParameter

class ArchitectureItemLabelSwitch {
    public static val eINSTANCE = new ArchitectureItemLabelSwitch

    dispatch def String getText(Object object) {
        return String::valueOf(object)
    }

    dispatch def String getText(EObject eObject) {
        return switch (eObject.eClass.EPackage) {
            case SpecifiedPackage::eINSTANCE,
            case ImplementedPackage::eINSTANCE,
            case InstantiatedPackage::eINSTANCE,
            case ArchitecturePackage::eINSTANCE: eObject.eClass.text
            default: EMFEditUtil::getText(eObject)
        }
    }
    
    dispatch def String getText(EClass eClass) {
        val name = switch (eClass.EPackage) {
            case SpecifiedPackage::eINSTANCE,
            case ImplementedPackage::eINSTANCE,
            case InstantiatedPackage::eINSTANCE,
            case ArchitecturePackage::eINSTANCE: ArchitectureEditPlugin.INSTANCE.getString('''_UI_«eClass.name»_type''')
            default: null
        }
        return name ?: eClass.name
    }

    // Architecture

    dispatch def String getText(NamedArchitectureElement element) {
        return element.name
    }
    
    // Implemented
    
    dispatch def String getText(FunctionParameter parameter) {
        return '''«parameter.kind.literal» «parameter.name»'''
    }
}