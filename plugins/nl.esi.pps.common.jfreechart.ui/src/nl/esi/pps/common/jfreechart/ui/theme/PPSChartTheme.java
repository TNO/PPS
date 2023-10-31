/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.common.jfreechart.ui.theme;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.RectangularShape;

import org.eclipse.trace4cps.common.jfreechart.ui.theme.DefaultChartTheme;
import org.jfree.chart.renderer.AbstractRenderer;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.chart.ui.RectangleInsets;

import nl.esi.pps.common.jfreechart.plot.PPSDrawingSupplier;

class PPSChartTheme extends DefaultChartTheme {
	private static final long serialVersionUID = -5386469941469283621L;

	private static final RectangleInsets DEFAULT_ITEM_LABEL_INSETS = new RectangleInsets(0, 3, 1, 4);

    PPSChartTheme() {
		super("PPS", false);
		setDrawingSupplier(new PPSDrawingSupplier());
		setXYBarPainter(new PatchedXYBarPainter());
	}
	
	@Override
	protected void applyToAbstractRenderer(AbstractRenderer renderer) {
		super.applyToAbstractRenderer(renderer);

		renderer.setItemLabelInsets(DEFAULT_ITEM_LABEL_INSETS);
	}
	
	private static class PatchedXYBarPainter extends StandardXYBarPainter {
		private static final long serialVersionUID = 1757880869879051480L;
		
		/**
		 * There is a bug in the JVM (i.e. {@link Graphics2D}) that fails to draw huge
		 * shapes, resulting in those shapes not to be drawn at all. This class reduces
		 * the size of these shapes to the {@link Graphics2D#getClip() clipping area} of
		 * <code>g2</code>, if set.
		 */
		@Override
		public void paintBar(Graphics2D g2, XYBarRenderer renderer, int row, int column, RectangularShape bar,
				RectangleEdge base) {

			Stroke outlineStroke = renderer.isDrawBarOutline() ? renderer.getItemOutlineStroke(row, column) : null;

			RectangularShape clippedBar = bar;
			Shape clip = g2.getClip();
			if (clip != null) {
				if (outlineStroke != null) {
					// Ensure that outline falls outside the clip area
					clip = outlineStroke.createStrokedShape(clip);
				}
				clippedBar = bar.getBounds2D().createIntersection(clip.getBounds2D());
			}
			
	        Paint itemPaint = renderer.getItemPaint(row, column);
	        g2.setPaint(itemPaint);
	        g2.fill(clippedBar);

	        // draw the outline...
	        if (renderer.isDrawBarOutline()) {
	            Paint paint = renderer.getItemOutlinePaint(row, column);
	            if (outlineStroke != null && paint != null) {
	                g2.setStroke(outlineStroke);
	                g2.setPaint(paint);
	                g2.draw(clippedBar);
	            }
	        }
		}
	}
}
