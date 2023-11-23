/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */

package nl.esi.pps.tmsc.compare.ui.handlers;

import static nl.esi.pps.common.ide.ui.jobs.StatusReportingJob.DEFAULT_LOG_SEVERITIES;
import static nl.esi.pps.tmsc.compare.ui.Activator.getPluginID;
import static org.eclipse.core.runtime.IStatus.ERROR;
import static org.eclipse.lsat.common.queries.QueryableIterable.from;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiPredicate;

import javax.inject.Named;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
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
import org.eclipse.swt.widgets.Shell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nl.esi.pps.architecture.ArchitectureModel;
import nl.esi.pps.common.core.runtime.ErrorStatusException;
import nl.esi.pps.common.core.runtime.FailOnErrorStatus;
import nl.esi.pps.common.core.runtime.jobs.IStatusJobFunction;
import nl.esi.pps.common.core.runtime.jobs.JobUtils;
import nl.esi.pps.common.ide.ui.jobs.StatusReportingJob;
import nl.esi.pps.preferences.PPSPreferences;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.ScopedTMSC;
import nl.esi.pps.tmsc.TMSC;
import nl.esi.pps.tmsc.TmscPlugin;
import nl.esi.pps.tmsc.compare.ArchitectureLifecycleStage;
import nl.esi.pps.tmsc.compare.TMSCComparison;
import nl.esi.pps.tmsc.metric.MetricModel;
import nl.esi.pps.tmsc.provider.TmscEditPlugin;
import nl.esi.pps.tmsc.rendering.RenderingProperties;
import nl.esi.pps.tmsc.rendering.plot.ScopesRenderingStrategy;
import nl.esi.pps.tmsc.util.ScopedTmscCopier;

public class CompareTmscHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(CompareTmscHandler.class);

	@Evaluate
	@CanExecute
	public boolean canExecute(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) IStructuredSelection selection) {
		if (!PPSPreferences.isAdvancedFeaturesEnabled() || selection == null || selection.size() != 2) {
			return false;
		}
		boolean allScopedTMSC = from((Iterable<?>) selection).forAll(e -> e instanceof ScopedTMSC);
		boolean allIFile = from((Iterable<?>) selection)
				.forAll(e -> e instanceof IFile && TmscPlugin.isTmscFile((IFile) e));
		return allScopedTMSC || allIFile;
	}

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SELECTION) IStructuredSelection selection,
			@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
		Iterator<?> selectionIterator = selection.iterator();

		CompareInputDialog inputDialog = new CompareInputDialog(shell);
		if (inputDialog.open() != InputDialog.OK) {
			return;
		}

		IStatusJobFunction jobFunction;
		if (from((Iterable<?>) selection).forAll(e -> e instanceof TMSC)) {
			ScopedTMSC tmsc1 = (ScopedTMSC) selectionIterator.next();
			ScopedTMSC tmsc2 = (ScopedTMSC) selectionIterator.next();
			jobFunction = monitor -> doJob(tmsc1, tmsc2, inputDialog.getValue(), inputDialog.getStage(), monitor);
		} else {
			IFile tmscIFile1 = (IFile) selectionIterator.next();
			IFile tmscIFile2 = (IFile) selectionIterator.next();
			jobFunction = monitor -> doJob(tmscIFile1, tmscIFile2, inputDialog.getValue(), inputDialog.getStage(), monitor);
		}
		
		String jobName = "Compare TMSCs";
		Job job = new StatusReportingJob(jobName, jobFunction, getPluginID(), DEFAULT_LOG_SEVERITIES,
				DEFAULT_LOG_SEVERITIES);
		job.setUser(true);
		job.schedule();
	}

	public static IStatus doJob(IFile tmscIFile1, IFile tmscIFile2, String postfix, ArchitectureLifecycleStage stage, IProgressMonitor monitor)
			throws ErrorStatusException {
		SubMonitor subMonitor = SubMonitor.convert(monitor, 101);
		subMonitor.setTaskName("Comparing TMSCs...");

		FailOnErrorStatus result = new FailOnErrorStatus(getPluginID(), "Compare TMSCs");
		result.setErrorMessage("Failed to compare TMSCs.");

		ResourceSet resourceSet = TmscEditPlugin.createResourceSet();
		TMSC tmsc1 = loadCompareTMSC(URIHelper.asURI(tmscIFile1), postfix, resourceSet, subMonitor.split(20), result);
		TMSC tmsc2 = loadCompareTMSC(URIHelper.asURI(tmscIFile2), postfix, resourceSet, subMonitor.split(20), result);
		doCompare(tmsc1, tmsc2, postfix, stage, subMonitor.split(60), result);

		JobUtils.refreshWorkspaceProjects(subMonitor.split(1), tmscIFile1, tmscIFile2);
		return result;
	}
	
	private static TMSC loadCompareTMSC(URI tmscURI, String postfix, ResourceSet resourceSet, IProgressMonitor monitor,
			FailOnErrorStatus result) throws ErrorStatusException {
		Persistor<FullScopeTMSC> persistor = new PersistorFactory(resourceSet).getPersistor(FullScopeTMSC.class, true);
		try {
			monitor.setTaskName("Loading TMSC from " + tmscURI.lastSegment());
			Map<Object, Object> loadOptions = new HashMap<>();
			loadOptions.put(IProgressMonitor.class, monitor);
			FullScopeTMSC fullScopeTMSC = persistor.loadOne(tmscURI, loadOptions);
			if (fullScopeTMSC.isEmpty()) {
				throw new IOException("TMSC is empty");
			}
			
			// Prepare the resource for its save result
			URI tmscSaveURI = createSaveURI(tmscURI, postfix);
			resourceSet.createResource(tmscSaveURI).getContents().addAll(
					fullScopeTMSC.eResource().getContents());

			RenderingProperties.setRenderingStrategyID(fullScopeTMSC, ScopesRenderingStrategy.ID);
			if (fullScopeTMSC.getChildScopes().size() == 1) {
				ScopedTMSC scopedTMSC = fullScopeTMSC.getChildScopes().get(0);
				ScopesRenderingStrategy.setGroupKey((ScopedTMSC) scopedTMSC, true);
				return scopedTMSC;
			}
			return fullScopeTMSC;
		} catch (IOException ex) {
			result.add(new Status(ERROR, getPluginID(),
					String.format("Failed to load %s: %s", tmscURI, ex.getMessage()), ex));
			return null;
		}
	}

	public static IStatus doJob(ScopedTMSC tmsc1, ScopedTMSC tmsc2, String postfix, ArchitectureLifecycleStage stage, IProgressMonitor monitor)
			throws ErrorStatusException {
		SubMonitor subMonitor = SubMonitor.convert(monitor, 101);
		subMonitor.setTaskName("Comparing TMSCs...");

		FailOnErrorStatus result = new FailOnErrorStatus(getPluginID(), "Compare TMSCs");
		result.setErrorMessage("Failed to compare TMSCs.");

		String postfix1 = postfix;
		String postfix2 = postfix;
		if (Objects.equals(tmsc1.eResource().getURI(), tmsc2.eResource().getURI())) {
			postfix1 = tmsc1.getName() + "_" + postfix;
			postfix2 = tmsc2.getName() + "_" + postfix;
		}
				
		TMSC compareTMSC1 = createCompareTMSC(tmsc1, postfix1, subMonitor.split(20));
		TMSC compareTMSC2 = createCompareTMSC(tmsc2, postfix2, subMonitor.split(20));
		doCompare(compareTMSC1, compareTMSC2, postfix, stage, subMonitor.split(60), result);

		IResource resource1 = URIHelper.asIResource(tmsc1.eResource().getURI());
		IResource resource2 = URIHelper.asIResource(tmsc2.eResource().getURI());
		JobUtils.refreshWorkspaceProjects(subMonitor.split(1), resource1, resource2);
		return result;
	}

	private static TMSC createCompareTMSC(ScopedTMSC tmsc, String postfix, IProgressMonitor monitor) {
		EObject[] otherRootContainers = ScopedTmscCopier.findOtherRootContainersToCopy(tmsc, MetricModel.class::isInstance);
		Map<EObject, EObject> copyMap = ScopedTmscCopier.copyTmsc(tmsc, otherRootContainers);
		ScopedTMSC compareTMSC = (ScopedTMSC) copyMap.get(tmsc);
		ScopesRenderingStrategy.setGroupKey((ScopedTMSC) compareTMSC, true);
		FullScopeTMSC fullScopeTMSC = (FullScopeTMSC) copyMap.get(tmsc.getFullScope());
		RenderingProperties.setRenderingStrategyID(fullScopeTMSC, ScopesRenderingStrategy.ID);

		// Prepare the resource for its save result
		URI tmscSaveURI = createSaveURI(tmsc.eResource().getURI(), postfix);
		Resource tmscSaveResource = tmsc.eResource().getResourceSet().createResource(tmscSaveURI);
		tmscSaveResource.getContents().add(fullScopeTMSC);
		for (EObject rootContainer : otherRootContainers) {
			tmscSaveResource.getContents().add(copyMap.get(rootContainer));
		}
		
		return compareTMSC;
	}

	private static void doCompare(TMSC tmsc1, TMSC tmsc2, String postfix, ArchitectureLifecycleStage stage, IProgressMonitor monitor, FailOnErrorStatus result)
			throws ErrorStatusException {
		SubMonitor subMonitor = SubMonitor.convert(monitor, 60);
		subMonitor.setTaskName("Comparing TMSCs");

		List<ArchitectureModel> architectures1 = tmsc1.getFullScope().getArchitectures();
		List<ArchitectureModel> architectures2 = tmsc2.getFullScope().getArchitectures();
		BiPredicate<Event, Event> equivalence = stage;
		if (!Objects.equals(architectures1, architectures2)) {
			LOGGER.debug("Using string based equivalence {} for comparison", stage.name());
			equivalence = stage::testDescription;
		}

		subMonitor.split(20);
		TMSCComparison.compare(tmsc1, tmsc2, postfix, equivalence);
		
		saveCompareTMSC(tmsc1, subMonitor.split(20), result);
		saveCompareTMSC(tmsc2, subMonitor.split(20), result);
	}
	
	private static void saveCompareTMSC(TMSC tmsc, IProgressMonitor monitor, FailOnErrorStatus result)
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
	
	private static URI createSaveURI(URI loadURI, String postfix) {
		String fileExtension = loadURI.fileExtension();
		String fileName = loadURI.trimFileExtension().lastSegment();
		return loadURI.trimSegments(1).appendSegment(fileName + "_" + postfix).appendFileExtension(fileExtension);
	}

	private static class CompareInputDialog extends InputDialog {
		private ArchitectureLifecycleStage stage = ArchitectureLifecycleStage.IMPLEMENTED;

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

			return inputComposite;
		}
		
		public ArchitectureLifecycleStage getStage() {
			return stage;
		}
	}
}