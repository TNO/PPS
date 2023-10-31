/**
 */
package nl.esi.pps.tmsc.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.LifelineSegment;
import nl.esi.pps.tmsc.TmscPackage;

/**
 * This is the item provider adapter for a {@link nl.esi.pps.tmsc.LifelineSegment} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class LifelineSegmentItemProvider extends DependencyItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LifelineSegmentItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Object getParent(Object object) {
		if (object instanceof LifelineSegment) {
			LifelineSegment lifelineSegment = (LifelineSegment) object;
			Execution activeExecution = lifelineSegment.getActiveExecution();
			if (activeExecution == null) {
				return lifelineSegment.getLifeline();
			} else {
				return activeExecution;
			}
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

		addLifelinePropertyDescriptor(object);
		addActiveExecutionPropertyDescriptor(object);
	}

	/**
	 * This adds a property descriptor for the Lifeline feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLifelinePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_LifelineSegment_lifeline_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_LifelineSegment_lifeline_feature",
								"_UI_LifelineSegment_type"),
						TmscPackage.Literals.LIFELINE_SEGMENT__LIFELINE, false, false, true, null,
						getDefaultDescriptorCategory(object), null));
	}

	/**
	 * This adds a property descriptor for the Active Execution feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addActiveExecutionPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_LifelineSegment_activeExecution_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_LifelineSegment_activeExecution_feature",
								"_UI_LifelineSegment_type"),
						TmscPackage.Literals.LIFELINE_SEGMENT__ACTIVE_EXECUTION, false, false, true, null,
						getDefaultDescriptorCategory(object), null));
	}

	/**
	 * This returns LifelineSegment.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		final LifelineSegment lifelineSegment = (LifelineSegment) object;
		final String active = lifelineSegment.getActiveExecution() == null ? "Idle" : "Active";
		return overlayImage(object, getResourceLocator().getImage("full/obj16/LifelineSegment" + active));
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
		super.notifyChanged(notification);
	}

}
