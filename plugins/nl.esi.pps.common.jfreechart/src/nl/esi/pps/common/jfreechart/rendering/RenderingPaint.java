/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.jfreechart.rendering;

import java.awt.Color;
import java.awt.Paint;
import java.awt.SystemColor;

/**
 * The first 16 colors create a color scheme as taken from <a href=
 * "http://colorbrewer2.org/#type=qualitative&scheme=Paired&n=12">ColorBrewer
 * 2.0</a>, reordered the colors a bit and added HTML colors
 * {@link RenderingPaint#GOLD}, {@link RenderingPaint#NAVY},
 * {@link RenderingPaint#OLIVE} and {@link RenderingPaint#MAROON}.<br>
 * The next 13 colors are colors as defined by {@link java.util.Color} in the
 * default sRGB space.<br>
 * The last 7 colors are colors as defined by {@link java.awt.SystemColor} to
 * encapsulate symbolic colors representing the color of native GUI objects on a
 * system.
 * 
 * @see http://colorbrewer2.org/#type=qualitative&scheme=Paired&n=12
 * @see https://sashat.me/2017/01/11/list-of-20-simple-distinct-colors/
 */
public enum RenderingPaint implements PaintSupplier {
	/** @see http://colorbrewer2.org/#type=qualitative&scheme=Paired&n=12 */
	BLUE(new Color(31, 120, 180)),
	/** @see http://colorbrewer2.org/#type=qualitative&scheme=Paired&n=12 */
	RED(new Color(227, 26, 28)),
	/** @see http://colorbrewer2.org/#type=qualitative&scheme=Paired&n=12 */
	GREEN(new Color(51, 160, 44)),
	/** @see http://colorbrewer2.org/#type=qualitative&scheme=Paired&n=12 */
	ORANGE(new Color(255, 127, 0)),
	/** @see http://colorbrewer2.org/#type=qualitative&scheme=Paired&n=12 */
	VIOLET(new Color(106, 61, 154)),
	/** @see https://www.w3schools.com/colors/color_tryit.asp?hex=FFD700 */
	GOLD(new Color(255, 215, 0)),
	/** @see http://colorbrewer2.org/#type=qualitative&scheme=Paired&n=12 */
	LIGHT_BLUE(new Color(166, 206, 227)),
	/** @see http://colorbrewer2.org/#type=qualitative&scheme=Paired&n=12 */
	PINK(new Color(251, 154, 153)),
	/** @see http://colorbrewer2.org/#type=qualitative&scheme=Paired&n=12 */
	LIGHT_GREEN(new Color(178, 223, 138)),
	/** @see http://colorbrewer2.org/#type=qualitative&scheme=Paired&n=12 */
	SAND(new Color(253, 191, 111)),
	/** @see http://colorbrewer2.org/#type=qualitative&scheme=Paired&n=12 */
	PURPLE(new Color(202, 178, 214)),
	/** @see http://colorbrewer2.org/#type=qualitative&scheme=Paired&n=12 */
	LIGHT_YELLOW(new Color(255, 255, 153)),
	/** @see https://www.w3schools.com/colors/color_tryit.asp?hex=000080 */
	NAVY(new Color(0, 0, 128)),
	/** @see https://www.w3schools.com/colors/color_tryit.asp?hex=800000 */
	MAROON(new Color(128, 0, 0)),
	/** @see https://www.w3schools.com/colors/color_tryit.asp?hex=808000 */
	OLIVE(new Color(128, 128, 0)),
	/** @see http://colorbrewer2.org/#type=qualitative&scheme=Paired&n=12 */
	BROWN(new Color(177, 89, 40)),

	/** @see Color#BLUE */
	PURE_BLUE(Color.BLUE),
	/** @see Color#ORANGE */
	PURE_ORANGE(Color.ORANGE),
	/** @see Color#PINK */
	PURE_PINK(Color.PINK),
	/** @see Color#RED */
	PURE_RED(Color.RED),
	/** @see Color#GREEN */
	PURE_GREEN(Color.GREEN),
	/** @see Color#YELLOW */
	YELLOW(Color.YELLOW),
	/** @see Color#CYAN */
	CYAN(Color.CYAN),
	/** @see Color#MAGENTA */
	MAGENTA(Color.MAGENTA),
	
	/** @see Color#LIGHT_GRAY */
	LIGHT_GRAY(Color.LIGHT_GRAY),
	/** @see Color#GRAY */
	GRAY(Color.GRAY),
	/** @see Color#DARK_GRAY */
	DARK_GRAY(Color.DARK_GRAY),
	/** @see Color#BLACK */
	BLACK(Color.BLACK),
	/** @see Color#WHITE */
	WHITE(Color.WHITE),
	
	/** @see SystemColor#activeCaption */
	ACTIVE_CAPTION(SystemColor.activeCaption, SystemColor.activeCaptionBorder, SystemColor.activeCaptionText),
	/** @see SystemColor#control */
	CONTROL(SystemColor.control, SystemColor.controlShadow, SystemColor.controlText),
	/** @see SystemColor#controlHighlight */
	CONTROL_HIGHLIGHT(SystemColor.controlHighlight, SystemColor.control, null),
	/** @see SystemColor#controlShadow */
	CONTROL_SHADOW(SystemColor.controlShadow, SystemColor.controlDkShadow, null),
	/** @see SystemColor#inactiveCaption */
	INACTIVE_CAPTION(SystemColor.inactiveCaption, SystemColor.inactiveCaptionBorder, SystemColor.inactiveCaptionText),
	/** @see SystemColor#info */
	INFO(SystemColor.info, null, SystemColor.infoText),
	/** @see SystemColor#window */
	WINDOW(SystemColor.window, SystemColor.windowBorder, SystemColor.windowText);

	private final Paint paint;
	private final Paint outlinePaint;
	private final Paint labelPaint;
	
	private RenderingPaint(Paint paint) {
		this(paint, null, null);
	}

	private RenderingPaint(Paint paint, Paint outlinePaint, Paint labelPaint) {
		this.paint = paint;
		this.outlinePaint = outlinePaint;
		this.labelPaint = labelPaint;
	}

	public Paint getPaint() {
		return paint;
	}
	
	public Paint getOutlinePaint() {
		if (outlinePaint != null) {
			return outlinePaint;
		}
		return PaintSupplier.super.getOutlinePaint();
	}
	
	public Paint getLabelPaint() {
		if (labelPaint != null) {
			return labelPaint;
		}
		return PaintSupplier.super.getLabelPaint();
	}

	/**
	 * Returns a defined paint, based on the {@code index}. {@link RenderingPaint}
	 * supports up to 24 unique colors.
	 */
	public static RenderingPaint valueOf(int index) {
		return RenderingPaint.values()[index % 24];
	}
}
