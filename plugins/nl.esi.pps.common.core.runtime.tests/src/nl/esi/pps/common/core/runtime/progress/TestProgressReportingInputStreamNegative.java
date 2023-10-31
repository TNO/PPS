/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.common.core.runtime.progress;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.Test;

public class TestProgressReportingInputStreamNegative {
	@Test(expected = NullPointerException.class)
	public void nullStream() throws Exception {
		try (final ProgressReportingInputStream in = new ProgressReportingInputStream(
				null, 100000, new NullProgressMonitor())) {
			in.available();
		}
	}

	@Test(expected = RuntimeException.class)
	public void nullMonitor() throws Exception {
		try (final ProgressReportingInputStream in = new ProgressReportingInputStream(
				new LinesInputStream(10000, "123456789"), 100000, null)) {

		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void zeroInterval() throws Exception {
		try (final ProgressReportingInputStream in = new ProgressReportingInputStream(
				new LinesInputStream(10000, "123456789"), 100000,
				new NullProgressMonitor())) {
			in.setUpdateInterval(0);
		}
	}
}
