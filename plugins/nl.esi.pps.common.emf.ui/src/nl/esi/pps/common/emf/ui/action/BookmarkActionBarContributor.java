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

import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.ide.IDEActionFactory;

/**
 * TODO: These extensions should become part of our code generator
 */
public class BookmarkActionBarContributor extends EditingDomainActionBarContributor {
	/**
	 * This is the action used to implement bookmark.
	 */
	protected BookmarkAction bookmarkAction;

	public BookmarkActionBarContributor(int style) {
		super(style);
	}

	protected BookmarkAction createBookmarkAction() {
		return new BookmarkAction();
	}

	@Override
	public void init(IActionBars actionBars) {
		super.init(actionBars);

		bookmarkAction = createBookmarkAction();
		if (bookmarkAction != null) {
			actionBars.setGlobalActionHandler(IDEActionFactory.BOOKMARK.getId(), bookmarkAction);
		}
	}

	@Override
	public void setActiveEditor(IEditorPart part) {
		super.setActiveEditor(part);

		if (bookmarkAction != null) {
			// Only enable bookmarks from the editor area
			bookmarkAction.setEnabled(isActivePart(part));
		}
	}

	@Override
	public void activate() {
		if (bookmarkAction != null) {
			bookmarkAction.setActiveWorkbenchPart(activeEditor);
		}

		super.activate();
	}

	@Override
	public void deactivate() {
		if (bookmarkAction != null) {
			bookmarkAction.setActiveWorkbenchPart(null);
		}

		super.deactivate();
	}

	@Override
	public void update() {
		if (bookmarkAction != null) {
			bookmarkAction.update();
		}

		super.update();
	}

	@Override
	protected void addGlobalActions(IMenuManager menuManager) {
		if (bookmarkAction != null) {
			if (menuManager.find("ui-actions") == null) {
				menuManager.insertAfter("additions-end", new Separator("ui-actions"));
			}
			menuManager.insertAfter("ui-actions", new ActionContributionItem(bookmarkAction));
		}

		super.addGlobalActions(menuManager);
	}

	/**
	 * Returns <code>true</code> if and only if <code>part</code> is the active part
	 * within its {@link IWorkbenchPage page}.
	 * 
	 * @param part the part under investigation.
	 * @return <code>true</code> when <code>part</code> is active.
	 */
	protected boolean isActivePart(IEditorPart part) {
		if (part == null || part.getSite() == null) {
			return false;
		}
		final IWorkbenchPage page = part.getSite().getPage();
		return page != null && page.getActivePart() == part;
	}
}
