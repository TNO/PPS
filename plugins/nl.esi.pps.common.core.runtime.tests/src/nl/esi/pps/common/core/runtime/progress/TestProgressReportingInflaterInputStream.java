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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

public class TestProgressReportingInflaterInputStream extends ATestProgressReportingReader {
	@Test
	public void zipped() throws Exception {
		final TestProgressMonitor monitor = new TestProgressMonitor();

		final ByteArrayOutputStream tmpOutput = new ByteArrayOutputStream();
		final GZIPOutputStream gzipOutput = new GZIPOutputStream(tmpOutput);
		IOUtils.copy(new RandomLinesInputStream(10000, 9), gzipOutput);
		gzipOutput.finish();

		try (final ProgressReportingInputStream in = new ProgressReportingInflaterInputStream(
				new GZIPInputStream(new ByteArrayInputStream(tmpOutput.toByteArray())), 100_000, monitor)) {

			in.setUpdateInterval(1);

			assertFalse(monitor.hasStarted());

			final byte[] line = new byte[10];

			in.read(line);
			assertEquals(0.0001d, monitor.getRatio(), ASSERT_PRECISION);

			readLinesBytes(in, 1337);
			assertEquals(0.1338d, monitor.getRatio(), ASSERT_PRECISION);

			readLinesBytes(in, 4000);
			assertEquals(0.5338d, monitor.getRatio(), ASSERT_PRECISION);

			readLinesBytes(in, 4000);
			assertEquals(0.9338d, monitor.getRatio(), ASSERT_PRECISION);
		}
	}

}
