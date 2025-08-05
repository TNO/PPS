/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.viewers.dataanalysis;

import static org.eclipse.lsat.common.queries.QueryableIterable.from;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import org.eclipse.xtext.xbase.lib.Pair;

import org.eclipse.lsat.common.queries.QueryableIterable;
import org.eclipse.lsat.common.util.IterableUtil;
import com.google.common.math.Quantiles;
import com.google.common.math.Stats;

import nl.esi.pps.tmsc.text.EDurationFormat;

public class DurationFilter {
	public enum Technique { INTERQUARTILE_RANGE, SIGMA, RANGE };
	
	public static String PROPERTY_FILTER = "filter";
	public static String PROPERTY_NEGATE = "negate";
	public static String PROPERTY_TECHNIQUE = "technique";
	public static String PROPERTY_MIN = "min";
	public static String PROPERTY_MAX = "max";
	public static String PROPERTY_SIGMA = "sigma";
	public static String PROPERTY_IQR_FACTOR = "iqrFactor";

	private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
	
	private boolean filter = false;
	private boolean negate = false;
	private Technique technique = Technique.INTERQUARTILE_RANGE;
	private long min = 0;
	private long max = Long.MAX_VALUE;
	private double sigma = 6.0;
	private double iqrFactor = 3.0;
	
	public String getDescription() {
		StringBuilder description = new StringBuilder();
		if (filter && technique != null) {
			description.append("Filter");
			if (negate) {
				description.append(" (negate)");
			}
			switch (technique) {
			case RANGE:
				description.append(": ").append(EDurationFormat.eINSTANCE.format(min)).append(" ≤ t ≤ ")
						.append(EDurationFormat.eINSTANCE.format(max));
				break;
			case SIGMA:
				description.append(" sigma: ").append(sigma);
				break;
			case INTERQUARTILE_RANGE:
				description.append(" IQR: ").append(iqrFactor);
				break;
			default:
				description.append(" UNKNOWN");
			}
		}
		return description.toString();
	}
	
	/**
	 * @see PropertyChangeSupport#addPropertyChangeListener(PropertyChangeListener)
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(listener);
	}

	/**
	 * @see PropertyChangeSupport#addPropertyChangeListener(String, PropertyChangeListener)
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}

	/**
	 * @see PropertyChangeSupport#removePropertyChangeListener(PropertyChangeListener)
	 */
	public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}

	/**
	 * @see PropertyChangeSupport#removePropertyChangeListener(String, PropertyChangeListener)
	 */
	public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(propertyName, listener);
	}
	
	public void setFilter(boolean filterActive) {
		propertyChangeSupport.firePropertyChange(PROPERTY_FILTER, this.filter, this.filter = filterActive);
	}
	
	public boolean isFilter() {
		return filter;
	}
	
	public void setNegate(boolean inverted) {
		propertyChangeSupport.firePropertyChange(PROPERTY_NEGATE, this.negate, this.negate = inverted);
	}
	
	public boolean isNegate() {
		return negate;
	}

	public Technique getTechnique() {
		return technique;
	}

	/**
	 * @throws NullPointerException if <code>technique</code> is <code>null</code>
	 */
	public void setTechnique(Technique technique) throws NullPointerException {
		if (technique == null) {
			throw new NullPointerException("Outlier detection technique cannot be null");
		}
		propertyChangeSupport.firePropertyChange(PROPERTY_TECHNIQUE, this.technique, this.technique = technique);
	}

	public long getMin() {
		return min;
	}

	public void setMin(long min) {
		propertyChangeSupport.firePropertyChange(PROPERTY_MIN, this.min, this.min = min);
	}

	public long getMax() {
		return max;
	}

	public void setMax(long max) {
		propertyChangeSupport.firePropertyChange(PROPERTY_MAX, this.max, this.max = max);
	}

	public double getSigma() {
		return sigma;
	}

	public void setSigma(double sigma) {
		propertyChangeSupport.firePropertyChange(PROPERTY_SIGMA, this.sigma, this.sigma = sigma);
	}

	public double getIqrFactor() {
		return iqrFactor;
	}

	public void setIqrFactor(double iqrFactor) {
		propertyChangeSupport.firePropertyChange(PROPERTY_IQR_FACTOR, this.iqrFactor, this.iqrFactor = iqrFactor);
	}

	public void filter(List<Pair<?, Long>> source) {
		QueryableIterable<Long> durations = from(source).collectOne(Pair::getValue);
		if (!filter || technique != Technique.RANGE) {
			// Update min/max values to current dataset
			setMin(IterableUtil.min(durations, 0L));
			setMax(IterableUtil.max(durations, Long.MAX_VALUE));
		}
		
		if (!filter || null == technique) {
			return;
		}
		
		final Predicate<Number> filterPredicate;
		switch (technique) {
		case INTERQUARTILE_RANGE:
			filterPredicate = interquartileRangePredicate(durations.asList(), iqrFactor);
			break;
		case SIGMA:
			filterPredicate = sigmaPredicate(durations.asList(), sigma);
			break;
		case RANGE:
			filterPredicate = minMaxPredicate(min, max);
			break;
		default:
			filterPredicate = n -> false;
		}
		final Predicate<Number> removePredicate = negate ? filterPredicate : filterPredicate.negate();
		source.removeIf(p -> removePredicate.test(p.getValue()));
	}
	
	private static <T> Predicate<Number> interquartileRangePredicate(Collection<? extends Number> values, double iqrFactor) {
		if (values.isEmpty()) {
			return n -> true;
		}
        Map<Integer, Double> quartiles = Quantiles.quartiles().indexes(1,3).compute(values);
        double q1 = quartiles.get(1);
        double q3 = quartiles.get(3);
        double min = q1 - (iqrFactor * (q3 - q1));
        double max = q3 + (iqrFactor * (q3 - q1));
		
        return minMaxPredicate(min, max);
	}
	
	private static <T> Predicate<Number> sigmaPredicate(Collection<? extends Number> values, double sigma) {
		if (values.size() < 2) {
			return n -> true;
		}
		Stats stats = Stats.of(values);
		double sd = stats.sampleStandardDeviation();
		double mean = stats.mean();
        double min = mean - (sigma * sd);
        double max = mean + (sigma * sd);
		
        return minMaxPredicate(min, max);
	}
	
	private static Predicate<Number> minMaxPredicate(Number min, Number max) {
		return value -> value != null && (min == null || value.doubleValue() >= min.doubleValue())
				&& (max == null || value.doubleValue() <= max.doubleValue());
	}
}
