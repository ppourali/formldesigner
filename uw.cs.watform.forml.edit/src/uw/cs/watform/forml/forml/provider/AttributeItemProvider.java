/**
 */
package uw.cs.watform.forml.forml.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import uw.cs.watform.forml.forml.Attribute;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.FormlPackage;

/**
 * This is the item provider adapter for a {@link uw.cs.watform.forml.forml.Attribute} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AttributeItemProvider extends ExprRefItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addCtrlPropertyDescriptor(object);
			addNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Ctrl feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCtrlPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Attribute_ctrl_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Attribute_ctrl_feature", "_UI_Attribute_type"),
				 FormlPackage.Literals.ATTRIBUTE__CTRL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Attribute_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Attribute_name_feature", "_UI_Attribute_type"),
				 FormlPackage.Literals.ATTRIBUTE__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
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
			childrenFeatures.add(FormlPackage.Literals.ATTRIBUTE__MULTIPLICITY);
			childrenFeatures.add(FormlPackage.Literals.ATTRIBUTE__TYPE);
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
	 * This returns Attribute.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Attribute"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Attribute)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Attribute_type") :
			getString("_UI_Attribute_type") + " " + label;
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

		switch (notification.getFeatureID(Attribute.class)) {
			case FormlPackage.ATTRIBUTE__CTRL:
			case FormlPackage.ATTRIBUTE__NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case FormlPackage.ATTRIBUTE__MULTIPLICITY:
			case FormlPackage.ATTRIBUTE__TYPE:
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

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ATTRIBUTE__MULTIPLICITY,
				 FormlFactory.eINSTANCE.createMultiplicity()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ATTRIBUTE__TYPE,
				 FormlFactory.eINSTANCE.createConcept()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ATTRIBUTE__TYPE,
				 FormlFactory.eINSTANCE.createRoleable()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ATTRIBUTE__TYPE,
				 FormlFactory.eINSTANCE.createRelationship()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ATTRIBUTE__TYPE,
				 FormlFactory.eINSTANCE.createAttributeType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ATTRIBUTE__TYPE,
				 FormlFactory.eINSTANCE.createStringType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ATTRIBUTE__TYPE,
				 FormlFactory.eINSTANCE.createIntType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ATTRIBUTE__TYPE,
				 FormlFactory.eINSTANCE.createBoolType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ATTRIBUTE__TYPE,
				 FormlFactory.eINSTANCE.createReferenceType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ATTRIBUTE__TYPE,
				 FormlFactory.eINSTANCE.createMessage()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ATTRIBUTE__TYPE,
				 FormlFactory.eINSTANCE.createEntity()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ATTRIBUTE__TYPE,
				 FormlFactory.eINSTANCE.createAssociation()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ATTRIBUTE__TYPE,
				 FormlFactory.eINSTANCE.createUndefinedType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ATTRIBUTE__TYPE,
				 FormlFactory.eINSTANCE.createAggregation()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ATTRIBUTE__TYPE,
				 FormlFactory.eINSTANCE.createComposition()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ATTRIBUTE__TYPE,
				 FormlFactory.eINSTANCE.createInput()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ATTRIBUTE__TYPE,
				 FormlFactory.eINSTANCE.createOutput()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ATTRIBUTE__TYPE,
				 FormlFactory.eINSTANCE.createFeature()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ATTRIBUTE__TYPE,
				 FormlFactory.eINSTANCE.createEnumeration()));
	}

}
