/**
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.xtext;

import nl.esi.emf.properties.PropertiesContainer;
import nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextModel;
import nl.esi.pps.tmsc.xtext.tmscXtext.XDependency;
import nl.esi.pps.tmsc.xtext.tmscXtext.XDependencySettings;
import nl.esi.pps.tmsc.xtext.tmscXtext.XDependencyType;
import nl.esi.pps.tmsc.xtext.tmscXtext.XDependencyTypeObject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.EcoreUtil2;

@SuppressWarnings("all")
public class TmscXtextQueries {
  private TmscXtextQueries() {
  }

  public static XDependencyType getType(final XDependency xDependency) {
    if ((xDependency == null)) {
      return null;
    } else {
      XDependencyTypeObject _typeObject = xDependency.getTypeObject();
      boolean _tripleNotEquals = (_typeObject != null);
      if (_tripleNotEquals) {
        return xDependency.getTypeObject().getValue();
      }
    }
    final TmscXtextModel model = EcoreUtil2.<TmscXtextModel>getContainerOfType(xDependency, TmscXtextModel.class);
    if (((xDependency.getName() != null) && (model != null))) {
      EList<XDependencySettings> _dependencySettings = model.getDependencySettings();
      for (final XDependencySettings dependencySettings : _dependencySettings) {
        if (((dependencySettings.getPrefix() != null) && xDependency.getName().startsWith(dependencySettings.getPrefix()))) {
          return dependencySettings.getType();
        }
      }
    }
    return XDependencyType.MESSAGE;
  }

  public static String getXtextName(final PropertiesContainer container) {
    final String key = "xtextName";
    final Object value = container.getProperties().get(key);
    return (String) value;
  }

  public static void setXtextName(final PropertiesContainer container, final String value) {
    final String key = "xtextName";
    if (value == null) {
    container.getProperties().remove(key);
    } else {
        container.getProperties().put(key, value);
    }
  }
}
