/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.common.jfreechart.plot;

import java.awt.Color;
import java.awt.Paint;

import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.renderer.AbstractRenderer;

import nl.esi.pps.common.jfreechart.rendering.PaintSupplier;
import nl.esi.pps.common.jfreechart.rendering.RenderingPaint;

public class PPSDrawingSupplier extends DefaultDrawingSupplier {
	private static final long serialVersionUID = 3665338707793878363L;

	/**
	 * Took the color scheme from <a href="http://colorbrewer2.org/#type=qualitative&scheme=Paired&n=12">ColorBrewer
	 * 2.0</a>, reordered the colors a bit and added HTML gold, navy, olive, maroon.
	 * 
	 * @see RenderingPaint
	 */
	protected static PaintSupplier[] PPS_PAINT_SEQUENCE = new PaintSupplier[] {
		RenderingPaint.BLUE,
		RenderingPaint.RED,
		RenderingPaint.GREEN,
		RenderingPaint.ORANGE,
		RenderingPaint.VIOLET,
		RenderingPaint.GOLD,
		
		RenderingPaint.LIGHT_BLUE,
		RenderingPaint.PINK,
		RenderingPaint.LIGHT_GREEN,
		RenderingPaint.SAND,
		RenderingPaint.PURPLE,
		RenderingPaint.LIGHT_YELLOW,

		RenderingPaint.NAVY,
		RenderingPaint.MAROON,
		RenderingPaint.OLIVE,
		RenderingPaint.BROWN
	};

	public static final int NUMBER_OF_COLORS_IN_PALETTE = PPS_PAINT_SEQUENCE.length + DEFAULT_PAINT_SEQUENCE.length;
	
	public PPSDrawingSupplier() {
		super(createDefaultPaintArray(), DEFAULT_FILL_PAINT_SEQUENCE, createDefaultOutlinePaintArray(),
				DEFAULT_STROKE_SEQUENCE, DEFAULT_OUTLINE_STROKE_SEQUENCE, DEFAULT_SHAPE_SEQUENCE);
	}

	protected static Paint[] createDefaultPaintArray() {
		// Concatenate the T-iPPS color sequence with the default sequence to ensure that we declare enough colors.
		Paint[] result = new Paint[NUMBER_OF_COLORS_IN_PALETTE];
		for (int i = 0; i < PPS_PAINT_SEQUENCE.length; i++) {
			result[i] = PPS_PAINT_SEQUENCE[i].getPaint();
		}
		for (int i = PPS_PAINT_SEQUENCE.length; i < result.length; i++) {
			result[i] = DEFAULT_PAINT_SEQUENCE[i - PPS_PAINT_SEQUENCE.length];
		}
		return result;
	}

	protected static Paint[] createDefaultOutlinePaintArray() {
		// Concatenate the T-iPPS color sequence with the default sequence to ensure that we declare enough colors.
		Paint[] result = new Paint[NUMBER_OF_COLORS_IN_PALETTE];
		for (int i = 0; i < PPS_PAINT_SEQUENCE.length; i++) {
			result[i] = PPS_PAINT_SEQUENCE[i].getOutlinePaint();
		}
		for (int i = PPS_PAINT_SEQUENCE.length; i < result.length; i++) {
			Paint paint = DEFAULT_PAINT_SEQUENCE[i - PPS_PAINT_SEQUENCE.length];
			result[i] = PaintSupplier.of(paint).getOutlinePaint();
		}
		return result;
	}
	
	public static void configureFixedSeriesColors(AbstractRenderer renderer, int nrOfSeries) {
		PPSDrawingSupplier supplier = new PPSDrawingSupplier();
		renderer.setAutoPopulateSeriesPaint(false);
		renderer.setAutoPopulateSeriesOutlinePaint(false);
		renderer.setComputeItemLabelContrastColor(true);
		for (int series = 0; series < nrOfSeries; series++) {
			renderer.setSeriesPaint(series, supplier.getNextPaint());
			renderer.setSeriesOutlinePaint(series, supplier.getNextOutlinePaint());
		}
	}
	
	public static String[] getHtmlColorSequence() {
		String[] htmlColors = new String[PPS_PAINT_SEQUENCE.length];
		for (int i = 0; i < PPS_PAINT_SEQUENCE.length; i++) {
			Color color = PPS_PAINT_SEQUENCE[i].getColor();
			htmlColors[i] = String.format("#%02X%02X%02X", color.getRed(), color.getGreen(), color.getBlue());
		}
		return htmlColors;
	}
}
