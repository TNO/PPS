/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.core.runtime.jobs;

import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.IJobFunction;
import org.eclipse.core.runtime.jobs.Job;

import nl.esi.pps.common.core.runtime.ErrorStatusException;

/**
 * A {@link Job} with an {@link IStatusJobFunction} rather than a {@link IJobFunction}, to allow throwing
 * {@link ErrorStatusException}.
 */
public class StatusJob extends WorkspaceJob {
	/** The function to execute for the job. */
	protected final IStatusJobFunction function;

	/**
	 * @param name The name of the job.
	 * @param function The function to execute for the job.
	 */
	public StatusJob(String name, IStatusJobFunction function) {
		super(name);
		this.function = function;
	}

	@Override
	public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
		try {
			return function.run(monitor);
		} catch (ErrorStatusException ex) {
			return ex.getStatus();
		} finally {
			monitor.done();
		}
	}
}
