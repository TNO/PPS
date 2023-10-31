/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.common.core.runtime;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

public class FailOnErrorStatus extends Status {
	private String infoMessage = null;
	private String warningMessage = null;
	private String errorMessage = null;
	private IStatus[] children = new IStatus[0];

	public FailOnErrorStatus(String pluginId, String okMessage) {
		this(OK, pluginId, OK, okMessage, null);
	}

	public FailOnErrorStatus(int severity, String pluginId, String okMessage) {
		this(severity, pluginId, OK, okMessage, null);
	}

	public FailOnErrorStatus(int severity, String pluginId, int code, String okMessage, Throwable exception) {
		super(severity, pluginId, code, okMessage, exception);
	}
	
	public void setOkMessage(String okMessage) {
		super.setMessage(okMessage);
	}
	
	public String getOkMessage() {
		return super.getMessage();
	}

	public void setInfoMessage(String infoMessage) {
		this.infoMessage = infoMessage;
	}
	
	public String getInfoMessage() {
		return infoMessage;
	}

	public void setWarningMessage(String warningMessage) {
		this.warningMessage = warningMessage;
	}
	
	public String getWarningMessage() {
		return warningMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}

	@Override
	public String getMessage() {
		String message = null;
		if (matches(ERROR)) {
			message = getErrorMessage();
		}
		if (null == message && matches(WARNING)) {
			message = getWarningMessage();
		}
		if (null == message && matches(INFO)) {
			message = getInfoMessage();
		}
		if (null == message) {
			message = getOkMessage();
		}
		return message;
	}

	@Override
	public boolean isMultiStatus() {
		return true;
	}

	@Override
	public IStatus[] getChildren() {
		return children;
	}

	protected void addChildren(IStatus... statuses) {
		IStatus[] result = new IStatus[children.length + statuses.length];
		System.arraycopy(children, 0, result, 0, children.length);
		System.arraycopy(statuses, 0, result, children.length, statuses.length);
		children = result;

		for (IStatus status : statuses) {
			Assert.isLegal(status != null);
			int newSev = status.getSeverity();
			if (newSev > getSeverity()) {
				setSeverity(newSev);
			}
		}
	}

	/**
	 * Adds the given status to this multi-status.
	 *
	 * @param status
	 *            the new child status
	 */
	public void add(IStatus status) throws ErrorStatusException {
		Assert.isLegal(status != null);
		addChildren(status);
		if (matches(ERROR)) {
			throw new ErrorStatusException(this);
		}
	}

	/**
	 * Adds all of the children of the given status to this multi-status. Does
	 * nothing if the given status has no children (which includes the case
	 * where it is not a multi-status).
	 *
	 * @param status
	 *            the status whose children are to be added to this one
	 */
	public void addAll(IStatus status) throws ErrorStatusException {
		Assert.isLegal(status != null);
		addChildren(status.getChildren());
		if (matches(ERROR)) {
			throw new ErrorStatusException(this);
		}
	}

	/**
	 * Merges the given status into this multi-status. Equivalent to
	 * <code>add(status)</code> if the given status is not a multi-status.
	 * Equivalent to <code>addAll(status)</code> if the given status is a
	 * multi-status.
	 *
	 * @param status
	 *            the status to merge into this one
	 * @see #add(IStatus)
	 * @see #addAll(IStatus)
	 */
	public void merge(IStatus status) throws ErrorStatusException {
		Assert.isLegal(status != null);
		if (!status.isMultiStatus()) {
			add(status);
		} else {
			addAll(status);
		}
	}
}
