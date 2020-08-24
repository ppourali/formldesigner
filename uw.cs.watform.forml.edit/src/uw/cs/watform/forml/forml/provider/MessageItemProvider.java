/**
 */
package uw.cs.watform.forml.forml.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.FormlPackage;
import uw.cs.watform.forml.forml.Message;

/**
 * This is the item provider adapter for a {@link uw.cs.watform.forml.forml.Message} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MessageItemProvider extends ConceptItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageItemProvider(AdapterFactory adapterFactory) {
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

		}
		return itemPropertyDescriptors;
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
			childrenFeatures.add(FormlPackage.Literals.MESSAGE__TYPE);
			childrenFeatures.add(FormlPackage.Literals.MESSAGE__ATTRIBUTES);
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
	 * This returns Message.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Message"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Message)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Message_type") :
			getString("_UI_Message_type") + " " + label;
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

		switch (notification.getFeatureID(Message.class)) {
			case FormlPackage.MESSAGE__TYPE:
			case FormlPackage.MESSAGE__ATTRIBUTES:
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
				(FormlPackage.Literals.MESSAGE__TYPE,
				 FormlFactory.eINSTANCE.createConcept()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__TYPE,
				 FormlFactory.eINSTANCE.createRoleable()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__TYPE,
				 FormlFactory.eINSTANCE.createRelationship()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__TYPE,
				 FormlFactory.eINSTANCE.createAttributeType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__TYPE,
				 FormlFactory.eINSTANCE.createStringType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__TYPE,
				 FormlFactory.eINSTANCE.createIntType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__TYPE,
				 FormlFactory.eINSTANCE.createBoolType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__TYPE,
				 FormlFactory.eINSTANCE.createReferenceType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__TYPE,
				 FormlFactory.eINSTANCE.createMessage()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__TYPE,
				 FormlFactory.eINSTANCE.createEntity()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__TYPE,
				 FormlFactory.eINSTANCE.createAssociation()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__TYPE,
				 FormlFactory.eINSTANCE.createUndefinedType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__TYPE,
				 FormlFactory.eINSTANCE.createAggregation()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__TYPE,
				 FormlFactory.eINSTANCE.createComposition()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__TYPE,
				 FormlFactory.eINSTANCE.createInput()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__TYPE,
				 FormlFactory.eINSTANCE.createOutput()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__TYPE,
				 FormlFactory.eINSTANCE.createFeature()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__TYPE,
				 FormlFactory.eINSTANCE.createEnumeration()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createExprRef()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createConcept()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createRoleable()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createRelationship()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createMessage()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createEntity()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createAssociation()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createAttribute()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createFunction()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createUndefinedType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createAggregation()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createComposition()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createInput()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createOutput()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createFeature()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createSPL()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createXORNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createAndNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createOrNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createFeatureNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createEnumeration()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createEnumConst()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.MESSAGE__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createVariable()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == FormlPackage.Literals.MESSAGE__TYPE ||
			childFeature == FormlPackage.Literals.MESSAGE__ATTRIBUTES;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
