/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.common.core.runtime.progress;

import java.io.InputStream;

import org.apache.commons.io.input.CountingInputStream;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * A {@link java.io.InputStream} that updates {@code monitor} every
 * {@link #setUpdateInterval(int)} read bytes with total progress.
 *
 * <p>
 * This class can handle files larger than Integer.MAX_VALUE.
 * </p>
 *
 * <p>
 * <b>Note:</b> This class assumes that constructor parameter {@code in}
 * contains exactly {@code totalLength} bytes. Otherwise, progress reporting
 * will be faulty.<br/>
 * One notable example is an InputStream stemming from a compressed file vs. the
 * file's size. See
 * {@link nl.esi.pps.common.core.runtime.progress.ProgressReportingInflaterInputStream}
 * for an example how to handle that situation.
 * </p>
 *
 * @see nl.esi.pps.common.core.runtime.progress.ProgressReportingInputStreamFactory
 */
public class ProgressReportingInputStream extends CountingInputStream {
	/**
	 * Callback interface for extended progress reporting (e.g. setting some
	 * progress message).
	 *
	 */
	@FunctionalInterface
	public static interface ReportingCallback {
		void report(long byteCount, long totalLength, @NonNull IProgressMonitor monitor);
	}

	protected static final int UPDATE_INTERVAL_DEFAULT = 42 * 1337;

	private final long totalLength;
	private final SubMonitor monitor;
	private final long ratio;

	private long updateInterval = UPDATE_INTERVAL_DEFAULT;
	private long lastReported = 0;

	private ReportingCallback callback = null;

	/**
	 * Creates a ProgressReportingInputStream.
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
	 * @throws NullPointerException
	 *             If {@code inputStream} is {@code null}.
	 * @throws RuntimeException
	 *             If {@code monitor} is {@code null}.
	 */
	public ProgressReportingInputStream(final @NonNull InputStream in, final long totalLength,
			final @NonNull IProgressMonitor monitor) {
		super(in);

		Assert.isNotNull(monitor, "monitor must not be null");

		this.totalLength = totalLength;
		this.ratio = calculateRatio(totalLength);

		this.monitor = SubMonitor.convert(monitor, normalize(totalLength));
	}

	@Override
	protected synchronized void afterRead(final int n) {
		super.afterRead(n);

		if (shouldReportProgress()) {
			getMonitor().split(normalize(calculateProcessedBytesDelta())).done();

			setLastReported(getByteCount());
			invokeCallback();
		}
	}

	protected int normalize(final long val) {
		if (getRatio() == IProgressReportingConstants.UNKNOWN_TOTAL_LENGTH) {
			return IProgressReportingConstants.UNKNOWN_WORK;
		}

		return (int) (val / getRatio());
	}

	protected boolean shouldReportProgress() {
		return calculateProcessedBytesDelta() >= getUpdateInterval() || getLastReported() == 0;
	}

	private void invokeCallback() {
		if (getCallback() != null) {
			getCallback().report(getByteCount(), getTotalLength(), getMonitor());
		}
	}

	private long calculateRatio(final long totalLength) {
		if (totalLength == IProgressReportingConstants.UNKNOWN_TOTAL_LENGTH) {
			return IProgressReportingConstants.UNKNOWN_WORK;
		}

		if (totalLength <= Integer.MAX_VALUE) {
			return 1;
		} else {
			return totalLength / Integer.MAX_VALUE;
		}
	}

	private long calculateProcessedBytesDelta() {
		return getByteCount() - getLastReported();
	}

	/**
	 * Returns the interval (in bytes read) when to update the progress report.
	 *
	 * @return The interval (in bytes read) when to update the progress report.
	 */
	public long getUpdateInterval() {
		return this.updateInterval;
	}

	/**
	 * Sets the interval when to update the progress report.
	 *
	 * <p>
	 * If the interval is too small, the progress reporting costs too much
	 * performance. If the interval is too big, the progress reporting is not
	 * up-to-date and feels "laggy" to the end-user. The default value is
	 * {@link #UPDATE_INTERVAL_DEFAULT}.
	 * </p>
	 *
	 * <p>
	 * <b>NOTE:</b> {@code updateInterval} determines when this class updates the
	 * {@link IProgressMonitor}. However, the IProgressMonitor may delay the actual
	 * reporting at its own discretion.
	 * </p>
	 *
	 * @param updateInterval
	 *            Number of bytes that have to be processed before the next progress
	 *            report. Must be {@code > 0}.
	 *
	 * @throws IllegalArgumentException
	 *             If {@code updateInterval <= 0}.
	 */
	public void setUpdateInterval(final long updateInterval) throws IllegalArgumentException {
		Assert.isLegal(updateInterval > 0, "updateInterval must be > 0");

		this.updateInterval = updateInterval;
	}

	/**
	 * Returns the reporting callback.
	 *
	 * @return The reporting callback, if set. Defaults to {@code null}.
	 */
	public @Nullable ReportingCallback getCallback() {
		return this.callback;
	}

	/**
	 * Sets or removes the reporting callback.
	 *
	 * <p>
	 * The reporting callback is called after every update to the progress monitor.
	 * </p>
	 *
	 * @param callback
	 *            The reporting callback. {@code null} removes the callback.
	 *
	 * @see #setUpdateInterval(long)
	 */
	public void setCallback(final @Nullable ReportingCallback callback) {
		this.callback = callback;
	}

	protected long getLastReported() {
		return this.lastReported;
	}

	protected void setLastReported(final long lastReported) {
		this.lastReported = lastReported;
	}

	protected long getRatio() {
		return this.ratio;
	}

	protected SubMonitor getMonitor() {
		return this.monitor;
	}

	protected long getTotalLength() {
		return this.totalLength;
	}
}
