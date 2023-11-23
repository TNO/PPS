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

import static org.junit.Assert.assertNotEquals;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.stream.IntStream;

public abstract class ATestProgressReportingReader {
	protected static final double ASSERT_PRECISION = 0.05d;
	protected static final byte[] BYTE_LINE = "123456789\n".getBytes();

	protected void readLines(final ProgressReportingReader reader, final int numLines) throws IOException {
		for (int i = 0; i < numLines; i++) {
			reader.readLine();
		}
	}

	protected void readLinesBytes(final ProgressReportingInputStream in, final int numLines) throws IOException {
		readLinesBytes(in, numLines, 10);
	}

	protected void readLinesBytes(final ProgressReportingInputStream in, final long numLines, final int lineLength)
			throws IOException {
		final long readSize = numLines * lineLength;

		final int bufLen = (int) Math.min(readSize, 1024 * 1024);

		final byte[] buf = new byte[bufLen];

		long remaining = readSize;

		while (remaining > 0) {
			remaining -= in.read(buf, 0, (int) Math.min(remaining, bufLen));
		}
	}

	protected byte[] encode(final Charset charset, final String input) {
		final byte[] bytes = input.getBytes(charset);
		final char[] chars = new char[bytes.length];
		IntStream.range(0, bytes.length).forEachOrdered(i -> chars[i] = (char) bytes[i]);
		final String output = String.valueOf(chars);

		assertNotEquals(input, output);
		return bytes;
	}

}
