/*
 * Copyright (c) 2018-2026 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */

package nl.esi.pps.tmsc.reconstruct;

import static org.eclipse.lsat.common.emf.ecore.resource.ResourceDiagnosticException.UNKNOWN_COLUMN;

import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.lsat.common.emf.ecore.resource.ResourceDiagnosticException;
import org.eclipse.lsat.common.emf.ecore.resource.ResourceDiagnosticException.Severity;

import nl.esi.pps.common.emf.ecore.resource.LineNumberResource;

public class TmscTraceResource extends LineNumberResource<TmscTraceReconstructor> { // <1>
	public TmscTraceResource() {
        super();
    }

    public TmscTraceResource(URI uri) {
        super(uri);
    }

    @Override
	protected TmscTraceReconstructor createLoadState(Map<?, ?> options) throws IOException {
    	TmscTraceReconstructor reconstructor = new TmscTraceReconstructor(); // <2>
    	reconstructor.preReconstruct();
    	return reconstructor;
	}
    
    @Override
	protected void doLoadLine(String line, int lineNr, TmscTraceReconstructor reconstructor)
			throws IOException, ResourceDiagnosticException {
        try {
			TmscTraceEvent traceEvent = TmscTraceEventImpl.parse(line); // <3>
			reconstructor.reconstruct(traceEvent);
		} catch (ParseException e) {
			throw new ResourceDiagnosticException(Severity.ERROR, uri, e.getErrorOffset(), lineNr, e.getMessage(), e);
		} catch (RuntimeException e) {
			throw new ResourceDiagnosticException(Severity.ERROR, uri, UNKNOWN_COLUMN, lineNr, e.getMessage(), e);
		}
	}
    
    @Override
	protected void disposeLoadState(TmscTraceReconstructor reconstructor) {
        reconstructor.postReconstruct(); // <4>

        getContents().add(reconstructor.getTmsc());
        getContents().add(reconstructor.getArchitecture());
        if (reconstructor.hasMetrics()) {
            getContents().add(reconstructor.getMetrics());
        }
	}
}
