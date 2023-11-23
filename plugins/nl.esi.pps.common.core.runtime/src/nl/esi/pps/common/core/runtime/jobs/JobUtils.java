/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.common.core.runtime.jobs;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Stream;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ISynchronizer;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.jobs.IJobFunction;
import org.eclipse.core.runtime.jobs.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Eclipse job utility methods. */
public class JobUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(JobUtils.class);
	
	/**
	 * Get a stream of files for the given resources, recursively.
	 *
	 * @param resources The resources.
	 * @return The stream of files.
	 */
	public static Stream<IFile> recursiveFilesStream(Collection<? extends IResource> resources) {
		return resources.stream().flatMap(JobUtils::recursiveFilesStream);
	}

	/**
	 * Get a stream of files for the given resource, recursively.
	 *
	 * @param resource The resource.
	 * @return The stream of files.
	 */
	public static Stream<IFile> recursiveFilesStream(IResource resource) {
		if (resource instanceof IFile) {
			return Stream.of((IFile) resource);
		} else if (resource instanceof IContainer) {
			try {
				return Arrays.stream(((IContainer)resource).members(true)).flatMap(JobUtils::recursiveFilesStream);
			} catch (CoreException e) {
				// Best effort stream. Ignore failures.
				return Stream.empty();
			}
		} else {
			LOGGER.error("Unexpected resource: " + resource.getFullPath());
			return Stream.empty();
		}
	}

	/**
	 * Get a stream of files, for the given resources and matching the given
	 * <a href=
	 * "https://docs.oracle.com/javase/tutorial/essential/io/fileOps.html#glob">glob</a>,
	 * for the given container, recursively.
	 *
	 * @param resource The resource.
	 * @param glob     A glob pattern to match
	 * @return The stream of files.
	 */
	public static Stream<IFile> recursiveFilesStream(Collection<? extends IResource> resources, String glob) {
		return resources.stream().flatMap(resource -> recursiveFilesStream(resource, glob));
	}

	/**
	 * Get a stream of files, matching the given <a href=
	 * "https://docs.oracle.com/javase/tutorial/essential/io/fileOps.html#glob">glob</a>,
	 * for the given container, recursively.
	 *
	 * @param resource The resource. If the resource is a file, the glob will be
	 *                 matched for this file only against its parent.
	 * @param glob     A glob pattern to match
	 * @return The stream of files.
	 */
	public static Stream<IFile> recursiveFilesStream(IResource resource, String glob) {
		final PathMatcher compiledGlob = FileSystems.getDefault().getPathMatcher("glob:" + glob);
		if (resource instanceof IFile) {
			final IFile file = (IFile) resource;
			return matchesGlob(file.getParent(), file, compiledGlob) ? Stream.of(file) : Stream.empty();
		} else if (resource instanceof IContainer) {
			final IContainer container = (IContainer) resource;
			return recursiveFilesStream(container).filter(file -> matchesGlob(container, file, compiledGlob));
		} else {
			LOGGER.error("Unexpected resource: " + resource.getFullPath());
			return Stream.empty();
		}
	}

	private static boolean matchesGlob(IContainer container, IFile file, PathMatcher compiledGlob) {
		final IPath relativeIPath = file.getFullPath().makeRelativeTo(container.getFullPath());
		final Path relativePath = Paths.get(relativeIPath.segment(0), relativeIPath.removeFirstSegments(1).segments());
		return compiledGlob.matches(relativePath);
	}
	
	/**
	 * Refresh the workspace. Refreshes the entire projects that contain the given files. Every project is only
	 * refreshed once, even if multiple files from that one project are provided.
	 *
	 * @param monitor The progress monitor to use to report progress.
	 * @param resources The resources for which to refresh.
	 */
	public static void refreshWorkspaceProjects(IProgressMonitor monitor, IResource... resources) {
		Set<IProject> projects = new LinkedHashSet<>();
		for (IResource resource: resources) {
			projects.add(resource.getProject());
		}

		refreshWorkspaceProjects(projects, monitor);
	}

	/**
	 * Refresh the workspace. Refreshes the entire projects that contain the given files. Every project is only
	 * refreshed once, even if multiple files from that one project are provided.
	 *
	 * @param resources The resources for which to refresh.
	 * @param monitor The progress monitor to use to report progress.
	 */
	public static void refreshWorkspaceProjects(Iterable<? extends IResource> resources, IProgressMonitor monitor) {
		Set<IProject> projects = new LinkedHashSet<>();
		for (IResource resource: resources) {
			projects.add(resource.getProject());
		}

		refreshWorkspaceProjects(projects, monitor);
	}

	/**
	 * Refresh the workspace.
	 *
	 * @param projects The projects to refresh.
	 * @param monitor The progress monitor to use to report progress.
	 */
	public static void refreshWorkspaceProjects(Collection<IProject> projects, IProgressMonitor monitor) {
		// Report what we are doing.
		monitor.setTaskName("Refreshing workspace");

		// Refresh projects.
		IProgressMonitor refreshMonitor = monitor.isCanceled() ? null : monitor;
		for (IProject project: projects) {
			try {
				project.refreshLocal(IResource.DEPTH_INFINITE, refreshMonitor);
			} catch (CoreException | OperationCanceledException ex) {
				// Best effort refresh. Ignore failures.
			}
		}
	}

	/**
	 * Creates a new {@link WorkspaceJob} that will execute the provided function
	 * when it runs.
	 *
	 * @param name The name of the job
	 * @param function The function to execute
	 * @return A job that encapsulates the provided function
	 * @see IJobFunction
	 * @see Job#create(String, IJobFunction)
	 */
	public static WorkspaceJob createWorkspaceJob(String name, IJobFunction function) {
		return new WorkspaceJob(name) {
			@Override
			public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
				try {
					return function.run(monitor);
				} finally {
					monitor.done();
				}
			}
		};
	}


	/**
	 * Returns the base name of {@code iFile}, i.e., the name of the file without
	 * its file extension.
	 * 
	 * @param iFile the file
	 * @return the base name of {@code iFile}
	 */
	public static String getBaseName(IFile iFile) {
		return iFile.getFullPath().removeFileExtension().lastSegment();
	}

	/**
	 * Returns the sibling file with the same name, but with the specified file
	 * extension.
	 *
	 * @param resource
	 *            anchor resource
	 * @param baseName
	 *            new base name (excl. extension), <tt>null</tt> leaves base name unchanged
	 * @param extension
	 *            new file extension, <tt>null</tt> leaves extension unchanged
	 * @return sibling file
	 */
	public static IFile getSibling(IResource resource, String baseName, String extension) {
		IPath filePath = resource.getFullPath();
		String newExtension = null == extension ? filePath.getFileExtension() : extension;
		filePath = filePath.removeFileExtension();
		String newBaseName = null == baseName ? filePath.lastSegment() : baseName;
		return resource.getWorkspace().getRoot().getFile(
				resource.getParent().getFullPath().append(newBaseName).addFileExtension(newExtension));
	}

	/**
	 * Ensures that when {@link IResource} is instance of:
	 * <ul><li><b>{@link IContainer}</b> - the container path itself exists including all parent paths</li>
	 * <li><b>{@link IFile}</b> - the parent container path exists including all parent paths</li></ul>
	 * @param resource the resource
	 * @throws CoreException when creating a (parent) resource fails
	 */
	public static void ensurePathExists(IResource resource) throws CoreException {
		if (!resource.getParent().exists()) {
			ensurePathExists(resource.getParent());
		}
		if (resource instanceof IFile) {
			// Nothing to do
			return;
		} else if (resource instanceof IFolder) {
			((IFolder) resource).create(true, true, null);
		} else if (resource instanceof IProject) {
			((IProject) resource).create(null);
		} else {
			throw new IllegalArgumentException(String.format(
					"Creating resource type '%s' not supported for resource: %s", resource.getClass(), resource));
		}
	}

	private static final QualifiedName PHANTOM_NAME = new QualifiedName(JobUtils.class.getName(), "phantom");

	/**
	 * Ensures that a resource appears to be part of the workspace although it
	 * doesn't actually exist. A phantom resource can be found by i.e.
	 * {@link JobUtils#recursiveFilesStream(IContainer, String)}, but the end user will
	 * not see it and it will not exist on disk.<br>
	 * Phantom resources represent incoming additions or outgoing deletions which have yet to be reconciled with a synchronization partner.
	 *
	 * @param resource the resource
	 * @throws CoreException if creation fails
	 * @see JobUtils#recursiveFilesStream(IContainer, String)
	 * @see IResource
	 */
	public static void createAsPhantom(IResource resource) throws CoreException {
		if (!resource.getParent().exists()) createAsPhantom(resource.getParent());
		final ISynchronizer synchronizer = resource.getWorkspace().getSynchronizer();
		synchronizer.add(PHANTOM_NAME);
		synchronizer.setSyncInfo(PHANTOM_NAME, resource, new byte[] {1});
	}

	/**
	 * Removes all descendant phantom resources of the specified resource
	 * including the resource itself if it is a phantom resource.
	 *
	 * @param resource the resource
	 * @throws CoreException if deletion fails
	 */
	public static void removePhantomResources(IResource resource) throws CoreException {
		final ISynchronizer synchronizer = resource.getWorkspace().getSynchronizer();
		if (Arrays.asList(synchronizer.getPartners()).contains(PHANTOM_NAME)) {
			synchronizer.flushSyncInfo(PHANTOM_NAME, resource, IResource.DEPTH_INFINITE);
		}
	}
}
