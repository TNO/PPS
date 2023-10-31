/**
 */
package nl.esi.emf.properties.provider;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import nl.esi.emf.properties.PropertiesContainer;
import nl.esi.emf.properties.PropertiesPackage;
import nl.esi.emf.properties.edit.PropertyItemPropertyDescriptor;

/**
 * This is the item provider adapter for a {@link nl.esi.emf.properties.PropertiesContainer} object.
 * <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 * @generated
 */
public class PropertiesContainerItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PropertiesContainerItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);
			addPropertyDescriptors(object);
		}
		reloadPropertiesPropertyDescriptors(object);
		return itemPropertyDescriptors;
	}

	/**
	 * This adds the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPropertyDescriptors(Object object) {
	}

	/**
	 * Adds all {@link PropertiesContainer#getProperties()} map entries as
	 * {@link ItemPropertyDescriptor}s in a
	 * {@link #getPropertiesPropertyDescriptorsCategory()} category.
	 */
	@SuppressWarnings("deprecation")
	protected void reloadPropertiesPropertyDescriptors(Object object) {
		// Remove existing properties descriptors (if any)
		itemPropertyDescriptors.removeIf(d -> d instanceof PropertyItemPropertyDescriptor);

		final String propertyDefaultCategory = getPropertiesPropertyDescriptorsDefaultCategory();
		final String[] propertyFilterFlags = getPropertiesPropertyDescriptorsFilterFlags(object);
		EMap<String, Serializable> properties = ((PropertiesContainer) object).getProperties();
		for (int propertyIndex = 0; propertyIndex < properties.size(); propertyIndex++) {
			final String propertyName = properties.get(propertyIndex).getKey();
			// Add a descriptor for each property
			itemPropertyDescriptors.add(new PropertyItemPropertyDescriptor(
					((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
					propertyName, propertyIndex, propertyDefaultCategory, propertyFilterFlags));
		}
	}

	/**
	 * <b>NOTE:</b> Properties should be added to their own unique category!
	 * 
	 * @return the category to use for the descriptors of the properties
	 * @see #reloadPropertiesCategoryDescriptors(Object)
	 */
	protected String getPropertiesPropertyDescriptorsDefaultCategory() {
		return getString("_UI_PropertiesContainer_properties_feature");
	}

	/**
	 * Returns the filter flags to use for the descriptors of the properties
	 * 
	 * @return the filter flags to use for the descriptors of the properties
	 * @see #reloadPropertiesCategoryDescriptors(Object)
	 */
	protected String[] getPropertiesPropertyDescriptorsFilterFlags(Object object) {
		return new String[] { "org.eclipse.ui.views.properties.expert" };
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean shouldComposeCreationImage() {
		return true;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_PropertiesContainer_type");
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(PropertiesContainer.class)) {
		case PropertiesPackage.PROPERTIES_CONTAINER__PROPERTIES:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * Return the resource locator for this item provider's resources. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return PropertiesEditPlugin.INSTANCE;
	}

	/**
	 * Returns the group name of properties to use when the property category is not
	 * set in the generator model. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected String getDefaultDescriptorCategory(final Object object) {
		if (object instanceof EObject) {
			final EObject eObject = (EObject) object;
			final EClass eClass = eObject.eClass();
			final ItemProviderAdapter itemProviderAdapter = (ItemProviderAdapter) adapterFactory.adapt(eObject,
					ItemProviderAdapter.class);
			if (itemProviderAdapter != null) {
				final String eClassPrettyName = itemProviderAdapter.getString("_UI_" + eClass.getName() + "_type");
				if (eClassPrettyName != null) {
					return eClassPrettyName;
				}
			}
			return eClass.getName();
		}
		return null;
	}
}
