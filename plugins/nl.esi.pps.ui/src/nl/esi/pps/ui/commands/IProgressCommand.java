/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.ui.commands;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;

public interface IProgressCommand extends Command {
	/**
	 * A {@link IProgressCommand} may use this {@code ProgressMonitor} only once for
	 * reporting progress. This means that it cannot report progress when the
	 * command is undone or redone.
	 * 
	 * @param progressMonitor monitor to report progress, use only once!
	 */
	void setProgressMonitor(IProgressMonitor progressMonitor);
}
