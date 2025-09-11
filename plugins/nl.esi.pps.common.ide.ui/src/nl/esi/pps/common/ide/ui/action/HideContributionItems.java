/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.ide.ui.action;

import java.util.function.Predicate;

import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.action.IContributionManagerOverrides;

/**
 * This class can be used to hide {@link IContributionItem}, matching a
 * {@link Predicate}, from an {@link IContributionManager}.
 * 
 * @see IContributionManager#getOverrides()
 */
public class HideContributionItems implements IContributionManagerOverrides {
	/**
	 * Hides all additions that are induced by the org.eclipse.platform feature.
	 */
	public static final Predicate<IContributionItem> ECLIPSE_PLATFORM_ADDITIONS = item -> {
		final String itemId = item.getId();
		if (itemId == null) {
			return false;
		}
		return itemId.startsWith("org.eclipse.debug.ui") || itemId.equals("compareWithMenu")
				|| itemId.equals("replaceWithMenu") || itemId.equals("team.main") || itemId.equals("ValidationCommand");
	};

	private final Predicate<IContributionItem> predicate;
	private final IContributionManagerOverrides delegate;

	public HideContributionItems(Predicate<IContributionItem> predicate) {
		this(predicate, null);
	}

	public HideContributionItems(Predicate<IContributionItem> predicate, IContributionManagerOverrides delegate) {
		this.predicate = predicate;
		this.delegate = delegate;
	}

	@Override
	public Boolean getVisible(IContributionItem item) {
		if (item.isVisible() && predicate.test(item)) {
			return false;
		}
		return delegate == null ? null : delegate.getVisible(item);
	}

	@Override
	public Boolean getEnabled(IContributionItem item) {
		return delegate == null ? null : delegate.getEnabled(item);
	}

	@Override
	public Integer getAccelerator(IContributionItem item) {
		return delegate == null ? null : delegate.getAccelerator(item);
	}

	@Override
	public String getAcceleratorText(IContributionItem item) {
		return delegate == null ? null : delegate.getAcceleratorText(item);
	}

	@Override
	public String getText(IContributionItem item) {
		return delegate == null ? null : delegate.getText(item);
	}
}
