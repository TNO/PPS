/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.ide.ui.part;

import static org.eclipse.swt.events.SelectionListener.widgetSelectedAdapter;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.jface.dialogs.IPageChangeProvider;
import org.eclipse.jface.dialogs.IPageChangedListener;
import org.eclipse.jface.dialogs.PageChangedEvent;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartService;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.part.PageSwitcher;
import org.eclipse.ui.part.ViewPart;

/**
 * A multi-page view-part is a view with multiple pages, each of which may
 * contain an arbitrary SWT control.
 * <p>
 * Subclasses must implement the following method: <code>createPages</code> - to
 * create the required pages by calling one of the <code>addPage</code> methods.
 * </p>
 * <p>
 * <b>NOTE:</b> This class is basically a copy of {@link MultiPageEditorPart}
 * and adapted to be a {@link ViewPart}. Keep this in mind for licensing issues.
 * </p>
 * 
 * @see MultiPageEditorPart
 */
public abstract class MultiPageViewPart extends ViewPart implements IPageChangeProvider {
	private static final String COMMAND_NEXT_SUB_TAB = "org.eclipse.ui.navigate.nextSubTab";
	private static final String COMMAND_PREVIOUS_SUB_TAB = "org.eclipse.ui.navigate.previousSubTab";

	/**
	 * The container widget.
	 */
	private CTabFolder container;

	private ListenerList<IPageChangedListener> pageChangeListeners = new ListenerList<>(ListenerList.IDENTITY);

	/**
	 * Creates an empty multi-page view-part with no pages.
	 */
	protected MultiPageViewPart() {
		super();
	}

	/**
	 * Creates and adds a new page containing the given control to this multi-page
	 * editor. The control may be <code>null</code>, allowing it to be created and
	 * set later using <code>setControl</code>.
	 *
	 * @param control
	 *            the control, or <code>null</code>
	 * @return the index of the new page
	 *
	 * @see MultiPageEditorPart#setControl(int, Control)
	 */
	public int addPage(Control control) {
		int index = getPageCount();
		addPage(index, control);
		return index;
	}

	/**
	 * Creates and adds a new page containing the given control to this multi-page
	 * editor. The page is added at the given index. The control may be
	 * <code>null</code>, allowing it to be created and set later using
	 * <code>setControl</code>.
	 *
	 * @param index
	 *            the index at which to add the page (0-based)
	 * @param control
	 *            the control, or <code>null</code>
	 *
	 * @see MultiPageEditorPart#setControl(int, Control)
	 */
	public void addPage(int index, Control control) {
		createItem(index, control);
	}

	/**
	 * Creates an empty container. Creates a CTabFolder with no style bits set, and
	 * hooks a selection listener which calls <code>pageChange()</code> whenever the
	 * selected tab changes.
	 *
	 * @param parent
	 *            The composite in which the container tab folder should be created;
	 *            must not be <code>null</code>.
	 * @return a new container
	 */
	private CTabFolder createContainer(Composite parent) {
		// use SWT.FLAT style so that an extra 1 pixel border is not reserved
		// inside the folder
		parent.setLayout(new FillLayout());
		final CTabFolder newContainer = new CTabFolder(parent, SWT.BOTTOM | SWT.FLAT);
		newContainer.addSelectionListener(widgetSelectedAdapter(e -> {
			int newPageIndex = newContainer.indexOf((CTabItem) e.item);
			pageChange(newPageIndex);
		}));
		newContainer.addTraverseListener(e -> {
			switch (e.detail) {
			case SWT.TRAVERSE_PAGE_NEXT:
			case SWT.TRAVERSE_PAGE_PREVIOUS:
				int detail = e.detail;
				e.doit = true;
				e.detail = SWT.TRAVERSE_NONE;
				Control control = newContainer.getParent();
				do {
					if (control.traverse(detail))
						return;
					if (control.getListeners(SWT.Traverse).length != 0)
						return;
					if (control instanceof Shell)
						return;
					control = control.getParent();
				} while (control != null);
			}
		});
		return newContainer;
	}

	/**
	 * Creates a tab item at the given index and places the given control in the new
	 * item. The item is a CTabItem with no style bits set.
	 *
	 * @param index
	 *            the index at which to add the control
	 * @param control
	 *            is the control to be placed in an item
	 * @return a new item
	 */
	private CTabItem createItem(int index, Control control) {
		CTabItem item = new CTabItem(getTabFolder(), SWT.NONE, index);
		item.setControl(control);
		return item;
	}

	/**
	 * Creates the pages of this multi-page editor.
	 * <p>
	 * Subclasses must implement this method.
	 * </p>
	 */
	protected abstract void createPages();

	/**
	 * The <code>MultiPageEditor</code> implementation of this
	 * <code>IWorkbenchPart</code> method creates the control for the multi-page
	 * editor by calling <code>createContainer</code>, then
	 * <code>createPages</code>. Subclasses should implement
	 * <code>createPages</code> rather than overriding this method.
	 *
	 * @param parent
	 *            The parent in which the editor should be created; must not be
	 *            <code>null</code>.
	 */
	@Override
	public final void createPartControl(Composite parent) {
		Composite pageContainer = createPageContainer(parent);
		this.container = createContainer(pageContainer);
		createPages();
		// set the active page (page 0 by default), unless it has already been
		// done
		if (getActivePage() == -1) {
			setActivePage(0);
		}
		initializePageSwitching();
		initializeSubTabSwitching();
	}

	/**
	 * Initialize the MultiPageEditorPart to use the page switching command. Clients
	 * can override this method with an empty body if they wish to opt-out.
	 *
	 * @since 3.4
	 */
	protected void initializePageSwitching() {
		new PageSwitcher(this) {
			@Override
			public Object[] getPages() {
				int pageCount = getPageCount();
				Object[] result = new Object[pageCount];
				for (int i = 0; i < pageCount; i++) {
					result[i] = Integer.valueOf(i);
				}
				return result;
			}

			@Override
			public String getName(Object page) {
				return getPageText(((Integer) page).intValue());
			}

			@Override
			public ImageDescriptor getImageDescriptor(Object page) {
				Image image = getPageImage(((Integer) page).intValue());
				if (image == null)
					return null;

				return ImageDescriptor.createFromImage(image);
			}

			@Override
			public void activatePage(Object page) {
				setActivePage(((Integer) page).intValue());
			}

			@Override
			public int getCurrentPageIndex() {
				return getActivePage();
			}
		};
	}

	/**
	 * Initialize the MultiPageEditorPart to use the sub-tab switching commands.
	 *
	 * @since 3.5
	 */
	private void initializeSubTabSwitching() {
		IHandlerService service = getSite().getService(IHandlerService.class);
		service.activateHandler(COMMAND_NEXT_SUB_TAB, new AbstractHandler() {
			/**
			 * {@inheritDoc}
			 * 
			 * @throws ExecutionException
			 *             if an exception occurred during execution
			 */
			@Override
			public Object execute(ExecutionEvent event) throws ExecutionException {
				int n = getPageCount();
				if (n == 0)
					return null;

				int i = getActivePage() + 1;
				if (i >= n)
					i = 0;
				setActivePage(i);
				return null;
			}
		});

		service.activateHandler(COMMAND_PREVIOUS_SUB_TAB, new AbstractHandler() {
			/**
			 * {@inheritDoc}
			 * 
			 * @throws ExecutionException
			 *             if an exception occurred during execution
			 */
			@Override
			public Object execute(ExecutionEvent event) throws ExecutionException {
				int n = getPageCount();
				if (n == 0)
					return null;

				int i = getActivePage() - 1;
				if (i < 0)
					i = n - 1;
				setActivePage(i);
				return null;
			}
		});
	}

	/**
	 * Creates the parent control for the container returned by
	 * {@link #getContainer() }.
	 *
	 * <p>
	 * Subclasses may extend and must call super implementation first.
	 * </p>
	 *
	 * @param parent
	 *            the parent for all of the editors contents.
	 * @return the parent for this editor's container. Must not be
	 *         <code>null</code>.
	 *
	 * @since 3.2
	 */
	protected Composite createPageContainer(Composite parent) {
		return parent;
	}

	/**
	 * The <code>MultiPageEditorPart</code> implementation of this
	 * <code>IWorkbenchPart</code> method disposes all nested editors. Subclasses
	 * may extend.
	 */
	@Override
	public void dispose() {
		pageChangeListeners.clear();
		super.dispose();
	}

	/**
	 * Returns the index of the currently active page, or -1 if there is no active
	 * page.
	 * <p>
	 * Subclasses should not override this method
	 * </p>
	 *
	 * @nooverride
	 *
	 * @return the index of the active page, or -1 if there is no active page
	 * @since 3.5
	 */
	public int getActivePage() {
		CTabFolder tabFolder = getTabFolder();
		if (tabFolder != null && !tabFolder.isDisposed()) {
			return tabFolder.getSelectionIndex();
		}
		return -1;
	}

	/**
	 * Returns the composite control containing this multi-page editor's pages. This
	 * should be used as the parent when creating controls for the individual pages.
	 * That is, when calling <code>addPage(Control)</code>, the passed control
	 * should be a child of this container.
	 * <p>
	 * Warning: Clients should not assume that the container is any particular
	 * subclass of Composite. The actual class used may change in order to improve
	 * the look and feel of multi-page editors. Any code making assumptions on the
	 * particular subclass would thus be broken.
	 * </p>
	 * <p>
	 * Subclasses should not override this method
	 * </p>
	 *
	 * @return the composite, or <code>null</code> if <code>createPartControl</code>
	 *         has not been called yet
	 */
	protected Composite getContainer() {
		return container;
	}

	/**
	 * Returns the control for the given page index, or <code>null</code> if no
	 * control has been set for the page. The page index must be valid.
	 * <p>
	 * Subclasses should not override this method
	 * </p>
	 *
	 * @param pageIndex
	 *            the index of the page
	 * @return the control for the specified page, or <code>null</code> if none has
	 *         been set
	 */
	protected Control getControl(int pageIndex) {
		return getItem(pageIndex).getControl();
	}

	/**
	 * Returns the tab item for the given page index (page index is 0-based). The
	 * page index must be valid.
	 *
	 * @param pageIndex
	 *            the index of the page
	 * @return the tab item for the given page index
	 */
	private CTabItem getItem(int pageIndex) {
		return getTabFolder().getItem(pageIndex);
	}

	/**
	 * Returns the number of pages in this multi-page editor.
	 *
	 * @return the number of pages
	 */
	protected int getPageCount() {
		CTabFolder folder = getTabFolder();
		// May not have been created yet, or may have been disposed.
		if (folder != null && !folder.isDisposed()) {
			return folder.getItemCount();
		}
		return 0;
	}

	/**
	 * Returns the image for the page with the given index, or <code>null</code> if
	 * no image has been set for the page. The page index must be valid.
	 *
	 * @param pageIndex
	 *            the index of the page
	 * @return the image, or <code>null</code> if none
	 */
	protected Image getPageImage(int pageIndex) {
		return getItem(pageIndex).getImage();
	}

	/**
	 * Returns the text label for the page with the given index. Returns the empty
	 * string if no text label has been set for the page. The page index must be
	 * valid.
	 *
	 * @param pageIndex
	 *            the index of the page
	 * @return the text label for the page
	 */
	protected String getPageText(int pageIndex) {
		return getItem(pageIndex).getText();
	}

	/**
	 * Returns the data for the given page index, or <code>null</code> if no control
	 * has been set for the page. The page index must be valid.
	 * <p>
	 * Subclasses should not override this method
	 * </p>
	 *
	 * @param pageIndex
	 *            the index of the page
	 * @return the data for the specified page, or <code>null</code> if none has
	 *         been set
	 */
	protected Object getPageData(int pageIndex) {
		return getItem(pageIndex).getData();
	}

	/**
	 * Returns the tab folder containing this multi-page editor's pages.
	 *
	 * @return the tab folder, or <code>null</code> if
	 *         <code>createPartControl</code> has not been called yet
	 */
	private CTabFolder getTabFolder() {
		return container;
	}

	/**
	 * Handles a property change notification from a nested editor. The default
	 * implementation simply forwards the change to listeners on this multi-page
	 * editor by calling <code>firePropertyChange</code> with the same property id.
	 * For example, if the dirty state of a nested editor changes (property id
	 * <code>IEditorPart.PROP_DIRTY</code>), this method handles it by firing a
	 * property change event for <code>IEditorPart.PROP_DIRTY</code> to property
	 * listeners on this multi-page editor.
	 * <p>
	 * Subclasses may extend or reimplement this method.
	 * </p>
	 *
	 * @param propertyId
	 *            the id of the property that changed
	 */
	protected void handlePropertyChange(int propertyId) {
		firePropertyChange(propertyId);
	}

	/**
	 * Notifies this multi-page editor that the page with the given id has been
	 * activated. This method is called when the user selects a different tab.
	 * <p>
	 * The <code>MultiPageEditorPart</code> implementation of this method sets focus
	 * to the new page, and notifies the action bar contributor (if there is one).
	 * This checks whether the action bar contributor is an instance of
	 * <code>MultiPageEditorActionBarContributor</code>, and, if so, calls
	 * <code>setActivePage</code> with the active nested editor. This also fires a
	 * selection change event if required.
	 * </p>
	 * <p>
	 * Subclasses may extend this method.
	 * </p>
	 *
	 * @param newPageIndex
	 *            the index of the activated page
	 */
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

	/**
	 * Removes the page with the given index from this multi-page editor. The
	 * controls for the page are disposed of; if the page has an editor, it is
	 * disposed of too. The page index must be valid.
	 *
	 * @param pageIndex
	 *            the index of the page
	 * @see MultiPageEditorPart#addPage(Control)
	 * @see MultiPageEditorPart#addPage(IEditorPart, IEditorInput)
	 */
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
	 * Sets the currently active page.
	 *
	 * @param pageIndex
	 *            the index of the page to be activated; the index must be valid
	 */
	protected void setActivePage(int pageIndex) {
		Assert.isTrue(pageIndex >= 0 && pageIndex < getPageCount());
		getTabFolder().setSelection(pageIndex);
		pageChange(pageIndex);
	}

	/**
	 * Sets the control for the given page index. The page index must be valid.
	 *
	 * @param pageIndex
	 *            the index of the page
	 * @param control
	 *            the control for the specified page, or <code>null</code> to clear
	 *            the control
	 */
	protected void setControl(int pageIndex, Control control) {
		getItem(pageIndex).setControl(control);
	}

	/**
	 * The <code>MultiPageEditor</code> implementation of this
	 * <code>IWorkbenchPart</code> method sets focus on the active nested editor, if
	 * there is one.
	 * <p>
	 * Subclasses may extend or reimplement.
	 * </p>
	 */
	@Override
	public void setFocus() {
		setFocus(getActivePage());
	}

	/**
	 * Sets focus to the control for the given page. If the page has an editor, this
	 * calls its <code>setFocus()</code> method. Otherwise, this calls
	 * <code>setFocus</code> on the control for the page.
	 *
	 * @param pageIndex
	 *            the index of the page
	 */
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

	/**
	 * Sets the image for the page with the given index, or <code>null</code> to
	 * clear the image for the page. The page index must be valid.
	 *
	 * @param pageIndex
	 *            the index of the page
	 * @param image
	 *            the image, or <code>null</code>
	 */
	protected void setPageImage(int pageIndex, Image image) {
		getItem(pageIndex).setImage(image);
	}

	/**
	 * Sets the text label for the page with the given index. The page index must be
	 * valid. The text label must not be null.
	 *
	 * @param pageIndex
	 *            the index of the page
	 * @param text
	 *            the text label
	 */
	protected void setPageText(int pageIndex, String text) {
		getItem(pageIndex).setText(text);
	}

	/**
	 * Sets the data for the page with the given index. The page index must be
	 * valid.
	 *
	 * @param pageIndex
	 *            the index of the page
	 * @param data
	 *            the data
	 */
	protected void setPageData(int pageIndex, Object data) {
		getItem(pageIndex).setData(data);
	}

	/**
	 * Returns the selected page for the current active page index, the Control for
	 * other pages.
	 * <p>
	 * <b>Note:</b> clients may override this method to return a page appropriate
	 * for their editors. Maybe be <code>null</code>.
	 * </p>
	 *
	 * @return The Control representing the current active page, or
	 *         <code>null</code> if there are no active pages.
	 * @since 3.5
	 * @see #getActivePage()
	 */
	@Override
	public Object getSelectedPage() {
		int index = getActivePage();
		if (index == -1) {
			return null;
		}
		return getControl(index);
	}

	/**
	 * Add the page change listener to be notified when the page changes. The newly
	 * selected page will be the Object returned from {@link #getSelectedPage()}. In
	 * the default case, this will be the active page Control, IEditorPart, or
	 * <code>null</code>.
	 * <p>
	 * This method has no effect if the listener has already been added.
	 * </p>
	 *
	 * @nooverride
	 *
	 * @since 3.5
	 */
	@Override
	public void addPageChangedListener(IPageChangedListener listener) {
		pageChangeListeners.add(listener);
	}

	/**
	 * Remove the page change listener.
	 * <p>
	 * This method has no effect if the listener is not in the list.
	 * </p>
	 *
	 * @nooverride
	 *
	 * @since 3.5
	 */
	@Override
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
