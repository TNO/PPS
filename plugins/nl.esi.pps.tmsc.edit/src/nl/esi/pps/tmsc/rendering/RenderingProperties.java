/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.rendering;

import java.awt.Color;
import java.awt.Paint;
import java.awt.Stroke;
import java.io.Serializable;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import nl.esi.emf.properties.PropertiesContainer;
import nl.esi.pps.common.jfreechart.rendering.PaintSupplier;
import nl.esi.pps.common.jfreechart.rendering.RenderingPaint;
import nl.esi.pps.common.jfreechart.rendering.RenderingStroke;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.Lifeline;
import nl.esi.pps.tmsc.TmscPlugin;

public class RenderingProperties {
	public static final String PROPERTY_RENDERING_STRATEGY_ID = "renderingStrategyID";
	public static final String PROPERTY_RENDERING_DEPENDENCIES = "renderingDependencies";
	public static final String PROPERTY_RENDERING_EXECUTIONS = "renderingExecutions";
	
	public static final String PROPERTY_HIDDEN = "hidden";
	public static final String PROPERTY_PAINT = "paint";
	public static final String PROPERTY_STROKE = "stroke";

	public static void setRenderingStrategyID(FullScopeTMSC tmsc, String value) {
		setProperty(tmsc, PROPERTY_RENDERING_STRATEGY_ID, value);
	}

	public static String getRenderingStrategyID(FullScopeTMSC tmsc) {
		final Serializable renderingStrategyID = getProperty(tmsc, PROPERTY_RENDERING_STRATEGY_ID);
		return renderingStrategyID instanceof String ? (String) renderingStrategyID : null;
	}
	
	public static void setRenderingDependencies(FullScopeTMSC tmsc, RenderingDependencies value) {
		setProperty(tmsc, PROPERTY_RENDERING_DEPENDENCIES, value.name());
	}

	public static void setRenderingDependencies(FullScopeTMSC tmsc, String value) {
		setProperty(tmsc, PROPERTY_RENDERING_DEPENDENCIES, value);
	}

	public static RenderingDependencies getRenderingDependencies(FullScopeTMSC tmsc) {
		final Serializable renderingDependencies = getProperty(tmsc, PROPERTY_RENDERING_DEPENDENCIES);
		if (renderingDependencies instanceof RenderingDependencies) {
			return (RenderingDependencies) renderingDependencies;
		} else if (renderingDependencies instanceof String) {
			return RenderingDependencies.valueOf((String) renderingDependencies);
		} else {
			return null;
		}
	}

	public static void setRenderingExecutions(FullScopeTMSC tmsc, RenderingExecutions value) {
		setProperty(tmsc, PROPERTY_RENDERING_EXECUTIONS, value.name());
	}

	public static void setRenderingExecutions(FullScopeTMSC tmsc, String value) {
		setProperty(tmsc, PROPERTY_RENDERING_EXECUTIONS, value);
	}

	public static RenderingExecutions getRenderingExecutions(FullScopeTMSC tmsc) {
		final Serializable renderingExecutions = getProperty(tmsc, PROPERTY_RENDERING_EXECUTIONS);
		if (renderingExecutions instanceof RenderingExecutions) {
			return (RenderingExecutions) renderingExecutions;
		} else if (renderingExecutions instanceof String) {
			return RenderingExecutions.valueOf((String) renderingExecutions);
		} else {
			return null;
		}
	}

	public static void setHidden(Dependency dependency, String value) {
		setHidden(dependency, Boolean.parseBoolean(value));
	}

	public static void setHidden(Dependency dependency, boolean value) {
		setProperty(dependency, PROPERTY_HIDDEN, value);
	}

	public static boolean isHidden(Dependency dependency) {
		final Serializable hiddenValue = getProperty(dependency, PROPERTY_HIDDEN);
		if (hiddenValue instanceof Boolean) {
			return (Boolean) hiddenValue;
		} else if (hiddenValue instanceof String) {
			return Boolean.parseBoolean((String) hiddenValue);
		}
		return false;
	}

	public static void setHidden(Execution execution, String value) {
		setHidden(execution, Boolean.parseBoolean(value));
	}

	public static void setHidden(Execution execution, boolean value) {
		setProperty(execution, PROPERTY_HIDDEN, value);
	}

	public static boolean isHidden(Execution execution) {
		final Serializable hiddenValue = getProperty(execution, PROPERTY_HIDDEN);
		if (hiddenValue instanceof Boolean) {
			return (Boolean) hiddenValue;
		} else if (hiddenValue instanceof String) {
			return Boolean.parseBoolean((String) hiddenValue);
		}
		return false;
	}

	public static void setPaint(Dependency dependency, RenderingPaint value) {
		setProperty(dependency, PROPERTY_PAINT, value.name());
	}

	public static void setPaint(Dependency dependency, String value) {
		setProperty(dependency, PROPERTY_PAINT, value);
	}

	public static <T extends Paint & Serializable> void setPaint(Dependency dependency, T value) {
		setProperty(dependency, PROPERTY_PAINT, value);
	}

	public static <T extends PaintSupplier & Serializable> void setPaint(Dependency dependency, T value) {
		setProperty(dependency, PROPERTY_PAINT, value);
	}

	public static PaintSupplier getPaint(Dependency dependency, PaintSupplier defaultPaintSupplier) {
		return getPaint((PropertiesContainer) dependency, defaultPaintSupplier);
	}

	public static void setPaint(Execution execution, RenderingPaint value) {
		setProperty(execution, PROPERTY_PAINT, value.name());
	}

	public static void setPaint(Execution execution, String value) {
		setProperty(execution, PROPERTY_PAINT, value);
	}

	public static <T extends Paint & Serializable> void setPaint(Execution execution, T value) {
		setProperty(execution, PROPERTY_PAINT, value);
	}

	public static <T extends PaintSupplier & Serializable> void setPaint(Execution execution, T value) {
		setProperty(execution, PROPERTY_PAINT, value);
	}

	public static PaintSupplier getPaint(Execution execution, PaintSupplier defaultPaintSupplier) {
		return getPaint((PropertiesContainer) execution, defaultPaintSupplier);
	}
	
	public static void setPaint(Lifeline lifeline, RenderingPaint value) {
		setProperty(lifeline, PROPERTY_PAINT, value.name());
	}

	public static void setPaint(Lifeline lifeline, String value) {
		setProperty(lifeline, PROPERTY_PAINT, value);
	}

	public static <T extends Paint & Serializable> void setPaint(Lifeline lifeline, T value) {
		setProperty(lifeline, PROPERTY_PAINT, value);
	}

	public static <T extends PaintSupplier & Serializable> void setPaint(Lifeline lifeline, T value) {
		setProperty(lifeline, PROPERTY_PAINT, value);
	}

	public static PaintSupplier getPaint(Lifeline lifeline, PaintSupplier defaultPaintSupplier) {
		return getPaint((PropertiesContainer) lifeline, defaultPaintSupplier);
	}

	private static PaintSupplier getPaint(PropertiesContainer propertiesContainer, PaintSupplier defaultPaintSupplier) {
		final Serializable paintValue = getProperty(propertiesContainer, PROPERTY_PAINT);
		if (paintValue instanceof PaintSupplier) {
			return (PaintSupplier) paintValue;
		} else if (paintValue instanceof Paint) {
			return new DefaultPaintSupplier((Paint) paintValue);
		} else if (paintValue instanceof String) {
			final String paintString = (String) paintValue;
			if (paintString.startsWith("#")) {
				return new DefaultPaintSupplier(decodeColor(paintString));
			} else {
				try {
					return Enum.valueOf(RenderingPaint.class, paintString);
				} catch (IllegalArgumentException e) {
					TmscPlugin.getDefault().getLog().log(new Status(IStatus.WARNING, TmscPlugin.PLUGIN_ID,
							"Failed to decode paint: " + paintString, e));
				}
			}
		}
		return defaultPaintSupplier;
	}

	/**
	 * Sets {@link #PROPERTY_STROKE} with {@code value} on {@code dependency}.
	 */
	public static void setStroke(Dependency dependency, RenderingStroke value) {
		setProperty(dependency, PROPERTY_STROKE, value.name());
	}

	public static <T extends Stroke & Serializable> void setStroke(Dependency dependency, T value) {
		setProperty(dependency, PROPERTY_STROKE, value);
	}

	public static Stroke getStroke(Dependency dependency) {
		return getStroke(dependency, null);
	}
	
	public static Stroke getStroke(Dependency dependency, Stroke defaultStroke) {
		final Serializable strokeValue = getProperty(dependency, PROPERTY_STROKE);
		if (strokeValue instanceof Stroke) {
			return (Stroke) strokeValue;
		} else if (strokeValue instanceof String) {
			try {
				return Enum.valueOf(RenderingStroke.class, (String) strokeValue).getStroke();
			} catch (IllegalArgumentException e) {
				TmscPlugin.getDefault().getLog().log(new Status(IStatus.WARNING, TmscPlugin.PLUGIN_ID,
						"Failed to decode stroke: " + strokeValue, e));
			}
		}
		return defaultStroke;
	}

	@SuppressWarnings("deprecation")
	private static Serializable getProperty(PropertiesContainer propertiesContainer, String property) {
		return propertiesContainer.getProperties().get(property);
	}

	@SuppressWarnings("deprecation")
	private static void setProperty(PropertiesContainer propertiesContainer, String property, Serializable value) {
		propertiesContainer.getProperties().put(property, value);
	}
	
	/**
	 * Converts a <code>String</code> to a number and returns the specified
	 * <code>Color</code>. This method handles string formats that are used to
	 * represent hexadecimal numbers.
	 * 
	 * @param colorString a <code>String</code> that represents a color as a 24-bit
	 *                    (opaque) or 32-bit (translucent) number
	 * @return the new <code>Color</code> object.
	 * @see {@link Color#decode(String)}
	 * @see java.lang.Long#decode
	 * @exception NumberFormatException if the specified string cannot be
	 *                                  interpreted as hexadecimal long or integer.
	 */
	public static Color decodeColor(String colorString) throws NumberFormatException {
		if (colorString.startsWith("#") && colorString.length() > 7) {
			// Support RGBA
			final Long colorLong = Long.decode(colorString);
			int r = (int) ((colorLong >> 24) & 0xFF);
			int g = (int) ((colorLong >> 16) & 0xFF);
			int b = (int) ((colorLong >> 8) & 0xFF);
			int a = (int) (colorLong & 0xFF);
			return new Color(r, g, b, a);
		} else {
			return Color.decode(colorString);
		}
	}

	private static class DefaultPaintSupplier implements PaintSupplier, Serializable {
		private static final long serialVersionUID = -2212338621365996389L;

		private final Paint paint;

		private DefaultPaintSupplier(Paint paint) {
			this.paint = paint;
		}

		@Override
		public Paint getPaint() {
			return paint;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((paint == null) ? 0 : paint.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			DefaultPaintSupplier other = (DefaultPaintSupplier) obj;
			if (paint == null) {
				if (other.paint != null)
					return false;
			} else if (!paint.equals(other.paint))
				return false;
			return true;
		}
	}
}
