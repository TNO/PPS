/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.ide.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.statushandlers.StatusManager;

public final class WorkbenchUtil {
	private WorkbenchUtil() {
		// Empty for utility classes
	}

	public static final void openDefaultEditorAsync(final IFile file) {
		if (PlatformUI.isWorkbenchRunning()) {
			final IWorkbench workbench = PlatformUI.getWorkbench();
			final Runnable task = () -> {
				try {
					openDefaultEditor(file, workbench);
				} catch (PartInitException e) {
					StatusManager.getManager().handle(e, Activator.getDefault().getBundle().getSymbolicName());
				}
			};
			workbench.getDisplay().asyncExec(task);
		}
	}
	
	public static final IEditorPart openDefaultEditorSync(final IFile file) throws PartInitException {
		if (PlatformUI.isWorkbenchRunning()) {
			final IWorkbench workbench = PlatformUI.getWorkbench();
			if (Display.getCurrent() == workbench.getDisplay()) {
				return openDefaultEditor(file, workbench);
			} else {
				final Object[] result = new Object[1];
				final Runnable task = () -> {
					try {
						result[0] = openDefaultEditor(file, workbench);
					} catch (Exception e) {
						result[0] = e;
					}
				};
				workbench.getDisplay().syncExec(task);
				
				if (result[0] instanceof Exception) {
					final Exception cause = (Exception) result[0];
					throw new PartInitException(cause.getMessage(), cause);
				} else {
					return (IEditorPart) result[0];
				}
			}
		} else {
			throw new PartInitException("The workbench has not yet been created or has completed.");
		}
	}

	public static final void openDefaultEditorAsync(final IMarker marker) {
		if (PlatformUI.isWorkbenchRunning()) {
			final IWorkbench workbench = PlatformUI.getWorkbench();
			final Runnable task = () -> {
				try {
					openDefaultEditor(marker, workbench);
				} catch (PartInitException e) {
					StatusManager.getManager().handle(e, Activator.getDefault().getBundle().getSymbolicName());
				}
			};
			workbench.getDisplay().asyncExec(task);
		}
	}

	public static final IEditorPart openDefaultEditorSync(final IMarker marker) throws PartInitException {
		if (PlatformUI.isWorkbenchRunning()) {
			final IWorkbench workbench = PlatformUI.getWorkbench();
			if (Display.getCurrent() == workbench.getDisplay()) {
				return openDefaultEditor(marker, workbench);
			} else {
				final Object[] result = new Object[1];
				final Runnable task = () -> {
					try {
						result[0] = openDefaultEditor(marker, workbench);
					} catch (Exception e) {
						result[0] = e;
					}
				};
				workbench.getDisplay().syncExec(task);
				
				if (result[0] instanceof Exception) {
					final Exception cause = (Exception) result[0];
					throw new PartInitException(cause.getMessage(), cause);
				} else {
					return (IEditorPart) result[0];
				}
			}
		} else {
			throw new PartInitException("The workbench has not yet been created or has completed.");
		}
	}
	
	private static final IEditorPart openDefaultEditor(final IFile file, IWorkbench workbench) throws PartInitException {
		IEditorRegistry editorRegistry = workbench.getEditorRegistry();
		if (null == editorRegistry) {
			throw new PartInitException("Workbench editor registry not found");
		}
		IEditorDescriptor defaultEditor = editorRegistry.getDefaultEditor(file.getName());
		if (null == defaultEditor) {
			throw new PartInitException("No default editor registered for: " + file.getName());
		}
		IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
		if (null == activeWorkbenchWindow) {
			throw new PartInitException("Workbench not active");
		}
		IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
		if (null == activePage) {
			throw new PartInitException("Workbench not active");
		}
		return activePage.openEditor(new FileEditorInput(file), defaultEditor.getId());
	}

	private static final IEditorPart openDefaultEditor(final IMarker marker, IWorkbench workbench) throws PartInitException {
		IResource markerResource = marker.getResource();
		if (!(markerResource instanceof IFile)) {
			throw new PartInitException("Only marker on IFile is supported");
		}
		IEditorPart editor = openDefaultEditor((IFile) markerResource, workbench);
		IGotoMarker gotoAdapter = editor.getAdapter(IGotoMarker.class);
		if (gotoAdapter != null) {
			gotoAdapter.gotoMarker(marker);
		}
		return editor;
	}
}
