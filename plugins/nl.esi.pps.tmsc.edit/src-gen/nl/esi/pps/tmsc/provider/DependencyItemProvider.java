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
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.TmscPackage;

/**
 * This is the item provider adapter for a {@link nl.esi.pps.tmsc.Dependency} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DependencyItemProvider extends PropertiesContainerItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependencyItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Object getParent(Object object) {
		if (object instanceof Dependency) {
			return ((Dependency) object).getSource();
		}
		return super.getParent(object);
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

		addSourcePropertyDescriptor(object);
		addTargetPropertyDescriptor(object);
		addScopesPropertyDescriptor(object);
		addStartTimePropertyDescriptor(object);
		addEndTimePropertyDescriptor(object);
		addDurationPropertyDescriptor(object);
		addTimeBoundPropertyDescriptor(object);
		addScheduledPropertyDescriptor(object);
		addProjectionPropertyDescriptor(object);
	}

	/**
	 * This adds a property descriptor for the Source feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSourcePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Dependency_source_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Dependency_source_feature",
								"_UI_Dependency_type"),
						TmscPackage.Literals.DEPENDENCY__SOURCE, false, false, false, null,
						getDefaultDescriptorCategory(object),
						new String[] { "org.eclipse.ui.views.properties.expert" }));
	}

	/**
	 * This adds a property descriptor for the Target feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Dependency_target_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Dependency_target_feature",
								"_UI_Dependency_type"),
						TmscPackage.Literals.DEPENDENCY__TARGET, false, false, false, null,
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
						getResourceLocator(), getString("_UI_Dependency_startTime_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Dependency_startTime_feature",
								"_UI_Dependency_type"),
						TmscPackage.Literals.DEPENDENCY__START_TIME, false, false, false,
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
						getResourceLocator(), getString("_UI_Dependency_endTime_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Dependency_endTime_feature",
								"_UI_Dependency_type"),
						TmscPackage.Literals.DEPENDENCY__END_TIME, false, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getDefaultDescriptorCategory(object), null,
						URI.createURI("editor://nl.esi.pps.tmsc.text.ETimestampFormat/")));
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
						getResourceLocator(), getString("_UI_Dependency_duration_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Dependency_duration_feature",
								"_UI_Dependency_type"),
						TmscPackage.Literals.DEPENDENCY__DURATION, false, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getDefaultDescriptorCategory(object), null,
						URI.createURI("editor://nl.esi.pps.tmsc.text.EDurationFormat/")));
	}

	/**
	 * This adds a property descriptor for the Time Bound feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTimeBoundPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Dependency_timeBound_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Dependency_timeBound_feature",
								"_UI_Dependency_type"),
						TmscPackage.Literals.DEPENDENCY__TIME_BOUND, false, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getDefaultDescriptorCategory(object),
						new String[] { "org.eclipse.ui.views.properties.expert" },
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
						getResourceLocator(), getString("_UI_Dependency_scopes_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Dependency_scopes_feature",
								"_UI_Dependency_type"),
						TmscPackage.Literals.DEPENDENCY__SCOPES, false, false, false, null,
						getDefaultDescriptorCategory(object),
						new String[] { "org.eclipse.ui.views.properties.expert" }));
	}

	/**
	 * This adds a property descriptor for the Scheduled feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addScheduledPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Dependency_scheduled_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Dependency_scheduled_feature",
								"_UI_Dependency_type"),
						TmscPackage.Literals.DEPENDENCY__SCHEDULED, false, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getDefaultDescriptorCategory(object),
						new String[] { "org.eclipse.ui.views.properties.expert" }));
	}

	/**
	 * This adds a property descriptor for the Projection feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProjectionPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Dependency_projection_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Dependency_projection_feature",
								"_UI_Dependency_type"),
						TmscPackage.Literals.DEPENDENCY__PROJECTION, false, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, getDefaultDescriptorCategory(object),
						new String[] { "org.eclipse.ui.views.properties.expert" }));
	}

	/**
	 * This returns Dependency.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Dependency"));
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

		switch (notification.getFeatureID(Dependency.class)) {
		case TmscPackage.DEPENDENCY__TMSC:
		case TmscPackage.DEPENDENCY__SOURCE:
		case TmscPackage.DEPENDENCY__TARGET:
		case TmscPackage.DEPENDENCY__SCOPES:
		case TmscPackage.DEPENDENCY__DURATION:
		case TmscPackage.DEPENDENCY__TIME_BOUND:
		case TmscPackage.DEPENDENCY__SCHEDULED:
		case TmscPackage.DEPENDENCY__PROJECTION:
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
