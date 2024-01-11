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

import org.eclipse.core.runtime.NullProgressMonitor;

public class TestProgressMonitor extends NullProgressMonitor {
	private boolean done = false;

	private int totalWork = 0;
	private int worked = 0;

	private String taskName;
	private String subTask;

	@Override
	public void beginTask(final String name, final int totalWork) {
		setTaskName(name);
		this.totalWork = totalWork;
	}

	@Override
	public void done() {
		this.done = true;
	}

	@Override
	public void setTaskName(final String name) {
		this.taskName = name;
	}

	@Override
	public void subTask(final String name) {
		this.subTask = name;
	}

	@Override
	public void worked(final int work) {
		this.worked += work;
	}

	public double getRatio() {
		return (double) this.worked / this.totalWork;
	}

	public boolean isDone() {
		return this.done;
	}

	public boolean hasStarted() {
		return this.worked != 0;
	}

	public String getTaskName() {
		return this.taskName;
	}

	public String getSubTask() {
		return this.subTask;
	}
}