/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc;

import org.eclipse.lsat.common.queries.QueryableIterable;

/**
 * Just a convenience event enumeration type as sometimes its implementation is
 * easier than using instanceof.
 */
public enum EventType {
	ENTRY {
		@Override
		public boolean isTypeOf(Event event) {
			return event instanceof EntryEvent;
		}

		@Override
		public Event createEvent() {
			return TmscFactory.eINSTANCE.createEntryEvent();
		}
	},
	EXIT {
		@Override
		public boolean isTypeOf(Event event) {
			return event instanceof ExitEvent;
		}

		@Override
		public Event createEvent() {
			return TmscFactory.eINSTANCE.createExitEvent();
		}
	};

	/**
	 * Tests if the {@code event} is of this type.
	 * 
	 * @param event the event to examine
	 * @return {@code true} if {@code event} is of this type.
	 */
	public abstract boolean isTypeOf(Event event);

	/**
	 * Convenience factory method that creates the right instance of an event using
	 * {@link TmscFactory}.
	 * 
	 * @return a new instance of an event
	 */
	public abstract Event createEvent();

	/**
	 * Extension method to access type directly from Event.
	 */
	public static EventType getType(Event event) {
		return valueOf(event);
	}

	public static EventType valueOf(Event event) {
		return QueryableIterable.from(values()).any(v -> v.isTypeOf(event));
	}
}
