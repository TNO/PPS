/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.compare;

import static nl.esi.emf.edit.provider.EMFEditUtil.getText;

import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.Function;

import org.eclipse.xtext.xbase.lib.StringExtensions;

import nl.esi.pps.architecture.ArchitectureModel;
import nl.esi.pps.architecture.implemented.ImplementedPackage;
import nl.esi.pps.architecture.instantiated.Executor;
import nl.esi.pps.architecture.instantiated.InstantiatedPackage;
import nl.esi.pps.architecture.specified.Component;
import nl.esi.pps.architecture.specified.Operation;
import nl.esi.pps.architecture.specified.SpecifiedPackage;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.EventType;

public enum ArchitectureLifecycleStage implements BiPredicate<Event, Event> {
	/**
	 * Within the specified phase, an event is considered to be equal when its
	 * {@link EventType}, {@link Component} and {@link Operation} are equal.
	 * 
	 * @see SpecifiedPackage
	 */
	SPECIFIED(
			equals(Event::eClass).and(equals(Event::getComponent)).and(equals(e -> e.getFunction().getOperation()))) {
		@Override
		public String describeTask(Event event, boolean full) {
			final String operation = getText(event.getFunction().getOperation());
			if (operation == null) {
				return null;
			}
			StringBuilder description = new StringBuilder();
			if (full) {
				description.append("of ");
			}
			description.append(operation);
			return description.toString();
		}

		@Override
		public String describeResource(Event event, boolean full) {
			String component = getText(event.getComponent());
			if (component == null) {
				throw new IllegalArgumentException("Failed to describe component, please contact PPS support. "
						+ "Hint: Make sure to load EMF edit libraries in resource set.");
			}
			StringBuilder description = new StringBuilder();
			if (full) {
				description.append("by ");
			}
			description.append(component);
			return description.toString();
		}
	},
	/**
	 * In addition to the {@link #SPECIFIED specified} constraints, an event is only
	 * considered to be equal when its {@link Function} is also equal.
	 * 
	 * @see ImplementedPackage
	 */
	IMPLEMENTED(equals(Event::getFunction).and(SPECIFIED)) {
		@Override
		public String describeTask(Event event, boolean full) {
			String function = getText(event.getFunction());
			if (function == null) {
				throw new IllegalArgumentException("Failed to describe function, please contact PPS support. "
						+ "Hint: Make sure to load EMF edit libraries in resource set.");
			}
			StringBuilder description = new StringBuilder();
			if (full) {
				description.append("of ");
			}
			description.append(function);
			if (full) {
				String operation = getText(event.getFunction().getOperation());
				if (operation != null) {
					description.append(" implementing ").append(operation);
				}
			}
			return description.toString();
		}

		@Override
		public String describeResource(Event event, boolean full) {
			return SPECIFIED.describeResource(event, full);
		}
	},
	/**
	 * In addition to the {@link #IMPLEMENTED implemented} constraints, an event is
	 * only considered to be equal when its {@link Executor} is also equal.
	 * 
	 * @see InstantiatedPackage
	 */
	INSTANTIATED(equals((Event e) -> e.getLifeline().getExecutor()).and(IMPLEMENTED)) {
		@Override
		public String describeTask(Event event, boolean full) {
			return IMPLEMENTED.describeTask(event, full);
		}

		@Override
		public String describeResource(Event event, boolean full) {
			String executor = getText(event.getLifeline().getExecutor());
			if (executor == null) {
				throw new IllegalArgumentException("Failed to describe executor, please contact PPS support. "
						+ "Hint: Make sure to load EMF edit libraries in resource set.");
			}
			StringBuilder description = new StringBuilder();
			if (full) {
				description.append(IMPLEMENTED.describeResource(event, full)).append(" on ");
			}
			description.append(executor);
			return description.toString();
		}
	};

	private final BiPredicate<? super Event, ? super Event> equivalence;

	private ArchitectureLifecycleStage(BiPredicate<? super Event, ? super Event> equivalence) {
		this.equivalence = equivalence;
	}

	@Override
	public boolean test(Event left, Event right) {
		return equivalence.test(left, right);
	}

	/**
	 * When determining the equivalence of two events that do NOT share an
	 * {@link ArchitectureModel}, use this tester, such that matching will be text
	 * based instead of object based.
	 */
	public boolean testDescription(Event left, Event right) {
		return Objects.equals(describe(left), describe(right));
	}

	public String describe(Event event) {
		return describe(event, true);
	}

	public String describe(Event event, boolean full) {
		final String type = EventType.valueOf(event).name().toLowerCase();
		final String task = describeTask(event, true);
		final String resource = describeResource(event, true);

		StringBuilder description = new StringBuilder(type);
		if (task != null) {
			description.append(' ').append(task);
		}
		description.append(' ').append(resource);
		return description.toString();
	}

	public abstract String describeTask(Event event, boolean full);

	public abstract String describeResource(Event event, boolean full);

	public String getLabel() {
		return StringExtensions.toFirstUpper(name().toLowerCase().replace('_', ' '));
	}

	private static <T, R> BiPredicate<T, T> equals(Function<? super T, R> function) {
		return (T left, T right) -> {
			R leftValue = function.apply(left);
			R rightValue = function.apply(right);
			return Objects.equals(leftValue, rightValue);
		};
	}
}
