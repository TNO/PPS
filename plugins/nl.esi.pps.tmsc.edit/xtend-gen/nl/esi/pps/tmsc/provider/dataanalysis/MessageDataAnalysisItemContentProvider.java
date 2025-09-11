/**
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.provider.dataanalysis;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import nl.esi.pps.tmsc.Lifeline;
import nl.esi.pps.tmsc.Message;
import nl.esi.pps.tmsc.util.TmscQueries;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * {@link Message} supports data analysis by providing this {@link IDataAnalysisItemContentProvider}.
 */
@SuppressWarnings("all")
public class MessageDataAnalysisItemContentProvider implements IDataAnalysisItemContentProvider {
  @Override
  public Set<String> getConfigurations(final Object object) {
    final Message message = ((Message) object);
    Set<String> _xifexpression = null;
    Lifeline _lifeline = message.getSource().getLifeline();
    Lifeline _lifeline_1 = message.getTarget().getLifeline();
    boolean _notEquals = (!Objects.equals(_lifeline, _lifeline_1));
    if (_notEquals) {
      _xifexpression = Collections.<String>singleton(IDataAnalysisItemContentProvider.DEFAULT_CONFIGURATION);
    }
    return _xifexpression;
  }

  @Override
  public String getTitle(final Object object, final String configuration) {
    final Message message = ((Message) object);
    StringConcatenation _builder = new StringConcatenation();
    String _name = message.eClass().getName();
    _builder.append(_name);
    _builder.append(" between ");
    String _name_1 = message.getSource().getLifeline().getExecutor().getName();
    _builder.append(_name_1);
    _builder.append(" and ");
    String _name_2 = message.getTarget().getLifeline().getExecutor().getName();
    _builder.append(_name_2);
    return _builder.toString();
  }

  @Override
  public Iterable<?> getSiblings(final Object object, final String configuration) {
    return TmscQueries.<Message>findAllOfTypeBetweenLifelines(((Message) object));
  }

  @Override
  public Long getDuration(final Object object, final Object sibling, final String configuration) {
    final Message message = ((Message) sibling);
    Long _xifexpression = null;
    boolean _isFullyTraced = TmscQueries.isFullyTraced(message);
    if (_isFullyTraced) {
      _xifexpression = message.getDuration();
    }
    return _xifexpression;
  }
}
