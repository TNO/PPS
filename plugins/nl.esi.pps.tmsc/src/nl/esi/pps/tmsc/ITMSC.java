/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc;

import static org.eclipse.lsat.common.queries.QueryableIterable.from;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Objects;

public interface ITMSC {
	Collection<Dependency> getDependencies();
	
	default Collection<Dependency> getIncomingDependencies(Event event) {
		LinkedList<Dependency> incomingDependencies = new LinkedList<>();
        for (Dependency dependency : getDependencies()) {
        	if (Objects.equals(event, dependency.getTarget())) {
        		incomingDependencies.add(dependency);
        	}
        }
        return incomingDependencies;
	}

	default Collection<Dependency> getOutgoingDependencies(Event event) {
		LinkedList<Dependency> outgoingDependencies = new LinkedList<>();
        for (Dependency dependency : getDependencies()) {
        	if (Objects.equals(event, dependency.getSource())) {
        		outgoingDependencies.add(dependency);
        	}
        }
        return outgoingDependencies;
	}

	default Collection<Event> getEvents() {
        LinkedHashSet<Event> events = new LinkedHashSet<>();
        for (Dependency dependency : getDependencies()) {
        	events.add(dependency.getSource());
        	events.add(dependency.getTarget());
        }
        return events;
	}
	
    default Collection<Event> getInitialEvents() {
        LinkedHashSet<Event> sources = new LinkedHashSet<>();
        LinkedHashSet<Event> targets = new LinkedHashSet<>();
        for (Dependency dependency : getDependencies()) {
        	sources.add(dependency.getSource());
        	targets.add(dependency.getTarget());
        }
        sources.removeAll(targets);
        return sources;
    }
    
    default boolean isInitialEvent(Event event) {
    	return !from(getDependencies()).exists(e -> e.getTarget() == event);
    }

    default Collection<Event> getFinalEvents() {
        LinkedHashSet<Event> sources = new LinkedHashSet<>();
        LinkedHashSet<Event> targets = new LinkedHashSet<>();
        for (Dependency dependency : getDependencies()) {
        	sources.add(dependency.getSource());
        	targets.add(dependency.getTarget());
        }
        targets.removeAll(sources);
        return targets;
    }

    default boolean isFinalEvent(Event event) {
    	return !from(getDependencies()).exists(e -> e.getSource() == event);
    }
}
