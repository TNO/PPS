/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.common.emf.edit.ui.provider;

import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.EMFEditUIPropertyEditorFactory;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Composite;

public abstract class FormatPropertyEditorFactory extends EMFEditUIPropertyEditorFactory {
	private final Format format;

	public FormatPropertyEditorFactory(Format format, URI uri) {
		super(uri);
		this.format = format;
	}

	@Override
	public IItemLabelProvider createLabelProvider(Object outerObject, IItemPropertyDescriptor propertyDescriptor) {
		return new IItemLabelProvider() {
			@Override
			public String getText(Object innerObject) {
				return format.format(innerObject);
			}

			@Override
			public Object getImage(Object innerObject) {
				return null;
			}
		};
	}

	@Override
	public CellEditor createEditor(Object object, IItemPropertyDescriptor propertyDescriptor, Composite composite) {
		if (propertyDescriptor.canSetProperty(object) && !propertyDescriptor.isMany(object)) {
			return new FormatTextCellEditor(format, composite);
		}
		return createDefaultEditor(object, propertyDescriptor, composite);
	}

	public static class FormatTextCellEditor extends TextCellEditor {
		private final Format format;

		public FormatTextCellEditor(Format format, Composite parent) {
			super(parent);
			this.format = format;
		}

		@Override
		protected void doSetValue(Object value) {
			super.doSetValue(format.format(value));
		}

		@Override
		protected Object doGetValue() {
			try {
				return format.parseObject((String) super.doGetValue());
			} catch (ParseException e) {
				return null;
			}
		}

		@Override
		protected boolean isCorrect(Object value) {
			if (value instanceof String) {
				String toBeValidated = ((String) value).trim();
				ParsePosition position = new ParsePosition(0);
				format.parseObject(toBeValidated, position);
				if (position.getErrorIndex() >= 0) {
					setErrorMessage("Invalid input: \"" + value + "\"");
					return false;
				} else if (position.getIndex() != toBeValidated.length()) {
					setErrorMessage("Invalid input near the end: \""
							+ toBeValidated.substring(position.getIndex()).trim() + "\"");
					return false;
				}
			}
			setErrorMessage(null);
			return true;
		}
	}
}
