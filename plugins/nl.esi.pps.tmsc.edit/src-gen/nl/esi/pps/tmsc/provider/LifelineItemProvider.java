/**
 */
package nl.esi.pps.tmsc.provider;

import static org.eclipse.lsat.common.queries.QueryableIterable.from;

import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.lsat.common.util.CollectionUtil;

import nl.esi.emf.properties.provider.PropertiesContainerItemProvider;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.Lifeline;
import nl.esi.pps.tmsc.LifelineSegment;
import nl.esi.pps.tmsc.TmscPackage;

/**
 * This is the item provider adapter for a {@link nl.esi.pps.tmsc.Lifeline} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class LifelineItemProvider extends PropertiesContainerItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LifelineItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Collection<?> getChildren(Object object) {
		Collection<?> superChildren = super.getChildren(object);
		if (object instanceof Lifeline) {
			final Lifeline lifeline = (Lifeline) object;
			final ArrayList<Object> children;
			if (lifeline.getExecutions().isEmpty()) {
				children = new ArrayList<Object>(lifeline.getEvents().size() * 2 + superChildren.size());
				for (Event event : lifeline.getEvents()) {
					children.add(event);
					CollectionUtil.addAll(children,
							from(event.getFullScopeOutgoingDependencies()).objectsOfKind(LifelineSegment.class));
				}
			} else {
				EList<Execution> rootExecutions = lifeline.getRootExecutions();
				children = new ArrayList<Object>(rootExecutions.size() * 2 + superChildren.size());
				for (Execution execution : rootExecutions) {
					children.add(execution);
					if (execution.getExit() != null) {
						CollectionUtil.addAll(children, from(execution.getExit().getFullScopeOutgoingDependencies())
								.objectsOfKind(LifelineSegment.class));
					}
				}
			}
			children.addAll(superChildren);
			return children;
		}
		return superChildren;
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

		addExecutorPropertyDescriptor(object);
		addTracedPropertyDescriptor(object);
	}

	/**
	 * This adds a property descriptor for the Executor feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExecutorPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Lifeline_executor_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Lifeline_executor_feature",
								"_UI_Lifeline_type"),
						TmscPackage.Literals.LIFELINE__EXECUTOR, false, false, true, null,
						getDefaultDescriptorCategory(object), null));
	}

	/**
	 * This adds a property descriptor for the Traced feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTracedPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Lifeline_traced_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Lifeline_traced_feature",
								"_UI_Lifeline_type"),
						TmscPackage.Literals.LIFELINE__TRACED, false, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, getDefaultDescriptorCategory(object), null));
	}

	/**
	 * This returns Lifeline.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		final Lifeline lifeline = (Lifeline) object;
		final String traced = lifeline.isTraced() ? "Traced" : "Untraced";
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Lifeline" + traced));
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

		switch (notification.getFeatureID(Lifeline.class)) {
		case TmscPackage.LIFELINE__EVENTS:
		case TmscPackage.LIFELINE__EXECUTIONS:
		case TmscPackage.LIFELINE__EXECUTOR:
		case TmscPackage.LIFELINE__TRACED:
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
