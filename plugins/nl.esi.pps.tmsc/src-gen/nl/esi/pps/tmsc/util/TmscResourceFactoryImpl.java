/**
 */
package nl.esi.pps.tmsc.util;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl.BinaryIO.Version;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import nl.esi.pps.tmsc.TmscPlugin;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource Factory</b> associated with the package.
 * <!-- end-user-doc -->
 * @see nl.esi.pps.tmsc.util.TmscResourceImpl
 * @generated
 */
public class TmscResourceFactoryImpl extends ResourceFactoryImpl {
	/**
	 * Creates an instance of the resource factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmscResourceFactoryImpl() {
		super();
	}

	/**
	 * Creates an instance of the resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource createResourceGen(URI uri) {
		Resource result = new TmscResourceImpl(uri);
		return result;
	}

	private static final int MEGABYTE = 1_000_000;

	@Override
	public Resource createResource(URI uri) {
		XMIResourceImpl result = (XMIResourceImpl) createResourceGen(uri);

		Map<Object, Object> loadOptions = result.getDefaultLoadOptions();
		Map<Object, Object> saveOptions = result.getDefaultSaveOptions();

		if (TmscPlugin.isTmscBinaryCompressedFileExtension(uri.fileExtension())) {
			loadOptions.put(Resource.OPTION_ZIP, Boolean.TRUE);
			loadOptions.put(XMLResource.OPTION_BINARY, Boolean.TRUE);
			loadOptions.put(BinaryResourceImpl.OPTION_VERSION, Version.VERSION_1_1);
			loadOptions.put(BinaryResourceImpl.OPTION_STYLE_BINARY_ENUMERATOR, true);
			loadOptions.put(BinaryResourceImpl.OPTION_BUFFER_CAPACITY, MEGABYTE);

			saveOptions.put(Resource.OPTION_ZIP, Boolean.TRUE);
			saveOptions.put(XMLResource.OPTION_BINARY, Boolean.TRUE);
			saveOptions.put(BinaryResourceImpl.OPTION_VERSION, Version.VERSION_1_1);
			saveOptions.put(BinaryResourceImpl.OPTION_STYLE_BINARY_ENUMERATOR, true);
			saveOptions.put(BinaryResourceImpl.OPTION_BUFFER_CAPACITY, MEGABYTE);
		}

		// Robustness: keep default content
		saveOptions.put(XMIResource.OPTION_KEEP_DEFAULT_CONTENT, true);
		// Robustness: keep type information
		saveOptions.put(XMIResource.OPTION_SAVE_TYPE_INFORMATION, true);

		return result;
	}
} //TmscResourceFactoryImpl
