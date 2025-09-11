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

package nl.esi.pps.tmsc.validation

import nl.esi.pps.common.emf.ecore.validation.EValidatorBase
import nl.esi.pps.common.emf.ecore.validation.ValidationReporter
import nl.esi.pps.tmsc.Event
import nl.esi.pps.tmsc.TMSC
import nl.esi.pps.tmsc.TmscPlugin
import nl.esi.pps.tmsc.text.EDurationFormat
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject

/**
 * An TMSC is urgent if and only if the timestamp of each event is as soon as possible, 
 * considering the source timestamp and time-bound of the events' incoming dependencies. 
 */
class UrgentTmscValidator extends EValidatorBase {
    new() {
        super(TmscPlugin::PLUGIN_ID)
    }
    
    override validate(EClass eClass, EObject eObject, ValidationReporter reporter) {
        if (eObject instanceof TMSC) {
            validateTMSC(eObject, reporter)
        }
    }

    def private void validateTMSC(TMSC tmsc, ValidationReporter reporter) {
        tmsc.events.forEach[validateEvent(tmsc, reporter)]
    }

    def private void validateEvent(Event event, extension TMSC tmsc, extension ValidationReporter reporter) {
        if (event.timestamp === null) {
            error('Event timestamp should be set to validate TMSC urgency', event)
            return
        }
        val incomingDependencies = event.incomingDependencies.toList
        if (incomingDependencies.isEmpty) {
            // An event without incoming dependencies is considered urgent by default
            return
        } else if (incomingDependencies.exists[source?.timestamp === null]) {
            // Prerequisite is not met, skip validation, other (model consistency) errors will be reported
            return
        }
        val urgentTime = incomingDependencies.map[source.timestamp + timeBound].max
        if (urgentTime < event.timestamp) {
            val delay = EDurationFormat.eINSTANCE.format(event.timestamp - urgentTime)
            error('''Event is not urgent as its timestamp is «delay» later than its urgent time''', event)
        }
    }
}
