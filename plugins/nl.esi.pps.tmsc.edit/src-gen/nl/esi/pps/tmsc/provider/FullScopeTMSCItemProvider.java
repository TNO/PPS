/**
 */
package nl.esi.pps.tmsc.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import java.util.Collection;
import nl.esi.pps.tmsc.FullScopeTMSC;
import nl.esi.pps.tmsc.TmscPackage;

/**
 * This is the item provider adapter for a {@link nl.esi.pps.tmsc.FullScopeTMSC} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FullScopeTMSCItemProvider extends TMSCItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FullScopeTMSCItemProvider(AdapterFactory adapterFactory) {
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

		addArchitecturesPropertyDescriptor(object);
		addEpochTimePropertyDescriptor(object);
		addStartTimePropertyDescriptor(object);
		addEndTimePropertyDescriptor(object);
	}

	/**
	 * This adds a property descriptor for the Epoch Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEpochTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_FullScopeTMSC_epochTime_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_FullScopeTMSC_epochTime_feature",
								"_UI_FullScopeTMSC_type"),
						TmscPackage.Literals.FULL_SCOPE_TMSC__EPOCH_TIME, false, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, getDefaultDescriptorCategory(object),
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
						getResourceLocator(), getString("_UI_FullScopeTMSC_startTime_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_FullScopeTMSC_startTime_feature",
								"_UI_FullScopeTMSC_type"),
						TmscPackage.Literals.FULL_SCOPE_TMSC__START_TIME, false, false, false,
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
						getResourceLocator(), getString("_UI_FullScopeTMSC_endTime_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_FullScopeTMSC_endTime_feature",
								"_UI_FullScopeTMSC_type"),
						TmscPackage.Literals.FULL_SCOPE_TMSC__END_TIME, false, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getDefaultDescriptorCategory(object), null,
						URI.createURI("editor://nl.esi.pps.tmsc.text.ETimestampFormat/")));
	}

	/**
	 * This adds a property descriptor for the Architectures feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addArchitecturesPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_FullScopeTMSC_architectures_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_FullScopeTMSC_architectures_feature",
								"_UI_FullScopeTMSC_type"),
						TmscPackage.Literals.FULL_SCOPE_TMSC__ARCHITECTURES, false, false, true, null,
						getDefaultDescriptorCategory(object),
						new String[] { "org.eclipse.ui.views.properties.expert" }));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(TmscPackage.Literals.FULL_SCOPE_TMSC__MEASUREMENTS);
			childrenFeatures.add(TmscPackage.Literals.FULL_SCOPE_TMSC__LIFELINES);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns FullScopeTMSC.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/FullScopeTMSC"));
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

		switch (notification.getFeatureID(FullScopeTMSC.class)) {
		case TmscPackage.FULL_SCOPE_TMSC__DEPENDENCIES:
		case TmscPackage.FULL_SCOPE_TMSC__ARCHITECTURES:
		case TmscPackage.FULL_SCOPE_TMSC__EPOCH_TIME:
		case TmscPackage.FULL_SCOPE_TMSC__START_TIME:
		case TmscPackage.FULL_SCOPE_TMSC__END_TIME:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case TmscPackage.FULL_SCOPE_TMSC__MEASUREMENTS:
		case TmscPackage.FULL_SCOPE_TMSC__LIFELINES:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

}
