/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.emf.ui.views.contentoutline;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.part.Page;
import org.eclipse.ui.progress.WorkbenchJob;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

import nl.esi.pps.common.emf.ui.Activator;

/**
 * An abstract base class for content outline pages.
 * <p>
 * Clients who are defining an editor may elect to provide a corresponding
 * content outline page. This content outline page will be presented to the
 * user via the standard Content Outline View (the user decides whether their
 * workbench window contains this view) whenever that editor is active.
 * This class should be subclassed.
 * </p>
 * <p>
 * Internally, each content outline page consists of a standard tree viewer;
 * selections made in the tree viewer are reported as selection change events
 * by the page (which is a selection provider). The tree viewer is not created
 * until <code>createPage</code> is called; consequently, subclasses must extend
 * <code>createControl</code> to configure the tree viewer with a proper content
 * provider, label provider, and input element.
 * </p>
 * <p>Subclasses may provide a hint for constructing the tree viewer
 * using {@link #getTreeStyle()}.</p>
 * <p>
 * Note that those wanting to use a control other than internally created
 * <code>TreeViewer</code> will need to implement
 * <code>IContentOutlinePage</code> directly rather than subclassing this class.
 * </p>
 */
public abstract class FilteredContentOutlinePage extends Page implements IContentOutlinePage, ISelectionChangedListener {
    private final ListenerList<ISelectionChangedListener> selectionChangedListeners = new ListenerList<>();

    private final PatternFilter patternFilter;
    
    protected OptimizedFilteredTree filteredTree;

    /**
     * Create a new content outline page.
     */
    protected FilteredContentOutlinePage() {
        this(new PatternFilter());
        this.patternFilter.setIncludeLeadingWildcard(true);
    }

    /**
     * Create a new content outline page.
     */
    protected FilteredContentOutlinePage(PatternFilter patternFilter) {
    	this.patternFilter = patternFilter;
    }

    @Override
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
        selectionChangedListeners.add(listener);
    }

    /**
     * The <code>ContentOutlinePage</code> implementation of this
     * <code>IContentOutlinePage</code> method creates a tree viewer. Subclasses
     * must extend this method configure the tree viewer with a proper content
     * provider, label provider, and input element.
     * @param parent
     */
    @Override
	public void createControl(Composite parent) {
        filteredTree = new OptimizedFilteredTree(parent, getTreeStyle(), patternFilter, true, true, 500);
        filteredTree.getViewer().addSelectionChangedListener(this);
    }

	/**
	 * A hint for the styles to use while constructing the TreeViewer.
	 * <p>Subclasses may override.</p>
	 *
	 * @return the tree styles to use. By default, SWT.MULTI | SWT.H_SCROLL |
	 *         SWT.V_SCROLL
	 * @since 3.6
	 */
	protected int getTreeStyle() {
		return SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL;
	}

    /**
     * Fires a selection changed event.
     *
     * @param selection the new selection
     */
    protected void fireSelectionChanged(ISelection selection) {
        // create an event
        final SelectionChangedEvent event = new SelectionChangedEvent(this,
                selection);

        // fire the event
        Object[] listeners = selectionChangedListeners.getListeners();
        for (Object listener : listeners) {
            final ISelectionChangedListener l = (ISelectionChangedListener) listener;
            SafeRunner.run(new SafeRunnable() {
                @Override
				public void run() {
                    l.selectionChanged(event);
                }
            });
        }
    }

    @Override
	public FilteredTree getControl() {
        return filteredTree;
    }
    
    @Override
	public ISelection getSelection() {
        if (filteredTree == null) {
			return StructuredSelection.EMPTY;
		}
        return filteredTree.getViewer().getSelection();
    }

    protected OptimizedFilteredTree getFilteredTree() {
    	return filteredTree;
    }

    /**
     * Returns this page's tree viewer.
     *
     * @return this page's tree viewer, or <code>null</code> if
     *   <code>createControl</code> has not been called yet
     */
    protected TreeViewer getTreeViewer() {
        return null == filteredTree ? null : filteredTree.getViewer();
    }

    @Override
	public void init(IPageSite pageSite) {
        super.init(pageSite);
        pageSite.setSelectionProvider(this);
    }

    @Override
	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
        selectionChangedListeners.remove(listener);
    }

    @Override
	public void selectionChanged(SelectionChangedEvent event) {
        fireSelectionChanged(event.getSelection());
    }

    /**
     * Sets focus to a part in the page.
     */
    @Override
	public void setFocus() {
        if (filteredTree != null) {
        	filteredTree.setFocus();
        }
    }

    @Override
	public void setSelection(ISelection selection) {
        if (filteredTree != null) {
			filteredTree.getViewer().setSelection(selection);
		}
    }
    
    @Override
    public void makeContributions(IMenuManager menuManager, IToolBarManager toolBarManager, IStatusLineManager statusLineManager) {
    	super.makeContributions(menuManager, toolBarManager, statusLineManager);
    	
    	toolBarManager.add(new Action("Collapse All",
    			Activator.getDescriptor(Activator.IMAGE_COLLAPSE_ALL)) {
    		@Override
			public boolean isEnabled() {
				return filteredTree.getViewer().getAutoExpandLevel() != TreeViewer.ALL_LEVELS;
			}
    		
    		@Override
    		public void run() {
    			TreeViewer treeViewer = filteredTree.getViewer();
				treeViewer.collapseAll();
    			if (treeViewer.getAutoExpandLevel() != 0) {
    				treeViewer.expandToLevel(treeViewer.getAutoExpandLevel());
    			}
    		}
		});
    }
    
    public void clearFilter() {
    	getFilteredTree().clearText();
    }
    
	protected static class OptimizedFilteredTree extends FilteredTree {
		protected WorkbenchJob refreshJob;
		protected long refreshJobDelay;
		protected boolean refreshEnabled = true;

		/**
		 * @see FilteredTree#FilteredTree(Composite, int, PatternFilter, boolean)
		 * @deprecated use {@link OptimizedFilteredTree#OptimizedFilteredTree(Composite, int, PatternFilter, boolean, boolean, long)}
		 */
		@Deprecated
		public OptimizedFilteredTree(Composite parent, int treeStyle, PatternFilter filter, boolean useNewLook, long refreshJobDelay) {
			super(parent, treeStyle, filter, useNewLook);
			this.refreshJobDelay = refreshJobDelay;
		}

		/** @see FilteredTree#FilteredTree(Composite, int, PatternFilter, boolean, boolean) */
		public OptimizedFilteredTree(Composite parent, int treeStyle, PatternFilter filter, boolean useNewLook, boolean useFastHashLookup, long refreshJobDelay) {
			super(parent, treeStyle, filter, useNewLook, useFastHashLookup);
			this.refreshJobDelay = refreshJobDelay;
		}

		@Override
		protected final long getRefreshJobDelay() {
			/*
			 * TODO refesh delay is used for all textchange events in FilteredTree. This delay should only be used when
			 * typing; requires patches in FilteredTree.
			 */
			return refreshJobDelay;
		}

		@Override
		protected WorkbenchJob doCreateRefreshJob() {
			final WorkbenchJob delegateJob = super.doCreateRefreshJob();
			refreshJob = new WorkbenchJob(delegateJob.getDisplay(), delegateJob.getName()) {
				@Override
				public IStatus runInUIThread(IProgressMonitor monitor) {
					return delegateJob.runInUIThread(monitor);
				}

				@Override
				public boolean shouldSchedule() {
					return refreshEnabled;
				}
			};
			return refreshJob;
		}

		@Override
		protected void clearText() {
			// We take care of the refresh ourself
			refreshEnabled = false;
			try {
				super.clearText();
				refreshFilterNow();
			} finally {
				refreshEnabled = true;
			}
		}
		
		protected void refreshFilterNow() {
			Display display = refreshJob.getDisplay();
			if (null != display && !display.isDisposed()) {
				display.syncExec(() -> refreshJob.runInUIThread(null));
			}
		}
	}
}
