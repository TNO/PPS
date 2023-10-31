/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.provider

import nl.esi.emf.edit.provider.EMFEditUtil
import nl.esi.pps.architecture.ArchitecturePackage
import nl.esi.pps.architecture.implemented.ImplementedPackage
import nl.esi.pps.architecture.instantiated.InstantiatedPackage
import nl.esi.pps.architecture.provider.ArchitectureItemLabelSwitch
import nl.esi.pps.architecture.specified.SpecifiedPackage
import nl.esi.pps.tmsc.Dependency
import nl.esi.pps.tmsc.EntryEvent
import nl.esi.pps.tmsc.Execution
import nl.esi.pps.tmsc.ExitEvent
import nl.esi.pps.tmsc.FullScopeTMSC
import nl.esi.pps.tmsc.Interval
import nl.esi.pps.tmsc.Lifeline
import nl.esi.pps.tmsc.LifelineSegment
import nl.esi.pps.tmsc.MessageControl
import nl.esi.pps.tmsc.ScopedTMSC
import nl.esi.pps.tmsc.TmscPackage
import nl.esi.pps.tmsc.text.ETimestampFormat
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject

class TmscItemLabelSwitch {
    public static val eINSTANCE = new TmscItemLabelSwitch

    dispatch def String getText(Object object) {
        return String::valueOf(object)
    }

    dispatch def String getText(EObject eObject) {
        return switch (eObject.eClass.EPackage) {
            case TmscPackage::eINSTANCE: eObject.eClass.text
            case SpecifiedPackage::eINSTANCE,
            case ImplementedPackage::eINSTANCE,
            case InstantiatedPackage::eINSTANCE,
            case ArchitecturePackage::eINSTANCE: ArchitectureItemLabelSwitch::eINSTANCE.getText(eObject)
            default: EMFEditUtil::getText(eObject)
        }
    }
    
    dispatch def String getText(EClass eClass) {
        val name = switch (eClass.EPackage) {
            case TmscPackage::eINSTANCE: TmscEditPlugin.INSTANCE.getString('''_UI_«eClass.name»_type''')
            case SpecifiedPackage::eINSTANCE,
            case ImplementedPackage::eINSTANCE,
            case InstantiatedPackage::eINSTANCE,
            case ArchitecturePackage::eINSTANCE: ArchitectureItemLabelSwitch::eINSTANCE.getText(eClass)
            default: null
        }
        return name ?: eClass.name
    }

    dispatch def String getText(FullScopeTMSC tmsc) {
        return tmsc.eClass.text
    }

    dispatch def String getText(ScopedTMSC tmsc) {
        return tmsc.name
    }

    dispatch def String getText(Lifeline lifeline) {
        return lifeline.executor?.text
    }

    dispatch def String getText(EntryEvent event) {
        return '''Entry at «ETimestampFormat.eINSTANCE.format(event.timestamp)»'''
    }
    
    dispatch def String getText(ExitEvent event) {
        return '''Exit at «ETimestampFormat.eINSTANCE.format(event.timestamp)»'''
    }

    dispatch def String getText(MessageControl messageControl) {
        return '''Control «messageControl.message?.text.toFirstLower»'''
    }
    
    private dispatch def String getReference(EntryEvent event) {
        return '''entry of «event.function?.text» on «event.lifeline.text»'''
    }
    
    private dispatch def String getReference(ExitEvent event) {
        return '''exit of «event.function?.text» on «event.lifeline.text»'''
    }
    
    dispatch def String getText(Dependency dependency) {
        return '''«dependency.eClass.text» from «dependency.source?.reference» to «dependency.target?.reference»'''
    }

    dispatch def String getText(LifelineSegment lifelineSegment) {
        return lifelineSegment.activeExecution?.text ?: 'Idle'
    }
    
    dispatch def String getText(Execution execution) {
        return execution.function?.text
    }

    dispatch def String getText(Interval interval) {
        return interval.name
    }
}
