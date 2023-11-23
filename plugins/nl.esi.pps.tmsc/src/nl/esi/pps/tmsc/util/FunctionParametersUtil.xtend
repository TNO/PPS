/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.util

import nl.esi.pps.architecture.implemented.Function
import nl.esi.pps.architecture.implemented.FunctionParameter
import nl.esi.pps.architecture.implemented.FunctionParameterKind
import nl.esi.pps.architecture.implemented.ImplementedFactory
import nl.esi.pps.tmsc.EntryEvent
import nl.esi.pps.tmsc.Event
import nl.esi.pps.tmsc.ExitEvent

class FunctionParametersUtil {
    static extension val ImplementedFactory m_impl = ImplementedFactory::eINSTANCE
    
    private new() {
        // Empty for utility classes
    }

    static def String getReturnValue(ExitEvent event) {
        return event.getArgument(null as String)
    }

    static def String getArgument(Event event, String parameterName) {
        val parameter = event.function.getParameter(parameterName)
        if (parameter === null) {
            return null
        }
        return event.getArgument(parameter)
    }

    static def String getArgument(Event event, FunctionParameter parameter) {
        return event.arguments.get(parameter)
    }

    static def void setReturnValue(ExitEvent event, String value) {
        event.setArgument(null as String, value)
    }
    
    static def void setArgument(Event event, String parameterName, String value) {
        var parameter = event.function.getParameter(parameterName)
        val parameterKind = switch (event) {
            ExitEvent: {
                if (parameterName === null) {
                    if (parameter !== null && parameter.kind != FunctionParameterKind::RETURN) {
                        throw new IllegalArgumentException('''Expected return parameter when name is not set, but was «parameter.kind»''')
                    }
                    FunctionParameterKind::RETURN
                } else if (parameter !== null && parameter.kind != FunctionParameterKind::OUT) {
                    FunctionParameterKind::IN_OUT
                } else {
                    FunctionParameterKind::OUT
                }
            }
            EntryEvent: {
                if (parameter !== null && parameter.kind != FunctionParameterKind::IN) {
                    FunctionParameterKind::IN_OUT
                } else {
                    FunctionParameterKind::IN
                }
            }
        }

        if (parameter === null) {
            parameter = event.function.getParameter(parameterName, parameterKind)
        } else {
            parameter.kind = parameterKind
        }

        event.setArgument(parameter, value)
    }

    static def void setArgument(Event event, FunctionParameter parameter, String value) {
        if (value === null) {
            event.arguments.removeKey(parameter)
        } else {
            event.arguments.put(parameter, value)
        }
    }

    def static FunctionParameter getParameter(Function function, String parameterName) {
        return getParameter(function, parameterName, null)
    }

    def static FunctionParameter getParameter(Function function, String parameterName,
        FunctionParameterKind parameterKind) {
        val parameter = function.parameters.findFirst[name == parameterName]
        if (parameter !== null) {
            if (parameterKind !== null && parameter.kind != parameterKind) {
                throw new IllegalArgumentException('''Expected parameter kind «parameter.kind», but was «parameterKind» for function parameter «function.name»(«parameterName»)''')
            }
            return parameter
        } else if (parameterKind !== null) {
            val newParameter = createFunctionParameter => [
                name = parameterName
                kind = parameterKind
            ]
            function.parameters += newParameter
            return newParameter
        } else {
            return null
        }
    }
}
