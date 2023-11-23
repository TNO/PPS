/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.core.runtime;

import org.eclipse.core.runtime.IStatus;

/** An {@link Exception} based on a {@link IStatus} with an {@link IStatus#ERROR} severity. */
public final class ErrorStatusException extends Exception {
	private static final long serialVersionUID = -8723070998966796917L;

	private final IStatus status; 
	
	/**
	 * The status of this exception should have an ERROR severity.
	 * 
	 * @param status
	 *            a status with {@link IStatus#ERROR} severity.
	 */
	public ErrorStatusException(IStatus status) {
		super(status.getMessage(), status.getException());
		this.status = status;
	}
	
	public IStatus getStatus() {
		return status;
	}
}