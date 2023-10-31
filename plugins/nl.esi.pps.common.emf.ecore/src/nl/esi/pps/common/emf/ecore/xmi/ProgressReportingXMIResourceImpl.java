/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.common.emf.ecore.xmi;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.lsat.common.emf.common.util.URIHelper;

import nl.esi.pps.common.core.runtime.progress.ProgressReportingInputStream;
import nl.esi.pps.common.core.runtime.progress.ProgressReportingInputStreamFactory;

public class ProgressReportingXMIResourceImpl extends XMIResourceImpl {
	protected static final int UPDATE_INTERVAL_DEFAULT = 42 * 1337;

	private long updateInterval;

	public ProgressReportingXMIResourceImpl(URI uri) {
		this(uri, UPDATE_INTERVAL_DEFAULT);
	}

	public ProgressReportingXMIResourceImpl(URI uri, long updateInterval) {
		super(uri);
		this.updateInterval = updateInterval;
	}

	public void setUpdateInterval(final long updateInterval) throws IllegalArgumentException {
		Assert.isLegal(updateInterval > 0, "updateInterval must be > 0");
		this.updateInterval = updateInterval;
	}
	
	@Override
	public void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		final IProgressMonitor monitor = (IProgressMonitor) options.get(IProgressMonitor.class);
		if (null == monitor) {
			super.doLoad(inputStream, options);
		} else {
			final ProgressReportingInputStream reportingInputStream = ProgressReportingInputStreamFactory
					.getInstance().create(inputStream, URIHelper.determineContentLength(getURI()), monitor);
			reportingInputStream.setUpdateInterval(updateInterval);
			monitor.subTask(String.format("Loading %s...", getURI().lastSegment()));

			super.doLoad(reportingInputStream, options);
		}
	}
}