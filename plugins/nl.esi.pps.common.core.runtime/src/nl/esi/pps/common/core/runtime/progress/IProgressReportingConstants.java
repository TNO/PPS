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

import org.eclipse.core.runtime.IProgressMonitor;

/**
 * Constants used for all progress reporting classes.
 *
 */
public interface IProgressReportingConstants {
	/**
	 * Length of the InputStream is not known.
	 */
	static final long UNKNOWN_TOTAL_LENGTH = -1;

	/**
	 * Amount of work done is not known.
	 */
	static final int UNKNOWN_WORK = IProgressMonitor.UNKNOWN;

	/**
	 * Number of bytes read from InputStream is not known.
	 */
	static final long UNKNOWN_BYTES_READ = UNKNOWN_WORK;
}
