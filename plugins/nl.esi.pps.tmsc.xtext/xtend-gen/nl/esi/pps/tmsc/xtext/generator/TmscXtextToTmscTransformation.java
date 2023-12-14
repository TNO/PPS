/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.xtext.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Consumer;
import java.util.stream.Stream;
import nl.esi.emf.properties.PropertiesContainer;
import nl.esi.pps.architecture.ArchitectureModel;
import nl.esi.pps.architecture.NamedArchitectureElement;
import nl.esi.pps.architecture.example.ExampleArchitecture;
import nl.esi.pps.architecture.example.ExampleFactory;
import nl.esi.pps.architecture.example.ExampleHost;
import nl.esi.pps.architecture.implemented.Function;
import nl.esi.pps.architecture.implemented.FunctionParameter;
import nl.esi.pps.architecture.implemented.FunctionParameterKind;
import nl.esi.pps.architecture.implemented.ImplementedFactory;
import nl.esi.pps.architecture.instantiated.Executor;
import nl.esi.pps.architecture.instantiated.InstantiatedFactory;
import nl.esi.pps.architecture.specified.Component;
import nl.esi.pps.architecture.specified.Interface;
import nl.esi.pps.architecture.specified.Operation;
import nl.esi.pps.architecture.specified.SpecifiedFactory;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.EntryEvent;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.Lifeline;
import nl.esi.pps.tmsc.LifelineSegment;
import nl.esi.pps.tmsc.Message;
import nl.esi.pps.tmsc.MessageControl;
import nl.esi.pps.tmsc.Reply;
import nl.esi.pps.tmsc.Request;
import nl.esi.pps.tmsc.TmscFactory;
import nl.esi.pps.tmsc.sort.TmscTopologicalOrder;
import nl.esi.pps.tmsc.util.TmscRefinements;
import nl.esi.pps.tmsc.xtext.TmscXtextQueries;
import nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextModel;
import nl.esi.pps.tmsc.xtext.tmscXtext.XComponent;
import nl.esi.pps.tmsc.xtext.tmscXtext.XDependency;
import nl.esi.pps.tmsc.xtext.tmscXtext.XDependencySettings;
import nl.esi.pps.tmsc.xtext.tmscXtext.XDependencyType;
import nl.esi.pps.tmsc.xtext.tmscXtext.XEvent;
import nl.esi.pps.tmsc.xtext.tmscXtext.XEventArgument;
import nl.esi.pps.tmsc.xtext.tmscXtext.XEventType;
import nl.esi.pps.tmsc.xtext.tmscXtext.XExecutor;
import nl.esi.pps.tmsc.xtext.tmscXtext.XFunction;
import nl.esi.pps.tmsc.xtext.tmscXtext.XFunctionParameter;
import nl.esi.pps.tmsc.xtext.tmscXtext.XFunctionParameterKind;
import nl.esi.pps.tmsc.xtext.tmscXtext.XHost;
import nl.esi.pps.tmsc.xtext.tmscXtext.XInterface;
import nl.esi.pps.tmsc.xtext.tmscXtext.XNamedArchitectureElement;
import nl.esi.pps.tmsc.xtext.tmscXtext.XOperation;
import nl.esi.pps.tmsc.xtext.tmscXtext.XProperty;
import nl.esi.pps.tmsc.xtext.tmscXtext.XPropertyBooleanValue;
import nl.esi.pps.tmsc.xtext.tmscXtext.XPropertyMutliValue;
import nl.esi.pps.tmsc.xtext.tmscXtext.XPropertyNumberValue;
import nl.esi.pps.tmsc.xtext.tmscXtext.XPropertyStringValue;
import nl.esi.pps.tmsc.xtext.tmscXtext.XPropertyValue;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.lsat.common.xtend.Queries;
import org.eclipse.lsat.common.xtend.annotations.Resolvable;
import org.eclipse.lsat.common.xtend.annotations.Transform;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class TmscXtextToTmscTransformation {
  @Extension
  private static final TmscFactory m_tmsc = TmscFactory.eINSTANCE;
  
  @Extension
  private static final SpecifiedFactory m_arch_spec = SpecifiedFactory.eINSTANCE;
  
  @Extension
  private static final ImplementedFactory m_arch_impl = ImplementedFactory.eINSTANCE;
  
  @Extension
  private static final InstantiatedFactory m_arch_inst = InstantiatedFactory.eINSTANCE;
  
  @Extension
  private static final ExampleFactory m_arch_example = ExampleFactory.eINSTANCE;
  
  @Transform
  private FullScopeTMSC _transform_transform(final TmscXtextModel tmscXtext) {
    ExampleArchitecture _createExampleArchitecture = TmscXtextToTmscTransformation.m_arch_example.createExampleArchitecture();
    final Procedure1<ExampleArchitecture> _function = (ExampleArchitecture it) -> {
      EList<Interface> _interfaces = it.getInterfaces();
      final Function1<XInterface, Interface> _function_1 = (XInterface it_1) -> {
        return this.xInterface2Interface(it_1);
      };
      List<Interface> _map = ListExtensions.<XInterface, Interface>map(tmscXtext.getInterfaces(), _function_1);
      Iterables.<Interface>addAll(_interfaces, _map);
      EList<Component> _components = it.getComponents();
      final Function1<XComponent, Component> _function_2 = (XComponent it_1) -> {
        return this.xComponent2Component(it_1);
      };
      List<Component> _map_1 = ListExtensions.<XComponent, Component>map(tmscXtext.getComponents(), _function_2);
      Iterables.<Component>addAll(_components, _map_1);
      EList<Function> _functions = it.getFunctions();
      final Function1<XFunction, Function> _function_3 = (XFunction it_1) -> {
        return this.xFunction2Function(it_1);
      };
      List<Function> _map_2 = ListExtensions.<XFunction, Function>map(tmscXtext.getFunctions(), _function_3);
      Iterables.<Function>addAll(_functions, _map_2);
      EList<ExampleHost> _hosts = it.getHosts();
      final Function1<XHost, ExampleHost> _function_4 = (XHost it_1) -> {
        return this.xHost2Host(it_1);
      };
      List<ExampleHost> _map_3 = ListExtensions.<XHost, ExampleHost>map(tmscXtext.getHosts(), _function_4);
      Iterables.<ExampleHost>addAll(_hosts, _map_3);
      EList<Executor> _executors = it.getExecutors();
      final Function1<XExecutor, Executor> _function_5 = (XExecutor it_1) -> {
        return this.xExecutor2Executor(it_1);
      };
      List<Executor> _map_4 = ListExtensions.<XExecutor, Executor>map(tmscXtext.getExecutors(), _function_5);
      Iterables.<Executor>addAll(_executors, _map_4);
    };
    final ExampleArchitecture architecture = ObjectExtensions.<ExampleArchitecture>operator_doubleArrow(_createExampleArchitecture, _function);
    final FullScopeTMSC tmsc = this.tmscXtextModel2FullScopeTMSC(tmscXtext);
    EList<ArchitectureModel> _architectures = tmsc.getArchitectures();
    _architectures.add(architecture);
    EList<Component> _components = architecture.getComponents();
    final Function1<Event, Component> _function_1 = (Event it) -> {
      return it.getComponent();
    };
    Iterable<Component> _map = IterableExtensions.<Event, Component>map(tmsc.getEvents(), _function_1);
    Iterables.<Component>addAll(_components, _map);
    return tmsc;
  }
  
  @Resolvable
  private FullScopeTMSC tmscXtextModel2FullScopeTMSC(final TmscXtextModel tmscXtext) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(tmscXtext);
    final FullScopeTMSC _result;
    synchronized (_createCache_tmscXtextModel2FullScopeTMSC) {
      if (_createCache_tmscXtextModel2FullScopeTMSC.containsKey(_cacheKey)) {
        return _createCache_tmscXtextModel2FullScopeTMSC.get(_cacheKey);
      }
      FullScopeTMSC _createFullScopeTMSC = TmscXtextToTmscTransformation.m_tmsc.createFullScopeTMSC();
      _result = _createFullScopeTMSC;
      _createCache_tmscXtextModel2FullScopeTMSC.put(_cacheKey, _result);
    }
    _init_tmscXtextModel2FullScopeTMSC(_result, tmscXtext);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, FullScopeTMSC> _createCache_tmscXtextModel2FullScopeTMSC = CollectionLiterals.newHashMap();
  
  private void _init_tmscXtextModel2FullScopeTMSC(final FullScopeTMSC it, final TmscXtextModel tmscXtext) {
    EList<Lifeline> _lifelines = it.getLifelines();
    final Function1<XHost, EList<XExecutor>> _function = (XHost it_1) -> {
      return it_1.getExecutors();
    };
    final Function1<XExecutor, Lifeline> _function_1 = (XExecutor it_1) -> {
      return this.xExecutor2Lifeline(it_1);
    };
    Iterable<Lifeline> _map = IterableExtensions.<XExecutor, Lifeline>map(Queries.<XExecutor>union(IterableExtensions.<XHost, XExecutor>flatMap(tmscXtext.getHosts(), _function), tmscXtext.getExecutors()), _function_1);
    Iterables.<Lifeline>addAll(_lifelines, _map);
    EList<Dependency> _dependencies = it.getDependencies();
    final Function1<Event, Iterable<Dependency>> _function_2 = (Event it_1) -> {
      EList<Dependency> _fullScopeIncomingDependencies = it_1.getFullScopeIncomingDependencies();
      EList<Dependency> _fullScopeOutgoingDependencies = it_1.getFullScopeOutgoingDependencies();
      return Iterables.<Dependency>concat(_fullScopeIncomingDependencies, _fullScopeOutgoingDependencies);
    };
    Iterable<Dependency> _flatMap = IterableExtensions.<Event, Dependency>flatMap(it.getEvents(), _function_2);
    Iterables.<Dependency>addAll(_dependencies, _flatMap);
    TmscRefinements.refineWithCompleteOrder(it);
    EList<Dependency> _dependencies_1 = it.getDependencies();
    final ArrayList<Dependency> specifiedDependencies = new ArrayList<Dependency>(_dependencies_1);
    TmscRefinements.refineWithCallStacks(it);
    final Consumer<Dependency> _function_3 = (Dependency it_1) -> {
      this.addDependencyDefaults(it_1);
    };
    specifiedDependencies.forEach(_function_3);
    final Function1<Lifeline, EList<Execution>> _function_4 = (Lifeline it_1) -> {
      return it_1.getExecutions();
    };
    final Consumer<Execution> _function_5 = (Execution it_1) -> {
      this.addExecutionDefaults(it_1);
    };
    IterableExtensions.<Lifeline, Execution>flatMap(it.getLifelines(), _function_4).forEach(_function_5);
    final Function1<Event, Boolean> _function_6 = (Event it_1) -> {
      Long _timestamp = it_1.getTimestamp();
      return Boolean.valueOf((_timestamp == null));
    };
    final Function1<Event, Boolean> _function_7 = (Event it_1) -> {
      XEvent _invResolveOne = this.<XEvent>invResolveOne(it_1, XEvent.class);
      return Boolean.valueOf((_invResolveOne == null));
    };
    final Consumer<Event> _function_8 = (Event it_1) -> {
      final Function1<Dependency, Boolean> _function_9 = (Dependency it_2) -> {
        Event _source = it_2.getSource();
        Long _timestamp = null;
        if (_source!=null) {
          _timestamp=_source.getTimestamp();
        }
        return Boolean.valueOf((_timestamp == null));
      };
      final Function1<Dependency, Long> _function_10 = (Dependency it_2) -> {
        Long _timestamp = it_2.getSource().getTimestamp();
        Long _elvis = null;
        Long _timeBound = it_2.getTimeBound();
        if (_timeBound != null) {
          _elvis = _timeBound;
        } else {
          _elvis = Long.valueOf(0L);
        }
        return Long.valueOf(((_timestamp).longValue() + (_elvis).longValue()));
      };
      it_1.setTimestamp(Queries.<Long>max(IterableExtensions.<Dependency, Long>map(IterableExtensions.<Dependency>reject(it_1.getFullScopeIncomingDependencies(), _function_9), _function_10), Long.valueOf(0L)));
    };
    IterableExtensions.<Event>reject(IterableExtensions.<Event>filter(TmscTopologicalOrder.getEventsInTopologicalOrder(it), _function_6), _function_7).forEach(_function_8);
    final Function1<Event, Long> _function_9 = (Event it_1) -> {
      return it_1.getTimestamp();
    };
    final List<Long> timestamps = IterableExtensions.<Long>toList(IterableExtensions.<Long>filterNull(IterableExtensions.<Event, Long>map(it.getEvents(), _function_9)));
    boolean _isEmpty = timestamps.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      it.setStartTime(IterableExtensions.<Long>min(timestamps));
      it.setEndTime(IterableExtensions.<Long>max(timestamps));
    }
    final Function1<Event, Boolean> _function_10 = (Event it_1) -> {
      Long _timestamp = it_1.getTimestamp();
      return Boolean.valueOf((_timestamp == null));
    };
    final Consumer<Event> _function_11 = (Event e) -> {
      Long _xifexpression = null;
      if ((e instanceof EntryEvent)) {
        _xifexpression = it.getStartTime();
      } else {
        _xifexpression = it.getEndTime();
      }
      e.setTimestamp(_xifexpression);
    };
    IterableExtensions.<Event>filter(it.getEvents(), _function_10).forEach(_function_11);
    this.addPropertiesIfAbsent(it, tmscXtext.getProperties());
  }
  
  @Resolvable
  private Interface xInterface2Interface(final XInterface xInterface) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(xInterface);
    final Interface _result;
    synchronized (_createCache_xInterface2Interface) {
      if (_createCache_xInterface2Interface.containsKey(_cacheKey)) {
        return _createCache_xInterface2Interface.get(_cacheKey);
      }
      Interface _createInterface = TmscXtextToTmscTransformation.m_arch_spec.createInterface();
      _result = _createInterface;
      _createCache_xInterface2Interface.put(_cacheKey, _result);
    }
    _init_xInterface2Interface(_result, xInterface);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, Interface> _createCache_xInterface2Interface = CollectionLiterals.newHashMap();
  
  private void _init_xInterface2Interface(final Interface it, final XInterface xInterface) {
    this.handleXNamedArchitectureElement(it, xInterface);
    EList<Operation> _operations = it.getOperations();
    final Function1<XOperation, Operation> _function = (XOperation it_1) -> {
      return this.xOperation2Operation(it_1);
    };
    List<Operation> _map = ListExtensions.<XOperation, Operation>map(xInterface.getOperations(), _function);
    Iterables.<Operation>addAll(_operations, _map);
  }
  
  @Resolvable
  private Operation xOperation2Operation(final XOperation xOperation) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(xOperation);
    final Operation _result;
    synchronized (_createCache_xOperation2Operation) {
      if (_createCache_xOperation2Operation.containsKey(_cacheKey)) {
        return _createCache_xOperation2Operation.get(_cacheKey);
      }
      Operation _createOperation = TmscXtextToTmscTransformation.m_arch_spec.createOperation();
      _result = _createOperation;
      _createCache_xOperation2Operation.put(_cacheKey, _result);
    }
    _init_xOperation2Operation(_result, xOperation);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, Operation> _createCache_xOperation2Operation = CollectionLiterals.newHashMap();
  
  private void _init_xOperation2Operation(final Operation it, final XOperation xOperation) {
    this.handleXNamedArchitectureElement(it, xOperation);
  }
  
  @Resolvable
  private Component xComponent2Component(final XComponent xComponent) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(xComponent);
    final Component _result;
    synchronized (_createCache_xComponent2Component) {
      if (_createCache_xComponent2Component.containsKey(_cacheKey)) {
        return _createCache_xComponent2Component.get(_cacheKey);
      }
      Component _createComponent = TmscXtextToTmscTransformation.m_arch_spec.createComponent();
      _result = _createComponent;
      _createCache_xComponent2Component.put(_cacheKey, _result);
    }
    _init_xComponent2Component(_result, xComponent);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, Component> _createCache_xComponent2Component = CollectionLiterals.newHashMap();
  
  private void _init_xComponent2Component(final Component it, final XComponent xComponent) {
    this.handleXNamedArchitectureElement(it, xComponent);
    EList<Interface> _providedInterfaces = it.getProvidedInterfaces();
    final Function1<XInterface, Interface> _function = (XInterface it_1) -> {
      return this.<Interface>resolveOne(it_1, Interface.class);
    };
    List<Interface> _map = ListExtensions.<XInterface, Interface>map(xComponent.getProvides(), _function);
    Iterables.<Interface>addAll(_providedInterfaces, _map);
    EList<Interface> _requiredInterfaces = it.getRequiredInterfaces();
    final Function1<XInterface, Interface> _function_1 = (XInterface it_1) -> {
      return this.<Interface>resolveOne(it_1, Interface.class);
    };
    List<Interface> _map_1 = ListExtensions.<XInterface, Interface>map(xComponent.getRequires(), _function_1);
    Iterables.<Interface>addAll(_requiredInterfaces, _map_1);
  }
  
  @Resolvable
  private Function xFunction2Function(final XFunction xFunction) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(xFunction);
    final Function _result;
    synchronized (_createCache_xFunction2Function) {
      if (_createCache_xFunction2Function.containsKey(_cacheKey)) {
        return _createCache_xFunction2Function.get(_cacheKey);
      }
      Function _createFunction = this.createFunction(xFunction);
      _result = _createFunction;
      _createCache_xFunction2Function.put(_cacheKey, _result);
    }
    _init_xFunction2Function(_result, xFunction);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, Function> _createCache_xFunction2Function = CollectionLiterals.newHashMap();
  
  private void _init_xFunction2Function(final Function it, final XFunction xFunction) {
    this.handleXNamedArchitectureElement(it, xFunction);
    EList<FunctionParameter> _parameters = it.getParameters();
    final Function1<XFunctionParameter, FunctionParameter> _function = (XFunctionParameter it_1) -> {
      return this.xFunctionParameter2FunctionParameter(it_1);
    };
    List<FunctionParameter> _map = ListExtensions.<XFunctionParameter, FunctionParameter>map(xFunction.getParameters(), _function);
    Iterables.<FunctionParameter>addAll(_parameters, _map);
    XOperation _operation = xFunction.getOperation();
    Operation _resolveOne = null;
    if (_operation!=null) {
      _resolveOne=this.<Operation>resolveOne(_operation, Operation.class);
    }
    it.setOperation(_resolveOne);
  }
  
  private Function createFunction(final XFunction xFunction) {
    Function _switchResult = null;
    boolean _matched = false;
    boolean _isIpcClient = xFunction.isIpcClient();
    if (_isIpcClient) {
      _matched=true;
      _switchResult = TmscXtextToTmscTransformation.m_arch_impl.createIPCClientFunction();
    }
    if (!_matched) {
      boolean _isIpcServer = xFunction.isIpcServer();
      if (_isIpcServer) {
        _matched=true;
        _switchResult = TmscXtextToTmscTransformation.m_arch_impl.createIPCServerFunction();
      }
    }
    if (!_matched) {
      _switchResult = TmscXtextToTmscTransformation.m_arch_impl.createFunction();
    }
    return _switchResult;
  }
  
  @Resolvable
  private FunctionParameter xFunctionParameter2FunctionParameter(final XFunctionParameter xFunctionParameter) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(xFunctionParameter);
    final FunctionParameter _result;
    synchronized (_createCache_xFunctionParameter2FunctionParameter) {
      if (_createCache_xFunctionParameter2FunctionParameter.containsKey(_cacheKey)) {
        return _createCache_xFunctionParameter2FunctionParameter.get(_cacheKey);
      }
      FunctionParameter _createFunctionParameter = TmscXtextToTmscTransformation.m_arch_impl.createFunctionParameter();
      _result = _createFunctionParameter;
      _createCache_xFunctionParameter2FunctionParameter.put(_cacheKey, _result);
    }
    _init_xFunctionParameter2FunctionParameter(_result, xFunctionParameter);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, FunctionParameter> _createCache_xFunctionParameter2FunctionParameter = CollectionLiterals.newHashMap();
  
  private void _init_xFunctionParameter2FunctionParameter(final FunctionParameter it, final XFunctionParameter xFunctionParameter) {
    it.setName(xFunctionParameter.getName());
    FunctionParameterKind _switchResult = null;
    XFunctionParameterKind _kind = xFunctionParameter.getKind();
    if (_kind != null) {
      switch (_kind) {
        case IN:
          _switchResult = FunctionParameterKind.IN;
          break;
        case OUT:
          _switchResult = FunctionParameterKind.OUT;
          break;
        case IN_OUT:
          _switchResult = FunctionParameterKind.IN_OUT;
          break;
        case RETURN:
          _switchResult = FunctionParameterKind.RETURN;
          break;
        default:
          break;
      }
    }
    it.setKind(_switchResult);
    this.addPropertiesIfAbsent(it, xFunctionParameter.getProperties());
  }
  
  private ExampleHost xHost2Host(final XHost xHost) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(xHost);
    final ExampleHost _result;
    synchronized (_createCache_xHost2Host) {
      if (_createCache_xHost2Host.containsKey(_cacheKey)) {
        return _createCache_xHost2Host.get(_cacheKey);
      }
      ExampleHost _createExampleHost = TmscXtextToTmscTransformation.m_arch_example.createExampleHost();
      _result = _createExampleHost;
      _createCache_xHost2Host.put(_cacheKey, _result);
    }
    _init_xHost2Host(_result, xHost);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, ExampleHost> _createCache_xHost2Host = CollectionLiterals.newHashMap();
  
  private void _init_xHost2Host(final ExampleHost it, final XHost xHost) {
    this.handleXNamedArchitectureElement(it, xHost);
    EList<Executor> _executors = it.getExecutors();
    final Function1<XExecutor, Executor> _function = (XExecutor it_1) -> {
      return this.xExecutor2Executor(it_1);
    };
    List<Executor> _map = ListExtensions.<XExecutor, Executor>map(xHost.getExecutors(), _function);
    Iterables.<Executor>addAll(_executors, _map);
  }
  
  @Resolvable
  private Executor xExecutor2Executor(final XExecutor xExecutor) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(xExecutor);
    final Executor _result;
    synchronized (_createCache_xExecutor2Executor) {
      if (_createCache_xExecutor2Executor.containsKey(_cacheKey)) {
        return _createCache_xExecutor2Executor.get(_cacheKey);
      }
      Executor _createExecutor = TmscXtextToTmscTransformation.m_arch_inst.createExecutor();
      _result = _createExecutor;
      _createCache_xExecutor2Executor.put(_cacheKey, _result);
    }
    _init_xExecutor2Executor(_result, xExecutor);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, Executor> _createCache_xExecutor2Executor = CollectionLiterals.newHashMap();
  
  private void _init_xExecutor2Executor(final Executor it, final XExecutor xExecutor) {
    this.handleXNamedArchitectureElement(it, xExecutor);
  }
  
  private void handleXNamedArchitectureElement(final NamedArchitectureElement element, final XNamedArchitectureElement xElement) {
    String _description = xElement.getDescription();
    boolean _tripleEquals = (_description == null);
    if (_tripleEquals) {
      element.setName(xElement.getName());
    } else {
      element.setName(xElement.getDescription());
      TmscXtextQueries.setXtextName(element, xElement.getName());
    }
    this.addPropertiesIfAbsent(element, xElement.getProperties());
  }
  
  @Resolvable
  private Lifeline xExecutor2Lifeline(final XExecutor xExecutor) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(xExecutor);
    final Lifeline _result;
    synchronized (_createCache_xExecutor2Lifeline) {
      if (_createCache_xExecutor2Lifeline.containsKey(_cacheKey)) {
        return _createCache_xExecutor2Lifeline.get(_cacheKey);
      }
      Lifeline _createLifeline = TmscXtextToTmscTransformation.m_tmsc.createLifeline();
      _result = _createLifeline;
      _createCache_xExecutor2Lifeline.put(_cacheKey, _result);
    }
    _init_xExecutor2Lifeline(_result, xExecutor);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, Lifeline> _createCache_xExecutor2Lifeline = CollectionLiterals.newHashMap();
  
  private void _init_xExecutor2Lifeline(final Lifeline it, final XExecutor xExecutor) {
    it.setExecutor(this.<Executor>resolveOne(xExecutor, Executor.class));
    EList<Event> _events = it.getEvents();
    final Function1<XEvent, Boolean> _function = (XEvent it_1) -> {
      XExecutor _executor = it_1.getExecutor();
      return Boolean.valueOf(Objects.equal(_executor, xExecutor));
    };
    final Function1<XEvent, Event> _function_1 = (XEvent it_1) -> {
      return this.xEvent2Event(it_1);
    };
    Iterable<Event> _map = IterableExtensions.<XEvent, Event>map(IterableExtensions.<XEvent>filter(EcoreUtil2.<TmscXtextModel>getContainerOfType(xExecutor, TmscXtextModel.class).getEvents(), _function), _function_1);
    Iterables.<Event>addAll(_events, _map);
    boolean _isUntraced = xExecutor.isUntraced();
    if (_isUntraced) {
      final Consumer<Event> _function_2 = (Event it_1) -> {
        it_1.setTraced(false);
      };
      it.getEvents().forEach(_function_2);
    }
    this.addPropertiesIfAbsent(it, xExecutor.getProperties());
    EObject _eContainer = xExecutor.eContainer();
    if ((_eContainer instanceof XHost)) {
      EObject _eContainer_1 = xExecutor.eContainer();
      this.addPropertiesIfAbsent(it, ((XHost) _eContainer_1).getProperties());
    }
  }
  
  @Resolvable
  private Event xEvent2Event(final XEvent xEvent) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(xEvent);
    final Event _result;
    synchronized (_createCache_xEvent2Event) {
      if (_createCache_xEvent2Event.containsKey(_cacheKey)) {
        return _createCache_xEvent2Event.get(_cacheKey);
      }
      Event _createEvent = this.createEvent(xEvent.getType());
      _result = _createEvent;
      _createCache_xEvent2Event.put(_cacheKey, _result);
    }
    _init_xEvent2Event(_result, xEvent);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, Event> _createCache_xEvent2Event = CollectionLiterals.newHashMap();
  
  private void _init_xEvent2Event(final Event it, final XEvent xEvent) {
    it.setTimestamp(TmscXtextToTmscTransformation.toNanos(xEvent.getTimestamp()));
    it.setLifeline(this.<Lifeline>resolveOne(xEvent.getExecutor(), Lifeline.class));
    Component _elvis = null;
    XComponent _component = xEvent.getComponent();
    Component _resolveOne = null;
    if (_component!=null) {
      _resolveOne=this.<Component>resolveOne(_component, Component.class);
    }
    if (_resolveOne != null) {
      _elvis = _resolveOne;
    } else {
      Component _xExecutor2Component = this.xExecutor2Component(xEvent.getExecutor());
      _elvis = _xExecutor2Component;
    }
    it.setComponent(_elvis);
    it.setFunction(this.<Function>resolveOne(xEvent.getFunction(), Function.class));
    EList<Dependency> _fullScopeOutgoingDependencies = it.getFullScopeOutgoingDependencies();
    final Function1<XDependency, Dependency> _function = (XDependency it_1) -> {
      return this.xDependency2Dependency(it_1);
    };
    List<Dependency> _map = ListExtensions.<XDependency, Dependency>map(xEvent.getOutgoingDependencies(), _function);
    Iterables.<Dependency>addAll(_fullScopeOutgoingDependencies, _map);
    EList<Dependency> _fullScopeIncomingDependencies = it.getFullScopeIncomingDependencies();
    final Function1<XDependency, Dependency> _function_1 = (XDependency it_1) -> {
      return this.xDependency2Dependency(it_1);
    };
    List<Dependency> _map_1 = ListExtensions.<XDependency, Dependency>map(xEvent.getIncomingDependencies(), _function_1);
    Iterables.<Dependency>addAll(_fullScopeIncomingDependencies, _map_1);
    final Consumer<XEventArgument> _function_2 = (XEventArgument arg) -> {
      it.getArguments().put(this.<FunctionParameter>resolveOne(arg.getParameter(), FunctionParameter.class), arg.getValue());
    };
    xEvent.getArguments().forEach(_function_2);
    this.addPropertiesIfAbsent(it, xEvent.getProperties());
  }
  
  private Event createEvent(final XEventType type) {
    Event _switchResult = null;
    if (type != null) {
      switch (type) {
        case ENTRY:
          _switchResult = TmscXtextToTmscTransformation.m_tmsc.createEntryEvent();
          break;
        case EXIT:
          _switchResult = TmscXtextToTmscTransformation.m_tmsc.createExitEvent();
          break;
        default:
          break;
      }
    }
    return _switchResult;
  }
  
  private Component xExecutor2Component(final XExecutor xExecutor) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(xExecutor);
    final Component _result;
    synchronized (_createCache_xExecutor2Component) {
      if (_createCache_xExecutor2Component.containsKey(_cacheKey)) {
        return _createCache_xExecutor2Component.get(_cacheKey);
      }
      Component _createComponent = TmscXtextToTmscTransformation.m_arch_spec.createComponent();
      _result = _createComponent;
      _createCache_xExecutor2Component.put(_cacheKey, _result);
    }
    _init_xExecutor2Component(_result, xExecutor);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, Component> _createCache_xExecutor2Component = CollectionLiterals.newHashMap();
  
  private void _init_xExecutor2Component(final Component it, final XExecutor xExecutor) {
    String _elvis = null;
    String _description = xExecutor.getDescription();
    if (_description != null) {
      _elvis = _description;
    } else {
      String _name = xExecutor.getName();
      _elvis = _name;
    }
    it.setName(_elvis);
  }
  
  @Resolvable
  private Dependency xDependency2Dependency(final XDependency xDependency) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(xDependency);
    final Dependency _result;
    synchronized (_createCache_xDependency2Dependency) {
      if (_createCache_xDependency2Dependency.containsKey(_cacheKey)) {
        return _createCache_xDependency2Dependency.get(_cacheKey);
      }
      Dependency _createDependency = this.createDependency(xDependency);
      _result = _createDependency;
      _createCache_xDependency2Dependency.put(_cacheKey, _result);
    }
    _init_xDependency2Dependency(_result, xDependency);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, Dependency> _createCache_xDependency2Dependency = CollectionLiterals.newHashMap();
  
  private void _init_xDependency2Dependency(final Dependency it, final XDependency xDependency) {
    BigDecimal _timeBound = xDependency.getTimeBound();
    boolean _tripleNotEquals = (_timeBound != null);
    if (_tripleNotEquals) {
      it.setTimeBound(TmscXtextToTmscTransformation.toNanos(xDependency.getTimeBound()));
    }
    Boolean _scheduled = xDependency.getScheduled();
    boolean _tripleNotEquals_1 = (_scheduled != null);
    if (_tripleNotEquals_1) {
      it.setScheduled(xDependency.getScheduled());
    }
    TmscXtextQueries.setXtextName(it, xDependency.getName());
    this.addPropertiesIfAbsent(it, xDependency.getProperties());
  }
  
  private Dependency createDependency(final XDependency xDependency) {
    Dependency _switchResult = null;
    XDependencyType _type = TmscXtextQueries.getType(xDependency);
    if (_type != null) {
      switch (_type) {
        case DOMAIN:
          _switchResult = TmscXtextToTmscTransformation.m_tmsc.createDomainDependency();
          break;
        case REQUEST:
          _switchResult = TmscXtextToTmscTransformation.m_tmsc.createRequest();
          break;
        case REPLY:
          Reply _createReply = TmscXtextToTmscTransformation.m_tmsc.createReply();
          final Procedure1<Reply> _function = (Reply it) -> {
            final Runnable _function_1 = () -> {
              it.setRequest(this.<Request>resolveOne(xDependency.getRequest(), Request.class));
            };
            this.late(_function_1);
          };
          _switchResult = ObjectExtensions.<Reply>operator_doubleArrow(_createReply, _function);
          break;
        case LIFELINE_SEGMENT:
          _switchResult = TmscXtextToTmscTransformation.m_tmsc.createLifelineSegment();
          break;
        case MESSAGE_CONTROL:
          MessageControl _createMessageControl = TmscXtextToTmscTransformation.m_tmsc.createMessageControl();
          final Procedure1<MessageControl> _function_1 = (MessageControl it) -> {
            final Runnable _function_2 = () -> {
              it.setMessage(this.<Message>resolveOne(xDependency.getMessage(), Message.class));
            };
            this.late(_function_2);
          };
          _switchResult = ObjectExtensions.<MessageControl>operator_doubleArrow(_createMessageControl, _function_1);
          break;
        default:
          _switchResult = TmscXtextToTmscTransformation.m_tmsc.createMessage();
          break;
      }
    } else {
      _switchResult = TmscXtextToTmscTransformation.m_tmsc.createMessage();
    }
    return _switchResult;
  }
  
  private void addDependencyDefaults(final Dependency dependency) {
    if ((dependency instanceof Execution)) {
      throw new IllegalArgumentException("Execution is not expected for this method");
    }
    XDependencyType _elvis = null;
    XDependency _invResolveOne = this.<XDependency>invResolveOne(dependency, XDependency.class);
    XDependencyType _type = null;
    if (_invResolveOne!=null) {
      _type=TmscXtextQueries.getType(_invResolveOne);
    }
    if (_type != null) {
      _elvis = _type;
    } else {
      _elvis = XDependencyType.LIFELINE_SEGMENT;
    }
    final XDependencyType dependencyType = _elvis;
    final Function1<XDependencySettings, Boolean> _function = (XDependencySettings it) -> {
      XDependencyType _type_1 = it.getType();
      return Boolean.valueOf(Objects.equal(_type_1, dependencyType));
    };
    final XDependencySettings dependencySettings = IterableExtensions.<XDependencySettings>findFirst(this.<TmscXtextModel>invResolveOne(dependency.getTmsc(), TmscXtextModel.class).getDependencySettings(), _function);
    final TmscXtextModel tmscSettings = this.<TmscXtextModel>invResolveOne(dependency.getTmsc(), TmscXtextModel.class);
    Long _timeBound = dependency.getTimeBound();
    boolean _tripleEquals = (_timeBound == null);
    if (_tripleEquals) {
      BigDecimal _xifexpression = null;
      if ((dependency instanceof LifelineSegment)) {
        BigDecimal _elvis_1 = null;
        BigDecimal _elvis_2 = null;
        BigDecimal _elvis_3 = null;
        BigDecimal _elvis_4 = null;
        BigDecimal _elvis_5 = null;
        BigDecimal _elvis_6 = null;
        XEvent _invResolveOne_1 = this.<XEvent>invResolveOne(((LifelineSegment)dependency).getTarget(), XEvent.class);
        BigDecimal _timeBound_1 = null;
        if (_invResolveOne_1!=null) {
          _timeBound_1=_invResolveOne_1.getTimeBound();
        }
        if (_timeBound_1 != null) {
          _elvis_6 = _timeBound_1;
        } else {
          Execution _activeExecution = ((LifelineSegment)dependency).getActiveExecution();
          Function _function_1 = null;
          if (_activeExecution!=null) {
            _function_1=_activeExecution.getFunction();
          }
          XFunction _invResolveOne_2 = null;
          if (_function_1!=null) {
            _invResolveOne_2=this.<XFunction>invResolveOne(_function_1, XFunction.class);
          }
          BigDecimal _timeBound_2 = null;
          if (_invResolveOne_2!=null) {
            _timeBound_2=_invResolveOne_2.getTimeBound();
          }
          _elvis_6 = _timeBound_2;
        }
        if (_elvis_6 != null) {
          _elvis_5 = _elvis_6;
        } else {
          Execution _activeExecution_1 = ((LifelineSegment)dependency).getActiveExecution();
          Component _component = null;
          if (_activeExecution_1!=null) {
            _component=_activeExecution_1.getComponent();
          }
          XComponent _invResolveOne_3 = null;
          if (_component!=null) {
            _invResolveOne_3=this.<XComponent>invResolveOne(_component, XComponent.class);
          }
          BigDecimal _timeBound_3 = null;
          if (_invResolveOne_3!=null) {
            _timeBound_3=_invResolveOne_3.getTimeBound();
          }
          _elvis_5 = _timeBound_3;
        }
        if (_elvis_5 != null) {
          _elvis_4 = _elvis_5;
        } else {
          BigDecimal _timeBound_4 = this.<XExecutor>invResolveOne(((LifelineSegment)dependency).getSource().getLifeline(), XExecutor.class).getTimeBound();
          _elvis_4 = _timeBound_4;
        }
        if (_elvis_4 != null) {
          _elvis_3 = _elvis_4;
        } else {
          XHost _containerOfType = EcoreUtil2.<XHost>getContainerOfType(this.<XExecutor>invResolveOne(((LifelineSegment)dependency).getSource().getLifeline(), XExecutor.class), XHost.class);
          BigDecimal _timeBound_5 = null;
          if (_containerOfType!=null) {
            _timeBound_5=_containerOfType.getTimeBound();
          }
          _elvis_3 = _timeBound_5;
        }
        if (_elvis_3 != null) {
          _elvis_2 = _elvis_3;
        } else {
          BigDecimal _timeBound_6 = null;
          if (dependencySettings!=null) {
            _timeBound_6=dependencySettings.getTimeBound();
          }
          _elvis_2 = _timeBound_6;
        }
        if (_elvis_2 != null) {
          _elvis_1 = _elvis_2;
        } else {
          BigDecimal _timeBound_7 = tmscSettings.getTimeBound();
          _elvis_1 = _timeBound_7;
        }
        _xifexpression = _elvis_1;
      } else {
        BigDecimal _elvis_7 = null;
        BigDecimal _timeBound_8 = null;
        if (dependencySettings!=null) {
          _timeBound_8=dependencySettings.getTimeBound();
        }
        if (_timeBound_8 != null) {
          _elvis_7 = _timeBound_8;
        } else {
          BigDecimal _timeBound_9 = tmscSettings.getTimeBound();
          _elvis_7 = _timeBound_9;
        }
        _xifexpression = _elvis_7;
      }
      final BigDecimal timeBound = _xifexpression;
      dependency.setTimeBound(TmscXtextToTmscTransformation.toNanos(timeBound));
    }
    Boolean _scheduled = dependency.getScheduled();
    boolean _tripleEquals_1 = (_scheduled == null);
    if (_tripleEquals_1) {
      Boolean _xifexpression_1 = null;
      if ((dependency instanceof LifelineSegment)) {
        Boolean _elvis_8 = null;
        Boolean _elvis_9 = null;
        Boolean _elvis_10 = null;
        Boolean _elvis_11 = null;
        Boolean _elvis_12 = null;
        Boolean _elvis_13 = null;
        XEvent _invResolveOne_4 = this.<XEvent>invResolveOne(((LifelineSegment)dependency).getTarget(), XEvent.class);
        Boolean _scheduled_1 = null;
        if (_invResolveOne_4!=null) {
          _scheduled_1=_invResolveOne_4.getScheduled();
        }
        if (_scheduled_1 != null) {
          _elvis_13 = _scheduled_1;
        } else {
          Execution _activeExecution_2 = ((LifelineSegment)dependency).getActiveExecution();
          Function _function_2 = null;
          if (_activeExecution_2!=null) {
            _function_2=_activeExecution_2.getFunction();
          }
          XFunction _invResolveOne_5 = null;
          if (_function_2!=null) {
            _invResolveOne_5=this.<XFunction>invResolveOne(_function_2, XFunction.class);
          }
          Boolean _scheduled_2 = null;
          if (_invResolveOne_5!=null) {
            _scheduled_2=_invResolveOne_5.getScheduled();
          }
          _elvis_13 = _scheduled_2;
        }
        if (_elvis_13 != null) {
          _elvis_12 = _elvis_13;
        } else {
          Execution _activeExecution_3 = ((LifelineSegment)dependency).getActiveExecution();
          Component _component_1 = null;
          if (_activeExecution_3!=null) {
            _component_1=_activeExecution_3.getComponent();
          }
          XComponent _invResolveOne_6 = null;
          if (_component_1!=null) {
            _invResolveOne_6=this.<XComponent>invResolveOne(_component_1, XComponent.class);
          }
          Boolean _scheduled_3 = null;
          if (_invResolveOne_6!=null) {
            _scheduled_3=_invResolveOne_6.getScheduled();
          }
          _elvis_12 = _scheduled_3;
        }
        if (_elvis_12 != null) {
          _elvis_11 = _elvis_12;
        } else {
          Boolean _scheduled_4 = this.<XExecutor>invResolveOne(((LifelineSegment)dependency).getSource().getLifeline(), XExecutor.class).getScheduled();
          _elvis_11 = _scheduled_4;
        }
        if (_elvis_11 != null) {
          _elvis_10 = _elvis_11;
        } else {
          XHost _containerOfType_1 = EcoreUtil2.<XHost>getContainerOfType(this.<XExecutor>invResolveOne(((LifelineSegment)dependency).getSource().getLifeline(), XExecutor.class), XHost.class);
          Boolean _scheduled_5 = null;
          if (_containerOfType_1!=null) {
            _scheduled_5=_containerOfType_1.getScheduled();
          }
          _elvis_10 = _scheduled_5;
        }
        if (_elvis_10 != null) {
          _elvis_9 = _elvis_10;
        } else {
          Boolean _scheduled_6 = null;
          if (dependencySettings!=null) {
            _scheduled_6=dependencySettings.getScheduled();
          }
          _elvis_9 = _scheduled_6;
        }
        if (_elvis_9 != null) {
          _elvis_8 = _elvis_9;
        } else {
          Boolean _scheduled_7 = tmscSettings.getScheduled();
          _elvis_8 = _scheduled_7;
        }
        _xifexpression_1 = _elvis_8;
      } else {
        Boolean _elvis_14 = null;
        Boolean _scheduled_8 = null;
        if (dependencySettings!=null) {
          _scheduled_8=dependencySettings.getScheduled();
        }
        if (_scheduled_8 != null) {
          _elvis_14 = _scheduled_8;
        } else {
          Boolean _scheduled_9 = tmscSettings.getScheduled();
          _elvis_14 = _scheduled_9;
        }
        _xifexpression_1 = _elvis_14;
      }
      dependency.setScheduled(_xifexpression_1);
    }
    EList<XProperty> _properties = null;
    if (dependencySettings!=null) {
      _properties=dependencySettings.getProperties();
    }
    this.addPropertiesIfAbsent(dependency, _properties);
  }
  
  private void addExecutionDefaults(final Execution execution) {
    Function _function = execution.getFunction();
    XFunction _invResolveOne = null;
    if (_function!=null) {
      _invResolveOne=this.<XFunction>invResolveOne(_function, XFunction.class);
    }
    EList<XProperty> _properties = null;
    if (_invResolveOne!=null) {
      _properties=_invResolveOne.getProperties();
    }
    this.addPropertiesIfAbsent(execution, _properties);
    Component _component = execution.getComponent();
    XComponent _invResolveOne_1 = null;
    if (_component!=null) {
      _invResolveOne_1=this.<XComponent>invResolveOne(_component, XComponent.class);
    }
    EList<XProperty> _properties_1 = null;
    if (_invResolveOne_1!=null) {
      _properties_1=_invResolveOne_1.getProperties();
    }
    this.addPropertiesIfAbsent(execution, _properties_1);
  }
  
  /**
   * Only adds the {@code xProperties} that are not yet set to {@code container}
   */
  private void addPropertiesIfAbsent(final PropertiesContainer container, final List<XProperty> xProperties) {
    if ((xProperties == null)) {
      return;
    }
    for (final XProperty xProperty : xProperties) {
      boolean _containsKey = container.getProperties().containsKey(xProperty.getName());
      boolean _not = (!_containsKey);
      if (_not) {
        container.getProperties().put(xProperty.getName(), this.getValue(xProperty.getValue()));
      }
    }
  }
  
  private Serializable _getValue(final XPropertyBooleanValue propertyValue) {
    return propertyValue.getValue();
  }
  
  private Serializable _getValue(final XPropertyNumberValue propertyValue) {
    return propertyValue.getValue();
  }
  
  private Serializable _getValue(final XPropertyStringValue propertyValue) {
    return propertyValue.getValue();
  }
  
  private Serializable _getValue(final XPropertyMutliValue propertyValue) {
    final ArrayList<Serializable> result = CollectionLiterals.<Serializable>newArrayList();
    final Function1<XPropertyValue, Serializable> _function = (XPropertyValue it) -> {
      return this.getValue(it);
    };
    List<Serializable> _map = ListExtensions.<XPropertyValue, Serializable>map(propertyValue.getValues(), _function);
    Iterables.<Serializable>addAll(result, _map);
    return result;
  }
  
  static Long toNanos(final BigDecimal seconds) {
    Long _xifexpression = null;
    if ((seconds == null)) {
      _xifexpression = null;
    } else {
      _xifexpression = Long.valueOf(seconds.movePointRight(9).longValueExact());
    }
    return _xifexpression;
  }
  
  private Serializable getValue(final XPropertyValue propertyValue) {
    if (propertyValue instanceof XPropertyBooleanValue) {
      return _getValue((XPropertyBooleanValue)propertyValue);
    } else if (propertyValue instanceof XPropertyMutliValue) {
      return _getValue((XPropertyMutliValue)propertyValue);
    } else if (propertyValue instanceof XPropertyNumberValue) {
      return _getValue((XPropertyNumberValue)propertyValue);
    } else if (propertyValue instanceof XPropertyStringValue) {
      return _getValue((XPropertyStringValue)propertyValue);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(propertyValue).toString());
    }
  }
  
  public synchronized FullScopeTMSC transform(final TmscXtextModel tmscXtext) {
    FullScopeTMSC result = _transform_transform(tmscXtext);
    _performLateFunctions();
    return result;
  }
  
  private final Queue<Runnable> _lateFunctions = new java.util.LinkedList<>();
  
  protected void _performLateFunctions() {
    while (!_lateFunctions.isEmpty()) {
        _lateFunctions.remove().run();
    }
  }
  
  /**
   * Late functions are executed at the end of the transformation, just before returning the result.
   */
  protected final void late(final Runnable function) {
    _lateFunctions.add(function);
  }
  
  private Optional<FullScopeTMSC> _resolveOne_tmscXtextModel2FullScopeTMSC(final TmscXtextModel tmscXtext) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(tmscXtext);
    synchronized (_createCache_tmscXtextModel2FullScopeTMSC) {
        if (_createCache_tmscXtextModel2FullScopeTMSC.containsKey(_cacheKey)) {
            return Optional.ofNullable(_createCache_tmscXtextModel2FullScopeTMSC.get(_cacheKey));
        } else {
            return Optional.empty();
        }
    }
  }
  
  private Stream<FullScopeTMSC> _resolveAll_tmscXtextModel2FullScopeTMSC(final TmscXtextModel tmscXtext) {
    final Optional<FullScopeTMSC> resolved = _resolveOne_tmscXtextModel2FullScopeTMSC(tmscXtext);
    return Stream.of(resolved).filter(Optional::isPresent).map(Optional::get);
  }
  
  private <T> Optional<T> _invResolveOne_tmscXtextModel2FullScopeTMSC(final FullScopeTMSC target, final Class<T> typeToResolve) {
    return _invResolveAll_tmscXtextModel2FullScopeTMSC(target, typeToResolve).findFirst();
  }
  
  private <T> Stream<T> _invResolveAll_tmscXtextModel2FullScopeTMSC(final FullScopeTMSC target, final Class<T> typeToResolve) {
    // TODO what about synchronization here?
    return _createCache_tmscXtextModel2FullScopeTMSC.entrySet().stream().filter(e -> e.getValue() == target)
            .flatMap(e -> e.getKey().stream()).filter(typeToResolve::isInstance).map(typeToResolve::cast);
  }
  
  protected <T> T resolveOne(final TmscXtextModel source, final Class<T> typeToResolve) {
    if (typeToResolve.isAssignableFrom(FullScopeTMSC.class) || FullScopeTMSC.class.isAssignableFrom(typeToResolve)) {
        final Optional<FullScopeTMSC> resolved = _resolveOne_tmscXtextModel2FullScopeTMSC(source);
        if (resolved.isPresent() && typeToResolve.isInstance(resolved.get())) {
            return typeToResolve.cast(resolved.get());
        }
    }
    return null;
  }
  
  protected <T> List<T> resolveAll(final TmscXtextModel source, final Class<T> typeToResolve) {
    List<T> resolved = CollectionLiterals.newLinkedList();
    if (typeToResolve.isAssignableFrom(FullScopeTMSC.class) || FullScopeTMSC.class.isAssignableFrom(typeToResolve)) {
        final Stream<FullScopeTMSC> result = _resolveAll_tmscXtextModel2FullScopeTMSC(source);
        result.filter(typeToResolve::isInstance).map(typeToResolve::cast).forEachOrdered(resolved::add);
    }
    return resolved;
  }
  
  protected <T> T resolveOne(final XInterface source, final Class<T> typeToResolve) {
    if (typeToResolve.isAssignableFrom(Interface.class) || Interface.class.isAssignableFrom(typeToResolve)) {
        final Optional<Interface> resolved = _resolveOne_xInterface2Interface(source);
        if (resolved.isPresent() && typeToResolve.isInstance(resolved.get())) {
            return typeToResolve.cast(resolved.get());
        }
    }
    return null;
  }
  
  protected <T> List<T> resolveAll(final XInterface source, final Class<T> typeToResolve) {
    List<T> resolved = CollectionLiterals.newLinkedList();
    if (typeToResolve.isAssignableFrom(Interface.class) || Interface.class.isAssignableFrom(typeToResolve)) {
        final Stream<Interface> result = _resolveAll_xInterface2Interface(source);
        result.filter(typeToResolve::isInstance).map(typeToResolve::cast).forEachOrdered(resolved::add);
    }
    return resolved;
  }
  
  protected <T> T resolveOne(final XOperation source, final Class<T> typeToResolve) {
    if (typeToResolve.isAssignableFrom(Operation.class) || Operation.class.isAssignableFrom(typeToResolve)) {
        final Optional<Operation> resolved = _resolveOne_xOperation2Operation(source);
        if (resolved.isPresent() && typeToResolve.isInstance(resolved.get())) {
            return typeToResolve.cast(resolved.get());
        }
    }
    return null;
  }
  
  protected <T> List<T> resolveAll(final XOperation source, final Class<T> typeToResolve) {
    List<T> resolved = CollectionLiterals.newLinkedList();
    if (typeToResolve.isAssignableFrom(Operation.class) || Operation.class.isAssignableFrom(typeToResolve)) {
        final Stream<Operation> result = _resolveAll_xOperation2Operation(source);
        result.filter(typeToResolve::isInstance).map(typeToResolve::cast).forEachOrdered(resolved::add);
    }
    return resolved;
  }
  
  protected <T> T resolveOne(final XComponent source, final Class<T> typeToResolve) {
    if (typeToResolve.isAssignableFrom(Component.class) || Component.class.isAssignableFrom(typeToResolve)) {
        final Optional<Component> resolved = _resolveOne_xComponent2Component(source);
        if (resolved.isPresent() && typeToResolve.isInstance(resolved.get())) {
            return typeToResolve.cast(resolved.get());
        }
    }
    return null;
  }
  
  protected <T> List<T> resolveAll(final XComponent source, final Class<T> typeToResolve) {
    List<T> resolved = CollectionLiterals.newLinkedList();
    if (typeToResolve.isAssignableFrom(Component.class) || Component.class.isAssignableFrom(typeToResolve)) {
        final Stream<Component> result = _resolveAll_xComponent2Component(source);
        result.filter(typeToResolve::isInstance).map(typeToResolve::cast).forEachOrdered(resolved::add);
    }
    return resolved;
  }
  
  protected <T> T resolveOne(final XFunction source, final Class<T> typeToResolve) {
    if (typeToResolve.isAssignableFrom(Function.class) || Function.class.isAssignableFrom(typeToResolve)) {
        final Optional<Function> resolved = _resolveOne_xFunction2Function(source);
        if (resolved.isPresent() && typeToResolve.isInstance(resolved.get())) {
            return typeToResolve.cast(resolved.get());
        }
    }
    return null;
  }
  
  protected <T> List<T> resolveAll(final XFunction source, final Class<T> typeToResolve) {
    List<T> resolved = CollectionLiterals.newLinkedList();
    if (typeToResolve.isAssignableFrom(Function.class) || Function.class.isAssignableFrom(typeToResolve)) {
        final Stream<Function> result = _resolveAll_xFunction2Function(source);
        result.filter(typeToResolve::isInstance).map(typeToResolve::cast).forEachOrdered(resolved::add);
    }
    return resolved;
  }
  
  protected <T> T resolveOne(final XFunctionParameter source, final Class<T> typeToResolve) {
    if (typeToResolve.isAssignableFrom(FunctionParameter.class) || FunctionParameter.class.isAssignableFrom(typeToResolve)) {
        final Optional<FunctionParameter> resolved = _resolveOne_xFunctionParameter2FunctionParameter(source);
        if (resolved.isPresent() && typeToResolve.isInstance(resolved.get())) {
            return typeToResolve.cast(resolved.get());
        }
    }
    return null;
  }
  
  protected <T> List<T> resolveAll(final XFunctionParameter source, final Class<T> typeToResolve) {
    List<T> resolved = CollectionLiterals.newLinkedList();
    if (typeToResolve.isAssignableFrom(FunctionParameter.class) || FunctionParameter.class.isAssignableFrom(typeToResolve)) {
        final Stream<FunctionParameter> result = _resolveAll_xFunctionParameter2FunctionParameter(source);
        result.filter(typeToResolve::isInstance).map(typeToResolve::cast).forEachOrdered(resolved::add);
    }
    return resolved;
  }
  
  protected <T> T resolveOne(final XExecutor source, final Class<T> typeToResolve) {
    if (typeToResolve.isAssignableFrom(Executor.class) || Executor.class.isAssignableFrom(typeToResolve)) {
        final Optional<Executor> resolved = _resolveOne_xExecutor2Executor(source);
        if (resolved.isPresent() && typeToResolve.isInstance(resolved.get())) {
            return typeToResolve.cast(resolved.get());
        }
    }
    if (typeToResolve.isAssignableFrom(Lifeline.class) || Lifeline.class.isAssignableFrom(typeToResolve)) {
        final Optional<Lifeline> resolved = _resolveOne_xExecutor2Lifeline(source);
        if (resolved.isPresent() && typeToResolve.isInstance(resolved.get())) {
            return typeToResolve.cast(resolved.get());
        }
    }
    return null;
  }
  
  protected <T> List<T> resolveAll(final XExecutor source, final Class<T> typeToResolve) {
    List<T> resolved = CollectionLiterals.newLinkedList();
    if (typeToResolve.isAssignableFrom(Executor.class) || Executor.class.isAssignableFrom(typeToResolve)) {
        final Stream<Executor> result = _resolveAll_xExecutor2Executor(source);
        result.filter(typeToResolve::isInstance).map(typeToResolve::cast).forEachOrdered(resolved::add);
    }
    if (typeToResolve.isAssignableFrom(Lifeline.class) || Lifeline.class.isAssignableFrom(typeToResolve)) {
        final Stream<Lifeline> result = _resolveAll_xExecutor2Lifeline(source);
        result.filter(typeToResolve::isInstance).map(typeToResolve::cast).forEachOrdered(resolved::add);
    }
    return resolved;
  }
  
  protected <T> T resolveOne(final XEvent source, final Class<T> typeToResolve) {
    if (typeToResolve.isAssignableFrom(Event.class) || Event.class.isAssignableFrom(typeToResolve)) {
        final Optional<Event> resolved = _resolveOne_xEvent2Event(source);
        if (resolved.isPresent() && typeToResolve.isInstance(resolved.get())) {
            return typeToResolve.cast(resolved.get());
        }
    }
    return null;
  }
  
  protected <T> List<T> resolveAll(final XEvent source, final Class<T> typeToResolve) {
    List<T> resolved = CollectionLiterals.newLinkedList();
    if (typeToResolve.isAssignableFrom(Event.class) || Event.class.isAssignableFrom(typeToResolve)) {
        final Stream<Event> result = _resolveAll_xEvent2Event(source);
        result.filter(typeToResolve::isInstance).map(typeToResolve::cast).forEachOrdered(resolved::add);
    }
    return resolved;
  }
  
  protected <T> T resolveOne(final XDependency source, final Class<T> typeToResolve) {
    if (typeToResolve.isAssignableFrom(Dependency.class) || Dependency.class.isAssignableFrom(typeToResolve)) {
        final Optional<Dependency> resolved = _resolveOne_xDependency2Dependency(source);
        if (resolved.isPresent() && typeToResolve.isInstance(resolved.get())) {
            return typeToResolve.cast(resolved.get());
        }
    }
    return null;
  }
  
  protected <T> List<T> resolveAll(final XDependency source, final Class<T> typeToResolve) {
    List<T> resolved = CollectionLiterals.newLinkedList();
    if (typeToResolve.isAssignableFrom(Dependency.class) || Dependency.class.isAssignableFrom(typeToResolve)) {
        final Stream<Dependency> result = _resolveAll_xDependency2Dependency(source);
        result.filter(typeToResolve::isInstance).map(typeToResolve::cast).forEachOrdered(resolved::add);
    }
    return resolved;
  }
  
  protected <T> T invResolveOne(final FullScopeTMSC target, final Class<T> typeToResolve) {
    if (TmscXtextModel.class.isAssignableFrom(typeToResolve)) {
        final Optional<T> resolved = _invResolveOne_tmscXtextModel2FullScopeTMSC(target, typeToResolve);
        if (resolved.isPresent()) {
            return resolved.get();
        }
    }
    return null;
  }
  
  protected <T> List<T> invResolveAll(final FullScopeTMSC target, final Class<T> typeToResolve) {
    List<T> resolved = CollectionLiterals.newLinkedList();
    if (TmscXtextModel.class.isAssignableFrom(typeToResolve)) {
        _invResolveAll_tmscXtextModel2FullScopeTMSC(target, typeToResolve).forEachOrdered(resolved::add);
    }
    return resolved;
  }
  
  protected <T> T invResolveOne(final Interface target, final Class<T> typeToResolve) {
    if (XInterface.class.isAssignableFrom(typeToResolve)) {
        final Optional<T> resolved = _invResolveOne_xInterface2Interface(target, typeToResolve);
        if (resolved.isPresent()) {
            return resolved.get();
        }
    }
    return null;
  }
  
  protected <T> List<T> invResolveAll(final Interface target, final Class<T> typeToResolve) {
    List<T> resolved = CollectionLiterals.newLinkedList();
    if (XInterface.class.isAssignableFrom(typeToResolve)) {
        _invResolveAll_xInterface2Interface(target, typeToResolve).forEachOrdered(resolved::add);
    }
    return resolved;
  }
  
  protected <T> T invResolveOne(final Operation target, final Class<T> typeToResolve) {
    if (XOperation.class.isAssignableFrom(typeToResolve)) {
        final Optional<T> resolved = _invResolveOne_xOperation2Operation(target, typeToResolve);
        if (resolved.isPresent()) {
            return resolved.get();
        }
    }
    return null;
  }
  
  protected <T> List<T> invResolveAll(final Operation target, final Class<T> typeToResolve) {
    List<T> resolved = CollectionLiterals.newLinkedList();
    if (XOperation.class.isAssignableFrom(typeToResolve)) {
        _invResolveAll_xOperation2Operation(target, typeToResolve).forEachOrdered(resolved::add);
    }
    return resolved;
  }
  
  protected <T> T invResolveOne(final Component target, final Class<T> typeToResolve) {
    if (XComponent.class.isAssignableFrom(typeToResolve)) {
        final Optional<T> resolved = _invResolveOne_xComponent2Component(target, typeToResolve);
        if (resolved.isPresent()) {
            return resolved.get();
        }
    }
    return null;
  }
  
  protected <T> List<T> invResolveAll(final Component target, final Class<T> typeToResolve) {
    List<T> resolved = CollectionLiterals.newLinkedList();
    if (XComponent.class.isAssignableFrom(typeToResolve)) {
        _invResolveAll_xComponent2Component(target, typeToResolve).forEachOrdered(resolved::add);
    }
    return resolved;
  }
  
  protected <T> T invResolveOne(final Function target, final Class<T> typeToResolve) {
    if (XFunction.class.isAssignableFrom(typeToResolve)) {
        final Optional<T> resolved = _invResolveOne_xFunction2Function(target, typeToResolve);
        if (resolved.isPresent()) {
            return resolved.get();
        }
    }
    return null;
  }
  
  protected <T> List<T> invResolveAll(final Function target, final Class<T> typeToResolve) {
    List<T> resolved = CollectionLiterals.newLinkedList();
    if (XFunction.class.isAssignableFrom(typeToResolve)) {
        _invResolveAll_xFunction2Function(target, typeToResolve).forEachOrdered(resolved::add);
    }
    return resolved;
  }
  
  protected <T> T invResolveOne(final FunctionParameter target, final Class<T> typeToResolve) {
    if (XFunctionParameter.class.isAssignableFrom(typeToResolve)) {
        final Optional<T> resolved = _invResolveOne_xFunctionParameter2FunctionParameter(target, typeToResolve);
        if (resolved.isPresent()) {
            return resolved.get();
        }
    }
    return null;
  }
  
  protected <T> List<T> invResolveAll(final FunctionParameter target, final Class<T> typeToResolve) {
    List<T> resolved = CollectionLiterals.newLinkedList();
    if (XFunctionParameter.class.isAssignableFrom(typeToResolve)) {
        _invResolveAll_xFunctionParameter2FunctionParameter(target, typeToResolve).forEachOrdered(resolved::add);
    }
    return resolved;
  }
  
  protected <T> T invResolveOne(final Executor target, final Class<T> typeToResolve) {
    if (XExecutor.class.isAssignableFrom(typeToResolve)) {
        final Optional<T> resolved = _invResolveOne_xExecutor2Executor(target, typeToResolve);
        if (resolved.isPresent()) {
            return resolved.get();
        }
    }
    return null;
  }
  
  protected <T> List<T> invResolveAll(final Executor target, final Class<T> typeToResolve) {
    List<T> resolved = CollectionLiterals.newLinkedList();
    if (XExecutor.class.isAssignableFrom(typeToResolve)) {
        _invResolveAll_xExecutor2Executor(target, typeToResolve).forEachOrdered(resolved::add);
    }
    return resolved;
  }
  
  protected <T> T invResolveOne(final Lifeline target, final Class<T> typeToResolve) {
    if (XExecutor.class.isAssignableFrom(typeToResolve)) {
        final Optional<T> resolved = _invResolveOne_xExecutor2Lifeline(target, typeToResolve);
        if (resolved.isPresent()) {
            return resolved.get();
        }
    }
    return null;
  }
  
  protected <T> List<T> invResolveAll(final Lifeline target, final Class<T> typeToResolve) {
    List<T> resolved = CollectionLiterals.newLinkedList();
    if (XExecutor.class.isAssignableFrom(typeToResolve)) {
        _invResolveAll_xExecutor2Lifeline(target, typeToResolve).forEachOrdered(resolved::add);
    }
    return resolved;
  }
  
  protected <T> T invResolveOne(final Event target, final Class<T> typeToResolve) {
    if (XEvent.class.isAssignableFrom(typeToResolve)) {
        final Optional<T> resolved = _invResolveOne_xEvent2Event(target, typeToResolve);
        if (resolved.isPresent()) {
            return resolved.get();
        }
    }
    return null;
  }
  
  protected <T> List<T> invResolveAll(final Event target, final Class<T> typeToResolve) {
    List<T> resolved = CollectionLiterals.newLinkedList();
    if (XEvent.class.isAssignableFrom(typeToResolve)) {
        _invResolveAll_xEvent2Event(target, typeToResolve).forEachOrdered(resolved::add);
    }
    return resolved;
  }
  
  protected <T> T invResolveOne(final Dependency target, final Class<T> typeToResolve) {
    if (XDependency.class.isAssignableFrom(typeToResolve)) {
        final Optional<T> resolved = _invResolveOne_xDependency2Dependency(target, typeToResolve);
        if (resolved.isPresent()) {
            return resolved.get();
        }
    }
    return null;
  }
  
  protected <T> List<T> invResolveAll(final Dependency target, final Class<T> typeToResolve) {
    List<T> resolved = CollectionLiterals.newLinkedList();
    if (XDependency.class.isAssignableFrom(typeToResolve)) {
        _invResolveAll_xDependency2Dependency(target, typeToResolve).forEachOrdered(resolved::add);
    }
    return resolved;
  }
  
  private Optional<Interface> _resolveOne_xInterface2Interface(final XInterface xInterface) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(xInterface);
    synchronized (_createCache_xInterface2Interface) {
        if (_createCache_xInterface2Interface.containsKey(_cacheKey)) {
            return Optional.ofNullable(_createCache_xInterface2Interface.get(_cacheKey));
        } else {
            return Optional.empty();
        }
    }
  }
  
  private Stream<Interface> _resolveAll_xInterface2Interface(final XInterface xInterface) {
    final Optional<Interface> resolved = _resolveOne_xInterface2Interface(xInterface);
    return Stream.of(resolved).filter(Optional::isPresent).map(Optional::get);
  }
  
  private <T> Optional<T> _invResolveOne_xInterface2Interface(final Interface target, final Class<T> typeToResolve) {
    return _invResolveAll_xInterface2Interface(target, typeToResolve).findFirst();
  }
  
  private <T> Stream<T> _invResolveAll_xInterface2Interface(final Interface target, final Class<T> typeToResolve) {
    // TODO what about synchronization here?
    return _createCache_xInterface2Interface.entrySet().stream().filter(e -> e.getValue() == target)
            .flatMap(e -> e.getKey().stream()).filter(typeToResolve::isInstance).map(typeToResolve::cast);
  }
  
  private Optional<Operation> _resolveOne_xOperation2Operation(final XOperation xOperation) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(xOperation);
    synchronized (_createCache_xOperation2Operation) {
        if (_createCache_xOperation2Operation.containsKey(_cacheKey)) {
            return Optional.ofNullable(_createCache_xOperation2Operation.get(_cacheKey));
        } else {
            return Optional.empty();
        }
    }
  }
  
  private Stream<Operation> _resolveAll_xOperation2Operation(final XOperation xOperation) {
    final Optional<Operation> resolved = _resolveOne_xOperation2Operation(xOperation);
    return Stream.of(resolved).filter(Optional::isPresent).map(Optional::get);
  }
  
  private <T> Optional<T> _invResolveOne_xOperation2Operation(final Operation target, final Class<T> typeToResolve) {
    return _invResolveAll_xOperation2Operation(target, typeToResolve).findFirst();
  }
  
  private <T> Stream<T> _invResolveAll_xOperation2Operation(final Operation target, final Class<T> typeToResolve) {
    // TODO what about synchronization here?
    return _createCache_xOperation2Operation.entrySet().stream().filter(e -> e.getValue() == target)
            .flatMap(e -> e.getKey().stream()).filter(typeToResolve::isInstance).map(typeToResolve::cast);
  }
  
  private Optional<Component> _resolveOne_xComponent2Component(final XComponent xComponent) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(xComponent);
    synchronized (_createCache_xComponent2Component) {
        if (_createCache_xComponent2Component.containsKey(_cacheKey)) {
            return Optional.ofNullable(_createCache_xComponent2Component.get(_cacheKey));
        } else {
            return Optional.empty();
        }
    }
  }
  
  private Stream<Component> _resolveAll_xComponent2Component(final XComponent xComponent) {
    final Optional<Component> resolved = _resolveOne_xComponent2Component(xComponent);
    return Stream.of(resolved).filter(Optional::isPresent).map(Optional::get);
  }
  
  private <T> Optional<T> _invResolveOne_xComponent2Component(final Component target, final Class<T> typeToResolve) {
    return _invResolveAll_xComponent2Component(target, typeToResolve).findFirst();
  }
  
  private <T> Stream<T> _invResolveAll_xComponent2Component(final Component target, final Class<T> typeToResolve) {
    // TODO what about synchronization here?
    return _createCache_xComponent2Component.entrySet().stream().filter(e -> e.getValue() == target)
            .flatMap(e -> e.getKey().stream()).filter(typeToResolve::isInstance).map(typeToResolve::cast);
  }
  
  private Optional<Function> _resolveOne_xFunction2Function(final XFunction xFunction) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(xFunction);
    synchronized (_createCache_xFunction2Function) {
        if (_createCache_xFunction2Function.containsKey(_cacheKey)) {
            return Optional.ofNullable(_createCache_xFunction2Function.get(_cacheKey));
        } else {
            return Optional.empty();
        }
    }
  }
  
  private Stream<Function> _resolveAll_xFunction2Function(final XFunction xFunction) {
    final Optional<Function> resolved = _resolveOne_xFunction2Function(xFunction);
    return Stream.of(resolved).filter(Optional::isPresent).map(Optional::get);
  }
  
  private <T> Optional<T> _invResolveOne_xFunction2Function(final Function target, final Class<T> typeToResolve) {
    return _invResolveAll_xFunction2Function(target, typeToResolve).findFirst();
  }
  
  private <T> Stream<T> _invResolveAll_xFunction2Function(final Function target, final Class<T> typeToResolve) {
    // TODO what about synchronization here?
    return _createCache_xFunction2Function.entrySet().stream().filter(e -> e.getValue() == target)
            .flatMap(e -> e.getKey().stream()).filter(typeToResolve::isInstance).map(typeToResolve::cast);
  }
  
  private Optional<FunctionParameter> _resolveOne_xFunctionParameter2FunctionParameter(final XFunctionParameter xFunctionParameter) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(xFunctionParameter);
    synchronized (_createCache_xFunctionParameter2FunctionParameter) {
        if (_createCache_xFunctionParameter2FunctionParameter.containsKey(_cacheKey)) {
            return Optional.ofNullable(_createCache_xFunctionParameter2FunctionParameter.get(_cacheKey));
        } else {
            return Optional.empty();
        }
    }
  }
  
  private Stream<FunctionParameter> _resolveAll_xFunctionParameter2FunctionParameter(final XFunctionParameter xFunctionParameter) {
    final Optional<FunctionParameter> resolved = _resolveOne_xFunctionParameter2FunctionParameter(xFunctionParameter);
    return Stream.of(resolved).filter(Optional::isPresent).map(Optional::get);
  }
  
  private <T> Optional<T> _invResolveOne_xFunctionParameter2FunctionParameter(final FunctionParameter target, final Class<T> typeToResolve) {
    return _invResolveAll_xFunctionParameter2FunctionParameter(target, typeToResolve).findFirst();
  }
  
  private <T> Stream<T> _invResolveAll_xFunctionParameter2FunctionParameter(final FunctionParameter target, final Class<T> typeToResolve) {
    // TODO what about synchronization here?
    return _createCache_xFunctionParameter2FunctionParameter.entrySet().stream().filter(e -> e.getValue() == target)
            .flatMap(e -> e.getKey().stream()).filter(typeToResolve::isInstance).map(typeToResolve::cast);
  }
  
  private Optional<Executor> _resolveOne_xExecutor2Executor(final XExecutor xExecutor) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(xExecutor);
    synchronized (_createCache_xExecutor2Executor) {
        if (_createCache_xExecutor2Executor.containsKey(_cacheKey)) {
            return Optional.ofNullable(_createCache_xExecutor2Executor.get(_cacheKey));
        } else {
            return Optional.empty();
        }
    }
  }
  
  private Stream<Executor> _resolveAll_xExecutor2Executor(final XExecutor xExecutor) {
    final Optional<Executor> resolved = _resolveOne_xExecutor2Executor(xExecutor);
    return Stream.of(resolved).filter(Optional::isPresent).map(Optional::get);
  }
  
  private <T> Optional<T> _invResolveOne_xExecutor2Executor(final Executor target, final Class<T> typeToResolve) {
    return _invResolveAll_xExecutor2Executor(target, typeToResolve).findFirst();
  }
  
  private <T> Stream<T> _invResolveAll_xExecutor2Executor(final Executor target, final Class<T> typeToResolve) {
    // TODO what about synchronization here?
    return _createCache_xExecutor2Executor.entrySet().stream().filter(e -> e.getValue() == target)
            .flatMap(e -> e.getKey().stream()).filter(typeToResolve::isInstance).map(typeToResolve::cast);
  }
  
  private Optional<Lifeline> _resolveOne_xExecutor2Lifeline(final XExecutor xExecutor) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(xExecutor);
    synchronized (_createCache_xExecutor2Lifeline) {
        if (_createCache_xExecutor2Lifeline.containsKey(_cacheKey)) {
            return Optional.ofNullable(_createCache_xExecutor2Lifeline.get(_cacheKey));
        } else {
            return Optional.empty();
        }
    }
  }
  
  private Stream<Lifeline> _resolveAll_xExecutor2Lifeline(final XExecutor xExecutor) {
    final Optional<Lifeline> resolved = _resolveOne_xExecutor2Lifeline(xExecutor);
    return Stream.of(resolved).filter(Optional::isPresent).map(Optional::get);
  }
  
  private <T> Optional<T> _invResolveOne_xExecutor2Lifeline(final Lifeline target, final Class<T> typeToResolve) {
    return _invResolveAll_xExecutor2Lifeline(target, typeToResolve).findFirst();
  }
  
  private <T> Stream<T> _invResolveAll_xExecutor2Lifeline(final Lifeline target, final Class<T> typeToResolve) {
    // TODO what about synchronization here?
    return _createCache_xExecutor2Lifeline.entrySet().stream().filter(e -> e.getValue() == target)
            .flatMap(e -> e.getKey().stream()).filter(typeToResolve::isInstance).map(typeToResolve::cast);
  }
  
  private Optional<Event> _resolveOne_xEvent2Event(final XEvent xEvent) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(xEvent);
    synchronized (_createCache_xEvent2Event) {
        if (_createCache_xEvent2Event.containsKey(_cacheKey)) {
            return Optional.ofNullable(_createCache_xEvent2Event.get(_cacheKey));
        } else {
            return Optional.empty();
        }
    }
  }
  
  private Stream<Event> _resolveAll_xEvent2Event(final XEvent xEvent) {
    final Optional<Event> resolved = _resolveOne_xEvent2Event(xEvent);
    return Stream.of(resolved).filter(Optional::isPresent).map(Optional::get);
  }
  
  private <T> Optional<T> _invResolveOne_xEvent2Event(final Event target, final Class<T> typeToResolve) {
    return _invResolveAll_xEvent2Event(target, typeToResolve).findFirst();
  }
  
  private <T> Stream<T> _invResolveAll_xEvent2Event(final Event target, final Class<T> typeToResolve) {
    // TODO what about synchronization here?
    return _createCache_xEvent2Event.entrySet().stream().filter(e -> e.getValue() == target)
            .flatMap(e -> e.getKey().stream()).filter(typeToResolve::isInstance).map(typeToResolve::cast);
  }
  
  private Optional<Dependency> _resolveOne_xDependency2Dependency(final XDependency xDependency) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(xDependency);
    synchronized (_createCache_xDependency2Dependency) {
        if (_createCache_xDependency2Dependency.containsKey(_cacheKey)) {
            return Optional.ofNullable(_createCache_xDependency2Dependency.get(_cacheKey));
        } else {
            return Optional.empty();
        }
    }
  }
  
  private Stream<Dependency> _resolveAll_xDependency2Dependency(final XDependency xDependency) {
    final Optional<Dependency> resolved = _resolveOne_xDependency2Dependency(xDependency);
    return Stream.of(resolved).filter(Optional::isPresent).map(Optional::get);
  }
  
  private <T> Optional<T> _invResolveOne_xDependency2Dependency(final Dependency target, final Class<T> typeToResolve) {
    return _invResolveAll_xDependency2Dependency(target, typeToResolve).findFirst();
  }
  
  private <T> Stream<T> _invResolveAll_xDependency2Dependency(final Dependency target, final Class<T> typeToResolve) {
    // TODO what about synchronization here?
    return _createCache_xDependency2Dependency.entrySet().stream().filter(e -> e.getValue() == target)
            .flatMap(e -> e.getKey().stream()).filter(typeToResolve::isInstance).map(typeToResolve::cast);
  }
}
