/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.emf.ui.action;

import java.util.Map;

public interface IBookmarkProvider {
	String EMF_BOOKMARK_TYPE = "nl.esi.pps.common.emf.bookmark";

	String EMF_BOOKMARK_PAGE_INDEX = "pageIndex";
	String EMF_BOOKMARK_VIEWER_INPUT = "viewerInput";
	String EMF_BOOKMARK_SELECTION = "selection";

	default String getBookmarkType() {
		return EMF_BOOKMARK_TYPE;
	}

	/**
	 * @return true to show dialog to input name, false if
	 *         {@link #getBookmarkName()} value should be used.
	 */
	default boolean askBookmarkName() {
		return true;
	}

	/**
	 * Subclasses should override this method when {@link #askBookmarkName()}
	 * returns <code>false</code>.
	 * 
	 * @return the default bookmark name if {@link #askBookmarkName()} is
	 *         <code>true</code>, the actual bookmark name if
	 *         {@link #askBookmarkName()} is <code>false</code>
	 */
	default String getBookmarkName() {
		return "";
	}

	/**
	 * This method will be called when a bookmark is created for this editor. This
	 * method should return a map with all the attribute values for the bookmark.
	 *
	 * Key: Attribute name as specified in extension point for
	 * {@link #getBookmarkType()} Value type: <code>String</code>,
	 * <code>Integer</code>, <code>Boolean</code> or <code>null</code>.
	 */
	Map<String, Object> createBookmarkAttributes(String bookmarkName);
}
