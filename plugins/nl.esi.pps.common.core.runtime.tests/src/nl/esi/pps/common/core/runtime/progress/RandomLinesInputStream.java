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

import java.util.Random;

import org.apache.commons.io.input.NullInputStream;

/**
 * We need to use random input as this is intended to be zipped, and repeating
 * lines would be zipped too well. Then, zipped bytes read and unzipped bytes
 * read would be too far apart.
 * 
 * @author nstotz
 *
 */
public class RandomLinesInputStream extends NullInputStream {
	private static final int MAX_NEWLINE_CHAR = Math.max('\n', '\r');

	private final Random random;
	private final int lineLength;

	private int currentIndex = 0;

	public RandomLinesInputStream(final long size, final int lineLength) {
		super(size * (lineLength + 1));
		this.lineLength = lineLength + 1;
		this.random = new Random(size);
	}

	@Override
	protected int processByte() {
		int result;
		if (shouldInsertNewline()) {
			result = '\n';
		} else {
			result = nonNewlineRandomByte();
		}
		this.currentIndex++;

		return result;
	}

	private boolean shouldInsertNewline() {
		return this.currentIndex % this.lineLength == 0 && this.currentIndex != 0;
	}

	private int nonNewlineRandomByte() {
		return MAX_NEWLINE_CHAR + this.random.nextInt(0xff - MAX_NEWLINE_CHAR);
	}

	@Override
	protected void processBytes(final byte[] bytes, final int offset, final int length) {
		final byte[] tmp = new byte[length];

		for (int i = 0; i < length; i++) {
			if (shouldInsertNewline()) {
				tmp[i] = '\n';
			} else {
				tmp[i] = (byte) nonNewlineRandomByte();
			}
			this.currentIndex++;
		}

		System.arraycopy(tmp, 0, bytes, offset, length);
	}
}
