/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.presentation;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;

import nl.esi.pps.architecture.ArchitectureModel;
import nl.esi.pps.architecture.deployed.Host;
import nl.esi.pps.architecture.implemented.Function;
import nl.esi.pps.architecture.instantiated.Executor;
import nl.esi.pps.architecture.specified.Component;
import nl.esi.pps.architecture.specified.Interface;
import nl.esi.pps.architecture.specified.Operation;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.Interval;
import nl.esi.pps.tmsc.Lifeline;
import nl.esi.pps.tmsc.TMSC;
import nl.esi.pps.tmsc.metric.MetricModel;

public class TmscContentOutlineComparator extends ViewerComparator {
	private static final Class<?>[] TYPE_ORDER = new Class<?>[] {
		MetricModel.class,
		Interval.class,
		TMSC.class,
		Lifeline.class,
		ArchitectureModel.class,
		Interface.class,
		Operation.class,
		Function.class,
		Component.class,
		Host.class,
		Executor.class,
		// Default, put at the end
		Object.class
	};
	
	private static final Class<?>[] EXECUTION_CONTENT = new Class<?>[] {
		Dependency.class,
		Event.class,
		Execution.class
	};

	public TmscContentOutlineComparator() {
		super(String.CASE_INSENSITIVE_ORDER);
	}

	@Override
	public int category(Object element) {
		return indexOf(TYPE_ORDER, element);
	}

	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		final Integer result = compare(e1, e2);
		if (result == null) {
			return 0;
		} else if (result == 0) {
			return super.compare(viewer, e1, e2);
		} else {
			return result;
		}
	}

	protected Integer compare(Object o1, Object o2) {
		if (indexOf(EXECUTION_CONTENT, o1) >= 0 && indexOf(EXECUTION_CONTENT, o2) >= 0) {
			// Do not sort, keep as is in model
			return null;
		}
		if (o1 instanceof Interval && o2 instanceof Interval) {
			// Do not sort, keep as is in model
			return null;
		}
		if (o1 instanceof Resource && o2 instanceof Resource) {
			// Do not sort, keep as is in model
			return null;
		}
		return 0;
	}
	
	private int indexOf(Class<?>[] classes, Object element) {
		for (int i = 0; i < classes.length; i++) {
			if (classes[i].isInstance(element)) {
				return i;
			}
		}
		return -1;
	}
}
