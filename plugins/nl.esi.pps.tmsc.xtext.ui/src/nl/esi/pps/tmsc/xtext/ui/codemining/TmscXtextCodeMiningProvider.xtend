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

/*
 * Generated by Xtext, all rights reserved ESI (TNO)
 */
package nl.esi.pps.tmsc.xtext.ui.codemining

import nl.esi.pps.tmsc.rendering.RenderingProperties
import nl.esi.pps.tmsc.viewers.plot.RenderingStrategyRegistryReader
import nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage
import nl.esi.pps.tmsc.xtext.tmscXtext.XDependency
import nl.esi.pps.tmsc.xtext.tmscXtext.XEvent
import nl.esi.pps.tmsc.xtext.tmscXtext.XEventArgument
import nl.esi.pps.tmsc.xtext.tmscXtext.XProperty
import nl.esi.pps.tmsc.xtext.tmscXtext.XPropertyStringValue
import org.eclipse.emf.ecore.EObject
import org.eclipse.jface.text.BadLocationException
import org.eclipse.jface.text.IDocument
import org.eclipse.jface.text.codemining.ICodeMining
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ui.codemining.AbstractXtextCodeMiningProvider
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.IAcceptor

import static extension nl.esi.pps.tmsc.xtext.TmscXtextQueries.*

class TmscXtextCodeMiningProvider extends AbstractXtextCodeMiningProvider {
	override void createCodeMinings(IDocument document, XtextResource resource, CancelIndicator indicator,
            IAcceptor<? super ICodeMining> acceptor) throws BadLocationException {
        resource.allContents.forEach[createCodeMinings(acceptor)]
    }
    	
	dispatch def private void createCodeMinings(EObject eObject,
            IAcceptor<? super ICodeMining> acceptor) throws BadLocationException {
        // Nothing to do
    }


    dispatch def private void createCodeMinings(XProperty xProperty,
            IAcceptor<? super ICodeMining> acceptor) throws BadLocationException {
        if (xProperty.name == RenderingProperties::PROPERTY_RENDERING_STRATEGY_ID) {
            val xPropertyValue = xProperty.value
            
            if (xPropertyValue instanceof XPropertyStringValue) {
                val renderingStrategyConfiguration = RenderingStrategyRegistryReader::renderingStrategyConfigurations
                    .findFirst[RenderingStrategyRegistryReader::getID(it) == xPropertyValue.value]
                val renderingStrategyName = (renderingStrategyConfiguration === null) ? 
                    '!! Unknown !!' : 
                    RenderingStrategyRegistryReader::getName(renderingStrategyConfiguration)
                val annotationOffset = NodeModelUtils::findActualNodeFor(xPropertyValue).totalOffset
                acceptor.accept(createNewLineContentCodeMining(annotationOffset, ''' «renderingStrategyName»:'''))
            }
        }
    }

    dispatch def private void createCodeMinings(XDependency xDependency,
            IAcceptor<? super ICodeMining> acceptor) throws BadLocationException {
        if (xDependency.typeObject === null) {
            val annotationOffset = NodeModelUtils::findActualNodeFor(xDependency).totalOffset
            acceptor.accept(createNewLineContentCodeMining(annotationOffset, '''«xDependency.type» '''))
        }
    }

    dispatch def private void createCodeMinings(XEvent xEvent,
            IAcceptor<? super ICodeMining> acceptor) throws BadLocationException {
        val dependencies = xEvent.incomingDependencies
        val dependencyNodes = NodeModelUtils.findNodesForFeature(xEvent, TmscXtextPackage.Literals.XEVENT__INCOMING_DEPENDENCIES)
        for (var i = 0; i < dependencies.size && i < dependencyNodes.size; i++) {
            val dependencyType = dependencies.get(i).type
        	val annotationOffset = dependencyNodes.get(i).totalOffset
            acceptor.accept(createNewLineContentCodeMining(annotationOffset, '''«dependencyType» '''))
        }
    }

    dispatch def private void createCodeMinings(XEventArgument xEventArgument,
            IAcceptor<? super ICodeMining> acceptor) throws BadLocationException {
        if (xEventArgument.parameter !== null) {
            val annotationOffset = NodeModelUtils::findActualNodeFor(xEventArgument).totalOffset
            acceptor.accept(createNewLineContentCodeMining(annotationOffset, '''«xEventArgument.parameter.kind.literal» '''))
        }
    }
}
