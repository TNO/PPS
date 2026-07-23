package nl.esi.pps.common.emf.ui.jobs;

import static nl.esi.pps.common.emf.ui.Activator.getPluginID;
import static org.eclipse.core.runtime.IStatus.ERROR;
import static org.eclipse.core.runtime.IStatus.OK;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.lsat.common.emf.common.util.DiagnosticUtil;
import org.eclipse.lsat.common.emf.common.util.URIHelper;
import org.eclipse.lsat.common.emf.common.util.UnsupportedURIException;
import org.eclipse.lsat.common.emf.ui.AdapterFactoryDiagnostician;

import nl.esi.pps.common.core.runtime.ErrorStatusException;
import nl.esi.pps.common.core.runtime.FailOnErrorStatus;

public class ValidateModelJob {
	/**
	 * Validates the complete resource that contains the {@code eObject} and marks
	 * the resource as validated.
	 */
	public static IStatus validateModel(EObject eObject, Supplier<AdapterFactory> adapterFactorySupplier,
			IProgressMonitor monitor) {
		Resource modelResource = eObject.eResource();
		if (modelResource == null) {
			IItemLabelProvider labelProvider = (IItemLabelProvider) adapterFactorySupplier.get().adapt(eObject,
					IItemLabelProvider.class);
			String eObjectLabel = labelProvider != null ? labelProvider.getText(eObject) : String.valueOf(eObject);
			return new Status(ERROR, getPluginID(),
					"Failed to validate model, " + eObjectLabel + " is not contained by a resource.");
		}
		try {
			IFile modelIFile = (IFile) URIHelper.asIResource(modelResource.getURI());
			return validateModel(modelIFile, modelResource, adapterFactorySupplier, monitor);
		} catch (UnsupportedURIException | ClassCastException | NullPointerException e) {
			IItemLabelProvider labelProvider = (IItemLabelProvider) adapterFactorySupplier.get().adapt(eObject,
					IItemLabelProvider.class);
			String eObjectLabel = labelProvider != null ? labelProvider.getText(eObject) : String.valueOf(eObject);
			return new Status(ERROR, getPluginID(), "Failed to validate model, " + eObjectLabel + " is not saved.");
		}
	}

	public static IStatus validateModel(IFile modelIFile, Supplier<AdapterFactory> adapterFactorySupplier,
			IProgressMonitor monitor) {
		SubMonitor subMonitor = SubMonitor.convert(monitor, 100);
		String modelName = modelIFile.getProjectRelativePath().toPortableString();
		FailOnErrorStatus result = new FailOnErrorStatus(OK, getPluginID(), "Validated model: " + modelName);

		try {
			subMonitor.setTaskName("Loading model: " + modelName);
			URI modelURI = URIHelper.asURI(modelIFile);
			ResourceSet resourceSet = new ResourceSetImpl();
			Resource modelResource = resourceSet.getResource(modelURI, false);
			if (null == modelResource) {
				modelResource = resourceSet.createResource(modelURI, ContentHandler.UNSPECIFIED_CONTENT_TYPE);
			}

			try {
				Map<Object, Object> loadOptions = new HashMap<>();
				loadOptions.put(IProgressMonitor.class, subMonitor.split(25));
				modelResource.load(loadOptions);
			} catch (IOException e) {
				result.add(new Status(ERROR, getPluginID(), "Failed to load model: " + e.getMessage(), e));
			}

			result.addAll(validateModel(modelIFile, modelResource, adapterFactorySupplier, subMonitor.split(75)));

		} catch (ErrorStatusException e) {
			// The status is already added to our result
		}
		return result;
	}

	public static IStatus validateModel(IFile modelIFile, Resource modelResource,
			Supplier<AdapterFactory> adapterFactorySupplier, IProgressMonitor monitor) {
		SubMonitor subMonitor = SubMonitor.convert(monitor, 75);
		String modelName = modelIFile.getName();
		FailOnErrorStatus result = new FailOnErrorStatus(OK, getPluginID(), "Validated model: " + modelName);

		try {
			subMonitor.setTaskName("Validating model: " + modelName);
			subMonitor.split(75);
			Diagnostic diagnostic = new AdapterFactoryDiagnostician(adapterFactorySupplier.get())
					.validate(modelResource, true);
			result.addAll(DiagnosticUtil.toIStatus(diagnostic));
		} catch (ErrorStatusException e) {
			// The status is already added to our result
		}
		return result;
	}
}
