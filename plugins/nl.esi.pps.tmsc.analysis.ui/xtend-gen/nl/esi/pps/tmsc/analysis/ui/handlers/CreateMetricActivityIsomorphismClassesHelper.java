package nl.esi.pps.tmsc.analysis.ui.handlers;

import com.google.common.collect.Iterables;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.ScopedTMSC;
import nl.esi.pps.tmsc.compare.ArchitectureLifecycleStage;
import nl.esi.pps.tmsc.compare.TmscIsomorphismMatcher;
import nl.esi.pps.tmsc.metric.Metric;
import nl.esi.pps.tmsc.metric.MetricInstance;
import nl.esi.pps.tmsc.rendering.plot.ScopesRenderingStrategy;
import nl.esi.pps.tmsc.util.TmscQueries;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class CreateMetricActivityIsomorphismClassesHelper {
  private static final DecimalFormat CLASS_FORMAT = new DecimalFormat("000");
  
  public static Iterable<ScopedTMSC> createIsomorphismClasses(final Metric metric, final CreateIntervalActivityStrategy strategy, final ArchitectureLifecycleStage stage) {
    final Function1<MetricInstance, ScopedTMSC> _function = (MetricInstance mi) -> {
      ScopedTMSC _createTMSC = strategy.createTMSC(mi);
      final Procedure1<ScopedTMSC> _function_1 = (ScopedTMSC miTmsc) -> {
        EList<ScopedTMSC> _scopes = mi.getScopes();
        _scopes.add(miTmsc);
        CreateMetricActivityIsomorphismClassesHelper.setIsomorphismType(miTmsc, strategy.getLabel());
        CreateMetricActivityIsomorphismClassesHelper.setIsomorphismStage(miTmsc, stage.getLabel());
        ScopesRenderingStrategy.setGroupKey(miTmsc, false);
      };
      return ObjectExtensions.<ScopedTMSC>operator_doubleArrow(_createTMSC, _function_1);
    };
    final Iterator<ScopedTMSC> metricInstanceTmscs = IteratorExtensions.<MetricInstance, ScopedTMSC>map(metric.getInstances().iterator(), _function);
    final Function1<Pair<Integer, List<ScopedTMSC>>, ScopedTMSC> _function_1 = (Pair<Integer, List<ScopedTMSC>> it) -> {
      ScopedTMSC _xblockexpression = null;
      {
        Integer _key = it.getKey();
        int _plus = ((_key).intValue() + 1);
        final String isomorphismClass = CreateMetricActivityIsomorphismClassesHelper.CLASS_FORMAT.format(_plus);
        final List<ScopedTMSC> isomorphicTmscs = it.getValue();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Isomorphism class ");
        _builder.append(isomorphismClass);
        _builder.append(" ");
        int _size = isomorphicTmscs.size();
        _builder.append(_size);
        _builder.append(" ");
        int _size_1 = IterableExtensions.<ScopedTMSC>head(isomorphicTmscs).getDependencies().size();
        _builder.append(_size_1);
        final String isomorphismClassName = _builder.toString();
        final Consumer<ScopedTMSC> _function_2 = (ScopedTMSC tmsc) -> {
          CreateMetricActivityIsomorphismClassesHelper.setIsomorphismClass(tmsc, isomorphismClass);
        };
        isomorphicTmscs.forEach(_function_2);
        final Function1<ScopedTMSC, EList<Dependency>> _function_3 = (ScopedTMSC it_1) -> {
          return it_1.getDependencies();
        };
        ScopedTMSC _createScopedTMSC = TmscQueries.createScopedTMSC(IterableExtensions.<ScopedTMSC, Dependency>flatMap(isomorphicTmscs, _function_3), isomorphismClassName);
        final Procedure1<ScopedTMSC> _function_4 = (ScopedTMSC groupTmsc) -> {
          EList<ScopedTMSC> _childScopes = groupTmsc.getChildScopes();
          Iterables.<ScopedTMSC>addAll(_childScopes, isomorphicTmscs);
          CreateMetricActivityIsomorphismClassesHelper.setIsomorphismType(groupTmsc, strategy.getLabel());
          CreateMetricActivityIsomorphismClassesHelper.setIsomorphismStage(groupTmsc, stage.getLabel());
          CreateMetricActivityIsomorphismClassesHelper.setIsomorphismClass(groupTmsc, isomorphismClass);
          ScopesRenderingStrategy.setGroupKey(groupTmsc, true);
        };
        _xblockexpression = ObjectExtensions.<ScopedTMSC>operator_doubleArrow(_createScopedTMSC, _function_4);
      }
      return _xblockexpression;
    };
    return IterableExtensions.<Pair<Integer, List<ScopedTMSC>>, ScopedTMSC>map(IterableExtensions.<List<ScopedTMSC>>indexed(TmscIsomorphismMatcher.<ScopedTMSC>findIsomorphismClasses(metricInstanceTmscs, stage)), _function_1);
  }
  
  public static String getIsomorphismType(final ScopedTMSC container) {
    final String key = "isomorphismType";
    final Object value = container.getProperties().get(key);
    return (String) value;
  }
  
  public static void setIsomorphismType(final ScopedTMSC container, final String value) {
    final String key = "isomorphismType";
    if (value == null) {
    container.getProperties().remove(key);
    } else {
        container.getProperties().put(key, value);
    }
  }
  
  public static String getIsomorphismStage(final ScopedTMSC container) {
    final String key = "isomorphismStage";
    final Object value = container.getProperties().get(key);
    return (String) value;
  }
  
  public static void setIsomorphismStage(final ScopedTMSC container, final String value) {
    final String key = "isomorphismStage";
    if (value == null) {
    container.getProperties().remove(key);
    } else {
        container.getProperties().put(key, value);
    }
  }
  
  public static String getIsomorphismClass(final ScopedTMSC container) {
    final String key = "isomorphismClass";
    final Object value = container.getProperties().get(key);
    return (String) value;
  }
  
  public static void setIsomorphismClass(final ScopedTMSC container, final String value) {
    final String key = "isomorphismClass";
    if (value == null) {
    container.getProperties().remove(key);
    } else {
        container.getProperties().put(key, value);
    }
  }
}
