/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.viewers.plot;


import static org.eclipse.lsat.common.queries.QueryableIterable.from;

import java.awt.geom.Point2D;
import java.util.List;
import java.util.Objects;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.trace4cps.common.jfreechart.ui.viewers.BackReferenceProvider;
import org.jfree.chart.annotations.XYAnnotation;
import org.jfree.chart.annotations.XYAnnotationBoundsInfo;
import org.jfree.chart.annotations.XYMeasurementAnnotation;
import org.jfree.data.Range;

import nl.esi.pps.tmsc.Interval;
import nl.esi.pps.tmsc.viewers.TmscPlotViewer;

public class IntervalAnnotation<T extends Interval> extends XYMeasurementAnnotation
		implements BackReferenceProvider<T>, XYAnnotationBoundsInfo {
	private static final long serialVersionUID = -5117927951630224029L;

	private transient T interval;
	
	public static <T extends Interval> IntervalAnnotation<T> add(TmscPlotViewer viewer, T interval) {
		@SuppressWarnings("unchecked")
		IntervalAnnotation<T> annotation = from((List<XYAnnotation>) viewer.getXYPlot().getAnnotations())
				.objectsOfKind(IntervalAnnotation.class)
				.any(a -> Objects.equals(a.getBackReference(), interval));
		
		if (annotation != null) {
			return annotation;
		}
		
		Point2D fromLocation = viewer.getEventLocation(interval.getFrom());
		Point2D toLocation = viewer.getEventLocation(interval.getTo());
		if (fromLocation == null || toLocation == null || interval == null) {
			return null;
		}
		
		annotation = new IntervalAnnotation<>(fromLocation, toLocation, interval, viewer.getLabelProvider());
		annotation.setFont(viewer.getXYPlot().getDomainAxis().getTickLabelFont());
		viewer.getXYPlot().addAnnotation(annotation, true);
		return annotation;
	}

	private IntervalAnnotation(Point2D fromLocation, Point2D toLocation, T interval, ILabelProvider labelProvider) {
		super(Orientation.HORIZONTAL, labelProvider.getText(interval), fromLocation, toLocation);
		this.interval = interval;
		setBaseCreateEntity(true);
		// Listen for name changes
		this.interval.eAdapters().add(new LabelAdapter(labelProvider));
	}
	
	@Override
	public T getBackReference() {
		return interval;
	}
	
    @Override
    public Range getXRange() {
        if (getX() > getX2()) {
            return new Range(getX2(), getX());
        } else {
            return new Range(getX(), getX2());
        }
    }

    @Override
    public Range getYRange() {
        if (getY() > getY2()) {
            return new Range(getY2(), getY());
        } else {
            return new Range(getY(), getY2());
        }
    }

    @Override
    public boolean getIncludeInDataBounds() {
        // Represents a measurement between existing points in a data set,
        // hence already included in the data bounds.
        return false;
    }
	
	public class LabelAdapter extends AdapterImpl {
		private final ILabelProvider labelProvider;

		public LabelAdapter(ILabelProvider labelProvider) {
			this.labelProvider = labelProvider;
		}

		@Override
		public void notifyChanged(Notification msg) {
			setText(labelProvider.getText(interval));
		}
	}
}
