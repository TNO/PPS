/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.emf.synchronizedtiming.ui;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "nl.esi.pps.common.emf.synchronizedtiming.ui"; //$NON-NLS-1$
	
	public static final String IMAGE_EXPORT_IMAGE = Activator.class.getPackage().getName() + ".IMAGE_EXPORT_IMAGE";
	public static final String IMAGE_TIME_SYNC = Activator.class.getPackage().getName() + ".IMAGE_TIME_SYNC";
	public static final String IMAGE_TIME_SYNC_ENABLED = Activator.class.getPackage().getName() + ".IMAGE_TIME_SYNC_ENABLED";
	public static final String IMAGE_MARGIN_SYNC = Activator.class.getPackage().getName() + ".IMAGE_MARGIN_SYNC";
	public static final String IMAGE_MARGIN_SYNC_ENABLED = Activator.class.getPackage().getName() + ".IMAGE_MARGIN_SYNC_ENABLED";
	public static final String IMAGE_ZOOM_VIEW = Activator.class.getPackage().getName() + ".IMAGE_ZOOM_TO_FIT_VIEW";
	public static final String IMAGE_ZOOM_OUT_HORIZONTAL = Activator.class.getPackage().getName() + ".IMAGE_ZOOM_OUT_HORIZONTAL";
	public static final String IMAGE_ZOOM_OUT_VERTICAL = Activator.class.getPackage().getName() + ".IMAGE_ZOOM_OUT_VERTICAL";
	public static final String IMAGE_ZOOM_SELECTION = Activator.class.getPackage().getName() + ".IMAGE_ZOOM_SELECTION";
	public static final String IMAGE_ZOOM_SELECTION_X = Activator.class.getPackage().getName() + ".IMAGE_ZOOM_SELECTION_X";
	public static final String IMAGE_ZOOM_SELECTION_Y = Activator.class.getPackage().getName() + ".IMAGE_ZOOM_SELECTION_Y";
	public static final String IMAGE_ZOOM_IN = Activator.class.getPackage().getName() + ".IMAGE_ZOOM_IN";
	public static final String IMAGE_ZOOM_OUT = Activator.class.getPackage().getName() + ".IMAGE_ZOOM_OUT";
	public static final String IMAGE_DATASET_VIEW = Activator.class.getPackage().getName() + ".IMAGE_DATA_VIEW";
	public static final String IMAGE_LEGEND_ONOFF = Activator.class.getPackage().getName() + ".IMAGE_LEGEND_ONOFF";

	// The shared instance
	private static @Nullable Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(@Nullable BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(@Nullable BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static @Nullable Activator getDefault() {
		return plugin;
	}

	public static @Nullable ImageDescriptor getDescriptor(String key) {
		Activator activator = getDefault();
		return (activator == null) ? null : activator.getImageRegistry().getDescriptor(key);
	}

	@Override
	protected void initializeImageRegistry(@Nullable ImageRegistry reg) {
		super.initializeImageRegistry(reg);

		if (null == reg) {
			return;
		}

		ImageDescriptor imageExportImage = ImageDescriptor
				.createFromURL(FileLocator.find(getBundle(), new Path("icons/export-image.png"), null));
		reg.put(IMAGE_EXPORT_IMAGE, imageExportImage);

		ImageDescriptor imageTimeSync = ImageDescriptor
				.createFromURL(FileLocator.find(getBundle(), new Path("icons/time-sync.png"), null));
		reg.put(IMAGE_TIME_SYNC, imageTimeSync);

		ImageDescriptor imageTimeSyncEnabled = ImageDescriptor
				.createFromURL(FileLocator.find(getBundle(), new Path("icons/time-sync-enabled.png"), null));
		reg.put(IMAGE_TIME_SYNC_ENABLED, imageTimeSyncEnabled);

		ImageDescriptor imageMarginSync = ImageDescriptor
				.createFromURL(FileLocator.find(getBundle(), new Path("icons/margin-sync.png"), null));
		reg.put(IMAGE_MARGIN_SYNC, imageMarginSync);

		ImageDescriptor imageMarinSyncEnabled = ImageDescriptor
				.createFromURL(FileLocator.find(getBundle(), new Path("icons/margin-sync-enabled.png"), null));
		reg.put(IMAGE_MARGIN_SYNC_ENABLED, imageMarinSyncEnabled);

		ImageDescriptor imageZoomView = ImageDescriptor
				.createFromURL(FileLocator.find(getBundle(), new Path("icons/zoom-view.png"), null));
		reg.put(IMAGE_ZOOM_VIEW, imageZoomView);

		reg.put(IMAGE_ZOOM_OUT_HORIZONTAL, ImageDescriptor
				.createFromURL(FileLocator.find(getBundle(), new Path("icons/zoom-out-horizontal.png"), null)));

		reg.put(IMAGE_ZOOM_OUT_VERTICAL, ImageDescriptor
				.createFromURL(FileLocator.find(getBundle(), new Path("icons/zoom-out-vertical.png"), null)));

		reg.put(IMAGE_ZOOM_SELECTION, ImageDescriptor
				.createFromURL(FileLocator.find(getBundle(), new Path("icons/zoom-selection.png"), null)));

		reg.put(IMAGE_ZOOM_SELECTION_X, ImageDescriptor
				.createFromURL(FileLocator.find(getBundle(), new Path("icons/zoom-selection-x.png"), null)));

		reg.put(IMAGE_ZOOM_SELECTION_Y, ImageDescriptor
				.createFromURL(FileLocator.find(getBundle(), new Path("icons/zoom-selection-y.png"), null)));

		reg.put(IMAGE_DATASET_VIEW, ImageDescriptor
				.createFromURL(FileLocator.find(getBundle(), new Path("icons/dataset-view.png"), null)));

		reg.put(IMAGE_LEGEND_ONOFF, ImageDescriptor
				.createFromURL(FileLocator.find(getBundle(), new Path("icons/LegendOnOff_16x16.png"), null)));

		reg.put(IMAGE_ZOOM_IN, ImageDescriptor
				.createFromURL(FileLocator.find(getBundle(), new Path("icons/zoom_in.png"), null)));
		
		reg.put(IMAGE_ZOOM_OUT, ImageDescriptor
				.createFromURL(FileLocator.find(getBundle(), new Path("icons/zoom_out.png"), null)));
	}
}
