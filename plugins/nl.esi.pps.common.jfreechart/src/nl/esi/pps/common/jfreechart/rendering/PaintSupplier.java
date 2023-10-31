/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.common.jfreechart.rendering;

import java.awt.Color;
import java.awt.Paint;
import java.awt.Transparency;

@FunctionalInterface
public interface PaintSupplier {
	static PaintSupplier of(Paint paint) {
		return () -> paint;
	}
	
	public Paint getPaint();
	
	default Paint getOutlinePaint() {
		return isColor() ? getColor().darker() : Color.BLACK;
	}

	default Paint getLabelPaint() {
		if (!isColor()) {
			return Color.BLACK;
		}			
		final Color color = getColor();
		double y = (299 * color.getRed() + 587 * color.getGreen() + 114 * color.getBlue()) / 1000;
		return y >= 128 ? Color.BLACK : Color.WHITE;
	}

	default Paint getGridBandPaint() {
		final Paint paint = getPaint();
		if (paint instanceof Color && paint.getTransparency() == Transparency.OPAQUE) {
			final Color color = getColor();
			return new Color(color.getRed(), color.getGreen(), color.getBlue(), Math.round(color.getAlpha() * 0.2f));
		}
		return paint;
	}
	
	default Paint getGridBandAlternativePaint() {
		final Paint paint = getGridBandPaint();
		if (paint instanceof Color && paint.getTransparency() == Transparency.TRANSLUCENT) {
			final Color color = (Color) paint;
			return new Color(color.getRed(), color.getGreen(), color.getBlue(), Math.round(color.getAlpha() * 0.7f));
		}
		return paint;
	}
	
	/**
	 * @return {@code true} if {@link #getPaint()} is an instance of {@link Color}.
	 */
	default boolean isColor() {
		return getPaint() instanceof Color;
	}

	/**
	 * @return {@link #getPaint()} as {@link Color}
	 * @throws ClassCastException if {@link #getPaint()} is not an instance of
	 *                            {@link Color}.
	 * @see #isColor()
	 */
	default Color getColor() throws ClassCastException {
		return Color.class.cast(getPaint());
	}
	
	// Derivative methods
	
	/**
	 * @see Color#brighter()
	 */
	default PaintSupplier brighter() {
		return isColor() ? of(getColor().brighter()) : this;
	}

	default PaintSupplier bitBrighter() {
		if (!isColor()) {
			return this;
		}
		final Color c = getColor();
		int r = Math.round(Math.min(c.getRed() * 1.15f, 255));
		int g = Math.round(Math.min(c.getGreen() * 1.15f, 255));
		int b = Math.round(Math.min(c.getBlue() * 1.15f, 255));
		return of(new Color(r, g, b, c.getAlpha()));
	}

	/**
	 * @see Color#darker()
	 */
	default PaintSupplier darker() {
		return isColor() ? of(getColor().darker()) : this;
	}

	default PaintSupplier bitDarker() {
		if (!isColor()) {
			return this;
		}
		final Color c = getColor();
		int r = Math.round(Math.max(c.getRed() * 0.85f, 0));
		int g = Math.round(Math.max(c.getGreen() * 0.85f, 0));
		int b = Math.round(Math.max(c.getBlue() * 0.85f, 0));
		return of(new Color(r, g, b, c.getAlpha()));
	}
	
	default PaintSupplier withAlpha(int alpha) {
		if (alpha < 0 || alpha > 255) {
			throw new IllegalArgumentException("Alpha outside of expected range");
		}
		if (!isColor()) {
			return this;
		}
		final Color c = getColor();
		return of(new Color(c.getRed(), c.getGreen(), c.getBlue(), alpha));
	}
}
