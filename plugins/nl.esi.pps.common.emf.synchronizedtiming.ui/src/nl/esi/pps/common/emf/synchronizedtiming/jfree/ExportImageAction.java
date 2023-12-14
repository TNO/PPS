/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.common.emf.synchronizedtiming.jfree;

import java.io.File;
import java.io.IOException;
import java.net.URI;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.trace4cps.common.jfreechart.ui.widgets.ChartPanelComposite;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;

import nl.esi.pps.common.emf.synchronizedtiming.ui.Activator;

public class ExportImageAction extends Action {
	@Nullable 
	private ChartPanelComposite chartPanelComposite;

	@Nullable
	private IFile suggestedIFile = null;

	public ExportImageAction() {
		this(null, Activator.getDescriptor(Activator.IMAGE_EXPORT_IMAGE));
	}
	
	public ExportImageAction(@Nullable ChartPanelComposite plotComposite) {
		this(plotComposite, Activator.getDescriptor(Activator.IMAGE_EXPORT_IMAGE));
	}

	public ExportImageAction(@Nullable ChartPanelComposite chartPanelComposite, @Nullable ImageDescriptor imageDescriptor) {
		super("Export As Image", imageDescriptor);
		setToolTipText("Export plot to an image file.");
		setChartPanelComposite(chartPanelComposite);
	}

	public void setSuggestedIFile(@Nullable IFile suggestedIFile) {
		this.suggestedIFile = suggestedIFile;
	}
	
	public void setChartPanelComposite(@Nullable ChartPanelComposite plotComposite) {
		this.chartPanelComposite = plotComposite;
		setEnabled(plotComposite != null);
	}
	
	protected @Nullable ChartPanelComposite getChartPanelComposite() {
		return chartPanelComposite;
	}

	@SuppressWarnings("null")
	@Override
	public void run() {
		@Nullable
		ChartPanelComposite runChartPanelComposite = getChartPanelComposite();
		if (null == runChartPanelComposite) {
			Activator.getDefault().getLog().log(
					new Status(Status.ERROR, Activator.PLUGIN_ID, "Failed to export as image: plot not found"));
			return;
		}
		
		// Set up the dialog.
		SaveAsDialog dialog = new SaveAsDialog(runChartPanelComposite.getShell());
		dialog.setBlockOnOpen(true);
		if (suggestedIFile != null) {
			dialog.setOriginalFile(suggestedIFile);
		} else {
			dialog.setOriginalName("plot.png");
		}
		dialog.create();
		String title = "Export plot as image";
		dialog.getShell().setText(title);
		dialog.setTitle(title);
		dialog.setMessage("Select PNG file location and name.");

		// Get save path using dialog.
		dialog.open();
		IPath savePath = dialog.getResult();
		if (savePath == null) {
			return; // Cancelled.
		}

		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IPath fullPath = root.getLocation().append(savePath);
		File saveFile = new File(fullPath.toOSString());

		// Save image.
		JFreeChart chart = runChartPanelComposite.getChart();
		Rectangle clientArea = runChartPanelComposite.getClientArea();
		try {
			ChartUtils.saveChartAsPNG(saveFile, chart, clientArea.width, clientArea.height);
		} catch (IOException e) {
			MessageDialog.openError(runChartPanelComposite.getShell(), title, "Failed to save image: " + e.getMessage());
			return;
		}

		// Refresh workspace, for the parent directory of the saved image file.
		URI saveDirUri = saveFile.getParentFile().toURI();
		IContainer[] dirs = root.findContainersForLocationURI(saveDirUri);
		for (IContainer dir : dirs) {
			try {
				dir.refreshLocal(IResource.DEPTH_ONE, null);
			} catch (CoreException e) {
				// Ignore refresh failures.
			}
		}
	}
}
