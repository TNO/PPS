/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.reconstruct;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

public class TmscTraceResource extends ResourceImpl { // <1>
	public TmscTraceResource() {
		super();
	}

	public TmscTraceResource(URI uri) {
		super(uri);
	}

	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		TmscTraceReconstructor reconstructor = new TmscTraceReconstructor(); // <2>
		reconstructor.preReconstruct();

		try (LineNumberReader reader = new LineNumberReader(new InputStreamReader(inputStream))) {
			try {
				String line;
				while ((line = reader.readLine()) != null) {
					TmscTraceEvent traceEvent = TmscTraceParser.parseLine(line); // <3>
					reconstructor.reconstruct(traceEvent);
				}
			} catch (RuntimeException e) {
				throw new IOException("Failed to parse trace at line " + reader.getLineNumber(), e);
			}
		}

		reconstructor.postReconstruct(); // <4>
		getContents().add(reconstructor.getTmsc());
		getContents().add(reconstructor.getArchitecture());
	}
}
