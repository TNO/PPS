/**
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.xtext.generator;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.io.IOException;
import java.util.function.Consumer;
import nl.esi.pps.architecture.ArchitectureModel;
import nl.esi.pps.architecture.ArchitecturePlugin;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.TmscPlugin;
import nl.esi.pps.tmsc.analysis.DefaultScheduledDependencyAnalysis;
import nl.esi.pps.tmsc.analysis.DefaultTimeBoundAnalysis;
import nl.esi.pps.tmsc.metric.MetricFactory;
import nl.esi.pps.tmsc.metric.MetricModel;
import nl.esi.pps.tmsc.metric.MetricPlugin;
import nl.esi.pps.tmsc.metric.extension.MetricProcessor;
import nl.esi.pps.tmsc.provider.TmscEditPlugin;
import nl.esi.pps.tmsc.xtext.services.TmscXtextGrammarAccess;
import nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextModel;
import nl.esi.pps.tmsc.xtext.tmscXtext.XArchitectureKind;
import nl.esi.pps.tmsc.xtext.tmscXtext.XEvent;
import nl.esi.pps.tmsc.xtext.tmscXtext.XTimeBoundAnalysis;
import nl.esi.pps.tmsc.xtext.tmscXtext.XTmscAnalysis;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.nodemodel.BidiIterable;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
@SuppressWarnings("all")
public class TmscXtextGenerator extends AbstractGenerator {
  @Inject
  @Extension
  private TmscXtextGrammarAccess tmscXtextGrammarAccess;

  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    final TmscXtextModel xtextTmsc = IterableExtensions.<TmscXtextModel>head(Iterables.<TmscXtextModel>filter(resource.getContents(), TmscXtextModel.class));
    if ((xtextTmsc == null)) {
      return;
    }
    final FullScopeTMSC tmsc = this.doTransform(xtextTmsc);
    final String tmscFileName = resource.getURI().trimFileExtension().lastSegment();
    final ResourceSet tmscResourceSet = TmscEditPlugin.createResourceSet();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(tmscFileName);
    _builder.append(".");
    _builder.append(TmscPlugin.TMSC_FILE_EXTENSION_XMI);
    final URI tmscURI = fsa.getURI(_builder.toString());
    final Resource tmscResource = tmscResourceSet.createResource(tmscURI);
    EList<EObject> _contents = tmscResource.getContents();
    _contents.add(tmsc);
    XArchitectureKind _architectureKind = xtextTmsc.getArchitectureKind();
    if (_architectureKind != null) {
      switch (_architectureKind) {
        case INTERNAL:
          EList<EObject> _contents_1 = tmscResource.getContents();
          EList<ArchitectureModel> _architectures = tmsc.getArchitectures();
          Iterables.<EObject>addAll(_contents_1, _architectures);
          break;
        case EXTERNAL:
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append(tmscFileName);
          _builder_1.append(".");
          _builder_1.append(ArchitecturePlugin.ARCHITECTURE_FILE_EXTENSION_XMI);
          final URI archURI = fsa.getURI(_builder_1.toString());
          final Resource archResource = tmscResourceSet.createResource(archURI);
          EList<EObject> _contents_2 = archResource.getContents();
          EList<ArchitectureModel> _architectures_1 = tmsc.getArchitectures();
          Iterables.<EObject>addAll(_contents_2, _architectures_1);
          try {
            archResource.save(null);
          } catch (final Throwable _t) {
            if (_t instanceof IOException) {
              final IOException e = (IOException)_t;
              Class<? extends TmscXtextGenerator> _class = this.getClass();
              String _message = e.getMessage();
              String _plus = ("Failed to save architecture: " + _message);
              Status _status = new Status(IStatus.ERROR, _class, _plus, e);
              TmscEditPlugin.INSTANCE.log(_status);
              return;
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
          break;
        default:
          break;
      }
    }
    final MetricModel metricModel = MetricFactory.eINSTANCE.createMetricModel();
    final Consumer<MetricProcessor> _function = (MetricProcessor p) -> {
      p.analyse(tmsc, metricModel);
    };
    MetricPlugin.getPlugin().getRegisteredMetricProcessors(tmsc).values().forEach(_function);
    boolean _isEmpty = metricModel.getMetrics().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      EList<EObject> _contents_3 = tmscResource.getContents();
      _contents_3.add(metricModel);
    }
    EList<XTmscAnalysis> _analyses = xtextTmsc.getAnalyses();
    for (final XTmscAnalysis analysis : _analyses) {
      boolean _matched = false;
      if (analysis instanceof XTimeBoundAnalysis) {
        _matched=true;
        final Long defaultTimeBound = TmscXtextToTmscTransformation.toNanos(((XTimeBoundAnalysis)analysis).getDefaultTimeBound());
        Long _elvis = null;
        if (defaultTimeBound != null) {
          _elvis = defaultTimeBound;
        } else {
          _elvis = Long.valueOf(0L);
        }
        new DefaultTimeBoundAnalysis((long) _elvis).analyzeTimeBounds(tmsc);
      }
    }
    try {
      tmscResource.save(null);
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException e = (IOException)_t;
        Class<? extends TmscXtextGenerator> _class = this.getClass();
        String _message = e.getMessage();
        String _plus = ("Failed to save tmsc: " + _message);
        Status _status = new Status(IStatus.ERROR, _class, _plus, e);
        TmscEditPlugin.INSTANCE.log(_status);
        return;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }

  private FullScopeTMSC doTransform(final TmscXtextModel tmscXtext) {
    final Function1<XEvent, ICompositeNode> _function = (XEvent it) -> {
      return TmscXtextGenerator.<ICompositeNode>adapt(it, ICompositeNode.class);
    };
    final Function1<ICompositeNode, BidiIterable<INode>> _function_1 = (ICompositeNode it) -> {
      return it.getChildren();
    };
    final Function1<INode, EObject> _function_2 = (INode it) -> {
      return it.getGrammarElement();
    };
    final Iterable<EObject> eventGrammarElements = IterableExtensions.<INode, EObject>map(IterableExtensions.<ICompositeNode, INode>flatMap(ListExtensions.<XEvent, ICompositeNode>map(tmscXtext.getEvents(), _function), _function_1), _function_2);
    final boolean containsISO8601 = IterableExtensions.contains(eventGrammarElements, this.tmscXtextGrammarAccess.getXEventAccess().getTimestampISO8601TerminalRuleCall_0_0_0());
    FullScopeTMSC _transform = new TmscXtextToTmscTransformation().transform(tmscXtext);
    final Procedure1<FullScopeTMSC> _function_3 = (FullScopeTMSC tmsc) -> {
      tmsc.setEpochTime(containsISO8601);
      new DefaultScheduledDependencyAnalysis().analyzeScheduledDependencies(tmsc, false);
    };
    return ObjectExtensions.<FullScopeTMSC>operator_doubleArrow(_transform, _function_3);
  }

  public static <T extends Object> T adapt(final Notifier notifier, final Class<T> adapterType) {
    Adapter _adapter = EcoreUtil.getAdapter(notifier.eAdapters(), adapterType);
    return ((T) _adapter);
  }
}
