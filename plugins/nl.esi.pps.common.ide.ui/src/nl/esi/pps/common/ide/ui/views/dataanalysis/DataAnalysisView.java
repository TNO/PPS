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

import java.util.UUID;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.resource.ResourceLocator;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.IPage;
import org.eclipse.ui.part.MessagePage;
import org.eclipse.ui.part.PageBook;
import org.eclipse.ui.part.PageBookView;
import org.eclipse.ui.views.properties.PinPropertySheetAction;

import nl.esi.pps.common.ide.ui.Activator;

public class DataAnalysisView extends PageBookView {
	public static final String ID = "nl.esi.pps.common.view.data-analysis";

	public static final String GROUP_VIEW = "view-actions";
	public static final String GROUP_VIEW_END = "view-actions-end";
	
	/**
	 * Message to show on the default page.
	 */
	private String defaultText = "No Data Analysis available";

	/**
	 * Whether this data view instance is pinned or not
	 */
	private IAction pinAction;

	/**
	 * Action to show another data analysis view
	 */
	private Action cloneViewAction = new Action("New Data Analysis View",
			ResourceLocator.imageDescriptorFromBundle(DataAnalysisView.class, "icons/new.png").orElse(null)) {
		@Override
		public void run() {
			try {
				DataAnalysisView.this.getSite().getPage().showView(DataAnalysisView.ID, UUID.randomUUID().toString(),
						IWorkbenchPage.VIEW_VISIBLE);
			} catch (PartInitException e) {
				Activator.getDefault().getLog()
						.log(new Status(IStatus.ERROR, Activator.getDefault().getBundle().getSymbolicName(),
								"Failed to initialize viewer: " + e.getMessage(), e));
			}
		}
	};

	public DataAnalysisView() {
		super();
	}

	@Override
	public void init(IViewSite site) throws PartInitException {
		super.init(site);

		pinAction = new PinPropertySheetAction();
		pinAction.setEnabled(false);
		pinAction.addPropertyChangeListener(event -> {
			if (IAction.CHECKED.equals(event.getProperty())) {
				boolean pinned = (boolean) event.getNewValue();
				// Forward to the page
				((IDataAnalysisPage) getCurrentPage()).setPinned(pinned);
				if (!pinned) {
					// Refresh page to switch to current editor
					partActivated(getSite().getPage().getActiveEditor());
				}
			}
		});

		cloneViewAction.setToolTipText("Opens another Data Analysis view.");
		IActionBars actionBars = site.getActionBars();
		Separator groupView = new Separator(GROUP_VIEW);
		groupView.setVisible(false);
		Separator groupViewEnd = new Separator(GROUP_VIEW_END);
		groupViewEnd.setVisible(false);
		
		actionBars.getMenuManager().add(groupView);
		actionBars.getMenuManager().add(groupViewEnd);
		actionBars.getMenuManager().insertBefore(GROUP_VIEW_END, pinAction);
		actionBars.getMenuManager().insertBefore(GROUP_VIEW_END, cloneViewAction);
		actionBars.getToolBarManager().add(groupView);
		actionBars.getToolBarManager().add(groupViewEnd);
		actionBars.getToolBarManager().insertBefore(GROUP_VIEW_END, pinAction);
		actionBars.getToolBarManager().insertBefore(GROUP_VIEW_END, cloneViewAction);
	}

	@Override
	protected IPage createDefaultPage(PageBook book) {
		MessagePage page = new MessagePage();
		initPage(page);
		page.createControl(book);
		page.setMessage(defaultText);
		return page;
	}

	@Override
	protected PageRec doCreatePage(IWorkbenchPart part) {
		IDataAnalysisPage page = Adapters.adapt(part, IDataAnalysisPage.class);
		if (page != null) {
			initPage(page);
			page.createControl(getPageBook());
			return new PageRec(part, page);
		}
		return null;
	}

	@Override
	protected void doDestroyPage(IWorkbenchPart part, PageRec pageRecord) {
		IDataAnalysisPage page = (IDataAnalysisPage) pageRecord.page;
		page.dispose();
		pageRecord.dispose();
	}

	@Override
	protected IWorkbenchPart getBootstrapPart() {
		IWorkbenchPage page = getSite().getPage();
		if (page != null) {
			return page.getActiveEditor();
		}
		return null;
	}

	@Override
	public void partClosed(IWorkbenchPart part) {
		if (isPinned() && getCurrentContributingPart() == part) {
			pinAction.setChecked(false);
		}
		super.partClosed(part);
	}
	
	@Override
	protected void partHidden(IWorkbenchPart part) {
		// Probably a bug in PageBook page is refreshed when part is hidden
		if (!isPinned()) {
			super.partHidden(part);
		}
	}
	
	@Override
	protected void showPageRec(PageRec pageRec) {
		boolean pinSupported = pageRec != null && pageRec.page instanceof IDataAnalysisPage;
		pinAction.setEnabled(pinSupported);
		super.showPageRec(pageRec);
	}
	
	@Override
	protected boolean isImportant(IWorkbenchPart part) {
		// We only care about editors, as long as we are not pinned
		return (part instanceof IEditorPart) && !isPinned();
	}
	
	public boolean isPinned() {
		return pinAction != null && pinAction.isChecked();
	}
}
