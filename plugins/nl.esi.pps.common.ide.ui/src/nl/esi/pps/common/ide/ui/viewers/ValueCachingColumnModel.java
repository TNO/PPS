/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.ide.ui.viewers;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

import org.eclipse.jface.viewers.ILabelProvider;

public abstract class ValueCachingColumnModel extends AbstractColumnModel {
	private static final Object HEADER_KEY = new Object();
	
	private final Map<Integer, Map<Object, Object>> columnValueCache = new HashMap<>();
	private final Function<Integer, Map<Object, Object>> valueCacheFactory;
	
	public ValueCachingColumnModel(ILabelProvider delegate, boolean useEquals) {
		super(delegate);
		valueCacheFactory = useEquals ? i -> new HashMap<>() : i -> new IdentityHashMap<>();
	}

	@Override
	public boolean setInput(Object input) {
		Object oldInput = getInput();
		final boolean changed = super.setInput(input);
		if (changed || !Objects.equals(oldInput, input)) {
			clearCache();
		}
		return changed;
	}

	public void clearCache() {
		columnValueCache.clear();
	}

	@Override
	public Object getColumnValue(Object element, int columnIndex) {
		return columnValueCache.computeIfAbsent(columnIndex, valueCacheFactory)
				.computeIfAbsent(element, e -> calculateColumnValue(e, columnIndex));
	}
	
	protected abstract Object calculateColumnValue(Object element, int columnIndex);

	@Override
	protected Object getColumnHeaderValue(int columnIndex) {
		return columnValueCache.computeIfAbsent(columnIndex, valueCacheFactory)
				.computeIfAbsent(HEADER_KEY, k -> calculateColumnHeaderValue(columnIndex));
	}
	
	protected abstract Object calculateColumnHeaderValue(int columnIndex);
}
