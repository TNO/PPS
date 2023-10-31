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
import nl.esi.pps.tmsc.Execution;
import nl.esi.pps.tmsc.LifelineSegment;
import nl.esi.pps.tmsc.TmscPackage;

/**
 * This is the item provider adapter for a {@link nl.esi.pps.tmsc.Execution} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ExecutionItemProvider extends PropertiesContainerItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Object getParent(Object object) {
		if (object instanceof Execution) {
			Execution execution = (Execution) object;
			if (execution.getParent() == null) {
				return execution.getLifeline();
			} else {
				return execution.getParent();
			}
		}
		return super.getParent(object);
	}

	@Override
	public Collection<?> getChildren(Object object) {
		Collection<?> superChildren = super.getChildren(object);
		if (object instanceof Execution) {
			final Execution execution = (Execution) object;
			final ArrayList<Object> children = new ArrayList<>(
					3 + execution.getChildren().size() * 2 + superChildren.size());
			if (execution.getEntry() != null) {
				children.add(execution.getEntry());
				CollectionUtil.addAll(children,
						QueryableIterable.from(execution.getEntry().getFullScopeOutgoingDependencies())
								.objectsOfType(LifelineSegment.class));
			}
			for (Execution child : execution.getChildren()) {
				children.add(child);
				if (child.getExit() != null) {
					CollectionUtil.addAll(children,
							QueryableIterable.from(child.getExit().getFullScopeOutgoingDependencies())
									.objectsOfType(LifelineSegment.class));

				}
			}
			if (execution.getExit() != null) {
				children.add(execution.getExit());
			}
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
		itemPropertyDescriptors.removeIf(d -> d instanceof ExecutionArgumentItemPropertyDescriptor);

		Execution execution = (Execution) object;
		EMap<FunctionParameter, String> entryArguments = execution.getEntry().getArguments();
		for (int argumentIndex = 0; argumentIndex < entryArguments.size(); argumentIndex++) {
			// Add a descriptor for each entry argument
			itemPropertyDescriptors.add(new ExecutionArgumentItemPropertyDescriptor(
					((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
					entryArguments.get(argumentIndex).getKey(), argumentIndex, EventType.ENTRY));
		}
		EMap<FunctionParameter, String> exitArguments = execution.getExit().getArguments();
		for (int argumentIndex = 0; argumentIndex < exitArguments.size(); argumentIndex++) {
			// Add a descriptor for each exit argument
			itemPropertyDescriptors.add(new ExecutionArgumentItemPropertyDescriptor(
					((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
					exitArguments.get(argumentIndex).getKey(), argumentIndex, EventType.EXIT));
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
		addParentPropertyDescriptor(object);
		addComponentPropertyDescriptor(object);
		addFunctionPropertyDescriptor(object);
		addStartTimePropertyDescriptor(object);
		addEndTimePropertyDescriptor(object);
		addDurationPropertyDescriptor(object);
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
						getResourceLocator(), getString("_UI_Execution_function_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Execution_function_feature",
								"_UI_Execution_type"),
						TmscPackage.Literals.EXECUTION__FUNCTION, false, false, false, null,
						getDefaultDescriptorCategory(object), null));
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
						getResourceLocator(), getString("_UI_Execution_lifeline_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Execution_lifeline_feature",
								"_UI_Execution_type"),
						TmscPackage.Literals.EXECUTION__LIFELINE, false, false, true, null,
						getDefaultDescriptorCategory(object),
						new String[] { "org.eclipse.ui.views.properties.expert" }));
	}

	/**
	 * This adds a property descriptor for the Parent feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addParentPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Execution_parent_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Execution_parent_feature",
								"_UI_Execution_type"),
						TmscPackage.Literals.EXECUTION__PARENT, false, false, false, null,
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
						getResourceLocator(), getString("_UI_Execution_startTime_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Execution_startTime_feature",
								"_UI_Execution_type"),
						TmscPackage.Literals.EXECUTION__START_TIME, false, false, false,
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
						getResourceLocator(), getString("_UI_Execution_endTime_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Execution_endTime_feature",
								"_UI_Execution_type"),
						TmscPackage.Literals.EXECUTION__END_TIME, false, false, false,
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
						getResourceLocator(), getString("_UI_Execution_duration_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Execution_duration_feature",
								"_UI_Execution_type"),
						TmscPackage.Literals.EXECUTION__DURATION, false, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getDefaultDescriptorCategory(object), null,
						URI.createURI("editor://nl.esi.pps.tmsc.text.EDurationFormat/")));
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
						getResourceLocator(), getString("_UI_Execution_component_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Execution_component_feature",
								"_UI_Execution_type"),
						TmscPackage.Literals.EXECUTION__COMPONENT, false, false, true, null,
						getDefaultDescriptorCategory(object), null));
	}

	/**
	 * This returns Execution.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Execution"));
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

		switch (notification.getFeatureID(Execution.class)) {
		case TmscPackage.EXECUTION__LIFELINE:
		case TmscPackage.EXECUTION__ENTRY:
		case TmscPackage.EXECUTION__CHILDREN:
		case TmscPackage.EXECUTION__EXIT:
		case TmscPackage.EXECUTION__PARENT:
		case TmscPackage.EXECUTION__START_TIME:
		case TmscPackage.EXECUTION__END_TIME:
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
