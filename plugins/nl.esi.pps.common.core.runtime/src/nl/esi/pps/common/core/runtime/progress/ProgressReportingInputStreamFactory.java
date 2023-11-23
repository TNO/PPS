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

import java.io.InputStream;
import java.util.zip.InflaterInputStream;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Creates the appropriate {@link ProgressReportingInputStream} based on a
 * specific {@link InputStream}.
 *
 */
public class ProgressReportingInputStreamFactory {
	private static ProgressReportingInputStreamFactory instance = null;

	public static @NonNull ProgressReportingInputStreamFactory getInstance() {
		if (instance == null) {
			instance = new ProgressReportingInputStreamFactory();
		}

		return instance;
	}

	protected ProgressReportingInputStreamFactory() {

	}

	/**
	 * Creates the appropriate {@link ProgressReportingInputStream} based on the
	 * type of {@code in}.
	 *
	 * @param in
	 *            Stream to read from.
	 * @param totalLength
	 *            Total length of the {@code inputStream}. Use
	 *            {@link IProgressReportingConstants#UNKNOWN_TOTAL_LENGTH} if
	 *            unknown.
	 * @param monitor
	 *            Progress monitor.
	 *
	 * @return The appropriate {@link ProgressReportingInputStream} based on the
	 *         type of {@code in}.
	 * @throws NullPointerException
	 *             If {@code inputStream} is {@code null}.
	 * @throws RuntimeException
	 *             If {@code monitor} is {@code null}.
	 */
	public @NonNull ProgressReportingInputStream create(final @NonNull InputStream in, final long totalLength,
			final @NonNull IProgressMonitor monitor) {
		if (in instanceof InflaterInputStream) {
			return new ProgressReportingInflaterInputStream((InflaterInputStream) in, totalLength, monitor);
		} else {
			return new ProgressReportingInputStream(in, totalLength, monitor);
		}
	}
}
