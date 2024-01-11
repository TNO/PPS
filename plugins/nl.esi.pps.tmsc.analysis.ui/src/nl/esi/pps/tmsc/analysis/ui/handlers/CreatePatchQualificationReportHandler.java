/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */

package nl.esi.pps.tmsc.analysis.ui.handlers;

import static nl.esi.pps.common.ide.ui.jobs.StatusReportingJob.DEFAULT_LOG_SEVERITIES;
import static nl.esi.pps.tmsc.analysis.ui.Activator.getPluginID;
import static nl.esi.pps.ui.handlers.AbstractCommandHandler.DEFAULT_DIALOG_SEVERITIES;
import static org.eclipse.core.runtime.IStatus.ERROR;
import static org.eclipse.lsat.common.queries.QueryableIterable.from;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Named;

import org.apache.commons.lang3.ArrayUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Evaluate;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.lsat.common.emf.common.util.URIHelper;
import org.eclipse.lsat.common.emf.ecore.resource.Persistor;
import org.eclipse.lsat.common.emf.ecore.resource.PersistorFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import nl.esi.emf.properties.provider.PropertiesItemProviderAdapterFactory;
import nl.esi.pps.architecture.implemented.provider.ImplementedItemProviderAdapterFactory;
import nl.esi.pps.architecture.instantiated.provider.InstantiatedItemProviderAdapterFactory;
import nl.esi.pps.architecture.provider.ArchitectureItemProviderAdapterFactory;
import nl.esi.pps.architecture.specified.provider.SpecifiedItemProviderAdapterFactory;
import nl.esi.pps.common.core.runtime.ErrorStatusException;
import nl.esi.pps.common.core.runtime.FailOnErrorStatus;
import nl.esi.pps.common.core.runtime.jobs.IStatusJobFunction;
import nl.esi.pps.common.ide.ui.jobs.StatusReportingJob;
import nl.esi.pps.common.jfreechart.rendering.RenderingPaint;
import nl.esi.pps.preferences.PPSPreferences;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.LifelineSegment;
import nl.esi.pps.tmsc.ScopedTMSC;
import nl.esi.pps.tmsc.TMSC;
import nl.esi.pps.tmsc.TmscFactory;
import nl.esi.pps.tmsc.TmscPlugin;
import nl.esi.pps.tmsc.analysis.CriticalPathAnalysis;
import nl.esi.pps.tmsc.analysis.RootCauseAnalysis;
import nl.esi.pps.tmsc.analysis.TimeBoundOutlierAnalysis;
import nl.esi.pps.tmsc.compare.ArchitectureLifecycleStage;
import nl.esi.pps.tmsc.compare.ITmscMatchResult;
import nl.esi.pps.tmsc.compare.TmscIsomorphismMatcher;
import nl.esi.pps.tmsc.compare.TmscMatchResult;
import nl.esi.pps.tmsc.compare.TmscServiceMatcher;
import nl.esi.pps.tmsc.compare.TmscWalkinshawMatcher;
import nl.esi.pps.tmsc.compare.ext.TMSCMatcher;
import nl.esi.pps.tmsc.metric.Metric;
import nl.esi.pps.tmsc.metric.MetricInstance;
import nl.esi.pps.tmsc.metric.MetricPlugin;
import nl.esi.pps.tmsc.metric.extension.MetricProcessor;
import nl.esi.pps.tmsc.provider.TmscItemProviderAdapterFactory;
import nl.esi.pps.tmsc.rendering.RenderingProperties;
import nl.esi.pps.tmsc.rendering.plot.ScopesRenderingStrategy;
import nl.esi.pps.tmsc.util.TmscQueries;

public class CreatePatchQualificationReportHandler {
	
	private static final DecimalFormat INDEX_FORMAT = new DecimalFormat("000");
	private static final String INDEX_PROPERTY = "Isomorphism class";
	
	@Evaluate
	@CanExecute
	public boolean canExecute(@Named(IServiceConstants.ACTIVE_SELECTION) @Optional IStructuredSelection selection) {
		if (!PPSPreferences.isAdvancedFeaturesEnabled() || selection == null || selection.size() != 2
				|| MetricPlugin.getPlugin().getRegisteredMetricProcessors().isEmpty()) {
			return false;
		}
		return from((Iterable<?>) selection).forAll(f -> f instanceof IFile && TmscPlugin.isTmscFile(((IFile) f)));
	}

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SELECTION) IStructuredSelection selection,
			@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
		
		CompareInputDialog inputDialog = new CompareInputDialog(shell);
		if (inputDialog.open() != InputDialog.OK) {
			return;
		}
		
		Iterator<?> selectionIterator = selection.iterator();
		IFile tmscIFile1 = (IFile) selectionIterator.next();
		IFile tmscIFile2 = (IFile) selectionIterator.next();

		IStatusJobFunction jobFunction = monitor -> doJob(tmscIFile1, tmscIFile2, inputDialog.getValue(), inputDialog.getMetricId(), inputDialog.getStage(), inputDialog.getMatcher(), monitor);
		Job job = new StatusReportingJob("Create patch qualification report", jobFunction, getPluginID(),
				DEFAULT_DIALOG_SEVERITIES, DEFAULT_LOG_SEVERITIES);
		job.setUser(true);
		job.schedule();
	}

	private static IStatus doJob(IFile tmscIFile1, IFile tmscIFile2, String postfix, String metricId, ArchitectureLifecycleStage stage, TMSCMatcher matcher, IProgressMonitor monitor)
			throws ErrorStatusException {
		FailOnErrorStatus result = new FailOnErrorStatus(getPluginID(), "Created patch qualification report");
		Collection<MetricProcessor> metricProcessors = MetricPlugin.getPlugin().getRegisteredMetricProcessors()
				.values();
		SubMonitor subMonitor = SubMonitor.convert(monitor, 2 * metricProcessors.size() * 100);

		ResourceSet resourceSet = createResourceSet();

		FullScopeTMSC preFullScopedTmsc;
		FullScopeTMSC postFullScopedTmsc;

		//FIXME: Selecting what is pre and what is post should not be done based on magic strings in the path!!!
		if(tmscIFile1.getFullPath().toString().contains("PRE")) {
			preFullScopedTmsc = loadTMSCFile(URIHelper.asURI(tmscIFile1), postfix, resourceSet, subMonitor.split(20), result);
			postFullScopedTmsc = loadTMSCFile(URIHelper.asURI(tmscIFile2), postfix, resourceSet, subMonitor.split(20), result);	
		} else {
			preFullScopedTmsc = loadTMSCFile(URIHelper.asURI(tmscIFile2), postfix, resourceSet, subMonitor.split(20), result);
			postFullScopedTmsc = loadTMSCFile(URIHelper.asURI(tmscIFile1), postfix, resourceSet, subMonitor.split(20), result);
		}

		MetricProcessor metricProcessor = metricProcessors.iterator().next();
		Metric preMetricInstances = metricProcessor.analyse(preFullScopedTmsc);
		Metric postMetricInstances = metricProcessor.analyse(postFullScopedTmsc);

		int counter = 0;
		BiMap<MetricInstance, ScopedTMSC> preActivityTmscs = HashBiMap.create(from(preMetricInstances.getInstances()).toMap(o -> o, CreateIntervalActivityStrategy.ACTIVITY::createTMSC));
		BiMap<MetricInstance, ScopedTMSC> postActivityTmscs = HashBiMap.create(from(postMetricInstances.getInstances()).toMap(o -> o, CreateIntervalActivityStrategy.ACTIVITY::createTMSC));					
		BiMap<MetricInstance, ScopedTMSC> preCausalScheduledActivityTmscs = HashBiMap.create(from(preMetricInstances.getInstances()).toMap(o -> o, CreateIntervalActivityStrategy.CAUSAL_SCHEDULED_ACTIVITY::createTMSC));
		BiMap<MetricInstance, ScopedTMSC> postCausalScheduledActivityTmscs = HashBiMap.create(from(postMetricInstances.getInstances()).toMap(o -> o, CreateIntervalActivityStrategy.CAUSAL_SCHEDULED_ACTIVITY::createTMSC));					

		List<List<ScopedTMSC>> preActivityTmscClasses =  TmscIsomorphismMatcher.findIsomorphismClasses(preActivityTmscs.values().iterator(), stage);
		List<List<ScopedTMSC>> postActivityTmscClasses =  TmscIsomorphismMatcher.findIsomorphismClasses(postActivityTmscs.values().iterator(), stage);

		List<Dependency> preDeltaDependencies = new ArrayList<Dependency>();
		List<Dependency> postDeltaDependencies = new ArrayList<Dependency>();

		Map<List<ScopedTMSC>, List<ScopedTMSC>> comparedClasses = new HashMap<>();

		for(Map.Entry<MetricInstance, ScopedTMSC> postEntry: postActivityTmscs.entrySet()) {
			List<ScopedTMSC> preVisitedIsomorphismClass = new ArrayList<ScopedTMSC>();
			List<ScopedTMSC> postVisitedIsomorphismClass = new ArrayList<ScopedTMSC>();
			MetricInstance postMetric = postEntry.getKey();
			ScopedTMSC postTmsc = postEntry.getValue();

			MetricInstance preMetric = preActivityTmscs.keySet().stream().filter(m -> m.getId().equals(postMetric.getId())).findFirst().orElse(null);
			if(preMetric == null)
				throw new RuntimeException("No corresponding metric instance has found!");
			ScopedTMSC preTmsc = preActivityTmscs.get(preMetric);

			boolean newComparison = true;
			for(Map.Entry<List<ScopedTMSC>, List<ScopedTMSC>> entry: comparedClasses.entrySet()) {
				if(entry.getKey().contains(preTmsc) && entry.getValue().contains(postTmsc))
					newComparison = false;
			}

			if(newComparison && postMetric.getId().contains(metricId)) {
				/*
				 * Time-bounds of all dependencies in both tmsc instances (pre and post) are collected from their siblings 
				 * use activity or scheduled activity tmsc?
				 * */
				
				Long budget = Long.valueOf(0);
				for(MetricInstance metric: preActivityTmscs.keySet())
					//if(budget < metric.getDuration())
					budget += metric.getDuration()/preActivityTmscs.keySet().size();
				postMetric.getMetric().setBudget(budget);
				
				Set<MetricInstance> preIsomorphicMetricInstances = new HashSet<MetricInstance>(); 
				Set<MetricInstance> postIsomorphicMetricInstances = new HashSet<MetricInstance>();

				for(List<ScopedTMSC> isomorphicTMSCs: preActivityTmscClasses) {
					if(isomorphicTMSCs.contains(preTmsc)) {
						preVisitedIsomorphismClass = isomorphicTMSCs;
						for(ScopedTMSC tmsc: isomorphicTMSCs)
							preIsomorphicMetricInstances.add(preActivityTmscs.inverse().get(tmsc));
					}
				}

				for(List<ScopedTMSC> isomorphicTMSCs: postActivityTmscClasses) {
					if(isomorphicTMSCs.contains(postTmsc)) {
						postVisitedIsomorphismClass = isomorphicTMSCs;
						for(ScopedTMSC tmsc: isomorphicTMSCs)
							postIsomorphicMetricInstances.add(postActivityTmscs.inverse().get(tmsc));
					}
				}
				
				collectTimeBoundSamples(preMetric, preIsomorphicMetricInstances, stage, matcher);
				collectTimeBoundSamples(postMetric, postIsomorphicMetricInstances, stage, matcher);

				comparedClasses.put(preVisitedIsomorphismClass, postVisitedIsomorphismClass);
				
				ITmscMatchResult primaryMatchResult = TmscServiceMatcher.match(preTmsc, postTmsc, stage::testDescription);
				ITmscMatchResult matchResult = TmscWalkinshawMatcher.match(preTmsc, postTmsc, primaryMatchResult.getEventMatches(), stage::testDescription);

				for (Dependency dep : preTmsc.getDependencies().stream().filter(d -> !matchResult.getDependencyMatches().containsKey(d)).collect(Collectors.toList())) {
					RenderingProperties.setPaint(dep, RenderingPaint.valueOf(counter%16));
					preDeltaDependencies.add(dep);
				}
				for (Dependency dep : postTmsc.getDependencies().stream().filter(d -> !matchResult.getDependencyMatches().containsValue(d)).collect(Collectors.toList())) {
					RenderingProperties.setPaint(dep, RenderingPaint.valueOf(counter%16));
					postDeltaDependencies.add(dep);
				}

				for(Map.Entry<Dependency, Dependency> depEntry: matchResult.getDependencyMatches().entrySet()) {
					ArrayList<Long> preTimeBoundSamples = TimeBoundOutlierAnalysis.getTimeBoundSamples(depEntry.getKey());
					TimeBoundOutlierAnalysis.setPreTimeBoundSamples(depEntry.getValue(), preTimeBoundSamples);
				}

				ScopedTMSC postCausalScheduledActivityTmsc = postCausalScheduledActivityTmscs.get(postMetric);
				ScopedTMSC preCausalScheduledActivityTmsc = preCausalScheduledActivityTmscs.get(preMetric);

				List<List<Dependency>> disjunctTmscDependencies = TmscQueries.findDisjunctTMSCs(postDeltaDependencies);
				CriticalPathAnalysis criticalPathAnalysis = new CriticalPathAnalysis();
				List<Dependency> scopedDep = postCausalScheduledActivityTmsc.getDependencies();
				
				Map<Dependency, List<Dependency>> projectedDepMapping = new HashMap<>();
				for(List<Dependency> subTmsc: disjunctTmscDependencies) {
					List<Event> eventList = TmscQueries.createCachedQueryTMSC(subTmsc).getEvents().stream().sorted((e1, e2) -> e1.getTimestamp().compareTo(e2.getTimestamp())).collect(Collectors.toList());
					Event postBegin = eventList.get(0);
					Event postEnd = eventList.get(eventList.size()-1);
					Event preBegin = matchResult.getEventMatches().inverse().get(postBegin);
					Event preEnd = matchResult.getEventMatches().inverse().get(postEnd);

					if(preBegin == null) {   
						preBegin = preEnd;
						Dependency incomingDependency = preTmsc.getIncomingDependencies(preBegin).stream().filter(d -> d instanceof LifelineSegment).findFirst().orElse(null);
						while(incomingDependency != null){
							preBegin = incomingDependency.getSource();
							incomingDependency = preTmsc.getIncomingDependencies(preBegin).stream().filter(d -> d instanceof LifelineSegment).findFirst().orElse(null);
					    }
					}
					
					if(preEnd == null) {   
						preEnd = preBegin;
						Dependency outgoingDependency = preTmsc.getOutgoingDependencies(preEnd).stream().filter(d -> d instanceof LifelineSegment).findFirst().orElse(null);
						while(outgoingDependency != null){
							preEnd = outgoingDependency.getTarget();
							outgoingDependency = preTmsc.getOutgoingDependencies(preEnd).stream().filter(d -> d instanceof LifelineSegment).findFirst().orElse(null);
					    }
					}
					
					if(postCausalScheduledActivityTmsc.getEvents().contains(postBegin) && postCausalScheduledActivityTmsc.getEvents().contains(postEnd)) {
						LifelineSegment projectedDep = TmscFactory.eINSTANCE.createLifelineSegment();
						projectedDep.setSource(postBegin);
						projectedDep.setProjection(true);
						projectedDep.setScheduled(false);
						projectedDep.setTarget(postEnd);
						scopedDep.add(projectedDep);

						Iterable<Dependency> postDepSet = criticalPathAnalysis.findCriticalPathBetween(postCausalScheduledActivityTmsc, postBegin, postEnd);
						Iterable<Dependency> preDepSet = (preBegin.getTimestamp().compareTo(preEnd.getTimestamp()) >= 0) ? Collections.emptyList() : criticalPathAnalysis.findCriticalPathBetween(preCausalScheduledActivityTmsc, preBegin, preEnd);
						postCausalScheduledActivityTmsc.getDependencies().forEach(d -> CriticalPathAnalysis.unsetCritical(d));
						preCausalScheduledActivityTmsc.getDependencies().forEach(d -> CriticalPathAnalysis.unsetCritical(d));

						ArrayList<Long> addedTimeBounds = new ArrayList<Long>();
						ArrayList<Long> addedPreTimeBounds = new ArrayList<Long>();

						for(Dependency dep: postDepSet) {
							if(addedTimeBounds.isEmpty())
								addedTimeBounds.addAll(TimeBoundOutlierAnalysis.getTimeBoundSamples(dep));
							else {
								ArrayList<Long> aux = TimeBoundOutlierAnalysis.getTimeBoundSamples(dep);
								if(aux == null || aux.isEmpty())
									throw new RuntimeException("time-bound samples of dependency type "+ dep.eClass().getName() + " between " + dep.getSource().getLifeline().getExecutor().getName() + " and " + dep.getTarget().getLifeline().getExecutor().getName() + " is empty!");

								for(int i=0; i< addedTimeBounds.size(); i++) {
									Long temp = addedTimeBounds.get(i) + aux.get(i);
									addedTimeBounds.set(i, temp);
								}
							}
						}
						TimeBoundOutlierAnalysis.setTimeBoundSamples(projectedDep, addedTimeBounds);

						for(Dependency dep: preDepSet) {
							if(addedPreTimeBounds.isEmpty())
								addedPreTimeBounds.addAll(TimeBoundOutlierAnalysis.getTimeBoundSamples(dep));
							else {
								ArrayList<Long> aux = TimeBoundOutlierAnalysis.getTimeBoundSamples(dep);
								if(aux == null || aux.isEmpty())
									throw new RuntimeException("time-bound samples of dependency type "+ dep.eClass().getName() + " between " + dep.getSource().getLifeline().getExecutor().getName() + " and " + dep.getTarget().getLifeline().getExecutor().getName() + " is empty!");

								for(int i=0; i< addedPreTimeBounds.size(); i++) {
									Long temp = addedPreTimeBounds.get(i) + aux.get(i);
									addedPreTimeBounds.set(i, temp);
								}
							}
						}
						TimeBoundOutlierAnalysis.setPreTimeBoundSamples(projectedDep, addedPreTimeBounds);

						projectedDep.setTimeBound(postEnd.getTimestamp() - postBegin.getTimestamp());
						postFullScopedTmsc.getDependencies().add(projectedDep);
						projectedDepMapping.put(projectedDep, subTmsc);
						scopedDep.removeAll(subTmsc);
					}
				}
				postFullScopedTmsc.getDependencies().forEach(d -> CriticalPathAnalysis.unsetCritical(d));
					
				RootCauseAnalysis rootCause = new RootCauseAnalysis();
				rootCause.analyseRootCause(postMetric, postCausalScheduledActivityTmsc);
				postFullScopedTmsc.getDependencies().addAll(from(postCausalScheduledActivityTmsc.getDependencies()).excluding(postTmsc.getDependencies()).asList());

				postFullScopedTmsc.getChildScopes().add(TmscQueries.createScopedTMSC(projectedDepMapping.keySet(), "Projected Dependencies"));
				postFullScopedTmsc.getChildScopes().add(TmscQueries.createScopedTMSC(projectedDepMapping.values().stream().flatMap(List::stream).collect(Collectors.toList()), "Delta Dependencies"));

				for(Map.Entry<Dependency, List<Dependency>> entry: projectedDepMapping.entrySet()) {
					if(CriticalPathAnalysis.isSetCritical(entry.getKey()))
						from(entry.getValue()).forEach(d -> CriticalPathAnalysis.setCritical(d, true));
				}
				
				saveTMSC(preFullScopedTmsc, subMonitor, result);
				saveTMSC(postFullScopedTmsc, subMonitor, result);
				counter ++;
			}
		}
		saveTMSC(preFullScopedTmsc, subMonitor, result);
		saveTMSC(postFullScopedTmsc, subMonitor, result);
		return result;
	}
	
	private static void diffClassification(FullScopeTMSC fullScopedTmsc, List<Dependency> diffDependencies, ArchitectureLifecycleStage stage) {
		List<List<Dependency>> disjunctTmscDependencies = TmscQueries.findDisjunctTMSCs(diffDependencies);
		List<ScopedTMSC> disjunctTmscs = new ArrayList<ScopedTMSC>();
		disjunctTmscDependencies.forEach(t -> {if(t.size() > 2) disjunctTmscs.add(TmscQueries.createScopedTMSC(t, ""));});

		List<List<ScopedTMSC>> isomorphismClasses = TmscIsomorphismMatcher.findIsomorphismClasses(disjunctTmscs.iterator(), stage);
		for (int index = 0; index < isomorphismClasses.size(); index++) {
			List<ScopedTMSC> isomorphicTMSCs = isomorphismClasses.get(index);
			ScopedTMSC isomorphismClassTMSC = TmscFactory.eINSTANCE.createScopedTMSC();
			isomorphismClassTMSC.setName(TmscQueries
					.toEID(String.format("Isomorphism class %s %d %d", INDEX_FORMAT.format(index + 1),
							isomorphicTMSCs.size(), isomorphicTMSCs.get(0).getDependencies().size())));
			isomorphismClassTMSC.getProperties().put(INDEX_PROPERTY, INDEX_FORMAT.format(index + 1));
			isomorphismClassTMSC.getChildScopes().addAll(isomorphicTMSCs);

			// All dependencies of a child scope should also be contained by its parent scope.
			isomorphismClassTMSC.getChildScopes().forEach(
					childScope -> isomorphismClassTMSC.getDependencies().addAll(childScope.getDependencies()));

			// IsomorphismClassTMSC itself is child-scope of tmsc
			fullScopedTmsc.getChildScopes().add(isomorphismClassTMSC);
			fullScopedTmsc.getDependencies().addAll(isomorphismClassTMSC.getDependencies());
		}
	}

	private static void collectTimeBoundSamples(MetricInstance metric, Collection<MetricInstance> metricInstances, ArchitectureLifecycleStage stage, TMSCMatcher matcher) {
		List<MetricInstance> sortedMetrics = metricInstances.stream().sorted((m1, m2) -> Integer.valueOf(m1.getId().substring(2)).compareTo(Integer.valueOf(m2.getId().substring(2)))).collect(Collectors.toList()); 
		for(MetricInstance otherMetric: sortedMetrics) {
			ScopedTMSC activityTmsc = CreateIntervalActivityStrategy.ACTIVITY.createTMSC(metric);
			ScopedTMSC otherActivityTmsc = CreateIntervalActivityStrategy.ACTIVITY.createTMSC(otherMetric);

			ITmscMatchResult matched = matcher.match(activityTmsc, otherActivityTmsc, stage);

			if (!matched.isFullMatch())
				throw new RuntimeException("Tmscs of an isomorphic class are not fully matched!");

			ScopedTMSC causalScheduledActivityTmsc = CreateIntervalActivityStrategy.CAUSAL_SCHEDULED_ACTIVITY.createTMSC(metric);
			ScopedTMSC otherCausalScheduledActivityTmsc = CreateIntervalActivityStrategy.CAUSAL_SCHEDULED_ACTIVITY.createTMSC(otherMetric);

			List<Dependency> dependencySet = causalScheduledActivityTmsc.getDependencies();
			dependencySet.removeAll(activityTmsc.getDependencies());
			dependencySet.addAll(activityTmsc.getDependencies());

			List<Dependency> otherDependencySet = otherCausalScheduledActivityTmsc.getDependencies();
			otherDependencySet.removeAll(otherActivityTmsc.getDependencies());
			otherDependencySet.addAll(otherActivityTmsc.getDependencies());

			ITmscMatchResult newMatched = new TmscMatchResult(TmscQueries.createCachedQueryTMSC(dependencySet), TmscQueries.createCachedQueryTMSC(otherDependencySet), matched.getEventMatches());
			for(Dependency dep: dependencySet.stream().filter(dep -> dep.getTimeBound() != null).collect(Collectors.toList())) {
				if(newMatched.getDependencyMatches().get(dep) != null) {
					ArrayList<Long> timeBoundSamples = new ArrayList<Long>();
					if(TimeBoundOutlierAnalysis.isSetTimeBoundSamples(dep))
						timeBoundSamples = TimeBoundOutlierAnalysis.getTimeBoundSamples(dep);
					timeBoundSamples.add(newMatched.getDependencyMatches().get(dep).getTimeBound());
					TimeBoundOutlierAnalysis.setTimeBoundSamples(dep, timeBoundSamples);
				}
			}
		}
	}
	
	
	private static FullScopeTMSC loadTMSCFile(URI tmscURI, String postfix, ResourceSet resourceSet, IProgressMonitor monitor,
		FailOnErrorStatus result) throws ErrorStatusException {
		Persistor<FullScopeTMSC> persistor = new PersistorFactory(resourceSet).getPersistor(FullScopeTMSC.class, true);
		try {
			monitor.setTaskName("Loading TMSC from " + tmscURI.lastSegment());
			Map<Object, Object> loadOptions = new HashMap<>();
			loadOptions.put(IProgressMonitor.class, monitor);
			FullScopeTMSC fullScopeTMSC = persistor.loadOne(tmscURI, loadOptions);
			if (fullScopeTMSC.getLifelines().isEmpty()) {
				throw new IOException("TMSC is empty");
			}
		
			// Prepare the resource for its save result
			URI tmscSaveURI = createSaveURI(tmscURI, postfix);
			resourceSet.createResource(tmscSaveURI).getContents().addAll(
				fullScopeTMSC.eResource().getContents());

			RenderingProperties.setRenderingStrategyID(fullScopeTMSC, ScopesRenderingStrategy.ID);
			return fullScopeTMSC;
		} catch (IOException ex) {
			result.add(new Status(ERROR, getPluginID(),
				String.format("Failed to load %s: %s", tmscURI, ex.getMessage()), ex));
			return null;
		}
	}

	private static URI createSaveURI(URI loadURI, String postfix) {
		String fileExtension = loadURI.fileExtension();
		String fileName = loadURI.trimFileExtension().lastSegment();
		return loadURI.trimSegments(1).appendSegment(fileName + "_" + postfix).appendFileExtension(fileExtension);
	}

	private static ResourceSet createResourceSet() {
		ResourceSetImpl resourceSet = new ResourceSetImpl();
	
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new TmscItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ArchitectureItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new SpecifiedItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ImplementedItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new InstantiatedItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new PropertiesItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		resourceSet.getAdapterFactories().add(adapterFactory);
	
		return resourceSet;
	}

	private static void saveTMSC(TMSC tmsc, IProgressMonitor monitor, FailOnErrorStatus result)
			throws ErrorStatusException {
		URI tmscSaveURI = tmsc.eResource().getURI();
		try {
			monitor.setTaskName("Saving TMSC to " + tmscSaveURI.lastSegment());
			Map<Object, Object> saveOptions = new HashMap<>();
			saveOptions.put(IProgressMonitor.class, monitor);
			tmsc.eResource().save(saveOptions);
		} catch (IOException ex) {
			result.add(new Status(ERROR, getPluginID(),
					String.format("Failed to save %s: %s", tmscSaveURI.lastSegment(), ex.getMessage()), ex));
		}
	}
	
	private static class CompareInputDialog extends InputDialog {
		private ArchitectureLifecycleStage stage = ArchitectureLifecycleStage.IMPLEMENTED;
		private TMSCMatcher matcher = TMSCMatcher.Isomorphism;
		private String metricId;
		
		public CompareInputDialog(Shell parentShell) {
			super(parentShell, "Compare TMSCs",
					"Please specify a common-part id to use for the comparison result.", "",
					s -> s.trim().isEmpty() ? "Cannot be empty" : null);
		}
		
		@Override
		protected Control createDialogArea(Composite parent) {
			Composite inputComposite = new Composite(parent, SWT.NONE);
			inputComposite.setFont(parent.getFont());
			inputComposite.setLayout(new GridLayout(1, true));
			inputComposite.setLayoutData(new GridData(GridData.FILL_BOTH));

			super.createDialogArea(inputComposite);
			
			Label label = new Label(inputComposite, SWT.NONE);
			label.setText("Please specify the index metric instance for timing comparison");
			Text text = new Text(inputComposite, getInputTextStyle());
			text.addModifyListener(e -> 		
				{metricId = text.getText();}
			);
			
			Group btnGroup = new Group(inputComposite, SWT.NONE);
			
			btnGroup.setFont(parent.getFont());
			btnGroup.setText("Architecture lifecycle stage");
			btnGroup.setLayout(new GridLayout());
			btnGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
			
			for (ArchitectureLifecycleStage stage : ArchitectureLifecycleStage.values()) {
				Button btn = new Button(btnGroup, SWT.RADIO);
				btn.setText(stage.getLabel());
				btn.setData(stage);
				if (this.stage == stage) {
					btn.setSelection(true); // Default selection
				}
				btn.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						Button btn = (Button) e.widget;
						if (btn.getSelection()) {
							CompareInputDialog.this.stage = (ArchitectureLifecycleStage) btn.getData();
						}
					}
				});
			}

			Group btnGroup2 = new Group(inputComposite, SWT.NONE);
			btnGroup2.setFont(parent.getFont());
			btnGroup2.setText("Comparison algorithm - any combinations is allowed (default: Isomorphism)");
			btnGroup2.setLayout(new GridLayout());
			btnGroup2.setLayoutData(new GridData(GridData.FILL_BOTH));
			
			Button[] btn = new Button[3];
			btn[0] = new Button(btnGroup2, SWT.CHECK);
			btn[0].setText("Service");
			btn[1] = new Button(btnGroup2, SWT.CHECK);
			btn[1].setText("Isomorphism");
			btn[1].setSelection(true);
			btn[2] = new Button(btnGroup2, SWT.CHECK);
			btn[2].setText("Walkinshaw");
			String str = "010";
			StringBuilder selection = new StringBuilder(str);
			
			for (Button b : btn) {
				b.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						int index = ArrayUtils.indexOf(btn, b);
						if (b.getSelection())
							selection.setCharAt(index, '1');
						else
							selection.setCharAt(index, '0');
						
						switch (selection.toString()) {
						case "100":
							CompareInputDialog.this.matcher = TMSCMatcher.Service;
							break;
						case "010":
							CompareInputDialog.this.matcher = TMSCMatcher.Isomorphism;
							break;
						case "110":
							CompareInputDialog.this.matcher = TMSCMatcher.Service_Isomorphism;
							break;
						case "001":
							CompareInputDialog.this.matcher = TMSCMatcher.Walkinshaw;
							break;
						case "101":
							CompareInputDialog.this.matcher = TMSCMatcher.Service_Walkinshaw;
							break;
						case "011":
							CompareInputDialog.this.matcher = TMSCMatcher.Isomorphism_Walkinshaw;
							break;
						case "111":
							CompareInputDialog.this.matcher = TMSCMatcher.Service_Isomorphism_Walkinshaw;
							break;
						default:
							break;
						}
					}
				});
			}
			
			return inputComposite;
		}
		
		public ArchitectureLifecycleStage getStage() {
			return stage;
		}
		
		public TMSCMatcher getMatcher() {
			return matcher;
		}
		
		public String getMetricId() {
			return metricId;
		}
	}
}