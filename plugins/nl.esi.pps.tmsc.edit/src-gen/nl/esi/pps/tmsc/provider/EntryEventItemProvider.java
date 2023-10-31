/**
 */
package nl.esi.pps.tmsc.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ViewerNotification;

import nl.esi.pps.tmsc.EntryEvent;
import nl.esi.pps.tmsc.TmscPackage;

/**
 * This is the item provider adapter for a {@link nl.esi.pps.tmsc.EntryEvent} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EntryEventItemProvider extends EventItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntryEventItemProvider(AdapterFactory adapterFactory) {
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

		addExecutionPropertyDescriptor(object);
	}

	/**
	 * This adds a property descriptor for the Execution feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExecutionPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_EntryEvent_execution_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_EntryEvent_execution_feature",
								"_UI_EntryEvent_type"),
						TmscPackage.Literals.ENTRY_EVENT__EXECUTION, false, false, true, null,
						getDefaultDescriptorCategory(object), null));
	}

	/**
	 * This returns EntryEvent.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		final EntryEvent event = (EntryEvent) object;
		final String traced = event.isTraced() ? "Traced" : "Untraced";
		return overlayImage(object, getResourceLocator().getImage("full/obj16/EntryEvent" + traced));
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
		return TmscItemLabelSwitch.eINSTANCE.getText(object);
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

		switch (notification.getFeatureID(EntryEvent.class)) {
		case TmscPackage.ENTRY_EVENT__EXECUTION:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		}
		super.notifyChanged(notification);
	}

}
