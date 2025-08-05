/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.emf.ui.domain;

import java.util.Objects;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public class EditingDomainResolver {
	private EditingDomainResolver() {
		// Empty for utility classes
	}
	
	/**
	 * Finds the {@link IEditorPart} for the specified
	 * {@link IEditingDomainProvider#getEditingDomain() editingDomain} within the
	 * {@link PlatformUI#getWorkbench() Eclipse Workbench}, or <code>null</code> if
	 * such an editor cannot be found.
	 * 
	 * @param editingDomain editing domain of the {@link IEditingDomainProvider editor}
	 * @return the editor
	 */
	public static <T extends IEditorPart & IEditingDomainProvider> T findEditorPart(EditingDomain editingDomain, Class<T> editorType) {
		if (editingDomain == null || editorType == null) {
			return null;
		}
		for(IWorkbenchWindow window : PlatformUI.getWorkbench().getWorkbenchWindows()) {
			for(IWorkbenchPage page : window.getPages()) {
				for(IEditorReference editorRef : page.getEditorReferences()) {
					final IEditorPart editor = editorRef.getEditor(false);
					if (editorType.isInstance(editor)
							&& Objects.equals(editingDomain, editorType.cast(editor).getEditingDomain())) {
						return editorType.cast(editor);
					}
				}
			}
		}
		return null;
	}
}
