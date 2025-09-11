/**
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.util;

import com.google.common.collect.Iterables;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import nl.esi.pps.architecture.ArchitectureModel;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.EntryEvent;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.ExitEvent;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.Lifeline;
import nl.esi.pps.tmsc.LifelineSegment;
import nl.esi.pps.tmsc.Measurement;
import nl.esi.pps.tmsc.MessageControl;
import nl.esi.pps.tmsc.ScopedTMSC;
import nl.esi.pps.tmsc.TMSC;
import nl.esi.pps.tmsc.TmscPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.lsat.common.xtend.Queries;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Creates a self contained copy of a {@link ScopedTMSC}, containing just enough content to be persisted and rendered.
 */
@SuppressWarnings("all")
public class ScopedTmscCopier extends EcoreUtil.Copier {
  private final Set<Dependency> registeredDependencies = CollectionLiterals.<Dependency>newHashSet();

  private final Set<Execution> registeredExecutions = CollectionLiterals.<Execution>newHashSet();

  private final Map<Lifeline, Set<Event>> registeredLifelineEvents = CollectionLiterals.<Lifeline, Set<Event>>newHashMap();

  private ScopedTmscCopier() {
  }

  /**
   * Finds all {@link EcoreUtil#getRootContainer(EObject) root containers} within
   * the same {@link EObject#eResource() resource} of {@code tmsc} for which
   * applies that some {@link EObject#eAllContents() content} of {@code tmsc} root
   * container {@link #eReferred(EObject) refers} to some content of the other
   * root container.<br>
   * <br>
   * <b>NOTE:</b> This might be a rather time consuming query as the whole model content
   * may be explored. If you know what to copy, just pass it directly into
   * {@link #copyTmsc(ScopedTMSC, EObject...)}
   */
  public static EObject[] findOtherRootContainersToCopy(final ScopedTMSC tmsc) {
    final Function1<EObject, Boolean> _function = (EObject it) -> {
      return Boolean.valueOf(false);
    };
    return ScopedTmscCopier.findOtherRootContainersToCopy(tmsc, _function);
  }

  public static EObject[] findOtherRootContainersToCopy(final ScopedTMSC tmsc, final Function1<? super EObject, ? extends Boolean> rejectPredicate) {
    return ScopedTmscCopier.findOtherRootContainersToCopy(Collections.<ScopedTMSC>singleton(tmsc), rejectPredicate);
  }

  public static EObject[] findOtherRootContainersToCopy(final Iterable<ScopedTMSC> tmscs) {
    final Function1<EObject, Boolean> _function = (EObject it) -> {
      return Boolean.valueOf(false);
    };
    return ScopedTmscCopier.findOtherRootContainersToCopy(tmscs, _function);
  }

  public static EObject[] findOtherRootContainersToCopy(final Iterable<ScopedTMSC> tmscs, final Function1<? super EObject, ? extends Boolean> rejectPredicate) {
    final Function1<ScopedTMSC, Resource> _function = (ScopedTMSC it) -> {
      return it.eResource();
    };
    final Set<Resource> resources = IterableExtensions.<Resource>toSet(IterableExtensions.<Resource>filterNull(IterableExtensions.<ScopedTMSC, Resource>map(tmscs, _function)));
    boolean _isEmpty = resources.isEmpty();
    if (_isEmpty) {
      return new EObject[0];
    } else {
      int _size = resources.size();
      boolean _greaterThan = (_size > 1);
      if (_greaterThan) {
        throw new IllegalArgumentException("Expected all TMSCs to be contained by the same resource.");
      }
    }
    final Resource tmscsResource = IterableExtensions.<Resource>head(resources);
    final Function1<ScopedTMSC, EObject> _function_1 = (ScopedTMSC it) -> {
      return EcoreUtil.getRootContainer(it);
    };
    final Set<EObject> tmscsRootContainers = IterableExtensions.<EObject>toSet(IterableExtensions.<ScopedTMSC, EObject>map(tmscs, _function_1));
    final Set<EObject> otherRootContainersToCopy = IterableExtensions.<EObject>toSet(IterableExtensions.<EObject>reject(tmscsResource.getContents(), ((Function1<? super EObject, Boolean>)rejectPredicate)));
    otherRootContainersToCopy.removeAll(tmscsRootContainers);
    boolean _isEmpty_1 = otherRootContainersToCopy.isEmpty();
    if (_isEmpty_1) {
      return new EObject[0];
    }
    final Function1<ScopedTMSC, FullScopeTMSC> _function_2 = (ScopedTMSC it) -> {
      return it.getFullScope();
    };
    final Function1<FullScopeTMSC, EList<ArchitectureModel>> _function_3 = (FullScopeTMSC it) -> {
      return it.getArchitectures();
    };
    final Function1<ArchitectureModel, EObject> _function_4 = (ArchitectureModel it) -> {
      return EcoreUtil.getRootContainer(it);
    };
    final Set<EObject> archsRootContainers = IterableExtensions.<EObject>toSet(IterableExtensions.<ArchitectureModel, EObject>map(IterableExtensions.<FullScopeTMSC, ArchitectureModel>flatMap(IterableExtensions.<ScopedTMSC, FullScopeTMSC>map(tmscs, _function_2), _function_3), _function_4));
    boolean _containsAll = archsRootContainers.containsAll(otherRootContainersToCopy);
    if (_containsAll) {
      return ((EObject[])Conversions.unwrapArray(otherRootContainersToCopy, EObject.class));
    }
    final Function1<EObject, Iterable<? extends EObject>> _function_5 = (EObject it) -> {
      return it.eContents();
    };
    final Function1<EObject, Iterable<EObject>> _function_6 = (EObject it) -> {
      return ScopedTmscCopier.eReferred(it);
    };
    final Function1<EObject, EObject> _function_7 = (EObject it) -> {
      return EcoreUtil.getRootContainer(it);
    };
    final Set<EObject> referredRootContainers = IterableExtensions.<EObject>toSet(IterableExtensions.<EObject, EObject>map(IterableExtensions.<EObject, EObject>flatMap(Queries.<EObject>closure(tmscsRootContainers, true, _function_5), _function_6), _function_7));
    referredRootContainers.removeAll(tmscsRootContainers);
    final Predicate<EObject> _function_8 = (EObject c) -> {
      return (rejectPredicate.apply(c)).booleanValue();
    };
    referredRootContainers.removeIf(_function_8);
    final Predicate<EObject> _function_9 = (EObject c) -> {
      Resource _eResource = c.eResource();
      return (!Objects.equals(_eResource, tmscsResource));
    };
    referredRootContainers.removeIf(_function_9);
    return ((EObject[])Conversions.unwrapArray(referredRootContainers, EObject.class));
  }

  public static void deriveStartEndTime(final ScopedTMSC tmsc) {
    ScopedTmscCopier.deriveStartEndTime(Collections.<ScopedTMSC>singleton(tmsc));
  }

  public static void deriveStartEndTime(final Iterable<ScopedTMSC> tmscs) {
    boolean _isNullOrEmpty = IterableExtensions.isNullOrEmpty(tmscs);
    if (_isNullOrEmpty) {
      return;
    }
    final FullScopeTMSC fullScope = ScopedTmscCopier.getFullScope(tmscs);
    final Function1<ScopedTMSC, Boolean> _function = (ScopedTMSC it) -> {
      return Boolean.valueOf(it.getOrigin().isEmpty());
    };
    boolean _exists = IterableExtensions.<ScopedTMSC>exists(tmscs, _function);
    if (_exists) {
      final Function1<ScopedTMSC, EList<Dependency>> _function_1 = (ScopedTMSC it) -> {
        return it.getDependencies();
      };
      final Function1<Dependency, Event> _function_2 = (Dependency it) -> {
        return it.getSource();
      };
      final Function1<Event, Long> _function_3 = (Event it) -> {
        return it.getTimestamp();
      };
      fullScope.setStartTime(Queries.<Long>min(Queries.<Event, Long>xcollectOne(Queries.<Dependency, Event>xcollectOne(IterableExtensions.<ScopedTMSC, Dependency>flatMap(tmscs, _function_1), _function_2), _function_3), fullScope.getStartTime()));
      final Function1<ScopedTMSC, EList<Dependency>> _function_4 = (ScopedTMSC it) -> {
        return it.getDependencies();
      };
      final Function1<Dependency, Event> _function_5 = (Dependency it) -> {
        return it.getTarget();
      };
      final Function1<Event, Long> _function_6 = (Event it) -> {
        return it.getTimestamp();
      };
      fullScope.setEndTime(Queries.<Long>max(Queries.<Event, Long>xcollectOne(Queries.<Dependency, Event>xcollectOne(IterableExtensions.<ScopedTMSC, Dependency>flatMap(tmscs, _function_4), _function_5), _function_6), fullScope.getEndTime()));
    } else {
      final Function1<ScopedTMSC, EList<Event>> _function_7 = (ScopedTMSC it) -> {
        return it.getOrigin();
      };
      final Function1<Event, Long> _function_8 = (Event it) -> {
        return it.getTimestamp();
      };
      fullScope.setStartTime(Queries.<Long>min(Queries.<Event, Long>xcollectOne(IterableExtensions.<ScopedTMSC, Event>flatMap(tmscs, _function_7), _function_8), fullScope.getStartTime()));
      final Function1<ScopedTMSC, EList<Event>> _function_9 = (ScopedTMSC it) -> {
        return it.getOrigin();
      };
      final Function1<Event, Long> _function_10 = (Event it) -> {
        return it.getTimestamp();
      };
      fullScope.setEndTime(Queries.<Long>max(Queries.<Event, Long>xcollectOne(IterableExtensions.<ScopedTMSC, Event>flatMap(tmscs, _function_9), _function_10), fullScope.getEndTime()));
    }
  }

  private static FullScopeTMSC getFullScope(final Iterable<ScopedTMSC> tmscs) {
    final Function1<ScopedTMSC, FullScopeTMSC> _function = (ScopedTMSC it) -> {
      return it.getFullScope();
    };
    final Set<FullScopeTMSC> fullScopes = IterableExtensions.<FullScopeTMSC>toSet(IterableExtensions.<ScopedTMSC, FullScopeTMSC>map(tmscs, _function));
    int _size = fullScopes.size();
    boolean _greaterThan = (_size > 1);
    if (_greaterThan) {
      throw new IllegalArgumentException("Scoped TMSCs should share same full scope.");
    }
    return IterableExtensions.<FullScopeTMSC>head(fullScopes);
  }

  /**
   * The equivalent of {@link EObject#eContents()}, but for
   * {@link EClass#getEAllReferences() non-containment references}.
   */
  private static Iterable<EObject> eReferred(final EObject eObject) {
    final Function1<EReference, Boolean> _function = (EReference it) -> {
      return Boolean.valueOf(it.isContainer());
    };
    final Function1<EReference, Iterable<EObject>> _function_1 = (EReference ref) -> {
      Iterable<EObject> _switchResult = null;
      boolean _matched = false;
      boolean _eIsSet = eObject.eIsSet(ref);
      boolean _not = (!_eIsSet);
      if (_not) {
        _matched=true;
        _switchResult = Collections.<EObject>emptyList();
      }
      if (!_matched) {
        boolean _isMany = ref.isMany();
        if (_isMany) {
          _matched=true;
          Object _eGet = eObject.eGet(ref);
          _switchResult = ((Iterable<EObject>) _eGet);
        }
      }
      if (!_matched) {
        Object _eGet_1 = eObject.eGet(ref);
        _switchResult = Collections.<EObject>singleton(((EObject) _eGet_1));
      }
      return _switchResult;
    };
    return IterableExtensions.<EReference, EObject>flatMap(IterableExtensions.<EReference>reject(eObject.eClass().getEAllReferences(), _function), _function_1);
  }

  /**
   * Creates a self contained copy of a {@link ScopedTMSC}, containing just enough
   * content to be persisted and rendered.
   * 
   * @param scopedSource        the TMSC to copy
   * @param otherRootContainers other root containers that should be copied as
   *                            they are referred to by {@code scopedSource}.
   * @return a mapping of all copied {@link EObject}s from their original source
   *         to their copy.
   * @see ScopedTmscCopier#findOtherRootContainersToCopy(ScopedTMSC)
   */
  public static Map<EObject, EObject> copyTmsc(final ScopedTMSC scopedSource, final EObject... otherRootContainers) {
    return ScopedTmscCopier.copyTmscs(Collections.<ScopedTMSC>singleton(scopedSource), otherRootContainers);
  }

  public static Map<EObject, EObject> copyTmscs(final Iterable<ScopedTMSC> scopedSources, final EObject... otherRootContainers) {
    boolean _isEmpty = IterableExtensions.isEmpty(scopedSources);
    if (_isEmpty) {
      throw new IllegalArgumentException("Expected at least 1 scoped TMSC to copy");
    }
    final FullScopeTMSC fullSource = ScopedTmscCopier.getFullScope(scopedSources);
    final ScopedTmscCopier copier = new ScopedTmscCopier();
    final Function1<ScopedTMSC, EList<Dependency>> _function = (ScopedTMSC it) -> {
      return it.getDependencies();
    };
    Iterable<Dependency> _flatMap = IterableExtensions.<ScopedTMSC, Dependency>flatMap(scopedSources, _function);
    for (final Dependency dependency : _flatMap) {
      {
        copier.register(dependency);
        Event _source = dependency.getSource();
        Execution _execution = null;
        if (_source!=null) {
          _execution=_source.getExecution();
        }
        copier.register(_execution);
        Event _target = dependency.getTarget();
        Execution _execution_1 = null;
        if (_target!=null) {
          _execution_1=_target.getExecution();
        }
        copier.register(_execution_1);
        if ((dependency instanceof LifelineSegment)) {
          copier.register(((LifelineSegment)dependency).getActiveExecution());
        } else {
          if ((dependency instanceof MessageControl)) {
            copier.register(((MessageControl)dependency).getMessage());
            Event _source_1 = ((MessageControl)dependency).getMessage().getSource();
            Execution _execution_2 = null;
            if (_source_1!=null) {
              _execution_2=_source_1.getExecution();
            }
            copier.register(_execution_2);
            Event _target_1 = ((MessageControl)dependency).getMessage().getTarget();
            Execution _execution_3 = null;
            if (_target_1!=null) {
              _execution_3=_target_1.getExecution();
            }
            copier.register(_execution_3);
          }
        }
      }
    }
    copier.copy(EcoreUtil.getRootContainer(fullSource));
    final Function1<ScopedTMSC, ScopedTMSC> _function_1 = (ScopedTMSC ss) -> {
      EObject _copy = copier.copy(ss);
      return ((ScopedTMSC) _copy);
    };
    final List<ScopedTMSC> scopedTargets = IterableExtensions.<ScopedTMSC>toList(IterableExtensions.<ScopedTMSC, ScopedTMSC>map(scopedSources, _function_1));
    EObject _get = copier.get(fullSource);
    final FullScopeTMSC fullTarget = ((FullScopeTMSC) _get);
    final Function1<ScopedTMSC, Boolean> _function_2 = (ScopedTMSC it) -> {
      TMSC _parentScope = it.getParentScope();
      return Boolean.valueOf((_parentScope == null));
    };
    final Consumer<ScopedTMSC> _function_3 = (ScopedTMSC it) -> {
      it.setParentScope(fullTarget);
    };
    IterableExtensions.<ScopedTMSC>filter(scopedTargets, _function_2).forEach(_function_3);
    copier.<EObject>copyAll(((Collection<? extends EObject>)Conversions.doWrapArray(otherRootContainers)));
    copier.copyReferences();
    TmscRefinements.refineWithCompleteOrder(fullTarget);
    final Consumer<Lifeline> _function_4 = (Lifeline it) -> {
      ScopedTmscCopier.updateCallStackHierarchy(it);
    };
    fullTarget.getLifelines().forEach(_function_4);
    return copier;
  }

  private static Execution updateCallStackHierarchy(final Lifeline lifeline) {
    final Function2<Execution, Event, Execution> _function = (Execution currentExecution, Event event) -> {
      final Execution eventExecution = event.getExecution();
      Execution _switchResult = null;
      boolean _matched = false;
      if ((eventExecution == null)) {
        _matched=true;
        _switchResult = currentExecution;
      }
      if (!_matched) {
        if (event instanceof EntryEvent) {
          _matched=true;
          Execution _xblockexpression = null;
          {
            eventExecution.getChildren().clear();
            if ((currentExecution != null)) {
              EList<Execution> _children = currentExecution.getChildren();
              _children.add(eventExecution);
            }
            _xblockexpression = eventExecution;
          }
          _switchResult = _xblockexpression;
        }
      }
      if (!_matched) {
        if (event instanceof ExitEvent) {
          _matched=true;
          _switchResult = eventExecution.getParent();
        }
      }
      return _switchResult;
    };
    return IterableExtensions.<Event, Execution>fold(lifeline.getEvents(), null, _function);
  }

  private void register(final Dependency dependency) {
    if ((dependency == null)) {
      return;
    }
    this.registeredDependencies.add(dependency);
    Event _source = dependency.getSource();
    boolean _tripleNotEquals = (_source != null);
    if (_tripleNotEquals) {
      final Function<Lifeline, Set<Event>> _function = (Lifeline it) -> {
        return CollectionLiterals.<Event>newHashSet();
      };
      this.registeredLifelineEvents.computeIfAbsent(dependency.getSource().getLifeline(), _function).add(dependency.getSource());
    }
    Event _target = dependency.getTarget();
    boolean _tripleNotEquals_1 = (_target != null);
    if (_tripleNotEquals_1) {
      final Function<Lifeline, Set<Event>> _function_1 = (Lifeline it) -> {
        return CollectionLiterals.<Event>newHashSet();
      };
      this.registeredLifelineEvents.computeIfAbsent(dependency.getTarget().getLifeline(), _function_1).add(dependency.getTarget());
    }
  }

  private void register(final Execution execution) {
    if ((execution == null)) {
      return;
    }
    this.registeredExecutions.add(execution);
    EntryEvent _entry = execution.getEntry();
    boolean _tripleNotEquals = (_entry != null);
    if (_tripleNotEquals) {
      final Function<Lifeline, Set<Event>> _function = (Lifeline it) -> {
        return CollectionLiterals.<Event>newHashSet();
      };
      this.registeredLifelineEvents.computeIfAbsent(execution.getEntry().getLifeline(), _function).add(execution.getEntry());
    }
    ExitEvent _exit = execution.getExit();
    boolean _tripleNotEquals_1 = (_exit != null);
    if (_tripleNotEquals_1) {
      final Function<Lifeline, Set<Event>> _function_1 = (Lifeline it) -> {
        return CollectionLiterals.<Event>newHashSet();
      };
      this.registeredLifelineEvents.computeIfAbsent(execution.getEntry().getLifeline(), _function_1).add(execution.getExit());
    }
  }

  private boolean isRegistered(final Event event) {
    final Function1<Set<Event>, Boolean> _function = (Set<Event> it) -> {
      return Boolean.valueOf(it.contains(event));
    };
    return IterableExtensions.<Set<Event>>exists(this.registeredLifelineEvents.values(), _function);
  }

  /**
   * Apply mapping semantics, copy once
   */
  @Override
  public EObject copy(final EObject eObject) {
    final EObject copy = this.get(eObject);
    EObject _xifexpression = null;
    if ((copy != null)) {
      _xifexpression = copy;
    } else {
      _xifexpression = super.copy(eObject);
    }
    return _xifexpression;
  }

  /**
   * @see #copyAll(Collection)
   */
  public <T extends Object> Collection<T> copyAll(final Iterable<? extends T> eObjects) {
    return this.<T>copyAll(IterableExtensions.toList(eObjects));
  }

  /**
   * We do not want to copy the whole model, so apply filtering for specific containments.
   */
  @Override
  protected void copyContainment(final EReference eReference, final EObject eObject, final EObject copyEObject) {
    boolean _matched = false;
    if (eObject instanceof FullScopeTMSC) {
      boolean _equals = Objects.equals(eReference, TmscPackage.Literals.TMSC__CHILD_SCOPES);
      if (_equals) {
        _matched=true;
        return;
      }
    }
    if (!_matched) {
      boolean _equals = Objects.equals(eReference, TmscPackage.Literals.FULL_SCOPE_TMSC__MEASUREMENTS);
      if (_equals) {
        _matched=true;
        final FullScopeTMSC source = ((FullScopeTMSC) eObject);
        final FullScopeTMSC target = ((FullScopeTMSC) copyEObject);
        EList<Measurement> _measurements = target.getMeasurements();
        final Function1<Measurement, Boolean> _function = (Measurement m) -> {
          return Boolean.valueOf((this.isRegistered(m.getFrom()) && this.isRegistered(m.getTo())));
        };
        Collection<Measurement> _copyAll = this.<Measurement>copyAll(IterableExtensions.<Measurement>filter(source.getMeasurements(), _function));
        Iterables.<Measurement>addAll(_measurements, _copyAll);
      }
    }
    if (!_matched) {
      boolean _equals_1 = Objects.equals(eReference, TmscPackage.Literals.FULL_SCOPE_TMSC__DEPENDENCIES);
      if (_equals_1) {
        _matched=true;
        final FullScopeTMSC source_1 = ((FullScopeTMSC) eObject);
        final FullScopeTMSC target_1 = ((FullScopeTMSC) copyEObject);
        EList<Dependency> _dependencies = target_1.getDependencies();
        final Function1<Dependency, Boolean> _function_1 = (Dependency d) -> {
          return Boolean.valueOf(this.registeredDependencies.contains(d));
        };
        Collection<Dependency> _copyAll_1 = this.<Dependency>copyAll(IterableExtensions.<Dependency>filter(source_1.getDependencies(), _function_1));
        Iterables.<Dependency>addAll(_dependencies, _copyAll_1);
      }
    }
    if (!_matched) {
      boolean _equals_2 = Objects.equals(eReference, TmscPackage.Literals.FULL_SCOPE_TMSC__LIFELINES);
      if (_equals_2) {
        _matched=true;
        final FullScopeTMSC source_2 = ((FullScopeTMSC) eObject);
        final FullScopeTMSC target_2 = ((FullScopeTMSC) copyEObject);
        EList<Lifeline> _lifelines = target_2.getLifelines();
        final Function1<Lifeline, Boolean> _function_2 = (Lifeline l) -> {
          return Boolean.valueOf(this.registeredLifelineEvents.containsKey(l));
        };
        Collection<Lifeline> _copyAll_2 = this.<Lifeline>copyAll(IterableExtensions.<Lifeline>filter(source_2.getLifelines(), _function_2));
        Iterables.<Lifeline>addAll(_lifelines, _copyAll_2);
      }
    }
    if (!_matched) {
      boolean _equals_3 = Objects.equals(eReference, TmscPackage.Literals.LIFELINE__EVENTS);
      if (_equals_3) {
        _matched=true;
        final Lifeline source_3 = ((Lifeline) eObject);
        final Lifeline target_3 = ((Lifeline) copyEObject);
        final Set<Event> sourceEvents = this.registeredLifelineEvents.get(source_3);
        EList<Event> _events = target_3.getEvents();
        final Function1<Event, Boolean> _function_3 = (Event e) -> {
          return Boolean.valueOf(sourceEvents.contains(e));
        };
        Collection<Event> _copyAll_3 = this.<Event>copyAll(IterableExtensions.<Event>filter(source_3.getEvents(), _function_3));
        Iterables.<Event>addAll(_events, _copyAll_3);
      }
    }
    if (!_matched) {
      boolean _equals_4 = Objects.equals(eReference, TmscPackage.Literals.LIFELINE__EXECUTIONS);
      if (_equals_4) {
        _matched=true;
        final Lifeline source_4 = ((Lifeline) eObject);
        final Lifeline target_4 = ((Lifeline) copyEObject);
        EList<Execution> _executions = target_4.getExecutions();
        final Function1<Execution, Boolean> _function_4 = (Execution d) -> {
          return Boolean.valueOf(this.registeredExecutions.contains(d));
        };
        Collection<Execution> _copyAll_4 = this.<Execution>copyAll(IterableExtensions.<Execution>filter(source_4.getExecutions(), _function_4));
        Iterables.<Execution>addAll(_executions, _copyAll_4);
      }
    }
    if (!_matched) {
      super.copyContainment(eReference, eObject, copyEObject);
    }
  }
}
