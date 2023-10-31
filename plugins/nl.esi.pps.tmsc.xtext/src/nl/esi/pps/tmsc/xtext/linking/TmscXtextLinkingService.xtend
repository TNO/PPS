/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.xtext.linking

import com.google.inject.Inject
import java.util.Collections
import nl.esi.pps.tmsc.xtext.services.TmscXtextGrammarAccess
import nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextFactory
import nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextModel
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.linking.impl.DefaultLinkingService
import org.eclipse.xtext.linking.impl.IllegalNodeException
import org.eclipse.xtext.nodemodel.INode

import static extension org.eclipse.xtext.EcoreUtil2.*

class TmscXtextLinkingService extends DefaultLinkingService {
    extension val TmscXtextFactory m_tmsc = TmscXtextFactory.eINSTANCE

    @Inject
    @Extension
    var TmscXtextGrammarAccess tmscXtextGrammarAccess;

    override getLinkedObjects(EObject context, EReference ref, INode node) throws IllegalNodeException {
        val result = super.getLinkedObjects(context, ref, node)
        if (!result.isEmpty) {
            return result
        }

        // Automatically infer executors, components, functions and messages
        switch (node.grammarElement) {
            case tmscXtextGrammarAccess.XEventAccess.executorXExecutorCrossReference_2_0: {
                val executor = createXExecutor => [
                    name = node.crossRefNodeAsString
                ]
                context.getContainerOfType(TmscXtextModel).executors += executor
                return Collections::singletonList(executor)
            }
            case tmscXtextGrammarAccess.XEventAccess.componentXComponentCrossReference_3_0: {
                val component = createXComponent => [
                    name = node.crossRefNodeAsString
                ]
                context.getContainerOfType(TmscXtextModel).components += component
                return Collections::singletonList(component)
            }
            case tmscXtextGrammarAccess.XEventAccess.functionXFunctionCrossReference_5_0: {
                val function = createXFunction => [
                    name = node.crossRefNodeAsString
                ]
                context.getContainerOfType(TmscXtextModel).functions += function
                return Collections::singletonList(function)
            }
            default: {
                return Collections::emptyList
            }
        }
    }
}
