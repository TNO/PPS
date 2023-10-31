/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.ui.perspective;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import nl.esi.pps.common.ide.ui.views.dataanalysis.DataAnalysisView;

public class PPSPerspectiveFactory implements IPerspectiveFactory {
	public static final String ID = "nl.esi.pps.ui.perspective";

	private static final String ID_ERROR_LOG = "org.eclipse.pde.runtime.LogView";
	private static final String ID_BOTTOM_CENTER_FOLDER = "nl.esi.pps.ui.perspective.bottom.center";
	private static final String ID_BOTTOM_RIGHT_FOLDER = "nl.esi.pps.ui.perspective.bottom.right";

	private static final String ID_VIEW_PLANT_UML = "net.sourceforge.plantuml.eclipse.views.PlantUmlView";
	
	@Override
	public void createInitialLayout(IPageLayout layout) {
		defineActions(layout);
		defineLayout(layout);
	}

	/**
	 * add items and actions set to the window
	 * 
	 * @param layout layout of the perspective
	 */
	private void defineActions(final IPageLayout layout) {
		// Show view shortcuts
		layout.addShowViewShortcut(IPageLayout.ID_PROJECT_EXPLORER);
		layout.addShowViewShortcut(IPageLayout.ID_BOOKMARKS);
		layout.addShowViewShortcut(IPageLayout.ID_OUTLINE);
		layout.addShowViewShortcut(IPageLayout.ID_PROP_SHEET);
		layout.addShowViewShortcut(IPageLayout.ID_PROBLEM_VIEW);
		layout.addShowViewShortcut(DataAnalysisView.ID);
		layout.addShowViewShortcut(ID_ERROR_LOG);
	}

	/**
	 * add views to the layout
	 * 
	 * @param layout layout of the perspective
	 */
	private void defineLayout(final IPageLayout layout) {
		final String editorArea = layout.getEditorArea();
		layout.addView(IPageLayout.ID_PROJECT_EXPLORER, IPageLayout.LEFT, 0.26f, editorArea);
		layout.addView(IPageLayout.ID_BOOKMARKS, IPageLayout.BOTTOM, 0.40f, IPageLayout.ID_PROJECT_EXPLORER);
		layout.addView(IPageLayout.ID_OUTLINE, IPageLayout.BOTTOM, 0.33f, IPageLayout.ID_BOOKMARKS);

		// Place problem, properties and advance views to bottom of editor area.
		final IFolderLayout bottomCenter = layout.createFolder(ID_BOTTOM_CENTER_FOLDER, IPageLayout.BOTTOM, 0.66f,
				editorArea);
		bottomCenter.addView(IPageLayout.ID_PROP_SHEET);
		bottomCenter.addView(IPageLayout.ID_PROBLEM_VIEW);

		final IFolderLayout bottomRight = layout.createFolder(ID_BOTTOM_RIGHT_FOLDER, IPageLayout.RIGHT, 0.5f,
				ID_BOTTOM_CENTER_FOLDER);
		bottomRight.addView(DataAnalysisView.ID);
		bottomRight.addView(ID_VIEW_PLANT_UML);
		bottomRight.addView(ID_ERROR_LOG);
	}
}
