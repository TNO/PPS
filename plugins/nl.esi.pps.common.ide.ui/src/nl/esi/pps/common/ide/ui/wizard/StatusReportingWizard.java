/*
 * Copyright (c) 2018-2026 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.ide.ui.wizard;

import static nl.esi.pps.common.core.runtime.StatusUtils.filter;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import nl.esi.pps.common.core.runtime.ErrorStatusException;
import nl.esi.pps.common.core.runtime.jobs.IStatusJobFunction;
import nl.esi.pps.common.ide.ui.Activator;
import nl.esi.pps.common.ide.ui.status.StatusDialog;
import nl.esi.pps.common.ide.ui.viewers.TreeColumnModelViewer;

public abstract class StatusReportingWizard extends Wizard implements IStatusJobFunction {
    public static final Collection<Integer> DEFAULT_SHOW_DIALOG_SEVERITIES = Collections
            .unmodifiableCollection(Arrays.asList(IStatus.INFO, IStatus.WARNING, IStatus.ERROR));

    public static final Collection<Integer> DEFAULT_LOG_SEVERITIES = Collections
            .unmodifiableCollection(Arrays.asList(IStatus.WARNING, IStatus.ERROR));

    /**
     * The severity levels for which to show a dialog on job completion.
     *
     * @see IStatus#getSeverity
     */
    protected final Collection<Integer> showDialogSeverities;

    /**
     * The severity levels for which to log the job result.
     *
     * @see IStatus#getSeverity
     */
    protected final Collection<Integer> logSeverities;

    public StatusReportingWizard(String title) {
        this(title, DEFAULT_SHOW_DIALOG_SEVERITIES, DEFAULT_LOG_SEVERITIES);
    }

    public StatusReportingWizard(String title, Collection<Integer> showDialogSeverities,
            Collection<Integer> logSeverities)
    {
        setWindowTitle(title);
        setNeedsProgressMonitor(true);
        this.showDialogSeverities = showDialogSeverities;
        this.logSeverities = logSeverities;
    }

    @Override
    public boolean performFinish() {
        try {
            getContainer().run(true, true, monitor -> {
                try {
                    handleResult(run(monitor));
                } catch (ErrorStatusException ex) {
                    handleResult(ex.getStatus());
                } finally {
                    monitor.done();
                }
            });
        } catch (InvocationTargetException ex) {
            handleResult(new Status(IStatus.ERROR, Activator.getDefault().getBundle().getSymbolicName(),
                    String.format("Failed to perform wizard: %s", ex.getMessage()), ex));
        } catch (InterruptedException ex) {
            // User canceled
        }
        return true;
    }

    private void handleResult(IStatus result) {
        if (logSeverities.contains(result.getSeverity())) {
            logJobResult(filter(result, s -> logSeverities.contains(s.getSeverity())));
        }
        if (showDialogSeverities.contains(result.getSeverity())) {
            showJobResultDialog(filter(result, s -> showDialogSeverities.contains(s.getSeverity())));
        }
    }

    protected void logJobResult(IStatus result) {
        Activator.getDefault().getLog().log(result);
    }

    protected void showJobResultDialog(IStatus result) {
        if (PlatformUI.isWorkbenchRunning()) {
            PlatformUI.getWorkbench().getDisplay().asyncExec(() -> {
                Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
                StatusDialog statusDialog = new StatusDialog(shell, getWindowTitle(), result) {
                    @Override
                    protected boolean isModal() {
                        return false;
                    }

                    @Override
                    protected boolean isResizable() {
                        return true;
                    }

                    @Override
                    protected TreeColumnModelViewer createStatusViewer(Composite parent) {
                        TreeColumnModelViewer statusViewer = super.createStatusViewer(parent);
                        statusViewer.expandAll();
                        return statusViewer;
                    }
                };
                statusDialog.setBlockOnOpen(false);
                statusDialog.open();
            });
        } else {
            Activator.getDefault().getLog().log(result);
        }
    }
}
