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

import java.lang.reflect.Field;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

import org.apache.commons.lang.reflect.FieldUtils;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.annotation.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A {@link ProgressReportingInputStream} with special handling for
 * {@link InflaterInputStream}.
 *
 * @see nl.esi.pps.common.core.runtime.progress.ProgressReportingInputStreamFactory
 */
public class ProgressReportingInflaterInputStream extends ProgressReportingInputStream {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProgressReportingInflaterInputStream.class);

	private final Inflater inflater;

	/**
	 * Creates a ProgressReportingInflaterInputStream.
	 *
	 * @param in
	 *            Stream to read from.
	 * @param totalSize
	 *            Size of the compressed source of {@code inputStream}. Use
	 *            {@link IProgressReportingConstants#UNKNOWN_TOTAL_LENGTH} if unknown.
	 * @param monitor
	 *            Progress monitor.
	 *
	 * @throws NullPointerException
	 *             If {@code inputStream} is {@code null}.
	 * @throws RuntimeException
	 *             If {@code monitor} is {@code null}.
	 */
	public ProgressReportingInflaterInputStream(final @NonNull InflaterInputStream in, final long totalSize,
			final @NonNull IProgressMonitor monitor) {
		super(in, totalSize, monitor);

		Object inflater = null;
		try {
			final Field infField = FieldUtils.getDeclaredField(InflaterInputStream.class, "inf", true);

			if (infField != null) {
				inflater = infField.get(this.in);
			}
		} catch (final IllegalArgumentException | IllegalAccessException e) {
			LOGGER.error("Cannot access field InflaterInputStream.inf to retrieve the Inflater", e);
		}
		this.inflater = (Inflater) inflater;
	}

	@Override
	public synchronized long getByteCount() {
		if (this.inflater == null) {
			return IProgressReportingConstants.UNKNOWN_BYTES_READ;
		}

		return this.inflater.getBytesRead();
	}
}
