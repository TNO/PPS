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

import java.util.Arrays;
import java.util.function.Predicate;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.IStatus;

public class StatusUtils {
	/**
	 * @param severityMask a mask formed by bitwise or'ing severity mask constants
	 *                     (<code>ERROR</code>, <code>WARNING</code>,
	 *                     <code>INFO</code>, <code>CANCEL</code>)
	 * @see IStatus#matches(int)
	 */
	public static IStatus filter(IStatus status, int severityMask) {
		return filter(status, s -> s.matches(severityMask));
	}

	public static IStatus filter(IStatus status, Predicate<? super IStatus> predicate) {
		return new FilteredStatus(status, predicate);
	}

	public static String getFullStatusMessage(IStatus status) {
		StringBuilder messages = new StringBuilder();
		addStatusMessages(status, messages, 0);
		return messages.toString();
	}

	private static void addStatusMessages(IStatus status, StringBuilder messages, int level) {
		StringBuilder message = new StringBuilder();
		message.append(StringUtils.repeat(" ", level * 2));
		if (level > 0) {
			message.append("- ");
		}
		switch (status.getSeverity()) {
		case IStatus.WARNING:
			message.append("WARNING: ");
			break;
		case IStatus.ERROR:
			message.append("ERROR: ");
			break;
		default:
			// No extra prefix.
		}
		message.append(status.getMessage() != null ? status.getMessage() : "<no message>");

		if (messages.length() > 0) {
			messages.append("\n");
		}
		messages.append(message);

		if (status.getException() != null) {
			addStatusException(status.getException(), messages, level + 1);
		}

		for (IStatus child : status.getChildren()) {
			addStatusMessages(child, messages, level + 1);
		}
	}

	private static void addStatusException(Throwable exception, StringBuilder messages, int level) {
		StringBuilder message = new StringBuilder();
		message.append(StringUtils.repeat(" ", level * 2));
		message.append("- ");
		message.append("CAUSE: ");
		message.append(exception.getMessage() != null ? exception.getMessage()
				: exception.getClass().getSimpleName() + ": <no message>");

		if (messages.length() > 0) {
			messages.append("\n");
		}
		messages.append(message);

		if (exception.getCause() != null) {
			addStatusException(exception.getCause(), messages, level + 1);
		}
	}

	private static final class FilteredStatus implements IStatus {
		final IStatus source;
		final Predicate<? super IStatus> predicate;

		private IStatus[] children = null;

		FilteredStatus(IStatus source, Predicate<? super IStatus> predicate) {
			this.source = source;
			this.predicate = predicate;
		}

		public IStatus[] getChildren() {
			if (null == children) {
				children = Arrays.stream(source.getChildren()).filter(predicate)
						.map(s -> new FilteredStatus(s, predicate)).toArray(IStatus[]::new);
			}
			return children;
		}

		public int getCode() {
			return source.getCode();
		}

		public Throwable getException() {
			return source.getException();
		}

		public String getMessage() {
			return source.getMessage();
		}

		public String getPlugin() {
			return source.getPlugin();
		}

		public int getSeverity() {
			return source.getSeverity();
		}

		public boolean isMultiStatus() {
			return source.isMultiStatus();
		}

		public boolean isOK() {
			return source.isOK();
		}

		public boolean matches(int severityMask) {
			return source.matches(severityMask);
		}
	}
}
