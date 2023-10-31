/**
 */
package nl.esi.pps.tmsc.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import nl.esi.emf.properties.provider.PropertiesContainerItemProvider;
import nl.esi.pps.tmsc.Interval;
import nl.esi.pps.tmsc.TmscPackage;

/**
 * This is the item provider adapter for a {@link nl.esi.pps.tmsc.Interval} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class IntervalItemProvider extends PropertiesContainerItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntervalItemProvider(AdapterFactory adapterFactory) {
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

		addFromPropertyDescriptor(object);
		addToPropertyDescriptor(object);
		addScopesPropertyDescriptor(object);
		addStartTimePropertyDescriptor(object);
		addEndTimePropertyDescriptor(object);
		addDurationPropertyDescriptor(object);
	}

	/**
	 * This adds a property descriptor for the To feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addToPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_Interval_to_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_Interval_to_feature", "_UI_Interval_type"),
				TmscPackage.Literals.INTERVAL__TO, false, false, true, null, getDefaultDescriptorCategory(object),
				new String[] { "org.eclipse.ui.views.properties.expert" }));
	}

	/**
	 * This adds a property descriptor for the From feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFromPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Interval_from_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Interval_from_feature",
								"_UI_Interval_type"),
						TmscPackage.Literals.INTERVAL__FROM, false, false, true, null,
						getDefaultDescriptorCategory(object),
						new String[] { "org.eclipse.ui.views.properties.expert" }));
	}

	/**
	 * This adds a property descriptor for the Duration feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDurationPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Interval_duration_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Interval_duration_feature",
								"_UI_Interval_type"),
						TmscPackage.Literals.INTERVAL__DURATION, false, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getDefaultDescriptorCategory(object), null,
						URI.createURI("editor://nl.esi.pps.tmsc.text.EDurationFormat/")));
	}

	/**
	 * This adds a property descriptor for the Scopes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addScopesPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Interval_scopes_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Interval_scopes_feature",
								"_UI_Interval_type"),
						TmscPackage.Literals.INTERVAL__SCOPES, false, false, true, null,
						getDefaultDescriptorCategory(object),
						new String[] { "org.eclipse.ui.views.properties.expert" }));
	}

	/**
	 * This adds a property descriptor for the Start Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStartTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Interval_startTime_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Interval_startTime_feature",
								"_UI_Interval_type"),
						TmscPackage.Literals.INTERVAL__START_TIME, false, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getDefaultDescriptorCategory(object), null,
						URI.createURI("editor://nl.esi.pps.tmsc.text.ETimestampFormat/")));
	}

	/**
	 * This adds a property descriptor for the End Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEndTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Interval_endTime_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Interval_endTime_feature",
								"_UI_Interval_type"),
						TmscPackage.Literals.INTERVAL__END_TIME, false, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getDefaultDescriptorCategory(object), null,
						URI.createURI("editor://nl.esi.pps.tmsc.text.ETimestampFormat/")));
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

		switch (notification.getFeatureID(Interval.class)) {
		case TmscPackage.INTERVAL__FROM:
		case TmscPackage.INTERVAL__TO:
		case TmscPackage.INTERVAL__SCOPES:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return TmscEditPlugin.INSTANCE;
	}

}
