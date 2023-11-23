/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
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

package nl.esi.pps.tmsc.xtext

import java.util.List
import nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage
import nl.esi.pps.tmsc.xtext.tmscXtext.XComponent
import nl.esi.pps.tmsc.xtext.tmscXtext.XFunction
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.parsetree.reconstr.impl.DefaultTransientValueService

class TmscXtextTransientValueService extends DefaultTransientValueService {
    
    override isCheckElementsIndividually(EObject owner, EStructuralFeature feature) {
        return switch (feature) {
        	case TmscXtextPackage.Literals.TMSC_XTEXT_MODEL__COMPONENTS,
        	case TmscXtextPackage.Literals.TMSC_XTEXT_MODEL__FUNCTIONS: {
        		true
        	}
        	default: {
        		super.isCheckElementsIndividually(owner, feature)
        	}
        }
    }
    
    override isTransient(EObject owner, EStructuralFeature feature, int index) {
        // Elements without a description are not explicitly declared
        return switch (feature) {
            case TmscXtextPackage.Literals.TMSC_XTEXT_MODEL__COMPONENTS: {
                (getElement(owner, feature, index) as XComponent).description === null
            }
            case TmscXtextPackage.Literals.TMSC_XTEXT_MODEL__FUNCTIONS: {
                (getElement(owner, feature, index) as XFunction).description === null
            }
            default: {
                super.isTransient(owner, feature, index)
            }
        }
    }
    
    static private def Object getElement(EObject owner, EStructuralFeature feature, int index) {
        val value = owner.eGet(feature)
        return value instanceof List<?> ? value.get(index) : value
    }
}