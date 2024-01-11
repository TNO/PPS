/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.provider.dataanalysis

import java.util.Collections
import nl.esi.pps.tmsc.Message
import nl.esi.pps.tmsc.util.TmscQueries

import static extension nl.esi.pps.tmsc.util.TmscQueries.*

/** 
 * {@link Message} supports data analysis by providing this {@link IDataAnalysisItemContentProvider}.
 */
class MessageDataAnalysisItemContentProvider implements IDataAnalysisItemContentProvider {
    override getConfigurations(Object object) {
        val message = object as Message
        // Disable data analysis for messages on same life-line
        return if (message.source.lifeline != message.target.lifeline) Collections::singleton(DEFAULT_CONFIGURATION)
    }
    
    override getTitle(Object object, String configuration) {
        val message = object as Message
        return '''«message.eClass.name» between «message.source.lifeline.executor.name» and «message.target.lifeline.executor.name»'''
    }
    
    override getSiblings(Object object, String configuration) {
        return TmscQueries::findAllOfTypeBetweenLifelines(object as Message)
    }
    
    override getDuration(Object object, Object sibling, String configuration) {
        val message = sibling as Message
        return if (message.isFullyTraced) message.duration
    }
}
