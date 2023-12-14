/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.common.ide.ui.action;

import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

public class DropDownMenuAction extends Action implements IMenuCreator {
	private final IPropertyChangeListener CHECKED_LISTENER = new IPropertyChangeListener() {
		@Override
		public void propertyChange(PropertyChangeEvent event) {
			if (!IAction.CHECKED.equals(event.getProperty())) {
				return;
			}
			if (Boolean.TRUE.equals(event.getNewValue())) {
				handleActionChecked((IAction) event.getSource());
			} else if (actions.stream().noneMatch(IAction::isChecked)) {
				setImageDescriptor(
						PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJS_WARN_TSK));
			}
		}
	};

	/** The menu associated with this action. */
	private Menu menu;

	/** The menu items. */
	private final List<? extends DropDownAction> actions;
	
	public DropDownMenuAction(String text, DropDownAction... actions) {
		this(text, text, actions);
	}

	public DropDownMenuAction(String text, String toolTipText, DropDownAction... actions) {
		this(text, toolTipText, Arrays.asList(actions));
	}

	public DropDownMenuAction(String text, List<? extends DropDownAction> actions) {
		this(text, text, actions);
	}
	
	public DropDownMenuAction(String text, String toolTipText, List<? extends DropDownAction> actions) {
		super(text, Action.AS_DROP_DOWN_MENU);
		this.actions = actions;
		setMenuCreator(this);
		setToolTipText(toolTipText);
		setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJS_WARN_TSK));

		for (DropDownAction action : actions) {
			action.addPropertyChangeListener(CHECKED_LISTENER);
			if (action.isChecked()) {
				handleActionChecked(action);
			}
		}
	}
	
	protected void handleActionChecked(IAction action) {
		setImageDescriptor(action.getImageDescriptor());
	}
	
	@Override
	public void runWithEvent(Event event) {
		// Show menu on button
		if (event.widget instanceof ToolItem) {
			ToolItem toolItem = (ToolItem) event.widget;
			Control control = toolItem.getParent();
			Menu menu = getMenu(control);

			Rectangle bounds = toolItem.getBounds();
			Point topLeft = new Point(bounds.x, bounds.y + bounds.height);
			menu.setLocation(control.toDisplay(topLeft));
			menu.setVisible(true);
		} else {
			super.runWithEvent(event);
		}
	}

	@Override
	public void dispose() {
		if (null != menu) {
			menu.dispose();
			menu = null;
		}
		for (DropDownAction action : actions) {
			action.removePropertyChangeListener(CHECKED_LISTENER);
		}
	}

	@Override
	public Menu getMenu(Menu parent) {
		if (null != menu) {
			menu.dispose();
		}

		menu = new Menu(parent);
		for (IAction action : actions) {
			addActionToMenu(menu, action);
		}
		return menu;
	}

	@Override
	public Menu getMenu(Control parent) {
		if (null != menu) {
			menu.dispose();
		}

		menu = new Menu(parent);
		for (IAction action : actions) {
			addActionToMenu(menu, action);
		}
		return menu;
	}

	protected void addActionToMenu(Menu parent, IAction action) {
		ActionContributionItem item = new ActionContributionItem(action);
		item.fill(parent, -1);
	}

	public static class DropDownAction extends Action {
		public DropDownAction(String text) {
			super(text, Action.AS_RADIO_BUTTON);
		}

		public DropDownAction(String text, ImageDescriptor image) {
			this(text);
			setImageDescriptor(image);
		}

		@Override
		public final void run() {
			if (isChecked()) {
				runChecked();
			} else {
				runUnchecked();
			}
		}

		protected void runChecked() {
			// do nothing
		}

		protected void runUnchecked() {
			// do nothing
		}
	}
}
