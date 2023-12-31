/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.xtext.ui.outline;

import java.util.function.Consumer;
import nl.esi.pps.tmsc.xtext.tmscXtext.XProperty;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Customization of the default outline structure.
 * 
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#outline
 */
@SuppressWarnings("all")
public class TmscXtextOutlineTreeProvider extends DefaultOutlineTreeProvider {
  @Override
  protected void _createChildren(final IOutlineNode parentNode, final EObject modelElement) {
    final Consumer<EObject> _function = (EObject child) -> {
      this.createNode(parentNode, child);
    };
    this.getChildren(modelElement).forEach(_function);
  }
  
  @Override
  protected boolean _isLeaf(final EObject modelElement) {
    return IterableExtensions.isEmpty(this.getChildren(modelElement));
  }
  
  /**
   * We do not want to show the properties in the outline
   */
  private Iterable<EObject> getChildren(final EObject modelElement) {
    return IterableExtensions.<EObject>reject(modelElement.eContents(), XProperty.class);
  }
}
