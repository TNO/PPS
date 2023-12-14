/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.analysis.ui.rendering;

import java.awt.geom.Point2D;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.analysis.ActivityAnalysis;
import nl.esi.pps.tmsc.analysis.CriticalPathAnalysis;
import nl.esi.pps.tmsc.analysis.RootCauseAnalysis;
import nl.esi.pps.tmsc.analysis.TimeBoundOutlierAnalysis;
import nl.esi.pps.tmsc.rendering.plot.EnumRenderingStrategy;
import nl.esi.pps.tmsc.viewers.plot.DependenciesRenderer;
import nl.esi.pps.tmsc.viewers.plot.DependencyDataItem;
import nl.esi.pps.tmsc.viewers.plot.ExecutionsRenderer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.trace4cps.common.jfreechart.data.xy.XYEdgeSeriesCollection;
import org.jfree.data.xy.XYIntervalSeriesCollection;

@SuppressWarnings("all")
public class CriticalPathRenderingStrategy extends EnumRenderingStrategy<EnumRenderingStrategy.VoidRenderingKey, CriticalPathRenderingKey> {
  public static final String ID = "nl.esi.pps.tmsc.analysis.ui.rendering.critical_path";
  
  public CriticalPathRenderingStrategy() {
    super(EnumRenderingStrategy.VoidRenderingKey.class, CriticalPathRenderingKey.class);
  }
  
  @Override
  protected EnumRenderingStrategy.VoidRenderingKey getRenderingKey(final Execution execution) {
    return null;
  }
  
  @Override
  protected CriticalPathRenderingKey getRenderingKey(final Dependency dependency) {
    CriticalPathRenderingKey _switchResult = null;
    final Dependency it = dependency;
    boolean _matched = false;
    if ((RootCauseAnalysis.isRootCause(it) && ActivityAnalysis.isResourceSharing(it))) {
      _matched=true;
      _switchResult = CriticalPathRenderingKey.ROOT_CAUSE_SERVICE;
    }
    if (!_matched) {
      boolean _isRootCause = RootCauseAnalysis.isRootCause(it);
      if (_isRootCause) {
        _matched=true;
        _switchResult = CriticalPathRenderingKey.ROOT_CAUSE_RESOURCE;
      }
    }
    if (!_matched) {
      if ((this.isCriticalOutlier(it) && ActivityAnalysis.isResourceSharing(it))) {
        _matched=true;
        _switchResult = CriticalPathRenderingKey.OUTLIER_SERVICE;
      }
    }
    if (!_matched) {
      boolean _isCriticalOutlier = this.isCriticalOutlier(it);
      if (_isCriticalOutlier) {
        _matched=true;
        _switchResult = CriticalPathRenderingKey.OUTLIER_RESOURCE;
      }
    }
    if (!_matched) {
      if ((CriticalPathAnalysis.isCritical(it) && ActivityAnalysis.isResourceSharing(it))) {
        _matched=true;
        _switchResult = CriticalPathRenderingKey.CRITICAL_SERVICE;
      }
    }
    if (!_matched) {
      boolean _isCritical = CriticalPathAnalysis.isCritical(it);
      if (_isCritical) {
        _matched=true;
        _switchResult = CriticalPathRenderingKey.CRITICAL_RESOURCE;
      }
    }
    return _switchResult;
  }
  
  private boolean isCriticalOutlier(final Dependency dependency) {
    return ((CriticalPathAnalysis.isCritical(dependency) && TimeBoundOutlierAnalysis.isSetTimeBoundOutlierThreshold(dependency)) && 
      (dependency.getTimeBound().compareTo(TimeBoundOutlierAnalysis.getTimeBoundOutlierThreshold(dependency)) > 0));
  }
  
  @Override
  public boolean select(final Viewer viewer, final Object parentElement, final Object element) {
    boolean _xblockexpression = false;
    {
      if ((element instanceof Dependency)) {
        if ((CriticalPathAnalysis.isCritical(((Dependency)element)) || RootCauseAnalysis.isRootCause(((Dependency)element)))) {
          return true;
        }
      }
      _xblockexpression = super.select(viewer, parentElement, element);
    }
    return _xblockexpression;
  }
  
  @Override
  public void add(final DependencyDataItem dependencyDataItem, final XYEdgeSeriesCollection dependenciesDataset, final DependenciesRenderer dependenciesRenderer) {
    DependencyDataItem dataItem = dependencyDataItem;
    boolean _isEpoch = ActivityAnalysis.isEpoch(dependencyDataItem.getBackReference());
    if (_isEpoch) {
      double _x0Value = dependencyDataItem.getX0Value();
      double _y1Value = dependencyDataItem.getY1Value();
      Point2D.Double _double = new Point2D.Double(_x0Value, _y1Value);
      double _x1Value = dependencyDataItem.getX1Value();
      double _y1Value_1 = dependencyDataItem.getY1Value();
      Point2D.Double _double_1 = new Point2D.Double(_x1Value, _y1Value_1);
      Dependency _backReference = dependencyDataItem.getBackReference();
      DependencyDataItem _dependencyDataItem = new DependencyDataItem(_double, _double_1, _backReference);
      dataItem = _dependencyDataItem;
    }
    super.add(dataItem, dependenciesDataset, dependenciesRenderer);
  }
  
  @Override
  protected void hideEmptySeriesInLegend(final XYEdgeSeriesCollection dependenciesDataset, final DependenciesRenderer dependenciesRenderer, final XYIntervalSeriesCollection executionsDataset, final ExecutionsRenderer executionsRenderer) {
    super.hideEmptySeriesInLegend(dependenciesDataset, dependenciesRenderer, executionsDataset, executionsRenderer);
    int _itemCount = dependenciesDataset.getItemCount(this.getSeries(CriticalPathRenderingKey.CRITICAL_SERVICE));
    boolean _greaterThan = (_itemCount > 0);
    if (_greaterThan) {
      dependenciesRenderer.setSeriesVisibleInLegend(this.getSeries(CriticalPathRenderingKey.CRITICAL_RESOURCE), Boolean.valueOf(true), false);
    }
    int _itemCount_1 = dependenciesDataset.getItemCount(this.getSeries(CriticalPathRenderingKey.OUTLIER_SERVICE));
    boolean _greaterThan_1 = (_itemCount_1 > 0);
    if (_greaterThan_1) {
      dependenciesRenderer.setSeriesVisibleInLegend(this.getSeries(CriticalPathRenderingKey.OUTLIER_RESOURCE), Boolean.valueOf(true), false);
    }
    int _itemCount_2 = dependenciesDataset.getItemCount(this.getSeries(CriticalPathRenderingKey.ROOT_CAUSE_SERVICE));
    boolean _greaterThan_2 = (_itemCount_2 > 0);
    if (_greaterThan_2) {
      dependenciesRenderer.setSeriesVisibleInLegend(this.getSeries(CriticalPathRenderingKey.ROOT_CAUSE_RESOURCE), Boolean.valueOf(true), false);
    }
  }
}
