/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.analysis

import nl.esi.pps.architecture.implemented.IPCFunction
import nl.esi.pps.common.core.runtime.StatusLogger
import nl.esi.pps.tmsc.Dependency
import nl.esi.pps.tmsc.Event
import nl.esi.pps.tmsc.ScopedTMSC
import nl.esi.pps.tmsc.TMSC
import nl.esi.pps.tmsc.util.TmscProjection
import org.eclipse.core.runtime.IProgressMonitor

import static extension nl.esi.pps.tmsc.util.TmscQueries.*

/**
 * Finds all {@link Dependency dependencies} between {@link Event events} with
 * an {@link IPCFunction} and puts them in a {@link ScopedTMSC}.
 */
final class CreateIPCScope {
    extension val StatusLogger logger = new StatusLogger('nl.esi.pps.tmsc.analysis', 'Create IPC Scope')
    
    def getStatus() {
        return logger.status
    }

    def createIPCScope(TMSC tmsc, IProgressMonitor monitor) {
        val ipcDependencies = tmsc.dependencies.filter[isIPCScope]
        val ipcEvents = ipcDependencies.flatMap[events].toSet
        val ipcScope = ipcDependencies.createScopedTMSC('IPC')

        val nonIPCDependencies = tmsc.dependencies.reject[isIPCScope]
        val dependenciesToProject = if (tmsc.dependencies.size > 100_000) {
            // FIXME: For now we choose to only project the activity (and unset) dependencies because of scalability issues.
            // This limits the analyses that can be performed on the resulting model to structural analyses only (e.g.
            // critical path and slack analysis cannot be performed!)
            warn('The input is too large to perform a full projection, skipping scheduled dependencies.')
            info('The output should only be used for structural comparison.')
            nonIPCDependencies.reject[scheduled == Boolean.TRUE]
        } else {
            nonIPCDependencies
        }
        
        val tmscProjection = new TmscProjection(ipcScope)
        tmscProjection.projectToScope(dependenciesToProject, monitor)[e | ipcEvents.contains(e)]

        return ipcScope
    }
    
    private static def isIPCScope(Dependency dependency) {
        return if (!dependency.source.traced) {
            dependency.target.function instanceof IPCFunction
        } else if (dependency.source.function instanceof IPCFunction) {
            !dependency.target.traced || dependency.target.function instanceof IPCFunction
        } else {
            false
        }
    }
}