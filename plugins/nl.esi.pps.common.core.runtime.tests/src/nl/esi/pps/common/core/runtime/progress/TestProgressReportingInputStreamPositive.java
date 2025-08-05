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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.eclipse.core.runtime.OperationCanceledException;
import org.junit.Test;

public class TestProgressReportingInputStreamPositive extends ATestProgressReportingReader {
	@Test
	public void regular() throws Exception {
		final TestProgressMonitor monitor = new TestProgressMonitor();
		try (final ProgressReportingInputStream in = new ProgressReportingInputStream(
				new LinesInputStream(10000, "123456789"), 100000, monitor)) {

			in.setUpdateInterval(1);

			assertFalse(monitor.hasStarted());

			final byte[] line = new byte[10];

			in.read(line);
			assertArrayEquals(BYTE_LINE, line);
			assertEquals(0.0001d, monitor.getRatio(), ASSERT_PRECISION);

			readLinesBytes(in, 1337);

			in.read(line);
			assertArrayEquals(BYTE_LINE, line);
			assertEquals(0.1339d, monitor.getRatio(), ASSERT_PRECISION);
		}
	}

	@Test
	public void unknownFileSize() throws Exception {
		final TestProgressMonitor monitor = new TestProgressMonitor();
		try (final ProgressReportingInputStream in = new ProgressReportingInputStream(
				new LinesInputStream(10000, "123456789"), IProgressReportingConstants.UNKNOWN_TOTAL_LENGTH, monitor)) {

			in.setUpdateInterval(1);

			assertFalse(monitor.hasStarted());

			final byte[] line = new byte[10];

			in.read(line);
			assertArrayEquals(BYTE_LINE, line);
			assertEquals(0.0d, monitor.getRatio(), ASSERT_PRECISION);

			readLinesBytes(in, 1337);

			in.read(line);

			assertArrayEquals(BYTE_LINE, line);
			assertEquals(0.0d, monitor.getRatio(), ASSERT_PRECISION);
		}
	}

	@Test(expected = OperationCanceledException.class)
	public void cancel() throws Exception {
		final TestProgressMonitor monitor = new TestProgressMonitor();
		try (final ProgressReportingInputStream in = new ProgressReportingInputStream(
				new LinesInputStream(10000, "123456789"), 100000, monitor)) {

			in.setUpdateInterval(1);

			readLinesBytes(in, 1337);

			monitor.setCanceled(true);

			readLinesBytes(in, 1337);
		}
	}

	@Test
	public void hugeFile() throws Exception {
		final TestProgressMonitor monitor = new TestProgressMonitor();

		final long size = 3L * Integer.MAX_VALUE;

		try (final ProgressReportingInputStream in = new ProgressReportingInputStream(
				new LinesInputStream(size / 2L, "a"), size, monitor)) {

			in.setUpdateInterval(1_000_000);

			assertFalse(monitor.hasStarted());

			final byte[] line = new byte[10];

			in.read(line);
			assertEquals(0.0001d, monitor.getRatio(), ASSERT_PRECISION);

			readLinesBytes(in, 1_000_000_000, 2);
			assertEquals(0.31d, monitor.getRatio(), ASSERT_PRECISION);

			readLinesBytes(in, 1_000_000_000, 2);
			assertEquals(0.62d, monitor.getRatio(), ASSERT_PRECISION);

			readLinesBytes(in, 1_000_000_000, 2);
			assertEquals(0.93d, monitor.getRatio(), ASSERT_PRECISION);
		}
	}

	@Test
	public void updateInterval() throws Exception {
		final TestProgressMonitor monitor = new TestProgressMonitor();
		try (final ProgressReportingInputStream in = new ProgressReportingInputStream(
				new LinesInputStream(10000, "123456789"), 100000, monitor)) {

			in.setUpdateInterval(80_000);

			assertFalse(monitor.hasStarted());

			final byte[] line = new byte[10];

			in.read(line);
			assertEquals(0.0001d, monitor.getRatio(), ASSERT_PRECISION);

			readLinesBytes(in, 7000);
			assertEquals(0.0001d, monitor.getRatio(), ASSERT_PRECISION);

			readLinesBytes(in, 1000);
			assertEquals(0.8001d, monitor.getRatio(), ASSERT_PRECISION);

			assertEquals(80_000, in.getUpdateInterval());
		}
	}
}
