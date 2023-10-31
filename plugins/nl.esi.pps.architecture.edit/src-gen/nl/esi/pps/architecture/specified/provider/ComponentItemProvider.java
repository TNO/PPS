/**
 */
package nl.esi.pps.architecture.specified.provider;

import java.util.Collection;
import nl.esi.pps.architecture.provider.ArchitectureEditPlugin;
import nl.esi.pps.architecture.provider.NamedArchitectureElementItemProvider;
import nl.esi.pps.architecture.specified.SpecifiedPackage;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;

/**
 * This is the item provider adapter for a {@link nl.esi.pps.architecture.specified.Component} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ComponentItemProvider extends NamedArchitectureElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This adds the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void addPropertyDescriptors(Object object) {
		super.addPropertyDescriptors(object);

		addRequiredInterfacesPropertyDescriptor(object);
		addProvidedInterfacesPropertyDescriptor(object);
	}

	/**
	 * This adds a property descriptor for the Required Interfaces feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRequiredInterfacesPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Component_requiredInterfaces_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Component_requiredInterfaces_feature",
								"_UI_Component_type"),
						SpecifiedPackage.Literals.COMPONENT__REQUIRED_INTERFACES, false, false, true, null,
						getDefaultDescriptorCategory(object), null));
	}

	/**
	 * This adds a property descriptor for the Provided Interfaces feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProvidedInterfacesPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Component_providedInterfaces_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Component_providedInterfaces_feature",
								"_UI_Component_type"),
						SpecifiedPackage.Literals.COMPONENT__PROVIDED_INTERFACES, false, false, true, null,
						getDefaultDescriptorCategory(object), null));
	}

	/**
	 * This returns Component.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Component"));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		return super.getText(object);
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);
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
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ArchitectureEditPlugin.INSTANCE;
	}

}
