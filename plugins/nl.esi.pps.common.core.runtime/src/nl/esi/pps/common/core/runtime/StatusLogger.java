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

import java.util.LinkedList;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

public class StatusLogger {
	private final LinkedList<MultiStatus> sections = new LinkedList<>();
	
	private final String pluginId;
	private final Logger logger;
	
	public StatusLogger(String pluginId, String message) {
		this.pluginId = pluginId;
		this.logger = LoggerFactory.getLogger(pluginId);
		sections.push(new MultiStatus(pluginId, 0, message, null));
	}
	
	public MultiStatus getStatus() {
		return getStatus(false);
	}
	
	public MultiStatus getStatus(boolean autoEndSections) {
		if (autoEndSections) {
			while (isSectionStarted()) endSection();
		} else if (isSectionStarted()) {
			throw new IllegalStateException("All sections should be ended before retrieving status");
		}
		return sections.getLast();
	}
	
	public void trace(String format, Object... arguments) {
		logger.trace(format, arguments);
	}

	public void debug(String format, Object... arguments) {
		logger.debug(format, arguments);
	}

	public void info(String format, Object... arguments) {
		log(IStatus.INFO, MessageFormatter.arrayFormat(format, arguments));
	}

	public void warn(String format, Object... arguments) {
		log(IStatus.WARNING, MessageFormatter.arrayFormat(format, arguments));
	}
	
	public void error(String format, Object... arguments) {
		log(IStatus.ERROR, MessageFormatter.arrayFormat(format, arguments));
	}
	
	private void log(int level, FormattingTuple tuple) {
		log(new Status(level, pluginId, tuple.getMessage(), tuple.getThrowable()));
	}
	
	/**
	 * @see MultiStatus#add(IStatus)
	 */
	public void log(IStatus status) {
		sections.peek().add(status);
	}

	/**
	 * @see MultiStatus#addAll(IStatus)
	 */
	public void logAll(IStatus status) {
		sections.peek().addAll(status);
	}
	
	public void startSection(String format, Object... arguments) {
		final FormattingTuple tuple = MessageFormatter.arrayFormat(format, arguments);
		final MultiStatus section = new MultiStatus(pluginId, 0, tuple.getMessage(), tuple.getThrowable());
		sections.push(section);
	}
	
	public void endSection() {
		if (!isSectionStarted()) {
			throw new IllegalStateException("No section in progress");
		}
		log(sections.pop());
	}
	
	public boolean isSectionStarted() {
		return sections.size() > 1;
	}
}
