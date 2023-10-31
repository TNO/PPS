/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.viewers.plot;

import java.awt.Font;
import java.awt.Paint;
import java.awt.Stroke;

import org.eclipse.trace4cps.common.jfreechart.ui.viewers.BackReferenceProvider;
import org.jfree.chart.annotations.XYAnnotation;
import org.jfree.chart.annotations.XYAnnotationBoundsInfo;
import org.jfree.chart.event.AnnotationChangeEvent;

import nl.esi.pps.tmsc.Dependency;

/**
 * This interface exposes the common and most used rendering properties of both
 * {@link DependencyIncomingAnnotation} and
 * {@link DependencyOutgoingAnnotation}.
 */
public interface DependencyAnnotation extends BackReferenceProvider<Dependency>, XYAnnotationBoundsInfo, XYAnnotation {
    /**
     * Returns the text for the annotation.
     *
     * @return The text (never <code>null</code>).
     *
     * @see #setText(String)
     */
    String getText();

    /**
     * Sets the text for the annotation.
     *
     * @param text  the text (<code>null</code> not permitted).
     *
     * @see #getText()
     */
    void setText(String text);

    /**
     * Returns the font for the annotation.
     *
     * @return The font (never <code>null</code>).
     *
     * @see #setFont(Font)
     */
    Font getFont();

    /**
     * Sets the font for the annotation and sends an
     * {@link AnnotationChangeEvent} to all registered listeners.
     *
     * @param font  the font (<code>null</code> not permitted).
     *
     * @see #getFont()
     */
    void setFont(Font font);

    /**
     * Returns the paint for the annotation.
     *
     * @return The paint (never <code>null</code>).
     *
     * @see #setPaint(Paint)
     */
    Paint getPaint();

    /**
     * Sets the paint for the annotation and sends an
     * {@link AnnotationChangeEvent} to all registered listeners.
     *
     * @param paint  the paint (<code>null</code> not permitted).
     *
     * @see #getPaint()
     */
    void setPaint(Paint paint);

    /**
     * Returns the background paint for the annotation.
     *
     * @return The background paint (possibly <code>null</code>).
     *
     * @see #setBackgroundPaint(Paint)
     */
    Paint getBackgroundPaint();

    /**
     * Sets the background paint for the annotation and sends an
     * {@link AnnotationChangeEvent} to all registered listeners.
     *
     * @param paint  the paint (<code>null</code> permitted).
     *
     * @see #getBackgroundPaint()
     */
    void setBackgroundPaint(Paint paint);

    /**
     * Returns the outline paint for the annotation.
     *
     * @return The outline paint (never <code>null</code>).
     *
     * @see #setOutlinePaint(Paint)
     */
    Paint getOutlinePaint();

    /**
     * Sets the outline paint for the annotation and sends an
     * {@link AnnotationChangeEvent} to all registered listeners.
     *
     * @param paint  the paint (<code>null</code> not permitted).
     *
     * @see #getOutlinePaint()
     */
    void setOutlinePaint(Paint paint);

    /**
     * Returns the outline stroke for the annotation.
     *
     * @return The outline stroke (never <code>null</code>).
     *
     * @see #setOutlineStroke(Stroke)
     */
    Stroke getOutlineStroke();

    /**
     * Sets the outline stroke for the annotation and sends an
     * {@link AnnotationChangeEvent} to all registered listeners.
     *
     * @param stroke  the stroke (<code>null</code> not permitted).
     *
     * @see #getOutlineStroke()
     */
    void setOutlineStroke(Stroke stroke);

    /**
     * Returns the flag that controls whether or not the outline is drawn.
     *
     * @return A boolean.
     */
    boolean isOutlineVisible();

    /**
     * Sets the flag that controls whether or not the outline is drawn and
     * sends an {@link AnnotationChangeEvent} to all registered listeners.
     *
     * @param visible  the new flag value.
     */
    void setOutlineVisible(boolean visible);

    /**
     * Returns the angle of the arrow.
     *
     * @return The angle (in radians).
     *
     * @see #setAngle(double)
     */
    double getAngle();

    /**
     * Sets the angle of the arrow and sends an
     * {@link AnnotationChangeEvent} to all registered listeners.
     *
     * @param angle  the angle (in radians).
     *
     * @see #getAngle()
     */
    void setAngle(double angle);

    /**
     * Returns the stroke used to draw the arrow line.
     *
     * @return The arrow stroke (never <code>null</code>).
     *
     * @see #setArrowStroke(Stroke)
     */
    Stroke getArrowStroke();

    /**
     * Sets the stroke used to draw the arrow line and sends an
     * {@link AnnotationChangeEvent} to all registered listeners.
     *
     * @param stroke  the stroke (<code>null</code> not permitted).
     *
     * @see #getArrowStroke()
     */
    void setArrowStroke(Stroke stroke);

    /**
     * Returns the paint used for the arrow.
     *
     * @return The arrow paint (never <code>null</code>).
     *
     * @see #setArrowPaint(Paint)
     */
    Paint getArrowPaint();

    /**
     * Sets the paint used for the arrow and sends an
     * {@link AnnotationChangeEvent} to all registered listeners.
     *
     * @param paint  the arrow paint (<code>null</code> not permitted).
     *
     * @see #getArrowPaint()
     */
    void setArrowPaint(Paint paint);
}
