package nl.esi.pps.tmsc.analysis.ui.commands;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.command.AbstractCommand;

import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.analysis.DefaultTimeBoundAnalysis;

public class DefaultTimeBoundAnalysisCommand extends AbstractCommand {
	private final FullScopeTMSC tmsc;
	private final long defaultTimeBound;

	public DefaultTimeBoundAnalysisCommand(FullScopeTMSC tmsc, long defaultTimeBound) {
		super("time-bound analysis");
		this.tmsc = tmsc;
		this.defaultTimeBound = defaultTimeBound;
	}

	@Override
	protected boolean prepare() {
		return true;
	}

	@Override
	public void execute() {
		new DefaultTimeBoundAnalysis(defaultTimeBound).analyzeTimeBounds(tmsc);
	}

	@Override
	public Collection<?> getAffectedObjects() {
		return Collections.singleton(tmsc);
	}

	@Override
	public boolean canUndo() {
		return false;
	}
	
	@Override
	public void redo() {
		execute();
	}
}
