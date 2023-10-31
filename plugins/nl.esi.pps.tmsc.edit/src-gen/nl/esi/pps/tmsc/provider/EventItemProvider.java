/**
 */
package nl.esi.pps.tmsc.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.lsat.common.queries.QueryableIterable;
import org.eclipse.lsat.common.util.CollectionUtil;

import nl.esi.emf.properties.provider.PropertiesContainerItemProvider;
import nl.esi.pps.architecture.implemented.FunctionParameter;
import nl.esi.pps.tmsc.Event;
import nl.esi.pps.tmsc.EventType;
import nl.esi.pps.tmsc.LifelineSegment;
import nl.esi.pps.tmsc.TmscPackage;

/**
 * This is the item provider adapter for a {@link nl.esi.pps.tmsc.Event} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EventItemProvider extends PropertiesContainerItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Object getParent(Object object) {
		if (object instanceof Event) {
			Event event = (Event) object;
			if (event.getExecution() == null) {
				return event.getLifeline();
			} else {
				return event.getExecution();
			}
		}
		return super.getParent(object);
	}

	@Override
	public Collection<?> getChildren(Object object) {
		Collection<?> superChildren = super.getChildren(object);
		if (object instanceof Event) {
			final Event event = (Event) object;
			final ArrayList<Object> children = new ArrayList<>(event.getFullScopeIncomingDependencies().size()
					+ event.getFullScopeOutgoingDependencies().size() + superChildren.size());
			CollectionUtil.addAll(children, QueryableIterable.from(event.getFullScopeIncomingDependencies())
					.reject(LifelineSegment.class::isInstance));
			CollectionUtil.addAll(children, QueryableIterable.from(event.getFullScopeOutgoingDependencies())
					.reject(LifelineSegment.class::isInstance));
			children.addAll(superChildren);
			return children;
		}
		return superChildren;
	}

	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		List<IItemPropertyDescriptor> propertyDescriptors = super.getPropertyDescriptors(object);
		reloadArgumentsPropertyDescriptors(object);
		return propertyDescriptors;
	}

	/**
	 * Adds all {@link Event#getArguments()} map entries as
	 * {@link ItemPropertyDescriptor}s in an <tt>arguments</tt> category.
	 */
	protected void reloadArgumentsPropertyDescriptors(Object object) {
		// Remove existing properties descriptors (if any)
		itemPropertyDescriptors.removeIf(d -> d instanceof EventArgumentItemPropertyDescriptor);

		Event event = (Event) object;
		EMap<FunctionParameter, String> arguments = event.getArguments();
		for (int argumentIndex = 0; argumentIndex < arguments.size(); argumentIndex++) {
			// Add a descriptor for each argument
			itemPropertyDescriptors.add(new EventArgumentItemPropertyDescriptor(
					((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
					arguments.get(argumentIndex).getKey(), argumentIndex, EventType.valueOf(event)));
		}
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
		addScopesPropertyDescriptor(object);
		addComponentPropertyDescriptor(object);
		addFunctionPropertyDescriptor(object);
		addTimestampPropertyDescriptor(object);
		addTracedPropertyDescriptor(object);
	}

	/**
	 * This adds a property descriptor for the Timestamp feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTimestampPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Event_timestamp_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Event_timestamp_feature",
								"_UI_Event_type"),
						TmscPackage.Literals.EVENT__TIMESTAMP, false, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getDefaultDescriptorCategory(object), null,
						URI.createURI("editor://nl.esi.pps.tmsc.text.ETimestampFormat/")));
	}

	/**
	 * This adds a property descriptor for the Function feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFunctionPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Event_function_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Event_function_feature", "_UI_Event_type"),
						TmscPackage.Literals.EVENT__FUNCTION, false, false, true, null,
						getDefaultDescriptorCategory(object), null));
	}

	/**
	 * This adds a property descriptor for the Scopes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addScopesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_Event_scopes_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_Event_scopes_feature", "_UI_Event_type"),
				TmscPackage.Literals.EVENT__SCOPES, false, false, true, null, getDefaultDescriptorCategory(object),
				new String[] { "org.eclipse.ui.views.properties.expert" }));
	}

	/**
	 * This adds a property descriptor for the Component feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addComponentPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Event_component_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Event_component_feature",
								"_UI_Event_type"),
						TmscPackage.Literals.EVENT__COMPONENT, false, false, true, null,
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
						getResourceLocator(), getString("_UI_Event_traced_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Event_traced_feature", "_UI_Event_type"),
						TmscPackage.Literals.EVENT__TRACED, false, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, getDefaultDescriptorCategory(object), null));
	}

	/**
	 * This adds a property descriptor for the Lifeline feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLifelinePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_Event_lifeline_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_Event_lifeline_feature", "_UI_Event_type"),
				TmscPackage.Literals.EVENT__LIFELINE, false, false, true, null, getDefaultDescriptorCategory(object),
				new String[] { "org.eclipse.ui.views.properties.expert" }));
	}

	/**
	 * This returns Event.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Event"));
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
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		Long labelValue = ((Event) object).getTimestamp();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ? getString("_UI_Event_type")
				: getString("_UI_Event_type") + " " + label;
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

		switch (notification.getFeatureID(Event.class)) {
		case TmscPackage.EVENT__LIFELINE:
		case TmscPackage.EVENT__ARGUMENTS:
		case TmscPackage.EVENT__FULL_SCOPE_INCOMING_DEPENDENCIES:
		case TmscPackage.EVENT__FULL_SCOPE_OUTGOING_DEPENDENCIES:
		case TmscPackage.EVENT__COMPONENT:
		case TmscPackage.EVENT__FUNCTION:
		case TmscPackage.EVENT__TIMESTAMP:
		case TmscPackage.EVENT__TRACED:
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
