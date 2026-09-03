/**
 */
package nl.esi.pps.architecture.example.provider;

import java.util.Collection;
import nl.esi.pps.architecture.example.ExampleFactory;
import nl.esi.pps.architecture.example.ExampleFunctionGroup;
import nl.esi.pps.architecture.example.ExamplePackage;

import nl.esi.pps.architecture.implemented.ImplementedFactory;

import nl.esi.pps.architecture.provider.NamedArchitectureElementItemProvider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link nl.esi.pps.architecture.example.ExampleFunctionGroup} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ExampleFunctionGroupItemProvider extends NamedArchitectureElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExampleFunctionGroupItemProvider(AdapterFactory adapterFactory) {
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

		addSubGroupsPropertyDescriptor(object);
		addParentGroupPropertyDescriptor(object);
	}

	/**
	 * This adds a property descriptor for the Sub Groups feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSubGroupsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ExampleFunctionGroup_subGroups_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_ExampleFunctionGroup_subGroups_feature",
						"_UI_ExampleFunctionGroup_type"),
				ExamplePackage.Literals.EXAMPLE_FUNCTION_GROUP__SUB_GROUPS, true, false, true, null,
				getDefaultDescriptorCategory(object), null));
	}

	/**
	 * This adds a property descriptor for the Parent Group feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addParentGroupPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ExampleFunctionGroup_parentGroup_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_ExampleFunctionGroup_parentGroup_feature",
						"_UI_ExampleFunctionGroup_type"),
				ExamplePackage.Literals.EXAMPLE_FUNCTION_GROUP__PARENT_GROUP, true, false, true, null,
				getDefaultDescriptorCategory(object), null));
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
			childrenFeatures.add(ExamplePackage.Literals.EXAMPLE_FUNCTION_GROUP__SUB_GROUPS);
			childrenFeatures.add(ExamplePackage.Literals.EXAMPLE_FUNCTION_GROUP__FUNCTIONS);
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
	 * This returns ExampleFunctionGroup.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ExampleFunctionGroup"));
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
		String label = ((ExampleFunctionGroup) object).getName();
		return label == null || label.length() == 0 ? null : label;
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

		switch (notification.getFeatureID(ExampleFunctionGroup.class)) {
		case ExamplePackage.EXAMPLE_FUNCTION_GROUP__SUB_GROUPS:
		case ExamplePackage.EXAMPLE_FUNCTION_GROUP__FUNCTIONS:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
			return;
		}
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

		newChildDescriptors.add(createChildParameter(ExamplePackage.Literals.EXAMPLE_FUNCTION_GROUP__SUB_GROUPS,
				ExampleFactory.eINSTANCE.createExampleFunctionGroup()));

		newChildDescriptors.add(createChildParameter(ExamplePackage.Literals.EXAMPLE_FUNCTION_GROUP__FUNCTIONS,
				ImplementedFactory.eINSTANCE.createFunction()));

		newChildDescriptors.add(createChildParameter(ExamplePackage.Literals.EXAMPLE_FUNCTION_GROUP__FUNCTIONS,
				ImplementedFactory.eINSTANCE.createIPCClientFunction()));

		newChildDescriptors.add(createChildParameter(ExamplePackage.Literals.EXAMPLE_FUNCTION_GROUP__FUNCTIONS,
				ImplementedFactory.eINSTANCE.createIPCServerFunction()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ExampleEditPlugin.INSTANCE;
	}

}
