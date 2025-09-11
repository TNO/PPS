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

import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * A {@link java.io.BufferedReader} that updates the
 * {@link org.eclipse.core.runtime.IProgressMonitor} passed to an
 * {@link ProgressReportingInputStream} with a message containing the number of
 * read lines.
 *
 * <p>
 * This class <i>can</i> handle files larger than Integer.MAX_VALUE. it
 * <i>cannot</i> handle files with more than Integer.MAX_VALUE lines (processing
 * them still works, but the progress report is faulty).
 * </p>
 *
 */
public class ProgressReportingReader extends LineNumberReader {
	private String progressMessage = "Processed %,d lines";

	/**
	 * Creates the ProgressReportingReader.
	 *
	 * @param in
	 *            Stream to read from.
	 * @param charset
	 *            Charset to read {@code in}.
	 *
	 * @throws NullPointerException
	 *             If {@code in} is null.
	 * @throws UnsupportedEncodingException
	 *             If {@code charset} is not supported.
	 */
	public ProgressReportingReader(final @NonNull ProgressReportingInputStream in, final @Nullable Charset charset) {
		super(new InputStreamReader(in, charset != null ? charset : Charset.defaultCharset()));

		in.setCallback((byteCount, totalSize, monitor) -> {
			monitor.subTask(String.format(getProgressMessage(), getLineNumber() + 1));
		});
	}

	/**
	 * Returns the message shown for reporting progress.
	 *
	 * @return The message shown for reporting progress.
	 */
	public @NonNull String getProgressMessage() {
		return this.progressMessage;
	}

	/**
	 * Sets the message to show for reporting progress.
	 *
	 * <p>
	 * {@code progressMessage} is passed to {@link String#format(String, Object...)}
	 * and receives a {@code Integer} object containing the number of processed
	 * lines.
	 * </p>
	 *
	 * <p>
	 * Default value is {@code "Processed %,d lines"}.
	 * </p>
	 *
	 * <p>
	 * See {@link ProgressReportingInputStream#setUpdateInterval(long)} for details
	 * on when the progress is reported.
	 * </p>
	 *
	 * @param progressMessage
	 *            Message to show for reporting progress.
	 *
	 * @throws RuntimeException
	 *             If {@code progressMessage} is {@code null}.
	 */
	public void setProgressMessage(final @NonNull String progressMessage) throws RuntimeException {
		Assert.isNotNull(progressMessage);

		this.progressMessage = progressMessage;
	}
}