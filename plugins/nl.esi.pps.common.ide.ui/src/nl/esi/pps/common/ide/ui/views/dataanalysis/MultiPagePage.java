/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.common.ide.ui.views.dataanalysis;

import static org.eclipse.swt.events.SelectionListener.widgetSelectedAdapter;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.jface.dialogs.IPageChangeProvider;
import org.eclipse.jface.dialogs.IPageChangedListener;
import org.eclipse.jface.dialogs.PageChangedEvent;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IPartService;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.part.Page;

/**
 * <b>NOTE:</b> This class is basically a copy of {@link MultiPageEditorPart}
 * and adapted to be a {@link Page}. Keep this in mind for licensing issues.
 * 
 * @see MultiPageEditorPart
 */
public abstract class MultiPagePage extends Page implements IPageChangeProvider {

	private CTabFolder tabFolder;

	private ListenerList<IPageChangedListener> pageChangeListeners = new ListenerList<>(ListenerList.IDENTITY);

	public MultiPagePage() {
		super();
	}

	public int addPage(Control control, String text) {
		int index = getPageCount();
		addPage(index, control, text);
		return index;
	}

	public void addPage(int index, Control control, String text) {
		createItem(index, control).setText(text);
	}

	private CTabItem createItem(int index, Control control) {
		CTabItem item = new CTabItem(tabFolder, SWT.NONE, index);
		item.setControl(control);
		return item;
	}

	protected abstract void createPages();

	@Override
	public final void createControl(Composite parent) {
		tabFolder = new CTabFolder(parent, SWT.BOTTOM | SWT.FLAT);
		tabFolder.addSelectionListener(widgetSelectedAdapter(e -> {
			int newPageIndex = tabFolder.indexOf((CTabItem) e.item);
			pageChange(newPageIndex);
		}));
		// set the active page (page 0 by default), unless it has already been done
		createPages();
		if (getActivePage() == -1 && getPageCount() > 0) {
			setActivePage(0);
		}
	}

	@Override
	public void dispose() {
		pageChangeListeners.clear();
		super.dispose();
	}

	public int getActivePage() {
		return tabFolder.getSelectionIndex();
	}

	protected Composite getContainer() {
		return tabFolder;
	}

	@Override
	public Control getControl() {
		return tabFolder;
	}

	protected Control getControl(int pageIndex) {
		return getItem(pageIndex).getControl();
	}

	private CTabItem getItem(int pageIndex) {
		return tabFolder.getItem(pageIndex);
	}

	protected int getPageCount() {
		return tabFolder.getItemCount();
	}

	protected Image getPageImage(int pageIndex) {
		return getItem(pageIndex).getImage();
	}

	protected String getPageText(int pageIndex) {
		return getItem(pageIndex).getText();
	}

	protected Object getPageData(int pageIndex) {
		return getItem(pageIndex).getData();
	}

	public Object getSelectedPage() {
		int index = getActivePage();
		if (index == -1) {
			return null;
		}
		return getControl(index);
	}

	protected void pageChange(int newPageIndex) {
		IPartService partService = getSite().getService(IPartService.class);
		if (partService.getActivePart() == this) {
			setFocus();
		}

		Object selectedPage = getSelectedPage();
		if (selectedPage != null) {
			firePageChanged(new PageChangedEvent(this, selectedPage));
		}
	}

	public void removePage(int pageIndex) {
		Assert.isTrue(pageIndex >= 0 && pageIndex < getPageCount());

		// get control for the item if it's not an editor
		CTabItem item = getItem(pageIndex);
		Control pageControl = item.getControl();

		// dispose item before disposing editor, in case there's an exception
		// in editor's dispose
		item.dispose();

		if (pageControl != null) {
			pageControl.dispose();
		}
	}

	/**
	 * Removes all pages with the active page as last to avoid unnecessary page
	 * changes.
	 */
	public void removeAllPages() {
		while (getPageCount() > 0) {
			if (getPageCount() > 1 && getActivePage() == 0) {
				removePage(1);
			} else {
				removePage(0);
			}
		}
	}

	protected void setActivePage(int pageIndex) {
		Assert.isTrue(pageIndex >= 0 && pageIndex < getPageCount());
		tabFolder.setSelection(pageIndex);
		pageChange(pageIndex);
	}

	protected void setControl(int pageIndex, Control control) {
		getItem(pageIndex).setControl(control);
	}

	@Override
	public void setFocus() {
		setFocus(getActivePage());
	}

	protected void setPageImage(int pageIndex, Image image) {
		getItem(pageIndex).setImage(image);
	}

	protected void setPageText(int pageIndex, String text) {
		getItem(pageIndex).setText(text);
	}

	protected void setPageData(int pageIndex, Object data) {
		getItem(pageIndex).setData(data);
	}

	private void setFocus(int pageIndex) {
		if (pageIndex < 0 || pageIndex >= getPageCount()) {
			// page index out of bounds, don't set focus.
			return;
		}
		// Give the page's control focus.
		final Control control = getControl(pageIndex);
		if (control != null) {
			control.setFocus();
		}
	}

	public void addPageChangedListener(IPageChangedListener listener) {
		pageChangeListeners.add(listener);
	}

	public void removePageChangedListener(IPageChangedListener listener) {
		pageChangeListeners.remove(listener);
	}

	private void firePageChanged(final PageChangedEvent event) {
		for (final IPageChangedListener l : pageChangeListeners) {
			SafeRunnable.run(new SafeRunnable() {
				@Override
				public void run() {
					l.pageChanged(event);
				}
			});
		}
	}
}