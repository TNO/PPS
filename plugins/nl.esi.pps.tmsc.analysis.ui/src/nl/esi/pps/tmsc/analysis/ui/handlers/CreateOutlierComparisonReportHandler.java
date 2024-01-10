
package nl.esi.pps.tmsc.analysis.ui.handlers;

import static nl.esi.pps.common.ide.ui.jobs.StatusReportingJob.DEFAULT_LOG_SEVERITIES;
import static nl.esi.pps.tmsc.analysis.ui.Activator.getPluginID;
import static nl.esi.pps.ui.handlers.AbstractCommandHandler.DEFAULT_DIALOG_SEVERITIES;
import static org.eclipse.core.runtime.IStatus.ERROR;
import static org.eclipse.lsat.common.queries.QueryableIterable.from;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Named;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Evaluate;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
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
import org.eclipse.swt.widgets.Shell;

import com.google.common.collect.BiMap;

import nl.esi.pps.common.core.runtime.ErrorStatusException;
import nl.esi.pps.common.core.runtime.FailOnErrorStatus;
import nl.esi.pps.common.core.runtime.jobs.IStatusJobFunction;
import nl.esi.pps.common.ide.ui.jobs.StatusReportingJob;
import nl.esi.pps.common.jfreechart.rendering.RenderingPaint;
import nl.esi.pps.preferences.PPSPreferences;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.ScopedTMSC;
import nl.esi.pps.tmsc.TMSC;
import nl.esi.pps.tmsc.TmscPlugin;
import nl.esi.pps.tmsc.analysis.ui.Activator;
import nl.esi.pps.tmsc.compare.ArchitectureLifecycleStage;
import nl.esi.pps.tmsc.compare.ITmscMatchResult;
import nl.esi.pps.tmsc.compare.TmscIsomorphismMatcher;
import nl.esi.pps.tmsc.compare.TmscServiceMatcher;
import nl.esi.pps.tmsc.metric.Metric;
import nl.esi.pps.tmsc.metric.MetricInstance;
import nl.esi.pps.tmsc.metric.MetricPlugin;
import nl.esi.pps.tmsc.metric.extension.MetricProcessor;
import nl.esi.pps.tmsc.rendering.RenderingProperties;

public class CreateOutlierComparisonReportHandler {
	@Evaluate
	@CanExecute
	public boolean canExecute(@Named(IServiceConstants.ACTIVE_SELECTION) @Optional IStructuredSelection selection) {
		if (!PPSPreferences.isAdvancedFeaturesEnabled() || selection == null || selection.isEmpty()
				|| MetricPlugin.getPlugin().getRegisteredMetricProcessors().isEmpty()) {
			return false;
		}
		return from((Iterable<?>) selection).forAll(f -> f instanceof IFile && TmscPlugin.isTmscFile(((IFile) f)));
	}

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SELECTION) IStructuredSelection selection,
			@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
		StrageSelectionDialog selectionDialog = new StrageSelectionDialog(shell);
		if (selectionDialog.open() != Window.OK) {
			return;
		}

		LinkedList<IFile> tmscIFiles = from((Iterable<?>) selection).objectsOfKind(IFile.class).asList();
		IStatusJobFunction jobFunction = monitor -> doJob(tmscIFiles, selectionDialog.getStage(), monitor);
		Job job = new StatusReportingJob("Create outlier comparison report", jobFunction, getPluginID(),
				DEFAULT_DIALOG_SEVERITIES, DEFAULT_LOG_SEVERITIES);
		job.setUser(true);
		job.schedule();
	}

	private static IStatus doJob(List<IFile> tmscIFiles, ArchitectureLifecycleStage stage, IProgressMonitor monitor)
			throws ErrorStatusException {
		FailOnErrorStatus result = new FailOnErrorStatus(getPluginID(), "Created outlier comparison report");
		Collection<MetricProcessor> metricProcessors = MetricPlugin.getPlugin().getRegisteredMetricProcessors()
				.values();
		SubMonitor subMonitor = SubMonitor.convert(monitor, tmscIFiles.size() * metricProcessors.size() * 100);

		for (IFile tmscIfile : tmscIFiles) {
			FullScopeTMSC tmsc = null;
			try {
				Persistor<FullScopeTMSC> persistor = new PersistorFactory().getPersistor(FullScopeTMSC.class, true);
				subMonitor.setTaskName("Loading TMSC from " + tmscIfile.getName());
				Map<Object, Object> loadOptions = new HashMap<>();
				loadOptions.put(IProgressMonitor.class, subMonitor.split(25));
				tmsc = persistor.loadOne(URIHelper.asURI(tmscIfile), loadOptions);
			} catch (IOException e) {
				result.add(new Status(IStatus.ERROR, Activator.getPluginID(),
						String.format("Failed to load %s: %s", tmscIfile.getFullPath().toOSString(), e.getMessage()),
						e));
			}

			for (MetricProcessor metricProcessor : metricProcessors) {
				Metric metric = metricProcessor.analyse(tmsc);
				if (metric != null) {
					String reportFileName = tmscIfile.getProjectRelativePath().removeFileExtension().lastSegment()
							+ " - " + stage.getLabel() + " - " + metricProcessor.getName() + ".csv";
					IFile reportIFile = tmscIfile.getParent().getFile(new Path(reportFileName));
					String[][] report = createComparisonReport(metric.getInstances(), stage, tmsc, subMonitor.split(65));
					String reportTxt = from(report).collectOne(array -> from(array).joinfields(", ", "", ""))
							.joinfields("\n", "", "");
					try {
						byte[] reportContent = reportTxt.toString().getBytes(reportIFile.getCharset());
						if (reportIFile.exists()) {
							reportIFile.setContents(new ByteArrayInputStream(reportContent), true, true,
									subMonitor.split(10));
						} else {
							reportIFile.create(new ByteArrayInputStream(reportContent), true, subMonitor.split(10));
						}
					} catch (CoreException | UnsupportedEncodingException e) {
						result.add(new Status(ERROR, getPluginID(), e.getMessage(), e));
					}
				}
			}
			saveTMSC(tmsc, subMonitor, result);
		}
		return result;
	}

	public static String[][] createComparisonReport(Collection<MetricInstance> metricInstances,
			ArchitectureLifecycleStage stage, FullScopeTMSC tmsc, IProgressMonitor monitor) {
		Map<MetricInstance, ScopedTMSC> activityTmscs = from(metricInstances).toMap(o -> o, CreateIntervalActivityStrategy.ACTIVITY::createTMSC);
		Map<MetricInstance, ScopedTMSC> causalActivityTmscs = from(metricInstances).toMap(o -> o, CreateIntervalActivityStrategy.CAUSAL_ACTIVITY::createTMSC);
		List<List<ScopedTMSC>> activityTmscClasses =  TmscIsomorphismMatcher.findIsomorphismClasses(activityTmscs.values().iterator(), stage);

		String[][] report = new String[activityTmscClasses.size() + 1][ activityTmscClasses.size() + 2];
		int column = 0;
		int row = 0;
		report[row][column] = "Class id";
		
		report[row][++column] = "Size";
		for(int i=0; i<activityTmscClasses.size(); i++) {
			report[row][++column] = "vs. Class"+ String.valueOf(i+1);
		}
		
		List<ScopedTMSC> exploredClasses = new ArrayList<>();
		for(List<ScopedTMSC> leftTmscClass: activityTmscClasses) {
			ScopedTMSC leftTmsc = leftTmscClass.get(0);
			exploredClasses.add(leftTmsc);
			report[findGroupIndex(activityTmscClasses, leftTmsc)][0] = String.valueOf(findGroupIndex(activityTmscClasses, leftTmsc));
			report[findGroupIndex(activityTmscClasses, leftTmsc)][1] = String.valueOf(leftTmscClass.size());

			for(List<ScopedTMSC> rightTmscClass: activityTmscClasses) {
				if(!exploredClasses.contains(rightTmscClass.get(0))) {
					ScopedTMSC rightTmsc = rightTmscClass.get(0);
					if(!leftTmsc.equals(rightTmsc)) {
						System.out.println("KPI instance "+String.valueOf(findGroupIndex(activityTmscClasses, leftTmsc))+" vs. "+ String.valueOf(findGroupIndex(activityTmscClasses, rightTmsc)));
						ITmscMatchResult matchResult = TmscServiceMatcher.match(leftTmsc, rightTmsc, stage);
						ITmscMatchResult matchResultHybrid = TmscIsomorphismMatcher.match(leftTmsc, rightTmsc, matchResult.getEventMatches(), stage);
					
						BiMap<Event, Event> matchedEvents = TmscIsomorphismMatcher.discoverEventMatches(leftTmsc, rightTmsc, stage);
						ITmscMatchResult matchResultIsomorphism = TmscIsomorphismMatcher.match(leftTmsc, rightTmsc, matchedEvents, stage);
					
						List<Dependency> leftMatchedDependencies = causalActivityTmscs.get(getMetric(activityTmscs, leftTmsc)).getDependencies().stream().filter(e -> matchResult.getDependencyMatches().keySet().contains(e)).collect(Collectors.toList());
						List<Dependency> leftIsoMatchedDependencies = causalActivityTmscs.get(getMetric(activityTmscs, leftTmsc)).getDependencies().stream().filter(e -> matchResultIsomorphism.getDependencyMatches().keySet().contains(e)).collect(Collectors.toList());
						List<Dependency> leftHybMatchedDependencies = causalActivityTmscs.get(getMetric(activityTmscs, leftTmsc)).getDependencies().stream().filter(e -> matchResultHybrid.getDependencyMatches().keySet().contains(e)).collect(Collectors.toList());

						List<Dependency> rightMatchedDependencies = causalActivityTmscs.get(getMetric(activityTmscs, rightTmsc)).getDependencies().stream().filter(e -> matchResult.getDependencyMatches().values().contains(e)).collect(Collectors.toList());
						List<Dependency> rightIsoMatchedDependencies = causalActivityTmscs.get(getMetric(activityTmscs, rightTmsc)).getDependencies().stream().filter(e -> matchResultIsomorphism.getDependencyMatches().values().contains(e)).collect(Collectors.toList());
						List<Dependency> rightHybMatchedDependencies = causalActivityTmscs.get(getMetric(activityTmscs, rightTmsc)).getDependencies().stream().filter(e -> matchResultHybrid.getDependencyMatches().values().contains(e)).collect(Collectors.toList());

						Map<Event,Event> mismatched = matchResult.getEventMatches().entrySet().stream().filter(pair -> !matchResultIsomorphism.getEventMatches().get(pair.getKey()).equals(pair.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
						//comment += "("+String.valueOf(findGroupIndex(activityTmscClasses, tmscClass.get(0)))+","+matchResult.getDependencyMatches().size()+"/"+String.valueOf(outlierTmsc.getDependencies().size())+"),";
						//comment += "("+findGroupIndex(activityTmscClasses, tmscClass.get(0))+"|"+tmscClass.size()+"|"+matchedDependencies.size()+"|"+isoMatchedDependencies.size()+"|"+causalActivityTmscs.get(mi).getDependencies().size()+"),";
						report[findGroupIndex(activityTmscClasses, leftTmsc)][findGroupIndex(activityTmscClasses, rightTmsc)+1] = "("+ mismatched.size() + "|"+(float) leftMatchedDependencies.size()/causalActivityTmscs.get(getMetric(activityTmscs, leftTmsc)).getDependencies().size()+"|"+ (float) leftIsoMatchedDependencies.size()/causalActivityTmscs.get(getMetric(activityTmscs, leftTmsc)).getDependencies().size()+"|"+(float) leftHybMatchedDependencies.size()/causalActivityTmscs.get(getMetric(activityTmscs, leftTmsc)).getDependencies().size()+")";
						report[findGroupIndex(activityTmscClasses, rightTmsc)][findGroupIndex(activityTmscClasses, leftTmsc)+1] = "("+ mismatched.size() + "|"+(float) rightMatchedDependencies.size()/causalActivityTmscs.get(getMetric(activityTmscs, rightTmsc)).getDependencies().size()+"|"+ (float) rightIsoMatchedDependencies.size()/causalActivityTmscs.get(getMetric(activityTmscs, rightTmsc)).getDependencies().size()+"|"+(float) rightHybMatchedDependencies.size()/causalActivityTmscs.get(getMetric(activityTmscs, rightTmsc)).getDependencies().size()+")";
						for (Dependency dep : tmsc.getDependencies().stream().filter(d -> matchResultIsomorphism.getDependencyMatches().containsValue(d) && !matchResult.getDependencyMatches().containsValue(d)).collect(Collectors.toList())) {
							RenderingProperties.setPaint(dep, RenderingPaint.valueOf(0));
						}
					}
				}
			}
		}
		return report;
	}

	private static <T> int findGroupIndex(List<List<T>> groups, T element) {
		for (int i = 0; i < groups.size(); i++) {
			if (groups.get(i).contains(element)) {
				return i + 1;
			}
		}
		return -1;
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
	
	private static MetricInstance getMetric(Map<MetricInstance, ScopedTMSC> metric2tmsc, ScopedTMSC tmsc) { 
		for (Map.Entry<MetricInstance, ScopedTMSC> entry : metric2tmsc.entrySet()) {
			if(entry.getValue().equals(tmsc))
				return entry.getKey();
		}
		return null;
	}
		
	public static class StrageSelectionDialog extends TitleAreaDialog {
		private ArchitectureLifecycleStage stage = ArchitectureLifecycleStage.IMPLEMENTED;

		public StrageSelectionDialog(Shell parent) {
			super(parent);
			setBlockOnOpen(true);
			setHelpAvailable(false);
		}

		@Override
		public void create() {
			super.create();
			setTitle("Select architecture lifecycle stage");
			setMessage("Please select the architecture lifecycle stage to use for the analysis.");
		}

		@Override
		protected Control createDialogArea(Composite parent) {
			Composite dialogArea = (Composite) super.createDialogArea(parent);
			createInputArea(dialogArea);
			return dialogArea;
		}
		
		protected Control createInputArea(Composite parent) {
			Composite btnComposite = new Composite(parent, SWT.NONE);
			btnComposite.setFont(parent.getFont());
			btnComposite.setLayout(new GridLayout());
			btnComposite.setLayoutData(new GridData(GridData.FILL_BOTH));

			for (ArchitectureLifecycleStage stage : ArchitectureLifecycleStage.values()) {
				Button btn = new Button(btnComposite, SWT.RADIO);
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
							StrageSelectionDialog.this.stage = (ArchitectureLifecycleStage) btn.getData();
						}
					}
				});
			}
			return btnComposite;
		}

		public ArchitectureLifecycleStage getStage() {
			return stage;
		}
	}
}