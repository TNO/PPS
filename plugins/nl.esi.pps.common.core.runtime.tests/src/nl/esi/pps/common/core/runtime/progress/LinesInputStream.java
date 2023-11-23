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

import org.apache.commons.io.input.NullInputStream;

public class LinesInputStream extends NullInputStream {
	private final byte[] line;
	private final int lineLength;

	private long currentIndex = 0;

	public LinesInputStream(final long repeat, final String line) {
		this(repeat, convertAndAppend(line));
	}

	private static byte[] convertAndAppend(final String line) {
		final byte[] lineBytes = line.getBytes();
		final byte[] result = new byte[lineBytes.length + 1];
		System.arraycopy(lineBytes, 0, result, 0, lineBytes.length);
		result[lineBytes.length] = '\n';
		return result;
	}

	public LinesInputStream(final long repeat, final byte[] line) {
		super(repeat * (line.length));

		this.lineLength = line.length;
		this.line = new byte[line.length * 2];
		System.arraycopy(line, 0, this.line, 0, line.length);
		System.arraycopy(line, 0, this.line, line.length, line.length);
	}

	@Override
	protected int processByte() {
		final int result = this.line[linePos()];
		this.currentIndex++;
		return result;
	}

	@Override
	protected void processBytes(final byte[] bytes, final int offset, final int length) {
		int internalOffset = offset;
		int remainingLength = length;

		for (int i = linePos(); i < length; i += this.lineLength) {
			System.arraycopy(this.line, i % this.lineLength, bytes, internalOffset,
					Math.min(remainingLength, this.lineLength));
			internalOffset += this.lineLength;
			remainingLength -= this.lineLength;
		}

		this.currentIndex += length;
	}

	private int linePos() {
		return (int) (this.currentIndex % (long) this.lineLength);
	}
}