/**
 */
package nl.esi.pps.tmsc.presentation;

import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.edit.ui.action.ValidateAction;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.BaseSelectionListenerAction;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

import nl.esi.pps.common.emf.ui.action.BookmarkActionBarContributor;

/**
 * This is the action bar contributor for the Tmsc model editor.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated NOT
 */
public class TmscActionBarContributor extends BookmarkActionBarContributor implements ISelectionChangedListener {
	/**
	 * This keeps track of the active editor.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IEditorPart activeEditorPart;

	/**
	 * This keeps track of the current selection provider.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ISelectionProvider selectionProvider;

	/**
	 * This action opens the Properties view.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IAction showPropertiesViewAction = new Action(
			TmscEditorPlugin.INSTANCE.getString("_UI_ShowPropertiesView_menu_item")) {
		@Override
		public void run() {
			try {
				getPage().showView("org.eclipse.ui.views.PropertySheet");
			} catch (PartInitException exception) {
				TmscEditorPlugin.INSTANCE.log(exception);
			}
		}
	};

	/**
	 * This action refreshes the viewer of the current editor if the editor
	 * implements {@link org.eclipse.emf.common.ui.viewer.IViewerProvider}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IAction refreshViewerAction = new Action(
			TmscEditorPlugin.INSTANCE.getString("_UI_RefreshViewer_menu_item")) {
		@Override
		public boolean isEnabled() {
			return activeEditorPart instanceof IViewerProvider;
		}

		@Override
		public void run() {
			if (activeEditorPart instanceof IViewerProvider) {
				Viewer viewer = ((IViewerProvider) activeEditorPart).getViewer();
				if (viewer != null) {
					viewer.refresh();
				}
			}
		}
	};

	protected SelectInOutlineViewAction selectInOutlineViewAction = new SelectInOutlineViewAction();

	/**
	 * This creates an instance of the contributor.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public TmscActionBarContributor() {
		super(SWT.NONE);
		validateAction = new ValidateAction();
	}

	/**
	 * This adds Separators for editor additions to the tool bar.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void contributeToToolBar(IToolBarManager toolBarManager) {
		super.contributeToToolBar(toolBarManager);
		toolBarManager.add(new Separator("tmsc-settings"));
		toolBarManager.add(new Separator("tmsc-additions"));
	}

	/**
	 * This adds to the menu bar a menu and some separators for editor additions,
	 * as well as the sub-menus for object creation items.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void contributeToMenu(IMenuManager menuManager) {
		super.contributeToMenu(menuManager);

		IMenuManager submenuManager = new MenuManager(TmscEditorPlugin.INSTANCE.getString("_UI_TmscEditor_menu"),
				"nl.esi.pps.tmscMenuID");
		menuManager.insertAfter("additions", submenuManager);
		submenuManager.add(new Separator("settings"));
		submenuManager.add(new Separator("actions"));
		submenuManager.add(new Separator("additions"));
		submenuManager.add(new Separator("additions-end"));

		// Add your contributions.
		// Ensure that you remove @generated or mark it @generated NOT

		addGlobalActions(submenuManager);
	}

	/**
	 * When the active editor changes, this remembers the change and registers with it as a selection provider.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setActiveEditor(IEditorPart part) {
		super.setActiveEditor(part);
		activeEditorPart = part;

		// Switch to the new selection provider.
		//
		if (selectionProvider != null) {
			selectionProvider.removeSelectionChangedListener(this);
		}
		if (part == null) {
			selectionProvider = null;
		} else {
			selectionProvider = part.getSite().getSelectionProvider();
			selectionProvider.addSelectionChangedListener(this);

			// Fake a selection changed event to update the menus.
			//
			if (selectionProvider.getSelection() != null) {
				selectionChanged(new SelectionChangedEvent(selectionProvider, selectionProvider.getSelection()));
			}
		}
	}

	@Override
	public TmscEditor getActiveEditor() {
		return (TmscEditor) super.getActiveEditor();
	}

	/**
	 * This implements {@link org.eclipse.jface.viewers.ISelectionChangedListener},
	 * handling {@link org.eclipse.jface.viewers.SelectionChangedEvent}s by querying for the children and siblings
	 * that can be added to the selected object and updating the menus accordingly.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		// Add your contributions.
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * This populates the pop-up menu before it appears.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void menuAboutToShow(IMenuManager menuManager) {
		// Add our standard marker.
		//
		if ((style & ADDITIONS_LAST_STYLE) == 0) {
			menuManager.add(new Separator("additions"));
		}
		menuManager.add(new Separator("edit"));

		// Add the edit menu actions.
		//
		menuManager.add(new ActionContributionItem(undoAction));
		menuManager.add(new ActionContributionItem(redoAction));
		menuManager.add(new Separator());
		menuManager.add(new ActionContributionItem(deleteAction));
		menuManager.add(new Separator());

		if ((style & ADDITIONS_LAST_STYLE) != 0) {
			menuManager.add(new Separator("additions"));
			menuManager.add(new Separator());
		}
		// Add our other standard marker.
		//
		menuManager.add(new Separator("additions-end"));

		addGlobalActions(menuManager);
	}

	/**
	 * This inserts global actions before the "additions-end" separator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private void addGlobalActionsGen(IMenuManager menuManager) {
		menuManager.insertAfter("additions-end", new Separator("ui-actions"));
		menuManager.insertAfter("ui-actions", showPropertiesViewAction);

		refreshViewerAction.setEnabled(refreshViewerAction.isEnabled());
		menuManager.insertAfter("ui-actions", refreshViewerAction);

		super.addGlobalActions(menuManager);
	}

	@Override
	protected void addGlobalActions(IMenuManager menuManager) {
		addGlobalActionsGen(menuManager);

		menuManager.insertAfter("ui-actions", selectInOutlineViewAction);
	}

	/**
	 * This ensures that a delete action will clean up all references to deleted objects.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean removeAllReferencesOnDelete() {
		return true;
	}

	@Override
	public void activate() {
		super.activate();

		getActiveEditor().addSelectionChangedListener(selectInOutlineViewAction);
	}

	@Override
	public void deactivate() {
		getActiveEditor().removeSelectionChangedListener(selectInOutlineViewAction);

		super.deactivate();
	}

	@Override
	public void update() {
		super.update();

		ISelection selection = getActiveEditor().getSelection();
		IStructuredSelection structuredSelection = selection instanceof IStructuredSelection
				? (IStructuredSelection) selection
				: StructuredSelection.EMPTY;
		selectInOutlineViewAction.updateSelection(structuredSelection);
	}

	protected class SelectInOutlineViewAction extends BaseSelectionListenerAction {
		public SelectInOutlineViewAction() {
			super(TmscEditorPlugin.INSTANCE.getString("_UI_SelectInOutlineView_menu_item"));
		}

		protected boolean updateSelection(IStructuredSelection selection) {
			return !selection.isEmpty() && isActivePart(getActiveEditor())
					&& getActiveEditor().getContentOutlinePage().getSite() != null;
		}

		@Override
		public void run() {
			IContentOutlinePage contentOutlinePage = getActiveEditor().getContentOutlinePage();
			contentOutlinePage.setSelection(getStructuredSelection());
		}
	};
}
