/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
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
import static org.junit.Assert.assertNotEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.io.IOUtils;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.junit.Test;

public class TestProgressReportingReaderPositive extends ATestProgressReportingReader {
	@Test
	public void regular() throws Exception {
		final TestProgressMonitor monitor = new TestProgressMonitor();
		try (
				final ProgressReportingInputStream in = new ProgressReportingInputStream(
						new LinesInputStream(10000, "123456789"), 100000, monitor);
				final ProgressReportingReader reader = new ProgressReportingReader(
						in, Charset.defaultCharset())) {

			in.setUpdateInterval(1);

			assertFalse(monitor.hasStarted());

			String line;

			line = reader.readLine();
			assertEquals("123456789", line);
			assertEquals("Processed 1 lines", monitor.getSubTask());
			assertEquals(0.05d, monitor.getRatio(), ASSERT_PRECISION);

			readLines(reader, 1337);

			line = reader.readLine();

			assertEquals("123456789", line);
			assertNotEquals("Processed 1 lines", monitor.getSubTask());
			assertEquals(0.1339d, monitor.getRatio(), ASSERT_PRECISION);
		}
	}

	@Test
	public void unknownFileSize() throws Exception {
		final TestProgressMonitor monitor = new TestProgressMonitor();
		try (
				final ProgressReportingInputStream in = new ProgressReportingInputStream(
						new LinesInputStream(10000, "123456789"), IProgressReportingConstants.UNKNOWN_TOTAL_LENGTH,
						monitor);
				final ProgressReportingReader reader = new ProgressReportingReader(
						in, Charset.defaultCharset())) {

			in.setUpdateInterval(1);

			assertFalse(monitor.hasStarted());

			String line;

			line = reader.readLine();
			assertEquals("123456789", line);
			assertEquals("Processed 1 lines", monitor.getSubTask());
			assertEquals(0.0d, monitor.getRatio(), ASSERT_PRECISION);

			readLines(reader, 1337);

			line = reader.readLine();

			assertEquals("123456789", line);
			assertNotEquals("Processed 1 lines", monitor.getSubTask());
			assertEquals(0.0d, monitor.getRatio(), ASSERT_PRECISION);
		}
	}

	public void nullCharset() throws Exception {
		final TestProgressMonitor monitor = new TestProgressMonitor();
		try (
				final ProgressReportingInputStream in = new ProgressReportingInputStream(
						new LinesInputStream(10000, "123456789"), 100000, new NullProgressMonitor());
				final ProgressReportingReader reader = new ProgressReportingReader(
						in, null)) {

			in.setUpdateInterval(1);

			assertFalse(monitor.hasStarted());

			String line;

			line = reader.readLine();
			assertEquals("123456789", line);
			assertEquals("Processed 1 lines", monitor.getSubTask());
			assertEquals(0.05d, monitor.getRatio(), ASSERT_PRECISION);

			readLines(reader, 1337);

			line = reader.readLine();

			assertEquals("123456789", line);
			assertNotEquals("Processed 1 lines", monitor.getSubTask());
			assertEquals(0.1339d, monitor.getRatio(), ASSERT_PRECISION);
		}
	}

	@Test(expected = OperationCanceledException.class)
	public void cancel() throws Exception {
		final TestProgressMonitor monitor = new TestProgressMonitor();
		try (
				final ProgressReportingInputStream in = new ProgressReportingInputStream(
						new LinesInputStream(10000, "123456789"), 100000, monitor);
				final ProgressReportingReader reader = new ProgressReportingReader(
						in, Charset.defaultCharset())) {

			in.setUpdateInterval(1);

			readLines(reader, 1337);

			monitor.setCanceled(true);

			readLines(reader, 1337);
		}
	}

	@Test
	public void zipped() throws Exception {
		final TestProgressMonitor monitor = new TestProgressMonitor();

		final ByteArrayOutputStream tmpOutput = new ByteArrayOutputStream();
		final GZIPOutputStream gzipOutput = new GZIPOutputStream(tmpOutput);
		IOUtils.copy(new RandomLinesInputStream(10000, 9), gzipOutput);
		gzipOutput.finish();

		try (
				final ProgressReportingInputStream in = new ProgressReportingInflaterInputStream(
						new GZIPInputStream(new ByteArrayInputStream(tmpOutput.toByteArray())), 100_000, monitor);
				final ProgressReportingReader reader = new ProgressReportingReader(
						in, Charset.defaultCharset())) {

			in.setUpdateInterval(1);

			assertFalse(monitor.hasStarted());

			reader.readLine();
			assertEquals("Processed 1 lines", monitor.getSubTask());
			assertEquals(0.05d, monitor.getRatio(), ASSERT_PRECISION);

			readLines(reader, 1337);
			assertNotEquals("Processed 1 lines", monitor.getSubTask());
			assertEquals(0.1338d, monitor.getRatio(), ASSERT_PRECISION);

			readLines(reader, 4000);
			assertEquals(0.5338d, monitor.getRatio(), ASSERT_PRECISION);

			readLines(reader, 4000);
			assertEquals(0.9338d, monitor.getRatio(), ASSERT_PRECISION);
		}
	}

	@Test
	public void hugeFile() throws Exception {
		final TestProgressMonitor monitor = new TestProgressMonitor();

		final long size = 3L * Integer.MAX_VALUE;

		try (
				final ProgressReportingInputStream in = new ProgressReportingInputStream(
						new LinesInputStream(size / 2L, "a"), size, monitor);
				final ProgressReportingReader reader = new ProgressReportingReader(
						in, Charset.defaultCharset())) {

			in.setUpdateInterval(1_000_000);

			assertFalse(monitor.hasStarted());

			reader.readLine();
			assertEquals("Processed 1 lines", monitor.getSubTask());
			assertEquals(0.0001d, monitor.getRatio(), ASSERT_PRECISION);

			readLines(reader, 2_000_000);
			assertNotEquals("Processed 1 lines", monitor.getSubTask());
			assertEquals(0.02d, monitor.getRatio(), ASSERT_PRECISION);
		}
	}

	@Test
	public void specialCharset() throws Exception {
		final TestProgressMonitor monitor = new TestProgressMonitor();

		final Charset charset = Charset.forName("UTF-32");

		final String input = "123456789\n";
		final byte[] bytes = encode(charset, input);

		try (
				final ProgressReportingInputStream in = new ProgressReportingInputStream(
						new LinesInputStream(10000, bytes), 100000, monitor);
				final ProgressReportingReader reader = new ProgressReportingReader(
						in, charset)) {

			in.setUpdateInterval(1);

			assertFalse(monitor.hasStarted());

			String line;

			line = reader.readLine();
			assertEquals("123456789", line);
		}
	}

	@Test
	public void updateInterval() throws Exception {
		final TestProgressMonitor monitor = new TestProgressMonitor();
		try (
				final ProgressReportingInputStream in = new ProgressReportingInputStream(
						new LinesInputStream(10000, "123456789"), 100000, monitor);
				final ProgressReportingReader reader = new ProgressReportingReader(
						in, Charset.defaultCharset())) {

			in.setUpdateInterval(20_000);

			assertFalse(monitor.hasStarted());

			reader.readLine();
			final String message = monitor.getSubTask();

			readLines(reader, 1000);

			reader.readLine();
			assertEquals(message, monitor.getSubTask());

			readLines(reader, 2000);

			reader.readLine();
			assertNotEquals(message, monitor.getSubTask());

			assertEquals(20_000, in.getUpdateInterval());
		}
	}

	@Test
	public void progressMessage() throws Exception {
		final TestProgressMonitor monitor = new TestProgressMonitor();
		try (
				final ProgressReportingInputStream in = new ProgressReportingInputStream(
						new LinesInputStream(10000, "123456789"), 100000, monitor);
				final ProgressReportingReader reader = new ProgressReportingReader(
						in, Charset.defaultCharset())) {

			in.setUpdateInterval(1);
			reader.setProgressMessage("Parsed %d lines");

			reader.readLine();
			assertEquals("Parsed 1 lines", monitor.getSubTask());

			assertEquals("Parsed %d lines", reader.getProgressMessage());
		}
	}
}
