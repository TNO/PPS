/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.emf.ecore.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.nio.charset.Charset;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.lsat.common.emf.common.util.URIHelper;
import org.eclipse.lsat.common.emf.common.util.UnsupportedURIException;
import org.eclipse.lsat.common.emf.ecore.resource.ResourceDiagnosticException;
import org.eclipse.lsat.common.emf.ecore.resource.ResourceDiagnosticReporter;

import nl.esi.pps.common.core.runtime.progress.ProgressReportingInputStream;
import nl.esi.pps.common.core.runtime.progress.ProgressReportingInputStreamFactory;
import nl.esi.pps.common.core.runtime.progress.ProgressReportingReader;

public abstract class LineNumberResource<State> extends ResourceImpl implements ResourceDiagnosticReporter {
	protected static final long DEFAULT_PROGRESS_BYTE_COUNT = 80_000L;

	private long progressByteCount = DEFAULT_PROGRESS_BYTE_COUNT;

	public LineNumberResource() {
		super();
	}

	public LineNumberResource(final URI uri) {
		super(uri);
	}

	/**
	 * Returns the {@link Charset} of the resource
	 *
	 * @return The Charset of resource, if available. If no URI or
	 *         unsupported URI or Charset is not available, returns
	 *         {@link Charset#defaultCharset()}.
	 */
	protected @NonNull Charset getCharset() {
		IResource fileResource = null;

		try {
			fileResource = URIHelper.asIResource(getURI());
		} catch (UnsupportedURIException e) {
			return Charset.defaultCharset();
		}

		if (fileResource == null) {
			return Charset.defaultCharset();
		}

		if (!(fileResource instanceof IFile)) {
			throw new IllegalStateException(fileResource.toString() + ": is not a file resource.");
		}

		IFile file = (IFile) fileResource;

		try {
			return Charset.forName(file.getCharset());
		} catch (final CoreException e) {
			return Charset.defaultCharset();
		}
	}

	public long getProgressByteCount() {
		return this.progressByteCount;
	}

	public void setProgressByteCount(final long progressByteCount) {
		this.progressByteCount = progressByteCount;
	}

	@Override
	protected void doLoad(final InputStream inputStream, final Map<?, ?> options) throws IOException {
		final IProgressMonitor monitor = null != options && options.containsKey(IProgressMonitor.class)
				? (IProgressMonitor) options.get(IProgressMonitor.class)
				: new NullProgressMonitor();

		final State state = createLoadState(options);
		try {
			final LineNumberReader reader = createReader(inputStream, monitor);
			doLoad(reader, state);
		} finally {
			disposeLoadState(state);
		}
	}

	protected LineNumberReader createReader(final InputStream inputStream, final IProgressMonitor monitor) throws IOException {
		final ProgressReportingInputStream reportingInputStream = ProgressReportingInputStreamFactory.getInstance()
				.create(inputStream, URIHelper.determineContentLength(getURI()), monitor);
		reportingInputStream.setUpdateInterval(getProgressByteCount());

		return new ProgressReportingReader(reportingInputStream, getCharset());
	}

	protected void doLoad(final LineNumberReader reader, final State state) throws IOException {
		String line;
		while ((line = reader.readLine()) != null) {
			try {
				doLoadLine(line, reader.getLineNumber(), state);
			} catch (final ResourceDiagnosticException ex) {
				if (ex.getLine() == ResourceDiagnosticException.UNKNOWN_LINE) {
					ex.setLine(reader.getLineNumber());
				}
				reportProblem(ex);
			}
		}
	}

	protected abstract State createLoadState(Map<?, ?> options) throws IOException;

	protected abstract void doLoadLine(String line, int lineNr, State state)
			throws IOException, ResourceDiagnosticException;

	/**
	 * May be overridden when state needs to be cleaned up after loading. This
	 * method is always called, regardless of exceptions during
	 * {@link #doLoad(InputStream, Map)}
	 *
	 * @param state
	 *            state to dispose
	 */
	protected void disposeLoadState(final State state) {
		// Empty
	}

	@Override
	public void reportProblem(final ResourceDiagnosticException ex) {
		if (null == ex.getLocation()) {
			ex.setLocation(getURI());
		}
		switch (ex.getSeverity()) {
		case ERROR:
			getErrors().add(ex);
			return;
		case WARNING:
			getWarnings().add(ex);
			return;
		default:
			throw new IllegalArgumentException("Unknown problem severity: " + ex.getSeverity());
		}
	}
}
