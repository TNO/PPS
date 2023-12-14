package nl.esi.pps.common.emf.synchronizedtiming.jfree;


import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.trace4cps.common.jfreechart.ui.widgets.ChartPanelComposite;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.Title;

import nl.esi.pps.common.emf.synchronizedtiming.ui.Activator;

public class ShowLegendAction extends Action {
	private @Nullable ChartPanelComposite chartPanelComposite;

	public ShowLegendAction() {
		this(null, Activator.getDescriptor(Activator.IMAGE_LEGEND_ONOFF));
	}

	public ShowLegendAction(@Nullable ChartPanelComposite plotComposite) {
		this(plotComposite, Activator.getDescriptor(Activator.IMAGE_LEGEND_ONOFF));
	}

	public ShowLegendAction(@Nullable ChartPanelComposite chartPanelComposite, @Nullable ImageDescriptor imageDescriptor) {
		super("Show Legend", IAction.AS_CHECK_BOX);
		setImageDescriptor(imageDescriptor);
		setToolTipText("If checked, this chart will show a legend.");
		setChartPanelComposite(chartPanelComposite);
	}

	public void setChartPanelComposite(@Nullable ChartPanelComposite plotComposite) {
		this.chartPanelComposite = plotComposite;
		update();
	}
	
	protected @Nullable ChartPanelComposite getChartPanelComposite() {
		return chartPanelComposite;
	}

	public void update() {
		if (chartPanelComposite != null) {
			JFreeChart chart = chartPanelComposite.getChart();
			LegendTitle legend = chart == null ? null : chart.getLegend();
			if (legend != null) {
				setEnabled(true);
				setChecked(legend.isVisible());
				return;
			}
		}
		setEnabled(false);
		setChecked(false);
	}
	
	@Override
	public void run() {
		if (chartPanelComposite != null) {
			JFreeChart chart = chartPanelComposite.getChart();
			if (chart == null) {
				return;
			}

			for (int i = 0; i < chart.getSubtitleCount(); i++) {
				Title subtitle = chart.getSubtitle(i);
				if (subtitle instanceof LegendTitle) {
					subtitle.setVisible(isChecked());
				}
			}
		}
	}
}