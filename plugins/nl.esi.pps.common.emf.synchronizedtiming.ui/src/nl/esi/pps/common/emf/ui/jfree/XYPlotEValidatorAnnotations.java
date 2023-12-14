/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.common.emf.ui.jfree;

import java.awt.Image;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.lsat.common.emf.common.util.URIHelper;
import org.eclipse.trace4cps.common.jfreechart.ui.viewers.BackReferenceProvider;
import org.eclipse.trace4cps.common.jfreechart.ui.viewers.BackReferenceResolver;
import org.eclipse.ui.statushandlers.StatusManager;
import org.jfree.chart.annotations.XYImageAnnotation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XYPlotEValidatorAnnotations {
	private static final Logger LOGGER = LoggerFactory.getLogger(XYPlotEValidatorAnnotations.class);
	private static final String PLUGIN_ID = "nl.esi.pps.common.emf.synchronizedtiming.ui";

	private static final BufferedImage INFO_IMAGE;
	private static final BufferedImage WARNING_IMAGE;
	private static final BufferedImage ERROR_IMAGE;

	static {
		BufferedImage infoImage = null;
		BufferedImage warningImage = null;
		BufferedImage errorImage = null;
		try {
			infoImage = ImageIO.read(new URL("platform:/plugin/" + PLUGIN_ID + "/icons/info.png"));
			warningImage = ImageIO.read(new URL("platform:/plugin/" + PLUGIN_ID + "/icons/warning.png"));
			errorImage = ImageIO.read(new URL("platform:/plugin/" + PLUGIN_ID + "/icons/error.png"));
		} catch (IOException e) {
			StatusManager.getManager().handle(new Status(IStatus.ERROR, PLUGIN_ID, e.getMessage(), e));
		}
		INFO_IMAGE = infoImage;
		WARNING_IMAGE = warningImage;
		ERROR_IMAGE = errorImage;
	}
	
	private XYPlotEValidatorAnnotations() {
		// Empty for utility classes
	}

	public static void addAnnotations(XYPlot xyPlot) {
		addAnnotations(xyPlot, IMarker.SEVERITY_ERROR, IMarker.SEVERITY_WARNING, IMarker.SEVERITY_INFO);
	}

	public static void addAnnotations(XYPlot xyPlot, int... severities) {
		addAnnotations(xyPlot, BackReferenceResolver.DEFAULT, severities);
	}

	public static void addAnnotations(XYPlot xyPlot, BackReferenceResolver backReferenceResolver, int... severities) {
		LOGGER.debug("addEValidatorAnnotations -->");
		Arrays.sort(severities);
		Map<EObject, Point2D.Double> coordinates = new HashMap<EObject, Point2D.Double>();
		for (int d = 0; d < xyPlot.getDatasetCount(); d++) {
			XYDataset dataset = xyPlot.getDataset(d);
			for (int series = 0; series < dataset.getSeriesCount(); series++) {
				for (int item = 0; item < dataset.getItemCount(series); item++) {
					BackReferenceProvider<?> backReference = backReferenceResolver.resolveBackReferenceProvider(dataset,
							series, item);
					if (backReference != null && backReference.getBackReference() instanceof EObject) {
						coordinates.put((EObject) backReference.getBackReference(),
								new Point2D.Double(dataset.getXValue(series, item), dataset.getYValue(series, item)));
					}
				}
			}
		}

		for (Resource resource : coordinates.keySet().stream().map(EObject::eResource).collect(Collectors.toSet())) {
			if (resource == null) {
				continue;
			}
			IResource iResource = URIHelper.asIResource(resource.getURI());
			ResourceSet resourceSet = resource.getResourceSet();
			if (iResource == null || resourceSet == null) {
				continue;
			}

			try {
				IMarker[] evalidatorMarkers = iResource.findMarkers(EValidator.MARKER, true, IResource.DEPTH_ZERO);
				for (IMarker marker : evalidatorMarkers) {
					int severity = marker.getAttribute(IMarker.SEVERITY, -1);
					if (Arrays.binarySearch(severities, severity) < 0) {
						continue;
					}
					
					Object objectURI = marker.getAttribute(EValidator.URI_ATTRIBUTE);
					if (objectURI instanceof String) {
						EObject eObject = resourceSet.getEObject(URI.createURI((String) objectURI), true);
						Point2D.Double point = coordinates.remove(eObject);
						if (point != null) {
							BufferedImage image = INFO_IMAGE;
							if (severity == IMarker.SEVERITY_ERROR) {
								image = ERROR_IMAGE;
							} else  if (severity == IMarker.SEVERITY_WARNING) {
								image = WARNING_IMAGE;
							}
							
							EValidatorAnnotation annotation = new EValidatorAnnotation(point.getX(), point.getY(),
									image, eObject);
							String tooltip = marker.getAttribute(IMarker.MESSAGE, null);
							if (tooltip != null) {
								annotation.setToolTipText(tooltip);
							}
							xyPlot.addAnnotation(annotation);
						}
					}
				}
			} catch (CoreException e) {
				StatusManager.getManager().handle(e, PLUGIN_ID);
			}
		}
		LOGGER.debug("addEValidatorAnnotations <--");
	}
	
	private static class EValidatorAnnotation extends XYImageAnnotation implements BackReferenceProvider<EObject> {
		private static final long serialVersionUID = -7106357805427006000L;

		private final transient EObject backReference;
		
		public EValidatorAnnotation(double x, double y, Image image, EObject backReference) {
			super(x, y, image);
			this.backReference = backReference;
		}
		
		@Override
		public EObject getBackReference() {
			return backReference;
		}
	}
}
