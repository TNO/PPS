/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.emf.ui.action;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.undo.CreateMarkersOperation;

import nl.esi.pps.common.emf.ui.Activator;

/**
 * @see org.eclipse.ui.texteditor.AddMarkerAction
 */
public class BookmarkAction extends Action {
	protected IWorkbenchPart activeWorkbenchPart;

	public BookmarkAction() {
		super("Add Bookmark...");
		setImageDescriptor(Activator.getDescriptor(Activator.IMAGE_BOOKMARK_ADD));
	}

	@Override
	public void run() {
		final IResource resource = getResource();
		final IBookmarkProvider bookmarkProvider = getBookmarkProvider();
		if (null == activeWorkbenchPart || null == resource || null == bookmarkProvider) {
			return;
		}

		final Shell shell = activeWorkbenchPart.getSite().getShell();
		final IAdaptable shellContext = new IAdaptable() {
			@SuppressWarnings("unchecked")
			@Override
			public <T> T getAdapter(Class<T> adapter) {
				return adapter == Shell.class ? (T) shell : null;
			}
		};

		String bookmarkName = bookmarkProvider.getBookmarkName();
		if (bookmarkProvider.askBookmarkName()) {
			InputDialog dialog = new InputDialog(shell, "Add Bookmark", "Enter Bookmark name:", bookmarkName,
					i -> i.isEmpty() ? "" : null);
			if (dialog.open() == InputDialog.OK) {
				bookmarkName = dialog.getValue();
			} else {
				return;
			}
		}

		IUndoableOperation operation = new CreateMarkersOperation(bookmarkProvider.getBookmarkType(),
				bookmarkProvider.createBookmarkAttributes(bookmarkName), resource, bookmarkName);
		IOperationHistory operationHistory = PlatformUI.getWorkbench().getOperationSupport().getOperationHistory();
		try {
			operationHistory.execute(operation, null, shellContext);
		} catch (ExecutionException e) {
			Activator.getDefault().getLog()
					.log(new Status(IStatus.ERROR, Activator.getDefault().getBundle().getSymbolicName(), IStatus.OK,
							"Failed to create bookmark: " + e.getLocalizedMessage(), e));
		}
	}

	public void update() {
		setEnabled(null != getResource() && null != getBookmarkProvider());
	}

	public void setActiveWorkbenchPart(IWorkbenchPart workbenchPart) {
		this.activeWorkbenchPart = workbenchPart;
	}

	/**
	 * Returns the resource on which to create the marker, or <code>null</code> if
	 * there is no applicable resource. This queries the editor's input using
	 * <code>getAdapter(IResource.class)</code>. Subclasses may override this
	 * method.
	 *
	 * @return the resource to which to attach the newly created marker
	 */
	protected IResource getResource() {
		if (activeWorkbenchPart instanceof IEditorPart) {
			final IEditorInput input = ((IEditorPart) activeWorkbenchPart).getEditorInput();
			return input.getAdapter(IResource.class);
		}
		return null;
	}

	protected IBookmarkProvider getBookmarkProvider() {
		if (null != activeWorkbenchPart) {
			return activeWorkbenchPart.getAdapter(IBookmarkProvider.class);
		}
		return null;
	}
}