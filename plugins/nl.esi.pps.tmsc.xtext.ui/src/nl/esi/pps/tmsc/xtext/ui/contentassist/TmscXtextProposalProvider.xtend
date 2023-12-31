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
 * generated by Xtext 2.22.0
 */
package nl.esi.pps.tmsc.xtext.ui.contentassist

import com.google.inject.Inject
import java.util.EnumSet
import nl.esi.pps.common.jfreechart.rendering.RenderingPaint
import nl.esi.pps.common.jfreechart.rendering.RenderingStroke
import nl.esi.pps.tmsc.metric.PropertiesMetricProcessor
import nl.esi.pps.tmsc.rendering.RenderingDependencies
import nl.esi.pps.tmsc.rendering.RenderingExecutions
import nl.esi.pps.tmsc.rendering.RenderingProperties
import nl.esi.pps.tmsc.viewers.plot.RenderingStrategyRegistryReader
import nl.esi.pps.tmsc.xtext.services.TmscXtextGrammarAccess
import nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextModel
import nl.esi.pps.tmsc.xtext.tmscXtext.XDependency
import nl.esi.pps.tmsc.xtext.tmscXtext.XDependencyType
import nl.esi.pps.tmsc.xtext.tmscXtext.XEvent
import nl.esi.pps.tmsc.xtext.tmscXtext.XEventType
import nl.esi.pps.tmsc.xtext.tmscXtext.XFunctionParameter
import nl.esi.pps.tmsc.xtext.tmscXtext.XFunctionParameterKind
import nl.esi.pps.tmsc.xtext.tmscXtext.XProperty
import nl.esi.pps.tmsc.xtext.tmscXtext.XPropertyStringValue
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.conversion.IValueConverterService
import org.eclipse.xtext.ui.IImageHelper
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor

import static extension nl.esi.pps.tmsc.xtext.TmscXtextQueries.*
import static extension org.eclipse.emf.ecore.util.EcoreUtil.*
import static extension org.eclipse.xtext.EcoreUtil2.*

/**
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#content-assist
 * on how to customize the content assistant.
 */
class TmscXtextProposalProvider extends AbstractTmscXtextProposalProvider {
    @Inject
    var IImageHelper imageHelper;

    @Inject
    @Extension
    var TmscXtextGrammarAccess tmscXtextGrammarAccess;
    
    @Inject
    @Extension
    var IValueConverterService valueConverterService;
    

    override completeXEvent_IncomingDependencies(EObject model, Assignment assignment, ContentAssistContext context,
        ICompletionProposalAcceptor acceptor) {
        val xDependencies = model.getContainerOfType(TmscXtextModel).events.flatMap[outgoingDependencies]
        for (xDependency : xDependencies) {
            acceptor.accept(
                createCompletionProposal(xDependency.name, '''«xDependency.type»: «xDependency.name»''',
                    xDependency.image, context))

        }
    }
       
    override completeXDependency_Name(EObject model, Assignment assignment, ContentAssistContext context,
        ICompletionProposalAcceptor acceptor) {
        val defaults = model.getContainerOfType(TmscXtextModel).dependencySettings.reject[prefix === null]
        for (dependencyDefaults : defaults) {
            acceptor.accept(
                createCompletionProposal(
                    dependencyDefaults.prefix, '''«dependencyDefaults.type»: «dependencyDefaults.prefix»''', null,
                    context))
        }
    }

    override completeXDependency_Request(EObject model, Assignment assignment, ContentAssistContext context,
        ICompletionProposalAcceptor acceptor) {
        lookupCrossReference(assignment.terminal as CrossReference, context, acceptor) [
            (EObjectOrProxy as XDependency).type == XDependencyType::REQUEST
        ]
    }
    
    override completeXDependency_Message(EObject model, Assignment assignment, ContentAssistContext context,
        ICompletionProposalAcceptor acceptor) {
        lookupCrossReference(assignment.terminal as CrossReference, context, acceptor) [
            return switch ((EObjectOrProxy as XDependency).type) {
                case MESSAGE,
                case REQUEST,
                case REPLY: true
                default: false
            }
        ]
    }
    
    override completeXProperty_Name(EObject model, Assignment assignment, ContentAssistContext context,
        ICompletionProposalAcceptor acceptor) {
        super.completeXProperty_Name(model, assignment, context, acceptor)
        // All properties as defined in this file
        val propertyNames = model.rootContainer.eAllContents.filter(XProperty).map[name].toSet
        // Add well-known properties
        propertyNames += RenderingProperties::PROPERTY_RENDERING_STRATEGY_ID
        propertyNames += RenderingProperties::PROPERTY_RENDERING_DEPENDENCIES
        propertyNames += RenderingProperties::PROPERTY_RENDERING_EXECUTIONS
        propertyNames += RenderingProperties::PROPERTY_HIDDEN
        propertyNames += RenderingProperties::PROPERTY_PAINT
        propertyNames += RenderingProperties::PROPERTY_STROKE
        propertyNames += PropertiesMetricProcessor::PROPERTY_METRIC_BUDGET
        propertyNames += PropertiesMetricProcessor::PROPERTY_METRIC_INSTANCE_FROM_ID
        propertyNames += PropertiesMetricProcessor::PROPERTY_METRIC_INSTANCE_TO_ID
        propertyNames += PropertiesMetricProcessor::PROPERTY_METRIC_ACTIVITY_CUT_OFF
        for (propertyName : propertyNames) {
            acceptor.accept(createCompletionProposal(propertyName, propertyName, null, context))
        }
    }

    override completeXPropertyValue_Value(EObject model, Assignment assignment, ContentAssistContext context,
        ICompletionProposalAcceptor acceptor) {
        super.completeXPropertyValue_Value(model, assignment, context, acceptor)
        if (assignment.terminal == tmscXtextGrammarAccess.XPropertyValueAccess.valueIDStringParserRuleCall_0_1_0) {
            switch propertyName: (model as XProperty).name {
            	case RenderingProperties::PROPERTY_RENDERING_STRATEGY_ID: {
            		for(renderingStrategy : RenderingStrategyRegistryReader::renderingStrategyConfigurations) {
            		    val imageDescriptor = RenderingStrategyRegistryReader.getIcon(renderingStrategy)
            		    val image = imageDescriptor.present ? imageHelper.getImage(imageDescriptor.get) : null
                        acceptor.accept(
                            createCompletionProposal(
                                RenderingStrategyRegistryReader::getID(renderingStrategy).toIDStringProposal,
                                RenderingStrategyRegistryReader.getName(renderingStrategy), image, context))
            		}
            	}
                case RenderingProperties::PROPERTY_RENDERING_DEPENDENCIES: {
                    for (rendering : RenderingDependencies.values) {
                        acceptor.accept(createCompletionProposal(rendering.name.toIDStringProposal, rendering.name, null, context))
                    }
                }
                case RenderingProperties::PROPERTY_RENDERING_EXECUTIONS: {
                    for (rendering : RenderingExecutions.values) {
                        acceptor.accept(createCompletionProposal(rendering.name.toIDStringProposal, rendering.name, null, context))
                    }
                }
                case RenderingProperties::PROPERTY_STROKE: {
                    for (stroke : RenderingStroke.values) {
                        acceptor.accept(createCompletionProposal(stroke.name.toIDStringProposal, stroke.name, null, context))
                    }
                }
            	default: {
                    val properties = model.rootContainer.eAllContents.filter(XProperty).filter[name == propertyName]
                    val propertyValues = properties.map[value].filter(XPropertyStringValue).map[value].toSet
                    if (RenderingProperties::PROPERTY_PAINT.equals(propertyName)) {
                        propertyValues += RenderingPaint.values.map[name]
                    }
                    for (propertyValue : propertyValues) {
                        acceptor.accept(createCompletionProposal(propertyValue.toIDStringProposal, propertyValue, null, context))
                    }
            	}
            }
        }
    }
    
    override completeXEventArgument_Parameter(EObject model, Assignment assignment, ContentAssistContext context,
        ICompletionProposalAcceptor acceptor) {
        val xEvent = EcoreUtil2::getContainerOfType(model, XEvent)
        val parameterKinds = xEvent.type == XEventType::ENTRY
                ? EnumSet::of(XFunctionParameterKind::IN, XFunctionParameterKind::IN_OUT)
                : EnumSet::of(XFunctionParameterKind::IN_OUT, XFunctionParameterKind::OUT, XFunctionParameterKind::RETURN)
        lookupCrossReference(assignment.terminal as CrossReference, context, acceptor) [
            parameterKinds.contains((EObjectOrProxy as XFunctionParameter).kind)
        ]
    }
    
    override complete_EBOOLEAN_OBJECT(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        acceptor.accept(createCompletionProposal('false', 'false', null, context))
        acceptor.accept(createCompletionProposal('true', 'true', null, context))
    }
    
    def private String toIDStringProposal(String value) {
        return valueConverterService.toString(value, 'IDString')
    }
}
