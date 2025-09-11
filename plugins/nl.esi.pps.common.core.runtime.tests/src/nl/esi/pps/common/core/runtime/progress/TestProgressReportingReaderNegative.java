/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.core.runtime.progress;

import java.nio.charset.Charset;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.Test;

public class TestProgressReportingReaderNegative {
	@Test(expected = RuntimeException.class)
	public void nullProgressMessage() throws Exception {
		try (
				final ProgressReportingInputStream in = new ProgressReportingInputStream(
						new LinesInputStream(10000, "123456789"), 100000, new NullProgressMonitor());
				final ProgressReportingReader reader = new ProgressReportingReader(
						in, Charset.defaultCharset())) {
			reader.setProgressMessage(null);
		}
	}
}
