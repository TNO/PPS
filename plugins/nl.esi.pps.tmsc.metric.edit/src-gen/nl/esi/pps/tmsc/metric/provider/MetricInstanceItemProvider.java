/**
 */
package nl.esi.pps.tmsc.metric.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemColorProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import nl.esi.pps.tmsc.metric.MetricInstance;
import nl.esi.pps.tmsc.metric.MetricPackage;
import nl.esi.pps.tmsc.provider.IntervalItemProvider;

/**
 * This is the item provider adapter for a {@link nl.esi.pps.tmsc.metric.MetricInstance} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MetricInstanceItemProvider extends IntervalItemProvider implements IItemColorProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricInstanceItemProvider(AdapterFactory adapterFactory) {
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

		addIdPropertyDescriptor(object);
		addNamePropertyDescriptor(object);
		addExceedsBudgetPropertyDescriptor(object);
		addMetricPropertyDescriptor(object);
	}

	/**
	 * This adds a property descriptor for the Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_MetricInstance_id_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_MetricInstance_id_feature",
								"_UI_MetricInstance_type"),
						MetricPackage.Literals.METRIC_INSTANCE__ID, false, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getDefaultDescriptorCategory(object),
						new String[] { "org.eclipse.ui.views.properties.expert" }));
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_MetricInstance_name_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_MetricInstance_name_feature",
								"_UI_MetricInstance_type"),
						MetricPackage.Literals.METRIC_INSTANCE__NAME, false, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getDefaultDescriptorCategory(object), null));
	}

	/**
	 * This adds a property descriptor for the Exceeds Budget feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExceedsBudgetPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_MetricInstance_exceedsBudget_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_MetricInstance_exceedsBudget_feature",
						"_UI_MetricInstance_type"),
				MetricPackage.Literals.METRIC_INSTANCE__EXCEEDS_BUDGET, false, false, false,
				ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, getDefaultDescriptorCategory(object), null));
	}

	/**
	 * This adds a property descriptor for the Metric feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMetricPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_MetricInstance_metric_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_MetricInstance_metric_feature",
						"_UI_MetricInstance_type"),
				MetricPackage.Literals.METRIC_INSTANCE__METRIC, false, false, true, null,
				getDefaultDescriptorCategory(object), new String[] { "org.eclipse.ui.views.properties.expert" }));
	}

	/**
	 * This returns MetricInstance.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		boolean exceedsBudget = ((MetricInstance) object).isExceedsBudget();
		return overlayImage(object, getResourceLocator()
				.getImage("full/obj16/MetricInstance" + String.valueOf(exceedsBudget).toUpperCase()));
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
		String label = ((MetricInstance) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_MetricInstance_type") : label;
	}

	private static final URI COLOR_RED = URI.createURI("color://rgb/192/0/0");

	@Override
	public Object getForeground(Object object) {
		if (((MetricInstance) object).isExceedsBudget()) {
			return COLOR_RED;
		}
		return super.getForeground(object);
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

		switch (notification.getFeatureID(MetricInstance.class)) {
		case MetricPackage.METRIC_INSTANCE__ID:
		case MetricPackage.METRIC_INSTANCE__NAME:
		case MetricPackage.METRIC_INSTANCE__EXCEEDS_BUDGET:
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
		return MetricEditPlugin.INSTANCE;
	}
}
