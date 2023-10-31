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

import java.awt.BasicStroke;
import java.awt.Stroke;

public enum RenderingStroke implements StrokeSupplier {
	FINE_SOLID(new BasicStroke(1.0f)),
	FINE_DASHED(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 4.0f, new float[] { 4.0f, 4.0f }, 0.0f)),
	FINE_DOTTED(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 4.0f, new float[] { 1.0f, 1.0f }, 0.0f)),
	FINE_DOT_DASH(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 4.0f, new float[] { 1.0f, 3.0f, 6.0f, 3.0f }, 0.0f)),
	FINE_DOT_DOUBLE_DASH(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 4.0f, new float[] { 1.0f, 3.0f, 6.0f, 3.0f, 6.0f, 3.0f }, 0.0f)),
	FINE_DOUBLE_DOT_DASH(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 4.0f, new float[] { 1.0f, 3.0f, 1.0f, 3.0f, 6.0f, 3.0f }, 0.0f)),
	FINE_LONG_DASHED(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 4.0f, new float[] { 16.0f, 4.0f }, 0.0f)),

	SOLID(new BasicStroke(2.0f)),
	DASHED(new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 5.0f, new float[] { 5.0f, 5.0f }, 0.0f)),
	DOTTED(new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 5.0f, new float[] { 2.0f, 2.0f }, 0.0f)),
	DOT_DASH(new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 5.0f, new float[] { 2.0f, 4.0f, 7.0f, 4.0f}, 0.0f)),
	DOT_DOUBLE_DASH(new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 5.0f, new float[] { 2.0f, 4.0f, 7.0f, 4.0f, 7.0f, 4.0f}, 0.0f)),
	DOUBLE_DOT_DASH(new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 5.0f, new float[] { 2.0f, 2.0f, 2.0f, 4.0f, 7.0f, 4.0f}, 0.0f)),
	LONG_DASHED(new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 5.0f, new float[] { 20.0f, 5.0f }, 0.0f)),

	FAT_SOLID(new BasicStroke(4.0f)),
	FAT_DASHED(new BasicStroke(4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 6.0f, new float[] { 6.0f, 6.0f }, 0.0f)),
	FAT_DOTTED(new BasicStroke(4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 5.0f, new float[] { 3.0f, 3.0f }, 0.0f)),
	FAT_DOT_DASH(new BasicStroke(4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 6.0f, new float[] { 3.0f, 5.0f, 8.0f, 5.0f}, 0.0f)),
	FAT_DOT_DOUBLE_DASH(new BasicStroke(4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 5.0f, new float[] { 3.0f, 5.0f, 8.0f, 5.0f, 8.0f, 5.0f}, 0.0f)),
	FAT_DOUBLE_DOT_DASH(new BasicStroke(4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 6.0f, new float[] { 3.0f, 3.0f, 3.0f, 5.0f, 8.0f, 5.0f}, 0.0f)),
	FAT_LONG_DASHED(new BasicStroke(4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 6.0f, new float[] { 24.0f, 6.0f }, 0.0f)),

	VERY_FAT_SOLID(new BasicStroke(6.0f)),
	VERY_FAT_DASHED(new BasicStroke(6.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 7.0f, new float[] { 7.0f, 7.0f }, 0.0f)),
	VERY_FAT_DOTTED(new BasicStroke(6.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 7.0f, new float[] { 4.0f, 4.0f }, 0.0f)),
	VERY_FAT_DOT_DASH(new BasicStroke(6.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 7.0f, new float[] { 4.0f, 6.0f, 9.0f, 6.0f}, 0.0f)),
	VERY_FAT_DOT_DOUBLE_DASH(new BasicStroke(6.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 7.0f, new float[] { 4.0f, 6.0f, 9.0f, 6.0f, 9.0f, 6.0f}, 0.0f)),
	VERY_FAT_DOUBLE_DOT_DASH(new BasicStroke(6.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 7.0f, new float[] { 4.0f, 4.0f, 4.0f, 6.0f, 9.0f, 6.0f}, 0.0f)),
	VERY_FAT_LONG_DASHED(new BasicStroke(6.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 7.0f, new float[] { 28.0f, 7.0f }, 0.0f));

	private final Stroke stroke;

	private RenderingStroke(Stroke stroke) {
		this.stroke = stroke;
	}

	@Override
	public Stroke getStroke() {
		return stroke;
	}
}
