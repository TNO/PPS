/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.emf.synchronizedtiming.range;

public class ConversionNotSupportedException extends RuntimeException {
	private static final long serialVersionUID = -7359598896034848211L;

	public ConversionNotSupportedException() {
	}

	public ConversionNotSupportedException(String message) {
		super(message);
	}

	public ConversionNotSupportedException(Throwable cause) {
		super(cause);
	}

	public ConversionNotSupportedException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConversionNotSupportedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
