/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.xtext.generator

import java.io.Serializable
import java.math.BigDecimal
import java.util.ArrayList
import java.util.List
import nl.esi.emf.properties.PropertiesContainer
import nl.esi.pps.architecture.NamedArchitectureElement
import nl.esi.pps.architecture.example.ExampleFactory
import nl.esi.pps.architecture.example.ExampleHost
import nl.esi.pps.architecture.implemented.Function
import nl.esi.pps.architecture.implemented.FunctionParameter
import nl.esi.pps.architecture.implemented.FunctionParameterKind
import nl.esi.pps.architecture.implemented.ImplementedFactory
import nl.esi.pps.architecture.instantiated.Executor
import nl.esi.pps.architecture.instantiated.InstantiatedFactory
import nl.esi.pps.architecture.specified.Component
import nl.esi.pps.architecture.specified.Interface
import nl.esi.pps.architecture.specified.Operation
import nl.esi.pps.architecture.specified.SpecifiedFactory
import nl.esi.pps.tmsc.Dependency
import nl.esi.pps.tmsc.EntryEvent
import nl.esi.pps.tmsc.Event
import nl.esi.pps.tmsc.Execution
import nl.esi.pps.tmsc.FullScopeTMSC
import nl.esi.pps.tmsc.Lifeline
import nl.esi.pps.tmsc.LifelineSegment
import nl.esi.pps.tmsc.Message
import nl.esi.pps.tmsc.Request
import nl.esi.pps.tmsc.TmscFactory
import nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextModel
import nl.esi.pps.tmsc.xtext.tmscXtext.XComponent
import nl.esi.pps.tmsc.xtext.tmscXtext.XDependency
import nl.esi.pps.tmsc.xtext.tmscXtext.XDependencyType
import nl.esi.pps.tmsc.xtext.tmscXtext.XEvent
import nl.esi.pps.tmsc.xtext.tmscXtext.XEventType
import nl.esi.pps.tmsc.xtext.tmscXtext.XExecutor
import nl.esi.pps.tmsc.xtext.tmscXtext.XFunction
import nl.esi.pps.tmsc.xtext.tmscXtext.XFunctionParameter
import nl.esi.pps.tmsc.xtext.tmscXtext.XHost
import nl.esi.pps.tmsc.xtext.tmscXtext.XInterface
import nl.esi.pps.tmsc.xtext.tmscXtext.XNamedArchitectureElement
import nl.esi.pps.tmsc.xtext.tmscXtext.XOperation
import nl.esi.pps.tmsc.xtext.tmscXtext.XProperty
import nl.esi.pps.tmsc.xtext.tmscXtext.XPropertyBooleanValue
import nl.esi.pps.tmsc.xtext.tmscXtext.XPropertyMutliValue
import nl.esi.pps.tmsc.xtext.tmscXtext.XPropertyNumberValue
import nl.esi.pps.tmsc.xtext.tmscXtext.XPropertyStringValue
import org.eclipse.lsat.common.xtend.annotations.Resolvable
import org.eclipse.lsat.common.xtend.annotations.Transform

import static extension nl.esi.pps.tmsc.sort.TmscTopologicalOrder.*
import static extension nl.esi.pps.tmsc.util.TmscRefinements.*
import static extension nl.esi.pps.tmsc.xtext.TmscXtextQueries.*
import static extension org.eclipse.lsat.common.xtend.Queries.*
import static extension org.eclipse.xtext.EcoreUtil2.*

class TmscXtextToTmscTransformation {
    static extension val TmscFactory m_tmsc = TmscFactory.eINSTANCE
    static extension val SpecifiedFactory m_arch_spec = SpecifiedFactory.eINSTANCE
    static extension val ImplementedFactory m_arch_impl = ImplementedFactory.eINSTANCE
    static extension val InstantiatedFactory m_arch_inst = InstantiatedFactory.eINSTANCE
    static extension val ExampleFactory m_arch_example = ExampleFactory.eINSTANCE

    @Transform
    def FullScopeTMSC transform(TmscXtextModel tmscXtext) {
        val architecture = createExampleArchitecture => [
            interfaces += tmscXtext.interfaces.map[xInterface2Interface]
            components += tmscXtext.components.map[xComponent2Component]
            functions += tmscXtext.functions.map[xFunction2Function]
            hosts += tmscXtext.hosts.map[xHost2Host]
            executors += tmscXtext.executors.map[xExecutor2Executor]
        ]
        val tmsc = tmscXtext.tmscXtextModel2FullScopeTMSC
        tmsc.architectures += architecture
        // The use of components is optional in the syntax. If a component is not set, it is assumed that the executor
        // also acts as a component, hence a Component is created for the executor. We should harvest these created
        // components of course.
        architecture.components += tmsc.events.map[component]
        return tmsc
    }
    
    @Resolvable
    private def FullScopeTMSC create createFullScopeTMSC tmscXtextModel2FullScopeTMSC(TmscXtextModel tmscXtext) {
        lifelines += tmscXtext.hosts.flatMap[executors].union(tmscXtext.executors).map[xExecutor2Lifeline]
        dependencies += events.flatMap[fullScopeIncomingDependencies + fullScopeOutgoingDependencies]
        
        // refineWithCompleteOrder may add LifelineSegments for which we also want to apply the dependency defaults,
        // but refineWithCallStacks may also add LifelineSegments for which we do NOT want to apply defaults,
        // yet applying defaults depends on the existence of Executions. For this reason we save the 
        // specifiedDependencies after refineWithCompleteOrder, but we add the defaults after refineWithCallStacks
        refineWithCompleteOrder
        val specifiedDependencies = new ArrayList(dependencies)
        refineWithCallStacks
        // Dependencies and executions are now complete, so add defaults, only for the specified ones.
        specifiedDependencies.forEach[addDependencyDefaults]
        // Executions are now complete, so add defaults
        lifelines.flatMap[executions].forEach[addExecutionDefaults]
        
        // Now that all time-bounds are set we can calculate the event time-stamps, 
        // only if time-stamp is omitted in trace and if the event was defined in the trace
        // For the events that were not defined in the trace, we consider them to be outside the trace window.
        // As such, their time-stamps should be set to either the start or end of the trace, see below.
        eventsInTopologicalOrder.filter[timestamp === null].reject[invResolveOne(XEvent) === null].forEach[
            timestamp = fullScopeIncomingDependencies.reject[source?.timestamp === null]
                .map[source.timestamp + (timeBound ?: 0L)].max(0L)
        ]

        // Now that the time-stamps are calculated we can derive the start and end time of the TMSC from its events
        val timestamps = events.map[timestamp].filterNull.toList
        if (!timestamps.isEmpty) {
            startTime = timestamps.min
            endTime = timestamps.max
        }
        
        // For the events that were not defined in the trace, we consider them to be outside the trace window.
        // As such, their time-stamps should be set to either the start or end of the trace.
        events.filter[timestamp === null].forEach [ e |
            e.timestamp = e instanceof EntryEvent ? startTime : endTime
        ]

        addPropertiesIfAbsent(tmscXtext.properties)
    }

    @Resolvable
    private def Interface create createInterface xInterface2Interface(XInterface xInterface) {
        handleXNamedArchitectureElement(xInterface)
        operations += xInterface.operations.map[xOperation2Operation]
    }

    @Resolvable
    private def Operation create createOperation xOperation2Operation(XOperation xOperation) {
        handleXNamedArchitectureElement(xOperation)
    }

    @Resolvable
    private def Component create createComponent xComponent2Component(XComponent xComponent) {
        handleXNamedArchitectureElement(xComponent)
        providedInterfaces += xComponent.provides.map[resolveOne(Interface)]
        requiredInterfaces += xComponent.requires.map[resolveOne(Interface)]
    }

    @Resolvable
    private def Function create createFunction(xFunction) xFunction2Function(XFunction xFunction) {
        handleXNamedArchitectureElement(xFunction)
        parameters += xFunction.parameters.map[xFunctionParameter2FunctionParameter]
        operation = xFunction.operation?.resolveOne(Operation)
    }
    
    private def Function createFunction(XFunction xFunction) {
        switch (xFunction) {
        	case xFunction.ipcClient: createIPCClientFunction
            case xFunction.ipcServer: createIPCServerFunction
        	default: createFunction
        }
    }

    @Resolvable
    private def FunctionParameter create createFunctionParameter xFunctionParameter2FunctionParameter(
        XFunctionParameter xFunctionParameter) {
        name = xFunctionParameter.name
        kind = switch (xFunctionParameter.kind) {
            case IN: FunctionParameterKind::IN
            case OUT: FunctionParameterKind::OUT
            case IN_OUT: FunctionParameterKind::IN_OUT
            case RETURN: FunctionParameterKind::RETURN
        }
        addPropertiesIfAbsent(xFunctionParameter.properties)
    }

    private def ExampleHost create createExampleHost xHost2Host(XHost xHost) {
        handleXNamedArchitectureElement(xHost)
        executors += xHost.executors.map[xExecutor2Executor]
    }

    @Resolvable
    private def Executor create createExecutor xExecutor2Executor(XExecutor xExecutor) {
        handleXNamedArchitectureElement(xExecutor)
    }
    
    private def handleXNamedArchitectureElement(NamedArchitectureElement element, XNamedArchitectureElement xElement) {
        if (xElement.description === null) {
            element.name = xElement.name
        } else {
            element.name = xElement.description
            element.xtextName = xElement.name
        }
        element.addPropertiesIfAbsent(xElement.properties)
    }

    @Resolvable
    private def Lifeline create createLifeline xExecutor2Lifeline(XExecutor xExecutor) {
        executor = xExecutor.resolveOne(Executor)
        events += xExecutor.getContainerOfType(TmscXtextModel).events.filter[executor == xExecutor].map[xEvent2Event]
        if (xExecutor.isUntraced) {
            events.forEach[traced = false]
        }
        addPropertiesIfAbsent(xExecutor.properties)
    }
    
    @Resolvable
    private def Event create createEvent(xEvent.type) xEvent2Event(XEvent xEvent) {
        timestamp = xEvent.timestamp.toNanos
        lifeline = xEvent.executor.resolveOne(Lifeline)
        // Components are optional in the syntax, the executor is the default component
        component = xEvent.component?.resolveOne(Component) ?: xEvent.executor.xExecutor2Component
        function = xEvent.function.resolveOne(Function)
        fullScopeOutgoingDependencies += xEvent.outgoingDependencies.map[xDependency2Dependency]
        fullScopeIncomingDependencies += xEvent.incomingDependencies.map[xDependency2Dependency]
        xEvent.arguments.forEach[arg |
            arguments.put(arg.parameter.resolveOne(FunctionParameter), arg.value)
        ]
        addPropertiesIfAbsent(xEvent.properties)
    }
    
    private def Event createEvent(XEventType type) {
        return switch (type) {
        	case ENTRY: createEntryEvent
        	case EXIT: createExitEvent
        }
    }
    
    private def Component create createComponent xExecutor2Component(XExecutor xExecutor) {
        name = xExecutor.description ?: xExecutor.name
    }
    
    @Resolvable
    private def Dependency create createDependency(xDependency) xDependency2Dependency(XDependency xDependency) {
        // Time-bound is unsettable, hence do not set null value 
        if (xDependency.timeBound !== null) {
            timeBound = xDependency.timeBound.toNanos
        }
        if (xDependency.scheduled !== null) {
            scheduled = xDependency.scheduled
        }
        // Properties
        xtextName = xDependency.name
        addPropertiesIfAbsent(xDependency.properties)
    }
    
    private def Dependency createDependency(XDependency xDependency) {
        return switch (xDependency.type) {
            case DOMAIN: {
                createDomainDependency
            }
        	case REQUEST: {
        		createRequest
        	}
        	case REPLY: {
        	    createReply => [
        	        late[request = xDependency.request.resolveOne(Request)]
        	    ]
        	}
            case LIFELINE_SEGMENT: {
                createLifelineSegment
            }
            case MESSAGE_CONTROL: {
                createMessageControl => [
                    late[message = xDependency.message.resolveOne(Message)]
                ]
            }
            default: {
                createMessage
            }
        }
    }
    
    private def void addDependencyDefaults(Dependency dependency) {
        if (dependency instanceof Execution) {
            throw new IllegalArgumentException('Execution is not expected for this method')
        }
        
        // Dependency may be automatically inferred either by refineWithCompleteOrder (i.e. type dependency) 
        val dependencyType = dependency.invResolveOne(XDependency)?.type ?: XDependencyType::LIFELINE_SEGMENT
        val dependencySettings = dependency.tmsc.invResolveOne(TmscXtextModel).dependencySettings.findFirst [
            type == dependencyType
        ]
        val tmscSettings = dependency.tmsc.invResolveOne(TmscXtextModel)
        
        // Setting default time-bound
        if (dependency.timeBound === null) {
            val timeBound = if (dependency instanceof LifelineSegment) {
                    // The time-bound can be set on (ordered by priority) the target event, 
                    // the function, the component, the executor, as dependency default or as tmsc default
                    dependency.target.invResolveOne(XEvent)?.timeBound
                        ?: dependency.activeExecution?.function?.invResolveOne(XFunction)?.timeBound
                        ?: dependency.activeExecution?.component?.invResolveOne(XComponent)?.timeBound
                        ?: dependency.source.lifeline.invResolveOne(XExecutor).timeBound
                        ?: dependency.source.lifeline.invResolveOne(XExecutor).getContainerOfType(XHost)?.timeBound
                        ?: dependencySettings?.timeBound
                        ?: tmscSettings.timeBound
            } else {
                dependencySettings?.timeBound ?: tmscSettings.timeBound
            }
            dependency.timeBound = timeBound.toNanos
        }

        // Setting default scheduled
        if (dependency.scheduled === null) {
            dependency.scheduled = if (dependency instanceof LifelineSegment) {
                    // The scheduled can be set on (ordered by priority) the target event, 
                    // the function, the component, the executor, as dependency default or as tmsc default
                    dependency.target.invResolveOne(XEvent)?.scheduled
                        ?: dependency.activeExecution?.function?.invResolveOne(XFunction)?.scheduled
                        ?: dependency.activeExecution?.component?.invResolveOne(XComponent)?.scheduled
                        ?: dependency.source.lifeline.invResolveOne(XExecutor).scheduled
                        ?: dependency.source.lifeline.invResolveOne(XExecutor).getContainerOfType(XHost)?.scheduled
                        ?: dependencySettings?.scheduled
                        ?: tmscSettings.scheduled
            } else {
                dependencySettings?.scheduled ?: tmscSettings.scheduled
            }
        }
        // Setting default properties
        dependency.addPropertiesIfAbsent(dependencySettings?.properties)
    }
    
    private def void addExecutionDefaults(Execution execution) {
        // Copy the properties from a function or component to all its executions
        execution.addPropertiesIfAbsent(execution.function?.invResolveOne(XFunction)?.properties)
        execution.addPropertiesIfAbsent(execution.component?.invResolveOne(XComponent)?.properties)
    }
    
    /** Only adds the {@code xProperties} that are not yet set to {@code container} */
    private def void addPropertiesIfAbsent(PropertiesContainer container, List<XProperty> xProperties) {
        if (xProperties === null) {
            return
        }
        for (xProperty : xProperties) {
            if (!container.properties.containsKey(xProperty.name)) {
                container.properties.put(xProperty.name, xProperty.value.value)
            }
        }
    }
    
    private dispatch def Serializable getValue(XPropertyBooleanValue propertyValue) {
        return propertyValue.value
    }
    
    private dispatch def Serializable getValue(XPropertyNumberValue propertyValue) {
        return propertyValue.value
    }
    
    private dispatch def Serializable getValue(XPropertyStringValue propertyValue) {
        return propertyValue.value
    }
    
    private dispatch def Serializable getValue(XPropertyMutliValue propertyValue) {
        val result = newArrayList
        result += propertyValue.values.map[value]
        return result
    }
    
    private static def Long toNanos(BigDecimal seconds) {
        return seconds === null ? null : seconds.movePointRight(9).longValueExact
    }
}
